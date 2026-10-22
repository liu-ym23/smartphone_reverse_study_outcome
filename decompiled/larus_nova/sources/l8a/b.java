package l8a;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes32.dex */
public class b extends AnimationBackendDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f508070a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f508070a;
    }

    public b(AnimationBackend r100, int r101) {
        super(r100);
        this.f508070a = r101;
    }
}
