package com.ss.android.lark.picker.base.reporter;

import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016J4\u0010\t\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u000e\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J4\u0010\u0010\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/reporter/IReporter;", "", BasicTestActionHandler.TEST_ACTION_RESET, "", "report", "args", "Lorg/json/JSONObject;", "safeValue", "value", "packQueryForClickReporter", "query", "", "filterStatus", "recFilterSelectedStatus", "packGrammarParamsForReporter", "grammarType", "packQueryForScreenReporter", "recFilterStatus", "getQueryId", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IReporter {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object safeValue(IReporter r100, Object r101) {
            if (r101 != null) goto L5;
            return "none";
        L5:
            return r101;
        }

        public static String getQueryId(IReporter r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "query");
            if (TextUtils.isEmpty(r101) == false) goto L7;
            return "6cb9acc00ffb4016dd5fe3a5d98e0bc5b94c285e";
        L7:
            return y.b(r101);
        }

        public static void packGrammarParamsForReporter(IReporter r100, JSONObject r101, String r102, String r103) {
            if (r101 == null) goto L18;
            if (r103 != null) goto L16;
        L10:
            boolean r104 = true;
        L11:
            if (r104 == true) goto L19;
            JSONObject r105 = new JSONObject();     // Catch: JSONException -> L8
            r105.put("filter_status", r100.safeValue(r102));     // Catch: JSONException -> L8
            r105.put("source", r100.safeValue(r103));     // Catch: JSONException -> L8
            r101.put("selected_rec_filter", r105);     // Catch: JSONException -> L8
            return;
        L8:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packGrammarParamsForReporter: " + e.getMessage());
            return;
        L19:
            return;
        L16:
            if (r103.length() == 0) goto L10;
            r104 = false;
            goto L11
        }

        public static void packQueryForClickReporter(IReporter r100, JSONObject r101, String r102, String r103, String r104) {
            if (r101 == null) goto L20;
            if (r102 != null) goto L17;
            r102 = "";
        L17:
            r101.put("query_length", r102.length());     // Catch: JSONException -> L13
            r101.put("query_id", r100.getQueryId(r102));     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r103) == false) goto L9;
            r101.put("is_filter", BdpAppEventConstant.FALSE);     // Catch: JSONException -> L13
        L16:
            return;
        L9:
            r101.put("is_filter", BdpAppEventConstant.TRUE);     // Catch: JSONException -> L13
            r101.put("filter_status", r103);     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r104) == true) goto L16;
            r101.put("selected_rec_filter", r104);     // Catch: JSONException -> L13
        L13:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packQueryForClickReporter: " + e.getMessage());
            return;
        }

        public static void packQueryForScreenReporter(IReporter r100, JSONObject r101, String r102, String r103, String r104) {
            if (r101 == null) goto L19;
            if (r102 != null) goto L17;
            r102 = "";
        L17:
            r101.put("query_length", r102.length());     // Catch: JSONException -> L14
            r101.put("query_id", r100.getQueryId(r102));     // Catch: JSONException -> L14
            if (TextUtils.isEmpty(r103) == false) goto L9;
            r101.put("is_filter", BdpAppEventConstant.FALSE);     // Catch: JSONException -> L14
        L11:
            if (TextUtils.isEmpty(r104) == true) goto L20;
            r101.put("rec_filter", r104);     // Catch: JSONException -> L14
            return;
        L20:
            return;
        L9:
            r101.put("is_filter", BdpAppEventConstant.TRUE);     // Catch: JSONException -> L14
            r101.put("filter_status", r103);     // Catch: JSONException -> L14
        L14:
            e = move-exception;
            Log.e(SearchClickReporter.TAG, "add key-value exception for packQueryForScreenReporter: " + e.getMessage());
            return;
        }

        public static /* synthetic */ void packGrammarParamsForReporter$default(IReporter r100, JSONObject r101, String r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = "";
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = "";
        L9:
            r100.packGrammarParamsForReporter(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packGrammarParamsForReporter");
        }

        public static /* synthetic */ void packQueryForClickReporter$default(IReporter r100, JSONObject r101, String r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L12;
            if ((r105 & 4) == 0) goto L7;
            r103 = "";
        L7:
            if ((r105 & 8) == 0) goto L9;
            r104 = null;
        L9:
            r100.packQueryForClickReporter(r101, r102, r103, r104);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packQueryForClickReporter");
        }

        public static /* synthetic */ void packQueryForScreenReporter$default(IReporter r100, JSONObject r101, String r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L12;
            if ((r105 & 4) == 0) goto L7;
            r103 = "";
        L7:
            if ((r105 & 8) == 0) goto L9;
            r104 = null;
        L9:
            r100.packQueryForScreenReporter(r101, r102, r103, r104);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: packQueryForScreenReporter");
        }
    }

    String getQueryId(String r100);

    void packGrammarParamsForReporter(JSONObject r100, String r101, String r102);

    void packQueryForClickReporter(JSONObject r100, String r101, String r102, String r103);

    void packQueryForScreenReporter(JSONObject r100, String r101, String r102, String r103);

    void report(JSONObject r100);

    void reset();

    Object safeValue(Object r100);
}
