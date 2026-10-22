package com.bytedance.gamecenter.base.order;

import com.bytedance.gamecenter.base.order.cache.TriggerDownloadRecordCacheImpl;
import com.bytedance.gamecenter.base.t;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class GlobalDownloadCompleteListener implements DownloadCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245011a;

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFailed(DownloadInfo r100, BaseException r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadStart(DownloadModel r100, DownloadController r101, DownloadEventConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "downloadMode");
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onInstalled(DownloadInfo r100, String r101) {
    }

    public GlobalDownloadCompleteListener() {
        this.f245011a = LazyKt.lazy(GlobalDownloadCompleteListener$triggerDownloadRecordCache$2.INSTANCE);
    }

    public static String b(DownloadInfo r100) {
        JSONObject r101 = new JSONObject(h.a().getSharedPreferences("sp_download_task_info", 0).getString(t.a(r100.getUrl()), "")).optJSONObject(EventConstant.Key.RAW_DATA);
        if (r101 == null) goto L5;
        JSONObject r102 = r101.optJSONObject("extra");
    L6:
        if (r102 == null) goto L8;
        String r103 = r102.optString("product_type");
    L9:
        if (r102 == null) goto L11;
        String r104 = r102.optString("unified_game_id");
    L13:
        if (Intrinsics.areEqual(BaseConstants.GAME_INFO_LIVE_UNION, r103) == false) goto L15;
        return r104;
    L15:
        return null;
    L11:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final void a(DownloadInfo r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        String r102 = b(r100);     // Catch: Throwable -> L4
        ((TriggerDownloadRecordCacheImpl) this.f245011a.getValue()).a(r102);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onCanceled(DownloadInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        a(r100);
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFinished(DownloadInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        a(r100);
    }
}
