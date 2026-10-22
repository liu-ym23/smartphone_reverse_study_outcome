package hoa;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DialogInterface.OnDismissListener f486298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f486299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f486300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f486301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f486302e;

    public final void a(int r100) {
        if (r100 != 1) goto L5;
    L31:
        TextView r101 = this.f486299b;
        if (r101 == null) goto L34;
        r101.setText(getContext().getResources().getString(R.string.larus_update_popup_downloading));
    L34:
        TextView r102 = this.f486301d;
        if (r102 == null) goto L42;
        r102.setText(getContext().getResources().getString(R.string.larus_update_popup_quit));
        return;
    L42:
        return;
    L5:
        if (r100 == 2) goto L31;
        if (r100 != 3) goto L9;
    L22:
        ProgressBar r103 = this.f486300c;
        if (r103 == null) goto L25;
        r103.setProgress(0);
    L25:
        TextView r104 = this.f486299b;
        if (r104 == null) goto L28;
        r104.setText(getContext().getResources().getString(R.string.larus_update_download_failed));
    L28:
        TextView r105 = this.f486301d;
        if (r105 == null) goto L40;
        r105.setText(getContext().getResources().getString(R.string.larus_update_popup_retry));
        return;
    L40:
        return;
    L9:
        if (r100 != 4) goto L11;
        ProgressBar r106 = this.f486300c;
        if (r106 == null) goto L16;
        r106.setProgress(100);
    L16:
        TextView r107 = this.f486299b;
        if (r107 == null) goto L19;
        r107.setText(getContext().getResources().getString(R.string.larus_update_download_completed));
    L19:
        TextView r108 = this.f486301d;
        if (r108 == null) goto L38;
        r108.setText(getContext().getResources().getString(R.string.larus_update_popup_install));
        return;
    L38:
        return;
    L11:
        if (r100 == 6) goto L22;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.obric_force_update_progress_dialog);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawableResource(R.drawable.transparent);
        r101.setLayout(-1, -2);
        r101.setGravity(17);
        r101.setWindowAnimations(R.style.update_dialog_animation);
    L5:
        setCanceledOnTouchOutside(false);
        this.f486299b = (TextView) findViewById(R.id.tvDialogTitle);
        this.f486300c = (ProgressBar) findViewById(R.id.updateProgressBar);
        TextView r102 = (TextView) findViewById(R.id.tvDialogCancel);
        this.f486301d = r102;
        if (r102 == null) goto L8;
        r102.setOnClickListener(new i(this));
    L8:
        IObricUpdateService r103 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r103 == null) goto L11;
        r103.f((coa.a) this.f486302e.getValue());
    L11:
        setOnDismissListener(new j(this));
        IObricUpdateService r104 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r104 == null) goto L14;
        int r105 = r104.l();
    L15:
        a(r105);
        return;
    L14:
        r105 = 2;
        goto L15
    }

    public m(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onDismissListener");
        super(r100);
        this.f486298a = r101;
        this.f486302e = LazyKt.lazy(new k(this));
    }
}
