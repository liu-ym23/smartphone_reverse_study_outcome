package com.ss.android.lark.photoeditor.impl.ui;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;

/* JADX INFO: loaded from: classes37.dex */
public final class l implements jkc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f438587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m.a f438588b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f438589a;

        public final void a() {
            if (UIUtils.isActivityRunning(this.f438589a.f438588b.f438593c.f438590a.f438596a) == true) goto L5;
            return;
        L5:
            l r100 = this.f438589a;
            o.a r101 = r100.f438588b.f438593c.f438590a.f438601f;
            if (r101 == null) goto L9;
            PhotoEditorFragment.b r102 = (PhotoEditorFragment.b) r101;
            r102.a(r100.f438587a.getAbsolutePath(), new Pair(Integer.valueOf(this.f438589a.f438588b.f438591a.getWidth()), Integer.valueOf(this.f438589a.f438588b.f438591a.getHeight())), this.f438589a.f438588b.f438592b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r100) {
            this.f438589a = r100;
        }
    }

    @Override // jkc.b
    public final void a(PolarisFileWrapper r100) {
        UICallbackExecutor.execute(new k(this, r100));
    }

    @Override // jkc.b
    public final void b(DecryptException r100) {
        Log.e("PhotoEditorPresenter", "occurs decrypt error: " + r100.getMessage());
        o r101 = this.f438588b.f438593c.f438590a;
        if ("from_preview".equals(r101.f438598c) == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        UICallbackExecutor.execute(new a(this));
        return;
    L5:
        if ("from_screenshot_forward_preview".equals(r101.f438598c) == true) goto L8;
        r102 = false;
        goto L9
    }

    public l(m.a r100, File r101) {
        this.f438588b = r100;
        this.f438587a = r101;
    }
}
