package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.keyboard.dtocompat.Image;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.statistics.PerfGalleryLoadMonitor;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class PhotoKBPlugin extends PanelMenuItem implements com.ss.android.lark.keyboard.base.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f429742w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f429743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f429744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.photo.a f429745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f429746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LarkPhotoPickerView f429747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommonLoadingDialog f429748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f429749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f429750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f429751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f429752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f429753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f429754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f429755p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n f429756q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final KeyboardMenuItemKey f429757r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g f429758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VideoSendChecker.a f429759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f429760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f429761v;

    public static final class a {
    }

    public interface b {
        void a(List<Photo> r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429762a = null;

        static {
            int[] r100 = new int[KeyboardScene.values().length];
            r100[KeyboardScene.Moments.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f429762a = r100;
        }
    }

    public static final class d extends dlb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f429764b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PhotoKBPlugin f429765a;

            public a(PhotoKBPlugin r100) {
                this.f429765a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.ss.android.lark.c.f(this.f429765a.n());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // dlb.b
        public final void h() {
            UICallbackExecutor.execute(new a(this.f429763a));
            PhotoKBPlugin.H(this.f429763a);
        }

        public d(PhotoKBPlugin r100, Activity r101) {
            this.f429763a = r100;
            this.f429764b = r101;
        }

        @Override // dlb.b
        public final void i(int r100, String r101) {
            Log.e("PhotoKBPlugin", "onUploadFailed, errorCode:" + r100 + ", errorMsg:" + r101);
            if (KeyboardPhotoModule.a().isHitStorageQuotaLimit(r100) == false) goto L5;
            KeyboardPhotoModule.a().showQuotaLimitDialog(this.f429764b, r100);
        L23:
            PhotoKBPlugin.H(this.f429763a);
            return;
        L5:
            PhotoKBPlugin r102 = this.f429763a;
            if (r100 != r102.f429751l) goto L9;
            KeyboardPhotoModule.a().showUnifiedStorageLimitCTADialog(this.f429764b);
            goto L23
        L9:
            if (r100 != r102.f429749j) goto L12;
            KeyboardPhotoModule.a().onAuthorizatedDeny(this.f429764b, r101);
            goto L23
        L12:
            if (r100 == r102.f429750k) goto L23;
            if (r101 != null) goto L15;
        L18:
            boolean r103 = true;
        L19:
            if (r103 == true) goto L21;
            UDToast.show(this.f429764b, r101);
        L22:
            this.f429763a.n().z().z();
            goto L23
        L21:
            UDToast.show(this.f429764b, R.string.Lark_Legacy_FailedToUploadTheImage);
            goto L22
        L15:
            if (r101.length() == 0) goto L18;
            r103 = false;
            goto L19
        }

        @Override // dlb.b
        public final void k(com.ss.android.lark.image.uploader.entity.b r100, com.ss.android.lark.image.uploader.entity.c r101) {
            Intrinsics.checkNotNullParameter(r100, "uploadImage");
            if (r101 == null) goto L12;
            String r102 = r101.f426410a;
            ImageInfo r103 = r100.f426397k;
            int r104 = 0;
            if (r103 == null) goto L7;
            int r105 = r103.f426421a;
        L8:
            if (r103 == null) goto L10;
            r104 = r103.f426422b;
        L10:
            Image r106 = new Image(CollectionsKt.listOf(r100.f426396j), r105, r104, r102);
            this.f429763a.L(r106, r100.f426388b);
            return;
        L7:
            r105 = 0;
            goto L8
        }

        @Override // dlb.b
        public final void j(int r100, com.ss.android.lark.image.uploader.entity.b r101, long r102, int r103, int r104) {
            PhotoKBPlugin.H(this.f429763a);
            Log.e("PhotoKBPlugin", "onUploadFileCheckInvalid, errorCode:" + r100 + ", maxLimitValue:" + r102);
            if (r100 != (-10003)) goto L5;
            Activity r105 = this.f429764b;
            StringBuilder r106 = new StringBuilder();
            r106.append(r103);
            r106.append('*');
            r106.append(r104);
            UDToast.show(r105, UIHelper.mustacheFormat(R.string.Lark_IM_ImageTooClear_Toast, "ResolutionRate", r106.toString()));
            return;
        L5:
            if (r100 == (-10001)) goto L7;
            UDToast.show(this.f429764b, UIHelper.getString(R.string.Lark_IM_InvalidImageFormat_Toast));
            return;
        L7:
            UDToast.show(this.f429764b, UIHelper.mustacheFormat(R.string.Lark_IM_ImageSizeTooLarge_Toast, "Num", "" + r102));
        }
    }

    public static final class e extends PermissionPurposeWindowPermissionResult {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429766b;

        public e(PhotoKBPlugin r100) {
            this.f429766b = r100;
        }

        @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult, com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f429766b.S(r100);
        }
    }

    public static final class f implements com.ss.android.lark.utils.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoKBPlugin f429767a;

        @Override // com.ss.android.lark.utils.h.d
        public final boolean b() {
            return true;
        }

        @Override // com.ss.android.lark.utils.h.d
        public final boolean a() {
            if (this.f429767a.J().f438544a != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public f(PhotoKBPlugin r100) {
            this.f429767a = r100;
        }
    }

    static {
    }

    public void R() {
    }

    public void U() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_image_outlined;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        LarkPhotoPickerView r100 = this.f429747h;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        this.f429745f.l();
    }

    public final StoragePermissionUtils.c J() {
        return new StoragePermissionUtils.c(n().l().getContext(), new String[0]);
    }

    public final boolean Q() {
        if (n().L().getInputType() != InputSupportType.Post) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f429757r;
    }

    public static final void H(PhotoKBPlugin r100) {
        Activity r101 = r100.n().l().getContext();
        if (r101.isDestroyed() == false) goto L5;
    L7:
        Log.e("PhotoKBPlugin", "activity destroyed, skip hide dialog");
        return;
    L5:
        if (r101.isFinishing() == true) goto L7;
        r100.f429748i.dismiss();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r100) {
        View r101 = null;
        if (r100 == false) goto L45;
        KeyboardScene r102 = n().l().f429557a;
        PerfGalleryLoadMonitor r103 = PerfGalleryLoadMonitor.f447609a;
        if (c.f429762a[r102.ordinal()] != 1) goto L7;
        Scene r104 = Scene.Moments;
    L8:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "scene");
        PerfGalleryLoadMonitor.a r105 = PerfGalleryLoadMonitor.f447610b;
        if (r105 != null) goto L11;
        r105 = new PerfGalleryLoadMonitor.a();
    L11:
        PerfGalleryLoadMonitor.f447610b = r105;
        r105.a(r104, 1);
        U();
        if (n().L().getInputType() != InputSupportType.Post) goto L14;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
        new PostInputPluginHitPoint("picture").c();
    L19:
        this.f429752m.invoke();
        if (this.f429754o == true) goto L32;
        this.f429754o = true;
        View r107 = this.f429746g;
        if (r107 == null) goto L24;
        r101 = r107;
    L25:
        r101.setSelected(true);
        boolean r108 = Q();
        LarkPhotoPickerView r109 = this.f429747h;
        if (r109 == null) goto L28;
        r109.setIsInPostMode(r108);
    L28:
        LarkPhotoPickerView r110 = this.f429747h;
        if (r110 == null) goto L31;
        r110.setEnablePostSendVideo(this.f429745f.j());
    L31:
        S(J());
        return;
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L25
    L32:
        View r111 = this.f429746g;
        if (r111 == null) goto L35;
        r101 = r111;
    L36:
        r101.setSelected(true);
        boolean r112 = Q();
        LarkPhotoPickerView r113 = this.f429747h;
        if (r113 == null) goto L39;
        r113.setIsInPostMode(r112);
    L39:
        LarkPhotoPickerView r114 = this.f429747h;
        if (r114 == null) goto L42;
        r114.setEnablePostSendVideo(this.f429745f.j());
    L42:
        LarkPhotoPickerView r115 = this.f429747h;
        if (r115 == null) goto L55;
        r115.g(false);
        return;
    L55:
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L36
    L18:
        new TextInputPluginHitPoint("picture").c();
        goto L19
    L14:
        r106 = false;
        goto L16
    L7:
        r104 = Scene.Chat;
        goto L8
    L45:
        View r116 = this.f429746g;
        if (r116 == null) goto L48;
        r101 = r116;
    L49:
        r101.setSelected(false);
        LarkPhotoPickerView r117 = this.f429747h;
        if (r117 == null) goto L52;
        r117.b();
    L52:
        this.f429745f.l();
        return;
    L48:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L49
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        final Activity r100 = n().l().getContext();
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.kb_plugin_photo, r110, false);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView");
        this.f429747h = (LarkPhotoPickerView) r111;
        LarkPhotoPickerView.d r112 = new PhotoKBPlugin$onCreatePanel$onFuncPickListener$1(this, r100);
        LarkPhotoPickerView r101 = this.f429747h;
        if (r101 == null) goto L5;
        r101.setShowGif(true);
        r101.setShowVideo(this.f429745f.p());
        r101.setPhotoPickerListener(r112);
    L5:
        StoragePermissionUtils.c r113 = J();
        Log.i("PhotoKBPlugin", "onCreatePanel / " + r113);
        if (r113.f438544a != 2) goto L11;
        Activity r102 = n().l().getContext();
        e r114 = new e(this);
        com.ss.android.lark.utils.l r103 = com.ss.android.lark.utils.n.b();
        Token r104 = new Token("LARK-PSDA-android_photo_picker_request_permission");
        f r115 = new f(this);
        String[] r105 = new String[0];
        StoragePermissionUtils.b r106 = StoragePermissionUtils.c(r102, 22, r105);
        if (r106.f438542a == false) goto L10;
        r114.b(new StoragePermissionUtils.c(r102, r105));
        goto L11
    L10:
        String[] r116 = r106.f438543b;
        com.ss.android.lark.utils.h.e(r102, new com.ss.android.lark.utils.c(r114, r102, r105), r103, r104, true, r116.length, 0, r115, r116);
    L11:
        LarkPhotoPickerView r117 = this.f429747h;
        if (r117 == null) goto L15;
        return r117;
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void S(StoragePermissionUtils.c r100) {
        Log.i("PhotoKBPlugin", "prepareMedias / " + r100);
        int r101 = r100.f438544a;
        LarkPhotoPickerView r102 = this.f429747h;
        if (r102 == null) goto L14;
        r102.i();
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L17;
        r102.g(false);
        return;
    L17:
        return;
    L11:
        if (r102.j() == true) goto L16;
        r102.g(false);
        return;
    L16:
        return;
    }

    public final List<Photo> T(List<Photo> r100) {
        com.ss.android.lark.keyboard.plugin.tool.photo.a r101 = this.f429745f;
        RichText r102 = null;
        if ((r101 instanceof com.ss.android.lark.keyboard.plugin.tool.photo.b) == false) goto L5;
        com.ss.android.lark.keyboard.plugin.tool.photo.b r103 = (com.ss.android.lark.keyboard.plugin.tool.photo.b) r101;
    L6:
        if (r103 != null) goto L9;
        return r100;
    L9:
        if (r103.a() == true) goto L11;
        return r100;
    L11:
        EditText r104 = n().L().c();
        if ((r104 instanceof FunctionEditText) == false) goto L14;
        r102 = com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) ((FunctionEditText) r104).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.f429100g));
    L14:
        boolean r105 = !((ArrayList) com.ss.android.lark.widget.richtext.d.e(r102)).isEmpty();
        ArrayList r106 = new ArrayList(r100.size());
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r100.iterator();
    L16:
        if (r108.hasNext() == false) goto L26;
        Photo r109 = (Photo) r108.next();
        if (r109.isVideo() == false) goto L22;
        if (r105 == false) goto L22;
        r107.add(r109);
    L22:
        r106.add(r109);
        if (r109.isVideo() == false) goto L16;
        r105 = true;
        goto L16
    L26:
        if ((!r107.isEmpty()) == true) goto L28;
    L30:
        return r106;
    L28:
        if (r103.b() != r107.size()) goto L30;
        UDToast.show(n().l().getContext(), R.string.Lark_IM_Attach_OneVideoLimit_Toast);
        goto L30
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r100) {
        View r101 = this.f429746g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r101 = null;
    L6:
        r101.setEnabled(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        r100.f429551a.setActivated(this.f429743d);
        View r101 = r100.f429551a;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f429746g = r101;
    }

    public PhotoKBPlugin(boolean r100, com.ss.android.lark.keyboard.plugin.tool.photo.a r101) {
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f429743d = r100;
        this.f429744e = true;
        this.f429745f = r101;
        this.f429748i = new CommonLoadingDialog();
        this.f429749j = KeyboardPhotoModule.a().getFileUploadAuthorizatedDenyCode();
        this.f429750k = KeyboardPhotoModule.a().getFileUploadAuthorizatedDenyCodeByFilePolicy();
        this.f429751l = KeyboardPhotoModule.a().getUnifiedStorageLimitErrorCode();
        this.f429752m = PhotoKBPlugin$mPluginClickListener$1.INSTANCE;
        this.f429753n = "unknown";
        this.f429755p = true;
        this.f429756q = new n(this);
        this.f429757r = KeyboardMenuItemKey.Photo;
        this.f429758s = new g(this);
        this.f429760u = true;
    }

    public final void K(List<Photo> r110, boolean r111) {
        List<Photo> r100 = T(r110);
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L22;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Photo r107 = (Photo) r105;
        boolean r108 = r107.isVideo();
        if (r107.isVideo() == false) goto L11;
        r101.add(r107);
    L13:
        if (r104 == CollectionsKt.getLastIndex(r100)) goto L16;
        if (r108 == true) goto L16;
    L21:
        r104 = r106;
    L16:
        if ((!r102.isEmpty()) == false) goto L19;
        M(new ArrayList(r102), r111, r110);
        r102.clear();
    L19:
        if ((!r101.isEmpty()) == false) goto L21;
        P(new ArrayList(r101), r111);
        r101.clear();
        goto L21
    L11:
        r102.add(r107.getPath());
        goto L13
    }

    public void L(Image r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        R();
        List<String> r102 = r100.getUrls();
        if (CollectionUtils.isNotEmpty(r102) == true) goto L5;
        return;
    L5:
        if (this.f429760u == false) goto L11;
        com.ss.android.lark.widget.span.b.AbstractC5432b.a r103 = new com.ss.android.lark.widget.span.b.AbstractC5432b.a((String) ListProtector.get(r102, 0), r100.getWidth(), r100.getHeight());
        EditText r104 = n().L().c();
        if ((r104 instanceof FunctionEditText) == false) goto L12;
        hob.f r105 = new hob.f(r103, r100.getToken(), r101, null);
        ((ImageEditor) ((FunctionEditText) r104).q(ImageEditor.f429058c)).insert(r105);
        return;
    L12:
        return;
    }

    public final void P(List<Photo> r110, boolean r111) {
        if (CollectionUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        EditText r100 = n().L().c();
        ArrayList r101 = new ArrayList();
        if ((r100 instanceof FunctionEditText) == false) goto L8;
        RichText r102 = com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) ((FunctionEditText) r100).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.f429100g));
    L9:
        r101.addAll(com.ss.android.lark.widget.richtext.d.e(r102));
        if (CollectionUtils.isNotEmpty(r101) == false) goto L13;
        UDToast.show(n().l().getContext(), R.string.Lark_Chat_TopicCreateSelectVideoError);
        return;
    L13:
        R();
        b r103 = this.f429761v;
        if (r103 == null) goto L16;
        r103.a(r110);
    L16:
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r110.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        Photo r106 = (Photo) r105.next();
        String r107 = CompressPathManager.generateCompressFilePath(r106.getPath(), Boolean.valueOf(r111));
        String r108 = r106.getPath();
        Intrinsics.checkNotNull(r107);
        VideoInfo r109 = new VideoInfo(r108, r107, r106.getMimeType(), r106.getSize(), r106.getDuration());
        this.f429745f.a();
        r104.add(r109);
        goto L18
    L20:
        Intrinsics.checkNotNullParameter(r104, "videoInfos");
        Intrinsics.checkNotNullParameter(r110, "photos");
        this.f429748i.show(n().l().getContext());
        g r112 = this.f429758s;
        l r113 = new l(r104, this);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r104, "videoInfos");
        Intrinsics.checkNotNullParameter(r113, "callback");
        r112.f429775a.f429745f.o(r104).observeOn(AndroidSchedulers.mainThread()).subscribeOn(LarkRxSchedulers.io()).subscribe(new com.ss.android.lark.keyboard.plugin.tool.photo.f(r113));
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r100 != 233) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r101, "data");
        LarkPhotoPickerView r102 = this.f429747h;
        if (r102 == null) goto L11;
        r102.e(r100, -1, r101);
        return;
    L11:
        return;
    L5:
        if (r100 == 911) goto L7;
    }

    public void M(List<String> r100, boolean r101, List<Photo> r102) {
        Intrinsics.checkNotNullParameter(r100, "photoPaths");
        Intrinsics.checkNotNullParameter(r102, "photos");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        String r105 = (String) r104.next();
        com.ss.android.lark.image.uploader.entity.b.a r106 = new com.ss.android.lark.image.uploader.entity.b.a();
        r106.c(r105);
        r106.a(Biz.Messenger);
        r106.d(Scene.Chat);
        r106.f426404d = 2;
        Intrinsics.checkNotNullParameter("ChatWindowActivity", "page");
        r106.f426405e = "ChatWindowActivity";
        r106.f426407g = r101;
        r103.add(r106.b());
        goto L4
    L6:
        long r107 = Environment.getDataDirectory().getFreeSpace();
        long r108 = ConfigManager.b();
        if (r107 >= r108) goto L9;
        Log.i("PhotoKBPlugin", "freeSpace is:" + r107 + ", diskFreeSizeLimit:" + r108);
        ThreadUtils.runOnUIThread(com.ss.android.lark.keyboard.plugin.tool.photo.e.f429773a);
        boolean r109 = false;
    L10:
        if (r109 == true) goto L12;
        return;
    L12:
        Activity r110 = n().l().getContext();
        this.f429748i.show(r110);
        int r111 = ykb.a.f568290b;
        ykb.a r112 = ykb.a.C8350a.a(r110);
        Intrinsics.checkNotNullParameter(r103, "imageList");
        ImageUploadTask r113 = r112.f568291a;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r103, "imageList");
        r113.f426376b.addAll(r103);
        r112.f568291a.f426381g = new com.ss.android.lark.image.uploader.upload.d(this.f429744e);
        r112.a(new d(this, r110));
        r112.c();
        return;
    L9:
        r109 = true;
        goto L10
    }

    public final void V(List<Photo> r110, List<String> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "photos");
        if (Q() == false) goto L5;
        List<Photo> r100 = T(r110);
    L6:
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L45;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        Photo r107 = (Photo) r105;
        boolean r108 = r107.isVideo();
        if (r107.isVideo() == false) goto L15;
        r101.add(r107);
    L17:
        if (r104 == CollectionsKt.getLastIndex(r100)) goto L20;
        if (r108 == true) goto L20;
    L43:
        r104 = r106;
    L20:
        if ((!r102.isEmpty()) == false) goto L27;
        if (Q() == false) goto L24;
        M(new ArrayList(r102), r112, r110);
    L25:
        r102.clear();
        goto L27
    L24:
        this.f429745f.e(new ArrayList(r102), r112, r110.size(), this.f429753n);
    L27:
        if ((!r101.isEmpty()) == false) goto L43;
        if (Q() == true) goto L31;
    L33:
        Photo r109 = (Photo) ListProtector.get(r101, 0);
        int r113 = r110.size();
        if (r111 != null) goto L36;
    L38:
        boolean r114 = false;
    L39:
        if (r114 == false) goto L41;
        ArrayList<File> r115 = new ArrayList();
        VFSFiles.f444819b.getClass();
        r115.add(VFSFiles.b(true).i(r109.getPath()));
        this.f429745f.h(r115);
    L42:
        r101.clear();
        goto L43
    L41:
        ArrayList r116 = new ArrayList();
        r109.setCompressPath(CompressPathManager.generateCompressFilePath(r109.getPath(), Boolean.valueOf(r112)));
        r116.add(r109);
        this.f429745f.i(r116, r113);
        goto L42
    L36:
        if (r111.contains(r109.getPath()) != true) goto L38;
        r114 = true;
        goto L39
    L31:
        if (this.f429745f.j() == false) goto L33;
        P(new ArrayList(r101), r112);
        goto L42
    L15:
        r102.add(r107.getPath());
        goto L17
    L45:
        if (Q() == true) goto L52;
        com.ss.android.lark.keyboard.event.k.a.a(n().e(), q.a.f429311a);
        n().H().h();
        return;
    L52:
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
