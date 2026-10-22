package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f202412g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f202413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f202414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f202415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f202416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f202417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f202418f;

    public static final class a {
        public static i a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            i r101 = new i(0);
            String r102 = r100.optString("schema", "");
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f202413a = r102;
            r101.f202414b = r100.optString("boe_ak", "");
            r101.f202415c = r100.optString("ppe_ak", "");
            r101.f202416d = r100.optString("prod_ak", "");
            String r103 = r100.optString("channel", "");
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f202417e = r103;
            String r104 = r100.optString("path", "");
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r101.f202418f = r104;
            return r101;
        }
    }

    static {
    }

    public i() {
        this(0);
    }

    public final String a() {
        CJHostService r100 = (CJHostService) ve4.b.a(CJHostService.class);
        Boolean r101 = null;
        if (r100 == null) goto L7;
        INetEnv r102 = r100.getNetEnvHelper();
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.isBoe());
    L8:
        boolean r104 = false;
        if (r103 == null) goto L11;
        boolean r105 = r103.booleanValue();
    L12:
        CJHostService r106 = (CJHostService) ve4.b.a(CJHostService.class);
        if (r106 == null) goto L17;
        INetEnv r107 = r106.getNetEnvHelper();
        if (r107 == null) goto L17;
        r101 = Boolean.valueOf(r107.isPpe());
    L17:
        if (r101 == null) goto L19;
        r104 = r101.booleanValue();
    L19:
        if (r105 == true) goto L25;
        if (r104 == false) goto L24;
        return this.f202415c;
    L24:
        return this.f202416d;
    L25:
        return this.f202414b;
    L11:
        r105 = false;
    L7:
        r103 = null;
        goto L8
    }

    public i(int r100) {
        Intrinsics.checkNotNullParameter("", "schema");
        Intrinsics.checkNotNullParameter("", "boeAK");
        Intrinsics.checkNotNullParameter("", "ppeAK");
        Intrinsics.checkNotNullParameter("", "prodAK");
        Intrinsics.checkNotNullParameter("", "channel");
        Intrinsics.checkNotNullParameter("", "path");
        this.f202413a = "";
        this.f202414b = "";
        this.f202415c = "";
        this.f202416d = "";
        this.f202417e = "";
        this.f202418f = "";
    }
}
