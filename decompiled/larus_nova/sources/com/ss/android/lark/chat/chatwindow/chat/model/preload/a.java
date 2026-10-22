package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import android.content.Context;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.RomUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f413368a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$a, reason: collision with other inner class name */
    public interface InterfaceC4810a {
        void f(y6b.a<?> r100);

        Context getContext();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2b.b f413369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y6b.a<?> f413370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BaseTextContentVO<?> f413371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f413372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WeakReference<InterfaceC4810a> f413373e;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC4811a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f413374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f413375b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f413376c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Layout f413377d;

            public RunnableC4811a(b r100, boolean r101, String r102, Layout r103) {
                this.f413374a = r100;
                this.f413375b = r101;
                this.f413376c = r102;
                this.f413377d = r103;
            }

            public final void a() {
                InterfaceC4810a r100 = this.f413374a.f413373e.get();
                if (r100 != null) goto L6;
                Log.e("AsyncParseLog", "dependency from WeakReference is null");
                return;
            L6:
                int r101 = a.f413368a;
                BaseTextContentVO r102 = a.c(this.f413374a.f413370b, this.f413375b);
                if (r102 != null) goto L11;
                Log.e("AsyncParseLog", "get latest ContentVO failed for message: " + this.f413376c);
                return;
            L11:
                if (Intrinsics.areEqual(r102, this.f413374a.f413371c) == true) goto L14;
                Log.i("AsyncParseLog", "ContentVO changed for message: " + this.f413376c + ", so drop parsed result");
                return;
            L14:
                r102.f411890z = this.f413377d;
                Log.i("AsyncParseLog", "notify message update, id " + this.f413376c + ", isTranslation: " + this.f413375b);
                Trace.beginSection("notify_layout_refreshed");
                r100.f(this.f413374a.f413370b);
                Trace.endSection();
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

        public final void a() {
            String r100 = this.f413370b.getId();
            boolean r101 = this.f413372d.f412418k;
            InterfaceC4810a r102 = this.f413373e.get();
            if (r102 != null) goto L6;
            Log.i("AsyncParseLog", "AsyncParseDependency from WeakReference is null before parse, return quickly");
            return;
        L6:
            Context r103 = r102.getContext();
            if (r103 != null) goto L9;
            return;
        L9:
            long r104 = System.currentTimeMillis();
            Trace.beginSection("layout_processor_process");
            com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r105 = this.f413372d;
            r105.f412420m = true;
            Layout r106 = TextLayoutRenderExtKt.d(this.f413369a, this.f413370b, r105, r103);
            if (r106 != null) goto L12;
            return;
        L12:
            Trace.endSection();
            Log.i("AsyncParseLog", "layout parse cost " + (System.currentTimeMillis() - r104) + "ms for message " + r100 + ", length " + this.f413370b.r());
            if (r106.getText() != null) goto L16;
            Log.e("AsyncParseLog", "contentLayout.text is null for message " + r100);
            return;
        L16:
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC4811a(this, r101, r100, r106));
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

        public b(z2b.b r100, y6b.a r101, BaseTextContentVO r102, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r103, b3b.a r104) {
            Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.Stage.RENDER);
            Intrinsics.checkNotNullParameter(r101, "messageVO");
            Intrinsics.checkNotNullParameter(r102, "contentVoSnapshot");
            Intrinsics.checkNotNullParameter(r103, "processParams");
            Intrinsics.checkNotNullParameter(r104, "dependency");
            this.f413369a = r100;
            this.f413370b = r101;
            this.f413371c = r102;
            this.f413372d = r103;
            this.f413373e = new WeakReference(r104);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z2b.b f413378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f413379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y6b.a<?> f413380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BaseTextContentVO<?> f413381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WeakReference<InterfaceC4810a> f413382e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final WeakReference<n> f413383f;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC4812a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f413384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f413385b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Layout f413386c;

            public RunnableC4812a(c r100, String r101, Layout r102) {
                this.f413384a = r100;
                this.f413385b = r101;
                this.f413386c = r102;
            }

            public final void a() {
                InterfaceC4810a r100 = this.f413384a.f413382e.get();
                if (r100 != null) goto L6;
                Log.e("AsyncParseLog", "dependency from WeakReference is null");
                return;
            L6:
                int r101 = a.f413368a;
                c r102 = this.f413384a;
                BaseTextContentVO r103 = a.c(r102.f413380c, r102.f413379b);
                if (r103 != null) goto L11;
                Log.e("AsyncParseLog", "get latest ContentVO failed for message: " + this.f413385b);
                return;
            L11:
                if (Intrinsics.areEqual(r103, this.f413384a.f413381d) == true) goto L14;
                Log.i("AsyncParseLog", "ContentVO changed for message: " + this.f413385b + ", so drop parsed result");
                return;
            L14:
                r103.f411890z = this.f413386c;
                Log.i("AsyncParseLog", "notify message update, id " + this.f413385b + ", isTranslation: " + this.f413384a.f413379b);
                Trace.beginSection("notify_layout_refreshed");
                r100.f(this.f413384a.f413380c);
                Trace.endSection();
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

        public final void a() {
            String r100 = this.f413380c.getId();
            long r101 = System.currentTimeMillis();
            Trace.beginSection("layout_processor_process");
            n r102 = this.f413383f.get();
            if (r102 != null) goto L6;
            Log.e("AsyncParseLog", "config is null ,async parse return.");
            return;
        L6:
            Object r103 = this.f413380c.b();
            RichText r104 = null;
            if ((r103 instanceof BaseTextContentVO) == false) goto L9;
            BaseTextContentVO r105 = (BaseTextContentVO) r103;
        L10:
            if (r105 != null) goto L13;
            return;
        L13:
            if (this.f413379b == true) goto L15;
            r104 = r105.g();
        L20:
            if (r104 != null) goto L22;
            return;
        L22:
            Layout r106 = TextLayoutRenderExtKt.f(this.f413378a, r104, r102);
            if (r106 != null) goto L25;
            return;
        L25:
            Trace.endSection();
            Log.i("AsyncParseLog", "layout parse cost " + (System.currentTimeMillis() - r101) + "ms for message " + r100 + ", length " + this.f413380c.r());
            if (r106.getText() != null) goto L29;
            Log.e("AsyncParseLog", "contentLayout.text is null for message " + r100);
            return;
        L29:
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC4812a(this, r100, r106));
            return;
        L15:
            v5b.a r107 = r105.f411957g;
            if (r107 == null) goto L20;
            BaseTextContent r108 = (BaseTextContent) r107.f553338a;
            if (r108 == null) goto L20;
            r104 = r108.getRichText();
            goto L20
        L9:
            r105 = null;
            goto L10
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

        public c(z2b.b r100, boolean r101, y6b.a r102, BaseTextContentVO r103, n r104, b3b.a r105) {
            Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.Stage.RENDER);
            Intrinsics.checkNotNullParameter(r102, "messageVO");
            Intrinsics.checkNotNullParameter(r103, "contentVoSnapshot");
            Intrinsics.checkNotNullParameter(r104, "config");
            Intrinsics.checkNotNullParameter(r105, "dependency");
            this.f413378a = r100;
            this.f413379b = r101;
            this.f413380c = r102;
            this.f413381d = r103;
            this.f413382e = new WeakReference(r105);
            this.f413383f = new WeakReference(r104);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static BaseTextContentVO c(y6b.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        if (r101 == false) goto L14;
        T r102 = r100.b();
        if ((r102 instanceof BaseTextContentVO) == false) goto L7;
        BaseTextContentVO r103 = (BaseTextContentVO) r102;
    L8:
        if (r103 == null) goto L10;
        Object r104 = r103.f411957g;
    L12:
        if ((r104 instanceof BaseTextContentVO) == true) goto L19;
        return null;
    L19:
        return (BaseTextContentVO) r104;
    L10:
        r104 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    L14:
        T r105 = r100.b();
        if ((r105 instanceof BaseTextContentVO) == true) goto L17;
        return null;
    L17:
        return (BaseTextContentVO) r105;
    }

    public static void a(z2b.b r100, y6b.a r101, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r102, b3b.a r110) {
        Intrinsics.checkNotNullParameter(r101, "messageVO");
        Intrinsics.checkNotNullParameter(r102, "processParams");
        Intrinsics.checkNotNullParameter(r110, "dependency");
        if (r100 != null) goto L5;
        int r103 = TextLayoutRender.f412443j;
        r100 = w2b.b.f558082d;
    L5:
        z2b.b r104 = r100;
        BaseTextContentVO r105 = c(r101, r102.f412418k);
        if (r105 != null) goto L9;
        Log.e("AsyncParseLog", "ContentVO get failed for message: " + r101.getId());
        return;
    L9:
        r105.A = false;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r104, r101, r105, r102, r110));
    }

    public static void b(z2b.b r100, boolean r101, y6b.a r110, n r111, b3b.a r112) {
        Intrinsics.checkNotNullParameter(r110, "messageVO");
        Intrinsics.checkNotNullParameter(r111, "config");
        Intrinsics.checkNotNullParameter(r112, "dependency");
        if (r100 != null) goto L5;
        int r102 = TextLayoutRender.f412443j;
        r100 = w2b.b.f558082d;
    L5:
        z2b.b r103 = r100;
        BaseTextContentVO r104 = c(r110, r101);
        if (r104 != null) goto L9;
        Log.e("AsyncParseLog", "ContentVO get failed for message: " + r110.getId());
        return;
    L9:
        boolean r105 = false;
        r104.A = false;
        if (Build.VERSION.SDK_INT != 31) goto L13;
        r105 = RomUtils.g();
    L13:
        if (r105 == true) goto L15;
    L18:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r103, r101, r110, r104, r111, r112));
        return;
    L15:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.close_pre_layout.reverse") == true) goto L18;
        Log.i("AsyncParseLog", "skip asyncParseV2 on risk device, message: " + r110.getId());
    }
}
