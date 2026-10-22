package com.bytedance.kmp.ec.yata.common.error;

import com.amap.api.services.core.AMapException;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内置错误码")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251397a = 0;

    static {
    }

    public static d a() {
        d r100 = new d(900010, "CUSTOM_CHECK_AUTO_EXPOSURE");
        r100.f251416s = "p1";
        r100.f251409l.put("error_level", "p1");
        return r100;
    }

    public static d b() {
        d r100 = new d(909998, "CUSTOM_COMPATIBLE");
        r100.e();
        r100.f251413p = true;
        return r100;
    }

    public static d c() {
        return new d(2004, "EVENT_ADJUST_FAILED");
    }

    public static d d() {
        return new d(AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL, "EVENT_MIS_FIELDS_ERROR");
    }

    public static d e() {
        d r100 = new d(2205, "EXECUTE_EVENT_UNEXPECTED_ERROR");
        r100.e();
        return r100;
    }

    public static d f() {
        return new d(2208, "EXECUTE_POPUP_EVENT_FAILED");
    }

    public static d g() {
        d r100 = new d(5001, "EXPRESSION_EXECUTE_FAILED");
        r100.e();
        return r100;
    }

    public static d h() {
        d r100 = new d(5002, "EXPRESSION_RESPONSE_TYPE_IRREGULAR");
        r100.e();
        return r100;
    }

    public static d i() {
        d r100 = new d(6000, "JSONPATCH_ERROR");
        r100.e();
        return r100;
    }

    public static d j() {
        d r100 = new d(909999, "OTHER_ERROR");
        r100.e();
        return r100;
    }
}
