package vw8;

import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import kotlin.jvm.internal.Intrinsics;
import lsc.m;
import org.commonmark.node.SoftLineBreak;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements m.c<SoftLineBreak> {
    public c() {
    }

    @Override // lsc.m.c
    public final void a(m r100, uvc.b r101) {
        SoftLineBreak r102 = (SoftLineBreak) r101;
        Intrinsics.checkNotNullParameter(r100, "visitor");
        Intrinsics.checkNotNullParameter(r102, OfficeSDKRequestTag.KEY_NEW_USER);
        if (r102.f551904e == null) goto L6;
        r100.b();
        return;
    }
}
