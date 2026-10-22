package com.bytedance.ee.bear.drive.view.preview.pdf;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.VCFollowLinearSmoothScroller;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.g;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.bytedance.ee.bear.drive.biz.wps.PdfEditButton;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.RecyclingImageView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import i75.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import v95.f;
import v95.i;
import v95.j;
import v95.k;
import v95.l;
import v95.o;
import v95.p;
import v95.q;
import v95.r;
import v95.s;
import v95.t;
import v95.u;
import v95.v;
import v95.w;
import v95.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimplePdfView extends FrameLayout implements m, com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a, m85.a {
    public static final /* synthetic */ int K = 0;
    public v95.b A;
    public v95.m B;
    public boolean C;
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b D;
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c E;
    public int F;
    public boolean G;
    public g H;
    public Disposable I;
    public PdfEditButton J;
    public BaseRecyclerView a;
    public LinearLayoutManagerWrapper b;
    public TextView c;
    public TextView d;
    public View.OnClickListener e;
    public com.bytedance.ee.bear.drive.view.preview.pdf.a f;
    public int g;
    public int h;
    public v95.a i;
    public DriveComponentRenderVM j;
    public PreviewViewModel k;
    public DriveVCFollowVM l;
    public DriveConfigurationVM m;
    public ViewOwner n;
    public CompositeDisposable o;
    public a95.a p;
    public c95.c q;
    public c r;
    public int s;
    public int t;
    public final SparseIntArray u;
    public LruBitmapPool v;
    public PdfPresentationView w;
    public boolean x;
    public ExhibitionMode y;
    public final CompositeDisposable z;

    public class a extends RecyclerView.OnScrollListener {
        public final /* synthetic */ SimplePdfView a;

        public a(SimplePdfView r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r2, int r3) {
            com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c r4 = this.a.E;
            if (r4 == null) goto L6;
            tt5.a.h("CCMFollow_PDFVCFollowConnector", "ScrollListener onScrollStateChanged: ");
            ((l65.a.C0248a) ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.c) r4).a).b();
            return;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExhibitionMode.values().length];
            a = r0;
            r0[ExhibitionMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[ExhibitionMode.PRESENTATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public int a;
        public final /* synthetic */ SimplePdfView b;

        public class a extends RecyclerView.ViewHolder {
            public final RecyclingImageView a;
            public final View b;

            public a(c r3, View r4) {
                super(r4);
                RecyclingImageView r0 = (RecyclingImageView) r4.findViewById(2131386526);
                this.a = r0;
                this.b = r4.findViewById(2131386525);
                r0.setOnClickListener(r3.b.e);
            }
        }

        public final long getItemId(int r3) {
            return r3;
        }

        public final int getItemViewType(int r1) {
            return 0;
        }

        public final int getItemCount() {
            return this.a;
        }

        public c(SimplePdfView r1) {
            this.b = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            if ((r8 instanceof a) == false) goto L20;
            tt5.a.h("DRIVE_PdfAdapter", "SimplePdfItemViewHolder >>>  pageCount: " + this.a + ", currentPage: " + (r9 + 1));
            if (r9 != 0) goto L7;
            ((a) r8).b.setVisibility(8);
        L8:
            RecyclingImageView r10 = ((a) r8).a;
            ViewGroup.LayoutParams r1 = r10.getLayoutParams();
            int[] r2 = this.b.getInitWidthHeight();
            int r3 = r1.width;
            int r4 = r2[0];
            if (r3 == r4) goto L11;
        L12:
            r1.width = r4;
            r1.height = r2[1];
            r10.setLayoutParams(r1);
        L13:
            SimplePdfView r5 = this.b;
            if (r5.f == null) goto L16;
            SimplePdfView r6 = this.b;
            e r7 = new e(r6, r6.f, r10, r9);
        L17:
            if (r7 == null) goto L21;
            r7.execute1(new Void[0]);
            return;
        L21:
            return;
        L16:
            r5.getClass();
            r7 = null;
            goto L17
        L11:
            if (r1.height == r2[1]) goto L13;
        L7:
            ((a) r8).b.setVisibility(0);
            goto L8
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new a(this, LayoutInflater.from(r3.getContext()).inflate(2131560230, r3, false));
        }
    }

    public static class d {
        public final int a;
        public final com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a b;

        public d(int r1, com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class e extends PthreadAsyncTask<Void, Void, com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a> {
        public final WeakReference<RecyclingImageView> h;
        public final com.bytedance.ee.bear.drive.view.preview.pdf.a i;
        public final int j;
        public final /* synthetic */ SimplePdfView k;

        /* JADX WARN: Multi-variable type inference failed */
        public final void onPreExecute() {
            super/*android.os.AsyncTask*/.onPreExecute();
            RecyclingImageView r0 = this.h.get();
            if (r0 == null) goto L6;
            r0.b(null, this.k.v);
            r0.setTag(String.valueOf(this.j));
            return;
        }

        public final Object doInBackground(Object[] r4) {
            Void[] r5 = (Void[]) r4;
            com.bytedance.ee.bear.drive.view.preview.pdf.a r6 = this.i;
            if (r6.d == false) goto L5;
        L8:
            boolean r7 = true;
        L9:
            if (r7 == false) goto L12;
            tt5.a.k("RenderTask", "doInBackground() mRenderTaskPdfRender.isClosed()");
            return null;
        L12:
            return this.i.c(this.j, false, this.k.v);
        L5:
            if (r6.a == null) goto L8;
            r7 = false;
            goto L9
        }

        public final void onPostExecute(Object r6) {
            com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a r7 = (com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a) r6;
            if (r7 != null) goto L6;
            return;
        L6:
            if (r7.a() == true) goto L8;
            tt5.a.h("RenderTask", "onPostExecute() result.isSuccessful() is false, exitIfNeeded.");
            SimplePdfView r0 = this.k;
            Throwable r8 = r7.d;
            int r1 = SimplePdfView.K;
            r0.k(r8);
            return;
        L8:
            RecyclingImageView r2 = this.h.get();
            if (r2 != null) goto L11;
        L25:
            r7.a.recycle();
            return;
        L11:
            if (r2.getTag().equals(String.valueOf(this.j)) == false) goto L25;
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            int r4 = r3.height;
            int r5 = r7.b;
            if (r4 == r5) goto L15;
        L16:
            r3.height = r5;
            r3.width = r7.c;
            r2.setLayoutParams(r3);
            this.k.u.put(this.j, r7.b);
        L17:
            SimplePdfView r9 = this.k;
            if (r9.s != 0) goto L20;
        L23:
            r9.s = r7.b;
            r9.t = r7.c;
            r9.G = false;
        L24:
            r2.b(r7.a, r9.v);
            return;
        L20:
            if (r9.t == 0) goto L23;
            if (r9.G == false) goto L24;
        L15:
            if (r3.width == r7.c) goto L17;
            goto L16
        }

        public e(SimplePdfView r1, com.bytedance.ee.bear.drive.view.preview.pdf.a r2, RecyclingImageView r3, int r4) {
            this.k = r1;
            this.i = r2;
            this.h = new WeakReference(r3);
            this.j = r4;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "SimplePdfView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setListenerChange(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC0155a r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setState(DrivePdfState r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r1) {
    }

    private com.bytedance.ee.bear.drive.view.preview.pdf.a getAvailablePdfRender() {
        com.bytedance.ee.bear.drive.view.preview.pdf.a r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0;
    }

    private int getLastPageIndex() {
        int r0 = this.h - 1;
        if (r0 >= 1) goto L6;
        return 1;
    L6:
        return r0;
    }

    private int getNextPageIndex() {
        int r0 = this.h + 1;
        int r1 = this.g;
        if (r0 > r1) goto L5;
        return r0;
    L5:
        return r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final DrivePdfState.V2Offset c() {
        DrivePdfState.V2Offset r0 = new DrivePdfState.V2Offset();
        r0.pageNumber = -1;
        r0.pageOffsetTop = -1.0f;
        LinearLayoutManager r1 = this.a.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == true) goto L5;
        return r0;
    L5:
        int r2 = r1.findFirstVisibleItemPosition();
        Rect r3 = h(r1.findViewByPosition(r2));
        Rect r4 = h(this.a);
        float r5 = a(r2);     // Catch: Exception -> L13
        float r6 = Math.abs(r3.top - r4.top);     // Catch: Exception -> L13
        float r7 = 0.0f;
        if (r5 > 0.0f) goto L9;
    L11:
        r0.pageNumber = r2 + 1;     // Catch: Exception -> L13
        r0.pageOffsetTop = r7;     // Catch: Exception -> L13
    L15:
        return r0;
    L9:
        if (r6 <= 0.0f) goto L11;
        r7 = r6 / r5;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.e("SimplePdfView", "generateOffsetPercentV2: ", e, false);
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int f() {
        LinearLayoutManager r0 = this.a.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r1 = r0;
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
        if (r2 != r3) goto L7;
        return r2;
    L7:
        int r4 = (r2 + r3) / 2;
        if (p(r4) == false) goto L11;
        tt5.a.h("SimplePdfView", "findMiddleItem: middlePosition");
        return r4;
    L11:
        int r5 = r4 - 1;
        if (p(r5) == false) goto L15;
        tt5.a.h("SimplePdfView", "findMiddleItem: middlePosition-1");
        return r5;
    L15:
        int r6 = r4 + 1;
        if (p(r6) == false) goto L19;
        tt5.a.h("SimplePdfView", "findMiddleItem: middlePosition+1");
        return r6;
    L19:
        tt5.a.k("SimplePdfView", "findMiddleItem: failed");
    L20:
        return -1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public ExhibitionMode getCurrentMode() {
        if (this.x == false) goto L6;
        return ExhibitionMode.PRESENTATION;
    L6:
        return ExhibitionMode.NORMAL;
    }

    public int getCurrentOrientation() {
        if (this.F != (-1)) goto L6;
        Context r0 = getContext();
        int r1 = n.a;
        this.F = r0.getResources().getConfiguration().orientation;
    L6:
        return this.F;
    }

    public int[] getInitWidthHeight() {
        int r0 = this.t;
        if (r0 == 0) goto L9;
        int r2 = this.s;
        if (r2 == 0) goto L9;
        if (this.G == true) goto L9;
    L14:
        return new int[]{r0, r2};
    L9:
        r0 = n.v();
        if (getCurrentOrientation() != 1) goto L12;
        r2 = n.t();
        goto L14
    L12:
        r2 = (r0 * r0) / n.t();
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getViewHeight() {
        return this.a.getHeight();
    }

    public final void i() {
        int r1 = 1;
        if (this.b.findFirstCompletelyVisibleItemPosition() == 0) goto L15;
        int r0 = this.b.findFirstVisibleItemPosition();
        View r2 = this.b.findViewByPosition(r0);
        BaseRecyclerView r3 = this.a;
        if (r2 == null) goto L10;
        int[] r5 = new int[2];
        r3.getLocationInWindow(r5);
        int[] r4 = new int[2];
        r2.getLocationInWindow(r4);
        if ((r2.getHeight() - (r5[1] - r4[1])) > ((r3.getHeight() / 2.0f) - r3.getPaddingTop())) goto L10;
        int r6 = (r0 + 1) + 1;
        r1 = this.g;
        if (r6 > r1) goto L15;
    L11:
        r1 = r6;
    L10:
        r6 = r0 + 1;
    L15:
        if (r1 == this.h) goto L18;
        setIndicator(r1);
        return;
    }

    public final boolean l() {
        tt5.a.h("SimplePdfView", "do exitPresentationMode. mIsPresentationMode: " + this.x + ", mCurrentPage: " + this.h);
        if (this.x == true) goto L5;
        return false;
    L5:
        PreviewViewModel r0 = this.k;
        if (r0 != null) goto L8;
    L10:
        PreviewViewModel r1 = this.k;
        if (r1 == null) goto L13;
        MutableLiveData<Boolean> r2 = r1.liveInnerIsPresentationMode();
        Boolean r3 = Boolean.FALSE;
        r2.setValue(r3);
        this.k.liveInnerVideoFullScreen().setValue(r3);
        this.k.liveInnerForceFullScreen().setValue(r3);
    L13:
        this.z.clear();
        r(this.h);
        this.w.setVisibility(8);
        ((DriveViewFullScreenVM) this.n.viewModel(DriveViewFullScreenVM.class)).getImmersiveTitleTopState().postValue(Boolean.FALSE);
        this.x = false;
        return true;
    L8:
        if (Boolean.TRUE.equals(r0.liveInnerEditModeSwitchActive().getValue()) == false) goto L10;
        this.J.setVisibility(0);
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        if (this.x == true) goto L5;
        return false;
    L5:
        if (l() == true) goto L7;
        return true;
    L7:
        if (this.D == null) goto L14;
        post(new p(this));
        return true;
    L14:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        PreviewViewModel r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        if (this.j.needBindReleaseListener() == true) goto L11;
        onRelease();
        return;
    L11:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        CompositeDisposable r1 = this.o;
        if (r1 == null) goto L10;
        r1.clear();
    L10:
        com.bytedance.ee.bear.drive.view.preview.pdf.a r2 = this.f;
        if (r2 == null) goto L13;
        r2.b();
    L13:
        LruBitmapPool r3 = this.v;
        if (r3 == null) goto L16;
        r3.clearMemory();
    L16:
        Disposable r4 = this.I;
        if (r4 == null) goto L22;
        if (r4.isDisposed() == true) goto L22;
        this.I.dispose();
    L22:
        if (h.j(this.i.b) == true) goto L24;
        return;
    L24:
        if (this.k == null) goto L28;
        tt5.a.h("SimplePdfView", "simplePdfView ppt detach from window, disable presentation action. ");
        this.k.liveInnerShowPresentationAction().postValue(Boolean.FALSE);
        if (this.A == null) goto L28;
        this.k.liveOuterEnterPresentationMode().removeObserver(this.A);
    L28:
        DriveVCFollowVM r5 = this.l;
        if (r5 != null) goto L31;
        return;
    L31:
        if (this.B == null) goto L36;
        r5.getLiveIsPresenter().removeObserver(this.B);
        return;
    L36:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [androidx.lifecycle.Observer, v95.m] */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.lifecycle.Observer, v95.b] */
    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        if (this.i == null) goto L25;
        c95.c r0 = this.q;
        if (r0 == null) goto L7;
        r0.onShowStart();
    L7:
        j65.a.b(this.k, "SimplePdfView");
        DriveFilePath r1 = this.i.a;
        if (r1 != null) goto L11;
        DriveFilePath.Companion.getClass();
        r1 = DriveFilePath.a.a();
    L11:
        if (z75.b.d(r1, this.p.b) == true) goto L13;
        tt5.a.d("SimplePdfView", "file is not exists: " + r1);
    L15:
        if (this.C == false) goto L22;
        if (h.j(this.i.b) == false) goto L22;
        if (this.k == null) goto L22;
        tt5.a.h("SimplePdfView", "simplePdfView show ppt, enable presentation action. ");
        this.k.liveInnerShowPresentationAction().postValue(Boolean.TRUE);
        MutableLiveData<Void> r2 = this.k.liveOuterEnterPresentationMode();
        LifecycleOwner r3 = this.n.lifecycleOwner();
        ?? r4 = new v95.b(this);
        this.A = r4;
        r2.observe(r3, r4);
    L22:
        if (this.l == null) goto L26;
        tt5.a.h("SimplePdfView", "simplePdfView show ppt, enable presenter changed listener. ");
        MutableLiveData<Boolean> r5 = this.l.getLiveIsPresenter();
        LifecycleOwner r6 = this.n.lifecycleOwner();
        ?? r7 = new v95.m(this);
        this.B = r7;
        r5.observe(r6, r7);
        return;
    L26:
        return;
    L13:
        this.f = new com.bytedance.ee.bear.drive.view.preview.pdf.a(r1, getCurrentOrientation(), this.p);
        this.o.clear();
        this.o.add(Flowable.fromCallable(new j(this)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new k(this), new l(this)));
        goto L15
    }

    public final void n() {
        LayoutInflater.from(getContext()).inflate(2131560216, this);
        this.a = findViewById(2131384076);
        this.c = (TextView) findViewById(2131375249);
        this.w = (PdfPresentationView) findViewById(2131382882);
        this.d = (TextView) findViewById(2131364273);
        this.o = new CompositeDisposable();
        c r0 = new c(this);
        this.r = r0;
        r0.setHasStableIds(true);
        this.b = new LinearLayoutManagerWrapper(getContext());
        this.a.setItemAnimator(null);
        this.a.setLayoutManager(this.b);
        this.a.setAdapter(this.r);
        this.a.addOnScrollListener(new x(this));
        this.v = w95.b.a(getContext());
        this.a.addOnScrollListener(new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getCurrentPage() {
        return this.h;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getPageCount() {
        return this.g;
    }

    public SimplePdfView(Context r2) {
        super(r2);
        this.h = 1;
        this.u = new SparseIntArray();
        this.x = false;
        this.y = ExhibitionMode.NORMAL;
        this.z = new CompositeDisposable();
        this.C = false;
        this.F = -1;
        this.G = false;
        n();
    }

    public static Rect h(View r6) {
        if (r6 == null) goto L5;
        int[] r1 = new int[2];
        r6.getLocationOnScreen(r1);
        int r0 = r1[0];
        return new Rect(r0, r1[1], r6.getWidth() + r0, r1[1] + r6.getHeight());
    L5:
        return new Rect(0, 0, 0, 0);
    }

    private void setIndicator(int r5) {
        this.h = r5;
        this.c.setText(String.format("%d/%d", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.g)}));
        this.d.setText(xo5.a.c(getContext(), 2131887216, "total", String.valueOf(this.g)));
        if (this.m == null) goto L6;
        tt5.a.h("SimplePdfView", "update current position " + this.h);
        DrivePdfState.V2Offset r6 = new DrivePdfState.V2Offset();
        r6.pageNumber = this.h;
        this.m.getCurrentV2Offset().postValue(r6);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int a(int r9) {
        int r0 = this.u.get(r9);
        if (r0 != 0) goto L60;
        com.bytedance.ee.bear.drive.view.preview.pdf.a r1 = getAvailablePdfRender();
        if (r1 != null) goto L7;
    L50:
        tt5.a.d("SimplePdfView", "getPageHeight, pdfRender is null or a page is opening. ");
        return this.u.get(0);
    L7:
        if (r1.e == true) goto L50;
        int r3 = r9 - 1;
        monitor-enter(r1);
    L47:
        th = move-exception;
        throw th;
    L11:
        if (r1.a != null) goto L15;
        int[] r4 = {0, 0};     // Catch: Throwable -> L47
        monitor-exit(r1);
    L38:
        if (r4.length < 2) goto L61;
        int r2 = r4[1];
        if (r2 <= 0) goto L62;
        this.u.put(r9, r2);
        return r2;
    L62:
        return r0;
    L61:
        return r0;
    L15:
        r1.e = true;     // Catch: Throwable -> L47
        PdfRenderer.Page r5 = r1.a.openPage(r3);     // Catch: Throwable -> L31
        int[] r6 = r1.a(r5, false);     // Catch: Throwable -> L24
        r5.close();     // Catch: Throwable -> L31
        r1.e = false;     // Catch: Throwable -> L47
        if (r1.d == false) goto L22;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L47
        r1.b();     // Catch: Throwable -> L47
        r1.d = false;     // Catch: Throwable -> L47
    L22:
        monitor-exit(r1);
        r4 = r6;
        goto L38
    L24:
        th = move-exception;
        if (r5 != null) goto L58;
    L30:
        throw th;     // Catch: Throwable -> L31
    L58:
        r5.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        tt5.a.f("PdfRender", th, false);     // Catch: Throwable -> L42
        r4 = new int[]{0, 0};     // Catch: Throwable -> L42
        r1.e = false;     // Catch: Throwable -> L47
        if (r1.d == false) goto L38;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L47
        r1.b();     // Catch: Throwable -> L47
        r1.d = false;     // Catch: Throwable -> L47
        goto L38
    L42:
        th = move-exception;
        r1.e = false;     // Catch: Throwable -> L47
        if (r1.d == false) goto L46;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L47
        r1.b();     // Catch: Throwable -> L47
        r1.d = false;     // Catch: Throwable -> L47
    L46:
        throw th;     // Catch: Throwable -> L47
    L60:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final boolean b(int r2) {
        if (this.x == false) goto L6;
        o(r2);
        this.h = r2;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final float d(int r5) {
        RecyclerView.LayoutManager r0 = this.a.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        return 0.0f;
    L5:
        Rect r1 = h(r0.findViewByPosition(r5));
        Rect r2 = h(this.a);
    L16:
        e = move-exception;
        tt5.a.e("SimplePdfView", "generateOffsetPercent: ", e, false);
    L18:
        return 0.0f;
    L7:
        if (r5 >= getPageCount()) goto L18;
        if (r5 < 0) goto L18;
        float r6 = a(r5);     // Catch: Exception -> L16
        float r3 = ((r2.top + r2.bottom) / 2) - r1.top;
        if (r6 <= 0.0f) goto L18;
        if (r3 <= 0.0f) goto L18;
        return r3 / r6;
    }

    public final boolean j(int r11) {
        tt5.a.h("SimplePdfView", "do enterPresentationMode. position: " + r11 + ", mIsPresentationMode: " + this.x + ", mCurrentPage: " + this.h);
        if (this.x == false) goto L5;
        return false;
    L5:
        o(r11);
        this.a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        this.J.setVisibility(8);
        PreviewViewModel r0 = this.k;
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.liveInnerIsPresentationMode();
        Boolean r2 = Boolean.TRUE;
        r1.setValue(r2);
        this.k.liveInnerVideoFullScreen().setValue(r2);
        this.k.liveInnerForceFullScreen().setValue(r2);
    L8:
        this.h = r11;
        CompositeDisposable r12 = this.z;
        PdfPresentationView r3 = this.w;
        r3.getClass();
        r12.add(new com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a(r3).filter(new q(this)).distinctUntilChanged(new r()).observeOn(Schedulers.single()).map(new s(this)).observeOn(fo5.d.d()).subscribe(new t(this), new u()));
        this.w.setBackClickListener(new v(this));
        this.w.setVisibility(0);
        ((DriveViewFullScreenVM) this.n.viewModel(DriveViewFullScreenVM.class)).getImmersiveTitleTopState().postValue(Boolean.TRUE);
        this.x = true;
        return true;
    }

    public final void k(Throwable r4) {
        tt5.a.e("SimplePdfView", "exitIfNeeded() error=", r4, false);
        if ((r4 instanceof SecurityException) == false) goto L7;
        PreviewViewModel r5 = this.k;
        if (r5 == null) goto L15;
        r5.liveInnerPasswordProtected().postValue("");
        return;
    L15:
        return;
    L7:
        com.bytedance.ee.bear.drive.view.preview.pdf.a r6 = this.f;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.h == true) goto L18;
        PreviewViewModel r7 = this.k;
        if (r7 == null) goto L19;
        r7.getLiveInnerShowPreviewFailedPage().postValue(null);
        return;
    L19:
        return;
    }

    public final com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a m(int r4) {
        com.bytedance.ee.bear.drive.view.preview.pdf.a r0 = getAvailablePdfRender();
        if (r0 == null) goto L15;
        if (r0.d == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L15;
        return r0.c(r4 - 1, true, this.v);
    L7:
        if (r0.a == null) goto L10;
        r1 = false;
    L15:
        return new com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a(new IllegalAccessException("pdfRender is null or closed. "));
    }

    public final void o(int r3) {
        Disposable r0 = this.I;
        if (r0 != null) goto L5;
    L7:
        this.I = Flowable.just(Integer.valueOf(r3)).observeOn(Schedulers.single()).map(new v95.c(this)).observeOn(fo5.d.d()).subscribe(new v95.d(this), new v95.e());
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.I.dispose();
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onNewConfiguration(Configuration r3) {
        tt5.a.h("DriveSdk", "SimplePdfView onNewConfiguration, newConfig = " + r3);
        int r4 = r3.orientation;
        this.F = r4;
        this.G = true;
        com.bytedance.ee.bear.drive.view.preview.pdf.a r0 = this.f;
        if (r0 == null) goto L5;
        r0.d(r4);
    L5:
        this.r.notifyDataSetChanged();
        postDelayed(new w(this), 100);
    }

    public final boolean p(int r5) {
        if (r5 >= 0) goto L5;
    L12:
        tt5.a.k("SimplePdfView", "positionIsMiddle: position is invaild");
        return false;
    L5:
        if (r5 >= getPageCount()) goto L12;
        LinearLayoutManager r1 = this.a.getLayoutManager();
        Rect r2 = h(this.a);
        if ((r1 instanceof LinearLayoutManager) == true) goto L10;
        return false;
    L10:
        return h(r1.findViewByPosition(r5)).contains((r2.left + r2.right) / 2, (r2.top + r2.bottom) / 2);
    }

    public final void q(String r4) {
        if (this.k == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r4);
        this.k.liveInnerReportMsg().a(new a0(20, r0));
        return;
    }

    public final void r(int r3) {
        tt5.a.h("SimplePdfView", "scrollToIndex: " + r3);
        setIndicator(r3);
        this.b.scrollToPositionWithOffset(r3 + (-1), 200);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setCurrentPosition(int r1) {
        setIndicator(r1);
    }

    public void setDefaultExhibitionMode(ExhibitionMode r1) {
        this.y = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setExhibitionMode(ExhibitionMode r3) {
        int r0 = this.h;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        l();
        return;
    L5:
        if (r4 != 2) goto L11;
        j(r0);
        q("auto");
        return;
    }

    public void setIsVCFollow(g r1) {
        this.H = r1;
    }

    public void setOnPageClickListener(View.OnClickListener r1) {
        this.e = r1;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r1) {
        this.q = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setPDFActionListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r1) {
        this.D = r1;
    }

    public void setPresentationEnable(boolean r1) {
        this.C = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setScrollListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c r1) {
        this.E = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.p = r1;
    }

    public SimplePdfView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.h = 1;
        this.u = new SparseIntArray();
        this.x = false;
        this.y = ExhibitionMode.NORMAL;
        this.z = new CompositeDisposable();
        this.C = false;
        this.F = -1;
        this.G = false;
        n();
    }

    public static void g(final SimplePdfView r2, com.bytedance.ee.bear.drive.view.preview.pdf.a r3) {
        r2.getClass();
        int r4 = r3.b;
        r2.g = r4;
        c r0 = r2.r;
        r0.a = r4;
        r0.notifyDataSetChanged();
        r2.setIndicator(1);
        c95.c r5 = r2.q;
        if (r5 == null) goto L5;
        r5.b("pdf_render");
    L5:
        j65.a.c(r2.k, "SimplePdfView");
        tt5.a.h("SimplePdfView", "renderFile, mPageCount = " + r2.g);
        r2.post(new o(r2));
        g r6 = r2.H;
        if (r6 == null) goto L9;
        r6.onViewReady();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final void e(int r4, int r5) {
        RecyclerView.LayoutManager r0 = this.a.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        VCFollowLinearSmoothScroller r1 = new VCFollowLinearSmoothScroller(this.a.getContext());
        r1.setTargetPosition(r4);
        r1.a = r5;
        r0.startSmoothScroll(r1);
        return;
    L5:
        tt5.a.k("SimplePdfView", "scrollToTargetPositionInternal: invalid LayoutManager");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r3, ViewOwner r4) {
        this.n = r4;
        this.j = (DriveComponentRenderVM) r3.viewModel(DriveComponentRenderVM.class);
        this.k = (PreviewViewModel) r4.viewModel(PreviewViewModel.class);
        this.l = (DriveVCFollowVM) r4.viewModel(DriveVCFollowVM.class);
        this.m = (DriveConfigurationVM) r4.viewModel(DriveConfigurationVM.class);
        this.j.bindReleaseListener(this);
        ((DriveBlockPreviewVM) r4.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(r4.lifecycleOwner(), new f(this));
        this.m.getLastPreviewConfig().observe(r4.lifecycleOwner(), new v95.g(this));
        PdfEditButton r5 = new PdfEditButton(getContext());
        this.J = r5;
        addView(r5);
        this.J.setVisibility(8);
        this.J.setOnClickListener(new v95.h(this));
        this.k.liveInnerEditModeSwitchActive().observe(this.n.lifecycleOwner(), new i(this));
    }

    public SimplePdfView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.h = 1;
        this.u = new SparseIntArray();
        this.x = false;
        this.y = ExhibitionMode.NORMAL;
        this.z = new CompositeDisposable();
        this.C = false;
        this.F = -1;
        this.G = false;
        n();
    }
}
