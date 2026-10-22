package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SubPanelEnum extends Enum<SubPanelEnum> {
    public static final /* synthetic */ SubPanelEnum[] a = null;
    public static final SubPanelEnum insert = null;
    public static final SubPanelEnum operation = null;
    public static final SubPanelEnum style = null;
    public String fragment;

    static {
        SubPanelEnum r0 = new SubPanelEnum("insert", 0, SubPanelInsertFragment.class.getName());
        insert = r0;
        SubPanelEnum r1 = new SubPanelEnum(WikiFolderPushPlugin.OPT, 1, SubPanelOperationFragment.class.getName());
        operation = r1;
        SubPanelEnum r2 = new SubPanelEnum("style", 2, SubPanelStyleFragment.class.getName());
        style = r2;
        a = new SubPanelEnum[]{r0, r1, r2};
    }

    public static SubPanelEnum[] values() {
        return (SubPanelEnum[]) a.clone();
    }

    public static SubPanelEnum valueOf(String r1) {
        return (SubPanelEnum) r27.a.a(SubPanelEnum.class, r1);
    }

    public SubPanelEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.fragment = r3;
    }
}
