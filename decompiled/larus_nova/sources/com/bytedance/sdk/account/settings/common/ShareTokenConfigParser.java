package com.bytedance.sdk.account.settings.common;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ShareTokenConfigParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f269339a = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class PathConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f269340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f269341b;

        public static final enum Type extends Enum<Type> {
            public static final Type EXACT = null;
            public static final Type GLOB = null;
            public static final Type PREFIX = null;
            public static final Type REGEX = null;
            public static final Type SUFFIX = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f269342a = null;

            static {
                Type r100 = new Type("PREFIX", 0);
                PREFIX = r100;
                Type r101 = new Type("SUFFIX", 1);
                SUFFIX = r101;
                Type r102 = new Type("EXACT", 2);
                EXACT = r102;
                Type r103 = new Type("GLOB", 3);
                GLOB = r103;
                Type r104 = new Type("REGEX", 4);
                REGEX = r104;
                f269342a = new Type[]{r100, r101, r102, r103, r104};
            }

            public static Type[] values() {
                return (Type[]) f269342a.clone();
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public Type(String r100, int r101) {
                super(r100, r101);
            }
        }

        public PathConfig(Type r100, String r101) {
            this.f269340a = r100;
            this.f269341b = r101;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f269343a;

        public a(int r100) {
            this.f269343a = r100;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f269344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f269345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PathConfig f269346c;

        public b(String r100, String r101, PathConfig r102) {
            this.f269344a = r100;
            this.f269345b = r101;
            this.f269346c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f269347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f269348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f269349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f269350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<b> f269351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f269352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f269353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f269354h;

        public c(boolean r100, boolean r101, String r102, List<String> r103, List<b> r104, List<b> r105, a r106, List<String> r107) {
            this.f269347a = r100;
            this.f269348b = r101;
            this.f269349c = r102;
            this.f269350d = r103;
            this.f269351e = r104;
            this.f269352f = r105;
            this.f269353g = r106;
            this.f269354h = r107;
        }
    }

    static {
        f269339a = Collections.unmodifiableList(new AnonymousClass1());
    }

    public static c a(JSONObject r110) {
        int r100 = 0;
        boolean r101 = r110.optBoolean("enable", false);
        boolean r102 = r110.optBoolean(GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, false);
        String r103 = r110.optString("config_version", null);
        List<String> r104 = c(r110.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.HOST_LIST), Collections.emptyList());
        List<b> r105 = b(r110.optJSONArray("white_list"));
        List<b> r106 = b(r110.optJSONArray("black_list"));
        JSONObject r107 = r110.optJSONObject("options");
        if (r107 != null) goto L6;
        a r108 = new a(16);
    L5:
        a r109 = r108;
        return new c(r101, r102, r103, r104, r105, r106, r109, c(r110.optJSONArray("monitor_exclude_path"), f269339a));
    L6:
        r107.optBoolean("blacklist_priority", true);
        r107.optBoolean("specificity_priority", true);
        int r111 = r107.optInt("max_regex", 16);
        if (r111 < 0) goto L10;
        r100 = r111;
    L10:
        r108 = new a(r100);
        goto L5
    }

    public static List<b> b(JSONArray r100) {
        if (r100 == null) goto L69;
        if (r100.length() == 0) goto L69;
        ArrayList r101 = new ArrayList(r100.length());
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L63;
        JSONObject r103 = r100.optJSONObject(r102);
        if (r103 == null) goto L61;
        b r104 = null;
        if (r103.has("host") == false) goto L17;
        String r105 = r103.optString("host", null);
        if (TextUtils.isEmpty(r105) == true) goto L17;
        String r106 = r105.trim().toLowerCase();
    L19:
        if (r103.has("domain_suffix") == false) goto L27;
        String r107 = r103.optString("domain_suffix", null);
        if (TextUtils.isEmpty(r107) == true) goto L27;
        String r108 = r107.trim().toLowerCase();
        if (TextUtils.isEmpty(r108) == true) goto L27;
        if (r108.startsWith(".") == true) goto L28;
        r108 = ".".concat(r108);
    L28:
        JSONObject r109 = r103.optJSONObject("path");
        if (r109 == null) goto L53;
        String r110 = r109.optString("type", "");
        String r111 = r109.optString("value", null);
        if (TextUtils.isEmpty(r111) == true) goto L53;
        String r112 = r111.trim();
        if (TextUtils.isEmpty(r112) == true) goto L53;
        if ("prefix".equalsIgnoreCase(r110) == false) goto L40;
        PathConfig.Type r113 = PathConfig.Type.PREFIX;
    L52:
        PathConfig r114 = new PathConfig(r113, r112);
    L54:
        if (r106 != null) goto L58;
        if (r108 != null) goto L58;
        if (r114 != null) goto L58;
    L59:
        if (r104 == null) goto L61;
        r101.add(r104);
    L58:
        r104 = new b(r106, r108, r114);
        goto L59
    L40:
        if ("suffix".equalsIgnoreCase(r110) == false) goto L43;
        r113 = PathConfig.Type.SUFFIX;
        goto L52
    L43:
        if ("exact".equalsIgnoreCase(r110) == false) goto L46;
        r113 = PathConfig.Type.EXACT;
        goto L52
    L46:
        if ("glob".equalsIgnoreCase(r110) == false) goto L49;
        r113 = PathConfig.Type.GLOB;
        goto L52
    L49:
        if ("regex".equalsIgnoreCase(r110) == false) goto L51;
        r113 = PathConfig.Type.REGEX;
        goto L52
    L51:
        r113 = PathConfig.Type.PREFIX;
    L53:
        r114 = null;
    L27:
        r108 = null;
    L17:
        r106 = null;
    L61:
        r102 = r102 + 1;
        goto L8
    L63:
        if (r101.isEmpty() == false) goto L67;
        return Collections.emptyList();
    L67:
        return Collections.unmodifiableList(r101);
    L69:
        return Collections.emptyList();
    }

    public static List<String> c(JSONArray r100, List<String> r101) {
        if (r100 != null) goto L4;
    L21:
        return r101;
    L4:
        if (r100.length() == 0) goto L21;
        ArrayList r102 = new ArrayList(r100.length());
        int r103 = 0;
    L8:
        if (r103 >= r100.length()) goto L17;
        String r104 = r100.optString(r103, null);
        if (TextUtils.isEmpty(r104) == true) goto L15;
        String r105 = r104.trim().toLowerCase();
        if (TextUtils.isEmpty(r105) == true) goto L15;
        r102.add(r105);
    L15:
        r103 = r103 + 1;
        goto L8
    L17:
        if (r102.isEmpty() == false) goto L20;
        return r101;
    L20:
        return Collections.unmodifiableList(r102);
    }
}
