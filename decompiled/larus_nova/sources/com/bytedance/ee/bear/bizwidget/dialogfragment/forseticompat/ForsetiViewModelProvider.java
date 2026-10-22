package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0096\u0002¢\u0006\u0002\u0010\rJ.\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModelProvider;", "Landroidx/lifecycle/ViewModelProvider;", "defaultStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getEffectiveStoreOwner", "storeOwner", "enable", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiViewModelProvider extends ViewModelProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewModelProvider.NewInstanceFactory f216459c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelStoreOwner f216460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelProvider.Factory f216461b;

    public static final class a {
        @JvmStatic
        public static ForsetiViewModelProvider a(ViewModelStoreOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "storeOwner");
            if ((r100 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
            ViewModelProvider.Factory r101 = ((HasDefaultViewModelProviderFactory) r100).getDefaultViewModelProviderFactory();
        L7:
            return new ForsetiViewModelProvider(r100, r101);
        L5:
            r101 = ForsetiViewModelProvider.f216459c;
            goto L7
        }
    }

    static {
        f216459c = new ViewModelProvider.NewInstanceFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public final <T extends ViewModel> T get(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        String r101 = r100.getCanonicalName();
        if (r101 == null) goto L7;
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r101), r100);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public ForsetiViewModelProvider(ViewModelStoreOwner r100, ViewModelProvider.Factory r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStoreOwner");
        Intrinsics.checkNotNullParameter(r101, "factory");
        super(r100, r101);
        this.f216460a = r100;
        this.f216461b = r101;
    }

    @Override // androidx.lifecycle.ViewModelProvider
    public final <T extends ViewModel> T get(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        ViewModelStoreOwner r102 = this.f216460a;
        boolean r103 = r102 instanceof FragmentActivity;
        if (r103 == false) goto L25;
        FragmentActivity r104 = (FragmentActivity) r102;
        Intrinsics.checkNotNullParameter(r104, "activity");
        if (ForsetiConfig.b() == true) goto L7;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L25;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (ForsetiConfig.b() == false) goto L25;
        if (r103 == false) goto L25;
        if (com.suite.lark.component.navroute.forseti.f.c(r104, true) == null) goto L25;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Fragment r106 = ((sua.a) ApiUtils.getApi(sua.a.class)).getForegroundForsetiNodePieceFragment(r104);
        if (r106 != null) goto L22;
        tt5.a.k("ForsetiViewModelProvider", "findForegroundFragmentInForseti: fragment is null");
        goto L25
    L22:
        if (r106.getHost() != null) goto L24;
        tt5.a.k("ForsetiViewModelProvider", "findForegroundFragmentInForseti: " + Reflection.getOrCreateKotlinClass(r106.getClass()).getSimpleName() + " host is null");
        goto L25
    L24:
        r102 = r106;
        goto L25
    L7:
        if (com.suite.lark.component.navroute.forseti.f.c(r104, true) == null) goto L11;
        if (DowngradeSettingUtil.a("downgradeProviderForsetiNode") == true) goto L11;
        r105 = true;
    L25:
        tt5.a.h("ForsetiViewModelProvider", r102 + " provide " + r100);
        return (T) new ViewModelProvider(r102, this.f216461b).get(r100, r101);
    }
}
