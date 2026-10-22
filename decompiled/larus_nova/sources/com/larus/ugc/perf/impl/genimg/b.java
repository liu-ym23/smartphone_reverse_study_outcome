package com.larus.ugc.perf.impl.genimg;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.api.bean.GalleryChatType;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.DurationInfo;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ugc.perf.impl.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.l3;

/* JADX INFO: loaded from: classes31.dex */
public final class b extends OldUgcGenImgPerfMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f375119d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f375120e;

    static {
        f375119d = new b();
    }

    public b() {
    }

    public static Map n(List r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        DurationInfo r103 = (DurationInfo) r102.next();
        String r104 = r103.stepName;
        Long r105 = r103.duration;
        if (r104 == null) goto L9;
        if (r105 == null) goto L9;
        Pair r106 = TuplesKt.to(r104, r105);
    L10:
        if (r106 == null) goto L4;
        r101.add(r106);
    L9:
        r106 = null;
        goto L10
    L12:
        Map r107 = MapsKt.toMap(r101);
        if (r107 == null) goto L15;
        return r107;
    L15:
        return MapsKt.emptyMap();
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, com.larus.ugc.perf.impl.d
    public final void a(com.larus.ugc.perf.impl.e r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        List r100 = CollectionsKt.listOf(GalleryChatType.HOMEWORK_CORRECTION);
        Message r101 = r110.f375104a;
        if (r101 == null) goto L13;
        List<Block> r102 = com.larus.im.bean.message.a.k(r101);
        if (r102 == null) goto L13;
        Block r103 = (Block) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L13;
        BlockContent r104 = r103.getContent();
        if (r104 == null) goto L13;
        CreationBlock r105 = r104.getCreationBlock();
        if (r105 == null) goto L13;
        String r106 = r105.scene;
    L15:
        if (CollectionsKt.contains(r100, r106) == false) goto L17;
        return;
    L17:
        boolean r107 = true;
        if (f375120e == true) goto L22;
        f375120e = true;
        com.larus.im.d.e().registerOnGlobalMessageObserver(new a());
    L22:
        if (Intrinsics.areEqual(r110.f375105b.get("receive_first_image"), Boolean.TRUE) == true) goto L51;
        Message r108 = r110.f375104a;
        if (r108 == null) goto L42;
        Iterator r109 = ((ArrayList) com.larus.im.bean.message.a.l(r108)).iterator();
    L28:
        if (r109.hasNext() == false) goto L40;
        Object r111 = r109.next();
        ImageData r112 = ((CreationItem) r111).image;
        if (r112 == null) goto L37;
        Integer r113 = r112.status;
        if (r113 == null) goto L37;
        if (r113.intValue() != 2) goto L37;
        boolean r114 = true;
    L38:
        if (r114 == false) goto L28;
    L41:
        CreationItem r115 = (CreationItem) r111;
    L43:
        if (r115 == null) goto L45;
        boolean r116 = true;
    L46:
        if (r116 == false) goto L51;
        r110.f375105b.put("receive_first_image", Boolean.TRUE);
        r110.f375105b.put("receive_first_imagetime", Long.valueOf(System.currentTimeMillis()));
        HashMap<String, Object> r117 = r110.f375105b;
        String r118 = r115.f346620id;
        if (r118 != null) goto L50;
        r118 = "";
    L50:
        r117.put("receive_first_imagetask_id", r118);
        goto L51
    L45:
        r116 = false;
    L37:
        r114 = false;
        goto L38
    L40:
        r111 = null;
        goto L41
    L42:
        r115 = null;
    L51:
        m(r110, 0);
        Message r119 = r110.f375104a;
        if (r119 != null) goto L54;
    L56:
        r107 = false;
    L57:
        if (r107 == false) goto L66;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1(r110, null), 2, null);
        return;
    L66:
        return;
    L54:
        if (com.larus.bmhome.chat.bean.d.j0(r119) != true) goto L56;
    L13:
        r106 = null;
        goto L15
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void b(Message r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        super.b(r210, r211);
        com.larus.ugc.perf.impl.e r100 = com.larus.ugc.perf.impl.d.a.a(r210);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("gen_image/image_load_finish" + r211);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
        return;
    L8:
        r100.f375105b.put("gen_image/image_load_finish" + r211, r102);
        long r103 = System.currentTimeMillis();
        Object r104 = r100.f375105b.get("gen_image/load_image" + r211 + ILoadStallMonitor.START_TIME);
        String r105 = null;
        if ((r104 instanceof Long) == false) goto L11;
        Long r106 = (Long) r104;
    L12:
        if (r106 == null) goto L14;
        long r107 = r106.longValue();
    L15:
        long r108 = r103 - r107;
        Message r109 = r100.f375104a;
        if (r109 == null) goto L19;
        r105 = tz9.a.a(r109);
    L19:
        if (r105 != null) goto L21;
        String r212 = "";
    L22:
        String r110 = r100.b();
        if (r110 != null) goto L25;
        String r213 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r108), "gen_image/image_load_finish", r212, "1", 0L, r213, r211, null, null, null, null, null, null, null, null, 261127), r100);
        return;
    L25:
        r213 = r110;
        goto L26
    L21:
        r212 = r105;
        goto L22
    L14:
        r107 = System.currentTimeMillis();
        goto L15
    L11:
        r106 = null;
        goto L12
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void e(Message r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        com.larus.ugc.perf.impl.e r100 = com.larus.ugc.perf.impl.d.a.a(r210);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("gen_image/show_loading" + r211);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
        return;
    L8:
        r100.f375105b.put("gen_image/show_loading" + r211, r102);
        long r103 = System.currentTimeMillis();
        Object r104 = r100.f375105b.get("gen_image/task_start" + r211 + ILoadStallMonitor.START_TIME);
        String r105 = null;
        if ((r104 instanceof Long) == false) goto L11;
        Long r106 = (Long) r104;
    L12:
        if (r106 == null) goto L14;
        long r107 = r106.longValue();
    L15:
        long r108 = r103 - r107;
        Message r109 = r100.f375104a;
        if (r109 == null) goto L19;
        r105 = tz9.a.a(r109);
    L19:
        if (r105 != null) goto L21;
        String r212 = "";
    L22:
        String r110 = r100.b();
        if (r110 != null) goto L25;
        String r213 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r108), "gen_image/show_loading", r212, null, null, r213, r211, null, null, null, null, null, null, null, null, 261319), r100);
        return;
    L25:
        r213 = r110;
        goto L26
    L21:
        r212 = r105;
        goto L22
    L14:
        r107 = System.currentTimeMillis();
        goto L15
    L11:
        r106 = null;
        goto L12
    }

    @Override // com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor, nq9.g
    public final void f(Message r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);
        super.f(r210, r211);
        com.larus.ugc.perf.impl.e r100 = com.larus.ugc.perf.impl.d.a.a(r210);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("gen_image/image_load_finish" + r211);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
        return;
    L8:
        r100.f375105b.put("gen_image/image_load_finish" + r211, r102);
        long r103 = System.currentTimeMillis();
        Object r104 = r100.f375105b.get("gen_image/load_image" + r211 + ILoadStallMonitor.START_TIME);
        String r105 = null;
        if ((r104 instanceof Long) == false) goto L11;
        Long r106 = (Long) r104;
    L12:
        if (r106 == null) goto L14;
        long r107 = r106.longValue();
    L15:
        long r108 = r103 - r107;
        Message r109 = r100.f375104a;
        if (r109 == null) goto L19;
        r105 = tz9.a.a(r109);
    L19:
        if (r105 != null) goto L21;
        String r212 = "";
    L22:
        String r110 = r100.b();
        if (r110 != null) goto L25;
        String r213 = "";
    L26:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(null, null, null, Long.valueOf(r108), "gen_image/image_load_finish", r212, "0", -1L, r213, r211, null, null, null, null, null, null, null, null, 261127), r100);
        return;
    L25:
        r213 = r110;
        goto L26
    L21:
        r212 = r105;
        goto L22
    L14:
        r107 = System.currentTimeMillis();
        goto L15
    L11:
        r106 = null;
        goto L12
    }

    public final void m(com.larus.ugc.perf.impl.e r410, long r411) {
        Message r100 = r410.f375104a;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
    L13:
        Object r102 = r410.f375105b.get("gen_image/receive_last_package");
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L16;
        return;
    L16:
        r410.f375105b.put("gen_image/receive_last_package", r103);
        Message r104 = r410.f375104a;
        if (r104 == null) goto L19;
        List<CreationItem> r105 = com.larus.im.bean.message.a.l(r104);
    L20:
        f r106 = f.f375107a;
        Message r110 = r410.f375104a;
        r106.getClass();
        List r107 = f.a(r110);
        Message r111 = r410.f375104a;
        if (r111 != null) goto L23;
    L25:
        boolean r112 = false;
    L26:
        if (r112 == true) goto L43;
        if (r105 != null) goto L29;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == false) goto L43;
        List r114 = r107;
        if (r114 != null) goto L37;
    L40:
        boolean r115 = true;
    L41:
        if (r115 == false) goto L43;
        return;
    L37:
        if (r114.isEmpty() == true) goto L40;
        r115 = false;
        goto L41
    L29:
        if (r105.isEmpty() == true) goto L32;
        r113 = false;
    L43:
        long r116 = System.currentTimeMillis();
        Long r117 = r410.d();
        if (r117 == null) goto L46;
        long r118 = r117.longValue();
    L47:
        long r119 = r116 - r118;
        if (r411 == 0) goto L50;
    L54:
        Long r120 = r410.c();
        if (r120 == null) goto L57;
        long r121 = r120.longValue();
    L58:
        long r122 = System.currentTimeMillis() - r121;
        Object r123 = r410.f375105b.get("receive_first_imagetime");
        if ((r123 instanceof Long) == false) goto L61;
        Long r124 = (Long) r123;
    L62:
        if (r124 == null) goto L64;
        long r125 = r124.longValue();
    L65:
        Long r126 = r410.d();
        if (r126 == null) goto L68;
        long r127 = r126.longValue();
    L69:
        long r128 = r125 - r127;
        if (r107 == null) goto L72;
        int r129 = r107.size();
    L73:
        if (r129 != 0) goto L77;
        if (r105 == null) goto L76;
        r129 = r105.size();
        goto L77
    L76:
        r129 = 0;
    L77:
        long r108 = OldUgcGenImgPerfMonitor.k(r410.f375104a, r411);
        if (r129 != 0) goto L82;
        if (r108 != 0) goto L82;
        return;
    L82:
        if (r108 != 710082041) goto L85;
        return;
    L85:
        if (r105 == null) goto L102;
        ArrayList r109 = new ArrayList();
        Iterator<T> r210 = r105.iterator();
    L88:
        if (r210.hasNext() == false) goto L101;
        Object r130 = r210.next();
        ImageData r131 = ((CreationItem) r130).image;
        if (r131 == null) goto L97;
        Integer r132 = r131.status;
        if (r132 == null) goto L97;
        if (r132.intValue() != 2) goto L97;
        boolean r133 = true;
    L98:
        if (r133 == false) goto L88;
        r109.add(r130);
    L97:
        r133 = false;
        goto L98
    L101:
        int r134 = r109.size();
    L103:
        Message r135 = r410.f375104a;
        if (r135 == null) goto L106;
        String r136 = tz9.a.a(r135);
    L107:
        String r137 = "";
        if (r136 != null) goto L110;
        String r310 = "";
    L111:
        Object r138 = r410.f375105b.get("message_receive_first_package");
        if ((r138 instanceof Long) == false) goto L114;
        Long r211 = (Long) r138;
    L115:
        if (r411 == 0) goto L118;
        r119 = -1;
    L118:
        Message r139 = r410.f375104a;
        if (r139 == null) goto L121;
        Integer r311 = Integer.valueOf(com.larus.bmhome.chat.bean.d.h(r139));
    L122:
        Message r140 = r410.f375104a;
        if (r140 == null) goto L125;
        Integer r312 = IAIChatControlTraceService.f365889a.Wb(r140);
        long r212 = 0;
    L127:
        if (r108 != r212) goto L138;
        Message r141 = r410.f375104a;
        if (r141 != null) goto L131;
    L133:
        boolean r142 = false;
    L134:
        if (r142 == false) goto L138;
        if (r129 <= 0) goto L137;
        if (r134 == 0) goto L138;
    L137:
        String r143 = "1";
    L139:
        String r313 = r143;
        Message r144 = r410.f375104a;
        if (r144 == null) goto L142;
        String r145 = ap8.a.b(r144);
    L143:
        if (r145 == null) goto L147;
        r137 = r145;
    L147:
        if (r137.length() != 0) goto L149;
        boolean r146 = true;
    L150:
        if (r146 == false) goto L152;
        r137 = "image";
    L152:
        String r412 = r137;
        if (r105 == null) goto L160;
        CreationItem r147 = (CreationItem) CollectionsKt.firstOrNull(r105);
        if (r147 == null) goto L160;
        CreationGenDetail r148 = r147.genDetail;
        if (r148 == null) goto L160;
        Integer r149 = r148.taskType;
        if (r149 == null) goto L160;
    L165:
        if (r149 == null) goto L167;
        String r314 = r149.toString();
    L168:
        LinkedHashSet r150 = new LinkedHashSet();
        if (r105 == null) goto L179;
        Iterator<T> r151 = r105.iterator();
    L172:
        if (r151.hasNext() == false) goto L179;
        CreationGenDetail r152 = ((CreationItem) r151.next()).genDetail;
        if (r152 == null) goto L172;
        Integer r153 = r152.taskType;
        if (r153 == null) goto L172;
        r150.add(Integer.valueOf(r153.intValue()));
    L179:
        if (r150.size() <= 1) goto L181;
        boolean r154 = true;
    L182:
        h1a.e.a(new OldUgcGenImgPerfMonitor.b(r211, Long.valueOf(r128), Long.valueOf(r122), Long.valueOf(r119), "gen_image/receive_last_package", r310, r313, Long.valueOf(r108), null, null, r314, l3.f(Boolean.valueOf(r154)), r311, r312, Integer.valueOf(r129), Integer.valueOf(r134), r412, null, 131840), r410);
        Message r155 = r410.f375104a;
        if (r155 == null) goto L206;
        List<AICreationTaskDurationInfo> r156 = ap8.a.a(r155);
        if (r156 == null) goto L206;
        Iterator<T> r157 = r156.iterator();
    L188:
        if (r157.hasNext() == false) goto L204;
        Object r158 = r157.next();
        AICreationTaskDurationInfo r159 = (AICreationTaskDurationInfo) r158;
        Integer r160 = r159.type;
        if (r160 != null) goto L193;
    L201:
        boolean r161 = false;
    L202:
        if (r161 == false) goto L188;
    L205:
        AICreationTaskDurationInfo r162 = (AICreationTaskDurationInfo) r158;
    L207:
        Message r163 = r410.f375104a;
        if (r163 == null) goto L210;
        String r164 = r163.getMessageId();
    L211:
        if (r108 != r212) goto L213;
        boolean r165 = true;
    L214:
        Object r166 = r410.f375105b.get("receive_first_imagetask_id");
        if ((r166 instanceof String) == false) goto L217;
        String r167 = (String) r166;
    L218:
        if (r162 == null) goto L222;
        List<DurationInfo> r168 = r162.durationInfo;
        if (r168 == null) goto L222;
        Map r169 = n(r168);
    L223:
        h1a.b.a(r164, r167, r165, Long.valueOf(r128), r169);
        Message r170 = r410.f375104a;
        if (r170 == null) goto L271;
        List<AICreationTaskDurationInfo> r171 = ap8.a.a(r170);
        if (r171 == null) goto L297;
        ArrayList r172 = new ArrayList();
        Iterator<T> r173 = r171.iterator();
    L229:
        if (r173.hasNext() == false) goto L239;
        Object r174 = r173.next();
        Integer r175 = ((AICreationTaskDurationInfo) r174).type;
        if (r175 != null) goto L234;
    L236:
        boolean r176 = false;
    L237:
        if (r176 == false) goto L229;
        r172.add(r174);
        goto L229
    L234:
        if (r175.intValue() != 2) goto L236;
        r176 = true;
        goto L237
    L239:
        Iterator r177 = r172.iterator();
    L241:
        if (r177.hasNext() == false) goto L298;
        AICreationTaskDurationInfo r178 = (AICreationTaskDurationInfo) r177.next();
        Message r179 = r410.f375104a;
        if (r179 == null) goto L245;
        String r180 = r179.getMessageId();
    L246:
        String r181 = r178.taskId;
        Integer r182 = r178.errorCode;
        if (r182 == null) goto L252;
        if (r182.intValue() != 0) goto L252;
        int r183 = 1;
    L253:
        Integer r184 = r178.errorCode;
        List<DurationInfo> r185 = r178.durationInfo;
        if (r185 == null) goto L256;
        f375119d.getClass();
        Map r186 = n(r185);
    L257:
        TrackParams r187 = new TrackParams();
        if (r180 == null) goto L260;
        r187.put(MusicAppletPage.KEY_MESSAGE_ID, r180);
    L260:
        if (r181 == null) goto L262;
        r187.put("task_id", r181);
    L262:
        r187.put("success", Integer.valueOf(r183));
        if (r184 == null) goto L265;
        r187.put("error_code", Integer.valueOf(r184.intValue()));
    L265:
        if (r186 == null) goto L270;
        Iterator r188 = r186.entrySet().iterator();
    L268:
        if (r188.hasNext() == false) goto L270;
        Map.Entry r189 = (Map.Entry) r188.next();
        r187.put((String) r189.getKey(), Long.valueOf(((Number) r189.getValue()).longValue()));
    L270:
        by7.a r190 = new by7.a("report_creation_task_monitor");
        r190.f21463a.merge(r187);
        r190.b();
        goto L241
    L256:
        r186 = null;
    L252:
        r183 = 0;
        goto L253
    L245:
        r180 = null;
        goto L246
    L298:
        return;
    L297:
        return;
    L271:
        return;
    L222:
        r169 = null;
        goto L223
    L217:
        r167 = null;
        goto L218
    L213:
        r165 = false;
        goto L214
    L210:
        r164 = null;
        goto L211
    L193:
        if (r160.intValue() != 2) goto L201;
        String r191 = r159.taskId;
        Object r192 = r410.f375105b.get("receive_first_imagetask_id");
        if ((r192 instanceof String) == false) goto L197;
        String r193 = (String) r192;
    L199:
        if (Intrinsics.areEqual(r191, r193) == false) goto L201;
        r161 = true;
        goto L202
    L197:
        r193 = null;
        goto L199
    L204:
        r158 = null;
    L206:
        r162 = null;
        goto L207
    L181:
        r154 = false;
        goto L182
    L167:
        r314 = null;
    L160:
        if (r107 == null) goto L164;
        com.larus.ugc.perf.impl.a r194 = (com.larus.ugc.perf.impl.a) CollectionsKt.firstOrNull(r107);
        if (r194 == null) goto L164;
        r149 = r194.taskType;
    L164:
        r149 = null;
        goto L165
    L149:
        r146 = false;
        goto L150
    L142:
        r145 = null;
        goto L143
    L131:
        if (r141.getMessageStatusLocal() != 21) goto L133;
        r142 = true;
    L138:
        r143 = "0";
        goto L139
    L125:
        r212 = 0;
        r312 = null;
        goto L127
    L121:
        r311 = null;
        goto L122
    L114:
        r211 = null;
        goto L115
    L110:
        r310 = r136;
        goto L111
    L106:
        r136 = null;
        goto L107
    L102:
        r134 = 0;
        goto L103
    L72:
        r129 = 0;
        goto L73
    L68:
        r127 = System.currentTimeMillis();
        goto L69
    L64:
        r125 = System.currentTimeMillis();
        goto L65
    L61:
        r124 = null;
        goto L62
    L57:
        r121 = 0;
        goto L58
    L50:
        if (r119 > 0) goto L52;
        return;
    L52:
        if (r119 <= 180000) goto L54;
        return;
    L46:
        r118 = System.currentTimeMillis();
        goto L47
    L23:
        if (com.larus.bmhome.chat.bean.d.j1(r111) != true) goto L25;
        r112 = true;
        goto L26
    L19:
        r105 = null;
        goto L20
    L11:
        if (r411 != 0) goto L13;
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.j0(r100) != true) goto L7;
        r101 = true;
        goto L9
    }
}
