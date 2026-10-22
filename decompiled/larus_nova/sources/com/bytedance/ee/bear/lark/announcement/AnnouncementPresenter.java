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
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class AnnouncementPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocumentPluginHost f227221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f227222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f227223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f227224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThumbnailSyncHelper f227225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f227226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f227227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.bear.lark.announcement.a f227228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f227229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f227230j;

    public class AnnounceSendCallback extends IAnnounceSendCallback.Stub {
        private h08.b sendingToast;
        final /* synthetic */ AnnouncementPresenter this$0;

        public static /* synthetic */ void a(AnnounceSendCallback r100) {
            r100.lambda$onAnnounceSendFailed$2();
        }

        public static /* synthetic */ void b(AnnounceSendCallback r100) {
            r100.lambda$onAnnounceSendSuccess$1();
        }

        public static /* synthetic */ void c(AnnounceSendCallback r100) {
            r100.lambda$onAnnounceSending$0();
        }

        private /* synthetic */ void lambda$onAnnounceSendFailed$2() {
            h08.b r100 = this.sendingToast;
            if (r100 == null) goto L5;
            r100.a();
        L5:
            com.bytedance.ee.util.ui.m.e(this.this$0.f227229i);
            com.bytedance.ee.util.ui.m.b(this.this$0.f227229i, 1000);
        }

        private /* synthetic */ void lambda$onAnnounceSendSuccess$1() {
            h08.b r100 = this.sendingToast;
            if (r100 == null) goto L5;
            r100.a();
        L5:
            this.this$0.f227221a.getActivity().finish();
        }

        private /* synthetic */ void lambda$onAnnounceSending$0() {
            h08.b r100 = LKUIToast.newGlobal(AnnouncementPresenter.c(this.this$0), this.this$0.g(R.string.Doc_Lark_AnnounceSending));
            this.sendingToast = r100;
            r100.b(R.drawable.doc_announce_sending, LKUIToast.getRotateAnimation());
            this.sendingToast.c();
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendSuccess() throws RemoteException {
            tt5.a.b("AnnouncementPresenter", "onAnnounceSendSuccess");
            AnnouncementPresenter r100 = this.this$0;
            r100.f227228h.a("Success", 40020211200L, r100.f227230j);
            com.bytedance.ee.util.ui.m.a(new t(this));
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSending() throws RemoteException {
            tt5.a.b("AnnouncementPresenter", "onAnnounceSending");
            com.bytedance.ee.util.ui.m.a(new r(this));
        }

        private AnnounceSendCallback(AnnouncementPresenter r100) {
            this.this$0 = r100;
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendFailed(long r100) throws RemoteException {
            tt5.a.h("AnnouncementPresenter", "onAnnounceSendFailed");
            AnnouncementPresenter r101 = this.this$0;
            r101.f227228h.a("Failed", r100, r101.f227230j);
            com.bytedance.ee.util.ui.m.a(new s(this));
        }

        public /* synthetic */ AnnounceSendCallback(AnnouncementPresenter r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f227231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<View> f227232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Boolean> f227233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<String> f227234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AnnouncementPresenter f227235e;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lark.announcement.AnnouncementPresenter$a$a, reason: collision with other inner class name */
        public class C3252a implements tk5.d<vk5.a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f227236a;

            @Override // tk5.d
            public final String getBiz() {
                return "doc";
            }

            @Override // tk5.d
            public final /* synthetic */ String getDependency() {
                return null;
            }

            @Override // tk5.d
            public final String getId() {
                return this.f227236a.f227231a;
            }

            public C3252a(a r100) {
                this.f227236a = r100;
            }

            @Override // tk5.d
            public final boolean b(vk5.c r100) {
                vk5.a r101 = (vk5.a) r100;
                FragmentActivity r102 = r101.getActivity();
                String r103 = this.f227236a.f227234d.invoke();
                View r104 = this.f227236a.f227232b.invoke();
                if (r104 == null) goto L5;
                r101.d(r102.getWindow(), new uk5.e(r103, r104), null);
                return true;
            L5:
                return false;
            }
        }

        public final void a() {
            this.f227235e.e();     // Catch: DoWhenInActiveException -> L8
            if (this.f227233c.invoke().booleanValue() == true) goto L6;
            return;
        L6:
            C3252a r100 = new C3252a(this);
            ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().g(r100, this.f227235e.f227221a.getActivity());
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

        public a(AnnouncementPresenter r100, String r101, Function0<View> r102, Function0<Boolean> r103, Function0<String> r104) {
            this.f227235e = r100;
            this.f227231a = r101;
            this.f227232b = r102;
            this.f227233c = r103;
            this.f227234d = r104;
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
        return this.f227221a.getContext();
    }

    public final void e() throws DoWhenInActiveException {
        if (this.f227221a.getActivity() == null) goto L10;
        if (this.f227221a.getLifecycleOwner().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        throw new DoWhenInActiveException();
    L10:
        throw new DoWhenInActiveException();
    }

    public final String f() {
        e();     // Catch: Exception -> L7
        String r100 = UriProtector.getQueryParameter(UriProtector.parse(this.f227221a.a().getUrl()), "chat_id");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public static void a(AnnouncementPresenter r100) {
        Toast.showFailureText(r100.getContext(), R.string.Doc_Lark_AnnounceSendFailed);
    }

    public static /* synthetic */ Context c(AnnouncementPresenter r100) {
        return r100.getContext();
    }

    public static boolean h(DocViewModel r100) {
        String r101 = r100.getUrl();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        tt5.a.k("AnnouncementPresenter", "can not judge announce type, url is null");
        return false;
    L6:
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101), "sub_type");
        if (r102 != null) goto L10;
        return false;
    L10:
        if ("community".equals(r102) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final String g(int r100) {
        return getContext().getString(r100);
    }

    public final void j(final String r100) {
        Disposable r101 = this.f227226f;
        AnonymousClass1 r102 = null;
        if (r101 == null) goto L5;
        r101.dispose();
        this.f227226f = null;
    L5:
        final AnnounceSendCallback r103 = new AnnounceSendCallback(this, r102);
        this.f227230j = System.currentTimeMillis();     // Catch: RemoteException -> L8
        r103.onAnnounceSending();     // Catch: RemoteException -> L8
    L10:
        Disposable r104 = this.f227225e.b().observeOn(fo5.d.d()).subscribe(new e(this, r100, r103), new i(this, r100, r103));
        this.f227226f = r104;
        this.f227227g.add(r104);
        return;
    L8:
        e = move-exception;
        tt5.a.f("AnnouncementPresenter", e, false);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.lark.announcement.m] */
    public AnnouncementPresenter(DocumentPluginHost r100, com.bytedance.ee.bear.lark.announcement.a r101) {
        this.f227229i = new m(this);
        this.f227221a = r100;
        this.f227227g = new CompositeDisposable();
        this.f227224d = new Handler(Looper.getMainLooper());
        this.f227225e = new ThumbnailSyncHelper(r100.a().getBearUrl());
        this.f227228h = r101;
    }

    public final void i(final String r100, final String r101, final IBinder r102) {
        Disposable r103 = Flowable.just("").subscribeOn(fo5.d.b()).map(new o()).map(new p(this, r100, r101, r102)).subscribe(new q(this), new f(this));
        this.f227227g.add(r103);
    }

    public static /* synthetic */ void b(AnnouncementPresenter r100, String r110, AnnounceSendCallback r111, Throwable r112) {
        r100.getClass();
        tt5.a.l("AnnouncementPresenter", "accept: ", r112);
        r100.e();     // Catch: DoWhenInActiveException -> L5
        r100.f227228h.a("Failed", 40020211206L, r100.f227230j);
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).e(r100.getContext(), r112, new n(r100, r110, r111));
        return;
    L5:
        r100.f227228h.a("Failed", 40020211205L, r100.f227230j);
    }
}
