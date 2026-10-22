package androidx.camera.core;

import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class UseCaseGroup {
    private final List<CameraEffect> mEffects;
    private final List<UseCase> mUseCases;
    private final ViewPort mViewPort;

    public static final class Builder {
        private static final List<Integer> SUPPORTED_TARGETS = null;
        private final List<CameraEffect> mEffects;
        private final List<UseCase> mUseCases;
        private ViewPort mViewPort;

        static {
            SUPPORTED_TARGETS = Arrays.asList(new Integer[]{1, 2, 4, 3, 7});
        }

        private void checkEffectTargets() {
            Iterator<CameraEffect> r0 = this.mEffects.iterator();
            int r2 = 0;
        L4:
            if (r0.hasNext() == false) goto L10;
            int r3 = r0.next().getTargets();
            TargetUtils.checkSupportedTargets(SUPPORTED_TARGETS, r3);
            int r4 = r2 & r3;
            if (r4 > 0) goto L9;
            r2 = r2 | r3;
            goto L4
        L9:
            throw new IllegalArgumentException(String.format(Locale.US, "More than one effects has targets %s.", new Object[]{TargetUtils.getHumanReadableName(r4)}));
        }

        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            checkEffectTargets();
            return new UseCaseGroup(this.mViewPort, this.mUseCases, this.mEffects);
        }

        public Builder() {
            this.mUseCases = new ArrayList();
            this.mEffects = new ArrayList();
        }

        public Builder addEffect(CameraEffect r2) {
            this.mEffects.add(r2);
            return this;
        }

        public Builder addUseCase(UseCase r2) {
            this.mUseCases.add(r2);
            return this;
        }

        public Builder setViewPort(ViewPort r1) {
            this.mViewPort = r1;
            return this;
        }
    }

    public List<CameraEffect> getEffects() {
        return this.mEffects;
    }

    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }

    public UseCaseGroup(ViewPort r1, List<UseCase> r2, List<CameraEffect> r3) {
        this.mViewPort = r1;
        this.mUseCases = r2;
        this.mEffects = r3;
    }
}
