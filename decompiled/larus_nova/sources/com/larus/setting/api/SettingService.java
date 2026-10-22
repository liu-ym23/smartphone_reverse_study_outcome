package com.larus.setting.api;

import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.setting.api.trace.ISettingTrackApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016JJ\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J \u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010)\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00061"}, d2 = {"Lcom/larus/setting/api/SettingService;", "Lcom/larus/setting/api/ISettingApi;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/ISettingApi;", "impl$delegate", "Lkotlin/Lazy;", "getSettingTrackImpl", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "openChangeAppIconPage", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFrom", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "localConversationId", "conversationId", "previousPage", "pendingDeeplinkSchema", "setEnableShowSynDialog", "enable", "", "preloadAppDynamicIcons", "initRegisterAppBackGroundListener", "setEnableBackGroundUpdate", "enableBackGroundUpdate", "getFindSettingsItemList", "", "Lcom/larus/setting/api/data/SettingsSection;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotifySettingItems", "isAppNotifyEnable", "application", "Landroid/app/Application;", "isAppNotifyDetailEnable", "jumpPrivacyModelTrainingPage", "bindManualCacheCleanEntry", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "entryView", "Landroid/view/View;", "currentPage", "trackNode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingService implements ISettingApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingService f367887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f367888b = null;

    private SettingService() {
    }

    static {
        f367887a = new SettingService();
        f367888b = LazyKt.lazy(new v());
    }

    public static ISettingApi l() {
        return (ISettingApi) f367888b.getValue();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final ISettingTrackApi f() {
        ISettingApi r100 = l();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void g() {
        ISettingApi r100 = l();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void i() {
        ISettingApi r100 = l();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void k() {
        ISettingApi r100 = l();
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final List<zs9.c> a(FragmentActivity r100) {
        ISettingApi r101 = l();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean e(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        ISettingApi r101 = l();
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.e(r100);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final boolean h(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        ISettingApi r101 = l();
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.h(r100);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void j(Context r100) {
        ISettingApi r101 = l();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final Object d(FragmentActivity r100, Continuation<? super List<zs9.c>> r101) {
        ISettingApi r102 = l();
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.d(r100, r101);
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void c(Fragment r100, View r101, String r102, by7.e r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        ISettingApi r104 = l();
        if (r104 != null) goto L12;
        if (r101 == null) goto L14;
        r101.setVisibility(8);
        return;
    L14:
        return;
    L12:
        r104.c(r100, r101, r102, r103);     // Catch: AbstractMethodError -> L9
        return;
    L9:
        if (r101 == null) goto L15;
        r101.setVisibility(8);
        return;
    }

    @Override // com.larus.setting.api.ISettingApi
    public final void b(Context r110, String r111, by7.e r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        ISettingApi r100 = l();
        if (r100 == null) goto L6;
        r100.b(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
