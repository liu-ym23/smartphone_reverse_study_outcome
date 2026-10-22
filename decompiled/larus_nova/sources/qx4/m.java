package qx4;

import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.ee.bear.debug.net.RequestListFragment;
import com.larus.nova.R;
import sa5.u;

/* JADX INFO: loaded from: classes16.dex */
public final class m extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestListFragment f535122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f535123b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L5;
        String r101 = r100.toString();
        if (r101 == null) goto L5;
    L6:
        RequestListFragment.U90(this.f535122a, r101);
        ImageView r102 = (ImageView) this.f535123b.findViewById(R.id.clearIcon);
        int r103 = 0;
        if (r101.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r103 = 8;
    L12:
        r102.setVisibility(r103);
        return;
    L9:
        r104 = false;
    L5:
        r101 = "";
        goto L6
    }

    public m(RequestListFragment r100, View r101) {
        this.f535122a = r100;
        this.f535123b = r101;
    }
}
