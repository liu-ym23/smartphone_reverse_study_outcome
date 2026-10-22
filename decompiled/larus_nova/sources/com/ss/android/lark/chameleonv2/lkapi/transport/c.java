package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends z0b.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f411457c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<b> f411458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Disposable> f411459b;

    public static final class a {
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        b r100 = new b(new WeakReference(this));
        this.f411458a = new WeakReference(r100);
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new com.ss.android.lark.chameleonv2.lkapi.transport.a(), r100});
    }

    public c() {
        this.f411459b = new LinkedHashSet();
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r100) {
        Iterator<T> r101 = this.f411459b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Disposable) r101.next()).dispose();
        goto L4
    L6:
        this.f411459b.clear();
    }
}
