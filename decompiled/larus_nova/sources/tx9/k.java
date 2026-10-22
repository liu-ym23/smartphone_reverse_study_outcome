package tx9;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f547878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet<String> f547879b = null;

    public k() {
    }

    static {
        f547878a = new k();
        f547879b = new LinkedHashSet();
    }

    public static /* synthetic */ void b(String r100, i r101, Integer r102, String r110, int r111) {
        k r103 = f547878a;
        if ((r111 & 8) == 0) goto L5;
        Integer r104 = null;
    L7:
        if ((r111 & 16) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r111 & 32) == 0) goto L13;
        boolean r106 = !Intrinsics.areEqual(r100, "card_bind");
    L14:
        r103.a(r100, r101, null, r104, r105, r106);
        return;
    L13:
        r106 = false;
        goto L14
    L9:
        r105 = r110;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }

    public final void a(String r210, i r211, String r212, Integer r213, String r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r210, "stage");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r211.f547861c;
        String r101 = r211.f547866h;
        String r102 = r211.f547859a;
        String r103 = r211.f547860b;
        String[] r104 = new String[5];
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        boolean r110 = false;
        r104[0] = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104[1] = r101;
        r104[2] = r210;
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104[3] = r102;
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r104[4] = r103;
        String r105 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r104), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        if (r215 == false) goto L33;
        monitor-enter(this);
        LinkedHashSet<String> r106 = f547879b;     // Catch: Throwable -> L30
        if (r106.contains(r105) == false) goto L21;
        monitor-exit(this);
        boolean r107 = false;
    L28:
        if (r107 == true) goto L33;
        return;
    L21:
        r106.add(r105);     // Catch: Throwable -> L30
        if (r106.size() <= 256) goto L26;
        Iterator<String> r108 = r106.iterator();     // Catch: Throwable -> L30
        if (r108.hasNext() == false) goto L26;
        r108.next();     // Catch: Throwable -> L30
        r108.remove();     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
        r107 = true;
    L30:
        th = move-exception;
        throw th;
    L33:
        String r109 = r211.f547870l;
        if (r109 != null) goto L36;
    L37:
        r110 = true;
    L38:
        if (r110 == false) goto L41;
        String r111 = null;
    L44:
        String r112 = r211.f547859a;
        String r113 = r211.f547860b;
        String r114 = r211.f547861c;
        String r115 = r211.f547862d;
        String r116 = r211.f547863e;
        String r117 = r211.f547868j;
        String r118 = r211.f547869k;
        Integer r119 = r211.f547865g;
        String r120 = r211.f547866h;
        Integer r121 = r211.f547867i;
        Integer r122 = r211.f547871m;
        String r123 = r211.f547872n;
        JSONObject r124 = new JSONObject();
        r124.put("scene", r211.f547864f);
        Unit r125 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r210, "stage");
        Intrinsics.checkNotNullParameter(r124, "params");
        r124.put("stage", r210);     // Catch: Exception -> L66
        r124.putOpt("record_id", r112);     // Catch: Exception -> L66
        r124.putOpt("record_id_v2", r113);     // Catch: Exception -> L66
        r124.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r114);     // Catch: Exception -> L66
        r124.putOpt("reply_message_id", r115);     // Catch: Exception -> L66
        r124.putOpt("conversation_id", r116);     // Catch: Exception -> L66
        r124.putOpt("device_id", r117);     // Catch: Exception -> L66
        r124.putOpt("user_id", r118);     // Catch: Exception -> L66
        if (r119 == null) goto L48;
        r124.put("block_type", r119.intValue());     // Catch: Exception -> L66
    L48:
        r124.putOpt(BitableResourceData.KEY_BLOCK_ID, r120);     // Catch: Exception -> L66
        if (r121 == null) goto L51;
        r124.put("record_minutes_block_status", r121.intValue());     // Catch: Exception -> L66
    L51:
        r124.putOpt("effective_card_stage", r212);     // Catch: Exception -> L66
        r124.putOpt("is_same_device", r111);     // Catch: Exception -> L66
        Integer r126 = r213;
        if (r126 == null) goto L56;
        r124.put("code", r213.intValue());     // Catch: Exception -> L64
    L64:
        e = e;
    L65:
        String r127 = r214;
        Integer r128 = r122;
    L68:
        String r129 = "AudioRecordEventHelper";
        FLogger.f375446a.e(r129, e.getMessage(), e);
    L69:
        TrackParams r130 = new TrackParams().merge(r124);
        by7.a r131 = new by7.a("flow_doc_record_minutes_block_funnel");
        FLogger.f375446a.i(r129, "emit flow_doc_record_minutes_block_funnel: stage=" + r210 + ", code=" + r126 + ", reason=" + r127 + ", blockType=" + r119 + ", status=" + r121 + ", effectiveCardStage=" + r212 + ", isSameDevice=" + r111 + ", serverFailCode=" + r128);
        r131.f21463a.merge(r130);
        r131.b();
        return;
    L56:
        r127 = r214;
        r128 = r122;
        r124.putOpt("reason", r127);     // Catch: Exception -> L62
        if (r128 == null) goto L60;
        r124.put("server_fail_code", r128.intValue());     // Catch: Exception -> L62
    L60:
        r124.putOpt("server_fail_info", r123);     // Catch: Exception -> L62
        r129 = "AudioRecordEventHelper";
    L62:
        e = e;
    L66:
        e = e;
        r126 = r213;
        goto L65
    L41:
        if (Intrinsics.areEqual(r211.f547870l, r211.f547868j) == false) goto L43;
        r111 = "1";
        goto L44
    L43:
        r111 = "0";
        goto L44
    L36:
        if (r109.length() != 0) goto L38;
        goto L37
    }
}
