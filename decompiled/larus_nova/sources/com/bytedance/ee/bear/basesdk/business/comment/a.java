package com.bytedance.ee.bear.basesdk.business.comment;

import android.app.Activity;
import com.bytedance.ee.util.ui.j;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larus.apm.impl.protector.RunnableProtector;
import i18.d;
import j18.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f206587a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.basesdk.business.comment.a$a, reason: collision with other inner class name */
    public static final class C2977a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f206588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LKEvent f206589b;

        public b(a r100, LKEvent r101) {
            this.f206588a = r100;
            this.f206589b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f206588a.getClass();     // Catch: Throwable -> L4
            String r100 = this.f206589b.f285488a;     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // i18.d
    public final void onRelease() {
    }

    public final Activity getActivity() {
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    @Override // i18.d
    public final void addEvents(e r100) {
        throw null;
    }

    @Override // i18.d, j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j.c(new b(this, r100));
        return super.handleEvent(r100);
    }
}
