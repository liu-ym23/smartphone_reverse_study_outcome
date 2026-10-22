package com.obric.livecard.api.entity;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003JG\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/obric/livecard/api/entity/TaskSceneEntity;", "Lcom/obric/livecard/api/entity/ISceneEntity;", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "Lcom/obric/livecard/api/entity/SceneType;", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", "content", "", "iconUrl", "priority", "", "sceneDesc", "(Lcom/obric/livecard/api/entity/SceneType;Lcom/obric/livecard/api/entity/RuntimeState;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getPriority", "()I", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "setRuntimeState", "(Lcom/obric/livecard/api/entity/RuntimeState;)V", "getSceneDesc", "setSceneDesc", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskSceneEntity implements ISceneEntity {
    private String content;
    private String iconUrl;
    private final int priority;
    private RuntimeState runtimeState;
    private String sceneDesc;
    private final SceneType sceneType;

    public static /* synthetic */ TaskSceneEntity copy$default(TaskSceneEntity r100, SceneType r101, RuntimeState r102, String r103, String r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.getSceneType();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.getRuntimeState();
    L8:
        RuntimeState r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.iconUrl;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.priority;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.getSceneDesc();
    L20:
        SceneType r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final SceneType component1() {
        return getSceneType();
    }

    public final RuntimeState component2() {
        return getRuntimeState();
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final int component5() {
        return this.priority;
    }

    public final String component6() {
        return getSceneDesc();
    }

    public final TaskSceneEntity copy(SceneType r100, RuntimeState r110, String r111, String r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r110, "runtimeState");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "iconUrl");
        return new TaskSceneEntity(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskSceneEntity) == true) goto L8;
        return false;
    L8:
        TaskSceneEntity r101 = (TaskSceneEntity) r100;
        if (getSceneType() == r101.getSceneType()) goto L12;
        return false;
    L12:
        if (getRuntimeState() == r101.getRuntimeState()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L21;
        return false;
    L21:
        if (this.priority == r101.priority) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getSceneDesc(), r101.getSceneDesc()) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((getSceneType().hashCode() * 31) + getRuntimeState().hashCode()) * 31) + this.content.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.priority) * 31;
        if (getSceneDesc() != null) goto L5;
        int r101 = 0;
    L7:
        return r100 + r101;
    L5:
        r101 = getSceneDesc().hashCode();
        goto L7
    }

    public String toString() {
        return "TaskSceneEntity(sceneType=" + getSceneType() + ", runtimeState=" + getRuntimeState() + ", content=" + this.content + ", iconUrl=" + this.iconUrl + ", priority=" + this.priority + ", sceneDesc=" + getSceneDesc() + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public RuntimeState getRuntimeState() {
        return this.runtimeState;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public String getSceneDesc() {
        return this.sceneDesc;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public SceneType getSceneType() {
        return this.sceneType;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setIconUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iconUrl = r100;
    }

    public void setRuntimeState(RuntimeState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.runtimeState = r100;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public void setSceneDesc(String r100) {
        this.sceneDesc = r100;
    }

    public TaskSceneEntity(SceneType r100, RuntimeState r101, String r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r101, "runtimeState");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "iconUrl");
        this.sceneType = r100;
        this.runtimeState = r101;
        this.content = r102;
        this.iconUrl = r103;
        this.priority = r104;
        this.sceneDesc = r105;
    }

    public /* synthetic */ TaskSceneEntity(SceneType r100, RuntimeState r101, String r110, String r111, int r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = SceneType.AI_TASK;
    L5:
        SceneType r102 = r100;
        if ((r114 & 16) == 0) goto L8;
        int r103 = Integer.MAX_VALUE;
    L10:
        if ((r114 & 32) == 0) goto L12;
        r113 = null;
    L12:
        this(r102, r101, r110, r111, r103, r113);
        return;
    L8:
        r103 = r112;
        goto L10
    }
}
