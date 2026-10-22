package wp0;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog f560547a;

    public c(ShelfManagementSellingPointSettingDialog r100) {
        this.f560547a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L5;
    L14:
        ShelfManagementSellingPointSettingDialog r103 = this.f560547a;
        ShelfManagementSellingPointSettingDialog.T90(r103, ((EditText) r103.S90(R.id.edit_text)).getText().toString());
        return true;
    L5:
        if (r101 == 6) goto L14;
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.getAction() == 0) goto L10;
        return false;
    L10:
        if (r102.getKeyCode() == 66) goto L14;
        return false;
    }
}
