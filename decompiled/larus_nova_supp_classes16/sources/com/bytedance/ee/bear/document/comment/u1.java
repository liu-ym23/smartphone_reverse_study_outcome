package com.bytedance.ee.bear.document.comment;

import android.view.View;
import com.bytedance.ee.bear.document.comment.bean.MenuCallbackData;
import com.bytedance.ee.bear.document.comment.bean.ReactionPanel;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u1 implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ ReactionPanel.OperationItem b;
    public final /* synthetic */ CommentPlugin.l0 c;

    public final void a(View r7) {
        w05.i r8 = ((w05.b) this.c.a.getHostAbility(w05.b.class)).getDocumentInfoProvider();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L8;
        int r0 = f35.b.a;
        PermissionResponse r1 = f35.b.c((DocumentInfo) r8.g().getValue(), "CONTENT_COPY", BizDomain.FileBizDomainCCM);
        r1.getCallback().a(CommentPlugin.access$5600(this.c.a), r1);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r1) == false) goto L17;
        CommentPlugin.access$4000(this.c.a).b().l("global_comments");
        return;
    L17:
        int r2 = f35.b.a;
        if (f35.b.f((DocumentInfo) r8.g().getValue()) == true) goto L21;
        CommentPlugin.access$4000(this.c.a).b().l("global_comments");
        Toast.showFailureText(CommentPlugin.access$5900(this.c.a), CommentPlugin.access$6000(this.c.a).getString(2131887613));
        return;
    L21:
        this.a.a(new MenuCallbackData(this.b.getId(), CommentPlugin.access$6100(this.c.a)));
        return;
    L8:
        gj5.b r3 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r4 = FileBizDomain.FileBizDomainCCM;
        gj5.c r5 = r3.g("CCM_CONTENT_COPY", r4, ((DocumentInfo) r8.g().getValue()).getType(), ((DocumentInfo) r8.g().getValue()).getObjToken());
        if (r5.a == true) goto L17;
        if (r5.b.equals(FileAuthResultFrom.COME_FROM_FILE_POLICY) == false) goto L14;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CONTENT_COPY", r4, this.c.a.getDocumentMetadata().getDocumentTypeValue(), this.c.a.getDocumentMetadata().getToken());
        return;
    L14:
        if (r5.b.equals(FileAuthResultFrom.COME_FROM_AUTHZ) == false) goto L24;
        CommentPlugin.access$4000(this.c.a).b().l("global_comments");
        Toast.showFailureText(CommentPlugin.access$5700(this.c.a), CommentPlugin.access$5800(this.c.a).getString(2131887246));
        return;
    }

    public u1(CommentPlugin.l0 r1, tb5.m r2, ReactionPanel.OperationItem r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
