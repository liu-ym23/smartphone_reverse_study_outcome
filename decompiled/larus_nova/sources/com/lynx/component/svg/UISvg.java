package com.lynx.component.svg;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.serval.svg.SVGRender;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import java.nio.charset.Charset;
import java.util.Map;
import x5a.i;
import x5a.j;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(fragmentLayerRendererHost = x5a.d.class, isCreateAsync = true, supportFragmentLayerRender = true, tagName = {"svg", "x-svg"})
@LynxGeneratorName(packageName = "com.lynx.component.svg")
public class UISvg extends LynxUI<SvgImageView> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f380956l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f380957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f380958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f380959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.lynx.component.svg.d f380960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.lynx.component.svg.parser.c f380961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile SVG f380962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f380964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f380965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile SVGRender f380966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f380967k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UISvg f380968a;

        public final void a() {
            if (this.f380968a.f380962f != null) goto L5;
            return;
        L5:
            x5a.e r100 = new x5a.e(this.f380968a.f380962f, this.f380968a.f380961e, this.f380968a.f380960d);
            ((SvgImageView) UISvg.P(this.f380968a)).setImageDrawable(r100);
            this.f380968a.invalidate();
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

        public a(UISvg r100) {
            this.f380968a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UISvg f380969a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f380969a.f380960d.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(UISvg r100) {
            this.f380969a = r100;
        }
    }

    public class c implements com.lynx.component.svg.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UISvg f380970a;

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onStart() {
        }

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onSuccess() {
        }

        public c(UISvg r100) {
            this.f380970a = r100;
        }

        @Override // com.lynx.component.svg.d.InterfaceC4557d
        public final void onError(String r100) {
            LLog.e("lynx_UISvg", "requestSrc error! the src is " + this.f380970a.f380957a + " error message is" + r100);
        }

        @Override // com.lynx.component.svg.d.c
        public final void a(String r100, SVG r101) {
            UISvg r102 = this.f380970a;
            if (r102.f380963g == false) goto L6;
            r102.f380958b = r100;
            this.f380970a.U(r100, true);
            return;
        L6:
            if (LynxEnv.inst().enableSvgAsync() == false) goto L8;
            LynxThreadPool.e().execute(new x5a.h(r102, r101));
            return;
        L8:
            UIThreadUtils.runOnUiThread(new j(r102, r101));
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UISvg f380971a;

        public final void a() {
            SVG r100 = SVG.c(this.f380971a.f380958b);     // Catch: SVGParseException -> L10
            UISvg r101 = this.f380971a;     // Catch: SVGParseException -> L10
            r101.getClass();     // Catch: SVGParseException -> L10
            if (LynxEnv.inst().enableSvgAsync() == false) goto L8;
            r101.f380962f = r100;     // Catch: SVGParseException -> L10
            if (r101.f380962f == null) goto L13;
            UIThreadUtils.runOnUiThread(new i(r101, new x5a.e(r100, r101.f380961e, r101.f380960d), r100));     // Catch: SVGParseException -> L10
        L13:
            return;
        L8:
            UIThreadUtils.runOnUiThread(new j(r101, r100));     // Catch: SVGParseException -> L10
        L10:
            e = move-exception;
            LLog.e("lynx_UISvg", "onPropsUpdated():  the content is:" + this.f380971a.f380958b + "the error message is " + e.toString());
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

        public d(UISvg r100) {
            this.f380971a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f380972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f380973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UISvg f380974c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j6a.a f380975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f380976b;

            @Override // java.lang.Runnable
            public final void run() {
                ((SvgImageView) UISvg.N(this.f380976b.f380974c)).setImageDrawable(this.f380975a);     // Catch: Throwable -> L6
                this.f380976b.f380974c.invalidate();     // Catch: Throwable -> L6
                e r100 = this.f380976b;     // Catch: Throwable -> L6
                if (r100.f380973b == false) goto L9;
                UISvg.R(r100.f380974c, null);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public a(e r100, j6a.a r101) {
                this.f380976b = r100;
                this.f380975a = r101;
            }
        }

        public final void a() {
        L6:
            e = move-exception;
            LLog.e("lynx_UISvg", "setDrawable: the content: " + this.f380974c.f380958b + ", the error message: " + e.getMessage());
            return;
        L3:
            if (this.f380974c.f380966j == null) goto L11;
            this.f380974c.f380966j.setColor(this.f380974c.f380959c);     // Catch: Exception -> L6
            UIThreadUtils.runOnUiThread(new a(this, new j6a.a(this.f380974c.f380966j.renderPicture(this.f380972a, new Rect(0, 0, this.f380974c.getWidth(), this.f380974c.getHeight())))));     // Catch: Exception -> L6
            return;
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

        public e(UISvg r100, String r101, boolean r102) {
            this.f380974c = r100;
            this.f380972a = r101;
            this.f380973b = r102;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UISvg f380977a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PictureDrawable f380978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f380979b;

            @Override // java.lang.Runnable
            public final void run() {
                ((SvgImageView) UISvg.O(this.f380979b.f380977a)).setImageDrawable(this.f380978a);     // Catch: Throwable -> L4
                this.f380979b.f380977a.invalidate();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r100, x5a.e r101) {
                this.f380979b = r100;
                this.f380978a = r101;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f380977a.f380962f == null) goto L10;
            UIThreadUtils.runOnUiThread(new a(this, new x5a.e(this.f380977a.f380962f, this.f380977a.f380961e, this.f380977a.f380960d)));     // Catch: Throwable -> L7
            return;
        }

        public f(UISvg r100) {
            this.f380977a = r100;
        }
    }

    public UISvg() {
        throw null;
    }

    public final void S() {
        if (this.f380963g == false) goto L7;
        U(this.f380958b, false);
        return;
    L7:
        if (LynxEnv.inst().enableSvgAsync() == false) goto L9;
        LynxThreadPool.e().execute(new f(this));
        return;
    L9:
        UIThreadUtils.runOnUiThread(new a(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        if (this.f380962f == null) goto L7;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L7:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    public final void T() {
        if (LynxEnv.inst().enableSvgAsync() == false) goto L5;
        LynxThreadPool.e().execute(new b(this));
        return;
    L5:
        this.f380960d.a();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.f380967k = true;
        this.f380966j = null;
        T();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        T();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        com.lynx.component.svg.parser.c r100 = this.f380961e;
        float r101 = getWidth();
        float r102 = getHeight();
        r100.getClass();
        r100.f381198a = new SVG.b(0.0f, 0.0f, r101, r102);
        if (this.f380963g == false) goto L6;
        this.f380964h = true;
        return;
    L6:
        if (this.f380962f == null) goto L10;
        S();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        if (this.f380963g == true) goto L5;
        return;
    L5:
        if (this.f380964h == false) goto L12;
        this.f380964h = false;
        if (TextUtils.isEmpty(this.f380958b) == false) goto L9;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L9:
        U(this.f380958b, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        boolean r100 = false;
        if (this.f380965i == false) goto L21;
        this.f380965i = false;
        if (this.f380957a.startsWith("data:image/svg+xml;base64") == false) goto L16;
        String r101 = new String(Base64.decode(this.f380957a.substring(26).getBytes(Charset.defaultCharset()), 0), Charset.defaultCharset());
        r100 = true;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.f380958b = null;
        goto L16
    L10:
        if (r101.equals(this.f380958b) == true) goto L16;
        this.f380958b = r101;
        if (this.f380963g == false) goto L15;
        U(this.f380958b, true);
        goto L16
    L15:
        LynxThreadPool.e().execute(new x5a.g(this));
    L16:
        if (r100 == false) goto L18;
        return;
    L18:
        this.f380960d.c(this.f380957a, new c(this));
        return;
    L21:
        if (this.f380963g == false) goto L23;
        return;
    L23:
        if (TextUtils.isEmpty(this.f380958b) == false) goto L29;
        if (TextUtils.isEmpty(this.f380957a) == false) goto L29;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L29:
        if (this.f380964h == false) goto L33;
        this.f380964h = false;
        LynxThreadPool.e().execute(new d(this));
        return;
    }

    public static /* synthetic */ View M(UISvg r100) {
        return r100.mView;
    }

    public static /* synthetic */ View N(UISvg r100) {
        return r100.mView;
    }

    public static /* synthetic */ View O(UISvg r100) {
        return r100.mView;
    }

    public static /* synthetic */ View P(UISvg r100) {
        return r100.mView;
    }

    public static /* synthetic */ View Q(UISvg r100) {
        return r100.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        return new SvgImageView(r100);
    }

    @LynxProp(name = "current-color")
    public void setColor(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r101 = null;
    L7:
        if (TextUtils.equals(r101, this.f380959c) == false) goto L9;
        return;
    L9:
        this.f380959c = r101;
        if (this.f380963g == false) goto L13;
        this.f380964h = true;
        return;
    L13:
        return;
    L5:
        r101 = r100.trim();
        goto L7
    }

    @LynxProp(name = "content")
    public void setContent(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        ((SvgImageView) this.mView).setImageDrawable(null);
        this.f380958b = null;
        return;
    L7:
        if (r100.equals(this.f380958b) == false) goto L9;
        return;
    L9:
        this.f380958b = r100;
        this.f380964h = true;
    }

    @LynxProp(defaultBoolean = false, name = "enable-serval-svg")
    public void setEnableServalSvg(boolean r100) {
        this.f380963g = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f380966j != null) goto L9;
        LynxThreadPool.e().execute(new h(this));
        return;
    }

    @LynxProp(name = "src")
    public void setSource(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        this.f380957a = null;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L7:
        if (r100.equals(this.f380957a) == false) goto L9;
        return;
    L9:
        this.f380957a = r100;
        this.f380965i = true;
    }

    public UISvg(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f380963g = false;
        this.f380964h = false;
        this.f380965i = false;
        this.f380967k = false;
        this.f380961e = new com.lynx.component.svg.parser.c(r100.getUIBody().getFontSize(), getFontSize());
        this.f380960d = new com.lynx.component.svg.d(r100, this);
    }

    public static void R(UISvg r100, SVG r101) {
        Map<String, EventsListener> r102 = r100.mEvents;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.containsKey("load") == false) goto L24;
        m7a.a r103 = new m7a.a(r100.getSign(), "load");
        if (r101 != null) goto L10;
        float r104 = r100.getHeight();
    L12:
        r103.a("height", Float.valueOf(r104));
        if (r101 != null) goto L16;
        float r105 = r100.getWidth();
    L18:
        r103.a("width", Float.valueOf(r105));
        r100.getLynxContext().getEventEmitter().sendCustomEvent(r103);
        return;
    L16:
        if (r101.f381027a == null) goto L20;
        r105 = r101.a().f381078c;
        goto L18
    L20:
        throw new IllegalArgumentException("SVG document is empty");
    L10:
        if (r101.f381027a == null) goto L22;
        r104 = r101.a().f381079d;
        goto L12
    L22:
        throw new IllegalArgumentException("SVG document is empty");
    }

    public final void U(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        ((SvgImageView) this.mView).setImageDrawable(null);
        return;
    L6:
        LynxThreadPool.e().execute(new e(this, r100, r101));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, Rect r113) {
        super.updateLayout(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
        com.lynx.component.svg.parser.c r109 = this.f380961e;
        float r114 = getWidth();
        float r115 = getHeight();
        r109.getClass();
        r109.f381198a = new SVG.b(0.0f, 0.0f, r114, r115);
        if (this.f380962f != null) goto L5;
        return;
    L5:
        if (this.f380963g == true) goto L9;
        S();
        return;
    }
}
