package da4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.bdp.bdpplatform.service.image.BdpImageServiceImpl;
import com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.bytedance.bdp.serviceapi.defaults.ui.model.d;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f467681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f467682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BdpThreadService f467683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageView f467684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BdpImageServiceImpl f467685e;

    public final void a() {
        Uri r100 = this.f467681a.f201590b;
        if (r100 != null) goto L5;
    L14:
        Bitmap r101 = BitmapFactory.decodeStream(ContentResolverWrapper.openInputStream(this.f467682b.getContentResolver(), this.f467681a.f201590b));     // Catch: FileNotFoundException -> L9
    L12:
        BdpImageServiceImpl r102 = this.f467685e;
        BdpThreadService r103 = this.f467683c;
        ImageView r104 = this.f467684d;
        r102.getClass();
        r103.c(new c(r101, r104));
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        r101 = null;
        goto L12
    L5:
        if (r100.toString().startsWith("http") == false) goto L14;
        d r105 = this.f467681a;
        r105.f201589a = r105.f201590b.toString();
        BdpImageServiceImpl.E2(this.f467685e, this.f467681a);
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(BdpImageServiceImpl r100, d r101, PreviewImageActivity r102, BdpThreadService r103, ImageView r104) {
        this.f467685e = r100;
        this.f467681a = r101;
        this.f467682b = r102;
        this.f467683c = r103;
        this.f467684d = r104;
    }
}
