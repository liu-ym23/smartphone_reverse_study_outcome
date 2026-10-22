package mx6;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.pdp.container.view.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;
import yw6.a0;
import yw6.g;
import yw6.h;
import yw6.u;
import yw6.v;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f516244h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f516245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f516246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f516247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f516248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f516249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xl4.a f516250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super View, Unit> f516251g;

    /* JADX INFO: renamed from: mx6.a$a, reason: collision with other inner class name */
    public static final class C6871a {
        public C6871a() {
        }

        public static final JSONObject a(String r100) {
            int r101 = a.f516244h;
            if (r100 == null) goto L17;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
            Object r103 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L7
        L10:
            if (Result.m9452exceptionOrNullimpl(r103) == null) goto L14;
            r103 = new JSONObject();
        L14:
            return (JSONObject) r103;
        L7:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        L17:
            return new JSONObject();
        }
    }

    public interface b {
        void update(int r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f516252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f516253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f516254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f516255d;

        public c(a r100, ViewGroup r101, u r102, String r103) {
            this.f516252a = r100;
            this.f516253b = r101;
            this.f516254c = r102;
            this.f516255d = r103;
        }

        public final void a() {
            a r100 = this.f516252a;
            ViewGroup r101 = this.f516253b;
            u r102 = this.f516254c;
            String r110 = this.f516255d;
            r100.getClass();
            if (r102.e() == null) goto L92;
            Context r103 = r101.getContext();
            Intrinsics.checkNotNullParameter(r103, "<this>");
            if ((r103 instanceof Activity) == false) goto L10;
            Activity r104 = (Activity) r103;
        L8:
            Activity r105 = r104;
            if (r110 == null) goto L25;
            long r111 = HostServiceUtilsKt.i0().c("marketing_coupon_share", r110, 0);
            if (r111 <= 0) goto L25;
            long r106 = System.currentTimeMillis();
            if (r106 <= r111) goto L26;
            long r112 = BaseConstants.Time.DAY;
            if ((r106 / r112) > (r111 / r112)) goto L25;
        L26:
            boolean r107 = false;
        L28:
            if (r107 == true) goto L34;
            Iterator r108 = ((ArrayList) r100.f516249e).iterator();
        L31:
            if (r108.hasNext() == false) goto L33;
            ((b) r108.next()).update(0);
            goto L31
        L33:
            m r109 = r100.f516246b;
            r109.a("merchant_share_bubble_show", MapsKt.plus(r109.b(), r100.c(r102.i())));
            return;
        L34:
            View r113 = LayoutInflater.from(r101.getContext()).inflate(R.layout.saas_poi_coupon_share_action_bubble_content, r101, false);
            DuxTextView r114 = (DuxTextView) r113.findViewById(R.id.bubble_text);
            g r115 = r102.e();
            if (r115 == null) goto L37;
            String r116 = r115.b();
        L38:
            if (r116 != null) goto L40;
        L43:
            boolean r117 = true;
        L45:
            if (r117 == false) goto L47;
            r113.setVisibility(8);
        L78:
            boolean r118 = false;
        L80:
            xl4.a.C8252a r119 = new xl4.a.C8252a(r105);
            r119.f564476j = r118;
            Intrinsics.checkNotNullParameter(r113, "view");
            r119.f564477k = r113;
            r119.f564471e = true;
            r119.f564470d = ColorProtector.parseColor("#393B44");
            r119.D = true;
            mx6.c r120 = new mx6.c(r100, r113, r102);
            Intrinsics.checkNotNullParameter(r120, "listener");
            r119.f564483q = r120;
            d r121 = new d(r100);
            Intrinsics.checkNotNullParameter(r121, "listener");
            r119.f564484r = r121;
            r100.f516250f = new xl4.a(r119);
            Intrinsics.checkNotNullParameter(r101, "anchor");
            xl4.a r122 = r100.f516250f;
            if (r122 == null) goto L93;
            int r123 = em4.g.e(r101.getContext());
            int[] r124 = new int[2];
            r101.getLocationOnScreen(r124);
            int r125 = r124[0];
            int r126 = r122.d();
            int r127 = (((r101.getWidth() / 2) + r125) - (r123 - r122.f())) - r126;
            float r128 = 10;
            Resources r129 = Resources.getSystem();
            int r130 = r127 + MathKt.roundToInt(TypedValue.applyDimension(1, r128, WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics())));
            int r131 = r123 - ((r125 + r122.f()) - r126);
            Resources r132 = Resources.getSystem();
            r122.l(r101, 80, false, r130, r131 - MathKt.roundToInt(TypedValue.applyDimension(1, r128, WindowDisplayMetricsOverride.apply(r132, r132.getDisplayMetrics()))), 0);
            if (r110 == null) goto L86;
            HostServiceUtilsKt.i0().f("marketing_coupon_share", r110, System.currentTimeMillis());
        L86:
            m r133 = r100.f516246b;
            r133.a("merchant_share_bubble_show", MapsKt.plus(MapsKt.plus(r133.b(), r100.c(r100.f516245a.i())), MapsKt.mapOf(TuplesKt.to("bubble_type", "1"))));
            return;
        L93:
            return;
        L47:
            r113.setVisibility(0);
            r114.setText(r116);
            int r134 = a.f516244h;
            v r135 = r102.i();
            if (r135 == null) goto L52;
            a0 r136 = r135.b();
            if (r136 == null) goto L52;
            String r137 = r136.a();
        L53:
            int r138 = C6871a.a(r137).optInt("status");
            DuxTextView r139 = (DuxTextView) r113.findViewById(R.id.bubble_action_text);
            View r140 = r113.findViewById(R.id.bubble_text_dividing_line);
            Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L61
            g r142 = r102.e();     // Catch: Throwable -> L61
            if (r142 == null) goto L58;
            String r143 = r142.a();     // Catch: Throwable -> L61
            if (r143 == null) goto L58;
        L59:
            Object r144 = Result.m9449constructorimpl(new JSONObject(r143));     // Catch: Throwable -> L61
        L64:
            if (Result.m9455isFailureimpl(r144) == false) goto L66;
            r144 = null;
        L66:
            JSONObject r145 = (JSONObject) r144;
            if (r145 == null) goto L69;
            String r146 = r145.optString("play_status_" + r138);
        L70:
            if (r146 != null) goto L72;
        L75:
            boolean r147 = true;
        L76:
            if (r147 == false) goto L79;
            r139.setVisibility(8);
            r140.setVisibility(8);
            goto L78
        L79:
            r139.setText(r146);
            r118 = false;
            r139.setVisibility(0);
            r140.setVisibility(0);
            goto L80
        L72:
            if (r146.length() == 0) goto L75;
            r147 = false;
            goto L76
        L69:
            r146 = null;
        L58:
            r143 = SliceInitService.DEFAULT_SWITCH;
        L61:
            th = move-exception;
            Result.Companion r148 = Result.Companion;
            r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L52:
            r137 = null;
            goto L53
        L40:
            if (r116.length() == 0) goto L43;
            r117 = false;
            goto L45
        L37:
            r116 = null;
        L25:
            r107 = true;
            goto L28
        L10:
            if ((r103 instanceof ContextThemeWrapper) == false) goto L14;
            ContextThemeWrapper r149 = (ContextThemeWrapper) r103;
            if ((r149.getBaseContext() instanceof Activity) == false) goto L14;
            Context r150 = r149.getBaseContext();
            Intrinsics.checkNotNull(r150, "null cannot be cast to non-null type android.app.Activity");
            r104 = (Activity) r150;
        L14:
            r104 = HostServiceUtilsKt.E().getCurrentActivity();
            Intrinsics.checkNotNull(r104);
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        new C6871a();
    }

    public final Map<String, String> c(v r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        if (r110 != null) goto L5;
        return r100;
    L5:
        a0 r101 = r110.b();
        if (r101 == null) goto L19;
        JSONObject r102 = C6871a.a(r101.a());
        String r103 = r102.optString("play_share_id");
        JSONObject r104 = r102.optJSONObject("play_info");
        String r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.optString(InstantPlayContext.PLAY_ID);
    L11:
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r100.put("play_share_id", r103);
        r100.put(InstantPlayContext.PLAY_ID, r106);
        v r107 = this.f516245a.i();
        if (r107 == null) goto L18;
        a0 r108 = r107.b();
        if (r108 == null) goto L18;
        r105 = r108.a();
    L18:
        r100.put("share_task_fromuser_info", new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("share_task_fromuser_status", String.valueOf(C6871a.a(r105).optInt("status"))), TuplesKt.to("play_share_id", r103)})).toString());
        goto L19
    L10:
        r106 = null;
    L19:
        a0 r111 = r110.a();
        if (r111 != null) goto L22;
        return r100;
    L22:
        JSONObject r109 = C6871a.a(r111.a());
        String r112 = r109.optString("play_share_id");
        String r113 = String.valueOf(r109.optInt("status", -1));
        if (r109.length() > 0) goto L26;
        r100.put("share_task_touser_info", new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("status_code", Integer.valueOf(r111.b())), TuplesKt.to("status_message", r111.c())})).toString());
        return r100;
    L26:
        r100.put("share_task_touser_info", new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("share_task_touser_status", r113), TuplesKt.to("play_share_id", r112), TuplesKt.to("status_code", Integer.valueOf(r111.b()))})).toString());
        return r100;
    }

    public a(u r100, com.bytedance.locallife.pdp.container.view.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "trackResponder");
        this.f516245a = r100;
        this.f516246b = r101;
        this.f516249e = new ArrayList();
    }

    public final View b(ViewGroup r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "data");
        String r102 = null;
        if (r101.f() != null) goto L5;
        return null;
    L5:
        boolean r103 = false;
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_coupon_share_simple_bubble, r100, false);
        r104.setVisibility(8);
        DuxTextView r105 = (DuxTextView) r104.findViewById(R.id.simple_bubble_text);
        v r106 = r101.i();
        if (r106 == null) goto L10;
        a0 r107 = r106.b();
        if (r107 == null) goto L10;
        String r108 = r107.a();
    L11:
        int r109 = C6871a.a(r108).optInt("status");
        h r110 = r101.f();
        if (r110 == null) goto L14;
        r102 = r110.a();
    L14:
        String r111 = C6871a.a(r102).optString("play_status_" + r109);
        if (r111 != null) goto L17;
    L18:
        r103 = true;
    L19:
        if (r103 == true) goto L31;
        DuxImageView r112 = (DuxImageView) r104.findViewById(R.id.simple_bubble_bg);
        if (r109 != 1) goto L24;
    L29:
        r112.setBackgroundResource(R.drawable.bg_coupon_share_bubble_2_chars);
        com.bytedance.dux.indicator.b.a(r112, (int) wo6.a.a(r104.getContext(), 26.0f));
    L30:
        r104.setTranslationY(wo6.a.a(r104.getContext(), -11.0f));
        r105.setText(r111);
        ((ArrayList) this.f516249e).add(new mx6.b(r104, this, r101));
        goto L31
    L24:
        if (r109 != 2) goto L26;
        r112.setBackgroundResource(R.drawable.bg_coupon_share_bubble_3_chars);
        com.bytedance.dux.indicator.b.a(r112, (int) wo6.a.a(r104.getContext(), 36.0f));
        goto L30
    L26:
        if (r109 == 3) goto L29;
    L31:
        r100.addView(r104);
        return r104;
    L17:
        if (r111.length() != 0) goto L19;
    L10:
        r108 = null;
        goto L11
    }

    public final void a(ViewGroup r100, u r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f516247c == false) goto L8;
        return;
    L8:
        this.f516247c = true;
        r100.post(new c(this, r100, r101, r102));
    }
}
