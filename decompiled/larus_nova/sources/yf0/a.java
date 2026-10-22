package yf0;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a extends f<BaseTalkApplyListWidgetContract$View> {
    public abstract void d();

    public abstract void e();

    public abstract void f(long r100);

    public abstract void g(boolean r100, String r101, long r102, String r103, int r104, boolean r105);

    public abstract void i();

    public abstract Pair<Integer, Integer> j();

    public abstract void k(Activity r100);

    public abstract void l(int r100, Function1<? super Integer, Unit> r101);

    public a(BaseTalkApplyListWidgetContract$View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public static /* synthetic */ void h(a r100, boolean r101, String r110, long r111, String r112, int r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        r111 = 20;
    L5:
        long r102 = r111;
        if ((r114 & 8) == 0) goto L8;
        r112 = "";
    L8:
        String r103 = r112;
        if ((r114 & 16) == 0) goto L11;
        r113 = WaitingListType.UNKNOWN.ordinal();
    L11:
        r100.g(r101, r110, r102, r103, r113, false);
    }
}
