package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.view.preview.audio.AudioView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimpleAudioPreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "SimpleAudioPreviewView";
    private final FrameLayout container;
    private AudioView mAudioView;
    private final boolean mIsVCFollow;
    private boolean mVCFollowInit;

    public static /* synthetic */ void a(SimpleAudioPreviewView r0) {
        r0.lambda$show$0();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void clean() {
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

    private /* synthetic */ void lambda$show$0() {
        trackOpenSuccess("media_player");
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public void onViewReady() {
        tt5.a.h(TAG, "onViewReady: init=" + this.mVCFollowInit + ", isVCFollow=" + this.mIsVCFollow);
        if (this.mVCFollowInit == true) goto L8;
        this.mVCFollowInit = true;
        if (this.mIsVCFollow == false) goto L9;
        ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo().setValue(new l65.d(m65.a.class, this.mAudioView));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        trackOpenStart();
        AudioView r0 = this.mAudioView;
        AudioView.d r1 = r0.r;
        if (r1 != null) goto L5;
    L7:
        this.mAudioView.post(new b0(this));
        return;
    L5:
        if (r1.a == null) goto L7;
        tt5.a.h(r0.a, "audio view show()");
        r0.u();
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.container;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public boolean isVcFollow() {
        return this.mIsVCFollow;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void onPermissionChanged(boolean r4) {
        AudioView r0 = this.mAudioView;
        tt5.a.k(r0.a, "handleMessage: MSG_PREVIEW_PAUSE");
        if (r4 == true) goto L6;
        r0.post(new g95.j(r0));
        return;
    }

    public SimpleAudioPreviewView(ViewOwner r3, ViewOwner r4, Context r5, z r6, a95.a r7) {
        super(r3, r4, r5, r6, r7);
        this.mVCFollowInit = false;
        Boolean r8 = (Boolean) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveIsVCFollowMode().getValue();
        boolean r9 = Boolean.TRUE.equals(r8);
        this.mIsVCFollow = r9;
        FrameLayout r0 = new FrameLayout(r5);
        this.container = r0;
        AudioView r10 = new AudioView(this.mContext);
        this.mAudioView = r10;
        r10.setAudioLogoDrawable(kac.a.b(2131254394));
        AudioView r11 = this.mAudioView;
        r11.k = r9;
        r11.l = this;
        r11.v(r3, r4);
        this.mAudioView.o(new AudioView.d(Uri.fromFile(z75.b.e(r6.d, this.mUserComponentAbility.b)).toString(), r6));
        r0.addView(this.mAudioView);
    }
}
