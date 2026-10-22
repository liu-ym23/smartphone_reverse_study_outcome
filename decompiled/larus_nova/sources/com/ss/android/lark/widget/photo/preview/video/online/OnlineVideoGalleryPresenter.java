package com.ss.android.lark.widget.photo.preview.video.online;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.video.pip.PipModeProcessor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.OriginalMediaHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class OnlineVideoGalleryPresenter extends BasePresenter<b, c, c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f447299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f447300b;

    public class ViewDelegate implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnlineVideoGalleryPresenter f447301a;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryPresenter$ViewDelegate$1, reason: invalid class name */
        public final class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PhotoItem f447302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f447303b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Integer f447304c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ViewDelegate f447305d;

            @Override // java.lang.Runnable
            public final void run() {
                this.f447305d.f447301a.getModel().n2(this.f447302a, new UIGetDataCallback(new C54161(this)));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public AnonymousClass1(ViewDelegate r100, PhotoItem r101, boolean r102, Integer r103) {
                this.f447305d = r100;
                this.f447302a = r101;
                this.f447303b = r102;
                this.f447304c = r103;
            }
        }

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewDelegate f447308a;

            /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryPresenter$ViewDelegate$a$a, reason: collision with other inner class name */
            public class RunnableC5417a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f447309a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f447310b;

                @Override // java.lang.Runnable
                public final void run() {
                    this.f447310b.f447308a.f447301a.getView().p6(this.f447309a);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC5417a(a r100, boolean r101) {
                    this.f447310b = r100;
                    this.f447309a = r101;
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                UICallbackExecutor.execute(new RunnableC5417a(this, com.ss.android.lark.widget.photopicker.f.a().isPrimaryHost()));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(ViewDelegate r100) {
                this.f447308a = r100;
            }
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.c.a
        public final void A4() {
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this));
        }

        public ViewDelegate(OnlineVideoGalleryPresenter r100) {
            this.f447301a = r100;
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.c.a
        public final void B0(final PhotoItem r100) {
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass2(this, r100));
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.c.a
        public final void X4(final PhotoItem r100, final Integer r101) {
            if (this.f447301a.f447299a == null) goto L10;
            if (r100 == null) goto L10;
            if (r100.isOriginal() == false) goto L10;
            if (TextUtils.isEmpty(r100.getMessageId()) == true) goto L10;
            OriginalMediaHandler.b(this.f447301a.f447299a, r100.getMessageId(), new j(this, r100, r101));
            return;
        L10:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(this, r100, true, r101));
        }
    }

    public class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnlineVideoGalleryPresenter f447311a;

        public a(OnlineVideoGalleryPresenter r100) {
            this.f447311a = r100;
        }

        public final void a(final Context r100, final boolean r101) {
            if (PipModeProcessor.f447396d == false) goto L8;
            if (r101 == false) goto L6;
            String r102 = y9c.d.i(r100, R.string.Lark_ChatFileStorage_ChatFileNotFoundDialogOver90Days);
        L7:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            FlowToast.a r103 = FlowToast.a(r100);
            r103.f417630d = -2;
            Intrinsics.checkNotNullParameter(r102, "value");
            Intrinsics.checkNotNullParameter(r102, "value");
            r103.f417628b = r102;
            r103.a().show();
            this.f447311a.getView().y();
            return;
        L6:
            r102 = y9c.d.i(r100, R.string.Lark_ChatFileStorage_ChatFileNotFoundDialogWithin90Days);
            goto L7
        L8:
            UICallbackExecutor.execute(new h(this, r100, r101));
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    public OnlineVideoGalleryPresenter(OnlineVideoGalleryFragment r110, PhotoItem r111, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, com.ss.android.lark.widget.photo.preview.video.online.a r219, OperateListener r310, String r311, String r312) {
        this.f447299a = r110.getContext();
        g r100 = new g(r110.getContext(), r111, r311, r312);
        setModel(r100);
        f0 r101 = new f0(r110, r111, r210, r211, r213, r212, r214, r215, r216, r217, r218, r219, r310);
        this.f447300b = r101;
        setView(r101);
        r101.f447326g = new ViewDelegate(this);
        r100.f447356c = new a(this);
    }
}
