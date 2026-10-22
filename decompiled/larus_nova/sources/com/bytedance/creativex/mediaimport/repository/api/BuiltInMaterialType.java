package com.bytedance.creativex.mediaimport.repository.api;

import com.obric.miniapp.alarm.AccountType;
import ki4.a0;
import ki4.e0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/BuiltInMaterialType;", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialSourceType;", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO", "IMAGE", AccountType.ALL, "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BuiltInMaterialType extends Enum<BuiltInMaterialType> implements e0, a0 {
    public static final BuiltInMaterialType ALL = null;
    public static final BuiltInMaterialType IMAGE = null;
    public static final BuiltInMaterialType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuiltInMaterialType[] f203611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203612b = null;

    public static EnumEntries<BuiltInMaterialType> getEntries() {
        return f203612b;
    }

    static {
        BuiltInMaterialType r100 = new BuiltInMaterialType("VIDEO", 0);
        VIDEO = r100;
        BuiltInMaterialType r101 = new BuiltInMaterialType("IMAGE", 1);
        IMAGE = r101;
        BuiltInMaterialType r102 = new BuiltInMaterialType(AccountType.ALL, 2);
        ALL = r102;
        BuiltInMaterialType[] r103 = {r100, r101, r102};
        f203611a = r103;
        f203612b = EnumEntriesKt.enumEntries(r103);
    }

    public static BuiltInMaterialType[] values() {
        return (BuiltInMaterialType[]) f203611a.clone();
    }

    public static BuiltInMaterialType valueOf(String r100) {
        return (BuiltInMaterialType) r27.a.a(BuiltInMaterialType.class, r100);
    }

    public BuiltInMaterialType(String r100, int r101) {
        super(r100, r101);
    }
}
