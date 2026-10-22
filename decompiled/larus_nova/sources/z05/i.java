package z05;

import android.app.Activity;
import androidx.autofill.HintConstants;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.vivo.libra.CallBack;
import e0c.k;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class i {
    public static boolean b(int r100) {
        if (r100 != sbb.e.f541304o.f541317b) goto L5;
    L8:
        return true;
    L5:
        if (r100 == sbb.e.f541297h.f541317b) goto L8;
        return false;
    }

    public static String c(String r100) {
        return r100.replaceAll("(edition_id=[^&]*)", "");
    }

    public static boolean d(String r100) {
        if (b(((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r100).a()) == true) goto L6;
        tt5.a.h("EditionUtils", "shouldInterceptor: enable = false");
        return false;
    L6:
        boolean r101 = fx4.a.a(r100);
        boolean r102 = p.a().L5(r100);
        if (r102 == false) goto L12;
        if (r101 == true) goto L12;
        return true;
    L12:
        tt5.a.h("EditionUtils", "shouldInterceptor: isVersionManagerUrl = " + r102 + " , isAnnounceDoc = " + r101);
        return false;
    }

    public static String a(Activity r110, String r111, Long r112, Locale r113) {
        Calendar r100 = Calendar.getInstance();
        Calendar.getInstance().setTime(new Date());
        int r101 = r100.get(1);
        r100.setTime(new Date(r112.longValue() * 1000));
        int r114 = r100.get(1);
        int r102 = r100.get(2);
        int r103 = r100.get(5);
        int r104 = r100.get(11);
        int r105 = r100.get(10);
        int r106 = r100.get(9);
        int r107 = r100.get(12);
        if (r113 != null) goto L5;
    L15:
        StringBuilder r115 = new StringBuilder(" ");
        if (r104 >= 10) goto L18;
        Object r108 = "0" + r104;
    L19:
        r115.append(r108);
        r115.append(":");
        if (r107 >= 10) goto L22;
        Object r109 = "0" + r107;
    L23:
        r115.append(r109);
        String r116 = r115.toString();
    L24:
        HashMap r117 = new HashMap();
        Map<String, SimpleDateFormat> r118 = zu5.a.f573665a;
        switch(r102) {
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
        String r119 = "";
    L39:
        r117.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, r119);
        r117.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, String.valueOf(r103));
        if (r101 == r114) goto L42;
        r117.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, String.valueOf(r114));
        String r120 = xo5.a.d(r110, R.string.Doc_Util_Reminder_Format_Year_Month_Day, r117) + r116;
    L43:
        HashMap r121 = new HashMap();
        r121.put(HintConstants.AUTOFILL_HINT_USERNAME, r111);
        r121.put("time", r120);
        return xo5.a.d(r110, R.string.LarkCCM_Docx_VersionMgmt_View_SavernTime_Tooltip, r121);
    L42:
        r120 = xo5.a.d(r110, R.string.Doc_Util_Reminder_Format_Month_Day, r117) + r116;
        goto L43
    L27:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_December);
        goto L39
    L28:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_November);
        goto L39
    L29:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_October);
        goto L39
    L30:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_September);
        goto L39
    L31:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_August);
        goto L39
    L32:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_July);
        goto L39
    L33:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_June);
        goto L39
    L34:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_May);
        goto L39
    L35:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_April);
        goto L39
    L36:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_March);
        goto L39
    L37:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_February);
        goto L39
    L38:
        r119 = r110.getResources().getString(R.string.Doc_Util_Reminder_January);
        goto L39
    L22:
        r109 = Integer.valueOf(r107);
        goto L23
    L18:
        r108 = Integer.valueOf(r104);
        goto L19
    L5:
        if (Locale.ENGLISH.getLanguage().equals(r113.getLanguage()) == false) goto L15;
        StringBuilder r122 = new StringBuilder(" ");
        r122.append(r105);
        r122.append(":");
        if (r107 >= 10) goto L9;
        Object r123 = "0" + r107;
    L10:
        r122.append(r123);
        r122.append(" ");
        if (r106 != 0) goto L13;
        String r124 = "AM";
    L14:
        r122.append(r124);
        r116 = r122.toString();
        goto L24
    L13:
        r124 = CallBack.EVENT_POWER_MODE;
        goto L14
    L9:
        r123 = Integer.valueOf(r107);
        goto L10
    }
}
