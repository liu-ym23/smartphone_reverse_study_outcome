package doc;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatDialog;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f469540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f469541b;

    public i(l r100, Ref.IntRef r101) {
        this.f469540a = r100;
        this.f469541b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        l r102 = this.f469540a;
        Intrinsics.checkNotNull(r100);
        r102.getClass();
        UDCheckBox r103 = null;
        if ((r100 instanceof AppCompatDialog) == false) goto L5;
        AppCompatDialog r104 = (AppCompatDialog) r100;
    L6:
        if (r104 == null) goto L8;
        r103 = (UDCheckBox) r104.findViewById(R.id.cbEMMCPDialog);
    L8:
        if (r103 == null) goto L10;
        boolean r105 = r103.isChecked();
    L11:
        if (r105 == false) goto L13;
        this.f469540a.f469547c.putBoolean("sc_clipboard_dialog_blocked", true);
    L13:
        o5c.b r106 = this.f469540a.f469545a;
        int r107 = this.f469541b.element;
        Intrinsics.checkNotNullParameter(r106, "statistics");
        JSONObject r108 = new JSONObject();
        r108.put("click", "got_it");
        r108.put(PickerReporterConstants.KEY.TARGET, "none");
        r108.put("is_no_more_remind", String.valueOf(r105));
        r108.put("times", String.valueOf(r107));
        Log.i("scs-tracker", "eventName: ".concat("scs_paste_remind_click"));
        r106.sendEvent("scs_paste_remind_click", r108);
        this.f469540a.f469547c.putInt("sc_clipboard_dialog_play_times", this.f469541b.element);
        return;
    L10:
        r105 = false;
        goto L11
    L5:
        r104 = null;
        goto L6
    }
}
