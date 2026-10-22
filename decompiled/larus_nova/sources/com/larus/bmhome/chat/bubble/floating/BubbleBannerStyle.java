package com.larus.bmhome.chat.bubble.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerStyle;", "", "layout", "", "<init>", "(Ljava/lang/String;II)V", "getLayout", "()I", "DEFAULT", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleBannerStyle extends Enum<BubbleBannerStyle> {
    public static final a Companion = null;
    public static final BubbleBannerStyle DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BubbleBannerStyle f297473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ BubbleBannerStyle[] f297474b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297475c = null;
    private final int layout;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BubbleBannerStyle> getEntries() {
        return f297475c;
    }

    static {
        BubbleBannerStyle r100 = new BubbleBannerStyle();
        DEFAULT = r100;
        BubbleBannerStyle[] r101 = {r100};
        f297474b = r101;
        f297475c = EnumEntriesKt.enumEntries(r101);
        Companion = new a();
        f297473a = r100;
    }

    public BubbleBannerStyle() {
        super("DEFAULT", 0);
        this.layout = 1;
    }

    public static BubbleBannerStyle[] values() {
        return (BubbleBannerStyle[]) f297474b.clone();
    }

    public static final /* synthetic */ BubbleBannerStyle access$getDEFAULT_STYLE$cp() {
        return f297473a;
    }

    public final int getLayout() {
        return this.layout;
    }

    public static BubbleBannerStyle valueOf(String r100) {
        return (BubbleBannerStyle) r27.a.a(BubbleBannerStyle.class, r100);
    }
}
