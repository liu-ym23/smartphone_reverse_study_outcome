package com.ss.android.lark.biz.officesdk.im.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewRenderResult;", "", "<init>", "(Ljava/lang/String;I)V", "NO_DATA", "NO_RENDER", "RENDER_FAILED", "SUCCESS", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UrlPreviewRenderResult extends Enum<UrlPreviewRenderResult> {
    public static final UrlPreviewRenderResult NO_DATA = null;
    public static final UrlPreviewRenderResult NO_RENDER = null;
    public static final UrlPreviewRenderResult RENDER_FAILED = null;
    public static final UrlPreviewRenderResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrlPreviewRenderResult[] f410613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410614b = null;

    public static EnumEntries<UrlPreviewRenderResult> getEntries() {
        return f410614b;
    }

    static {
        UrlPreviewRenderResult r100 = new UrlPreviewRenderResult("NO_DATA", 0);
        NO_DATA = r100;
        UrlPreviewRenderResult r101 = new UrlPreviewRenderResult("NO_RENDER", 1);
        NO_RENDER = r101;
        UrlPreviewRenderResult r102 = new UrlPreviewRenderResult("RENDER_FAILED", 2);
        RENDER_FAILED = r102;
        UrlPreviewRenderResult r103 = new UrlPreviewRenderResult("SUCCESS", 3);
        SUCCESS = r103;
        UrlPreviewRenderResult[] r104 = {r100, r101, r102, r103};
        f410613a = r104;
        f410614b = EnumEntriesKt.enumEntries(r104);
    }

    public static UrlPreviewRenderResult[] values() {
        return (UrlPreviewRenderResult[]) f410613a.clone();
    }

    public static UrlPreviewRenderResult valueOf(String r100) {
        return (UrlPreviewRenderResult) a.a(UrlPreviewRenderResult.class, r100);
    }

    public UrlPreviewRenderResult(String r100, int r101) {
        super(r100, r101);
    }
}
