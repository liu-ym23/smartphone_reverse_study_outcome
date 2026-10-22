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
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.PageType;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.fileselector.exception.ImageOverSizeException;
import com.bytedance.ee.bear.fileselector.exception.VideoOverSizeException;
import com.bytedance.ee.bear.fileselector.model.FileSelectConfigModel;
import com.bytedance.ee.bear.fileselector.view.FilePanelDragView;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.q;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttm.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0007H\u0016J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002J\u0018\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020%H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\b\u0010@\u001a\u00020\u0011H\u0002J\u001a\u0010A\u001a\u00020\u00182\u0006\u00107\u001a\u00020B2\b\b\u0001\u0010C\u001a\u000205H\u0002J\u0018\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u0007H\u0002J\"\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u0002052\u0006\u0010I\u001a\u0002052\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u00152\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0002J\u001e\u0010P\u001a\u00020\u00182\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010T\u001a\u00020\u0015H\u0003J$\u0010U\u001a\b\u0012\u0004\u0012\u00020V0R2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010T\u001a\u00020\u0015H\u0002J\b\u0010W\u001a\u00020\u0018H\u0002J\u0018\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0018\u0010[\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020YH\u0002J \u0010]\u001a\u00020\u00182\u0006\u00109\u001a\u00020#2\u0006\u0010^\u001a\u00020%2\u0006\u0010:\u001a\u000205H\u0002J\b\u0010_\u001a\u00020\u0015H\u0002J\u000e\u0010`\u001a\u00020\u00182\u0006\u0010:\u001a\u000205J\b\u0010a\u001a\u00020\u0018H\u0002J\u0010\u0010b\u001a\u00020\u00182\u0006\u00109\u001a\u00020cH\u0016J\u0018\u0010d\u001a\u00020V2\u0006\u0010e\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0015H\u0002J\b\u0010f\u001a\u00020\u0018H\u0016J\b\u0010g\u001a\u00020\u0018H\u0016J\"\u0010h\u001a\u00020\u00182\b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u0002052\u0006\u0010l\u001a\u000205H\u0016J\n\u0010m\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010n\u001a\u00020\u0015H\u0016J\u000e\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u000205J\b\u0010O\u001a\u00020\u0015H\u0002J\n\u0010q\u001a\u0004\u0018\u00010BH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/FileSelectFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "mFileSelectConfig", "Lcom/bytedance/ee/bear/fileselector/api/FileSelectConfig;", "mLuban", "Lcom/bytedance/ee/util/algorithm/Luban;", "mDragView", "Lcom/bytedance/ee/bear/fileselector/view/FilePanelDragView;", "mMainHandler", "Landroid/os/Handler;", "mFileSelectConfigModel", "Lcom/bytedance/ee/bear/fileselector/model/FileSelectConfigModel;", "mSelectContentView", "Landroid/widget/FrameLayout;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isNewLarkFormEnable", "", "isFirstSatrt", "setFileSelectConfig", "", "config", "getFileSelectConfig", "getFileSelectConfig$framework_file_selector_release", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "handleInstanceState", "onSaveInstanceState", "outState", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onDetach", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "adjustHeight", "", "handleHeaderView", "pickerView", "createDialogWithDragView", "dialog", "height", "initDragView", RootDescription.ROOT_ELEMENT, "openFilePicker", "permissionDeniedAndDismiss", "openCcmAlbum", "buildLarkPhotoPickerView", "prepareMedias", "Lcom/ss/android/lark/widget/halfscreen/LarkPhotoPickerView;", "permissionResult", "setupLarkPhotoPickerView", "larkPhotoPickerView", "fileSelectConfig", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "checkFileSize", "filePointer", "", "isFileUseUri", "handlePhoto", "selectedPhoto", "", "Lcom/ss/android/lark/widget/photopicker/entity/Photo;", "isOrigin", "onFail", "Lcom/bytedance/ee/bear/fileselector/bean/FileBean;", "cancelAndDismissDialog", "compressAndCopyImage", "Lcom/ss/android/lark/vfs/VFSFile;", "srcFile", "copyFile", "destFile", "initDialog", "contentView", "isAvailableToken", "resetDialogHeight", "dismissDialog", "onDismiss", "Landroid/content/DialogInterface;", "photo2FileBean", "photo", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "getLuban", "onBackPressed", "removeSelfFromFragmentManager", "animExit", "getLarkPhotoPickerViewOrNull", "Companion", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSelectFragment extends BaseAntiScreenshotsDialogFragment implements ocb.a, sa5.d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f226737q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FileSelectConfig f226738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public du5.c f226739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FilePanelDragView f226740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f226741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FileSelectConfigModel f226742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LarkPhotoPickerView f226743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f226744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f226745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f226746p;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f226748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ab5.a> f226749c;

        public b(FileSelectFragment r100, boolean r101, Ref.ObjectRef<ab5.a> r102) {
            this.f226747a = r100;
            this.f226748b = r101;
            this.f226749c = r102;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            Photo r111 = (Photo) r110;
            Intrinsics.checkNotNullParameter(r111, "photo");
            VFSFile r100 = ay4.d.a().i(r111.getPath());
            boolean r101 = true;
            if (r111.isVideo() == false) goto L20;
            FileSelectConfig r102 = this.f226747a.f226738h;
            if (r102 != null) goto L7;
        L13:
            tt5.a.h("FileSelectorFragment", "photo.width = " + r111.getWidth() + ", photo.height = " + r111.getHeight());
            int[] r103 = VideoTools.getSize(r111.getPath());
            int r104 = r103[0];
            if (r104 > 0) goto L16;
        L18:
            tt5.a.h("FileSelectorFragment", "photo.width = " + r111.getWidth() + ", photo.height = " + r111.getHeight());
        L93:
            if (TextUtils.isEmpty(r111.getCompressPath()) == false) goto L97;
            ab5.a r105 = this.f226749c.element;
            if (r105 == null) goto L97;
            r105.a(r111.getId(), 1.0f);
        L97:
            FileSelectFragment r106 = this.f226747a;
            boolean r107 = this.f226748b;
            int r108 = FileSelectFragment.f226737q;
            r106.getClass();
            return FileSelectFragment.la0(r111, r107);
        L16:
            if (r103[1] <= 0) goto L18;
            r111.setWidth(r104);
            r111.setHeight(r103[1]);
            r111.setSize(r100.length());
            goto L18
        L7:
            if (r102.maxVideoSize <= 0) goto L13;
            if (r100.length() <= r102.maxVideoSize) goto L13;
            throw new VideoOverSizeException("Video over size. Max video size is " + r102.maxVideoSize + " and the video size is " + r100.length());
        L20:
            if (this.f226748b == false) goto L30;
            FileSelectConfig r109 = this.f226747a.f226738h;
            if (r109 == null) goto L30;
            if (r109.maxImageSize <= 0) goto L30;
            if (r100.length() <= r109.maxImageSize) goto L30;
            throw new ImageOverSizeException("Image over size. Max image size is " + r109.maxImageSize + " and the image size is " + r100.length());
        L30:
            FileSelectFragment r112 = this.f226747a;
            boolean r113 = this.f226748b;
            int r114 = FileSelectFragment.f226737q;
            r112.getClass();
            FileSelectConfig r115 = r112.f226738h;     // Catch: Exception -> L87
            if (r115 != null) goto L34;
        L89:
            r111.setPath(r100.getPath());
            if (this.f226747a.f226745o == false) goto L93;
            r111.setSize(r100.length());
            goto L93
        L34:
            if (r115.isOriginFile == true) goto L89;
            String r116 = r100.getPath();     // Catch: Exception -> L87
            if (TextUtils.isEmpty(r116) == true) goto L42;
            String r117 = r116.substring(r116.lastIndexOf("."), r116.length());     // Catch: Exception -> L87
            if (r117.startsWith(EffectConstants.GIF_FILE_SUFFIX) == false) goto L40;
        L43:
            if (r101 == true) goto L89;
            boolean r118 = r115.isOriginFile;     // Catch: Exception -> L87
            VFSFile r119 = null;
            VFSPath r120 = null;
            r120 = null;
            r119 = null;
            if (r118 == false) goto L49;
        L69:
            if (r118 == false) goto L89;
            if (r115.enableImageCompress == false) goto L89;
            if (r113 == true) goto L82;
            du5.c r121 = r112.ga0();     // Catch: Exception -> L87
            if (r121 == null) goto L83;
            VFSPath r122 = r100.getVfsPath();     // Catch: Exception -> L87
            r122 = new du5.c.b(r121.f470045a).c(r122);     // Catch: IOException -> L78 Exception -> L87
        L80:
            if (r122 == null) goto L83;
            r119 = r122.toFile();     // Catch: Exception -> L87
            goto L83
        L78:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
        L83:
            if (r119 != null) goto L86;
            tt5.a.k("FileSelectorFragment", "compress image failed");     // Catch: Exception -> L87
            goto L89
        L86:
            r100 = r119;
            goto L89
        L82:
            r119 = r100;
            goto L83
        L49:
            if (r115.enableImageCompress == false) goto L69;
            tt5.a.b("FileSelectorFragment", "compressImage, isOrigin = " + r113);     // Catch: Exception -> L87
            if (r113 == false) goto L59;
            du5.c r123 = r112.ga0();     // Catch: Exception -> L87
            if (r123 == null) goto L66;
            r120 = r100.getVfsPath();     // Catch: Exception -> L87
            r120 = du5.c.b.a(new du5.c.b(r123.f470045a), r120);     // Catch: Exception -> L57
        L57:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
        L66:
            if (r120 != null) goto L68;
            tt5.a.k("FileSelectorFragment", "compress image failed");     // Catch: Exception -> L87
            goto L89
        L68:
            r100 = r112.ea0(r100, r120.toFile());     // Catch: Exception -> L87
            goto L89
        L59:
            du5.c r124 = r112.ga0();     // Catch: Exception -> L87
            if (r124 == null) goto L66;
            VFSPath r125 = r100.getVfsPath();     // Catch: Exception -> L87
            r120 = new du5.c.b(r124.f470045a).c(r125);     // Catch: IOException -> L64 Exception -> L87
            goto L66
        L64:
            e = move-exception;
            tt5.a.f("Luban", e, false);     // Catch: Exception -> L87
            r120 = r125;
            goto L66
        L40:
            if (r117.startsWith(".GIF") == true) goto L43;
        L42:
            r101 = false;
        L87:
            e = move-exception;
            tt5.a.m("FileSelectorFragment", e);
            goto L89
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<V> f226750a = null;

        static {
            f226750a = new c();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T1, T2> f226751a = null;

        static {
            f226751a = new d();
        }

        public d() {
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) {
            List r102 = (List) r100;
            FileBean r103 = (FileBean) r101;
            if (r102 == null) goto L6;
            Intrinsics.checkNotNull(r103);
            r102.add(r103);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ab5.a> f226752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<Photo> f226754c;

        public e(Ref.ObjectRef<ab5.a> r100, FileSelectFragment r101, List<Photo> r102) {
            this.f226752a = r100;
            this.f226753b = r101;
            this.f226754c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            List r111 = (List) r110;
            ab5.a r100 = this.f226752a.element;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            FileSelectFragment r101 = this.f226753b;
            FileSelectConfig r102 = r101.f226738h;
            if (r102 == null) goto L29;
            List<Photo> r103 = this.f226754c;
            za5.a r104 = r102.fileSelectListener;
            if (r104 == null) goto L20;
            int r105 = ab5.e.f2497a;
            Intrinsics.checkNotNull(r111);
            Intrinsics.checkNotNullParameter(r111, "fileBeanList");
            Intrinsics.checkNotNullParameter(r103, "selectedPhoto");
            ArrayList r106 = new ArrayList();
            Iterator<Photo> r107 = r103.iterator();
        L11:
            if (r107.hasNext() == false) goto L18;
            Photo r108 = r107.next();
            Iterator r109 = r111.iterator();
        L14:
            if (r109.hasNext() == false) goto L11;
            FileBean r112 = (FileBean) r109.next();
            if (r108.getId() != r112.getId()) goto L14;
            r106.add(r112);
            goto L11
        L18:
            r104.c(r106);
        L20:
            if (r102.autoDismiss == false) goto L30;
            r101.dismissDialog();
            return;
        L30:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ab5.a> f226755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<Photo> f226757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f226758d;

        public f(Ref.ObjectRef<ab5.a> r100, FileSelectFragment r101, List<Photo> r102, boolean r103) {
            this.f226755a = r100;
            this.f226756b = r101;
            this.f226757c = r102;
            this.f226758d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ab5.a r102 = this.f226755a.element;
            if (r102 == null) goto L5;
            r102.cancel();
        L5:
            FileSelectFragment r103 = this.f226756b;
            FileSelectConfig r104 = r103.f226738h;
            if (r104 == null) goto L24;
            List<Photo> r105 = this.f226757c;
            boolean r106 = this.f226758d;
            if ((r101 instanceof ImageOverSizeException) == false) goto L13;
            bb5.c r107 = r104.fileCheckListener;
            if (r107 == null) goto L21;
            r107.a(FileType.IMAGE);
        L21:
            if (r104.autoDismiss == false) goto L25;
            r103.dismissDialog();
            return;
        L25:
            return;
        L13:
            if ((r101 instanceof VideoOverSizeException) == false) goto L17;
            bb5.c r108 = r104.fileCheckListener;
            if (r108 == null) goto L21;
            r108.a(FileType.VIDEO);
            goto L21
        L17:
            za5.a r109 = r104.fileSelectListener;
            if (r109 == null) goto L21;
            r109.c(FileSelectFragment.aa0(r103, r105, r106));
            goto L21
        }
    }

    public static final class g implements bb5.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<Photo> f226760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f226761c;

        @Override // bb5.g
        public final void close() {
            FileSelectFragment r100 = this.f226759a;
            FileSelectConfig r101 = r100.f226738h;
            if (r101 == null) goto L12;
            List<Photo> r102 = this.f226760b;
            boolean r103 = this.f226761c;
            za5.a r104 = r101.fileSelectListener;
            if (r104 == null) goto L8;
            r104.c(FileSelectFragment.aa0(r100, r102, r103));
        L8:
            if (r101.autoDismiss == false) goto L10;
            r100.dismissDialog();
            return;
        L10:
            r100.f226744n.clear();
            return;
        }

        public g(FileSelectFragment r100, List<Photo> r101, boolean r102) {
            this.f226759a = r100;
            this.f226760b = r101;
            this.f226761c = r102;
        }
    }

    public static final class h implements com.ss.android.lark.widget.photopicker.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226762a;

        public h(FileSelectFragment r100) {
            this.f226762a = r100;
        }

        @Override // com.ss.android.lark.widget.photopicker.b
        public final void onIntercept(String r100) {
            FileSelectFragment.ba0(this.f226762a);
        }
    }

    public static final class i implements StoragePermissionUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f226764b;

        public i(FileSelectFragment r100, LarkPhotoPickerView r101) {
            this.f226763a = r100;
            this.f226764b = r101;
        }

        @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = r100.f438544a;
            FileSelectFragment r102 = this.f226763a;
            LarkPhotoPickerView r103 = this.f226764b;
            int r104 = FileSelectFragment.f226737q;
            r102.getClass();
            FileSelectFragment.ma0(r103, r101);
        }
    }

    public static final class j implements StoragePermissionUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileSelectFragment f226765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LarkPhotoPickerView f226766b;

        public j(FileSelectFragment r100, LarkPhotoPickerView r101) {
            this.f226765a = r100;
            this.f226766b = r101;
        }

        @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = r100.f438544a;
            FileSelectFragment r102 = this.f226765a;
            LarkPhotoPickerView r103 = this.f226766b;
            int r104 = FileSelectFragment.f226737q;
            r102.getClass();
            FileSelectFragment.ma0(r103, r101);
        }
    }

    static {
    }

    public final int ca0() {
        FileSelectConfig r100 = this.f226738h;
        int r101 = 0;
        if (r100 != null) goto L5;
    L14:
        tt5.a.h("FileSelectorFragment", "adjustHeight height: " + r101);
        return r101;
    L5:
        if (r100.adjustHeightByKeyboard == false) goto L12;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L14;
        if (rcb.b.a(r102) == false) goto L11;
        int r103 = pcb.a.AbstractC7181a.b(r102).keyBoardRawHeightWithOrientation(r102.getResources().getConfiguration().orientation);
    L13:
        r101 = r103;
        goto L14
    L11:
        r103 = pcb.a.AbstractC7181a.b(r102).keyBoardRawHeight();
        goto L13
    L12:
        r103 = Math.max(r100.ccmPickViewHeight, r100.minCcmPickViewHeight);
        goto L13
    }

    public final void da0() {
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L7;
        za5.a r101 = r100.fileSelectListener;
        if (r101 == null) goto L7;
        r101.b();
    L7:
        dismissDialog();
    }

    public final LarkPhotoPickerView fa0() {
        LarkPhotoPickerView r100 = this.f226743m;
        if ((r100 instanceof LarkPhotoPickerView) == false) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView");
        return r100;
    L5:
        return null;
    }

    public final du5.c ga0() {
        if (this.f226739i != null) goto L8;
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L8;
        du5.c r101 = new du5.c(du5.c.a(getContext()));
        int r102 = r100.maxImageCompressSize;
        du5.c.a r103 = r101.f470045a;
        r103.f470046a = r102;
        r103.f470049d = r100.imageCompressType;
        this.f226739i = r101;
    L8:
        return this.f226739i;
    }

    public final LarkPhotoPickerView ka0() {
        LarkPhotoPickerView r100 = new LarkPhotoPickerView(requireContext());
        FileSelectConfig r101 = this.f226738h;
        if (r101 == null) goto L5;
        oa0(r100, r101);
    L5:
        r100.setPhotoPickerListener(new LarkPhotoPickerListener(this, new FileSelectFragment$buildLarkPhotoPickerView$2(this)));
        r100.setClickable(true);
        return r100;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        tt5.a.h("FileSelectorFragment", LiveCommonConstants.REASON_ON_DEDTROY);
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L11;
        FileSelectConfig r101 = this.f226738h;
        if (r101 == null) goto L11;
        if (r100.getSupportFragmentManager().isDestroyed() == true) goto L11;
        if (r101.adjustHeightByKeyboard == false) goto L11;
        pcb.a.AbstractC7181a.b(r100).a(this);
    L11:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L7;
        bb5.b r101 = r100.dialogLifecycle;
        if (r101 == null) goto L7;
        r101.onDetach();
    L7:
        LarkPhotoPickerView r102 = fa0();
        if (r102 == null) goto L10;
        r102.d();
    L10:
        super.onDetach();
    }

    public FileSelectFragment() {
        this.f226741k = new Handler(Looper.getMainLooper());
        this.f226744n = new CompositeDisposable();
        this.f226745o = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.larkform.new.enable");
        this.f226746p = true;
    }

    public final void dismissDialog() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        this.f226744n.clear();
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L8;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L5;
        FragmentManager r101 = r100.getSupportFragmentManager();
    L7:
        if (r101 == null) goto L11;
        FragmentTransaction r102 = r101.beginTransaction();
        r102.setCustomAnimations(0, R.anim.file_selector_panel_exit);
        if (r101.getFragments().contains(this) == false) goto L11;
        r102.remove(this).commitAllowingStateLoss();
    L11:
        FileSelectConfig r103 = this.f226738h;
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r103.isConsumeBackPress != true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("FileSelectorFragment", "onDestroyView in FileSelectFragment");
        FileSelectConfig r100 = this.f226738h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.canDragView == false) goto L11;
        FilePanelDragView r101 = this.f226740j;
        if (r101 == null) goto L12;
        r101.b(true);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L8;
        bb5.b r101 = r100.dialogLifecycle;
        if (r101 == null) goto L9;
        r101.onPause();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("FileSelectorFragment", "onResume");
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L8;
        bb5.b r101 = r100.dialogLifecycle;
        if (r101 == null) goto L9;
        r101.onResume();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        FileSelectConfig r101 = this.f226738h;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L24:
        FileSelectConfig r104 = this.f226738h;
        if (r104 == null) goto L30;
        bb5.b r105 = r104.dialogLifecycle;
        if (r105 == null) goto L30;
        r105.onStart();
    L30:
        if (this.f226746p == false) goto L54;
        this.f226746p = false;
        LarkPhotoPickerView r106 = fa0();
        if (r106 == null) goto L55;
        FragmentActivity r107 = getActivity();
        if (r107 != null) goto L36;
        tt5.a.h("FileSelectorFragment", "activity is null");
        ma0(r106, 2);
        return;
    L36:
        new HashMap();
        int r108 = StoragePermissionUtils.a(r107, StoragePermissionUtils.d(r107, 2));
        StoragePermissionUtils.a(r107, StoragePermissionUtils.d(r107, 4));
        StoragePermissionUtils.d(r107, 8);
        StoragePermissionUtils.e(r107);
        if (r108 == 2) goto L39;
        boolean r109 = true;
    L40:
        tt5.a.h("FileSelectorFragment", "hasPhotoPermission = " + r109);
        if (r109 == false) goto L43;
        new HashMap();
        int r110 = StoragePermissionUtils.a(r107, StoragePermissionUtils.d(r107, 2));
        StoragePermissionUtils.a(r107, StoragePermissionUtils.d(r107, 4));
        StoragePermissionUtils.d(r107, 8);
        StoragePermissionUtils.e(r107);
        ma0(r106, r110);
        return;
    L43:
        FileSelectConfig r111 = this.f226738h;
        if (r111 != null) goto L46;
    L48:
        r102 = false;
    L50:
        if (r102 == false) goto L52;
        StoragePermissionUtils.f(r107, new i(this, r106), 22, new Token("LARK-PSDA-ccm_android_photopickerview_request_permission"), new String[0]);
        return;
    L52:
        StoragePermissionUtils.f(r107, new j(this, r106), 2, new Token("LARK-PSDA-ccm_android_photopickerview_request_permission"), new String[0]);
        return;
    L46:
        if (r111.showVideo != true) goto L48;
    L39:
        r109 = false;
        goto L40
    L55:
        return;
    L54:
        return;
    L10:
        if (this.f226743m == null) goto L24;
        if (r100 == null) goto L24;
        Window r112 = r100.getWindow();
        if (r112 == null) goto L17;
        WindowManager.LayoutParams r113 = r112.getAttributes();
        if (r113 == null) goto L17;
        r113.height = ca0();
    L17:
        Window r114 = r100.getWindow();
        if (r114 == null) goto L24;
        Window r115 = r100.getWindow();
        if (r115 == null) goto L22;
        WindowManager.LayoutParams r116 = r115.getAttributes();
    L23:
        r114.setAttributes(r116);
        goto L24
    L22:
        r116 = null;
        goto L23
    L5:
        if (r101.selectType != 2) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L8;
        bb5.b r101 = r100.dialogLifecycle;
        if (r101 == null) goto L9;
        r101.onStop();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final PageType V90() {
        return PageType.NORMAL;
    }

    public static View Z90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final void ba0(FileSelectFragment r100) {
        FileSelectConfig r101 = r100.f226738h;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNull(r101);
        bb5.f r102 = r101.permissionCheckListener;
        if (r102 == null) goto L8;
        r102.onPermissionDenied();
    L8:
        r100.f226741k.postDelayed(new com.bytedance.ee.bear.fileselector.c(r100), 100);
        return;
    L7:
        tt5.a.k("FileSelectorFragment", "permissionDeniedAndDismiss with empty config.");
        goto L8
    }

    public final FrameLayout ha0(LarkPhotoPickerView r100) {
        Context r101 = getContext();
        if (r101 == null) goto L14;
        FrameLayout r102 = new FrameLayout(r101);
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setOrientation(1);
        r102.addView(r103);
        FileSelectConfig r104 = this.f226738h;
        if (r104 != null) goto L7;
    L12:
        r103.addView(r100);
        return r102;
    L7:
        if (r104.headerViewRes == (-1)) goto L9;
        r103.addView(LayoutInflater.from(getContext()).inflate(r104.headerViewRes, null));
        goto L12
    L9:
        View r105 = r104.headView;
        if (r105 == null) goto L12;
        r103.addView(r105);
        goto L12
    L14:
        return r100;
    }

    public final void na0(FileSelectConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f226738h = r100;
        FileSelectConfigModel r101 = this.f226742l;
        if (r101 == null) goto L5;
        r101.setFileSelectConfig(r100);
    L5:
        LarkPhotoPickerView r102 = this.f226743m;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.isAttachedToWindow() == true) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L19;
        LarkPhotoPickerView r104 = fa0();
        if (r104 == null) goto L18;
        oa0(r104, r100);
        r104.b();
        return;
    L18:
        return;
    L19:
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        FileSelectConfig r101 = this.f226738h;
        if (r101 == null) goto L8;
        bb5.b r102 = r101.dialogLifecycle;
        if (r102 == null) goto L9;
        r102.b(ca0());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FileSelectConfigModel r101 = (FileSelectConfigModel) new ViewModelProvider(requireActivity()).get(FileSelectConfigModel.class);
        this.f226742l = r101;
        if (r100 == null) goto L9;
        if (r101 == null) goto L6;
        FileSelectConfig r102 = r101.getFileSelectConfig();
    L7:
        if (r102 == null) goto L9;
        this.f226738h = r102;
        goto L9
    L6:
        r102 = null;
    L9:
        FileSelectConfig r103 = this.f226738h;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNull(r103);
        if (r103.adjustHeightByKeyboard == false) goto L16;
        pcb.a.AbstractC7181a.b(getActivity()).c(this);
        return;
    L16:
        return;
    L14:
        tt5.a.k("FileSelectorFragment", "onCreate with empty config.");
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r100 == null) goto L5;
        return r101;
    L5:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L45;
        FileSelectConfig r103 = this.f226738h;
        if (r103 == null) goto L44;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.selectType;
        if (r104 != 0) goto L12;
        tt5.a.k("FileSelectorFragment", "Unknown Operate Type!");
        goto L45
    L12:
        if (r104 != 1) goto L14;
        ja0(r101, new View(r102), 10);
        int r105 = com.bytedance.ee.bear.fileselector.h.f226795a;
        final FileSelectConfig r106 = this.f226738h;
        final Context r107 = getContext();
        if (r107 == null) goto L45;
        com.bytedance.ee.bear.fileselector.a.a(r107, new FileSelectFragment$onCreateDialog$lambda$4$$inlined$openLarkCamara$1(r107, this, r106, r107, this));
        goto L45
    L14:
        if (r104 != 2) goto L16;
        int r108 = ca0();
        FileSelectConfig r109 = this.f226738h;
        Intrinsics.checkNotNull(r109);
        if (r109.canDragView == true) goto L31;
        LarkPhotoPickerView r110 = ka0();
        this.f226743m = r110;
        Intrinsics.checkNotNull(r110);
        ja0(r101, ha0(r110), r108);
        FileSelectConfig r111 = this.f226738h;
        Intrinsics.checkNotNull(r111);
        r111.getClass();
        goto L45
    L31:
        View r112 = LayoutInflater.from(getContext()).inflate(R.layout.file_panel_dialog_fragment, null, false);
        Intrinsics.checkNotNull(r112);
        FilePanelDragView r113 = (FilePanelDragView) r112.findViewById(R.id.file_dragview);
        this.f226740j = r113;
        if (r113 == null) goto L39;
        FileSelectConfig r114 = this.f226738h;
        if (r114 != null) goto L36;
    L38:
        r113.b(false);
        r113.f226797w.a();
        r113.addView(ka0());
        r113.setOnHeightChangeListener(new com.bytedance.ee.bear.fileselector.b(r113, this));
        goto L39
    L36:
        if (r114.canDragView == true) goto L38;
        r113.getDragHandler().setVisibility(8);
        r113.getTopBar().setVisibility(8);
        ViewGroup.LayoutParams r115 = r113.getTopBar().getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        UDShadowLayout.LayoutParams r116 = (UDShadowLayout.LayoutParams) r115;
        ((ViewGroup.MarginLayoutParams) r116).topMargin = 0;
        r113.getTopBar().setLayoutParams(r116);
    L39:
        ja0(r101, r112, r108);
        goto L45
    L16:
        if (r104 != 3) goto L18;
        ja0(r101, new View(r102), 10);
        int r117 = com.bytedance.ee.bear.fileselector.h.f226795a;
        FileSelectConfig r118 = this.f226738h;
        Context r119 = getContext();
        if (r119 == null) goto L45;
        if (r118 == null) goto L45;
        int r120 = s.C;
        com.ss.android.lark.widget.photopicker.e r121 = new com.ss.android.lark.widget.photopicker.e(s.b.a(new PhotoPickerLauncher$openFullScreenAlbum$1$1$1(r118)));
        r121.f447470d = new h(this);
        r121.b(r119, this, 1);
        goto L45
    L18:
        if (r104 != 4) goto L45;
        ja0(r101, new View(r102), 10);
        FileSelectConfig r122 = this.f226738h;
        if (r122 == null) goto L23;
        pm4.a r123 = new pm4.a(this, 3, 0);
        r123.f529836k = r122.showFilterMenu;
        r123.f529835j = r122.customSendBtnTips;
        com.bytedance.ee.android.file.picker.lib.a.b(r123);
        goto L45
    L23:
        tt5.a.k("FileSelectorFragment", "openFilePicker with empty config.");
        goto L45
    L44:
        tt5.a.k("FileSelectorFragment", "onCreateDialog with empty config.");
    L45:
        FileSelectConfig r124 = this.f226738h;
        if (r124 == null) goto L50;
        bb5.b r125 = r124.dialogLifecycle;
        if (r125 == null) goto L50;
        r125.a(r101);
    L50:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r100);     // Catch: Throwable -> L9
        FileSelectConfig r101 = this.f226738h;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        bb5.h r102 = r101.onDismissListener;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onDismiss();     // Catch: Throwable -> L9
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        FileSelectConfig r101 = this.f226738h;
        if (r101 == null) goto L8;
        FileSelectConfigModel r102 = this.f226742l;
        if (r102 == null) goto L9;
        r102.setFileSelectConfig(r101);
        return;
    L9:
        return;
    }

    public static FileBean la0(Photo r100, boolean r101) {
        FileBean r102 = new FileBean();
        r102.setId(r100.getId());
        r102.setPath(r100.getPath());
        r102.setMimeType(r100.getMimeType());
        r102.setDuration(r100.getDuration());
        r102.setChecked(r100.isChecked());
        r102.position = r100.position;
        r102.setNum(r100.getNum());
        r102.setPictureType(r100.getPictureType());
        r102.setWidth(r100.getWidth());
        r102.setHeight(r100.getHeight());
        r102.setSize(r100.getSize());
        r102.setCompressPath(r100.getCompressPath());
        r102.setOrigin(r101);
        return r102;
    }

    public static void ma0(LarkPhotoPickerView r100, @StoragePermissionUtils.PartialPermissionState int r101) {
        r100.i();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L14;
        r100.g(false);
        return;
    L14:
        return;
    L9:
        if (r100.j() == true) goto L13;
        r100.g(false);
        return;
    }

    public static void oa0(LarkPhotoPickerView r100, FileSelectConfig r101) {
        r100.setMaxCount(r101.maxSelectImageNum);
        r100.setSingleShowSelector(r101.showSingleSelector);
        r100.setIsShowOriginalCheckBox(r101.showOrigin);
        boolean r102 = true;
        r100.setToastTotalMaxCount(true);
        r100.setOriginChecked(r101.isOrigin);
        r100.setShowGif(r101.showGif);
        r100.setShowVideo(r101.showVideo);
        r100.setImageVideoExclusive(!r101.mixSelect);
        if (1 == r101.actionType) goto L6;
        r102 = false;
    L6:
        r100.setInConfirmMode(r102);
    }

    public final VFSFile ea0(VFSFile r100, VFSFile r110) {
        if (Intrinsics.areEqual(r100.getPath(), r110.getPath()) == false) goto L8;
        tt5.a.h("FileSelectorFragment", "Copy file manually.");
        String r101 = r100.getName();
        Intrinsics.checkNotNull(r101);
        String r102 = "Luban_" + System.currentTimeMillis() + UUID.randomUUID() + r101.substring(StringsKt.lastIndexOf$default(r101, ".", 0, false, 6, null));
        VFSPath r103 = du5.c.a(getContext());
        if (r103 == null) goto L9;
        VFSFile r111 = r103.subPath(r102).toFile();
        FileUtils.j(r100.getVfsPath(), r111.getVfsPath());
        return r111;
    L9:
        return r110;
    L8:
        return r110;
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [T, ab5.d] */
    public final void ia0(List<Photo> r100, boolean r110) {
        if (r100.size() != 0) goto L6;
        tt5.a.k("FileSelectorFragment", "The selected photo is empty.");
        da0();
        return;
    L6:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        FileSelectConfig r102 = this.f226738h;
        UDDialog r103 = null;
        if (r102 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r102.isOriginFile);
    L10:
        if (r110 == false) goto L12;
    L23:
        Flowable r105 = Flowable.fromIterable(r100);
        Intrinsics.checkNotNull(r105);
    L24:
        this.f226744n.add(r105.map(new b(this, r110, r101)).collect(c.f226750a, d.f226751a).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).subscribe(new e(r101, this, r100), new f(r101, this, r100, r110)));
        return;
    L12:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L23;
        ?? r106 = new ab5.d(requireActivity());
        r101.element = r106;
        g r107 = new g(this, r100, r110);
        Intrinsics.checkNotNullParameter(r100, "selectedPhoto");
        Intrinsics.checkNotNullParameter(r107, "photoCompressClose");
        r106.f2492i = r107;
        ip5.a r108 = new ip5.a(r106.f2490g).title(R.string.LarkCCM_Drive_Compressing_Title);
        r108.f495305a = 0;
        UDDialog r109 = r108.controller(r106.f2487d).addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_Cancel, new ab5.c(r106)).width(r106.f2488e).marginInDp(0).cancelOnTouchOutside(false).build();
        r106.f2489f = r109;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
    L18:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r103);
    L22:
        r106.f2494k = r100.size();
        tt5.a.h(r106.f2491h, "show compress dialog");
        r105 = Flowable.create(new ab5.b(r100, r106, r110), BackpressureStrategy.BUFFER);
        goto L24
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L21:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L22
    L16:
        r103 = r109;
        goto L18
    L9:
        r104 = null;
        goto L10
    }

    public static final List aa0(FileSelectFragment r100, List r101, boolean r102) {
        r100.getClass();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(la0((Photo) r104.next(), r102));
        goto L4
    L6:
        return r103;
    }

    public final void ja0(Dialog r100, View r101, int r102) {
        r100.requestWindowFeature(1);     // Catch: Exception -> L24
        if (getContext() == null) goto L13;
        ViewParent r103 = r101.getParent();     // Catch: Exception -> L24
        if ((r103 instanceof ViewGroup) == false) goto L8;
        ViewGroup r104 = (ViewGroup) r103;     // Catch: Exception -> L24
    L9:
        if (r104 == null) goto L11;
        r104.removeAllViews();     // Catch: Exception -> L24
    L11:
        r100.setContentView(r101);     // Catch: Exception -> L24
        goto L13
    L8:
        r104 = null;
    L13:
        if (r100.getWindow() == null) goto L41;
        Window r105 = r100.getWindow();     // Catch: Exception -> L24
        if (r105 == null) goto L18;
        WindowManager.LayoutParams r106 = r105.getAttributes();     // Catch: Exception -> L24
        if (r106 == null) goto L18;
    L20:
        if ((getContext() instanceof Activity) == false) goto L26;
        Context r107 = getContext();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L24
        if (Z90(((Activity) r107).getWindow()).getWindowToken() == null) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L29;
        r106.type = 1000;     // Catch: Exception -> L24
    L29:
        r106.width = -1;     // Catch: Exception -> L24
        r106.height = r102;     // Catch: Exception -> L24
        r106.softInputMode = 1;     // Catch: Exception -> L24
        r106.flags = (r106.flags | MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME) & (-3);     // Catch: Exception -> L24
        r106.gravity = 80;     // Catch: Exception -> L24
        Window r109 = r100.getWindow();     // Catch: Exception -> L24
        if (r109 == null) goto L32;
        r109.setAttributes(r106);     // Catch: Exception -> L24
    L32:
        Window r110 = r100.getWindow();     // Catch: Exception -> L24
        if (r110 == null) goto L35;
        r110.setBackgroundDrawableResource(R.color.lkui_transparent);     // Catch: Exception -> L24
    L35:
        r100.setCanceledOnTouchOutside(false);     // Catch: Exception -> L24
        return;
    L26:
        r108 = false;
    L18:
        r106 = new WindowManager.LayoutParams();     // Catch: Exception -> L24
        goto L20
    L41:
        return;
    L24:
        e = move-exception;
        tt5.a.e("FileSelectorFragment", "initDialog error", e, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r110, int r111, Intent r112) {
        super.onActivityResult(r110, r111, r112);
        tt5.a.h("FileSelectorFragment", "onActivityResult()... requestCode = " + r110 + ", resultCode = " + r111);
        if (r110 != 233) goto L5;
    L80:
        FileSelectConfig r100 = this.f226738h;
        if (r100 == null) goto L85;
        bb5.a r101 = r100.backToPickerViewListener;
        if (r101 == null) goto L85;
        SelectMediaViewModel.Mo(((j45.d) r101).f497366a);
    L85:
        tt5.a.h("FileSelectorFragment", "LarkPhotoView handleActivityResult...");
        LarkPhotoPickerView r102 = fa0();
        if (r102 == null) goto L101;
        r102.e(r110, r111, r112);
        return;
    L101:
        return;
    L5:
        if (r110 == 911) goto L80;
        if (r112 != null) goto L10;
        tt5.a.k("FileSelectorFragment", "The activity result data is null.");
        da0();
        return;
    L10:
        if (r110 != 1) goto L17;
        if (r111 != (-1)) goto L17;
        if (r112.getBooleanExtra("KEY_FOR_SEND", false) == false) goto L15;
        boolean r113 = r112.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        Serializable r114 = r112.getSerializableExtra("KEY_SELECTED_MEDIA");
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ss.android.lark.widget.photopicker.entity.Photo>");
        ia0(TypeIntrinsics.asMutableList(r114), r113);
        return;
    L15:
        tt5.a.k("FileSelectorFragment", "Cancel from full screen album.");
        da0();
        return;
    L17:
        if (r110 != 2) goto L27;
        if (r111 != (-1)) goto L27;
        Serializable r115 = r112.getSerializableExtra("KEY_SELECTED_MEDIA");
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.collections.MutableList<com.ss.android.lark.widget.photopicker.entity.Photo>");
        List<Photo> r116 = TypeIntrinsics.asMutableList(r115);
        boolean r117 = r112.getBooleanExtra("KEEP_ORIGIN_PHOTO", false);
        if (q.a(r116) == true) goto L25;
        Photo r118 = (Photo) ListProtector.get(r116, 0);
        String r103 = ((Photo) ListProtector.get(r116, 0)).getMimeType();
        if (r103 != null) goto L24;
        r103 = FileUtils.D(((Photo) ListProtector.get(r116, 0)).getPath());
    L24:
        r118.setMimeType(r103);
        ia0(r116, r117);
        return;
    L25:
        da0();
        tt5.a.k("FileSelectorFragment", "The photo is null.");
        return;
    L27:
        if (r110 != 3) goto L78;
        if (r111 != (-1)) goto L78;
        ArrayList r119 = new ArrayList();
        ClipData r120 = r112.getClipData();
        Context r121 = getContext();
        if (r121 == null) goto L34;
        ApplicationInfo r122 = r121.getApplicationInfo();
        if (r122 == null) goto L34;
        int r123 = r122.targetSdkVersion;
    L35:
        tt5.a.h("FileSelectorFragment", "targetSdkVersion is " + r123);
        if (r123 >= 30) goto L38;
        boolean r124 = false;
    L39:
        if (r120 != null) goto L41;
        tt5.a.h("FileSelectorFragment", "onActivityResult REQUEST_CODE_OPEN_FILE_PICKER no ClipData");
    L72:
        FileSelectConfig r125 = this.f226738h;
        if (r125 == null) goto L77;
        za5.a r126 = r125.fileSelectListener;
        if (r126 == null) goto L77;
        r126.a(r119, r124);
    L77:
        dismissDialog();
        return;
    L41:
        int r104 = r120.getItemCount();
        int r105 = 0;
    L42:
        if (r105 >= r104) goto L72;
        Uri r106 = r120.getItemAt(r105).getUri();
        if (r106 == null) goto L71;
        if (r124 == false) goto L47;
        String r107 = r106.toString();
    L48:
        if (r107 != null) goto L50;
    L53:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L56;
        tt5.a.k("FileSelectorFragment", "The file uri path is null and the uri is " + r106);
        goto L71
    L56:
        FileSelectConfig r109 = this.f226738h;
        if (r109 == null) goto L63;
        long r127 = r109.maxFileSize;
        if (r127 <= 0) goto L63;
        if (r127 >= FileUtils.z(r124, r107)) goto L63;
        boolean r128 = false;
    L64:
        if (r128 == false) goto L66;
        r119.add(r107);
        goto L71
    L66:
        tt5.a.k("FileSelectorFragment", "This file is over size. The filePointer is " + r107);
        FileSelectConfig r129 = this.f226738h;
        if (r129 == null) goto L71;
        bb5.c r130 = r129.fileCheckListener;
        if (r130 == null) goto L71;
        r130.a(FileType.FILE);
    L63:
        r128 = true;
        goto L64
    L50:
        if (r107.length() == 0) goto L53;
        r108 = false;
        goto L54
    L47:
        r107 = c1.c(getContext(), r106);
    L71:
        r105 = r105 + 1;
        goto L42
    L38:
        tt5.a.h("FileSelectorFragment", "Path to uri is enable");
        r124 = true;
    L34:
        r123 = 0;
    L78:
        da0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FileSelectConfig r103 = this.f226738h;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L22;
        LarkPhotoPickerView r105 = ka0();
        this.f226743m = r105;
        FrameLayout r106 = ha0(r105);
        FileSelectConfig r107 = this.f226738h;
        if (r107 == null) goto L12;
        ViewGroup r108 = r107.container;
    L13:
        if (r108 == null) goto L21;
        View r109 = r106.getChildAt(0);
        if (r109 == null) goto L21;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L20;
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r110;
        r111.height = ca0();
        r111.gravity = 80;
        r109.setLayoutParams(r111);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L21:
        return r106;
    L12:
        r108 = null;
        goto L13
    L22:
        tt5.a.k("FileSelectorFragment", "onCreateView with empty config.");
        return super.onCreateView(r100, r101, r102);
    L5:
        if (r103.selectType != 2) goto L7;
        r104 = true;
        goto L8
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        if (r101 > 0) goto L4;
        return;
    L4:
        if (rcb.b.a(getActivity()) == true) goto L14;
        Dialog r103 = getDialog();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isShowing() == false) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L17;
        View r105 = Z90(r104);
        WindowManager.LayoutParams r106 = r104.getAttributes();
        r106.height = r101;
        r104.getWindowManager().updateViewLayout(r105, r106);
        return;
    L17:
        return;
    L16:
        return;
    }
}
