package tu;

import android.app.Activity;
import com.bytedance.android.gamecp.common.ui.i;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements uu.a {
    public d() {
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.bytedance.android.gamecp.common.ui.i, java.lang.Object] */
    @Override // uu.a
    public final void a(Activity r100, uu.b r110, String[] r111) {
        Intrinsics.checkNotNullParameter(r111, ComplianceResult.JsonKey.PERMISSIONS);
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        String r102 = null;
        r101.element = null;
        i.c r103 = new i.c();
        r103.f57005b = r100;
        r103.f57004a = 5;
        if (r100 == null) goto L5;
        String r104 = r100.getString(R.string.gamecp_permissions_dialog_title);
    L6:
        r103.f57006c = r104;
        if (r100 == null) goto L9;
        String r112 = r100.getString(R.string.gamecp_permissions_dialog_info_message, new Object[]{ru.c.a(r100, (String[]) Arrays.copyOf(r111, r111.length))});
    L10:
        r103.f57007d = r112;
        r103.f57012i = Float.valueOf(UtilityKotlinExtentionsKt.b(4));
        if (r100 == null) goto L13;
        String r113 = r100.getString(R.string.gamecp_setting);
    L14:
        a r105 = new a(r110, r101);
        i.b[] r106 = r103.f57008e;
        i.b r107 = r106[0];
        if (r107 != null) goto L17;
        r107 = new i.b();
        r106[0] = r107;
    L17:
        r107.f57001a = r113;
        r107.f57002b = r105;
        if (r100 == null) goto L20;
        r102 = r100.getString(R.string.gamecp_cancel);
    L20:
        b r108 = new b(r110, r101);
        i.b[] r114 = r103.f57008e;
        i.b r109 = r114[1];
        if (r109 != null) goto L23;
        r109 = new i.b();
        r114[1] = r109;
    L23:
        r109.f57001a = r102;
        r109.f57002b = r108;
        r103.f57009f = new c(r110);
        r103.f57010g = true;
        ?? r115 = new i(r103.f57005b, r103);
        r101.element = r115;
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r115);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L27:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        return;
    L13:
        r113 = null;
        goto L14
    L9:
        r112 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
