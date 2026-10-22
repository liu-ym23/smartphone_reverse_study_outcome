package com.larus.chat.gallery.impl.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/PreviewChromeKind;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "MEDIA_SOURCE_V4", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewChromeKind extends Enum<PreviewChromeKind> {
    public static final PreviewChromeKind LEGACY = null;
    public static final PreviewChromeKind MEDIA_SOURCE_V4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewChromeKind[] f324212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324213b = null;

    public static EnumEntries<PreviewChromeKind> getEntries() {
        return f324213b;
    }

    static {
        PreviewChromeKind r100 = new PreviewChromeKind("LEGACY", 0);
        LEGACY = r100;
        PreviewChromeKind r101 = new PreviewChromeKind("MEDIA_SOURCE_V4", 1);
        MEDIA_SOURCE_V4 = r101;
        PreviewChromeKind[] r102 = {r100, r101};
        f324212a = r102;
        f324213b = EnumEntriesKt.enumEntries(r102);
    }

    public static PreviewChromeKind[] values() {
        return (PreviewChromeKind[]) f324212a.clone();
    }

    public static PreviewChromeKind valueOf(String r100) {
        return (PreviewChromeKind) r27.a.a(PreviewChromeKind.class, r100);
    }

    public PreviewChromeKind(String r100, int r101) {
        super(r100, r101);
    }
}
