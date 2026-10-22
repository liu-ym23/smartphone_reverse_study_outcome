package com.obric.aiagent.product.platform.api.rom;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.Metadata;
import kotlin.Unit;
import v9a.f;
import y9a.a;
import y9a.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/product/platform/api/rom/RomInfo;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "TAG", "", "instance", "tryInit", "", "getDeviceBrand", "getDeviceModel", "getOSVersion", "getShortOSVersion", "getOSReleaseDate", "", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getFwkApiVersion", "useAssistantApi", "", "getRomReleaseRegion", "getRomBuildType", "isOautoModelPreinstalled", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isUTRom", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RomInfo implements IRomInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RomInfo f385011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IRomInfo f385012b = null;

    private RomInfo() {
    }

    static {
        f385011a = new RomInfo();
    L16:
        th = move-exception;
        ILogDepend.f384986a.e("RomInfo", "init RomInfo failed", th);
    L18:
        IRomInfo r100 = (IRomInfo) ServiceManager.get().getService(IRomInfo.class, false);
        f385012b = r100;
        ILogDepend.f384986a.i("RomInfo", "RomInfo instance: " + r100);
        return;
    L4:
        if (f.f553878h.a().b() == true) goto L24;
        ServiceManager.get().bind(IRomInfo.class, new SingletonProvider(new b()));     // Catch: Throwable -> L12
    L14:
        ILogDepend.f384986a.i("RomInfo", "bind RomInfo isOs=" + f.f553878h.a().b());     // Catch: Throwable -> L16
        goto L18
    L12:
        th = move-exception;
        ILogDepend.f384986a.e("RomInfo", "bind PublicRomInfoImpl failed", th);     // Catch: Throwable -> L16
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L16
        goto L14
    L24:
        ServiceManager.get().bind(IRomInfo.class, new SingletonProvider(new a()));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ILogDepend.f384986a.e("RomInfo", "bind PacificRomInfoImpl failed", th);     // Catch: Throwable -> L16
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
        goto L14
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String a() {
        IRomInfo r100 = f385012b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String b() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int c() {
        IRomInfo r100 = f385012b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.c();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean d() {
        IRomInfo r100 = f385012b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean e() {
        IRomInfo r100 = f385012b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String f() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.f();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String g() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.g();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceBrand() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.getDeviceBrand();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceModel() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.getDeviceModel();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getOSVersion() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        String r101 = r100.getOSVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int h() {
        IRomInfo r100 = f385012b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.h();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final void i() {
        IRomInfo r100 = f385012b;
        if (r100 == null) goto L6;
        r100.i();
        return;
    }
}
