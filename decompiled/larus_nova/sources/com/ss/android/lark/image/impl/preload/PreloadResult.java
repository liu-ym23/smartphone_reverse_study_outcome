package com.ss.android.lark.image.impl.preload;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\"\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/PreloadResult;", "", "scene", "", "sceneID", "imageKey", DyPayConstant.KEY_START_TIME, "", "preloadingDuration", "", "state", "Lcom/ss/android/lark/image/impl/preload/ResultState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILcom/ss/android/lark/image/impl/preload/ResultState;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getSceneID", "setSceneID", "getImageKey", "setImageKey", "getStartTime", "()J", "setStartTime", "(J)V", "getPreloadingDuration", "()I", "setPreloadingDuration", "(I)V", "getState", "()Lcom/ss/android/lark/image/impl/preload/ResultState;", "setState", "(Lcom/ss/android/lark/image/impl/preload/ResultState;)V", "toString", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreloadResult {
    private String imageKey;
    private int preloadingDuration;
    private String scene;
    private String sceneID;
    private long startTime;
    private ResultState state;

    public String toString() {
        return "scene:" + this.scene + ",sceneID:" + this.sceneID + ",imageKey:" + this.imageKey + ",startTime:" + this.startTime + ",preloadingDuration:" + this.preloadingDuration + ",state:" + this.state.getValue();
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public final int getPreloadingDuration() {
        return this.preloadingDuration;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSceneID() {
        return this.sceneID;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final ResultState getState() {
        return this.state;
    }

    public final void setPreloadingDuration(int r100) {
        this.preloadingDuration = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setState(ResultState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public PreloadResult(String r100, String r101, String r102, long r103, int r104, ResultState r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "sceneID");
        Intrinsics.checkNotNullParameter(r102, "imageKey");
        Intrinsics.checkNotNullParameter(r105, "state");
        this.scene = r100;
        this.sceneID = r101;
        this.imageKey = r102;
        this.startTime = r103;
        this.preloadingDuration = r104;
        this.state = r105;
    }
}
