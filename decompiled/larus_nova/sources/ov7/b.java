package ov7;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f526933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f526934b;

    public final boolean c() {
        if (this.f526934b[0] != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        if (c() == false) goto L6;
        return "0";
    L6:
        StringBuilder r100 = new StringBuilder((this.f526934b.length - 1) * 8);
        int r101 = this.f526934b.length;
    L7:
        r101 = r101 - 1;
        if (r101 < 0) goto L38;
        int r102 = b(r101);
        if (r102 == 0) goto L7;
        if (r102 >= 0) goto L18;
        if (r101 != (this.f526934b.length - 1)) goto L15;
        r100.append("-");
    L16:
        r102 = -r102;
    L21:
        if (r101 == 0) goto L23;
        if (r102 != 1) goto L23;
    L31:
        if (r101 == 0) goto L7;
        if (r101 == 1) goto L33;
        r100.append("x^");
        r100.append(r101);
        goto L7
    L33:
        r100.append(Permission.EXECUTE);
    L23:
        a r103 = this.f526933a;
        if (r102 == 0) goto L35;
        int r104 = r103.f526928b[r102];
        if (r104 != 0) goto L28;
        r100.append('1');
        goto L31
    L28:
        if (r104 != 1) goto L30;
        r100.append('a');
        goto L31
    L30:
        r100.append("a^");
        r100.append(r104);
        goto L31
    L35:
        r103.getClass();
        throw new IllegalArgumentException();
    L15:
        r100.append(" - ");
        goto L16
    L18:
        if (r100.length() <= 0) goto L21;
        r100.append(" + ");
        goto L21
    L38:
        return r100.toString();
    }

    public final b a(b r100) {
        if (this.f526933a.equals(r100.f526933a) == false) goto L21;
        if (c() == false) goto L8;
        return r100;
    L8:
        if (r100.c() == false) goto L10;
        return this;
    L10:
        int[] r101 = this.f526934b;
        int[] r102 = r100.f526934b;
        if (r101.length > r102.length) goto L14;
        r101 = r102;
        r102 = r101;
    L14:
        int[] r103 = new int[r101.length];
        int r104 = r101.length - r102.length;
        System.arraycopy(r101, 0, r103, 0, r104);
        int r105 = r104;
    L16:
        if (r105 >= r101.length) goto L19;
        r103[r105] = r102[r105 - r104] ^ r101[r105];
        r105 = r105 + 1;
        goto L16
    L19:
        return new b(this.f526933a, r103);
    L21:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public final int b(int r100) {
        int[] r101 = this.f526934b;
        return r101[(r101.length - 1) - r100];
    }

    public final b d(b r110) {
        if (this.f526933a.equals(r110.f526933a) == false) goto L20;
        if (c() == true) goto L18;
        if (r110.c() == true) goto L18;
        int[] r100 = this.f526934b;
        int r101 = r100.length;
        int[] r111 = r110.f526934b;
        int r102 = r111.length;
        int[] r103 = new int[(r101 + r102) - 1];
        int r104 = 0;
    L10:
        if (r104 >= r101) goto L16;
        int r105 = r100[r104];
        int r106 = 0;
    L12:
        if (r106 >= r102) goto L14;
        int r107 = r104 + r106;
        r103[r107] = r103[r107] ^ this.f526933a.c(r105, r111[r106]);
        r106 = r106 + 1;
        goto L12
    L14:
        r104 = r104 + 1;
        goto L10
    L16:
        return new b(this.f526933a, r103);
    L18:
        return this.f526933a.f526929c;
    L20:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public b(a r100, int[] r101) {
        if (r101.length == 0) goto L19;
        this.f526933a = r100;
        int r102 = r101.length;
        if (r102 > 1) goto L7;
    L16:
        this.f526934b = r101;
        return;
    L7:
        if (r101[0] != 0) goto L16;
        int r103 = 1;
    L9:
        if (r103 >= r102) goto L13;
        if (r101[r103] != 0) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 != r102) goto L15;
        this.f526934b = new int[]{0};
        return;
    L15:
        int r104 = r102 - r103;
        int[] r105 = new int[r104];
        this.f526934b = r105;
        System.arraycopy(r101, r103, r105, 0, r104);
        return;
    L19:
        throw new IllegalArgumentException();
    }

    public final b e(int r100, int r101) {
        if (r100 < 0) goto L12;
        if (r101 == 0) goto L5;
        int r102 = this.f526934b.length;
        int[] r103 = new int[r100 + r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L10;
        r103[r104] = this.f526933a.c(this.f526934b[r104], r101);
        r104 = r104 + 1;
        goto L7
    L10:
        return new b(this.f526933a, r103);
    L5:
        return this.f526933a.f526929c;
    L12:
        throw new IllegalArgumentException();
    }
}
