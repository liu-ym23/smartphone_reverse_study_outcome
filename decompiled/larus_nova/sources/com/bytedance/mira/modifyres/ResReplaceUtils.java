package com.bytedance.mira.modifyres;

import android.text.TextUtils;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public class ResReplaceUtils {
    public ResReplaceUtils() {
    }

    public static byte[] intToByteArray(int r100) {
        return new byte[]{(byte) (r100 >> 0), (byte) (r100 >> 8), (byte) (r100 >> 16), (byte) (r100 >> 24)};
    }

    public static int getCount(ExtDataInput r100) {
        return (int) r100.mDelegate.getInputStream().getByteCount();
    }

    public static void modifyXml(byte[] r100, IResIdMapper r101) throws IOException {
        AXmlResourceParser r102 = new AXmlResourceParser(r100, r101);
        r102.setInput(new ByteArrayInputStream(r100));
    L4:
        if (r102.nextToken() != 1) goto L4;
    }

    public static void replaceResId(String r100, byte[] r101, IResIdMapper r102) throws Throwable {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r102.needModify(r100) == true) goto L9;
        return;
    L9:
        if (r100.equals(ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME) == false) goto L12;
        modifyXml(r101, r102);
        return;
    L12:
        if (r100.endsWith(".xml") == false) goto L16;
        if (r100.startsWith("res/") == false) goto L16;
    L17:
        modifyXml(r101, r102);
        return;
    L16:
        if (TextUtils.equals(r100, ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME) == true) goto L17;
        if (r100.equals("resources.arsc") == false) goto L24;
        new ARSCDecoder(r101, r102).readTableHeader();
        return;
    }

    public static int replaceResId(byte[] r100, int r101, int r102, IResIdMapper r103) {
        if (r101 < 2130706432) goto L6;
        int r104 = r103.mapId(r101);
        byte[] r105 = intToByteArray(r104);
        r100[r102] = r105[0];
        r100[r102 + 1] = r105[1];
        r100[r102 + 2] = r105[2];
        r100[r102 + 3] = r105[3];
        return r104;
    L6:
        return r101;
    }

    public static void reorderAttributeForNode(int r110, byte[] r111, int[] r112, int r113, HashMap<Integer, Integer> r114) {
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap();
        int r102 = 0;
        int r103 = -1;
    L3:
        if (r102 >= r113) goto L10;
        int r104 = r102 * 5;
        int r105 = r112[r104 + 1];
        if (r114.containsKey(Integer.valueOf(r105)) == false) goto L9;
        if (r103 != (-1)) goto L8;
        r103 = r102;
    L8:
        int r106 = (r104 * 4) + r110;
        r100.put(Integer.valueOf(r102), Arrays.copyOfRange(r111, r106, r106 + 20));
        r101.put(Integer.valueOf(r114.get(Integer.valueOf(r105)).intValue()), Integer.valueOf(r102));
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        ArrayList r115 = new ArrayList(r101.keySet());
        Collections.sort(r115);
        Iterator r116 = r115.iterator();
        int r117 = 0;
    L12:
        if (r116.hasNext() == false) goto L14;
        byte[] r118 = (byte[]) r100.get(Integer.valueOf(((Integer) r101.get((Integer) r116.next())).intValue()));
        int r107 = r117 + 1;
        System.arraycopy(r118, 0, r111, (((r117 + r103) * 5) * 4) + r110, r118.length);
        r117 = r107;
        goto L12
    }
}
