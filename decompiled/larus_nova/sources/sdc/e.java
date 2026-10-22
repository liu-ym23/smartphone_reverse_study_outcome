package sdc;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import rdc.j;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f541531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f541532b;

    public e(t r100, d r101) {
        this.f541531a = r100;
        this.f541532b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        t r101 = this.f541531a;
        boolean r102 = r101.f537388m;
        boolean r103 = r101.f537389n;
        int r104 = R.string.Lark_Legacy_PickerJustOneVideoTip;
        if (r103 == false) goto L15;
        AppCompatCheckBox r105 = this.f541532b.f541528e;
        if (r105 == null) goto L7;
        r105.setChecked(false);
    L7:
        Context r106 = this.f541532b.f541524a;
        t r107 = this.f541531a;
        if (r107.f537391p == true) goto L10;
    L12:
        r104 = R.string.Lark_Legacy_SelectPhotosOrVideosError;
    L13:
        LKUIToast.show(r106, r104);
        return;
    L10:
        if (r107.a() == false) goto L12;
    L15:
        if (r101.f537390o == false) goto L37;
        AppCompatCheckBox r108 = this.f541532b.f541528e;
        if (r108 == null) goto L19;
        r108.setChecked(false);
    L19:
        s r109 = this.f541532b.f541525b;
        int r110 = r109.f447557b;
        if (r110 == 2) goto L24;
        if (r110 == 1) goto L24;
        int r111 = R.string.Lark_Legacy_PickerOverMaxCountTips;
        String r112 = DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT;
    L26:
        if (r109.f447561f == false) goto L32;
        t r113 = this.f541531a;
        if (r113.f537391p == false) goto L32;
        if (r113.a() == false) goto L32;
        LKUIToast.show(this.f541532b.f541524a, UIHelper.getString(R.string.Lark_Legacy_PickerJustOneVideoTip));
        return;
    L32:
        d r114 = this.f541532b;
        Context r115 = r114.f541524a;
        s r116 = r114.f541525b;
        if (r116.f447563h == false) goto L35;
        int r117 = r116.f447559d;
    L36:
        LKUIToast.show(r115, UIHelper.mustacheFormat(r111, r112, String.valueOf(r117)));
        return;
    L35:
        r117 = r116.f447558c;
    L24:
        r111 = R.string.Lark_Legacy_Max9Items;
        r112 = "number";
        goto L26
    L37:
        ((j) this.f541532b.f541526c).a(r101, !r102, r101.a());
    }
}
