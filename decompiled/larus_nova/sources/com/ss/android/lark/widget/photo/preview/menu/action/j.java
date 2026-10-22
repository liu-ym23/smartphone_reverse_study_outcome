package com.ss.android.lark.widget.photo.preview.menu.action;

import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements RxScheduledExecutor.Producer<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f446883a;

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final File produce() {
        Object r100 = this.f446883a.f446880c.getLoadModel();     // Catch: Exception -> L13
        Object r101 = this.f446883a.f446880c.getTranslateOriginModel();     // Catch: Exception -> L13
        PhotoItem r102 = this.f446883a.f446880c;     // Catch: Exception -> L13
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        if (r101 == null) goto L11;
        r100 = r101;
    L11:
        return ImageLoader.with(this.f446883a.f446878a).load(r100).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L5:
        if (r102.getTranslateProperty().isTranslated() == false) goto L7;
        r103 = true;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public j(i r100) {
        this.f446883a = r100;
    }
}
