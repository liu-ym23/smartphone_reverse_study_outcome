package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerSource;", "", "<init>", "(Ljava/lang/String;I)V", "CMD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerSource extends Enum<BubbleBannerSource> {
    public static final BubbleBannerSource CMD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerSource[] f297469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297470b = null;

    public static EnumEntries<BubbleBannerSource> getEntries() {
        return f297470b;
    }

    static {
        BubbleBannerSource r100 = new BubbleBannerSource();
        CMD = r100;
        BubbleBannerSource[] r101 = {r100};
        f297469a = r101;
        f297470b = EnumEntriesKt.enumEntries(r101);
    }

    public BubbleBannerSource() {
        super("CMD", 0);
    }

    public static BubbleBannerSource[] values() {
        return (BubbleBannerSource[]) f297469a.clone();
    }

    public static BubbleBannerSource valueOf(String r100) {
        return (BubbleBannerSource) r27.a.a(BubbleBannerSource.class, r100);
    }
}
