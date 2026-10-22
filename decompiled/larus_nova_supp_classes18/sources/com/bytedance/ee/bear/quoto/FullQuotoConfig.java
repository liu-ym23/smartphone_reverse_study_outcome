package com.bytedance.ee.bear.quoto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static final /* synthetic */ FullQuotoConfig[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int buttonStringId;
    private final boolean gotoContactService;
    private final int mainTitleId;
    private final int placeHolderId;
    private final String reportType;
    public boolean showCreateExceedCapacity;
    private final int subTitleId;

    public static EnumEntries<FullQuotoConfig> getEntries() {
        return b;
    }

    static {
        FullQuotoConfig r11 = new FullQuotoConfig("UPLOAD", 0, 2131232538, 2131887308, 2131887307, "drive_storage_limit", 0, false, 48, null);
        UPLOAD = r11;
        int r15 = 2131232538;
        int r16 = 2131887308;
        int r19 = 0;
        boolean r20 = false;
        int r21 = 48;
        DefaultConstructorMarker r22 = null;
        FullQuotoConfig r0 = new FullQuotoConfig("MAKE_COPY", 1, r15, r16, 2131887302, "drive_storage_limit", r19, r20, r21, r22);
        MAKE_COPY = r0;
        int r30 = 0;
        boolean r31 = false;
        int r32 = 48;
        DefaultConstructorMarker r33 = null;
        FullQuotoConfig r1 = new FullQuotoConfig("TRANSLATE", 2, 2131232539, 2131887168, 2131887167, "doc_translation_number_limit", r30, r31, r32, r33);
        TRANSLATE = r1;
        FullQuotoConfig r2 = new FullQuotoConfig("CREATE_TEMPLATE", 3, r15, r16, 2131887303, "drive_storage_limit", r19, r20, r21, r22);
        CREATE_TEMPLATE = r2;
        int r26 = 2131232538;
        int r27 = 2131887308;
        FullQuotoConfig r3 = new FullQuotoConfig("SAVE_TO_TEMPLATE", 4, r26, r27, 2131887305, "drive_storage_limit", r30, r31, r32, r33);
        SAVE_TO_TEMPLATE = r3;
        FullQuotoConfig r4 = new FullQuotoConfig("SAVE_TO_DRIVE", 5, r15, r16, 2131887304, "drive_storage_limit", r19, r20, r21, r22);
        SAVE_TO_DRIVE = r4;
        FullQuotoConfig r5 = new FullQuotoConfig("SAVE_TO_WPS", 6, r26, r27, 2131887248, "drive_storage_limit", r30, r31, r32, r33);
        SAVE_TO_WPS = r5;
        FullQuotoConfig r6 = new FullQuotoConfig("OTHERS_EXCEED_TENANT_QUOTA", 7, 2131232538, 2131889201, 2131889200, "docs_others_tenant_quota", 2131887306, false);
        OTHERS_EXCEED_TENANT_QUOTA = r6;
        FullQuotoConfig[] r7 = {r11, r0, r1, r2, r3, r4, r5, r6};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FullQuotoConfig[] values() {
        return (FullQuotoConfig[]) a.clone();
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

    public static FullQuotoConfig valueOf(String r1) {
        return (FullQuotoConfig) r27.a.a(FullQuotoConfig.class, r1);
    }

    public final FullQuotoConfig withShowCreateExceedCapacity(boolean r1) {
        this.showCreateExceedCapacity = r1;
        return this;
    }

    public FullQuotoConfig(String r1, int r2, int r3, int r4, int r5, String r6, int r7, boolean r8) {
        super(r1, r2);
        this.placeHolderId = r3;
        this.mainTitleId = r4;
        this.subTitleId = r5;
        this.reportType = r6;
        this.buttonStringId = r7;
        this.gotoContactService = r8;
    }

    public /* synthetic */ FullQuotoConfig(String r11, int r12, int r13, int r14, int r15, String r16, int r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 16) == 0) goto L5;
        int r8 = 2131887220;
    L7:
        if ((r19 & 32) == 0) goto L9;
        boolean r9 = true;
    L10:
        this(r11, r12, r13, r14, r15, r16, r8, r9);
        return;
    L9:
        r9 = r18;
        goto L10
    L5:
        r8 = r17;
        goto L7
    }
}
