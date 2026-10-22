package com.obric.aiagent.ipc.utils;

import androidx.core.os.BundleKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384748a = 0;

    static {
    }

    public static void b(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "detail");
        BundleKt.bundleOf(new Pair[]{TuplesKt.to("ipc_action_type", "call_result"), TuplesKt.to("ipc_tag", r100), TuplesKt.to("ipc_detail", r101), TuplesKt.to("ipc_cost", Long.valueOf(r102))});
    }

    public static void d(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "detail");
        BundleKt.bundleOf(new Pair[]{TuplesKt.to("ipc_action_type", "invoke_result"), TuplesKt.to("ipc_tag", r100), TuplesKt.to("ipc_detail", r101), TuplesKt.to("ipc_cost", Long.valueOf(r102))});
    }

    public static void a(String r100, String r101, IPCException r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "detail");
        Intrinsics.checkNotNullParameter(r102, "e");
        BundleKt.bundleOf(new Pair[]{TuplesKt.to("ipc_action_type", "call_fail"), TuplesKt.to("ipc_tag", r100), TuplesKt.to("ipc_detail", r101), TuplesKt.to("ipc_exception", r102.getMessage()), TuplesKt.to("ipc_cost", Long.valueOf(r103))});
    }

    public static void c(String r100, String r101, IPCException r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "detail");
        Intrinsics.checkNotNullParameter(r102, "e");
        BundleKt.bundleOf(new Pair[]{TuplesKt.to("ipc_action_type", "invoke_fail"), TuplesKt.to("ipc_tag", r100), TuplesKt.to("ipc_detail", r101), TuplesKt.to("ipc_exception", r102.getMessage()), TuplesKt.to("ipc_cost", Long.valueOf(r103))});
    }
}
