package com.obric.livecard.api.entity;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/livecard/api/entity/NotificationSceneEntity;", "Lcom/obric/livecard/api/entity/ISceneEntity;", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "Lcom/obric/livecard/api/entity/SceneType;", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", "sceneDesc", "", "(Lcom/obric/livecard/api/entity/SceneType;Lcom/obric/livecard/api/entity/RuntimeState;Ljava/lang/String;)V", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "setRuntimeState", "(Lcom/obric/livecard/api/entity/RuntimeState;)V", "getSceneDesc", "()Ljava/lang/String;", "setSceneDesc", "(Ljava/lang/String;)V", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotificationSceneEntity implements ISceneEntity {
    private RuntimeState runtimeState;
    private String sceneDesc;
    private final SceneType sceneType;

    public NotificationSceneEntity() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NotificationSceneEntity copy$default(NotificationSceneEntity r100, SceneType r101, RuntimeState r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.getSceneType();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.getRuntimeState();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.getSceneDesc();
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final SceneType component1() {
        return getSceneType();
    }

    public final RuntimeState component2() {
        return getRuntimeState();
    }

    public final String component3() {
        return getSceneDesc();
    }

    public final NotificationSceneEntity copy(SceneType r100, RuntimeState r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        return new NotificationSceneEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NotificationSceneEntity) == true) goto L8;
        return false;
    L8:
        NotificationSceneEntity r101 = (NotificationSceneEntity) r100;
        if (getSceneType() == r101.getSceneType()) goto L12;
        return false;
    L12:
        if (getRuntimeState() == r101.getRuntimeState()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getSceneDesc(), r101.getSceneDesc()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = getSceneType().hashCode() * 31;
        int r101 = 0;
        if (getRuntimeState() != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (getSceneDesc() == null) goto L11;
        r101 = getSceneDesc().hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = getRuntimeState().hashCode();
        goto L6
    }

    public String toString() {
        return "NotificationSceneEntity(sceneType=" + getSceneType() + ", runtimeState=" + getRuntimeState() + ", sceneDesc=" + getSceneDesc() + ')';
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

    public void setRuntimeState(RuntimeState r100) {
        this.runtimeState = r100;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public void setSceneDesc(String r100) {
        this.sceneDesc = r100;
    }

    public NotificationSceneEntity(SceneType r100, RuntimeState r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        this.sceneType = r100;
        this.runtimeState = r101;
        this.sceneDesc = r102;
    }

    public /* synthetic */ NotificationSceneEntity(SceneType r100, RuntimeState r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = SceneType.NOTIFICATION;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = RuntimeState.PROCESSING;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
