package com.bytedance.ee.bear.lynx.impl.xbridge.method.network;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes18.dex */
@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xbridge/method/network/NetworkConstant$RequestErrorCode;", "", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface NetworkConstant$RequestErrorCode {
    public static final a Companion = null;
    public static final int HTTP_ERROR = -115000;
    public static final int INNER_ERROR = -113000;
    public static final int NET_ERROR = -114000;
    public static final int PARAM_ERROR = -112000;
    public static final int SERVER_ERROR = -116000;
    public static final int SUCCESS = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f229962a = null;

        static {
            f229962a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f229962a;
    }
}
