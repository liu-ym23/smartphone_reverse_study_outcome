package com.ss.android.lark.time.format.common;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class TimezoneUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f441320a = null;

    static {
        f441320a = LazyKt.lazy(TimezoneUtil$timezoneDisplayName$2.INSTANCE);
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = UIUtils.getString(r100, R.string.Calendar_StandardTime_TwelveHourOnTheHourWithMeridiemIndicator);
        Intrinsics.checkNotNull(r101);
        return StringsKt.startsWith$default(r101, UIUtils.getString(r100, R.string.Calendar_StandardTime_MeridiemFormat), false, 2, null);
    }
}
