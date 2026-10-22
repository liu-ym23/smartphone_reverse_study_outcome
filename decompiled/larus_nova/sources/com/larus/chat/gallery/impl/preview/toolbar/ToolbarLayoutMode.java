package com.larus.chat.gallery.impl.preview.toolbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarLayoutMode;", "", "<init>", "(Ljava/lang/String;I)V", "VERTICAL", "HORIZONTAL", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolbarLayoutMode extends Enum<ToolbarLayoutMode> {
    public static final a Companion = null;
    public static final ToolbarLayoutMode HORIZONTAL = null;
    public static final ToolbarLayoutMode VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarLayoutMode[] f324677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324678b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ToolbarLayoutMode> getEntries() {
        return f324678b;
    }

    static {
        ToolbarLayoutMode r100 = new ToolbarLayoutMode("VERTICAL", 0);
        VERTICAL = r100;
        ToolbarLayoutMode r101 = new ToolbarLayoutMode("HORIZONTAL", 1);
        HORIZONTAL = r101;
        ToolbarLayoutMode[] r102 = {r100, r101};
        f324677a = r102;
        f324678b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ToolbarLayoutMode[] values() {
        return (ToolbarLayoutMode[]) f324677a.clone();
    }

    public static ToolbarLayoutMode valueOf(String r100) {
        return (ToolbarLayoutMode) r27.a.a(ToolbarLayoutMode.class, r100);
    }

    public ToolbarLayoutMode(String r100, int r101) {
        super(r100, r101);
    }
}
