package com.ss.android.lark.officesdk.di.core;

import com.larus.network.http.ServiceType;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/DependencyContextUniqueId;", "", "<init>", "(Ljava/lang/String;I)V", "Global", "OfficeWebView", ChameleonResConstants.WEBCONAINER_ROOT_DIR, ServiceType.DOC, "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DependencyContextUniqueId extends Enum<DependencyContextUniqueId> {
    public static final DependencyContextUniqueId Chameleon = null;
    public static final DependencyContextUniqueId Doc = null;
    public static final DependencyContextUniqueId Global = null;
    public static final DependencyContextUniqueId OfficeWebView = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DependencyContextUniqueId[] f433170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433171b = null;

    public static EnumEntries<DependencyContextUniqueId> getEntries() {
        return f433171b;
    }

    static {
        DependencyContextUniqueId r100 = new DependencyContextUniqueId("Global", 0);
        Global = r100;
        DependencyContextUniqueId r101 = new DependencyContextUniqueId("OfficeWebView", 1);
        OfficeWebView = r101;
        DependencyContextUniqueId r102 = new DependencyContextUniqueId(ChameleonResConstants.WEBCONAINER_ROOT_DIR, 2);
        Chameleon = r102;
        DependencyContextUniqueId r103 = new DependencyContextUniqueId(ServiceType.DOC, 3);
        Doc = r103;
        DependencyContextUniqueId[] r104 = {r100, r101, r102, r103};
        f433170a = r104;
        f433171b = EnumEntriesKt.enumEntries(r104);
    }

    public static DependencyContextUniqueId[] values() {
        return (DependencyContextUniqueId[]) f433170a.clone();
    }

    public static DependencyContextUniqueId valueOf(String r100) {
        return (DependencyContextUniqueId) r27.a.a(DependencyContextUniqueId.class, r100);
    }

    public DependencyContextUniqueId(String r100, int r101) {
        super(r100, r101);
    }
}
