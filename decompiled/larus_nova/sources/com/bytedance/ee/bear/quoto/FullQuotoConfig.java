package com.bytedance.ee.bear.quoto;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BC\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/quoto/FullQuotoConfig;", "", "placeHolderId", "", "mainTitleId", "subTitleId", "reportType", "", "buttonStringId", "gotoContactService", "", "<init>", "(Ljava/lang/String;IIIILjava/lang/String;IZ)V", "getPlaceHolderId", "()I", "getMainTitleId", "getSubTitleId", "getReportType", "()Ljava/lang/String;", "getButtonStringId", "getGotoContactService", "()Z", "UPLOAD", "MAKE_COPY", "TRANSLATE", "CREATE_TEMPLATE", "SAVE_TO_TEMPLATE", "SAVE_TO_DRIVE", "SAVE_TO_WPS", "OTHERS_EXCEED_TENANT_QUOTA", "showCreateExceedCapacity", "withShowCreateExceedCapacity", "show", "features-quoto-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FullQuotoConfig extends Enum<FullQuotoConfig> {
    public static final FullQuotoConfig CREATE_TEMPLATE = null;
    public static final FullQuotoConfig MAKE_COPY = null;
    public static final FullQuotoConfig OTHERS_EXCEED_TENANT_QUOTA = null;
    public static final FullQuotoConfig SAVE_TO_DRIVE = null;
    public static final FullQuotoConfig SAVE_TO_TEMPLATE = null;
    public static final FullQuotoConfig SAVE_TO_WPS = null;
    public static final FullQuotoConfig TRANSLATE = null;
    public static final FullQuotoConfig UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FullQuotoConfig[] f236310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236311b = null;
    private final int buttonStringId;
    private final boolean gotoContactService;
    private final int mainTitleId;
    private final int placeHolderId;
    private final String reportType;
    public boolean showCreateExceedCapacity;
    private final int subTitleId;

    public static EnumEntries<FullQuotoConfig> getEntries() {
        return f236311b;
    }

    static {
        FullQuotoConfig r110 = new FullQuotoConfig("UPLOAD", 0, R.drawable.ccm_ccm_empty_positive_storage_limit, R.string.CreationMobile_ECM_SpaceMaxToast, R.string.CreationMobile_ECM_SpaceMaxDesc, "drive_storage_limit", 0, false, 48, null);
        UPLOAD = r110;
        int r111 = R.drawable.ccm_ccm_empty_positive_storage_limit;
        int r112 = R.string.CreationMobile_ECM_SpaceMaxToast;
        int r113 = 0;
        boolean r210 = false;
        int r211 = 48;
        DefaultConstructorMarker r212 = null;
        FullQuotoConfig r100 = new FullQuotoConfig("MAKE_COPY", 1, r111, r112, R.string.CreationMobile_ECM_SpaceCantCopyDesc, "drive_storage_limit", r113, r210, r211, r212);
        MAKE_COPY = r100;
        int r310 = 0;
        boolean r311 = false;
        int r312 = 48;
        DefaultConstructorMarker r313 = null;
        FullQuotoConfig r101 = new FullQuotoConfig("TRANSLATE", 2, R.drawable.ccm_ccm_empty_positive_translation_limit, R.string.CreationMobile_Docs_Billing_Translation_Title, R.string.CreationMobile_Docs_Biling_MaxTranslationTimes_Toast, "doc_translation_number_limit", r310, r311, r312, r313);
        TRANSLATE = r101;
        FullQuotoConfig r102 = new FullQuotoConfig("CREATE_TEMPLATE", 3, r111, r112, R.string.CreationMobile_ECM_SpaceCantCreateDesc, "drive_storage_limit", r113, r210, r211, r212);
        CREATE_TEMPLATE = r102;
        int r213 = R.drawable.ccm_ccm_empty_positive_storage_limit;
        int r214 = R.string.CreationMobile_ECM_SpaceMaxToast;
        FullQuotoConfig r103 = new FullQuotoConfig("SAVE_TO_TEMPLATE", 4, r213, r214, R.string.CreationMobile_ECM_SpaceCantTemplateDesc, "drive_storage_limit", r310, r311, r312, r313);
        SAVE_TO_TEMPLATE = r103;
        FullQuotoConfig r104 = new FullQuotoConfig("SAVE_TO_DRIVE", 5, r111, r112, R.string.CreationMobile_ECM_SpaceCantSaveDesc, "drive_storage_limit", r113, r210, r211, r212);
        SAVE_TO_DRIVE = r104;
        FullQuotoConfig r105 = new FullQuotoConfig("SAVE_TO_WPS", 6, r213, r214, R.string.CreationMobile_ECM_CapacityFullCannotEdit, "drive_storage_limit", r310, r311, r312, r313);
        SAVE_TO_WPS = r105;
        FullQuotoConfig r106 = new FullQuotoConfig("OTHERS_EXCEED_TENANT_QUOTA", 7, R.drawable.ccm_ccm_empty_positive_storage_limit, R.string.LarkCCM_Docs_OwnerStgFull_Title, R.string.LarkCCM_Docs_OwnerStgFull_Desc, "docs_others_tenant_quota", R.string.CreationMobile_ECM_SpaceKnewButton, false);
        OTHERS_EXCEED_TENANT_QUOTA = r106;
        FullQuotoConfig[] r107 = {r110, r100, r101, r102, r103, r104, r105, r106};
        f236310a = r107;
        f236311b = EnumEntriesKt.enumEntries(r107);
    }

    public static FullQuotoConfig[] values() {
        return (FullQuotoConfig[]) f236310a.clone();
    }

    public final int getButtonStringId() {
        return this.buttonStringId;
    }

    public final boolean getGotoContactService() {
        return this.gotoContactService;
    }

    public final int getMainTitleId() {
        return this.mainTitleId;
    }

    public final int getPlaceHolderId() {
        return this.placeHolderId;
    }

    public final String getReportType() {
        return this.reportType;
    }

    public final int getSubTitleId() {
        return this.subTitleId;
    }

    public static FullQuotoConfig valueOf(String r100) {
        return (FullQuotoConfig) r27.a.a(FullQuotoConfig.class, r100);
    }

    public final FullQuotoConfig withShowCreateExceedCapacity(boolean r100) {
        this.showCreateExceedCapacity = r100;
        return this;
    }

    public FullQuotoConfig(String r100, int r101, int r102, int r103, int r104, String r105, int r106, boolean r107) {
        super(r100, r101);
        this.placeHolderId = r102;
        this.mainTitleId = r103;
        this.subTitleId = r104;
        this.reportType = r105;
        this.buttonStringId = r106;
        this.gotoContactService = r107;
    }

    public /* synthetic */ FullQuotoConfig(String r110, int r111, int r112, int r113, int r114, String r115, int r116, boolean r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 16) == 0) goto L5;
        int r100 = R.string.CreationMobile_Docs_StorageFull_ContactSupport_btn;
    L7:
        if ((r118 & 32) == 0) goto L9;
        boolean r101 = true;
    L10:
        this(r110, r111, r112, r113, r114, r115, r100, r101);
        return;
    L9:
        r101 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }
}
