package com.bytedance.ee.bear.middleground.comment.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.ui.j;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import if5.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 62\u00020\u0001:\u0003678B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u000fJ$\u0010$\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\u000fH\u0002J4\u0010&\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001c\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010-\u001a\u00020 J\u0006\u0010.\u001a\u00020 J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\u000e\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aJ\u000e\u00103\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u00104\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u000e\u00105\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageView;", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "isLoading", "", "lastUrl", "lastDefaultUrl", "loadingDriveKey", "delayedTask", "Ljava/lang/Runnable;", "getDelayedTask", "()Ljava/lang/Runnable;", "setDelayedTask", "(Ljava/lang/Runnable;)V", "onImageLoadFailListener", "Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageView$OnImageLoadFailListener;", "downloadImageAnalytic", "Lcom/bytedance/ee/bear/imageviewer/DownloadImageAnalytic;", "docToken", "docType", "loadImage", "", "url", "defaultUrl", "canPreview", "driveDownloadForLoad", PlayerResolution.SDKKEY.ORIGIN, "glideDownloadForLoad", EventConstant.Value.RETRY, "retryDefault", "useDefault", "loadLocalImageFile", "resource", "Ljava/io/File;", "cancelLoading", "showLoadingFail", "onImageLoadSuccess", "onImageLoadFailed", "setOnImageLoadFailListener", "listener", "setDownloadImageAnalytic", "setDocToken", "setDocType", "Companion", "DownloadDriveCallback", "OnImageLoadFailListener", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentImageView extends LKUIRoundedImageView2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f231612l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f231613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDLoadingDrawable f231614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f231615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f231616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f231617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f231618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f231619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f231620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.imageviewer.b f231621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f231622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f231623k;

    public static final class a {
    }

    public final class b implements w85.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f231624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f231625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f231626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f231627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CommentImageView f231628e;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231629a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f231630b;

            public a(CommentImageView r100, b r101) {
                this.f231629a = r100;
                this.f231630b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L15;
                throw th;
            L15:
                return;
            L3:
                if (com.bytedance.ee.util.ui.b.b(this.f231629a.getContext()) == true) goto L5;
                tt5.a.d(this.f231629a.f231613a, "onDownloadFail()... retry, Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                CommentImageView r100 = this.f231629a;     // Catch: Throwable -> L7
                b r101 = this.f231630b;     // Catch: Throwable -> L7
                r100.l(r101.f231624a, r101.f231625b, true);     // Catch: Throwable -> L7
                goto L12
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.image.CommentImageView$b$b, reason: collision with other inner class name */
        public static final class RunnableC3313b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231631a;

            public RunnableC3313b(CommentImageView r100) {
                this.f231631a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L15;
                throw th;
            L15:
                return;
            L3:
                if (com.bytedance.ee.util.ui.b.b(this.f231631a.getContext()) == true) goto L5;
                tt5.a.d(this.f231631a.f231613a, "onDownloadFail()... not retry, Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                this.f231631a.setImageResource(R.drawable.comment_load_image_fail);     // Catch: Throwable -> L7
                this.f231631a.o();     // Catch: Throwable -> L7
                goto L12
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231632a;

            public c(CommentImageView r100) {
                this.f231632a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L15;
                throw th;
            L15:
                return;
            L3:
                if (com.bytedance.ee.util.ui.b.b(this.f231632a.getContext()) == true) goto L5;
                tt5.a.d(this.f231632a.f231613a, "onDownloadStart()... Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                CommentImageView r100 = this.f231632a;     // Catch: Throwable -> L7
                r100.setImageDrawable(r100.f231614b);     // Catch: Throwable -> L7
                goto L12
            }
        }

        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231633a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ w85.b f231634b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f231635c;

            public d(CommentImageView r100, w85.b r101, b r102) {
                this.f231633a = r100;
                this.f231634b = r101;
                this.f231635c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L15;
                throw th;
            L15:
                return;
            L3:
                if (com.bytedance.ee.util.ui.b.b(this.f231633a.getContext()) == true) goto L5;
                tt5.a.d(this.f231633a.f231613a, "onDownloadSuccess()... Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                this.f231633a.n(this.f231634b.f558653b, this.f231635c.f231625b);     // Catch: Throwable -> L7
                goto L12
            }
        }

        @Override // w85.a.b
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadUrl");
            this.f231627d = System.currentTimeMillis();
            j.c(new c(this.f231628e));
        }

        @Override // w85.a.b
        public final void c(String r110, w85.b r111) {
            Intrinsics.checkNotNullParameter(r110, "downloadUrl");
            Intrinsics.checkNotNullParameter(r111, "result");
            if (this.f231627d == 0) goto L7;
            long r112 = System.currentTimeMillis() - this.f231627d;
            com.bytedance.ee.bear.imageviewer.b r100 = this.f231628e.f231621i;
            if (r100 == null) goto L7;
            r100.a(200, "success", "commentCardDrive", r111.f558653b.length(), r112);
        L7:
            j.c(new d(this.f231628e, r111, this));
        }

        @Override // w85.a.b
        public final void a(String r110, String r111, int r112) {
            Intrinsics.checkNotNullParameter(r110, "downloadUrl");
            Intrinsics.checkNotNullParameter(r111, "key");
            tt5.a.d(this.f231628e.f231613a, "onDownloadFail()... key = " + r111 + ", errorCode = " + r112 + ", downloadUrl = " + du5.b.f(r110) + ", origin = " + this.f231626c);
            if (this.f231627d == 0) goto L8;
            long r100 = System.currentTimeMillis() - this.f231627d;
            com.bytedance.ee.bear.imageviewer.b r101 = this.f231628e.f231621i;
            if (r101 == null) goto L8;
            r101.a(-1, "errorCode = " + r112, "commentCardDrive", -1, r100);
        L8:
            if (this.f231626c == true) goto L11;
            if (r112 == 1000) goto L11;
            j.c(new a(this.f231628e, this));
            return;
        L11:
            if (r112 == 1000) goto L15;
            j.c(new RunnableC3313b(this.f231628e));
            return;
        }

        public b(CommentImageView r100, String r101, String r102, boolean r103) {
            this.f231628e = r100;
            this.f231624a = r101;
            this.f231625b = r102;
            this.f231626c = r103;
        }
    }

    public interface c {
    }

    public static final class d implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentImageView f231636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f231637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f231638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f231639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f231640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f231641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f231642g;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f231643a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231644b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f231645c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f231646d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f231647e;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.image.CommentImageView$d$a$a, reason: collision with other inner class name */
            public static final class RunnableC3314a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CommentImageView f231648a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f231649b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f231650c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ boolean f231651d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ boolean f231652e;

                public RunnableC3314a(CommentImageView r100, String r101, String r102, boolean r103, boolean r104) {
                    this.f231648a = r100;
                    this.f231649b = r101;
                    this.f231650c = r102;
                    this.f231651d = r103;
                    this.f231652e = r104;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CommentImageView r100 = this.f231648a;     // Catch: Throwable -> L4
                    String r101 = this.f231649b;     // Catch: Throwable -> L4
                    String r102 = this.f231650c;     // Catch: Throwable -> L4
                    boolean r103 = this.f231651d;     // Catch: Throwable -> L4
                    boolean r104 = this.f231652e;     // Catch: Throwable -> L4
                    int r105 = CommentImageView.f231612l;     // Catch: Throwable -> L4
                    r100.m(r101, r102, false, r103, r104);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(String r100, CommentImageView r101, String r102, boolean r103, boolean r104) {
                this.f231643a = r100;
                this.f231644b = r101;
                this.f231645c = r102;
                this.f231646d = r103;
                this.f231647e = r104;
            }

            public final void a() {
                if (TextUtils.equals(this.f231643a, this.f231644b.f231616d) == false) goto L5;
                tt5.a.b(this.f231644b.f231613a, "onLoadFailed，retry...");
                j.c(new RunnableC3314a(this.f231644b, this.f231643a, this.f231645c, this.f231646d, this.f231647e));
            L6:
                this.f231644b.setDelayedTask(null);
                return;
            L5:
                tt5.a.b(this.f231644b.f231613a, "path changed, no retry...");
                goto L6
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

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentImageView f231653a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f231654b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f231655c;

            public b(CommentImageView r100, String r101, String r102) {
                this.f231653a = r100;
                this.f231654b = r101;
                this.f231655c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CommentImageView r100 = this.f231653a;     // Catch: Throwable -> L4
                String r101 = this.f231654b;     // Catch: Throwable -> L4
                String r102 = this.f231655c;     // Catch: Throwable -> L4
                int r103 = CommentImageView.f231612l;     // Catch: Throwable -> L4
                r100.m(r101, r102, false, false, true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r110) {
            Intrinsics.checkNotNullParameter(r101, "o");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            tt5.a.d(this.f231636a.f231613a, "onLoadFailed()... downloadUrl = " + du5.b.f(this.f231637b) + ", retry = " + this.f231638c + ", retryDefault = " + this.f231639d + ", useDefault = " + this.f231640e);
            if (TextUtils.equals(this.f231641f, this.f231636a.f231616d) == true) goto L5;
        L17:
            tt5.a.d(this.f231636a.f231613a, "url changed, won't retry!");
            return false;
        L5:
            if (TextUtils.equals(this.f231642g, this.f231636a.f231617e) == false) goto L17;
            if (this.f231638c == false) goto L11;
            CommentImageView r103 = this.f231636a;
            r103.setDelayedTask(new a(this.f231641f, r103, this.f231642g, this.f231639d, this.f231640e));
            j.d(this.f231636a.getDelayedTask(), 2000);
            return true;
        L11:
            if (this.f231639d == false) goto L15;
            tt5.a.b(this.f231636a.f231613a, "onLoadFailed retry originalUrl...");
            j.c(new b(this.f231636a, this.f231641f, this.f231642g));
            return true;
        L15:
            tt5.a.d(this.f231636a.f231613a, "onLoadFailed. Has tried three times...");
            this.f231636a.o();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r101, "o");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "dataSource");
            tt5.a.h(this.f231636a.f231613a, "onResourceReady dataSource=" + r103);
            this.f231636a.f231615c = false;
            return false;
        }

        public d(CommentImageView r100, String r101, boolean r102, boolean r103, boolean r104, String r105, String r106) {
            this.f231636a = r100;
            this.f231637b = r101;
            this.f231638c = r102;
            this.f231639d = r103;
            this.f231640e = r104;
            this.f231641f = r105;
            this.f231642g = r106;
        }
    }

    public static final class e implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentImageView f231656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f231657b;

        public e(CommentImageView r100, String r101) {
            this.f231656a = r100;
            this.f231657b = r101;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "o");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            tt5.a.d(this.f231656a.f231613a, "loadLocalImageFile()... onLoadFailed, defaultUrl = " + du5.b.f(this.f231657b));
            this.f231656a.o();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r101, "o");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "dataSource");
            tt5.a.h(this.f231656a.f231613a, "loadLocalImageFile()... onResourceReady dataSource=" + r103);
            this.f231656a.f231615c = false;
            return false;
        }
    }

    static {
    }

    public CommentImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void o() {
        this.f231615c = false;
        c r100 = this.f231620h;
        if (r100 == null) goto L10;
        f r101 = (f) r100;
        CommentImageAdapter.e r102 = r101.f489583a;
        View r103 = r101.f489584b;
        r102.getClass();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r104 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r103.getTag();
        tt5.a.h("Comment#CommentImageAdapter", "onImageLoadFail... holder = Holder@" + r102.hashCode() + ", imageView = ImageView@" + r102.f231602a.hashCode() + ", imageEntity = " + r104);
        if (r104 == null) goto L11;
        r104.setLoadFail(true);
        CommentImageAdapter.c r105 = r102.f231607f.f231598m;
        if (r105 == null) goto L12;
        r105.a(r104);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j() {
        if (this.f231615c == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f231618f) == true) goto L7;
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).b(this.f231618f);
    L7:
        Glide.with(getContext()).clear(this);
        Runnable r100 = this.f231619g;
        if (r100 == null) goto L10;
        j.e(r100);
        this.f231619g = null;
    L10:
        this.f231615c = false;
    }

    public final Runnable getDelayedTask() {
        return this.f231619g;
    }

    public final void setDelayedTask(Runnable r100) {
        this.f231619g = r100;
    }

    public final void setDocToken(String r100) {
        this.f231622j = r100;
    }

    public final void setDocType(int r100) {
        this.f231623k = r100;
    }

    public final void setDownloadImageAnalytic(com.bytedance.ee.bear.imageviewer.b r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadImageAnalytic");
        this.f231621i = r100;
    }

    public final void setOnImageLoadFailListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f231620h = r100;
    }

    public final void n(File r100, String r101) {
        if (r100 != null) goto L5;
    L8:
        tt5.a.d(this.f231613a, "loadLocalImageFile(): file is null ,view = " + this);
        if (TextUtils.isEmpty(r101) == true) goto L11;
        m(r101, r101, false, false, false);
        return;
    L11:
        setImageResource(R.drawable.comment_load_image_fail);
        o();
        return;
    L5:
        if (r100.exists() == false) goto L8;
        Intrinsics.checkNotNull(Glide.with(getContext()).load(r100).error(R.drawable.comment_load_image_fail).addListener(new e(this, r101)).into(this));
    }

    public CommentImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f231613a = "Comment#CommentImageView@" + hashCode();
        this.f231622j = "";
        this.f231623k = 2;
        UDLoadingDrawable r103 = new UDLoadingDrawable(getContext());
        this.f231614b = r103;
        r103.setColorSchemeColors(new int[]{y9c.d.c(getContext(), R.color.ud_N400)});
        r103.start();
    }

    public final void l(String r100, String r101, boolean r110) {
        if (r110 == false) goto L4;
        String r102 = r101;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        o();
        return;
    L9:
        ConnectionService.NetworkState r103 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState();
        w85.c r104 = (w85.c) org.koin.java.a.c(w85.c.class, null, null, 6);
        w85.a.C8081a r105 = new w85.a.C8081a();
        boolean r106 = true;
        r105.f558639a = true;
        r105.f558642d = r102;
        if (r110 == false) goto L12;
        DownloadRequestInfo.DownloadType r107 = DownloadRequestInfo.DownloadType.IMG;
    L13:
        r105.f558640b = r107;
        if (r103.a() == true) goto L17;
        r106 = false;
    L17:
        r105.f558641c = r106;
        r105.f558646h = this.f231622j;
        r105.f558647i = this.f231623k;
        r105.f558648j = new b(this, r100, r101, r110);
        r105.f558645g = ((com.bytedance.ee.bear.f) org.koin.java.a.c(com.bytedance.ee.bear.f.class, null, null, 6)).c(this.f231623k);
        this.f231618f = r104.d(new w85.a(r105)).f558657f;
        return;
    L12:
        r107 = DownloadRequestInfo.DownloadType.COVER;
        goto L13
    L4:
        r102 = r100;
        goto L6
    }

    public /* synthetic */ CommentImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void m(String r110, String r111, boolean r112, boolean r113, boolean r114) {
        if (com.bytedance.ee.util.ui.b.b(getContext()) == true) goto L6;
        tt5.a.d(this.f231613a, "glideDownloadForLoad()... Activity is not active.");
        return;
    L6:
        if (r114 == false) goto L8;
        String r100 = r111;
    L10:
        if (TextUtils.isEmpty(r100) == false) goto L13;
        tt5.a.k(this.f231613a, "glideDownloadForLoad()... downloadUrl is empty! useDefault = " + r114);
        o();
        return;
    L13:
        Glide.with(getContext()).load(new CommentImageGlideUrl(r100)).placeholder(this.f231614b).error(R.drawable.comment_load_image_fail).addListener(new d(this, r100, r112, r113, r114, r110, r111)).into(this);
        return;
    L8:
        r100 = r110;
        goto L10
    }
}
