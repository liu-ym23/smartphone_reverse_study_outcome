package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ BaseInputComment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Ref.ObjectRef<PermissionResponse> c;
    public final /* synthetic */ gj5.c d;

    public z(BaseInputComment r1, boolean r2, Ref.ObjectRef<PermissionResponse> r3, gj5.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        tt5.a.h(this.a.L(), "Click insertImage.");
        if (this.b == false) goto L10;
        Object r6 = this.c.element;
        if (r6 == null) goto L10;
        if (((PermissionResponse) r6).getAllow() == false) goto L9;
        this.a.v0();
    L9:
        ((PermissionResponse) this.c.element).getCallback().a(this.a.a.getActivity(), (PermissionResponse) this.c.element);
        return;
    L10:
        gj5.c r7 = this.d;
        if (r7.a == false) goto L13;
        this.a.v0();
        return;
    L13:
        FileAuthResultFrom r8 = r7.b;
        if (r8 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L17;
        Toast.showText(this.a.a.getActivity(), 2131887246);
        return;
    L17:
        if (r8 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L23;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_ATTACHMENT_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, "");
        return;
    }
}
