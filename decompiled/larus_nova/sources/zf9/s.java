package zf9;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.producers.ImageResizeOptionStrategy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends ImageResizeOptionStrategy {
    public s() {
    }

    @Override // com.facebook.imagepipeline.producers.ImageResizeOptionStrategy
    public final ResizeOptions getResizeConfig(Uri r100, int r101, int r102, int r110, int r111, boolean r112, ImageFormat r113) {
        Iterator<v> r114 = w.f571782a.iterator();
    L4:
        if (r114.hasNext() == false) goto L8;
        ResizeOptions r115 = r114.next().a(r100, r101, r102, r110, r111);
        if (r115 == null) goto L4;
        return r115;
    L8:
        return null;
    }
}
