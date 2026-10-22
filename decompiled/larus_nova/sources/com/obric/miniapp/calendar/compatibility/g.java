package com.obric.miniapp.calendar.compatibility;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vka.j;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements vka.b<Long> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f397599e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f397601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f397602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EventEntity f397603d;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        EventEntity r101 = this.f397603d;
        if (r101.M == null) goto L5;
        boolean r102 = true;
    L6:
        boolean r103 = r101.f397530b;
        Long r110 = r101.f397528a;
        boolean r111 = r101.f397534d;
        Long r104 = r101.f397532c;
        if (r104 == null) goto L9;
        String r112 = r104.toString();
    L10:
        EventEntity r105 = this.f397603d;
        boolean r113 = r105.f397538f;
        Long r114 = r105.f397536e;
        boolean r106 = r105.f397542h;
        String r107 = r105.f397540g;
        boolean r108 = r105.f397575z;
        String r115 = r105.f397574y;
        boolean r109 = r105.f397546j;
        Long r116 = r105.f397544i;
        boolean r117 = r105.f397554n;
        Long r118 = r105.f397552m;
        boolean r119 = r105.f397566t;
        Integer r120 = r105.f397564s;
        boolean r121 = r105.f397573x;
        String r122 = r105.f397572w;
        boolean r123 = r105.B;
        String r124 = r105.A;
        if (r124 == null) goto L13;
        Integer r125 = StringsKt.toIntOrNull(r124);
    L14:
        EventEntity r126 = this.f397603d;
        boolean r127 = r126.D;
        String r128 = r126.C;
        Integer r210 = r125;
        if (r126.F == true) goto L21;
        if (r103 == false) goto L18;
    L20:
        boolean r211 = false;
    L22:
        String r129 = r126.E;
        if (r129 != null) goto L40;
        if (r103 == false) goto L26;
    L39:
        r108 = r108;
        r107 = r107;
        r128 = r128;
        r102 = r102;
        String r130 = null;
    L42:
        EventEntity r131 = this.f397603d;
        boolean r132 = r131.H;
        String r133 = r131.G;
        boolean r134 = r131.f397527J;
        String r135 = r131.I;
        boolean r136 = r131.L;
        String r137 = r131.K;
        boolean r138 = r131.N;
        Long r139 = r131.M;
        if (r139 == null) goto L45;
        String r310 = r139.toString();
    L46:
        EventEntity r140 = this.f397603d;
        boolean r141 = r140.P;
        Long r142 = r140.O;
        boolean r143 = r140.R;
        Integer r144 = r140.Q;
        boolean r145 = r140.f397563r0;
        String r146 = r140.f397561q0;
        boolean r147 = r140.f397571v0;
        String r148 = r140.f397569u0;
        boolean r212 = !r103;
        if (r110 == null) goto L71;
        r110.longValue();
        Integer r510 = r210;
        String r511 = r310;
        String r512 = r148;
        String r513 = "sync_data1";
        String r514 = r135;
        boolean r213 = r108;
        boolean r214 = r134;
        String r515 = r133;
        String r516 = r107;
        String r311 = r130;
        String r149 = r128;
        boolean r312 = r132;
        boolean r313 = r136;
        String r517 = r137;
        boolean r314 = r138;
        boolean r315 = r141;
        Long r518 = r142;
        boolean r316 = r143;
        Integer r519 = r144;
        boolean r317 = r145;
        String r610 = r146;
        boolean r318 = r147;
        vka.f r150 = r100;
        Long r151 = r116;
        Long r152 = r110;
        Long r153 = r118;
        boolean r215 = r111;
        String r154 = r122;
        String r216 = r112;
        Integer r155 = r120;
        Cursor r156 = r100.query(new ala.b(r110, 2), new String[]{"sync_data1"}, null, null, null);
        if (r156 == null) goto L68;
        Cursor r157 = r156;
        Cursor r158 = r157;     // Catch: Throwable -> L62
        if (r158.moveToNext() == true) goto L54;
    L58:
        String r159 = null;
    L59:
        CloseableKt.closeFinally(r157, null);
        if (r159 == null) goto L68;
        JsonObject r160 = JsonParser.parseString(r159).getAsJsonObject();
    L69:
        if (r160 == null) goto L72;
    L73:
        r160.addProperty("originalDtStart", this.f397603d.f397544i);
        EventEntity r161 = this.f397603d;
        if (r161.f397550l == false) goto L79;
        Long r162 = r161.f397548k;
        if (r162 == null) goto L78;
        r160.addProperty(DBDefinition.ETAG, Long.valueOf(r162.longValue()));
        Unit r163 = Unit.INSTANCE;
        goto L79
    L78:
        r160.remove(DBDefinition.ETAG);
    L79:
        EventEntity r164 = this.f397603d;
        if (r164.f397558p == false) goto L85;
        Long r165 = r164.f397556o;
        if (r165 == null) goto L84;
        r160.addProperty("dtStamp", Long.valueOf(r165.longValue()));
        Unit r166 = Unit.INSTANCE;
        goto L85
    L84:
        r160.remove("dtStamp");
    L85:
        EventEntity r167 = this.f397603d;
        if (r167.f397562r == false) goto L91;
        Long r168 = r167.f397560q;
        if (r168 == null) goto L90;
        r160.addProperty("createTime", Long.valueOf(r168.longValue()));
        Unit r169 = Unit.INSTANCE;
        goto L91
    L90:
        r160.remove("createTime");
    L91:
        EventEntity r170 = this.f397603d;
        if (r170.f397570v == false) goto L97;
        EventEntity.EventType r171 = r170.f397568u;
        if (r171 == null) goto L96;
        r160.addProperty("eventType", r171.toString());
        Unit r172 = Unit.INSTANCE;
        goto L97
    L96:
        r160.remove("eventType");
    L97:
        EventEntity r173 = this.f397603d;
        if (r173.T == false) goto L103;
        String r174 = r173.S;
        if (r174 == null) goto L102;
        r160.addProperty("iCalStr", r174);
        Unit r175 = Unit.INSTANCE;
        goto L103
    L102:
        r160.remove("iCalStr");
    L103:
        EventEntity r176 = this.f397603d;
        if (r176.V == false) goto L109;
        Integer r177 = r176.U;
        if (r177 == null) goto L108;
        r160.addProperty("isCompleted", Integer.valueOf(r177.intValue()));
        Unit r178 = Unit.INSTANCE;
        goto L109
    L108:
        r160.remove("isCompleted");
    L109:
        EventEntity r179 = this.f397603d;
        if (r179.X == false) goto L115;
        EventEntity.EventFreq r180 = r179.W;
        if (r180 == null) goto L114;
        r160.addProperty("freq", r180.toString());
        Unit r181 = Unit.INSTANCE;
        goto L115
    L114:
        r160.remove("freq");
    L115:
        EventEntity r182 = this.f397603d;
        if (r182.Z == false) goto L121;
        Integer r183 = r182.Y;
        if (r183 == null) goto L120;
        r160.addProperty(VideoThumbInfo.KEY_INTERVAL, Integer.valueOf(r183.intValue()));
        Unit r184 = Unit.INSTANCE;
        goto L121
    L120:
        r160.remove(VideoThumbInfo.KEY_INTERVAL);
    L121:
        EventEntity r185 = this.f397603d;
        if (r185.f397531b0 == false) goto L127;
        Long r186 = r185.f397529a0;
        if (r186 == null) goto L126;
        r160.addProperty("until", Long.valueOf(r186.longValue()));
        Unit r187 = Unit.INSTANCE;
        goto L127
    L126:
        r160.remove("until");
    L127:
        EventEntity r188 = this.f397603d;
        if (r188.f397535d0 == false) goto L133;
        Integer r189 = r188.f397533c0;
        if (r189 == null) goto L132;
        r160.addProperty("exStatus", Integer.valueOf(r189.intValue()));
        Unit r190 = Unit.INSTANCE;
        goto L133
    L132:
        r160.remove("exStatus");
    L133:
        EventEntity r191 = this.f397603d;
        if (r191.f397539f0 == false) goto L139;
        Integer r192 = r191.f397537e0;
        if (r192 == null) goto L138;
        r160.addProperty("index", Integer.valueOf(r192.intValue()));
        Unit r193 = Unit.INSTANCE;
        goto L139
    L138:
        r160.remove("index");
    L139:
        EventEntity r194 = this.f397603d;
        if (r194.f397543h0 == false) goto L145;
        Long r195 = r194.f397541g0;
        if (r195 == null) goto L144;
        r160.addProperty("exDtStart", Long.valueOf(r195.longValue()));
        Unit r196 = Unit.INSTANCE;
        goto L145
    L144:
        r160.remove("exDtStart");
    L145:
        EventEntity r197 = this.f397603d;
        if (r197.f397547j0 == false) goto L151;
        Long r198 = r197.f397545i0;
        if (r198 == null) goto L150;
        r160.addProperty("exDtEnd", Long.valueOf(r198.longValue()));
        Unit r199 = Unit.INSTANCE;
        goto L151
    L150:
        r160.remove("exDtEnd");
    L151:
        EventEntity r200 = this.f397603d;
        if (r200.f397551l0 == false) goto L157;
        String r201 = r200.f397549k0;
        if (r201 == null) goto L156;
        r160.addProperty("syncStatus", r201);
        Unit r202 = Unit.INSTANCE;
        goto L157
    L156:
        r160.remove("syncStatus");
    L157:
        EventEntity r203 = this.f397603d;
        if (r203.f397559p0 == false) goto L163;
        Boolean r204 = r203.f397557o0;
        if (r204 == null) goto L162;
        r160.addProperty("isNoTimeTodo", Boolean.valueOf(r204.booleanValue()));
        Unit r205 = Unit.INSTANCE;
        goto L163
    L162:
        r160.remove("isNoTimeTodo");
    L163:
        EventEntity r206 = this.f397603d;
        if (r206.f397567t0 == false) goto L169;
        Long r207 = r206.f397565s0;
        if (r207 == null) goto L168;
        r160.addProperty("completeTime", Long.valueOf(r207.longValue()));
        Unit r208 = Unit.INSTANCE;
        goto L169
    L168:
        r160.remove("completeTime");
    L169:
        String r209 = r160.toString();
        ContentValues r217 = new ContentValues();
        if (r113 == false) goto L172;
        r217.put("calendar_id", r114);
    L172:
        if (r106 == false) goto L174;
        r217.put("title", r516);
    L174:
        if (r213 == false) goto L176;
        r217.put("eventLocation", r115);
    L176:
        if (r121 == false) goto L178;
        r217.put("description", r154);
    L178:
        if (r123 == false) goto L180;
        r217.put("eventColor", r510);
    L180:
        if (r109 == false) goto L182;
        r217.put("dtstart", r151);
    L182:
        if (r117 == false) goto L184;
        r217.put("dtend", r153);
    L184:
        if (r212 == false) goto L186;
        r217.put("eventTimezone", "Asia/Shanghai");
    L186:
        if (r127 == false) goto L188;
        r217.put("duration", r149);
    L188:
        if (r119 == false) goto L190;
        r217.put("allDay", r155);
    L190:
        if (r211 == false) goto L192;
        r217.put("rrule", r311);
    L192:
        if (r312 == false) goto L194;
        r217.put("rdate", r515);
    L194:
        if (r214 == false) goto L196;
        r217.put("exrule", r514);
    L196:
        if (r313 == false) goto L199;
        r217.put("exdate", r517);
    L199:
        if (r314 == false) goto L201;
        r217.put("original_id", r511);
    L201:
        if (r315 == false) goto L203;
        r217.put("originalInstanceTime", r518);
    L203:
        if (r316 == false) goto L205;
        r217.put("originalAllDay", r519);
    L205:
        if (r318 == false) goto L207;
        r217.put("customAppPackage", r512);
    L207:
        if (r317 == false) goto L209;
        r217.put("customAppUri", r610);
    L209:
        if (r215 == false) goto L211;
        r217.put("_sync_id", r216);
    L211:
        r217.put(r513, r209);
        EventEntity r218 = this.f397603d;
        if (r218.f397555n0 == false) goto L215;
        r217.put("sync_data2", r218.f397553m0);
    L215:
        if (this.f397601b == false) goto L221;
        Long r219 = this.f397602c;
        if (r219 == null) goto L219;
        long r220 = r219.longValue();
    L220:
        r217.put("dirty", Long.valueOf(r220));
        goto L221
    L219:
        r220 = 0;
    L221:
        if (r152 == null) goto L226;
        Long r221 = r152;
        if (r150.update(new ala.b(r221, this.f397600a), r217, null, null) > 0) goto L236;
        return null;
    L236:
        return r221;
    L226:
        vka.f r222 = r150;
        if (r102 == false) goto L229;
        r217.remove("original_id");
        ala.e r223 = new ala.c(this.f397603d.M.longValue(), this.f397600a);
    L231:
        return r222.insert(r223, r217);
    L229:
        r223 = new ala.b(null, this.f397600a);
    L72:
        r160 = new JsonObject();
        goto L73
    L54:
        if (r158.isNull(0) == true) goto L58;
        r159 = r158.getString(0);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r157, th);
        throw th;
    L68:
        r160 = null;
        goto L69
    L71:
        r512 = r148;
        r513 = "sync_data1";
        r514 = r135;
        r515 = r133;
        r510 = r210;
        r213 = r108;
        r516 = r107;
        r517 = r137;
        r511 = r310;
        r315 = r141;
        r518 = r142;
        r316 = r143;
        r519 = r144;
        r610 = r146;
        r214 = r134;
        r318 = r147;
        r311 = r130;
        r149 = r128;
        r312 = r132;
        r313 = r136;
        r314 = r138;
        r317 = r145;
        r150 = r100;
        r151 = r116;
        r152 = r110;
        r153 = r118;
        r215 = r111;
        r154 = r122;
        r216 = r112;
        r155 = r120;
        goto L72
    L45:
        r310 = null;
        goto L46
    L26:
        if (r126.W == null) goto L39;
        StringBuilder r224 = new StringBuilder();
        r224.append("FREQ=" + this.f397603d.W);
        if (this.f397603d.Y == null) goto L31;
        r224.append(";INTERVAL=" + this.f397603d.Y);
    L31:
        if (this.f397603d.f397529a0 == null) goto L38;
        StringBuilder r225 = new StringBuilder(";UNTIL=");
        Lazy r226 = j.f555554a;
        long r227 = this.f397603d.f397529a0.longValue();
        if (Build.VERSION.SDK_INT < 26) goto L35;
        DateTimeFormatter r228 = (DateTimeFormatter) j.f555554a.getValue();
        Intrinsics.checkNotNull(r228);
        String r229 = r228.format(Instant.ofEpochMilli(r227).atZone(ZoneId.systemDefault()));
        Intrinsics.checkNotNull(r229);
    L36:
        r225.append(r229);
        r224.append(r225.toString());
        goto L38
    L35:
        r229 = ((SimpleDateFormat) j.f555555b.getValue()).format(new Date(r227));
        Intrinsics.checkNotNull(r229);
    L38:
        r129 = r224.toString();
    L41:
        r130 = r129;
        goto L42
    L40:
        r107 = r107;
        r128 = r128;
        r102 = r102;
        goto L41
    L18:
        if (r126.X == false) goto L20;
    L21:
        r211 = true;
        goto L22
    L13:
        r125 = null;
        goto L14
    L9:
        r112 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public g(String r100, boolean r101, Long r102, EventEntity r103) {
        Intrinsics.checkNotNullParameter(r100, "accountName");
        Intrinsics.checkNotNullParameter(r103, "entity");
        this.f397600a = r100;
        this.f397601b = r101;
        this.f397602c = r102;
        this.f397603d = r103;
    }
}
