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
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.util.ui.j;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import if5.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 62\u00020\u0001:\u0003678B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u000fJ$\u0010$\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\u000fH\u0002J4\u0010&\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001c\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010-\u001a\u00020 J\u0006\u0010.\u001a\u00020 J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\u000e\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aJ\u000e\u00103\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u00104\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u000e\u00105\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageView;", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "isLoading", "", "lastUrl", "lastDefaultUrl", "loadingDriveKey", "delayedTask", "Ljava/lang/Runnable;", "getDelayedTask", "()Ljava/lang/Runnable;", "setDelayedTask", "(Ljava/lang/Runnable;)V", "onImageLoadFailListener", "Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageView$OnImageLoadFailListener;", "downloadImageAnalytic", "Lcom/bytedance/ee/bear/imageviewer/DownloadImageAnalytic;", "docToken", "docType", "loadImage", "", ResourceData.KEY_URL, "defaultUrl", "canPreview", "driveDownloadForLoad", "origin", "glideDownloadForLoad", "retry", "retryDefault", "useDefault", "loadLocalImageFile", "resource", "Ljava/io/File;", "cancelLoading", "showLoadingFail", "onImageLoadSuccess", "onImageLoadFailed", "setOnImageLoadFailListener", "listener", "setDownloadImageAnalytic", "setDocToken", "setDocType", "Companion", "DownloadDriveCallback", "OnImageLoadFailListener", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentImageView extends LKUIRoundedImageView2 {
    public static final /* synthetic */ int l = 0;
    public final String a;
    public final UDLoadingDrawable b;
    public volatile boolean c;
    public String d;
    public String e;
    public String f;
    public Runnable g;
    public c h;
    public com.bytedance.ee.bear.imageviewer.b i;
    public String j;
    public int k;

    public static final class a {
    }

    public final class b implements w85.a.b {
        public final String a;
        public final String b;
        public final boolean c;
        public long d;
        public final /* synthetic */ CommentImageView e;

        public static final class a implements Runnable {
            public final /* synthetic */ CommentImageView a;
            public final /* synthetic */ b b;

            public a(CommentImageView r1, b r2) {
                this.a = r1;
                this.b = r2;
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
                if (com.bytedance.ee.util.ui.b.b(this.a.getContext()) == true) goto L5;
                tt5.a.d(this.a.a, "onDownloadFail()... retry, Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                CommentImageView r0 = this.a;     // Catch: Throwable -> L7
                b r1 = this.b;     // Catch: Throwable -> L7
                r0.l(r1.a, r1.b, true);     // Catch: Throwable -> L7
                goto L12
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.image.CommentImageView$b$b, reason: collision with other inner class name */
        public static final class RunnableC0066b implements Runnable {
            public final /* synthetic */ CommentImageView a;

            public RunnableC0066b(CommentImageView r1) {
                this.a = r1;
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
                if (com.bytedance.ee.util.ui.b.b(this.a.getContext()) == true) goto L5;
                tt5.a.d(this.a.a, "onDownloadFail()... not retry, Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                this.a.setImageResource(2131233320);     // Catch: Throwable -> L7
                this.a.o();     // Catch: Throwable -> L7
                goto L12
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ CommentImageView a;

            public c(CommentImageView r1) {
                this.a = r1;
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
                if (com.bytedance.ee.util.ui.b.b(this.a.getContext()) == true) goto L5;
                tt5.a.d(this.a.a, "onDownloadStart()... Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                CommentImageView r0 = this.a;     // Catch: Throwable -> L7
                r0.setImageDrawable(r0.b);     // Catch: Throwable -> L7
                goto L12
            }
        }

        public static final class d implements Runnable {
            public final /* synthetic */ CommentImageView a;
            public final /* synthetic */ w85.b b;
            public final /* synthetic */ b c;

            public d(CommentImageView r1, w85.b r2, b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
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
                if (com.bytedance.ee.util.ui.b.b(this.a.getContext()) == true) goto L5;
                tt5.a.d(this.a.a, "onDownloadSuccess()... Activity is not active.");     // Catch: Throwable -> L7
            L12:
                return;
            L5:
                this.a.n(this.b.b, this.c.b);     // Catch: Throwable -> L7
                goto L12
            }
        }

        public final void e(String r3) {
            Intrinsics.checkNotNullParameter(r3, "downloadUrl");
            this.d = System.currentTimeMillis();
            j.c(new c(this.e));
        }

        public final void c(String r13, w85.b r14) {
            Intrinsics.checkNotNullParameter(r13, "downloadUrl");
            Intrinsics.checkNotNullParameter(r14, "result");
            if (this.d == 0) goto L7;
            long r10 = System.currentTimeMillis() - this.d;
            com.bytedance.ee.bear.imageviewer.b r4 = this.e.i;
            if (r4 == null) goto L7;
            r4.a(200, "success", "commentCardDrive", r14.b.length(), r10);
        L7:
            j.c(new d(this.e, r14, this));
        }

        public final void a(String r11, String r12, int r13) {
            Intrinsics.checkNotNullParameter(r11, "downloadUrl");
            Intrinsics.checkNotNullParameter(r12, "key");
            tt5.a.d(this.e.a, "onDownloadFail()... key = " + r12 + ", errorCode = " + r13 + ", downloadUrl = " + du5.b.f(r11) + ", origin = " + this.c);
            if (this.d == 0) goto L8;
            long r8 = System.currentTimeMillis() - this.d;
            com.bytedance.ee.bear.imageviewer.b r2 = this.e.i;
            if (r2 == null) goto L8;
            r2.a(-1, "errorCode = " + r13, "commentCardDrive", -1, r8);
        L8:
            if (this.c == true) goto L11;
            if (r13 == 1000) goto L11;
            j.c(new a(this.e, this));
            return;
        L11:
            if (r13 == 1000) goto L15;
            j.c(new RunnableC0066b(this.e));
            return;
        }

        public b(CommentImageView r1, String r2, String r3, boolean r4) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface c {
    }

    public static final class d implements RequestListener<Drawable> {
        public final /* synthetic */ CommentImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public static final class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ CommentImageView b;
            public final /* synthetic */ String c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ boolean e;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.image.CommentImageView$d$a$a, reason: collision with other inner class name */
            public static final class RunnableC0067a implements Runnable {
                public final /* synthetic */ CommentImageView a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ boolean d;
                public final /* synthetic */ boolean e;

                public RunnableC0067a(CommentImageView r1, String r2, String r3, boolean r4, boolean r5) {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                    this.e = r5;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CommentImageView r0 = this.a;     // Catch: Throwable -> L4
                    String r1 = this.b;     // Catch: Throwable -> L4
                    String r2 = this.c;     // Catch: Throwable -> L4
                    boolean r4 = this.d;     // Catch: Throwable -> L4
                    boolean r5 = this.e;     // Catch: Throwable -> L4
                    int r6 = CommentImageView.l;     // Catch: Throwable -> L4
                    r0.m(r1, r2, false, r4, r5);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(String r1, CommentImageView r2, String r3, boolean r4, boolean r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void a() {
                if (TextUtils.equals(this.a, this.b.d) == false) goto L5;
                tt5.a.b(this.b.a, "onLoadFailed，retry...");
                j.c(new RunnableC0067a(this.b, this.a, this.c, this.d, this.e));
            L6:
                this.b.setDelayedTask(null);
                return;
            L5:
                tt5.a.b(this.b.a, "path changed, no retry...");
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
            public final /* synthetic */ CommentImageView a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public b(CommentImageView r1, String r2, String r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CommentImageView r0 = this.a;     // Catch: Throwable -> L4
                String r1 = this.b;     // Catch: Throwable -> L4
                String r2 = this.c;     // Catch: Throwable -> L4
                int r6 = CommentImageView.l;     // Catch: Throwable -> L4
                r0.m(r1, r2, false, false, true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final boolean onLoadFailed(GlideException r7, Object r8, Target<Drawable> r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r8, "o");
            Intrinsics.checkNotNullParameter(r9, "target");
            tt5.a.d(this.a.a, "onLoadFailed()... downloadUrl = " + du5.b.f(this.b) + ", retry = " + this.c + ", retryDefault = " + this.d + ", useDefault = " + this.e);
            if (TextUtils.equals(this.f, this.a.d) == true) goto L5;
        L17:
            tt5.a.d(this.a.a, "url changed, won't retry!");
            return false;
        L5:
            if (TextUtils.equals(this.g, this.a.e) == false) goto L17;
            if (this.c == false) goto L11;
            CommentImageView r11 = this.a;
            r11.setDelayedTask(new a(this.f, r11, this.g, this.d, this.e));
            j.d(this.a.getDelayedTask(), BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
            return true;
        L11:
            if (this.d == false) goto L15;
            tt5.a.b(this.a.a, "onLoadFailed retry originalUrl...");
            j.c(new b(this.a, this.f, this.g));
            return true;
        L15:
            tt5.a.d(this.a.a, "onLoadFailed. Has tried three times...");
            this.a.o();
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Drawable r6 = (Drawable) r1;
            Intrinsics.checkNotNullParameter(r2, "o");
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            tt5.a.h(this.a.a, "onResourceReady dataSource=" + r4);
            this.a.c = false;
            return false;
        }

        public d(CommentImageView r1, String r2, boolean r3, boolean r4, boolean r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class e implements RequestListener<Drawable> {
        public final /* synthetic */ CommentImageView a;
        public final /* synthetic */ String b;

        public e(CommentImageView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "o");
            Intrinsics.checkNotNullParameter(r3, "target");
            tt5.a.d(this.a.a, "loadLocalImageFile()... onLoadFailed, defaultUrl = " + du5.b.f(this.b));
            this.a.o();
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Drawable r6 = (Drawable) r1;
            Intrinsics.checkNotNullParameter(r2, "o");
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            tt5.a.h(this.a.a, "loadLocalImageFile()... onResourceReady dataSource=" + r4);
            this.a.c = false;
            return false;
        }
    }

    static {
    }

    public CommentImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void o() {
        this.c = false;
        c r0 = this.h;
        if (r0 == null) goto L10;
        f r1 = (f) r0;
        CommentImageAdapter.e r2 = r1.a;
        View r3 = r1.b;
        r2.getClass();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r4 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r3.getTag();
        tt5.a.h("Comment#CommentImageAdapter", "onImageLoadFail... holder = Holder@" + r2.hashCode() + ", imageView = ImageView@" + r2.a.hashCode() + ", imageEntity = " + r4);
        if (r4 == null) goto L11;
        r4.setLoadFail(true);
        CommentImageAdapter.c r5 = r2.f.m;
        if (r5 == null) goto L12;
        r5.a(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        if (this.c == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f) == true) goto L7;
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).b(this.f);
    L7:
        Glide.with(getContext()).clear(this);
        Runnable r0 = this.g;
        if (r0 == null) goto L10;
        j.e(r0);
        this.g = null;
    L10:
        this.c = false;
    }

    public final Runnable getDelayedTask() {
        return this.g;
    }

    public final void setDelayedTask(Runnable r1) {
        this.g = r1;
    }

    public final void setDocToken(String r1) {
        this.j = r1;
    }

    public final void setDocType(int r1) {
        this.k = r1;
    }

    public final void setDownloadImageAnalytic(com.bytedance.ee.bear.imageviewer.b r2) {
        Intrinsics.checkNotNullParameter(r2, "downloadImageAnalytic");
        this.i = r2;
    }

    public final void setOnImageLoadFailListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(File r8, String r9) {
        if (r8 != null) goto L5;
    L8:
        tt5.a.d(this.a, "loadLocalImageFile(): file is null ,view = " + this);
        if (TextUtils.isEmpty(r9) == true) goto L11;
        m(r9, r9, false, false, false);
        return;
    L11:
        setImageResource(2131233320);
        o();
        return;
    L5:
        if (r8.exists() == false) goto L8;
        Intrinsics.checkNotNull(Glide.with(getContext()).load(r8).error(2131233320).addListener(new e(this, r9)).into(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommentImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "Comment#CommentImageView@" + hashCode();
        this.j = "";
        this.k = 2;
        UDLoadingDrawable r5 = new UDLoadingDrawable(getContext());
        this.b = r5;
        r5.setColorSchemeColors(new int[]{y9c.d.c(getContext(), 2131108721)});
        r5.start();
    }

    public final void l(String r8, String r9, boolean r10) {
        if (r10 == false) goto L4;
        String r0 = r9;
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        o();
        return;
    L9:
        ConnectionService.NetworkState r1 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        w85.c r2 = (w85.c) org.koin.java.a.c(w85.c.class, null, null, 6);
        w85.a.a r5 = new w85.a.a();
        boolean r6 = true;
        r5.a = true;
        r5.d = r0;
        if (r10 == false) goto L12;
        DownloadRequestInfo.DownloadType r3 = DownloadRequestInfo.DownloadType.IMG;
    L13:
        r5.b = r3;
        if (r1.a() == true) goto L17;
        r6 = false;
    L17:
        r5.c = r6;
        r5.h = this.j;
        r5.i = this.k;
        r5.j = new b(this, r8, r9, r10);
        r5.g = ((com.bytedance.ee.bear.f) org.koin.java.a.c(com.bytedance.ee.bear.f.class, null, null, 6)).c(this.k);
        this.f = r2.d(new w85.a(r5)).f;
        return;
    L12:
        r3 = DownloadRequestInfo.DownloadType.COVER;
        goto L13
    L4:
        r0 = r8;
        goto L6
    }

    public /* synthetic */ CommentImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(String r11, String r12, boolean r13, boolean r14, boolean r15) {
        if (com.bytedance.ee.util.ui.b.b(getContext()) == true) goto L6;
        tt5.a.d(this.a, "glideDownloadForLoad()... Activity is not active.");
        return;
    L6:
        if (r15 == false) goto L8;
        String r2 = r12;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        tt5.a.k(this.a, "glideDownloadForLoad()... downloadUrl is empty! useDefault = " + r15);
        o();
        return;
    L13:
        Glide.with(getContext()).load(new CommentImageGlideUrl(r2)).placeholder(this.b).error(2131233320).addListener(new d(this, r2, r13, r14, r15, r11, r12)).into(this);
        return;
    L8:
        r2 = r11;
        goto L10
    }
}
