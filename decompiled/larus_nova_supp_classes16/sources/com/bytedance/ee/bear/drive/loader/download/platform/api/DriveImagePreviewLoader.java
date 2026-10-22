package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveImagePreviewLoader;", "Lcom/bytedance/ee/bear/drive/loader/IDriveImagePreviewLoader;", "<init>", "()V", "fileInfoLoader", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveFileInfoLoader;", "fetchDriveImagePreview", "Lcom/bytedance/ee/bear/drive/callback/ICancelable;", "fileToken", "", "callback", "Lcom/bytedance/ee/bear/drive/callback/IDriveImagePreviewCallBack;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImagePreviewLoader implements a85.b {
    public static final Companion Companion = null;
    private static final String TAG = "DriveImagePreviewLoader";
    private final DriveFileInfoLoader fileInfoLoader;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveImagePreviewLoader$Companion;", "", "<init>", "()V", "TAG", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DriveImagePreviewLoader() {
        ((hb5.a) LarkContext.spiByDwarf(hb5.a.class)).checkAndInit();
        this.fileInfoLoader = new DriveFileInfoLoader();
    }

    @Override // a85.b
    public h75.a fetchDriveImagePreview(final String r3, final h75.c r4) {
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.h(TAG, "fetchDriveImagePreview start: fileToken=" + du5.b.k(r3));
        return this.fileInfoLoader.fetchFileInfo(r3, null, new AnonymousClass1(r3, r4));
    }
}
