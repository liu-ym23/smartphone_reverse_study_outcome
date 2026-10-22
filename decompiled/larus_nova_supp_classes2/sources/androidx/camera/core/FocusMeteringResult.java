package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }

    private FocusMeteringResult(boolean r1) {
        this.mIsFocusSuccessful = r1;
    }

    public static FocusMeteringResult create(boolean r1) {
        return new FocusMeteringResult(r1);
    }
}
