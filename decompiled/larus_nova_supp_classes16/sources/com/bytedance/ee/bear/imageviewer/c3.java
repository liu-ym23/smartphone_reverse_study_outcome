package com.bytedance.ee.bear.imageviewer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageCommentData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageType;
import com.bytedance.ee.bear.contract.imageviewer.delegate.ImageAction;
import com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;
import com.bytedance.ee.bear.imageviewer.view.ImageViewerLargeImageView;
import com.bytedance.ee.bear.imageviewer.view.ImageViewerShareDialogFragment;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.widgets.SwipeControlViewPager;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c3 implements IImageViewer, sa5.d {
    public static final List<String> L1 = null;
    public PermissionResponse A;
    public ImageData B;
    public final List<ImageData.Image> C;
    public ImageCommentData D;
    public final MutableLiveData<ImageCommentData> E;
    public final MutableLiveData<ImageData> F;
    public int G;
    public uw4.d G1;
    public RequestManager H;
    public uw4.g H0;
    public final e H1;
    public TextView I;
    public uw4.c J;
    public uw4.f K;
    public uw4.b L;
    public final k L0;
    public uw4.a M;
    public tw4.a N;
    public tw4.c O;
    public tw4.b P;
    public final z2 P0;
    public com.bytedance.ee.bear.contract.b0 Q;
    public LKUIDialog R;
    public xu5.b.a S;
    public UDDialog T;
    public final List<DiagramWebView> U;
    public final long V;
    public final com.bytedance.ee.bear.imageviewer.g V0;
    public final List<LargeImageView> W;
    public final Map<LargeImageView, io.reactivex.disposables.a> X;
    public final CompositeDisposable Y;
    public final boolean Z;
    public final Map<String, Boolean> a;
    public FragmentActivity b;
    public com.bytedance.ee.bear.widgets.a b1;
    public boolean c;
    public Fragment d;
    public LifecycleOwner e;
    public SwipeControlViewPager f;
    public final Map<ImageData.Image, String> g;
    public sa5.b g1;
    public View h;
    public final b h1;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public s3 k0;
    public String k1;
    public boolean l;
    public ViewGroup m;
    public IImageViewer.ImageCommentMode n;
    public final AtomicBoolean o;
    public final i p;
    public boolean p0;
    public int p1;
    public final boolean q;
    public com.bytedance.ee.bear.bizwidget.magicshare.cursor.b r;
    public j s;
    public TextView t;
    public ImageView u;
    public AppCompatImageView v;
    public String v1;
    public View w;
    public AppCompatImageView x;
    public String x1;
    public ImageView y;
    public ImageData.Position y1;
    public AppCompatImageView z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            b = r0;
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L27:
            b[ShareType.Download.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L33:
            b[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L45:
            b[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L29:
            b[ShareType.QQ.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L37:
            b[ShareType.Weibo.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L39:
            b[ShareType.More.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r3 = new int[FileAuthResultFrom.values().length];
            a = r3;
            r3[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L31:
            a[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L35:
            a[FileAuthResultFrom.COME_FROM_UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    public class b implements bp5.c.a {
        public final boolean interceptSetStatusBarColor(Activity r1, int r2, boolean r3) {
            return true;
        }

        public final boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
            return true;
        }

        public b() {
        }
    }

    public class c implements com.bytedance.ee.bear.share.export.m {
        public final /* synthetic */ ShareType a;

        public final void onSuccess() {
            tt5.a.h("ImageViewer", "performExternalShare success, type = " + this.a);
        }

        public c(ShareType r1) {
            this.a = r1;
        }

        public final void onFailed(String r3) {
            tt5.a.d("ImageViewer", "performExternalShare failed, type = " + this.a + ", error = " + r3);
        }
    }

    public class d extends CustomTarget<File> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ LargeImageView d;
        public final /* synthetic */ ImageData.Image e;
        public final /* synthetic */ FrameLayout f;
        public final /* synthetic */ c3 g;

        public final void onLoadCleared(Drawable r2) {
            tt5.a.b("ImageViewer", "onLoadCleared");
        }

        public final void onLoadFailed(Drawable r8) {
            tt5.a.d("ImageViewer", "onLoadFailed， error:");
            c3.c(this.g, this.b, this.c, this.d, this.e, this.f);
        }

        public final void onLoadStarted(Drawable r3) {
            tt5.a.b("ImageViewer", "onLoadStarted");
            super.onLoadStarted(r3);
            this.g.u.setEnabled(false);
        }

        public final void onResourceReady(Object r11, Transition r12) {
            File r13 = (File) r11;
            if (r13 == null) goto L18;
            boolean r14 = this.a;
            String r2 = this.b;
            String r3 = this.c;
            VFSPath r16 = ay4.d.a().t(r13);
            LargeImageView r1 = this.d;
            ImageData.Image r5 = this.e;
            FrameLayout r6 = this.f;
            c3 r0 = this.g;
            r0.getClass();
            tt5.a.h("ImageViewer", "onResourceReady");
            if (r16 == null) goto L19;
            String r7 = com.bytedance.ee.util.io.b.b(r16);
            tt5.a.b("ImageViewer", "image type = " + r7);
            if (TextUtils.equals(r7, "html") == true) goto L16;
            r0.L(r16, r1, r5, r6);
            return;
        L16:
            FileUtils.p(r16);     // Catch: IOException -> L10
        L12:
            if (r14 == false) goto L20;
            tt5.a.h("ImageViewer", "loadResourceFinished(): retry");
            r0.E(r1, r2, r3, !TextUtils.equals(r2, r3), r5, r6);
            return;
        L20:
            return;
        L10:
            e = move-exception;
            tt5.a.e("ImageViewer", "FileUtils forceDelete file failed " + r16, e, false);
            goto L12
        L19:
            return;
        }

        public d(c3 r1, boolean r2, String r3, String r4, LargeImageView r5, ImageData.Image r6, FrameLayout r7) {
            this.g = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ c3 a;

        @Override // java.lang.Runnable
        public final void run() {
            c3 r0 = this.a;     // Catch: Throwable -> L4
            c3.d(r0, r0.t);     // Catch: Throwable -> L4
            c3 r1 = this.a;     // Catch: Throwable -> L4
            c3.d(r1, r1.h);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(c3 r1) {
            this.a = r1;
        }
    }

    public interface f {
        void onFailed(Throwable r1);

        void onSuccess(Uri r1);
    }

    public static class g {
        public final int a;
        public final String b;

        public g(String r2) {
            this.a = 3;
            this.b = r2;
        }

        public g(int r1) {
            this.a = r1;
        }
    }

    public static class h implements w85.a.b {
        public final MutableLiveData<g> a;

        public h(MutableLiveData<g> r1) {
            this.a = r1;
        }

        @Override // w85.a.b
        public final void e(String r3) {
            this.a.postValue(new g(1));
        }

        @Override // w85.a.b
        public final void c(String r2, w85.b r3) {
            this.a.postValue(new g(r3.b.getAbsolutePath()));
        }

        @Override // w85.a.b
        public final void a(String r2, String r3, int r4) {
            tt5.a.h("ImageViewer", "onDownloadFail()... key = " + r3 + ", errorCode = " + r4);
            this.a.postValue(new g(2));
        }
    }

    public class i implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ c3 a;

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public i(c3 r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r2) {
            if (r2 != 1) goto L6;
            this.a.H.onStop();
            return;
        L6:
            if (this.a.H.isPaused() == false) goto L9;
            this.a.H.onStart();
        L9:
            if (r2 != 2) goto L15;
            tw4.c r3 = this.a.O;
            if (r3 == null) goto L16;
            ImageViewerPlugin.access$2400(((ImageViewerPlugin.f) r3).a).b("switch");
            return;
        L16:
            return;
        }

        public final void onPageSelected(int r5) {
            c3 r0 = this.a;
            tw4.b r1 = r0.P;
            if (r1 == null) goto L14;
            int r2 = r5 - r0.G;
            if (r2 == 0) goto L11;
            if (r2 <= 0) goto L9;
            ImageAction r3 = ImageAction.NEXT;
        L10:
            r1.b(r3);
            goto L11
        L9:
            r3 = ImageAction.PREVIOUS;
        L11:
            c3 r4 = this.a;
            if (r4.c == true) goto L14;
            r1.a(c3.b(r4, r5));
        L14:
            c3 r6 = this.a;
            r6.G = r5;
            r6.t.setText((this.a.G + 1) + "/" + ((ArrayList) this.a.C).size());
            this.a.i0();
            String r7 = this.a.mC();
            c3 r8 = this.a;
            uw4.b r9 = r8.L;
            if (r9 != null) goto L17;
        L19:
            c3 r10 = this.a;
            tw4.c r11 = r10.O;
            if (r11 == null) goto L22;
            ((ImageViewerPlugin.f) r11).b(ImageType.getType(r10.mC()));
            c3 r12 = this.a;
            ((ImageViewerPlugin.f) r12.O).a(c3.b(r12, r5));
        L22:
            this.a.g0(r7);
            c3 r13 = this.a;
            if (r13.q == false) goto L26;
            com.bytedance.ee.util.ui.j.e(r13.H1);
            com.bytedance.ee.util.ui.j.d(this.a.H1, 5000);
            return;
        L26:
            return;
        L17:
            if (r8.c == true) goto L19;
            int r14 = r8.G;
            r8.c7();
            r9.c(r7, r14, this.a.iF());
            goto L19
        }
    }

    public class j extends PagerAdapter {
        public final /* synthetic */ c3 a;

        public final int getItemPosition(Object r1) {
            return -2;
        }

        public final boolean isViewFromObject(View r1, Object r2) {
            if (r1 != r2) goto L4;
            return true;
        L4:
            return false;
        }

        public final int getCount() {
            return ((ArrayList) this.a.C).size();
        }

        public j(c3 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object instantiateItem(ViewGroup r9, int r10) {
            String r0 = ((ImageData.Image) ListProtector.get(this.a.C, r10)).getUuid();
            if (ImageType.getType(r0) != ImageType.DIAGRAM) goto L10;
            DiagramWebView r11 = new DiagramWebView(this.a.getContext());
            ((ArrayList) this.a.U).add(r11);
            c3 r1 = this.a;
            tw4.a r2 = r1.N;
            if (r2 == null) goto L9;
            int r3 = r1.G;
            i3 r4 = new i3(r11);
            BaseDiagramPlugin r5 = (BaseDiagramPlugin) ImageViewerPlugin.access$2300(((ImageViewerPlugin.e) r2).a, BaseDiagramPlugin.class);
            if (r5 == null) goto L9;
            r5.requestDiagramSVGData(r0, r3, r4);
        L9:
            r11.setOnClickListener(this.a.P0);
            this.a.a0(r11);
            r11.setTag(r0);
            View r12 = r11;
        L11:
            r9.addView(r12);
            return r12;
        L10:
            LargeImageView r6 = new ImageViewerLargeImageView(this.a.getContext());
            r6.w();
            r6.setOnClickListener(this.a.P0);
            ((ArrayList) this.a.W).add(r6);
            ImageData.Image r7 = (ImageData.Image) ListProtector.get(this.a.C, r10);
            String r8 = r7.getOriginalSrc();
            String r13 = r7.getSrc();
            r6.setTag(r0);
            FrameLayout r14 = new FrameLayout(this.a.getContext());
            r14.addView(r6);
            r14.setTag(2131388105, r6);
            this.a.K(r6, r8, r13, r7, r14);
            r12 = r14;
            goto L11
        }

        public final void destroyItem(ViewGroup r3, int r4, Object r5) {
            if ((r5 instanceof DiagramWebView) == false) goto L6;
            DiagramWebView r6 = (DiagramWebView) r5;
            ((ArrayList) this.a.U).remove(r6);
            r6.clearHistory();
            r6.loadUrl("about:blank");
            r6.destroy();
        L16:
            r3.removeView((View) r5);
            return;
        L6:
            if ((r5 instanceof FrameLayout) == false) goto L15;
            LargeImageView r7 = (View) ((FrameLayout) r5).getTag(2131388105);
            if ((r7 instanceof LargeImageView) == false) goto L15;
            c3 r0 = this.a;
            if (r0.k == false) goto L12;
            r0.m(r7);
        L12:
            ((ArrayList) this.a.W).remove(r7);
            SubsamplingScaleImageView r8 = r7.getScaleImageView();
            if (r8 == null) goto L15;
            r8.setOnScaleEventListener(null);
        L15:
            this.a.H.clear((View) r5);
            goto L16
        }
    }

    public class k implements ImageViewerShareDialogFragment.b {
        public final /* synthetic */ c3 a;

        public k(c3 r1) {
            this.a = r1;
        }

        public final boolean a(ShareType r4) {
            if (CipherManager.d() == 1) goto L5;
            return true;
        L5:
            if (r4 != ShareType.Download) goto L7;
            int r5 = 2131887290;
        L8:
            Toast.showText(this.a.getContext(), this.a.getContext().getString(r5), 1, true);
            CipherManager.h();
            return false;
        L7:
            r5 = 2131887299;
            goto L8
        }

        public final void b(final ShareType r5) {
            switch(a.b[r5.ordinal()]) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L5;
                case 4: goto L5;
                case 5: goto L5;
                case 6: goto L5;
                case 7: goto L5;
                default: goto L4;
            };
        L4:
            tt5.a.k("ImageViewer", "ShareActionHandler - doShareToType, not supported shareType: " + r5);
            return;
        L5:
            final c3 r0 = this.a;
            if (c3.J(r0.mC()) == false) goto L8;
            r0.X(new c1(r0, r5));
            return;
        L8:
            VFSPath r1 = c3.t(c3.u(r0.iF()));
            if (r1 == null) goto L12;
            r0.Y.add(Flowable.just(r1).subscribeOn(fo5.d.c()).map(new t(r0)).observeOn(fo5.d.d()).subscribe(new u(r0, r5), new v(r0)));
            return;
        L12:
            if (r0.j("shareImageToExternalApp") == false) goto L23;
            final ImageData.Image r2 = (ImageData.Image) ListProtector.get(r0.C, r0.G);
            r0.Y.add(Flowable.just(r2.getRealSrc()).subscribeOn(fo5.d.c()).map(new w(r0, r2)).map(new x(r0)).observeOn(fo5.d.d()).subscribe(new y(r0, r5), new z(r0)));
            return;
        L23:
            return;
        L15:
            c3 r6 = this.a;
            r6.F(r6.A);
            return;
        L16:
            c3 r7 = this.a;
            r7.G(r7.A);
        }
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final boolean isShowing() {
        return true;
    }

    static {
        L1 = new ArrayList();
    }

    public final String A() {
        ImageData r0 = this.B;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getImage() != null) goto L7;
        return "";
    L7:
        return B(this.B.getImage().getOriginalSrc());
    }

    public final void I() {
        if (this.p0 == false) goto L6;
        tt5.a.h("ImageViewer", "initActionSheet() openingActionSheet is true");
        return;
    L6:
        LargeImageView r0 = iF();
        if ((r0 instanceof LargeImageView) == false) goto L9;
        LargeImageView r1 = r0;
    L11:
        if (r1 == null) goto L24;
        SubsamplingScaleImageView r2 = r1.getScaleImageView();
        if (r2 != null) goto L16;
    L25:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L30;
        tt5.a.h("ImageViewer", "initActionSheet() use cached qr result without screenshot scan");
        p(w());
        return;
    L30:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.support_screenshot_qrcode_scan_enable") == true) goto L33;
        tt5.a.h("ImageViewer", "initActionSheet() isSupportScreenShot is false");
        p(w());
        return;
    L33:
        this.p0 = true;
        Disposable r4 = Flowable.just("").subscribeOn(Schedulers.io()).map(new com.bytedance.ee.bear.imageviewer.k(this)).doOnNext(new l(this)).filter(new m()).flatMap(new n(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this), new p(this));
        this.Y.add(r4);
        return;
    L16:
        if (r2.getVisibility() != 0) goto L25;
        if (r2.b1 == false) goto L24;
        if (Math.abs(r2.getScale() - r2.getMinScale()) < 0.001f) goto L25;
    L24:
        r3 = false;
        goto L26
    L9:
        r1 = null;
        goto L11
    }

    public final void M() {
        tt5.a.h("ImageViewer", "notifyDelegateToClose()");
        uw4.c r0 = this.J;
        if (r0 == null) goto L6;
        r0.b(mC());
        return;
    }

    public final void N() {
        tt5.a.h("ImageViewer", "onClickAreaMark");
        tw4.b r0 = this.P;
        if (r0 == null) goto L6;
        r0.b(ImageAction.IMAGE_SELECTION_CLICK);
    L6:
        if (this.K == null) goto L9;
        View r1 = iF();
        View r2 = u(r1);
        VFSPath r3 = t(r2);
        this.K.b(mC(), r1, r2, r3);
        return;
    }

    public final void P() {
        Iterator r0 = ((ArrayList) this.W).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        LargeImageView r1 = (LargeImageView) r0.next();
        if (r1 == null) goto L4;
        SubsamplingScaleImageView r3 = r1.b;
        if (r3 == null) goto L4;
        if (r3.getVisibility() != 0) goto L4;
        SubsamplingScaleImageView r2 = r1.b;
        r2.G(true);
        r2.G1 = null;
        r2.H1 = null;
        r2.L1 = null;
        r2.M1 = null;
        goto L4
    L12:
        uw4.c r4 = this.J;
        if (r4 == null) goto L18;
        Fragment r5 = this.d;
        if ((r5 instanceof IImageViewer) == false) goto L17;
        r4.a((IImageViewer) r5);
        goto L18
    L17:
        r4.a(null);
    L18:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).s("docs_image_view", (String) v(null).first);
    }

    public final void Q() {
        tt5.a.b("ImageViewer", "onDestroyView");
        Iterator r0 = ((ArrayList) this.U).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DiagramWebView r1 = (DiagramWebView) r0.next();
        r1.clearHistory();
        r1.loadUrl("about:blank");
        r1.destroy();
        goto L4
    L6:
        ((ArrayList) this.U).clear();
        if (this.k == false) goto L12;
        Iterator r2 = new ArrayList(((HashMap) this.X).keySet()).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        m((LargeImageView) r2.next());
    L12:
        this.Y.dispose();
        FragmentActivity r3 = this.b;
        if (r3 == null) goto L15;
        bp5.c.c(r3, this.h1);
    L15:
        xu5.b.a r4 = this.S;
        if (r4 == null) goto L18;
        r4.resetState();
    L18:
        sa5.b r5 = this.g1;
        if (r5 == null) goto L21;
        r5.d(this);
    L21:
        tw4.c r6 = this.O;
        if (r6 == null) goto L24;
        ImageViewerPlugin.access$2400(((ImageViewerPlugin.f) r6).a).b("quit");
    L24:
        com.bytedance.ee.bear.bizwidget.magicshare.cursor.b r7 = this.r;
        if (r7 == null) goto L30;
        r7.hide();
        return;
    }

    public final void S() {
        LKUIDialog r0 = this.R;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        a(this.R);
    L8:
        if (this.G < (((ArrayList) this.C).size() - 1)) goto L10;
        this.G = this.B.getImageList().size() - 1;
    L10:
        W();
    }

    public final void W() {
        ((ArrayList) this.C).clear();
        List<ImageData.Image> r0 = this.C;
        ArrayList r1 = (ArrayList) r0;
        r1.addAll(this.B.getImageList());
        int r2 = this.G;
        j r3 = this.s;
        if (r3 == null) goto L5;
        r3.notifyDataSetChanged();
    L5:
        V(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Wh() {
        this.o.set(true);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ImageData.Image c7() {
        ImageData r0 = this.B;
        if (r0 != null) goto L5;
        return null;
    L5:
        List<ImageData.Image> r1 = r0.getImageList();
        if (r1 != null) goto L8;
        return null;
    L8:
        int r2 = r1.size();
        int r3 = this.G;
        if (r2 <= r3) goto L14;
        if (r3 < 0) goto L14;
        return (ImageData.Image) ListProtector.get(r1, r3);
    L14:
        return null;
    }

    public final void d0() {
        tw4.c r0 = this.O;
        if (r0 == null) goto L5;
        ImageViewerPlugin.access$2400(((ImageViewerPlugin.f) r0).a).b("delete_image");
    L5:
        uw4.f r1 = this.K;
        if (r1 == null) goto L8;
        mC();
        r1.a();
    L8:
        FragmentActivity r2 = this.b;
        Intrinsics.checkNotNullParameter(r2, "context");
        UDDialogBuilder r3 = new UDDialogBuilder(r2);
        r3.autoDismiss(true);
        r3.message(2131887663);
        DialogInterface.OnClickListener r4 = new f1(this);
        r3.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887736).textColorRes(2131102093).onClickListener(r4));
        r3.addActionButton(2131391778, 2131887716, null);
        DialogInterface.OnCancelListener r5 = new g1();
        Intrinsics.checkNotNullParameter(r5, "value");
        r3.onCancelListener(r5);
        UDDialog r6 = r3.build();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    }

    public final boolean f() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        if (x() != null) goto L5;
    L9:
        return false;
    L5:
        if (x().isExport() == false) goto L9;
        if (r0.g() == false) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ViewGroup getContainerView() {
        ViewGroup r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return null;
    }

    public Context getContext() {
        FragmentActivity r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return eu5.b.a;
    }

    public final boolean i() {
        StringBuilder r0 = new StringBuilder("getCurrentToolStatus == ");
        r0.append(x());
        r0.append(", imageSupportedFollowMask.get(getCurrentImageUUID() == ");
        Map<String, Boolean> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r0.append(r2.get(mC()));
        r0.append(", isValidSchema: ");
        String r3 = "";
        if (c7() != null) goto L5;
        String r4 = "";
    L6:
        r0.append(com.bytedance.ee.util.io.e.c(r4));
        tt5.a.h("ImageViewer", r0.toString());
        if (x() != null) goto L9;
        return false;
    L9:
        if (x().isFollowMark() == false) goto L21;
        Boolean r5 = Boolean.TRUE;
        Map<String, Boolean> r6 = this.a;
        HashMap r7 = (HashMap) r6;
        if (r5.equals(r7.get(mC())) == true) goto L13;
        return false;
    L13:
        if (c7() == null) goto L17;
        r3 = c7().getRealSrc();
    L17:
        if (com.bytedance.ee.util.io.e.c(r3) == false) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L5:
        r4 = c7().getRealSrc();
        goto L6
    }

    public final void i0() {
        IImageViewer.ImageCommentMode r0 = this.n;
        if (r0 == null) goto L9;
        if (r0 == IImageViewer.ImageCommentMode.EXIT) goto L9;
        tt5.a.h("ImageViewer", "updateToolStatusView: imgaeCommentMode = " + this.n);
        return;
    L9:
        if (this.i == true) goto L11;
    L14:
        this.t.clearAnimation();
        this.h.clearAnimation();
        int r1 = 0;
        this.t.setVisibility(0);
        this.h.setVisibility(0);
        Y();
        ImageView r2 = this.u;
        if (f() == false) goto L17;
        int r3 = 0;
    L18:
        r2.setVisibility(r3);
        AppCompatImageView r4 = this.v;
        if (h() == true) goto L21;
    L23:
        int r5 = 8;
    L24:
        r4.setVisibility(r5);
        View r6 = this.w;
        if (i() == false) goto L27;
        int r7 = 0;
    L28:
        r6.setVisibility(r7);
        h0();
        ImageView r8 = this.y;
        if (g() == true) goto L32;
        r1 = 8;
    L32:
        r8.setVisibility(r1);
        if (this.q == false) goto L36;
        com.bytedance.ee.util.ui.j.e(this.H1);
        com.bytedance.ee.util.ui.j.d(this.H1, 5000);
        return;
    L36:
        return;
    L27:
        r7 = 8;
        goto L28
    L21:
        if (i() == true) goto L23;
        r5 = 0;
        goto L24
    L17:
        r3 = 8;
        goto L18
    L11:
        if (this.l == true) goto L14;
        tt5.a.h("ImageViewer", "updateToolStatusView: menuAndIndexVisibility is false");
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final String mC() {
        ImageData r0 = this.B;
        if (r0 != null) goto L6;
        tt5.a.k("ImageViewer", "getCurrentImageUUID(): mCurrentImageData is null");
        return "";
    L6:
        List<ImageData.Image> r1 = r0.getImageList();
        if (r1 != null) goto L9;
    L23:
        tt5.a.k("ImageViewer", "getCurrentImageUUID(): imageList.isEmpty()");
        return "";
    L9:
        if (r1.isEmpty() == true) goto L23;
        if (this.G < r1.size()) goto L14;
        this.G = r1.size() - 1;
    L14:
        int r3 = this.G;
        if (r3 >= 0) goto L17;
    L21:
        tt5.a.d("ImageViewer", "getCurrentImageUUID mImageList size: " + ((ArrayList) this.C).size() + ", cPos = " + this.G);
        return "";
    L17:
        if (r3 >= ((ArrayList) this.C).size()) goto L21;
        return ((ImageData.Image) ListProtector.get(r1, this.G)).getUuid();
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        uw4.d r0 = this.G1;
        if (r0 != null) goto L5;
    L8:
        M();
        return true;
    L5:
        if (r0.onBackPressed() == false) goto L8;
        tt5.a.h("ImageViewer", "onBackPressedListener()...accept");
        return true;
    }

    public final ImageData.ToolStatus x() {
        ImageData r0 = this.B;
        if (r0 != null) goto L5;
    L19:
        tt5.a.d("ImageViewer", "getCurrentToolStatus()... mCurrentImageData or mCurrentImageData.getImageList() is empty");
        return null;
    L5:
        if (r0.getImageList() == null) goto L19;
        if (this.B.getImageList().isEmpty() == true) goto L19;
        if (this.G < this.B.getImageList().size()) goto L13;
        this.G = this.B.getImageList().size() - 1;
    L13:
        if (this.G < 0) goto L18;
        ImageData.ToolStatus r1 = ((ImageData.Image) ListProtector.get(this.B.getImageList(), this.G)).getSingleToolStatus();
        if (r1 == null) goto L18;
        return r1;
    L18:
        return this.B.getToolStatus();
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [com.bytedance.ee.bear.imageviewer.z2] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.bytedance.ee.bear.imageviewer.g] */
    public c3() {
        ArrayList r0 = (ArrayList) L1;
        r0.add("jpeg");
        r0.add("jpg");
        r0.add("png");
        this.a = new HashMap();
        this.c = true;
        this.g = new HashMap();
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.i = r1.h("ccm.mobile.support_img_zoom_when_area_mark");
        this.j = r1.g("ccm.slides.image_area_comment_enabled");
        r1.g("ccm.docx.pc.image_viewer_v2_enable");
        this.k = r1.g("ccm.image.open_thumbnail_placeholder_enable");
        this.l = true;
        this.o = new AtomicBoolean(false);
        this.p = new i(this);
        Application r2 = LarkContext.getApplication();
        UserSession r4 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r2, com.ss.android.lark.passportc.convention.a.class)).b();
        this.q = ((dn4.a) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r2, com.ss.android.lark.passportc.internal.v.class)).c(r4), dn4.a.class)).a().isCurrentEnable("ccm.doc.mobile.picture_clear_screen");
        this.r = null;
        this.A = null;
        this.C = new ArrayList();
        this.E = new MutableLiveData();
        this.F = new MutableLiveData();
        this.U = new ArrayList();
        com.bytedance.ee.bear.contract.d r3 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.V = 0;
        this.W = new ArrayList();
        this.X = new HashMap();
        this.Y = new CompositeDisposable();
        this.Z = r1.h("ccm.docs.all.synced_block_enable");
        this.p0 = false;
        this.L0 = new k(this);
        this.P0 = new z2(this);
        this.V0 = new com.bytedance.ee.bear.imageviewer.g(this);
        this.h1 = new b();
        this.k1 = "";
        this.p1 = 0;
        this.x1 = "";
        this.H1 = new e(this);
        this.V = System.currentTimeMillis();
    }

    public final void Y() {
        if (c0() == true) goto L6;
        this.I.setVisibility(8);
        return;
    L6:
        boolean r1 = false;
        this.I.setVisibility(0);
        int r0 = j08.b.b(eu5.b.a.getResources().getColor(2131103449), 0.25f);
        ImageCommentData r2 = this.D;
        if (r2 == null) goto L28;
        ImageCommentData.ImageCommentInfo r3 = r2.getImageCommentDataMap().get(mC());
        if (r3 != null) goto L11;
    L13:
        this.I.setCompoundDrawablePadding(0);
        this.I.setText("");
    L14:
        if (r3 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        TextView r5 = this.I;
        if (r4 == true) goto L22;
    L24:
        r5.setEnabled(r1);
        TextView r6 = this.I;
        if (r4 == false) goto L27;
        r0 = -1;
    L27:
        r6.setTextColor(r0);
        return;
    L22:
        if (r() == false) goto L24;
        r1 = true;
        goto L24
    L16:
        if (r3.isCommentable() == false) goto L18;
        r4 = true;
        goto L19
    L11:
        if (r3.getCommentCount() <= 0) goto L13;
        this.I.setCompoundDrawablePadding(UIHelper.dp2px(7.0f));
        this.I.setText(String.valueOf(r3.getCommentCount()));
        goto L14
    L28:
        tt5.a.k("ImageViewer", "Image Comment data is null");
        this.I.setCompoundDrawablePadding(0);
        this.I.setText("");
        TextView r7 = this.I;
        if (x() != null) goto L31;
    L33:
        boolean r8 = false;
    L34:
        if (r8 == true) goto L36;
    L38:
        r7.setEnabled(r1);
        this.I.setTextColor(r0);
        return;
    L36:
        if (r() == false) goto L38;
        r1 = true;
        goto L38
    L31:
        if (x().isCommentable() == false) goto L33;
        r8 = true;
        goto L34
    }

    public final void Z() {
        if (e() == true) goto L6;
        this.z.setVisibility(8);
        return;
    L6:
        this.z.setVisibility(0);
        this.z.setEnabled(true);
        this.z.setOnClickListener(new com.bytedance.ee.bear.imageviewer.j(this));
    }

    public final boolean c0() {
        if (x() != null) goto L5;
    L9:
        return false;
    L5:
        if (x().isComment() == false) goto L9;
        if (AppInfoUtils.e().booleanValue() == true) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void close() {
        M();
        FragmentActivity r0 = this.b;
        if (r0 == null) goto L5;
        bp5.c.c(r0, this.h1);
    L5:
        xu5.b.a r1 = this.S;
        if (r1 == null) goto L8;
        r1.resetState();
    L8:
        sa5.b r2 = this.g1;
        if (r2 == null) goto L12;
        r2.d(this);
        return;
    }

    public final boolean e() {
        ImageData.ToolStatus r0 = x();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        tt5.a.h("ImageViewer", "canAreaMark, currentToolStatus = " + r0 + ", from = " + this.x1 + ", canAreaMark = " + r1);
        return r1;
    L5:
        if (r0.isAreaComment() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void e0() {
        Context r0 = getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r0);
        r1.autoDismiss(true);
        r1.message(2131887670);
        r1.messageTextColor(2131108724);
        r1.messageGravity(17);
        r1.width(260.0f);
        r1.marginInDp(0);
        r1.addActionButton(2131391777, 2131887719, new com.bytedance.ee.bear.imageviewer.i(this));
        r1.cancelable(false);
        UDDialog r2 = r1.build();
        this.T = r2;
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }

    public final void f0() {
        ImageData.Image r0 = c7();
        boolean r2 = false;
        Matrix r3 = null;
        if (r0 != null) goto L37;
    L8:
        String r4 = null;
    L9:
        LargeImageView r5 = iF();
        if ((r5 instanceof LargeImageView) == false) goto L18;
        LargeImageView r6 = r5;
        r3 = new Matrix();
        ImageView r7 = r6.getImageView();
        if (r7.getVisibility() != 0) goto L14;
        r3.set(r7.getImageMatrix());
    L14:
        SubsamplingScaleImageView r8 = r6.getScaleImageView();
        if (r8.getVisibility() != 0) goto L18;
        r3.set(r8.getBitmapMatrix());
    L18:
        if (this.K == null) goto L24;
        if (r0 == null) goto L24;
        if (TextUtils.isEmpty(r4) == true) goto L24;
        if (r3 == null) goto L24;
        this.K.f(r4, r0.getCrop(), r3);
        return;
    L24:
        StringBuilder r9 = new StringBuilder("mOnIconItemClickListener: ");
        if (this.K == null) goto L27;
        boolean r10 = true;
    L28:
        r9.append(r10);
        r9.append(" currImg: ");
        if (r0 == null) goto L31;
        boolean r1 = true;
    L32:
        r9.append(r1);
        r9.append(" fileToken: ");
        r9.append(!TextUtils.isEmpty(r4));
        r9.append(" matrix: ");
        if (r3 == null) goto L35;
        r2 = true;
    L35:
        r9.append(r2);
        tt5.a.k("ImageViewer", r9.toString());
        return;
    L31:
        r1 = false;
        goto L32
    L27:
        r10 = false;
        goto L28
    L37:
        r4 = UriProtector.parse(r0.getSrc()).getLastPathSegment();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        tt5.a.e("ImageViewer", "supportFollowMask, ", e, false);
        goto L8
    }

    public final boolean g() {
        if (x() != null) goto L5;
    L7:
        return false;
    L5:
        if (x().isDelete() == false) goto L7;
        return true;
    }

    public final boolean h() {
        if (x() != null) goto L5;
        return false;
    L5:
        return x().isEdit();
    }

    public final void h0() {
        if (TextUtils.isEmpty(w()) == true) goto L5;
    L16:
        this.x.setVisibility(0);
        this.x.setOnClickListener(new u1(this));
        return;
    L5:
        if (g() == true) goto L16;
        if (f() == true) goto L16;
        if (h() == true) goto L16;
        if (c0() == true) goto L16;
        if (i() == true) goto L16;
        this.x.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final View iF() {
        ImageData.Image r0 = c7();
        SwipeControlViewPager r1 = this.f;
        if (r1 == null) goto L8;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r1.findViewWithTag(r0.getUuid());
    L8:
        return null;
    }

    public final boolean r() {
        if (getContext() != null) goto L6;
        return false;
    L6:
        if (getContext().getResources().getConfiguration().orientation != 1) goto L8;
    L13:
        return true;
    L8:
        if (ku5.c.k(getContext()) == true) goto L13;
        int r0 = sbb.e.o.b;
        int r3 = this.p1;
        if (r0 == r3) goto L13;
        if (sbb.e.m.b == r3) goto L13;
        return false;
    }

    public final String w() {
        ImageData.Image r0 = c7();
        if (r0 != null) goto L7;
        return "";
    L7:
        return (String) ((HashMap) this.g).get(r0);
    }

    public static String B(String r3) {
        if (r3 != null) goto L10;
    L8:
        return "";
    L10:
        String r4 = UriProtector.parse(r3).getPath();     // Catch: Exception -> L6
        String r5 = r4.substring(0, r4.lastIndexOf("/"));     // Catch: Exception -> L6
        return r5.substring(r5.lastIndexOf("/") + 1, r5.length());
    L6:
        e = move-exception;
        tt5.a.d("ImageViewer", "getImageToken error " + e);
        goto L8
    }

    public static boolean J(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(ImageType.DIAGRAM.uuidPrefix) == false) goto L7;
        return true;
    }

    public static void a(UDDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static VFSPath n(String r2) throws IOException {
        VFSPath r0 = ay4.c.b(Biz.DOCS, "cover");
        if (com.suite.lark.component.storage.ext.b.b(r0) == true) goto L5;
        com.suite.lark.component.storage.ext.b.d(r0);
    L5:
        VFSPath r3 = r0.subPath(r2);
        if (com.suite.lark.component.storage.ext.b.b(r3) == true) goto L8;
        com.suite.lark.component.storage.ext.b.a(r3);
    L8:
        return r3;
    }

    public static byte[] o(String r2) throws Exception {
        if (TextUtils.isEmpty(r2) == true) goto L14;
        if (r2.contains(",") == false) goto L15;
        r2 = r2.substring(r2.indexOf(",") + 1);
    L15:
        return Base64.decode(r2, 0);
    L10:
        e = move-exception;
        throw new Exception("decodeBase64ToBytes, [image export] decode failed", e);
    L14:
        throw new IllegalArgumentException("base64String is empty");
    }

    public static VFSPath s(VFSPath r6) {
        String r0 = r6.getRealPath();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r6;
    L5:
        String r1 = com.bytedance.ee.util.io.b.b(r6);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r6;
    L8:
        int r2 = r0.lastIndexOf(47);
        int r4 = r0.lastIndexOf(".");
        if (r4 <= r2) goto L11;
        String r3 = r0.substring(0, r4) + "." + r1;
    L13:
        if (TextUtils.equals(r3, r0) == false) goto L15;
        return r6;
    L15:
        VFSPath r5 = ay4.d.a().z(r3);
    L20:
        e = move-exception;
        tt5.a.e("ImageViewer", "fixImagePathToRealType failed", e, false);
        return r6;
    L17:
        if (com.suite.lark.component.storage.ext.b.b(r5) == true) goto L19;
        FileUtils.j(r6, r5);     // Catch: Exception -> L20
    L19:
        return r5;
    L11:
        r3 = r0 + "." + r1;
        goto L13
    }

    public static VFSPath t(View r3) {
        if (r3 != null) goto L6;
        tt5.a.d("ImageViewer", "getCurImagePath(): container is null");
        return null;
    L6:
        Object r4 = r3.getTag(2131388100);
        if ((r4 instanceof VFSPath) == true) goto L11;
        tt5.a.d("ImageViewer", "getCurImagePath(): tag is not VFSPath");
        return null;
    L11:
        return (VFSPath) r4;
    }

    public static View u(View r3) {
        if (r3 != null) goto L6;
        tt5.a.d("ImageViewer", "onClickAreaMark(): currPageSubView is null");
        return null;
    L6:
        Object r4 = r3.getParent();
        if (r4 != null) goto L11;
        tt5.a.d("ImageViewer", "onClickAreaMark(): container is null");
        return null;
    L11:
        if ((r4 instanceof View) == true) goto L15;
        tt5.a.d("ImageViewer", "onClickAreaMark(): container is not FrameLayout");
        return null;
    L15:
        return (View) r4;
    }

    public static String y(String r2) {
        r2.getClass();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1487394660: goto L18;
            case -1487018032: goto L14;
            case -879267568: goto L10;
            case -879264467: goto L6;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L28;
            default: goto L22;
        };
    L22:
        return ".png";
    L24:
        return ".gif";
    L26:
        return ".webp";
    L28:
        return ".jpg";
    L6:
        if (r2.equals("image/jpg") == false) goto L21;
        r1 = 3;
        goto L21
    L10:
        if (r2.equals("image/gif") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (r2.equals("image/webp") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (r2.equals("image/jpeg") == false) goto L21;
        r1 = 0;
        goto L21
    }

    public final PermissionResponse C(String r9) {
        Pair<String, Integer> r1 = v(null);
        if (J(r9) == false) goto L6;
        BaseEntity r10 = new BaseEntity((String) r1.first, sbb.e.d(((Integer) r1.second).intValue()), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r10, "EXPORT"), null);
    L6:
        UniBaseEntity r11 = new UniBaseEntity((String) r1.first, sbb.e.l, BizDomain.FileBizDomainCCM, "", "", sbb.e.d(((Integer) r1.second).intValue()));
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r11, "ATTACHMENT_DOWNLOAD"), null);
    }

    public final t3 D(String r4) {
        Pair<String, Integer> r0 = v(null);
        if (J(r4) == false) goto L7;
        return new t3(((Integer) r0.second).intValue(), (String) r0.first, "CCM_EXPORT");
    L7:
        return new t3(sbb.e.l.b, "", "CCM_ATTACHMENT_DOWNLOAD");
    }

    public final void F(PermissionResponse r3) {
        tt5.a.h("ImageViewer", "handleActionSheetItemClick allow: " + r3.getAllow() + ", " + r3.getDenySource());
        r3.getCallback().a(getContext(), r3);
        if (r3.getAllow() == false) goto L9;
        tw4.c r4 = this.O;
        if (r4 == null) goto L7;
        ImageViewerPlugin.access$2400(((ImageViewerPlugin.f) r4).a).b("press_download");
    L7:
        l("download");
        return;
    }

    public final void G(PermissionResponse r3) {
        tt5.a.h("ImageViewer", "handleActionSheetItemClickSend allow: " + r3.getAllow() + ", " + r3.getDenySource());
        r3.getCallback().a(getContext(), r3);
        if (r3.getAllow() == false) goto L9;
        tw4.c r4 = this.O;
        if (r4 == null) goto L7;
        ImageViewerPlugin.access$2400(((ImageViewerPlugin.f) r4).a).b("press_send_lark");
    L7:
        l("send_to_chat");
        return;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void JB(ImageCommentData r2) {
        this.E.setValue(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void LN(com.bytedance.ee.bear.document.imageviewer.areacomment.c.f r1) {
        this.H0 = r1;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ob(ImageViewerPlugin.f r1) {
        this.O = r1;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void RX(tw4.b r1) {
        this.P = r1;
    }

    public final void V(int r4) {
        if (this.f.getCurrentItem() != r4) goto L5;
        Y();
    L5:
        SwipeControlViewPager r0 = this.f;
        if (r0 == null) goto L8;
        r0.setCurrentItem(r4);
    L8:
        String r1 = mC();
        uw4.b r2 = this.L;
        if (r2 == null) goto L11;
        c7();
        r2.c(r1, r4, iF());
    L11:
        tt5.a.h("ImageViewer", "refreshImageData(): uuid = " + du5.b.g(r1));
        this.t.setText((r4 + 1) + "/" + ((ArrayList) this.C).size());
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ws(com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.c r1) {
        this.G1 = r1;
    }

    public final void X(tw4.a.InterfaceC0300a r5) {
        String r0 = mC();
        tw4.a r1 = this.N;
        if (r1 == null) goto L8;
        int r2 = this.G;
        ImageViewerPlugin.e r3 = (ImageViewerPlugin.e) r1;
        ImageViewerPlugin.access$1300(r3.a).downloadImage(r0, r2);
        BaseDiagramPlugin r4 = (BaseDiagramPlugin) ImageViewerPlugin.access$2200(r3.a, BaseDiagramPlugin.class);
        if (r4 == null) goto L9;
        r4.registerDiagramBase64DataRequestListener(r5);
        return;
    L9:
        return;
    }

    public final void a0(View r3) {
        r3.setOnLongClickListener(this.V0);
        this.y.setEnabled(true);
        this.u.setEnabled(true);
        g0(mC());
        this.I.setOnClickListener(new e2(this));
        this.y.setOnClickListener(new g2(this));
        if (h() == false) goto L6;
        this.v.setEnabled(true);
        this.v.setOnClickListener(new j2(this));
    L6:
        if (i() == false) goto L8;
        this.w.setEnabled(true);
        this.w.setOnClickListener(new t2(this));
    L8:
        Z();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void aQ(r15.c r1) {
        this.M = r1;
    }

    public final void b0(Uri r3) {
        if (r3 == null) goto L4;
        final ArrayList r0 = new ArrayList();
        r0.add(r3);
        Disposable r4 = Flowable.just("").subscribeOn(fo5.d.b()).map(new y1()).map(new z1(r0)).subscribe(new a2(), new b2());
        this.Y.add(r4);
        return;
    L4:
        tt5.a.d("ImageViewer", "shareToLark() failed: file is null");
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void c80(ImageViewerPlugin.e r1) {
        this.N = r1;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void f00(boolean r5) {
        this.l = r5;
        View r0 = this.h;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        TextView r2 = this.t;
        if (r5 == false) goto L9;
        r1 = 0;
    L9:
        r2.setVisibility(r1);
        View r4 = iF();
        if (r5 == false) goto L12;
        com.bytedance.ee.bear.imageviewer.g r6 = this.V0;
    L13:
        if (r4 == null) goto L16;
        r4.setOnLongClickListener(r6);
        return;
    L16:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = 8;
        goto L6
    }

    public final void g0(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        tt5.a.d("ImageViewer", "updateDownStyleAndClick err: uuid is null or empty!!!");
        return;
    L6:
        final t3 r0 = D(r5);
        final gj5.c r1 = k(r0);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        final jg5.e r2 = jg5.e.a.a;
        if (r2.g() == false) goto L9;
        this.A = C(r5);
        boolean r6 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(this.A);
    L10:
        ImageView r3 = this.u;
        if (r6 == false) goto L13;
        int r7 = 2131233826;
    L14:
        r3.setImageResource(r7);
        this.u.setOnClickListener(new com.bytedance.ee.bear.imageviewer.h(this, r2, r1, r0));
        return;
    L13:
        r7 = 2131233828;
        goto L14
    L9:
        r6 = r1.a;
        goto L10
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void hl(IImageViewer.ImageCommentMode r7) {
        tt5.a.h("ImageViewer", "imageCommentMode: " + r7);
        this.n = r7;     // Catch: Exception -> L19
        View r3 = iF();     // Catch: Exception -> L19
        if (r7 != IImageViewer.ImageCommentMode.EXIT) goto L13;
        this.m.setEnabled(true);     // Catch: Exception -> L19
        this.f.a = false;     // Catch: Exception -> L19
        if (r3 == null) goto L9;
        r3.setOnClickListener(this.P0);     // Catch: Exception -> L19
        r3.setOnLongClickListener(this.V0);     // Catch: Exception -> L19
    L9:
        if (this.q == true) goto L23;
        i0();     // Catch: Exception -> L19
        return;
    L23:
        return;
    L13:
        if (r7 != IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L15;
        this.m.setEnabled(false);     // Catch: Exception -> L19
    L15:
        this.f.a = true;     // Catch: Exception -> L19
        this.h.setVisibility(8);     // Catch: Exception -> L19
        this.t.setVisibility(8);     // Catch: Exception -> L19
        if (r3 == null) goto L24;
        r3.setOnClickListener(null);     // Catch: Exception -> L19
        r3.setOnLongClickListener(null);     // Catch: Exception -> L19
        return;
    L24:
        return;
    L19:
        e = move-exception;
        tt5.a.e("ImageViewer", "imageCommentMode: ", e, false);
    }

    public final boolean j(String r3) {
        int r0 = this.G;
        if (r0 >= 0) goto L5;
    L11:
        tt5.a.d("ImageViewer", r3 + " mImageList size: " + ((ArrayList) this.C).size() + ", cPos = " + this.G + ", or current image null");
        return false;
    L5:
        if (r0 >= ((ArrayList) this.C).size()) goto L11;
        if (ListProtector.get(this.C, this.G) == null) goto L11;
        return true;
    }

    public final gj5.c k(t3 r5) {
        if (this.p1 != 28) goto L7;
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    L7:
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g(r5.c, FileBizDomain.FileBizDomainCCM, r5.getType(), r5.b);
    }

    public final void l(final String r5) {
        FragmentActivity r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.k("ImageViewer", "checkStoragePermissions mFragmentActivity is null");
        return;
    L6:
        com.ss.android.lark.utils.h.g(r0, new s(this, r5), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_docs_image_preview_download"), new String[0]);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.FrameLayout, com.bytedance.ee.bear.imageviewer.view.ImageViewerLargeImageView] */
    public final void m(LargeImageView r3) {
        io.reactivex.disposables.a r0 = (io.reactivex.disposables.a) ((HashMap) this.X).remove(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        this.Y.delete(r0);
        if ((r3 instanceof ImageViewerLargeImageView) == false) goto L14;
        ?? r4 = (ImageViewerLargeImageView) r3;
        View r1 = r4.g;
        if (r1 != null) goto L10;
        r1 = null;
    L11:
        if (r1 == null) goto L15;
        this.H.clear(r1);
        return;
    L15:
        return;
    L10:
        r4.g = null;
        r4.removeView(r1);
        goto L11
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void mG(uw4.b r1) {
        this.L = r1;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void oZ(boolean r2) {
        this.f.a = r2;
    }

    public final void p(final String r9) {
        this.p0 = false;
        if (this.b1 != null) goto L84;
        LKUIDialog r1 = this.R;
        if (r1 == null) goto L10;
        if (r1.isShowing() == true) goto L84;
    L10:
        if (j("initActionSheet") == true) goto L12;
        return;
    L12:
        this.b1 = new com.bytedance.ee.bear.widgets.a(getContext());
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        final jg5.e r2 = jg5.e.a.a;
        final t3 r3 = D(mC());
        final gj5.c r4 = k(r3);
        if (this.q == false) goto L18;
        if (i() == false) goto L18;
        this.b1.e(2131889789, new q0(this));
    L18:
        if (this.q == false) goto L23;
        if (c0() == false) goto L23;
        this.b1.e(2131888905, new s0(this));
    L23:
        if (h() == false) goto L26;
        this.b1.e(2131889353, new t0(this));
    L26:
        if (f() == false) goto L39;
        if (AppInfoUtils.e().booleanValue() == true) goto L39;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L39;
        if (this.j == true) goto L34;
    L36:
        int r5 = 2131887683;
    L37:
        this.b1.e(r5, new u0(this, r2, r4, r3));
        goto L39
    L34:
        if (sbb.e.m.b != this.p1) goto L36;
        r5 = 2131889764;
    L39:
        if (e() == false) goto L46;
        com.bytedance.ee.bear.widgets.a r6 = this.b1;
        if (TextUtils.equals(this.x1, "input_comment") == false) goto L43;
        int r7 = 2131888898;
    L44:
        r6.e(r7, new v0(this));
        goto L46
    L43:
        r7 = 2131888900;
    L46:
        if (TextUtils.isEmpty(r9) == true) goto L48;
        tt5.a.h("ImageViewer", "initActionSheet(), result:" + du5.b.g(r9));
        this.b1.e(2131887681, new w0(this, r9));
    L50:
        if (r2.g() == false) goto L52;
        this.A = C(mC());
        boolean r10 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(this.A);
    L54:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.moblie.imageviewer_add_share") == true) goto L56;
        if (r10 == true) goto L61;
    L74:
        if (this.q == true) goto L76;
    L78:
        this.b1.b(new b1(this));
        LKUIDialog r11 = this.b1.l();
        this.R = r11;
        r11.setOnShowListener(new r0(this));
        LKUIDialog r12 = this.R;
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L82:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L76:
        if (g() == false) goto L78;
        this.b1.e(2131889486, new a1(this));
        goto L78
    L61:
        if (f() == false) goto L74;
        if (this.j == true) goto L65;
    L67:
        int r8 = 2131887679;
    L68:
        com.bytedance.ee.bear.widgets.a r13 = this.b1;
        CharSequence r14 = getContext().getText(r8);
        if (r10 == false) goto L71;
        float r16 = 1.0f;
    L72:
        View.OnClickListener r17 = new z0(this, r2, r4, r3);
        cp5.b r18 = new cp5.b();
        r18.a = r14;
        r18.d = false;
        r18.e = null;
        r18.f = r17;
        r18.c = false;
        r18.b = -1;
        r18.g = true;
        r18.h = r16;
        r18.i = true;
        r13.f(r18);
        goto L74
    L71:
        r16 = 0.3f;
        goto L72
    L65:
        if (sbb.e.m.b != this.p1) goto L67;
        r8 = 2131889763;
        goto L68
    L56:
        if (f() == false) goto L74;
        if (r10 == false) goto L74;
        this.b1.e(2131888910, new x0(this));
        goto L74
    L52:
        r10 = r4.a;
        goto L54
    L48:
        tt5.a.h("ImageViewer", "initActionSheet(), result is null");
    L84:
        tt5.a.b("ImageViewer", "ActionSheet has shown...");
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void qK(uw4.f r1) {
        this.K = r1;
    }

    public final Pair<String, Integer> v(ImageData.Image r4) {
        if (this.Z == true) goto L6;
        tt5.a.h("ImageViewer", "fg disable use old logic");
        return new Pair(this.k1, Integer.valueOf(this.p1));
    L6:
        if (r4 != null) goto L8;
    L21:
        ImageData r5 = this.B;
        if (r5 != null) goto L24;
    L49:
        tt5.a.d("ImageViewer", "getCurrentDocObjToken()... mCurrentImageData or mCurrentImageData.getImageList() is empty, use default");
        return new Pair(this.k1, Integer.valueOf(this.p1));
    L24:
        if (CollectionUtils.isEmpty(r5.getImageList()) == true) goto L49;
        if (this.G < this.B.getImageList().size()) goto L30;
        this.G = this.B.getImageList().size() - 1;
    L30:
        if (this.G < 0) goto L47;
        ImageData.Image r6 = (ImageData.Image) ListProtector.get(this.B.getImageList(), this.G);
        if (r6 == null) goto L47;
        if (r6.getSourceInfo() == null) goto L42;
        if (TextUtils.isEmpty(r6.getSourceInfo().getToken()) == true) goto L42;
        if (r6.getSourceInfo().getType() <= 0) goto L42;
        tt5.a.h("ImageViewer", "getCurrentDocObjToken use curImage, sourceInfo , mCurrentPosition=" + this.G);
        return new Pair(r6.getSourceInfo().getToken(), Integer.valueOf(r6.getSourceInfo().getType()));
    L42:
        if (TextUtils.isEmpty(r6.getSrcObjToken()) == true) goto L47;
        if (r6.getSrcObjType() <= 0) goto L47;
        tt5.a.h("ImageViewer", "getCurrentDocObjToken use curImage, mCurrentPosition=" + this.G);
        return new Pair(r6.getSrcObjToken(), Integer.valueOf(r6.getSrcObjType()));
    L47:
        tt5.a.h("ImageViewer", "getCurrentDocObjToken use default mCurrentPosition=" + this.G);
        return new Pair(this.k1, Integer.valueOf(this.p1));
    L8:
        if (r4.getSourceInfo() == null) goto L16;
        if (TextUtils.isEmpty(r4.getSourceInfo().getToken()) == true) goto L16;
        if (r4.getSourceInfo().getType() <= 0) goto L16;
        tt5.a.h("ImageViewer", "getCurrentDocPair use image data ,sourceInfo");
        return new Pair(r4.getSourceInfo().getToken(), Integer.valueOf(r4.getSourceInfo().getType()));
    L16:
        if (TextUtils.isEmpty(r4.getSrcObjToken()) == true) goto L21;
        if (r4.getSrcObjType() <= 0) goto L21;
        tt5.a.h("ImageViewer", "getCurrentDocPair use image data");
        return new Pair(r4.getSrcObjToken(), Integer.valueOf(r4.getSrcObjType()));
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void wn(ImageData r4) {
        this.Y.add(Flowable.just("").subscribeOn(fo5.d.a()).map(new com.bytedance.ee.bear.imageviewer.d(r4)).observeOn(fo5.d.d()).subscribe(new c0(this), new n0()));
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void xJ(uw4.c r1) {
        this.J = r1;
    }

    public static String b(c3 r1, int r2) {
        ImageData r0 = r1.B;
        if (r0 != null) goto L5;
    L9:
        return "";
    L5:
        if (r0.getImageList() == null) goto L9;
        ImageData.Image r3 = (ImageData.Image) ListProtector.get(r1.B.getImageList(), r2);
        if (r3 == null) goto L9;
        return B(r3.getOriginalSrc());
    }

    public static void d(c3 r2, View r3) {
        r2.getClass();
        AlphaAnimation r4 = new AlphaAnimation(1.0f, 0.0f);
        r4.setDuration(200);
        r4.setFillAfter(true);
        r4.setAnimationListener(new h3(r3));
        r3.startAnimation(r4);
    }

    public final void H(gj5.c r4, t3 r5) {
        int r6 = a.a[r4.b.ordinal()];
        if (r6 != 1) goto L5;
        Toast.showText(getContext(), 2131887246);
        return;
    L5:
        if (r6 != 2) goto L7;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c(r5.c, FileBizDomain.FileBizDomainCCM, r5.getType(), r5.b);
        return;
    L7:
        if (r6 == 3) goto L9;
        tt5.a.d("ImageViewer", "handleValidateSource : UnKnown type");
        return;
    L9:
        tt5.a.d("ImageViewer", "handleDownItemClick validateResult: UNKNOWN");
        Toast.showText(getContext(), 2131887246);
    }

    public final void R(View r7, ImageData r8) {
        if (TextUtils.equals("vc", this.x1) == true) goto L5;
        r7.setFitsSystemWindows(true);
    L5:
        this.m = (ViewGroup) r7.findViewById(2131374968);
        this.u = (ImageView) r7.findViewById(2131369320);
        this.v = r7.findViewById(2131369321);
        this.w = r7.findViewById(2131373098);
        this.x = r7.findViewById(2131369322);
        ImageView r0 = (ImageView) r7.findViewById(2131369319);
        this.y = r0;
        com.bytedance.ee.util.ui.l.c(r0, 2131106521);
        this.t = (TextView) r7.findViewById(2131369380);
        this.f = r7.findViewById(2131381813);
        this.z = r7.findViewById(2131363228);
        Z();
        SwipeControlViewPager r1 = this.f;
        Resources r2 = this.b.getResources();
        r1.setPageMargin((int) (WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density * 15.0f));
        TextView r3 = (TextView) r7.findViewById(2131369379);
        this.I = r3;
        r3.setCompoundDrawablePadding(0);
        this.I.setText("");
        this.I.setEnabled(false);
        this.u.setEnabled(false);
        this.v.setEnabled(false);
        this.w.setEnabled(false);
        this.y.setEnabled(false);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this.e, new com.bytedance.ee.bear.imageviewer.f(this));
        if (TextUtils.isEmpty(w()) == true) goto L8;
    L17:
        this.x.setVisibility(0);
        this.x.setOnClickListener(new q(this));
    L18:
        uw4.c r4 = this.J;
        if (r4 == null) goto L21;
        r4.onCreated();
    L21:
        tt5.a.b("ImageViewer", "onViewCreated");
        this.h = r7.findViewById(2131379903);
        this.B = r8;
        xu5.b.a r9 = xu5.b.b(this.b, ForsetiHelper.g(this.d));
        this.S = r9;
        r9.saveState();
        this.S.b(-16777216, true);
        bp5.c.b(this.b, this.h1);
        this.Q = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        ImageData r10 = this.B;
        if (r10 != null) goto L24;
    L31:
        M();
    L32:
        this.E.observe(this.e, new f2(this));
        this.F.observe(this.e, new q2(this));
        com.bytedance.ee.bear.bizwidget.magicshare.cursor.b r11 = this.r;
        if (r11 == null) goto L36;
        r11.show();
        return;
    L36:
        return;
    L24:
        if (r10.getImage() == null) goto L31;
        if (this.B.getImageList() == null) goto L31;
        if (this.B.getImageList().isEmpty() == true) goto L31;
        CompositeDisposable r12 = this.Y;
        ImageData r13 = this.B;
        r12.add(Flowable.just("").subscribeOn(fo5.d.a()).map(new com.bytedance.ee.bear.imageviewer.d(r13)).observeOn(fo5.d.d()).subscribe(new y0(this), new j1()));
        goto L32
    L8:
        if (g() == true) goto L17;
        if (f() == true) goto L17;
        if (h() == true) goto L17;
        if (c0() == true) goto L17;
        if (i() == false) goto L18;
        goto L17
    }

    public final void T(ShareItemModel r11, VFSPath r12) {
        if (r12 != null) goto L7;
        tt5.a.k("ImageViewer", "performCustomShare(): imagePath is null");
        return;
    L7:
        if (TextUtils.isEmpty(r12.getRealPath()) == false) goto L9;
        File r1 = null;
    L10:
        ShareItemModel.a r13 = r11.getOnClickedListener();
        Context r3 = getContext();
        String r6 = "";
        if (TextUtils.isEmpty(this.k1) == true) goto L13;
        String r5 = s45.p.a().A9(sbb.e.f(this.p1), this.k1);
    L26:
        Context r7 = getContext();
        int r8 = this.G;
        if (r8 >= 0) goto L29;
    L32:
        ImageData.Image r9 = null;
    L33:
        if (r9 != null) goto L35;
    L38:
        boolean r14 = r13.a(r3, r11, new com.bytedance.ee.bear.share.g(r5, ShareItemUtil.b(r7, r6, this.p1), null, r1));
        tt5.a.h("ImageViewer", "performCustomShare, shareType: " + r11.getType() + ", isConsumed: " + r14);
        if (r14 == true) goto L44;
        ShareType r16 = r11.getType();
        if (r16 == null) goto L45;
        this.L0.b(r16);
        return;
    L45:
        return;
    L44:
        return;
    L35:
        if (TextUtils.isEmpty(r9.getTitle()) == true) goto L38;
        r6 = r9.getTitle();
        goto L38
    L29:
        if (r8 >= ((ArrayList) this.C).size()) goto L32;
        r9 = (ImageData.Image) ListProtector.get(this.C, this.G);
        goto L33
    L13:
        int r10 = this.G;
        if (r10 >= 0) goto L16;
    L19:
        ImageData.Image r17 = null;
    L20:
        if (r17 != null) goto L22;
    L25:
        r5 = "";
        goto L26
    L22:
        if (TextUtils.isEmpty(r17.getRealSrc()) == true) goto L25;
        r5 = r17.getRealSrc();
        goto L26
    L16:
        if (r10 >= ((ArrayList) this.C).size()) goto L19;
        r17 = (ImageData.Image) ListProtector.get(this.C, this.G);
        goto L20
    L9:
        r1 = new PolarisFileWrapper(r12.getRealPath());
        goto L10
    }

    public final void U(ShareType r9, VFSPath r10) {
        if (r10 != null) goto L5;
        tt5.a.k("ImageViewer", "performExternalShare(): imagePath is null");
        return;
    L5:
        ExternalShareMinaConfig r0 = (ExternalShareMinaConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        com.bytedance.ee.bear.share.e r2 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9();
        c r7 = new c(r9);
        if (r9 != ShareType.More) goto L9;
        r2.b(getContext(), r10, r7);
        return;
    L9:
        if (r0.isShareChannelBanned(r9) == false) goto L11;
        r2.d(getContext(), r9, r10, null, r7);
        return;
    L11:
        r2.a(getContext(), r9, r10, r7);
    }

    public final VFSPath z(String r5, ImageData.Image r6) {
        if (this.k0 != null) goto L5;
        this.k0 = new s3();
    L5:
        s3 r0 = this.k0;
        RequestManager r1 = this.H;
        String r2 = this.k1;
        int r3 = this.p1;
        r0.getClass();
        return s3.a(r1, r5, r2, r3, r6);
    }

    public final void L(final VFSPath r11, final LargeImageView r12, final ImageData.Image r13, final FrameLayout r14) {
        if (r11 == null) goto L22;
        if (r12 == null) goto L22;
        if (r14 == null) goto L22;
        r14.setTag(2131388100, r11);
        final tw4.b r1 = this.P;
        if (r1 == null) goto L14;
        SubsamplingScaleImageView r2 = r12.getScaleImageView();
        if (r2 == null) goto L14;
        r2.setOnScaleEventListener(new u2(r1));
    L14:
        tt5.a.h("ImageViewer", "loadLocalImageFile(): image = " + r13);
        float[] r0 = r13.getCrop();
        final com.bytedance.ee.bear.contract.imageviewer.bean.a r3 = r13.getLocalTransformerInfo();
        if (r3 == null) goto L19;
        float[] r4 = r3.e;
        if (r4 == null) goto L19;
        final float[] r5 = r4;
    L20:
        Flowable.just(r5).map(new o1(this, r13, r11, r5)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new p1(this, r3, r13, r5, r11, r12, r14), new q1(this, r12));
        return;
    L19:
        r5 = r0;
    L22:
        tt5.a.d("ImageViewer", "loadLocalImageFile(): file is null ,view = " + r12 + ", frameLayout = " + r14);
    }

    public final void O(FragmentActivity r3, Fragment r4, LifecycleOwner r5, Bundle r6) {
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("docs_image_view");
        this.b = r3;
        this.e = r5;
        this.d = r4;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a.getClass();
        sa5.b r7 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r3, r4);
        this.g1 = r7;
        if (r7 == null) goto L5;
        r7.e(this);
    L6:
        if (r6 == null) goto L9;
        this.k1 = r6.getString("extra_token", "");
        this.p1 = r6.getInt("extra_type", 0);
        this.v1 = r6.getString("extra_enter_anim_uuid", "");
        this.x1 = r6.getString("extra_from", "");
        r6.remove("extra_enter_anim_uuid");
        this.y1 = (ImageData.Position) r6.getParcelable("extra_enter_anim_pos");
    L9:
        if (TextUtils.equals("vc", this.x1) == false) goto L12;
        this.r = com.bytedance.ee.bear.bizwidget.magicshare.cursor.d.a(this.b, new e3(this), com.bytedance.ee.util.ui.n.d(5));
        return;
    L12:
        return;
    L5:
        tt5.a.k("ImageViewer", "onCreate: backPressDispatcher is null");
        goto L6
    }

    public final void K(final LargeImageView r9, String r10, String r11, final ImageData.Image r12, FrameLayout r13) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        String r3 = r11;
    L7:
        if (com.bytedance.ee.util.io.e.c(r3) == false) goto L32;
        if (((v45.a) org.koin.java.a.a(v45.a.class)).g(r3) == true) goto L11;
        E(r9, r3, r11, true, r12, r13);
        return;
    L11:
        if (this.k == false) goto L29;
        ImageData r14 = this.B;
        if (r14 != null) goto L15;
        ImageData.Image r16 = null;
    L16:
        if (r16 == null) goto L29;
        if (TextUtils.isEmpty(r16.getUuid()) == true) goto L29;
        if (TextUtils.equals(r16.getUuid(), r12.getUuid()) == false) goto L29;
        final String r17 = UriProtector.parse(r3).getLastPathSegment();     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r17) == true) goto L29;
        m(r9);
        final io.reactivex.disposables.a r0 = new io.reactivex.disposables.a();
        ((HashMap) this.X).put(r9, r0);
        this.Y.add(r0);
        final String r1 = r12.getThumbnailSrc();
        r0.b(Maybe.fromCallable(new r1(this, r17, r1)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new s1(this, r9, r0, r12), new t1(this, r9, r0), new v1(this, r9, r0)));
    L27:
        e = move-exception;
        tt5.a.l("ImageViewer", "parse file token for opening thumbnail failed", e);
        goto L29
    L15:
        r16 = r14.getImage();
    L29:
        q(r9, r3, r11, DownloadRequestInfo.DownloadType.IMG, r12, r13);
        return;
    L32:
        if (TextUtils.isEmpty(r3) == true) goto L34;
        L(ay4.d.a().z(r3), r9, r12, r13);
        return;
    L34:
        tt5.a.d("ImageViewer", "loadImageDetail, but url empty! " + r11 + ", " + r10);
        return;
    L5:
        r3 = r10;
        goto L7
    }

    public static void c(c3 r6, String r7, String r8, LargeImageView r9, ImageData.Image r10, FrameLayout r11) {
        r6.getClass();
        if (TextUtils.equals(r7, r8) == true) goto L8;
        if (TextUtils.isEmpty(r8) == true) goto L8;
        r6.K(r9, r8, r8, r10, r11);
        return;
    L8:
        if (r6.k == false) goto L10;
        r6.m(r9);
    L10:
        r6.u.setEnabled(false);
        r9.v();
        uw4.b r12 = r6.L;
        if (r12 == null) goto L15;
        r12.a(r6.mC(), r6.G);
        return;
    }

    public final void E(LargeImageView r12, String r13, String r14, boolean r16, ImageData.Image r17, FrameLayout r18) {
        this.H.downloadOnly().load(new BearGlideUrl(Uri.decode(r13))).diskCacheStrategy(DiskCacheStrategy.DATA).into(new d(this, r16, r13, r14, r12, r17, r18));
    }

    public final void q(final LargeImageView r14, final String r16, final String r17, final DownloadRequestInfo.DownloadType r18, final ImageData.Image r19, final FrameLayout r110) {
        ConnectionService.NetworkState r10 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        final MutableLiveData r11 = new MutableLiveData();
        com.bytedance.ee.util.ui.m.a(new d2(this, r11, r18, r14, r16, r17, r19, r110));
        if (this.k0 != null) goto L5;
        this.k0 = new s3();
    L5:
        this.k0.getClass();
        if (TextUtils.isEmpty(r16) == false) goto L8;
        String r0 = null;
    L9:
        Pair<String, Integer> r1 = v(r19);
        w85.c r2 = (w85.c) org.koin.java.a.a(w85.c.class);
        w85.a.C0319a r3 = new w85.a.C0319a();
        boolean r4 = true;
        r3.a = true;
        r3.d = r16;
        r3.m = r0;
        r3.b = r18;
        if (r10.a() == true) goto L13;
        r4 = false;
    L13:
        r3.c = r4;
        r3.h = (String) r1.first;
        r3.i = ((Integer) r1.second).intValue();
        r3.j = new h(r11);
        r3.g = ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).c(((Integer) r1.second).intValue());
        r2.d(new w85.a(r3));
        return;
    L8:
        r0 = UriProtector.getQueryParameter(UriProtector.parse(r16), "extra");
        goto L9
    }
}
