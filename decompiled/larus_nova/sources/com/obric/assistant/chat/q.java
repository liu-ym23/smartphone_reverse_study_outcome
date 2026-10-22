package com.obric.assistant.chat;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f386975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f386976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f386977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f386978d;

    public q() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f386975a == r101.f386975a) goto L12;
        return false;
    L12:
        if (this.f386976b == r101.f386976b) goto L15;
        return false;
    L15:
        if (this.f386977c == r101.f386977c) goto L18;
        return false;
    L18:
        if (this.f386978d == r101.f386978d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f386975a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f386976b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f386977c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f386978d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricChatPageStateSnapshot(isInChatPage=" + this.f386975a + ", isMainConversation=" + this.f386976b + ", isChatWindow=" + this.f386977c + ", isFullScreen=" + this.f386978d + ')';
    }

    public q(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f386975a = r100;
        this.f386976b = r101;
        this.f386977c = r102;
        this.f386978d = r103;
    }
}
