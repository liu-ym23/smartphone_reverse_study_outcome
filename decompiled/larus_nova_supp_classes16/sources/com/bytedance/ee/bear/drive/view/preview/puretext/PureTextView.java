package com.bytedance.ee.bear.drive.view.preview.puretext;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.widgets.universedesign.SpaceTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PureTextView extends FrameLayout implements m, c95.b, m85.a, SpaceTextView.b {
    public static final /* synthetic */ int q = 0;
    public c a;
    public PureTextRecyclerView b;
    public b c;
    public Disposable d;
    public View.OnClickListener e;
    public GestureDetectorCompat f;
    public PointValue g;
    public EncryptData h;
    public int i;
    public c95.c j;
    public PreviewViewModel k;
    public DriveComponentRenderVM l;
    public ViewOwner m;
    public a55.a n;
    public String o;
    public a95.a p;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ PureTextView a;

        public final boolean a() {
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (e.a.a.g() == false) goto L6;
            s55.a r0 = s55.a.a;
            PureTextView r1 = this.a;
            return s55.a.f(r1.i, "CONTENT_COPY", "", r1.getContext());
        L6:
            String r2 = ((d) org.koin.java.a.a(d.class)).f("", "CCM_CONTENT_COPY", this.a.i);
            if (TextUtils.isEmpty(r2) == true) goto L10;
            Toast.showFailureText(this.a.getContext(), r2, 0);
            return true;
        L10:
            return false;
        }

        public a(PureTextView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r3) {
            if (this.a.g.isEscaped() == false) goto L6;
            super.onLongPress(r3);
            return;
        L6:
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (e.a.a.g() == false) goto L12;
            if (PureTextView.d(this.a) == true) goto L12;
            return;
        L12:
            if (this.a.i != (-900099004)) goto L17;
            if (a() == false) goto L17;
            return;
        L17:
            if (this.a.g.getAllow() == false) goto L25;
            if (this.a.i != 0) goto L21;
        L23:
            super.onLongPress(r3);
            return;
        L21:
            if (a() == false) goto L23;
            return;
        L25:
            if (PureTextView.d(this.a) == true) goto L27;
            return;
        L27:
            int r4 = t55.b.a;
            if (t55.b.a(this.a.g.getPoint()) == false) goto L30;
            return;
        L30:
            String r5 = this.a.getContext().getString(2131887613);
            Toast.showFailureText(this.a.getContext(), r5, 0);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r2) {
            PureTextView r3 = this.a;
            View.OnClickListener r0 = r3.e;
            if (r0 == null) goto L7;
            r0.onClick(r3.b);
            return true;
        L7:
            return true;
        }
    }

    public class b extends RecyclerView.Adapter<a> {
        public final ArrayList<String> a;
        public final /* synthetic */ PureTextView b;

        public class a extends RecyclerView.ViewHolder {
            public final SpaceTextView a;

            public a(View r2) {
                super(r2);
                this.a = r2.findViewById(2131383447);
            }
        }

        public final int getItemCount() {
            return this.a.size();
        }

        public b(PureTextView r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            a r5 = (a) r3;
            r5.a.setText((CharSequence) ListProtector.get(this.a, r4));
            boolean r6 = PureTextView.d(this.b);
            SpaceTextView r0 = r5.a;
            if (this.b.g.isEscaped() == false) goto L5;
        L11:
            boolean r7 = true;
        L12:
            r0.setTextIsSelectable(r7);
            r5.a.setOnTextContextMenuItemClickListener(this.b);
            SpaceTextView r8 = r5.a;
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L15;
            com.bytedance.ee.bear.drive.view.preview.action.a.a(r8);
        L15:
            r5.a.setCopyCallback(new com.bytedance.ee.bear.drive.view.preview.puretext.a(this));
            return;
        L5:
            if (this.b.g.getAllow() == true) goto L7;
        L10:
            r7 = false;
            goto L12
        L7:
            if (this.b.i != 0) goto L10;
            if (r6 == false) goto L10;
            goto L10
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131560218, r3, false);
            r5.setOnTouchListener(new y95.e(this));
            return new a(r5);
        }
    }

    public static class c {
        public final z a;

        public c(z r1) {
            this.a = r1;
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
        return "PureTextView";
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
    public final boolean onBackPressed() {
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

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
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

    private a55.b getOnContextMenuItemClickListener() {
        if (this.n != null) goto L10;
        ViewOwner r1 = this.m;
        c r2 = this.a;
        if (r2 == null) goto L7;
        z r3 = r2.a;
    L8:
        this.n = new a55.a(r1, r3);
        goto L10
    L7:
        r3 = null;
    L10:
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        PreviewViewModel r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        if (this.l.needBindReleaseListener() == true) goto L11;
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
        Disposable r1 = this.d;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        a55.a r2 = this.n;
        if (r2 == null) goto L14;
        r2.onRelease();
        return;
    L14:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L15;
        c95.c r1 = this.j;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        j65.a.b(this.k, "PureTextView");
        DriveFilePath r2 = this.a.a.d;
        if (r2.isEmpty() == false) goto L12;
        tt5.a.d("PureTextView", "showDocuments filePath is empty");
        return;
    L12:
        this.d = Flowable.just(r2).map(new y95.b(this)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new y95.c(this), new y95.d(this));
        return;
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(2131560219, this);
        this.b = (PureTextRecyclerView) findViewById(2131383448);
        this.c = new b(this);
        LinearLayoutManager r0 = new LinearLayoutManager(getContext());
        this.b.setLayoutManager(r0);
        this.b.setAdapter(this.c);
        this.f = new GestureDetectorCompat(getContext(), new a(this));
        this.b.setOnTouchListener(new y95.a(this));
    }

    public PureTextView(Context r2) {
        super(r2);
        this.g = new PointValue(false, 0);
        this.i = 0;
        e();
    }

    public static boolean d(PureTextView r12) {
        c r0 = r12.a;
        if (r0 == null) goto L16;
        z r1 = r0.a;
        if (r1 == null) goto L16;
        String r3 = r1.t;
        String r4 = r1.o;
        a55.b r2 = r12.getOnContextMenuItemClickListener();
        String r13 = r12.o;
        ((a55.a) r2).getClass();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L12;
        s55.a r5 = s55.a.a;
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        return s55.a.h(r5, "CONTENT_COPY", r3, r4, r13, null, null, null, null, null, 496).getAllow();
    L12:
        FileBizDomain r14 = pw4.b.d(r3);
        if (Intrinsics.areEqual(r3, "calendar") == false) goto L19;
        r14 = FileBizDomain.FileBizDomainCCM;
    L19:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r3), r14, pw4.b.f(r3), r4).a;
    L16:
        return true;
    }

    @Override // c95.b
    public final void a(PointValue r1) {
        if (r1 == null) goto L4;
        this.g = r1;
    L4:
        b r2 = this.c;
        if (r2 == null) goto L8;
        r2.notifyDataSetChanged();
        return;
    }

    @Override // c95.b
    public final void b(int r1) {
        this.i = r1;
        b r2 = this.c;
        if (r2 == null) goto L6;
        r2.notifyDataSetChanged();
        return;
    }

    @Override // c95.b
    public final void c(String r1) {
        this.o = r1;
        b r2 = this.c;
        if (r2 == null) goto L6;
        r2.notifyDataSetChanged();
        return;
    }

    public final void f(int r9) {
        tt5.a.h("PureTextView", "onTextContextMenuItemClick()...id = " + r9);
        ((a55.a) getOnContextMenuItemClickListener()).b(r9, true, this.i, getContext(), "", null);
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r1) {
        this.h = r1;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r1) {
        this.j = r1;
    }

    public void setPureTextOnClickListener(View.OnClickListener r1) {
        this.e = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.p = r1;
    }

    public PureTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.g = new PointValue(false, 0);
        this.i = 0;
        e();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r2, ViewOwner r3) {
        this.m = r3;
        this.k = (PreviewViewModel) r3.viewModel(PreviewViewModel.class);
        DriveComponentRenderVM r4 = (DriveComponentRenderVM) r2.viewModel(DriveComponentRenderVM.class);
        this.l = r4;
        r4.bindReleaseListener(this);
    }

    public PureTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = new PointValue(false, 0);
        this.i = 0;
        e();
    }
}
