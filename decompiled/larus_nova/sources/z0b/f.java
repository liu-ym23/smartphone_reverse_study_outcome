package z0b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends AbsChameleonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f569649a;

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return this.f569649a.a();
    }

    public f() {
        this.f569649a = new c();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final void onAttach(IChameleonHandlerContext r100) {
        Iterator<a> r101 = this.f569649a.f569647a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().d(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final void onDetach(IChameleonHandlerContext r100) {
        Iterator<a> r101 = this.f569649a.f569647a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().e(r100);
        goto L4
    }
}
