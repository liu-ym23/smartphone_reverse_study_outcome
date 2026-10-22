package com.ss.android.lark.todo.impl.adapterhelper.viewholder;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/adapterhelper/viewholder/TaskBaseViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "payloads", "", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskBaseViewHolder extends BaseViewHolder {
    public void T3(MultiItemEntity r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    public TaskBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public void U3(MultiItemEntity r100, List<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "payloads");
        T3(r100);
    }
}
