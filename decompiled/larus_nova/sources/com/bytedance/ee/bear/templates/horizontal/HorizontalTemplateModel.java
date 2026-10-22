package com.bytedance.ee.bear.templates.horizontal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.templates.category.CategoryModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes18.dex */
public final class HorizontalTemplateModel implements com.bytedance.ee.bear.templates.horizontal.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f239087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f239088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f239089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f239090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f239091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f239092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CategoryModel f239093g;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.a
    public final Flowable<HorizontalTemplates> K() {
        Flowable r100 = Flowable.just((String) this.f239092f.getValue()).observeOn(fo5.d.b()).flatMap(new c(this)).onErrorReturn(d.f239108a);
        CategoryModel r101 = this.f239093g;
        if (r101 != null) goto L5;
        Publisher r102 = Flowable.just(new HorizontalTemplates(0, new ArrayList(), new NullPointerException(), false));
    L7:
        return Flowable.concat(r100, r102).observeOn(fo5.d.d());
    L5:
        r102 = r101.v0(String.valueOf(this.f239088b)).map(new e(this));
        goto L7
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        FragmentActivity r100 = this.f239087a.getActivity();
        if (r100 == null) goto L5;
        HorizontalTemplateViewModel r101 = (HorizontalTemplateViewModel) ViewModelProviders.of(r100).get(HorizontalTemplateViewModel.class);
    L5:
        this.f239093g = new CategoryModel(this.f239088b, this.f239090d, this.f239089c, new AnonymousClass2(this));
    }

    public HorizontalTemplateModel(Fragment r100, long r101, int r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f239087a = r100;
        this.f239088b = r101;
        this.f239089c = r102;
        this.f239090d = r103;
        this.f239091e = LazyKt.lazy(HorizontalTemplateModel$cacheService$2.INSTANCE);
        this.f239092f = LazyKt.lazy(new HorizontalTemplateModel$cacheKey$2(this));
    }
}
