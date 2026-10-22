package com.bytedance.ee.bear.drive.biz.preview.viewfinder;

import android.view.View;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import q65.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/viewfinder/DriveViewFinderVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "finder", "Lcom/bytedance/ee/bear/drive/biz/preview/viewfinder/IViewFinder;", "getFinder", "()Lcom/bytedance/ee/bear/drive/biz/preview/viewfinder/IViewFinder;", "setFinder", "(Lcom/bytedance/ee/bear/drive/biz/preview/viewfinder/IViewFinder;)V", "findViewById", "T", "Landroid/view/View;", "idRes", "", "(I)Landroid/view/View;", "onCleared", "", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveViewFinderVM extends ViewModel {
    private a finder;

    public void onCleared() {
        super.onCleared();
        this.finder = null;
    }

    public DriveViewFinderVM() {
    }

    public final a getFinder() {
        return this.finder;
    }

    public final <T extends View> T findViewById(int r2) {
        a r0 = this.finder;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.a(r2);
    }

    public final void setFinder(a r1) {
        this.finder = r1;
    }
}
