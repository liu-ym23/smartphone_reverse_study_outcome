package qo5;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f534171f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f534172g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f534173h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f534174i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f534175j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f534176k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f534177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f534178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<Integer, Integer> f534179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f534180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f534181e;

    public static final class a {
    }

    static {
        f534171f = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_id=([^,]*)");
        f534172g = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_ver=([^,]*)");
        f534173h = PatternProtector.compile("#EXT-X-LARK-INFO:.*?idx_f=([^,]*)");
        f534174i = PatternProtector.compile("#EXT-X-LARK-INFO:.*?idx_e=([^,]*)");
        f534175j = PatternProtector.compile("#EXT-X-LARK-INFO:.*?block_parent=([^,]*)");
        f534176k = PatternProtector.compile("#EXTINF:(.*?)(,|$)");
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        String r101 = this.f534177a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.putOpt("id", r101);
        r100.putOpt("ver", Integer.valueOf(this.f534178b));
        JSONArray r102 = new JSONArray();
        r102.put(this.f534179c.getFirst().intValue());
        r102.put(this.f534179c.getSecond().intValue());
        Unit r103 = Unit.INSTANCE;
        r100.putOpt(FilterData.FilterOptionItem.Type.RANGE, r102);
        String r104 = this.f534180d;
        if (r104 != null) goto L8;
    L16:
        JSONObject r105 = new JSONObject();
        r105.putOpt("scene", "tts");
        r105.putOpt("selected", new JSONArray().put(r100));
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L19;
        tt5.a.h("TtsM3U8Segment", "openItemSource, result: " + du5.b.h(r105.toString()));
    L19:
        tt5.a.h("TtsM3U8Segment", "exportAnchorBlockJsonObj, " + this);
        return r105;
    L8:
        if (r104.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L16;
        JSONObject r107 = new JSONObject();
        r107.putOpt("id", r104);
        r107.putOpt("reference", new JSONArray().put(r100));
        r100 = r107;
        goto L16
    L10:
        r106 = false;
        goto L11
    }

    public final String toString() {
        return "TtsM3U8Segment@" + hashCode() + "{blockId: " + du5.b.i(this.f534177a) + ", blockVersion: " + this.f534178b + ", blockRange: " + this.f534179c + ", blockReferenceId: " + du5.b.i(this.f534180d) + ", durationMs: " + this.f534181e + '}';
    }

    public b() {
        this.f534179c = new Pair(0, 0);
    }
}
