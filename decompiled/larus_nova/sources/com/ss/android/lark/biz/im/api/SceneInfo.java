package com.ss.android.lark.biz.im.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/biz/im/api/SceneInfo;", "Ljava/io/Serializable;", "sceneId", "", "sceneName", "", "<init>", "(JLjava/lang/String;)V", "getSceneId", "()J", "getSceneName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneInfo implements Serializable {
    private final long sceneId;
    private final String sceneName;

    public static /* synthetic */ SceneInfo copy$default(SceneInfo r100, long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sceneId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sceneName;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.sceneId;
    }

    public final String component2() {
        return this.sceneName;
    }

    public final SceneInfo copy(long r100, String r101) {
        return new SceneInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SceneInfo) == true) goto L8;
        return false;
    L8:
        SceneInfo r101 = (SceneInfo) r100;
        if (this.sceneId == r101.sceneId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneName, r101.sceneName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.sceneId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.sceneName;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "SceneInfo(sceneId=" + this.sceneId + ", sceneName=" + this.sceneName + ')';
    }

    public final long getSceneId() {
        return this.sceneId;
    }

    public final String getSceneName() {
        return this.sceneName;
    }

    public SceneInfo(long r100, String r101) {
        this.sceneId = r100;
        this.sceneName = r101;
    }
}
