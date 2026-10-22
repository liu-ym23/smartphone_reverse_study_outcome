package com.bytedance.creativex.mediaimport.view.internal.base;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.views.DebounceOnClickListener;

/* JADX INFO: loaded from: classes15.dex */
public final class a1 extends DebounceOnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f203818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseMediaViewHolder f203819e;

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
        int r100 = this.f203818d.getAdapterPosition();
        if (r100 != (-1)) goto L5;
        return;
    L5:
        BaseMediaViewHolder r101 = this.f203819e;
        DATA r102 = r101.f203798c;
        if (r102 == 0) goto L11;
        r101.f203796a.invoke(r102, Integer.valueOf(r100), this.f203819e.f203799d);
        BaseMediaViewHolder r103 = this.f203819e;
        if (r103.f203800e == true) goto L12;
        r103.f203797b.invoke(r102, Integer.valueOf(r100), this.f203819e.f203799d);
        return;
    L12:
        return;
    }

    public a1(RecyclerView.ViewHolder r100, BaseMediaViewHolder r101) {
        this.f203818d = r100;
        this.f203819e = r101;
        super(400);
    }
}
