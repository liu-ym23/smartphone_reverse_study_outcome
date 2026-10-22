package com.ss.android.photoeditor.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f449535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextEditorView f449536b;

    public final void a() {
        TextEditorDrawView r100 = this.f449536b.f449491a;
        r100.n();
        RectF r101 = new RectF(0.0f, 0.0f, r100.f449436m.width(), r100.f449436m.height());
        r100.f449447x = r101;
        if (r100.f449429f != null) goto L6;
        r100.f449429f = Bitmap.createBitmap((int) r101.width(), (int) r100.f449447x.height(), Bitmap.Config.ARGB_4444);
        r100.f449433j = new Canvas(r100.f449429f);
    L6:
        if (r100.f449430g != null) goto L9;
        r100.f449430g = Bitmap.createBitmap((int) r100.f449447x.width(), (int) r100.f449447x.height(), Bitmap.Config.ARGB_4444);
        r100.f449435l = new Canvas(r100.f449430g);
    L9:
        if (r100.f449431h != null) goto L11;
        r100.f449431h = Bitmap.createBitmap((int) r100.f449447x.width(), (int) r100.f449447x.height(), Bitmap.Config.ARGB_4444);
        r100.f449434k = new Canvas(r100.f449431h);
    L11:
        r100.f449432i = Bitmap.createScaledBitmap(r100.f449428e, (int) r100.f449447x.width(), (int) r100.f449447x.height(), true);
        r100.f449441r = new ArrayList();
        r100.f449442s = new TextEditorDrawView.f(r100);
        r100.f449443t = new RectF(r100.f449436m);
        pfc.f.b r102 = pfc.f.i().d();
        TextEditorDrawView.e r103 = new TextEditorDrawView.e();
        r100.f449448y = r103;
        r103.f449451a = new RectF(r102.f529058a);
        TextEditorDrawView.e r104 = r100.f449448y;
        r104.f449452b = new RectF(r102.f529059b);
        TextEditorDrawView.e r105 = r100.f449448y;
        r105.f449453c = r102.f529060c;
        r105.f449454d = new RectF(r100.f449447x);
        r100.o();
        wfc.e r106 = r100.f449442s.a(r100.getWidth() / 2, r100.getHeight() / 2);
        r100.f449440q = r106;
        if (r106 != null) goto L14;
    L16:
        r100.m(true);
        TextEditorView r107 = this.f449536b;
        r107.f449492b.setTextEditorView(r107.f449491a.getTextStickerController());
        this.f449536b.f449492b.f449468d = true;
        Runnable r108 = this.f449535a;
        if (r108 == null) goto L20;
        r108.run();
        return;
    L20:
        return;
    L14:
        if (r106.f559525q == true) goto L16;
        r106.f559525q = true;
        r106.b();
        goto L16
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

    public f(TextEditorView r100, TextPhotoEditorPlugin.a r101) {
        this.f449536b = r100;
        this.f449535a = r101;
    }
}
