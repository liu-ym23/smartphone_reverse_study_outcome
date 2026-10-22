package z20;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f569766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f569767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f569768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f569769d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_dialog_hight_light_permission);
        setCanceledOnTouchOutside(false);
        this.f569766a = (Button) findViewById(R.id.left_button);
        this.f569767b = (Button) findViewById(R.id.right_button);
        Button r101 = this.f569766a;
        if (r101 == null) goto L5;
        r101.setOnClickListener(new a(this));
    L5:
        Button r102 = this.f569767b;
        if (r102 == null) goto L9;
        r102.setOnClickListener(new b(this));
        return;
    }

    public c(Context r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_high_light_permission_dialog);
        this.f569768c = r101;
        this.f569769d = r102;
    }
}
