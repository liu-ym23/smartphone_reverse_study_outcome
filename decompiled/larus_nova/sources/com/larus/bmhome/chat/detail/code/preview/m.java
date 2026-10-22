package com.larus.bmhome.chat.detail.code.preview;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f302800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f302801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Runnable f302802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f302803d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbsWebFragment f302804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f302805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f302806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<FragmentActivity> f302807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f302808e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CodePreviewStatus f302809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f302810g;

        public a(AbsWebFragment r100, String r101, String r102, WeakReference r103, int r104, String r105) {
            CodePreviewStatus r106 = CodePreviewStatus.LOADING;
            Intrinsics.checkNotNullParameter(r100, "webFragment");
            Intrinsics.checkNotNullParameter(r101, "codeId");
            Intrinsics.checkNotNullParameter(r102, "messageId");
            Intrinsics.checkNotNullParameter(r103, "activityRef");
            Intrinsics.checkNotNullParameter(r106, "status");
            Intrinsics.checkNotNullParameter(r105, "conversationId");
            this.f302804a = r100;
            this.f302805b = r101;
            this.f302806c = r102;
            this.f302807d = r103;
            this.f302808e = r104;
            this.f302809f = r106;
            this.f302810g = r105;
        }
    }

    public static final class b implements nf9.c {
        public b() {
        }

        @Override // nf9.c
        public final void B(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // nf9.c
        public final void C(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // nf9.c
        public final void A(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            m r101 = m.f302800a;
            a r102 = m.f302801b;
            if (r102 == null) goto L6;
            String r103 = r102.f302806c;
            if (r103 == null) goto L6;
        L7:
            r101.getClass();
            m.b(r103);
            FLogger.f375446a.d("PreloadCodeWebViewManager", "onStreamEnd, conversationId[" + r100.getConversationId() + "], messageId[" + r100.getMessageId() + ']');
            Runnable r104 = m.f302802c;
            if (r104 == null) goto L10;
            r104.run();
        L10:
            m.f302802c = null;
            return;
        L6:
            r103 = "";
            goto L7
        }
    }

    public m() {
    }

    static {
        f302800a = new m();
        f302803d = new b();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        a r101 = f302801b;
        if (r101 == null) goto L7;
        String r102 = r101.f302810g;
        if (r102 == null) goto L7;
        int r103 = com.larus.im.d.f347134a;
        com.larus.im.internal.stream.b.f350138a.e(r102, f302803d);
    L7:
        a r104 = f302801b;
        if (r104 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r104.f302806c, r100) == true) goto L13;
        return;
    L13:
        Lazy r105 = i.f302790a;
        String r106 = r104.f302805b;
        Intrinsics.checkNotNullParameter(r106, "codeId");
        ((Map) i.f302791b.getValue()).remove(r106);
        FragmentActivity r107 = r104.f302807d.get();     // Catch: Exception -> L32
        if (r107 != null) goto L18;
    L34:
        f302801b = null;
        FLogger.f375446a.i("PreloadCodeWebViewManager", "destroyByMessageId, messageId[" + r100 + ']');
        return;
    L18:
        if (r107.isFinishing() == true) goto L34;
        if (r107.isDestroyed() == true) goto L34;
        r107.getSupportFragmentManager().beginTransaction().remove(r104.f302804a).commitAllowingStateLoss();     // Catch: Exception -> L32
        View r108 = a(r107.getWindow());     // Catch: Exception -> L32
        if ((r108 instanceof ViewGroup) == false) goto L25;
        ViewGroup r109 = (ViewGroup) r108;     // Catch: Exception -> L32
    L26:
        if (r109 == null) goto L28;
        final View r110 = r109.findViewById(r104.f302808e);     // Catch: Exception -> L32
    L29:
        if (r110 == null) goto L34;
        r109.post(new k(r110));     // Catch: Exception -> L32
        goto L34
    L28:
        r110 = null;
        goto L29
    L25:
        r109 = null;
    L32:
        e = move-exception;
        FLogger.f375446a.e("PreloadCodeWebViewManager", "destroyEntry failed, codeId[" + r104.f302805b + ']', e);
        goto L34
    }
}
