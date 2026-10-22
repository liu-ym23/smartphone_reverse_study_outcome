package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RTChorusDialogOperateView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getOrderedSongDataContext", "Lkotlin/Function0;", "", "dismissDialogAction", "setDismissAction", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusDialogOperateView extends LinearLayout {
    public final TextView a;
    public Function0<Unit> b;

    public RTChorusDialogOperateView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RTChorusDialogOperateView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final OrderedSongDataContext getOrderedSongDataContext() {
        return KtvModeOrderedSongDataContext.Companion.getContext();
    }

    public static final /* synthetic */ OrderedSongDataContext a(RTChorusDialogOperateView r0) {
        return r0.getOrderedSongDataContext();
    }

    public final void setDismissAction(Function0<Unit> r1) {
        this.b = r1;
    }

    public RTChorusDialogOperateView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.b = RTChorusDialogOperateView$dismissDialogAction$1.INSTANCE;
        LayoutInflater.from(r6).inflate(2131567403, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-2, s1.f(50.0f)));
        setOrientation(0);
        setGravity(17);
        ImageView r9 = (ImageView) findViewById(2131386004);
        TextView r10 = (TextView) findViewById(2131365707);
        this.a = r10;
        if (KtvSettingHelper.C() == true) goto L5;
    L10:
        if (r10 == null) goto L12;
        r10.setVisibility(8);
    L12:
        if (r9 == null) goto L15;
        r9.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AnonymousClass1(this)));
        return;
    L15:
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.Y.getValue()).booleanValue() == true) goto L10;
        if ((((long) ((Number) KtvSettingHelper.p1.getValue()).intValue()) * 1000) <= System.currentTimeMillis()) goto L10;
        if (r10 == null) goto L12;
        r10.setVisibility(0);
        goto L12
    }

    public /* synthetic */ RTChorusDialogOperateView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
