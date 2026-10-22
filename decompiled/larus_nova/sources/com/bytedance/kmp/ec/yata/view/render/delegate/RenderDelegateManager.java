package com.bytedance.kmp.ec.yata.view.render.delegate;

import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.view.render.delegate.v1.SliceYaTaRenderDelegate;
import com.bytedance.kmp.ec.yata.view.render.delegate.v2.SliceYaTaRenderDelegateV2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class RenderDelegateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f252010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<?>, Object> f252011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a> f252012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EmptyViewRenderDelegate f252013d;

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f252012c).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final Map.Entry r101 = (Map.Entry) r100.next();
        ((a) r101.getValue()).destroy();
        String r102 = YaTaLog.f251436a;
        YaTaLog.g("RenderDelegateManager", new RenderDelegateManager$destroy$1$1(r101));
        goto L4
    }

    public RenderDelegateManager(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f252010a = r100;
        this.f252011b = new LinkedHashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        this.f252012c = r101;
        EmptyViewRenderDelegate r102 = new EmptyViewRenderDelegate(r100);
        this.f252013d = r102;
        if (r100.f251820c.f251428d == false) goto L5;
        Object r103 = new SliceYaTaRenderDelegateV2(this, r100);
    L6:
        r101.put("slice", r103);
        r101.put(ViewRenderType.EMPTY, r102);
        return;
    L5:
        r103 = new SliceYaTaRenderDelegate(this, r100);
        goto L6
    }

    public final a b(ba6.b r100) {
        if (r100 != null) goto L7;
        YataErrorManager r101 = this.f252010a.f251821d;
        int r102 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        com.bytedance.kmp.ec.yata.common.error.d r103 = new com.bytedance.kmp.ec.yata.common.error.d(3001, "VIEW_RENDER_NOT_FOUND");
        r103.e();
        r103.c("container_is_null");
        r103.d("渲染引擎异常 container找不到");
        r101.c(r103);
        return this.f252013d;
    L7:
        if (r100.getContainerType().length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        YataErrorManager r105 = this.f252010a.f251821d;
        int r106 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        com.bytedance.kmp.ec.yata.common.error.d r107 = new com.bytedance.kmp.ec.yata.common.error.d(3001, "VIEW_RENDER_NOT_FOUND");
        r107.e();
        r107.c("container.containerType_is_null");
        r107.d("渲染引擎异常  container.container_type为空");
        r105.c(r107);
        return this.f252013d;
    L13:
        int r108 = h.f251540a;
        String r109 = r100.getContainerType();
        Intrinsics.checkNotNullParameter(r109, "content");
        String r110 = r109.toLowerCase(Locale.ROOT);
        a r111 = (a) ((LinkedHashMap) this.f252012c).get(r110);
        if (r111 != null) goto L17;
        YataErrorManager r112 = this.f252010a.f251821d;
        int r113 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        com.bytedance.kmp.ec.yata.common.error.d r114 = new com.bytedance.kmp.ec.yata.common.error.d(3001, "VIEW_RENDER_NOT_FOUND");
        r114.e();
        r114.c("type-" + r110);
        r114.d("渲染引擎异常 " + r110 + "对应的引擎缺失");
        r112.c(r114);
        return this.f252013d;
    L17:
        return r111;
    L9:
        r104 = false;
        goto L10
    }
}
