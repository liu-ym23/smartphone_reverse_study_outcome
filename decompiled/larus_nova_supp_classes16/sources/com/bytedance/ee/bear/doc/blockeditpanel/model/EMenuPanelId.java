package com.bytedance.ee.bear.doc.blockeditpanel.model;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum EMenuPanelId extends Enum<EMenuPanelId> {
    public static final Map<String, EMenuPanelId> a = null;
    public static final EMenuPanelId alignMenuPanel = null;
    public static final /* synthetic */ EMenuPanelId[] b = null;
    public static final EMenuPanelId blockMenuPanel = null;
    public static final EMenuPanelId fileMorePanel = null;
    public static final EMenuPanelId highlightPanel = null;
    public static final EMenuPanelId reactionPanel = null;
    public static final EMenuPanelId toolBarMenuPanel = null;
    public static final EMenuPanelId visionMenuPanel = null;
    String id;

    static {
        int r2 = 0;
        EMenuPanelId r0 = new EMenuPanelId("blockMenuPanel", 0, "blockMenuPanel");
        blockMenuPanel = r0;
        EMenuPanelId r1 = new EMenuPanelId("toolBarMenuPanel", 1, "toolBarMenuPanel");
        toolBarMenuPanel = r1;
        EMenuPanelId r3 = new EMenuPanelId("highlightPanel", 2, "highlightPanel");
        highlightPanel = r3;
        EMenuPanelId r5 = new EMenuPanelId("alignMenuPanel", 3, "alignMenuPanel");
        alignMenuPanel = r5;
        EMenuPanelId r7 = new EMenuPanelId("visionMenuPanel", 4, "visionMenuPanel");
        visionMenuPanel = r7;
        EMenuPanelId r9 = new EMenuPanelId("reactionPanel", 5, "reactionPanel");
        reactionPanel = r9;
        EMenuPanelId r11 = new EMenuPanelId("fileMorePanel", 6, "fileMorePanel");
        fileMorePanel = r11;
        b = new EMenuPanelId[]{r0, r1, r3, r5, r7, r9, r11};
        a = new HashMap();
        EMenuPanelId[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        EMenuPanelId r8 = r4[r2];
        a.put(r8.id, r8);
        r2 = r2 + 1;
        goto L3
    }

    public static EMenuPanelId[] values() {
        return (EMenuPanelId[]) b.clone();
    }

    public static EMenuPanelId getEnumMenuPanelIdByPanelId(String r1) {
        return (EMenuPanelId) ((HashMap) a).get(r1);
    }

    public static EMenuPanelId valueOf(String r1) {
        return (EMenuPanelId) a.a(EMenuPanelId.class, r1);
    }

    public EMenuPanelId(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
