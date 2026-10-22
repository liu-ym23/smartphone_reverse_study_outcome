package com.ivy.ivykit.plugin.impl.jsb;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a implements u26.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KitType f278378a;

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void b(String r100, com.bytedance.ies.bullet.service.base.p r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void c() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void f(byte[] r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "templateArray");
        Intrinsics.checkNotNullParameter(r101, "baseUrl");
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void g() {
    }

    @Override // u26.d, v06.a, com.bytedance.ies.bullet.service.base.o
    public abstract /* synthetic */ q26.j getContext();

    @Override // com.bytedance.ies.bullet.service.base.o
    public String getSessionId() {
        return null;
    }

    @Override // u26.d
    public final void h(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void m() {
    }

    @Override // v06.a
    public final void n(String r100, com.bytedance.ies.bullet.core.q r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "lifeCycle");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void onHide() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void onShow() {
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public View realView() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalprops");
    }

    @Override // u26.d
    public final void updateScreenMetrics(int r100, int r101) {
    }

    public a() {
        this.f278378a = KitType.LYNX;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final KitType getKitType() {
        return this.f278378a;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final SccConfig.SccLevel i() {
        return SccConfig.SccLevel.SAFE;
    }

    @Override // com.bytedance.ies.bullet.service.base.o
    public final boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return true;
    }
}
