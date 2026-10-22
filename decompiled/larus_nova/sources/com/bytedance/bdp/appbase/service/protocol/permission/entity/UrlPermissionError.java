package com.bytedance.bdp.appbase.service.protocol.permission.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/service/protocol/permission/entity/UrlPermissionError;", "", "PROTOCOL_ERROR", "INVALID_DOMAIN", "INVALID_URL", "bdp-appbase_release"}, k = 1, mv = {1, 4, 0})
public final enum UrlPermissionError extends Enum<UrlPermissionError> {
    public static final UrlPermissionError INVALID_DOMAIN = null;
    public static final UrlPermissionError INVALID_URL = null;
    public static final UrlPermissionError PROTOCOL_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrlPermissionError[] f200978a = null;

    static {
        UrlPermissionError r100 = new UrlPermissionError("PROTOCOL_ERROR", 0);
        PROTOCOL_ERROR = r100;
        UrlPermissionError r101 = new UrlPermissionError("INVALID_DOMAIN", 1);
        INVALID_DOMAIN = r101;
        UrlPermissionError r102 = new UrlPermissionError("INVALID_URL", 2);
        INVALID_URL = r102;
        f200978a = new UrlPermissionError[]{r100, r101, r102};
    }

    public static UrlPermissionError valueOf(String r100) {
        return (UrlPermissionError) a.a(UrlPermissionError.class, r100);
    }

    public static UrlPermissionError[] values() {
        return (UrlPermissionError[]) f200978a.clone();
    }

    public UrlPermissionError(String r100, int r101) {
        super(r100, r101);
    }
}
