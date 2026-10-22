package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t3;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final c e;

    private final Switch getSwitchButton() {
        return (Switch) this.c.getValue();
    }

    private final FrameLayout getSwitchButtonContainer() {
        return (FrameLayout) this.d.getValue();
    }

    private final TextView getSwitchContent() {
        return (TextView) this.a.getValue();
    }

    private final ImageView getSwitchRule() {
        return (ImageView) this.b.getValue();
    }

    public final void b() {
        c(getSwitchRule(), 0);
    }

    public static final /* synthetic */ Switch a(e r0) {
        return r0.getSwitchButton();
    }

    public e(c r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "kSongSwitchView");
        Intrinsics.checkNotNullParameter(r6, "context");
        CharSequence r0 = null;
        super(r6, null, 0);
        this.e = r5;
        this.a = LazyKt.lazy(new KSongSwitchView$switchContent$2(this));
        this.b = LazyKt.lazy(new KSongSwitchView$switchRule$2(this));
        this.c = LazyKt.lazy(new KSongSwitchView$switchButton$2(this));
        this.d = LazyKt.lazy(new KSongSwitchView$switchButtonContainer$2(this));
        LayoutInflater.from(r6).inflate(2131565567, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(52.0f)));
        Switch r7 = getSwitchButton();
        if (r7 == null) goto L5;
        r7.setChecked(r5.b());
    L5:
        FrameLayout r8 = getSwitchButtonContainer();
        if (r8 == null) goto L8;
        r8.setOnClickListener(x0.a(new KSongSwitchView$1(this)));
    L8:
        ImageView r9 = getSwitchRule();
        if (r9 == null) goto L11;
        r9.setOnClickListener(x0.a(new KSongSwitchView$2(this)));
    L11:
        TextView r10 = getSwitchContent();
        if (r10 == null) goto L14;
        r10.setClickable(true);
    L14:
        FrameLayout r11 = getSwitchButtonContainer();
        if (r11 == null) goto L17;
        r11.setClickable(true);
    L17:
        TextView r12 = getSwitchContent();
        if (r12 == null) goto L20;
        r12.setText(r5.a());
    L20:
        TextView r13 = getSwitchContent();
        TextView r14 = getSwitchContent();
        if (r14 == null) goto L23;
        r0 = r14.getText();
    L23:
        r3.a(r13, String.valueOf(r0));
    }

    public static void c(View r1, int r2) {
        if (r2 != 0) goto L4;
        if (r1 == null) goto L19;
        r1.setVisibility(0);
        return;
    L19:
        return;
    L4:
        if (r2 != 4) goto L6;
        if (r1 == null) goto L17;
        r1.setVisibility(4);
        return;
    L17:
        return;
    L6:
        if (r2 != 8) goto L20;
        if (r1 == null) goto L15;
        r1.setVisibility(8);
        return;
    L15:
        return;
    }

    public final void d(boolean r3, boolean r4) {
        Switch r0 = getSwitchButton();
        if (r0 != null) goto L5;
    L6:
        Switch r1 = getSwitchButton();
        if (r1 == null) goto L9;
        r1.setChecked(r3);
    L9:
        if (r4 == false) goto L15;
        int r5 = r3.a;
        FrameLayout r6 = getSwitchButtonContainer();
        if (r6 == null) goto L16;
        r6.postDelayed(new t3(r6), 100);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r0.isChecked() != r3) goto L6;
    }
}
