package com.larus.bitable.sdk.api;

import com.bytedance.ee.bear.browser.plugin.i;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.larus.office.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import fo9.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0015H&J\u000e\u0010\u001b\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/larus/bitable/sdk/api/IBitableSdkService;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "openAndGetBitableFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "inputParam", "Lcom/larus/office/OfficeInputParam;", "listener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBaseMainAIChatVisibilityAbilities", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "preloadDocumentData", "", "tryPrefetchData", "", "notifyBottomPanelHeightChanged", "height", "", "notifyAIChatListFoldStatusChanged", "isFold", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBitableSdkService extends ISdkLifecycleV2 {
    List<i> D(h r100);

    Object a(Continuation<? super Unit> r100);

    boolean c(OfficeInputParam r100);

    void d(boolean r100);

    void i(int r100);

    Object v(OfficeInputParam r100, a r101, h r102, com.larus.office.container.impl.applet.i r103, Continuation r104);
}
