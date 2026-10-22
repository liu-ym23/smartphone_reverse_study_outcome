package d18;

import android.content.Context;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements e18.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f466427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f466430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f466431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f466432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f466433g;

    public final class a implements e18.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f466435b;

        @Override // e18.c
        public final String a() {
            int r100 = this.f466434a;
            if (r100 >= 0) goto L5;
            return "";
        L5:
            if (r100 >= this.f466435b.getItemsCount()) goto L14;
            d r101 = this.f466435b;
            int r102 = r101.f466431e + this.f466434a;
            CalendarDate r103 = new CalendarDate(r101.f466428b, r101.f466429c, r102, 0, 0, 0);
            StringBuilder r104 = new StringBuilder();
            r104.append(h18.b.a(this.f466435b.getContext(), R.string.Calendar_StandardTime_DayOnlyString, "numberDay", String.valueOf(r102)));
            if (this.f466435b.f466432f == false) goto L11;
            r104.append("(");
            r104.append(this.f466435b.f466430d[r103.getWeekDay() - 1]);
            r104.append(")");
        L11:
            return r104.toString();
        L14:
            return "";
        }

        public a(d r100, int r101) {
            this.f466435b = r100;
            this.f466434a = r101;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.f466433g - this.f466431e) + 1;
    }

    public final Context getContext() {
        return this.f466427a;
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
        Intrinsics.checkNotNullParameter(r101, "dayWeek");
        return r101.f466434a;
    }

    public d(Context r100, int r101, int r102, String[] r103, boolean r104) {
        int r105 = com.larksuite.component.universe_design.util.a.a(r101, r102);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "mWeeks");
        this.f466427a = r100;
        this.f466428b = r101;
        this.f466429c = r102;
        this.f466430d = r103;
        this.f466431e = 1;
        this.f466432f = r104;
        this.f466433g = r105;
    }
}
