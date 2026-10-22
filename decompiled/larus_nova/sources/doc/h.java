package doc;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatDialog;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f469539a;

    public h(l r100) {
        this.f469539a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        l r102 = this.f469539a;
        Intrinsics.checkNotNull(r100);
        r102.getClass();
        UDCheckBox r103 = null;
        if ((r100 instanceof AppCompatDialog) == false) goto L5;
        AppCompatDialog r104 = (AppCompatDialog) r100;
    L6:
        if (r104 == null) goto L8;
        r103 = (UDCheckBox) r104.findViewById(R.id.cbEMMCPDialog);
    L8:
        if (r103 != null) goto L10;
        return;
    L10:
        r103.setChecked(!r103.isChecked());
        return;
    L5:
        r104 = null;
        goto L6
    }
}
