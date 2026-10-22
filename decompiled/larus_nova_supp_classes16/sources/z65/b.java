package z65;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public int a;
    public final String b;
    public long c;
    public long d;
    public int e;
    public final String f;
    public final String g;
    public int h;
    public int i;
    public boolean j;
    public String k;

    public final int hashCode() {
        String r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 + r0.hashCode();
    L5:
        String r2 = this.g;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return (r1 * 31) + r2.hashCode();
    }

    public final String toString() {
        return "UploadFileInformation{imageUrl='null', imageId= " + this.a + ", name='" + this.b + "', bytesTransferred='" + this.c + "', bytesTotal='" + this.d + "', status= " + this.e + ", subType= " + this.f + ", itemKey='" + this.g + "', progress= " + this.h + ", lastStatus= " + this.i + ", showSwipeMenu= " + this.j + ", errorCode= " + this.k + '}';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (TextUtils.equals(this.f, r6.f) == true) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(this.g, r6.g) == false) goto L13;
        return true;
    }

    public b(String r1, long r2, long r4, int r6, String r7, String r8, String r9) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.k = r9;
    }
}
