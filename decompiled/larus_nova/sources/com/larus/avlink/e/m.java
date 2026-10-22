package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.gallery.thumbnail.l0;
import com.larus.avlink.gallery.thumbnail.m0;
import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f291793a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f291794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f98.h f291795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AsyncThrowable f291796c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f291794a == r101.f291794a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291795b, r101.f291795b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f291796c, r101.f291796c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f291794a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            f98.h r102 = this.f291795b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            AsyncThrowable r106 = this.f291796c;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return r105 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "UploadResult(success=" + this.f291794a + ", response=" + this.f291795b + ", error=" + this.f291796c + ')';
        }

        public a(boolean r100, f98.h r101, AsyncThrowable r102) {
            this.f291794a = r100;
            this.f291795b = r101;
            this.f291796c = r102;
        }
    }

    static {
        f291793a = new m();
    }

    public m() {
    }

    public static void b(int r100, List r110, Map r111, int r112, l0 r113, m0 r114) {
        Intrinsics.checkNotNullParameter(r110, "visionInfo");
        Intrinsics.checkNotNullParameter(r111, "extra");
        Unit r115 = Unit.INSTANCE;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraENetworkUtil$uploadOcrResult$1(r100, r114, r110, r112, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0345 -> B:13:0x0051). Please report as a decompilation issue!!! */
    public final Object a(b49.h r210, int r211, List r212, String r213, String r214, int r215, Integer r216, int r310, f r311, g r312, Continuation r313) {
        int r100 = r211;
        if ((r313 instanceof DoraENetworkUtil$uploadImageWithRetry$1) == false) goto L7;
        DoraENetworkUtil$uploadImageWithRetry$1 r101 = (DoraENetworkUtil$uploadImageWithRetry$1) r313;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 1;
        if (r105 == 0) goto L17;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        int r107 = r101.I$3;
        int r108 = r101.I$2;
        int r109 = r101.I$1;
        int r110 = r101.I$0;
        f98.e r111 = (f98.e) r101.L$2;
        Function8 r112 = (Function8) r101.L$1;
        List r113 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r114 = r108;
        r100 = r110;
        Function8 r115 = r112;
    L13:
        Object r116 = r104;
        DoraENetworkUtil$uploadImageWithRetry$1 r117 = r101;
        int r118 = r109;
        Object r119 = r116;
        int r120 = r107 + 1;
        List r121 = r113;
        f98.e r122 = r111;
        r106 = 1;
        int r123 = r114;
    L69:
        int r124 = t39.e.f544466a;
        if (r120 > r106) goto L113;
        com.larus.dora.api.network.a r125 = com.larus.dora.api.network.a.f331768a;
        JSONObject r126 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r122));
        r117.L$0 = r121;
        r117.L$1 = r115;
        r117.L$2 = r122;
        r117.I$0 = r100;
        r117.I$1 = r118;
        r117.I$2 = r123;
        r117.I$3 = r120;
        r117.label = r106;
        Object r127 = com.larus.dora.api.network.a.c(r125, f98.h.class, "/alice/audio/process_vision_file", r126, null, r117, 248);
        if (r127 != r119) goto L74;
        return r119;
    L74:
        List r128 = r121;
        r107 = r120;
        f98.e r129 = r122;
        int r130 = r100;
        int r131 = r123;
        r111 = r129;
        Function8 r132 = r115;
        r103 = r127;
        Object r217 = r119;
        r109 = r118;
        r101 = r117;
        r104 = r217;
    L75:
        com.larus.network.http.a r133 = (com.larus.network.http.a) r103;
        if ((r133 instanceof y) == false) goto L102;
        f98.h r134 = (f98.h) ((y) r133).f360135b;
        if (r134 == null) goto L80;
        List<f98.o> r135 = r134.a();
    L81:
        List<f98.o> r136 = r135;
        if (r136 != null) goto L84;
    L87:
        boolean r137 = true;
    L89:
        if (r137 == false) goto L95;
        FLogger r138 = FLogger.f375446a;
        StringBuilder r139 = new StringBuilder("uploadImage response contents is empty. mode: ");
        r139.append(r111.f475984b);
        r139.append(", cid: ");
        r139.append(r111.b());
        r139.append(", imageId: ");
        r139.append(r109);
        r139.append(", imageCount: ");
        r139.append(r111.f475983a);
        r139.append(", realCount: ");
        List<f98.l> r140 = r111.a();
        if (r140 == null) goto L93;
        Integer r141 = Boxing.boxInt(r140.size());
    L94:
        r139.append(r141);
        r139.append('.');
        r138.e("DoraE_Camera", r139.toString());
    L100:
        AsyncThrowable r142 = null;
        int r143 = 1;
    L114:
        if (r132 == null) goto L129;
        Integer r144 = Boxing.boxInt(r109);
        Integer r145 = Boxing.boxInt(r130);
        if (r143 == 0) goto L118;
        boolean r146 = true;
    L119:
        Boolean r147 = Boxing.boxBoolean(r146);
        f98.l r148 = (f98.l) CollectionsKt.firstOrNull(r128);
        if (r148 == null) goto L122;
        Integer r149 = r148.d();
    L123:
        f98.l r150 = (f98.l) CollectionsKt.firstOrNull(r128);
        if (r150 == null) goto L126;
        Integer r151 = r150.a();
    L127:
        r132.invoke(r144, r145, r111, r134, r147, r142, r149, r151);
        goto L129
    L126:
        r151 = null;
        goto L127
    L122:
        r149 = null;
        goto L123
    L118:
        r146 = false;
    L129:
        if (r143 == 0) goto L131;
        boolean r152 = true;
    L133:
        return new a(r152, r134, r142);
    L131:
        r152 = false;
        goto L133
    L93:
        r141 = null;
        goto L94
    L95:
        FLogger r153 = FLogger.f375446a;
        StringBuilder r154 = new StringBuilder("uploadImage success. mode: ");
        r154.append(r111.f475984b);
        r154.append(", cid: ");
        r154.append(r111.b());
        r154.append(", imageId: ");
        r154.append(r109);
        r154.append(", imageCount: ");
        r154.append(r111.f475983a);
        r154.append(", realCount: ");
        List<f98.l> r155 = r111.a();
        if (r155 == null) goto L98;
        Integer r156 = Boxing.boxInt(r155.size());
    L99:
        r154.append(r156);
        r154.append('.');
        r153.i("DoraE_Camera", r154.toString());
        goto L100
    L98:
        r156 = null;
        goto L99
    L84:
        if (r136.isEmpty() == true) goto L87;
        r137 = false;
        goto L89
    L80:
        r135 = null;
        goto L81
    L102:
        if ((r133 instanceof com.larus.network.http.f) == false) goto L111;
        com.larus.network.http.f r157 = (com.larus.network.http.f) r133;
        FLogger.f375446a.e("DoraE_Camera", "uploadImage failed. cid: " + r111.b() + ", imageId: " + r109 + ", imageCount: " + r111.f475983a + ", retry: " + r107 + '.', r157.f360157d);
        int r158 = t39.e.f544466a;
        if (r107 >= 1) goto L110;
        r101.L$0 = r128;
        r101.L$1 = r132;
        r101.L$2 = r111;
        r101.I$0 = r130;
        r101.I$1 = r109;
        r101.I$2 = r131;
        r101.I$3 = r107;
        r101.label = 2;
        if (DelayKt.delay(500, r101) != r104) goto L108;
        return r104;
    L108:
        r115 = r132;
        r114 = r131;
        r100 = r130;
        r113 = r128;
        goto L13
    L110:
        r142 = r157.f360157d;
        r134 = null;
        r143 = 0;
        goto L114
    L111:
        FLogger.f375446a.i("DoraE_Camera", "uploadImage is loading. cid: " + r111.b() + ", imageId: " + r109 + ", imageCount: " + r111.f475983a + '.');
        r118 = r109;
        r115 = r132;
        r121 = r128;
        f98.e r159 = r111;
        r123 = r131;
        r100 = r130;
        r122 = r159;
    L113:
        r128 = r121;
        r132 = r115;
        r109 = r118;
        r143 = r123;
        r134 = null;
        r111 = r122;
        r130 = r100;
        r142 = null;
        goto L114
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r107 = r101.I$3;
        r131 = r101.I$2;
        r109 = r101.I$1;
        r130 = r101.I$0;
        f98.e r160 = (f98.e) r101.L$2;
        Function8 r161 = (Function8) r101.L$1;
        r128 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r132 = r161;
        r111 = r160;
        goto L75
    L17:
        ResultKt.throwOnFailure(r103);
        int r162 = r210.f17668a;
        List r163 = r212;
        if ((r163 instanceof Collection) == true) goto L20;
    L22:
        Iterator r164 = r163.iterator();
        int r165 = 0;
    L24:
        if (r164.hasNext() == false) goto L33;
        if (((f98.l) r164.next()) == null) goto L28;
        boolean r166 = true;
    L29:
        if (r166 == false) goto L24;
        r165 = r165 + 1;
        if (r165 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
        goto L24
    L28:
        r166 = false;
    L33:
        r122 = new f98.e();
        r122.c(r213);
        r122.e(r214);
        r122.f475983a = r165;
        r122.f475984b = r100;
        r122.i(r215);
        r122.d(CollectionsKt.filterNotNull(r163));
        r122.h(r310);
        f98.m r167 = new f98.m();
        r167.a(r210.f17672e);
        r122.g(r167);
        if (ia8.e.a().isRecording() == true) goto L36;
    L50:
        r122.j(r216);
    L51:
        FLogger r168 = FLogger.f375446a;
        StringBuilder r169 = new StringBuilder("uploadImage. imageId: ");
        r169.append(r162);
        r169.append(", mode: ");
        r169.append(r100);
        r169.append(", imageCount: ");
        r169.append(r122.f475983a);
        r169.append(", imageUUID: ");
        List<f98.l> r170 = r122.a();
        if (r170 == null) goto L56;
        f98.l r171 = (f98.l) CollectionsKt.firstOrNull(r170);
        if (r171 == null) goto L56;
        String r172 = r171.b();
    L57:
        r169.append(r172);
        r168.i("DoraE_Camera", r169.toString());
        if (r311 == null) goto L68;
        Object r173 = Boxing.boxInt(r162);
        Object r174 = Boxing.boxInt(r211);
        f98.l r175 = (f98.l) CollectionsKt.firstOrNull(r212);
        if (r175 == null) goto L62;
        Object r176 = r175.d();
    L63:
        f98.l r177 = (f98.l) CollectionsKt.firstOrNull(r212);
        if (r177 == null) goto L66;
        Object r178 = r177.a();
    L67:
        r311.invoke(r173, r174, r122, r176, r178);
        goto L68
    L66:
        r178 = null;
        goto L67
    L62:
        r176 = null;
    L68:
        r121 = r212;
        r119 = r104;
        r120 = 0;
        r123 = 0;
        r117 = r101;
        r118 = r162;
        r115 = r312;
    L56:
        r172 = null;
        goto L57
    L36:
        if (r100 != 20) goto L50;
        IDoraService r179 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r179 == null) goto L44;
        DeviceService r180 = r179.device();
        if (r180 == null) goto L44;
        if (r180.J() != true) goto L44;
        boolean r181 = true;
    L45:
        if (r181 == false) goto L50;
        FLogger r182 = FLogger.f375446a;
        StringBuilder r183 = new StringBuilder("GRecord, upload image recordId: ");
        LarkRecordMinutesManager.f294325a.getClass();
        r183.append(LarkRecordMinutesManager.j());
        r182.i("DoraE_Camera", r183.toString());
        r122.j(Boxing.boxInt(DoraVisionBizScene.FPA_MEETING.getValue()));
        JSONObject r184 = new JSONObject();
        String r185 = LarkRecordMinutesManager.j();
        if (r185 != null) goto L49;
        r185 = "";
    L49:
        r184.put("meeting_message_id", r185);
        r122.f(r184.toString());
    L44:
        r181 = false;
        goto L45
    L20:
        if (r163.isEmpty() == false) goto L22;
        r165 = 0;
    L7:
        r101 = new DoraENetworkUtil$uploadImageWithRetry$1(this, r313);
        goto L8
    }
}
