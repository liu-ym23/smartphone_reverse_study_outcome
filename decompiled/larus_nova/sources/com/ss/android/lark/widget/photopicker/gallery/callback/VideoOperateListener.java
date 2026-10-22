package com.ss.android.lark.widget.photopicker.gallery.callback;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.video.online.c;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J*\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;", "Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "onOperate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "videoView", "Lcom/ss/android/lark/widget/photo/preview/video/online/IOnlineVideoGalleryContract$IView;", "actionID", "", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "isVideo", "", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface VideoOperateListener extends OperateListener {
    @Override // com.ss.android.lark.widget.photo.preview.callback.OperateListener
    void onOperate(Context r100, String r101, PhotoItem r102, boolean r103);

    boolean onOperate(Context r100, c r101, String r102, PhotoItem r103, boolean r104);
}
