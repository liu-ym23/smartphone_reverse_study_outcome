package com.ss.android.ugc.aweme.search.dynamic.core.ability;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.lynx.tasm.LynxError;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import com.ss.android.ugc.aweme.search.dynamic.legacy.ISearchDynamicAbilityLegacy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility;", "Lcom/ss/android/ugc/aweme/search/dynamic/legacy/ISearchDynamicAbilityLegacy;", "DefaultFactory", "IFactory", "Scope", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public interface ISearchDynamicAbility extends ISearchDynamicAbilityLegacy {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility$DefaultFactory;", "Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility$IFactory;", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public static class DefaultFactory implements IFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f452650a;

        @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
        public final ISearchDynamicAbility create() {
            return null;
        }

        @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
        public final String getName() {
            return "";
        }

        public DefaultFactory() {
            this.f452650a = 1;
        }

        @Override // com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility.IFactory
        public final int getScope() {
            return this.f452650a;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility$IFactory;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public interface IFactory {
        ISearchDynamicAbility create();

        String getName();

        int getScope();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/ISearchDynamicAbility$Scope;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Scope {
    }

    void a(DynamicData r100);

    void b(AnnieXLynxView r100, String r101);

    void c(AnnieXLynxView r100);

    void d(Uri r100, AnnieXLynxView r101);

    void e(AnnieXLynxView r100);

    void f(AnnieXLynxView r100);

    void g(AnnieXLynxView r100, LynxError r101);

    String getName();

    void h(DynamicData r100);

    void l();

    void m(AnnieXLynxView r100);

    void onViewAttachedToWindow(View r100);

    void onViewDetachedFromWindow(View r100);

    void onViewRecycled();
}
