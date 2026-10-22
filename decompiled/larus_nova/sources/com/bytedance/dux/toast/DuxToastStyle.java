package com.bytedance.dux.toast;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/toast/DuxToastStyle;", "", "System", "DuxCustom", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum DuxToastStyle extends Enum<DuxToastStyle> {
    public static final DuxToastStyle DuxCustom = null;
    public static final DuxToastStyle System = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DuxToastStyle[] f205817a = null;

    public static DuxToastStyle valueOf(String r100) {
        return (DuxToastStyle) r27.a.a(DuxToastStyle.class, r100);
    }

    public static DuxToastStyle[] values() {
        return (DuxToastStyle[]) f205817a.clone();
    }

    static {
        DuxToastStyle r100 = new DuxToastStyle("System", 0);
        System = r100;
        DuxToastStyle r101 = new DuxToastStyle("DuxCustom", 1);
        DuxCustom = r101;
        f205817a = new DuxToastStyle[]{r100, r101};
    }

    public DuxToastStyle(String r100, int r101) {
        super(r100, r101);
    }
}
