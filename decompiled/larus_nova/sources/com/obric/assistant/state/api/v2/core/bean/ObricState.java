package com.obric.assistant.state.api.v2.core.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0003Jf\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "", "currentIslandState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "priority", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", "sourceMessageId", "taskCreatedTime", "", "ext", "", "<init>", "(Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getCurrentIslandState", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "getConversationId", "()Ljava/lang/String;", "getScene", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "getPriority", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", "getSourceMessageId", "getTaskCreatedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricState {
    private final String conversationId;
    private final ObricIslandStateType currentIslandState;
    private final Map<String, Object> ext;
    private final ObricIslandPriority priority;
    private final ObricInteractionScene scene;
    private final String sourceMessageId;
    private final Long taskCreatedTime;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricState copy$default(ObricState r100, ObricIslandStateType r101, String r102, ObricInteractionScene r103, ObricIslandPriority r104, String r110, Long r111, Map r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.currentIslandState;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.conversationId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.scene;
    L11:
        ObricInteractionScene r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.priority;
    L14:
        ObricIslandPriority r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.sourceMessageId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.taskCreatedTime;
    L20:
        Long r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.ext;
    L23:
        ObricIslandStateType r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final ObricIslandStateType component1() {
        return this.currentIslandState;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final ObricInteractionScene component3() {
        return this.scene;
    }

    public final ObricIslandPriority component4() {
        return this.priority;
    }

    public final String component5() {
        return this.sourceMessageId;
    }

    public final Long component6() {
        return this.taskCreatedTime;
    }

    public final Map<String, Object> component7() {
        return this.ext;
    }

    public final ObricState copy(ObricIslandStateType r110, String r111, ObricInteractionScene r112, ObricIslandPriority r113, String r114, Long r115, Map<String, ? extends Object> r116) {
        Intrinsics.checkNotNullParameter(r110, "currentIslandState");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "priority");
        Intrinsics.checkNotNullParameter(r116, "ext");
        return new ObricState(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricState) == true) goto L8;
        return false;
    L8:
        ObricState r101 = (ObricState) r100;
        if (this.currentIslandState == r101.currentIslandState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (this.scene == r101.scene) goto L18;
        return false;
    L18:
        if (this.priority == r101.priority) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceMessageId, r101.sourceMessageId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskCreatedTime, r101.taskCreatedTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.currentIslandState.hashCode() * 31) + this.conversationId.hashCode()) * 31;
        ObricInteractionScene r101 = this.scene;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.priority.hashCode()) * 31;
        String r105 = this.sourceMessageId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.taskCreatedTime;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.ext.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricState(currentIslandState=" + this.currentIslandState + ", conversationId=" + this.conversationId + ", scene=" + this.scene + ", priority=" + this.priority + ", sourceMessageId=" + this.sourceMessageId + ", taskCreatedTime=" + this.taskCreatedTime + ", ext=" + this.ext + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final ObricIslandStateType getCurrentIslandState() {
        return this.currentIslandState;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final ObricIslandPriority getPriority() {
        return this.priority;
    }

    public final ObricInteractionScene getScene() {
        return this.scene;
    }

    public final String getSourceMessageId() {
        return this.sourceMessageId;
    }

    public final Long getTaskCreatedTime() {
        return this.taskCreatedTime;
    }

    public ObricState(ObricIslandStateType r100, String r101, ObricInteractionScene r102, ObricIslandPriority r103, String r104, Long r105, Map<String, ? extends Object> r106) {
        Intrinsics.checkNotNullParameter(r100, "currentIslandState");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "priority");
        Intrinsics.checkNotNullParameter(r106, "ext");
        this.currentIslandState = r100;
        this.conversationId = r101;
        this.scene = r102;
        this.priority = r103;
        this.sourceMessageId = r104;
        this.taskCreatedTime = r105;
        this.ext = r106;
    }

    public /* synthetic */ ObricState(ObricIslandStateType r110, String r111, ObricInteractionScene r112, ObricIslandPriority r113, String r114, Long r115, Map r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        ObricInteractionScene r100 = ObricInteractionScene.DEFAULT;
    L7:
        if ((r117 & 8) == 0) goto L9;
        ObricIslandPriority r101 = ObricIslandPriority.LOW;
    L11:
        if ((r117 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        Map r104 = MapsKt.emptyMap();
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
