package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f434036a = 0;

    static {
    }

    public static String a(long r110) {
        long r111 = r110 / 1000;
        long r100 = r111 / TimeUtils.SECONDS_PER_HOUR;
        long r101 = (r111 % TimeUtils.SECONDS_PER_HOUR) / 60;
        long r112 = r111 % 60;
        if (r100 <= 0) goto L5;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r100), Long.valueOf(r101), Long.valueOf(r112)}, 3));
    L5:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r101), Long.valueOf(r112)}, 2));
    }
}
