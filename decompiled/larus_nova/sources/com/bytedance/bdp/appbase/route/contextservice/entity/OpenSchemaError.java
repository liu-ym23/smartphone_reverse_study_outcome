package com.bytedance.bdp.appbase.route.contextservice.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/route/contextservice/entity/OpenSchemaError;", "", "HOST_CANNOT_OPEN_SCHEMA", "bdp-appbase-cpapi_release"}, k = 1, mv = {1, 4, 0})
public final enum OpenSchemaError extends Enum<OpenSchemaError> {
    public static final OpenSchemaError HOST_CANNOT_OPEN_SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenSchemaError[] f200960a = null;

    static {
        OpenSchemaError r100 = new OpenSchemaError();
        HOST_CANNOT_OPEN_SCHEMA = r100;
        f200960a = new OpenSchemaError[]{r100};
    }

    public static OpenSchemaError valueOf(String r100) {
        return (OpenSchemaError) a.a(OpenSchemaError.class, r100);
    }

    public static OpenSchemaError[] values() {
        return (OpenSchemaError[]) f200960a.clone();
    }

    public OpenSchemaError() {
        super("HOST_CANNOT_OPEN_SCHEMA", 0);
    }
}
