package q08;

import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531204a = 0;

    static {
    }

    public static void a(n08.a r100, CalendarDate r101, CalendarDate r102) {
        if (r101.sameDay(r102) == false) goto L6;
        CalendarAttr r103 = r100.f516609d;
        CalendarAttr.DateState r104 = CalendarAttr.DateState.CURRENT_DATE;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f284797b = r104;
        return;
    L6:
        if (r101.beforeDay(r102) == false) goto L8;
        CalendarAttr r105 = r100.f516609d;
        CalendarAttr.DateState r106 = CalendarAttr.DateState.PAST_DATE;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f284797b = r106;
        return;
    L8:
        CalendarAttr r107 = r100.f516609d;
        CalendarAttr.DateState r108 = CalendarAttr.DateState.FUTURE_DATE;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f284797b = r108;
    }

    public static void b(n08.a r100, CalendarDate r101, CalendarDate r102) {
        if (r101.sameDay(r102) == false) goto L5;
        CalendarAttr r103 = r100.f516609d;
        CalendarAttr.SelectState r104 = CalendarAttr.SelectState.SELECT;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f284796a = r104;
        return;
    L5:
        CalendarAttr r105 = r100.f516609d;
        CalendarAttr.SelectState r106 = CalendarAttr.SelectState.UN_SELECT;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f284796a = r106;
    }
}
