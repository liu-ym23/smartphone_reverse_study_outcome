package i39;

import android.content.Context;
import android.net.Uri;
import com.larus.doc.api.IDocService;
import com.larus.utils.k0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {
    public a() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual("//flow/doc_ai_edit_back", k0.a(r103));
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        IDocService r102 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r102 == null) goto L7;
        r102.X9();
        return true;
    L7:
        return true;
    }
}
