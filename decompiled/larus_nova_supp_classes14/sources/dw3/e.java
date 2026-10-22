package dw3;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.bytedance.applet.block.permissionapplycard.view.h;
import com.bytedance.applet.block.permissionapplycard.view.p;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.AppletGrantingWidgetDelegate;
import com.larus.bmhome.chat.api.f;
import com.larus.bmhome.chat.api.r0;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.PermissionApplyBlock;
import java.util.HashMap;
import java.util.Map;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends jc8.b<a> {
    public cw3.c d;
    public final Lazy e;

    public final String c() {
        return "PermissionApplyBlockHolder";
    }

    public final void i() {
        cw3.c r0 = this.d;
        if (r0 == null) goto L11;
        PermissionApplyCardView r1 = (PermissionApplyCardView) r0.c.getValue();
        r1.getClass();
        AppletGrantingWidgetDelegate r2 = AppletGrantingWidgetDelegate.a;
        f r3 = r1.a;
        if (r3 == null) goto L8;
        r0 r4 = r3.a;
        if (r4 == null) goto L8;
    L9:
        r2.e(r4);
        r1.b = new h();
        return;
    L8:
        r4 = new r0("", "", "", "", "", "", null);
        goto L9
    }

    public e() {
        this.e = LazyKt.lazy(new c());
    }

    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((a) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [dw3.b] */
    public final void g(jc8.a r15) {
        a r16 = (a) r15;
        Intrinsics.checkNotNullParameter(r16, "blockModel");
        final kc8.b r0 = jc8.c.a(this, kc8.b.class);
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        Function1 r2 = r1.B;
        if (r2 == null) goto L9;
        r2.invoke(Boolean.FALSE);
    L9:
        String r3 = null;
        Map r4 = r16.j().getExt();     // Catch: Exception -> L16
        if (r4 == null) goto L13;
        String r5 = (String) r4.get("doubaoapp_da_params");     // Catch: Exception -> L16
    L14:
        HashMap r10 = (HashMap) ((Gson) this.e.getValue()).fromJson(r5, new d().getType());     // Catch: Exception -> L16
    L17:
        cw3.c r6 = this.d;
        if (r6 == null) goto L59;
        BlockContent r7 = ((jc8.a) r16).a.getContent();
        if (r7 == null) goto L24;
        PermissionApplyBlock r8 = r7.getPermissionApplyBlock();
        if (r8 == null) goto L24;
        String r12 = r8.permissionData;
    L25:
        String r9 = r16.j().getReplyId();
        if (r9 != null) goto L28;
        String r11 = "";
    L29:
        String r13 = r16.j().getMessageId();
        if (r13 != null) goto L32;
        String r14 = "";
    L33:
        String r17 = ((jc8.a) r16).g;
        String r18 = r16.j().getConversationId();
        if (r18 != null) goto L36;
        String r19 = "";
    L37:
        String r20 = r16.j().getSectionId();
        if (r20 != null) goto L40;
        String r21 = "";
    L41:
        String r110 = r16.j().getSenderId();
        if (r110 != null) goto L44;
        r110 = "";
    L44:
        ew3.a r111 = new ew3.a(r12, new r0(r14, r11, r17, r19, r21, r110, r10), new b(r0));
        Intrinsics.checkNotNullParameter(r111, "vmData");
        ew3.d r22 = (ew3.d) r6.b.getValue();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r111, "vmData");
        r22.a = r111;
        ew3.a r112 = ((ew3.d) r6.b.getValue()).a;
        if (r112 == null) goto L48;
        Function1<String, Boolean> r23 = r112.c;
        if (r23 == null) goto L48;
    L49:
        if (r112 == null) goto L51;
        r3 = r112.a;
    L51:
        if (r112 == null) goto L54;
        r0 r113 = r112.b;
        if (r113 == null) goto L54;
    L55:
        ((PermissionApplyCardView) r6.c.getValue()).S5(new p(r3, r113, r23), (ew3.d.a) ((ew3.d) r6.b.getValue()).b.getValue());
        return;
    L54:
        r113 = new r0("", "", "", "", "", "", null);
    L48:
        r23 = new ew3.c();
        goto L49
    L40:
        r21 = r20;
        goto L41
    L36:
        r19 = r18;
        goto L37
    L32:
        r14 = r13;
        goto L33
    L28:
        r11 = r9;
    L24:
        r12 = null;
        goto L25
    L59:
        return;
    L13:
        r5 = null;
    L16:
        r10 = null;
        goto L17
    }

    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        cw3.c r0 = new cw3.c(r3.getContext());
        this.d = r0;
        ConstraintLayout r1 = (PermissionApplyCardView) r0.c.getValue();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return super.h(r3);
    }
}
