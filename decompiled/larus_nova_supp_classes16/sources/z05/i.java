package z05;

import android.app.Activity;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static boolean b(int r1) {
        if (r1 != sbb.e.o.b) goto L5;
    L8:
        return true;
    L5:
        if (r1 == sbb.e.h.b) goto L8;
        return false;
    }

    public static String c(String r2) {
        return r2.replaceAll("(edition_id=[^&]*)", "");
    }

    public static boolean d(String r5) {
        if (b(((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r5).a()) == true) goto L6;
        tt5.a.h("EditionUtils", "shouldInterceptor: enable = false");
        return false;
    L6:
        boolean r0 = fx4.a.a(r5);
        boolean r6 = p.a().L5(r5);
        if (r6 == false) goto L12;
        if (r0 == true) goto L12;
        return true;
    L12:
        tt5.a.h("EditionUtils", "shouldInterceptor: isVersionManagerUrl = " + r6 + " , isAnnounceDoc = " + r0);
        return false;
    }

    public static String a(Activity r12, String r13, Long r14, Locale r16) {
        Calendar r0 = Calendar.getInstance();
        Calendar.getInstance().setTime(new Date());
        int r2 = r0.get(1);
        r0.setTime(new Date(r14.longValue() * 1000));
        int r17 = r0.get(1);
        int r1 = r0.get(2);
        int r3 = r0.get(5);
        int r4 = r0.get(11);
        int r6 = r0.get(10);
        int r7 = r0.get(9);
        int r5 = r0.get(12);
        if (r16 != null) goto L5;
    L15:
        StringBuilder r18 = new StringBuilder(" ");
        if (r4 >= 10) goto L18;
        Object r8 = DiagramData$RESULT.FAIL + r4;
    L19:
        r18.append(r8);
        r18.append(":");
        if (r5 >= 10) goto L22;
        Object r9 = DiagramData$RESULT.FAIL + r5;
    L23:
        r18.append(r9);
        String r19 = r18.toString();
    L24:
        HashMap r10 = new HashMap();
        Map r11 = zu5.a.a;
        switch(r1) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            default: goto L26;
        };
    L26:
        String r20 = "";
    L39:
        r10.put("month", r20);
        r10.put("day", String.valueOf(r3));
        if (r2 == r17) goto L42;
        r10.put("year", String.valueOf(r17));
        String r110 = xo5.a.d(r12, 2131888293, r10) + r19;
    L43:
        HashMap r111 = new HashMap();
        r111.put("username", r13);
        r111.put("time", r110);
        return xo5.a.d(r12, 2131889379, r111);
    L42:
        r110 = xo5.a.d(r12, 2131888289, r10) + r19;
        goto L43
    L27:
        r20 = r12.getResources().getString(2131888285);
        goto L39
    L28:
        r20 = r12.getResources().getString(2131888301);
        goto L39
    L29:
        r20 = r12.getResources().getString(2131888302);
        goto L39
    L30:
        r20 = r12.getResources().getString(2131888305);
        goto L39
    L31:
        r20 = r12.getResources().getString(2131888284);
        goto L39
    L32:
        r20 = r12.getResources().getString(2131888296);
        goto L39
    L33:
        r20 = r12.getResources().getString(2131888297);
        goto L39
    L34:
        r20 = r12.getResources().getString(2131888300);
        goto L39
    L35:
        r20 = r12.getResources().getString(2131888283);
        goto L39
    L36:
        r20 = r12.getResources().getString(2131888299);
        goto L39
    L37:
        r20 = r12.getResources().getString(2131888287);
        goto L39
    L38:
        r20 = r12.getResources().getString(2131888295);
        goto L39
    L22:
        r9 = Integer.valueOf(r5);
        goto L23
    L18:
        r8 = Integer.valueOf(r4);
        goto L19
    L5:
        if (Locale.ENGLISH.getLanguage().equals(r16.getLanguage()) == false) goto L15;
        StringBuilder r112 = new StringBuilder(" ");
        r112.append(r6);
        r112.append(":");
        if (r5 >= 10) goto L9;
        Object r21 = DiagramData$RESULT.FAIL + r5;
    L10:
        r112.append(r21);
        r112.append(" ");
        if (r7 != 0) goto L13;
        String r22 = "AM";
    L14:
        r112.append(r22);
        r19 = r112.toString();
        goto L24
    L13:
        r22 = "PM";
        goto L14
    L9:
        r21 = Integer.valueOf(r5);
        goto L10
    }
}
