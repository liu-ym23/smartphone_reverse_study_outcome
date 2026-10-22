package com.bytedance.ee.bear.middleground.permission.apply;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "AUDIT_CONTROL", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ApplyPermissionPageMode extends Enum<ApplyPermissionPageMode> {
    public static final ApplyPermissionPageMode AUDIT_CONTROL = null;
    public static final ApplyPermissionPageMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyPermissionPageMode[] f232880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f232881b = null;

    public static EnumEntries<ApplyPermissionPageMode> getEntries() {
        return f232881b;
    }

    static {
        ApplyPermissionPageMode r100 = new ApplyPermissionPageMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ApplyPermissionPageMode r101 = new ApplyPermissionPageMode("AUDIT_CONTROL", 1);
        AUDIT_CONTROL = r101;
        ApplyPermissionPageMode[] r102 = {r100, r101};
        f232880a = r102;
        f232881b = EnumEntriesKt.enumEntries(r102);
    }

    public static ApplyPermissionPageMode[] values() {
        return (ApplyPermissionPageMode[]) f232880a.clone();
    }

    public static ApplyPermissionPageMode valueOf(String r100) {
        return (ApplyPermissionPageMode) r27.a.a(ApplyPermissionPageMode.class, r100);
    }

    public ApplyPermissionPageMode(String r100, int r101) {
        super(r100, r101);
    }
}
