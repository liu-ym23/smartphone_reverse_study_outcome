package com.ss.android.lark.widget.photo.preview.menu;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.photopicker.entity.PhotoState;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f447016a;

    public t(q r100) {
        this.f447016a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f447016a.f447006a.d().getPhotoState().getUIState().setValue(PhotoState.UIState.HIDE_LOOK);     // Catch: Throwable -> L4
        this.f447016a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
