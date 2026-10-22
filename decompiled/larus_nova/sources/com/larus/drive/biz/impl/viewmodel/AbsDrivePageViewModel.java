package com.larus.drive.biz.impl.viewmodel;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.doc.api.IDocService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.dialog.DriveInputConfirmDialog;
import com.larus.drive.biz.impl.file.DriveLocalFileSelector;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.DriveMainFragment;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\tH$J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001cJ\u0016\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&J\u0010\u0010.\u001a\u00020\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "hostCallback", "Lcom/larus/drive/biz/impl/viewmodel/callback/IDrivePageHostCallback;", "needRefreshAfterOnResume", "", "currentFolderToken", "", "getCurrentFolderToken", "()Ljava/lang/String;", "setCurrentFolderToken", "(Ljava/lang/String;)V", "currentFolderDriveToken", "getCurrentFolderDriveToken", "setCurrentFolderDriveToken", "createFileCanceller", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "eventParams", "Lorg/json/JSONObject;", "larkDriveConfig", "Lcom/larus/platform/model/LarkDriveConfig;", "getLarkDriveConfig", "()Lcom/larus/platform/model/LarkDriveConfig;", "larkDriveConfig$delegate", "Lkotlin/Lazy;", "onCleared", "", "getTag", "setEventParams", "driveLocalFileSelectorListener", "com/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1", "getDriveLocalFileSelectorListener", "()Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1;", "driveLocalFileSelectorListener$delegate", "getMoreActionMenuList", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "ctx", "Landroid/content/Context;", "onResume", "handleMoreActionMenuItemClick", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", MapController.ITEM_LAYER_TAG, "setHostCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDrivePageViewModel extends ViewModel {
    private nc5.b createFileCanceller;
    private String currentFolderDriveToken;
    private String currentFolderToken;
    private final Lazy driveLocalFileSelectorListener$delegate;
    private JSONObject eventParams;
    private q79.a hostCallback;
    private final Lazy larkDriveConfig$delegate;
    private boolean needRefreshAfterOnResume;

    public static final class a implements m79.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDrivePageViewModel f341512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f341513b;

        @Override // m79.g
        public final void d() {
        }

        @Override // m79.g
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "input");
            nc5.b r101 = AbsDrivePageViewModel.access$getCreateFileCanceller$p(this.f341512a);
            if (r101 == null) goto L5;
            r101.cancel();
        L5:
            AbsDrivePageViewModel r102 = this.f341512a;
            DriveSdkService r103 = DriveSdkService.f341224a;
            String r104 = r102.getCurrentFolderDriveToken();
            DriveFileType r105 = DriveFileType.FOLDER;
            final AbsDrivePageViewModel r106 = this.f341512a;
            Function1<? super DriveFileItem, Unit> r107 = new w(r106);
            final Fragment r108 = this.f341513b;
            AbsDrivePageViewModel.access$setCreateFileCanceller$p(r102, r103.R(r104, r105, r100, r107, new x(r106, r108)));
        }

        @Override // m79.g
        public final boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "input");
            int r101 = AbsDrivePageViewModel.access$getLarkDriveConfig(this.f341512a).d();
            if (r100.length() <= r101) goto L6;
            t19.s r102 = t19.s.f544207a;
            FragmentActivity r103 = this.f341513b.getActivity();
            String r104 = this.f341513b.getString(R.string.larus_create_bot_notice_length);
            r102.getClass();
            t19.s.t(r103, r104);
            return false;
        L6:
            return true;
        }

        @Override // m79.g
        public final Pair<Boolean, String> c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "input");
            int r101 = AbsDrivePageViewModel.access$getLarkDriveConfig(this.f341512a).d();
            if (r100.length() <= r101) goto L7;
            t19.s r102 = t19.s.f544207a;
            FragmentActivity r103 = this.f341513b.getActivity();
            String r104 = this.f341513b.getString(R.string.larus_create_bot_notice_length);
            r102.getClass();
            t19.s.t(r103, r104);
            return TuplesKt.to(Boolean.TRUE, StringsKt.take(r100, r101));
        L7:
            return TuplesKt.to(Boolean.FALSE, r100);
        }

        public a(AbsDrivePageViewModel r100, Fragment r101) {
            this.f341512a = r100;
            this.f341513b = r101;
        }
    }

    public static /* synthetic */ Unit Mo(AbsDrivePageViewModel r100, Fragment r101, String r102) {
        return handleMoreActionMenuItemClick$lambda$3(r100, r101, r102);
    }

    public static /* synthetic */ AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 No(AbsDrivePageViewModel r100) {
        return driveLocalFileSelectorListener_delegate$lambda$1(r100);
    }

    public static /* synthetic */ c2 Oo() {
        return larkDriveConfig_delegate$lambda$0();
    }

    public static /* synthetic */ Unit yo(AbsDrivePageViewModel r100, Fragment r101, DriveFileItem r102) {
        return handleMoreActionMenuItemClick$lambda$2(r100, r101, r102);
    }

    public abstract String getTag();

    private final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 getDriveLocalFileSelectorListener() {
        return (AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1) this.driveLocalFileSelectorListener$delegate.getValue();
    }

    private final c2 getLarkDriveConfig() {
        return (c2) this.larkDriveConfig$delegate.getValue();
    }

    private static final c2 larkDriveConfig_delegate$lambda$0() {
        return z2.f365865a.getLarkDriveConfig();
    }

    public final void onResume() {
        if (this.needRefreshAfterOnResume == true) goto L5;
        return;
    L5:
        this.needRefreshAfterOnResume = false;
        q79.a r100 = this.hostCallback;
        if (r100 == null) goto L9;
        r100.refresh();
        return;
    }

    public AbsDrivePageViewModel() {
        this.larkDriveConfig$delegate = LazyKt.lazy(new u());
        this.driveLocalFileSelectorListener$delegate = LazyKt.lazy(new v(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        nc5.b r100 = this.createFileCanceller;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public final String getCurrentFolderDriveToken() {
        return this.currentFolderDriveToken;
    }

    public final String getCurrentFolderToken() {
        return this.currentFolderToken;
    }

    public static final /* synthetic */ nc5.b access$getCreateFileCanceller$p(AbsDrivePageViewModel r100) {
        return r100.createFileCanceller;
    }

    public static final /* synthetic */ JSONObject access$getEventParams$p(AbsDrivePageViewModel r100) {
        return r100.eventParams;
    }

    public static final /* synthetic */ q79.a access$getHostCallback$p(AbsDrivePageViewModel r100) {
        return r100.hostCallback;
    }

    public static final /* synthetic */ c2 access$getLarkDriveConfig(AbsDrivePageViewModel r100) {
        return r100.getLarkDriveConfig();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.drive.biz.impl.viewmodel.AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1] */
    private static final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 driveLocalFileSelectorListener_delegate$lambda$1(final AbsDrivePageViewModel r100) {
        return new AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1(r100);
    }

    public final List<ot8.a> getMoreActionMenuList(Context r129) {
        Intrinsics.checkNotNullParameter(r129, "ctx");
        int r100 = com.larus.drive.biz.impl.utils.n.f341282a;
        Intrinsics.checkNotNullParameter(r129, "ctx");
        ArrayList r101 = new ArrayList();
        if (Build.VERSION.SDK_INT <= 29) goto L32;
        r101.add(new l0(10001, 0, r129.getString(R.string.larus_drive_add_newDoc), null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_drive_page_menu_doc), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        boolean r103 = false;
        if (r102 == null) goto L30;
        LaunchInfo r104 = r102.f297186a;
        if (r104 == null) goto L30;
        String r105 = r104.W();
        if (r105 == null) goto L30;
        List<z0> r106 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r105);
        Object r107 = null;
        if (r106 == null) goto L28;
        Iterator<T> r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L27;
        Object r109 = r108.next();
        com.larus.bmhome.actionbar.model.r r110 = ((z0) r109).f295621q;
        if (r110 == null) goto L24;
        Integer r111 = r110.f295408a;
        if (r111 == null) goto L24;
        if (r111.intValue() != 30) goto L24;
        boolean r112 = true;
    L25:
        if (r112 == false) goto L15;
        r107 = r109;
    L24:
        r112 = false;
    L27:
        r107 = (z0) r107;
    L28:
        if (r107 == null) goto L30;
        r103 = true;
    L30:
        if (r103 == false) goto L32;
        r101.add(new l0(10002, 0, r129.getString(R.string.larus_drive_add_newSlides), null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_drive_page_menu_ppt), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
    L32:
        r101.add(new l0(10003, 0, r129.getString(R.string.larus_drive_add_newFolder), null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_drive_page_menu_folder), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        r101.add(new i0(1, ContextCompat.getColor(r129, v19.c.b(R.attr.larus_neutral_transparent_1, r129, R.color.larus_neutral_transparent_1))));
        r101.add(new l0(10004, 0, r129.getString(R.string.larus_slides_mobile_editor_btn_UploadImage), null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_drive_page_menu_pic), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        r101.add(new l0(10005, 0, r129.getString(R.string.larus_memo_record_action_menu_upload), null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_drive_page_menu_upload_file), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        return r101;
    }

    public final void setCurrentFolderDriveToken(String r100) {
        this.currentFolderDriveToken = r100;
    }

    public final void setCurrentFolderToken(String r100) {
        this.currentFolderToken = r100;
    }

    public void setEventParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "eventParams");
        this.eventParams = r100;
    }

    public final void setHostCallback(q79.a r100) {
        this.hostCallback = r100;
    }

    public static final /* synthetic */ void access$setCreateFileCanceller$p(AbsDrivePageViewModel r100, nc5.b r101) {
        r100.createFileCanceller = r101;
    }

    public final void handleMoreActionMenuItemClick(final Fragment r100, ot8.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        String r102 = null;
        switch(r101.getId()) {
            case 10001: goto L18;
            case 10002: goto L8;
            case 10003: goto L7;
            case 10004: goto L6;
            case 10005: goto L5;
            default: goto L30;
        };
    L5:
        DriveLocalFileSelector r103 = DriveLocalFileSelector.f341191a;
        final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 r104 = getDriveLocalFileSelectorListener();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r104, "listener");
        DriveLocalFileSelector.b(r100, new com.larus.drive.biz.impl.file.d(r100, r104));
        return;
    L6:
        DriveLocalFileSelector r105 = DriveLocalFileSelector.f341191a;
        final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 r106 = getDriveLocalFileSelectorListener();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r106, "listener");
        DriveLocalFileSelector.b(r100, new com.larus.drive.biz.impl.file.c(r100, r106));
        return;
    L7:
        int r107 = DriveInputConfirmDialog.f341173n;
        DriveInputConfirmDialog.a r108 = new DriveInputConfirmDialog.a();
        r108.f341184a = r100.getString(R.string.larus_drive_newFolder_header);
        r108.f341186c = r100.getString(R.string.larus_drive_newFolder_name_placeholder);
        r108.f341187d = r100.getString(R.string.larus_drive_newFolder_btn_add);
        r108.f341188e = r100.getString(R.string.larus_drive_newFolder_btn_cancel);
        r108.f341189f = r100.getString(R.string.larus_drive_toast_nameEmpty);
        a r109 = new a(this, r100);
        Intrinsics.checkNotNullParameter(r109, "callback");
        r108.f341190g = r109;
        INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDrivePageViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r108.a(), r100.getParentFragmentManager(), null);
        return;
    L8:
        e0 r110 = AuthModelDelegate.f297134b.e().getValue();
        if (r110 == null) goto L26;
        LaunchInfo r111 = r110.f297186a;
        if (r111 == null) goto L27;
        String r112 = r111.W();
        if (r112 == null) goto L28;
        com.bytedance.router.i r113 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//flow/chat_page");
        Pair[] r114 = new Pair[4];
        r114[0] = TuplesKt.to("bot_id", r112);
        r114[1] = TuplesKt.to("actionbar_instruction_type", 30);
        r114[2] = TuplesKt.to("slide_create_from_drive", Boolean.TRUE);
        WeakReference<DriveMainFragment> r115 = DriveMainFragment.f341322w;
        if (DriveMainFragment.a.a() == null) goto L17;
        r102 = "ai_space_list";
    L17:
        r114[3] = TuplesKt.to("argPreviousPage", r102);
        Bundle r116 = com.larus.utils.f.c(r114);
        r113.f267554c.putExtras(r116);
        r113.d();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L18:
        this.needRefreshAfterOnResume = true;
        nc5.b r117 = this.createFileCanceller;
        if (r117 == null) goto L21;
        r117.cancel();
    L21:
        this.createFileCanceller = DriveSdkService.f341224a.R(this.currentFolderDriveToken, DriveFileType.AI_DOC, null, new s(this, r100), new t(this, r100));
        return;
    }

    public static void INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDrivePageViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DriveInputConfirmDialog r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        DriveInputConfirmDialog r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    private static final Unit handleMoreActionMenuItemClick$lambda$2(AbsDrivePageViewModel r100, Fragment r101, DriveFileItem r102) {
        String r103 = null;
        r100.createFileCanceller = null;
        FLogger r104 = FLogger.f375446a;
        String r105 = r100.getTag();
        StringBuilder r106 = new StringBuilder("createDriveFile success, fileToken[");
        if (r102 == null) goto L5;
        String r107 = r102.f341565b;
    L6:
        r106.append(r107);
        r106.append("], fileDriveToken[");
        if (r102 == null) goto L9;
        String r108 = r102.f341566c;
    L10:
        r106.append(r108);
        r106.append(']');
        r104.i(r105, r106.toString());
        q79.a r109 = r100.hostCallback;
        if (r109 == null) goto L13;
        r109.refresh();
    L13:
        FragmentActivity r110 = r101.getActivity();
        if (r110 == null) goto L16;
        if (r102 == null) goto L19;
        IDocService.Companion r111 = IDocService.f330931a;
        Pair[] r112 = new Pair[3];
        r112[0] = TuplesKt.to("key_doc_id", r102.f341565b);
        WeakReference<DriveMainFragment> r113 = DriveMainFragment.f341322w;
        DriveMainFragment r114 = DriveMainFragment.a.a();
        if (r114 == null) goto L23;
        r103 = r114.b();
    L23:
        r112[1] = TuplesKt.to("key_click_previous_page", r103);
        r112[2] = TuplesKt.to("key_doc_enter_from", "ai_space_create_blank_doc");
        Bundle r115 = BundleKt.bundleOf(r112);
        DriveMainFragment.a.a();
        r111.Z9(r110, r115, "ai_space_list");
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L9:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    private static final Unit handleMoreActionMenuItemClick$lambda$3(AbsDrivePageViewModel r100, Fragment r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "it");
        r100.createFileCanceller = null;
        t19.s r103 = t19.s.f544207a;
        FragmentActivity r104 = r101.getActivity();
        String r105 = r101.getString(R.string.larus_error_try_again);
        r103.getClass();
        t19.s.t(r104, r105);
        FLogger.f375446a.e(r100.getTag(), "createDriveFile error, msg = " + r102);
        return Unit.INSTANCE;
    }
}
