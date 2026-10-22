package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ok2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardPopStrategyConfig;", "Ljava/io/Serializable;", "", "component1", "component2", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;", "component3", "Lok2/a;", "component4", "cardPopupType", "cardContinuousControl", "cardDensityControl", "autoPopConfig", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getCardPopupType", "()I", "getCardContinuousControl", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;", "getCardDensityControl", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;", "Lok2/a;", "getAutoPopConfig", "()Lok2/a;", "<init>", "(IILcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;Lok2/a;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardPopStrategyConfig implements Serializable {

    @SerializedName("ec_live_pop_card_show_automatic_config")
    private final a autoPopConfig;

    @SerializedName("ec_live_card_same_card_continuous_control")
    private final int cardContinuousControl;

    @SerializedName("ec_live_card_same_card_density_control")
    private final ExplainCardDensityControl cardDensityControl;

    @SerializedName("ec_live_card_pop_up_type")
    private final int cardPopupType;

    public ExplainCardPopStrategyConfig() {
        this(0, 0, null, null, 15, null);
    }

    public static /* synthetic */ ExplainCardPopStrategyConfig copy$default(ExplainCardPopStrategyConfig r0, int r1, int r2, ExplainCardDensityControl r3, a r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.cardPopupType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cardContinuousControl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.cardDensityControl;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.autoPopConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.cardPopupType;
    }

    public final int component2() {
        return this.cardContinuousControl;
    }

    public final ExplainCardDensityControl component3() {
        return this.cardDensityControl;
    }

    public final a component4() {
        return this.autoPopConfig;
    }

    public final ExplainCardPopStrategyConfig copy(int r2, int r3, ExplainCardDensityControl r4, a r5) {
        return new ExplainCardPopStrategyConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ExplainCardPopStrategyConfig) == false) goto L14;
        ExplainCardPopStrategyConfig r4 = (ExplainCardPopStrategyConfig) r3;
        if (this.cardPopupType == r4.cardPopupType) goto L8;
        return false;
    L8:
        if (this.cardContinuousControl == r4.cardContinuousControl) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cardDensityControl, r4.cardDensityControl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoPopConfig, r4.autoPopConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = ((this.cardPopupType * 31) + this.cardContinuousControl) * 31;
        ExplainCardDensityControl r1 = this.cardDensityControl;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        a r5 = this.autoPopConfig;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "ExplainCardPopStrategyConfig(cardPopupType=" + this.cardPopupType + ", cardContinuousControl=" + this.cardContinuousControl + ", cardDensityControl=" + this.cardDensityControl + ", autoPopConfig=" + this.autoPopConfig + ")";
    }

    public final a getAutoPopConfig() {
        return this.autoPopConfig;
    }

    public final int getCardContinuousControl() {
        return this.cardContinuousControl;
    }

    public final ExplainCardDensityControl getCardDensityControl() {
        return this.cardDensityControl;
    }

    public final int getCardPopupType() {
        return this.cardPopupType;
    }

    public ExplainCardPopStrategyConfig(int r1, int r2, ExplainCardDensityControl r3, a r4) {
        this.cardPopupType = r1;
        this.cardContinuousControl = r2;
        this.cardDensityControl = r3;
        this.autoPopConfig = r4;
    }

    public /* synthetic */ ExplainCardPopStrategyConfig(int r2, int r3, ExplainCardDensityControl r4, a r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
