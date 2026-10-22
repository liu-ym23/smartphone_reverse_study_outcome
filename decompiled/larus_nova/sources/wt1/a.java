package wt1;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends AnimationBackendDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f561181a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f561181a;
    }

    public a(AnimationBackend r100) {
        super(r100);
        this.f561181a = Integer.MAX_VALUE;
    }
}
