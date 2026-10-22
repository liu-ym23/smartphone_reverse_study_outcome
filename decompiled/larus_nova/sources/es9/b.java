package es9;

import android.app.Activity;
import com.bytedance.praisedialoglib.manager.h;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ds9.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements x57.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473791a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f473791a = r100;
    }

    @Override // x57.b
    public final void a(h.a r100) {
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        f r102 = new f(r101, this.f473791a);
        r102.f469892k = new a(r100);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }
}
