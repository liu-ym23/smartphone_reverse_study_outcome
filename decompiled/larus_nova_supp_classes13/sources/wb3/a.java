package wb3;

import com.bytedance.android.ec.core.utils.y;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements y.b {
    public a() {
    }

    public final void onFailure() {
    }

    public final void onSuccess(DataSource<CloseableReference<CloseableImage>> r1) {
        if (r1 == null) goto L5;
        r1.close();
        return;
    }
}
