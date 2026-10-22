package hma;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f486051a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f486052a = null;

        static {
            int[] r100 = new int[DayOfWeek.values().length];
            r100[DayOfWeek.MONDAY.ordinal()] = 1;
            r100[DayOfWeek.TUESDAY.ordinal()] = 2;
            r100[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            r100[DayOfWeek.THURSDAY.ordinal()] = 4;
            r100[DayOfWeek.FRIDAY.ordinal()] = 5;
            r100[DayOfWeek.SATURDAY.ordinal()] = 6;
            r100[DayOfWeek.SUNDAY.ordinal()] = 7;
            f486052a = r100;
        }
    }

    static {
    }

    public h() {
    }

    public static int a(int r100, boolean r101) {
        if (r100 != 1) goto L5;
    L22:
        return 31;
    L5:
        if (r100 != 2) goto L7;
        if (r101 == false) goto L21;
        return 29;
    L21:
        return 28;
    L7:
        if (r100 == 3) goto L22;
        if (r100 == 5) goto L22;
        if (r100 == 10) goto L22;
        if (r100 == 12) goto L22;
        if (r100 == 7) goto L22;
        if (r100 == 8) goto L22;
        return 30;
    }

    public static List b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = new ArrayList();
        int r102 = 1;
    L3:
        int r103 = r102 + 1;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L5:
        int r104 = R.string.oui_reel_picker_month_def;
    L18:
        r101.add(r100.getString(r104));
        if (r102 == 12) goto L20;
        r102 = r103;
        goto L3
    L20:
        return r101;
    L6:
        r104 = R.string.oui_reel_picker_month_dec;
        goto L18
    L7:
        r104 = R.string.oui_reel_picker_month_nov;
        goto L18
    L8:
        r104 = R.string.oui_reel_picker_month_oct;
        goto L18
    L9:
        r104 = R.string.oui_reel_picker_month_sep;
        goto L18
    L10:
        r104 = R.string.oui_reel_picker_month_aug;
        goto L18
    L11:
        r104 = R.string.oui_reel_picker_month_jul;
        goto L18
    L12:
        r104 = R.string.oui_reel_picker_month_jun;
        goto L18
    L13:
        r104 = R.string.oui_reel_picker_month_may;
        goto L18
    L14:
        r104 = R.string.oui_reel_picker_month_apr;
        goto L18
    L15:
        r104 = R.string.oui_reel_picker_month_mar;
        goto L18
    L16:
        r104 = R.string.oui_reel_picker_month_feb;
        goto L18
    L17:
        r104 = R.string.oui_reel_picker_month_jan;
        goto L18
    }

    public static boolean e(int r100) {
        if ((r100 % 4) != 0) goto L7;
        if ((r100 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r100 % 400) == 0) goto L8;
        return false;
    }

    public static List c(int r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "suffix");
        ArrayList r104 = new ArrayList();
        if (r100 > r101) goto L8;
    L4:
        int r105 = r100 + 1;
        r104.add(Intrinsics.stringPlus(StringsKt.padStart(String.valueOf(r100), r103, '0'), r102));
        if (r100 == r101) goto L8;
        r100 = r105;
    L8:
        return r104;
    }

    public static /* synthetic */ List d(int r100, int r101, String r102, int r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L9;
        r103 = 2;
    L9:
        return c(r100, r101, r102, r103);
    }
}
