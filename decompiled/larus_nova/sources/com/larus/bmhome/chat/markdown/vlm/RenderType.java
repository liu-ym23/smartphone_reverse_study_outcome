package com.larus.bmhome.chat.markdown.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/RenderType;", "", "<init>", "(Ljava/lang/String;I)V", "Video", "Picture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType Picture = null;
    public static final RenderType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f307320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307321b = null;

    public static EnumEntries<RenderType> getEntries() {
        return f307321b;
    }

    static {
        RenderType r100 = new RenderType("Video", 0);
        Video = r100;
        RenderType r101 = new RenderType("Picture", 1);
        Picture = r101;
        RenderType[] r102 = {r100, r101};
        f307320a = r102;
        f307321b = EnumEntriesKt.enumEntries(r102);
    }

    public static RenderType[] values() {
        return (RenderType[]) f307320a.clone();
    }

    public static RenderType valueOf(String r100) {
        return (RenderType) a.a(RenderType.class, r100);
    }

    public RenderType(String r100, int r101) {
        super(r100, r101);
    }
}
