package com.ss.android.lark.integrator.security.compliance.screen_audit;

import com.bytedance.android.livehostapi.business.IHostShare;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.CommonDrawer;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.Extend;
import com.ss.android.lark.pb.security_event.RenderItem;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.auditsdk.screen.d {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.screen_audit.a$a, reason: collision with other inner class name */
    public static final class C5074a {
    }

    static {
    }

    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.auditsdk.screen.d
    public final void a() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        int r100 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
        d("recording", c(com.ss.android.lark.auditsdk.wrapper.a.C4763a.b()));
    }

    @Override // com.ss.android.lark.auditsdk.screen.d
    public final void b() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        int r100 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
        d(IHostShare.ShareType.SCREENSHOT, c(com.ss.android.lark.auditsdk.wrapper.a.C4763a.c()));
    }

    public static Event.Builder c(Event.Builder r100) {
        RenderItem r101 = new RenderItem.Builder().Key("source").Value("1").build();
        CommonDrawer r102 = new CommonDrawer.Builder().ItemList(CollectionsKt.listOf(r101)).build();
        return r100.Extend(new Extend.Builder().CommonDrawer(r102).build());
    }

    public static void d(String r100, Event.Builder r101) {
        owa.a.a().getClass();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r101, "builder");     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b.d.f409722a.a(r101);     // Catch: Throwable -> L5
        Log.i("OfficeSDKScreenAudit", "audit posted, type=".concat(r100));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "audit post failed, type=".concat(r100), th);
    }
}
