package pkb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.ui.dialog.d;
import com.larus.nova.R;
import com.ss.android.lark.chat.component.ChatInitErrorComponent$showOpenChatError$1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import w4b.c;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static void a(String r100, final ChatInitErrorComponent$showOpenChatError$1.a r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        c r102 = ChatCoreModule.a();
        if (r102 != null) goto L8;
        return;
    L8:
        Context r103 = r102.getContext();
        if (r103 != null) goto L11;
        return;
    L11:
        d r104 = new d(r103);
        r104.h(r100);
        r104.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_IKnow, r101);
        DialogInterface.OnDismissListener r105 = new a(r101);
        r104.f284132c.onDismissListener(r105);
        r104.f284132c.cancelOnTouchOutside(false);
        r104.d();
    }
}
