package com.obric.assistant.cocreationreview.modules.memory;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import f06.d;
import hda.n0;
import hda.w0;
import hda.x0;
import hda.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements hda.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f387405b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f387406a;

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.modules.memory.a$a, reason: collision with other inner class name */
    public static final class C4600a {
    }

    static {
        f387405b = UriProtector.parse("content://com.obric.memorydata.memory.provider");
    }

    public a(Context r100) {
        this.f387406a = r100;
    }

    public static void f(ContentProviderClient r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r100.close();
        return;
    L5:
        r100.release();
    }

    @Override // hda.b
    public final x0 a(w0 r100) {
        Intrinsics.checkNotNullParameter(r100, "feedback");
        int r101 = b.f387426a;
        Intrinsics.checkNotNullParameter(r100, "feedback");
        JSONObject r102 = new JSONObject().put("recordId", r100.f484774a).put(EventConstant.Key.MODULE, r100.f484775b.getRaw()).put("vote", r100.f484776c.getRaw()).put("reasons", new JSONArray(CollectionsKt.toList(r100.f484777d))).put("comment", r100.f484778e).put("businessPayloadJson", r100.f484779f);
        String r103 = r100.f484780g;
        if (r103 == null) goto L5;
        r102.put("traceJson", r103);
    L5:
        String r104 = r102.toString();
        Bundle r105 = new Bundle();
        r105.putString("feedbackJson", r104);
        Unit r106 = Unit.INSTANCE;
        Bundle r107 = c("submitMemoryReviewFeedback", r105);
        if (r107 == null) goto L8;
        String r108 = r107.getString("resultJson");
    L10:
        if (r108 == null) goto L13;
        Intrinsics.checkNotNullParameter(r108, "jsonText");
        JSONObject r109 = new JSONObject(r108);
        return new x0(r109.optBoolean("accepted", false), r109.optString("message", ""));
    L13:
        return new x0(false, "MemoryData provider unavailable");
    L8:
        r108 = null;
        goto L10
    }

    @Override // hda.b
    public final c b(n0 r310) {
        Intrinsics.checkNotNullParameter(r310, "request");
        int r100 = b.f387426a;
        Intrinsics.checkNotNullParameter(r310, "request");
        JSONObject r101 = new JSONObject().put(EventConstant.Key.MODULE, r310.f484730a.getRaw());
        Object r102 = r310.f484731b;
        if (r102 != null) goto L5;
        r102 = JSONObject.NULL;
    L5:
        String r103 = r101.put("pageCursor", r102).put("pageSize", r310.f484732c).put("observeFromTimeMillis", r310.f484733d).put("windowEndTimeMillis", r310.f484734e).toString();
        Bundle r104 = new Bundle();
        r104.putString("requestJson", r103);
        Unit r105 = Unit.INSTANCE;
        Bundle r106 = c("getMemoryReviewPage", r104);
        if (r106 == null) goto L8;
        String r107 = r106.getString("resultJson");
    L9:
        if (r107 == null) goto L61;
        Intrinsics.checkNotNullParameter(r107, "jsonText");
        JSONObject r108 = new JSONObject(r107);
        MemoryDataReviewModuleKey.a r109 = MemoryDataReviewModuleKey.Companion;
        String r110 = b.a(r108, EventConstant.Key.MODULE);
        r109.getClass();
        MemoryDataReviewModuleKey[] r111 = MemoryDataReviewModuleKey.values();
        int r112 = r111.length;
        int r113 = 0;
    L11:
        if (r113 >= r112) goto L16;
        MemoryDataReviewModuleKey r114 = r111[r113];
        if (Intrinsics.areEqual(r114.getRaw(), r110) == true) goto L17;
        r113 = r113 + 1;
    L17:
        if (r114 != null) goto L19;
        r114 = MemoryDataReviewModuleKey.SCREEN_MEMORY;
    L19:
        MemoryDataReviewModuleKey r115 = r114;
        long r116 = r108.optLong("observeFromTimeMillis", 0);
        long r117 = r108.optLong("windowEndTimeMillis", System.currentTimeMillis());
        List r118 = b.b(r108.optJSONArray("pendingRecords"), r115);
        List r119 = b.b(r108.optJSONArray("completedRecords"), r115);
        JSONObject r120 = r108.optJSONObject("feedbackByRecordId");
        if (r120 != null) goto L22;
        Map r121 = MapsKt.emptyMap();
    L57:
        String r122 = b.a(r108, "nextPageCursor");
        if (r122 != null) goto L73;
        r122 = b.a(r108, "nextCursor");
    L73:
        return new c(r115, r116, r117, r118, r119, r121, r122, r108.optBoolean("hasMore", false), b.a(r108, "error"));
    L22:
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator<String> r124 = r120.keys();
    L24:
        if (r124.hasNext() == false) goto L56;
        String r125 = r124.next();
        JSONObject r126 = r120.optJSONObject(r125);
        if (r126 == null) goto L24;
        MemoryReviewFeedbackState.a r127 = MemoryReviewFeedbackState.Companion;
        String r128 = b.a(r126, "state");
        r127.getClass();
        MemoryReviewFeedbackState r210 = MemoryReviewFeedbackState.a.a(r128);
        Vote.a r129 = Vote.Companion;
        String r130 = b.a(r126, "vote");
        r129.getClass();
        Vote r211 = Vote.a.a(r130);
        JSONArray r131 = r126.optJSONArray("reasons");
        if (r131 != null) goto L31;
        Set r212 = SetsKt.emptySet();
    L41:
        String r213 = r126.optString("comment", "");
        String r132 = b.a(r126, "displayedCardJson");
        if (r132 != null) goto L47;
        Object r133 = r126.opt("displayedCard");
        if (r133 == null) goto L46;
        r132 = r133.toString();
        goto L47
    L46:
        String r214 = null;
    L48:
        String r134 = b.a(r126, "traceJson");
        if (r134 != null) goto L54;
        Object r135 = r126.opt("trace");
        if (r135 == null) goto L53;
        r134 = r135.toString();
        goto L54
    L53:
        String r215 = null;
    L55:
        r123.put(r125, new y(r210, r211, r212, r213, r214, r215, r126.optLong("updateTimeMillis", 0)));
        r120 = r120;
    L54:
        r215 = r134;
    L47:
        r214 = r132;
        goto L48
    L31:
        LinkedHashSet r136 = new LinkedHashSet();
        int r137 = r131.length();
        int r138 = 0;
    L32:
        if (r138 >= r137) goto L40;
        String r139 = r131.optString(r138);
        Intrinsics.checkNotNull(r139);
        if ((!StringsKt.isBlank(r139)) == false) goto L36;
        String r140 = r139;
    L37:
        if (r140 == null) goto L39;
        r136.add(r140);
    L39:
        r138 = r138 + 1;
        goto L32
    L36:
        r140 = null;
        goto L37
    L40:
        r212 = r136;
        goto L41
    L56:
        r121 = r123;
        goto L57
    L16:
        r114 = null;
        goto L17
    L61:
        int r141 = c.f387427j;
        MemoryDataReviewModuleKey r142 = r310.f484730a;
        long r143 = r310.f484733d;
        long r144 = r310.f484734e;
        Intrinsics.checkNotNullParameter(r142, EventConstant.Key.MODULE);
        return new c(r142, r143, r144, CollectionsKt.emptyList(), CollectionsKt.emptyList(), MapsKt.emptyMap(), null, false, "MemoryData provider unavailable");
    L8:
        r107 = null;
        goto L9
    }

    public static ContentProviderClient d(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final Bundle c(String r100, Bundle r101) {
        Context r102 = this.f387406a;
        Bundle r103 = null;
        if (r102 == null) goto L25;
        Context r104 = r102.getApplicationContext();
        if (r104 == null) goto L25;
        ContentProviderClient r105 = d(r104.getContentResolver(), f387405b);     // Catch: IllegalArgumentException -> L9 SecurityException -> L10
    L26:
        if (r105 != null) goto L28;
        return null;
    L28:
        r103 = r105.call(r100, null, r101);     // Catch: Throwable -> L16 RemoteException -> L18 DeadObjectException -> L20
    L21:
        f(r105);
        return r103;
    L18:
        e = move-exception;
        int r106 = s3.f387719a;     // Catch: Throwable -> L16
        s3.c("memory.bridge", "provider remote failure method=" + r100 + " type=" + e.getClass().getSimpleName());     // Catch: Throwable -> L16
    L20:
        int r107 = s3.f387719a;     // Catch: Throwable -> L16
        s3.c("memory.bridge", "provider died method=".concat(r100));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        f(r105);
        throw th;
    L9:
        int r108 = s3.f387719a;
        s3.c("memory.bridge", "provider missing method=".concat(r100));
    L11:
        r105 = null;
    L10:
        int r109 = s3.f387719a;
        s3.c("memory.bridge", "acquire denied method=".concat(r100));
    L25:
        return null;
    }

    public final hda.a e(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        if (StringsKt.isBlank(r100) == true) goto L5;
        Bundle r101 = new Bundle();
        r101.putInt("protocolVersion", 1);
        r101.putString("recordId", r100);
        r101.putString(EffectConfiguration.KEY_CURSOR, r110);
        Unit r102 = Unit.INSTANCE;
        Bundle r103 = c("getMemoryReviewAudioTranscriptChunk", r101);
        if (r103 == null) goto L9;
        MemoryReviewAudioTranscriptCode.a r104 = MemoryReviewAudioTranscriptCode.Companion;
        String r105 = r103.getString("code");
        r104.getClass();
        MemoryReviewAudioTranscriptCode[] r106 = MemoryReviewAudioTranscriptCode.values();
        int r107 = r106.length;
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L16;
        MemoryReviewAudioTranscriptCode r109 = r106[r108];
        if (Intrinsics.areEqual(r109.name(), r105) == true) goto L17;
        r108 = r108 + 1;
    L17:
        if (r109 != null) goto L19;
        MemoryReviewAudioTranscriptCode r111 = MemoryReviewAudioTranscriptCode.INTERNAL_ERROR;
    L20:
        String r112 = r103.getString(MonitorConstants.CHUNK);
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        return new hda.a(r111, r112, r103.getString("nextCursor"), r103.getBoolean("hasMore", false), r103.getLong(DBDefinition.TOTAL_BYTES, 0));
    L19:
        r111 = r109;
        goto L20
    L16:
        r109 = null;
        goto L17
    L9:
        return new hda.a(MemoryReviewAudioTranscriptCode.INTERNAL_ERROR);
    L5:
        return new hda.a(MemoryReviewAudioTranscriptCode.NOT_FOUND);
    }
}
