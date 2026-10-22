package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s26.a f247146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u26.d f247147b;

    public com.bytedance.ies.bullet.service.base.j b() {
        return null;
    }

    public String e() {
        return null;
    }

    public void g(LynxViewBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewBuilder");
    }

    public BulletContext getContext() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
    }

    public void j(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public abstract t36.j k(String r100, String r101);

    public abstract List<com.lynx.tasm.behavior.a> l();

    public abstract h m();

    public n n() {
        return null;
    }

    public TemplateData o() {
        return null;
    }

    public void p(com.bytedance.ies.bullet.service.base.o r100) {
        Intrinsics.checkNotNullParameter(r100, "kitViewService");
    }

    public void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public Map<String, g26.c> c() {
        return new LinkedHashMap();
    }

    public Map<String, Object> d() {
        return new LinkedHashMap();
    }

    public final Map<String, Object> f() {
        Map<String, Object> r100 = PropsUtilsKt.getDeviceProps(KitType.LYNX, com.bytedance.ies.bullet.lynx.init.h.f247352a.getContext(), getContext());
        if (r100 != null) goto L5;
        r100 = new LinkedHashMap();
    L5:
        r100.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());
        r100.putAll(d());
        return r100;
    }

    public a(s26.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f247146a = r100;
    }
}
