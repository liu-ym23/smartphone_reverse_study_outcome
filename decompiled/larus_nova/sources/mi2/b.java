package mi2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements tk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gl2.a f514050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f514051b;

    public final View a() {
        return this.f514050a.getView();
    }

    public final void b() {
        String r100 = a.f514048a;
        a.f514049b = true;
        com.bytedance.android.ec.monitor.duration.d r101 = i.f47987a.get(a.f514048a);
        if (r101 == null) goto L5;
        r101.a("initial");
    L5:
        this.f514050a.init(this.f514051b);
        View r102 = this.f514050a.getView();
        r102.setPadding(0, 0, 0, UtilityKotlinExtentionsKt.d(12));
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = r102.getLayoutParams().height + UtilityKotlinExtentionsKt.d(12);
    }

    @Override // tk.a
    public final void onUnload() {
        this.f514050a.release();
    }

    public b(d r100, Context r101) {
        this.f514050a = r100;
        this.f514051b = r101;
    }
}
