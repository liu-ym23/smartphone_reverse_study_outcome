package ti5;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ TransferApplyFragment a;

    public f(TransferApplyFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        Toast.cancelLoading();
        if (ax4.d.b((Throwable) r13, 10053) == false) goto L46;
        TransferApplyFragment r14 = this.a;
        int r0 = TransferApplyFragment.q;
        Context r1 = r14.getContext();
        if (r1 == null) goto L50;
        String r2 = UIHelper.mustacheFormat(2131889327, "username", r14.h.getOwnerName());
        gp5.a r3 = (gp5.a) ((gp5.a) new gp5.a(r1).cancelable(false)).cancelOnTouchOutside(false);
        r3.o = false;
        String r5 = r1.getString(2131889323);
        Intrinsics.checkNotNullParameter(r5, "value");
        r3.j = r5;
        Intrinsics.checkNotNull(r2);
        gp5.a r4 = (gp5.a) ((gp5.a) r3.title(r2)).message(r1.getString(2131889313));
        Context r6 = r14.getContext();
        String r7 = "";
        if (r6 != null) goto L10;
        String r8 = "";
    L29:
        r4.getClass();
        if (r8 == null) goto L33;
        r7 = r8;
    L33:
        r4.v = r7;
        gp5.a r9 = (gp5.a) ((gp5.a) r4.titleGravity(17)).messageGravity(8388611);
        r9.f = Integer.MAX_VALUE;
        r9.p = true;
        r9.q = new q(r14);
        r9.w = false;
        ViewGroup.LayoutParams r10 = null;
        r9.b(r1.getString(2131889326), null);
        r9.c();
        r r11 = new r(r1, r14);
        Intrinsics.checkNotNullParameter(r11, "value");
        r9.r = r11;
        r9.show();
        UDEditText r15 = r9.g();
        if (r15 == null) goto L36;
        r10 = r15.getLayoutParams();
    L36:
        if (r10 == null) goto L38;
        r10.height = com.bytedance.ee.util.ui.n.d(86);
    L38:
        if (r15 == null) goto L40;
        r15.clearFocus();
    L40:
        if (r15 == null) goto L42;
        r15.setGravity(48);
    L42:
        if (r15 == null) goto L44;
        r15.setSingleLine(false);
    L44:
        if (r15 == null) goto L48;
        r15.setLayoutParams(r10);
        return;
    L48:
        return;
    L10:
        int r12 = r14.h.getType();
        if (r12 == 0) goto L25;
        if (r12 != 28) goto L15;
        r8 = UIHelper.mustacheFormat(2131889110, "collaborators", r14.h.getOwnerName()) + UIHelper.mustacheFormat(2131889318, "doc_type", r6.getString(2131887343));
        goto L29
    L15:
        if (r14.k == false) goto L17;
        String r16 = UIHelper.mustacheFormat(2131889315, "username", r14.h.getOwnerName());
    L18:
        Intrinsics.checkNotNull(r16);
        if (sbb.g.b(r14.h.getType()) == false) goto L21;
        String r17 = r6.getString(2131888912);
    L22:
        Intrinsics.checkNotNull(r17);
        r8 = r16 + UIHelper.mustacheFormat(2131889318, "doc_type", r17);
        goto L29
    L21:
        r17 = r6.getString(2131888003);
        goto L22
    L17:
        r16 = UIHelper.mustacheFormat(2131887312, "username", r14.h.getOwnerName());
        goto L18
    L25:
        if (r14.k == false) goto L27;
        String r18 = UIHelper.mustacheFormat(2131889316, "username", r14.h.getOwnerName());
    L28:
        Intrinsics.checkNotNull(r18);
        r8 = r18 + UIHelper.mustacheFormat(2131889318, "doc_type", r6.getString(2131888004));
        goto L29
    L27:
        r18 = UIHelper.mustacheFormat(2131887311, "username", r14.h.getOwnerName());
        goto L28
    L50:
        return;
    L46:
        TransferApplyFragment.aa0(this.a);
    }
}
