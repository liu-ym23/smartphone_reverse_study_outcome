package dgc;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Float> f468551a;

    public a(ArrayList r100) {
        this.f468551a = r100;
    }

    public static a b(String r110) {
        int r100 = r110.length();
        ArrayList r101 = new ArrayList();
        int r102 = 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r102 >= r100) goto L22;
        if (r104 == false) goto L6;
        r104 = false;
    L21:
        r102 = r102 + 1;
        goto L3
    L6:
        char r105 = r110.charAt(r102);
        switch(r105) {
            case 9: goto L14;
            case 10: goto L14;
            case 32: goto L14;
            case 41: goto L9;
            case 44: goto L14;
            case 65: goto L9;
            case 67: goto L9;
            case 72: goto L9;
            case 76: goto L9;
            case 77: goto L9;
            case 81: goto L9;
            case 83: goto L9;
            case 84: goto L9;
            case 86: goto L9;
            case 90: goto L9;
            case 97: goto L9;
            case 99: goto L9;
            case 104: goto L9;
            case 108: goto L9;
            case 109: goto L9;
            case 113: goto L9;
            case 115: goto L9;
            case 116: goto L9;
            case 118: goto L9;
            case 122: goto L9;
            default: goto L21;
        };
    L14:
        String r106 = r110.substring(r103, r102);
        if (r106.trim().length() <= 0) goto L20;
        r101.add(Float.valueOf(CastFloatProtector.parseFloat(r106)));
        if (r105 != '-') goto L19;
        r103 = r102;
        goto L21
    L19:
        r103 = r102 + 1;
        r104 = true;
        goto L21
    L20:
        r103 = r103 + 1;
        goto L21
    L9:
        String r111 = r110.substring(r103, r102);
        if (r111.trim().length() <= 0) goto L13;
        r101.add(Float.valueOf(CastFloatProtector.parseFloat(r111)));
    L13:
        return new a(r101);
    L22:
        String r112 = r110.substring(r103);
        if (r112.length() <= 0) goto L26;
        r101.add(Float.valueOf(CastFloatProtector.parseFloat(r112)));     // Catch: NumberFormatException -> L27
    L26:
        return new a(r101);
    }

    public static final a a(String r100, XmlPullParser r101) {
        int r102 = r101.getAttributeCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.getAttributeName(r103).equals(r100) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return b(r101.getAttributeValue(r103));
    L9:
        return null;
    }
}
