package com.larus.audioplayer.api.news;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audioplayer/api/news/SOURCE_TYPE;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "URL", "VIDEO_MODEL", "LOCAL_FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SOURCE_TYPE extends Enum<SOURCE_TYPE> {
    public static final SOURCE_TYPE LOCAL_FILE = null;
    public static final SOURCE_TYPE URL = null;
    public static final SOURCE_TYPE VIDEO_MODEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SOURCE_TYPE[] f290183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290184b = null;
    private final int value;

    public static EnumEntries<SOURCE_TYPE> getEntries() {
        return f290184b;
    }

    static {
        SOURCE_TYPE r100 = new SOURCE_TYPE("URL", 0, 0);
        URL = r100;
        SOURCE_TYPE r101 = new SOURCE_TYPE("VIDEO_MODEL", 1, 1);
        VIDEO_MODEL = r101;
        SOURCE_TYPE r102 = new SOURCE_TYPE("LOCAL_FILE", 2, 3);
        LOCAL_FILE = r102;
        SOURCE_TYPE[] r103 = {r100, r101, r102};
        f290183a = r103;
        f290184b = EnumEntriesKt.enumEntries(r103);
    }

    public static SOURCE_TYPE[] values() {
        return (SOURCE_TYPE[]) f290183a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SOURCE_TYPE valueOf(String r100) {
        return (SOURCE_TYPE) a.a(SOURCE_TYPE.class, r100);
    }

    public SOURCE_TYPE(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
