package com.larus.mirabridge.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/mirabridge/api/bean/PluginLoadResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "INTERNAL_ERROR", "NETWORK_ERROR", "CANCEL_BY_USER", "IN_PLUGIN_BLACK_LIST", "NOT_INTERFACE", "NOT_REGISTER", "SERVICE_CONSTRUCTOR_ERROR", "SERVICE_TYPE_ERROR", "SERVICE_CLASS_NOT_FOUND", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PluginLoadResult extends Enum<PluginLoadResult> {
    public static final PluginLoadResult CANCEL_BY_USER = null;
    public static final PluginLoadResult INTERNAL_ERROR = null;
    public static final PluginLoadResult IN_PLUGIN_BLACK_LIST = null;
    public static final PluginLoadResult NETWORK_ERROR = null;
    public static final PluginLoadResult NOT_INTERFACE = null;
    public static final PluginLoadResult NOT_REGISTER = null;
    public static final PluginLoadResult SERVICE_CLASS_NOT_FOUND = null;
    public static final PluginLoadResult SERVICE_CONSTRUCTOR_ERROR = null;
    public static final PluginLoadResult SERVICE_TYPE_ERROR = null;
    public static final PluginLoadResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginLoadResult[] f359315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359316b = null;

    public static EnumEntries<PluginLoadResult> getEntries() {
        return f359316b;
    }

    static {
        PluginLoadResult r100 = new PluginLoadResult("SUCCESS", 0);
        SUCCESS = r100;
        PluginLoadResult r101 = new PluginLoadResult("INTERNAL_ERROR", 1);
        INTERNAL_ERROR = r101;
        PluginLoadResult r102 = new PluginLoadResult("NETWORK_ERROR", 2);
        NETWORK_ERROR = r102;
        PluginLoadResult r103 = new PluginLoadResult("CANCEL_BY_USER", 3);
        CANCEL_BY_USER = r103;
        PluginLoadResult r104 = new PluginLoadResult("IN_PLUGIN_BLACK_LIST", 4);
        IN_PLUGIN_BLACK_LIST = r104;
        PluginLoadResult r105 = new PluginLoadResult("NOT_INTERFACE", 5);
        NOT_INTERFACE = r105;
        PluginLoadResult r110 = new PluginLoadResult("NOT_REGISTER", 6);
        NOT_REGISTER = r110;
        PluginLoadResult r111 = new PluginLoadResult("SERVICE_CONSTRUCTOR_ERROR", 7);
        SERVICE_CONSTRUCTOR_ERROR = r111;
        PluginLoadResult r112 = new PluginLoadResult("SERVICE_TYPE_ERROR", 8);
        SERVICE_TYPE_ERROR = r112;
        PluginLoadResult r113 = new PluginLoadResult("SERVICE_CLASS_NOT_FOUND", 9);
        SERVICE_CLASS_NOT_FOUND = r113;
        PluginLoadResult[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f359315a = r114;
        f359316b = EnumEntriesKt.enumEntries(r114);
    }

    public static PluginLoadResult[] values() {
        return (PluginLoadResult[]) f359315a.clone();
    }

    public static PluginLoadResult valueOf(String r100) {
        return (PluginLoadResult) a.a(PluginLoadResult.class, r100);
    }

    public PluginLoadResult(String r100, int r101) {
        super(r100, r101);
    }
}
