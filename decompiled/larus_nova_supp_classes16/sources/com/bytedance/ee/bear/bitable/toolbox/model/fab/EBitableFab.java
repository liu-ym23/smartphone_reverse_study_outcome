package com.bytedance.ee.bear.bitable.toolbox.model.fab;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum EBitableFab extends Enum<EBitableFab> {
    public static final Map<String, EBitableFab> a = null;
    public static final /* synthetic */ EBitableFab[] b = null;
    public static final EBitableFab bitableManager = null;
    public static final EBitableFab bitableViewList = null;
    public static final EBitableFab createRecord = null;
    public static final EBitableFab createRecordUnable = null;
    public static final EBitableFab debugFab = null;
    public static final EBitableFab kanbanZoomIn = null;
    public static final EBitableFab kanbanZoomOut = null;
    public static final EBitableFab shareDashboard = null;
    public static final EBitableFab shareForm = null;
    public int colorRes;
    public int imageRes;
    public int imageTintColorRes;
    public int type;
    public int unableColorRes;
    public int unableTintColorRes;

    public EBitableFab() {
        throw null;
    }

    static {
        EBitableFab r7 = new EBitableFab("bitableViewList", 0, 0, 2131256146, 2131100557, 2131105548);
        bitableViewList = r7;
        EBitableFab r0 = new EBitableFab("bitableManager", 1, 0, 2131256146, 2131100557, 2131105548);
        bitableManager = r0;
        EBitableFab r2 = new EBitableFab("kanbanZoomIn", 2, 0, 2131256308, 2131100557, 2131105548);
        kanbanZoomIn = r2;
        EBitableFab r4 = new EBitableFab("kanbanZoomOut", 3, 0, 2131256310, 2131100557, 2131105548);
        kanbanZoomOut = r4;
        EBitableFab r1 = new EBitableFab("createRecord", 4, 0, 2131253548, 2131105548, 2131106521);
        createRecord = r1;
        EBitableFab r3 = new EBitableFab("shareForm", 5);
        shareForm = r3;
        EBitableFab r5 = new EBitableFab("shareDashboard", 6);
        shareDashboard = r5;
        EBitableFab r8 = new EBitableFab("debugFab", 7);
        debugFab = r8;
        EBitableFab r10 = new EBitableFab("createRecordUnable", 8, 0, 2131253548, 2131101948, 2131106521);
        createRecordUnable = r10;
        int r13 = 0;
        b = new EBitableFab[]{r7, r0, r2, r4, r1, r3, r5, r8, r10};
        a = new HashMap();
        EBitableFab[] r6 = values();
        int r9 = r6.length;
    L3:
        if (r13 >= r9) goto L5;
        EBitableFab r11 = r6[r13];
        ((HashMap) a).put(r11.name(), r11);
        r13 = r13 + 1;
        goto L3
    }

    public static EBitableFab[] values() {
        return (EBitableFab[]) b.clone();
    }

    public static EBitableFab getEBitableFabByName(String r1) {
        EBitableFab r2 = (EBitableFab) ((HashMap) a).get(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return bitableViewList;
    }

    public static EBitableFab valueOf(String r1) {
        return (EBitableFab) a.a(EBitableFab.class, r1);
    }

    public EBitableFab(String r8, int r9) {
        this(r8, r9, 1, 0, 0, 0);
    }

    public EBitableFab(String r1, int r2, int r3, int r4, int r5, int r6) {
        super(r1, r2);
        this.type = r3;
        this.imageRes = r4;
        this.colorRes = r5;
        this.imageTintColorRes = r6;
        this.unableColorRes = 0;
        this.unableTintColorRes = 0;
    }
}
