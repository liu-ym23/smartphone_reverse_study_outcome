package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes22.dex */
public class SVGImageView extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f272930c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SVG f272931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f272932b;

    public class a extends PthreadAsyncTask<Integer, Integer, SVG> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f272933h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f272934i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ SVGImageView f272935j;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Integer[] r101 = (Integer[]) r100;
            Context r102 = this.f272933h;     // Catch: SVGParseException -> L10
            int r103 = this.f272934i;     // Catch: SVGParseException -> L10
            Resources r104 = r102.getResources();     // Catch: SVGParseException -> L10
            SVGParser r105 = new SVGParser();     // Catch: SVGParseException -> L10
            InputStream r106 = r104.openRawResource(r103);     // Catch: SVGParseException -> L10
            SVG r107 = r105.g(r106);     // Catch: Throwable -> L7
            r106.close();     // Catch: SVGParseException -> L10 IOException -> L13
            return r107;
        L23:
            return r107;
        L7:
            th = move-exception;
            r106.close();     // Catch: IOException -> L14 SVGParseException -> L10
        L9:
            throw th;     // Catch: SVGParseException -> L10
        L10:
            e = move-exception;
            String.format("Error loading resource 0x%x: %s", new Object[]{Integer.valueOf(this.f272934i), e.getMessage()});
            return null;
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            SVGImageView r101 = this.f272935j;
            r101.f272931a = (SVG) r100;
            r101.a();
        }

        public a(SVGImageView r100, Context r101, int r102) {
            this.f272935j = r100;
            this.f272933h = r101;
            this.f272934i = r102;
        }
    }

    public class b extends PthreadAsyncTask<InputStream, Integer, SVG> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SVGImageView f272936h;

        public b(SVGImageView r100) {
            this.f272936h = r100;
        }

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            InputStream[] r101 = (InputStream[]) r100;
            SVG r102 = SVG.d(r101[0]);     // Catch: Throwable -> L6 SVGParseException -> L8
            r101[0].close();     // Catch: IOException -> L15
            return r102;
        L28:
            return r102;
        L8:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L6
            r101[0].close();     // Catch: IOException -> L17
        L11:
            return null;
        L6:
            th = move-exception;
            r101[0].close();     // Catch: IOException -> L16
        L14:
            throw th;
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            SVGImageView r101 = this.f272936h;
            r101.f272931a = (SVG) r100;
            r101.a();
        }
    }

    static {
        f272930c = View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});     // Catch: NoSuchMethodException -> L4
        return;
    }

    public final void a() {
        SVG r100 = this.f272931a;
        if (r100 != null) goto L5;
        return;
    L5:
        Picture r101 = r100.g(this.f272932b);
        Method r102 = f272930c;
        if (r102 != null) goto L12;
    L9:
        setImageDrawable(new PictureDrawable(r101));
        return;
    L12:
        r102.invoke(this, new Object[]{Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null});     // Catch: Exception -> L11
        goto L9
    }

    public SVGImageView(Context r100) {
        super(r100);
        this.f272931a = null;
        this.f272932b = new c();
    }

    private void setFromString(String r100) {
        this.f272931a = new SVGParser().g(new ByteArrayInputStream(r100.getBytes()));     // Catch: SVGParseException -> L4
        a();     // Catch: SVGParseException -> L4
        return;
    }

    public final boolean c(String r100) {
        InputStream r101 = getContext().getAssets().open(r100);     // Catch: IOException -> L5
        new b(this).execute1(new InputStream[]{r101});     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    public final boolean d(Uri r100) {
        InputStream r101 = ContentResolverWrapper.openInputStream(getContext().getContentResolver(), r100);     // Catch: FileNotFoundException -> L5
        new b(this).execute1(new InputStream[]{r101});     // Catch: FileNotFoundException -> L5
        return true;
    L5:
        return false;
    }

    public void setCSS(String r100) {
        c r101 = this.f272932b;
        r101.getClass();
        CSSParser.Source r102 = CSSParser.Source.RenderOptions;
        CSSParser r103 = new CSSParser(CSSParser.MediaType.screen, r102);
        CSSParser.c r104 = new CSSParser.c(r100);
        r104.q();
        r101.f272985a = r103.e(r104);
        a();
    }

    public void setImageAsset(String r100) {
        if (c(r100) == false) goto L5;
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        new a(this, getContext(), r100).execute1(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        if (d(r100) == true) goto L6;
        Objects.toString(r100);
        return;
    }

    public void setSVG(SVG r100) {
        if (r100 == null) goto L6;
        this.f272931a = r100;
        a();
        return;
    L6:
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f272931a = null;
        this.f272932b = new c();
        b(r101, 0);
    }

    public final void b(AttributeSet r100, int r101) {
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        TypedArray r102 = getContext().getTheme().obtainStyledAttributes(r100, new int[]{R.attr.css, R.attr.svg}, r101, 0);
        String r103 = r102.getString(0);     // Catch: Throwable -> L27
        if (r103 == null) goto L9;
        c r104 = this.f272932b;     // Catch: Throwable -> L27
        r104.getClass();     // Catch: Throwable -> L27
        CSSParser.Source r105 = CSSParser.Source.RenderOptions;     // Catch: Throwable -> L27
        CSSParser r106 = new CSSParser(CSSParser.MediaType.screen, r105);     // Catch: Throwable -> L27
        CSSParser.c r107 = new CSSParser.c(r103);     // Catch: Throwable -> L27
        r107.q();     // Catch: Throwable -> L27
        r104.f272985a = r106.e(r107);     // Catch: Throwable -> L27
    L9:
        int r108 = r102.getResourceId(1, -1);     // Catch: Throwable -> L27
        if (r108 == (-1)) goto L14;
        setImageResource(r108);     // Catch: Throwable -> L27
        r102.recycle();
        return;
    L14:
        String r109 = r102.getString(1);     // Catch: Throwable -> L27
        if (r109 != null) goto L17;
    L25:
        r102.recycle();
        return;
    L17:
        if (d(Uri.parse(r109)) == false) goto L21;
        r102.recycle();
        return;
    L21:
        if (c(r109) == false) goto L24;
        r102.recycle();
        return;
    L24:
        setFromString(r109);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    public SVGImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f272931a = null;
        this.f272932b = new c();
        b(r101, r102);
    }
}
