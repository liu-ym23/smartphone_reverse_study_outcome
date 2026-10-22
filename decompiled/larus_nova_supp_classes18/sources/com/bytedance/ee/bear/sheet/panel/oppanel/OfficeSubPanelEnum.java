package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum OfficeSubPanelEnum extends Enum<OfficeSubPanelEnum> {
    public static final /* synthetic */ OfficeSubPanelEnum[] a = null;
    public static final OfficeSubPanelEnum insert = null;
    public static final OfficeSubPanelEnum operation = null;
    public static final OfficeSubPanelEnum style = null;
    public String fragment;

    static {
        OfficeSubPanelEnum r0 = new OfficeSubPanelEnum("insert", 0, OfficeSubPanelInsertFragment.class.getName());
        insert = r0;
        OfficeSubPanelEnum r1 = new OfficeSubPanelEnum(WikiFolderPushPlugin.OPT, 1, OfficeSubPanelOperationFragment.class.getName());
        operation = r1;
        OfficeSubPanelEnum r2 = new OfficeSubPanelEnum("style", 2, OfficeSubPanelStyleFragment.class.getName());
        style = r2;
        a = new OfficeSubPanelEnum[]{r0, r1, r2};
    }

    public static OfficeSubPanelEnum[] values() {
        return (OfficeSubPanelEnum[]) a.clone();
    }

    public static OfficeSubPanelEnum valueOf(String r1) {
        return (OfficeSubPanelEnum) r27.a.a(OfficeSubPanelEnum.class, r1);
    }

    public OfficeSubPanelEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.fragment = r3;
    }
}
