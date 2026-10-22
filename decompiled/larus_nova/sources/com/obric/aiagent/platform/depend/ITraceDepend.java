package com.obric.aiagent.platform.depend;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s9a.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&JU\u0010\u000f\u001a\u00020\u00032K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0011H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\u001c\u0010\u0019\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/platform/depend/ITraceDepend;", "", "report", "", "event", "", "params", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "enableETVerify", "getSessionId", "getDeviceId", "getInstallId", "getSsid", "awaitTraceId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", com.bytedance.android.ec.core.event.a.KEY_DID, WsConstants.KEY_INSTALL_ID, "ssid", "getUserID", "getUUID", "addCommonParams", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITraceDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f385002a = null;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J(\u0010\u0016\u001a\u00020\n2\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/platform/depend/ITraceDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/ITraceDepend;", "impl$delegate", "Lkotlin/Lazy;", "report", "", "event", "", "params", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "enableETVerify", "getSessionId", "getDeviceId", "getInstallId", "getSsid", "awaitTraceId", "callback", "Lkotlin/Function3;", "getUserID", "getUUID", "addCommonParams", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ITraceDepend {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f385003b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<ITraceDepend> f385004c = null;

        private Companion() {
        }

        static {
            f385003b = new Companion();
            f385004c = LazyKt.lazy(new d());
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public final void a(Bundle r100) {
            Intrinsics.checkNotNullParameter("ipc_anomaly", "event");
            Intrinsics.checkNotNullParameter(r100, "bundleParams");
            ITraceDepend r101 = f385004c.getValue();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    static {
        f385002a = Companion.f385003b;
    }

    void a(Bundle r100);
}
