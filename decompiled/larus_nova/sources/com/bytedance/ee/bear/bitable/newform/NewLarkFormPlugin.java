package com.bytedance.ee.bear.bitable.newform;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.view.cell.select.t;
import com.bytedance.ee.bear.bitable.core.basemain.ability.BaseMainOverlayType;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.bytedance.ee.bear.bitable.newform.notification.ContactChooseFragment;
import com.bytedance.ee.bear.bitable.newform.notification.PreSelectItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\f+,-./0123456B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0012\u0010#\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010$\u001a\u00020\u001a2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0&H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "<init>", "()V", "keyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "openFullScreenHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$OpenFullScreenHandler;", "closeFullScreenHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$CloseFullScreenHandler;", "colorPanelHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelHandler;", "ratingPanelHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$RatingPanelHanlder;", "formBridgeConfiguration", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$FormConfigurationHandler;", "safeAreaHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$SafeAreaHandler;", "chooseContactHandler", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ChooseContactHandler;", "isFixMenuHideDisable", "", "isViewImmersive", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onKeyboardHeightChanged", "khp", "keyboardHeight", "", "orientation", "shouldDisableLandscape", "onDetachFromHost", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "updateContentKeyboardInset", "getSafeAreaTop", "Companion", "OpenFullScreenHandler", "CloseFullScreenHandler", "ColorPanelHandler", "RatingPanelHanlder", "FormConfigurationHandler", "SafeAreaHandler", "ChooseContactHandler", "ColorPanelRequest", "ColorPanelItem", "RatingPanelRequest", "FormsContacts", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewLarkFormPlugin extends DocumentPlugin implements p, ocb.a {
    public static final String CHOOSE_CONTACT = "biz.forms.chooseContact";
    public static final String COLOR_PANEL = "biz.bitable.colorPanel";
    public static final d Companion = null;
    public static final String FORM_BRIDGE_CONFIGURATION = "biz.bitable.formConfiguration";
    public static final String FULL_SCREEN_CLOSE = "biz.util.closeFullScreen";
    public static final String FULL_SCREEN_OPEN = "biz.util.openFullScreen";
    public static final String RATING_PANEL = "biz.bitable.ratingPanel";
    public static final String SAFE_AREA = "biz.bitable.safeArea";
    public static final String TAG = "NewLarkForm";
    private final a chooseContactHandler;
    private final b closeFullScreenHandler;
    private final c colorPanelHandler;
    private final e formBridgeConfiguration;
    private final boolean isFixMenuHideDisable;
    private pcb.a keyboardHeightProvider;
    private final f openFullScreenHandler;
    private final g ratingPanelHandler;
    private final h safeAreaHandler;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "color", "", "textColor", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getTextColor", "setTextColor", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ColorPanelItem implements NonProguard {
        private String color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private Integer f214745id;
        private String textColor;

        public final String getColor() {
            return this.color;
        }

        public final Integer getId() {
            return this.f214745id;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final void setColor(String r100) {
            this.color = r100;
        }

        public final void setId(Integer r100) {
            this.f214745id = r100;
        }

        public final void setTextColor(String r100) {
            this.textColor = r100;
        }

        public ColorPanelItem(Integer r100, String r101, String r102) {
            this.f214745id = r100;
            this.color = r101;
            this.textColor = r102;
        }

        public /* synthetic */ ColorPanelItem(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "optionID", "", "colors", "", "Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;", "selectedColor", SendEventContainerMethodParamModel.EventKinds.onClick, "<init>", "(Ljava/lang/String;[Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;Ljava/lang/String;)V", "getOptionID", "()Ljava/lang/String;", "getColors", "()[Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;", "[Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;", "getSelectedColor", "()Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$ColorPanelItem;", "getOnClick", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ColorPanelRequest implements NonProguard {
        private final ColorPanelItem[] colors;
        private final String onClick;
        private final String optionID;
        private final ColorPanelItem selectedColor;

        public final ColorPanelItem[] getColors() {
            return this.colors;
        }

        public final String getOnClick() {
            return this.onClick;
        }

        public final String getOptionID() {
            return this.optionID;
        }

        public final ColorPanelItem getSelectedColor() {
            return this.selectedColor;
        }

        public ColorPanelRequest(String r100, ColorPanelItem[] r101, ColorPanelItem r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "optionID");
            Intrinsics.checkNotNullParameter(r101, "colors");
            this.optionID = r100;
            this.colors = r101;
            this.selectedColor = r102;
            this.onClick = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$FormsContacts;", "Lcom/bytedance/ee/util/io/NonProguard;", "preselectItems", "", "Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;", "<init>", "([Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;)V", "getPreselectItems", "()[Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;", "[Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FormsContacts implements NonProguard {
        private final PreSelectItem[] preselectItems;

        /* JADX WARN: Multi-variable type inference failed */
        public FormsContacts() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final PreSelectItem[] getPreselectItems() {
            return this.preselectItems;
        }

        public FormsContacts(PreSelectItem[] r100) {
            this.preselectItems = r100;
        }

        public /* synthetic */ FormsContacts(PreSelectItem[] r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/NewLarkFormPlugin$RatingPanelRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "symbols", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "selectedSymbol", SendEventContainerMethodParamModel.EventKinds.onClick, "", "<init>", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;Ljava/lang/String;)V", "getSymbols", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "getSelectedSymbol", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "getOnClick", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class RatingPanelRequest implements NonProguard {
        private final String onClick;
        private final FieldConfigMetaModel.RatingSymboInfo selectedSymbol;
        private final FieldConfigMetaModel.RatingSymboInfo[] symbols;

        public final String getOnClick() {
            return this.onClick;
        }

        public final FieldConfigMetaModel.RatingSymboInfo getSelectedSymbol() {
            return this.selectedSymbol;
        }

        public final FieldConfigMetaModel.RatingSymboInfo[] getSymbols() {
            return this.symbols;
        }

        public RatingPanelRequest(FieldConfigMetaModel.RatingSymboInfo[] r100, FieldConfigMetaModel.RatingSymboInfo r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "symbols");
            Intrinsics.checkNotNullParameter(r101, "selectedSymbol");
            this.symbols = r100;
            this.selectedSymbol = r101;
            this.onClick = r102;
        }
    }

    public final class a implements i<FormsContacts> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214746a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(NewLarkFormPlugin r100) {
            this.f214746a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            FormsContacts r102 = (FormsContacts) r100;
            if (r102 == null) goto L6;
            PreSelectItem[] r103 = r102.getPreselectItems();
            if (r103 == null) goto L6;
        L7:
            Regex r104 = ContactChooseFragment.f214772k;
            FragmentActivity r105 = NewLarkFormPlugin.access$getActivity(this.f214746a);
            com.bytedance.ee.bear.bitable.newform.c r106 = new com.bytedance.ee.bear.bitable.newform.c(r101);
            Intrinsics.checkNotNullParameter(r105, "activity");
            Intrinsics.checkNotNullParameter(r106, "finishListener");
            String r107 = ContactChooseFragment.class.getName();
            Bundle r108 = new Bundle();
            r108.putParcelableArray("key.init_selected_items", r103);
            Unit r109 = Unit.INSTANCE;
            Fragment r110 = Fragment.instantiate(r105, r107, r108);
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.newform.notification.ContactChooseFragment");
            ContactChooseFragment r111 = (ContactChooseFragment) r110;
            r111.f214774h = r106;
            FragmentManager r112 = r105.getSupportFragmentManager();
            LandscapeRestrictionOperation r113 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, "ContactChooseFragment", r113);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r111, r113) == true) goto L16;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L11:
            r111.show(r112, "ContactChooseFragment");
            return;
        L16:
            return;
        L6:
            r103 = new PreSelectItem[0];
            goto L7
        }
    }

    public final class b implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214747a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(NewLarkFormPlugin r100) {
            this.f214747a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            tt5.a.h("NewLarkForm", "closeFullScreen data:" + ((String) r100));
            DocumentPluginHost r102 = (DocumentPluginHost) this.f214747a.getHost();
            if (r102 == null) goto L7;
            com.bytedance.ee.bear.bitable.core.basemain.ability.b r103 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r102.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
            if (r103 == null) goto L7;
            r103.Qn(BaseMainOverlayType.FORM, false);
        L7:
            BaseUnspecifiedOrientationPlugin r104 = (BaseUnspecifiedOrientationPlugin) NewLarkFormPlugin.access$findPlugin(this.f214747a, BaseUnspecifiedOrientationPlugin.class);
            if (r104 == null) goto L10;
            r104.onOrientationSupportPanelDismiss(this.f214747a);
        L10:
            pcb.a r105 = NewLarkFormPlugin.access$getKeyboardHeightProvider$p(this.f214747a);
            if (r105 == null) goto L13;
            r105.a(this.f214747a);
        L13:
            NewLarkFormPlugin.access$updateContentKeyboardInset(this.f214747a, 0);
        }
    }

    public final class c implements i<ColorPanelRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214748a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(NewLarkFormPlugin r100) {
            this.f214748a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r110) {
            ColorPanelRequest r101 = (ColorPanelRequest) r100;
            if (r101 == null) goto L15;
            if (r110 == null) goto L15;
            Context r102 = NewLarkFormPlugin.access$getContext(this.f214748a);
            ColorPanelItem[] r103 = r101.getColors();
            ArrayList r104 = new ArrayList(r103.length);
            int r105 = r103.length;
            int r106 = 0;
            int r107 = 0;
        L7:
            if (r107 >= r105) goto L9;
            ColorPanelItem r108 = r103[r107];
            NewLarkFormPlugin.Companion.getClass();
            r104.add(d.a(r108));
            r107 = r107 + 1;
            goto L7
        L9:
            ColorBean[] r109 = (ColorBean[]) r104.toArray(new ColorBean[0]);
            ColorPanelItem r111 = r101.getSelectedColor();
            if (r111 == null) goto L14;
            Integer r112 = r111.getId();
            if (r112 == null) goto L14;
            r106 = r112.intValue();
        L14:
            t r113 = new t(r102, r109, r106);
            r113.C();
            r113.B();
            com.bytedance.ee.bear.bitable.newform.d r114 = new com.bytedance.ee.bear.bitable.newform.d(r110, r101);
            Intrinsics.checkNotNullParameter(r114, "listener");
            r113.f208177o = r114;
            r113.show();
            return;
        L15:
            tt5.a.d("NewLarkForm", "colorPanel failed data=" + r101 + " callback=" + r110);
        }
    }

    public static final class d {
        public d() {
        }

        public static ColorBean a(ColorPanelItem r100) {
            Intrinsics.checkNotNullParameter(r100, "color");
            ColorBean r101 = new ColorBean();
            Integer r102 = r100.getId();
            if (r102 == null) goto L5;
            String r103 = r102.toString();
        L6:
            r101.setId(r103);
            r101.setColor(r100.getColor());
            r101.setTextColor(r100.getTextColor());
            return r101;
        L5:
            r103 = null;
            goto L6
        }
    }

    public final class e implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            SettingsBitableConfig r103 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
            if (r101 == null) goto L11;
            JSONObject r104 = new JSONObject();
            r104.put2("callbackType", "success");
            if (r103 == null) goto L9;
            Map<String, Boolean> r105 = r103.a();
            if (r105 == null) goto L9;
            r104.put2("data", r105);
        L9:
            r101.b(r104);
            return;
        }
    }

    public final class f implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214749a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(NewLarkFormPlugin r100) {
            this.f214749a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            tt5.a.h("NewLarkForm", "openFullScreen data:" + ((String) r100));
            DocumentPluginHost r102 = (DocumentPluginHost) this.f214749a.getHost();
            if (r102 == null) goto L7;
            com.bytedance.ee.bear.bitable.core.basemain.ability.b r103 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r102.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
            if (r103 == null) goto L7;
            r103.Qn(BaseMainOverlayType.FORM, true);
        L7:
            pcb.a r104 = NewLarkFormPlugin.access$getKeyboardHeightProvider$p(this.f214749a);
            if (r104 == null) goto L10;
            r104.c(this.f214749a);
        L10:
            BaseUnspecifiedOrientationPlugin r105 = (BaseUnspecifiedOrientationPlugin) NewLarkFormPlugin.access$findPlugin(this.f214749a, BaseUnspecifiedOrientationPlugin.class);
            if (r105 == null) goto L14;
            r105.onOrientationSupportPanelShowing(this.f214749a);
            return;
        }
    }

    public final class g implements i<RatingPanelRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214750a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(NewLarkFormPlugin r100) {
            this.f214750a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            RatingPanelRequest r102 = (RatingPanelRequest) r100;
            if (r102 == null) goto L7;
            if (r101 == null) goto L7;
            com.bytedance.ee.bear.bitable.fieldedit.view.widgets.d r103 = new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.d(NewLarkFormPlugin.access$getContext(this.f214750a), new com.bytedance.ee.bear.bitable.newform.e(this.f214750a, r102, r101));
            r103.f211772j = r102.getSelectedSymbol().getSymbol();
            r103.b();
            return;
        L7:
            tt5.a.d("NewLarkForm", "openRatingPanel failed data=" + r102 + " callback=" + r101);
        }
    }

    public final class h implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewLarkFormPlugin f214751a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(NewLarkFormPlugin r100) {
            this.f214751a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            tt5.a.h("NewLarkForm", "onReqSafeArea");
            if (r101 == null) goto L6;
            JSONObject r103 = new JSONObject();
            NewLarkFormPlugin r104 = this.f214751a;
            r103.put2("callbackType", "success");
            JSONObject r105 = new JSONObject();
            r105.put2("top", NewLarkFormPlugin.access$getSafeAreaTop(r104) + GXTemplateKey.GAIAX_PX);
            Unit r106 = Unit.INSTANCE;
            r103.put2("data", r105);
            r101.b(r103);
            return;
        }
    }

    static {
        Companion = new d();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public NewLarkFormPlugin() {
        this.openFullScreenHandler = new f(this);
        this.closeFullScreenHandler = new b(this);
        this.colorPanelHandler = new c(this);
        this.ratingPanelHandler = new g(this);
        this.formBridgeConfiguration = new e();
        this.safeAreaHandler = new h(this);
        this.chooseContactHandler = new a(this);
        int r100 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("ccm.base.forms.fix_menu_hide.disable", "key");
        this.isFixMenuHideDisable = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.base.forms.fix_menu_hide.disable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getSafeAreaTop() {
        SettingsBitableConfig r100 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        if (r100 != null) goto L5;
        r100 = new SettingsBitableConfig();
    L5:
        tt5.a.h("NewLarkForm", "getSafeAreaTop settings=" + r100.e());
        int r101 = 0;
        if (r100.e() == true) goto L9;
        return 0;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L42;
        WindowInsets r102 = INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_newform_NewLarkFormPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((DocumentPluginHost) getHost()).getActivity().getWindow()).getRootView().getRootWindowInsets();
        Integer r103 = null;
        if (r102 == null) goto L13;
        DisplayCutout r104 = r102.getDisplayCutout();
    L15:
        if (this.isFixMenuHideDisable == true) goto L23;
        tt5.a.h("NewLarkForm", "getSafeArea top with new method");
        if (r104 != null) goto L19;
        tt5.a.h("NewLarkForm", "getSafeArea top with new method, no displaycutout");
        double r105 = StatusBarUtil.getStatusBarHeight(getContext());
        Context r106 = getContext();
        int r107 = n.f243167a;
        double r108 = Math.ceil(r105 / ((double) n.a(r106.getResources()).density));
    L44:
        return (int) r108;
    L19:
        if (r104.getBoundingRects().size() <= 0) goto L43;
        double r109 = r104.getSafeInsetTop();
        Context r110 = getContext();
        int r111 = n.f243167a;
        r108 = Math.ceil(r109 / ((double) n.a(r110.getResources()).density));
        goto L44
    L43:
        return 0;
    L23:
        if (r104 == null) goto L27;
        List<Rect> r112 = r104.getBoundingRects();
        if (r112 == null) goto L27;
        int r113 = r112.size();
    L28:
        if (r113 <= 0) goto L45;
        if (r104 == null) goto L31;
        r101 = r104.getSafeInsetTop();
    L31:
        double r114 = r101;
        Context r115 = getContext();
        int r116 = n.f243167a;
        int r117 = (int) Math.ceil(r114 / ((double) n.a(r115.getResources()).density));
        StringBuilder r118 = new StringBuilder("cutout true rects=");
        if (r104 == null) goto L36;
        List<Rect> r119 = r104.getBoundingRects();
        if (r119 == null) goto L36;
        Integer r120 = Integer.valueOf(r119.size());
    L37:
        r118.append(r120);
        r118.append(" safeInsetTop=");
        if (r104 == null) goto L40;
        r103 = Integer.valueOf(r104.getSafeInsetTop());
    L40:
        r118.append(r103);
        r118.append(" safeTop=");
        r118.append(r117);
        tt5.a.h("NewLarkForm", r118.toString());
        return r117;
    L36:
        r120 = null;
        goto L37
    L45:
        return 0;
    L27:
        r113 = 0;
        goto L28
    L13:
        r104 = null;
        goto L15
    L42:
        return 0;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_newform_NewLarkFormPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(NewLarkFormPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(NewLarkFormPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ pcb.a access$getKeyboardHeightProvider$p(NewLarkFormPlugin r100) {
        return r100.keyboardHeightProvider;
    }

    public static final /* synthetic */ int access$getSafeAreaTop(NewLarkFormPlugin r100) {
        return r100.getSafeAreaTop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateContentKeyboardInset(int r100) {
        DocumentPluginHost r101 = (DocumentPluginHost) getHost();
        if (r101 == null) goto L8;
        ViewGroup r102 = r101.getContainer(ContainerType.Content.getValue());
        if (r102 == null) goto L9;
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), RangesKt.coerceAtLeast(r100, 0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(FULL_SCREEN_OPEN, this.openFullScreenHandler);
        r100.put(FULL_SCREEN_CLOSE, this.closeFullScreenHandler);
        r100.put(COLOR_PANEL, this.colorPanelHandler);
        r100.put(RATING_PANEL, this.ratingPanelHandler);
        r100.put(FORM_BRIDGE_CONFIGURATION, this.formBridgeConfiguration);
        r100.put(SAFE_AREA, this.safeAreaHandler);
        r100.put(CHOOSE_CONTACT, this.chooseContactHandler);
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.keyboardHeightProvider = pcb.a.AbstractC7181a.b(getActivity());
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        pcb.a r101 = this.keyboardHeightProvider;
        if (r101 == null) goto L5;
        r101.a(this);
    L5:
        updateContentKeyboardInset(0);
        this.keyboardHeightProvider = null;
        super.onDetachFromHost(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(NewLarkFormPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static final /* synthetic */ void access$updateContentKeyboardInset(NewLarkFormPlugin r100, int r101) {
        r100.updateContentKeyboardInset(r101);
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        tt5.a.h("NewLarkForm", "onKeyboardHeightChanged keyboardHeight=" + r101);
        updateContentKeyboardInset(r101);
    }
}
