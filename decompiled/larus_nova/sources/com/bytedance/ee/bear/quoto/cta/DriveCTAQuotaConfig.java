package com.bytedance.ee.bear.quoto.cta;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/quoto/cta/DriveCTAQuotaConfig;", "", "featureKey", "", "scene", "checkpointTenantId", "checkpointUserId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeatureKey", "()Ljava/lang/String;", "getScene", "getCheckpointTenantId", "setCheckpointTenantId", "(Ljava/lang/String;)V", "getCheckpointUserId", "setCheckpointUserId", "EXCEED_TENANT_QUOTA", "UNI_STORAGE_EXCEED_TENANT_QUOTA", "A2_LICENSE_EXCEED_TENANT_QUOTA", "withCheckPoint", "features-quoto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveCTAQuotaConfig extends Enum<DriveCTAQuotaConfig> {
    public static final DriveCTAQuotaConfig A2_LICENSE_EXCEED_TENANT_QUOTA = null;
    public static final DriveCTAQuotaConfig EXCEED_TENANT_QUOTA = null;
    public static final DriveCTAQuotaConfig UNI_STORAGE_EXCEED_TENANT_QUOTA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveCTAQuotaConfig[] f236343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236344b = null;
    private String checkpointTenantId;
    private String checkpointUserId;
    private final String featureKey;
    private final String scene;

    public DriveCTAQuotaConfig() {
        throw null;
    }

    public static EnumEntries<DriveCTAQuotaConfig> getEntries() {
        return f236344b;
    }

    static {
        DriveCTAQuotaConfig r100 = new DriveCTAQuotaConfig("EXCEED_TENANT_QUOTA", 0, "drive_storage_limit", "scene_Upload_drive_storage_limit", null, null, 12, null);
        EXCEED_TENANT_QUOTA = r100;
        DriveCTAQuotaConfig r101 = new DriveCTAQuotaConfig("UNI_STORAGE_EXCEED_TENANT_QUOTA", 1, "unified_storage_limit", "scene_limit_unified_storage_limit", null, null, 12, null);
        UNI_STORAGE_EXCEED_TENANT_QUOTA = r101;
        DriveCTAQuotaConfig r102 = new DriveCTAQuotaConfig("A2_LICENSE_EXCEED_TENANT_QUOTA", 2, "doc_create_limit", "scene_a2_license_limit", null, null, 12, null);
        A2_LICENSE_EXCEED_TENANT_QUOTA = r102;
        DriveCTAQuotaConfig[] r103 = {r100, r101, r102};
        f236343a = r103;
        f236344b = EnumEntriesKt.enumEntries(r103);
    }

    public static DriveCTAQuotaConfig[] values() {
        return (DriveCTAQuotaConfig[]) f236343a.clone();
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

    public static DriveCTAQuotaConfig valueOf(String r100) {
        return (DriveCTAQuotaConfig) a.a(DriveCTAQuotaConfig.class, r100);
    }

    public final void setCheckpointTenantId(String r100) {
        this.checkpointTenantId = r100;
    }

    public final void setCheckpointUserId(String r100) {
        this.checkpointUserId = r100;
    }

    public final DriveCTAQuotaConfig withCheckPoint(String r100, String r101) {
        this.checkpointTenantId = r100;
        this.checkpointUserId = r101;
        return this;
    }

    public static /* synthetic */ DriveCTAQuotaConfig withCheckPoint$default(DriveCTAQuotaConfig r100, String r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = null;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r102 = null;
    L10:
        return r100.withCheckPoint(r101, r102);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withCheckPoint");
    }

    public DriveCTAQuotaConfig(String r100, int r101, String r102, String r103, String r104, String r105, int r106, DefaultConstructorMarker r107) {
        if ((r106 & 4) == 0) goto L6;
        r104 = null;
    L6:
        if ((r106 & 8) == 0) goto L8;
        r105 = null;
    L8:
        super(r100, r101);
        this.featureKey = r102;
        this.scene = r103;
        this.checkpointTenantId = r104;
        this.checkpointUserId = r105;
    }
}
