package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ SearchUserResultAdapter.SearchUserViewHolder d;
    public final /* synthetic */ SearchUserResultAdapter e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        tt5.a.h("SearchUserResultAdapter", "onClicked escape item, id: " + this.c.getId());
        if (((ArrayList) this.e.e).contains(this.c) == false) goto L6;
        this.e.B2(this.d, this.c);
        return;
    L6:
        StringBuilder r6 = new StringBuilder("escapeRuleBean is null? ");
        boolean r2 = false;
        if (this.e.o != null) goto L9;
        boolean r1 = true;
    L10:
        r6.append(r1);
        r6.append(", escapeApprovalInfo is null? ");
        if (this.e.p != null) goto L13;
        r2 = true;
    L13:
        r6.append(r2);
        tt5.a.h("SearchUserResultAdapter", r6.toString());
        SearchUserResultAdapter r7 = this.e;
        EscapeRuleBean r0 = r7.o;
        if (r0 == null) goto L18;
        EscapeApprovalInfo r3 = r7.p;
        if (r3 == null) goto L18;
        SearchUserResultAdapter.y2(r7, this.d, this.c, r0, r3);
        return;
    L18:
        final SearchUserResultAdapter.SearchUserViewHolder r4 = this.d;
        final UserInfo r8 = this.c;
        r7.D2(new h(this, r4, r8));
        return;
    L9:
        r1 = false;
        goto L10
    }

    public i(SearchUserResultAdapter r1, UserInfo r2, SearchUserResultAdapter.SearchUserViewHolder r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
