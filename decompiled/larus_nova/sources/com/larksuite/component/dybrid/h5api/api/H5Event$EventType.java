package com.larksuite.component.dybrid.h5api.api;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum H5Event$EventType extends Enum<H5Event$EventType> {
    public static final H5Event$EventType CALL = null;
    public static final H5Event$EventType CALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H5Event$EventType[] f283989a = null;

    static {
        H5Event$EventType r100 = new H5Event$EventType("CALL", 0);
        CALL = r100;
        H5Event$EventType r101 = new H5Event$EventType(HTTP.CALLBACK, 1);
        CALLBACK = r101;
        f283989a = new H5Event$EventType[]{r100, r101};
    }

    public static H5Event$EventType[] values() {
        return (H5Event$EventType[]) f283989a.clone();
    }

    public static H5Event$EventType valueOf(String r100) {
        return (H5Event$EventType) a.a(H5Event$EventType.class, r100);
    }

    public H5Event$EventType(String r100, int r101) {
        super(r100, r101);
    }
}
