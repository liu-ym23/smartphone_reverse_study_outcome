package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.ies.bullet.prefetchv2.z;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class o implements com.bytedance.ies.bullet.prefetchv2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f278449a = null;

    public static final class a implements te7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f278450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.ies.bullet.prefetchv2.d.a f278451b;

        public a(String r100, z.d r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f278450a = r100;
            this.f278451b = r101;
        }

        @Override // te7.a
        public final void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
            Intrinsics.checkNotNullParameter(r101, "responseHeader");
            com.bytedance.ies.bullet.prefetchv2.d.a r104 = this.f278451b;
            com.bytedance.ies.bullet.prefetchv2.d.b r105 = new com.bytedance.ies.bullet.prefetchv2.d.b();
            if (r102 == null) goto L5;
            int r106 = r102.intValue();
        L6:
            r105.f247523d = r106;
            r105.f247521b = r100.toString();
            r105.f247522c = r101;
            r104.b(r105);
            return;
        L5:
            r106 = -1;
            goto L6
        }

        @Override // te7.a
        public final void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r102, int r103) {
            Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
            Map<Class<?>, ox7.a> r104 = ox7.b.f527091a;
            ox7.b.b("IvyPrefetchNetworkExecutor", "onFailed throwable, url: " + this.f278450a, r102);
            this.f278451b.a(r102);
        }

        @Override // te7.a
        public final Unit b(JSONObject r100, LinkedHashMap r101, String r102, Throwable r103, Integer r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
            Intrinsics.checkNotNullParameter(r101, "responseHeader");
            Intrinsics.checkNotNullParameter(r102, "rawResponse");
            Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
            Map<Class<?>, ox7.a> r106 = ox7.b.f527091a;
            ox7.b.b("IvyPrefetchNetworkExecutor", "onParsingFailed url: " + this.f278450a + ", statusCode: " + r104 + ", clientCode: " + r105, null);
            ox7.b.b("IvyPrefetchNetworkExecutor", "onParsingFailed throwable", r103);
            com.bytedance.ies.bullet.prefetchv2.d.a r107 = this.f278451b;
            com.bytedance.ies.bullet.prefetchv2.d.b r108 = new com.bytedance.ies.bullet.prefetchv2.d.b();
            if (r104 == null) goto L5;
            int r109 = r104.intValue();
        L6:
            r108.f247523d = r109;
            r108.f247521b = r100.toString();
            r108.f247522c = r101;
            r107.b(r108);
            return Unit.INSTANCE;
        L5:
            r109 = -1;
            goto L6
        }
    }

    static {
        f278449a = new o();
    }

    public o() {
    }

    @Override // com.bytedance.ies.bullet.prefetchv2.d
    public final void a(String r100, Map r101, boolean r102, z.d r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r103, "callback");
        XBaseRuntime.f270095a.getClass();
        IHostNetworkDepend r104 = XBaseRuntime.f270104j;
        if (r104 != null) goto L6;
        Map<Class<?>, ox7.a> r105 = ox7.b.f527091a;
        ox7.b.b("IvyPrefetchNetworkExecutor", "HostNetworkDepend is null", null);
        r103.a(new Exception("HostNetworkDepend is null"));
        return;
    L6:
        te7.e r106 = te7.e.f545589a;
        a r107 = new a(r100, r103);
        r106.getClass();
        te7.e.h(r100, r101, r107, r104, r102);
    }

    @Override // com.bytedance.ies.bullet.prefetchv2.d
    public final void b(String r100, Map r110, String r111, JSONObject r112, boolean r113, z.d r114) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r110, "headers");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r112, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r114, "callback");
        XBaseRuntime.f270095a.getClass();
        IHostNetworkDepend r101 = XBaseRuntime.f270104j;
        if (r101 != null) goto L6;
        Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
        ox7.b.b("IvyPrefetchNetworkExecutor", "HostNetworkDepend is null", null);
        r114.a(new Exception("HostNetworkDepend is null"));
        return;
    L6:
        te7.e r103 = te7.e.f545589a;
        a r104 = new a(r100, r114);
        r103.getClass();
        te7.e.m(r100, r110, r111, r112, r104, r101, r113);
    }
}
