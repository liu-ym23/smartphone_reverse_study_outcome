package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TextLayoutRender extends com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f412443j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v2b.a f412444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v2b.g f412445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z2b.a f412446i;

    public static abstract class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f412447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f412448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f412449c;

        public final Context getContext() {
            return this.f412448b;
        }

        public a(b<?, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.f412447a = r100.f412450a;
            this.f412448b = r100.getContext();
            com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r101 = r100.f412452c;
            if (r101 != null) goto L5;
            r101 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        L5:
            this.f412449c = r101;
        }
    }

    public static abstract class b<O extends a<V>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f412450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f412451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f412452c;

        public final Context getContext() {
            return this.f412451b;
        }

        public b(V r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f412450a = r100;
            this.f412451b = r101;
        }
    }

    public static final class c {
        @JvmStatic
        public static boolean a() {
            return FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messenger.im.refactor_message_richtext");
        }
    }

    public static final class d extends b<e, RichText> {
        public d(Context r100, RichText r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "richText");
            super(r101, r100);
        }
    }

    public static final class e extends a<RichText> implements z2b.b.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RichText f412453d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(d r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            super(r100);
            this.f412453d = (RichText) this.f412447a;
        }
    }

    public static final class f extends b<g, CharSequence> {
        public f(Context r100, CharSequence r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "text");
            super(r101, r100);
        }
    }

    public static final class g extends a<CharSequence> implements z2b.b.InterfaceC8412b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CharSequence f412454d;

        public g(f r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            super(r100);
            this.f412454d = (CharSequence) this.f412447a;
        }
    }

    static {
    }

    public TextLayoutRender() {
        this.f412444g = new v2b.a();
        this.f412445h = new v2b.g();
    }

    @Override // z2b.b
    public final CharSequence a(final z2b.b.a r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        e r100 = (e) r110;
        Function0<CharSequence> r101 = new TextLayoutRender$parse$parseAction$1(this, r110);
        z2b.a r102 = this.f412446i;
        if (r102 == null) goto L5;
        e(r100.f412449c.f412423p);
        d(this.f412466c);
        CharSequence r103 = r102.b(r110);
        if (r103 == null) goto L10;
        d(this.f412467d);
        Log.d("TextLayoutRender", "parse, hit cache for message " + r100.f412449c.f412423p);
        return r103;
    L10:
        long r104 = System.currentTimeMillis();
        CharSequence r105 = r101.invoke();
        long r106 = System.currentTimeMillis() - r104;
        if (this.f412464a == false) goto L13;
        Log.i("TextLayoutRender", "parse, message " + r100.f412449c.f412423p + " , build charSequence, build charSequence cost " + r106 + " millis");
    L13:
        r102.a(r110, r105);
        return r105;
    L5:
        return r101.invoke();
    }

    @Override // z2b.b
    public final Layout b(final z2b.b.InterfaceC8412b r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        g r100 = (g) r110;
        Function0<Layout> r101 = new TextLayoutRender$render$renderAction$1(this, r110);
        z2b.a r102 = this.f412446i;
        if (r102 == null) goto L5;
        e(r100.f412449c.f412423p);
        d(this.f412468e);
        Layout r103 = r102.c(r110);
        if (r103 == null) goto L10;
        d(this.f412469f);
        Log.d("TextLayoutRender", "render, hit cache for message " + r100.f412449c.f412423p);
        return r103;
    L10:
        long r104 = System.currentTimeMillis();
        Layout r105 = r101.invoke();
        if (r105 != null) goto L14;
        return null;
    L14:
        long r106 = System.currentTimeMillis() - r104;
        if (this.f412464a == false) goto L17;
        Log.i("TextLayoutRender", "render, message " + r100.f412449c.f412423p + " not hit cache, build layout, build layout cost " + r106 + " millis");
    L17:
        r102.d(r110, r105);
        return r105;
    L5:
        return r101.invoke();
    }

    public final void f(final z2b.a r100) {
        this.f412446i = r100;
        v2b.a r101 = this.f412444g;
        if ((r100 instanceof AbsTextLayoutCacheStore) == false) goto L5;
        Function1<Context, com.ss.android.lark.widget.light.viewstub.f> r102 = new TextLayoutRender$updateCacheStoreInner$1(r100);
    L6:
        r101.f552776b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
