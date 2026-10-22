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
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimpleDocumentPreviewView extends AbsPreviewView {
    private static final String TAG = "SimpleDocumentPreviewView";
    private com.bytedance.ee.bear.drive.cache.t mDriveCacheManager;
    private q75.a mDriveConfig;
    private g85.f mMimeTypeManager;
    private View.OnClickListener mOnSwitchFullScreenClickListener;
    private m mPreviewView;

    public class a implements c95.c {
        public final /* synthetic */ SimpleDocumentPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public a(SimpleDocumentPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r3) {
            tt5.a.h(SimpleDocumentPreviewView.TAG, "onShowSuccess, mPreviewView = ".concat(SimpleDocumentPreviewView.access$000(this.a).getClass().getSimpleName()));
            this.a.trackOpenSuccess(r3);
        }

        @Override // c95.c
        public final void a(String r3, Throwable r4) {
            tt5.a.d(SimpleDocumentPreviewView.TAG, "onShowFailure, mPreviewView = ".concat(SimpleDocumentPreviewView.access$000(this.a).getClass().getSimpleName()));
            this.a.trackOpenFailed(r3, r4);
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ Observer b;
        public final /* synthetic */ Observer c;
        public final /* synthetic */ SimpleDocumentPreviewView d;

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

        public b(SimpleDocumentPreviewView r1, e0 r2, f0 r3, g0 r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class c extends com.bytedance.ee.bear.drive.view.widget.j {
        public final /* synthetic */ SimpleDocumentPreviewView a;

        public c(SimpleDocumentPreviewView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final boolean f(String r2) {
            this.a.mPreviewViewModel.liveInnerRoute().postValue(r2);
            return true;
        }
    }

    public static /* synthetic */ void a(SimpleDocumentPreviewView r0, PointValue r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void b(SimpleDocumentPreviewView r0, z r1, View r2) {
        r0.lambda$new$0(r1, r2);
    }

    public static /* synthetic */ void c(SimpleDocumentPreviewView r0, EncryptData r1) {
        r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void d(SimpleDocumentPreviewView r0, String r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ void e(SimpleDocumentPreviewView r0, Integer r1) {
        r0.lambda$new$4(r1);
    }

    public static /* synthetic */ void f(SimpleDocumentPreviewView r0, y75.b r1) {
        r0.lambda$new$1(r1);
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

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mPreviewView.getView();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        this.mPreviewView.show();
    }

    public static /* synthetic */ m access$000(SimpleDocumentPreviewView r0) {
        return r0.mPreviewView;
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

    private /* synthetic */ void lambda$new$2(PointValue r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((c95.b) this.mPreviewView).a(r2);
    }

    private /* synthetic */ void lambda$new$3(EncryptData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((c95.b) this.mPreviewView).setEncryptData(r2);
    }

    private /* synthetic */ void lambda$new$4(Integer r2) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        ((c95.b) this.mPreviewView).b(r2.intValue());
    }

    private /* synthetic */ void lambda$new$5(String r2) {
        ((c95.b) this.mPreviewView).c(r2);
    }

    private void initDriveWebView(DriveWebView r3, z r4) {
        r3.g(this.mParentViewOwner, this.mViewOwner);
        r3.setFileModel(r4);
        r3.f(new c(this));
        i75.k.a(r3);
        new n45.c(r3.getSettings(), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).b(r3);
    }

    private void lambda$new$0(z r1, View r2) {
        this.mPreviewViewModel.liveInnerToggleFullScreen().postValue(r1.c);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.g0] */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.e0] */
    /* JADX WARN: Type inference failed for: r9v37, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.f0] */
    public SimpleDocumentPreviewView(ViewOwner r7, ViewOwner r8, Context r9, final z r10, a95.a r11) {
        super(r7, r8, r9, r10, r11);
        o75.a r12 = o75.b.a();
        this.mMimeTypeManager = r12.getMimeTypeManager();
        this.mDriveCacheManager = r12.getCacheManager();
        this.mDriveConfig = r12.getDriveConfig();
        this.mOnSwitchFullScreenClickListener = new c0(this, r10);
        if (i75.h.c(this.mMimeTypeManager, r10.b, r10.c) == false) goto L6;
        ExcelRenderView r13 = new ExcelRenderView(this.mContext);
        r13.h = new ExcelRenderView.a(r10);
        r13.i = new com.bytedance.ee.bear.drive.view.preview.excel.j(this.mDriveCacheManager, this.mContext, new d0(this), this.mUserComponentAbility);
        this.mPreviewView = r13;
    L23:
        m r14 = this.mPreviewView;
        if ((r14 instanceof BaseWebPreviewView) == false) goto L26;
        initDriveWebView(((BaseWebPreviewView) r14).getWebView(), this.mFileModel);
    L26:
        m r16 = this.mPreviewView;
        if (r16 == null) goto L30;
        r16.setOnShowViewTrackEventCallback(new a(this));
    L30:
        if ((this.mPreviewView instanceof c95.b) == false) goto L32;
        ?? r17 = new e0(this);
        ?? r18 = new f0(this);
        ?? r19 = new g0(this);
        Observer r0 = new h0(this);
        ((DrivePermissionViewModel) r8.viewModel(DrivePermissionViewModel.class)).getTenantId().observe(r8.lifecycleOwner(), r0);
        this.mPreviewView.getView().addOnAttachStateChangeListener(new b(this, r17, r18, r19));
    L32:
        this.mPreviewView.setUserAbility(r11);
        this.mPreviewView.onSetup(this.mParentViewOwner, this.mViewOwner);
        disableBehavior();
        return;
    L6:
        if (i75.h.m(this.mMimeTypeManager, r10.b, r10.c) == false) goto L8;
        HtmlRenderView r20 = new HtmlRenderView(this.mContext);
        r20.h = new HtmlRenderView.a(r10);
        this.mPreviewView = r20;
        goto L23
    L8:
        g85.f r21 = this.mMimeTypeManager;
        g85.b r22 = (g85.b) r21;
        if (TextUtils.equals(r22.b(r10.c, null).b, "text/markdown") == true) goto L11;
    L13:
        g85.f r23 = this.mMimeTypeManager;
        g85.b r24 = (g85.b) r23;
        if (r24.f(r10.b) == false) goto L17;
        CsvView r26 = new CsvView(this.mContext);
        r26.h = new CsvView.a(r10);
        this.mPreviewView = r26;
        goto L23
    L17:
        if (i75.h.l(r10.c) == false) goto L19;
        PureTextView r27 = new PureTextView(this.mContext);
        r27.a = new PureTextView.c(r10);
        r27.setPureTextOnClickListener(this.mOnSwitchFullScreenClickListener);
        this.mPreviewView = r27;
        goto L23
    L19:
        g85.f r28 = this.mMimeTypeManager;
        g85.b r29 = (g85.b) r28;
        if (r29.n(r10.c) == false) goto L22;
        DocumentView r30 = new DocumentView(this.mContext);
        r30.h = new DocumentView.a(r10);
        r30.setHighLight(isTextCanHighLight(r10));
        this.mPreviewView = r30;
        goto L23
    L22:
        this.mPreviewView = new NotSupportPreviewView(r7, r8, this.mContext, this.mFileModel, r11);
        goto L23
    L11:
        if (isRenderMarkdown(r10) == false) goto L13;
        MarkdownView r31 = new MarkdownView(this.mContext);
        r31.h = new MarkdownView.a(r10);
        this.mPreviewView = r31;
        goto L23
    }
}
