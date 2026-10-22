package d18;

import android.content.Context;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements e18.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f466420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f466423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CalendarDate f466424e;

    public final class a implements e18.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f466426b;

        @Override // e18.c
        public final String a() {
            TimeZone r100 = TimeZone.getTimeZone("UTC");
            CalendarDate r101 = new CalendarDate(this.f466426b.f466424e, r100);
            r101.add(5, this.f466425a);
            StringBuilder r102 = new StringBuilder();
            Context r103 = this.f466426b.f466420a;
            Date r104 = r101.getDate();
            Intrinsics.checkNotNull(r100);
            int[] r105 = com.larksuite.component.universe_design.util.a.f285486a;
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r104, "date");
            Intrinsics.checkNotNullParameter(r100, TimeZoneItemV2.TIME_ZONE);
            String r106 = r103.getResources().getString(R.string.Calendar_StandardTime_MonthDayCombineFormat);
            Intrinsics.checkNotNullParameter(r104, "date");
            Intrinsics.checkNotNullParameter(r100, TimeZoneItemV2.TIME_ZONE);
            Intrinsics.checkNotNullParameter(r106, SubInfo.KEY_FORMAT);
            SimpleDateFormat r107 = new SimpleDateFormat(r106, Locale.getDefault());
            r107.setTimeZone(r100);
            String r108 = r107.format(r104);
            if (r108 != null) goto L5;
            r108 = "";
        L5:
            r102.append(r108);
            r102.append(' ');
            r102.append(this.f466426b.f466423d[r101.getWeekDay() - 1]);
            return r102.toString();
        }

        public a(c r100, int r101) {
            this.f466426b = r100;
            this.f466425a = r101;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.f466422c - this.f466421b) + 1;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final a getItem(int r100) {
        return new a(this, r100);
    }

    @Override // e18.a
    public final int indexOf(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return r101.f466425a;
    }

    public c(Context r100, CalendarDate r101, int r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "beginDate");
        Intrinsics.checkNotNullParameter(r103, "weekStringArray");
        this.f466420a = r100;
        this.f466421b = 0;
        this.f466422c = r102;
        this.f466423d = r103;
        this.f466424e = new CalendarDate(r101);
    }
}
