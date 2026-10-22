package com.ss.android.ugc.route_monitor;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/route_monitor/ComponentType;", "", BannerBizName.ACTIVITY, HTTP.SERVICE, "RECEIVER", "CONTENT_PROVIDER", "UNKNOWN", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType ACTIVITY = null;
    public static final ComponentType CONTENT_PROVIDER = null;
    public static final ComponentType RECEIVER = null;
    public static final ComponentType SERVICE = null;
    public static final ComponentType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentType[] f454377a = null;

    static {
        ComponentType r100 = new ComponentType(BannerBizName.ACTIVITY, 0);
        ACTIVITY = r100;
        ComponentType r101 = new ComponentType(HTTP.SERVICE, 1);
        SERVICE = r101;
        ComponentType r102 = new ComponentType("RECEIVER", 2);
        RECEIVER = r102;
        ComponentType r103 = new ComponentType("CONTENT_PROVIDER", 3);
        CONTENT_PROVIDER = r103;
        ComponentType r104 = new ComponentType("UNKNOWN", 4);
        UNKNOWN = r104;
        f454377a = new ComponentType[]{r100, r101, r102, r103, r104};
    }

    public static ComponentType valueOf(String r100) {
        return (ComponentType) r27.a.a(ComponentType.class, r100);
    }

    public static ComponentType[] values() {
        return (ComponentType[]) f454377a.clone();
    }

    public ComponentType(String r100, int r101) {
        super(r100, r101);
    }
}
