package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/EntityDomain;", "", "domainName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDomainName", "()Ljava/lang/String;", "EntityDomainUNKNOWN", "EntityDomainCCM", "EntityDomainIM", "EntityDomainMAIL", "EntityDomainVC", "EntityDomainTODO", "EntityDomainCALENDAR", "EntityDomainPASSPORT", "EntityDomainORM", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntityDomain extends Enum<EntityDomain> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EntityDomain[] $VALUES = null;

    @SerializedName("CALENDAR")
    public static final EntityDomain EntityDomainCALENDAR = null;

    @SerializedName("CCM")
    public static final EntityDomain EntityDomainCCM = null;

    @SerializedName("IM")
    public static final EntityDomain EntityDomainIM = null;

    @SerializedName("MAIL")
    public static final EntityDomain EntityDomainMAIL = null;

    @SerializedName("ORM")
    public static final EntityDomain EntityDomainORM = null;

    @SerializedName("PASSPORT")
    public static final EntityDomain EntityDomainPASSPORT = null;

    @SerializedName(AlarmSessionType.TODO)
    public static final EntityDomain EntityDomainTODO = null;

    @SerializedName("UNKNOWN")
    public static final EntityDomain EntityDomainUNKNOWN = null;

    @SerializedName("VC")
    public static final EntityDomain EntityDomainVC = null;
    private final String domainName;

    private static final /* synthetic */ EntityDomain[] $values() {
        return new EntityDomain[]{EntityDomainUNKNOWN, EntityDomainCCM, EntityDomainIM, EntityDomainMAIL, EntityDomainVC, EntityDomainTODO, EntityDomainCALENDAR, EntityDomainPASSPORT, EntityDomainORM};
    }

    public static EnumEntries<EntityDomain> getEntries() {
        return $ENTRIES;
    }

    static {
        EntityDomainUNKNOWN = new EntityDomain("EntityDomainUNKNOWN", 0, "UNKNOWN");
        EntityDomainCCM = new EntityDomain("EntityDomainCCM", 1, "CCM");
        EntityDomainIM = new EntityDomain("EntityDomainIM", 2, "IM");
        EntityDomainMAIL = new EntityDomain("EntityDomainMAIL", 3, "MAIL");
        EntityDomainVC = new EntityDomain("EntityDomainVC", 4, "VC");
        EntityDomainTODO = new EntityDomain("EntityDomainTODO", 5, AlarmSessionType.TODO);
        EntityDomainCALENDAR = new EntityDomain("EntityDomainCALENDAR", 6, "CALENDAR");
        EntityDomainPASSPORT = new EntityDomain("EntityDomainPASSPORT", 7, "PASSPORT");
        EntityDomainORM = new EntityDomain("EntityDomainORM", 8, "ORM");
        EntityDomain[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static EntityDomain[] values() {
        return (EntityDomain[]) $VALUES.clone();
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public static EntityDomain valueOf(String r100) {
        return (EntityDomain) r27.a.a(EntityDomain.class, r100);
    }

    private EntityDomain(String r100, int r101, String r102) {
        super(r100, r101);
        this.domainName = r102;
    }
}
