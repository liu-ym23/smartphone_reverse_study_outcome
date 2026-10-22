package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.halfscreen.PhotoPickerParam;
import com.ss.android.lark.widget.halfscreen.PhotoPreviewPickerParam;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.j;
import com.ss.android.lark.widget.photopicker.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkPhotoPickerListener implements LarkPhotoPickerView.d {
    public final FileSelectFragment a;
    public final Function2<? super List<Photo>, ? super Boolean, Unit> b;

    public static final class a {
    }

    public static final class b implements LarkPhotoPickerView.d.a {
        public final /* synthetic */ LarkPhotoPickerListener a;

        public final /* synthetic */ void b() {
        }

        public final /* synthetic */ boolean d() {
            return false;
        }

        public final /* synthetic */ boolean e() {
            return false;
        }

        public final /* synthetic */ void f(List r1, boolean r2) {
        }

        public final /* synthetic */ void g(Photo r1, boolean r2, boolean r3) {
        }

        public final /* synthetic */ void i(List r1, boolean r2) {
        }

        public b(LarkPhotoPickerListener r1) {
            this.a = r1;
        }

        public final void a(int r5) {
            LarkPhotoPickerListener r0 = this.a;
            FileSelectConfig r1 = r0.a.h;
            Integer r2 = null;
            if (r1 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r1.showVideo);
        L6:
            if (r1 == null) goto L8;
            r2 = Integer.valueOf(r1.totalMaxPhotoCount);
        L8:
            r0.e(r3, r2, r5);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public final void c(int r2) {
            FragmentActivity r0 = this.a.a.getActivity();
            if (r0 == null) goto L6;
            LKUIToast.show(r0, UIHelper.getString(r2));
            return;
        }

        public final void h(List<Photo> r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "photos");
            Intrinsics.checkNotNullParameter(r4, "chooseImageSource");
            this.a.b.invoke(r2, Boolean.valueOf(r3));
        }
    }

    public static final class c implements com.ss.android.lark.widget.photopicker.b {
        public c() {
        }

        public final void onIntercept(String r1) {
        }
    }

    static {
    }

    public final void a() {
        tt5.a.h("LarkPhotoPickerListener", "onCameraSelected...");
        final FileSelectConfig r1 = FileSelectConfig.buildFileSelectConfig(this.a.h);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.maxSelectImageNum > 0) goto L8;
        tt5.a.h("LarkPhotoPickerListener", "maxSelectImageNum <= 0, should't open camera");
        e(Boolean.valueOf(r1.showVideo), Integer.valueOf(r1.totalMaxPhotoCount), r1.maxSelectImageNum);
        return;
    L8:
        boolean r0 = r1.showVideo;
        if (r0 == false) goto L11;
        int r2 = 2;
    L12:
        r1.mediaType = r2;
        r1.showTakePhoto = true;
        r1.showTakeVideo = r0;
        int r3 = h.a;
        final FileSelectFragment r4 = this.a;
        final Context r5 = r4.getContext();
        if (r5 == null) goto L17;
        com.bytedance.ee.bear.fileselector.a.a(r5, new LarkPhotoPickerListener$onCameraSelected$lambda$1$$inlined$openLarkCamara$1(r5, r4, r1, r5));
        return;
    L17:
        return;
    L11:
        r2 = 0;
        goto L12
    }

    public final LarkPhotoPickerView.d.a c() {
        return new b(this);
    }

    public final void b(PhotoPreviewPickerParam r6) {
        tt5.a.h("LarkPhotoPickerListener", "onPreviewSelected...");
        if (this.a.getActivity() != null) goto L5;
        return;
    L5:
        j r0 = new j();
        r0.a(new ArrayList(r6.getPhotos()));
        int r1 = r6.getCurrentPosition();
        r0.a.putInt("current_item", r1);
        r0.b = r6.getSourceView();
        boolean r3 = false;
        r0.a.putBoolean("show_delete", false);
        boolean r2 = r6.isKeepOrigin();
        r0.a.putBoolean("keep_origin", r2);
        int r4 = r6.getPhotoCount();
        r0.a.putInt("MAX_COUNT", r4);
        ArrayList r5 = new ArrayList(r6.getSelectedPhotoPaths());
        r0.a.putSerializable("SELECTED_ITEMS", r5);
        FileSelectConfig r7 = this.a.h;
        if (r7 != null) goto L8;
    L10:
        r0.a.putBoolean("IS_SEND", r3);
        int r8 = r6.getMediaType();
        r0.a.putInt("MEDIA_TYPE", r8);
        FileSelectConfig r9 = this.a.h;
        if (r9 == null) goto L13;
        int r10 = r9.totalMaxPhotoCount;
    L14:
        r0.a.putInt("TOTAL_MAX_COUNT", r10);
        boolean r11 = r6.isUseTransitionAnim();
        r0.a.putBoolean("is_use_transition_anim", r11);
        r0.b(this.a.requireContext(), this.a);
        return;
    L13:
        r10 = -1;
        goto L14
    L8:
        if (r7.actionType != 0) goto L10;
        r3 = true;
        goto L10
    }

    public final void d(PhotoPickerParam r4) {
        tt5.a.h("LarkPhotoPickerListener", "onAlbumSelected...");
        FileSelectConfig r0 = FileSelectConfig.buildFileSelectConfig(this.a.h);
        if (r0 == null) goto L18;
        int r2 = 0;
        if (r0.showVideo == true) goto L7;
        int r1 = 0;
    L11:
        r0.mediaType = r1;
        r0.showOrigin = r4.isShown();
        r0.checkedKeepOrigin = r4.isKeepOrigin();
        r0.selectLocalMedias = new ArrayList(r4.getImagesUri());
        r0.totalMaxPhotoCount = r0.totalMaxPhotoCount;
        if (r0.actionType != 0) goto L14;
        r2 = 1;
    L14:
        r0.larkAlbumActionType = r2;
        int r5 = h.a;
        FileSelectFragment r6 = this.a;
        Context r3 = r6.getContext();
        if (r3 == null) goto L19;
        int r7 = s.C;
        com.ss.android.lark.widget.photopicker.e r8 = new com.ss.android.lark.widget.photopicker.e(s.b.a(new PhotoPickerLauncher$openFullScreenAlbum$1$1$1(r0)));
        r8.d = new c();
        r8.b(r3, r6, 233);
        return;
    L19:
        return;
    L7:
        if (r0.mixSelect == false) goto L9;
        r1 = 2;
        goto L11
    L9:
        r1 = 3;
        goto L11
    }

    public LarkPhotoPickerListener(FileSelectFragment r2, Function2<? super List<Photo>, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "handlePhoto");
        this.a = r2;
        this.b = r3;
    }

    public final void e(Boolean r4, Integer r5, int r6) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r0) == false) goto L8;
        if (AppInfoUtils.f().booleanValue() == false) goto L8;
        String r1 = "num";
    L12:
        if (Intrinsics.areEqual(r4, r0) == true) goto L14;
        int r7 = 2131892078;
    L18:
        if (r5 != null) goto L21;
    L23:
        FragmentActivity r8 = this.a.getActivity();
        if (r8 == null) goto L27;
        UDToast.show(r8, UIHelper.mustacheFormat(r7, r1, String.valueOf(r5)));
        return;
    L27:
        return;
    L21:
        if ((-1) != r5.intValue()) goto L23;
        r5 = Integer.valueOf(r6);
        goto L23
    L14:
        if (AppInfoUtils.f().booleanValue() == false) goto L16;
        r7 = 2131889432;
        goto L18
    L16:
        r7 = 2131891905;
    L8:
        if (Intrinsics.areEqual(r4, r0) == false) goto L10;
        r1 = "number";
        goto L12
    L10:
        r1 = "max_count";
        goto L12
    }
}
