package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.view.preview.audio.AudioView;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AudioPreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "AudioPreviewView";
    private final fa5.a aiSummaryDependency;
    private final FrameLayout container;
    private AudioView mAudioView;
    private final boolean mIsVCFollow;
    private boolean mVCFollowInit;

    public static /* synthetic */ void a(AudioPreviewView r0) {
        r0.lambda$show$2();
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

    private /* synthetic */ void lambda$show$2() {
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
        this.mAudioView.post(new b(this));
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

    private /* synthetic */ void lambda$new$0(Boolean r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.booleanValue() == true) goto L8;
        this.mPreviewViewModel.liveInnerForceFullScreen().setValue(Boolean.TRUE);
        this.mAudioView.m();
        return;
    }

    private /* synthetic */ void lambda$new$1(Boolean r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mPreviewViewModel.liveInnerForceFullScreen().setValue(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void onPermissionChanged(boolean r4) {
        AudioView r0 = this.mAudioView;
        tt5.a.k(r0.a, "handleMessage: MSG_PREVIEW_PAUSE");
        if (r4 == true) goto L6;
        r0.post(new g95.j(r0));
        return;
    }

    public AudioPreviewView(ViewOwner r4, ViewOwner r5, Context r6, z r7, a95.a r8) {
        super(r4, r5, r6, r7, r8);
        this.mVCFollowInit = false;
        Boolean r9 = (Boolean) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveIsVCFollowMode().getValue();
        boolean r10 = Boolean.TRUE.equals(r9);
        this.mIsVCFollow = r10;
        fa5.a r0 = (fa5.a) LarkContext.spiByDwarf(fa5.a.class);
        this.aiSummaryDependency = r0;
        FrameLayout r1 = new FrameLayout(r6);
        this.container = r1;
        this.mAudioView = new AudioView(this.mContext);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L5;
        this.mAudioView.setAudioLogoDrawable(2131254394);
    L5:
        AudioView r11 = this.mAudioView;
        r11.k = r10;
        r11.l = this;
        r11.v(r4, r5);
        this.mAudioView.o(new AudioView.d(Uri.fromFile(z75.b.e(r7.d, this.mUserComponentAbility.b)).toString(), r7));
        r1.addView(this.mAudioView);
        r0.a(this.mFileModel);
    }
}
