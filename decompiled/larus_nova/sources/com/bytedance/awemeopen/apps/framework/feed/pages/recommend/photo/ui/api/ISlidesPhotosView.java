package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.api;

import android.view.View;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.SlidesPhotosConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b;
import kotlin.Metadata;
import nz3.d;
import nz3.f;
import nz3.g;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\u001aH&J\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 H&J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001eH&J\n\u0010'\u001a\u0004\u0018\u00010&H&J\u0012\u0010)\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u001eH&J\b\u0010*\u001a\u00020\u0004H&J\b\u0010+\u001a\u00020\u0004H&J\b\u0010,\u001a\u00020\u0004H&J\b\u0010-\u001a\u00020\u0004H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H&J\b\u00101\u001a\u00020\u0004H&J\b\u00102\u001a\u00020\u001eH&J\b\u00103\u001a\u00020\u001eH&J\b\u00104\u001a\u00020\u001eH&J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020 H&J\b\u00105\u001a\u00020\u0004H&J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001eH&J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u001eH&¨\u0006:"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/api/ISlidesPhotosView;", "", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/SlidesPhotosConfig;", "config", "", "setSlidesPhotosConfig", "Lnz3/f;", "callback", "setSlidesProgressCallback", "Lnz3/b;", "imageGestureListener", "setImageGestureListener", "Landroid/view/View$OnClickListener;", "clickListener", "setClickListener", "Landroid/view/View$OnLongClickListener;", "longClickListener", "setLongClickListener", "Lnz3/d;", "onSwipeListener", "setOnSwipeListener", "Lnz3/g;", "touchInterceptor", "setTouchInterceptor", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/vh/b;", "getCurrentViewHolder", "", "getCurrentPosition", "getCurrentItem", "position", "", "smooth", "", "delay", "setCurrentPosition", "setCurrentPositionFullProgress", "refreshInFirstPosition", "setRefreshInFirstPosition", "Landroid/view/View;", "getProgressBar", BasicTestActionHandler.TEST_ACTION_RESET, "startLoop", "initialLoop", "restartLoop", "pauseLoop", "resumeLoop", "", "progress", "seek", "stopLoop", "isPaused", "isStoppedByDrag", "isLooping", "onDragByUser", TeaEventTrack.ACTION_DRAMA_NEXT, "handleProgressSwitch", "isPreview", "changeToFullPreview", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public interface ISlidesPhotosView {
    void changeToFullPreview(boolean r100);

    int getCurrentItem();

    int getCurrentPosition();

    b getCurrentViewHolder();

    View getProgressBar();

    void handleProgressSwitch(boolean r100);

    void initialLoop();

    boolean isLooping();

    boolean isPaused();

    boolean isStoppedByDrag();

    void onDragByUser();

    void pauseLoop();

    void reset(int r100, long r101);

    void restartLoop();

    void resumeLoop();

    void seek(float r100);

    void setClickListener(View.OnClickListener r100);

    void setCurrentPosition(int r100, boolean r101, long r102);

    void setCurrentPositionFullProgress(int r100, boolean r101);

    void setImageGestureListener(nz3.b r100);

    void setLongClickListener(View.OnLongClickListener r100);

    void setOnSwipeListener(d r100);

    void setRefreshInFirstPosition(boolean r100);

    void setSlidesPhotosConfig(SlidesPhotosConfig r100);

    void setSlidesProgressCallback(f r100);

    void setTouchInterceptor(g r100);

    void startLoop(boolean r100);

    void stopLoop();
}
