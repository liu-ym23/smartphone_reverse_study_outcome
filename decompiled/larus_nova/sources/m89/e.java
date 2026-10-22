package m89;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveRenameBinding;
import com.larus.drive.sdk.impl.view.operation.DriveRenameDialog;
import kotlin.Pair;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveRenameDialog f512490a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public e(DriveRenameDialog r100) {
        this.f512490a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (this.f512490a.f342248m == false) goto L5;
        return;
    L5:
        EditText r101 = null;
        if (r100 == null) goto L8;
        String r102 = r100.toString();
    L9:
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        v79.d r103 = this.f512490a.f342246k;
        if (r103 == null) goto L15;
        Pair<Boolean, String> r104 = r103.c(r102);
        if (r104 == null) goto L15;
    L17:
        if (r104.getFirst().booleanValue() == false) goto L31;
        DriveRenameDialog r105 = this.f512490a;
        r105.f342248m = true;
        LarusDialogDriveRenameBinding r106 = r105.f342239d;
        if (r106 == null) goto L21;
        r101 = r106.f341733e;
    L21:
        String r107 = r104.getSecond();
        if (r100 == null) goto L29;
        if (r101 == null) goto L25;
        int r108 = r101.getSelectionEnd();
    L26:
        r100.replace(0, r100.length(), r107);
        int r109 = Math.min(r108, r107.length());
        if (r101 == null) goto L29;
        r101.setSelection(r109);
        goto L29
    L25:
        r108 = 0;
    L29:
        this.f512490a.f342248m = false;
        return;
    L31:
        return;
    L15:
        r104 = new Pair(Boolean.FALSE, r102);
        goto L17
    L8:
        r102 = null;
        goto L9
    }
}
