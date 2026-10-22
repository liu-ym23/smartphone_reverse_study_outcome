package jg5;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements ShareItemModel.a {
    public final /* synthetic */ c a;
    public final /* synthetic */ km5.a b;

    public d(c r1, km5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean a(Context r8, ShareItemModel r9, com.bytedance.ee.bear.share.g r10) {
        Intrinsics.checkNotNullParameter(r10, "shareData");
        c r1 = this.a;
        km5.a r2 = this.b;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L13
        r1.getClass();     // Catch: Throwable -> L13
        String r4 = c.g(r9, r10, r2);     // Catch: Throwable -> L13
        if (StringsKt.isBlank(r4) == false) goto L7;
        tt5.a.k("OfficeSharePanelProvider", "shareToLark, share url is blank");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L13
        c.c(r1, r8, r9, r10, r2);     // Catch: Throwable -> L13
        return true;
    L7:
        com.bytedance.ee.bear.lark.dependency.t r5 = (com.bytedance.ee.bear.lark.dependency.t) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.t.class);     // Catch: Throwable -> L13
        if (r5.Qc() == true) goto L11;
        tt5.a.h("OfficeSharePanelProvider", "shareToLark fallback to copy link, im experiment disabled");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L13
        c.c(r1, r8, r9, r10, r2);     // Catch: Throwable -> L13
        return true;
    L11:
        DocShareTextData r6 = new DocShareTextData(r10.b, r4, "Docs", true);     // Catch: Throwable -> L13
        r6.setCanAddExtraInfo(true);     // Catch: Throwable -> L13
        r5.V0(r8, r6);     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L13
    L15:
        c r11 = this.a;
        km5.a r12 = this.b;
        Throwable r13 = Result.exceptionOrNull-impl(r7);
        if (r13 == null) goto L20;
        tt5.a.e("OfficeSharePanelProvider", "shareToLark failed, fallback to copy link", r13, false);
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        c.c(r11, r8, r9, r10, r12);
        r7 = Boolean.TRUE;
    L20:
        return ((Boolean) r7).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
