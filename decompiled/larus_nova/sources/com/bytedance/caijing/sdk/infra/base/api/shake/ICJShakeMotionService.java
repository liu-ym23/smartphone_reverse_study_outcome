package com.bytedance.caijing.sdk.infra.base.api.shake;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.Metadata;
import ne4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/shake/ICJShakeMotionService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", DownloadHelper.IDENTITY, "", "priority", "bpeaCert", "Lne4/a;", "createShakeMotionKit", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJShakeMotionService extends ICJService {
    a createShakeMotionKit(Context r100, String r101, int r102, String r103);
}
