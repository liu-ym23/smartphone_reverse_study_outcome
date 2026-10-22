package com.ss.android.ainote;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f407130a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f407131a;

        public a(Context r100) {
            this.f407131a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context r100 = this.f407131a;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
            UDToast.show(r100, this.f407131a.getString(R.string.View_PersonalNotes_UploadImageLimitReached_Error), R.drawable.ud_icon_more_close_outlined);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f407130a = new Handler(Looper.getMainLooper());
    }

    public static void a(Context r100) {
        if (r100 != null) goto L5;
        r100 = LarkContext.getApplication();
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        Intrinsics.checkNotNull(r100);
        UDToast.show(r100, r100.getString(R.string.View_PersonalNotes_UploadImageLimitReached_Error), R.drawable.ud_icon_more_close_outlined);
        return;
    L7:
        f407130a.post(new a(r100));
    }
}
