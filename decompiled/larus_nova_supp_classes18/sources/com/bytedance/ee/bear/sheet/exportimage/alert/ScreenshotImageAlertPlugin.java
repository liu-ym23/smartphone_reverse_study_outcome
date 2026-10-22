package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.share.g;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;
import com.bytedance.ee.bear.sheet.exportimage.preview.SheetImagePreviewPlugin;
import com.bytedance.ee.bear.sheet.screenshotobserver.ScreenshotObserverPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.lark.android.encryption.CipherManager;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rm5.o;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "listener", "Lcom/bytedance/ee/bear/sheet/screenshotobserver/IScreenshotObserver$OnScreenshotListener;", "screenshotObserverPlugin", "Lcom/bytedance/ee/bear/sheet/screenshotobserver/ScreenshotObserverPlugin;", "orientationPlugin", "Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "shareImageDataPlugin", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel;", "imageAlertHandler", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertPlugin$ShowImageAlertHandler;", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet/common/SheetAnalytic;", "exportImageResultListener", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin$ExportImageResultListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onStop", "onDetachFromUIContainer", "showFragment", "hideFragment", "getReminderFragment", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertFragment;", "shouldDisableLandscape", "", "getCurrentShareTitle", "", "Companion", "ShowImageAlertHandler", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotImageAlertPlugin extends DocumentPlugin implements p {
    public static final String BIZ_UTIL_SHOW_IMAGE_ALERT = "biz.util.showImageAlert";
    public static final a Companion = null;
    public static final String TAG = "ScreenshotImageAlertPlugin";
    private final ShareImageDataPlugin.b exportImageResultListener;
    private b imageAlertHandler;
    private gn5.a listener;
    private BaseUnspecifiedOrientationPlugin<?> orientationPlugin;
    private ScreenshotObserverPlugin screenshotObserverPlugin;
    private ShareImageDataPlugin shareImageDataPlugin;
    private qm5.a sheetAnalytic;
    private ScreenshotImageAlertViewModel viewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<ImageAlertModel> {
        public m a;
        public String b;
        public final /* synthetic */ ScreenshotImageAlertPlugin c;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(ScreenshotImageAlertPlugin r1) {
            this.c = r1;
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "actionId");
            JSONObject r0 = new JSONObject();
            r0.put(ResourceData.KEY_ID, r3);
            m r4 = this.a;
            if (r4 == null) goto L6;
            r4.b(r0);
            return;
        }

        public final void handle(Object r4, m r5) {
            ImageAlertModel r6 = (ImageAlertModel) r4;
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "showImageAlert. data" + r6);
            if (CipherManager.d() != 1) goto L5;
            tt5.a.k(ScreenshotImageAlertPlugin.TAG, "showImageAlert, cipher is on");
            return;
        L5:
            this.a = r5;
            Boolean r7 = ImageAlertModel.isValid(r6);
            ScreenshotImageAlertViewModel r0 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.c);
            if (r0 == null) goto L10;
            MutableLiveData<Boolean> r1 = r0.getActive();
            if (r1 == null) goto L10;
            r1.setValue(r7);
        L10:
            if (r6 == null) goto L13;
            String r2 = r6.getSource();
            if (r2 == null) goto L13;
        L14:
            this.b = r2;
            if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L17;
            ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.c).b("show_screenshot_dialog");
            HashMap r8 = new HashMap();
            r8.put("click", "smart_screencapture");
            r8.put("target", "none");
            qm5.b.b("ccm_sheet_content_page_click", r8);
        L17:
            ScreenshotImageAlertViewModel r9 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.c);
            if (r9 == null) goto L22;
            MutableLiveData<ImageAlertModel> r10 = r9.getImageAlertData();
            if (r10 == null) goto L22;
            r10.setValue(r6);
        L22:
            ShareImageDataPlugin r11 = ScreenshotImageAlertPlugin.access$getShareImageDataPlugin$p(this.c);
            if (r11 == null) goto L27;
            r11.setExportImageResultListener(ScreenshotImageAlertPlugin.access$getExportImageResultListener$p(this.c));
            return;
        L27:
            return;
        L13:
            r2 = "";
            goto L14
        }
    }

    public static final class c implements ShareImageDataPlugin.b {
        public final /* synthetic */ ScreenshotImageAlertPlugin a;

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onCancel() {
            ScreenshotImageAlertViewModel r0 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L7;
            MutableLiveData<Boolean> r1 = r0.getActive();
            if (r1 == null) goto L7;
            r1.setValue(Boolean.FALSE);
        L7:
            ShareImageDataPlugin r2 = ScreenshotImageAlertPlugin.access$getShareImageDataPlugin$p(this.a);
            if (r2 == null) goto L10;
            r2.setExportImageResultListener(null);
        L10:
            ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a).f("stopTransfer");
        }

        public c(ScreenshotImageAlertPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void a(VFSFile r4) {
            ScreenshotImageAlertViewModel r0 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L7;
            MutableLiveData<File> r1 = r0.getImageBitmap();
            if (r1 == null) goto L7;
            r1.setValue(r4);
        L7:
            ShareImageDataPlugin r5 = ScreenshotImageAlertPlugin.access$getShareImageDataPlugin$p(this.a);
            if (r5 == null) goto L10;
            r5.setExportImageResultListener(null);
        L10:
            qm5.a r6 = ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a);
            b r2 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r2 == null) goto L14;
            String r3 = r2.b;
            if (r3 == null) goto L14;
        L15:
            r6.getClass();
            HashMap r7 = new HashMap();
            r7.put("source", r3);
            r6.c("export_image_success", r7);
            return;
        L14:
            r3 = "";
            goto L15
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onFail(String r3) {
            ShareImageDataPlugin r0 = ScreenshotImageAlertPlugin.access$getShareImageDataPlugin$p(this.a);
            if (r0 == null) goto L5;
            r0.setExportImageResultListener(null);
        L5:
            ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a).f(r3);
        }
    }

    public static final class d implements ScreenshotImageAlertViewModel.a {
        public final /* synthetic */ ScreenshotImageAlertPlugin a;

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final void a() {
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "Save sheet exported image.");
            b r0 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r0 == null) goto L5;
            r0.a("leftBtn");
        L5:
            qm5.a r1 = ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a);
            b r2 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r2 == null) goto L9;
            String r3 = r2.b;
            if (r3 == null) goto L9;
        L10:
            r1.e(r3, o.a(ShareType.Download));
            qm5.b.c("save");
            return;
        L9:
            r3 = "";
            goto L10
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final void c() {
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "Share sheet image.");
            b r0 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r0 == null) goto L5;
            r0.a("rightBtn");
        L5:
            qm5.b.c("share");
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final void onClose() {
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "Close image alert.");
            ScreenshotImageAlertViewModel r0 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L7;
            MutableLiveData<Boolean> r1 = r0.getActive();
            if (r1 == null) goto L7;
            r1.setValue(Boolean.FALSE);
        L7:
            b r2 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r2 == null) goto L10;
            r2.a("exit");
        L10:
            qm5.b.c("close");
        }

        public d(ScreenshotImageAlertPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final void d(ShareType r5) {
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TYPE);
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Share sheet image succeed. type : " + r5.name());
            qm5.a r0 = ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a);
            b r1 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r1 == null) goto L6;
            String r2 = r1.b;
            if (r2 == null) goto L6;
        L7:
            String r6 = o.a(r5);
            r0.getClass();
            HashMap r3 = new HashMap();
            r3.put("source", r2);
            r3.put("op_item", r6);
            r0.c("share_export_image_success", r3);
            return;
        L6:
            r2 = "";
            goto L7
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final void e(ShareType r3) {
            Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "onShareToExternalApp... channel = " + r3.name());
            qm5.a r0 = ScreenshotImageAlertPlugin.access$getSheetAnalytic$p(this.a);
            b r1 = ScreenshotImageAlertPlugin.access$getImageAlertHandler$p(this.a);
            if (r1 == null) goto L6;
            String r2 = r1.b;
            if (r2 == null) goto L6;
        L7:
            r0.e(r2, o.a(r3));
            return;
        L6:
            r2 = "";
            goto L7
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel.a
        public final boolean b(ShareItemModel r9, File r10) {
            Intrinsics.checkNotNullParameter(r9, "shareItem");
            Intrinsics.checkNotNullParameter(r10, "shareImage");
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "doShareCustom... itemId = " + r9.getItemId());
            ShareItemModel.a r0 = r9.getOnClickedListener();
            if (r0 == null) goto L11;
            Context r1 = ScreenshotImageAlertPlugin.access$getContext(this.a);
            ScreenshotImageAlertViewModel r3 = ScreenshotImageAlertPlugin.access$getViewModel$p(this.a);
            if (r3 == null) goto L7;
            String r4 = r3.getShareUrl();
        L8:
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            return r0.a(r1, r9, new g(r4, ShareItemUtil.b(ScreenshotImageAlertPlugin.access$getContext(this.a), ScreenshotImageAlertPlugin.access$getCurrentShareTitle(this.a), 3), null, r10));
        L7:
            r4 = null;
            goto L8
        L11:
            return false;
        }
    }

    public static final class e implements gn5.a {
        public final /* synthetic */ ScreenshotImageAlertPlugin a;

        public e(ScreenshotImageAlertPlugin r1) {
            this.a = r1;
        }

        @Override // gn5.a
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
            tt5.a.h(ScreenshotImageAlertPlugin.TAG, "Notify js bridge Screenshot occurred.");
            ScreenshotImageAlertPlugin.access$execJS(this.a, "javascript:window.lark.biz.sheet.onScreenShot", new JSONObject());
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return true;
    }

    private final String getCurrentShareTitle() {
        ScreenshotImageAlertViewModel r0 = this.viewModel;
        if (r0 == null) goto L10;
        MutableLiveData<ImageAlertModel> r1 = r0.getImageAlertData();
        if (r1 == null) goto L10;
        ImageAlertModel r2 = (ImageAlertModel) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.getTitle();
        if (r3 == null) goto L10;
        return r3;
    L10:
        DocViewModel r4 = getDocViewModel();
        if (r4 == null) goto L17;
        LiveData r5 = r4.getTitle();
        if (r5 == null) goto L17;
        CharSequence r6 = (CharSequence) r5.getValue();
        if (r6 == null) goto L17;
        return r6.toString();
    L17:
        return "";
    }

    private final void hideFragment() {
        tt5.a.h(TAG, "Dismiss Screenshot alert dialog...");
        ScreenshotImageAlertFragment r0 = getReminderFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_alert_ScreenshotImageAlertPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    public ScreenshotImageAlertPlugin() {
        this.sheetAnalytic = new qm5.a();
        this.exportImageResultListener = new c(this);
    }

    private final ScreenshotImageAlertFragment getReminderFragment() {
        return getHost().c().getChildFragmentManager().findFragmentByTag(TAG);
    }

    private final void showFragment() {
        if (getReminderFragment() != null) goto L6;
        tt5.a.h(TAG, "Show Screenshot alert dialog...");
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_alert_ScreenshotImageAlertPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateFragment(ScreenshotImageAlertFragment.class), getHost().c().getChildFragmentManager(), TAG);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_alert_ScreenshotImageAlertPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ScreenshotImageAlertFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ Context access$getContext(ScreenshotImageAlertPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ String access$getCurrentShareTitle(ScreenshotImageAlertPlugin r0) {
        return r0.getCurrentShareTitle();
    }

    public static final /* synthetic */ ShareImageDataPlugin.b access$getExportImageResultListener$p(ScreenshotImageAlertPlugin r0) {
        return r0.exportImageResultListener;
    }

    public static final /* synthetic */ b access$getImageAlertHandler$p(ScreenshotImageAlertPlugin r0) {
        return r0.imageAlertHandler;
    }

    public static final /* synthetic */ BaseUnspecifiedOrientationPlugin access$getOrientationPlugin$p(ScreenshotImageAlertPlugin r0) {
        return r0.orientationPlugin;
    }

    public static final /* synthetic */ ShareImageDataPlugin access$getShareImageDataPlugin$p(ScreenshotImageAlertPlugin r0) {
        return r0.shareImageDataPlugin;
    }

    public static final /* synthetic */ qm5.a access$getSheetAnalytic$p(ScreenshotImageAlertPlugin r0) {
        return r0.sheetAnalytic;
    }

    public static final /* synthetic */ ScreenshotImageAlertViewModel access$getViewModel$p(ScreenshotImageAlertPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$hideFragment(ScreenshotImageAlertPlugin r0) {
        r0.hideFragment();
    }

    public static final /* synthetic */ void access$showFragment(ScreenshotImageAlertPlugin r0) {
        r0.showFragment();
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        b r4 = new b(this);
        this.imageAlertHandler = r4;
        bindBridgeHandler(BIZ_UTIL_SHOW_IMAGE_ALERT, r4);
        ScreenshotImageAlertViewModel r5 = (ScreenshotImageAlertViewModel) viewModel(ScreenshotImageAlertViewModel.class);
        this.viewModel = r5;
        if (r5 == null) goto L7;
        MutableLiveData<Boolean> r6 = r5.getActive();
        if (r6 == null) goto L7;
        r6.observe(getLifecycleOwner(), new AnonymousClass1(this));
    L7:
        ScreenshotImageAlertViewModel r7 = this.viewModel;
        if (r7 == null) goto L10;
        r7.setDelegete(new d(this));
    L10:
        this.listener = new e(this);
        this.screenshotObserverPlugin = findPlugin(ScreenshotObserverPlugin.class);
        this.orientationPlugin = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        this.shareImageDataPlugin = findPlugin(ShareImageDataPlugin.class);
        ScreenshotImageAlertViewModel r8 = this.viewModel;
        BearUrl r0 = null;
        if (r8 == null) goto L21;
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L17;
        BearUrl r2 = r1.getBearUrl();
        if (r2 == null) goto L17;
        String r9 = r2.e;
    L18:
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r8.setShareUrl(r9);
    L17:
        r9 = null;
    L21:
        qm5.a r10 = this.sheetAnalytic;
        DocViewModel r11 = getDocViewModel();
        if (r11 == null) goto L24;
        r0 = r11.getBearUrl();
    L24:
        r10.a = r0;
    }

    public void onStop(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStop(r2);
        if (AppInfoUtils.f().booleanValue() == false) goto L10;
        ScreenshotImageAlertViewModel r3 = this.viewModel;
        if (r3 == null) goto L11;
        MutableLiveData<Boolean> r4 = r3.getActive();
        if (r4 == null) goto L12;
        r4.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onStop(PluginHost r1) {
        onStop((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        ScreenshotObserverPlugin r3 = this.screenshotObserverPlugin;
        if (r3 == null) goto L6;
        r3.addScreenshotListener(this.listener);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        ScreenshotObserverPlugin r3 = this.screenshotObserverPlugin;
        if (r3 == null) goto L5;
        r3.removeScreenshotListener(this.listener);
    L5:
        ScreenshotImageAlertViewModel r4 = this.viewModel;
        if (r4 == null) goto L11;
        MutableLiveData<Boolean> r5 = r4.getActive();
        if (r5 == null) goto L12;
        r5.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_alert_ScreenshotImageAlertPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ScreenshotImageAlertFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ScreenshotImageAlertFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ void access$execJS(ScreenshotImageAlertPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }
}
