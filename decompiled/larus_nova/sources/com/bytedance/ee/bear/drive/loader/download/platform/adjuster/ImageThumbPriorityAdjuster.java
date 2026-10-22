package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g85.b;
import g85.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q75.a;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/adjuster/ImageThumbPriorityAdjuster;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/adjuster/IPriorityAdjuster;", "mimeTypeManager", "Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeManager;", "driveConfig", "Lcom/bytedance/ee/bear/drive/config/fg/DriveConfig;", "<init>", "(Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeManager;Lcom/bytedance/ee/bear/drive/config/fg/DriveConfig;)V", "getMimeTypeManager", "()Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeManager;", "getDriveConfig", "()Lcom/bytedance/ee/bear/drive/config/fg/DriveConfig;", "getName", "", "adjust", "", "", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/IFileModel;", "source", "isServerSupportTypeReady", "", "type", "addImageThumbProcessor", "", "removeImageThumbProcessor", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageThumbPriorityAdjuster implements IPriorityAdjuster {
    public static final Companion Companion = null;
    private static final String TAG = "DrivePlatform_ImageThumbPriorityAdjuster";
    private final a driveConfig;
    private final f mimeTypeManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/adjuster/ImageThumbPriorityAdjuster$Companion;", "", "<init>", "()V", "TAG", "", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "ImageThumbPriorityAdjuster";
    }

    public final a getDriveConfig() {
        return this.driveConfig;
    }

    public final f getMimeTypeManager() {
        return this.mimeTypeManager;
    }

    private final void addImageThumbProcessor(List<Integer> r100) {
        if (r100.contains(-4) == true) goto L6;
        ListProtector.add(r100, 0, -4);
        return;
    }

    private final void removeImageThumbProcessor(List<Integer> r100) {
        r100.remove(-4);
    }

    public ImageThumbPriorityAdjuster(f r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mimeTypeManager");
        Intrinsics.checkNotNullParameter(r101, "driveConfig");
        this.mimeTypeManager = r100;
        this.driveConfig = r101;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c<?> r100, List<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "fileModel");
        Intrinsics.checkNotNullParameter(r101, "source");
        f r102 = this.mimeTypeManager;
        b r103 = (b) r102;
        if (r103.j(r100.I(), null) == true) goto L6;
        return r101;
    L6:
        if (r100.G() == false) goto L8;
    L14:
        removeImageThumbProcessor(r101);
    L15:
        return r101;
    L8:
        if (r100.F() == true) goto L14;
        if (isServerSupportTypeReady(11, r100, r101) == true) goto L15;
        if (isServerSupportTypeReady(12, r100, r101) == true) goto L15;
        addImageThumbProcessor(r101);
        goto L15
    }

    private final boolean isServerSupportTypeReady(int r100, c<?> r101, List<Integer> r102) {
        if (r102.contains(Integer.valueOf(r100)) == true) goto L7;
        tt5.a.h(TAG, "image thumb type=" + r100 + " not found");
        return false;
    L7:
        if (r101.b() != null) goto L10;
        tt5.a.k(TAG, "image thumb type=" + r100 + " metaMap is null");
        return false;
    L10:
        PreviewMeta r103 = r101.b().get(r100);
        if (r103 != null) goto L13;
    L16:
        tt5.a.h(TAG, "image thumb type=" + r100 + ", linear is running");
        return false;
    L13:
        if (r103.getStatus() != 0) goto L16;
        tt5.a.h(TAG, "image thumb type=" + r100 + ", linear is ready");
        return true;
    }
}
