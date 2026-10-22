package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f430425e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f430421a == r101.f430421a) goto L12;
        return false;
    L12:
        if (this.f430422b == r101.f430422b) goto L15;
        return false;
    L15:
        if (this.f430423c == r101.f430423c) goto L18;
        return false;
    L18:
        if (this.f430424d == r101.f430424d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f430425e, r101.f430425e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f430421a * 31) + this.f430422b) * 31) + this.f430423c) * 31) + this.f430424d) * 31;
        String r101 = this.f430425e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ImmersiveVoiceButtonConfig(textRes=" + this.f430421a + ", pressedTextRes=" + this.f430422b + ", backgroundColorRes=" + this.f430423c + ", pressedBackgroundColorRes=" + this.f430424d + ", dynamicText=" + this.f430425e + ')';
    }

    public t(String r100) {
        this.f430421a = R.string.Lark_IM_AudioMsg_HoldToRecord_Button;
        this.f430422b = R.string.Lark_IM_AudioMsg_ReleaseToStop_Button;
        this.f430423c = R.color.bg_body;
        this.f430424d = R.color.fill_pressed;
        this.f430425e = r100;
    }
}
