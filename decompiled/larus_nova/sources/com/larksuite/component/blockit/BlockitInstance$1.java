package com.larksuite.component.blockit;

import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.service.BlockitService;
import com.larksuite.component.blockit.service.IGetDataCallbackWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes24.dex */
class BlockitInstance$1 implements IGetDataCallbackWrapper<BlockEntity> {
    final /* synthetic */ b this$0;
    final /* synthetic */ String val$blockId;
    final /* synthetic */ com.larksuite.component.blockit.core.a val$blockitContext;
    final /* synthetic */ boolean val$enableEntityCache;
    final /* synthetic */ c val$listener;
    final /* synthetic */ com.larksuite.component.blockit.core.b val$opContainerBundle;
    final /* synthetic */ Set val$providerSet;
    final /* synthetic */ ViewGroup val$rootView;
    final /* synthetic */ BlockEntity val$sourceEntity;
    final /* synthetic */ long val$startEntityTimestamp;

    @Override // com.larksuite.component.blockit.service.IGetDataCallbackWrapper, com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public final /* synthetic */ void onSuccess(Object r100) {
        IGetDataCallbackWrapper.CC.$default$onSuccess(this, r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        AppBrandLogger.i("BlockitInstance", new Object[]{"request blockTypeId onError " + r100.getDebugMsg()});
        if (r100.getStatus() != 1) goto L5;
        d r101 = (d) ApiUtils.getApi(d.class);
        ncb.b r102 = ncb.b.f518680a;
        r101.f();
    L6:
        r100.getDisplayMsg();
        throw null;
    L5:
        d r103 = (d) ApiUtils.getApi(d.class);
        ncb.b r104 = ncb.b.f518680a;
        r103.f();
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public void onSuccess2(BlockEntity r100, IGetDataCallbackWrapper.a r101) {
        AppBrandLogger.i("BlockitInstance", new Object[]{"request block success, blockId:" + this.val$blockId});
        r100.setAppID(this.val$sourceEntity.getAppID());
        com.larksuite.component.blockit.core.b r102 = this.val$opContainerBundle;
        b r103 = this.this$0;
        ncb.b r104 = ncb.b.f518685f;
        r103.getClass();
        OPMonitor r105 = b.a(r104, r102, r100).setResultTypeSuccess().addCategoryValue("use_cache", Integer.valueOf(r101.f283136a ? 1 : 0)).addCategoryValue("enable_cache", Boolean.valueOf(((BlockitService.BlockCacheMGetBlockEntityV2ConfigModel) SettingManager.getInstance().get(BlockitService.BlockCacheMGetBlockEntityV2ConfigModel.class)).enable)).addCategoryValue("use_cache_when_fetch_fail", Boolean.valueOf(this.val$enableEntityCache)).addCategoryValue(LocationMonitorConst.CACHE_TIMESTAMP, Long.valueOf(r101.f283137b));
        if (r101.f283136a == false) goto L5;
        String r106 = "cache";
    L6:
        r105.addCategoryValue("from", r106).addMetricValue("duration", Long.valueOf(System.currentTimeMillis() - this.val$startEntityTimestamp)).flush();
        b r107 = this.this$0;
        ncb.b r108 = ncb.b.f518680a;
        com.larksuite.component.blockit.core.b r109 = this.val$opContainerBundle;
        r107.getClass();
        b.a(r108, r109, r100).addCategoryValue(BitableResourceData.KEY_BLOCK_ID, r100.getBlockID()).setResultTypeSuccess().flush();
        ((d) ApiUtils.getApi(d.class)).d();
        return;
    L5:
        r106 = "network";
        goto L6
    }

    @Override // com.larksuite.component.blockit.service.IGetDataCallbackWrapper
    public /* bridge */ /* synthetic */ void onSuccess(BlockEntity r100, IGetDataCallbackWrapper.a r101) {
        onSuccess2(r100, r101);
    }

    public BlockitInstance$1(b r100, String r101, BlockEntity r102, com.larksuite.component.blockit.core.b r103, boolean r104, long r105, ViewGroup r106, c r107, Set r110, com.larksuite.component.blockit.core.a r111) {
        this.this$0 = r100;
        this.val$blockId = r101;
        this.val$sourceEntity = r102;
        this.val$opContainerBundle = r103;
        this.val$enableEntityCache = r104;
        this.val$startEntityTimestamp = r105;
        this.val$rootView = r106;
        this.val$providerSet = r110;
    }
}
