package ti5;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyAdapter f546111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f546112b;

    public c(TransferApplyAdapter r100, TextView r101) {
        this.f546111a = r100;
        this.f546112b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f546111a.f234284a;
        if (r101 == null) goto L6;
        TextView r102 = this.f546112b;
        Intrinsics.checkNotNull(r102);
        r101.a(r102);
        return;
    }
}
