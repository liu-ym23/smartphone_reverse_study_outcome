package com.larus.dora.impl.nl.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/nl/permission/ProactivePermission;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFICATION_LISTENER", "POST_NOTIFICATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactivePermission extends Enum<ProactivePermission> {
    public static final ProactivePermission NOTIFICATION_LISTENER = null;
    public static final ProactivePermission POST_NOTIFICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactivePermission[] f336386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336387b = null;

    public static EnumEntries<ProactivePermission> getEntries() {
        return f336387b;
    }

    static {
        ProactivePermission r100 = new ProactivePermission("NOTIFICATION_LISTENER", 0);
        NOTIFICATION_LISTENER = r100;
        ProactivePermission r101 = new ProactivePermission("POST_NOTIFICATION", 1);
        POST_NOTIFICATION = r101;
        ProactivePermission[] r102 = {r100, r101};
        f336386a = r102;
        f336387b = EnumEntriesKt.enumEntries(r102);
    }

    public static ProactivePermission[] values() {
        return (ProactivePermission[]) f336386a.clone();
    }

    public static ProactivePermission valueOf(String r100) {
        return (ProactivePermission) a.a(ProactivePermission.class, r100);
    }

    public ProactivePermission(String r100, int r101) {
        super(r100, r101);
    }
}
