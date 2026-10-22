package com.larus.profile.impl;

import android.view.View;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.nova.R;
import com.larus.profile.impl.view.BotProfileView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/profile/impl/ProfileBotViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfileBot;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "profile", "Lcom/larus/profile/impl/view/BotProfileView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileBotViewHolder extends ListViewHolder<fs9.n> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f366021f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BotProfileView f366022e;

    public ProfileBotViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f366022e = (BotProfileView) r100.findViewById(R.id.bot_profile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, fs9.n, java.lang.Object] */
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
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void T3(fs9.n r100) {
        final fs9.n r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f278523a = r101;
        BotProfileView r102 = this.f366022e;
        if (r102 == 0) goto L5;
        r102.R5(r101);
    L5:
        BotProfileView r103 = this.f366022e;
        if (r103 == null) goto L8;
        com.larus.utils.e1.u(r103, 0.0f, R.color.larus_base_1, R.color.larus_press);
    L8:
        com.larus.utils.e1.d(this.itemView, new u(this));
        BotProfileView r104 = this.f366022e;
        if (r104 == null) goto L12;
        r104.setAddItemClick(new v(this, r101));
        return;
    }
}
