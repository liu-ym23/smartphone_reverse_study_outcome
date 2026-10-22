package com.bytedance.caijing.sdk.infra.base.api.trip.sidebar;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/sidebar/ComponentUiType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GRID_LIST", "UNKNOWN", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum ComponentUiType extends Enum<ComponentUiType> {
    public static final a Companion = null;
    public static final ComponentUiType GRID_LIST = null;
    public static final ComponentUiType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentUiType[] f202253a = null;
    private final String type;

    public static ComponentUiType valueOf(String r100) {
        return (ComponentUiType) r27.a.a(ComponentUiType.class, r100);
    }

    public static ComponentUiType[] values() {
        return (ComponentUiType[]) f202253a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.caijing.sdk.infra.base.api.trip.sidebar.ComponentUiType$a] */
    static {
        ComponentUiType r100 = new ComponentUiType("GRID_LIST", 0, "grid_list");
        GRID_LIST = r100;
        ComponentUiType r101 = new ComponentUiType("UNKNOWN", 1, "unknown");
        UNKNOWN = r101;
        f202253a = new ComponentUiType[]{r100, r101};
        Companion = new a();
    }

    public final String getType() {
        return this.type;
    }

    public ComponentUiType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
