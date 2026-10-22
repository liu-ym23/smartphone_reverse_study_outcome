package com.bytedance.caijing.sdk.infra.base.api.trip.host;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
public interface IDeviceHelper {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/IDeviceHelper$FoldStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FoldStatus {
        public static final a Companion = null;
        public static final String FLAT = "flat";
        public static final String FOLDED = "folded";
        public static final String HALF = "half";
        public static final String UNKNOWN = "";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f202248a = null;

            static {
                f202248a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f202248a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/IDeviceHelper$FoldType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FoldType {
        public static final a Companion = null;
        public static final String HORIZONTAL = "horizontal";
        public static final String UNKNOWN = "";
        public static final String VERTICAL = "vertical";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f202249a = null;

            static {
                f202249a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f202249a;
        }
    }
}
