package com.bytedance.ies.xelement.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xelement/api/XResourceFrom;", "", "GECKO", "BUILTIN", "CDN", "LOCAL_HOST", "x-element-api_release"}, k = 1, mv = {1, 6, 0})
public final enum XResourceFrom extends Enum<XResourceFrom> {
    public static final XResourceFrom BUILTIN = null;
    public static final XResourceFrom CDN = null;
    public static final XResourceFrom GECKO = null;
    public static final XResourceFrom LOCAL_HOST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XResourceFrom[] f249733a = null;

    public static XResourceFrom valueOf(String r100) {
        return (XResourceFrom) a.a(XResourceFrom.class, r100);
    }

    public static XResourceFrom[] values() {
        return (XResourceFrom[]) f249733a.clone();
    }

    static {
        XResourceFrom r100 = new XResourceFrom("GECKO", 0);
        GECKO = r100;
        XResourceFrom r101 = new XResourceFrom("BUILTIN", 1);
        BUILTIN = r101;
        XResourceFrom r102 = new XResourceFrom("CDN", 2);
        CDN = r102;
        XResourceFrom r103 = new XResourceFrom("LOCAL_HOST", 3);
        LOCAL_HOST = r103;
        f249733a = new XResourceFrom[]{r100, r101, r102, r103};
    }

    public XResourceFrom(String r100, int r101) {
        super(r100, r101);
    }
}
