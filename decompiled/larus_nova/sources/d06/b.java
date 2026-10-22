package d06;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static long a(byte[] r210) {
        int r100 = r210.length;
        long r101 = 104729;
        int r102 = r100 >> 3;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L6;
        int r110 = r103 + (r104 << 3);
        r101 = (Long.rotateLeft(r101 ^ (Long.rotateLeft(((((((((((long) r210[r110]) & 255) | ((((long) r210[r110 + 1]) & 255) << 8)) | ((((long) r210[r110 + 2]) & 255) << 16)) | ((((long) r210[r110 + 3]) & 255) << 24)) | ((((long) r210[r110 + 4]) & 255) << 32)) | ((((long) r210[r110 + 5]) & 255) << 40)) | ((((long) r210[r110 + 6]) & 255) << 48)) | ((((long) r210[r110 + 7]) & 255) << 56)) * (-8663945395140668459L), 31) * 5545529020109919103L), 27) * 5) + 1390208809;
        r104 = r104 + 1;
        r103 = 0;
        goto L4
    L6:
        int r105 = (r102 << 3) + 0;
        long r106 = 0;
        switch(((r100 + 0) - r105)) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L16;
        };
    L9:
        r106 = 0 ^ ((((long) r210[r105 + 6]) & 255) << 48);
    L10:
        r106 = r106 ^ ((((long) r210[r105 + 5]) & 255) << 40);
    L11:
        r106 = r106 ^ ((((long) r210[r105 + 4]) & 255) << 32);
    L12:
        r106 = r106 ^ ((((long) r210[r105 + 3]) & 255) << 24);
    L13:
        r106 = r106 ^ ((((long) r210[r105 + 2]) & 255) << 16);
    L14:
        r106 = r106 ^ ((((long) r210[r105 + 1]) & 255) << 8);
    L15:
        r101 = r101 ^ (Long.rotateLeft(((((long) r210[r105]) & 255) ^ r106) * (-8663945395140668459L), 31) * 5545529020109919103L);
    L16:
        long r107 = ((long) r100) ^ r101;
        long r108 = (r107 ^ (r107 >>> 33)) * (-49064778989728563L);
        long r109 = (r108 ^ (r108 >>> 33)) * (-4265267296055464877L);
        return r109 ^ (r109 >>> 33);
    }
}
