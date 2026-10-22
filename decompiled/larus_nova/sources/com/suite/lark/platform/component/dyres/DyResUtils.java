package com.suite.lark.platform.component.dyres;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class DyResUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f460577a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/dyres/DyResUtils$ResI18n;", "", "Companion", "dyres_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResI18n {
        public static final a Companion = null;
        public static final String de_DE = "de_DE";
        public static final String en_US = "en_US";
        public static final String es_ES = "es_ES";
        public static final String fr_FR = "fr_FR";
        public static final String hi_IN = "hi_IN";

        /* JADX INFO: renamed from: in, reason: collision with root package name */
        public static final String f460578in = "in";
        public static final String it_IT = "it_IT";
        public static final String ja_JP = "ja_JP";
        public static final String ko_KR = "ko_KR";
        public static final String pt_BR = "pt_BR";
        public static final String ru_RU = "ru_RU";
        public static final String th_TH = "th_TH";
        public static final String vi_VN = "vi_VN";
        public static final String zh_CN = "zh_CN";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f460579a = null;

            static {
                f460579a = new a();
            }

            public a() {
            }

            public static List a() {
                return CollectionsKt.listOf(new String[]{"zh_CN", ResI18n.en_US, ResI18n.ja_JP, ResI18n.de_DE, ResI18n.es_ES, ResI18n.fr_FR, ResI18n.hi_IN, "in", ResI18n.it_IT, ResI18n.ko_KR, ResI18n.pt_BR, ResI18n.ru_RU, ResI18n.th_TH, ResI18n.vi_VN});
            }
        }

        static {
            Companion = a.f460579a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/dyres/DyResUtils$ResType;", "", "Companion", "dyres_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResType {
        public static final a Companion = null;
        public static final int IMAGE = 2;
        public static final int TEXT = 1;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f460580a = null;

            static {
                f460580a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f460580a;
        }
    }

    public static final class a {
        public static String a(Locale r100) {
            StringBuilder r101 = new StringBuilder();
            r101.append(r100.getLanguage().toLowerCase());
            if (r100.getCountry().length() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            String r103 = "";
        L9:
            r101.append(r103);
            return r101.toString();
        L8:
            r103 = "_" + r100.getCountry().toUpperCase();
            goto L9
        L5:
            r102 = false;
            goto L6
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f460581a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f460582a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f460583b;

            static {
                f460582a = new a();
            }

            public a() {
            }
        }

        static {
            f460581a = a.f460582a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f460584c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f460585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, String> f460586b;

        public static final class a {
            public static c a(JSONObject r100) {
                Intrinsics.checkNotNullParameter("upload_contacts_max_num", "valueKey");
                Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                JSONObject r101 = r100.optJSONObject("value");     // Catch: JSONException -> L40
                if (r101 != null) goto L6;
                return null;
            L6:
                String r102 = r100.optString("type");     // Catch: JSONException -> L40
                c r103 = new c();     // Catch: JSONException -> L40
                ResType.a r104 = ResType.Companion;     // Catch: JSONException -> L40
                Intrinsics.checkNotNull(r102);     // Catch: JSONException -> L40
                r104.getClass();     // Catch: JSONException -> L40
                Intrinsics.checkNotNullParameter(r102, "value");     // Catch: JSONException -> L40
                int r105 = r102.hashCode();     // Catch: JSONException -> L40
                if (r105 == 3556653) goto L22;
                if (r105 == 100313435) goto L18;
                if (r105 == 112202875) goto L14;
            L23:
                int r106 = 0;
            L25:
                r103.f460585a = r106;     // Catch: JSONException -> L40
                ResI18n.Companion.getClass();     // Catch: JSONException -> L40
                Iterator r107 = ResI18n.a.a().iterator();     // Catch: JSONException -> L40
            L26:
                if (r107.hasNext() == false) goto L39;
                String r108 = (String) r107.next();     // Catch: JSONException -> L40
                String r109 = r101.optString(r108);     // Catch: JSONException -> L40
                if (r109 != null) goto L31;
            L34:
                boolean r110 = true;
            L35:
                if (r110 == true) goto L26;
                r103.f460586b.put(r108, r109);     // Catch: JSONException -> L40
                goto L26
            L31:
                if (r109.length() == 0) goto L34;
                r110 = false;
                goto L35
            L39:
                return r103;
            L14:
                if (r102.equals("video") == false) goto L23;
                r106 = 3;
                goto L25
            L18:
                if (r102.equals("image") == false) goto L23;
                r106 = 2;
                goto L25
            L22:
                if (r102.equals("text") == false) goto L23;
                r106 = 1;
            L40:
                return null;
            }
        }

        static {
        }

        public c() {
            this.f460586b = new HashMap();
        }

        public final int getType() {
            return this.f460585a;
        }
    }

    static {
    }
}
