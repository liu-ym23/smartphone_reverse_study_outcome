package com.bytedance.ee.bear.quoto.cta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/cta/DriveCTAQuotaConfig;", "", "featureKey", "", "scene", "checkpointTenantId", "checkpointUserId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeatureKey", "()Ljava/lang/String;", "getScene", "getCheckpointTenantId", "setCheckpointTenantId", "(Ljava/lang/String;)V", "getCheckpointUserId", "setCheckpointUserId", "EXCEED_TENANT_QUOTA", "UNI_STORAGE_EXCEED_TENANT_QUOTA", "A2_LICENSE_EXCEED_TENANT_QUOTA", "withCheckPoint", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveCTAQuotaConfig extends Enum<DriveCTAQuotaConfig> {
    public static final DriveCTAQuotaConfig A2_LICENSE_EXCEED_TENANT_QUOTA = null;
    public static final DriveCTAQuotaConfig EXCEED_TENANT_QUOTA = null;
    public static final DriveCTAQuotaConfig UNI_STORAGE_EXCEED_TENANT_QUOTA = null;
    public static final /* synthetic */ DriveCTAQuotaConfig[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private String checkpointTenantId;
    private String checkpointUserId;
    private final String featureKey;
    private final String scene;

    public DriveCTAQuotaConfig() {
        throw null;
    }

    public static EnumEntries<DriveCTAQuotaConfig> getEntries() {
        return b;
    }

    static {
        DriveCTAQuotaConfig r9 = new DriveCTAQuotaConfig("EXCEED_TENANT_QUOTA", 0, "drive_storage_limit", "scene_Upload_drive_storage_limit", null, null, 12, null);
        EXCEED_TENANT_QUOTA = r9;
        DriveCTAQuotaConfig r0 = new DriveCTAQuotaConfig("UNI_STORAGE_EXCEED_TENANT_QUOTA", 1, "unified_storage_limit", "scene_limit_unified_storage_limit", null, null, 12, null);
        UNI_STORAGE_EXCEED_TENANT_QUOTA = r0;
        DriveCTAQuotaConfig r1 = new DriveCTAQuotaConfig("A2_LICENSE_EXCEED_TENANT_QUOTA", 2, "doc_create_limit", "scene_a2_license_limit", null, null, 12, null);
        A2_LICENSE_EXCEED_TENANT_QUOTA = r1;
        DriveCTAQuotaConfig[] r2 = {r9, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static DriveCTAQuotaConfig[] values() {
        return (DriveCTAQuotaConfig[]) a.clone();
    }

    public final String getCheckpointTenantId() {
        return this.checkpointTenantId;
    }

    public final String getCheckpointUserId() {
        return this.checkpointUserId;
    }

    public final String getFeatureKey() {
        return this.featureKey;
    }

    public final String getScene() {
        return this.scene;
    }

    public static DriveCTAQuotaConfig valueOf(String r1) {
        return (DriveCTAQuotaConfig) a.a(DriveCTAQuotaConfig.class, r1);
    }

    public final void setCheckpointTenantId(String r1) {
        this.checkpointTenantId = r1;
    }

    public final void setCheckpointUserId(String r1) {
        this.checkpointUserId = r1;
    }

    public final DriveCTAQuotaConfig withCheckPoint(String r1, String r2) {
        this.checkpointTenantId = r1;
        this.checkpointUserId = r2;
        return this;
    }

    public static /* synthetic */ DriveCTAQuotaConfig withCheckPoint$default(DriveCTAQuotaConfig r1, String r2, String r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = null;
    L10:
        return r1.withCheckPoint(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withCheckPoint");
    }

    public DriveCTAQuotaConfig(String r2, int r3, String r4, String r5, String r6, String r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 8) == 0) goto L8;
        r7 = null;
    L8:
        super(r2, r3);
        this.featureKey = r4;
        this.scene = r5;
        this.checkpointTenantId = r6;
        this.checkpointUserId = r7;
    }
}
