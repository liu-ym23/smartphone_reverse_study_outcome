package com.larus.chat.gallery.impl.preview.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/data/LocalMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocalMediaType extends Enum<LocalMediaType> {
    public static final LocalMediaType IMAGE = null;
    public static final LocalMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalMediaType[] f324230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324231b = null;

    public static EnumEntries<LocalMediaType> getEntries() {
        return f324231b;
    }

    static {
        LocalMediaType r100 = new LocalMediaType("IMAGE", 0);
        IMAGE = r100;
        LocalMediaType r101 = new LocalMediaType("VIDEO", 1);
        VIDEO = r101;
        LocalMediaType[] r102 = {r100, r101};
        f324230a = r102;
        f324231b = EnumEntriesKt.enumEntries(r102);
    }

    public static LocalMediaType[] values() {
        return (LocalMediaType[]) f324230a.clone();
    }

    public static LocalMediaType valueOf(String r100) {
        return (LocalMediaType) a.a(LocalMediaType.class, r100);
    }

    public LocalMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
