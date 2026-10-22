package com.larksuite.component.card.protocol;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/protocol/CardActionDataSource;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IM_CONTENT", "CARD_ENTITY", "STREAMING_CARD_ENTITY", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardActionDataSource extends Enum<CardActionDataSource> implements Serializable {
    public static final CardActionDataSource CARD_ENTITY = null;
    public static final CardActionDataSource IM_CONTENT = null;
    public static final CardActionDataSource STREAMING_CARD_ENTITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardActionDataSource[] f283858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f283859b = null;

    public static EnumEntries<CardActionDataSource> getEntries() {
        return f283859b;
    }

    static {
        CardActionDataSource r100 = new CardActionDataSource("IM_CONTENT", 0);
        IM_CONTENT = r100;
        CardActionDataSource r101 = new CardActionDataSource("CARD_ENTITY", 1);
        CARD_ENTITY = r101;
        CardActionDataSource r102 = new CardActionDataSource("STREAMING_CARD_ENTITY", 2);
        STREAMING_CARD_ENTITY = r102;
        CardActionDataSource[] r103 = {r100, r101, r102};
        f283858a = r103;
        f283859b = EnumEntriesKt.enumEntries(r103);
    }

    public static CardActionDataSource[] values() {
        return (CardActionDataSource[]) f283858a.clone();
    }

    public static CardActionDataSource valueOf(String r100) {
        return (CardActionDataSource) a.a(CardActionDataSource.class, r100);
    }

    public CardActionDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
