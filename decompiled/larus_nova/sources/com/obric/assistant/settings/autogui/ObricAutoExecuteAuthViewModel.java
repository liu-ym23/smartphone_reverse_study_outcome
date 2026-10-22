package com.obric.assistant.settings.autogui;

import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018*\u00020\u0019H\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\u001a\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006#"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onAuthorizationCheckedChanged", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/settings/autogui/AuthorizationItem;", "checked", "", "resolvePageConfig", "Lcom/google/gson/JsonObject;", "configJson", "parsePageConfig", "Lcom/obric/assistant/settings/autogui/AuthorizationPageConfig;", "toAuthorizationItems", "", "Lcom/google/gson/JsonArray;", "buildRows", "Lcom/obric/assistant/settings/autogui/AuthorizationRow;", "authorizations", "resolveCardPosition", "", "index", "getStoredValue", "saveStoredValue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoExecuteAuthViewModel extends ViewModel {
    private static final String CLOUD_CONFIG_KEY = "auto_gui_automatic_execution_authorization";
    public static final a Companion = null;
    private static final String LOG_PREFIX = "[AutoExecuteAuth]";
    private static final String TAG = "ObricAutoExecuteAuthVM";
    private static final String TYPE_SWITCH = "switch";
    private final kotlinx.coroutines.flow.z0<h> _uiState;
    private final i1<h> uiState;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final int resolveCardPosition(List<com.obric.assistant.settings.autogui.a> r100, int r101) {
        return 0;
    }

    public final void refresh() {
        JsonObject r100 = t1.f393353a.getObricCloudConfig(CLOUD_CONFIG_KEY);
        FLogger r101 = FLogger.f375446a;
        if (r100 == null) goto L6;
        String r102 = r100.toString();
        if (r102 == null) goto L6;
    L7:
        r101.i(TAG, "[AutoExecuteAuth] refresh, cloudKey=auto_gui_automatic_execution_authorization, rawConfig=".concat(r102));
        b r103 = parsePageConfig(resolvePageConfig(r100));
        List<c> r104 = buildRows(r103.f391896b);
        r101.i(TAG, "[AutoExecuteAuth] refresh, pageName=" + r103.f391895a + ", authorizationCount=" + r103.f391896b.size() + ", rowCount=" + r104.size());
        kotlinx.coroutines.flow.z0<h> r105 = this._uiState;
        String r106 = r103.f391895a;
        if (StringsKt.isBlank(r106) == false) goto L10;
        r106 = FlowRuntime.a().getApplication().getString(R.string.obric_setting_auto_gui_auto_execute_auth);
    L10:
        r105.setValue(new h(r106, r104));
        return;
    L6:
        r102 = "null";
        goto L7
    }

    public ObricAutoExecuteAuthViewModel() {
        StateFlowImpl r100 = j1.a(new h(FlowRuntime.a().getApplication().getString(R.string.obric_setting_auto_gui_auto_execute_auth), CollectionsKt.emptyList()));
        this._uiState = r100;
        this.uiState = kotlinx.coroutines.flow.e.b(r100);
    }

    public final i1<h> getUiState() {
        return this.uiState;
    }

    private final List<c> buildRows(List<com.obric.assistant.settings.autogui.a> r110) {
        if (r110.isEmpty() == true) goto L5;
        ArrayList r100 = new ArrayList();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L13;
        com.obric.assistant.settings.autogui.a r102 = (com.obric.assistant.settings.autogui.a) r111.next();
        String r103 = StringsKt.trim(r102.f391887a).toString();
        Object r104 = r101.get(r103);
        if (r104 != null) goto L12;
        r104 = new ArrayList();
        r101.put(r103, r104);
    L12:
        String r105 = r102.f391888b;
        String r106 = r102.f391889c;
        String r107 = r102.f391890d;
        String r108 = r102.f391891e;
        Intrinsics.checkNotNullParameter(r103, "sectionTitle");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r106, "hint");
        Intrinsics.checkNotNullParameter(r107, "key");
        Intrinsics.checkNotNullParameter(r108, "defaultStatus");
        ((List) r104).add(new com.obric.assistant.settings.autogui.a(r103, r105, r106, r107, r108));
        goto L8
    L13:
        Iterator r112 = r101.entrySet().iterator();
    L15:
        if (r112.hasNext() == false) goto L26;
        Map.Entry r109 = (Map.Entry) r112.next();
        String r113 = (String) r109.getKey();
        List<com.obric.assistant.settings.autogui.a> r114 = (List) r109.getValue();
        if ((!StringsKt.isBlank(r113)) == false) goto L19;
        r100.add(new c.a(r113));
    L19:
        Iterator<T> r115 = r114.iterator();
        int r116 = 0;
    L21:
        if (r115.hasNext() == false) goto L15;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        com.obric.assistant.settings.autogui.a r119 = (com.obric.assistant.settings.autogui.a) r117;
        r100.add(new c.b(r119, getStoredValue(r119), resolveCardPosition(r114, r116)));
        r116 = r118;
        goto L21
    L26:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean getStoredValue(com.obric.assistant.settings.autogui.a r100) {
        String r101 = t1.f393353a.P1(r100.f391890d, r100.f391891e);
        boolean r102 = Intrinsics.areEqual(com.obric.assistant.c.a(r101), "1");
        FLogger.f375446a.i(TAG, "[AutoExecuteAuth] resolveAuthorizationStatus, key=" + r100.f391890d + ", title=" + r100.f391888b + ", defaultStatus=" + r100.f391891e + ", storedStatus=" + r101 + ", checked=" + r102);
        return r102;
    }

    private final b parsePageConfig(JsonObject r100) {
        if (r100 == null) goto L4;
        String r101 = i.a(r100, "page_name");
        JsonArray r102 = r100.getAsJsonArray("authorizations");
        if (r102 == null) goto L8;
        List<com.obric.assistant.settings.autogui.a> r103 = toAuthorizationItems(r102);
    L9:
        if (r103 != null) goto L12;
        r103 = CollectionsKt.emptyList();
    L12:
        return new b(r101, r103);
    L8:
        r103 = null;
        goto L9
    L4:
        return new b(FlowRuntime.a().getApplication().getString(R.string.obric_setting_auto_gui_auto_execute_auth), CollectionsKt.emptyList());
    }

    private final JsonObject resolvePageConfig(JsonObject r100) {
        JsonObject r101 = null;
        if (r100 != null) goto L6;
        FLogger.f375446a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, raw config is null");
        return null;
    L6:
        JsonElement r102 = r100.get(CLOUD_CONFIG_KEY);
        if (r102 != null) goto L9;
    L11:
        if (r101 == null) goto L14;
        FLogger.f375446a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, use nested config by key=auto_gui_automatic_execution_authorization, nestedConfig=" + r101);
        return r101;
    L14:
        FLogger.f375446a.i(TAG, "[AutoExecuteAuth] resolvePageConfig, nested key=auto_gui_automatic_execution_authorization not found, fallback to raw config");
        return r100;
    L9:
        if (r102.isJsonObject() == false) goto L11;
        r101 = r102.getAsJsonObject();
        goto L11
    }

    private final List<com.obric.assistant.settings.autogui.a> toAuthorizationItems(JsonArray r110) {
        ArrayList r100 = new ArrayList();
        Iterator<JsonElement> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L19;
        JsonElement r101 = r111.next();
        Intrinsics.checkNotNull(r101);
        if (r101.isJsonObject() == false) goto L8;
        JsonObject r102 = r101.getAsJsonObject();
    L9:
        if (r102 == null) goto L4;
        String r103 = i.a(r102, "type");
        String r104 = i.a(r102, "key");
        String r105 = i.a(r102, "title");
        if (Intrinsics.areEqual(r103, "switch") == false) goto L4;
        if (StringsKt.isBlank(r104) == true) goto L4;
        if (StringsKt.isBlank(r105) == true) goto L4;
        String r106 = StringsKt.trim(i.a(r102, CommodityText.SECTION_TITLE)).toString();
        String r107 = i.a(r102, "hint");
        int r108 = com.obric.assistant.c.f386004a;
        r100.add(new com.obric.assistant.settings.autogui.a(r106, r105, r107, r104, com.obric.assistant.c.a(i.a(r102, ComposerHelper.COMPOSER_DEFAULT_VALUE))));
        goto L4
    L8:
        r102 = null;
        goto L9
    L19:
        return r100;
    }

    private final void saveStoredValue(com.obric.assistant.settings.autogui.a r100, boolean r101) {
        t1 r102 = t1.f393353a;
        String r103 = r100.f391890d;
        int r104 = com.obric.assistant.c.f386004a;
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r102.X(r103, r105);
        return;
    L5:
        r105 = "2";
        goto L6
    }

    public final void onAuthorizationCheckedChanged(com.obric.assistant.settings.autogui.a r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        saveStoredValue(r110, r111);
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[AutoExecuteAuth] onAuthorizationCheckedChanged, key=");
        r101.append(r110.f391890d);
        r101.append(", defaultStatus=");
        r101.append(r110.f391891e);
        r101.append(", targetStatus=");
        int r102 = com.obric.assistant.c.f386004a;
        if (r111 == false) goto L5;
        String r103 = "1";
    L6:
        r101.append(r103);
        r101.append(", checked=");
        r101.append(r111);
        r100.i(TAG, r101.toString());
        kotlinx.coroutines.flow.z0<h> r104 = this._uiState;
        h r105 = r104.getValue();
        List<c> r106 = this._uiState.getValue().f391929b;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L15;
        c r109 = (c) r108.next();
        if ((r109 instanceof c.b) == false) goto L14;
        c.b r112 = (c.b) r109;
        if (Intrinsics.areEqual(r112.f391915a.f391890d, r110.f391890d) == false) goto L14;
        com.obric.assistant.settings.autogui.a r113 = r112.f391915a;
        int r114 = r112.f391917c;
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        r109 = new c.b(r113, r111, r114);
    L14:
        r107.add(r109);
        goto L8
    L15:
        String r115 = r105.f391928a;
        Intrinsics.checkNotNullParameter(r115, "pageName");
        Intrinsics.checkNotNullParameter(r107, "rows");
        r104.setValue(new h(r115, r107));
        return;
    L5:
        r103 = "2";
        goto L6
    }
}
