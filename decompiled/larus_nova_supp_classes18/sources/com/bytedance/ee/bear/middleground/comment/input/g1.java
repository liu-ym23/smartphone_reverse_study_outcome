package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1 implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Ref.ObjectRef<PermissionResponse> b;
    public final /* synthetic */ InputComment c;
    public final /* synthetic */ gj5.c d;

    public g1(boolean r1, Ref.ObjectRef<PermissionResponse> r2, InputComment r3, gj5.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        tt5.a.h("Comment#InputComment", "Click insertImage.");
        if (this.a == false) goto L10;
        Object r6 = this.b.element;
        if (r6 == null) goto L10;
        if (((PermissionResponse) r6).getAllow() == false) goto L9;
        InputComment.u(this.c);
    L9:
        ((PermissionResponse) this.b.element).getCallback().a(this.c.a.getActivity(), (PermissionResponse) this.b.element);
        return;
    L10:
        gj5.c r7 = this.d;
        if (r7.a == false) goto L13;
        InputComment.u(this.c);
        return;
    L13:
        FileAuthResultFrom r8 = r7.b;
        if (r8 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L17;
        Toast.showText(this.c.a.getActivity(), 2131887246);
        return;
    L17:
        if (r8 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L23;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_ATTACHMENT_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, "");
        return;
    }
}
