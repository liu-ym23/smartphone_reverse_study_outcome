package qo5;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final Pattern f = null;
    public static final Pattern g = null;
    public static final Pattern h = null;
    public static final Pattern i = null;
    public static final Pattern j = null;
    public static final Pattern k = null;
    public String a;
    public int b;
    public Pair<Integer, Integer> c;
    public String d;
    public long e;

    public static final class a {
    }

    static {
        f = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_id=([^,]*)");
        g = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_ver=([^,]*)");
        h = PatternProtector.compile("#EXT-X-LARK-INFO:.*?idx_f=([^,]*)");
        i = PatternProtector.compile("#EXT-X-LARK-INFO:.*?idx_e=([^,]*)");
        j = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_parent=([^,]*)");
        k = PatternProtector.compile("#EXTINF:(.*?)(,|$)");
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.putOpt(ResourceData.KEY_ID, r1);
        r0.putOpt("ver", Integer.valueOf(this.b));
        JSONArray r2 = new JSONArray();
        r2.put(((Number) this.c.getFirst()).intValue());
        r2.put(((Number) this.c.getSecond()).intValue());
        Unit r3 = Unit.INSTANCE;
        r0.putOpt(FilterData.FilterOptionItem.Type.RANGE, r2);
        String r4 = this.d;
        if (r4 != null) goto L8;
    L16:
        JSONObject r5 = new JSONObject();
        r5.putOpt("scene", "tts");
        r5.putOpt("selected", new JSONArray().put(r0));
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L19;
        tt5.a.h("TtsM3U8Segment", "openItemSource, result: " + du5.b.h(r5.toString()));
    L19:
        tt5.a.h("TtsM3U8Segment", "exportAnchorBlockJsonObj, " + this);
        return r5;
    L8:
        if (r4.length() <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        JSONObject r7 = new JSONObject();
        r7.putOpt(ResourceData.KEY_ID, r4);
        r7.putOpt("reference", new JSONArray().put(r0));
        r0 = r7;
        goto L16
    L10:
        r6 = false;
        goto L11
    }

    public final String toString() {
        return "TtsM3U8Segment@" + hashCode() + "{blockId: " + du5.b.i(this.a) + ", blockVersion: " + this.b + ", blockRange: " + this.c + ", blockReferenceId: " + du5.b.i(this.d) + ", durationMs: " + this.e + '}';
    }

    public b() {
        this.c = new Pair(0, 0);
    }
}
