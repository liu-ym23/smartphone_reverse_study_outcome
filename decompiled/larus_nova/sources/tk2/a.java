package tk2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f546477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f546478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f546479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ vk2.a f546480d;

    public a(int r100) {
        this.f546480d = new vk2.a("Freq");
        this.f546479c = r100;
    }

    @Override // tk2.b
    public final boolean a(String r100) {
        if (this.f546479c > 0) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r100.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 != null) goto L15;
        return true;
    L15:
        if ((!Intrinsics.areEqual(r100, this.f546477a)) == false) goto L18;
        return true;
    L18:
        if (this.f546478b < this.f546479c) goto L25;
        return false;
    L25:
        return true;
    L9:
        r101 = false;
        goto L10
    }

    @Override // tk2.b
    public final void b(String r100) {
        if (this.f546479c > 0) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 != null) goto L15;
        return;
    L15:
        if ((!Intrinsics.areEqual(r100, this.f546477a)) == false) goto L17;
        this.f546477a = r100;
        this.f546478b = 1;
    L18:
        String r102 = "card " + r100 + " show " + this.f546478b + " times.";
        vk2.a r103 = this.f546480d;
        r103.getClass();
        dm.a.b r104 = dm.a.f469202a;
        dm.a.a(r103.f555469a).i(r102);
        return;
    L17:
        this.f546478b++;
        goto L18
    L9:
        r101 = false;
        goto L10
    }
}
