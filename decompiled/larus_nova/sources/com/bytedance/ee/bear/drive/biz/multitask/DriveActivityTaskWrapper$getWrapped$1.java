package com.bytedance.ee.bear.drive.biz.multitask;

import com.ss.android.lark.multitask.task.ActivityTask;
import kotlin.Metadata;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016¨\u0006\u0015"}, d2 = {"com/bytedance/ee/bear/drive/biz/multitask/DriveActivityTaskWrapper$getWrapped$1", "Lcom/ss/android/lark/multitask/task/ActivityTask;", "getIconFactory", "Lcom/ss/android/lark/multitask/task/Task$IconFactory;", "getTitle", "", "onSaveInstanceState", "", "outState", "Landroid/os/Bundle;", "getDrawableIconFactory", "Lcom/ss/android/lark/multitask/task/DrawableIconFactory;", "getDriveName", "getDriveUrl", "", "getFileListString", "openEntities", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/BaseOpenEntity;", "getType", "getIdentifier", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveActivityTaskWrapper$getWrapped$1 extends ActivityTask {
    @Override // com.ss.android.lark.multitask.task.ActivityTask, com.ss.android.lark.multitask.task.Task
    public String getType() {
        return e.f541301l.getType();
    }

    @Override // com.ss.android.lark.multitask.task.ActivityTask, com.ss.android.lark.multitask.task.Task
    public String getIdentifier() {
        throw null;
    }

    @Override // com.ss.android.lark.multitask.task.ActivityTask, com.ss.android.lark.multitask.task.Task
    public final CharSequence getTitle() {
        throw null;
    }
}
