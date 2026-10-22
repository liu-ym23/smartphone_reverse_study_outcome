package com.bytedance.ee.bear.lark.announcement;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.IAnnounceSendCallback;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.facade.common.DoWhenInActiveException;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AnnouncementPresenter {
    public final DocumentPluginHost a;
    public a b;
    public a c;
    public final Handler d;
    public final ThumbnailSyncHelper e;
    public Disposable f;
    public final CompositeDisposable g;
    public final com.bytedance.ee.bear.lark.announcement.a h;
    public final m i;
    public long j;

    public class AnnounceSendCallback extends IAnnounceSendCallback.Stub {
        private h08.b sendingToast;
        final /* synthetic */ AnnouncementPresenter this$0;

        public static /* synthetic */ void a(AnnounceSendCallback r0) {
            r0.lambda$onAnnounceSendFailed$2();
        }

        public static /* synthetic */ void b(AnnounceSendCallback r0) {
            r0.lambda$onAnnounceSendSuccess$1();
        }

        public static /* synthetic */ void c(AnnounceSendCallback r0) {
            r0.lambda$onAnnounceSending$0();
        }

        private /* synthetic */ void lambda$onAnnounceSendFailed$2() {
            h08.b r0 = this.sendingToast;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            com.bytedance.ee.util.ui.m.e(this.this$0.i);
            com.bytedance.ee.util.ui.m.b(this.this$0.i, 1000);
        }

        private /* synthetic */ void lambda$onAnnounceSendSuccess$1() {
            h08.b r0 = this.sendingToast;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            this.this$0.a.getActivity().finish();
        }

        private /* synthetic */ void lambda$onAnnounceSending$0() {
            h08.b r0 = LKUIToast.newGlobal(AnnouncementPresenter.c(this.this$0), this.this$0.g(2131887860));
            this.sendingToast = r0;
            r0.b(2131233822, LKUIToast.getRotateAnimation());
            this.sendingToast.c();
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendSuccess() throws RemoteException {
            tt5.a.b("AnnouncementPresenter", "onAnnounceSendSuccess");
            AnnouncementPresenter r0 = this.this$0;
            r0.h.a("Success", 40020211200L, r0.j);
            com.bytedance.ee.util.ui.m.a(new t(this));
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSending() throws RemoteException {
            tt5.a.b("AnnouncementPresenter", "onAnnounceSending");
            com.bytedance.ee.util.ui.m.a(new r(this));
        }

        private AnnounceSendCallback(AnnouncementPresenter r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendFailed(long r8) throws RemoteException {
            tt5.a.h("AnnouncementPresenter", "onAnnounceSendFailed");
            AnnouncementPresenter r0 = this.this$0;
            r0.h.a("Failed", r8, r0.j);
            com.bytedance.ee.util.ui.m.a(new s(this));
        }

        public /* synthetic */ AnnounceSendCallback(AnnouncementPresenter r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public class a implements Runnable {
        public final String a;
        public final Function0<View> b;
        public final Function0<Boolean> c;
        public final Function0<String> d;
        public final /* synthetic */ AnnouncementPresenter e;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lark.announcement.AnnouncementPresenter$a$a, reason: collision with other inner class name */
        public class C0196a implements tk5.d<vk5.a> {
            public final /* synthetic */ a a;

            public final String getBiz() {
                return "doc";
            }

            public final /* synthetic */ String getDependency() {
                return null;
            }

            public final String getId() {
                return this.a.a;
            }

            public C0196a(a r1) {
                this.a = r1;
            }

            public final boolean b(vk5.c r5) {
                vk5.a r6 = (vk5.a) r5;
                FragmentActivity r0 = r6.getActivity();
                String r1 = (String) this.a.d.invoke();
                View r2 = (View) this.a.b.invoke();
                if (r2 == null) goto L5;
                r6.d(r0.getWindow(), new uk5.e(r1, r2), null);
                return true;
            L5:
                return false;
            }
        }

        public final void a() {
            this.e.e();     // Catch: DoWhenInActiveException -> L8
            if (((Boolean) this.c.invoke()).booleanValue() == true) goto L6;
            return;
        L6:
            C0196a r0 = new C0196a(this);
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().g(r0, this.e.a.getActivity());
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

        public a(AnnouncementPresenter r1, String r2, Function0<View> r3, Function0<Boolean> r4, Function0<String> r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static boolean d() {
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_doc_groupAnnouncement_intro") == false) goto L6;
        tt5.a.h("AnnouncementPresenter", "showGuideTip: had shown");
        return false;
    L6:
        return true;
    }

    private Context getContext() {
        return this.a.getContext();
    }

    public final void e() throws DoWhenInActiveException {
        if (this.a.getActivity() == null) goto L10;
        if (this.a.getLifecycleOwner().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        throw new DoWhenInActiveException();
    L10:
        throw new DoWhenInActiveException();
    }

    public final String f() {
        e();     // Catch: Exception -> L7
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(this.a.a().getUrl()), "chat_id");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return "";
    }

    public static void a(AnnouncementPresenter r1) {
        Toast.showFailureText(r1.getContext(), 2131887859);
    }

    public static /* synthetic */ Context c(AnnouncementPresenter r0) {
        return r0.getContext();
    }

    public static boolean h(DocViewModel r2) {
        String r3 = r2.getUrl();
        if (TextUtils.isEmpty(r3) == false) goto L6;
        tt5.a.k("AnnouncementPresenter", "can not judge announce type, url is null");
        return false;
    L6:
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), "sub_type");
        if (r4 != null) goto L10;
        return false;
    L10:
        if ("community".equals(r4) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final String g(int r2) {
        return getContext().getString(r2);
    }

    public final void j(final String r5) {
        Disposable r0 = this.f;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        r0.dispose();
        this.f = null;
    L5:
        final AnnounceSendCallback r2 = new AnnounceSendCallback(this, r1);
        this.j = System.currentTimeMillis();     // Catch: RemoteException -> L8
        r2.onAnnounceSending();     // Catch: RemoteException -> L8
    L10:
        Disposable r6 = this.e.b().observeOn(fo5.d.d()).subscribe(new e(this, r5, r2), new i(this, r5, r2));
        this.f = r6;
        this.g.add(r6);
        return;
    L8:
        e = move-exception;
        tt5.a.f("AnnouncementPresenter", e, false);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.lark.announcement.m] */
    public AnnouncementPresenter(DocumentPluginHost r3, com.bytedance.ee.bear.lark.announcement.a r4) {
        this.i = new m(this);
        this.a = r3;
        this.g = new CompositeDisposable();
        this.d = new Handler(Looper.getMainLooper());
        this.e = new ThumbnailSyncHelper(r3.a().getBearUrl());
        this.h = r4;
    }

    public final void i(final String r3, final String r4, final IBinder r5) {
        Disposable r6 = Flowable.just("").subscribeOn(fo5.d.b()).map(new o()).map(new p(this, r3, r4, r5)).subscribe(new q(this), new f(this));
        this.g.add(r6);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ee.bear.lark.announcement.n] */
    public static /* synthetic */ void b(final AnnouncementPresenter r9, final String r10, final AnnounceSendCallback r11, Throwable r12) {
        r9.getClass();
        tt5.a.l("AnnouncementPresenter", "accept: ", r12);
        r9.e();     // Catch: DoWhenInActiveException -> L5
        r9.h.a("Failed", 40020211206L, r9.j);
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).e(r9.getContext(), r12, new n(r9, r10, r11));
        return;
    L5:
        r9.h.a("Failed", 40020211205L, r9.j);
    }
}
