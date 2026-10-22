package y48;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f566078e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f566081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f566082d;

    public static final class a {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f566079a == r101.f566079a) goto L12;
        return false;
    L12:
        if (this.f566080b == r101.f566080b) goto L15;
        return false;
    L15:
        if (this.f566081c == r101.f566081c) goto L18;
        return false;
    L18:
        if (this.f566082d == r101.f566082d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f566079a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f566080b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f566081c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f566082d == true) goto L19;
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
        return "ChatSpeakerBehavior(alterSendTextOrVoice=" + this.f566079a + ", enableBlurMode=" + this.f566080b + ", enableShowAudioAnimation=" + this.f566081c + ", resetStatusOnVisible=" + this.f566082d + ')';
    }

    static {
        f566078e = new d(0);
    }

    public /* synthetic */ d(int r100) {
        this(false, true, true, false);
    }

    public d(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f566079a = r100;
        this.f566080b = r101;
        this.f566081c = r102;
        this.f566082d = r103;
    }

    public static d a(d r100, boolean r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f566079a;
    L6:
        if ((r104 & 2) == 0) goto L8;
        boolean r105 = r100.f566080b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f566081c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f566082d;
    L15:
        r100.getClass();
        return new d(r101, r105, r102, r103);
    L8:
        r105 = false;
        goto L10
    }
}
