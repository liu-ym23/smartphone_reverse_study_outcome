package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShelfDisplayDialog f534446a;

    public a(AudienceShelfDisplayDialog r100) {
        this.f534446a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L6;
        AudienceShelfDisplayDialog r102 = this.f534446a;
        int r103 = AudienceShelfDisplayDialog.f84965v;
        ((MaxHeightRecyclerView) r102.T90(R.id.shelf_page_list)).post(new g(r102, r101));
        return;
    }
}
