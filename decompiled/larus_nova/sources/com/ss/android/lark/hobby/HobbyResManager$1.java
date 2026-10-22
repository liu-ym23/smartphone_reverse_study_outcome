package com.ss.android.lark.hobby;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.byted.cast.common.source.ISendResultListener;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ug.brand.PullTenantBuildResourceResponse;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import java.io.File;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
class HobbyResManager$1 implements IGetDataCallback<PullTenantBuildResourceResponse> {
    final /* synthetic */ d this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$tid;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.e("HobbyResManager", "PullTenantBuildResource onError", r100, true);
    }

    public void onSuccess(PullTenantBuildResourceResponse r110) {
        if (r110 != null) goto L5;
        onError(new ErrorResult(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL));
        return;
    L5:
        String r100 = r110.mresource_url;
        final String r101 = r110.mtask_id;
        Log.i("HobbyResManager", "PullTenantBuildResource onSuccess, resourceUrl: " + r100 + ", taskId: " + r101);
        final d r102 = this.this$0;
        final Context r103 = this.val$context;
        final String r104 = this.val$tid;
        r102.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L8;
    L14:
        Log.e("HobbyResManager", "taskId or resourceUrl is empty, taskId: " + r101 + ", resourceUrl: " + r100);
        return;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        String r111 = UserSP.getInstance().getString("hobby_res_task_id", "");
        Log.i("HobbyResManager", "lastTaskId: " + r111);
        if (r111.compareTo(r101) >= 0) goto L17;
        final String r112 = Integer.toString(r101.hashCode());
        String r105 = d.d(r104);
        StringBuilder r106 = new StringBuilder();
        StringBuilder r107 = new StringBuilder();
        StringBuilder r108 = new StringBuilder();
        r108.append(d.c(r103));
        String r113 = File.separator;
        r108.append(r113);
        r108.append(r105);
        r107.append(r108.toString());
        r107.append("_zip");
        r106.append(r107.toString());
        r106.append(r113);
        r106.append(AeUtil.RESZIPNAME);
        final String r109 = r106.toString();
        ((e) ApiUtils.getApi(e.class)).addPushPushResourceListener(new b(r102, r112, r103, r104, r109, r101));
        ((e) ApiUtils.getApi(e.class)).downloadResource(r112, r109, r100);
        Log.i("HobbyResManager", "download ka dynamic resource start");
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PullTenantBuildResourceResponse) r100);
    }

    public HobbyResManager$1(d r100, Context r101, String r102) {
        this.this$0 = r100;
        this.val$context = r101;
        this.val$tid = r102;
    }
}
