package ti5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyAdapter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyAdapter f546109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f546110b;

    public b(TransferApplyAdapter r100, d r101) {
        this.f546109a = r100;
        this.f546110b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Iterator<T> r101 = this.f546109a.getData().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).f546114b = false;
        goto L4
    L6:
        this.f546110b.f546114b = true;
        this.f546109a.notifyDataSetChanged();
        a r102 = this.f546109a.f234284a;
        if (r102 == null) goto L11;
        r102.b(this.f546110b);
        return;
    }
}
