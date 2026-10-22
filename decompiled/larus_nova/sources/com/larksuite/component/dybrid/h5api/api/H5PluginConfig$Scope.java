package com.larksuite.component.dybrid.h5api.api;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum H5PluginConfig$Scope extends Enum<H5PluginConfig$Scope> {
    public static final H5PluginConfig$Scope PAGE = null;
    public static final H5PluginConfig$Scope SERVICE = null;
    public static final H5PluginConfig$Scope SESSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H5PluginConfig$Scope[] f283992a = null;

    static {
        H5PluginConfig$Scope r100 = new H5PluginConfig$Scope(HTTP.SERVICE, 0);
        SERVICE = r100;
        H5PluginConfig$Scope r101 = new H5PluginConfig$Scope("SESSION", 1);
        SESSION = r101;
        H5PluginConfig$Scope r102 = new H5PluginConfig$Scope("PAGE", 2);
        PAGE = r102;
        f283992a = new H5PluginConfig$Scope[]{r100, r101, r102};
    }

    public static H5PluginConfig$Scope[] values() {
        return (H5PluginConfig$Scope[]) f283992a.clone();
    }

    public static H5PluginConfig$Scope valueOf(String r100) {
        return (H5PluginConfig$Scope) a.a(H5PluginConfig$Scope.class, r100);
    }

    public H5PluginConfig$Scope(String r100, int r101) {
        super(r100, r101);
    }
}
