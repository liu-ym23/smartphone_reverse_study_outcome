package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0096\u0002¢\u0006\u0002\u0010\rJ.\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider;", "defaultStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getEffectiveStoreOwner", "storeOwner", "enable", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiViewModelProvider extends ViewModelProvider {
    public static final ViewModelProvider.NewInstanceFactory c = null;
    public final ViewModelStoreOwner a;
    public final ViewModelProvider.Factory b;

    public static final class a {
        @JvmStatic
        public static ForsetiViewModelProvider a(ViewModelStoreOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "storeOwner");
            if ((r2 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            ViewModelProvider.Factory r0 = ((HasDefaultViewModelProviderFactory) r2).getDefaultViewModelProviderFactory();
        L7:
            return new ForsetiViewModelProvider(r2, r0);
        L5:
            r0 = ForsetiViewModelProvider.c;
            goto L7
        }
    }

    static {
        c = new ViewModelProvider.NewInstanceFactory();
    }

    public final <T extends ViewModel> T get(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "modelClass");
        String r0 = r3.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r0), r3);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public ForsetiViewModelProvider(ViewModelStoreOwner r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStoreOwner");
        Intrinsics.checkNotNullParameter(r3, "factory");
        super(r2, r3);
        this.a = r2;
        this.b = r3;
    }

    public final <T extends ViewModel> T get(String r8, Class<T> r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "modelClass");
        ViewModelStoreOwner r0 = this.a;
        boolean r1 = r0 instanceof FragmentActivity;
        if (r1 == false) goto L25;
        FragmentActivity r3 = (FragmentActivity) r0;
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (ForsetiConfig.b() == true) goto L7;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L25;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (ForsetiConfig.b() == false) goto L25;
        if (r1 == false) goto L25;
        if (com.suite.lark.component.navroute.forseti.f.c(r3, true) == null) goto L25;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ViewModelStoreOwner r2 = ((sua.a) ApiUtils.getApi(sua.a.class)).getForegroundForsetiNodePieceFragment(r3);
        if (r2 != null) goto L22;
        tt5.a.k("ForsetiViewModelProvider", "findForegroundFragmentInForseti: fragment is null");
        goto L25
    L22:
        if (r2.getHost() != null) goto L24;
        tt5.a.k("ForsetiViewModelProvider", "findForegroundFragmentInForseti: " + Reflection.getOrCreateKotlinClass(r2.getClass()).getSimpleName() + " host is null");
        goto L25
    L24:
        r0 = r2;
        goto L25
    L7:
        if (com.suite.lark.component.navroute.forseti.f.c(r3, true) == null) goto L11;
        if (DowngradeSettingUtil.a("downgradeProviderForsetiNode") == true) goto L11;
        r4 = true;
    L25:
        tt5.a.h("ForsetiViewModelProvider", r0 + " provide " + r8);
        return (T) new ViewModelProvider(r0, this.b).get(r8, r9);
    }
}
