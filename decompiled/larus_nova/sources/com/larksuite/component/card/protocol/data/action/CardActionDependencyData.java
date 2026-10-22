package com.larksuite.component.card.protocol.data.action;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "Ljava/io/Serializable;", "selectPersonCurrentChatId", "", "cardSceneIsGroup", "", "isEphemeralCard", "openUrlExtraParams", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;ZZLandroid/os/Bundle;)V", "getSelectPersonCurrentChatId", "()Ljava/lang/String;", "getCardSceneIsGroup", "()Z", "getOpenUrlExtraParams", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardActionDependencyData implements Serializable {
    private final boolean cardSceneIsGroup;
    private final boolean isEphemeralCard;
    private final Bundle openUrlExtraParams;
    private final String selectPersonCurrentChatId;

    public static /* synthetic */ CardActionDependencyData copy$default(CardActionDependencyData r100, String r101, boolean r102, boolean r103, Bundle r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.selectPersonCurrentChatId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.cardSceneIsGroup;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isEphemeralCard;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.openUrlExtraParams;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.selectPersonCurrentChatId;
    }

    public final boolean component2() {
        return this.cardSceneIsGroup;
    }

    public final boolean component3() {
        return this.isEphemeralCard;
    }

    public final Bundle component4() {
        return this.openUrlExtraParams;
    }

    public final CardActionDependencyData copy(String r100, boolean r101, boolean r102, Bundle r103) {
        return new CardActionDependencyData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardActionDependencyData) == true) goto L8;
        return false;
    L8:
        CardActionDependencyData r101 = (CardActionDependencyData) r100;
        if (Intrinsics.areEqual(this.selectPersonCurrentChatId, r101.selectPersonCurrentChatId) == true) goto L12;
        return false;
    L12:
        if (this.cardSceneIsGroup == r101.cardSceneIsGroup) goto L15;
        return false;
    L15:
        if (this.isEphemeralCard == r101.isEphemeralCard) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openUrlExtraParams, r101.openUrlExtraParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.selectPersonCurrentChatId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.cardSceneIsGroup == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.isEphemeralCard == true) goto L14;
        r104 = 1237;
    L14:
        int r107 = (r106 + r104) * 31;
        Bundle r108 = this.openUrlExtraParams;
        if (r108 == null) goto L19;
        r101 = r108.hashCode();
    L19:
        return r107 + r101;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CardActionDependencyData(selectPersonCurrentChatId=" + this.selectPersonCurrentChatId + ", cardSceneIsGroup=" + this.cardSceneIsGroup + ", isEphemeralCard=" + this.isEphemeralCard + ", openUrlExtraParams=" + this.openUrlExtraParams + ')';
    }

    public final boolean getCardSceneIsGroup() {
        return this.cardSceneIsGroup;
    }

    public final Bundle getOpenUrlExtraParams() {
        return this.openUrlExtraParams;
    }

    public final String getSelectPersonCurrentChatId() {
        return this.selectPersonCurrentChatId;
    }

    public final boolean isEphemeralCard() {
        return this.isEphemeralCard;
    }

    public CardActionDependencyData(String r100, boolean r101, boolean r102, Bundle r103) {
        this.selectPersonCurrentChatId = r100;
        this.cardSceneIsGroup = r101;
        this.isEphemeralCard = r102;
        this.openUrlExtraParams = r103;
    }

    public /* synthetic */ CardActionDependencyData(String r100, boolean r101, boolean r102, Bundle r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
