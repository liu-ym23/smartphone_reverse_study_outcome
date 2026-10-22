package com.bytedance.bdlocation.utils;

import bua.a;
import bua.b;
import bua.c;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class HARServiceUtil {
    public HARServiceUtil() {
    }

    public static List<HARStatus> getHARStatusList() {
        ArrayList r0 = new ArrayList();
        b r1 = b.b.a;
        int r2 = BDLocationConfig.getHARStatusRange();
        List r3 = r1.a(r2);
        if (r3 != null) goto L5;
    L9:
        ArrayList r4 = null;
    L10:
        int r5 = a.a;
        if (r4 != null) goto L13;
    L18:
        return r0;
    L13:
        if (r4.size() <= 0) goto L18;
        Iterator r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        c r7 = (c) r6.next();
        HARStatus r8 = new HARStatus();
        r7.getClass();
        r8.predict = null;
        r8.timestamp = 0;
        r0.add(r8);
        goto L16
    L5:
        if (r3.isEmpty() == true) goto L9;
        r4 = new ArrayList();
        int r9 = Math.min(r3.size(), r2);
        int r10 = 0;
    L7:
        if (r10 >= r9) goto L10;
        r4.add(ListProtector.get(r3, r10));
        r10 = r10 + 1;
        goto L7
    }

    public static int getMaxHARStatus() {
        List r0 = b.b.a.a(BDLocationConfig.getHARStatusRange());
        int r1 = 0;
        if (r0 != null) goto L5;
    L60:
        int r2 = a.a;
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L60;
        HashMap r3 = new HashMap();
        int r4 = r0.size();
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L10;
        ((c) ListProtector.get(r0, r5)).getClass();
        r5 = r5 + 1;
        goto L7
    L10:
        if (r3.isEmpty() == true) goto L22;
        Iterator r6 = r3.entrySet().iterator();
        Map.Entry r7 = null;
    L13:
        if (r6.hasNext() == false) goto L20;
        Map.Entry r8 = (Map.Entry) r6.next();
        if (r8 == null) goto L13;
        if (r7 == null) goto L19;
        if (((Float) r7.getValue()).floatValue() >= ((Float) r8.getValue()).floatValue()) goto L13;
    L19:
        r7 = r8;
        goto L13
    L20:
        if (r7 == null) goto L22;
        String r9 = (String) r7.getKey();
    L23:
        r9.getClass();
        int r10 = r9.hashCode();
        if (r10 == 1444) goto L46;
        if (r10 == 1445) goto L42;
        switch(r10) {
            case 49: goto L38;
            case 50: goto L34;
            case 51: goto L30;
            default: goto L47;
        };
    L47:
        byte r11 = -1;
    L49:
        if (r11 == 0) goto L59;
        if (r11 == 1) goto L58;
        if (r11 == 2) goto L57;
        if (r11 == 3) goto L56;
        if (r11 != 4) goto L60;
        r1 = -2;
        goto L60
    L56:
        r1 = -1;
        goto L60
    L57:
        r1 = 3;
        goto L60
    L58:
        r1 = 2;
        goto L60
    L59:
        r1 = 1;
        goto L60
    L30:
        if (r9.equals("3") == false) goto L47;
        r11 = 2;
        goto L49
    L34:
        if (r9.equals(PromotionCategory.CATEGORY_TYPE_SECOND) == false) goto L47;
        r11 = 1;
        goto L49
    L38:
        if (r9.equals("1") == false) goto L47;
        r11 = 0;
        goto L49
    L42:
        if (r9.equals("-2") == false) goto L47;
        r11 = 4;
        goto L49
    L46:
        if (r9.equals("-1") == false) goto L47;
        r11 = 3;
    L22:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L23
    }
}
