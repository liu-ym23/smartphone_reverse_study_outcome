package com.bytedance.lark.rustclient.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.log.Log;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b0 {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (TextUtils.isEmpty(r100) == true) goto L35;
        int r101 = r100.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L5:
        if (r102 > r101) goto L21;
        if (r103 == true) goto L8;
        int r104 = r102;
    L10:
        if (Intrinsics.compare(r100.charAt(r104), 32) > 0) goto L12;
        boolean r105 = true;
    L13:
        if (r103 == false) goto L14;
        if (r105 == false) goto L21;
        r101 = r101 - 1;
        goto L5
    L14:
        if (r105 == false) goto L15;
        r102 = r102 + 1;
        goto L5
    L15:
        r103 = true;
        goto L5
    L12:
        r105 = false;
        goto L13
    L8:
        r104 = r101;
    L21:
        if (Intrinsics.areEqual(r100.subSequence(r102, r101 + 1).toString(), "0") == true) goto L36;
        return false;
    L36:
        return true;
    L35:
        return true;
    }

    public static final void b(String r100, boolean r101, Command r102, String r103, String r104, String r105, boolean r106) {
        if (Intrinsics.areEqual(r102, Command.MAKE_USER_ONLINE) == false) goto L6;
        r100 = "make_user_online";
    L6:
        if (Intrinsics.areEqual(r102, Command.MAKE_USER_OFFLINE) == false) goto L9;
        r100 = "make_user_offline";
    L9:
        if (Intrinsics.areEqual(r102, Command.PASS_THROUGH_PUSH) == false) goto L11;
        r100 = "passthrough_push_c";
    L11:
        StringBuilder r107 = new StringBuilder("[user_id_verification][android][");
        r107.append(r100.toLowerCase(Locale.getDefault()));
        r107.append("][is_err: ");
        r107.append(r101);
        r107.append("][intercepted: ");
        if (TextUtils.equals(r104, r105) == true) goto L15;
        if (r106 == false) goto L15;
        boolean r108 = true;
    L16:
        r107.append(r108);
        r107.append("] (cmd: ");
        r107.append(r102.getName());
        r107.append(", context_id: ");
        r107.append(r103);
        r107.append(", user_id: ");
        r107.append(r105);
        r107.append(", verify_user_id: ");
        r107.append(r104);
        r107.append(", match: ");
        r107.append(TextUtils.equals(r104, r105));
        r107.append(", requireVerify: ");
        r107.append(r106);
        r107.append(')');
        Log.w("sdk", r107.toString());
        return;
    L15:
        r108 = false;
        goto L16
    }
}
