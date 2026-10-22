package p8a;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ResizeOptions f528254f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f528256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f528257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DraweeHolder<GenericDraweeHierarchy> f528258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f528259e;

    static {
        f528254f = new ResizeOptions(1000, 1000);
    }

    public q(String r100, final boolean r101, boolean r102, s r103) {
        CountDownLatch r104 = new CountDownLatch(1);
        this.f528257c = r104;
        this.f528255a = r100;
        this.f528256b = r103;
        UIThreadUtils.runOnUiThreadImmediately(new n(this, r101));
        if (r102 == false) goto L9;
        r104.await(100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L6
        return;
    L10:
        return;
    }
}
