package com.bytedance.ee.bear.bitable.chameleon.render;

import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<FetchResult extends NonProguard, JSParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3020a<FetchResult> f209671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<JSParams>> f209672b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.chameleon.render.a$a, reason: collision with other inner class name */
    public static final class C3020a<FetchResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FetchResult f209673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f209674b;

        public C3020a(FetchResult r100, Throwable r101) {
            this.f209673a = r100;
            this.f209674b = r101;
        }
    }

    public static final class b<JSParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSParams f209675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m f209676b;

        public b(JSParams r100, m r101) {
            this.f209675a = r100;
            this.f209676b = r101;
        }
    }

    public abstract void a(com.bytedance.ee.bear.document.render.node.e r100, C3020a<FetchResult> r101, List<b<JSParams>> r102);

    public abstract boolean b(DocumentLoaderV3 r100);

    public abstract String c();

    public abstract JSParams e(JSONObject r100);

    public boolean f(com.bytedance.ee.bear.document.render.node.e r100, JSParams r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 == null) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract Disposable g(DocumentLoaderV3 r100, Function1 r101);

    public a() {
        this.f209672b = new ArrayList();
    }

    public final void d(com.bytedance.ee.bear.document.render.node.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        C3020a<FetchResult> r101 = this.f209671a;
        boolean r102 = true;
        if ((!((ArrayList) this.f209672b).isEmpty()) == false) goto L11;
        if (r101 == null) goto L12;
        List<b<JSParams>> r103 = CollectionsKt.toList(this.f209672b);
        ((ArrayList) this.f209672b).clear();
        this.f209671a = null;
        StringBuilder r104 = new StringBuilder("notify callback, bridge=");
        r104.append(c());
        r104.append(", count=");
        r104.append(r103.size());
        r104.append(", success=");
        if (r101.f209674b == null) goto L9;
        r102 = false;
    L9:
        r104.append(r102);
        tt5.a.h("BitableNetDataNode", r104.toString());
        a(r100, r101, r103);
        return;
    L12:
        return;
    }
}
