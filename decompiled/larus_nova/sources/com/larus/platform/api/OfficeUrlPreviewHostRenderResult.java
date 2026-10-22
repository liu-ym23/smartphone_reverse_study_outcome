package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/OfficeUrlPreviewHostRenderResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RENDER_FAILED", "NO_DATA", "NO_RENDER", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewHostRenderResult extends Enum<OfficeUrlPreviewHostRenderResult> {
    public static final OfficeUrlPreviewHostRenderResult NO_DATA = null;
    public static final OfficeUrlPreviewHostRenderResult NO_RENDER = null;
    public static final OfficeUrlPreviewHostRenderResult RENDER_FAILED = null;
    public static final OfficeUrlPreviewHostRenderResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewHostRenderResult[] f364832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364833b = null;

    public static EnumEntries<OfficeUrlPreviewHostRenderResult> getEntries() {
        return f364833b;
    }

    static {
        OfficeUrlPreviewHostRenderResult r100 = new OfficeUrlPreviewHostRenderResult("SUCCESS", 0);
        SUCCESS = r100;
        OfficeUrlPreviewHostRenderResult r101 = new OfficeUrlPreviewHostRenderResult("RENDER_FAILED", 1);
        RENDER_FAILED = r101;
        OfficeUrlPreviewHostRenderResult r102 = new OfficeUrlPreviewHostRenderResult("NO_DATA", 2);
        NO_DATA = r102;
        OfficeUrlPreviewHostRenderResult r103 = new OfficeUrlPreviewHostRenderResult("NO_RENDER", 3);
        NO_RENDER = r103;
        OfficeUrlPreviewHostRenderResult[] r104 = {r100, r101, r102, r103};
        f364832a = r104;
        f364833b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeUrlPreviewHostRenderResult[] values() {
        return (OfficeUrlPreviewHostRenderResult[]) f364832a.clone();
    }

    public static OfficeUrlPreviewHostRenderResult valueOf(String r100) {
        return (OfficeUrlPreviewHostRenderResult) r27.a.a(OfficeUrlPreviewHostRenderResult.class, r100);
    }

    public OfficeUrlPreviewHostRenderResult(String r100, int r101) {
        super(r100, r101);
    }
}
