package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.graphics.Rect;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchAutoPlayScrollStateObserver;", "Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/ScrollStateObserver;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class SearchAutoPlayScrollStateObserver extends ScrollStateObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f452018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<String, JSONObject, Unit> f452019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f452020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f452021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f452022g;

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.ScrollStateObserver
    public final Rect b() {
        this.f452018c.getLocationOnScreen((int[]) this.f452021f.getValue());
        ((Rect) this.f452022g.getValue()).set(((int[]) this.f452021f.getValue())[0], ((int[]) this.f452021f.getValue())[1], ((int[]) this.f452021f.getValue())[0] + this.f452018c.getWidth(), ((int[]) this.f452021f.getValue())[1] + this.f452018c.getHeight());
        return (Rect) this.f452022g.getValue();
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.ScrollStateObserver
    public final void c() {
        this.f452019d.invoke("saas_video_state", new JSONObject().put("state", "stop"));
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.ScrollStateObserver
    public final void d() {
        this.f452019d.invoke("saas_video_state", new JSONObject().put("state", "play"));
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.ScrollStateObserver
    public final int a() {
        return this.f452020e;
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.ScrollStateObserver
    public final void e(int r100) {
        this.f452019d.invoke("saas_video_state", new JSONObject().put("state", "play"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchAutoPlayScrollStateObserver(View r100, Function2<? super String, ? super JSONObject, Unit> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "sendAction");
        this.f452018c = r100;
        this.f452019d = r101;
        this.f452020e = r102;
        this.f452021f = LazyKt.lazy(SearchAutoPlayScrollStateObserver$location$2.INSTANCE);
        this.f452022g = LazyKt.lazy(SearchAutoPlayScrollStateObserver$rect$2.INSTANCE);
    }
}
