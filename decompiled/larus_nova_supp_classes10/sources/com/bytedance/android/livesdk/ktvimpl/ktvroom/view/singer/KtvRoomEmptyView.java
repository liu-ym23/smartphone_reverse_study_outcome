package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomEmptyView;", "Landroid/widget/FrameLayout;", "", "visibility", "", "setVisibility", "", "b", "Z", "getEnableRecordState", "()Z", "setEnableRecordState", "(Z)V", "enableRecordState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomEmptyView extends FrameLayout {
    public Map<Integer, View> a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public KtvRoomEmptyView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomEmptyView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getEnableRecordState() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setEnableRecordState(boolean r1) {
        this.b = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        StringBuilder r0 = new StringBuilder("visibility == ");
        if (r3 != 8) goto L5;
        boolean r4 = true;
    L6:
        r0.append(r4);
        ALogger.e("KtvRoomEmptyView", r0.toString());
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        Function1<p, Unit> r4 = new AnonymousClass1(this, r3);
        Intrinsics.checkNotNullParameter(r4, "cb");
        if (this.b == false) goto L6;
        p.g.getClass();
        p.a.a(r4);
        return;
    }

    public KtvRoomEmptyView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        View.inflate(r2, 2131567729, this);
    }

    public /* synthetic */ KtvRoomEmptyView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
