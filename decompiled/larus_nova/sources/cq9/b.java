package cq9;

import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.creation.CreationMultiReferenceProtocolState;
import com.larus.platform.creation.CreationMultiReferenceRuleResult;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f465024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f465025b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f465026c = null;

    public b() {
    }

    static {
        f465024a = SetsKt.setOf(new String[]{"video_creation", "creation_feed", "do_same_restore", "do_same", "model_switch", "tab_switch", "send_precheck", "album_callback"});
        f465025b = SetsKt.setOf(new String[]{"model_input_rule_selector", "prefill", "album", "delete", "click_remove", "ref_resources", "model_selector", "creation_tab", "attachment_snapshot", ChatDraftItem.TYPE_NESTED_FILE});
        f465026c = SetsKt.setOf(new String[]{"UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "NOT_READY", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO"});
    }

    public static void a(CreationMultiReferenceLogEvent r110, Boolean r111, String r112, String r113, a r114, CreationMultiReferenceProtocolState r115, CreationMultiReferenceRuleResult r116, String r210, int r211) {
        String r100 = null;
        if ((r211 & 2) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r211 & 32) == 0) goto L17;
        a r104 = null;
    L19:
        if ((r211 & 64) == 0) goto L21;
        CreationMultiReferenceProtocolState r105 = null;
    L23:
        if ((r211 & 128) == 0) goto L25;
        CreationMultiReferenceRuleResult r106 = null;
    L27:
        if ((r211 & 256) == 0) goto L29;
        String r107 = null;
    L30:
        Intrinsics.checkNotNullParameter(r110, "event");
        List r108 = CollectionsKt.createListBuilder();
        r108.add("event=" + r110.getValue());
        if (r101 == null) goto L33;
        r108.add("gate=" + r101.booleanValue());
    L33:
        String r109 = "other";
        if (r102 != null) goto L36;
    L42:
        if (r103 != null) goto L44;
    L50:
        if (r104 == null) goto L54;
        r108.add("image_count=" + r104.f465017a);
        r108.add("video_count=" + r104.f465018b);
        r108.add("audio_count=" + r104.f465019c);
        r108.add("unknown_count=" + r104.f465020d);
        r108.add("video_duration=" + r104.f465021e);
        r108.add("audio_duration=" + r104.f465022f);
        r108.add("total_duration=" + (r104.f465021e + r104.f465022f));
        Integer r117 = r104.f465023g;
        if (r117 == null) goto L54;
        r108.add("entity_summary=total:" + r117.intValue() + ",image:" + r104.f465017a + ",video:" + r104.f465018b + ",audio:" + r104.f465019c + ",unknown:" + r104.f465020d);
    L54:
        if (r105 == null) goto L56;
        r108.add("protocol_state=" + r105.getValue());
    L56:
        if (r106 == null) goto L58;
        r108.add("rule_result=" + r106.getValue());
    L58:
        if (r107 != null) goto L60;
    L66:
        FLogger.f375446a.i("CreationMultiReference", CollectionsKt.joinToString$default(CollectionsKt.build(r108), " ", null, null, 0, null, null, 62, null));
        return;
    L60:
        if (f465026c.contains(r107) == false) goto L62;
        r100 = r107;
    L62:
        if (r100 == null) goto L65;
        r109 = r100;
    L65:
        r108.add("reason=".concat(r109));
        goto L66
    L44:
        if (f465025b.contains(r103) == true) goto L47;
        r103 = null;
    L47:
        if (r103 != null) goto L49;
        r103 = "other";
    L49:
        r108.add("source=".concat(r103));
        goto L50
    L36:
        if (f465024a.contains(r102) == true) goto L39;
        r102 = null;
    L39:
        if (r102 != null) goto L41;
        r102 = "other";
    L41:
        r108.add("scene=".concat(r102));
        goto L42
    L29:
        r107 = r210;
        goto L30
    L25:
        r106 = r116;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
