package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bean/SuggestItemType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VideoRichMediaWelcomeBack", "ArticleRichMediaWelcomeBack", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SuggestItemType extends Enum<SuggestItemType> {
    public static final SuggestItemType ArticleRichMediaWelcomeBack = null;
    public static final SuggestItemType VideoRichMediaWelcomeBack = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SuggestItemType[] f297438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297439b = null;
    private final int value;

    public static EnumEntries<SuggestItemType> getEntries() {
        return f297439b;
    }

    static {
        SuggestItemType r100 = new SuggestItemType("VideoRichMediaWelcomeBack", 0, 150);
        VideoRichMediaWelcomeBack = r100;
        SuggestItemType r101 = new SuggestItemType("ArticleRichMediaWelcomeBack", 1, 151);
        ArticleRichMediaWelcomeBack = r101;
        SuggestItemType[] r102 = {r100, r101};
        f297438a = r102;
        f297439b = EnumEntriesKt.enumEntries(r102);
    }

    public static SuggestItemType[] values() {
        return (SuggestItemType[]) f297438a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SuggestItemType valueOf(String r100) {
        return (SuggestItemType) r27.a.a(SuggestItemType.class, r100);
    }

    public SuggestItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
