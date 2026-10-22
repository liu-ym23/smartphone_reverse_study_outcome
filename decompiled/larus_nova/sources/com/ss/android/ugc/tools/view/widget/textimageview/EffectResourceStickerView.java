package com.ss.android.ugc.tools.view.widget.textimageview;

import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import com.ss.android.ugc.tools.CukaieManifest;
import com.ss.android.ugc.tools.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class EffectResourceStickerView extends com.ss.android.ugc.tools.view.widget.textimageview.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InvokeDownloadingMethod f455201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f455202h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/textimageview/EffectResourceStickerView$InvokeDownloadingMethod;", "", "STATE_DOWNLOADED", "STATE_DOWNLOADING", "STATE_DOWNLOAD_PROGRESS", "STATE_NOT_DOWNLOAD", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public static final enum InvokeDownloadingMethod extends Enum<InvokeDownloadingMethod> {
        public static final InvokeDownloadingMethod STATE_DOWNLOADED = null;
        public static final InvokeDownloadingMethod STATE_DOWNLOADING = null;
        public static final InvokeDownloadingMethod STATE_DOWNLOAD_PROGRESS = null;
        public static final InvokeDownloadingMethod STATE_NOT_DOWNLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InvokeDownloadingMethod[] f455203a = null;

        static {
            InvokeDownloadingMethod r100 = new InvokeDownloadingMethod("STATE_DOWNLOADED", 0);
            STATE_DOWNLOADED = r100;
            InvokeDownloadingMethod r101 = new InvokeDownloadingMethod("STATE_DOWNLOADING", 1);
            STATE_DOWNLOADING = r101;
            InvokeDownloadingMethod r102 = new InvokeDownloadingMethod("STATE_DOWNLOAD_PROGRESS", 2);
            STATE_DOWNLOAD_PROGRESS = r102;
            InvokeDownloadingMethod r103 = new InvokeDownloadingMethod("STATE_NOT_DOWNLOAD", 3);
            STATE_NOT_DOWNLOAD = r103;
            f455203a = new InvokeDownloadingMethod[]{r100, r101, r102, r103};
        }

        public static InvokeDownloadingMethod valueOf(String r100) {
            return (InvokeDownloadingMethod) r27.a.a(InvokeDownloadingMethod.class, r100);
        }

        public static InvokeDownloadingMethod[] values() {
            return (InvokeDownloadingMethod[]) f455203a.clone();
        }

        public InvokeDownloadingMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    private final ImageView getDownloadImgCenterOpt() {
        throw null;
    }

    private final ViewStub getLibraryLayoutStub() {
        throw null;
    }

    public final int getCenterLoadingIconRes() {
        return 0;
    }

    public final int getDownloadIconRes() {
        return 0;
    }

    public final boolean getEnableDotView() {
        return false;
    }

    public final int getLoadingIconRes() {
        return 0;
    }

    public final boolean getShouldShowDownloadImg() {
        return false;
    }

    public final boolean getUseCenterLoadingImg() {
        return false;
    }

    public final void setShowDownloadIcon(boolean r100) {
    }

    static {
        i.a(CukaieManifest.a(), 2.0f);
        i.a(CukaieManifest.a(), 3.0f);
    }

    private final ImageView getDownloadImgCenter() {
        ViewParent r100 = null;
        if (getEnableSimplifyLayout() == false) goto L13;
        ViewStub r101 = getLibraryLayoutStub();
        if (r101 == null) goto L7;
        r100 = r101.getParent();
    L7:
        if (r100 == null) goto L12;
        ViewStub r102 = getLibraryLayoutStub();
        if (r102 == null) goto L12;
        r102.inflate();
    L12:
        return getDownloadImgCenterOpt();
    L13:
        return null;
    }

    public final boolean getEnableSimplifyLayout() {
        if (getSimpleLayoutMode() == false) goto L7;
        shc.a.f542086b.f542087a.getClass();
        return false;
    L7:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InvokeDownloadingMethod r100 = this.f455201g;
        if (r100 == null) goto L25;
        int r101 = b.f455210a[r100.ordinal()];
        if (r101 != 1) goto L7;
        this.f455201g = InvokeDownloadingMethod.STATE_DOWNLOADED;
        Intrinsics.throwUninitializedPropertyAccessException("downloadImg");
        throw null;
    L7:
        if (r101 != 2) goto L9;
        this.f455201g = InvokeDownloadingMethod.STATE_NOT_DOWNLOAD;
        Intrinsics.throwUninitializedPropertyAccessException("downloadImg");
        throw null;
    L9:
        if (r101 != 3) goto L11;
        this.f455201g = InvokeDownloadingMethod.STATE_DOWNLOADING;
        Intrinsics.throwUninitializedPropertyAccessException("downloadImg");
        throw null;
    L11:
        if (r101 != 4) goto L26;
        Integer r102 = this.f455202h;
        if (r102 == null) goto L17;
        int r103 = r102.intValue();
        this.f455201g = InvokeDownloadingMethod.STATE_DOWNLOAD_PROGRESS;
        this.f455202h = Integer.valueOf(r103);
        Intrinsics.throwUninitializedPropertyAccessException("downloadImg");
        throw null;
    L17:
        this.f455201g = InvokeDownloadingMethod.STATE_DOWNLOADING;
        Intrinsics.throwUninitializedPropertyAccessException("downloadImg");
        throw null;
    L26:
        return;
    }
}
