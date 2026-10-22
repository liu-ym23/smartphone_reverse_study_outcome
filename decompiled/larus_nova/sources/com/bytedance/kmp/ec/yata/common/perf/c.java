package com.bytedance.kmp.ec.yata.common.perf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f251475c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f251476d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f251477e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f251478f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f251479g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f251480h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f251481i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f251482j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f251483k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f251484l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f251485m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f251486n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f251487o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f251488p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f251489q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251491b;

    public static final class a {
    }

    static {
        f251475c = new c("yata_ins_init_timing", "【标准-初始化SDK】");
        f251476d = new c("yata_adjust_fields_timing", "【标准-adjust更新，包含修改和提交到store】");
        f251477e = new c("yata_adjust_modify_timing", "【遗留-adjust match和修改】");
        f251478f = new c("yata_adjust_store_dispatch_timing", "【遗留-adjust的修改提交到store】");
        f251479g = new c("yata_update_build_protocol_timing", "【标准-Update网络请求构建上行数据】");
        f251480h = new c("yata_update_compose_yata_param", "【非标准-Update网络请求组装yata_param】");
        f251481i = new c("yata_update_serialize_yata_param", "【非标准-Update网络请求序列化yata_param】");
        f251482j = new c("yata_update_gzip_yata_param", "【非标准-Update网络请求压缩yata_param】");
        f251483k = new c("yata_update_serialize_request_body", "【非标准-Update网络请求序列化request_body】");
        f251484l = new c("yata_update_net_timing", "【标准-Update端到端网络请求】");
        f251485m = new c("yata_downlink_model_timing", "【标准-Update请求结果序列化】");
        f251486n = new c("yata_store_tree_build_timing", "【标准-区块节点树全量构建】");
        f251487o = new c("yata_store_tree_update_timing", "【标准-区块节点树差量更新】");
        f251488p = new c("yata_patch_timing", "【标准-Patch执行】");
        f251489q = new c("yata_view_upscreen_timing", "【标准-上屏】");
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "cName");
        this.f251490a = r100;
        this.f251491b = r101;
    }
}
