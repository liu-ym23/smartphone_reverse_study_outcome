package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.document.CsvView;
import com.bytedance.ee.bear.drive.view.preview.document.DocumentView;
import com.bytedance.ee.bear.drive.view.preview.excel.ExcelRenderView;
import com.bytedance.ee.bear.drive.view.preview.htmlrender.HtmlRenderView;
import com.bytedance.ee.bear.drive.view.preview.markdown.MarkdownView;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.puretext.PureTextView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderBaseView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderDocPPTView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.TTReaderExcelView;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentPreviewView extends AbsPreviewView {
    private static final String TAG = "DocumentPreviewView";
    private com.bytedance.ee.bear.drive.cache.t mDriveCacheManager;
    private q75.a mDriveConfig;
    private g85.f mMimeTypeManager;
    private View.OnClickListener mOnSwitchFullScreenClickListener;
    private m mPreviewView;

    public class a implements com.bytedance.ee.bear.drive.view.preview.ttreader.a.c {
        public final /* synthetic */ z a;
        public final /* synthetic */ DocumentPreviewView b;

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void a() {
            PreviewViewModel r0 = this.b.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerForceFullScreen().postValue(Boolean.FALSE);
            return;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void b() {
            PreviewViewModel r0 = this.b.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerForceFullScreen().postValue(Boolean.TRUE);
            return;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void toggle() {
            PreviewViewModel r0 = this.b.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerToggleFullScreen().postValue(this.a.c);
            return;
        }

        public a(DocumentPreviewView r1, z r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements c95.c {
        public final /* synthetic */ DocumentPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public b(DocumentPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r3) {
            tt5.a.h(DocumentPreviewView.TAG, "onShowSuccess, mPreviewView = ".concat(DocumentPreviewView.access$000(this.a).getClass().getSimpleName()));
            this.a.trackOpenSuccess(r3);
        }

        @Override // c95.c
        public final void a(String r3, Throwable r4) {
            tt5.a.d(DocumentPreviewView.TAG, "onShowFailure, mPreviewView = ".concat(DocumentPreviewView.access$000(this.a).getClass().getSimpleName()));
            this.a.trackOpenFailed(r3, r4);
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ Observer b;
        public final /* synthetic */ Observer c;
        public final /* synthetic */ DocumentPreviewView d;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.d.mPermissionViewModel.getLiveOuterCopyable().observeForever(this.a);
            this.d.mPreviewViewModel.liveOuterEncryptId().observeForever(this.b);
            this.d.mPreviewViewModel.getLiveOuterDlpCode().observeForever(this.c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            this.d.mPermissionViewModel.getLiveOuterCopyable().removeObserver(this.a);
            this.d.mPreviewViewModel.liveOuterEncryptId().removeObserver(this.b);
            this.d.mPreviewViewModel.getLiveOuterDlpCode().removeObserver(this.c);
        }

        public c(DocumentPreviewView r1, h r2, i r3, j r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class d extends com.bytedance.ee.bear.drive.view.widget.j {
        public final /* synthetic */ DocumentPreviewView a;

        public d(DocumentPreviewView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final boolean f(String r2) {
            this.a.mPreviewViewModel.liveInnerRoute().postValue(r2);
            return true;
        }
    }

    public static /* synthetic */ void a(DocumentPreviewView r0, String r1) {
        r0.lambda$new$8(r1);
    }

    public static /* synthetic */ void b(DocumentPreviewView r0, EncryptData r1) {
        r0.lambda$new$6(r1);
    }

    public static /* synthetic */ void c(DocumentPreviewView r0, PointValue r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ void d(DocumentPreviewView r0, String r1) {
        r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void e(DocumentPreviewView r0, String r1) {
        r0.lambda$new$4(r1);
    }

    public static /* synthetic */ void f(DocumentPreviewView r0, Integer r1) {
        r0.lambda$new$7(r1);
    }

    public static /* synthetic */ void g(DocumentPreviewView r0, y75.b r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void h(DocumentPreviewView r0, z r1, View r2) {
        r0.lambda$new$0(r1, r2);
    }

    public static /* synthetic */ void i(DocumentPreviewView r0, String r1) {
        r0.lambda$new$2(r1);
    }

    private boolean isHtmlFilePreviewSupported() {
        com.bytedance.ee.drive.preview.f r1 = (com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class);     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        if (r1.B1() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        e = move-exception;
        tt5.a.e(TAG, "isHtmlFilePreviewSupported failed", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r1, ViewOwner r2) {
    }

    private boolean resolveTextClickFullScreenEnabled() {
        com.bytedance.ee.drive.render.k r4 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(this.mContext).b();     // Catch: Throwable -> L12
        if (r4 != null) goto L6;
        com.bytedance.ee.drive.render.k.f r5 = null;
    L7:
        if (r5 != null) goto L9;
    L14:
        boolean r6 = true;
    L15:
        tt5.a.h(TAG, "resolveTextClickFullScreenEnabled, enabled=" + r6);     // Catch: Throwable -> L12
        return r6;
    L9:
        if (r5.a == true) goto L14;
        r6 = false;
        goto L15
    L6:
        r5 = r4.getText();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        tt5.a.e(TAG, "resolveTextClickFullScreenEnabled failed, use default", th, false);
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mPreviewView.getView();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        this.mPreviewView.show();
    }

    public static /* synthetic */ m access$000(DocumentPreviewView r0) {
        return r0.mPreviewView;
    }

    private boolean isNativeHtmlPreviewEnabled(z r6) {
        if (isHtmlFilePreviewSupported() == false) goto L21;
        g85.f r0 = this.mMimeTypeManager;
        if (r0 == null) goto L17;
        if (r6 == null) goto L17;
        g85.b r1 = (g85.b) r0;
        if (r1.i(r6.c, r6.u) == false) goto L11;
    L16:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L22;
        return true;
    L22:
        return false;
    L11:
        if (r1.i(r6.b, r6.u) == true) goto L16;
        if (i75.h.d(r6.c) == true) goto L16;
        if (i75.h.d(r6.b) == true) goto L16;
    L17:
        r7 = false;
        goto L18
    L21:
        return false;
    }

    private boolean isRenderMarkdown(z r5) {
        if (r5.e > (this.mDriveConfig.a().getHighlight_max_size() * 1024)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isTextCanHighLight(z r5) {
        if (r5.e > (this.mDriveConfig.a().getHighlight_max_size() * 1024)) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$new$1(y75.b r3) {
        tt5.a.h(TAG, "excel file first loaded");
        this.mPreviewViewModel.liveInnerSaveCache().postValue(r3);
    }

    private /* synthetic */ void lambda$new$2(String r2) {
        this.mPreviewViewModel.liveInnerRoute().postValue(r2);
    }

    private /* synthetic */ void lambda$new$3(String r2) {
        this.mPreviewViewModel.liveInnerRoute().postValue(r2);
    }

    private /* synthetic */ void lambda$new$4(String r2) {
        this.mPreviewViewModel.liveInnerRoute().postValue(r2);
    }

    private /* synthetic */ void lambda$new$5(PointValue r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((c95.b) this.mPreviewView).a(r2);
    }

    private /* synthetic */ void lambda$new$6(EncryptData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((c95.b) this.mPreviewView).setEncryptData(r2);
    }

    private /* synthetic */ void lambda$new$7(Integer r2) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        ((c95.b) this.mPreviewView).b(r2.intValue());
    }

    private /* synthetic */ void lambda$new$8(String r2) {
        ((c95.b) this.mPreviewView).c(r2);
    }

    private void lambda$new$0(z r1, View r2) {
        this.mPreviewViewModel.liveInnerToggleFullScreen().postValue(r1.c);
    }

    private void initDriveWebView(DriveWebView r3, z r4, boolean r5) {
        r3.g(this.mParentViewOwner, this.mViewOwner);
        r3.setFileModel(r4);
        if (r5 == false) goto L5;
        r3.f(new d(this));
    L5:
        i75.k.a(r3);
        new n45.c(r3.getSettings(), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).b(r3);
    }

    /* JADX WARN: Type inference failed for: r11v20, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.h] */
    /* JADX WARN: Type inference failed for: r13v58, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.i] */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.j] */
    public DocumentPreviewView(ViewOwner r11, ViewOwner r12, Context r13, final z r14, a95.a r16) {
        super(r11, r12, r13, r14, r16);
        o75.a r17 = o75.b.a();
        this.mMimeTypeManager = r17.getMimeTypeManager();
        this.mDriveCacheManager = r17.getCacheManager();
        q75.a r18 = r17.getDriveConfig();
        this.mDriveConfig = r18;
        this.mOnSwitchFullScreenClickListener = new com.bytedance.ee.bear.drive.view.preview.wrapper.c(this, r14);
        boolean r19 = w55.n.k(r18);
        boolean r0 = w55.n.h(this.mDriveConfig);
        boolean r1 = w55.n.i(this.mDriveConfig);
        tt5.a.h(TAG, "enableTTWord: " + r19 + ", enableTTExcel: " + r0 + ", enableTTPPT: " + r1);
        if (i75.h.c(this.mMimeTypeManager, r14.b, r14.c) == false) goto L6;
        ExcelRenderView r110 = new ExcelRenderView(this.mContext);
        r110.h = new ExcelRenderView.a(r14);
        r110.i = new com.bytedance.ee.bear.drive.view.preview.excel.j(this.mDriveCacheManager, this.mContext, new com.bytedance.ee.bear.drive.view.preview.wrapper.d(this), this.mUserComponentAbility);
        this.mPreviewView = r110;
    L43:
        m r111 = this.mPreviewView;
        if ((r111 instanceof com.bytedance.ee.bear.drive.view.preview.htmlrender.a) == false) goto L47;
        com.bytedance.ee.bear.drive.view.preview.htmlrender.a r112 = (com.bytedance.ee.bear.drive.view.preview.htmlrender.a) r111;
        initDriveWebView(r112.getSourceWebView(), this.mFileModel, true);
        initDriveWebView(r112.getRenderWebView(), this.mFileModel, false);
    L49:
        m r113 = this.mPreviewView;
        if ((r113 instanceof TTReaderDocPPTView) == false) goto L52;
        ((TTReaderBaseView) r113).setFullScreenManager(new a(this, r14));
    L52:
        m r114 = this.mPreviewView;
        if (r114 == null) goto L55;
        r114.setOnShowViewTrackEventCallback(new b(this));
    L55:
        m r115 = this.mPreviewView;
        if ((r115 instanceof c95.a) == false) goto L59;
        ((c95.a) r115).setClickLinkCallback(new g(this));
    L59:
        if ((this.mPreviewView instanceof c95.b) == false) goto L61;
        ?? r116 = new h(this);
        ?? r117 = new i(this);
        ?? r118 = new j(this);
        ((DrivePermissionViewModel) r12.viewModel(DrivePermissionViewModel.class)).getTenantId().observe(r12.lifecycleOwner(), new k(this));
        this.mPreviewView.getView().addOnAttachStateChangeListener(new c(this, r116, r117, r118));
    L61:
        this.mPreviewView.setUserAbility(r16);
        this.mPreviewView.onSetup(this.mParentViewOwner, this.mViewOwner);
        disableBehavior();
        return;
    L47:
        if ((r111 instanceof BaseWebPreviewView) == false) goto L49;
        initDriveWebView(((BaseWebPreviewView) r111).getWebView(), this.mFileModel, true);
        goto L49
    L6:
        if (i75.h.m(this.mMimeTypeManager, r14.b, r14.c) == false) goto L8;
        HtmlRenderView r119 = new HtmlRenderView(this.mContext);
        r119.h = new HtmlRenderView.a(r14);
        this.mPreviewView = r119;
        goto L43
    L8:
        if (r0 == true) goto L10;
    L14:
        if (r19 == true) goto L16;
    L18:
        if (r1 == false) goto L23;
        if (i75.h.j(r14.c) == false) goto L23;
        TTReaderDocPPTView r120 = new TTReaderDocPPTView(this.mContext);
        z r121 = this.mFileModel;
        PreviewViewModel r2 = this.mPreviewViewModel;
        r120.f = r121;
        r120.g = r2;
        r120.setClickLinkCallback(new f(this));
        r120.e.h = new com.bytedance.ee.bear.drive.view.preview.ttreader.a.b(false, false);
        this.mPreviewView = r120;
    L23:
        if (TextUtils.equals(((g85.b) this.mMimeTypeManager).b(r14.c, null).b, "text/markdown") == false) goto L28;
        if (isRenderMarkdown(r14) == false) goto L28;
        MarkdownView r122 = new MarkdownView(this.mContext);
        r122.h = new MarkdownView.a(r14);
        this.mPreviewView = r122;
    L28:
        if (((g85.b) this.mMimeTypeManager).f(r14.b) == false) goto L31;
        CsvView r123 = new CsvView(this.mContext);
        r123.h = new CsvView.a(r14);
        this.mPreviewView = r123;
        goto L43
    L31:
        if (i75.h.l(r14.c) == false) goto L37;
        PureTextView r124 = new PureTextView(this.mContext);
        r124.a = new PureTextView.c(r14);
        if (resolveTextClickFullScreenEnabled() == false) goto L35;
        r124.setPureTextOnClickListener(this.mOnSwitchFullScreenClickListener);
    L35:
        this.mPreviewView = r124;
        goto L43
    L37:
        if (isNativeHtmlPreviewEnabled(r14) == false) goto L40;
        com.bytedance.ee.bear.drive.view.preview.htmlrender.a r125 = new com.bytedance.ee.bear.drive.view.preview.htmlrender.a(this.mContext);
        r125.f(r14, isTextCanHighLight(r14));
        this.mPreviewView = r125;
        goto L43
    L40:
        if (((g85.b) this.mMimeTypeManager).n(r14.c) == false) goto L42;
        DocumentView r126 = new DocumentView(this.mContext);
        r126.h = new DocumentView.a(r14);
        r126.setHighLight(isTextCanHighLight(r14));
        this.mPreviewView = r126;
        goto L43
    L42:
        this.mPreviewView = new NotSupportPreviewView(r11, r12, this.mContext, this.mFileModel, r16);
        goto L43
    L16:
        if (i75.h.g(r14.c) == false) goto L18;
        TTReaderDocPPTView r127 = new TTReaderDocPPTView(this.mContext);
        z r128 = this.mFileModel;
        PreviewViewModel r3 = this.mPreviewViewModel;
        r127.f = r128;
        r127.g = r3;
        r127.setClickLinkCallback(new e(this));
        r127.setIndicatorVisible(false);
        r127.e.h = new com.bytedance.ee.bear.drive.view.preview.ttreader.a.b(false, false);
        this.mPreviewView = r127;
        goto L43
    L10:
        if (((g85.b) this.mMimeTypeManager).g(r14.c) == false) goto L12;
    L13:
        TTReaderExcelView r129 = new TTReaderExcelView(this.mContext);
        z r130 = this.mFileModel;
        PreviewViewModel r4 = this.mPreviewViewModel;
        r129.f = r130;
        r129.g = r4;
        r129.k = new TTReaderExcelView.b(r14);
        r129.l = i75.h.f(r14.b);
        this.mPreviewView = r129;
        goto L43
    L12:
        if (((g85.b) this.mMimeTypeManager).f(r14.c) == false) goto L14;
        goto L13
    }
}
