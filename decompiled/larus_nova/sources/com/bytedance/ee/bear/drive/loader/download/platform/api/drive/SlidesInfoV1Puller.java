package com.bytedance.ee.bear.drive.loader.download.platform.api.drive;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SheetInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SlidesInfoPuller;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/SlidesInfoV1Puller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SheetInfoPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SheetInfoPuller$Result;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "<init>", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "pull", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result;", "params", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Params;", "canRetry", "", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesInfoV1Puller extends BasePuller<SheetInfoPuller.Params, SheetInfoPuller.Result> {
    public static final Companion Companion = null;
    private static final String REQUEST_URL = "/space/api/slide/file_edit_type/";
    private static final String TAG = "DrivePlatform_SlidesInfoPuller";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/SlidesInfoV1Puller$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_URL", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SlidesInfoV1Puller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        super(r100, REQUEST_URL);
    }

    public final Flowable<SlidesInfoPuller.Result> pull(SlidesInfoPuller.Params r100, boolean r101) {
        a.h("DrivePlatform_SlidesInfoPuller", "V1 pullSlidesInfo start");
        return Flowable.just(SlidesInfoPuller.Result.Companion.buildWpsResult());
    }
}
