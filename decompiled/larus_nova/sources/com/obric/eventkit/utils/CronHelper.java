package com.obric.eventkit.utils;

import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.cronutils.model.CronType;
import com.obric.eventkit.logger.Logger;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import wr7.g;
import wr7.h;
import yr7.e;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J#\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/obric/eventkit/utils/CronHelper;", "", "", "cron", "", "isTimeRecurring", "", "fromTimestamp", "getNextScheduleTime", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "isValidCron", "", "isValidCronException", "TAG", "Ljava/lang/String;", "Lyr7/e;", "cronParser$delegate", "Lkotlin/Lazy;", "getCronParser", "()Lyr7/e;", "cronParser", "<init>", "()V", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class CronHelper {
    public static final CronHelper INSTANCE = null;
    private static final String TAG = "CronHelper";
    private static final Lazy cronParser$delegate = null;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lyr7/e;", AbsMethodDelegate.TAG_INVOKE, "()Lyr7/e;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function0<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396883a = null;

        static {
            f396883a = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public e invoke() {
            return new e(com.cronutils.model.definition.a.b(CronType.QUARTZ));
        }
    }

    static {
        INSTANCE = new CronHelper();
        cronParser$delegate = LazyKt.lazy(a.f396883a);
    }

    private CronHelper() {
    }

    private final e getCronParser() {
        return (e) cronParser$delegate.getValue();
    }

    public static /* synthetic */ Long getNextScheduleTime$default(CronHelper r100, String r101, Long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getNextScheduleTime(r101, r102);
    }

    public final Long getNextScheduleTime(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "cron");
        h r102 = g.a(INSTANCE.getCronParser().a(r100));     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r101 == null) goto L7;
        ZonedDateTime r103 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(r101.longValue()), ZoneId.systemDefault());     // Catch: Throwable -> L14
    L8:
        ZonedDateTime r104 = r102.a(r103).orElse(null);     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        return Long.valueOf(r104.toInstant().toEpochMilli());
    L7:
        r103 = ZonedDateTime.now();     // Catch: Throwable -> L14
    L12:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        Logger.INSTANCE.i(TAG, "getNextScheduleTime fail cron = " + r100 + ", fromTimestamp = " + r101 + ' ' + r106);
    L19:
        return null;
    L14:
        th = move-exception;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean isTimeRecurring(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cron");
        List r101 = StringsKt.split$default(r100, new String[]{" "}, false, 0, 6, null);
        if (r101.size() == 6) goto L8;
        if (r101.size() == 7) goto L8;
        return false;
    L8:
        if (StringsKt.contains$default(r100, "*", false, 2, null) == false) goto L10;
    L15:
        return true;
    L10:
        if (StringsKt.contains$default(r100, "-", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r100, HTTP.URL_DEFAULT, false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r100, ",", false, 2, null) == true) goto L15;
        return false;
    }

    public final boolean isValidCron(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cron");
        INSTANCE.isValidCronException(r100);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Throwable r101 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r101 == null) goto L14;
        Logger.INSTANCE.i(TAG, "isValidCron fail cron = " + r100 + ", " + r101);
        return false;
    L14:
        return false;
    }

    public final void isValidCronException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cron");
        getCronParser().a(r100).validate();
    }
}
