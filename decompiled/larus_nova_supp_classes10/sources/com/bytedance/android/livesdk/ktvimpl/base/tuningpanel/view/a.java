package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends FrameLayout {
    public final Lazy a;
    public final FrameLayout b;
    public final Switch c;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a d;

    private final ec0.a getTuningMusicControl() {
        return (ec0.a) this.a.getValue();
    }

    public static final /* synthetic */ ec0.a a(a r0) {
        return r0.getTuningMusicControl();
    }

    public a(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6, Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        boolean r1 = false;
        super(r7, null, 0);
        this.d = r6;
        this.a = LazyKt.lazy(CellularEnhancementView$tuningMusicControl$2.INSTANCE);
        View r8 = LayoutInflater.from(r7).inflate(2131566473, this, true);
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView r0 = (TextView) r8.findViewById(2131364755);
        FrameLayout r3 = (FrameLayout) r8.findViewById(2131364754);
        this.b = r3;
        Switch r9 = (Switch) r8.findViewById(2131364753);
        this.c = r9;
        if (r0 == null) goto L5;
        r0.setText(s1.B(2131918227));
    L5:
        if (r9 == null) goto L11;
        if (r6 != null) goto L8;
    L10:
        r9.setChecked(r1);
        goto L11
    L8:
        if (r6.p() != true) goto L10;
        r1 = true;
    L11:
        if (r3 == null) goto L14;
        r3.setOnClickListener(x0.a(new CellularEnhancementView$1(this)));
        return;
    }
}
