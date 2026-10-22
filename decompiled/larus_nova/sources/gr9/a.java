package gr9;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f482394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f482395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f482396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f482397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f482398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f482399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f482400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f482401h;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f482394a == r101.f482394a) goto L12;
        return false;
    L12:
        if (this.f482395b == r101.f482395b) goto L15;
        return false;
    L15:
        if (this.f482396c == r101.f482396c) goto L18;
        return false;
    L18:
        if (this.f482397d == r101.f482397d) goto L21;
        return false;
    L21:
        if (this.f482398e == r101.f482398e) goto L24;
        return false;
    L24:
        if (this.f482399f == r101.f482399f) goto L27;
        return false;
    L27:
        if (this.f482400g == r101.f482400g) goto L30;
        return false;
    L30:
        if (this.f482401h == r101.f482401h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f482394a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f482395b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f482396c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f482397d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f482398e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f482399f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f482400g == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.f482401h == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
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
        return "ChatListSearchConfig(chatListSearchIsOn=" + this.f482394a + ", chatListSearchIsDefaultHidden=" + this.f482395b + ", useFts=" + this.f482396c + ", chatListBotSearchIsOn=" + this.f482397d + ", chatListIconSearchIsOn=" + this.f482398e + ", chatListSearchBotsAndMessage=" + this.f482399f + ", chatListSearchShowRecommendBots=" + this.f482400g + ", chatListSearchShowMessageFirst=" + this.f482401h + ')';
    }

    public /* synthetic */ a(int r110) {
        this(false, false, true, false, false, false, false, false);
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.f482394a = r100;
        this.f482395b = r101;
        this.f482396c = r102;
        this.f482397d = r103;
        this.f482398e = r104;
        this.f482399f = r105;
        this.f482400g = r106;
        this.f482401h = r107;
    }
}
