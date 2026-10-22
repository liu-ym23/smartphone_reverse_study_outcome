package com.bytedance.ee.bear.document.folder.selection;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ SelectFileBlockMediaPlugin a;

    public c(SelectFileBlockMediaPlugin r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("SelectFileBlockMediaPlugin", "saveFilesFlow fail " + ((Throwable) r3));
        Toast.showFailureText(SelectFileBlockMediaPlugin.access$getContext(this.a), 2131888966);
    }
}
