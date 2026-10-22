package e2c;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f470885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f470886b;

    public final boolean b() {
        if (this.f470886b[0] != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder((this.f470886b.length - 1) * 8);
        int r101 = this.f470886b.length;
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L30;
        int[] r102 = this.f470886b;
        int r103 = r102[(r102.length - 1) - r101];
        if (r103 == 0) goto L3;
        if (r103 >= 0) goto L10;
        r100.append(" - ");
        r103 = -r103;
    L13:
        if (r101 == 0) goto L15;
        if (r103 != 1) goto L15;
    L23:
        if (r101 == 0) goto L3;
        if (r101 == 1) goto L25;
        r100.append("x^");
        r100.append(r101);
        goto L3
    L25:
        r100.append(Permission.EXECUTE);
    L15:
        a r104 = this.f470885a;
        if (r103 == 0) goto L27;
        int r105 = r104.f470880b[r103];
        if (r105 != 0) goto L20;
        r100.append('1');
        goto L23
    L20:
        if (r105 != 1) goto L22;
        r100.append('a');
        goto L23
    L22:
        r100.append("a^");
        r100.append(r105);
        goto L23
    L27:
        r104.getClass();
        throw new IllegalArgumentException();
    L10:
        if (r100.length() <= 0) goto L13;
        r100.append(" + ");
        goto L13
    L30:
        return r100.toString();
    }

    public final b a(b r100) {
        if (this.f470885a.equals(r100.f470885a) == false) goto L21;
        if (b() == false) goto L8;
        return r100;
    L8:
        if (r100.b() == false) goto L10;
        return this;
    L10:
        int[] r101 = this.f470886b;
        int[] r102 = r100.f470886b;
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
        return new b(this.f470885a, r103);
    L21:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public b(a r100, int[] r101) {
        if (r101.length == 0) goto L19;
        this.f470885a = r100;
        int r102 = r101.length;
        if (r102 > 1) goto L7;
    L16:
        this.f470886b = r101;
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
        this.f470886b = new int[]{0};
        return;
    L15:
        int r104 = r102 - r103;
        int[] r105 = new int[r104];
        this.f470886b = r105;
        System.arraycopy(r101, r103, r105, 0, r104);
        return;
    L19:
        throw new IllegalArgumentException();
    }

    public final b c(int r100, int r101) {
        if (r100 < 0) goto L12;
        if (r101 == 0) goto L5;
        int r102 = this.f470886b.length;
        int[] r103 = new int[r100 + r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L10;
        r103[r104] = this.f470885a.a(this.f470886b[r104], r101);
        r104 = r104 + 1;
        goto L7
    L10:
        return new b(this.f470885a, r103);
    L5:
        return this.f470885a.f470881c;
    L12:
        throw new IllegalArgumentException();
    }
}
