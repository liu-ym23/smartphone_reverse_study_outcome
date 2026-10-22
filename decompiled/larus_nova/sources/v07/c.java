package v07;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends AnimationBackendDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552315a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f552315a;
    }

    public c(AnimationBackend r100, int r101) {
        super(r100);
        this.f552315a = r101;
    }
}
