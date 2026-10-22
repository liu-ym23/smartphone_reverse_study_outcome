package com.bytedance.frameworks.baselib.network.config.hostpathmatch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.c;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T extends c> {
    private static final String TAG = "TTHostPathMatchRule";
    private T mDefaultValue;
    protected final AtomicBoolean mEnable;
    private final List<Pair<a, T>> mRuleList;

    public abstract String getConfigRootKey();

    public abstract T parseHostPathValue(Object r100);

    public boolean parseSpecificConfig(JSONObject r100) {
        return true;
    }

    public boolean isEnabled() {
        return this.mEnable.get();
    }

    public b() {
        this.mEnable = new AtomicBoolean(false);
        this.mRuleList = new CopyOnWriteArrayList();
    }

    public List<Pair<a, T>> getmRuleList() {
        return this.mRuleList;
    }

    public T getValue(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L105:
        return null;
    L5:
        if (this.mEnable.get() == false) goto L105;
        Uri r111 = UriProtector.parse(r110);
        if (r111 != null) goto L10;
        return null;
    L10:
        String r100 = r111.getHost();
        String r112 = r111.getPath();
        if (TextUtils.isEmpty(r100) == true) goto L105;
        if (TextUtils.isEmpty(r112) == true) goto L105;
        Iterator<Pair<a, T>> r101 = this.mRuleList.iterator();
    L17:
        if (r101.hasNext() == false) goto L101;
        Pair<a, T> r102 = r101.next();
        if (r102 == null) goto L17;
        a r103 = (a) r102.first;
        if (r103 == null) goto L17;
        Set<String> r104 = r103.f244642a;
        boolean r105 = false;
        boolean r106 = true;
        if (r104 != null) goto L27;
    L32:
        boolean r107 = false;
    L33:
        if (r107 == true) goto L45;
        Set<String> r108 = r103.f244643b;
        if (r108 == null) goto L45;
        Iterator<String> r109 = r108.iterator();
    L38:
        if (r109.hasNext() == false) goto L45;
        if (UrlUtils.matchPattern(r100, r109.next()) == false) goto L38;
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "hitRule: host_wc.");
    L44:
        r107 = true;
    L45:
        if (r107 == false) goto L101;
        Set<String> r113 = r103.f244644c;
        if (r113 != null) goto L50;
    L55:
        if (r105 == true) goto L67;
        Set<String> r114 = r103.f244645d;
        if (r114 == null) goto L67;
        Iterator<String> r115 = r114.iterator();
    L60:
        if (r115.hasNext() == false) goto L67;
        if (r112.startsWith(r115.next()) == false) goto L60;
        if (Logger.debug() == false) goto L66;
        Logger.d(TAG, "hitRule: path_prefix.");
    L66:
        r105 = true;
    L67:
        if (r105 == true) goto L79;
        Set<String> r116 = r103.f244646e;
        if (r116 == null) goto L79;
        Iterator<String> r117 = r116.iterator();
    L72:
        if (r117.hasNext() == false) goto L79;
        if (r112.contains(r117.next()) == false) goto L72;
        if (Logger.debug() == false) goto L78;
        Logger.d(TAG, "hitRule: path_contain.");
    L78:
        r105 = true;
    L79:
        if (r105 == true) goto L95;
        Set<Pattern> r118 = r103.f244647f;
        if (r118 == null) goto L95;
        Iterator r119 = ((HashSet) r118).iterator();
    L84:
        if (r119.hasNext() == false) goto L95;
        Pattern r120 = (Pattern) r119.next();
        if (r120 == null) goto L84;
        if (r120.matcher(r112).matches() == false) goto L84;
    L93:
        r105 = true;
        goto L84
    L90:
        if (Logger.debug() == false) goto L96;
        Logger.d(TAG, "hitRule: path_pattern.");     // Catch: Throwable -> L93
    L96:
        if (r106 == false) goto L17;
        return (T) r102.second;
    L95:
        r106 = r105;
        goto L96
    L50:
        if (r113.contains(r112) == false) goto L55;
        if (Logger.debug() == false) goto L54;
        Logger.d(TAG, "hitRule: path_eq.");
    L54:
        r105 = true;
        goto L55
    L27:
        if (r104.contains(r100) == false) goto L32;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "hitRule: host_eq.");
    L31:
        r107 = true;
    L101:
        if (Logger.debug() == false) goto L104;
        Logger.d(TAG, "use default config");
    L104:
        return this.mDefaultValue;
    }

    public Set<String> parseJSONArrayToSet(JSONArray r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 0) goto L19;
        HashSet r101 = new HashSet();
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L13;
        String r103 = r100.optString(r102);
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r101.add(r103);
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        return r101;
    L19:
        return null;
    }

    public boolean parseTNCConfig(JSONObject r100) {
        int r101 = 0;
        this.mEnable.set(false);
        this.mRuleList.clear();
        if (r100 != null) goto L5;
    L96:
        return false;
    L5:
        if (r100.length() == 0) goto L96;
        JSONObject r102 = r100.optJSONObject(getConfigRootKey());
        if (r102 != null) goto L10;
    L95:
        return true;
    L10:
        if (r102.length() == 0) goto L95;
        AtomicBoolean r103 = this.mEnable;
        if (r102.optInt("enabled", 0) <= 0) goto L15;
        boolean r104 = true;
    L16:
        r103.set(r104);
        if (this.mEnable.get() == true) goto L20;
        return true;
    L20:
        if (parseSpecificConfig(r102) == true) goto L22;
        return false;
    L22:
        Object r105 = r102.opt("default");
        if (r105 == null) goto L25;
        this.mDefaultValue = (T) parseHostPathValue(r105);
    L25:
        JSONArray r106 = r102.optJSONArray("rule_list");
        if (r106 != null) goto L28;
    L94:
        return false;
    L28:
        if (r106.length() == 0) goto L94;
    L31:
        if (r101 >= r106.length()) goto L93;
        JSONObject r107 = r106.optJSONObject(r101);
        if (r107 == null) goto L92;
        if (r107.length() == 0) goto L92;
        a r108 = new a();
        r108.f244642a = parseJSONArrayToSet(r107.optJSONArray("host_eq"));
        r108.f244643b = parseJSONArrayToSet(r107.optJSONArray("host_wc"));
        Set<String> r109 = r108.f244642a;
        if (r109 != null) goto L40;
    L41:
        Set<String> r110 = r108.f244643b;
        if (r110 == null) goto L90;
        if (r110.isEmpty() == true) goto L90;
    L46:
        r108.f244644c = parseJSONArrayToSet(r107.optJSONArray("path_eq"));
        r108.f244645d = parseJSONArrayToSet(r107.optJSONArray("path_prefix"));
        r108.f244646e = parseJSONArrayToSet(r107.optJSONArray("path_contain"));
        Set<String> r111 = parseJSONArrayToSet(r107.optJSONArray("path_pattern"));
        if (r111 == null) goto L55;
        r108.f244647f = new HashSet();
        Iterator<String> r112 = r111.iterator();
    L50:
        if (r112.hasNext() == false) goto L55;
        String r113 = r112.next();
        r108.f244647f.add(PatternProtector.compile(r113));     // Catch: Throwable -> L54
    L55:
        Set<String> r114 = r108.f244644c;
        if (r114 != null) goto L58;
    L59:
        Set<String> r115 = r108.f244645d;
        if (r115 != null) goto L62;
    L63:
        Set<String> r116 = r108.f244646e;
        if (r116 != null) goto L66;
    L67:
        Set<Pattern> r117 = r108.f244647f;
        if (r117 == null) goto L87;
        if (r117.isEmpty() == true) goto L87;
    L72:
        Object r118 = r107.opt("value");
        if (r118 == null) goto L75;
        c r119 = parseHostPathValue(r118);
        if (r119 == null) goto L80;
        String r120 = r107.optString("sign");
        if (TextUtils.isEmpty(r120) == true) goto L85;
        r119.sign = r120;
    L85:
        this.mRuleList.add(new Pair(r108, r119));
        goto L92
    L80:
        if (Logger.debug() == false) goto L92;
        Logger.d(TAG, "ParseHostPathValue failed.");
        goto L92
    L75:
        if (Logger.debug() == false) goto L92;
        Logger.d(TAG, "value is null.");
    L87:
        if (Logger.debug() == false) goto L92;
        Logger.d(TAG, "no path filter exist.");
        goto L92
    L66:
        if (r116.isEmpty() == false) goto L72;
    L62:
        if (r115.isEmpty() == false) goto L72;
    L58:
        if (r114.isEmpty() == false) goto L72;
    L90:
        if (Logger.debug() == false) goto L92;
        Logger.d(TAG, "both host_eq and host_wc empty.");
        goto L92
    L40:
        if (r109.isEmpty() == false) goto L46;
    L92:
        r101 = r101 + 1;
        goto L31
    L93:
        return true;
    L15:
        r104 = false;
        goto L16
    }

    public void setEnabled(boolean r100) {
        this.mEnable.set(r100);
    }
}
