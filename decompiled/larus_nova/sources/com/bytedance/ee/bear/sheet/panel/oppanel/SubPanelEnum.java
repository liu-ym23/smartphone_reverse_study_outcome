package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: classes18.dex */
public final enum SubPanelEnum extends Enum<SubPanelEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubPanelEnum[] f238201a = null;
    public static final SubPanelEnum insert = null;
    public static final SubPanelEnum operation = null;
    public static final SubPanelEnum style = null;
    public String fragment;

    static {
        SubPanelEnum r100 = new SubPanelEnum("insert", 0, SubPanelInsertFragment.class.getName());
        insert = r100;
        SubPanelEnum r101 = new SubPanelEnum(WikiFolderPushPlugin.OPT, 1, SubPanelOperationFragment.class.getName());
        operation = r101;
        SubPanelEnum r102 = new SubPanelEnum("style", 2, SubPanelStyleFragment.class.getName());
        style = r102;
        f238201a = new SubPanelEnum[]{r100, r101, r102};
    }

    public static SubPanelEnum[] values() {
        return (SubPanelEnum[]) f238201a.clone();
    }

    public static SubPanelEnum valueOf(String r100) {
        return (SubPanelEnum) r27.a.a(SubPanelEnum.class, r100);
    }

    public SubPanelEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.fragment = r102;
    }
}
