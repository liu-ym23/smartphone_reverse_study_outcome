package com.obric.oui.indicator;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class OBaseIndicator$setViewPager2$3 implements OBaseIndicator.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1 f401228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f401229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OBaseIndicator f401230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Integer> f401231d;

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final boolean b() {
        if (this.f401229b.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final void c() {
        OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1 r100 = this.f401228a;
        if (r100 == null) goto L7;
        this.f401229b.unregisterOnPageChangeCallback(r100);
        return;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final int getCount() {
        return this.f401231d.invoke().intValue();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final int getCurrentItem() {
        return OBaseIndicator.a(this.f401230c, this.f401229b.getCurrentItem(), getCount());
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final void a(int r100) {
        this.f401229b.setCurrentItem(r100, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.obric.oui.indicator.OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1, java.lang.Object] */
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
    @Override // com.obric.oui.indicator.OBaseIndicator.c
    public final void d(final l r100) {
        Intrinsics.checkNotNullParameter(r100, "onPageChangeListenerHelper");
        final OBaseIndicator r101 = this.f401230c;
        ?? r102 = new OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1(r100, r101, this);
        this.f401228a = r102;
        ViewPager2 r103 = this.f401229b;
        Intrinsics.checkNotNull(r102);
        r103.registerOnPageChangeCallback(r102);
    }

    public OBaseIndicator$setViewPager2$3(ViewPager2 r100, OCarouselIndicator r101, Function0 r102) {
        this.f401229b = r100;
        this.f401230c = r101;
        this.f401231d = r102;
    }
}
