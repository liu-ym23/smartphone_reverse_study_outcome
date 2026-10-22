package com.ss.android.lark.passportc.task;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0c.b f438500c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public m f438501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public Set<q> f438502b;

    public static final class a {
    }

    @Inject
    public h() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r100) {
        return e.a(this, r100);
    }

    static {
        f438500c = new j0c.b("register_static_user_convention");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f438500c;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Set<q> r101 = this.f438502b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("staticConventions");
        r101 = null;
    L6:
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        q r103 = (q) r102.next();
        m r104 = this.f438501a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("userService");
        r104 = null;
    L13:
        r104.d(r103);
        goto L8
    L15:
        return Observable.just(new j0c.c(f438500c, true, null, 12));
    }
}
