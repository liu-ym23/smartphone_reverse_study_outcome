package com.larus.drive.sdk.impl.viewmodel.preview;

import androidx.lifecycle.ViewModel;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.im.bean.message.ImageObj;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import y79.c;
import y79.d;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "buildSendDriveFileInfo", "Lcom/larus/drive/sdk/api/file/upload/SendDriveFileInfo;", "sendText", "", "file", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewViewModel extends ViewModel {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f342327a = null;

        static {
            int[] r100 = new int[DriveFileType.values().length];
            r100[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f342327a = r100;
        }
    }

    public DrivePreviewViewModel() {
    }

    public final c buildSendDriveFileInfo(String r210, DriveFileItem r211) {
        if (r211 == null) goto L5;
        DriveFileType r100 = r211.f341573j;
        int r101 = a.f342327a[r100.ordinal()];
        if (r101 == 1) goto L14;
        if (r101 != 2) goto L10;
        int r110 = 2;
    L15:
        ImageObj r102 = new ImageObj(r211.f341568e, 0, 0, null, null, 30, null);
        return new c(r210, ObricActionBarTrackType.KEY_BOARD, CollectionsKt.listOf(new d(r211.f341564a, r211.f341565b, r211.f341568e, r211.e(), r110, r211.f341567d, r102, r102, ISmModel.VERSION_0300)), 2);
    L10:
        if (r101 == 3) goto L12;
        r110 = 0;
        goto L15
    L12:
        r110 = 3;
        goto L15
    L14:
        r110 = 1;
        goto L15
    L5:
        return new c(null, null, null, 15);
    }
}
