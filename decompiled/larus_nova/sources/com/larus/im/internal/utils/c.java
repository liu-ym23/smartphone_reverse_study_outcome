package com.larus.im.internal.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f350526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<com.larus.im.internal.rtcsdk.impl.g, com.larus.im.internal.rtcsdk.impl.g> f350527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<List<com.larus.im.internal.rtcsdk.impl.g>, Unit> f350528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.larus.im.internal.rtcsdk.impl.g> f350529d;

    public static final class a {
    }

    static {
    }

    public static com.larus.im.service.audio.l a(List r100) {
        Iterator r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 + ((com.larus.im.service.audio.l) r101.next()).f350772a.length;
        goto L4
    L6:
        byte[] r103 = new byte[r102];
        Iterator r104 = ((ArrayList) r100).iterator();
        int r105 = 0;
    L8:
        if (r104.hasNext() == false) goto L11;
        com.larus.im.service.audio.l r106 = (com.larus.im.service.audio.l) r104.next();
        byte[] r107 = r106.f350772a;
        System.arraycopy(r107, 0, r103, r105, r107.length);
        r105 = r105 + r106.f350772a.length;
        goto L8
    L11:
        return new com.larus.im.service.audio.l(r103, ((com.larus.im.service.audio.l) ListProtector.get(r100, 0)).f350773b, ((com.larus.im.service.audio.l) ListProtector.get(r100, 0)).getType(), ((com.larus.im.service.audio.l) ListProtector.get(r100, 0)).f350775d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
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
    public final void b(com.larus.im.internal.rtcsdk.impl.g r100) {
        Intrinsics.checkNotNullParameter(r100, "micWithRef");
        ((ArrayList) this.f350529d).add(r100);
        if (((ArrayList) this.f350529d).size() != this.f350526a) goto L26;
        List<com.larus.im.internal.rtcsdk.impl.g> r101 = this.f350529d;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        ArrayList r103 = (ArrayList) r101;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102.add(((com.larus.im.internal.rtcsdk.impl.g) r104.next()).f349863a);
        goto L6
    L8:
        com.larus.im.service.audio.l r105 = a(r102);
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r107 = r103.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((com.larus.im.internal.rtcsdk.impl.g) r107.next()).f349864b);
        goto L10
    L12:
        com.larus.im.internal.rtcsdk.impl.g r108 = new com.larus.im.internal.rtcsdk.impl.g(r105, a(r106));
        com.larus.im.internal.rtcsdk.impl.g r109 = this.f350527b.invoke(r108);
        List<com.larus.im.service.audio.l> r110 = c(r109.f349863a);
        List<com.larus.im.service.audio.l> r111 = c(r109.f349864b);
        if (r110.size() == this.f350526a) goto L15;
    L20:
        ?? r112 = CollectionsKt.emptyList();
    L21:
        this.f350528c.invoke(r112);
        ((ArrayList) this.f350529d).clear();
        return;
    L15:
        if (r111.size() != this.f350526a) goto L20;
        r112 = new ArrayList();
        int r113 = this.f350526a;
        int r114 = 0;
    L18:
        if (r114 >= r113) goto L21;
        r112.add(new com.larus.im.internal.rtcsdk.impl.g((com.larus.im.service.audio.l) ListProtector.get(r110, r114), (com.larus.im.service.audio.l) ListProtector.get(r111, r114)));
        r114 = r114 + 1;
        goto L18
    }

    public final List<com.larus.im.service.audio.l> c(com.larus.im.service.audio.l r110) {
        byte[] r100 = r110.f350772a;
        int r101 = 0;
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L14;
        int r103 = r100.length;
        int r104 = this.f350526a;
        if ((r103 % r104) != 0) goto L14;
        int r105 = r100.length / r104;
        ArrayList r106 = new ArrayList();
        int r107 = this.f350526a;
    L11:
        if (r101 >= r107) goto L13;
        int r108 = r101 * r105;
        r106.add(new com.larus.im.service.audio.l(ArraysKt.copyOfRange(r110.f350772a, r108, r108 + r105), r110.f350773b, r110.getType(), r110.f350775d));
        r101 = r101 + 1;
        goto L11
    L13:
        return r106;
    L14:
        String r111 = "OmniAVFrame size must be divisible by " + this.f350526a + ", content size: " + r110.f350772a.length;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L19;
        fe9.c.f476624a.b("AudioFrameCollectorAndSlicer", r111);
        return CollectionsKt.emptyList();
    L19:
        throw new IllegalArgumentException(r111);
    L5:
        r102 = false;
        goto L6
    }

    public c(com.larus.im.internal.rtcsdk.impl.k r100, com.larus.im.internal.rtcsdk.impl.l r101) {
        Intrinsics.checkNotNullParameter(r100, "externalProcessor");
        Intrinsics.checkNotNullParameter(r101, "onSliceResult");
        this.f350526a = 4;
        this.f350527b = r100;
        this.f350528c = r101;
        this.f350529d = new ArrayList();
    }
}
