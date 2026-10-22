package tk2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public String a;
    public int b;
    public final int c;
    public final /* synthetic */ vk2.a d;

    public a(int r3) {
        this.d = new vk2.a("Freq");
        this.c = r3;
    }

    @Override // tk2.b
    public final boolean a(String r7) {
        if (this.c > 0) goto L5;
        return true;
    L5:
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r7.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r7 = null;
    L13:
        if (r7 != null) goto L15;
        return true;
    L15:
        if ((!Intrinsics.areEqual(r7, this.a)) == false) goto L18;
        return true;
    L18:
        if (this.b < this.c) goto L25;
        return false;
    L25:
        return true;
    L9:
        r0 = false;
        goto L10
    }

    @Override // tk2.b
    public final void b(String r6) {
        if (this.c > 0) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r6 = null;
    L13:
        if (r6 != null) goto L15;
        return;
    L15:
        if ((!Intrinsics.areEqual(r6, this.a)) == false) goto L17;
        this.a = r6;
        this.b = 1;
    L18:
        String r7 = "card " + r6 + " show " + this.b + " times.";
        vk2.a r1 = this.d;
        r1.getClass();
        dm.a.b r2 = dm.a.a;
        dm.a.a(r1.a).i(r7);
        return;
    L17:
        this.b++;
        goto L18
    L9:
        r0 = false;
        goto L10
    }
}
