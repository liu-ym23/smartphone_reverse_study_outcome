package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TopPauseStartFunctionItem {
    public ImageView a;
    public final LifecycleOwner b;
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c c;
    public final a d;
    public final String e;

    public final void a() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.c;
        KtvRoomLyricsStateMachineConfig.d r1 = null;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.getCurState();
    L6:
        boolean r3 = r2 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = this.c;
        if (r4 == null) goto L9;
        r1 = r4.getCurState();
    L9:
        boolean r5 = r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        if (r3 == true) goto L21;
        if (r5 == true) goto L21;
        ImageView r6 = this.a;
        if (r6 == null) goto L15;
        r6.setAlpha(0.5f);
    L15:
        ImageView r7 = this.a;
        if (r7 == null) goto L18;
        r7.setEnabled(false);
    L18:
        ImageView r8 = this.a;
        if (r8 == null) goto L44;
        r8.setTag(Boolean.FALSE);
        return;
    L44:
        return;
    L21:
        ImageView r9 = this.a;
        if (r9 == null) goto L24;
        r9.setAlpha(1.0f);
    L24:
        ImageView r10 = this.a;
        if (r10 == null) goto L27;
        r10.setEnabled(true);
    L27:
        ImageView r11 = this.a;
        if (r11 == null) goto L30;
        r11.setTag(Boolean.TRUE);
    L30:
        ImageView r12 = this.a;
        if (r12 == null) goto L33;
        UtilityKotlinExtentionsKt.f(r12);
    L33:
        if (r5 == false) goto L37;
        ImageView r13 = this.a;
        if (r13 == null) goto L40;
        r13.setBackgroundResource(this.d.b);
    L40:
        ImageView r14 = this.a;
        if (r14 == null) goto L46;
        r14.setOnClickListener(x0.a(new TopPauseStartFunctionItem$handleStateChanged$1(this)));
        return;
    L46:
        return;
    L37:
        ImageView r15 = this.a;
        if (r15 == null) goto L40;
        r15.setBackgroundResource(this.d.a);
        goto L40
    L5:
        r2 = null;
        goto L6
    }

    public TopPauseStartFunctionItem(LifecycleOwner r2, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3, a r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "iconRes");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
