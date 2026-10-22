package com.ss.android.lark.todo.impl.utils;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444289a = 0;

    static {
    }

    public static String g(String r100) {
        return "{\"module\":\"todo\", \"assert\":\"" + r100 + "\"}";
    }

    public static String h(String r100) {
        return "{\"module\":\"todo\", \"monitor\":\"" + r100 + "\"}";
    }

    public static String i(String r100) {
        return "{\"module\":\"todo\", \"opt_type\":\"" + r100 + "\"}";
    }

    public static String j(String r100) {
        return "{\"module\":\"todo\", \"push_type\":\"" + r100 + "\"}";
    }

    public static String a(String r100, String r101, ErrorResult r102) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        Intrinsics.checkNotNullParameter(r101, "apiName");
        StringBuilder r103 = new StringBuilder();
        if (r102 != null) goto L5;
        r103.append("\"error_result\":\"null\"");
    L7:
        return c(r100, r101, r103.toString());
    L5:
        r103.append("\"err_code\":\"");
        r103.append(r102.getErrorCode());
        r103.append("\", \"err_msg\":\"");
        r103.append(r102.getDebugMsg());
        r103.append("\"");
        goto L7
    }

    public static String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        Intrinsics.checkNotNullParameter(r101, "apiName");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        return c(r100, r101, "\"err_msg\":\"" + r102 + Typography.quote);
    }

    public static String c(String r100, String r101, String r102) {
        return "{\"module\":\"todo\", \"context_id\":\"" + r100 + "\", \"api_name\":\"" + r101 + "\", \"api_opt\":\"err\", " + r102 + com.alipay.sdk.m.u.i.f25855d;
    }

    public static String e(String r100, String r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        Intrinsics.checkNotNullParameter(r101, "apiName");
        Intrinsics.checkNotNullParameter(r102, "messages");
        return d(r100, r101, HiAnalyticsConstant.Direction.REQUEST, (String[]) Arrays.copyOf(r102, r102.length));
    }

    public static String f(String r100, String r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        Intrinsics.checkNotNullParameter(r101, "apiName");
        Intrinsics.checkNotNullParameter(r102, "messages");
        return d(r100, r101, "suc", (String[]) Arrays.copyOf(r102, r102.length));
    }

    public static String d(String r100, String r101, String r102, String... r103) {
        StringBuilder r104 = new StringBuilder("{\"module\":\"todo\", \"context_id\":\"");
        r104.append(r100);
        r104.append("\", \"api_name\":\"");
        r104.append(r101);
        r104.append("\", \"api_opt\":\"");
        r104.append(r102);
        r104.append("\"");
        if (r103 == null) goto L8;
        int r105 = 0;
    L6:
        if (r105 >= (r103.length - 1)) goto L8;
        r104.append(", \"");
        int r106 = r105 + 1;
        r104.append(r103[r105]);
        r104.append("\":\"");
        r105 = r106 + 1;
        r104.append(r103[r106]);
        r104.append("\"");
    L8:
        r104.append(com.alipay.sdk.m.u.i.f25855d);
        return r104.toString();
    }
}
