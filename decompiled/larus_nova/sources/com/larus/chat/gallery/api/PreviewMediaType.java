package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewMediaType extends Enum<PreviewMediaType> {
    public static final PreviewMediaType IMAGE = null;
    public static final PreviewMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewMediaType[] f324110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324111b = null;

    public static EnumEntries<PreviewMediaType> getEntries() {
        return f324111b;
    }

    static {
        PreviewMediaType r100 = new PreviewMediaType("IMAGE", 0);
        IMAGE = r100;
        PreviewMediaType r101 = new PreviewMediaType("VIDEO", 1);
        VIDEO = r101;
        PreviewMediaType[] r102 = {r100, r101};
        f324110a = r102;
        f324111b = EnumEntriesKt.enumEntries(r102);
    }

    public static PreviewMediaType[] values() {
        return (PreviewMediaType[]) f324110a.clone();
    }

    public static PreviewMediaType valueOf(String r100) {
        return (PreviewMediaType) r27.a.a(PreviewMediaType.class, r100);
    }

    public PreviewMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
