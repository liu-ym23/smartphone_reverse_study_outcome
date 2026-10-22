package up9;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public abstract class a implements g0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f551074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaGalleryLiveDataViewModel f551075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaMobViewModel f551076c;

    /* JADX INFO: renamed from: up9.a$a, reason: collision with other inner class name */
    public static final class C7915a implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f551077a;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public C7915a(a r100) {
            this.f551077a = r100;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            Set r104 = CollectionsKt.toSet(CollectionsKt.filterNotNull(r101));
            boolean r105 = r104.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
            boolean r106 = r104.contains(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
            boolean r107 = r104.contains(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
            MediaGalleryLiveDataViewModel r108 = this.f551077a.f551075b;
            int r109 = 1;
            if (r108 == null) goto L9;
            MediaGalleryUIConfig r110 = r108.getUiConfig();
            if (r110 == null) goto L9;
            if (r110.f364490g != true) goto L9;
            boolean r111 = true;
        L10:
            if (r111 == false) goto L15;
            if (r106 == false) goto L14;
            if (r107 == false) goto L14;
            r106 = true;
        L14:
            r106 = false;
        L15:
            if (r106 == true) goto L20;
            if (r105 == false) goto L19;
            r109 = 2;
            goto L20
        L19:
            r109 = 0;
        L20:
            com.larus.platform.service.o r112 = com.larus.platform.service.o.f365780a;
            JSONObject r113 = new JSONObject();
            r113.put("result", r109);
            Unit r114 = Unit.INSTANCE;
            r112.reportEvent("rd_request_image_permission", r113);
            if (r101.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L25;
            FLogger.f375446a.i("AbsMediaSelectorListState", "READ_MEDIA_VISUAL_USER_SELECTED granted");
            MediaGalleryLiveDataViewModel r115 = this.f551077a.f551075b;
            if (r115 == null) goto L27;
            r115.refreshMediaFoldersAfterPermissionChange();
            return;
        L27:
            return;
        L25:
            FLogger.f375446a.i("AbsMediaSelectorListState", "registerForActivityResult false");
            return;
        L9:
            r111 = false;
            goto L10
        }
    }

    private final void requestPermissions(List<String> r100) {
        FragmentActivity r101 = this.f551074a.getActivity();
        if (r101 == null) goto L6;
        i2 r102 = i2.f365748b;
        Fragment r103 = this.f551074a;
        C7915a r104 = new C7915a(this);
        JSONObject r105 = new JSONObject();
        r105.put("enter_method", "album");
        r102.j(r103, r101, r100, r105, r104);
        return;
    }

    public a(MediaSelectorListFragment r100, MediaGalleryLiveDataViewModel r101, MediaMobViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f551074a = r100;
        this.f551075b = r101;
        this.f551076c = r102;
    }

    @Override // up9.g0.b
    public void a(op9.d r100, int r110, ClickType r111) {
        Intrinsics.checkNotNullParameter(r100, "mediaItem");
        Intrinsics.checkNotNullParameter(r111, "type");
        boolean r112 = false;
        if (r111 != ClickType.ON_FIRST_IMAGE_LOAD_SUCCESS) goto L8;
        MediaMobViewModel r101 = this.f551076c;
        if (r101 == null) goto L8;
        JSONObject r102 = new JSONObject();
        r102.put("first_frame_thumb_count", 1);
        r102.put("first_frame_error_count", 0);
        r101.loadFrameEnd(r102);
    L8:
        if (r111 != ClickType.ON_FIRST_IMAGE_LOAD_FAILURE) goto L13;
        MediaMobViewModel r103 = this.f551076c;
        if (r103 == null) goto L13;
        JSONObject r104 = new JSONObject();
        r104.put("first_frame_thumb_count", 0);
        r104.put("first_frame_error_count", 1);
        r103.loadFrameEnd(r104);
    L13:
        if (r111 != ClickType.ADD_MORE_PHOTO) goto L28;
        int r105 = pp9.c.f530227b;
        long r106 = System.currentTimeMillis();
        if ((r106 - pp9.c.f530226a) >= 500) goto L17;
        r112 = true;
    L18:
        if (r112 == false) goto L21;
        return;
    L21:
        if (Build.VERSION.SDK_INT < 34) goto L26;
        requestPermissions(CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}));
        MediaMobViewModel r107 = this.f551076c;
        if (r107 == null) goto L25;
        r107.mobClickAddChosenPic();
    L25:
        FLogger.f375446a.i("AbsMediaSelectorListState", "request beyond UPSIDE_DOWN_CAKE");
        return;
    L26:
        FLogger.f375446a.i("AbsMediaSelectorListState", "request under UPSIDE_DOWN_CAKE");
        return;
    L17:
        pp9.c.f530226a = r106;
        goto L18
    }
}
