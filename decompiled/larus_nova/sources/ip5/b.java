package ip5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f495306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDProgress f495307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f495308c;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.bear_ud_dialog_progress_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L6;
        return null;
    L6:
        this.f495308c = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
        this.f495307b = (UDProgress) r100.findViewById(R.id.progress_bar);
        b(this.f495306a);
        return r100;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void b(int r100) {
        if (r100 > 0) goto L6;
        r100 = 0;
    L8:
        this.f495306a = r100;
        UDProgress r101 = this.f495307b;
        if (r101 == null) goto L11;
        r101.setProgress(r100);
    L11:
        TextView r102 = this.f495308c;
        if (r102 == null) goto L15;
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102.setText(String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(r100)}, 1)));
        return;
    L15:
        return;
    L6:
        if (r100 <= 100) goto L8;
        r100 = 100;
        goto L8
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof a) == false) goto L7;
        super.apply(r100, r101);
        this.f495306a = ((a) r100).f495305a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDProgressDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
