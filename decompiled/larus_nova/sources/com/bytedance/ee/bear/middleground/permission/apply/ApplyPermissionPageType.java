package com.bytedance.ee.bear.middleground.permission.apply;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "BITABLE_PRO", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ApplyPermissionPageType extends Enum<ApplyPermissionPageType> {
    public static final ApplyPermissionPageType BITABLE_PRO = null;
    public static final ApplyPermissionPageType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyPermissionPageType[] f232882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f232883b = null;

    public static EnumEntries<ApplyPermissionPageType> getEntries() {
        return f232883b;
    }

    static {
        ApplyPermissionPageType r100 = new ApplyPermissionPageType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ApplyPermissionPageType r101 = new ApplyPermissionPageType("BITABLE_PRO", 1);
        BITABLE_PRO = r101;
        ApplyPermissionPageType[] r102 = {r100, r101};
        f232882a = r102;
        f232883b = EnumEntriesKt.enumEntries(r102);
    }

    public static ApplyPermissionPageType[] values() {
        return (ApplyPermissionPageType[]) f232882a.clone();
    }

    public static ApplyPermissionPageType valueOf(String r100) {
        return (ApplyPermissionPageType) r27.a.a(ApplyPermissionPageType.class, r100);
    }

    public ApplyPermissionPageType(String r100, int r101) {
        super(r100, r101);
    }
}
