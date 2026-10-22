package androidx.camera.video;

import android.net.Uri;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutputResults {
    public OutputResults() {
    }

    public abstract Uri getOutputUri();

    public static OutputResults of(Uri r1) {
        Preconditions.checkNotNull(r1, "OutputUri cannot be null.");
        return new AutoValue_OutputResults(r1);
    }
}
