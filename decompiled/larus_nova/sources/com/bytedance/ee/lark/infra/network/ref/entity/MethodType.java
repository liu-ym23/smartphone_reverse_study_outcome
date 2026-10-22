package com.bytedance.ee.lark.infra.network.ref.entity;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum MethodType extends Enum<MethodType> {
    public static final MethodType DELETE = null;
    public static final MethodType GET = null;
    public static final MethodType HEAD = null;
    public static final MethodType PATCH = null;
    public static final MethodType POST = null;
    public static final MethodType PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MethodType[] f242809a = null;
    String method;

    static {
        MethodType r100 = new MethodType("GET", 0, MonitorConstants.CONNECT_TYPE_GET);
        GET = r100;
        MethodType r101 = new MethodType("POST", 1, UGCMonitor.TYPE_POST);
        POST = r101;
        MethodType r102 = new MethodType("HEAD", 2, "head");
        HEAD = r102;
        MethodType r103 = new MethodType("DELETE", 3, "delete");
        DELETE = r103;
        MethodType r104 = new MethodType("PUT", 4, "put");
        PUT = r104;
        MethodType r105 = new MethodType("PATCH", 5, "patch");
        PATCH = r105;
        f242809a = new MethodType[]{r100, r101, r102, r103, r104, r105};
    }

    public static MethodType[] values() {
        return (MethodType[]) f242809a.clone();
    }

    public String getValue() {
        return this.method;
    }

    public static MethodType valueOf(String r100) {
        return (MethodType) a.a(MethodType.class, r100);
    }

    public MethodType(String r100, int r101, String r102) {
        super(r100, r101);
        this.method = r102;
    }
}
