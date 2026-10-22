package com.larus.bmhome.chat.standarduikit.richmedia.view;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaOverlayAlignment;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, GXAnimation.STATE_END, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaOverlayAlignment extends Enum<RichMediaOverlayAlignment> {
    public static final RichMediaOverlayAlignment END = null;
    public static final RichMediaOverlayAlignment START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichMediaOverlayAlignment[] f309602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309603b = null;

    public static EnumEntries<RichMediaOverlayAlignment> getEntries() {
        return f309603b;
    }

    static {
        RichMediaOverlayAlignment r100 = new RichMediaOverlayAlignment(GXAnimation.STATE_START, 0);
        START = r100;
        RichMediaOverlayAlignment r101 = new RichMediaOverlayAlignment(GXAnimation.STATE_END, 1);
        END = r101;
        RichMediaOverlayAlignment[] r102 = {r100, r101};
        f309602a = r102;
        f309603b = EnumEntriesKt.enumEntries(r102);
    }

    public static RichMediaOverlayAlignment[] values() {
        return (RichMediaOverlayAlignment[]) f309602a.clone();
    }

    public static RichMediaOverlayAlignment valueOf(String r100) {
        return (RichMediaOverlayAlignment) a.a(RichMediaOverlayAlignment.class, r100);
    }

    public RichMediaOverlayAlignment(String r100, int r101) {
        super(r100, r101);
    }
}
