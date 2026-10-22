package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UserInfo f233554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SearchUserResultAdapter.SearchUserViewHolder f233555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SearchUserResultAdapter f233556e;

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
    public final void a(View r100) {
        tt5.a.h("SearchUserResultAdapter", "onClicked escape item, id: " + this.f233554c.getId());
        if (((ArrayList) this.f233556e.f233517e).contains(this.f233554c) == false) goto L6;
        this.f233556e.B2(this.f233555d, this.f233554c);
        return;
    L6:
        StringBuilder r101 = new StringBuilder("escapeRuleBean is null? ");
        boolean r102 = false;
        if (this.f233556e.f233527o != null) goto L9;
        boolean r103 = true;
    L10:
        r101.append(r103);
        r101.append(", escapeApprovalInfo is null? ");
        if (this.f233556e.f233528p != null) goto L13;
        r102 = true;
    L13:
        r101.append(r102);
        tt5.a.h("SearchUserResultAdapter", r101.toString());
        SearchUserResultAdapter r104 = this.f233556e;
        EscapeRuleBean r105 = r104.f233527o;
        if (r105 == null) goto L18;
        EscapeApprovalInfo r106 = r104.f233528p;
        if (r106 == null) goto L18;
        SearchUserResultAdapter.y2(r104, this.f233555d, this.f233554c, r105, r106);
        return;
    L18:
        final SearchUserResultAdapter.SearchUserViewHolder r107 = this.f233555d;
        final UserInfo r108 = this.f233554c;
        r104.D2(new h(this, r107, r108));
        return;
    L9:
        r103 = false;
        goto L10
    }

    public i(SearchUserResultAdapter r100, UserInfo r101, SearchUserResultAdapter.SearchUserViewHolder r102) {
        this.f233556e = r100;
        this.f233554c = r101;
        this.f233555d = r102;
    }
}
