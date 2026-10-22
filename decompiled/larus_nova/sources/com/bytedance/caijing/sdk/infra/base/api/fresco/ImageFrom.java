package com.bytedance.caijing.sdk.infra.base.api.fresco;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes15.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/fresco/ImageFrom;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ImageFrom {
    public static final a Companion = null;
    public static final int DISK = 2;
    public static final int MEMORY = 1;
    public static final int NETWORK = 0;
    public static final int UNKNOWN = -1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f202226a = null;

        static {
            f202226a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f202226a;
    }
}
