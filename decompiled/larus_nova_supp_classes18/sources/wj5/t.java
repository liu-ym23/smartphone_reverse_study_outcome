package wj5;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ l a;

    public t(l r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        DocObjInfo r14 = (DocObjInfo) r13;
        tt5.a.h("DocShortcutMoreInfoBehavior", "getNode ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        DocObjInfo r11 = new DocObjInfo(false, r14.isStared(), false, false, null, null, 0, 125, null);
        Intrinsics.checkNotNullParameter(r11, "docObjInfo");
        r0.h = r11;
    L5:
        l r15 = this.a;
        r15.e(r15.c());
    }
}
