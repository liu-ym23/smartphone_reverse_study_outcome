package com.larus.shortcuts.api;

import com.larus.platform.api.IShortcutPlatformService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J8\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/shortcuts/api/ShortcutPlatfomServiceImpl;", "Lcom/larus/platform/api/IShortcutPlatformService;", "<init>", "()V", "addDynamicShortcut", "", "canShowCamera", "", "canShowRealtime", "cvsID", "", "refreshDynamicShortcut", "snapshotDynamicShortcutConfig", "clearDynamicShortcut", "tryAddPinShortcut", "cvsName", "iconUrl", "isCallBot", "eventJson", "Lorg/json/JSONObject;", "tryDisablePinShortcut", "cvsdID", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShortcutPlatfomServiceImpl implements IShortcutPlatformService {
    public ShortcutPlatfomServiceImpl() {
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void b() {
        IShortcutsService r100 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void d() {
        IShortcutsService r100 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void e() {
        IShortcutsService r100 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsdID");
        IShortcutsService r101 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void s0(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "cvsID");
        IShortcutsService r103 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r103 == null) goto L6;
        r103.s0(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.IShortcutPlatformService
    public final void c(String r100, String r101, String r110, boolean r111, JSONObject r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        if (r110 != null) goto L8;
        return;
    L8:
        IShortcutsService r102 = (IShortcutsService) ServiceManager.get().getService(IShortcutsService.class);
        if (r102 == null) goto L12;
        r102.c(r100, r101, r110, r111, r112);
        return;
    }
}
