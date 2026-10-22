package com.larus.chat.gallery.impl.preview.toolbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarVisualStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "MEDIA_SOURCE_V4", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolbarVisualStyle extends Enum<ToolbarVisualStyle> {
    public static final ToolbarVisualStyle LEGACY = null;
    public static final ToolbarVisualStyle MEDIA_SOURCE_V4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarVisualStyle[] f324679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324680b = null;

    public static EnumEntries<ToolbarVisualStyle> getEntries() {
        return f324680b;
    }

    static {
        ToolbarVisualStyle r100 = new ToolbarVisualStyle("LEGACY", 0);
        LEGACY = r100;
        ToolbarVisualStyle r101 = new ToolbarVisualStyle("MEDIA_SOURCE_V4", 1);
        MEDIA_SOURCE_V4 = r101;
        ToolbarVisualStyle[] r102 = {r100, r101};
        f324679a = r102;
        f324680b = EnumEntriesKt.enumEntries(r102);
    }

    public static ToolbarVisualStyle[] values() {
        return (ToolbarVisualStyle[]) f324679a.clone();
    }

    public static ToolbarVisualStyle valueOf(String r100) {
        return (ToolbarVisualStyle) r27.a.a(ToolbarVisualStyle.class, r100);
    }

    public ToolbarVisualStyle(String r100, int r101) {
        super(r100, r101);
    }
}
