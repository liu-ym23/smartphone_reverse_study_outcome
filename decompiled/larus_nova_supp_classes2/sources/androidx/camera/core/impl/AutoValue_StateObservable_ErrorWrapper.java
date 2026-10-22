package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_StateObservable_ErrorWrapper extends StateObservable.ErrorWrapper {
    private final Throwable error;

    public int hashCode() {
        return this.error.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.error + "}";
    }

    @Override // androidx.camera.core.impl.StateObservable.ErrorWrapper
    public Throwable getError() {
        return this.error;
    }

    public AutoValue_StateObservable_ErrorWrapper(Throwable r2) {
        if (r2 == null) goto L7;
        this.error = r2;
        return;
    L7:
        throw new NullPointerException("Null error");
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof StateObservable.ErrorWrapper) == true) goto L8;
        return false;
    L8:
        return this.error.equals(((StateObservable.ErrorWrapper) r2).getError());
    }
}
