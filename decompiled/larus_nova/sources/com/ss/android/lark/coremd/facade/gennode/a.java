package com.ss.android.lark.coremd.facade.gennode;

import com.ss.android.lark.coremd.base.buildnode.NodeDisplayType;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.a0;
import v7b.c;
import v7b.e0;
import v7b.f;
import v7b.g;
import v7b.i;
import v7b.l;
import v7b.q;
import v7b.s;
import v7b.u;
import v7b.v;
import v7b.z;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements u9b.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Class<? extends s>> f419714d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Class<? extends s>> f419715e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Class<? extends s>> f419716f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Class<? extends s>> f419717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends s>> f419718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Class<? extends s>> f419719c;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.gennode.a$a, reason: collision with other inner class name */
    public static final class C4942a {
    }

    static {
        f419714d = SetsKt.setOf(new Class[]{q.class, v.class, v7b.b.class, u.class, c.class, i.class});
        f419715e = SetsKt.setOf(new Class[]{f.class, a0.class, e0.class, z.class});
        f419716f = SetsKt.setOf(new Class[]{g.class, l.class});
    }

    public a(int r100) {
        Set<Class<? extends s>> r101 = f419714d;
        Set<Class<? extends s>> r102 = f419715e;
        Set<Class<? extends s>> r103 = f419716f;
        Intrinsics.checkNotNullParameter(r101, "blockType");
        Intrinsics.checkNotNullParameter(r102, "inlineBlockType");
        Intrinsics.checkNotNullParameter(r103, "nonContainerBlock");
        this.f419717a = r101;
        this.f419718b = r102;
        this.f419719c = r103;
    }

    @Override // u9b.b
    public final NodeDisplayType a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Class<?> r101 = r100.getClass();
        if (this.f419717a.contains(r101) == false) goto L6;
        return NodeDisplayType.Block;
    L6:
        if (this.f419718b.contains(r101) == false) goto L9;
        return NodeDisplayType.InlineBlock;
    L9:
        if (this.f419719c.contains(r101) == false) goto L12;
        return NodeDisplayType.NonContainerBlock;
    L12:
        return NodeDisplayType.Inline;
    }
}
