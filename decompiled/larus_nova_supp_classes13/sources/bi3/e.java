package bi3;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformLoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements n43.b {
    public final PlatformLoadingView a;

    public final View getView() {
        return this.a;
    }

    public e(PlatformLoadingView r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingView");
        this.a = r2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup, com.bytedance.android.shopping.skubuy.platform.view.PlatformLoadingView, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d(y43.a r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        ?? r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "state");
        boolean r2 = false;
        if (r6.a == false) goto L13;
        boolean r0 = r6.b;
        boolean r4 = r6.c;
        r1.setVisibility(0);
        if (r4 == false) goto L7;
        r1.a.c();
    L8:
        if (r0 == false) goto L10;
        r1.b.setVisibility(0);
        r1.c.setVisibility(0);
    L17:
        if (r6.a == true) goto L19;
    L21:
        r1.setClickable(r2);
        return;
    L19:
        if (r6.d == false) goto L21;
        r2 = true;
        goto L21
    L10:
        r1.b.setVisibility(8);
        r1.c.setVisibility(8);
        r1.d.setVisibility(8);
        ObjectAnimator r3 = r1.e;
        if (r3 == null) goto L17;
        r3.cancel();
        goto L17
    L7:
        r1.a.d();
        goto L8
    L13:
        r1.a.d();
        r1.setVisibility(8);
        r1.b.setVisibility(8);
        r1.c.setVisibility(8);
        r1.d.setVisibility(8);
        ObjectAnimator r5 = r1.e;
        if (r5 == null) goto L17;
        r5.cancel();
        goto L17
    }
}
