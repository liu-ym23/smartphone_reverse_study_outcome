package com.ss.android.lark.picker.base.reporter;

import android.text.TextUtils;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.lark.pb.basic.v1.Message;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchCustomizationInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.utils.y;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002JC\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/SearchClickReporter;", "Lcom/ss/android/lark/picker/base/reporter/IReporter;", "<init>", "()V", "TAG", "", "reportSearchResultClickInChat", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "location", "position", "", "tagForRpt", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "reportClickProfile", BasicTestActionHandler.TEST_ACTION_RESET, "report", "args", "Lorg/json/JSONObject;", "commonReport", "addSearchPlatformHitPoint", "jSONObject", "reportClickAppShortCut", "Lcom/ss/android/lark/search/dto/info/SearchOpenAppInfo;", "sectionPosition", "subPosition", "appLink", "(Lcom/ss/android/lark/search/dto/info/SearchOpenAppInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchClickReporter implements IReporter {
    public static final SearchClickReporter INSTANCE = null;
    public static final String TAG = "SearchClickReporter";

    static {
        INSTANCE = new SearchClickReporter();
    }

    private SearchClickReporter() {
    }

    @JvmStatic
    public static final void reportSearchResultClickInChat(SearchBaseInfo r100, String r101, String r102, Integer r110) {
        reportSearchResultClickInChat$default(r100, r101, r102, r110, null, 16, null);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void reset() {
    }

    private final void commonReport(JSONObject r100) {
        if (r100 == null) goto L10;
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, y.b(PickerBaseModuleDependency.getDependency().getLoginUserId()));     // Catch: JSONException -> L5
        SafeReporter.INSTANCE.safeSendEvent("asl_search_click", r100);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "add key-value exception for SearchClickReporter report: " + e.getMessage());
        return;
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public String getQueryId(String r100) {
        return IReporter.DefaultImpls.getQueryId(this, r100);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void report(JSONObject r100) {
        if (r100 == null) goto L17;
        r100.put("request_timestamp", System.currentTimeMillis());
        if (ChatInSideContext.INSTANCE.inChat() == true) goto L6;
    L15:
        INSTANCE.commonReport(r100);
        return;
    L6:
        if (TextUtils.isEmpty(ChatInSideContext.getChatId()) == true) goto L11;
        if ((!StringsKt.isBlank(ChatInSideContext.getChatId())) == false) goto L11;
        r100.put("chat_id", ChatInSideContext.getChatId());
    L11:
        if (TextUtils.isEmpty(ChatInSideContext.getChatType()) == true) goto L15;
        if ((!StringsKt.isBlank(ChatInSideContext.getChatType())) == false) goto L15;
        r100.put("chat_type", ChatInSideContext.getChatType());
        goto L15
    }

    public final void reportClickProfile(SearchBaseInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        JSONObject r100 = new JSONObject();
    L16:
        Log.e(TAG, "reportClickProfile occurs exception");
        return;
    L5:
        if ((r110 instanceof SearchChatterInfo) == false) goto L8;
        r100.put("result_type", ((SearchChatterInfo) r110).getResultTypeForReport());     // Catch: JSONException -> L16
    L10:
        r100.put("click", "profile");     // Catch: JSONException -> L16
        r100.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: JSONException -> L16
        SearchClickReporter r101 = INSTANCE;     // Catch: JSONException -> L16
        r101.addSearchPlatformHitPoint(r110, r100);     // Catch: JSONException -> L16
        r100.put(PickerReporterConstants.KEY.ENTITY_ID, r110.getEntityIdForReport());     // Catch: JSONException -> L16
        r100.put("search_location", r110.getSearchLocation());     // Catch: JSONException -> L16
        IReporter.DefaultImpls.packQueryForClickReporter$default(r101, r100, r110.getQuery(), r110.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L16
        r100.put("impr_id", r110.getImprId());     // Catch: JSONException -> L16
        r100.put("search_session_id", r110.getSession());     // Catch: JSONException -> L16
        if (r110.isPickerShow() == false) goto L13;
        String r111 = "component";
    L14:
        r100.put("scene_type", r111);     // Catch: JSONException -> L16
        r101.report(r100);     // Catch: JSONException -> L16
        return;
    L13:
        r111 = PullConfiguration.PROCESS_NAME_MAIN;
        goto L14
    L8:
        if ((r110 instanceof SearchChatInfo) == false) goto L20;
        r100.put("result_type", "groups");     // Catch: JSONException -> L16
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public Object safeValue(Object r100) {
        return IReporter.DefaultImpls.safeValue(this, r100);
    }

    private final void addSearchPlatformHitPoint(SearchBaseInfo r100, JSONObject r101) {
        if (r100 == null) goto L19;
        String r102 = r100.getBid();
        boolean r103 = false;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L20;
        String r105 = r100.getEntityType();
        if (r105 != null) goto L14;
    L15:
        r103 = true;
    L16:
        if (r103 == true) goto L21;
        r101.put("Bid", r100.getBid());
        r101.put("EntityType", r100.getEntityType());
        return;
    L21:
        return;
    L14:
        if (r105.length() != 0) goto L16;
    L20:
        return;
    L6:
        if (r102.length() == 0) goto L9;
        r104 = false;
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packGrammarParamsForReporter(JSONObject r100, String r101, String r102) {
        IReporter.DefaultImpls.packGrammarParamsForReporter(this, r100, r101, r102);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packQueryForClickReporter(JSONObject r100, String r101, String r102, String r103) {
        IReporter.DefaultImpls.packQueryForClickReporter(this, r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.picker.base.reporter.IReporter
    public void packQueryForScreenReporter(JSONObject r100, String r101, String r102, String r103) {
        IReporter.DefaultImpls.packQueryForScreenReporter(this, r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void reportSearchResultClickInChat(SearchBaseInfo r100, String r110, String r111, Integer r112, String r113) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L37
        r101.put("click", "result_click");     // Catch: JSONException -> L37
        if (r100 == null) goto L42;
        SearchClickReporter r102 = INSTANCE;     // Catch: JSONException -> L37
        r102.addSearchPlatformHitPoint(r100, r101);     // Catch: JSONException -> L37
        if ((r100 instanceof SearchOpenAppInfo) == false) goto L11;
        if (((SearchOpenAppInfo) r100).isAvailable() == true) goto L11;
        String r103 = "openplatform_ecosystem_application_detail_view";
    L14:
        r101.put(PickerReporterConstants.KEY.TARGET, r103);     // Catch: JSONException -> L37
        r101.put(PickerReporterConstants.KEY.ENTITY_ID, r100.getEntityIdForReport());     // Catch: JSONException -> L37
        r101.put("result_type", r100.getResultTypeForReport());     // Catch: JSONException -> L37
        if (r113 == null) goto L17;
        r101.put("tag", r113);     // Catch: JSONException -> L37
    L17:
        if (r112 == null) goto L19;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, r112.intValue());     // Catch: JSONException -> L37
    L19:
        r101.put("result_click_action", "none");     // Catch: JSONException -> L37
        if ((r100 instanceof SearchOpenSearchInfo) == false) goto L24;
        r101.put("slash_id", ((SearchOpenSearchInfo) r100).getSlashId());     // Catch: JSONException -> L37
    L33:
        if (r111 == null) goto L35;
        r101.put("search_location", r111);     // Catch: JSONException -> L37
    L35:
        IReporter.DefaultImpls.packQueryForClickReporter$default(r102, r101, r100.getQuery(), r100.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L37
        r101.put("impr_id", r100.getImprId());     // Catch: JSONException -> L37
        r101.put("search_session_id", r100.getSession());     // Catch: JSONException -> L37
        r101.put("scene_type", r102.safeValue(r110));     // Catch: JSONException -> L37
        r102.report(r101);     // Catch: JSONException -> L37
        return;
    L24:
        if ((r100 instanceof SearchCustomizationInfo) == false) goto L27;
        r101.put("slash_id", ((SearchCustomizationInfo) r100).getDataSourceId());     // Catch: JSONException -> L37
        goto L33
    L27:
        if ((r100 instanceof SearchMessageInfo) == false) goto L33;
        if (((SearchMessageInfo) r100).getThreadMessageType() != Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L31;
        String r114 = BdpAppEventConstant.FALSE;
    L32:
        r101.put("is_thread", r114);     // Catch: JSONException -> L37
        goto L33
    L31:
        r114 = BdpAppEventConstant.TRUE;
    L11:
        if ((r100 instanceof SearchSpaceInfo) == false) goto L13;
        r103 = "ccm_docs_page_view";
        goto L14
    L13:
        r103 = "none";
        goto L14
    L42:
        return;
    L37:
        e = move-exception;
        Log.e(TAG, "add key-value exception for reportSearchResultClickInChat: " + e.getMessage());
    }

    public final void reportClickAppShortCut(SearchOpenAppInfo r110, String r111, Integer r112, Integer r113, Integer r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r115, "appLink");
        JSONObject r100 = new JSONObject();
        r100.put("click", "result_click");     // Catch: JSONException -> L18
        r100.put("sub_result_type", "apps_shortcut");     // Catch: JSONException -> L18
        if (r112 == null) goto L6;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, r112.intValue());     // Catch: JSONException -> L18
    L6:
        if (r113 == null) goto L8;
        r100.put("section_pos", r113.intValue());     // Catch: JSONException -> L18
    L8:
        if (r114 == null) goto L10;
        r100.put("sub_entity_pos", r114.intValue());     // Catch: JSONException -> L18
    L10:
        r100.put("sub_entity_id", y.b(r115));     // Catch: JSONException -> L18
        SearchClickReporter r116 = INSTANCE;     // Catch: JSONException -> L18
        r116.addSearchPlatformHitPoint(r110, r100);     // Catch: JSONException -> L18
        r100.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: JSONException -> L18
        r100.put(PickerReporterConstants.KEY.ENTITY_ID, r110.getEntityIdForReport());     // Catch: JSONException -> L18
        r100.put("result_type", r110.getResultTypeForReport());     // Catch: JSONException -> L18
        r100.put("tag", r110.getTagForReport());     // Catch: JSONException -> L18
        r100.put("result_click_action", "none");     // Catch: JSONException -> L18
        r100.put("search_location", r110.getSearchLocation());     // Catch: JSONException -> L18
        IReporter.DefaultImpls.packQueryForClickReporter$default(r116, r100, r110.getQuery(), r110.getFilterStatus(), null, 8, null);     // Catch: JSONException -> L18
        r116.packGrammarParamsForReporter(r100, r110.getFilterStatus(), r110.getGrammarType());     // Catch: JSONException -> L18
        r100.put("impr_id", r110.getImprId());     // Catch: JSONException -> L18
        r100.put("scene_type", r116.safeValue(r111));     // Catch: JSONException -> L18
        r100.put("search_session_id", r110.getSession());     // Catch: JSONException -> L18
        r100.put("request_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L18
        Map<String, Object> r117 = r110.getExtraParams();     // Catch: JSONException -> L18
        if (r117 == null) goto L16;
        Iterator<Map.Entry<String, Object>> r118 = r117.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r118.hasNext() == false) goto L16;
        Map.Entry<String, Object> r119 = r118.next();     // Catch: JSONException -> L18
        r100.put(r119.getKey(), r119.getValue());     // Catch: JSONException -> L18
    L16:
        INSTANCE.commonReport(r100);     // Catch: JSONException -> L18
        return;
    L18:
        Log.e(TAG, "reportClickProfile occurs exception");
    }

    public static /* synthetic */ void reportSearchResultClickInChat$default(SearchBaseInfo r100, String r101, String r102, Integer r103, String r104, int r105, Object r106) {
        if ((r105 & 16) == 0) goto L5;
        r104 = null;
    L5:
        reportSearchResultClickInChat(r100, r101, r102, r103, r104);
    }
}
