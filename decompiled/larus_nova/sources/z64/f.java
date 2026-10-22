package z64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f570467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f570468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f570469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f570470f;

    /* JADX INFO: loaded from: classes47.dex */
    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        String r100 = this.f570465a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f570466b) * 31;
        String r104 = this.f570467c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f570468d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f570469e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f570470f;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LoginBadgerRequest(challengeKey=" + this.f570465a + ", sceneId=" + this.f570466b + ", deviceId=" + this.f570467c + ", timestamp=" + this.f570468d + ", triggerPath=" + this.f570469e + ", triggerLogid=" + this.f570470f + ")";
    }

    @Override // z64.c
    public final String a() {
        return this.f570469e;
    }

    @Override // z64.c
    public final String b() {
        return this.f570465a;
    }

    @Override // z64.c
    public final String getDeviceId() {
        return this.f570467c;
    }

    @Override // z64.c
    public final int getSceneId() {
        return this.f570466b;
    }

    @Override // z64.c
    public final long getTimestamp() {
        return this.f570468d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L25;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f570465a, r101.f570465a) == false) goto L25;
        if (this.f570466b != r101.f570466b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L25;
        if (Intrinsics.areEqual(this.f570467c, r101.f570467c) == false) goto L25;
        if (this.f570468d != r101.f570468d) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L25;
        if (Intrinsics.areEqual(this.f570469e, r101.f570469e) == false) goto L25;
        if (Intrinsics.areEqual(this.f570470f, r101.f570470f) == false) goto L25;
    L18:
        r103 = false;
        goto L19
    L11:
        r102 = false;
    L25:
        return false;
    }

    public /* synthetic */ f(String r110, String r111, long r112, String r113, int r114) {
        String r100 = "";
        if ((r114 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r114 & 16) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r114 & 32) != 0) goto L22;
        r100 = null;
    L22:
        this(r101, r102, r103, r112, r104, r100);
        return;
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = 17;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public f(String r100, int r101, String r102, long r103, String r104, String r105) {
        this.f570465a = r100;
        this.f570466b = r101;
        this.f570467c = r102;
        this.f570468d = r103;
        this.f570469e = r104;
        this.f570470f = r105;
    }
}
