package com.bytedance.ee.bear.fileselector;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.PageType;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.fileselector.exception.ImageOverSizeException;
import com.bytedance.ee.bear.fileselector.exception.VideoOverSizeException;
import com.bytedance.ee.bear.fileselector.model.FileSelectConfigModel;
import com.bytedance.ee.bear.fileselector.view.FilePanelDragView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.q;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0007H\u0016J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002J\u0018\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020%H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\b\u0010@\u001a\u00020\u0011H\u0002J\u001a\u0010A\u001a\u00020\u00182\u0006\u00107\u001a\u00020B2\b\b\u0001\u0010C\u001a\u000205H\u0002J\u0018\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u0007H\u0002J\"\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u0002052\u0006\u0010I\u001a\u0002052\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0002J\u001e\u0010P\u001a\u00020\u00182\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010T\u001a\u00020\u0015H\u0003J$\u0010U\u001a\b\u0012\u0004\u0012\u00020V0R2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010T\u001a\u00020\u0015H\u0002J\b\u0010W\u001a\u00020\u0018H\u0002J\u0018\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0018\u0010[\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020YH\u0002J \u0010]\u001a\u00020\u00182\u0006\u00109\u001a\u00020#2\u0006\u0010^\u001a\u00020%2\u0006\u0010:\u001a\u000205H\u0002J\b\u0010_\u001a\u00020\u0015H\u0002J\u000e\u0010`\u001a\u00020\u00182\u0006\u0010:\u001a\u000205J\b\u0010a\u001a\u00020\u0018H\u0002J\u0010\u0010b\u001a\u00020\u00182\u0006\u00109\u001a\u00020cH\u0016J\u0018\u0010d\u001a\u00020V2\u0006\u0010e\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0015H\u0002J\b\u0010f\u001a\u00020\u0018H\u0016J\b\u0010g\u001a\u00020\u0018H\u0016J\"\u0010h\u001a\u00020\u00182\b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u0002052\u0006\u0010l\u001a\u000205H\u0016J\n\u0010m\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010n\u001a\u00020\u0015H\u0016J\u000e\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u000205J\b\u0010O\u001a\u00020\u0015H\u0002J\n\u0010q\u001a\u0004\u0018\u00010BH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/FileSelectFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "mFileSelectConfig", "Lcom/bytedance/ee/bear/fileselector/api/FileSelectConfig;", "mLuban", "Lcom/bytedance/ee/util/algorithm/Luban;", "mDragView", "Lcom/bytedance/ee/bear/fileselector/view/FilePanelDragView;", "mMainHandler", "Landroid/os/Handler;", "mFileSelectConfigModel", "Lcom/bytedance/ee/bear/fileselector/model/FileSelectConfigModel;", "mSelectContentView", "Landroid/widget/FrameLayout;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isNewLarkFormEnable", "", "isFirstSatrt", "setFileSelectConfig", "", "config", "getFileSelectConfig", "getFileSelectConfig$framework_file_selector_release", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleInstanceState", "onSaveInstanceState", "outState", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "onStart", "onResume", "onPause", "onStop", "onDetach", "onAttach", "context", "Landroid/content/Context;", "adjustHeight", "", "handleHeaderView", "pickerView", "createDialogWithDragView", "dialog", "height", "initDragView", "root", "openFilePicker", "permissionDeniedAndDismiss", "openCcmAlbum", "buildLarkPhotoPickerView", "prepareMedias", "Lcom/ss/android/lark/widget/halfscreen/LarkPhotoPickerView;", "permissionResult", "setupLarkPhotoPickerView", "larkPhotoPickerView", "fileSelectConfig", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "checkFileSize", "filePointer", "", "isFileUseUri", "handlePhoto", "selectedPhoto", "", "Lcom/ss/android/lark/widget/photopicker/entity/Photo;", "isOrigin", "onFail", "Lcom/bytedance/ee/bear/fileselector/bean/FileBean;", "cancelAndDismissDialog", "compressAndCopyImage", "Lcom/ss/android/lark/vfs/VFSFile;", "srcFile", "copyFile", "destFile", "initDialog", "contentView", "isAvailableToken", "resetDialogHeight", "dismissDialog", "onDismiss", "Landroid/content/DialogInterface;", "photo2FileBean", "photo", "onDestroyView", "onDestroy", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "getLuban", "onBackPressed", "removeSelfFromFragmentManager", "animExit", "getLarkPhotoPickerViewOrNull", "Companion", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSelectFragment extends BaseAntiScreenshotsDialogFragment implements ocb.a, sa5.d {
    public static final /* synthetic */ int q = 0;
    public FileSelectConfig h;
    public du5.c i;
    public FilePanelDragView j;
    public final Handler k;
    public FileSelectConfigModel l;
    public LarkPhotoPickerView m;
    public final CompositeDisposable n;
    public final boolean o;
    public boolean p;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ FileSelectFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Ref.ObjectRef<ab5.a> c;

        public b(FileSelectFragment r1, boolean r2, Ref.ObjectRef<ab5.a> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r13) {
            Photo r14 = (Photo) r13;
            Intrinsics.checkNotNullParameter(r14, "photo");
            VFSPath r0 = ay4.d.a().i(r14.getPath());
            boolean r3 = true;
            if (r14.isVideo() == false) goto L20;
            FileSelectConfig r1 = this.a.h;
            if (r1 != null) goto L7;
        L13:
            tt5.a.h("FileSelectorFragment", "photo.width = " + r14.getWidth() + ", photo.height = " + r14.getHeight());
            int[] r2 = VideoTools.getSize(r14.getPath());
            int r4 = r2[0];
            if (r4 > 0) goto L16;
        L18:
            tt5.a.h("FileSelectorFragment", "photo.width = " + r14.getWidth() + ", photo.height = " + r14.getHeight());
        L93:
            if (TextUtils.isEmpty(r14.getCompressPath()) == false) goto L97;
            ab5.a r5 = (ab5.a) this.c.element;
            if (r5 == null) goto L97;
            r5.a(r14.getId(), 1.0f);
        L97:
            FileSelectFragment r6 = this.a;
            boolean r7 = this.b;
            int r8 = FileSelectFragment.q;
            r6.getClass();
            return FileSelectFragment.la0(r14, r7);
        L16:
            if (r2[1] <= 0) goto L18;
            r14.setWidth(r4);
            r14.setHeight(r2[1]);
            r14.setSize(r0.length());
            goto L18
        L7:
            if (r1.maxVideoSize <= 0) goto L13;
            if (r0.length() <= r1.maxVideoSize) goto L13;
            throw new VideoOverSizeException("Video over size. Max video size is " + r1.maxVideoSize + " and the video size is " + r0.length());
        L20:
            if (this.b == false) goto L30;
            FileSelectConfig r9 = this.a.h;
            if (r9 == null) goto L30;
            if (r9.maxImageSize <= 0) goto L30;
            if (r0.length() <= r9.maxImageSize) goto L30;
            throw new ImageOverSizeException("Image over size. Max image size is " + r9.maxImageSize + " and the image size is " + r0.length());
        L30:
            FileSelectFragment r10 = this.a;
            boolean r11 = this.b;
            int r12 = FileSelectFragment.q;
            r10.getClass();
            FileSelectConfig r16 = r10.h;     // Catch: Exception -> L87
            if (r16 != null) goto L34;
        L89:
            r14.setPath(r0.getPath());
            if (this.a.o == false) goto L93;
            r14.setSize(r0.length());
            goto L93
        L34:
            if (r16.isOriginFile == true) goto L89;
            String r17 = r0.getPath();     // Catch: Exception -> L87
            if (TextUtils.isEmpty(r17) == true) goto L42;
            String r18 = r17.substring(r17.lastIndexOf("."), r17.length());     // Catch: Exception -> L87
            if (r18.startsWith(".gif") == false) goto L40;
        L43:
            if (r3 == true) goto L89;
            boolean r19 = r16.isOriginFile;     // Catch: Exception -> L87
            VFSPath r110 = null;
            if (r19 == false) goto L49;
        L69:
            if (r19 == false) goto L89;
            if (r16.enableImageCompress == false) goto L89;
            if (r11 == true) goto L82;
            du5.c r20 = r10.ga0();     // Catch: Exception -> L87
            if (r20 == null) goto L83;
            VFSPath r21 = r0.getVfsPath();     // Catch: Exception -> L87
            r21 = new du5.c.b(r20.a).c(r21);     // Catch: IOException -> L78 Exception -> L87
        L80:
            if (r21 == null) goto L83;
            r110 = r21.toFile();     // Catch: Exception -> L87
            goto L83
        L78:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
        L83:
            if (r110 != null) goto L86;
            tt5.a.k("FileSelectorFragment", "compress image failed");     // Catch: Exception -> L87
            goto L89
        L86:
            r0 = r110;
            goto L89
        L82:
            r110 = r0;
            goto L83
        L49:
            if (r16.enableImageCompress == false) goto L69;
            tt5.a.b("FileSelectorFragment", "compressImage, isOrigin = " + r11);     // Catch: Exception -> L87
            if (r11 == false) goto L59;
            du5.c r22 = r10.ga0();     // Catch: Exception -> L87
            if (r22 == null) goto L66;
            r110 = r0.getVfsPath();     // Catch: Exception -> L87
            r110 = du5.c.b.a(new du5.c.b(r22.a), r110);     // Catch: Exception -> L57
        L57:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
        L66:
            if (r110 != null) goto L68;
            tt5.a.k("FileSelectorFragment", "compress image failed");     // Catch: Exception -> L87
            goto L89
        L68:
            r0 = r10.ea0(r0, r110.toFile());     // Catch: Exception -> L87
            goto L89
        L59:
            du5.c r23 = r10.ga0();     // Catch: Exception -> L87
            if (r23 == null) goto L66;
            VFSPath r24 = r0.getVfsPath();     // Catch: Exception -> L87
            r110 = new du5.c.b(r23.a).c(r24);     // Catch: IOException -> L64 Exception -> L87
            goto L66
        L64:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
            r110 = r24;
            goto L66
        L40:
            if (r18.startsWith(".GIF") == true) goto L43;
        L42:
            r3 = false;
        L87:
            e = move-exception;
            tt5.a.m("FileSelectorFragment", e);
            goto L89
        }
    }

    public static final class c<V> implements Callable {
        public static final c<V> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.Callable
        public final List<FileBean> call() {
            return new ArrayList();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T1, T2> implements ttc.a {
        public static final d<T1, T2> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1, Object r2) {
            List r3 = (List) r1;
            FileBean r4 = (FileBean) r2;
            if (r3 == null) goto L6;
            Intrinsics.checkNotNull(r4);
            r3.add(r4);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef<ab5.a> a;
        public final /* synthetic */ FileSelectFragment b;
        public final /* synthetic */ List<Photo> c;

        public e(Ref.ObjectRef<ab5.a> r1, FileSelectFragment r2, List<Photo> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            List r12 = (List) r11;
            ab5.a r0 = (ab5.a) this.a.element;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            FileSelectFragment r1 = this.b;
            FileSelectConfig r2 = r1.h;
            if (r2 == null) goto L29;
            List<Photo> r3 = this.c;
            za5.a r4 = r2.fileSelectListener;
            if (r4 == null) goto L20;
            int r5 = ab5.e.a;
            Intrinsics.checkNotNull(r12);
            Intrinsics.checkNotNullParameter(r12, "fileBeanList");
            Intrinsics.checkNotNullParameter(r3, "selectedPhoto");
            ArrayList r6 = new ArrayList();
            Iterator<Photo> r7 = r3.iterator();
        L11:
            if (r7.hasNext() == false) goto L18;
            Photo r8 = r7.next();
            Iterator r9 = r12.iterator();
        L14:
            if (r9.hasNext() == false) goto L11;
            FileBean r10 = (FileBean) r9.next();
            if (r8.getId() != r10.getId()) goto L14;
            r6.add(r10);
            goto L11
        L18:
            r4.c(r6);
        L20:
            if (r2.autoDismiss == false) goto L30;
            r1.dismissDialog();
            return;
        L30:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef<ab5.a> a;
        public final /* synthetic */ FileSelectFragment b;
        public final /* synthetic */ List<Photo> c;
        public final /* synthetic */ boolean d;

        public f(Ref.ObjectRef<ab5.a> r1, FileSelectFragment r2, List<Photo> r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            ab5.a r0 = (ab5.a) this.a.element;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            FileSelectFragment r1 = this.b;
            FileSelectConfig r2 = r1.h;
            if (r2 == null) goto L24;
            List<Photo> r3 = this.c;
            boolean r4 = this.d;
            if ((r7 instanceof ImageOverSizeException) == false) goto L13;
            bb5.c r8 = r2.fileCheckListener;
            if (r8 == null) goto L21;
            r8.a(FileType.IMAGE);
        L21:
            if (r2.autoDismiss == false) goto L25;
            r1.dismissDialog();
            return;
        L25:
            return;
        L13:
            if ((r7 instanceof VideoOverSizeException) == false) goto L17;
            bb5.c r9 = r2.fileCheckListener;
            if (r9 == null) goto L21;
            r9.a(FileType.VIDEO);
            goto L21
        L17:
            za5.a r10 = r2.fileSelectListener;
            if (r10 == null) goto L21;
            r10.c(FileSelectFragment.aa0(r1, r3, r4));
            goto L21
        }
    }

    public static final class g implements bb5.g {
        public final /* synthetic */ FileSelectFragment a;
        public final /* synthetic */ List<Photo> b;
        public final /* synthetic */ boolean c;

        @Override // bb5.g
        public final void close() {
            FileSelectFragment r0 = this.a;
            FileSelectConfig r1 = r0.h;
            if (r1 == null) goto L12;
            List<Photo> r2 = this.b;
            boolean r3 = this.c;
            za5.a r4 = r1.fileSelectListener;
            if (r4 == null) goto L8;
            r4.c(FileSelectFragment.aa0(r0, r2, r3));
        L8:
            if (r1.autoDismiss == false) goto L10;
            r0.dismissDialog();
            return;
        L10:
            r0.n.clear();
            return;
        }

        public g(FileSelectFragment r1, List<Photo> r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h implements com.ss.android.lark.widget.photopicker.b {
        public final /* synthetic */ FileSelectFragment a;

        public h(FileSelectFragment r1) {
            this.a = r1;
        }

        public final void onIntercept(String r1) {
            FileSelectFragment.ba0(this.a);
        }
    }

    public static final class i implements StoragePermissionUtils.a {
        public final /* synthetic */ FileSelectFragment a;
        public final /* synthetic */ LarkPhotoPickerView b;

        public i(FileSelectFragment r1, LarkPhotoPickerView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(StoragePermissionUtils.c r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            int r5 = r4.a;
            FileSelectFragment r0 = this.a;
            LarkPhotoPickerView r1 = this.b;
            int r2 = FileSelectFragment.q;
            r0.getClass();
            FileSelectFragment.ma0(r1, r5);
        }
    }

    public static final class j implements StoragePermissionUtils.a {
        public final /* synthetic */ FileSelectFragment a;
        public final /* synthetic */ LarkPhotoPickerView b;

        public j(FileSelectFragment r1, LarkPhotoPickerView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(StoragePermissionUtils.c r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            int r5 = r4.a;
            FileSelectFragment r0 = this.a;
            LarkPhotoPickerView r1 = this.b;
            int r2 = FileSelectFragment.q;
            r0.getClass();
            FileSelectFragment.ma0(r1, r5);
        }
    }

    static {
    }

    public final int ca0() {
        FileSelectConfig r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
    L14:
        tt5.a.h("FileSelectorFragment", "adjustHeight height: " + r1);
        return r1;
    L5:
        if (r0.adjustHeightByKeyboard == false) goto L12;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L14;
        if (rcb.b.a(r2) == false) goto L11;
        int r3 = pcb.a.a.b(r2).keyBoardRawHeightWithOrientation(r2.getResources().getConfiguration().orientation);
    L13:
        r1 = r3;
        goto L14
    L11:
        r3 = pcb.a.a.b(r2).keyBoardRawHeight();
        goto L13
    L12:
        r3 = Math.max(r0.ccmPickViewHeight, r0.minCcmPickViewHeight);
        goto L13
    }

    public final void da0() {
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L7;
        za5.a r1 = r0.fileSelectListener;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        dismissDialog();
    }

    public final LarkPhotoPickerView fa0() {
        LarkPhotoPickerView r0 = this.m;
        if ((r0 instanceof LarkPhotoPickerView) == false) goto L5;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView");
        return r0;
    L5:
        return null;
    }

    public final du5.c ga0() {
        if (this.i != null) goto L8;
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L8;
        du5.c r2 = new du5.c(du5.c.a(getContext()));
        int r1 = r0.maxImageCompressSize;
        du5.c.a r3 = r2.a;
        r3.a = r1;
        r3.d = r0.imageCompressType;
        this.i = r2;
    L8:
        return this.i;
    }

    public final LarkPhotoPickerView ka0() {
        LarkPhotoPickerView r0 = new LarkPhotoPickerView(requireContext());
        FileSelectConfig r1 = this.h;
        if (r1 == null) goto L5;
        oa0(r0, r1);
    L5:
        r0.setPhotoPickerListener(new LarkPhotoPickerListener(this, new FileSelectFragment$buildLarkPhotoPickerView$2(this)));
        r0.setClickable(true);
        return r0;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        tt5.a.h("FileSelectorFragment", "onDestroy");
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L11;
        FileSelectConfig r1 = this.h;
        if (r1 == null) goto L11;
        if (r0.getSupportFragmentManager().isDestroyed() == true) goto L11;
        if (r1.adjustHeightByKeyboard == false) goto L11;
        pcb.a.a.b(r0).a(this);
    L11:
        super.onDestroy();
    }

    public final void onDetach() {
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L7;
        bb5.b r1 = r0.dialogLifecycle;
        if (r1 == null) goto L7;
        r1.onDetach();
    L7:
        LarkPhotoPickerView r2 = fa0();
        if (r2 == null) goto L10;
        r2.d();
    L10:
        super.onDetach();
    }

    public FileSelectFragment() {
        this.k = new Handler(Looper.getMainLooper());
        this.n = new CompositeDisposable();
        this.o = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.larkform.new.enable");
        this.p = true;
    }

    public final void dismissDialog() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        this.n.clear();
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        FragmentManager r1 = r0.getSupportFragmentManager();
    L7:
        if (r1 == null) goto L11;
        FragmentTransaction r2 = r1.beginTransaction();
        r2.setCustomAnimations(0, 2130772299);
        if (r1.getFragments().contains(this) == false) goto L11;
        r2.remove(this).commitAllowingStateLoss();
    L11:
        FileSelectConfig r3 = this.h;
        if (r3 != null) goto L14;
        return false;
    L14:
        if (r3.isConsumeBackPress != true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("FileSelectorFragment", "onDestroyView in FileSelectFragment");
        FileSelectConfig r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.canDragView == false) goto L11;
        FilePanelDragView r1 = this.j;
        if (r1 == null) goto L12;
        r1.b(true);
        return;
    L12:
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L8;
        bb5.b r1 = r0.dialogLifecycle;
        if (r1 == null) goto L9;
        r1.onPause();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("FileSelectorFragment", "onResume");
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L8;
        bb5.b r1 = r0.dialogLifecycle;
        if (r1 == null) goto L9;
        r1.onResume();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        FileSelectConfig r1 = this.h;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
    L24:
        FileSelectConfig r4 = this.h;
        if (r4 == null) goto L30;
        bb5.b r5 = r4.dialogLifecycle;
        if (r5 == null) goto L30;
        r5.onStart();
    L30:
        if (this.p == false) goto L54;
        this.p = false;
        LarkPhotoPickerView r6 = fa0();
        if (r6 == null) goto L55;
        FragmentActivity r7 = getActivity();
        if (r7 != null) goto L36;
        tt5.a.h("FileSelectorFragment", "activity is null");
        ma0(r6, 2);
        return;
    L36:
        new HashMap();
        int r8 = StoragePermissionUtils.a(r7, StoragePermissionUtils.d(r7, 2));
        StoragePermissionUtils.a(r7, StoragePermissionUtils.d(r7, 4));
        StoragePermissionUtils.d(r7, 8);
        StoragePermissionUtils.e(r7);
        if (r8 == 2) goto L39;
        boolean r9 = true;
    L40:
        tt5.a.h("FileSelectorFragment", "hasPhotoPermission = " + r9);
        if (r9 == false) goto L43;
        new HashMap();
        int r10 = StoragePermissionUtils.a(r7, StoragePermissionUtils.d(r7, 2));
        StoragePermissionUtils.a(r7, StoragePermissionUtils.d(r7, 4));
        StoragePermissionUtils.d(r7, 8);
        StoragePermissionUtils.e(r7);
        ma0(r6, r10);
        return;
    L43:
        FileSelectConfig r11 = this.h;
        if (r11 != null) goto L46;
    L48:
        r2 = false;
    L50:
        if (r2 == false) goto L52;
        StoragePermissionUtils.f(r7, new i(this, r6), 22, new Token("LARK-PSDA-ccm_android_photopickerview_request_permission"), new String[0]);
        return;
    L52:
        StoragePermissionUtils.f(r7, new j(this, r6), 2, new Token("LARK-PSDA-ccm_android_photopickerview_request_permission"), new String[0]);
        return;
    L46:
        if (r11.showVideo != true) goto L48;
    L39:
        r9 = false;
        goto L40
    L55:
        return;
    L54:
        return;
    L10:
        if (this.m == null) goto L24;
        if (r0 == null) goto L24;
        Window r12 = r0.getWindow();
        if (r12 == null) goto L17;
        WindowManager.LayoutParams r13 = r12.getAttributes();
        if (r13 == null) goto L17;
        r13.height = ca0();
    L17:
        Window r14 = r0.getWindow();
        if (r14 == null) goto L24;
        Window r16 = r0.getWindow();
        if (r16 == null) goto L22;
        WindowManager.LayoutParams r17 = r16.getAttributes();
    L23:
        r14.setAttributes(r17);
        goto L24
    L22:
        r17 = null;
        goto L23
    L5:
        if (r1.selectType != 2) goto L7;
        r3 = true;
        goto L8
    }

    public final void onStop() {
        super.onStop();
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L8;
        bb5.b r1 = r0.dialogLifecycle;
        if (r1 == null) goto L9;
        r1.onStop();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final PageType V90() {
        return PageType.NORMAL;
    }

    public static View Z90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final void ba0(FileSelectFragment r4) {
        FileSelectConfig r0 = r4.h;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        bb5.f r1 = r0.permissionCheckListener;
        if (r1 == null) goto L8;
        r1.onPermissionDenied();
    L8:
        r4.k.postDelayed(new com.bytedance.ee.bear.fileselector.c(r4), 100);
        return;
    L7:
        tt5.a.k("FileSelectorFragment", "permissionDeniedAndDismiss with empty config.");
        goto L8
    }

    public final FrameLayout ha0(LarkPhotoPickerView r6) {
        Context r0 = getContext();
        if (r0 == null) goto L14;
        FrameLayout r1 = new FrameLayout(r0);
        LinearLayout r2 = new LinearLayout(getContext());
        r2.setOrientation(1);
        r1.addView(r2);
        FileSelectConfig r3 = this.h;
        if (r3 != null) goto L7;
    L12:
        r2.addView(r6);
        return r1;
    L7:
        if (r3.headerViewRes == (-1)) goto L9;
        r2.addView(LayoutInflater.from(getContext()).inflate(r3.headerViewRes, null));
        goto L12
    L9:
        View r4 = r3.headView;
        if (r4 == null) goto L12;
        r2.addView(r4);
        goto L12
    L14:
        return r6;
    }

    public final void na0(FileSelectConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.h = r2;
        FileSelectConfigModel r0 = this.l;
        if (r0 == null) goto L5;
        r0.setFileSelectConfig(r2);
    L5:
        LarkPhotoPickerView r1 = this.m;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isAttachedToWindow() == true) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L19;
        LarkPhotoPickerView r4 = fa0();
        if (r4 == null) goto L18;
        oa0(r4, r2);
        r4.b();
        return;
    L18:
        return;
    L19:
        return;
    L10:
        r3 = false;
        goto L11
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        FileSelectConfig r3 = this.h;
        if (r3 == null) goto L8;
        bb5.b r4 = r3.dialogLifecycle;
        if (r4 == null) goto L9;
        r4.b(ca0());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FileSelectConfigModel r0 = (FileSelectConfigModel) new ViewModelProvider(requireActivity()).get(FileSelectConfigModel.class);
        this.l = r0;
        if (r3 == null) goto L9;
        if (r0 == null) goto L6;
        FileSelectConfig r4 = r0.getFileSelectConfig();
    L7:
        if (r4 == null) goto L9;
        this.h = r4;
        goto L9
    L6:
        r4 = null;
    L9:
        FileSelectConfig r5 = this.h;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        if (r5.adjustHeightByKeyboard == false) goto L16;
        pcb.a.a.b(getActivity()).c(this);
        return;
    L16:
        return;
    L14:
        tt5.a.k("FileSelectorFragment", "onCreate with empty config.");
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.widget.LinearLayout, com.bytedance.ee.bear.fileselector.view.FilePanelDragView, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout] */
    public final Dialog onCreateDialog(Bundle r9) {
        Dialog r0 = super.onCreateDialog(r9);
        if (r9 == null) goto L5;
        return r0;
    L5:
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L45;
        FileSelectConfig r1 = this.h;
        if (r1 == null) goto L44;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.selectType;
        if (r2 != 0) goto L12;
        tt5.a.k("FileSelectorFragment", "Unknown Operate Type!");
        goto L45
    L12:
        if (r2 != 1) goto L14;
        ja0(r0, new View(r10), 10);
        int r11 = com.bytedance.ee.bear.fileselector.h.a;
        final FileSelectConfig r4 = this.h;
        final Context r12 = getContext();
        if (r12 == null) goto L45;
        com.bytedance.ee.bear.fileselector.a.a(r12, new FileSelectFragment$onCreateDialog$lambda$4$$inlined$openLarkCamara$1(r12, this, r4, r12, this));
        goto L45
    L14:
        if (r2 != 2) goto L16;
        int r13 = ca0();
        FileSelectConfig r3 = this.h;
        Intrinsics.checkNotNull(r3);
        if (r3.canDragView == true) goto L31;
        LarkPhotoPickerView r5 = ka0();
        this.m = r5;
        Intrinsics.checkNotNull(r5);
        ja0(r0, ha0(r5), r13);
        FileSelectConfig r14 = this.h;
        Intrinsics.checkNotNull(r14);
        r14.getClass();
        goto L45
    L31:
        View r6 = LayoutInflater.from(getContext()).inflate(2131561100, null, false);
        Intrinsics.checkNotNull(r6);
        ?? r7 = (FilePanelDragView) r6.findViewById(2131372404);
        this.j = r7;
        if (r7 == 0) goto L39;
        FileSelectConfig r8 = this.h;
        if (r8 != null) goto L36;
    L38:
        r7.b(false);
        r7.w.a();
        r7.addView(ka0());
        r7.setOnHeightChangeListener(new com.bytedance.ee.bear.fileselector.b(r7, this));
        goto L39
    L36:
        if (r8.canDragView == true) goto L38;
        r7.getDragHandler().setVisibility(8);
        r7.getTopBar().setVisibility(8);
        UDShadowLayout.LayoutParams r16 = r7.getTopBar().getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        UDShadowLayout.LayoutParams r17 = r16;
        ((ViewGroup.MarginLayoutParams) r17).topMargin = 0;
        r7.getTopBar().setLayoutParams(r17);
    L39:
        ja0(r0, r6, r13);
        goto L45
    L16:
        if (r2 != 3) goto L18;
        ja0(r0, new View(r10), 10);
        int r18 = com.bytedance.ee.bear.fileselector.h.a;
        FileSelectConfig r19 = this.h;
        Context r20 = getContext();
        if (r20 == null) goto L45;
        if (r19 == null) goto L45;
        int r21 = s.C;
        com.ss.android.lark.widget.photopicker.e r22 = new com.ss.android.lark.widget.photopicker.e(s.b.a(new PhotoPickerLauncher$openFullScreenAlbum$1$1$1(r19)));
        r22.d = new h(this);
        r22.b(r20, this, 1);
        goto L45
    L18:
        if (r2 != 4) goto L45;
        ja0(r0, new View(r10), 10);
        FileSelectConfig r23 = this.h;
        if (r23 == null) goto L23;
        pm4.a r24 = new pm4.a(this, 3, 0);
        r24.k = r23.showFilterMenu;
        r24.j = r23.customSendBtnTips;
        com.bytedance.ee.android.file.picker.lib.a.b(r24);
        goto L45
    L23:
        tt5.a.k("FileSelectorFragment", "openFilePicker with empty config.");
        goto L45
    L44:
        tt5.a.k("FileSelectorFragment", "onCreateDialog with empty config.");
    L45:
        FileSelectConfig r26 = this.h;
        if (r26 == null) goto L50;
        bb5.b r27 = r26.dialogLifecycle;
        if (r27 == null) goto L50;
        r27.a(r0);
    L50:
        return r0;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r2);     // Catch: Throwable -> L9
        FileSelectConfig r3 = this.h;     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        bb5.h r4 = r3.onDismissListener;     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.onDismiss();     // Catch: Throwable -> L9
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        FileSelectConfig r3 = this.h;
        if (r3 == null) goto L8;
        FileSelectConfigModel r0 = this.l;
        if (r0 == null) goto L9;
        r0.setFileSelectConfig(r3);
        return;
    L9:
        return;
    }

    public static FileBean la0(Photo r3, boolean r4) {
        FileBean r0 = new FileBean();
        r0.setId(r3.getId());
        r0.setPath(r3.getPath());
        r0.setMimeType(r3.getMimeType());
        r0.setDuration(r3.getDuration());
        r0.setChecked(r3.isChecked());
        r0.position = r3.position;
        r0.setNum(r3.getNum());
        r0.setPictureType(r3.getPictureType());
        r0.setWidth(r3.getWidth());
        r0.setHeight(r3.getHeight());
        r0.setSize(r3.getSize());
        r0.setCompressPath(r3.getCompressPath());
        r0.setOrigin(r4);
        return r0;
    }

    public static void ma0(LarkPhotoPickerView r2, @StoragePermissionUtils.PartialPermissionState int r3) {
        r2.i();
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L14;
        r2.g(false);
        return;
    L14:
        return;
    L9:
        if (r2.j() == true) goto L13;
        r2.g(false);
        return;
    }

    public static void oa0(LarkPhotoPickerView r2, FileSelectConfig r3) {
        r2.setMaxCount(r3.maxSelectImageNum);
        r2.setSingleShowSelector(r3.showSingleSelector);
        r2.setIsShowOriginalCheckBox(r3.showOrigin);
        boolean r0 = true;
        r2.setToastTotalMaxCount(true);
        r2.setOriginChecked(r3.isOrigin);
        r2.setShowGif(r3.showGif);
        r2.setShowVideo(r3.showVideo);
        r2.setImageVideoExclusive(!r3.mixSelect);
        if (1 == r3.actionType) goto L6;
        r0 = false;
    L6:
        r2.setInConfirmMode(r0);
    }

    public final VFSFile ea0(VFSFile r9, VFSFile r10) {
        if (Intrinsics.areEqual(r9.getPath(), r10.getPath()) == false) goto L8;
        tt5.a.h("FileSelectorFragment", "Copy file manually.");
        String r0 = r9.getName();
        Intrinsics.checkNotNull(r0);
        String r1 = "Luban_" + System.currentTimeMillis() + UUID.randomUUID() + r0.substring(StringsKt.lastIndexOf$default(r0, ".", 0, false, 6, null));
        VFSPath r2 = du5.c.a(getContext());
        if (r2 == null) goto L9;
        VFSFile r11 = r2.subPath(r1).toFile();
        FileUtils.j(r9.getVfsPath(), r11.getVfsPath());
        return r11;
    L9:
        return r10;
    L8:
        return r10;
    }

    public final void ia0(List<Photo> r9, boolean r10) {
        if (r9.size() != 0) goto L6;
        tt5.a.k("FileSelectorFragment", "The selected photo is empty.");
        da0();
        return;
    L6:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        FileSelectConfig r1 = this.h;
        UDDialog r2 = null;
        if (r1 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r1.isOriginFile);
    L10:
        if (r10 == false) goto L12;
    L23:
        Flowable r4 = Flowable.fromIterable(r9);
        Intrinsics.checkNotNull(r4);
    L24:
        this.n.add(r4.map(new b(this, r10, r0)).collect(c.a, d.a).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new e(r0, this, r9), new f(r0, this, r9, r10)));
        return;
    L12:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L23;
        ab5.d r5 = new ab5.d(requireActivity());
        r0.element = r5;
        g r6 = new g(this, r9, r10);
        Intrinsics.checkNotNullParameter(r9, "selectedPhoto");
        Intrinsics.checkNotNullParameter(r6, "photoCompressClose");
        r5.i = r6;
        ip5.a r7 = new ip5.a(r5.g).title(2131889459);
        r7.a = 0;
        UDDialog r8 = r7.controller(r5.d).addActionButton(2131391777, 2131887716, new ab5.c(r5)).width(r5.e).marginInDp(0).cancelOnTouchOutside(false).build();
        r5.f = r8;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
    L18:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r2);
    L22:
        r5.k = r9.size();
        tt5.a.h(r5.h, "show compress dialog");
        r4 = Flowable.create(new ab5.b(r9, r5, r10), BackpressureStrategy.BUFFER);
        goto L24
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L21:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L22
    L16:
        r2 = r8;
        goto L18
    L9:
        r3 = null;
        goto L10
    }

    public static final List aa0(FileSelectFragment r1, List r2, boolean r3) {
        r1.getClass();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(la0((Photo) r5.next(), r3));
        goto L4
    L6:
        return r4;
    }

    public final void ja0(Dialog r5, View r6, int r7) {
        r5.requestWindowFeature(1);     // Catch: Exception -> L24
        if (getContext() == null) goto L13;
        ViewParent r2 = r6.getParent();     // Catch: Exception -> L24
        if ((r2 instanceof ViewGroup) == false) goto L8;
        ViewGroup r3 = (ViewGroup) r2;     // Catch: Exception -> L24
    L9:
        if (r3 == null) goto L11;
        r3.removeAllViews();     // Catch: Exception -> L24
    L11:
        r5.setContentView(r6);     // Catch: Exception -> L24
        goto L13
    L8:
        r3 = null;
    L13:
        if (r5.getWindow() == null) goto L41;
        Window r8 = r5.getWindow();     // Catch: Exception -> L24
        if (r8 == null) goto L18;
        WindowManager.LayoutParams r9 = r8.getAttributes();     // Catch: Exception -> L24
        if (r9 == null) goto L18;
    L20:
        if ((getContext() instanceof Activity) == false) goto L26;
        Context r4 = getContext();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L24
        if (Z90(((Activity) r4).getWindow()).getWindowToken() == null) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        r9.type = UploadResult.UPLOAD_CACELL;     // Catch: Exception -> L24
    L29:
        r9.width = -1;     // Catch: Exception -> L24
        r9.height = r7;     // Catch: Exception -> L24
        r9.softInputMode = 1;     // Catch: Exception -> L24
        r9.flags = (r9.flags | 264) & (-3);     // Catch: Exception -> L24
        r9.gravity = 80;     // Catch: Exception -> L24
        Window r11 = r5.getWindow();     // Catch: Exception -> L24
        if (r11 == null) goto L32;
        r11.setAttributes(r9);     // Catch: Exception -> L24
    L32:
        Window r12 = r5.getWindow();     // Catch: Exception -> L24
        if (r12 == null) goto L35;
        r12.setBackgroundDrawableResource(2131103546);     // Catch: Exception -> L24
    L35:
        r5.setCanceledOnTouchOutside(false);     // Catch: Exception -> L24
        return;
    L26:
        r10 = false;
    L18:
        r9 = new WindowManager.LayoutParams();     // Catch: Exception -> L24
        goto L20
    L41:
        return;
    L24:
        e = move-exception;
        tt5.a.e("FileSelectorFragment", "initDialog error", e, false);
    }

    public final void onActivityResult(int r12, int r13, Intent r14) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r12, r13, r14);
        tt5.a.h("FileSelectorFragment", "onActivityResult()... requestCode = " + r12 + ", resultCode = " + r13);
        if (r12 != 233) goto L5;
    L80:
        FileSelectConfig r0 = this.h;
        if (r0 == null) goto L85;
        bb5.a r1 = r0.backToPickerViewListener;
        if (r1 == null) goto L85;
        SelectMediaViewModel.Mo(((j45.d) r1).a);
    L85:
        tt5.a.h("FileSelectorFragment", "LarkPhotoView handleActivityResult...");
        LarkPhotoPickerView r2 = fa0();
        if (r2 == null) goto L101;
        r2.e(r12, r13, r14);
        return;
    L101:
        return;
    L5:
        if (r12 == 911) goto L80;
        if (r14 != null) goto L10;
        tt5.a.k("FileSelectorFragment", "The activity result data is null.");
        da0();
        return;
    L10:
        if (r12 != 1) goto L17;
        if (r13 != (-1)) goto L17;
        if (r14.getBooleanExtra("KEY_FOR_SEND", false) == false) goto L15;
        boolean r16 = r14.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        Serializable r17 = r14.getSerializableExtra("KEY_SELECTED_MEDIA");
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ss.android.lark.widget.photopicker.entity.Photo>");
        ia0(TypeIntrinsics.asMutableList(r17), r16);
        return;
    L15:
        tt5.a.k("FileSelectorFragment", "Cancel from full screen album.");
        da0();
        return;
    L17:
        if (r12 != 2) goto L27;
        if (r13 != (-1)) goto L27;
        Serializable r18 = r14.getSerializableExtra("KEY_SELECTED_MEDIA");
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ss.android.lark.widget.photopicker.entity.Photo>");
        List<Photo> r19 = TypeIntrinsics.asMutableList(r18);
        boolean r110 = r14.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        if (q.a(r19) == true) goto L25;
        Photo r111 = (Photo) ListProtector.get(r19, 0);
        String r3 = ((Photo) ListProtector.get(r19, 0)).getMimeType();
        if (r3 != null) goto L24;
        r3 = FileUtils.D(((Photo) ListProtector.get(r19, 0)).getPath());
    L24:
        r111.setMimeType(r3);
        ia0(r19, r110);
        return;
    L25:
        da0();
        tt5.a.k("FileSelectorFragment", "The photo is null.");
        return;
    L27:
        if (r12 != 3) goto L78;
        if (r13 != (-1)) goto L78;
        ArrayList r112 = new ArrayList();
        ClipData r113 = r14.getClipData();
        Context r114 = getContext();
        if (r114 == null) goto L34;
        ApplicationInfo r115 = r114.getApplicationInfo();
        if (r115 == null) goto L34;
        int r116 = r115.targetSdkVersion;
    L35:
        tt5.a.h("FileSelectorFragment", "targetSdkVersion is " + r116);
        if (r116 >= 30) goto L38;
        boolean r117 = false;
    L39:
        if (r113 != null) goto L41;
        tt5.a.h("FileSelectorFragment", "onActivityResult REQUEST_CODE_OPEN_FILE_PICKER no ClipData");
    L72:
        FileSelectConfig r118 = this.h;
        if (r118 == null) goto L77;
        za5.a r119 = r118.fileSelectListener;
        if (r119 == null) goto L77;
        r119.a(r112, r117);
    L77:
        dismissDialog();
        return;
    L41:
        int r4 = r113.getItemCount();
        int r5 = 0;
    L42:
        if (r5 >= r4) goto L72;
        Uri r6 = r113.getItemAt(r5).getUri();
        if (r6 == null) goto L71;
        if (r117 == false) goto L47;
        String r7 = r6.toString();
    L48:
        if (r7 != null) goto L50;
    L53:
        boolean r8 = true;
    L54:
        if (r8 == false) goto L56;
        tt5.a.k("FileSelectorFragment", "The file uri path is null and the uri is " + r6);
        goto L71
    L56:
        FileSelectConfig r9 = this.h;
        if (r9 == null) goto L63;
        long r10 = r9.maxFileSize;
        if (r10 <= 0) goto L63;
        if (r10 >= FileUtils.z(r117, r7)) goto L63;
        boolean r11 = false;
    L64:
        if (r11 == false) goto L66;
        r112.add(r7);
        goto L71
    L66:
        tt5.a.k("FileSelectorFragment", "This file is over size. The filePointer is " + r7);
        FileSelectConfig r20 = this.h;
        if (r20 == null) goto L71;
        bb5.c r21 = r20.fileCheckListener;
        if (r21 == null) goto L71;
        r21.a(FileType.FILE);
    L63:
        r11 = true;
        goto L64
    L50:
        if (r7.length() == 0) goto L53;
        r8 = false;
        goto L54
    L47:
        r7 = c1.c(getContext(), r6);
    L71:
        r5 = r5 + 1;
        goto L42
    L38:
        tt5.a.h("FileSelectorFragment", "Path to uri is enable");
        r117 = true;
    L34:
        r116 = 0;
    L78:
        da0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FileSelectConfig r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L22;
        LarkPhotoPickerView r7 = ka0();
        this.m = r7;
        FrameLayout r8 = ha0(r7);
        FileSelectConfig r9 = this.h;
        if (r9 == null) goto L12;
        ViewGroup r10 = r9.container;
    L13:
        if (r10 == null) goto L21;
        View r11 = r8.getChildAt(0);
        if (r11 == null) goto L21;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L20;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        r13.height = ca0();
        r13.gravity = 80;
        r11.setLayoutParams(r13);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L21:
        return r8;
    L12:
        r10 = null;
        goto L13
    L22:
        tt5.a.k("FileSelectorFragment", "onCreateView with empty config.");
        return super.onCreateView(r4, r5, r6);
    L5:
        if (r0.selectType != 2) goto L7;
        r1 = true;
        goto L8
    }

    public final void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
        if (r3 > 0) goto L4;
        return;
    L4:
        if (rcb.b.a(getActivity()) == true) goto L14;
        Dialog r5 = getDialog();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isShowing() == false) goto L16;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L17;
        View r7 = Z90(r6);
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.height = r3;
        r6.getWindowManager().updateViewLayout(r7, r0);
        return;
    L17:
        return;
    L16:
        return;
    }
}
