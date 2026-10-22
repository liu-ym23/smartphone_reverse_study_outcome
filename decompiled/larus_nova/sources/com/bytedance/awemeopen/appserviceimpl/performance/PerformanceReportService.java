package com.bytedance.awemeopen.appserviceimpl.performance;

import com.bytedance.awemeopen.infra.base.event.b;
import com.bytedance.awemeopen.infra.base.event.d;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import d34.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class PerformanceReportService implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198140a;

    @Override // k24.a
    public final void x0() {
    }

    @Override // n24.a
    public final void f() {
        ((e44.a) this.f198140a.getValue()).getClass();
    }

    public PerformanceReportService() {
        this.f198140a = LazyKt.lazy(PerformanceReportService$performanceReportDomain$2.INSTANCE);
    }

    @Override // d34.a
    public final void F2(String r100, Map<String, Object> r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        ((e44.a) this.f198140a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b.C2872b r103 = b.a(r100);
        Iterator r104 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.d((String) r105.getKey(), r105.getValue());
        goto L4
    L6:
        r103.c(r102, null).b();
    }

    @Override // d34.a
    public final void i1(String r110, String r111, long r112, int r210, int r211, String r212, String r213, String r214, String r215, String r216, Map<String, Object> r217, d r218) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "firstFrameFrom");
        Intrinsics.checkNotNullParameter(r212, "authorId");
        Intrinsics.checkNotNullParameter(r213, "groupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "fromGroupId");
        Intrinsics.checkNotNullParameter(r216, "awemeType");
        ((e44.a) this.f198140a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "firstFrameFrom");
        Intrinsics.checkNotNullParameter(r212, "authorId");
        Intrinsics.checkNotNullParameter(r213, "groupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "fromGroupId");
        Intrinsics.checkNotNullParameter(r216, "awemeType");
        b.C2872b r100 = b.a(PortraitEngine.LABEL_FIRST_FRAME);
        r100.d("enter_from", r110);
        r100.d("first_frame_from", r111);
        r100.d(IVideoEventLogger.LOG_CALLBACK_FIRST_FRAME_COST, Long.valueOf(r112));
        r100.d("is_first_video", Integer.valueOf(r210));
        r100.d("first_frame_position", Integer.valueOf(r211));
        r100.d("author_openid", r212);
        r100.d("group_id", r213);
        r100.d("impr_id", r214);
        r100.d("aweme_type", r216);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r215);
        if (r217 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r101 = r217.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, Object> r102 = r101.next();
        r100.d(r102.getKey(), r102.getValue());
    L8:
        r100.c(r218, null).b();
    }
}
