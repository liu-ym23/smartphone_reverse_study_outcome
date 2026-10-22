package com.bytedance.applet.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.IHostScanCodeDepend;
import com.bytedance.ai.bridge.service.ScanCodeCallback;
import com.bytedance.ai.bridge.service.ScanCodeRequest;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletHostScanCodeServiceImpl implements IHostScanCodeDepend {
    public final Handler a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.applet.impl.AppletHostScanCodeServiceImpl$scanCode$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(Object r8) {
            super(1, r8, ScanCodeCallback.class, "onFail", "onFail(Ljava/lang/String;)V", 0);
        }

        public final void invoke(String r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            ((ScanCodeCallback) ((CallableReference) this).receiver).onFail(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public AppletHostScanCodeServiceImpl() {
        this.a = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.applet.impl.l0] */
    public final void scanCode(ScanCodeRequest r6, final ScanCodeCallback r7) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "callback");
        List r0 = r6.getScanType();
        boolean r2 = true;
        if (r0.isEmpty() == true) goto L15;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((String) r3.next()).toLowerCase(Locale.US), "qrcode") == false) goto L12;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == true) goto L20;
        r7.onFail("scanType not supported");
        return;
    L20:
        FragmentActivity r5 = r6.getBridgeContext().getOwnerActivity();
        final FragmentActivity r8 = null;
        if ((r5 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r9 = r5;
    L24:
        if (r9 != null) goto L28;
        Activity r10 = AppHost.a.a().getCurrentActivity();
        if ((r10 instanceof FragmentActivity) == false) goto L29;
        r8 = (FragmentActivity) r10;
    L29:
        if (r8 != null) goto L32;
        r7.onFail("scanCode requires a FragmentActivity");
        return;
    L32:
        final IFlowCamera r11 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r11 != null) goto L37;
        r7.onFail("camera service unavailable");
        return;
    L37:
        if (r11.s(Intrinsics.areEqual(r6.getOnlyFromCamera(), Boolean.TRUE), new k0(r7, this), new AnonymousClass2(r7)) == true) goto L40;
        r7.onFail("scanCode is running");
        return;
    L40:
        final ?? r12 = new l0(r8, r11, this);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L43;
        r12.invoke();
    L44:
        if (r2 == true) goto L50;
        r11.h("scanCode post to main thread failed");
        return;
    L50:
        return;
    L43:
        r2 = this.a.post(new m0(r12));
        goto L44
    L28:
        r8 = r9;
        goto L29
    L23:
        r9 = null;
        goto L24
    L8:
        if (r1.isEmpty() == false) goto L10;
    L15:
        r4 = true;
        goto L17
    }
}
