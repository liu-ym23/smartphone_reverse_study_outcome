package com.ss.android.ugc.aweme.discover.utils.actionrecord;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/utils/actionrecord/ECSearchActionRecordManager;", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchActionRecordManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f450787a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/utils/actionrecord/ECSearchActionRecordManager$Companion;", "", "", "ENABLE_SHOW_DOC", "I", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static String a(List r110) {
            JSONArray r100 = new JSONArray();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L65
            if (r110 == null) goto L6;
            int r102 = r110.size();     // Catch: Throwable -> L65
        L7:
            if (r102 <= 0) goto L9;
            if (r110 == null) goto L12;
            int r103 = r110.size();     // Catch: Throwable -> L65
        L13:
            int r104 = r103 - 1;     // Catch: Throwable -> L65
            int r105 = 50;
        L14:
            if (r104 < 0) goto L63;
            Integer r106 = null;
            if (r110 == null) goto L18;
            SearchAggregateCommodity r107 = (SearchAggregateCommodity) CollectionsKt.getOrNull(r110, r104);     // Catch: Throwable -> L65
        L19:
            ECSearchActionRecordManager.f450787a.getClass();     // Catch: Throwable -> L65
            if (r107 == null) goto L24;
            Map<String, Object> r108 = r107.getLogInfo();     // Catch: Throwable -> L65
            if (r108 == null) goto L24;
            Object r109 = r108.get("enable_show_doc");     // Catch: Throwable -> L65
        L26:
            if ((r109 instanceof Double) == false) goto L32;
            if (((int) ((Number) r109).doubleValue()) != 1) goto L30;
            boolean r111 = true;
        L35:
            if (r111 == false) goto L60;
            if (r107 == null) goto L40;
            LogPbBean r112 = r107.getLogPbBean();     // Catch: Throwable -> L65
            if (r112 == null) goto L40;
            String r113 = r112.imprId;     // Catch: Throwable -> L65
        L42:
            if (TextUtils.isEmpty(r113) == false) goto L44;
        L50:
            boolean r114 = false;
        L51:
            if (r114 == false) goto L60;
            JSONObject r115 = new JSONObject();     // Catch: Throwable -> L65
            if (r107 == null) goto L55;
            String r116 = String.valueOf(r107.getDocId());     // Catch: Throwable -> L65
        L56:
            r115.putOpt("doc_id", r116);     // Catch: Throwable -> L65
            if (r107 == null) goto L59;
            r106 = Integer.valueOf(r107.getDocType());     // Catch: Throwable -> L65
        L59:
            r115.putOpt("doc_type", r106);     // Catch: Throwable -> L65
            Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L65
            r100.put(r115);     // Catch: Throwable -> L65
            r105 = r105 - 1;     // Catch: Throwable -> L65
            goto L60
        L55:
            r116 = null;
            goto L56
        L44:
            if (r107 == null) goto L46;
            long r118 = r107.getDocId();     // Catch: Throwable -> L65
        L48:
            if (r118 <= 0) goto L50;
            r114 = true;
            goto L51
        L46:
            r118 = 0;
        L40:
            r113 = null;
        L60:
            if (r105 <= 0) goto L63;
            r104 = r104 - 1;     // Catch: Throwable -> L65
            goto L14
        L30:
            r111 = false;
            goto L35
        L32:
            if ((r109 instanceof Boolean) == false) goto L34;
            r111 = ((Boolean) r109).booleanValue();     // Catch: Throwable -> L65
            goto L35
        L34:
            r111 = Intrinsics.areEqual(r109, 1);     // Catch: Throwable -> L65
        L24:
            r109 = null;
            goto L26
        L18:
            r107 = null;
        L63:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
        L68:
            return r100.toString();
        L12:
            r103 = 0;
            goto L13
        L9:
            return r100.toString();
        L6:
            r102 = 0;
        L65:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L68
        }
    }

    static {
        f450787a = new Companion(0);
    }
}
