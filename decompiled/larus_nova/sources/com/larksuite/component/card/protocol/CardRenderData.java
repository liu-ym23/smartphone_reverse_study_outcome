package com.larksuite.component.card.protocol;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J=\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larksuite/component/card/protocol/CardRenderData;", "Ljava/io/Serializable;", "linkType", "Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "bizID", "", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "cardConfig", "Lcom/larksuite/component/card/protocol/CardConfig;", "<init>", "(Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;Ljava/lang/String;Lcom/larksuite/component/card/protocol/CardData;Lcom/larksuite/component/card/protocol/CardContext;Lcom/larksuite/component/card/protocol/CardConfig;)V", "getLinkType", "()Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "getBizID", "()Ljava/lang/String;", "getCardData", "()Lcom/larksuite/component/card/protocol/CardData;", "getCardContext", "()Lcom/larksuite/component/card/protocol/CardContext;", "setCardContext", "(Lcom/larksuite/component/card/protocol/CardContext;)V", "getCardConfig", "()Lcom/larksuite/component/card/protocol/CardConfig;", "setCardConfig", "(Lcom/larksuite/component/card/protocol/CardConfig;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LinkType", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardRenderData implements Serializable {
    private final String bizID;
    private CardConfig cardConfig;
    private CardContext cardContext;
    private final CardData cardData;
    private final LinkType linkType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "STREAMING_POLLING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LinkType extends Enum<LinkType> {
        public static final LinkType MESSAGE = null;
        public static final LinkType STREAMING_POLLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkType[] f283893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283894b = null;

        public static EnumEntries<LinkType> getEntries() {
            return f283894b;
        }

        static {
            LinkType r100 = new LinkType("MESSAGE", 0);
            MESSAGE = r100;
            LinkType r101 = new LinkType("STREAMING_POLLING", 1);
            STREAMING_POLLING = r101;
            LinkType[] r102 = {r100, r101};
            f283893a = r102;
            f283894b = EnumEntriesKt.enumEntries(r102);
        }

        public static LinkType[] values() {
            return (LinkType[]) f283893a.clone();
        }

        public static LinkType valueOf(String r100) {
            return (LinkType) a.a(LinkType.class, r100);
        }

        public LinkType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ CardRenderData copy$default(CardRenderData r100, LinkType r101, String r102, CardData r103, CardContext r104, CardConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.linkType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bizID;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cardData;
    L11:
        CardData r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.cardContext;
    L14:
        CardContext r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.cardConfig;
    L17:
        LinkType r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final LinkType component1() {
        return this.linkType;
    }

    public final String component2() {
        return this.bizID;
    }

    public final CardData component3() {
        return this.cardData;
    }

    public final CardContext component4() {
        return this.cardContext;
    }

    public final CardConfig component5() {
        return this.cardConfig;
    }

    public final CardRenderData copy(LinkType r100, String r101, CardData r110, CardContext r111, CardConfig r112) {
        Intrinsics.checkNotNullParameter(r101, "bizID");
        Intrinsics.checkNotNullParameter(r110, "cardData");
        Intrinsics.checkNotNullParameter(r111, "cardContext");
        Intrinsics.checkNotNullParameter(r112, "cardConfig");
        return new CardRenderData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardRenderData) == true) goto L8;
        return false;
    L8:
        CardRenderData r101 = (CardRenderData) r100;
        if (this.linkType == r101.linkType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizID, r101.bizID) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardData, r101.cardData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardContext, r101.cardContext) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardConfig, r101.cardConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        LinkType r100 = this.linkType;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((r101 * 31) + this.bizID.hashCode()) * 31) + this.cardData.hashCode()) * 31) + this.cardContext.hashCode()) * 31) + this.cardConfig.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "CardRenderData(linkType=" + this.linkType + ", bizID=" + this.bizID + ", cardData=" + this.cardData + ", cardContext=" + this.cardContext + ", cardConfig=" + this.cardConfig + ')';
    }

    public final String getBizID() {
        return this.bizID;
    }

    public final CardConfig getCardConfig() {
        return this.cardConfig;
    }

    public final CardContext getCardContext() {
        return this.cardContext;
    }

    public final CardData getCardData() {
        return this.cardData;
    }

    public final LinkType getLinkType() {
        return this.linkType;
    }

    public final void setCardConfig(CardConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardConfig = r100;
    }

    public final void setCardContext(CardContext r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardContext = r100;
    }

    public CardRenderData(LinkType r100, String r101, CardData r102, CardContext r103, CardConfig r104) {
        Intrinsics.checkNotNullParameter(r101, "bizID");
        Intrinsics.checkNotNullParameter(r102, "cardData");
        Intrinsics.checkNotNullParameter(r103, "cardContext");
        Intrinsics.checkNotNullParameter(r104, "cardConfig");
        this.linkType = r100;
        this.bizID = r101;
        this.cardData = r102;
        this.cardContext = r103;
        this.cardConfig = r104;
    }
}
