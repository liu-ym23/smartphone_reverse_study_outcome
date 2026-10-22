package dw1;

import android.view.View;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.SingleDrawTabViewHolder;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdk.viewmodel.i;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleDrawTabViewHolder f470305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f470306b;

    public d(SingleDrawTabViewHolder r100, e r101) {
        this.f470305a = r100;
        this.f470306b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SingleDrawViewModel r101 = this.f470305a.f123841c;
        if (r101 == null) goto L8;
        NextLiveData<i> r102 = r101.getShowLoading();
        if (r102 == null) goto L9;
        r102.setValue(new i(this.f470306b.f()));
        return;
    L9:
        return;
    }
}
