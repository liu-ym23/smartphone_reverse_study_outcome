package com.bytedance.caijing.sdk.infra.base.api.env;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes15.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/DidFetchRetCode;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DidFetchRetCode {
    public static final a Companion = null;
    public static final int FAIL_FETCH = 5;
    public static final int NET_ERROR = 2;
    public static final int SUCCESS_FETCH = 0;
    public static final int SUCCESS_HAS_DID = 1;
    public static final int TIME_OUT_APP_LOG = 3;
    public static final int TIME_OUT_FETCH = 4;
    public static final int UNKNOWN = 6;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f202219a = null;

        static {
            f202219a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f202219a;
    }
}
