package omb;

import android.content.Context;
import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.bytedance.lark.base.open.pkm.j;
import com.larksuite.component.card.cardcontainer.IUniversalCardJsService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class g implements IUniversalCardJsService {
    @Inject
    public g() {
    }

    @Override // com.larksuite.component.card.cardcontainer.IUniversalCardJsService
    public final String getJsBundleFile(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return a.f(r100);
    }

    @Override // com.larksuite.component.card.cardcontainer.IUniversalCardJsService
    public final String getJsBundleVersion(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = a.f524318d;
        if (r101 != null) goto L6;
        return "unknown";
    L6:
        return r101;
    }

    @Override // com.larksuite.component.card.cardcontainer.IUniversalCardJsService
    public final void initCardEnv(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ee6.f.a();
    }

    @Override // com.larksuite.component.card.cardcontainer.IUniversalCardJsService
    public final byte[] loadTemplate(Context r100, File r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PkmBizType r102 = a.f524315a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        j r103 = a.f524316b;
        if (r103 != null) goto L8;
        a.e(r100);
        r103 = a.f524316b;
        if (r103 != null) goto L8;
        Log.w("CardTemplatePkmManager", "ensureManager: pkmManager still null");
    L8:
        if (r103 == null) goto L23;
        String r104 = a.f(r100);
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L23;
        return r103.g(a.f524315a);
    L21:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "localTemplate failed. path=" + r104, e);
        goto L23
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L23:
        return null;
    }
}
