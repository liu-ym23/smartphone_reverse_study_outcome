package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerRenderPart;", "", "<init>", "(Ljava/lang/String;I)V", "SPACER", "CONTENT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerRenderPart extends Enum<BubbleBannerRenderPart> {
    public static final BubbleBannerRenderPart CONTENT = null;
    public static final BubbleBannerRenderPart SPACER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerRenderPart[] f297467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297468b = null;

    public static EnumEntries<BubbleBannerRenderPart> getEntries() {
        return f297468b;
    }

    static {
        BubbleBannerRenderPart r100 = new BubbleBannerRenderPart("SPACER", 0);
        SPACER = r100;
        BubbleBannerRenderPart r101 = new BubbleBannerRenderPart("CONTENT", 1);
        CONTENT = r101;
        BubbleBannerRenderPart[] r102 = {r100, r101};
        f297467a = r102;
        f297468b = EnumEntriesKt.enumEntries(r102);
    }

    public static BubbleBannerRenderPart[] values() {
        return (BubbleBannerRenderPart[]) f297467a.clone();
    }

    public static BubbleBannerRenderPart valueOf(String r100) {
        return (BubbleBannerRenderPart) r27.a.a(BubbleBannerRenderPart.class, r100);
    }

    public BubbleBannerRenderPart(String r100, int r101) {
        super(r100, r101);
    }
}
