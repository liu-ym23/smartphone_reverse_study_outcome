package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", "a", "Lkotlin/Lazy;", "getKtvCommonStackAvatarAdapter", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonStackAvatarAdapter;", "ktvCommonStackAvatarAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonStackAvatarView extends RecyclerView {
    public final Lazy a;

    public static final class a implements RecyclerView.ChildDrawingOrderCallback {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final int onGetChildDrawingOrder(int r1, int r2) {
            if (r1 > 0) goto L4;
            return r2;
        L4:
            return (r1 - r2) - 1;
        }
    }

    public KtvCommonStackAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvCommonStackAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final KtvCommonStackAvatarAdapter getKtvCommonStackAvatarAdapter() {
        return (KtvCommonStackAvatarAdapter) this.a.getValue();
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public KtvCommonStackAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(KtvCommonStackAvatarView$ktvCommonStackAvatarAdapter$2.INSTANCE);
        setLayoutManager(new SSLinearLayoutManager(r2, 0));
        setAdapter(getKtvCommonStackAvatarAdapter());
        setChildDrawingOrderCallback(a.a);
    }

    public /* synthetic */ KtvCommonStackAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void r(List<? extends py.k> r5, String r6, int r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "totalCountStr");
        Intrinsics.checkNotNullParameter(r9, "scene");
        KtvCommonStackAvatarAdapter r3 = getKtvCommonStackAvatarAdapter();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "totalCountStr");
        Intrinsics.checkNotNullParameter(r9, "scene");
        ((ArrayList) r3.c).clear();
        List<py.k> r0 = r3.c;
        ArrayList r1 = (ArrayList) r0;
        r1.addAll(CollectionsKt.take(r5, r8));
        r3.d = r7;
        r3.e = r6;
        r3.f = r8;
        r3.a = r9;
        r3.notifyDataSetChanged();
    }
}
