package com.larus.bmhome.chat.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/input/SendImageCacheScope;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_CACHE", "EXTERNAL_FILES", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendImageCacheScope extends Enum<SendImageCacheScope> {
    public static final SendImageCacheScope EXTERNAL_FILES = null;
    public static final SendImageCacheScope INTERNAL_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendImageCacheScope[] f303329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303330b = null;

    public static EnumEntries<SendImageCacheScope> getEntries() {
        return f303330b;
    }

    static {
        SendImageCacheScope r100 = new SendImageCacheScope("INTERNAL_CACHE", 0);
        INTERNAL_CACHE = r100;
        SendImageCacheScope r101 = new SendImageCacheScope("EXTERNAL_FILES", 1);
        EXTERNAL_FILES = r101;
        SendImageCacheScope[] r102 = {r100, r101};
        f303329a = r102;
        f303330b = EnumEntriesKt.enumEntries(r102);
    }

    public static SendImageCacheScope[] values() {
        return (SendImageCacheScope[]) f303329a.clone();
    }

    public static SendImageCacheScope valueOf(String r100) {
        return (SendImageCacheScope) a.a(SendImageCacheScope.class, r100);
    }

    public SendImageCacheScope(String r100, int r101) {
        super(r100, r101);
    }
}
