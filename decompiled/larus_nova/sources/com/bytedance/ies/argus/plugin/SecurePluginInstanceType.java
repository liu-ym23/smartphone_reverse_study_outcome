package com.bytedance.ies.argus.plugin;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "", "GLOBAL", "CONTAINER", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SecurePluginInstanceType extends Enum<SecurePluginInstanceType> {
    public static final SecurePluginInstanceType CONTAINER = null;
    public static final SecurePluginInstanceType GLOBAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecurePluginInstanceType[] f246079a = null;

    public static SecurePluginInstanceType valueOf(String r100) {
        return (SecurePluginInstanceType) r27.a.a(SecurePluginInstanceType.class, r100);
    }

    public static SecurePluginInstanceType[] values() {
        return (SecurePluginInstanceType[]) f246079a.clone();
    }

    static {
        SecurePluginInstanceType r100 = new SecurePluginInstanceType("GLOBAL", 0);
        GLOBAL = r100;
        SecurePluginInstanceType r101 = new SecurePluginInstanceType("CONTAINER", 1);
        CONTAINER = r101;
        f246079a = new SecurePluginInstanceType[]{r100, r101};
    }

    public SecurePluginInstanceType(String r100, int r101) {
        super(r100, r101);
    }
}
