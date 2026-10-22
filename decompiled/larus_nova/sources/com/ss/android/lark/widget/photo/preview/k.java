package com.ss.android.lark.widget.photo.preview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.NetworkUtils;
import com.larksuite.framework.utils.h0;
import com.larksuite.framework.utils.z;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.player.IMPlayerSettings;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.OriginalMediaHandler;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f446736a = 0;

    public static final class a {
        @JvmStatic
        public static c a(List r100, int r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "photoItemList");
            return new c(r100, r101, r102);
        }
    }

    public static final class b {

        public static final class a {
        }

        static {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f446737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f446738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ActivityTransitionLauncher.LocationInfo f446739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<? extends PhotoItem> f446740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f446741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Handler f446742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final DownloadCheckUtil.a f446743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Biz f446744h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Scene f446745i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f446746j;

        public final void b(EnterSource r100) {
            this.f446737a.putSerializable(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE, r100);
        }

        public final void c(int r100) {
            boolean r101 = true;
            if ((r100 & 1) == 0) goto L5;
            boolean r102 = true;
        L6:
            this.f446737a.putBoolean("show_delete", r102);
            if ((r100 & 2) == 0) goto L9;
            boolean r103 = true;
        L10:
            l(r103);
            if ((r100 & 4) == 0) goto L13;
            boolean r104 = true;
        L14:
            j(r104);
            if ((r100 & 8) == 0) goto L17;
            boolean r105 = true;
        L18:
            n(r105);
            if ((r100 & 16) == 0) goto L21;
            boolean r106 = true;
        L22:
            h(r106);
            if ((r100 & 32) == 0) goto L25;
            boolean r107 = true;
        L26:
            o(r107);
            if ((r100 & 2048) == 0) goto L29;
            boolean r108 = true;
        L30:
            m(r108);
            if ((r100 & 64) == 0) goto L33;
            boolean r109 = true;
        L34:
            this.f446737a.putBoolean("show_qr_code", r109);
            if ((r100 & 128) == 0) goto L37;
            boolean r110 = true;
        L38:
            this.f446737a.putBoolean("show_edit", r110);
            if ((r100 & 256) == 0) goto L41;
            boolean r111 = true;
        L42:
            this.f446737a.putBoolean("show_photo_title_bar", r111);
            if ((r100 & 512) == 0) goto L45;
            boolean r112 = true;
        L46:
            k(r112);
            if ((r100 & 1024) == 0) goto L49;
            boolean r113 = true;
        L50:
            p(r113);
            if ((r100 & 4096) != 0) goto L54;
            r101 = false;
        L54:
            g(r101);
            return;
        L49:
            r113 = false;
            goto L50
        L45:
            r112 = false;
            goto L46
        L41:
            r111 = false;
            goto L42
        L37:
            r110 = false;
            goto L38
        L33:
            r109 = false;
            goto L34
        L29:
            r108 = false;
            goto L30
        L25:
            r107 = false;
            goto L26
        L21:
            r106 = false;
            goto L22
        L17:
            r105 = false;
            goto L18
        L13:
            r104 = false;
            goto L14
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L6
        }

        public final void d(boolean r100) {
            this.f446737a.putBoolean("is_mute", r100);
        }

        public final void e(boolean r100) {
            this.f446737a.putBoolean("extra_is_secure", r100);
        }

        public final void f(OperateListener r100) {
            if (r100 == null) goto L5;
            this.f446737a.putSerializable("operate_listener", r100);
            return;
        }

        public final void g(boolean r100) {
            this.f446737a.putBoolean("show_copy_image", r100);
        }

        public final void h(boolean r100) {
            this.f446737a.putBoolean("show_show_forward", r100);
        }

        public final void i(boolean r100) {
            this.f446737a.putBoolean("show_image_ocr", r100);
        }

        public final void j(boolean r100) {
            this.f446737a.putBoolean("show_jump_chat", r100);
        }

        public final void k(boolean r100) {
            this.f446737a.putBoolean("show_photo_index_label", r100);
        }

        public final void l(boolean r100) {
            this.f446737a.putBoolean("show_save", r100);
        }

        public final void m(boolean r100) {
            this.f446737a.putBoolean("show_save_sticker", r100);
        }

        public final void n(boolean r100) {
            this.f446737a.putBoolean("show_save_to_driver", r100);
        }

        public final void o(boolean r100) {
            this.f446737a.putBoolean("show_translation", r100);
        }

        public final void p(boolean r100) {
            this.f446737a.putBoolean("show_view_chat_image", r100);
        }

        public final void r(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            s(r100, null);
        }

        public final void t(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r101 = ViewUtils.getActivityByContext(r100);
            if (r101 == null) goto L6;
            r(r101);
            return;
        L6:
            Log.e("PhotoPreviewNew", "startCompat: context is not activity");
        }

        public final void u(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            s(r100, null);
        }

        public final void a(Context r110, Runnable r111) {
            if (NetworkUtils.d(r110) == true) goto L7;
            Application r100 = LarkContext.getApplication();
            if (NetworkUtils.d(r100) == true) goto L7;
            LKUIToast.show(r100, R.string.Lark_Setting_NameNetworkError);
        L7:
            List<? extends PhotoItem> r101 = this.f446740d;
            if (r101 == null) goto L109;
            List r102 = CollectionsKt.filterNotNull(r101);
            if (r102 == null) goto L110;
            Iterator r103 = r102.iterator();
        L13:
            if (r103.hasNext() == false) goto L15;
            ((PhotoItem) r103.next()).setDownloadCheckFlag(this.f446743g);
            goto L13
        L15:
            int r104 = this.f446741e;
            String r105 = null;
            if (r104 >= 0) goto L18;
        L20:
            PhotoItem r106 = null;
        L21:
            PhotoUtilsNew r107 = PhotoUtilsNew.f447142a;
            boolean r108 = true;
            if (r106 != null) goto L24;
        L94:
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "photoList");
            Intrinsics.checkNotNullParameter(r111, "failed");
            Log.i("PhotoUtilsNew", "routeToFileIfNeed");
            if (r106 != null) goto L97;
        L99:
            r108 = false;
        L100:
            if (r108 == true) goto L102;
        L104:
            OriginalMediaHandler.a(r102, r111);
            return;
        L102:
            if (TextUtils.isEmpty(r106.getMessageId()) == true) goto L104;
            OriginalMediaHandler.b(r110, r106.getMessageId(), new com.ss.android.lark.widget.photo.preview.utils.f(r102, r111));
            return;
        L97:
            if (r106.isVideo() != true) goto L99;
        L24:
            if (r106.isVideo() == false) goto L94;
            if (IMPlayerSettings.a().getClickPreloadEnable() != 1) goto L94;
            com.ss.android.lark.widget.photopicker.f.d r109 = com.ss.android.lark.widget.photopicker.f.a();
            String r112 = r106.getMediaExtra().getUrl();
            if (r112 != null) goto L30;
        L33:
            boolean r113 = true;
        L34:
            if (r113 == false) goto L36;
        L71:
            boolean r114 = false;
        L72:
            if (r114 == false) goto L94;
            if (LarkPlayerUtils.d() == false) goto L81;
            String r115 = r109.getSession();
            if (r115 == null) goto L94;
            LarkPlayerUtils.f438652a.getClass();
            LarkPlayerUtils.a();
            if (r112 != null) goto L80;
            r112 = "";
        L80:
            LarkPlayerUtils.e(r112, r106.getMessageId(), r115);
            goto L94
        L81:
            String r116 = r109.getUserId();
            if (r116 == null) goto L94;
            if (r116.length() <= 0) goto L86;
            boolean r117 = true;
        L87:
            if (r117 == false) goto L89;
            r105 = r116;
        L89:
            if (r105 == null) goto L94;
            LarkPlayerUtils.f438652a.getClass();
            LarkPlayerUtils.a();
            if (r112 != null) goto L93;
            r112 = "";
        L93:
            LarkPlayerUtils.f(r112, r106.getMessageId(), r105);
            goto L94
        L86:
            r117 = false;
            goto L87
        L36:
            if (FileUtils.r(r112) == true) goto L71;
            if (NetworkUtils.d(LarkContext.getApplication()) == false) goto L71;
            LarkPlayerUtils r118 = LarkPlayerUtils.f438652a;
            if (r112 == null) goto L42;
            String r119 = Integer.valueOf(r112.hashCode()).toString();
        L43:
            if (r119 != null) goto L45;
        L48:
            boolean r120 = true;
        L49:
            if (r120 == true) goto L68;
            String[] r121 = VFSFiles.f444819b.i(z0c.a.b()).list();
            if (r121 == null) goto L63;
            int r122 = r121.length;
            int r123 = 0;
        L53:
            if (r123 >= r122) goto L63;
            String r124 = r121[r123];
            if (r124 != null) goto L57;
        L59:
            boolean r125 = false;
        L60:
            if (r125 == true) goto L64;
            r123 = r123 + 1;
        L64:
            if (r124 == null) goto L66;
            boolean r126 = true;
        L67:
            Log.i("LarkPlayerUtils", "has cache:" + r126 + ", key:" + r119);
        L69:
            if (r126 == true) goto L71;
            r114 = true;
            goto L72
        L66:
            r126 = false;
            goto L67
        L57:
            if (StringsKt.contains$default(r124, r119, false, 2, null) != true) goto L59;
            r125 = true;
        L63:
            r124 = null;
            goto L64
        L68:
            r126 = false;
            goto L69
        L45:
            if (r119.length() == 0) goto L48;
            r120 = false;
            goto L49
        L42:
            r119 = null;
            goto L43
        L30:
            if (r112.length() == 0) goto L33;
            r113 = false;
            goto L34
        L18:
            if (r104 >= r102.size()) goto L20;
            r106 = (PhotoItem) ListProtector.get(r102, this.f446741e);
            goto L21
        L110:
            return;
        }

        public final void s(Activity r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Log.i("PhotoPreviewNew", "start");
            PerfPhotoViewMonitor r102 = PerfPhotoViewMonitor.f447616a;
            List<? extends PhotoItem> r103 = this.f446740d;
            int r104 = this.f446741e;
            r102.getClass();
            if (r103 == null) goto L8;
            if (r104 < 0) goto L8;
            if (r104 >= r103.size()) goto L8;
            PhotoItem r105 = (PhotoItem) ListProtector.get(r103, r104);
        L9:
            PerfPhotoViewMonitor.e(r105, this.f446744h, this.f446745i, this.f446746j);
            PerfPhotoViewMonitor.f(1);
            if (ForsetiConfig.a(r100) == false) goto L21;
            if (r101 == null) goto L21;
            Lazy r106 = PhotoPagerFgUtils.f447136a;
            boolean r107 = idb.f.a().isCurrentEnable("core.image_preview.enable_forseti");
            StringBuilder r108 = new StringBuilder("isEnableImagePreviewInForseti :");
            boolean r109 = true ^ r107;
            r108.append(r109);
            Log.i("PhotoPagerFgUtils", r108.toString());
            if (r109 == false) goto L21;
            if (com.ss.android.lark.widget.photopicker.utils.f.a(r100) == false) goto L17;
            KeyboardUtils.hideKeyboard(r100);
            this.f446742f.postDelayed(new l(this, r101), 50);
            return;
        L17:
            Context r110 = r101.getContext();
            if (r110 == null) goto L26;
            a(r110, new PhotoPreviewNew$PhotoPreviewBuilder$startImplInForseti$1$1(r110, this, r101, 666));
            return;
        L26:
            return;
        L21:
            if (com.ss.android.lark.widget.photopicker.utils.f.a(r100) == false) goto L23;
            KeyboardUtils.hideKeyboard(r100);
            this.f446742f.postDelayed(new m(this, r100), 50);
            return;
        L23:
            a(r100, new n(r100, this, 666));
            return;
        L8:
            r105 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Serializable, java.util.List[]] */
        public c(List<? extends PhotoItem> r100, int r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "photoItemList");
            Bundle r103 = new Bundle();
            this.f446737a = r103;
            this.f446738b = r102;
            this.f446740d = r100;
            this.f446741e = r101;
            this.f446742f = new Handler(Looper.getMainLooper());
            this.f446743g = new DownloadCheckUtil.a();
            Intrinsics.checkNotNullParameter(r100, "photoPaths");
            this.f446740d = r100;
            Log.i("PhotoPreviewNew", "setPhotos, size:" + r100.size());
            if (z.e(com.ss.android.lark.widget.photopicker.f.a().getContext()) == false) goto L5;
            h0.a.f285998a.b("key_photos_preview", r100);
            r103.putString("key_photos_preview", "key_photos_preview");
        L12:
            this.f446741e = r101;
            r103.putInt("current_item", r101);
            this.f446738b = r102;
            return;
        L5:
            List<? extends PhotoItem> r104 = r100;
            if (CollectionUtils.isEmpty(r104) == false) goto L8;
        L10:
            r103.putSerializable("photos_preview", new ArrayList(r104));
        L11:
            r103.putBoolean("direct_pass_photo_data", true);
            goto L12
        L8:
            if (r100.size() <= 20) goto L10;
            r103.putSerializable("photos_preview", CollectionUtils.split(r100, 20));
            goto L11
        }

        public final void q(Biz r100, Scene r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f446744h = r100;
            this.f446737a.putSerializable("biz", r100);
            this.f446745i = r101;
            this.f446737a.putSerializable("scene", r101);
            this.f446746j = r102;
            this.f446737a.putInt("from_type", r102);
        }
    }

    static {
    }
}
