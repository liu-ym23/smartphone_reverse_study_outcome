package com.ss.android.lark.chat.entity.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;", "Ljava/io/Serializable;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/ss/android/lark/chat/entity/message/AIButtonStrategy;", "customizeButtons", "", "Lcom/ss/android/lark/chat/entity/message/AIButtonType;", "aiAnswerMarkdownData", "", "buttonGroup", "Lcom/ss/android/lark/chat/entity/message/CustomizeAIButtonGroup;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/AIButtonStrategy;Ljava/util/List;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/CustomizeAIButtonGroup;)V", "getStrategy", "()Lcom/ss/android/lark/chat/entity/message/AIButtonStrategy;", "getCustomizeButtons", "()Ljava/util/List;", "getAiAnswerMarkdownData", "()Ljava/lang/String;", "getButtonGroup", "()Lcom/ss/android/lark/chat/entity/message/CustomizeAIButtonGroup;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIButtonConfig implements Serializable {
    private final String aiAnswerMarkdownData;
    private final CustomizeAIButtonGroup buttonGroup;
    private final List<AIButtonType> customizeButtons;
    private final AIButtonStrategy strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIButtonConfig copy$default(AIButtonConfig r100, AIButtonStrategy r101, List r102, String r103, CustomizeAIButtonGroup r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.strategy;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.customizeButtons;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.aiAnswerMarkdownData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.buttonGroup;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final AIButtonStrategy component1() {
        return this.strategy;
    }

    public final List<AIButtonType> component2() {
        return this.customizeButtons;
    }

    public final String component3() {
        return this.aiAnswerMarkdownData;
    }

    public final CustomizeAIButtonGroup component4() {
        return this.buttonGroup;
    }

    public final AIButtonConfig copy(AIButtonStrategy r100, List<? extends AIButtonType> r101, String r102, CustomizeAIButtonGroup r103) {
        return new AIButtonConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIButtonConfig) == true) goto L8;
        return false;
    L8:
        AIButtonConfig r101 = (AIButtonConfig) r100;
        if (this.strategy == r101.strategy) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.customizeButtons, r101.customizeButtons) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.aiAnswerMarkdownData, r101.aiAnswerMarkdownData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonGroup, r101.buttonGroup) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        AIButtonStrategy r100 = this.strategy;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<AIButtonType> r104 = this.customizeButtons;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.aiAnswerMarkdownData;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CustomizeAIButtonGroup r110 = this.buttonGroup;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AIButtonConfig(strategy=" + this.strategy + ", customizeButtons=" + this.customizeButtons + ", aiAnswerMarkdownData=" + this.aiAnswerMarkdownData + ", buttonGroup=" + this.buttonGroup + ')';
    }

    public final String getAiAnswerMarkdownData() {
        return this.aiAnswerMarkdownData;
    }

    public final CustomizeAIButtonGroup getButtonGroup() {
        return this.buttonGroup;
    }

    public final List<AIButtonType> getCustomizeButtons() {
        return this.customizeButtons;
    }

    public final AIButtonStrategy getStrategy() {
        return this.strategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIButtonConfig(AIButtonStrategy r100, List<? extends AIButtonType> r101, String r102, CustomizeAIButtonGroup r103) {
        this.strategy = r100;
        this.customizeButtons = r101;
        this.aiAnswerMarkdownData = r102;
        this.buttonGroup = r103;
    }
}
