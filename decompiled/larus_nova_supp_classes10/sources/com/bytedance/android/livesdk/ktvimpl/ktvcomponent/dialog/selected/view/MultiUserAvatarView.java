package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.ui.NoTouchRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/selected/view/MultiUserAvatarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiUserAvatarView extends FrameLayout {
    public final MultiUserAvatarAdapter a;
    public List<k> b;

    public static final class a {
    }

    static {
    }

    public MultiUserAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MultiUserAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(List<k> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "avatarImageMode");
        this.b = r3;
        MultiUserAvatarAdapter r0 = this.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "a");
        r0.b = r3;
    L5:
        MultiUserAvatarAdapter r5 = this.a;
        if (r5 == null) goto L8;
        r5.a = r4;
    L8:
        if (r5 == null) goto L11;
        r5.notifyDataSetChanged();
        return;
    }

    public MultiUserAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        new ArrayList();
        LayoutInflater.from(r2).inflate(2131567007, this);
        NoTouchRecyclerView r5 = findViewById(2131363729);
        if (r5 == null) goto L5;
        LinearLayoutManager r6 = new LinearLayoutManager(r2);
        r6.setOrientation(0);
        Unit r0 = Unit.INSTANCE;
        r5.setLayoutManager(r6);
    L5:
        if (r5 == null) goto L7;
        r5.setChildDrawingOrderCallback(new AnonymousClass2());
    L7:
        if (r5 == null) goto L9;
        r5.addItemDecoration(new AnonymousClass3());
    L9:
        MultiUserAvatarAdapter r7 = new MultiUserAvatarAdapter(r2);
        this.a = r7;
        r7.c = 4;
        if (r5 == null) goto L13;
        r5.setAdapter(r7);
        return;
    }

    public /* synthetic */ MultiUserAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
