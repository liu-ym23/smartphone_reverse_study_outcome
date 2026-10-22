package com.bytedance.env.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/env/api/EnvManager;", "", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final class EnvManager {
    public static final a Companion = null;
    private static final Lazy apiImpl$delegate = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EnvManagerApi a() {
            return (EnvManagerApi) EnvManager.access$getApiImpl$cp().getValue();
        }
    }

    public EnvManager() {
    }

    @JvmStatic
    public static final EnvManagerApi getService() {
        Companion.getClass();
        return a.a();
    }

    static {
        Companion = new a();
        apiImpl$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, EnvManager$Companion$apiImpl$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getApiImpl$cp() {
        return apiImpl$delegate;
    }
}
