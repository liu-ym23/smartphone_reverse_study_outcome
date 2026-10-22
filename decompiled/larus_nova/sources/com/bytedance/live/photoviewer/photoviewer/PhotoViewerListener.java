package com.bytedance.live.photoviewer.photoviewer;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/live/photoviewer/photoviewer/PhotoViewerListener;", "Ljava/io/Serializable;", LiveCommonConstants.REASON_ON_DEDTROY, "", "duration", "", "onPageSelected", "position", "onPrepared", "onRenderStart", SendEventContainerMethodParamModel.EventKinds.onShow, "activity", "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "onUserChangeProgress", "onVideoCompleted", "onVideoMuteStateChange", "isMute", "", "onVideoPause", "onVideoPlay", "onVideoRePlay", "photoviewer_release"}, k = 1, mv = {1, 1, 16})
public interface PhotoViewerListener extends Serializable {
    void onDestroy(int r100);

    void onPageSelected(int r100);

    void onPrepared();

    void onRenderStart();

    void onShow(Activity r100, View r101);

    void onUserChangeProgress();

    void onVideoCompleted();

    void onVideoMuteStateChange(boolean r100);

    void onVideoPause();

    void onVideoPlay();

    void onVideoRePlay();
}
