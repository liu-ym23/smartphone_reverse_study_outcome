package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import com.ss.ugc.effectplatform.task.FetchCategoryEffectCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryEffectTask;
import com.ss.ugc.effectplatform.task.FetchCategoryInfoCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryPagingEffectCacheTask;
import com.ss.ugc.effectplatform.task.FetchCategoryPagingEffectTask;
import com.ss.ugc.effectplatform.task.FetchDownloadedEffectListTask;
import com.ss.ugc.effectplatform.task.FetchPanelEffectListCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelEffectListTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoPagingCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoTask;
import com.ss.ugc.effectplatform.task.QueryInfoStickerListCacheTask;
import com.ss.ugc.effectplatform.task.d0;
import com.ss.ugc.effectplatform.task.d1;
import com.ss.ugc.effectplatform.task.e1;
import com.ss.ugc.effectplatform.task.o;
import com.ss.ugc.effectplatform.task.o0;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectConfig f457498a;

    /* JADX INFO: loaded from: classes36.dex */
    public static final class a implements IEffectPlatformBaseListener<QueryCustomizedEffectsData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f457499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IEffectPlatformBaseListener f457500b;

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onSuccess(QueryCustomizedEffectsData r100) {
            QueryCustomizedEffectsData r101 = r100;
            this.f457499a.f457498a.getClass();
            this.f457499a.f457498a.getClass();
            IEffectPlatformBaseListener r102 = this.f457500b;
            if (r102 == null) goto L6;
            r102.onSuccess(r101);
            return;
        }

        public a(e r100, IEffectPlatformBaseListener r101) {
            this.f457499a = r100;
            this.f457500b = r101;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onFail(QueryCustomizedEffectsData r100, ExceptionResult r101) {
            QueryCustomizedEffectsData r102 = r100;
            IEffectPlatformBaseListener r103 = this.f457500b;
            if (r103 == null) goto L6;
            r103.onFail(r102, r101);
            return;
        }
    }

    public e(EffectConfig r100) {
        this.f457498a = r100;
    }

    public final void e(String r100, IEffectPlatformBaseListener r101) {
        String r102 = q.a();
        if (r101 == null) goto L5;
        this.f457498a.N.b(r102, r101);
    L5:
        EffectConfig r103 = this.f457498a;
        FetchDownloadedEffectListTask r104 = new FetchDownloadedEffectListTask(r103, r100, r102);
        q1 r105 = r103.D;
        if (r105 == null) goto L9;
        r105.a(r104);
        return;
    }

    public final void i(String r100, Map<String, String> r101, IEffectPlatformBaseListener<QueryCustomizedEffectsData> r102) {
        String r103 = q.a();
        this.f457498a.N.b(r103, new a(this, r102));
        q1 r104 = this.f457498a.D;
        if (r104 == null) goto L6;
        r104.a(new d1(this.f457498a, r100, r103, r101));
        return;
    }

    public final void f(String r100, boolean r101, Map r102, IEffectPlatformBaseListener r103) {
        String r104 = q.a();
        this.f457498a.N.b(r104, r103);
        if (r101 == false) goto L5;
        e0.c r105 = new FetchPanelEffectListCacheTask(this.f457498a, r100, r104);
    L6:
        q1 r106 = this.f457498a.D;
        if (r106 == null) goto L10;
        r106.a(r105);
        return;
    L10:
        return;
    L5:
        r105 = new FetchPanelEffectListTask(this.f457498a, r100, r102, r104);
        goto L6
    }

    public final void a(String r100, String r101, int r110, Map r111, IEffectPlatformBaseListener r112) {
        String r102 = q.a();
        if (r112 == null) goto L5;
        this.f457498a.N.b(r102, r112);
    L5:
        o r113 = new o(this.f457498a, r102, r100, r101, r110, r111);
        q1 r103 = this.f457498a.D;
        if (r103 == null) goto L9;
        r103.a(r113);
        return;
    }

    public final void c(String r100, List r101, boolean r102, Map r110, IEffectPlatformBaseListener r111) {
        String r103 = q.a();
        if (r111 == null) goto L5;
        this.f457498a.N.b(r103, r111);
    L5:
        if (r102 == false) goto L7;
        e0.c r104 = new FetchCategoryInfoCacheTask(this.f457498a, r100, r103, r101);
    L8:
        q1 r105 = this.f457498a.D;
        if (r105 == null) goto L12;
        r105.a(r104);
        return;
    L12:
        return;
    L7:
        r104 = new d0(this.f457498a, r100, r103, r101, r110);
        goto L8
    }

    public final void j(String r100, Integer r101, Integer r110, Map r111, boolean r112, IEffectPlatformBaseListener r113) {
        String r102 = q.a();
        if (r113 == null) goto L5;
        this.f457498a.N.b(r102, r113);
    L5:
        if (r112 == false) goto L7;
        e0.c r114 = new QueryInfoStickerListCacheTask(this.f457498a, r100, r101, r110, r102);
    L8:
        q1 r103 = this.f457498a.D;
        if (r103 == null) goto L12;
        r103.a(r114);
        return;
    L12:
        return;
    L7:
        r114 = new e1(this.f457498a, r100, r101, r110, r111, r102);
        goto L8
    }

    public final void b(String r110, String r111, int r112, int r113, int r114, String r115, boolean r116, Map r210, IEffectPlatformBaseListener r211) {
        String r100 = q.a();
        if (r211 == null) goto L5;
        this.f457498a.N.b(r100, r211);
    L5:
        if (r116 == false) goto L7;
        e0.c r101 = new FetchCategoryEffectCacheTask(this.f457498a, r110, r100, r111, r112, r113, r114);
    L8:
        q1 r102 = this.f457498a.D;
        if (r102 == null) goto L12;
        r102.a(r101);
        return;
    L12:
        return;
    L7:
        r101 = new FetchCategoryEffectTask(this.f457498a, r110, r100, r111, r112, r113, r114, r115, r210);
        goto L8
    }

    public final void d(String r110, String r111, int r112, int r113, int r114, String r115, boolean r116, Map r210, IEffectPlatformBaseListener r211) {
        String r100 = q.a();
        if (r211 == null) goto L5;
        this.f457498a.N.b(r100, r211);
    L5:
        if (r116 == false) goto L7;
        e0.c r101 = new FetchCategoryPagingEffectCacheTask(this.f457498a, r110, r100, r111, r112, r113, r114);
    L8:
        q1 r102 = this.f457498a.D;
        if (r102 == null) goto L12;
        r102.a(r101);
        return;
    L12:
        return;
    L7:
        r101 = new FetchCategoryPagingEffectTask(this.f457498a, r110, r100, r111, r112, r113, r114, r115, r210);
        goto L8
    }

    public final void g(String r110, boolean r111, String r112, int r113, int r114, boolean r115, boolean r116, Map r210, IEffectPlatformBaseListener r211) {
        String r100 = q.a();
        if (r211 == null) goto L5;
        this.f457498a.N.b(r100, r211);
    L5:
        if (r115 == false) goto L7;
        e0.c r101 = new FetchPanelInfoCacheTask(this.f457498a, r110, r100, r111, r112, r113, r114);
    L8:
        q1 r102 = this.f457498a.D;
        if (r102 == null) goto L12;
        r102.a(r101);
        return;
    L12:
        return;
    L7:
        r101 = new FetchPanelInfoTask(this.f457498a, r110, r100, r111, r112, r113, r114, r116, r210);
        goto L8
    }

    public final void h(String r110, String r111, int r112, int r113, int r114, String r115, boolean r116, Map r210, IEffectPlatformBaseListener r211) {
        String r100 = q.a();
        if (r211 == null) goto L5;
        this.f457498a.N.b(r100, r211);
    L5:
        if (r116 == false) goto L7;
        e0.c r117 = new FetchPanelInfoPagingCacheTask(this.f457498a, r110, r100, r111, r112, r113, r114, r115);
    L8:
        q1 r101 = this.f457498a.D;
        if (r101 == null) goto L12;
        r101.a(r117);
        return;
    L12:
        return;
    L7:
        r117 = new o0(this.f457498a, r110, r100, r111, r112, r113, r114, r115, r210);
        goto L8
    }
}
