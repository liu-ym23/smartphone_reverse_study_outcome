package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.appserviceimpl.feed.preload.FeedListPreloader;
import com.bytedance.awemeopen.bizmodels.feed.preload.AosPreloadFeedListReason;
import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AosPreloadHelper implements q54.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AosPreloadHelper f197655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v24.c f197656b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v24.b f197657c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v24.a f197658d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h34.a f197659e = null;

    public AosPreloadHelper() {
    }

    static {
        f197655a = new AosPreloadHelper();
        d14.a r100 = b14.a.f16924a;
        v24.c r101 = (v24.c) b14.a.a(v24.c.class);
        f197656b = r101;
        r101.W2();
        FeedListPreloader r102 = FeedListPreloader.f198106a;
        f197657c = r102;
        r101.o2();
        f197658d = com.bytedance.awemeopen.appserviceimpl.feed.preload.a.f198109a;
        h34.a r103 = (h34.a) b14.a.a(h34.a.class);
        f197659e = r103;
        r103.w();
        i14.b r104 = i14.b.f487976a;
        r54.a r105 = AosExtConfig.f193138b.z0();
        r102.f(new w14.a(r105.f536300a, r105.f536301b, r105.f536302c, r105.f536303d, r105.f536304e, r105.f536305f, r105.f536306g));
    }

    @Override // q54.b
    public final void a() {
        c(AosPreloadFeedListReason.HOST_INVOKE_PRELOAD);
    }

    public static void c(AosPreloadFeedListReason r100) {
        Intrinsics.checkNotNullParameter(r100, "preloadReason");
        v24.b r101 = f197657c;
        w24.b r102 = new w24.b();
        List<u24.b> r103 = q.b();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f558008n = r103;
        r102.f558012r = "host_preload";
        Unit r104 = Unit.INSTANCE;
        r101.c(r100, r102);
    }

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
    @Override // q54.b
    public final void b(List<q54.a> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "list");
        v24.a r100 = f197658d;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        q54.a r103 = (q54.a) r102.next();
        r101.add(new AosAwemePreloadModel(r103.f531727a, r103.f531728b, r103.f531729c, r103.f531730d, r103.f531731e, r103.f531732f, r103.f531733g, r103.f531734h, r103.f531735i, r103.f531736j));
        goto L4
    L6:
        r100.a(r101, AosPreloadHelper$preload$2.INSTANCE, r111);
    }
}
