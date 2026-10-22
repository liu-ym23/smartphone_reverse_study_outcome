package com.bytedance.locallife.cube.experiments;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257205a = 0;

    /* JADX INFO: renamed from: com.bytedance.locallife.cube.experiments.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u000bR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u000bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/cube/experiments/a$a;", "", "", "", "threadOptSchemas", "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", "syncMethods", "d", "setSyncMethods", "([Ljava/lang/String;)V", "asyncMethods", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAsyncMethods", "mainThreadMethod", "b", "setMainThreadMethod", "mainThreadOptMethod", "c", "setMainThreadOptMethod", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class C3651a {

        @SerializedName("bdx_bridge_async_methods")
        private String[] asyncMethods;

        @SerializedName("bdx_bridge_main_thread_method")
        private String[] mainThreadMethod;

        @SerializedName("bdx_bridge_main_thread_opt_method")
        private String[] mainThreadOptMethod;

        @SerializedName("bdx_bridge_sync_methods")
        private String[] syncMethods;

        @SerializedName("bdx_bridge_thread_opt_schema")
        private final String[] threadOptSchemas;

        public C3651a() {
        }

        public final String[] a() {
            return this.asyncMethods;
        }

        public final String[] b() {
            return this.mainThreadMethod;
        }

        public final String[] c() {
            return this.mainThreadOptMethod;
        }

        public final String[] d() {
            return this.syncMethods;
        }

        public final String[] e() {
            return this.threadOptSchemas;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/cube/experiments/a$b;", "", "", "isThreadOptEnable", "Z", "b", "()Z", "setThreadOptEnable", "(Z)V", "", "", "Lcom/bytedance/locallife/cube/experiments/a$a;", "optConfigs", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setOptConfigs", "(Ljava/util/Map;)V", "", "jsbWithBridgeHook", "[Ljava/lang/String;", "getJsbWithBridgeHook", "()[Ljava/lang/String;", "setJsbWithBridgeHook", "([Ljava/lang/String;)V", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("bdx_bridge_enable_thread_opt")
        private boolean isThreadOptEnable;

        @SerializedName("bdx_bridge_opt_with_out_bridge_hook")
        private String[] jsbWithBridgeHook;

        @SerializedName("bdx_bridge_opt_configs")
        private Map<String, C3651a> optConfigs;

        public b() {
        }

        public final Map<String, C3651a> a() {
            return this.optConfigs;
        }

        public final boolean b() {
            return this.isThreadOptEnable;
        }
    }

    static {
    }
}
