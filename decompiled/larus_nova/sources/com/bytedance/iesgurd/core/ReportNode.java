package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/core/ReportNode;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "GECKO_REGISTER_BY_IREGISTER", "GECKO_REGISTER_CUSTOM_PARAMS", "CHECK_UPDATE_REQUEST", "CHECK_UPDATE_RESPONSE", "SYNC_GLOBAL_SETTING", "SETTINGS_RESPONSE", "HIT_STORAGE_POLICY", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final enum ReportNode extends Enum<ReportNode> {
    private static final /* synthetic */ ReportNode[] $VALUES = null;
    public static final ReportNode CHECK_UPDATE_REQUEST = null;
    public static final ReportNode CHECK_UPDATE_RESPONSE = null;
    public static final ReportNode GECKO_REGISTER_BY_IREGISTER = null;
    public static final ReportNode GECKO_REGISTER_CUSTOM_PARAMS = null;
    public static final ReportNode HIT_STORAGE_POLICY = null;
    public static final ReportNode SETTINGS_RESPONSE = null;
    public static final ReportNode SYNC_GLOBAL_SETTING = null;
    private final String tag;

    static {
        ReportNode r100 = new ReportNode("GECKO_REGISTER_BY_IREGISTER", 0, "gecko_register_by_iRegister");
        GECKO_REGISTER_BY_IREGISTER = r100;
        ReportNode r101 = new ReportNode("GECKO_REGISTER_CUSTOM_PARAMS", 1, "gecko_register_custom_params");
        GECKO_REGISTER_CUSTOM_PARAMS = r101;
        ReportNode r102 = new ReportNode("CHECK_UPDATE_REQUEST", 2, "check_update_request");
        CHECK_UPDATE_REQUEST = r102;
        ReportNode r103 = new ReportNode("CHECK_UPDATE_RESPONSE", 3, "check_update_response");
        CHECK_UPDATE_RESPONSE = r103;
        ReportNode r104 = new ReportNode("SYNC_GLOBAL_SETTING", 4, "sync_global_setting");
        SYNC_GLOBAL_SETTING = r104;
        ReportNode r105 = new ReportNode("SETTINGS_RESPONSE", 5, "settings_response");
        SETTINGS_RESPONSE = r105;
        ReportNode r106 = new ReportNode("HIT_STORAGE_POLICY", 6, "hit_storage_policy");
        HIT_STORAGE_POLICY = r106;
        $VALUES = new ReportNode[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ReportNode valueOf(String r100) {
        return (ReportNode) r27.a.a(ReportNode.class, r100);
    }

    public static ReportNode[] values() {
        return (ReportNode[]) $VALUES.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    private ReportNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
