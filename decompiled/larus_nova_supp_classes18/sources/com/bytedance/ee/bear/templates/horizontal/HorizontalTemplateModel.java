package com.bytedance.ee.bear.templates.horizontal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.templates.category.CategoryModel;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class HorizontalTemplateModel implements com.bytedance.ee.bear.templates.horizontal.a {
    public final Fragment a;
    public final long b;
    public final int c;
    public final Bundle d;
    public final Lazy e;
    public final Lazy f;
    public CategoryModel g;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.a
    public final Flowable<HorizontalTemplates> K() {
        Flowable r0 = Flowable.just((String) this.f.getValue()).observeOn(fo5.d.b()).flatMap(new c(this)).onErrorReturn(d.a);
        CategoryModel r1 = this.g;
        if (r1 != null) goto L5;
        Flowable r2 = Flowable.just(new HorizontalTemplates(0, new ArrayList(), new NullPointerException(), false));
    L7:
        return Flowable.concat(r0, r2).observeOn(fo5.d.d());
    L5:
        r2 = r1.v0(String.valueOf(this.b)).map(new e(this));
        goto L7
    }

    public final void create() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L5;
        HorizontalTemplateViewModel r1 = (HorizontalTemplateViewModel) ViewModelProviders.of(r0).get(HorizontalTemplateViewModel.class);
    L5:
        this.g = new CategoryModel(this.b, this.d, this.c, new AnonymousClass2(this));
    }

    public HorizontalTemplateModel(Fragment r2, long r3, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = LazyKt.lazy(HorizontalTemplateModel$cacheService$2.INSTANCE);
        this.f = LazyKt.lazy(new HorizontalTemplateModel$cacheKey$2(this));
    }
}
