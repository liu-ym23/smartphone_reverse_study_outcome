package uy7;

import android.content.Context;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tt.refer.common.base.AppType;
import j18.l;
import kotlin.jvm.internal.Intrinsics;
import l18.h;
import vxb.b;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f552151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l f552152x;

    @Override // vxb.b
    public final void c() {
    }

    @Override // com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final AppType getAppType() {
        return AppType.DynamicComponent;
    }

    public final Context getContext() {
        return this.f552151w;
    }

    @Override // vxb.b, com.bytedance.ee.lark.infra.sandbox.context.IAppContext
    public final LKBasePluginResult sendEvent(LKEvent r100) {
        return ((h) this.f552152x).handleEvent(r100);
    }

    public a(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pluginManager");
        super(r100);
        this.f552151w = r100;
        this.f552152x = r101;
    }
}
