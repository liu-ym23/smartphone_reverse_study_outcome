package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.content.ClipData;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;
import com.bytedance.ee.bear.watermark.interfaces.CCMWatermarkInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u00020\u00012\u00020\u0002:\n=>?@ABCDEFB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010(\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020 H\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u0013H\u0002J\u0010\u00101\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0002J\u001c\u00106\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020 H\u0016J\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\b\u0010-\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010;\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/ImagePreviewViewModel;", "showShareOperationListHandler", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewPlugin$ShowShareOperationListHandler;", "shareOperationViewMessageHandler", "Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewPlugin$ShareOperationViewMessageHandler;", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet/common/SheetAnalytic;", "imageFile", "Ljava/io/File;", "watermarkedImageFile", "userComponentAbility", "Lcom/bytedance/ee/bear/usercomponent/DocUserComponentAbility;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onShareText", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "text", "onCustomShareText", "", "shareItem", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "canShareImage", "canPassCipherImageGuard", "onShareImage", "canCustomShareImage", "onCustomShareImage", "notifyCustomShareImage", "isWatermarkRemainingEnable", "shareImageInner", "getImageFileForShare", "Lio/reactivex/Single;", "originalFile", "isWatermarkEnabled", "reportClickShareExportImage", "reportExportImageSuccess", "reportShareExportImageSuccess", "cancelToastAndListener", "sheetImageDataPlugin", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin;", "cancelListener", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "shouldDisableLandscape", "getWatermarkedImage", "getCurrentShareUrl", "getCurrentShareTitle", "Companion", "ShowLoadingHandler", "HideLoadingHandler", "ShowTitleHandler", "HideTitleHandler", "WatermarkInfoHandler", "SheetWatermarkInfo", "ShowShareOperationListHandler", "HideShareOperationListHandler", "ShareOperationViewMessageHandler", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetImagePreviewPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    public static final String BIZ_NAVIGATION_HIDE_TITLE = "biz.navigation.hideTitle";
    public static final String BIZ_NAVIGATION_SHOW_TITLE = "biz.navigation.showTitle";
    public static final String BIZ_SHEET_GET_WATERMARK_INFO = "biz.sheet.getWatermarkInfo";
    public static final String BIZ_SHEET_HIDE_LOADING = "biz.sheet.hideLoading";
    public static final String BIZ_SHEET_SHARE_OPERATION_VIEW_MESSAGE = "biz.sheet.shareOpreationViewMessage";
    public static final String BIZ_SHEET_SHOW_LOADING = "biz.sheet.showLoading";
    public static final String BIZ_UTIL_HIDE_SHARE_OPERATION_LIST = "biz.util.hideShareOpreationList";
    public static final String BIZ_UTIL_SHOW_SHARE_OPERATION_LIST = "biz.util.showShareOpreationList";
    public static final a Companion = null;
    public static final String JS_BIZ_NAVIGATION_EXIT = "javascript:lark.biz.navigation.exit";
    public static final String SOURCE_CARDVIEW = "cardview";
    public static final String SOURCE_CARDVIEW_PANEL = "cardview_panel";
    public static final String TAG = "SheetImagePreviewPlugin";
    private File imageFile;
    private e shareOperationViewMessageHandler;
    private qm5.a sheetAnalytic;
    private g showShareOperationListHandler;
    private wo5.b userComponentAbility;
    private ImagePreviewViewModel viewModel;
    private File watermarkedImageFile;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/preview/SheetImagePreviewPlugin$SheetWatermarkInfo;", "Lcom/bytedance/ee/bear/watermark/interfaces/CCMWatermarkInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "obviousWatermarkEnabled", "", "getObviousWatermarkEnabled", "()Ljava/lang/Integer;", "setObviousWatermarkEnabled", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "build", "watermarkInfo", "watermarkData", "Lcom/ss/android/lark/watermark/dto/WatermarkData;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SheetWatermarkInfo extends CCMWatermarkInfo {

        @JSONField(name = "obvious_watermark_enabled")
        private Integer obviousWatermarkEnabled;

        public SheetWatermarkInfo() {
        }

        public final Integer getObviousWatermarkEnabled() {
            return this.obviousWatermarkEnabled;
        }

        public final void setObviousWatermarkEnabled(Integer r1) {
            this.obviousWatermarkEnabled = r1;
        }

        public final SheetWatermarkInfo build(CCMWatermarkInfo r2, WatermarkData r3) {
            Intrinsics.checkNotNullParameter(r2, "watermarkInfo");
            Intrinsics.checkNotNullParameter(r3, "watermarkData");
            setAlpha(r2.getAlpha().toString());
            setBgColor(r2.getBgColor().toString());
            setDark_opacity(r2.getDark_opacity().toString());
            setDensity(r2.getDensity().toString());
            setWatermarkTag(r2.getWatermarkTag());
            setFont_size(r2.getFont_size().toString());
            setRotate_angle(r2.getRotate_angle().toString());
            setWatermarkContent(r2.getWatermarkContent());
            setContent(r2.getContent());
            if (r3.getObviousEnabled() == false) goto L5;
            int r4 = 1;
        L6:
            this.obviousWatermarkEnabled = Integer.valueOf(r4);
            return this;
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<Unit> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, tb5.m r2) {
            Unit r3 = (Unit) r1;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Hide loading.");
            ImagePreviewViewModel r4 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r4 == null) goto L8;
            MutableLiveData<Boolean> r5 = r4.getShowLoading();
            if (r5 == null) goto L9;
            r5.setValue(Boolean.FALSE);
            return;
        L9:
            return;
        }
    }

    public final class c implements tb5.i<Unit> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, tb5.m r2) {
            Unit r3 = (Unit) r1;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Hide ShareOperationList.");
            ImagePreviewViewModel r4 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r4 == null) goto L8;
            MutableLiveData<Boolean> r5 = r4.getShowShare();
            if (r5 == null) goto L9;
            r5.setValue(Boolean.FALSE);
            return;
        L9:
            return;
        }
    }

    public final class d implements tb5.i<Unit> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public d(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, tb5.m r2) {
            Unit r3 = (Unit) r1;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Hide title.");
            ImagePreviewViewModel r4 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r4 == null) goto L7;
            MutableLiveData<Boolean> r5 = r4.getActive();
            if (r5 == null) goto L7;
            r5.setValue(Boolean.FALSE);
        L7:
            ImagePreviewViewModel r6 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r6 == null) goto L13;
            MutableLiveData<PreviewTitleModel> r7 = r6.getTitleData();
            if (r7 == null) goto L14;
            r7.setValue(null);
            return;
        L14:
            return;
        }
    }

    public final class e implements tb5.i<ShareOperationTypeModel> {
        public tb5.m a;
        public final /* synthetic */ SheetImagePreviewPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public e(SheetImagePreviewPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r3, tb5.m r4) {
            ShareOperationTypeModel r5 = (ShareOperationTypeModel) r3;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "ShareOperationViewMessage. data :" + r5);
            ImagePreviewViewModel r0 = SheetImagePreviewPlugin.access$getViewModel$p(this.b);
            if (r0 == null) goto L7;
            MutableLiveData<ShareOperationTypeModel> r1 = r0.getOperationType();
            if (r1 == null) goto L7;
            r1.setValue(r5);
        L7:
            ImagePreviewViewModel r6 = SheetImagePreviewPlugin.access$getViewModel$p(this.b);
            if (r6 == null) goto L12;
            MutableLiveData<Boolean> r7 = r6.getCalSharePanelHeight();
            if (r7 == null) goto L12;
            r7.setValue(Boolean.TRUE);
        L12:
            this.a = r4;
        }
    }

    public final class f implements tb5.i<Unit> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public f(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, tb5.m r2) {
            Unit r3 = (Unit) r1;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Show loading.");
            ImagePreviewViewModel r4 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r4 == null) goto L7;
            MutableLiveData<Boolean> r5 = r4.getActive();
            if (r5 == null) goto L7;
            r5.setValue(Boolean.TRUE);
        L7:
            ImagePreviewViewModel r6 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r6 == null) goto L13;
            MutableLiveData<Boolean> r7 = r6.getShowLoading();
            if (r7 == null) goto L14;
            r7.setValue(Boolean.TRUE);
            return;
        L14:
            return;
        }
    }

    public final class g implements tb5.i<ShowShareOperationListModel> {
        public tb5.m a;
        public String b;
        public final /* synthetic */ SheetImagePreviewPlugin c;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public g(SheetImagePreviewPlugin r1) {
            this.c = r1;
            this.b = "";
        }

        public final void handle(Object r3, tb5.m r4) {
            ShowShareOperationListModel r5 = (ShowShareOperationListModel) r3;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Show ShareOperationList.");
            ImagePreviewViewModel r0 = SheetImagePreviewPlugin.access$getViewModel$p(this.c);
            if (r0 == null) goto L7;
            MutableLiveData<Boolean> r1 = r0.getShowShare();
            if (r1 == null) goto L7;
            r1.setValue(Boolean.TRUE);
        L7:
            this.a = r4;
            if (r5 == null) goto L11;
            String r6 = r5.getSource();
            if (r6 == null) goto L11;
        L12:
            this.b = r6;
            return;
        L11:
            r6 = "";
            goto L12
        }
    }

    public final class h implements tb5.i<PreviewTitleModel> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public h(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r2, tb5.m r3) {
            PreviewTitleModel r4 = (PreviewTitleModel) r2;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Show title. data: " + r4);
            ImagePreviewViewModel r5 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r5 == null) goto L8;
            MutableLiveData<PreviewTitleModel> r6 = r5.getTitleData();
            if (r6 == null) goto L9;
            r6.setValue(r4);
            return;
        L9:
            return;
        }
    }

    public final class i implements tb5.i<Unit> {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public i(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r7, tb5.m r8) {
            Unit r9 = (Unit) r7;
            boolean r0 = wo5.d.a(SheetImagePreviewPlugin.access$getUserComponentAbility$p(this.a), "admin.security.watermark.file.switch");
            boolean r1 = wo5.d.a(SheetImagePreviewPlugin.access$getUserComponentAbility$p(this.a), "admin.security.watermark.file.switch.sheet");
            boolean r2 = wo5.d.a(SheetImagePreviewPlugin.access$getUserComponentAbility$p(this.a), "admin.watermark.filewatermark.remaining");
            tt5.a.h(SheetImagePreviewPlugin.TAG, "getWatermarkInfo, watermarkEnable=" + r0 + ", watermarkSheetEnable=" + r1 + ", watermarkRemainingEnable=" + r2);
            if (r8 != null) goto L5;
            tt5.a.k(SheetImagePreviewPlugin.TAG, "getWatermarkInfo callback is null");
            return;
        L5:
            if (r2 == false) goto L7;
            r8.b(new JSONObject());
            return;
        L7:
            zo5.b r3 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
            if (r0 == true) goto L10;
            r8.a(r3.a());
            return;
        L10:
            if (r1 == false) goto L17;
            r8.b(new JSONObject());
            return;
        L17:
            SheetWatermarkInfo r4 = new SheetWatermarkInfo().build(r3.a(), r3.getWatermarkData(WatermarkType.EXPORT));     // Catch: Exception -> L14
            tt5.a.b(SheetImagePreviewPlugin.TAG, "build=" + r4);     // Catch: Exception -> L14
            r8.a(r4);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            tt5.a.d(SheetImagePreviewPlugin.TAG, "WatermarkInfoHandler fail: " + e);
            r8.a(r3.a());
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ File a;

        public j(File r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Boolean) r2, "it");
            return this.a;
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public k(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Boolean) r2, "it");
            return SheetImagePreviewPlugin.access$getWatermarkedImageFile$p(this.a);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        public l(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            File r4 = (File) r3;
            StringBuilder r0 = new StringBuilder("[watermark remaining] generated file=");
            if (r4 == null) goto L5;
            String r1 = r4.getAbsolutePath();
        L6:
            r0.append(r1);
            tt5.a.h(SheetImagePreviewPlugin.TAG, r0.toString());
            SheetImagePreviewPlugin.access$setWatermarkedImageFile$p(this.a, r4);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class m<T, R> implements Function {
        public static final m<T, R> a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final Object apply(Object r2) {
            VFSPath r3 = (VFSPath) r2;
            Intrinsics.checkNotNullParameter(r3, "path");
            return r3.toFile().getAbsoluteFile();
        }
    }

    public static final class n implements Action {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final void run() {
            Toast.cancelLoading();
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ ShareItemModel a;
        public final /* synthetic */ SheetImagePreviewPlugin b;

        public o(ShareItemModel r1, SheetImagePreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            File r9 = (File) r8;
            ShareItemModel.a r0 = this.a.getOnClickedListener();
            if (r0 == null) goto L5;
            boolean r10 = r0.a(SheetImagePreviewPlugin.access$getContext(this.b), this.a, new com.bytedance.ee.bear.share.g(SheetImagePreviewPlugin.access$getCurrentShareUrl(this.b), SheetImagePreviewPlugin.access$getCurrentShareTitle(this.b), null, r9));
        L6:
            tt5.a.d(SheetImagePreviewPlugin.TAG, "notifyCustomShareImage, getImageFileForShare success, shareType: " + this.a.getType() + ", consumed: " + r10);
            if (r10 == false) goto L9;
            return;
        L9:
            if (this.a.getType() == null) goto L13;
            SheetImagePreviewPlugin.access$onShareImage(this.b, this.a.getType());
            return;
        L13:
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ ShareItemModel a;
        public final /* synthetic */ SheetImagePreviewPlugin b;

        public p(ShareItemModel r1, SheetImagePreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            ShareItemModel.a r0 = this.a.getOnClickedListener();
            if (r0 == null) goto L5;
            boolean r1 = r0.a(SheetImagePreviewPlugin.access$getContext(this.b), this.a, new com.bytedance.ee.bear.share.g(SheetImagePreviewPlugin.access$getCurrentShareUrl(this.b), SheetImagePreviewPlugin.access$getCurrentShareTitle(this.b), null, null));
        L6:
            tt5.a.d(SheetImagePreviewPlugin.TAG, "notifyCustomShareImage, getImageFileForShare failed, shareType: " + this.a.getType() + ", consumed: " + r1 + ", error: " + r9);
            if (r1 == false) goto L9;
            return;
        L9:
            if (this.a.getType() == null) goto L13;
            SheetImagePreviewPlugin.access$onShareImage(this.b, this.a.getType());
            return;
        L13:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class q implements ImagePreviewViewModel.a {
        public final /* synthetic */ SheetImagePreviewPlugin a;

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final void onClose() {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Close ImagePreviewFragment.");
            SheetImagePreviewPlugin.access$execJS(this.a, SheetImagePreviewPlugin.JS_BIZ_NAVIGATION_EXIT, new JSONObject());
        }

        public q(SheetImagePreviewPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final boolean a(ShareItemModel r2) {
            Intrinsics.checkNotNullParameter(r2, "shareItem");
            return SheetImagePreviewPlugin.access$canCustomShareImage(this.a, r2);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final boolean b(ShareType r2) {
            Intrinsics.checkNotNullParameter(r2, "shareType");
            return SheetImagePreviewPlugin.access$canShareImage(this.a, r2);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final void c(ShareType r3) {
            Intrinsics.checkNotNullParameter(r3, "shareType");
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Share image to external app. shareType: " + r3.name());
            SheetImagePreviewPlugin.access$onShareImage(this.a, r3);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final void e(int r4) {
            e r0 = SheetImagePreviewPlugin.access$getShareOperationViewMessageHandler$p(this.a);
            if (r0 == null) goto L8;
            tt5.a.h(SheetImagePreviewPlugin.TAG, "notifySharePanelHeightChanged: height = " + r4);
            JSONObject r1 = new JSONObject();
            r1.put("viewHeight", Integer.valueOf(r4));
            tb5.m r5 = r0.a;
            if (r5 == null) goto L9;
            r5.b(r1);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final void d(ShareType r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "shareType");
            Intrinsics.checkNotNullParameter(r4, "text");
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Share text to external app. shareType: " + r3.name());
            SheetImagePreviewPlugin.access$onShareText(this.a, r3, r4);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.preview.ImagePreviewViewModel.a
        public final boolean f(ShareItemModel r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "shareItem");
            Intrinsics.checkNotNullParameter(r5, "text");
            tt5.a.h(SheetImagePreviewPlugin.TAG, "Custom share item clicked. itemId: " + r3.getItemId() + ", isShareText: " + r4);
            if (r4 == true) goto L7;
            SheetImagePreviewPlugin.access$onCustomShareImage(this.a, r3);
            return true;
        L7:
            return SheetImagePreviewPlugin.access$onCustomShareText(this.a, r3, r5);
        }
    }

    public static final class r implements ShareImageDataPlugin.b {
        public final /* synthetic */ SheetImagePreviewPlugin a;
        public final /* synthetic */ ShareImageDataPlugin b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ShareItemModel d;

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onCancel() {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onCustomShareImage: GetImageData canceled.");
            SheetImagePreviewPlugin.access$getSheetAnalytic$p(this.a).f("stopTransfer");
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void a(VFSFile r5) {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onCustomShareImage: GetImageData succeed.");
            boolean r2 = false;
            if (this.c == false) goto L13;
            ImagePreviewViewModel r1 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r1 == null) goto L9;
            MutableLiveData<Boolean> r3 = r1.getActive();
            if (r3 == null) goto L9;
            boolean r4 = Intrinsics.areEqual(r3.getValue(), Boolean.TRUE);
        L10:
            if (r4 == false) goto L13;
            SheetImagePreviewPlugin.access$cancelListener(this.a, this.b);
        L14:
            ImagePreviewViewModel r6 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r6 == null) goto L19;
            MutableLiveData<Boolean> r7 = r6.getActive();
            if (r7 == null) goto L19;
            r2 = Intrinsics.areEqual(r7.getValue(), Boolean.TRUE);
        L19:
            if (r2 == true) goto L22;
            tt5.a.k(SheetImagePreviewPlugin.TAG, "onCustomShareImage, export image onSuccess but not active.");
            return;
        L22:
            SheetImagePreviewPlugin.access$setImageFile$p(this.a, r5);
            SheetImagePreviewPlugin.access$setWatermarkedImageFile$p(this.a, null);
            SheetImagePreviewPlugin.access$reportExportImageSuccess(this.a);
            SheetImagePreviewPlugin.access$notifyCustomShareImage(this.a, this.d, this.c);
            return;
        L9:
            r4 = false;
        L13:
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
            goto L14
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onFail(String r3) {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onCustomShareImage, GetImageData failed. code: -1, errorInfo: " + r3);
            SheetImagePreviewPlugin.access$getSheetAnalytic$p(this.a).f(r3);
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
        }

        public r(SheetImagePreviewPlugin r1, ShareImageDataPlugin r2, boolean r3, ShareItemModel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class s implements ShareImageDataPlugin.b {
        public final /* synthetic */ SheetImagePreviewPlugin a;
        public final /* synthetic */ ShareImageDataPlugin b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ShareType d;

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onCancel() {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onShareImage: GetImageData canceled.");
            SheetImagePreviewPlugin.access$getSheetAnalytic$p(this.a).f("stopTransfer");
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void a(VFSFile r4) {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onShareImage: GetImageData succeed.");
            boolean r1 = false;
            if (this.c == false) goto L13;
            ImagePreviewViewModel r0 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L9;
            MutableLiveData<Boolean> r2 = r0.getActive();
            if (r2 == null) goto L9;
            boolean r3 = Intrinsics.areEqual(r2.getValue(), Boolean.TRUE);
        L10:
            if (r3 == false) goto L13;
            SheetImagePreviewPlugin.access$cancelListener(this.a, this.b);
        L14:
            ImagePreviewViewModel r5 = SheetImagePreviewPlugin.access$getViewModel$p(this.a);
            if (r5 == null) goto L19;
            MutableLiveData<Boolean> r6 = r5.getActive();
            if (r6 == null) goto L19;
            r1 = Intrinsics.areEqual(r6.getValue(), Boolean.TRUE);
        L19:
            if (r1 == true) goto L21;
            return;
        L21:
            SheetImagePreviewPlugin.access$setImageFile$p(this.a, r4);
            SheetImagePreviewPlugin.access$setWatermarkedImageFile$p(this.a, null);
            SheetImagePreviewPlugin.access$reportExportImageSuccess(this.a);
            SheetImagePreviewPlugin.access$shareImageInner(this.a, this.d);
            return;
        L9:
            r3 = false;
        L13:
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
            goto L14
        }

        @Override // com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin.b
        public final void onFail(String r3) {
            tt5.a.h(SheetImagePreviewPlugin.TAG, "onShareImage: GetImageData failed. code: -1, errorInfo: " + r3);
            SheetImagePreviewPlugin.access$getSheetAnalytic$p(this.a).f(r3);
            SheetImagePreviewPlugin.access$cancelToastAndListener(this.a, this.b);
        }

        public s(SheetImagePreviewPlugin r1, ShareImageDataPlugin r2, boolean r3, ShareType r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class t implements rm5.o.b {
        public final /* synthetic */ SheetImagePreviewPlugin a;
        public final /* synthetic */ ShareType b;

        @Override // rm5.o.b
        public final void onSuccess() {
            qm5.a r0 = SheetImagePreviewPlugin.access$getSheetAnalytic$p(this.a);
            g r1 = SheetImagePreviewPlugin.access$getShowShareOperationListHandler$p(this.a);
            if (r1 == null) goto L6;
            String r2 = r1.b;
            if (r2 == null) goto L6;
        L7:
            String r3 = rm5.o.a(this.b);
            r0.getClass();
            HashMap r4 = new HashMap();
            r4.put("mode", r2);
            r4.put("fab_type", null);
            r4.put("op_item", r3);
            r0.c("share_card_text_success", r4);
            return;
        L6:
            r2 = "";
            goto L7
        }

        @Override // rm5.o.b
        public final void onFail(String r3) {
            Context r0 = SheetImagePreviewPlugin.access$getContext(this.a);
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            Toast.showFailureTextWithMargin(r0, r3, 0);
        }

        public t(SheetImagePreviewPlugin r1, ShareType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class u implements Action {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
        }

        public final void run() {
            Toast.cancelLoading();
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ ShareType a;
        public final /* synthetic */ SheetImagePreviewPlugin b;

        public v(ShareType r1, SheetImagePreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            File r6 = (File) r5;
            ShareType r0 = this.a;
            if (r0 != ShareType.Download) goto L5;
            rm5.o.b(SheetImagePreviewPlugin.access$getContext(this.b), r6, new com.bytedance.ee.bear.sheet.exportimage.preview.k(this.b, this.a));
            return;
        L5:
            SheetImagePreviewPlugin.access$reportShareExportImageSuccess(this.b, r0);
            rm5.o.c(SheetImagePreviewPlugin.access$getContext(this.b), this.a, r6);
        }
    }

    public static final class w<T> implements Consumer {
        public static final w<T> a = null;

        static {
            a = new w();
        }

        public w() {
        }

        public final void accept(Object r3) {
            tt5.a.d(SheetImagePreviewPlugin.TAG, "shareImageInner: error: " + ((Throwable) r3));
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
        ImagePreviewViewModel r0 = this.viewModel;
        if (r0 == null) goto L12;
        MutableLiveData<PreviewTitleModel> r1 = r0.getTitleData();
        if (r1 == null) goto L12;
        PreviewTitleModel r2 = (PreviewTitleModel) r1.getValue();
        if (r2 == null) goto L12;
        PreviewTitleModel.Item r3 = r2.getTitleItem();
        if (r3 == null) goto L12;
        String r4 = r3.text;
        if (r4 == null) goto L12;
    L17:
        return ShareItemUtil.b(getContext(), r4, 3);
    L12:
        CharSequence r5 = (CharSequence) getDocViewModel().getTitle().getValue();
        if (r5 == null) goto L15;
        r4 = r5.toString();
        goto L17
    L15:
        r4 = "";
        goto L17
    }

    private final void reportExportImageSuccess() {
        qm5.a r0 = this.sheetAnalytic;
        g r1 = this.showShareOperationListHandler;
        if (r1 == null) goto L6;
        String r2 = r1.b;
        if (r2 == null) goto L6;
    L7:
        r0.getClass();
        HashMap r3 = new HashMap();
        r3.put("source", r2);
        r0.c("export_image_success", r3);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public SheetImagePreviewPlugin() {
        this.sheetAnalytic = new qm5.a();
    }

    private final String getCurrentShareUrl() {
        BearUrl r0 = getDocViewModel().getBearUrl();
        if (r0 == null) goto L5;
        String r1 = r0.e;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ Context access$getContext(SheetImagePreviewPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ String access$getCurrentShareTitle(SheetImagePreviewPlugin r0) {
        return r0.getCurrentShareTitle();
    }

    public static final /* synthetic */ String access$getCurrentShareUrl(SheetImagePreviewPlugin r0) {
        return r0.getCurrentShareUrl();
    }

    public static final /* synthetic */ e access$getShareOperationViewMessageHandler$p(SheetImagePreviewPlugin r0) {
        return r0.shareOperationViewMessageHandler;
    }

    public static final /* synthetic */ qm5.a access$getSheetAnalytic$p(SheetImagePreviewPlugin r0) {
        return r0.sheetAnalytic;
    }

    public static final /* synthetic */ g access$getShowShareOperationListHandler$p(SheetImagePreviewPlugin r0) {
        return r0.showShareOperationListHandler;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(SheetImagePreviewPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ wo5.b access$getUserComponentAbility$p(SheetImagePreviewPlugin r0) {
        return r0.userComponentAbility;
    }

    public static final /* synthetic */ ImagePreviewViewModel access$getViewModel$p(SheetImagePreviewPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ File access$getWatermarkedImageFile$p(SheetImagePreviewPlugin r0) {
        return r0.watermarkedImageFile;
    }

    public static final /* synthetic */ void access$removeFragment(SheetImagePreviewPlugin r0) {
        r0.removeFragment();
    }

    public static final /* synthetic */ void access$reportExportImageSuccess(SheetImagePreviewPlugin r0) {
        r0.reportExportImageSuccess();
    }

    private final boolean canCustomShareImage(ShareItemModel r1) {
        ShareType r2 = r1.getType();
        if (r2 != null) goto L6;
        r2 = ShareType.More;
    L6:
        return canPassCipherImageGuard(r2);
    }

    private final boolean canPassCipherImageGuard(ShareType r4) {
        if (CipherManager.d() != 1) goto L13;
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r4 != ShareType.Download) goto L9;
        int r5 = 2131887290;
    L10:
        Toast.showText(r0, r0.getString(r5), 1);
        CipherManager.h();
        return false;
    L9:
        r5 = 2131887299;
        goto L10
    L13:
        return true;
    }

    private final boolean canShareImage(ShareType r1) {
        return canPassCipherImageGuard(r1);
    }

    private final void cancelListener(ShareImageDataPlugin r3) {
        ImagePreviewViewModel r0 = this.viewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getDisableShareItem();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.FALSE);
    L7:
        r3.setExportImageResultListener(null);
    }

    private final void cancelToastAndListener(ShareImageDataPlugin r1) {
        Toast.cancelLoading();
        cancelListener(r1);
    }

    private final Single<File> getWatermarkedImage(File r4) {
        if (r4 == null) goto L4;
        VFSPath r0 = ay4.d.a().z(r4.getAbsolutePath());
        tt5.a.h(TAG, "[watermark remaining] originalFile=" + r4.getAbsolutePath());
        Lazy r5 = CCMWatermarkManager.a;
        String r6 = r0.getRealPath();
        Intrinsics.checkNotNullParameter(r6, "filePath");
        return ((zo5.b) CCMWatermarkManager.a.getValue()).e(r6).map(m.a);
    L4:
        return Single.error(new Throwable("[watermark remaining] getWatermarkedImage, originalFile is null"));
    }

    private final void onCustomShareImage(ShareItemModel r6) {
        boolean r0 = wo5.d.a(this.userComponentAbility, "admin.watermark.filewatermark.remaining");
        if (this.imageFile == null) goto L6;
        notifyCustomShareImage(r6, r0);
        return;
    L6:
        g r1 = this.showShareOperationListHandler;
        if (r1 == null) goto L11;
        JSONObject r2 = new JSONObject();
        r2.put(ResourceData.KEY_ID, "load");
        tb5.m r3 = r1.a;
        if (r3 == null) goto L11;
        r3.b(r2);
    L11:
        ImagePreviewViewModel r4 = this.viewModel;
        if (r4 == null) goto L16;
        MutableLiveData<Boolean> r5 = r4.getDisableShareItem();
        if (r5 == null) goto L16;
        r5.setValue(Boolean.TRUE);
    L16:
        Toast.showLoading(getContext(), getContext().getText(2131888211));
        ShareImageDataPlugin r7 = findPlugin(ShareImageDataPlugin.class);
        if (r7 != null) goto L24;
        Toast.cancelLoading();
        ImagePreviewViewModel r8 = this.viewModel;
        if (r8 == null) goto L26;
        MutableLiveData<Boolean> r9 = r8.getDisableShareItem();
        if (r9 == null) goto L27;
        r9.setValue(Boolean.FALSE);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        r7.setExportImageResultListener(new r(this, r7, r0, r6));
    }

    private final void onShareImage(ShareType r7) {
        reportClickShareExportImage(r7);
        boolean r0 = wo5.d.a(this.userComponentAbility, "admin.watermark.filewatermark.remaining");
        tt5.a.h(TAG, "onShareImage: isWatermarkRemainingEnable: " + r0);
        if (this.imageFile == null) goto L10;
        if (r0 == true) goto L6;
    L8:
        shareImageInner(r7);
        return;
    L6:
        if (this.watermarkedImageFile != null) goto L8;
        Toast.showLoading(getContext(), getContext().getText(2131888211));
        tt5.a.k(TAG, "onShareImage: watermark remaining enable but watermarked image file is null");
        goto L8
    L10:
        g r1 = this.showShareOperationListHandler;
        if (r1 == null) goto L15;
        JSONObject r2 = new JSONObject();
        r2.put(ResourceData.KEY_ID, "load");
        tb5.m r3 = r1.a;
        if (r3 == null) goto L15;
        r3.b(r2);
    L15:
        ImagePreviewViewModel r4 = this.viewModel;
        if (r4 == null) goto L21;
        MutableLiveData<Boolean> r5 = r4.getDisableShareItem();
        if (r5 == null) goto L21;
        r5.setValue(Boolean.TRUE);
    L21:
        if (r7 != ShareType.Download) goto L24;
        if (r0 == true) goto L24;
        Toast.showLoading(getContext(), getContext().getText(2131888130));
    L25:
        ShareImageDataPlugin r6 = findPlugin(ShareImageDataPlugin.class);
        if (r6 == null) goto L29;
        r6.setExportImageResultListener(new s(this, r6, r0, r7));
        return;
    L29:
        return;
    L24:
        Toast.showLoading(getContext(), getContext().getText(2131888211));
        goto L25
    }

    private final void reportClickShareExportImage(ShareType r8) {
        g r0 = this.showShareOperationListHandler;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        String r2 = "";
        if (r1 == true) goto L16;
        qm5.a r3 = this.sheetAnalytic;
        g r4 = this.showShareOperationListHandler;
        if (r4 == null) goto L37;
        String r5 = r4.b;
        if (r5 == null) goto L37;
        r2 = r5;
    L37:
        r3.e(r2, rm5.o.a(r8));
        return;
    L16:
        if (r8 != ShareType.Download) goto L24;
        qm5.a r6 = this.sheetAnalytic;
        g r7 = this.showShareOperationListHandler;
        if (r7 == null) goto L23;
        String r9 = r7.b;
        if (r9 == null) goto L23;
        r2 = r9;
    L23:
        String r10 = rm5.o.a(r8);
        r6.getClass();
        HashMap r11 = new HashMap();
        r11.put("mode", r2);
        r11.put("fab_type", null);
        r11.put("op_item", r10);
        r6.c("click_download_card_img", r11);
        return;
    L24:
        qm5.a r12 = this.sheetAnalytic;
        g r13 = this.showShareOperationListHandler;
        if (r13 == null) goto L30;
        String r14 = r13.b;
        if (r14 == null) goto L30;
        r2 = r14;
    L30:
        String r15 = rm5.o.a(r8);
        r12.getClass();
        HashMap r16 = new HashMap();
        r16.put("mode", r2);
        r16.put("fab_type", null);
        r16.put("op_item", r15);
        r12.c("click_share_card_img", r16);
        return;
    L5:
        if (TextUtils.equals(r0.b, SOURCE_CARDVIEW) == false) goto L7;
    L10:
        boolean r17 = true;
    L11:
        if (r17 != true) goto L13;
        r1 = true;
        goto L13
    L7:
        if (TextUtils.equals(r0.b, SOURCE_CARDVIEW_PANEL) == true) goto L10;
        r17 = false;
        goto L11
    }

    private final void reportShareExportImageSuccess(ShareType r8) {
        g r0 = this.showShareOperationListHandler;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        String r2 = "";
        if (r1 == true) goto L16;
        qm5.a r3 = this.sheetAnalytic;
        g r4 = this.showShareOperationListHandler;
        if (r4 == null) goto L37;
        String r5 = r4.b;
        if (r5 == null) goto L37;
        r2 = r5;
    L37:
        String r9 = rm5.o.a(r8);
        r3.getClass();
        HashMap r6 = new HashMap();
        r6.put("source", r2);
        r6.put("op_item", r9);
        r3.c("share_export_image_success", r6);
        return;
    L16:
        if (r8 != ShareType.Download) goto L24;
        qm5.a r7 = this.sheetAnalytic;
        g r10 = this.showShareOperationListHandler;
        if (r10 == null) goto L23;
        String r11 = r10.b;
        if (r11 == null) goto L23;
        r2 = r11;
    L23:
        String r12 = rm5.o.a(r8);
        r7.getClass();
        HashMap r13 = new HashMap();
        r13.put("mode", r2);
        r13.put("fab_type", null);
        r13.put("op_item", r12);
        r7.c("download_card_img_success", r13);
        return;
    L24:
        qm5.a r14 = this.sheetAnalytic;
        g r15 = this.showShareOperationListHandler;
        if (r15 == null) goto L30;
        String r16 = r15.b;
        if (r16 == null) goto L30;
        r2 = r16;
    L30:
        String r17 = rm5.o.a(r8);
        r14.getClass();
        HashMap r18 = new HashMap();
        r18.put("mode", r2);
        r18.put("fab_type", null);
        r18.put("op_item", r17);
        r14.c("share_card_img_success", r18);
        return;
    L5:
        if (TextUtils.equals(r0.b, SOURCE_CARDVIEW) == false) goto L7;
    L10:
        boolean r19 = true;
    L11:
        if (r19 != true) goto L13;
        r1 = true;
        goto L13
    L7:
        if (TextUtils.equals(r0.b, SOURCE_CARDVIEW_PANEL) == true) goto L10;
        r19 = false;
        goto L11
    }

    private final void shareImageInner(ShareType r3) {
        boolean r0 = wo5.d.a(this.userComponentAbility, "admin.watermark.filewatermark.remaining");
        getImageFileForShare(this.imageFile, r3, r0).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(u.a).subscribe(new v(r3, this), w.a);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        this.showShareOperationListHandler = new g(this);
        this.shareOperationViewMessageHandler = new e(this);
        r3.put(BIZ_SHEET_SHOW_LOADING, new f(this));
        r3.put(BIZ_SHEET_HIDE_LOADING, new b(this));
        r3.put(BIZ_NAVIGATION_SHOW_TITLE, new h(this));
        r3.put(BIZ_NAVIGATION_HIDE_TITLE, new d(this));
        g r0 = this.showShareOperationListHandler;
        Intrinsics.checkNotNull(r0);
        r3.put(BIZ_UTIL_SHOW_SHARE_OPERATION_LIST, r0);
        r3.put(BIZ_UTIL_HIDE_SHARE_OPERATION_LIST, new c(this));
        e r1 = this.shareOperationViewMessageHandler;
        Intrinsics.checkNotNull(r1);
        r3.put(BIZ_SHEET_SHARE_OPERATION_VIEW_MESSAGE, r1);
        r3.put(BIZ_SHEET_GET_WATERMARK_INFO, new i(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.viewModel = (ImagePreviewViewModel) viewModel(ImagePreviewViewModel.class);
        if (r3 == null) goto L5;
        this.userComponentAbility = new wo5.b(r3.getUserComponent());
    L5:
        ImagePreviewViewModel r4 = this.viewModel;
        if (r4 == null) goto L8;
        r4.setDelegate(new q(this));
    L8:
        ImagePreviewViewModel r5 = this.viewModel;
        if (r5 == null) goto L13;
        MutableLiveData<Boolean> r6 = r5.getActive();
        if (r6 == null) goto L13;
        r6.observe(getLifecycleOwner(), new AnonymousClass3(this));
    L13:
        qm5.a r7 = this.sheetAnalytic;
        r7.a = getDocViewModel().getBearUrl();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ boolean access$canCustomShareImage(SheetImagePreviewPlugin r0, ShareItemModel r1) {
        return r0.canCustomShareImage(r1);
    }

    public static final /* synthetic */ boolean access$canShareImage(SheetImagePreviewPlugin r0, ShareType r1) {
        return r0.canShareImage(r1);
    }

    public static final /* synthetic */ void access$cancelListener(SheetImagePreviewPlugin r0, ShareImageDataPlugin r1) {
        r0.cancelListener(r1);
    }

    public static final /* synthetic */ void access$cancelToastAndListener(SheetImagePreviewPlugin r0, ShareImageDataPlugin r1) {
        r0.cancelToastAndListener(r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(SheetImagePreviewPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(SheetImagePreviewPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$onCustomShareImage(SheetImagePreviewPlugin r0, ShareItemModel r1) {
        r0.onCustomShareImage(r1);
    }

    public static final /* synthetic */ void access$onShareImage(SheetImagePreviewPlugin r0, ShareType r1) {
        r0.onShareImage(r1);
    }

    public static final /* synthetic */ void access$reportShareExportImageSuccess(SheetImagePreviewPlugin r0, ShareType r1) {
        r0.reportShareExportImageSuccess(r1);
    }

    public static final /* synthetic */ void access$setImageFile$p(SheetImagePreviewPlugin r0, File r1) {
        r0.imageFile = r1;
    }

    public static final /* synthetic */ void access$setWatermarkedImageFile$p(SheetImagePreviewPlugin r0, File r1) {
        r0.watermarkedImageFile = r1;
    }

    public static final /* synthetic */ void access$shareImageInner(SheetImagePreviewPlugin r0, ShareType r1) {
        r0.shareImageInner(r1);
    }

    private final void notifyCustomShareImage(ShareItemModel r3, boolean r4) {
        File r0 = this.imageFile;
        ShareType r1 = r3.getType();
        if (r1 != null) goto L5;
        r1 = ShareType.More;
    L5:
        getImageFileForShare(r0, r1, r4).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(n.a).subscribe(new o(r3, this), new p(r3, this));
    }

    private final boolean onCustomShareText(ShareItemModel r7, String r8) {
        g r0 = this.showShareOperationListHandler;
        if (r0 == null) goto L7;
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_ID, "text");
        tt5.a.h(TAG, "onShareText");
        tb5.m r2 = r0.a;
        if (r2 == null) goto L7;
        r2.b(r1);
    L7:
        ShareItemModel.a r3 = r7.getOnClickedListener();
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.a(getContext(), r7, new com.bytedance.ee.bear.share.g(getCurrentShareUrl(), getCurrentShareTitle(), r8, null));
    }

    private final void onShareText(final ShareType r10, final String r11) {
        g r0 = this.showShareOperationListHandler;
        if (r0 == null) goto L7;
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_ID, "text");
        tt5.a.h(TAG, "onShareText");
        tb5.m r2 = r0.a;
        if (r2 == null) goto L7;
        r2.b(r1);
    L7:
        String r5 = "";
        if (r10 != ShareType.CopyText) goto L25;
        qm5.a r3 = this.sheetAnalytic;
        g r6 = this.showShareOperationListHandler;
        if (r6 == null) goto L13;
        String r7 = r6.b;
        if (r7 == null) goto L13;
    L14:
        String r8 = rm5.o.a(r10);
        r3.getClass();
        HashMap r9 = new HashMap();
        r9.put("mode", r7);
        r9.put("fab_type", null);
        r9.put("op_item", r8);
        r3.c("click_copy_card_text", r9);
        ClipData r12 = ClipData.newPlainText(null, r11);
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).h(r12, new Token("LARK-PSDA-ccm_android_sheet_card_mode_copy_text")) == false) goto L23;
        qm5.a r13 = this.sheetAnalytic;
        g r14 = this.showShareOperationListHandler;
        if (r14 == null) goto L22;
        String r15 = r14.b;
        if (r15 == null) goto L22;
        r5 = r15;
    L22:
        String r16 = rm5.o.a(r10);
        r13.getClass();
        HashMap r17 = new HashMap();
        r17.put("mode", r5);
        r17.put("fab_type", null);
        r17.put("op_item", r16);
        r13.c("copy_card_text_success", r17);
        Toast.showSuccessTextWithMargin(getContext(), getContext().getResources().getText(2131887614), 0);
        return;
    L23:
        Toast.showFailureTextWithMargin(getContext(), getContext().getResources().getText(2131887613), 0);
        return;
    L13:
        r7 = "";
        goto L14
    L25:
        if (r10 != ShareType.WechatMoments) goto L27;
        com.bytedance.ee.bear.share.e r18 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9();
        Context r19 = getContext();
        r18.getClass();
        km5.c.f(r19);
        return;
    L27:
        qm5.a r4 = this.sheetAnalytic;
        g r20 = this.showShareOperationListHandler;
        if (r20 == null) goto L31;
        String r21 = r20.b;
        if (r21 == null) goto L31;
    L32:
        String r22 = rm5.o.a(r10);
        r4.getClass();
        HashMap r23 = new HashMap();
        r23.put("mode", r21);
        r23.put("fab_type", null);
        r23.put("op_item", r22);
        r4.c("click_share_card_text", r23);
        Context r24 = getContext();
        final t r25 = new t(this, r10);
        if (r10.equals(ShareType.Lark) == false) goto L35;
        Flowable.just("").subscribeOn(fo5.d.b()).map(new rm5.h()).map(new rm5.i(r11)).subscribe(new rm5.j(r25, r10), new rm5.k(r25, r10));
        return;
    L35:
        ExternalShareMinaConfig r26 = com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig());
        rm5.n r27 = new rm5.n(r25, r10);
        if (r10.equals(ShareType.More) == false) goto L39;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().c(r24, r11, r27);
        return;
    L39:
        if (r26.isShareChannelBanned(r10) == false) goto L41;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        km5.c.j(r24, r10, r11, r27);
        return;
    L41:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        km5.c.i(r24, r10, r11, r27);
        return;
    L31:
        r21 = "";
        goto L32
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        ImagePreviewViewModel r3 = this.viewModel;
        if (r3 == null) goto L8;
        MutableLiveData<Boolean> r4 = r3.getActive();
        if (r4 == null) goto L9;
        r4.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$execJS(SheetImagePreviewPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }

    public static final /* synthetic */ void access$notifyCustomShareImage(SheetImagePreviewPlugin r0, ShareItemModel r1, boolean r2) {
        r0.notifyCustomShareImage(r1, r2);
    }

    public static final /* synthetic */ boolean access$onCustomShareText(SheetImagePreviewPlugin r0, ShareItemModel r1, String r2) {
        return r0.onCustomShareText(r1, r2);
    }

    public static final /* synthetic */ void access$onShareText(SheetImagePreviewPlugin r0, ShareType r1, String r2) {
        r0.onShareText(r1, r2);
    }

    private final Single<File> getImageFileForShare(File r4, ShareType r5, boolean r6) {
        String r0 = null;
        if (r6 == true) goto L5;
    L17:
        StringBuilder r7 = new StringBuilder("[watermark remaining] skip, shareType=");
        r7.append(r5);
        r7.append(", file=");
        if (r4 == null) goto L20;
        r0 = r4.getAbsolutePath();
    L20:
        r7.append(r0);
        tt5.a.h(TAG, r7.toString());
        Single<File> r8 = Single.just(Boolean.TRUE).map(new j(r4));
        Intrinsics.checkNotNull(r8);
        return r8;
    L5:
        if (r5 == ShareType.Lark) goto L17;
        if (this.watermarkedImageFile == null) goto L13;
        StringBuilder r9 = new StringBuilder("[watermark remaining] reuse cached file=");
        File r10 = this.watermarkedImageFile;
        if (r10 == null) goto L12;
        r0 = r10.getAbsolutePath();
    L12:
        r9.append(r0);
        tt5.a.h(TAG, r9.toString());
        Single<File> r11 = Single.just(Boolean.TRUE).map(new k(this));
        Intrinsics.checkNotNull(r11);
        return r11;
    L13:
        StringBuilder r12 = new StringBuilder("[watermark remaining] apply new watermark, file=");
        if (r4 == null) goto L16;
        r0 = r4.getAbsolutePath();
    L16:
        r12.append(r0);
        tt5.a.h(TAG, r12.toString());
        Single<File> r13 = getWatermarkedImage(r4).doOnSuccess(new l(this));
        Intrinsics.checkNotNull(r13);
        return r13;
    }
}
