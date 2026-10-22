package mz3;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f516485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GalleryLayout f516486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f516487c;

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = this.f516485a;
        if (r100 == 0) goto L5;
        Void r101 = (Void) r100;
        this.f516486b.f(r100, this.f516487c, true);
    L5:
        this.f516486b.f195185b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public j(View r100, GalleryLayout r101, int r102) {
        this.f516485a = r100;
        this.f516486b = r101;
        this.f516487c = r102;
    }
}
