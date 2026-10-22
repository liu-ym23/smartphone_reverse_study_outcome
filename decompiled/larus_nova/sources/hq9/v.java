package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f486790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f486791g;

    public v() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f486785a, r101.f486785a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486786b, r101.f486786b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486787c, r101.f486787c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486788d, r101.f486788d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486789e, r101.f486789e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f486790f, r101.f486790f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f486791g, r101.f486791g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f486785a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f486786b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486787c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f486788d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f486789e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f486790f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f486791g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioTraceCommonParams(botId=" + this.f486785a + ", chatType=" + this.f486786b + ", conversationId=" + this.f486787c + ", localMsgId=" + this.f486788d + ", asrTaskId=" + this.f486789e + ", ttsTaskId=" + this.f486790f + ", scene=" + this.f486791g + ')';
    }

    public v(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f486785a = r100;
        this.f486786b = r101;
        this.f486787c = r102;
        this.f486788d = r103;
        this.f486789e = r104;
        this.f486790f = null;
        this.f486791g = r105;
    }
}
