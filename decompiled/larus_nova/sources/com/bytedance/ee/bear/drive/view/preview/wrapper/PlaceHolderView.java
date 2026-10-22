package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class PlaceHolderView extends FrameLayout implements m85.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f225733j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f225734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f225735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpaceEmptyState f225736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BearLottieView f225737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SpaceEmptyState f225738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceEmptyState f225739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f225740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DriveComponentRenderVM f225741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f225742i;

    public class a implements h95.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlaceHolderView f225743a;

        @Override // h95.b
        public final void a() {
            ConstraintLayout.LayoutParams r100 = (ConstraintLayout.LayoutParams) this.f225743a.f225735b.getLayoutParams();
            r100.verticalBias = 0.4f;
            this.f225743a.f225735b.setLayoutParams(r100);
            this.f225743a.f225736c.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
            this.f225743a.f225736c.getImageView().requestLayout();
            this.f225743a.f225738e.setTitleTextAppearance(R.style.UDText_Headline);
            this.f225743a.f225738e.setDescTextAppearance(R.style.UDText_Body2);
            this.f225743a.f225739f.setVisibility(0);
        }

        @Override // h95.b
        public final void b() {
            ConstraintLayout.LayoutParams r100 = (ConstraintLayout.LayoutParams) this.f225743a.f225735b.getLayoutParams();
            r100.verticalBias = 0.55f;
            this.f225743a.f225735b.setLayoutParams(r100);
            this.f225743a.f225736c.setImageSizeResource(R.dimen.ccm_emptystate_image_size_small);
            this.f225743a.f225736c.getImageView().requestLayout();
            this.f225743a.f225738e.setTitleTextAppearance(R.style.UDText_Body1);
            this.f225743a.f225738e.setDescTextAppearance(R.style.UDText_Caption1);
            this.f225743a.f225739f.setVisibility(8);
        }

        public a(PlaceHolderView r100) {
            this.f225743a = r100;
        }
    }

    public interface b {
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "PlaceHolderView";
    }

    @Override // m85.a
    public final void onRelease() {
        this.f225737d.cancelAnimation();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_preview_unsupport_view, this);
        this.f225734a = (ConstraintLayout) findViewById(R.id.drive_unsupport_root_view);
        this.f225735b = (ConstraintLayout) findViewById(R.id.drive_place_holder_root_container);
        this.f225736c = (SpaceEmptyState) findViewById(R.id.drive_place_holder_icon);
        this.f225737d = (BearLottieView) findViewById(R.id.drive_place_holder_lottie_view);
        this.f225738e = (SpaceEmptyState) findViewById(R.id.drive_place_holder_message);
        SpaceEmptyState r100 = (SpaceEmptyState) findViewById(R.id.drive_place_holder_open_external);
        this.f225739f = r100;
        r100.setTag(R.id.drive_preview_block_fun_location_tag, Boolean.TRUE);
        this.f225739f.setPrimaryClickListener(new q(this));
        this.f225739f.setSecondaryClickListener(new r(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225741h.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public PlaceHolderView(Context r100) {
        super(r100);
        a();
    }

    public void setBtnOpenExternalEnable(boolean r100) {
        this.f225739f.setPrimaryActionEnabled(r100);
    }

    public void setBtnOpenExternalVisibility(boolean r100) {
        this.f225739f.showDescription(!r100);
        this.f225739f.showPrimaryAction(r100);
    }

    public void setDescText(String r100) {
        this.f225738e.setDesc(r100);
    }

    public void setImagePlaceHolder(int r100) {
        this.f225737d.setVisibility(8);
        this.f225736c.setImageRes(Integer.valueOf(kac.a.b(r100)));
    }

    public void setLottiePlaceHolder(int r100) {
        this.f225737d.setVisibility(0);
        this.f225736c.getImageView().setVisibility(8);
        this.f225737d.setAnimation(r100);
        this.f225737d.playAnimation();
    }

    public void setNoExportPermissionTips(String r100) {
        this.f225739f.setDesc(r100);
    }

    public void setNoExportPermissionTipsVisibility(boolean r100) {
        this.f225739f.showDescription(r100);
    }

    public void setOnBtnOpenExternalClickListener(b r100) {
        this.f225740g = r100;
    }

    public void setOpenExternalVisibility(boolean r100) {
        this.f225739f.showPrimaryAction(r100);
    }

    public void setPrimaryText(String r100) {
        this.f225739f.setPrimaryText(r100);
    }

    public void setRootLayoutColor(int r100) {
        this.f225734a.setBackgroundColor(getResources().getColor(r100));
    }

    public void setSecondaryClickText(String r100) {
        this.f225739f.setSecondaryText(r100);
    }

    public void setSizeInBytes(long r100) {
        if (r100 <= 0) goto L5;
        getContext();
        String r101 = com.bytedance.ee.util.io.a.a(r100);
    L6:
        this.f225738e.setDesc(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void setTipsText(SpannableString r100) {
        this.f225738e.setTitle(r100);
    }

    public void setTipsText(String r100) {
        this.f225738e.setTitle(r100);
    }

    public PlaceHolderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public final void b(ViewOwner r100, ViewOwner r101) {
        DriveComponentRenderVM r102 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f225741h = r102;
        r102.bindReleaseListener(this);
        new DriveBlockViewSwitchManager(r101).a(new a(this));
    }

    public PlaceHolderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
