package com.larus.chat.job.impl.page;

import com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings;
import com.larus.im.bean.job.AIJob;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325370a = 0;

    static {
    }

    public static String a(int r100) {
        if (r100 != 3) goto L5;
        return "lark_event_job";
    L5:
        return "cron_job";
    }

    public static boolean b(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 3) goto L9;
        ChatJobLarkEventSettings.f325056a.getClass();
        if (ChatJobLarkEventSettings.a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean c(AIJob r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        if (r100.getJobType() != 1) goto L5;
        return true;
    L5:
        if (r100.getJobType() != 3) goto L13;
        ChatJobLarkEventSettings.f325056a.getClass();
        if (ChatJobLarkEventSettings.a() == false) goto L13;
        if (r100.getStatus() != 1) goto L11;
        return true;
    L11:
        if (r100.getStatus() != 2) goto L13;
        return true;
    L13:
        return false;
    }
}
