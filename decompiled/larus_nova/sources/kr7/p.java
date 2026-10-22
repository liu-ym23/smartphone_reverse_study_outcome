package kr7;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public final class p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ResizeOptions f505818l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f505819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f505820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxContext f505821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f505822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f505823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f505824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DraweeHolder<GenericDraweeHierarchy> f505825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f505826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PipelineDraweeControllerBuilder f505827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScalingUtils.ScaleType f505828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CountDownLatch f505829k;

    static {
        f505818l = new ResizeOptions(1000, 1000);
    }

    public LynxContext getContext() {
        return this.f505821c;
    }

    public p(final String r110, final LynxContext r111, final c r112, final ScalingUtils.ScaleType r113, final boolean r114, boolean r115) {
        this.f505822d = false;
        this.f505823e = null;
        CountDownLatch r100 = new CountDownLatch(1);
        this.f505829k = r100;
        UIThreadUtils.runOnUiThreadImmediately(new n(this, r110, r111, r112, r114, r113));
        if (r115 == false) goto L11;
        r100.await(100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
