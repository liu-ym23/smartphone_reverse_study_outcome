package com.bytedance.ee.bear.middleground.comment.control;

import android.content.ClipData;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends c0 {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.b c;
    public final /* synthetic */ CommentFunction d;
    public final /* synthetic */ TextView e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ String c;

        public a(CommentFunction r1, TextView r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            ClipData r5 = (ClipData) r4;
            CommentFunction r0 = this.a;
            TextView r1 = this.b;
            Intrinsics.checkNotNull(r5);
            CommentFunction.J(r0, r1, r5, this.c);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.control.b$b, reason: collision with other inner class name */
    public static final class C0061b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommentFunction b;
        public final /* synthetic */ TextView c;

        public C0061b(String r1, CommentFunction r2, TextView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            tt5.a.l("Comment#CommentFunction", "copy failed", (Throwable) r4);
            ClipData r5 = ClipData.newPlainText(null, this.a);
            CommentFunction r0 = this.b;
            TextView r1 = this.c;
            Intrinsics.checkNotNull(r5);
            CommentFunction.J(r0, r1, r5, this.a);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.a(r9);
        if (this.c.c == true) goto L22;
        CommentFunction r10 = this.d;
        Context r1 = this.e.getContext();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r5 = true;
        if (jg5.e.a.a.g() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = r10.a;
        PermissionResponse r3 = r2.S.c(r2.k.b, r2.i, "CONTENT_COPY");
        r3.getCallback().a(r1, r3);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r3) == true) goto L20;
    L17:
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r10.Q(new j(r4));
        if (r4.element == true) goto L21;
        r10.a.d0.l("part_comments");
        Toast.showFailureText(r1, 2131887613);
    L21:
        if (r5 == true) goto L22;
        return;
    L20:
        r5 = false;
        goto L21
    L9:
        com.bytedance.ee.bear.middleground.comment.uitls.p r6 = r10.a;
        gj5.c r7 = r6.S.e(r6.k.b, r6.i);
        if (r7.a == true) goto L17;
        FileAuthResultFrom r8 = r7.b;
        if (r8 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L15;
        gj5.b r11 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r12 = FileBizDomain.FileBizDomainCCM;
        com.bytedance.ee.bear.middleground.comment.uitls.p r13 = r10.a;
        r11.c("CCM_CONTENT_COPY", r12, r13.k.b, r13.i);
        goto L20
    L15:
        if (r8 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L20;
        r10.a.d0.l("part_comments");
        Toast.showFailureText(r1, r1.getText(2131887246), 1);
    L22:
        SpannableStringBuilder r14 = new SpannableStringBuilder(this.e.getText());
        String r15 = StringsKt.replace$default(this.e.getText().toString(), "<doc.at.~#_%=`>", "", false, 4, null);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.docx_comment_copy_atmention_support") == false) goto L25;
        Single<ClipData> r0 = com.bytedance.ee.bear.utils.f.a(r14, r15, new com.bytedance.ee.bear.middleground.comment.widget.g());
        CommentFunction r16 = this.d;
        TextView r17 = this.e;
        r0.subscribe(new a(r16, r17, r15), new C0061b(r15, r16, r17));
        return;
    L25:
        tt5.a.h("Comment#CommentFunction", "only PlainText");
        ClipData r18 = ClipData.newPlainText(null, r15);
        CommentFunction r19 = this.d;
        TextView r20 = this.e;
        Intrinsics.checkNotNull(r18);
        CommentFunction.J(r19, r20, r18, r15);
    }

    public b(com.bytedance.ee.bear.middleground.comment.export.bean.b r1, CommentFunction r2, TextView r3, com.bytedance.ee.bear.middleground.comment.uitls.p r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super(r4, "COPY");
    }
}
