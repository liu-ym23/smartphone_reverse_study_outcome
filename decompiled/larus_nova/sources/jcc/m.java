package jcc;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.halfscreen.PhotoPickerParam;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f498188a;

    public m(LarkPhotoPickerView r100) {
        this.f498188a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r310) {
        LarkPhotoPickerView r100 = this.f498188a;
        LarkPhotoPickerView.d r101 = r100.H;
        new ArrayList();
        String r110 = UIHelper.getString(R.string.Lark_Legacy_PickerConfirm);
        int r102 = r100.f445900p;
        boolean r111 = r100.S;
        boolean r112 = r100.I;
        boolean r210 = !r100.R;
        boolean r113 = r100.f445884J;
        boolean r103 = r100.f445904t;
        boolean r104 = r100.f445903s;
        r101.d(new PhotoPickerParam(false, false, true, r102, r100.f445901q, r111, 4, r112, r113, false, new ArrayList(r100.f445898n.f447457b), r104, true, 0, r110, false, r103, r210, true, false, r100.M, r100.K, r100.L, false, null));
    }
}
