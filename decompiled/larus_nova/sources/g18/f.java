package g18;

import android.content.Context;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f479627a = 0;

    static {
    }

    @JvmStatic
    public static final d18.e a(Context r100, CalendarDate r101, CalendarDate r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "startCalendar");
        Intrinsics.checkNotNullParameter(r102, "endCalendar");
        int r104 = r101.getYear();
        int r105 = r102.getYear();
        if (r104 > r103) goto L6;
        if (r103 > r105) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == true) goto L10;
        return null;
    L10:
        int r107 = h18.b.f483538a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String[] r108 = r100.getResources().getStringArray(R.array.ud_timePicker_monthAbbr);
        if (r103 == r104) goto L17;
        if (r103 != r105) goto L16;
        return new d18.e(1, r102.getMonth(), r108);
    L16:
        return new d18.e(1, 12, r108);
    L17:
        return new d18.e(r101.getMonth(), 12, r108);
    L6:
        r106 = false;
        goto L7
    }
}
