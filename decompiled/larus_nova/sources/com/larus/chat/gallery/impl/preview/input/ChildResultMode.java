package com.larus.chat.gallery.impl.preview.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/input/ChildResultMode;", "", "<init>", "(Ljava/lang/String;I)V", "APPEND", "ALBUM_APPEND", "EDIT_REPLACE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChildResultMode extends Enum<ChildResultMode> {
    public static final ChildResultMode ALBUM_APPEND = null;
    public static final ChildResultMode APPEND = null;
    public static final ChildResultMode EDIT_REPLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChildResultMode[] f324304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324305b = null;

    public static EnumEntries<ChildResultMode> getEntries() {
        return f324305b;
    }

    static {
        ChildResultMode r100 = new ChildResultMode("APPEND", 0);
        APPEND = r100;
        ChildResultMode r101 = new ChildResultMode("ALBUM_APPEND", 1);
        ALBUM_APPEND = r101;
        ChildResultMode r102 = new ChildResultMode("EDIT_REPLACE", 2);
        EDIT_REPLACE = r102;
        ChildResultMode[] r103 = {r100, r101, r102};
        f324304a = r103;
        f324305b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChildResultMode[] values() {
        return (ChildResultMode[]) f324304a.clone();
    }

    public static ChildResultMode valueOf(String r100) {
        return (ChildResultMode) r27.a.a(ChildResultMode.class, r100);
    }

    public ChildResultMode(String r100, int r101) {
        super(r100, r101);
    }
}
