package com.ss.android.lark.widget.photo.preview.callback;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "Ljava/io/Serializable;", "onOperate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "actionID", "", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "isVideo", "", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OperateListener extends Serializable {
    void onOperate(Context r100, String r101, PhotoItem r102, boolean r103);
}
