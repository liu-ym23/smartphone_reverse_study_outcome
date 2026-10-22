package gg5;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ MessageConfig c;

    public c(b r1, TextView r2, MessageConfig r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(View r12) {
        b r13 = this.a;
        Context r0 = this.b.getContext();
        MessageConfig r1 = this.c;
        r13.getClass();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r6 = true;
        if (jg5.e.a.a.g() == false) goto L9;
        PermissionResponse r14 = b.a(r1);
        if (r14 == null) goto L18;
        r14.getCallback().a(r0, r14);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r14) == false) goto L18;
    L20:
        r6 = false;
    L21:
        if (r6 == false) goto L29;
        b r15 = this.a;
        TextView r2 = this.b;
        Intrinsics.checkNotNull(r2);
        MessageConfig r3 = this.c;
        r15.getClass();
        if (r3.isCanCopy() == false) goto L27;
        ClipData r16 = ClipData.newPlainText(null, StringsKt.replace$default(r2.getText().toString(), "<doc.at.~#_%=`>", "", false, 4, null));
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).h(r16, new Token("LARK-PSDA-ccm_android_feed_pannel_set_clipboard")) == false) goto L30;
        String r17 = r2.getContext().getString(2131887614);
        Toast.showSuccessText(r2.getContext(), r17, 0);
        return;
    L30:
        return;
    L27:
        String r18 = r2.getContext().getString(2131887613);
        Toast.showFailureText(r2.getContext(), r18, 0);
        return;
    L29:
        return;
    L18:
        if (r1.isCanCopy() == true) goto L21;
        uf5.r r19 = bg5.a.b;
        bg5.a.f(r1.isWhole());
        Toast.showFailureText(r0, 2131887613);
        goto L20
    L9:
        gj5.b r110 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r7 = FileBizDomain.FileBizDomainCCM;
        gj5.c r111 = r110.g("CCM_CONTENT_COPY", r7, r1.getDocumentType().b, r1.getToken());
        boolean r8 = r111.a;
        FileAuthResultFrom r112 = r111.b;
        if (r8 == true) goto L18;
        if (r112 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L15;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CONTENT_COPY", r7, r1.getDocumentType().b, r1.getToken());
        goto L20
    L15:
        if (r112 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L20;
        uf5.r r113 = bg5.a.b;
        bg5.a.f(r1.isWhole());
        Toast.showFailureText(r0, r0.getText(2131887246), 1);
        goto L20
    }
}
