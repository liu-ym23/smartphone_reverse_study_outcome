package com.larus.bmhome.share.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/share/network/WebpageSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEEP_RESEARCH", "CODE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebpageSource extends Enum<WebpageSource> {
    public static final WebpageSource CODE = null;
    public static final WebpageSource DEEP_RESEARCH = null;
    public static final WebpageSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebpageSource[] f313847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f313848b = null;
    private final int value;

    public static EnumEntries<WebpageSource> getEntries() {
        return f313848b;
    }

    static {
        WebpageSource r100 = new WebpageSource("UNKNOWN", 0, 1);
        UNKNOWN = r100;
        WebpageSource r101 = new WebpageSource("DEEP_RESEARCH", 1, 1);
        DEEP_RESEARCH = r101;
        WebpageSource r102 = new WebpageSource("CODE", 2, 2);
        CODE = r102;
        WebpageSource[] r103 = {r100, r101, r102};
        f313847a = r103;
        f313848b = EnumEntriesKt.enumEntries(r103);
    }

    public static WebpageSource[] values() {
        return (WebpageSource[]) f313847a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WebpageSource valueOf(String r100) {
        return (WebpageSource) r27.a.a(WebpageSource.class, r100);
    }

    public WebpageSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
