package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/preview/ResourceRefKind;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_URI", "REMOTE_URL", "CLOUD_TOKEN", "UPLOADING", "REMOTE_KEY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceRefKind extends Enum<ResourceRefKind> {
    public static final ResourceRefKind CLOUD_TOKEN = null;
    public static final ResourceRefKind LOCAL_URI = null;
    public static final ResourceRefKind REMOTE_KEY = null;
    public static final ResourceRefKind REMOTE_URL = null;
    public static final ResourceRefKind UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceRefKind[] f365657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365658b = null;

    public static EnumEntries<ResourceRefKind> getEntries() {
        return f365658b;
    }

    static {
        ResourceRefKind r100 = new ResourceRefKind("LOCAL_URI", 0);
        LOCAL_URI = r100;
        ResourceRefKind r101 = new ResourceRefKind("REMOTE_URL", 1);
        REMOTE_URL = r101;
        ResourceRefKind r102 = new ResourceRefKind("CLOUD_TOKEN", 2);
        CLOUD_TOKEN = r102;
        ResourceRefKind r103 = new ResourceRefKind("UPLOADING", 3);
        UPLOADING = r103;
        ResourceRefKind r104 = new ResourceRefKind("REMOTE_KEY", 4);
        REMOTE_KEY = r104;
        ResourceRefKind[] r105 = {r100, r101, r102, r103, r104};
        f365657a = r105;
        f365658b = EnumEntriesKt.enumEntries(r105);
    }

    public static ResourceRefKind[] values() {
        return (ResourceRefKind[]) f365657a.clone();
    }

    public static ResourceRefKind valueOf(String r100) {
        return (ResourceRefKind) a.a(ResourceRefKind.class, r100);
    }

    public ResourceRefKind(String r100, int r101) {
        super(r100, r101);
    }
}
