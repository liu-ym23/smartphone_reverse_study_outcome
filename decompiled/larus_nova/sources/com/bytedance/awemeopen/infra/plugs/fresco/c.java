package com.bytedance.awemeopen.infra.plugs.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    public static class a extends BasePostprocessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l64.b f198857a;

        public a(l64.b r100) {
            this.f198857a = r100;
        }

        @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
        public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
            CloseableReference<Bitmap> r102 = r101.createBitmap(r100.getWidth(), r100.getHeight());
            c.e(r100, r102.get(), this.f198857a.f507682q);     // Catch: Throwable -> L6
            CloseableReference<Bitmap> r103 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L6
            CloseableReference.closeSafely(r102);
            return r103;
        L6:
            th = move-exception;
            CloseableReference.closeSafely(r102);
            throw th;
        }

        @Override // com.facebook.imagepipeline.request.BasePostprocessor
        public final void process(Bitmap r100, Bitmap r101) {
            super.process(r100, r101);
        }
    }

    public static class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l64.a f198858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f198859b;

        public b(l64.a r100, l64.b r101) {
            this.f198859b = false;
            this.f198858a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            if (this.f198859b == false) goto L5;
            return;
        L5:
            this.f198859b = true;
            l64.a r102 = this.f198858a;
            if (r102 == null) goto L9;
            r102.onFail(new Exception(r101));
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            super.onIntermediateImageSet(r100, (ImageInfo) r101);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if (this.f198859b == true) goto L15;
            this.f198859b = true;
            l64.a r104 = this.f198858a;
            if (r104 == null) goto L8;
            r104.onSuccess();
        L8:
            if (r102 != null) goto L10;
            return;
        L10:
            if ((r102 instanceof AnimatedDrawable2) == false) goto L14;
            ((AnimatedDrawable2) r102).setAnimationListener(new f(this));
            return;
        L14:
            return;
        }
    }

    public static Bitmap a(Bitmap r110, l64.b r111) {
        float r100 = r111.f507677l / r110.getWidth();
        float r101 = r111.f507678m / r110.getHeight();
        int r102 = r110.getWidth();
        int r103 = r110.getHeight();
        Matrix r104 = new Matrix();
        if (r100 <= r101) goto L5;
        int r105 = (int) Math.ceil(r110.getHeight() * (r101 / r100));
        int r106 = (r110.getHeight() - r105) / 2;
        int r107 = r106;
        int r108 = r102;
        int r109 = r105;
        int r112 = 0;
        r101 = r111.f507678m / r105;
    L6:
        r104.preScale(r100, r101);
        return Bitmap.createBitmap(r110, r112, r107, r108, r109, r104, true);
    L5:
        int r113 = (int) Math.ceil(r110.getWidth() * (r100 / r101));
        int r114 = (r110.getWidth() - r113) / 2;
        r112 = r114;
        r108 = r113;
        r109 = r103;
        r107 = 0;
        r100 = r111.f507677l / r113;
        goto L6
    }

    public static void d(Context r100, l64.b r101) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.awemeopen.infra.plugs.fresco.c.d(android.content.Context, l64.b):void");
    }

    public static void b(Bitmap r100, Bitmap r101, l64.b r102) {
        Canvas r103 = new Canvas(r101);
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setColor(-12434878);
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        if (r102.f507682q == 0) goto L5;
        RectF r106 = new RectF(r105);
        float r107 = r102.f507682q;
        r103.drawRoundRect(r106, r107, r107, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    L5:
        r103.drawBitmap(r100, r105, r105, r104);
    }

    public static void e(Bitmap r100, Bitmap r101, int r102) {
        Canvas r103 = new Canvas(r101);
        Paint r104 = new Paint();
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        RectF r106 = new RectF(r105);
        float r107 = r102;
        r104.setAntiAlias(true);
        r103.drawARGB(0, 0, 0, 0);
        r104.setColor(-12434878);
        r103.drawRoundRect(r106, r107, r107, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, r105, r105, r104);
    }

    public static void c(Bitmap r100, Bitmap r101, int r102, int r103, l64.b r110) {
        float r104 = r103 / r100.getWidth();
        float r105 = r102 / r100.getHeight();
        Matrix r106 = new Matrix();
        Canvas r107 = new Canvas(r101);
        Paint r108 = new Paint();
        r108.setAntiAlias(true);
        r107.drawARGB(0, 0, 0, 0);
        r108.setColor(-12434878);
        r106.postScale(r104, r105);
        if (r110.f507682q == 0) goto L5;
        RectF r109 = new RectF(new Rect(0, 0, r103, r102));
        float r111 = r110.f507682q;
        r107.drawRoundRect(r109, r111, r111, r108);
        r108.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    L5:
        r107.drawBitmap(r100, r106, r108);
    }
}
