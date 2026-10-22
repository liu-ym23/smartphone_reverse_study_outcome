package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

/* JADX INFO: loaded from: classes36.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f430172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f430173b;

    public a0() {
        this(3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f430172a == r101.f430172a) goto L12;
        return false;
    L12:
        if (this.f430173b == r101.f430173b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f430172a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f430173b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImmersiveVoiceKeyboardMenuConfig(showEmoji=" + this.f430172a + ", showMention=" + this.f430173b + ')';
    }

    public a0(int r100) {
        boolean r101 = false;
        if ((r100 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r100 & 2) == 0) goto L9;
        r101 = true;
    L9:
        this.f430172a = r102;
        this.f430173b = r101;
        return;
    L5:
        r102 = false;
        goto L7
    }
}
