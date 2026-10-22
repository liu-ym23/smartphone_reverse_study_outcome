package com.ss.android.lark.coremd.impl.buildnode;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.ext.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v7b.q;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class ListItemBuildUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f419827a = 0;

    static {
    }

    public static List a(s r100) {
        ArrayList r101 = new ArrayList();
        s r102 = r100.f553569e;
    L3:
        if (r102 == null) goto L5;
        r101.add(r102);
        r102 = r102.f553572h;
        goto L3
    L5:
        return r101;
    }

    public static s d(final s r100) {
        if ((r100 instanceof q) == true) goto L7;
        return null;
    L7:
        return (s) i.a(ListItemBuildExtend.class, new ListItemBuildUtils$containerNode$1(r100));
    }

    public static int f(final s r100) {
        if ((r100 instanceof q) == true) goto L7;
        return 0;
    L7:
        return ((Number) i.a(ListItemBuildExtend.class, new ListItemBuildUtils$floor$floor$1(r100))).intValue();
    }

    public static List g(List r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (((ArrayList) r100).isEmpty() == true) goto L5;
        ArrayList r101 = new ArrayList();
        LinkedList r102 = new LinkedList();
        LinkedList r103 = new LinkedList();
        Iterator r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L29;
        s r105 = (s) r104.next();
        if ((r105 instanceof q) == false) goto L11;
        int r106 = f(r105);
        if (r102.isEmpty() == true) goto L27;
        if (f((s) r102.getLast()) <= r106) goto L27;
        c(r106, r102, r103, r101);
        r102.add(r105);
    L27:
        r102.add(r105);
        goto L8
    L11:
        c(-1, r102, r103, r101);
        if (r105.f553570f == null) goto L20;
        List r107 = a(r105);
        s r108 = r105.f553569e;
    L14:
        if (r108 == null) goto L16;
        r108.p();
        r108 = r108.f553572h;
        goto L14
    L16:
        Iterator r109 = g(r107).iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        r105.e((s) r109.next());
    L20:
        r101.add(r105);
        goto L8
    L29:
        if ((!r102.isEmpty()) == false) goto L31;
        c(-1, r102, r103, r101);
    L31:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s b(final s r100, final List r101) {
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = r100;
        i.a(ListItemBuildExtend.class, new ListItemBuildUtils$commitListRecursive$1(r100, r101, r102));
        return (s) r102.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s e(final s r100, final int r101) {
        if ((r100 instanceof q) == true) goto L5;
        return r100;
    L5:
        final Ref.IntRef r102 = new Ref.IntRef();
        r102.element = f(r100);
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = r100;
        i.a(ListItemBuildExtend.class, new ListItemBuildUtils$floatUpToTargetFloor$1(r100, r102, r101, r103));
        return (s) r103.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    public static void c(int r100, LinkedList r101, LinkedList r110, List r111) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        r110.clear();
    L6:
        int r102 = 1;
        if ((!r101.isEmpty()) == false) goto L20;
        if (f((s) r101.getLast()) <= r100) goto L20;
        s r103 = (s) r101.remove(CollectionsKt.getLastIndex(r101));
        r110.addFirst(r103);
        if ((true ^ r101.isEmpty()) == false) goto L6;
        if (f((s) r101.getLast()) >= f(r103)) goto L6;
        s r104 = (s) r101.getLast();
        Iterator r105 = r110.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        r104.e((s) r105.next());
        goto L16
    L18:
        r110.clear();
    L20:
        if ((!r110.isEmpty()) == true) goto L22;
    L74:
        r110.clear();
        return;
    L22:
        if (r110.isEmpty() == false) goto L25;
        ?? r106 = CollectionsKt.emptyList();
    L73:
        ((ArrayList) r111).addAll((Collection) r106);
        goto L74
    L25:
        if (r110.isEmpty() == true) goto L33;
        Iterator r107 = r110.iterator();
    L29:
        if (r107.hasNext() == false) goto L33;
        if ((((s) r107.next()) instanceof q) == true) goto L29;
        boolean r108 = false;
    L34:
        if (r108 == true) goto L36;
    L69:
        r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r109 = r110.iterator();
    L71:
        if (r109.hasNext() == false) goto L73;
        s r112 = e((s) r109.next(), 0);
        r106.add(b(r112, a(r112)));
        goto L71
    L36:
        if (r110.size() <= 1) goto L69;
        Object r113 = CollectionsKt.first(r110);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        q r114 = (q) r113;
        int r115 = f(r114);
        s r116 = d(r114);
        if (r116 == null) goto L40;
        Class<?> r117 = r116.getClass();
    L42:
        if (r110.isEmpty() == true) goto L59;
        Iterator r118 = r110.iterator();
    L46:
        if (r118.hasNext() == false) goto L59;
        s r119 = (s) r118.next();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        q r120 = (q) r119;
        if (f(r120) != r115) goto L56;
        s r121 = d(r120);
        if (r121 == null) goto L52;
        Class<?> r122 = r121.getClass();
    L54:
        if (Intrinsics.areEqual(r122, r117) == false) goto L56;
        boolean r123 = true;
    L57:
        if (r123 == true) goto L46;
        boolean r124 = false;
    L60:
        if (r124 == false) goto L69;
        s r125 = e(r114, 0);
        s r126 = b(r125, a(r125));
        int r127 = r110.size();
    L62:
        if (r102 >= r127) goto L68;
        Object r128 = ListProtector.get(r110, r102);
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type com.ss.android.lark.commonmark.node.ListItem");
        s r129 = e((q) r128, 0);
        Iterator r130 = ((ArrayList) a(b(r129, a(r129)))).iterator();
    L65:
        if (r130.hasNext() == false) goto L67;
        r126.e((s) r130.next());
        goto L65
    L67:
        r102 = r102 + 1;
        goto L62
    L68:
        r106 = CollectionsKt.listOf(r126);
        goto L73
    L52:
        r122 = null;
    L56:
        r123 = false;
    L59:
        r124 = true;
        goto L60
    L40:
        r117 = null;
    L33:
        r108 = true;
        goto L34
    }
}
