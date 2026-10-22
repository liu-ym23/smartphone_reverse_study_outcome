package com.larus.home.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.doc.api.IDocService;
import com.larus.office.base.preview.OfficePreviewType;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.container.api.IOfficeContainerService;
import com.larus.platform.api.e3;
import com.larus.platform.api.q4;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class x1 implements e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f346268a = null;

    static {
        f346268a = new x1();
    }

    public x1() {
    }

    public final String e() {
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L6;
        String r101 = r100.x0();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final JSONObject g() {
        gd9.i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        Activity r101 = r100.a().e();
        if ((r101 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r102 = (AppCompatActivity) r101;
    L6:
        if (r102 == null) goto L23;
        FragmentManager r103 = r102.getSupportFragmentManager();
        if (r103 == null) goto L23;
        List<Fragment> r104 = r103.getFragments();
        if (r104 == null) goto L23;
        Fragment r105 = (Fragment) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L23;
        IOfficeContainerService r106 = (IOfficeContainerService) ServiceManager.get().getService(IOfficeContainerService.class);
        if (r106 == null) goto L16;
        wn9.a r107 = r106.e();
        if (r107 != r105) goto L21;
        return r107.getTraceInfo();
    L21:
        return new JSONObject();
    L16:
        return new JSONObject();
    L23:
        return new JSONObject();
    L5:
        r102 = null;
        goto L6
    }

    public final void p() {
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L6;
        r100.r0();
        return;
    }

    public final q4 f() {
        return kc9.f.a();
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return true;
    L10:
        IOfficeSdkServiceV2 r103 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L26;
        IDocService r105 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r105 != null) goto L20;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L25;
        return false;
    L25:
        return true;
    L20:
        if (r105.ba(r100) != true) goto L22;
        r106 = true;
        goto L23
    L26:
        return false;
    L13:
        if (r103.l0(r100) != true) goto L15;
        r104 = true;
        goto L16
    L5:
        if (r101.A0(r100) != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.v0(r100);
        return;
    }

    @Override // com.larus.platform.api.e3
    public final boolean d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.d0(r100) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        com.larus.office.base.preview.c r101 = com.larus.office.base.preview.c.f361026a;
        OfficePreviewType r102 = OfficePreviewType.UNKNOWN;
        r101.getClass();
        return com.larus.office.base.preview.c.d(r100, r102);
    }

    public final void k(boolean r100) {
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.y0(r100);
        return;
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.m0(r100);
        return;
    }

    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.j0(r100);
        return;
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IOfficeSdkServiceV2 r101 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r101 == null) goto L6;
        r101.u0(r100);
        return;
    }

    public final Fragment c(Fragment r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r101, "arguments");
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.t0(r100, r101);
    }

    public final void d(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r102, r100, r101, 4);
        return;
    }

    public final void h(String r100, uo9.h r101) {
        Intrinsics.checkNotNullParameter(r100, "originPath");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L6;
        r102.p0(r100, r101);
        return;
    }

    public final void i(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L20
        boolean r103 = true;
        if (r102 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L11;
        r102.g0(r100, r101);     // Catch: Exception -> L20
        return;
    L11:
        if (r102 != null) goto L13;
    L15:
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r102.B0(r101);     // Catch: Exception -> L20
        return;
    L18:
        FLogger.f375446a.e("SdkOfficeServiceImpl", "Not feishu applink or office suite url, open failed");     // Catch: Exception -> L20
        return;
    L13:
        if (r102.l0(r101) != true) goto L15;
    L6:
        if (r102.A0(r101) != true) goto L8;
        r104 = true;
    L20:
        e = move-exception;
        FLogger.f375446a.e("SdkOfficeServiceImpl", "Open feishu link failed: " + e.getMessage(), e);
    }

    public final Object m(String r100, Long r101, String r110, String r111, Continuation<? super Unit> r112) {
        IOfficeSdkServiceV2 r102 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r102 == null) goto L10;
        Object r103 = r102.k0(r100, r101, r110, r111, r112);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}
