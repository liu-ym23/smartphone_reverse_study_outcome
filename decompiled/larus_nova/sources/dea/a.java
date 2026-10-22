package dea;

import android.content.Context;
import android.net.Uri;
import com.bytedance.router.c;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: dea.a$a, reason: collision with other inner class name */
    public static final class C5662a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r103), "//main_page");
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        IObricUserGuide r102 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r100 == null) goto L9;
        if (r102 == null) goto L6;
        Boolean r103 = Boolean.valueOf(r102.d(r100));
    L7:
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        FLogger.f375446a.i("UserGuideInterceptor", "isInSystemWizard=" + r104);
        if (r104 == false) goto L16;
        if (r102 == null) goto L17;
        r102.e();
        return true;
    L17:
        return true;
    L16:
        return false;
    L6:
        r103 = null;
    L9:
        r104 = false;
        goto L10
    }
}
