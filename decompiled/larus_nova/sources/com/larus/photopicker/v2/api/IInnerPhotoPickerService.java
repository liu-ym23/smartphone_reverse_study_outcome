package com.larus.photopicker.v2.api;

import android.app.Activity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.photopicker.impl.ui.PhotoPickerFragment;
import com.larus.platform.api.a0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp9.a;
import lp9.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0012\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u000eH&¨\u0006\u0013"}, d2 = {"Lcom/larus/photopicker/v2/api/IInnerPhotoPickerService;", "", "getPhotoPickActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getAddPartImageManager", "Lcom/larus/photopicker/v2/api/IAddPartImageManager;", "getAlbumFastInputConfig", "Lcom/larus/photopicker/v2/api/IAlbumFastInputConfig;", "getBottomPhotoPickerPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "pageConfig", "Lcom/larus/platform/model/BottomPhotoPickerPageConfig;", "goPhotoPickerSettingPermissionActivity", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "loadFrameStart", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInnerPhotoPickerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f364187a = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/larus/photopicker/v2/api/IInnerPhotoPickerService$Companion;", "Lcom/larus/photopicker/v2/api/IInnerPhotoPickerService;", "<init>", "()V", "getAddPartImageManager", "Lcom/larus/photopicker/v2/api/IAddPartImageManager;", "getAlbumFastInputConfig", "Lcom/larus/photopicker/v2/api/IAlbumFastInputConfig;", "getBottomPhotoPickerPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "pageConfig", "Lcom/larus/platform/model/BottomPhotoPickerPageConfig;", "getPhotoPickActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "goPhotoPickerSettingPermissionActivity", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "loadFrameStart", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IInnerPhotoPickerService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f364188c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IInnerPhotoPickerService f364189b;

        static {
            f364188c = new Companion();
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final b b() {
            return this.f364189b.b();
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final void c() {
            this.f364189b.c();
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final Class<? extends Activity> d() {
            return this.f364189b.d();
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final a e() {
            return this.f364189b.e();
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final a0 f(b0 r100) {
            Intrinsics.checkNotNullParameter(r100, "pageConfig");
            return this.f364189b.f(r100);
        }

        @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
        public final void g(PhotoPickerFragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            this.f364189b.g(r100);
        }

        private Companion() {
            this.f364189b = (IInnerPhotoPickerService) ServiceManager.get().getService(IInnerPhotoPickerService.class);
        }
    }

    static {
        f364187a = Companion.f364188c;
    }

    b b();

    void c();

    Class<? extends Activity> d();

    a e();

    a0 f(b0 r100);

    void g(PhotoPickerFragment r100);
}
