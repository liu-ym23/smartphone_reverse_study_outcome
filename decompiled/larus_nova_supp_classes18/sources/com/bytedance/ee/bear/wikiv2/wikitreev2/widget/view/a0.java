package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ t b;

    public a0(Context r1, t r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        MoveToSpaceStatusPuller.Result r4 = (MoveToSpaceStatusPuller.Result) r3;
        tt5.a.h("WikiItemMoreViewDelegate", "moveToSpace()...success, task_id = " + r4.task_id + ", status = " + r4.status);
        Toast.cancelLoading();
        int r5 = r4.status;
        if (r5 != MoveToSpaceStatusPuller.MoveToSpaceStatus.MOVE_DONE.getStatus()) goto L6;
        Toast.showSuccessText(this.a, this.b.d.getString(2131887494));
        return;
    L6:
        if (r5 != MoveToSpaceStatusPuller.MoveToSpaceStatus.MOVE_FAILED.getStatus()) goto L10;
        Toast.showFailureText(this.a, this.b.d.getString(2131887932));
        return;
    }
}
