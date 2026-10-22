package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;

/* JADX INFO: loaded from: classes18.dex */
public final enum OfficeSubPanelEnum extends Enum<OfficeSubPanelEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSubPanelEnum[] f238185a = null;
    public static final OfficeSubPanelEnum insert = null;
    public static final OfficeSubPanelEnum operation = null;
    public static final OfficeSubPanelEnum style = null;
    public String fragment;

    static {
        OfficeSubPanelEnum r100 = new OfficeSubPanelEnum("insert", 0, OfficeSubPanelInsertFragment.class.getName());
        insert = r100;
        OfficeSubPanelEnum r101 = new OfficeSubPanelEnum(WikiFolderPushPlugin.OPT, 1, OfficeSubPanelOperationFragment.class.getName());
        operation = r101;
        OfficeSubPanelEnum r102 = new OfficeSubPanelEnum("style", 2, OfficeSubPanelStyleFragment.class.getName());
        style = r102;
        f238185a = new OfficeSubPanelEnum[]{r100, r101, r102};
    }

    public static OfficeSubPanelEnum[] values() {
        return (OfficeSubPanelEnum[]) f238185a.clone();
    }

    public static OfficeSubPanelEnum valueOf(String r100) {
        return (OfficeSubPanelEnum) r27.a.a(OfficeSubPanelEnum.class, r100);
    }

    public OfficeSubPanelEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.fragment = r102;
    }
}
