package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PlaceHolderView extends FrameLayout implements m85.a {
    public static final /* synthetic */ int j = 0;
    public ConstraintLayout a;
    public ConstraintLayout b;
    public SpaceEmptyState c;
    public BearLottieView d;
    public SpaceEmptyState e;
    public SpaceEmptyState f;
    public b g;
    public DriveComponentRenderVM h;
    public long i;

    public class a implements h95.b {
        public final /* synthetic */ PlaceHolderView a;

        @Override // h95.b
        public final void a() {
            ViewGroup.LayoutParams r0 = (ConstraintLayout.LayoutParams) this.a.b.getLayoutParams();
            ((ConstraintLayout.LayoutParams) r0).verticalBias = 0.4f;
            this.a.b.setLayoutParams(r0);
            this.a.c.setImageSizeResource(2131165486);
            this.a.c.getImageView().requestLayout();
            this.a.e.setTitleTextAppearance(2131953915);
            this.a.e.setDescTextAppearance(2131953910);
            this.a.f.setVisibility(0);
        }

        @Override // h95.b
        public final void b() {
            ViewGroup.LayoutParams r0 = (ConstraintLayout.LayoutParams) this.a.b.getLayoutParams();
            ((ConstraintLayout.LayoutParams) r0).verticalBias = 0.55f;
            this.a.b.setLayoutParams(r0);
            this.a.c.setImageSizeResource(2131165487);
            this.a.c.getImageView().requestLayout();
            this.a.e.setTitleTextAppearance(2131953909);
            this.a.e.setDescTextAppearance(2131953912);
            this.a.f.setVisibility(8);
        }

        public a(PlaceHolderView r1) {
            this.a = r1;
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
        this.d.cancelAnimation();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560221, this);
        this.a = findViewById(2131370336);
        this.b = findViewById(2131370301);
        this.c = findViewById(2131370297);
        this.d = (BearLottieView) findViewById(2131370298);
        this.e = findViewById(2131370299);
        SpaceEmptyState r0 = findViewById(2131370300);
        this.f = r0;
        r0.setTag(2131370304, Boolean.TRUE);
        this.f.setPrimaryClickListener(new q(this));
        this.f.setSecondaryClickListener(new r(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public PlaceHolderView(Context r1) {
        super(r1);
        a();
    }

    public void setBtnOpenExternalEnable(boolean r2) {
        this.f.setPrimaryActionEnabled(r2);
    }

    public void setBtnOpenExternalVisibility(boolean r3) {
        this.f.showDescription(!r3);
        this.f.showPrimaryAction(r3);
    }

    public void setDescText(String r2) {
        this.e.setDesc(r2);
    }

    public void setImagePlaceHolder(int r3) {
        this.d.setVisibility(8);
        this.c.setImageRes(Integer.valueOf(kac.a.b(r3)));
    }

    public void setLottiePlaceHolder(int r3) {
        this.d.setVisibility(0);
        this.c.getImageView().setVisibility(8);
        this.d.setAnimation(r3);
        this.d.playAnimation();
    }

    public void setNoExportPermissionTips(String r2) {
        this.f.setDesc(r2);
    }

    public void setNoExportPermissionTipsVisibility(boolean r2) {
        this.f.showDescription(r2);
    }

    public void setOnBtnOpenExternalClickListener(b r1) {
        this.g = r1;
    }

    public void setOpenExternalVisibility(boolean r2) {
        this.f.showPrimaryAction(r2);
    }

    public void setPrimaryText(String r2) {
        this.f.setPrimaryText(r2);
    }

    public void setRootLayoutColor(int r3) {
        this.a.setBackgroundColor(getResources().getColor(r3));
    }

    public void setSecondaryClickText(String r2) {
        this.f.setSecondaryText(r2);
    }

    public void setSizeInBytes(long r4) {
        if (r4 <= 0) goto L5;
        getContext();
        String r5 = com.bytedance.ee.util.io.a.a(r4);
    L6:
        this.e.setDesc(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void setTipsText(SpannableString r2) {
        this.e.setTitle(r2);
    }

    public void setTipsText(String r2) {
        this.e.setTitle(r2);
    }

    public PlaceHolderView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public final void b(ViewOwner r2, ViewOwner r3) {
        DriveComponentRenderVM r4 = (DriveComponentRenderVM) r2.viewModel(DriveComponentRenderVM.class);
        this.h = r4;
        r4.bindReleaseListener(this);
        new DriveBlockViewSwitchManager(r3).a(new a(this));
    }

    public PlaceHolderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
