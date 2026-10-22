package tqb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.host.ILarkLynxViewHolder;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i extends a implements ILarkLynxViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f547251g;

    public final ILarkLynxContainer g() {
        ILarkLynxContainer r100 = this.f547239e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if ((!isDestroyed()) == false) goto L12;
        int r101 = b.f547241a;
        ILarkLynxContainer r102 = b.a(this.f547251g, this.f547235a, this.f547236b, null);
        e(r102);
        if (this.f547236b.getRenderOnCreateView() == false) goto L10;
        load();
    L10:
        return r102;
    L12:
        throw new IllegalStateException("LynxViewHolder is destroyed".toString());
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void load() {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        g();
        super.load();
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void destroy() {
        super.destroy();
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxViewHolder
    public final View getView(boolean r100) {
        if (this.f547239e != null) goto L5;
        boolean r101 = true;
    L6:
        ILarkLynxContainer r102 = g();
        if (r100 == false) goto L13;
        if (r101 == true) goto L10;
    L11:
        load();
        goto L13
    L10:
        if (this.f547236b.getRenderOnCreateView() == false) goto L11;
    L13:
        return r102.getLynxView();
    L5:
        r101 = false;
        goto L6
    }

    public i(Context r100, LarkLynxHostParams r101, LarkLynxHostOptions r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "options");
        super(r101, r102);
        this.f547251g = r100;
    }
}
