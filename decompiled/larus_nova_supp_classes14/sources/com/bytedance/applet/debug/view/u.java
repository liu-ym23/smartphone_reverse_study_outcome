package com.bytedance.applet.debug.view;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements x.a {
    @Override // com.bytedance.applet.debug.view.x.a
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // com.bytedance.applet.debug.view.x.a
    public final void onLongClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public u() {
    }

    @Override // com.bytedance.applet.debug.view.x.a
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        AppHost.Companion r6 = AppHost.a;
        FragmentActivity r0 = r6.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L15;
        Intent r1 = new Intent(r6.getApplication(), AppletDebugActivity.class);
        r1.putExtra("actionName", "showDebugInfo");
        if ((r0 instanceof j4) == false) goto L7;
        j4 r7 = (j4) r0;
    L8:
        boolean r2 = false;
        if (r7 != null) goto L11;
    L13:
        r1.putExtra("callerIsMainBotChatPage", r2);
        r1.addFlags(268435456);
        r0.startActivity(r1);
        return;
    L11:
        if (r7.s1() != true) goto L13;
        r2 = true;
        goto L13
    L7:
        r7 = null;
        goto L8
    }
}
