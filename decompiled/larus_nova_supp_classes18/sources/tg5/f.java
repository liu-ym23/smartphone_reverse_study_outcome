package tg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends t {
    public final /* synthetic */ b c;

    public f(b r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r18) {
        if (this.c.x0() == false) goto L36;
        if (this.c.h() == false) goto L36;
        if (this.c.b8() == false) goto L36;
        b r1 = this.c;
        Iterator<UserInfo> r12 = r1.e().iterator();
        String r15 = "";
        int r14 = 0;
    L10:
        if (r12.hasNext() == false) goto L22;
        UserInfo r4 = r12.next();
        if (r4.getOwnerType() != 18) goto L10;
        r14 = r14 + 1;
        if (r15.length() != 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L10;
        r15 = r4.getDisplayName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c());
        if (r15 != null) goto L10;
        r15 = "";
        goto L10
    L16:
        r7 = false;
        goto L17
    L22:
        if (r14 != 1) goto L24;
        String r5 = xo5.a.c(r1.a, 2131887165, "department", r15);
    L25:
        Context r8 = r1.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        UDDialogBuilder r3 = new UDDialogBuilder(r8);
        r3.autoDismiss(true);
        r3.title(2131887166);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "value");
        r3.message(r5);
        r3.addActionButton(2131391777, 2131887163, new k(r1));
        r3.addActionButton(2131391778, 2131887716, l.a);
        UDDialog r2 = r3.build();
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r2);
    L30:
        String r6 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r9 = new JSONObject();
        String r10 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r11 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L33;
        String r13 = ThumbGlideUrl.SOURCE_VC;
    L34:
        com.bytedance.ee.bear.middleground.permission.c.a(r9, r10, r11, r13, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_send_notice_view", r9);
        return;
    L33:
        r13 = "none";
        goto L34
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L29:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L30
    L24:
        HashMap r16 = new HashMap();
        r16.put("department", r15);
        r16.put("count", String.valueOf(r14));
        r5 = xo5.a.d(r1.a, 2131887164, r16);
    L36:
        if (this.c.x0() == false) goto L55;
        Iterator<UserInfo> r17 = this.c.e().iterator();
    L39:
        if (r17.hasNext() == false) goto L45;
        UserInfo r19 = r17.next();
        if (r19.getOwnerType() != 2) goto L39;
        if (r19.getUserCount() < 500) goto L39;
        boolean r20 = true;
    L46:
        if (r20 == false) goto L55;
        if (this.c.b8() == false) goto L55;
        b r21 = this.c;
        r21.getClass();
        Context r22 = r21.a;
        Intrinsics.checkNotNullParameter(r22, "context");
        UDDialogBuilder r23 = new UDDialogBuilder(r22);
        r23.autoDismiss(true);
        r23.title(2131887166);
        r23.message(2131887162);
        r23.addActionButton(2131391777, 2131887163, new m(r21));
        r23.addActionButton(2131391778, 2131887716, null);
        UDDialog r24 = r23.build();
        if (DialogLancet.shouldBlockDialogShow(r24) == false) goto L85;
        DialogLancet.handleBlockedDialogShow(r24);
        return;
    L85:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L83
    L53:
        DialogLancet.beforeDialogShow(r24);
        r24.show();
        DialogLancet.afterDialogShow(r24);
        return;
    L45:
        r20 = false;
    L55:
        if (this.c.k() == false) goto L78;
        b r25 = this.c;
        if (r25.j0() == false) goto L70;
        if (r25.b.findViewById(2131367732).isChecked() == false) goto L70;
        if (r25.s() != 1) goto L63;
        String r26 = xo5.a.c(r25.a, 2131889088, "email", r25.C());
    L64:
        Context r27 = r25.a;
        Intrinsics.checkNotNullParameter(r27, "context");
        UDDialogBuilder r28 = new UDDialogBuilder(r27);
        r28.autoDismiss(true);
        r28.title(2131889098);
        Intrinsics.checkNotNull(r26);
        Intrinsics.checkNotNullParameter(r26, "value");
        r28.message(r26);
        r28.messageGravity(8388611);
        r28.addActionButton(2131391777, 2131889093, new i(r25));
        r28.addActionButton(2131391778, 2131887716, null);
        UDDialog r29 = r28.build();
        if (DialogLancet.shouldBlockDialogShow(r29) == false) goto L89;
        DialogLancet.handleBlockedDialogShow(r29);
        return;
    L89:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L68:
        DialogLancet.beforeDialogShow(r29);
        r29.show();
        DialogLancet.afterDialogShow(r29);
        return;
    L63:
        r26 = xo5.a.d(r25.a, 2131889099, r25.w());
    L70:
        if (r25.s() != 1) goto L72;
        String r30 = xo5.a.c(r25.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r25.c, 2131888866, 2131889087), "email", r25.C());
    L77:
        fp5.a r31 = (fp5.a) new fp5.a(r25.a).title(2131889092);
        Intrinsics.checkNotNull(r30);
        fp5.a r32 = (fp5.a) ((fp5.a) r31.message(r30)).messageGravity(8388611);
        r32.b(r25.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r25.c, 2131888869, 2131889091)));
        r32.e = false;
        ((fp5.a) ((fp5.a) r32.addActionButton(2131391777, 2131889093, new j(r25))).addActionButton(2131391778, 2131889090, null)).show();
        return;
    L72:
        Context r33 = r25.a;
        int r34 = r25.c;
        if (r25.s() != 1) goto L75;
        int r35 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r34, 2131888866, 2131889087);
    L76:
        r30 = xo5.a.d(r33, r35, r25.w());
        goto L77
    L75:
        r35 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r34, 2131888867, 2131889094);
        goto L76
    L78:
        p.a r36 = this.c.d;
        if (r36 == null) goto L112;
        r36.W2();
        return;
    }
}
