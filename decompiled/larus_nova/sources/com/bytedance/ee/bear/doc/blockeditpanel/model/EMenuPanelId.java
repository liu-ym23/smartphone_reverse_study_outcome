package com.bytedance.ee.bear.doc.blockeditpanel.model;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum EMenuPanelId extends Enum<EMenuPanelId> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, EMenuPanelId> f217629a = null;
    public static final EMenuPanelId alignMenuPanel = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EMenuPanelId[] f217630b = null;
    public static final EMenuPanelId blockMenuPanel = null;
    public static final EMenuPanelId fileMorePanel = null;
    public static final EMenuPanelId highlightPanel = null;
    public static final EMenuPanelId reactionPanel = null;
    public static final EMenuPanelId toolBarMenuPanel = null;
    public static final EMenuPanelId visionMenuPanel = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    String f217631id;

    static {
        int r100 = 0;
        EMenuPanelId r101 = new EMenuPanelId("blockMenuPanel", 0, "blockMenuPanel");
        blockMenuPanel = r101;
        EMenuPanelId r102 = new EMenuPanelId("toolBarMenuPanel", 1, "toolBarMenuPanel");
        toolBarMenuPanel = r102;
        EMenuPanelId r103 = new EMenuPanelId("highlightPanel", 2, "highlightPanel");
        highlightPanel = r103;
        EMenuPanelId r104 = new EMenuPanelId("alignMenuPanel", 3, "alignMenuPanel");
        alignMenuPanel = r104;
        EMenuPanelId r105 = new EMenuPanelId("visionMenuPanel", 4, "visionMenuPanel");
        visionMenuPanel = r105;
        EMenuPanelId r106 = new EMenuPanelId("reactionPanel", 5, "reactionPanel");
        reactionPanel = r106;
        EMenuPanelId r110 = new EMenuPanelId("fileMorePanel", 6, "fileMorePanel");
        fileMorePanel = r110;
        f217630b = new EMenuPanelId[]{r101, r102, r103, r104, r105, r106, r110};
        f217629a = new HashMap();
        EMenuPanelId[] r107 = values();
        int r108 = r107.length;
    L3:
        if (r100 >= r108) goto L5;
        EMenuPanelId r109 = r107[r100];
        f217629a.put(r109.f217631id, r109);
        r100 = r100 + 1;
        goto L3
    }

    public static EMenuPanelId[] values() {
        return (EMenuPanelId[]) f217630b.clone();
    }

    public static EMenuPanelId getEnumMenuPanelIdByPanelId(String r100) {
        return (EMenuPanelId) ((HashMap) f217629a).get(r100);
    }

    public static EMenuPanelId valueOf(String r100) {
        return (EMenuPanelId) a.a(EMenuPanelId.class, r100);
    }

    public EMenuPanelId(String r100, int r101, String r102) {
        super(r100, r101);
        this.f217631id = r102;
    }
}
