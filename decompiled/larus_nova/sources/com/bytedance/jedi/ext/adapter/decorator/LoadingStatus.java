package com.bytedance.jedi.ext.adapter.decorator;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/decorator/LoadingStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public @interface LoadingStatus {
    public static final a Companion = null;
    public static final int IDLE = 241;
    public static final int LOADING = 242;
    public static final int LOAD_ERROR = 244;
    public static final int NO_MORE = 243;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f250969a = null;

        public a() {
        }

        static {
            f250969a = new a();
        }
    }

    static {
        Companion = a.f250969a;
    }
}
