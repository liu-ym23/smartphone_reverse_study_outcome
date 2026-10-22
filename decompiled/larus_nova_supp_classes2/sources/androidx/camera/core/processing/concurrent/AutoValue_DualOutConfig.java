package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.OutConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_DualOutConfig extends DualOutConfig {
    private final OutConfig primaryOutConfig;
    private final OutConfig secondaryOutConfig;

    public int hashCode() {
        return ((this.primaryOutConfig.hashCode() ^ 1000003) * 1000003) ^ this.secondaryOutConfig.hashCode();
    }

    public String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.primaryOutConfig + ", secondaryOutConfig=" + this.secondaryOutConfig + "}";
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getPrimaryOutConfig() {
        return this.primaryOutConfig;
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getSecondaryOutConfig() {
        return this.secondaryOutConfig;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DualOutConfig) == false) goto L14;
        DualOutConfig r6 = (DualOutConfig) r5;
        if (this.primaryOutConfig.equals(r6.getPrimaryOutConfig()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.secondaryOutConfig.equals(r6.getSecondaryOutConfig()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_DualOutConfig(OutConfig r1, OutConfig r2) {
        if (r1 == null) goto L11;
        this.primaryOutConfig = r1;
        if (r2 == null) goto L9;
        this.secondaryOutConfig = r2;
        return;
    L9:
        throw new NullPointerException("Null secondaryOutConfig");
    L11:
        throw new NullPointerException("Null primaryOutConfig");
    }
}
