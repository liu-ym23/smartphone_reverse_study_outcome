package pc3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.video.UrlModel;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.SelectBitrateResolutionStrategy;
import com.bytedance.android.shopping.api.video.d;
import com.bytedance.android.shopping.api.video.e;
import com.bytedance.android.shopping.api.video.h;
import com.bytedance.android.shopping.api.video.l;
import com.bytedance.android.shopping.api.video.m;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends SlcRoundFrameLayout {
    public ViewGroup c;
    public ECStatusView d;
    public SimpleDraweeView e;
    public SimpleDraweeView f;
    public ECVideoPlayerView g;
    public Boolean h;

    /* JADX INFO: renamed from: pc3.a$a, reason: collision with other inner class name */
    public static final class C0224a implements h {
        public C0224a(WeakReference<a> r2) {
            Intrinsics.checkNotNullParameter(r2, "viewWeakRef");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, null, 6, 0);
        FrameLayout.inflate(r14, 2131560401, this);
        this.c = (ViewGroup) findViewById(2131384822);
        this.d = findViewById(2131379091);
        this.e = findViewById(2131382424);
        SimpleDraweeView r15 = findViewById(2131368160);
        this.f = r15;
        if (r15 == null) goto L7;
        GenericDraweeHierarchy r16 = r15.getHierarchy();
        if (r16 == null) goto L7;
        r16.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L7:
        ECVideoPlayerView r17 = new ECVideoPlayerView(getContext(), null, 0, new l(AVScene.CONTENT_COMMENT_ITEM, true, true, false, SelectBitrateResolutionStrategy.VIEW_SIZE_ADAPTION, true, false, 136));
        this.g = r17;
        ViewGroup r1 = this.c;
        if (r1 == null) goto L10;
        r1.addView(r17, 0, new ViewGroup.LayoutParams(-1, -1));
    L10:
        ECStatusView r18 = this.d;
        if (r18 == null) goto L14;
        r18.b(getContext(), null, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    public final void b(ECCommentVideo r11, String r12) {
        SimpleDraweeView r0 = this.f;
        boolean r1 = false;
        Object r2 = null;
        if (r0 == null) goto L11;
        UrlModel r3 = r11.getCover();
        if (r3 == null) goto L9;
        List r4 = r3.getUrlList();
        if (r4 == null) goto L9;
        String r5 = (String) CollectionsKt.getOrNull(r4, 0);
    L10:
        r0.setImageURI(r5);
    L9:
        r5 = null;
    L11:
        SimpleDraweeView r6 = this.e;
        if (r6 == null) goto L14;
        r6.setImageURI(r12);
    L14:
        e r13 = m.b(r11, new d(true, false, 0, 0, false, 444));
        ECVideoPlayerView r14 = this.g;
        if (r14 == null) goto L17;
        r14.w(ScaleType.CENTER_CROP);
    L17:
        ECVideoPlayerView r15 = this.g;
        if (r15 == null) goto L20;
        r15.b(r13);
    L20:
        int r16 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r17 = com.bytedance.android.ec.base.settings.a.a;
        Object r18 = 0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L177
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("iesec_comment_slice_video_prerender_opt");     // Catch: Throwable -> L71
        if (r8 != null) goto L26;
    L68:
        Object r9 = null;
    L69:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L71
    L73:
        Throwable r19 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L177
        if (r19 == null) goto L77;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L177
    L77:
        if (Result.isFailure-impl(r10) == false) goto L80;
        r10 = null;
    L80:
        if ((r10 instanceof Integer) == true) goto L82;
        r10 = null;
    L82:
        Object r20 = (Integer) r10;     // Catch: Throwable -> L177
        if (r20 != null) goto L89;
        Object r21 = com.bytedance.android.ec.base.settings.d.a.get("iesec_comment_slice_video_prerender_opt");     // Catch: Throwable -> L177
        if ((r21 instanceof Integer) == true) goto L88;
        r21 = null;
    L88:
        r20 = (Integer) r21;     // Catch: Throwable -> L177
    L89:
        if (r20 != null) goto L187;
        int r22 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L177
        Object r23 = com.bytedance.android.ec.base.settings.d.c.get("iesec_comment_slice_video_prerender_opt");     // Catch: Throwable -> L141
        if (r23 != null) goto L96;
    L138:
        Object r24 = null;
    L139:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L141
    L143:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L167
        if (r26 == null) goto L147;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L167
    L147:
        if (Result.isFailure-impl(r25) == false) goto L150;
        r25 = null;
    L150:
        if ((r25 instanceof Integer) == true) goto L152;
        r25 = null;
    L152:
        r20 = (Integer) r25;     // Catch: Throwable -> L167
        if (r20 != null) goto L175;
        IHybridHostService r27 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L167
        if (r27 == null) goto L158;
        Object r28 = r27.getHostABValue("iesec_comment_slice_video_prerender_opt", r18);     // Catch: Throwable -> L167
    L159:
        if (r28 != null) goto L161;
    L166:
        r20 = r18;
        goto L175
    L161:
        if ((r28 instanceof Integer) == false) goto L164;
        r2 = r28;
    L164:
        Object r29 = (Integer) r2;     // Catch: Throwable -> L167
        if (r29 == null) goto L166;
    L174:
        r20 = r29;
        goto L175
    L158:
        r28 = null;
    L175:
        com.bytedance.android.ec.base.settings.d.d("iesec_comment_slice_video_prerender_opt", r20);     // Catch: Throwable -> L177
        goto L187
    L96:
        if ((r23 instanceof Integer) == true) goto L98;
        Object r30 = null;
    L99:
        r24 = (Integer) r30;     // Catch: Throwable -> L141
        if (r24 != null) goto L139;
        if ((r23 instanceof Number) == false) goto L126;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L111;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L141
        if ((r31 instanceof Integer) == true) goto L109;
        r31 = null;
    L109:
        r24 = (Integer) r31;     // Catch: Throwable -> L141
        goto L139
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L117;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L141
        if ((r32 instanceof Integer) == true) goto L115;
        r32 = null;
    L115:
        r24 = (Integer) r32;     // Catch: Throwable -> L141
        goto L139
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L120;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L141
        goto L139
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L126;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L141
        if ((r33 instanceof Integer) == true) goto L124;
        r33 = null;
    L124:
        r24 = (Integer) r33;     // Catch: Throwable -> L141
    L126:
        if ((r23 instanceof JSONObject) == false) goto L128;
    L199:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L134
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L134
        if ((r34 instanceof Integer) == true) goto L132;
        r34 = null;
    L132:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L134
    L136:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L139;
    L134:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L141
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L136
    L128:
        if ((r23 instanceof JSONArray) == false) goto L138;
    L98:
        r30 = r23;
    L167:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L177
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
        Throwable r38 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L177
        if (r38 == null) goto L172;
        EnsureManager.ensureNotReachHere(r38);     // Catch: Throwable -> L177
    L172:
        if (Result.isFailure-impl(r29) == false) goto L174;
        r29 = r18;
    L141:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L167
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L187:
        if (((Number) r20).intValue() != 1) goto L189;
        r1 = true;
    L189:
        if (r1 == false) goto L208;
        Boolean r110 = this.h;
        Boolean r40 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r110, r40)) == false) goto L209;
        ECVideoPlayerView r111 = this.g;
        if (r111 == null) goto L195;
        r111.p();
    L195:
        this.h = r40;
        return;
    L209:
        return;
    L208:
        return;
    L26:
        if ((r8 instanceof Integer) == true) goto L28;
        Object r41 = null;
    L29:
        r9 = (Integer) r41;     // Catch: Throwable -> L71
        if (r9 != null) goto L69;
        if ((r8 instanceof Number) == false) goto L56;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L41;
        Float r42 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L71
        if ((r42 instanceof Integer) == true) goto L39;
        r42 = null;
    L39:
        r9 = (Integer) r42;     // Catch: Throwable -> L71
        goto L69
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L47;
        Double r43 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L71
        if ((r43 instanceof Integer) == true) goto L45;
        r43 = null;
    L45:
        r9 = (Integer) r43;     // Catch: Throwable -> L71
        goto L69
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L50;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L71
        goto L69
    L50:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L56;
        Long r44 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L71
        if ((r44 instanceof Integer) == true) goto L54;
        r44 = null;
    L54:
        r9 = (Integer) r44;     // Catch: Throwable -> L71
    L56:
        if ((r8 instanceof JSONObject) == false) goto L58;
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L64
        Object r45 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L64
        if ((r45 instanceof Integer) == true) goto L62;
        r45 = null;
    L62:
        Object r46 = Result.constructor-impl((Integer) r45);     // Catch: Throwable -> L64
    L66:
        r9 = r46;
        if (Result.isFailure-impl(r9) == false) goto L69;
    L64:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L71
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L71
        goto L66
    L58:
        if ((r8 instanceof JSONArray) == false) goto L68;
    L28:
        r41 = r8;
    L71:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L177
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
    L177:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r112 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r50 = Result.exceptionOrNull-impl(r112);
        if (r50 == null) goto L182;
        EnsureManager.ensureNotReachHere(r50);
    L182:
        if (Result.isFailure-impl(r112) == true) goto L185;
        r18 = r112;
    L185:
        r20 = r18;
        goto L187
    }

    public final void c(Map<?, ?> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "videoInfoMap");
        Intrinsics.checkNotNullParameter(r3, "playBtnUrl");
        ECCommentVideo r4 = (ECCommentVideo) u0.b(k.d(r2), ECCommentVideo.class);     // Catch: JSONException -> L8
        if (r4 != null) goto L6;
        return;
    L6:
        b(r4, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
