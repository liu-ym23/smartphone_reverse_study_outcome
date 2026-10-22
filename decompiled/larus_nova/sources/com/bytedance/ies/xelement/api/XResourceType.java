package com.bytedance.ies.xelement.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/api/XResourceType;", "", "DISK", "ASSET", "x-element-api_release"}, k = 1, mv = {1, 6, 0})
public final enum XResourceType extends Enum<XResourceType> {
    public static final XResourceType ASSET = null;
    public static final XResourceType DISK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XResourceType[] f249734a = null;

    public static XResourceType valueOf(String r100) {
        return (XResourceType) a.a(XResourceType.class, r100);
    }

    public static XResourceType[] values() {
        return (XResourceType[]) f249734a.clone();
    }

    static {
        XResourceType r100 = new XResourceType("DISK", 0);
        DISK = r100;
        XResourceType r101 = new XResourceType("ASSET", 1);
        ASSET = r101;
        f249734a = new XResourceType[]{r100, r101};
    }

    public XResourceType(String r100, int r101) {
        super(r100, r101);
    }
}
