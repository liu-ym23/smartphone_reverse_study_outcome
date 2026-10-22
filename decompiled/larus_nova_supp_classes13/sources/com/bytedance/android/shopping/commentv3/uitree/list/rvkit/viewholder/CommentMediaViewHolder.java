package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.View;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.e;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/CommentMediaViewHolder;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentMediaViewHolder extends BaseSliceViewHolder<CommentSliceView> {
    public static final List<CommentMediaViewHolder> j = null;

    public static final class a {
        public static void a(boolean r9) {
            Iterator r0 = ((ArrayList) CommentMediaViewHolder.j).iterator();
        L3:
            Object r2 = null;
            if (r0.hasNext() == false) goto L199;
            CommentMediaViewHolder r1 = (CommentMediaViewHolder) r0.next();
            int r3 = ec3.a.a;
            int r4 = com.bytedance.android.ec.base.settings.b.a;
            int r5 = e.a;
            Object r6 = e.a(Boolean.TRUE, Boolean.FALSE);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L173
            h.a();     // Catch: Throwable -> L173
            SDKSettingsCacheManager r8 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L173
            r8.getClass();     // Catch: Throwable -> L61
            Object r10 = SDKSettingsCacheManager.b.get("ec_comment_player_release_on_destroy");     // Catch: Throwable -> L61
            if (r10 != null) goto L13;
        L58:
            Object r11 = null;
        L59:
            Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L61
        L63:
            Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L173
            if (r13 == null) goto L67;
            EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L173
        L67:
            if (Result.isFailure-impl(r12) == false) goto L70;
            r12 = null;
        L70:
            if ((r12 instanceof Boolean) == true) goto L72;
            r12 = null;
        L72:
            Object r14 = (Boolean) r12;     // Catch: Throwable -> L173
            if (r14 != null) goto L79;
            r8.getClass();     // Catch: Throwable -> L173
            Object r15 = SDKSettingsCacheManager.a.get("ec_comment_player_release_on_destroy");     // Catch: Throwable -> L173
            if ((r15 instanceof Boolean) == true) goto L78;
            r15 = null;
        L78:
            r14 = (Boolean) r15;     // Catch: Throwable -> L173
        L79:
            if (r14 != null) goto L183;
            int r16 = g.a;     // Catch: Throwable -> L173
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L135
            Object r17 = SDKSettingsCacheManager.b.get("ec_comment_player_release_on_destroy");     // Catch: Throwable -> L135
            if (r17 != null) goto L87;
        L132:
            Object r18 = null;
        L133:
            Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L135
        L137:
            Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L160
            if (r20 == null) goto L141;
            EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L160
        L141:
            if (Result.isFailure-impl(r19) == false) goto L144;
            r19 = null;
        L144:
            if ((r19 instanceof Boolean) == true) goto L146;
            r19 = null;
        L146:
            Object r21 = (Boolean) r19;     // Catch: Throwable -> L160
            if (r21 != null) goto L170;
            jj4.b r22 = jj4.b.b;     // Catch: Throwable -> L160
            Object r23 = jj4.a.a("ec_comment_player_release_on_destroy", Boolean.class, r6, false);     // Catch: Throwable -> L160
            if (r23 != null) goto L153;
            Intrinsics.throwNpe();     // Catch: Throwable -> L160
        L153:
            if ((r23 instanceof Boolean) == true) goto L155;
            r23 = null;
        L155:
            Object r24 = (Boolean) r23;     // Catch: Throwable -> L160
            if (r24 != null) goto L158;
            r24 = r6;
        L158:
            r21 = Result.constructor-impl(r24);     // Catch: Throwable -> L160
        L163:
            if (Result.exceptionOrNull-impl(r21) == null) goto L170;
            r21 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_comment_player_release_on_destroy", Boolean.class, r6);     // Catch: Throwable -> L167
        L168:
            if (r21 != null) goto L170;
            r14 = r6;
        L171:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L173
            SDKSettingsCacheManager.e("ec_comment_player_release_on_destroy", r14);     // Catch: Throwable -> L173
        L167:
            r21 = r6;
        L170:
            r14 = r21;
            goto L171
        L87:
            if ((r17 instanceof Boolean) == true) goto L89;
            Object r25 = null;
        L90:
            r18 = (Boolean) r25;     // Catch: Throwable -> L135
            if (r18 != null) goto L133;
            if ((r17 instanceof Number) == false) goto L120;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
            Float r26 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L135
            if ((r26 instanceof Boolean) == true) goto L100;
            r26 = null;
        L100:
            r18 = (Boolean) r26;     // Catch: Throwable -> L135
            goto L133
        L102:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
            Double r27 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L135
            if ((r27 instanceof Boolean) == true) goto L106;
            r27 = null;
        L106:
            r18 = (Boolean) r27;     // Catch: Throwable -> L135
            goto L133
        L108:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L114;
            Integer r28 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L135
            if ((r28 instanceof Boolean) == true) goto L112;
            r28 = null;
        L112:
            r18 = (Boolean) r28;     // Catch: Throwable -> L135
            goto L133
        L114:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L120;
            Long r29 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L135
            if ((r29 instanceof Boolean) == true) goto L118;
            r29 = null;
        L118:
            r18 = (Boolean) r29;     // Catch: Throwable -> L135
        L120:
            if ((r17 instanceof JSONObject) == false) goto L122;
        L398:
            Object r30 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Boolean.class);     // Catch: Throwable -> L128
            if ((r30 instanceof Boolean) == true) goto L126;
            r30 = null;
        L126:
            Object r31 = Result.constructor-impl((Boolean) r30);     // Catch: Throwable -> L128
        L130:
            r18 = r31;
            if (Result.isFailure-impl(r18) == false) goto L133;
        L128:
            th = move-exception;
            Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L135
            r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
            goto L130
        L122:
            if ((r17 instanceof JSONArray) == false) goto L132;
        L89:
            r25 = r17;
            goto L90
        L135:
            th = move-exception;
            Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L160
            r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
            goto L137
        L160:
            th = move-exception;
            Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L173
            r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        L183:
            if (((Boolean) r14).booleanValue() == true) goto L184;
            r1.Z3();
            goto L3
        L184:
            if (r9 == true) goto L186;
            pc3.a r35 = r1.a4();
            if (r35 == null) goto L3;
            ECVideoPlayerView r36 = r35.g;
            if (r36 == null) goto L197;
            r36.s();
        L197:
            r35.h = null;
            goto L3
        L186:
            if (r1.a4() == null) goto L3;
            int r37 = ECSdk.a;
            s83.g r38 = (s83.g) ECSdk.a(s83.g.class);
            if (r38 == null) goto L3;
            f r39 = r38.p();
            if (r39 == null) goto L3;
            r39.j();
            goto L3
        L13:
            if ((r10 instanceof Boolean) == true) goto L15;
            Object r40 = null;
        L16:
            r11 = (Boolean) r40;     // Catch: Throwable -> L61
            if (r11 != null) goto L59;
            if ((r10 instanceof Number) == false) goto L46;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L28;
            Float r41 = Float.valueOf(((Number) r10).floatValue());     // Catch: Throwable -> L61
            if ((r41 instanceof Boolean) == true) goto L26;
            r41 = null;
        L26:
            r11 = (Boolean) r41;     // Catch: Throwable -> L61
            goto L59
        L28:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L34;
            Double r42 = Double.valueOf(((Number) r10).doubleValue());     // Catch: Throwable -> L61
            if ((r42 instanceof Boolean) == true) goto L32;
            r42 = null;
        L32:
            r11 = (Boolean) r42;     // Catch: Throwable -> L61
            goto L59
        L34:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
            Integer r43 = Integer.valueOf(((Number) r10).intValue());     // Catch: Throwable -> L61
            if ((r43 instanceof Boolean) == true) goto L38;
            r43 = null;
        L38:
            r11 = (Boolean) r43;     // Catch: Throwable -> L61
            goto L59
        L40:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
            Long r44 = Long.valueOf(((Number) r10).longValue());     // Catch: Throwable -> L61
            if ((r44 instanceof Boolean) == true) goto L44;
            r44 = null;
        L44:
            r11 = (Boolean) r44;     // Catch: Throwable -> L61
        L46:
            if ((r10 instanceof JSONObject) == false) goto L48;
        L381:
            Object r45 = SDKSettingsCacheManager.a().fromJson(r10.toString(), Boolean.class);     // Catch: Throwable -> L54
            if ((r45 instanceof Boolean) == true) goto L52;
            r45 = null;
        L52:
            Object r46 = Result.constructor-impl((Boolean) r45);     // Catch: Throwable -> L54
        L56:
            r11 = r46;
            if (Result.isFailure-impl(r11) == false) goto L59;
        L54:
            th = move-exception;
            Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L61
            r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
            goto L56
        L48:
            if ((r10 instanceof JSONArray) == false) goto L58;
        L15:
            r40 = r10;
            goto L16
        L61:
            th = move-exception;
            Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L173
            r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
        L173:
            th = move-exception;
            Result.Companion r49 = Result.Companion;
            Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r51 = Result.exceptionOrNull-impl(r50);
            if (r51 == null) goto L178;
            EnsureManager.ensureNotReachHere(r51);
        L178:
            if (Result.isFailure-impl(r50) == true) goto L181;
            r6 = r50;
        L181:
            r14 = r6;
            goto L183
        L199:
            ((ArrayList) CommentMediaViewHolder.j).clear();
            if (r9 == false) goto L423;
            int r52 = ec3.a.a;
            int r53 = n.a;
            Object r54 = Boolean.FALSE;
            int r55 = com.bytedance.android.ec.base.settings.a.a;
            Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L364
            Object r57 = d.c.get("ec_comment_player_fix_media_list_miss");     // Catch: Throwable -> L255
            if (r57 != null) goto L207;
        L252:
            Object r58 = null;
        L253:
            Object r59 = Result.constructor-impl(r58);     // Catch: Throwable -> L255
        L257:
            Throwable r60 = Result.exceptionOrNull-impl(r59);     // Catch: Throwable -> L364
            if (r60 == null) goto L261;
            EnsureManager.ensureNotReachHere(r60);     // Catch: Throwable -> L364
        L261:
            if (Result.isFailure-impl(r59) == false) goto L264;
            r59 = null;
        L264:
            if ((r59 instanceof Boolean) == true) goto L266;
            r59 = null;
        L266:
            Object r61 = (Boolean) r59;     // Catch: Throwable -> L364
            if (r61 != null) goto L273;
            Object r62 = d.a.get("ec_comment_player_fix_media_list_miss");     // Catch: Throwable -> L364
            if ((r62 instanceof Boolean) == true) goto L272;
            r62 = null;
        L272:
            r61 = (Boolean) r62;     // Catch: Throwable -> L364
        L273:
            if (r61 != null) goto L374;
            int r63 = c.a;     // Catch: Throwable -> L364
            Object r64 = d.c.get("ec_comment_player_fix_media_list_miss");     // Catch: Throwable -> L328
            if (r64 != null) goto L280;
        L325:
            Object r65 = null;
        L326:
            Object r66 = Result.constructor-impl(r65);     // Catch: Throwable -> L328
        L330:
            Throwable r67 = Result.exceptionOrNull-impl(r66);     // Catch: Throwable -> L354
            if (r67 == null) goto L334;
            EnsureManager.ensureNotReachHere(r67);     // Catch: Throwable -> L354
        L334:
            if (Result.isFailure-impl(r66) == false) goto L337;
            r66 = null;
        L337:
            if ((r66 instanceof Boolean) == true) goto L339;
            r66 = null;
        L339:
            r61 = (Boolean) r66;     // Catch: Throwable -> L354
            if (r61 != null) goto L362;
            IHybridHostService r68 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L354
            if (r68 == null) goto L345;
            Object r69 = r68.getHostABValue("ec_comment_player_fix_media_list_miss", r54);     // Catch: Throwable -> L354
        L346:
            if (r69 != null) goto L348;
        L353:
            r61 = r54;
            goto L362
        L348:
            if ((r69 instanceof Boolean) == false) goto L351;
            r2 = r69;
        L351:
            Object r70 = (Boolean) r2;     // Catch: Throwable -> L354
            if (r70 == null) goto L353;
        L361:
            r61 = r70;
            goto L362
        L345:
            r69 = null;
        L362:
            d.d("ec_comment_player_fix_media_list_miss", r61);     // Catch: Throwable -> L364
            goto L374
        L280:
            if ((r64 instanceof Boolean) == true) goto L282;
            Object r71 = null;
        L283:
            r65 = (Boolean) r71;     // Catch: Throwable -> L328
            if (r65 != null) goto L326;
            if ((r64 instanceof Number) == false) goto L313;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L295;
            Float r72 = Float.valueOf(((Number) r64).floatValue());     // Catch: Throwable -> L328
            if ((r72 instanceof Boolean) == true) goto L293;
            r72 = null;
        L293:
            r65 = (Boolean) r72;     // Catch: Throwable -> L328
            goto L326
        L295:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L301;
            Double r73 = Double.valueOf(((Number) r64).doubleValue());     // Catch: Throwable -> L328
            if ((r73 instanceof Boolean) == true) goto L299;
            r73 = null;
        L299:
            r65 = (Boolean) r73;     // Catch: Throwable -> L328
            goto L326
        L301:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L307;
            Integer r74 = Integer.valueOf(((Number) r64).intValue());     // Catch: Throwable -> L328
            if ((r74 instanceof Boolean) == true) goto L305;
            r74 = null;
        L305:
            r65 = (Boolean) r74;     // Catch: Throwable -> L328
            goto L326
        L307:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L313;
            Long r75 = Long.valueOf(((Number) r64).longValue());     // Catch: Throwable -> L328
            if ((r75 instanceof Boolean) == true) goto L311;
            r75 = null;
        L311:
            r65 = (Boolean) r75;     // Catch: Throwable -> L328
        L313:
            if ((r64 instanceof JSONObject) == false) goto L315;
        L394:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L321
            Object r76 = SDKSettingsCacheManager.a().fromJson(r64.toString(), Boolean.class);     // Catch: Throwable -> L321
            if ((r76 instanceof Boolean) == true) goto L319;
            r76 = null;
        L319:
            Object r77 = Result.constructor-impl((Boolean) r76);     // Catch: Throwable -> L321
        L323:
            r65 = r77;
            if (Result.isFailure-impl(r65) == false) goto L326;
        L321:
            th = move-exception;
            Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L328
            r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
            goto L323
        L315:
            if ((r64 instanceof JSONArray) == false) goto L325;
        L282:
            r71 = r64;
        L354:
            th = move-exception;
            Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L364
            r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L364
            Throwable r80 = Result.exceptionOrNull-impl(r70);     // Catch: Throwable -> L364
            if (r80 == null) goto L359;
            EnsureManager.ensureNotReachHere(r80);     // Catch: Throwable -> L364
        L359:
            if (Result.isFailure-impl(r70) == false) goto L361;
            r70 = r54;
        L328:
            th = move-exception;
            Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L354
            r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L354
        L374:
            if (((Boolean) r61).booleanValue() == false) goto L424;
            int r82 = ECSdk.a;
            s83.g r84 = (s83.g) ECSdk.a(s83.g.class);
            if (r84 == null) goto L425;
            f r85 = r84.p();
            if (r85 == null) goto L426;
            r85.j();
            return;
        L426:
            return;
        L425:
            return;
        L424:
            return;
        L207:
            if ((r57 instanceof Boolean) == true) goto L209;
            Object r86 = null;
        L210:
            r58 = (Boolean) r86;     // Catch: Throwable -> L255
            if (r58 != null) goto L253;
            if ((r57 instanceof Number) == false) goto L240;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L222;
            Float r87 = Float.valueOf(((Number) r57).floatValue());     // Catch: Throwable -> L255
            if ((r87 instanceof Boolean) == true) goto L220;
            r87 = null;
        L220:
            r58 = (Boolean) r87;     // Catch: Throwable -> L255
            goto L253
        L222:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L228;
            Double r88 = Double.valueOf(((Number) r57).doubleValue());     // Catch: Throwable -> L255
            if ((r88 instanceof Boolean) == true) goto L226;
            r88 = null;
        L226:
            r58 = (Boolean) r88;     // Catch: Throwable -> L255
            goto L253
        L228:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L234;
            Integer r89 = Integer.valueOf(((Number) r57).intValue());     // Catch: Throwable -> L255
            if ((r89 instanceof Boolean) == true) goto L232;
            r89 = null;
        L232:
            r58 = (Boolean) r89;     // Catch: Throwable -> L255
            goto L253
        L234:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L240;
            Long r90 = Long.valueOf(((Number) r57).longValue());     // Catch: Throwable -> L255
            if ((r90 instanceof Boolean) == true) goto L238;
            r90 = null;
        L238:
            r58 = (Boolean) r90;     // Catch: Throwable -> L255
        L240:
            if ((r57 instanceof JSONObject) == false) goto L242;
        L387:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L248
            Object r91 = SDKSettingsCacheManager.a().fromJson(r57.toString(), Boolean.class);     // Catch: Throwable -> L248
            if ((r91 instanceof Boolean) == true) goto L246;
            r91 = null;
        L246:
            Object r92 = Result.constructor-impl((Boolean) r91);     // Catch: Throwable -> L248
        L250:
            r58 = r92;
            if (Result.isFailure-impl(r58) == false) goto L253;
        L248:
            th = move-exception;
            Result.Companion r94 = Result.Companion;     // Catch: Throwable -> L255
            r92 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L255
            goto L250
        L242:
            if ((r57 instanceof JSONArray) == false) goto L252;
        L209:
            r86 = r57;
        L255:
            th = move-exception;
            Result.Companion r95 = Result.Companion;     // Catch: Throwable -> L364
            r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L364
        L364:
            th = move-exception;
            Result.Companion r96 = Result.Companion;
            Object r97 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r98 = Result.exceptionOrNull-impl(r97);
            if (r98 == null) goto L369;
            EnsureManager.ensureNotReachHere(r98);
        L369:
            if (Result.isFailure-impl(r97) == true) goto L372;
            r54 = r97;
        L372:
            r61 = r54;
            goto L374
        }
    }

    static {
        j = new ArrayList();
    }

    public final pc3.a a4() {
        SliceCardView r0 = this.a;
        Object r1 = null;
        if (r0 == 0) goto L5;
        View r2 = qc3.a.a(r0, CommentMediaViewHolder$findVideoView$1.INSTANCE);
    L7:
        if ((r2 instanceof pc3.a) == false) goto L11;
        r1 = r2;
    L11:
        return (pc3.a) r1;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, java.lang.Object, pc3.a] */
    public final void Z3() {
        ?? r0 = a4();
        if (r0 != 0) goto L5;
        return;
    L5:
        if (NetworkUtils.isWifi(r0.getContext()) == false) goto L19;
        ECVideoPlayerView r1 = r0.g;
        if (r1 != null) goto L9;
    L11:
        pc3.a.C0224a r2 = new pc3.a.C0224a(new WeakReference(r0));
        ECVideoPlayerView r3 = r0.g;
        if (r3 == null) goto L14;
        r3.r(r2);
    L14:
        ECVideoPlayerView r4 = r0.g;
        if (r4 == null) goto L20;
        r4.n();
        return;
    L20:
        return;
    L9:
        if (r1.h() != true) goto L11;
        return;
    }

    public CommentMediaViewHolder(CommentSliceView r2, com.bytedance.android.shopping.commentv3.base.c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2, r3);
    }
}
