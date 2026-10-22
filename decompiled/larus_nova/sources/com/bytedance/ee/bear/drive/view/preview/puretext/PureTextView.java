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
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import jg5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class PureTextView extends FrameLayout implements m, c95.b, m85.a, SpaceTextView.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f225151q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f225152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PureTextRecyclerView f225153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f225154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f225155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f225156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GestureDetectorCompat f225157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointValue f225158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EncryptData f225159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c95.c f225161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PreviewViewModel f225162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DriveComponentRenderVM f225163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewOwner f225164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a55.a f225165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f225166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a95.a f225167p;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PureTextView f225168a;

        public final boolean a() {
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (e.a.f499003a.g() == false) goto L6;
            s55.a r100 = s55.a.f540731a;
            PureTextView r101 = this.f225168a;
            return s55.a.f(r101.f225160i, "CONTENT_COPY", "", r101.getContext());
        L6:
            String r102 = ((d) org.koin.java.a.a(d.class)).f("", "CCM_CONTENT_COPY", this.f225168a.f225160i);
            if (TextUtils.isEmpty(r102) == true) goto L10;
            Toast.showFailureText(this.f225168a.getContext(), r102, 0);
            return true;
        L10:
            return false;
        }

        public a(PureTextView r100) {
            this.f225168a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            if (this.f225168a.f225158g.isEscaped() == false) goto L6;
            super.onLongPress(r100);
            return;
        L6:
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (e.a.f499003a.g() == false) goto L12;
            if (PureTextView.d(this.f225168a) == true) goto L12;
            return;
        L12:
            if (this.f225168a.f225160i != (-900099004)) goto L17;
            if (a() == false) goto L17;
            return;
        L17:
            if (this.f225168a.f225158g.getAllow() == false) goto L25;
            if (this.f225168a.f225160i != 0) goto L21;
        L23:
            super.onLongPress(r100);
            return;
        L21:
            if (a() == false) goto L23;
            return;
        L25:
            if (PureTextView.d(this.f225168a) == true) goto L27;
            return;
        L27:
            int r101 = t55.b.f544629a;
            if (t55.b.a(this.f225168a.f225158g.getPoint()) == false) goto L30;
            return;
        L30:
            String r102 = this.f225168a.getContext().getString(R.string.Doc_Comment_CopyFailed);
            Toast.showFailureText(this.f225168a.getContext(), r102, 0);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            PureTextView r101 = this.f225168a;
            View.OnClickListener r102 = r101.f225156e;
            if (r102 == null) goto L7;
            r102.onClick(r101.f225153b);
            return true;
        L7:
            return true;
        }
    }

    public class b extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<String> f225169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PureTextView f225170b;

        public class a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SpaceTextView f225171a;

            public a(View r100) {
                super(r100);
                this.f225171a = (SpaceTextView) r100.findViewById(R.id.pure_text_item_view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f225169a.size();
        }

        public b(PureTextView r100) {
            this.f225170b = r100;
            this.f225169a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            a r102 = (a) r100;
            r102.f225171a.setText((CharSequence) ListProtector.get(this.f225169a, r101));
            boolean r103 = PureTextView.d(this.f225170b);
            SpaceTextView r104 = r102.f225171a;
            if (this.f225170b.f225158g.isEscaped() == false) goto L5;
        L11:
            boolean r105 = true;
        L12:
            r104.setTextIsSelectable(r105);
            r102.f225171a.setOnTextContextMenuItemClickListener(this.f225170b);
            SpaceTextView r106 = r102.f225171a;
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L15;
            com.bytedance.ee.bear.drive.view.preview.action.a.a(r106);
        L15:
            r102.f225171a.setCopyCallback(new com.bytedance.ee.bear.drive.view.preview.puretext.a(this));
            return;
        L5:
            if (this.f225170b.f225158g.getAllow() == true) goto L7;
        L10:
            r105 = false;
            goto L12
        L7:
            if (this.f225170b.f225160i != 0) goto L10;
            if (r103 == false) goto L10;
            goto L10
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.drive_preview_pure_text_item_view, r100, false);
            r102.setOnTouchListener(new y95.e(this));
            return new a(r102);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f225172a;

        public c(z r100) {
            this.f225172a = r100;
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
    public final void onCommentInputPanelClose(boolean r100) {
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
    public final /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r100) {
    }

    private a55.b getOnContextMenuItemClickListener() {
        if (this.f225165n != null) goto L10;
        ViewOwner r100 = this.f225164m;
        c r101 = this.f225152a;
        if (r101 == null) goto L7;
        z r102 = r101.f225172a;
    L8:
        this.f225165n = new a55.a(r100, r102);
        goto L10
    L7:
        r102 = null;
    L10:
        return this.f225165n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        PreviewViewModel r100 = this.f225162k;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        if (this.f225163l.needBindReleaseListener() == true) goto L11;
        onRelease();
        return;
    L11:
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r100 = this.f225162k;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f225155d;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        a55.a r102 = this.f225165n;
        if (r102 == null) goto L14;
        r102.onRelease();
        return;
    L14:
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        c r100 = this.f225152a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f225172a == null) goto L15;
        c95.c r101 = this.f225161j;
        if (r101 == null) goto L9;
        r101.onShowStart();
    L9:
        j65.a.b(this.f225162k, "PureTextView");
        DriveFilePath r102 = this.f225152a.f225172a.f225836d;
        if (r102.isEmpty() == false) goto L12;
        tt5.a.d("PureTextView", "showDocuments filePath is empty");
        return;
    L12:
        this.f225155d = Flowable.just(r102).map(new y95.b(this)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new y95.c(this), new y95.d(this));
        return;
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_preview_pure_text_view, this);
        this.f225153b = (PureTextRecyclerView) findViewById(R.id.pure_text_view);
        this.f225154c = new b(this);
        LinearLayoutManager r100 = new LinearLayoutManager(getContext());
        this.f225153b.setLayoutManager(r100);
        this.f225153b.setAdapter(this.f225154c);
        this.f225157f = new GestureDetectorCompat(getContext(), new a(this));
        this.f225153b.setOnTouchListener(new y95.a(this));
    }

    public PureTextView(Context r100) {
        super(r100);
        this.f225158g = new PointValue(false, 0);
        this.f225160i = 0;
        e();
    }

    public static boolean d(PureTextView r110) {
        c r100 = r110.f225152a;
        if (r100 == null) goto L16;
        z r101 = r100.f225172a;
        if (r101 == null) goto L16;
        String r102 = r101.f225852t;
        String r103 = r101.f225847o;
        a55.b r104 = r110.getOnContextMenuItemClickListener();
        String r111 = r110.f225166o;
        ((a55.a) r104).getClass();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L12;
        s55.a r105 = s55.a.f540731a;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        return s55.a.h(r105, "CONTENT_COPY", r102, r103, r111, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT).getAllow();
    L12:
        FileBizDomain r112 = pw4.b.d(r102);
        if (Intrinsics.areEqual(r102, "calendar") == false) goto L19;
        r112 = FileBizDomain.FileBizDomainCCM;
    L19:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r102), r112, pw4.b.f(r102), r103).f481503a;
    L16:
        return true;
    }

    @Override // c95.b
    public final void a(PointValue r100) {
        if (r100 == null) goto L4;
        this.f225158g = r100;
    L4:
        b r101 = this.f225154c;
        if (r101 == null) goto L8;
        r101.notifyDataSetChanged();
        return;
    }

    @Override // c95.b
    public final void b(int r100) {
        this.f225160i = r100;
        b r101 = this.f225154c;
        if (r101 == null) goto L6;
        r101.notifyDataSetChanged();
        return;
    }

    @Override // c95.b
    public final void c(String r100) {
        this.f225166o = r100;
        b r101 = this.f225154c;
        if (r101 == null) goto L6;
        r101.notifyDataSetChanged();
        return;
    }

    public final void f(int r100) {
        tt5.a.h("PureTextView", "onTextContextMenuItemClick()...id = " + r100);
        ((a55.a) getOnContextMenuItemClickListener()).b(r100, true, this.f225160i, getContext(), "", null);
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r100) {
        this.f225159h = r100;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r100) {
        this.f225161j = r100;
    }

    public void setPureTextOnClickListener(View.OnClickListener r100) {
        this.f225156e = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r100) {
        this.f225167p = r100;
    }

    public PureTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225158g = new PointValue(false, 0);
        this.f225160i = 0;
        e();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r100, ViewOwner r101) {
        this.f225164m = r101;
        this.f225162k = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        DriveComponentRenderVM r102 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f225163l = r102;
        r102.bindReleaseListener(this);
    }

    public PureTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225158g = new PointValue(false, 0);
        this.f225160i = 0;
        e();
    }
}
