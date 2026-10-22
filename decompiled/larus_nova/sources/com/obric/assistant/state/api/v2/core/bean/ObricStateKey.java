package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricStateKey;", "", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "<init>", "(Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;)V", "getConversationId", "()Ljava/lang/String;", "getScene", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateKey {
    private final String conversationId;
    private final ObricInteractionScene scene;

    public static /* synthetic */ ObricStateKey copy$default(ObricStateKey r100, String r101, ObricInteractionScene r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final ObricInteractionScene component2() {
        return this.scene;
    }

    public final ObricStateKey copy(String r100, ObricInteractionScene r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        return new ObricStateKey(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricStateKey) == true) goto L8;
        return false;
    L8:
        ObricStateKey r101 = (ObricStateKey) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.scene == r101.scene) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.conversationId.hashCode() * 31) + this.scene.hashCode();
    }

    public String toString() {
        return "ObricStateKey(conversationId=" + this.conversationId + ", scene=" + this.scene + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final ObricInteractionScene getScene() {
        return this.scene;
    }

    public ObricStateKey(String r100, ObricInteractionScene r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.conversationId = r100;
        this.scene = r101;
    }

    public /* synthetic */ ObricStateKey(String r100, ObricInteractionScene r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ObricInteractionScene.DEFAULT;
    L5:
        this(r100, r101);
    }
}
