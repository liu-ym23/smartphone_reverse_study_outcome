package com.bytedance.kmp.ec.yata.chain.event;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/ec/yata/chain/event/EventControlFlowType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "yata-chain-kmp_release"}, k = 1, mv = {1, 7, 0})
public @interface EventControlFlowType {
    public static final String BLOCK = "block";
    public static final String CANCEL_FAILED = "cancel_failed";
    public static final String CANCEL_SUCCESS = "cancel_success";
    public static final a Companion = null;
    public static final String EMPTY = "empty";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f251279a = null;

        static {
            f251279a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f251279a;
    }
}
