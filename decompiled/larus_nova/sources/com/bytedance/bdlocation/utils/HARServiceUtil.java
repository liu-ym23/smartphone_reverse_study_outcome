package com.bytedance.bdlocation.utils;

import bua.a;
import bua.b;
import bua.c;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class HARServiceUtil {
    public HARServiceUtil() {
    }

    public static List<HARStatus> getHARStatusList() {
        ArrayList r100 = new ArrayList();
        b r101 = b.C0362b.f20755a;
        int r102 = BDLocationConfig.getHARStatusRange();
        List r103 = r101.a(r102);
        if (r103 != null) goto L5;
    L9:
        ArrayList r104 = null;
    L10:
        int r105 = a.f20751a;
        if (r104 != null) goto L13;
    L18:
        return r100;
    L13:
        if (r104.size() <= 0) goto L18;
        Iterator r106 = r104.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        c r107 = (c) r106.next();
        HARStatus r108 = new HARStatus();
        r107.getClass();
        r108.predict = null;
        r108.timestamp = 0;
        r100.add(r108);
        goto L16
    L5:
        if (r103.isEmpty() == true) goto L9;
        r104 = new ArrayList();
        int r109 = Math.min(r103.size(), r102);
        int r110 = 0;
    L7:
        if (r110 >= r109) goto L10;
        r104.add(ListProtector.get(r103, r110));
        r110 = r110 + 1;
        goto L7
    }

    public static int getMaxHARStatus() {
        List r100 = b.C0362b.f20755a.a(BDLocationConfig.getHARStatusRange());
        int r101 = 0;
        if (r100 != null) goto L5;
    L60:
        int r102 = a.f20751a;
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L60;
        HashMap r103 = new HashMap();
        int r104 = r100.size();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L10;
        ((c) ListProtector.get(r100, r105)).getClass();
        r105 = r105 + 1;
        goto L7
    L10:
        if (r103.isEmpty() == true) goto L22;
        Iterator r106 = r103.entrySet().iterator();
        Map.Entry r107 = null;
    L13:
        if (r106.hasNext() == false) goto L20;
        Map.Entry r108 = (Map.Entry) r106.next();
        if (r108 == null) goto L13;
        if (r107 == null) goto L19;
        if (((Float) r107.getValue()).floatValue() >= ((Float) r108.getValue()).floatValue()) goto L13;
    L19:
        r107 = r108;
        goto L13
    L20:
        if (r107 == null) goto L22;
        String r109 = (String) r107.getKey();
    L23:
        r109.getClass();
        int r110 = r109.hashCode();
        if (r110 == 1444) goto L46;
        if (r110 == 1445) goto L42;
        switch(r110) {
            case 49: goto L38;
            case 50: goto L34;
            case 51: goto L30;
            default: goto L47;
        };
    L47:
        byte r111 = -1;
    L49:
        if (r111 == 0) goto L59;
        if (r111 == 1) goto L58;
        if (r111 == 2) goto L57;
        if (r111 == 3) goto L56;
        if (r111 != 4) goto L60;
        r101 = -2;
        goto L60
    L56:
        r101 = -1;
        goto L60
    L57:
        r101 = 3;
        goto L60
    L58:
        r101 = 2;
        goto L60
    L59:
        r101 = 1;
        goto L60
    L30:
        if (r109.equals("3") == false) goto L47;
        r111 = 2;
        goto L49
    L34:
        if (r109.equals("2") == false) goto L47;
        r111 = 1;
        goto L49
    L38:
        if (r109.equals("1") == false) goto L47;
        r111 = 0;
        goto L49
    L42:
        if (r109.equals("-2") == false) goto L47;
        r111 = 4;
        goto L49
    L46:
        if (r109.equals("-1") == false) goto L47;
        r111 = 3;
    L22:
        r109 = "0";
        goto L23
    }
}
