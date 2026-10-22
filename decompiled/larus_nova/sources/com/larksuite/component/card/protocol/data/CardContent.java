package com.larksuite.component.card.protocol.data;

import com.larus.platform.model.SlashMentionConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/protocol/data/CardContent;", "Ljava/io/Serializable;", "cardJSON", "", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "<init>", "(Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/CardAttachment;)V", "getCardJSON", "()Ljava/lang/String;", "getAttachment", "()Lcom/larksuite/component/card/protocol/data/CardAttachment;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardContent implements Serializable {
    private final CardAttachment attachment;
    private final String cardJSON;

    public static /* synthetic */ CardContent copy$default(CardContent r100, String r101, CardAttachment r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.cardJSON;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.attachment;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.cardJSON;
    }

    public final CardAttachment component2() {
        return this.attachment;
    }

    public final CardContent copy(String r100, CardAttachment r101) {
        Intrinsics.checkNotNullParameter(r100, "cardJSON");
        Intrinsics.checkNotNullParameter(r101, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        return new CardContent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardContent) == true) goto L8;
        return false;
    L8:
        CardContent r101 = (CardContent) r100;
        if (Intrinsics.areEqual(this.cardJSON, r101.cardJSON) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachment, r101.attachment) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.cardJSON.hashCode() * 31) + this.attachment.hashCode();
    }

    public String toString() {
        return "CardContent(cardJSON=" + this.cardJSON + ", attachment=" + this.attachment + ')';
    }

    public final CardAttachment getAttachment() {
        return this.attachment;
    }

    public final String getCardJSON() {
        return this.cardJSON;
    }

    public CardContent(String r100, CardAttachment r101) {
        Intrinsics.checkNotNullParameter(r100, "cardJSON");
        Intrinsics.checkNotNullParameter(r101, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        this.cardJSON = r100;
        this.attachment = r101;
    }
}
