package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes24.dex */
public final class BlurProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BlurProcessor f283997a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f283998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f283999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f284000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i<Bitmap> f284001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f284002e;

        public a(Context r100, Bitmap r101, int r102, j r103, float r104) {
            this.f283998a = r100;
            this.f283999b = r101;
            this.f284000c = r102;
            this.f284001d = r103;
            this.f284002e = r104;
        }

        public final void a() {
            Objects.toString(ThreadMethodProxy.currentThread());
            RenderScript r100 = RenderScript.create(this.f283998a);
            Bitmap r101 = Bitmap.createBitmap(this.f283999b.getWidth() / this.f284000c, this.f283999b.getHeight() / this.f284000c, Bitmap.Config.ARGB_8888);
            Canvas r102 = new Canvas(r101);
            int r103 = this.f284000c;
            r102.scale(1.0f / r103, 1.0f / r103);
            r102.drawBitmap(this.f283999b, 0.0f, 0.0f, new Paint(2));
            Bitmap r104 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation r105 = Allocation.createFromBitmap(r100, r101);
            Allocation r106 = Allocation.createFromBitmap(r100, r104);
            ScriptIntrinsicBlur r107 = ScriptIntrinsicBlur.create(r100, Element.U8_4(r100));
            r107.setRadius(this.f284002e);
            r107.setInput(r105);
            r107.forEach(r106);
            r106.copyTo(r104);
            r100.destroy();
            this.f284001d.resumeWith(Result.m9449constructorimpl(r104));
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
    }

    static {
        f283997a = new BlurProcessor();
    }

    public BlurProcessor() {
    }

    public final Object b(Context r100, Bitmap r101, int r102, Continuation<? super Drawable> r103) {
        if ((r103 instanceof BlurProcessor$process$1) == false) goto L7;
        BlurProcessor$process$1 r104 = (BlurProcessor$process$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = r104.I$0;
        r100 = (Context) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        Bitmap r109 = (Bitmap) r106;
        new Canvas(r109).drawColor(r102);
        return new BitmapDrawable(r100.getResources(), r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r100;
        r104.I$0 = r102;
        r104.label = 1;
        r106 = a(r100, r101, 25.0f, 6, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new BlurProcessor$process$1(this, r103);
        goto L8
    }

    public static Object a(Context r100, Bitmap r110, float r111, int r112, Continuation r113) {
        j r101 = new j(IntrinsicsKt.intercepted(r113), 1);
        r101.C();
        CoreThreadPool.getDefault().getFixedThreadPool().submit(new a(r100, r110, r112, r101, r111));
        Object r102 = r101.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r113);
    L5:
        return r102;
    }
}
