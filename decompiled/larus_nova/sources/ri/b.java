package ri;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    void a(Activity r100, String r101, a r102);

    void b();

    void bindImage(SimpleDraweeView r100, String r101);

    void c(ECUrlModel r100, Function1 r101);

    void d();

    boolean isDownloaded(Uri r100);
}
