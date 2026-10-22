package com.bytedance.ee.bear.document.folder.selection;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectFileBlockMediaPlugin f219920a;

    public c(SelectFileBlockMediaPlugin r100) {
        this.f219920a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("SelectFileBlockMediaPlugin", "saveFilesFlow fail " + ((Throwable) r100));
        Toast.showFailureText(SelectFileBlockMediaPlugin.access$getContext(this.f219920a), R.string.LarkCCM_Docs_CantUploadFileBlock_Mob);
    }
}
