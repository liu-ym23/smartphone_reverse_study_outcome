package com.bytedance.creativex.mediaimport.view.internal.base;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.views.DebounceOnClickListener;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends DebounceOnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f203814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseFolderViewHolder f203815e;

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
    @Override // com.ss.android.ugc.aweme.views.DebounceOnClickListener
    public final void a() {
        int r100 = this.f203814d.getAdapterPosition();
        if (r100 != (-1)) goto L5;
        return;
    L5:
        BaseFolderViewHolder r101 = this.f203815e;
        DATA r102 = r101.f203687b;
        if (r102 == 0) goto L9;
        r101.f203686a.invoke(r102, Integer.valueOf(r100));
        return;
    }

    public a(RecyclerView.ViewHolder r100, BaseFolderViewHolder r101) {
        this.f203814d = r100;
        this.f203815e = r101;
        super(400);
    }
}
