package com.bytedance.ies.xelement;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xelement/XElementInitializerLite;", "", "Lcom/bytedance/ies/xelement/XElementConfigLite;", "localConfig", "Lcom/bytedance/ies/xelement/XElementConfigLite;", "value", "getConfig", "()Lcom/bytedance/ies/xelement/XElementConfigLite;", "setConfig", "(Lcom/bytedance/ies/xelement/XElementConfigLite;)V", "config", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-video_release"}, k = 1, mv = {1, 6, 0})
public final class XElementInitializerLite {
    public static final a Companion = null;
    private static final Lazy<XElementInitializerLite> instance$delegate = null;
    private XElementConfigLite localConfig;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ XElementInitializerLite(DefaultConstructorMarker r100) {
        this();
    }

    static {
        Companion = new a();
        instance$delegate = LazyKt.lazy(XElementInitializerLite$Companion$instance$2.INSTANCE);
    }

    public final XElementConfigLite getConfig() {
        XElementConfigLite r100 = this.localConfig;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("localConfig");
        return null;
    L6:
        return r100;
    }

    private XElementInitializerLite() {
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public final void setConfig(XElementConfigLite r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.localConfig = r100;
    }
}
