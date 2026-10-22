package com.ss.android.lark.conditional.access.display;

import android.content.Context;
import android.util.Base64;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.commonmark.html.HtmlCompatMarkdownParser;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.coremd.base.parse.n;
import com.ss.android.lark.coremd.impl.parse.l;
import com.ss.android.lark.coremdbiz.facade.plugins.u;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class DisplayUtilsKt {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/conditional/access/display/DisplayUtilsKt$parseB64Extra$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/conditional/access/display/DisplayUtilsKt$parseDisplayExtra$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    public static final class c implements com.ss.android.lark.coremd.base.parse.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<n, Unit> f418052a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super n, Unit> r100) {
            this.f418052a = r100;
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void a(l.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
            this.f418052a.invoke(r100);
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void c(com.ss.android.lark.coremd.impl.parse.j.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
        }

        @Override // com.ss.android.lark.coremd.base.parse.g
        public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
            Intrinsics.checkNotNullParameter(r100, "registry");
        }
    }

    public static final class d implements com.ss.android.lark.commonmark.html.a {
        public d() {
        }

        @Override // com.ss.android.lark.commonmark.html.a
        public final s a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "tagName");
            Intrinsics.checkNotNullParameter(r101, "attributes");
            if (Intrinsics.areEqual(r100, SRStrategy.MEDIAINFO_KEY_BITRATE) == false) goto L7;
            return new v7b.h();
        L7:
            if (Intrinsics.areEqual(r100, INotificationHitPoint.NoticeType.AT) == false) goto L24;
            String r102 = (String) r101.get("data-user-name");
            String r103 = (String) r101.get("data-user-id");
            boolean r104 = true;
            if (r102 != null) goto L11;
        L14:
            boolean r105 = true;
        L15:
            if (r105 == true) goto L24;
            if (r103 != null) goto L18;
        L21:
            if (r104 == true) goto L24;
            return new eab.a(StringsKt.removePrefix(r102, "@"), r103);
        L18:
            if (r103.length() == 0) goto L21;
            r104 = false;
            goto L21
        L11:
            if (r102.length() == 0) goto L14;
            r105 = false;
        L24:
            return null;
        }
    }

    public static final Map<String, String> a(InternalSecurityAction r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getCurrentAction().getParams().get("b64Extra");
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = new String(Base64.decode(r101, 0), Charsets.UTF_8);
        Gson r103 = e0.f444707a;
        Map<String, String> r104 = (Map) e0.b(r102, new a().getType());
        if (r104 == null) goto L11;
        return r104;
    L11:
        return MapsKt.emptyMap();
    L4:
        return MapsKt.emptyMap();
    }

    public static final Map<String, String> b(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        String r101 = r100.getCurrentAction().getParams().get("displayExtra");
        Gson r102 = e0.f444707a;
        Map<String, String> r103 = (Map) e0.b(r101, new b().getType());
        if (r103 == null) goto L5;
        return r103;
    L5:
        return MapsKt.emptyMap();
    }

    public static final Integer c(InternalSecurityAction r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r100.getCurrentAction().getParams().get("b64Extra");
        if (r102 != null) goto L9;
        return null;
    L9:
        if (StringsKt.isBlank(r102) == false) goto L35;
        return null;
    L35:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        JsonElement r104 = JsonParser.parseString(new String(Base64.decode(r102, 0), Charsets.UTF_8)).getAsJsonObject().get("geoChallengeType");     // Catch: Throwable -> L27
        if (r104 != null) goto L15;
        return null;
    L15:
        if (r104.isJsonPrimitive() == false) goto L20;
        if (r104.getAsJsonPrimitive().isNumber() == false) goto L20;
        Integer r105 = Integer.valueOf(r104.getAsInt());     // Catch: Throwable -> L27
    L25:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r106) == true) goto L34;
        r101 = r106;
    L34:
        return (Integer) r101;
    L20:
        if (r104.isJsonPrimitive() == true) goto L22;
    L24:
        r105 = null;
        goto L25
    L22:
        if (r104.getAsJsonPrimitive().isString() == false) goto L24;
        r105 = StringsKt.toIntOrNull(r104.getAsString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static final String d(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "display");
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r101.isEmpty() == false) goto L5;
        return r100;
    L5:
        String r102 = UIHelper.mustacheFormat(r100, r101);
        Intrinsics.checkNotNull(r102);
        if (StringsKt.contains$default(r102, "{{", false, 2, null) == false) goto L8;
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModel", "replaceDisplayExtra remain {{}}, display: " + r100 + ", extra: " + r101 + ", result: " + r102);
        FileAuthMonitor.UpdateTrigger[] r104 = FileAuthMonitor.f418450a;
        FileAuthMonitor.e(401, r102);
    L8:
        return r102;
    }

    public static final CustomDisplayTemplate e(CustomDisplayTemplate r110, InternalSecurityAction r111) {
        Intrinsics.checkNotNullParameter(r110, "originalTemplate");
        Intrinsics.checkNotNullParameter(r111, "action");
        Map r100 = MapsKt.toMutableMap(b(r111));
        r100.putAll(a(r111));
        CustomDisplayTemplate.Builder r112 = r110.newBuilder().title(d(r110.title, r100)).text(d(r110.text, r100));
        String r101 = r110.richText;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        CustomDisplayTemplate.Builder r113 = r112.richText(d(r101, r100));
        String r102 = r110.sub_text;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        CustomDisplayTemplate.Builder r114 = r113.sub_text(d(r102, r100));
        List<CustomDisplayContent> r103 = r110.content_list;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L27;
        CustomDisplayContent r106 = (CustomDisplayContent) r105.next();
        CustomDisplayContent.Builder r107 = r106.newBuilder().title(d(r106.title, r100)).text(d(r106.text, r100));
        String r108 = r106.richText;
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        CustomDisplayContent.Builder r109 = r107.richText(d(r108, r100));
        List<CustomDisplayHandler> r115 = r106.handler_list;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r117 = r115.iterator();
    L16:
        if (r117.hasNext() == false) goto L26;
        CustomDisplayHandler r118 = (CustomDisplayHandler) r117.next();
        CustomDisplayHandler.Builder r119 = r118.newBuilder().name(d(r118.name, r100));
        Map<String, String> r120 = r118.link;
        LinkedHashMap r121 = new LinkedHashMap(MapsKt.mapCapacity(r120.size()));
        Iterator<T> r122 = r120.entrySet().iterator();
    L19:
        if (r122.hasNext() == false) goto L21;
        Map.Entry r123 = (Map.Entry) r122.next();
        r121.put(r123.getKey(), d((String) r123.getValue(), r100));
        goto L19
    L21:
        CustomDisplayHandler.Builder r124 = r119.link(r121);
        Map<String, String> r125 = r118.params;
        LinkedHashMap r126 = new LinkedHashMap(MapsKt.mapCapacity(r125.size()));
        Iterator<T> r127 = r125.entrySet().iterator();
    L23:
        if (r127.hasNext() == false) goto L25;
        Map.Entry r128 = (Map.Entry) r127.next();
        r126.put(r128.getKey(), d((String) r128.getValue(), r100));
        goto L23
    L25:
        r116.add(r124.params(r126).build());
        goto L16
    L26:
        r104.add(r109.handler_list(r116).build());
        goto L10
    L27:
        CustomDisplayTemplate.Builder r129 = r114.content_list(r104);
        List<CustomDisplayHandler> r130 = r110.handler_list;
        ArrayList r131 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r130, 10));
        Iterator<T> r132 = r130.iterator();
    L29:
        if (r132.hasNext() == false) goto L39;
        CustomDisplayHandler r133 = (CustomDisplayHandler) r132.next();
        CustomDisplayHandler.Builder r134 = r133.newBuilder().name(d(r133.name, r100));
        Map<String, String> r135 = r133.link;
        LinkedHashMap r136 = new LinkedHashMap(MapsKt.mapCapacity(r135.size()));
        Iterator<T> r137 = r135.entrySet().iterator();
    L32:
        if (r137.hasNext() == false) goto L34;
        Map.Entry r138 = (Map.Entry) r137.next();
        r136.put(r138.getKey(), d((String) r138.getValue(), r100));
        goto L32
    L34:
        CustomDisplayHandler.Builder r139 = r134.link(r136);
        Map<String, String> r140 = r133.params;
        LinkedHashMap r141 = new LinkedHashMap(MapsKt.mapCapacity(r140.size()));
        Iterator<T> r142 = r140.entrySet().iterator();
    L36:
        if (r142.hasNext() == false) goto L38;
        Map.Entry r143 = (Map.Entry) r142.next();
        r141.put(r143.getKey(), d((String) r143.getValue(), r100));
        goto L36
    L38:
        r131.add(r139.params(r141).build());
        goto L29
    L39:
        CustomDisplayTemplate r144 = r129.handler_list(r131).build();
        Intrinsics.checkNotNull(r144);
        return r144;
    }

    public static /* synthetic */ CharSequence g(String r100, final Context r101) {
        return f(r100, r101, new DisplayUtilsKt$transRichText$1(r101));
    }

    public static final CharSequence f(String r100, Context r101, Function1<? super n, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "clickRegistry");
        boolean r103 = idb.f.a().isEnable("im.richtext.link.inline_render");
        t9b.a r104 = t9b.a.f545142a;
        HtmlCompatMarkdownParser r105 = new HtmlCompatMarkdownParser();
        d r106 = new d();
        if (r105.f417156a == r103) goto L5;
        r105.f417156a = r103;
        r105.f417159d = null;
    L5:
        r105.a(r106);
        s r107 = r105.b(r100);
        t9b.b r108 = t9b.b.f545143a;
        com.ss.android.lark.coremd.impl.parse.b.a r109 = t9b.b.a(r101);
        t9b.e r110 = t9b.e.f545146a;
        r109.c(com.ss.android.lark.coremdbiz.facade.a.a(DisplayUtilsKt$transRichText$2.INSTANCE));
        Intrinsics.checkNotNullParameter(t9b.d.f545145a, "<this>");
        r109.e(u.f420163a);
        r109.e(new c(r102));
        if (w4c.c.a().R() == false) goto L9;
        r109.b(new j());
    L9:
        return r109.d(r107);
    }
}
