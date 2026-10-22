package wj5;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560011a;

    public t(l r100) {
        this.f560011a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        DocObjInfo r111 = (DocObjInfo) r110;
        tt5.a.h("DocShortcutMoreInfoBehavior", "getNode ok. ");
        oj5.a r100 = this.f560011a.c();
        if (r100 == null) goto L5;
        DocObjInfo r112 = new DocObjInfo(false, r111.isStared(), false, false, null, null, 0, 125, null);
        Intrinsics.checkNotNullParameter(r112, "docObjInfo");
        r100.f523537h = r112;
    L5:
        l r113 = this.f560011a;
        r113.e(r113.c());
    }
}
