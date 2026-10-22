package com.ss.android.lark.flow.feed.utils;

import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f423631a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("FeedSidebarAdapter", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Log.d("FeedSidebarAdapter", "[FlowFeedLog] " + r100);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.e(r100, "[FlowFeedLog] " + r101);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.i(r100, "[FlowFeedLog] " + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.w(r100, "[FlowFeedLog] " + r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.e(r100, "[FlowFeedLog] ".concat(r101), r102);
    }
}
