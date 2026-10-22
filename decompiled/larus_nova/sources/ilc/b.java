package ilc;

import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final String a(ModelInfo r100) {
        ExtendedUrlModel r101 = r100.getFile_url();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getUri();
    }
}
