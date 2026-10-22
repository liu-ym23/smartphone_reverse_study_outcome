package com.larus.bmhome.resource.access;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourcePipelineRoute;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "REMOTE", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ResourcePipelineRoute extends Enum<ResourcePipelineRoute> {
    public static final ResourcePipelineRoute LOCAL = null;
    public static final ResourcePipelineRoute REMOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourcePipelineRoute[] f313589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313590b = null;

    public static EnumEntries<ResourcePipelineRoute> getEntries() {
        return f313590b;
    }

    static {
        ResourcePipelineRoute r100 = new ResourcePipelineRoute(AccountType.LOCAL, 0);
        LOCAL = r100;
        ResourcePipelineRoute r101 = new ResourcePipelineRoute("REMOTE", 1);
        REMOTE = r101;
        ResourcePipelineRoute[] r102 = {r100, r101};
        f313589a = r102;
        f313590b = EnumEntriesKt.enumEntries(r102);
    }

    public static ResourcePipelineRoute[] values() {
        return (ResourcePipelineRoute[]) f313589a.clone();
    }

    public static ResourcePipelineRoute valueOf(String r100) {
        return (ResourcePipelineRoute) r27.a.a(ResourcePipelineRoute.class, r100);
    }

    public ResourcePipelineRoute(String r100, int r101) {
        super(r100, r101);
    }
}
