package rb9;

import ac9.c0;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import eb9.o;
import eb9.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements fb9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f536992a;

    public b(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "menuPresenter");
        this.f536992a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [rb9.a] */
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
    @Override // fb9.c
    public final boolean g(View r100, final o<?> r110, FlowFeedActionScene r111, List<? extends eb9.d> r112, final Function2<? super eb9.d, ? super eb9.c, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r110, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "actionItems");
        Intrinsics.checkNotNullParameter(r113, "onAction");
        if (AppHost.f326268a.isTestChannel() == false) goto L17;
        List<? extends eb9.d> r101 = r112;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r102.add(((eb9.d) r103.next()).c());
        goto L6
    L9:
        if (CollectionsKt.distinct(r102).size() != r112.size()) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L17;
        throw new IllegalArgumentException("Flow feed action ids must be unique within one card action".toString());
    L11:
        r104 = false;
    L17:
        if (r112.isEmpty() == false) goto L20;
        return false;
    L20:
        return this.f536992a.a(r100, r110, r111, r112, new a(r110, r113));
    }
}
