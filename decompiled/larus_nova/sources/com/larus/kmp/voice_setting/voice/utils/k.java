package com.larus.kmp.voice_setting.voice.utils;

import com.larus.im.FlowRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceSettingLogLevel f355105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f355106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f355107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f355108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f355109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<n, Object> f355110g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355111a = null;

        static {
            int[] r100 = new int[VoiceSettingLogLevel.values().length];
            r100[VoiceSettingLogLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VoiceSettingLogLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f355111a = r100;
        }
    }

    public static void a(final k r110) {
        String r100 = "";
        Intrinsics.checkNotNullParameter("", "file");
        Intrinsics.checkNotNullParameter("", "function");
        boolean r101 = false;
        if ("".length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L11:
        r100 = " [,,-1]";
    L12:
        StringBuilder r103 = new StringBuilder();
        ArrayList r104 = new ArrayList();
        r104.add("<What=" + c(r110.f355106c) + Typography.greater);
        Map<n, Object> r105 = r110.f355110g;
        List<String> r106 = null;
        if ((!r105.isEmpty()) == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L29;
        StringBuilder r107 = new StringBuilder("<Params=");
        ArrayList r111 = new ArrayList(r105.size());
        Iterator<Map.Entry<n, Object>> r108 = r105.entrySet().iterator();
    L19:
        if (r108.hasNext() == false) goto L28;
        Map.Entry<n, Object> r109 = r108.next();
        n r112 = r109.getKey();
        Object r113 = r109.getValue();
        String r114 = "\"" + c(r112.f355116a) + Typography.quote;
        if ((r113 instanceof String) == false) goto L24;
        String r115 = "\"" + c((String) r113) + Typography.quote;
    L27:
        r111.add(r114 + ':' + r115);
        goto L19
    L24:
        if ((r113 instanceof Number) == false) goto L26;
        r115 = r113.toString();
        goto L27
    L26:
        r115 = "\"" + c(r113.toString()) + Typography.quote;
        goto L27
    L28:
        r107.append("{" + CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, null, 62, null) + '}');
        r107.append(Typography.greater);
        r104.add(r107.toString());
    L29:
        String r116 = r110.f355109f;
        if (r116 == null) goto L32;
        r104.add("<Who=" + c(r116) + Typography.greater);
    L32:
        String r117 = r110.f355108e;
        if (r117 == null) goto L35;
        r104.add("<Where=" + c(r117) + Typography.greater);
    L35:
        List<String> r118 = r110.f355107d;
        if (r118 != null) goto L38;
    L42:
        r103.append(CollectionsKt.joinToString$default(r104, "", null, null, 0, null, null, 62, null));
        r103.append(r100);
        String r119 = r103.toString();
        gd9.h r120 = FlowRuntime.b().e();
        int r121 = a.f355111a[r110.f355105b.ordinal()];
        if (r121 != 1) goto L45;
        r120.i(r110.f355104a, r119);
        return;
    L45:
        if (r121 != 2) goto L48;
        r120.e(r110.f355104a, r119);
        return;
    L48:
        throw new NoWhenBranchMatchedException();
    L38:
        if ((!r118.isEmpty()) == false) goto L40;
        r106 = r118;
    L40:
        if (r106 == null) goto L42;
        r104.add("<LinkID=" + CollectionsKt.joinToString$default(r106, ",", null, null, 0, null, new j(r110), 30, null) + Typography.greater);
        goto L42
    L8:
        if ("".length() <= 0) goto L10;
        r101 = true;
    L10:
        if (r101 == false) goto L12;
    L5:
        r102 = false;
        goto L6
    }

    public static String c(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "<", "", false, 4, null), ">", "", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        LinkedHashMap r101 = new LinkedHashMap();
        r100.invoke(r101);
        this.f355110g.putAll(r101);
    }

    public k(String r100, VoiceSettingLogLevel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r102, "what");
        this.f355104a = r100;
        this.f355105b = r101;
        this.f355106c = r102;
        this.f355110g = new LinkedHashMap();
    }
}
