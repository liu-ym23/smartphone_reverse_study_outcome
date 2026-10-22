package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.text.Layout;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import v7b.r;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class TextLayoutRender2 extends com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z2b.a f412484g;

    public static final class a {
    }

    static {
    }

    public TextLayoutRender2() {
    }

    @Override // z2b.b
    public final CharSequence a(z2b.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        m r101 = (m) r100;
        n r102 = r101.f412526b;
        z2b.a r103 = this.f412484g;
        if (r103 == null) goto L5;
        e(r102.f412528b);
        d(this.f412466c);
        CharSequence r104 = r103.b(r100);
        if (r104 == null) goto L10;
        d(this.f412467d);
        Log.d("TextLayoutRender2", "parse, hit cache for message , message id is " + r102.f412528b);
        return r104;
    L10:
        long r105 = System.currentTimeMillis();
        CharSequence r106 = f(r101.f412525a, r102);
        r103.a(r100, r106);
        long r107 = System.currentTimeMillis() - r105;
        if (this.f412464a == false) goto L13;
        Log.i("TextLayoutRender2", "parse, message " + r101.f412526b.f412528b + " , build charSequence, build charSequence cost " + r107 + " millis");
    L13:
        return r106;
    L5:
        return f(r101.f412525a, r102);
    }

    @Override // z2b.b
    public final Layout b(z2b.b.InterfaceC8412b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        p r101 = (p) r100;
        n r102 = r101.f412538b;
        z2b.a r103 = this.f412484g;
        if (r103 == null) goto L5;
        e(r102.f412528b);
        d(this.f412468e);
        Layout r104 = r103.c(r100);
        if (r104 == null) goto L10;
        d(this.f412469f);
        Log.d("TextLayoutRender2", "render, hit cache for message, message id is " + r102.f412528b);
        return r104;
    L10:
        long r105 = System.currentTimeMillis();
        Layout r106 = g(r101.f412537a, r102);
        if (r106 == null) goto L13;
        r103.d(r100, r106);
    L13:
        long r107 = System.currentTimeMillis() - r105;
        if (this.f412464a == false) goto L16;
        Log.i("TextLayoutRender2", "render, message " + r102.f412528b + " not hit cache, render cs, render cost " + r107 + " millis");
    L16:
        return r106;
    L5:
        return g(r101.f412537a, r102);
    }

    public static CharSequence f(RichText r100, final n r101) {
        t9b.a r102 = t9b.a.f545142a;
        com.ss.android.lark.richtextmd.parse.impl.b r103 = com.ss.android.lark.richtextmd.parse.ext.a.b(r101.getContext());
        com.ss.android.lark.richtextmd.parse.ext.a.a(r103, new TextLayoutRender2$parseImpl$node$1(r101));
        s r104 = r103.b(r100);
        if (DevEnvUtil.isDevelopPackage(r101.getContext()) == false) goto L5;
        Log.d("TextLayoutRender2", "parse, node tree is " + r.a(r104, false));
    L5:
        t9b.b r105 = t9b.b.f545143a;
        com.ss.android.lark.coremd.impl.parse.b.a r106 = t9b.b.a(r101.getContext());
        com.ss.android.lark.coremd.ext.l.b(r106, r101.f412530d);
        com.ss.android.lark.coremd.ext.l.a(r106, r101.f412533g);
        r106.c(r101.f412531e.clone());
        return r106.a(r104, r101.f412532f.clone());
    }

    public final Layout g(CharSequence r100, n r101) {
        com.ss.android.lark.widget.light.layout.h r102 = r101.f412534h;
        TextLayoutBuilder r103 = new TextLayoutBuilder();
        z2b.a r104 = this.f412484g;
        if ((r104 instanceof TextLayoutCacheStoreImpl2) == false) goto L5;
        TextLayoutCacheStoreImpl2 r105 = (TextLayoutCacheStoreImpl2) r104;
        Context r106 = r101.getContext();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.f446127c.f446150s = new k(r105, r106);
    L5:
        r103.h(r100);
        r102.a(r103);
        return r103.a();
    }
}
