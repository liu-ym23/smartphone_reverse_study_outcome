package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/AnimationEventDetail;", "", "animationName", "", "animationType", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnimationName", "()Ljava/lang/String;", "setAnimationName", "(Ljava/lang/String;)V", "getAnimationType", "setAnimationType", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimationEventDetail {
    private String animationName;
    private String animationType;

    public final String getAnimationName() {
        return this.animationName;
    }

    public final String getAnimationType() {
        return this.animationType;
    }

    public final void setAnimationName(String r100) {
        this.animationName = r100;
    }

    public final void setAnimationType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.animationType = r100;
    }

    public AnimationEventDetail(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "animationType");
        this.animationName = r100;
        this.animationType = r101;
    }

    public /* synthetic */ AnimationEventDetail(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101);
    }
}
