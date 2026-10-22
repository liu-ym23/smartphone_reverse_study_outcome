package com.bytedance.ee.bear.bitable.toolbox.model.fab;

import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum EBitableFab extends Enum<EBitableFab> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, EBitableFab> f215996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EBitableFab[] f215997b = null;
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
        EBitableFab r100 = new EBitableFab("bitableViewList", 0, 0, R.drawable.ud_icon_view_list_outlined, R.color.bg_float, R.color.primary_fill_default);
        bitableViewList = r100;
        EBitableFab r101 = new EBitableFab("bitableManager", 1, 0, R.drawable.ud_icon_view_list_outlined, R.color.bg_float, R.color.primary_fill_default);
        bitableManager = r101;
        EBitableFab r102 = new EBitableFab("kanbanZoomIn", 2, 0, R.drawable.ud_icon_zoom_in_outlined, R.color.bg_float, R.color.primary_fill_default);
        kanbanZoomIn = r102;
        EBitableFab r103 = new EBitableFab("kanbanZoomOut", 3, 0, R.drawable.ud_icon_zoom_out_outlined, R.color.bg_float, R.color.primary_fill_default);
        kanbanZoomOut = r103;
        EBitableFab r104 = new EBitableFab("createRecord", 4, 0, R.drawable.ud_icon_add_outlined, R.color.primary_fill_default, R.color.static_white);
        createRecord = r104;
        EBitableFab r105 = new EBitableFab("shareForm", 5);
        shareForm = r105;
        EBitableFab r106 = new EBitableFab("shareDashboard", 6);
        shareDashboard = r106;
        EBitableFab r107 = new EBitableFab("debugFab", 7);
        debugFab = r107;
        EBitableFab r110 = new EBitableFab("createRecordUnable", 8, 0, R.drawable.ud_icon_add_outlined, R.color.fill_disable, R.color.static_white);
        createRecordUnable = r110;
        int r111 = 0;
        f215997b = new EBitableFab[]{r100, r101, r102, r103, r104, r105, r106, r107, r110};
        f215996a = new HashMap();
        EBitableFab[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r111 >= r109) goto L5;
        EBitableFab r112 = r108[r111];
        ((HashMap) f215996a).put(r112.name(), r112);
        r111 = r111 + 1;
        goto L3
    }

    public static EBitableFab[] values() {
        return (EBitableFab[]) f215997b.clone();
    }

    public static EBitableFab getEBitableFabByName(String r100) {
        EBitableFab r101 = (EBitableFab) ((HashMap) f215996a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return bitableViewList;
    }

    public static EBitableFab valueOf(String r100) {
        return (EBitableFab) a.a(EBitableFab.class, r100);
    }

    public EBitableFab(String r100, int r101) {
        this(r100, r101, 1, 0, 0, 0);
    }

    public EBitableFab(String r100, int r101, int r102, int r103, int r104, int r105) {
        super(r100, r101);
        this.type = r102;
        this.imageRes = r103;
        this.colorRes = r104;
        this.imageTintColorRes = r105;
        this.unableColorRes = 0;
        this.unableTintColorRes = 0;
    }
}
