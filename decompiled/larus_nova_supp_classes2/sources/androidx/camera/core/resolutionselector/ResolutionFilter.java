package androidx.camera.core.resolutionselector;

import android.util.Size;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ResolutionFilter {
    List<Size> filter(List<Size> r1, int r2);
}
