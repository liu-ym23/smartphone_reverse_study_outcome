package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends BaseModel implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cqb.a f431364b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cqb.a f431365a;

    static {
        f431364b = new cqb.a(39.908823d, 116.39747d);
    }

    public g() {
        this.f431365a = f431364b;
    }

    @Override // com.ss.android.lark.locationmessage.ui.navigation.b
    public final boolean isAdminGpsEnabled() {
        return com.ss.android.lark.location.service.f.a().isAdminGpsEnabled();
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
    }

    @Override // com.ss.android.lark.locationmessage.ui.navigation.b
    public final void S(Context r100, Token r101, Scene r102, u r110) {
        f r103 = new f(this, r110);
        LocationRequestOption r104 = new LocationRequestOption();
        com.ss.android.lark.location.service.f.a().getLocationWithOption(r100, r104, r101, r102, r103);
    }
}
