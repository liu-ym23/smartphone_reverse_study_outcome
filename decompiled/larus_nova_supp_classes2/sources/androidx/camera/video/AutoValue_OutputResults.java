package androidx.camera.video;

import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_OutputResults extends OutputResults {
    private final Uri outputUri;

    public int hashCode() {
        return this.outputUri.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.outputUri + "}";
    }

    @Override // androidx.camera.video.OutputResults
    public Uri getOutputUri() {
        return this.outputUri;
    }

    public AutoValue_OutputResults(Uri r2) {
        if (r2 == null) goto L7;
        this.outputUri = r2;
        return;
    L7:
        throw new NullPointerException("Null outputUri");
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof OutputResults) == true) goto L8;
        return false;
    L8:
        return this.outputUri.equals(((OutputResults) r2).getOutputUri());
    }
}
