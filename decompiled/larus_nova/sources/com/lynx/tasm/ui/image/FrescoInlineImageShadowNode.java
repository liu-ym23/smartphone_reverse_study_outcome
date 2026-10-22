package com.lynx.tasm.ui.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public class FrescoInlineImageShadowNode extends AbsInlineImageShadowNode {
    public Uri Q;
    public ScalingUtils.ScaleType R;
    public final PipelineDraweeControllerBuilder S;
    public String T;
    public boolean U;
    public boolean V;
    public final a W;
    public int X;
    public CloseableReference<?> Y;
    public boolean Z;

    public class a extends BaseControllerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrescoInlineImageShadowNode f383837a;

        public a(FrescoInlineImageShadowNode r100) {
            this.f383837a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            if (r101 != null) goto L5;
            String r102 = "unknown";
        L6:
            this.f383837a.Q(r102);
            LynxError r103 = new LynxError(u7a.b.b(u7a.b.a(r101)), "Failed to load image", "", "error");
            r103.setRootCause(r102);
            this.f383837a.getContext().reportResourceError(this.f383837a.T, "image", r103);
            return;
        L5:
            r102 = r101.getMessage();
            goto L6
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, r101, r102);
            if ((r101 instanceof CloseableStaticBitmap) == false) goto L17;
            CloseableReference<Bitmap> r103 = ((CloseableStaticBitmap) r101).cloneUnderlyingBitmapReference();
            if (r103 != null) goto L8;
            this.f383837a.Q("reference null");
            this.f383837a.getContext().reportResourceError(this.f383837a.T, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap reference from response", "", "error"));
            return;
        L8:
            Bitmap r104 = r103.get();
            if (r104 != null) goto L12;
            this.f383837a.Q("bitmap null");
            this.f383837a.getContext().reportResourceError(this.f383837a.T, "image", new LynxError(30102, "Failed to load image，the reason is get null bitmap from response", "", "error"));
            return;
        L12:
            FrescoInlineImageShadowNode r105 = this.f383837a;
            if (r105.Z == false) goto L15;
            FrescoInlineImageShadowNode.T(r105);
            this.f383837a.Y = r103;
            LLog.i("FrescoInlineImageShadowNode", "clone reference mRef = " + this.f383837a.Y.hashCode());
        L15:
            this.f383837a.R(r104.getWidth(), r104.getHeight());
            return;
        L17:
            if ((r102 instanceof AnimatedDrawable2) == false) goto L21;
            AnimatedDrawable2 r106 = (AnimatedDrawable2) r102;
            int r107 = r106.getIntrinsicWidth();
            int r108 = r106.getIntrinsicHeight();
            r106.setAnimationBackend(new l8a.b(r106.getAnimationBackend(), this.f383837a.X));
            this.f383837a.R(r107, r108);
            m8a.e.c(r106);
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrescoInlineImageShadowNode f383838a;

        @Override // java.lang.Runnable
        public final void run() {
            FrescoInlineImageShadowNode.T(this.f383838a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FrescoInlineImageShadowNode r100) {
            this.f383838a = r100;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void s() {
        if (this.U == false) goto L14;
        Uri r100 = null;
        if (this.T != null) goto L7;
    L13:
        this.Q = r100;
        this.U = false;
        goto L14
    L7:
        if (this.V == true) goto L9;
        this.T = d7a.a.b(getContext(), this.T, false);
    L9:
        Uri r101 = UriProtector.parse(this.T);
        if (r101.getScheme() != null) goto L12;
        LLog.e("Lynx", "Image src should not be relative url : " + this.T);
        goto L13
    L12:
        r100 = r101;
    L14:
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        if (this.Z == false) goto L6;
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
        return;
    }

    public FrescoInlineImageShadowNode() {
        this.T = null;
        this.U = false;
        this.V = false;
        this.X = 0;
        this.Y = null;
        this.S = Fresco.newDraweeControllerBuilder();
        this.R = ScalingUtils.ScaleType.FIT_XY;
        this.W = new a(this);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a O() {
        Resources r100 = getContext().getResources();
        float r101 = this.f382209h.c();
        float r102 = this.f382209h.a();
        return new d(r100, (int) Math.ceil(r101), (int) Math.ceil(r102), this.f382209h.b(), this.Q, this.R, this.S, getContext().getFrescoCallerContext(), this.W);
    }

    public static void T(FrescoInlineImageShadowNode r100) {
        if (r100.Y == null) goto L6;
        LLog.i("FrescoInlineImageShadowNode", "close reference mRef = " + r100.Y.hashCode());
        r100.Y.close();
        r100.Y = null;
        return;
    }

    @LynxProp(name = "loop-count")
    public void setLoopCount(int r100) {
        if (r100 > 0) goto L4;
        r100 = 0;
    L4:
        this.X = r100;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r100) {
        this.R = o.b(r100);
    }

    @LynxProp(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r100) {
        this.V = r100;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r100) {
        this.T = r100;
        this.U = true;
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        super.w(r100);
        this.Z = r100.getEnableVSyncAligned();
    }
}
