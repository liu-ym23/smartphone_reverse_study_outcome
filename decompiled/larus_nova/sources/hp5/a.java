package hp5;

import android.content.Context;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f486430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f486431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f486432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f486433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f486434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDCheckBox.c f486435f;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f486431b = "";
        this.f486432c = "";
        this.f486433d = -1;
        this.f486434e = true;
        controller(new e(r100));
        marginInDp(36);
    }
}
