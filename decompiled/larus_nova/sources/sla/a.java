package sla;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f542506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f542508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f542509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f542510f;

    public final String toString() {
        String r100 = this.f542505a + ':';
        switch(this.f542506b) {
            case 900: goto L17;
            case 901: goto L15;
            case 902: goto L12;
            case 903: goto L11;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L5;
        };
    L12:
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        String r102 = "00000000" + Integer.toHexString(this.f542507c);
        r101.append("#" + r102.substring(r102.length() - 8));
        return r101.toString();
    L5:
        return r100 + "????";
    L7:
        return r100 + this.f542508d;
    L9:
        return r100 + Boolean.valueOf(this.f542510f);
    L11:
        return r100 + this.f542509e;
    L15:
        return r100 + this.f542508d;
    L17:
        return r100 + this.f542507c;
    }

    public int getType() {
        return this.f542506b;
    }

    public a(a r100) {
        this.f542507c = Integer.MIN_VALUE;
        this.f542508d = Float.NaN;
        this.f542509e = null;
        this.f542505a = r100.f542505a;
        this.f542506b = r100.f542506b;
        this.f542507c = r100.f542507c;
        this.f542508d = r100.f542508d;
        this.f542509e = r100.f542509e;
        this.f542510f = r100.f542510f;
    }
}
