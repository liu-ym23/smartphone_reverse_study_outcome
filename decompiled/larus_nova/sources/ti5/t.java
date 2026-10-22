package ti5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f546152a = 0;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f546153a = null;

        static {
            f546153a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f546154a = null;

        static {
            f546154a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r101 = new UDDialogBuilder(r100);
        r101.autoDismiss(true);
        r101.title(R.string.LarkCCM_Workspace_ConAccess_TransferFail_Title);
        r101.message(R.string.LarkCCM_Workspace_ConAccess_TransferFailed_Tooltip);
        r101.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_GotIt, a.f546153a);
        r101.cancelOnTouchOutside(false);
        UDDialog r102 = r101.build();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    public static void c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r102 = new UDDialogBuilder(r100);
        r102.autoDismiss(true);
        r102.title(R.string.LarkCCM_Workspace_ConAccess_TransferFail_Title);
        Intrinsics.checkNotNullParameter(r101, "value");
        r102.message(r101);
        r102.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_GotIt, b.f546154a);
        r102.cancelOnTouchOutside(false);
        UDDialog r103 = r102.build();
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }

    @JvmStatic
    public static final boolean a(JSONObject r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "ownerId");
        if (r100 == null) goto L5;
        Iterator<String> r103 = r100.keys();
    L7:
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L21;
        if (r103 == null) goto L15;
        String r105 = r103.next();
    L17:
        if (r100.optInt(r105) != r101) goto L7;
        if (TextUtils.equals(r105, r102) == false) goto L7;
        return true;
    L15:
        r105 = null;
        goto L17
    L21:
        return false;
    L9:
        if (r103.hasNext() != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r103 = null;
        goto L7
    }
}
