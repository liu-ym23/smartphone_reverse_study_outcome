package com.lynx.xelement.markdown;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.lynx.markdown.Markdown;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import o8a.b;
import p8a.d;
import p8a.m;
import p8a.o;
import p8a.q;
import p8a.s;
import p8a.t;
import y6a.a;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIMarkdownShadowNode extends ShadowNode implements e, s, p8a.e {
    public a A;
    public String B;
    public String C;
    public final Looper D;
    public final Handler E;
    public b F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d f384189v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p8a.a f384190w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t f384191x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f384192y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f384193z;

    @LynxProp(name = "enable-region-view")
    public void setEnableRegionView(boolean r100) {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [o8a.b] */
    public final d D() {
        if (this.f384189v != null) goto L11;
        if (this.f382220m == null) goto L11;
        d r100 = new d(this.f382220m, this);
        this.f384189v = r100;
        r100.setResourceLoader(this.f384191x);
        this.f384189v.setEventListener(this.f384192y);
        this.f384189v.disableInternalVSync(true);
        if (this.D == null) goto L9;
        this.F = new b(this);
        Choreographer.getInstance().postFrameCallback(this.F);
    L9:
        p8a.a r101 = this.f384190w;
        r101.f528230a = this.f384189v;
    L11:
        return this.f384189v;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        p8a.a r100 = this.f384190w;
        r100.f528230a = this.f384189v;
        return r100;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void q() {
        if (this.D == null) goto L11;
        Looper r100 = Looper.myLooper();
        Looper r101 = this.D;
        if (r100 == r101) goto L11;
        Runnable r102 = new o8a.a(this);
        if (r101 == null) goto L10;
        this.E.post(r102);
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(r102);
        return;
    L11:
        super.q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        t r100 = this.f384191x;
        Iterator<q> r101 = r100.f528268b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        final q r102 = r101.next();
        r102.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new o(r102));
        goto L4
    L6:
        r100.f528268b.clear();
        r100.f528269c.clear();
        this.f384193z = null;
        this.A = null;
        d r103 = this.f384189v;
        if (r103 == null) goto L9;
        r103.destroy();
        this.f384189v = null;
    L9:
        this.f384190w.f528230a = null;
    }

    public LynxUIMarkdownShadowNode() {
        this.f384190w = new p8a.a();
        this.f384191x = new t(this);
        this.f384192y = new m(this);
        this.B = "";
        this.C = "";
        Markdown.ensureInitialized();
        h(this);
        Looper r100 = Looper.myLooper();
        this.D = r100;
        if (r100 == null) goto L6;
        this.E = new Handler(r100);
        return;
    }

    public static /* synthetic */ void C(LynxUIMarkdownShadowNode r100) {
        super.q();
    }

    @LynxProp(name = "allow-break-around-punctuation")
    public void setAllowBreakAroundPunctuation(boolean r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setBooleanProp(12, r100);
        return;
    }

    @LynxProp(name = "animation-frame-rate")
    public void setAnimationFrameRate(float r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setNumberProp(10, r100);
        return;
    }

    @LynxProp(name = "animation-type")
    public void setAnimationType(String r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setAnimationType("typewriter".equals(r100) ? 1 : 0);
    L5:
        q();
    }

    @LynxProp(name = "animation-velocity")
    public void setAnimationVelocity(float r100) {
        d r101 = D();
        if (r101 != null) goto L5;
    L9:
        q();
        return;
    L5:
        if (r100 >= 0.0f) goto L8;
        r100 = 1.0f;
    L8:
        r101.setAnimationVelocity(r100);
        goto L9
    }

    @LynxProp(name = "content")
    public void setContent(String r100) {
        d r101 = D();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.B = r100;
        if (r101 == null) goto L9;
        r101.setContent(r100);
        return;
    }

    @LynxProp(name = "content-complete")
    public void setContentComplete(boolean r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setBooleanProp(3, r100);
    L5:
        q();
    }

    @LynxProp(name = "content-id")
    public void setContentID(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.C = r100;
    }

    @LynxProp(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setBooleanProp(13, r100);
        return;
    }

    @LynxProp(name = "exposure-tags")
    public void setExposureTags(ReadableArray r100) {
        d r101 = D();
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        ArrayList<Object> r102 = null;
    L7:
        r101.setArrayProp(9, r102);
        return;
    L6:
        r102 = r100.asArrayList();
        goto L7
    }

    @LynxProp(name = "image-downsampling")
    public void setImageDownSampling(boolean r100) {
        this.f384191x.f528270d = r100;
    }

    @LynxProp(name = "image-sync-load")
    public void setImageSyncLoad(boolean r100) {
        this.f384191x.f528271e = r100;
    }

    @LynxProp(name = "initial-animation-step")
    public void setInitialAnimationStep(int r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setInitialAnimationStep(r100);
    L5:
        q();
    }

    @LynxProp(name = "content-range")
    public void setMarkdownContentRange(ReadableArray r100) {
        d r101 = D();
        if (r101 == null) goto L14;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.size() <= 0) goto L10;
        r101.setNumberProp(7, r100.getInt(0));
    L10:
        if (r100.size() <= 1) goto L12;
        r101.setNumberProp(8, r100.getInt(1));
    L12:
        q();
        return;
    }

    @LynxProp(name = "markdown-effect")
    public void setMarkdownEffect(ReadableMap r100) {
        d r101 = D();
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        HashMap<String, Object> r102 = null;
    L7:
        r101.setObjectProp(18, r102);
        return;
    L6:
        r102 = r100.asHashMap();
        goto L7
    }

    @LynxProp(name = "markdown-max-height")
    public void setMarkdownMaxHeight(float r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setNumberProp(6, r100);
    L5:
        q();
    }

    @LynxProp(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setColorProp(14, r100);
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setColorProp(15, r100);
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setNumberProp(16, r100);
        return;
    }

    @LynxProp(name = "markdown-style")
    public void setStyleSheet(ReadableMap r100) {
        d r101 = D();
        if (r101 == null) goto L8;
        if (r100 != null) goto L6;
        HashMap<String, Object> r102 = null;
    L7:
        r101.setStyle(r102);
        goto L8
    L6:
        r102 = r100.asHashMap();
    L8:
        q();
    }

    @LynxProp(name = "text-mark-attachments")
    public void setTextMarkAttachments(ReadableArray r100) {
        d r101 = D();
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        ArrayList<Object> r102 = null;
    L7:
        r101.setArrayProp(19, r102);
        return;
    L6:
        r102 = r100.asArrayList();
        goto L7
    }

    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(int r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setNumberProp(2, r100);
    L5:
        q();
    }

    @LynxProp(name = "typewriter-dynamic-height")
    public void setTypewriterAutoHeight(boolean r100) {
        d r101 = D();
        if (r101 == null) goto L5;
        r101.setBooleanProp(4, r100);
    L5:
        q();
    }

    @LynxProp(name = "typewriter-height-transition-duration")
    public void setTypewriterHeightTransitionDuration(float r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setNumberProp(11, r100);
        return;
    }

    @LynxProp(name = "typewriter-height-transition-prefetch")
    public void setTypewriterHeightTransitionPrefetch(boolean r100) {
        d r101 = D();
        if (r101 == null) goto L6;
        r101.setBooleanProp(20, r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        this.f382220m = r100;
        D();
    }

    public final void E(String r100, Throwable r101) {
        if (this.f382222o == false) goto L5;
        return;
    L5:
        if (this.f382220m == null) goto L13;
        if (r101 != null) goto L9;
        String r102 = "failed to load image";
    L10:
        this.f382220m.reportResourceError(r100, "image", r102);
        return;
    L9:
        r102 = r101.getMessage();
        goto L10
    }

    @Override // y6a.e
    public final k b(j r100, g r101) {
        this.f384193z = r101;
        d r102 = D();
        if (r102 == null) goto L5;
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r103 >= l()) goto L16;
        ShadowNode r105 = k(r103);
        if ((r105 instanceof NativeLayoutNodeRef) == false) goto L15;
        if (r105.o() == false) goto L15;
        r105.f382206e = false;
        r104 = true;
    L15:
        r103 = r103 + 1;
        goto L8
    L16:
        if (r104 == false) goto L18;
        r102.markDirty();
    L18:
        long r106 = r102.measure((int) r100.f566410a, r100.f566411b.intValue(), (int) r100.f566412c, r100.f566413d.intValue());
        return new k((int) ((r106 >>> 42) & 2097151), (int) ((r106 >>> 21) & 2097151), (int) (r106 & 2097151));
    L5:
        return new k(0.0f, 0.0f, 0.0f);
    }

    @Override // y6a.e
    public final void d(y6a.b r100, a r101) {
        this.A = r101;
        d r102 = D();
        if (r102 == null) goto L6;
        r102.align((int) r100.f566403a, (int) r100.f566404b);
        return;
    }
}
