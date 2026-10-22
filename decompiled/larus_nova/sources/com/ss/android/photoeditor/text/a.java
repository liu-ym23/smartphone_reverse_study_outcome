package com.ss.android.photoeditor.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f449529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextEditorDrawView f449530b;

    public final void a() {
        TextEditorDrawView r100 = this.f449530b;
        int r101 = TextEditorDrawView.D;
        r100.n();
        TextEditorDrawView r102 = this.f449530b;
        r102.f449443t.set(r102.f449436m);
        this.f449530b.f449447x = new RectF(0.0f, 0.0f, this.f449530b.f449436m.width(), this.f449530b.f449436m.height());
        TextEditorDrawView r103 = this.f449530b;
        r103.f449429f = Bitmap.createBitmap((int) r103.f449447x.width(), (int) this.f449530b.f449447x.height(), Bitmap.Config.ARGB_4444);
        this.f449530b.f449433j = new Canvas(this.f449530b.f449429f);
        TextEditorDrawView r104 = this.f449530b;
        r104.f449430g = Bitmap.createBitmap((int) r104.f449447x.width(), (int) this.f449530b.f449447x.height(), Bitmap.Config.ARGB_4444);
        this.f449530b.f449435l = new Canvas(this.f449530b.f449430g);
        TextEditorDrawView r105 = this.f449530b;
        r105.f449431h = Bitmap.createBitmap((int) r105.f449447x.width(), (int) this.f449530b.f449447x.height(), Bitmap.Config.ARGB_4444);
        this.f449530b.f449434k = new Canvas(this.f449530b.f449431h);
        TextEditorDrawView r106 = this.f449530b;
        r106.f449432i = Bitmap.createScaledBitmap(r106.f449428e, (int) r106.f449447x.width(), (int) this.f449530b.f449447x.height(), true);
        pfc.f.b r107 = pfc.f.i().d();
        RectF r108 = new RectF(r107.f529058a);
        RectF r109 = new RectF(r107.f529059b);
        RectF r110 = new RectF(0.0f, 0.0f, this.f449530b.f449436m.width(), this.f449530b.f449436m.height());
        int r111 = r107.f529060c;
        RectF r112 = new RectF(this.f449530b.f449448y.f449451a);
        RectF r113 = new RectF(this.f449530b.f449448y.f449452b);
        RectF r114 = new RectF(this.f449530b.f449448y.f449454d);
        TextEditorDrawView.e r115 = this.f449530b.f449448y;
        int r116 = r115.f449453c;
        r115.f449451a = new RectF(r108);
        this.f449530b.f449448y.f449452b = new RectF(r109);
        TextEditorDrawView.e r117 = this.f449530b.f449448y;
        r117.f449453c = r111;
        r117.f449454d = new RectF(r110);
        if (((r116 / 90) % 2) != 0) goto L5;
        float r118 = r112.width();
        float r119 = r114.width();
    L6:
        float r120 = r118 / r119;
        com.ss.android.photoeditor.util.b.f(r114, 0.0f, 0.0f, r120, r120);
        TextEditorDrawView.j(this.f449530b, r120);
        int r121 = -r116;
        com.ss.android.photoeditor.util.b.d(r114, r121, 0.0f, 0.0f);
        Iterator r122 = ((ArrayList) this.f449530b.f449441r).iterator();
    L8:
        if (r122.hasNext() == false) goto L10;
        wfc.e r123 = (wfc.e) r122.next();
        com.ss.android.photoeditor.util.b.c(r123.f559510b, 0.0f, 0.0f, r121);
        r123.f559511c += r121;
        r123.f();
        goto L8
    L10:
        float r124 = r112.centerX() - r114.centerX();
        float r125 = r112.centerY() - r114.centerY();
        r114.offset(r124, r125);
        TextEditorDrawView.l(this.f449530b, r124, r125);
        float r126 = r109.width() / r113.width();
        com.ss.android.photoeditor.util.b.f(r112, 0.0f, 0.0f, r126, r126);
        com.ss.android.photoeditor.util.b.f(r113, 0.0f, 0.0f, r126, r126);
        TextEditorDrawView.j(this.f449530b, r126);
        float r127 = r109.left - r113.left;
        float r128 = r109.top - r113.top;
        r112.offset(r127, r128);
        r113.offset(r127, r128);
        TextEditorDrawView.l(this.f449530b, r127, r128);
        if (((r111 / 90) % 2) != 0) goto L13;
        float r129 = r110.width();
        float r130 = r108.width();
    L14:
        float r131 = r129 / r130;
        com.ss.android.photoeditor.util.b.f(r108, 0.0f, 0.0f, r131, r131);
        com.ss.android.photoeditor.util.b.f(r112, 0.0f, 0.0f, r131, r131);
        TextEditorDrawView.j(this.f449530b, r131);
        com.ss.android.photoeditor.util.b.d(r108, r111, 0.0f, 0.0f);
        com.ss.android.photoeditor.util.b.d(r112, r111, 0.0f, 0.0f);
        Iterator r132 = ((ArrayList) this.f449530b.f449441r).iterator();
    L16:
        if (r132.hasNext() == false) goto L18;
        wfc.e r133 = (wfc.e) r132.next();
        com.ss.android.photoeditor.util.b.c(r133.f559510b, 0.0f, 0.0f, r111);
        r133.f559511c += r111;
        r133.f();
        goto L16
    L18:
        float r134 = r110.centerX() - r108.centerX();
        float r135 = r110.centerY() - r108.centerY();
        r108.offset(r134, r135);
        r112.offset(r134, r135);
        TextEditorDrawView.l(this.f449530b, r134, r135);
        TextEditorDrawView r136 = this.f449530b;
        Iterator r137 = ((HashMap) r136.A).keySet().iterator();
    L20:
        if (r137.hasNext() == false) goto L22;
        wfc.e r138 = (wfc.e) r137.next();
        TextEditorDrawView.g r139 = (TextEditorDrawView.g) ((HashMap) r136.A).get(r138);
        TextEditorDrawView.e r140 = r136.f449448y;
        RectF r141 = r140.f449454d;
        RectF r142 = r140.f449451a;
        RectF r143 = r140.f449452b;
        int r144 = r140.f449453c;
        r139.getClass();
        r139.f449459f = new RectF(r142);
        r139.f449460g = new RectF(r143);
        r139.f449461h = r144;
        r139.f449457d = new RectF(r141);
        r139.f449458e = r138;
        Log.d("updateLocationInfo", "updateLocationInfo");
        goto L20
    L22:
        this.f449530b.m(true);
        Runnable r145 = this.f449529a;
        if (r145 == null) goto L29;
        r145.run();
        return;
    L29:
        return;
    L13:
        r129 = r110.height();
        r130 = r108.width();
        goto L14
    L5:
        r118 = r112.height();
        r119 = r114.width();
        goto L6
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

    public a(TextEditorDrawView r100, Runnable r101) {
        this.f449530b = r100;
        this.f449529a = r101;
    }
}
