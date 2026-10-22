package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.net.Uri;
import androidx.core.text.HtmlCompat;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class MentionSearchRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MentionSearchRepository f298887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f298888b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298889a = null;

        static {
            int[] r100 = new int[MentionSearchResultType.values().length];
            r100[MentionSearchResultType.DRIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[MentionSearchResultType.CONTACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[MentionSearchResultType.CONVERSATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MentionSearchResultType.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[MentionSearchResultType.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f298889a = r100;
        }
    }

    public MentionSearchRepository() {
    }

    static {
        f298887a = new MentionSearchRepository();
        f298888b = new Gson();
    }

    public static List a(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L6:
        if (r102 >= r100.length()) goto L25;
        int r103 = StringsKt.indexOf$default(r100, "<h>", r102, false, 4, null);
        if (r103 < 0) goto L25;
        int r104 = r103 + 3;
        int r105 = StringsKt.indexOf$default(r100, "</h>", r104, false, 4, null);
        if (r105 < 0) goto L25;
        String r106 = c(r100.substring(r104, r105));
        boolean r107 = true;
        if ((!StringsKt.isBlank(r106)) == false) goto L24;
        if (r101.isEmpty() == true) goto L22;
        Iterator r108 = r101.iterator();
    L18:
        if (r108.hasNext() == false) goto L22;
        if (StringsKt.equals((String) r108.next(), r106, true) == false) goto L18;
        r107 = false;
    L22:
        if (r107 == false) goto L24;
        r101.add(r106);
    L24:
        r102 = r105 + 4;
    L25:
        return r101;
    }

    public static boolean b(String r100) {
        if (StringsKt.startsWith(r100, "https://", true) != true) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        if (StringsKt.startsWith(r100, "http://", true) != true) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public static String c(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return StringsKt.trim(HtmlCompat.fromHtml(r100, 0).toString()).toString();
    }

    public static MentionSearchResultType i(t0 r100) {
        MentionSearchResultType.a r101 = MentionSearchResultType.Companion;
        int r102 = r100.b();
        r101.getClass();
        MentionSearchResultType r103 = MentionSearchResultType.a.a(r102);
        int r104 = 0;
        if (r103 != MentionSearchResultType.UNKNOWN) goto L5;
        boolean r105 = true;
    L6:
        MentionSearchResultType r106 = null;
        if (r105 == false) goto L10;
        r103 = null;
    L10:
        if (r103 != null) goto L27;
        String r107 = r100.a();
        MentionSearchResultType[] r108 = MentionSearchResultType.values();
        int r109 = r108.length;
    L12:
        if (r104 >= r109) goto L21;
        MentionSearchResultType r110 = r108[r104];
        MentionSearchDomain r111 = r110.getDomain();
        if (r111 == null) goto L16;
        String r112 = r111.getKey();
    L18:
        if (Intrinsics.areEqual(r112, r107) == true) goto L19;
        r104 = r104 + 1;
        goto L12
    L19:
        r106 = r110;
        goto L21
    L16:
        r112 = null;
    L21:
        if (r106 != null) goto L24;
        return MentionSearchResultType.UNKNOWN;
    L24:
        return r106;
    L27:
        return r103;
    L5:
        r105 = false;
        goto L6
    }

    public final Object d(String r100, Continuation<? super f0> r101) {
        if ((r101 instanceof MentionSearchRepository$queryContacts$1) == false) goto L7;
        MentionSearchRepository$queryContacts$1 r102 = (MentionSearchRepository$queryContacts$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        f0 r107 = (f0) r104;
        if (r107 == null) goto L20;
        return r107;
    L20:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List<? extends MentionSearchDomain> r108 = CollectionsKt.listOf(MentionSearchDomain.CONTACT);
        r102.label = 1;
        r104 = e(r100, r108, MapsKt.emptyMap(), r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new MentionSearchRepository$queryContacts$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v41, types: [java.util.ArrayList] */
    public final Object h(boolean r210, Continuation<? super f0> r310) {
        if ((r310 instanceof MentionSearchRepository$recommend$1) == false) goto L7;
        MentionSearchRepository$recommend$1 r100 = (MentionSearchRepository$recommend$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MentionSearchRepository$recommend$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        boolean r105 = r110.Z$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
        boolean r107 = r105;
        boolean r108 = true;
    L21:
        v0 r109 = (v0) ((com.larus.network.http.a) r106).f360135b;
        if (r109 == null) goto L24;
        List<y0> r111 = r109.a();
        if (r111 == null) goto L74;
        List r112 = CollectionsKt.filterNotNull(r111);
        if (r112 == null) goto L74;
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L31:
        if (r114.hasNext() == false) goto L40;
        Object r115 = r114.next();
        y0 r116 = (y0) r115;
        if (r107 == true) goto L35;
    L37:
        boolean r117 = false;
    L38:
        if (r117 == false) goto L31;
        r113.add(r115);
        goto L31
    L35:
        if (r116.b() != MentionSearchResultType.GROUP.getProtocolValue()) goto L37;
        r117 = true;
        goto L38
    L40:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r113.iterator();
    L42:
        if (r119.hasNext() == false) goto L47;
        List<x0> r120 = ((y0) r119.next()).a();
        if (r120 != null) goto L46;
        r120 = CollectionsKt.emptyList();
    L46:
        CollectionsKt.addAll(r118, CollectionsKt.filterNotNull(r120));
        goto L42
    L47:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r118.iterator();
    L49:
        if (r122.hasNext() == false) goto L68;
        x0 r123 = (x0) r122.next();
        Regex r124 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.f298733a;
        w0 r125 = r123.a();
        if (r125 == null) goto L53;
        String r126 = r125.e();
    L54:
        String r127 = c(r123.c());
        w0 r128 = r123.a();
        if (r128 == null) goto L57;
        String r129 = r128.a();
    L58:
        w0 r130 = r123.a();
        if (r130 == null) goto L61;
        String r131 = r130.b();
    L62:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r132 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.e(r126, r127, r129, r131);
        if (r132 == null) goto L65;
        c1 r133 = new c1(r132, null, null, 6);
    L66:
        if (r133 == null) goto L49;
        r121.add(r133);
        goto L49
    L65:
        r133 = null;
        goto L66
    L61:
        r131 = null;
        goto L62
    L57:
        r129 = null;
        goto L58
    L53:
        r126 = null;
        goto L54
    L68:
        HashSet r134 = new HashSet();
        ?? r135 = new ArrayList();
        Iterator r136 = r121.iterator();
    L70:
        if (r136.hasNext() == false) goto L75;
        Object r137 = r136.next();
        if (r134.add(((c1) r137).f298904a.f298715a) == false) goto L70;
        r135.add(r137);
    L75:
        if (r135 != 0) goto L77;
        r135 = CollectionsKt.emptyList();
    L77:
        ?? r138 = r135;
        List<y0> r139 = r109.a();
        if (r139 == null) goto L170;
        List r140 = CollectionsKt.filterNotNull(r139);
        if (r140 == null) goto L170;
        ArrayList r141 = new ArrayList();
        Iterator r142 = r140.iterator();
    L83:
        if (r142.hasNext() == false) goto L90;
        Object r143 = r142.next();
        if (((y0) r143).b() != MentionSearchResultType.DRIVE.getProtocolValue()) goto L87;
        boolean r144 = true;
    L88:
        if (r144 == false) goto L83;
        r141.add(r143);
        goto L83
    L87:
        r144 = false;
        goto L88
    L90:
        ArrayList r145 = new ArrayList();
        Iterator r146 = r141.iterator();
    L92:
        if (r146.hasNext() == false) goto L97;
        List<x0> r147 = ((y0) r146.next()).a();
        if (r147 != null) goto L96;
        r147 = CollectionsKt.emptyList();
    L96:
        CollectionsKt.addAll(r145, CollectionsKt.filterNotNull(r147));
        goto L92
    L97:
        ArrayList r148 = new ArrayList();
        Iterator r149 = r145.iterator();
    L99:
        if (r149.hasNext() == false) goto L163;
        x0 r150 = (x0) r149.next();
        String r151 = r150.b();
        if (r151 != null) goto L103;
    L105:
        boolean r152 = false;
    L106:
        if (r152 == false) goto L108;
        String r211 = r151;
    L109:
        if (r211 == null) goto L124;
        String r153 = r150.c();
        if (r153 == null) goto L114;
        String r154 = c(r153);
    L115:
        if (r154 != null) goto L117;
    L119:
        boolean r155 = false;
    L120:
        if (r155 == false) goto L122;
        String r156 = r154;
    L123:
        if (r156 == null) goto L124;
        InputReferenceType r157 = InputReferenceType.DRIVE;
        w0 r158 = r150.a();
        if (r158 == null) goto L132;
        String r159 = r158.c();
        if (r159 == null) goto L132;
        if (b(r159) == false) goto L132;
        String r212 = r159;
    L133:
        w0 r160 = r150.a();
        if (r160 == null) goto L140;
        String r161 = r160.d();
        if (r161 == null) goto L140;
        Integer r162 = StringsKt.toIntOrNull(r161);
        if (r162 == null) goto L140;
        int r163 = r162.intValue();
    L141:
        String r164 = r150.b();
        if (r164 != null) goto L144;
        r164 = "";
    L144:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r165 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r211, r156, r157, r211, r212, new com.larus.bmhome.chat.component.bottom.core.inputtext.i0(r163, r164, 5), null, null, null, null, 960);
    L145:
        if (r165 == null) goto L160;
        w0 r166 = r150.a();
        if (r166 == null) goto L158;
        String r167 = r166.f();
        if (r167 == null) goto L158;
        Long r168 = StringsKt.toLongOrNull(r167);
        if (r168 == null) goto L158;
        if (r168.longValue() <= 0) goto L155;
        boolean r169 = true;
    L156:
        if (r169 == false) goto L158;
    L159:
        c1 r170 = new c1(r165, null, r168, 2);
    L161:
        if (r170 == null) goto L99;
        r148.add(r170);
        goto L99
    L155:
        r169 = false;
    L158:
        r168 = null;
        goto L159
    L160:
        r170 = null;
    L140:
        r163 = 0;
    L132:
        r212 = null;
        goto L133
    L122:
        r156 = null;
        goto L123
    L117:
        if ((StringsKt.isBlank(r154) ^ r108) != r108) goto L119;
        r155 = true;
        goto L120
    L114:
        r154 = null;
    L124:
        r165 = null;
        goto L145
    L108:
        r211 = null;
        goto L109
    L103:
        if (b(r151) != r108) goto L105;
        r152 = true;
        goto L106
    L163:
        HashSet r171 = new HashSet();
        ArrayList r172 = new ArrayList();
        Iterator r173 = r148.iterator();
    L165:
        if (r173.hasNext() == false) goto L169;
        Object r174 = r173.next();
        if (r171.add(((c1) r174).f298904a.f298715a) == false) goto L165;
        r172.add(r174);
        goto L165
    L169:
        List r175 = r172;
    L171:
        List<y0> r176 = r109.a();
        if (r176 == null) goto L240;
        List r177 = CollectionsKt.filterNotNull(r176);
        if (r177 == null) goto L240;
        ArrayList r178 = new ArrayList();
        Iterator r179 = r177.iterator();
    L177:
        if (r179.hasNext() == false) goto L184;
        Object r180 = r179.next();
        if (((y0) r180).b() != MentionSearchResultType.CONVERSATION.getProtocolValue()) goto L181;
        boolean r181 = true;
    L182:
        if (r181 == false) goto L177;
        r178.add(r180);
        goto L177
    L181:
        r181 = false;
        goto L182
    L184:
        ArrayList r182 = new ArrayList();
        Iterator r183 = r178.iterator();
    L186:
        if (r183.hasNext() == false) goto L191;
        List<x0> r184 = ((y0) r183.next()).a();
        if (r184 != null) goto L190;
        r184 = CollectionsKt.emptyList();
    L190:
        CollectionsKt.addAll(r182, CollectionsKt.filterNotNull(r184));
        goto L186
    L191:
        ArrayList r185 = new ArrayList();
        Iterator r186 = r182.iterator();
    L193:
        if (r186.hasNext() == false) goto L230;
        x0 r187 = (x0) r186.next();
        String r188 = r187.b();
        if (r188 != null) goto L197;
    L199:
        boolean r189 = false;
    L200:
        if (r189 == true) goto L203;
        r188 = null;
    L203:
        if (r188 == null) goto L218;
        String r190 = r187.c();
        if (r190 == null) goto L208;
        String r191 = c(r190);
    L209:
        if (r191 != null) goto L211;
    L213:
        boolean r192 = false;
    L214:
        if (r192 == false) goto L216;
        String r193 = r191;
    L217:
        if (r193 == null) goto L218;
        w0 r194 = r187.a();
        if (r194 == null) goto L226;
        String r195 = r194.c();
        if (r195 == null) goto L226;
        if (b(r195) == false) goto L226;
        String r213 = r195;
    L227:
        InputReferenceType r196 = InputReferenceType.CONVERSATION;
        Regex r197 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        Intrinsics.checkNotNullParameter(r188, "conversationId");
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r198 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r188, r193, r196, new Uri.Builder().scheme("conversation").authority(r188).build().toString(), r213, null, null, null, null, null, 992);
    L228:
        if (r198 == null) goto L193;
        r185.add(r198);
    L226:
        r213 = null;
        goto L227
    L216:
        r193 = null;
        goto L217
    L211:
        if ((StringsKt.isBlank(r191) ^ r108) != r108) goto L213;
        r192 = true;
        goto L214
    L208:
        r191 = null;
    L218:
        r198 = null;
        goto L228
    L197:
        if ((StringsKt.isBlank(r188) ^ r108) != r108) goto L199;
        r189 = true;
        goto L200
    L230:
        HashSet r199 = new HashSet();
        ArrayList r200 = new ArrayList();
        Iterator r201 = r185.iterator();
    L232:
        if (r201.hasNext() == false) goto L236;
        Object r202 = r201.next();
        if (r199.add(((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r202).f298715a) == false) goto L232;
        r200.add(r202);
        goto L232
    L236:
        ?? r203 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r200, 10));
        Iterator r204 = r200.iterator();
    L238:
        if (r204.hasNext() == false) goto L242;
        r203.add(new c1((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r204.next(), null, null, 6));
    L242:
        return new f0(r175, null, r138, r203, 18);
    L240:
        r203 = CollectionsKt.emptyList();
    L170:
        r175 = CollectionsKt.emptyList();
    L74:
        r135 = 0;
        goto L75
    L24:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        List r205 = CollectionsKt.createListBuilder();
        r205.add(MentionSearchDomain.CONVERSATION.getKey());
        r205.add(MentionSearchDomain.DRIVE.getKey());
        if (r210 == false) goto L17;
        r205.add(MentionSearchDomain.GROUP.getKey());
    L17:
        JSONObject r206 = new JSONObject().put("scene", "mention").put("domain_keys", new JSONArray(CollectionsKt.build(r205))).put("ext", new JSONObject());
        Intrinsics.checkNotNull(r206);
        r110.Z$0 = r210;
        r110.label = 1;
        r108 = true;
        Object r207 = HttpExtKt.k(ServiceType.IM, v0.class, "/alice/search/mention_recommend", r206, null, null, true, null, null, null, r110, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r207 != r103) goto L20;
        return r103;
    L20:
        r106 = r207;
        r107 = r210;
    L7:
        r100 = new MentionSearchRepository$recommend$1(this, r310);
        goto L8
    }

    public final Object g(String r100, List<? extends MentionSearchDomain> r101, Continuation<? super f0> r102) {
        if ((r102 instanceof MentionSearchRepository$queryReferences$1) == false) goto L7;
        MentionSearchRepository$queryReferences$1 r103 = (MentionSearchRepository$queryReferences$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        f0 r108 = (f0) r105;
        if (r108 == null) goto L20;
        return r108;
    L20:
        return new f0(null, null, null, null, 31);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;
        r105 = e(r100, r101, MapsKt.emptyMap(), r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new MentionSearchRepository$queryReferences$1(this, r102);
        goto L8
    }

    /* JADX WARN: Failed to calculate best type for var: r0v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v14 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v26 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v27 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v28 ??, new type: java.lang.Enum
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v72 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v72 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v87 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v87 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v88 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v88 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v90 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v90 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v11 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v8 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r10v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v9 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r14v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v2 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchResultType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v5 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v5 ??, new type: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.t0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v11 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.lang.Object e(java.lang.String r33, java.util.List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain> r34, java.util.Map<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain, java.lang.String> r35, kotlin.coroutines.Continuation<? super com.larus.bmhome.chat.component.bottom.core.inputtext.mention.f0> r36) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0111: IGET (r0v1 ?? I:T) = (r4v10 com.larus.network.http.a) A[DECLARE_VAR] (LINE:67109137) com.larus.network.http.a.b java.lang.Object in method: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchRepository.e(java.lang.String, java.util.List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain>, java.util.Map<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchDomain, java.lang.String>, kotlin.coroutines.Continuation<? super com.larus.bmhome.chat.component.bottom.core.inputtext.mention.f0>):java.lang.Object, file: classes25.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchRepository.e(java.lang.String, java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f(String r100, MentionSearchDomain r101, String r102, Continuation<? super f0> r103) {
        if ((r103 instanceof MentionSearchRepository$queryMore$1) == false) goto L7;
        MentionSearchRepository$queryMore$1 r104 = (MentionSearchRepository$queryMore$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r101 = (MentionSearchDomain) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        f0 r109 = (f0) r106;
        if (r109 == null) goto L23;
        if (r109.f298917e.containsKey(r101) == false) goto L23;
        return r109;
    L23:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        List<? extends MentionSearchDomain> r110 = CollectionsKt.listOf(r101);
        Map<MentionSearchDomain, String> r111 = MapsKt.mapOf(TuplesKt.to(r101, r102));
        r104.L$0 = r101;
        r104.label = 1;
        r106 = e(r100, r110, r111, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new MentionSearchRepository$queryMore$1(this, r103);
        goto L8
    }
}
