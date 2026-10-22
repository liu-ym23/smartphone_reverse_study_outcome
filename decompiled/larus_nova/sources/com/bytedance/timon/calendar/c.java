package com.bytedance.timon.calendar;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.timon.calendar.impl.TimonCalendarImpl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function1<? super com.bytedance.timon.calendar.b, Unit> f270568a;

    public static final class a implements com.bytedance.timon.calendar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f270569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f270570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.timon.calendar.a f270571c;

        @Override // com.bytedance.timon.calendar.b
        public final void onPermissionDenied() {
            this.f270571c.a(false, ResultCode.NoPermission, "user denied WRITE_CALENDAR permission");
        }

        @Override // com.bytedance.timon.calendar.b
        public final void a(String[] r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            TimonCalendarImpl.f270576a.h(this.f270569a, this.f270570b, this.f270571c, 1);
        }

        public a(Context r100, String r101, com.bytedance.timon.calendar.a r102) {
            this.f270569a = r100;
            this.f270570b = r101;
            this.f270571c = r102;
        }
    }

    public static final class b implements com.bytedance.timon.calendar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f270572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventRecord f270573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.timon.calendar.a f270574c;

        @Override // com.bytedance.timon.calendar.b
        public final void onPermissionDenied() {
            this.f270574c.a(false, ResultCode.NoPermission, "user denied WRITE_CALENDAR permission");
        }

        @Override // com.bytedance.timon.calendar.b
        public final void a(String[] r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            TimonCalendarImpl.f270576a.a(this.f270572a, this.f270573b, this.f270574c);
        }

        public b(Context r100, EventRecord r101, com.bytedance.timon.calendar.a r102) {
            this.f270572a = r100;
            this.f270573b = r101;
            this.f270574c = r102;
        }
    }

    static {
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TimonCalendarImpl.f270577b.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.timon.calendar.impl.b.f270585b = r100.getApplicationContext().getSharedPreferences("timon_calendar_sp_repo", 0);
    }

    public static EventRecord d(String r110) {
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276361k);
        TimonCalendarImpl r100 = TimonCalendarImpl.f270576a;
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276361k);
    L15:
        e = move-exception;
        TimonCalendarImpl.f("readEventByEventId", TimonCalendarImpl.f270580e, TimonCalendarImpl.e(), r110, 0, Integer.valueOf(ResultCode.Unknown.getValue()), e.getMessage(), e);
        return null;
    L4:
        if (r110.length() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L20;
        Gson r102 = new Gson();     // Catch: JsonSyntaxException -> L15
        TimonCalendarImpl.f270577b.getClass();     // Catch: JsonSyntaxException -> L15
        Intrinsics.checkNotNullParameter(r110, "key");     // Catch: JsonSyntaxException -> L15
        SharedPreferences r103 = com.bytedance.timon.calendar.impl.b.f270585b;     // Catch: JsonSyntaxException -> L15
        if (r103 == null) goto L12;
        String r104 = r103.getString(r110, "");     // Catch: JsonSyntaxException -> L15
    L13:
        EventRecord r111 = (EventRecord) GsonProtectorUtils.fromJson(r102, r104, EventRecord.class);     // Catch: JsonSyntaxException -> L15
        TimonCalendarImpl.g(r100, "readEventByEventId", TimonCalendarImpl.f270580e, TimonCalendarImpl.e(), r110, 1, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);     // Catch: JsonSyntaxException -> L15
        return r111;
    L12:
        r104 = null;
        goto L13
    L20:
        return null;
    L6:
        r101 = false;
        goto L7
    }

    public static void a(Context r100, String r101, com.bytedance.timon.calendar.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r102, "callBack");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_CALENDAR") != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        TimonCalendarImpl.f270576a.h(r100, r101, r102, 1);
        return;
    L8:
        Function1<? super com.bytedance.timon.calendar.b, Unit> r104 = f270568a;
        if (r104 == null) goto L11;
        r104.invoke(new a(r100, r101, r102));
        return;
    L11:
        r102.a(false, ResultCode.NoRequestPermissionInvoker, "no register request permission invoker");
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static void c(Context r100, EventRecord r101, com.bytedance.timon.calendar.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "callBack");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_CALENDAR") != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        TimonCalendarImpl.f270576a.a(r100, r101, r102);
        return;
    L8:
        Function1<? super com.bytedance.timon.calendar.b, Unit> r104 = f270568a;
        if (r104 == null) goto L11;
        r104.invoke(new b(r100, r101, r102));
        return;
    L11:
        r102.a(false, ResultCode.NoRequestPermissionInvoker, "no register request permission invoker");
        return;
    L5:
        r103 = false;
        goto L6
    }
}
