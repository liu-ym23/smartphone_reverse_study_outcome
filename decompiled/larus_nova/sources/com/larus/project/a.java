package com.larus.project;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367000a = 0;

    static {
    }

    public static String b(ProjectListDataSourceImpl r100) {
        return ProjectListDataSourceImpl.class.getName() + '@' + Integer.toHexString(r100.hashCode());
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "detail");
        FLogger.f375446a.i("FlowFeedArch", r100 + ' ' + r101);
    }
}
