package sbb;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pattern f541280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pattern f541281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f541282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f541283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f541284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f541285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f541286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f541287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f541288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f541289j;

    public final void e() {
        Set<Map.Entry<String, String>> r100 = this.f541284e.entrySet();
        if (r100 != null) goto L5;
    L39:
        StringBuilder r101 = new StringBuilder("updateDocumentTypeName()...");
        r101.append("doc = " + e.f541296g.f541318c + ", sheet = " + e.f541297h.f541318c + ", folder = " + e.f541295f.f541318c + ", bitable = " + e.f541298i.f541318c + ", baseAdd = " + e.f541299j.f541318c + ", mindnote = " + e.f541300k.f541318c + ", file = " + e.f541301l.f541318c + ", slide = " + e.f541302m.f541318c + ", docx = " + e.f541304o.f541318c + ", wiki = " + e.f541303n.f541318c);
        Log.i("BaseDomainConfigParser", r101.toString());
        return;
    L5:
        if (CollectionUtils.isEmpty(r100) == true) goto L39;
        Iterator<Map.Entry<String, String>> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L39;
        Map.Entry<String, String> r103 = r102.next();
        if (TextUtils.equals(r103.getKey(), "doc") == true) goto L11;
        if (TextUtils.equals(r103.getKey(), DocumentType.SHEET_NAME) == true) goto L14;
        if (TextUtils.equals(r103.getKey(), DocumentType.FOLDER_NAME) == true) goto L17;
        if (TextUtils.equals(r103.getKey(), DocumentType.BITABLE_NAME) == true) goto L20;
        if (TextUtils.equals(r103.getKey(), DocumentType.BASE_ADD_NAME) == true) goto L23;
        if (TextUtils.equals(r103.getKey(), DocumentType.MINDNOTE_NAME) == true) goto L26;
        if (TextUtils.equals(r103.getKey(), "file") == true) goto L29;
        if (TextUtils.equals(r103.getKey(), "slides") == true) goto L32;
        if (TextUtils.equals(r103.getKey(), "wiki") == true) goto L35;
        if (TextUtils.equals(r103.getKey(), "doc") == false) goto L8;
        e.f541304o.f541318c = r103.getValue();
        goto L8
    L35:
        e.f541303n.f541318c = r103.getValue();
        goto L8
    L32:
        e.f541302m.f541318c = r103.getValue();
        goto L8
    L29:
        e.f541301l.f541318c = r103.getValue();
        goto L8
    L26:
        e.f541300k.f541318c = r103.getValue();
        goto L8
    L23:
        e.f541299j.f541318c = r103.getValue();
        goto L8
    L20:
        e.f541298i.f541318c = r103.getValue();
        goto L8
    L17:
        e.f541295f.f541318c = r103.getValue();
        goto L8
    L14:
        e.f541297h.f541318c = r103.getValue();
        goto L8
    L11:
        e.f541296g.f541318c = r103.getValue();
        goto L8
    }

    public b(String r100) {
        this.f541280a = PatternProtector.compile("/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        this.f541281b = PatternProtector.compile("/([\\w]{14,})");
        this.f541282c = f.f541328j;
        this.f541283d = "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/";
        this.f541284e = f.f541327i;
        this.f541285f = "typeReg";
        this.f541286g = "tokenReg";
        this.f541287h = "tokenPattern";
        this.f541288i = "lateastMap";
        this.f541289j = "productMap";
        Log.i("BaseDomainConfigParser", "domainConfigStr = $domainConfigStr");
        a(r100);
        c(r100);
        e();
    }

    public void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        Log.e("BaseDomainConfigParser", "parseDomainConfig()... json is empty");
        return;
    L11:
        d(new JSONObject(r100));     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
    }

    public final void c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        Log.e("BaseDomainConfigParser", "parsePathChangeConfigStr()... json is empty");
        return;
    L16:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L13
        HashMap r102 = b(r101, this.f541288i);     // Catch: JSONException -> L13
        if (r102 == null) goto L9;
        this.f541284e = r102;     // Catch: JSONException -> L13
    L9:
        HashMap r103 = b(r101, this.f541289j);     // Catch: JSONException -> L13
        if (r103 == null) goto L18;
        this.f541282c = r103;     // Catch: JSONException -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
    }

    public void d(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject(this.f541287h);
        String r102 = "/([\\w]{14,})";
        if (r101 == null) goto L11;
        this.f541283d = r101.optString(this.f541285f, "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/");
        r102 = r101.optString(this.f541286g, "/([\\w]{14,})");
    L11:
        this.f541280a = PatternProtector.compile(this.f541283d);     // Catch: Exception -> L7
        this.f541281b = PatternProtector.compile(r102);     // Catch: Exception -> L7
    L9:
        Log.i("BaseDomainConfigParser", String.format("parseProductPattern()... mTypeReg = %s\n mTokenReg = %s", new Object[]{this.f541283d, r102}));
        return;
    L7:
        e = move-exception;
        Log.e("BaseDomainConfigParser", e);
        goto L9
    }

    public static HashMap b(JSONObject r100, String r101) {
        HashMap r102 = new HashMap();
        JSONObject r103 = r100.optJSONObject(r101);
        if (r103 != null) goto L6;
        Log.i("BaseDomainConfigParser", "parseJsonObj2Map()...jsonObject = null , key = $jsonKey");
        return null;
    L6:
        Iterator<String> r104 = r103.keys();
    L8:
        if (r104.hasNext() == false) goto L10;
        String r105 = r104.next();
        r102.put(r105, r103.optString(r105));
        goto L8
    L10:
        Log.i("BaseDomainConfigParser", "parseJsonObj2Map()...map = $productMap");
        return r102;
    }
}
