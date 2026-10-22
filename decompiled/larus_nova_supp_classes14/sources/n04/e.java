package n04;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.profile.m;
import com.bytedance.awemeopen.apps.framework.utils.o0;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends c {
    public final DmtTextView a;
    public final DmtTextView b;
    public final AoImageView c;
    public final View d;
    public b e;

    public static final class a {
    }

    static {
    }

    public e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3);
        LayoutInflater.from(r3).inflate(2131558688, this, true);
        this.c = findViewById(2131363075);
        this.a = (DmtTextView) findViewById(2131363074);
        this.b = (DmtTextView) findViewById(2131363073);
        this.d = findViewById(2131363076);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // n04.c
    public final void a(b r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        this.e = r7;
        this.a.setText(r7.a.f());
        this.b.setText(r7.a.e());
        JsonObject r0 = new JsonParser().parse(r7.a.a());     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Exception -> L5
        boolean r1 = r0.get("has_new").getAsBoolean();     // Catch: Exception -> L5
    L6:
        if (r1 == false) goto L8;
        x54.b.d(this.d);
    L9:
        List r4 = null;
        if (r7.b == false) goto L17;
        AoImageView r2 = this.c;
        t14.a r8 = r7.a.c();
        if (r8 == null) goto L14;
        r4 = r8.g();
    L14:
        com.bytedance.awemeopen.infra.base.image.b r5 = new com.bytedance.awemeopen.infra.base.image.b(r4);
        Resources r3 = Resources.getSystem();
        r5.s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r2.j(r5);
        this.a.setTextColor(getContext().getResources().getColor(2131100352));
        this.b.setTextColor(getContext().getResources().getColor(2131100273));
        if (r1 == false) goto L26;
        this.d.setBackgroundResource(2131231587);
        return;
    L26:
        return;
    L17:
        AoImageView r6 = this.c;
        t14.a r9 = r7.a.d();
        if (r9 == null) goto L20;
        r4 = r9.g();
    L20:
        com.bytedance.awemeopen.infra.base.image.b r10 = new com.bytedance.awemeopen.infra.base.image.b(r4);
        Resources r11 = Resources.getSystem();
        r10.s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
        r6.j(r10);
        this.a.setTextColor(getContext().getResources().getColor(2131100353));
        this.b.setTextColor(getContext().getResources().getColor(2131100342));
        if (r1 == false) goto L28;
        this.d.setBackgroundResource(2131231586);
        return;
    L28:
        return;
    L8:
        x54.b.b(this.d);
    L5:
        r1 = false;
        goto L6
    }

    @Override // n04.c
    public final void b(m r6) {
        Intrinsics.checkNotNullParameter(r6, "pgParameters");
        if (r6.getActivity() != null) goto L5;
        return;
    L5:
        x54.b.b(this.d);
        b r0 = this.e;
        if (r0 == null) goto L14;
        com.bytedance.awemeopen.bizmodels.profile.c r1 = r0.a;
        if (r1 == null) goto L15;
        String r2 = r1.b();
        if (r2 == null) goto L16;
        ProfilePageConfig r3 = r6.b.getPageConfig();
        LinkedHashMap r4 = new LinkedHashMap();
        d r5 = e(r6, r3);
        r4.put("entrance_location", r5.a);
        r4.put("store_source_page", r5.b);
        r4.put("store_group_type", r5.c);
        r4.put("store_source_method", r5.d);
        r4.put("source_page", r5.f);
        d14.a r7 = b14.a.a;
        b14.a.a(s24.a.class).j(r6.getActivity(), o0.a(r2, r4));
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // n04.c
    public final void c(m r11) {
        Intrinsics.checkNotNullParameter(r11, "pgParameters");
        b r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        ProfilePageConfig r1 = r11.b.getPageConfig();     // Catch: Exception -> L7
        JsonObject r2 = new JsonParser().parse(r0.a.a());     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Exception -> L7
        JsonObject r3 = r2;     // Catch: Exception -> L7
        String r4 = r3.get("store_type").getAsString();     // Catch: Exception -> L7
        String r9 = r3.get("shop_id").getAsString();     // Catch: Exception -> L7
        d r12 = e(r11, r1);     // Catch: Exception -> L7
        d14.a r5 = b14.a.a;     // Catch: Exception -> L7
        b14.a.a(t24.a.class).T0(r4, r12.b, r12.c, r12.d, r12.e, r9);     // Catch: Exception -> L7
        return;
    }

    @Override // n04.c
    public final void d(m r11) {
        Intrinsics.checkNotNullParameter(r11, "pgParameters");
        b r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        ProfilePageConfig r1 = r11.b.getPageConfig();     // Catch: Exception -> L7
        JsonObject r2 = new JsonParser().parse(r0.a.a());     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Exception -> L7
        JsonObject r3 = r2;     // Catch: Exception -> L7
        String r4 = r3.get("store_type").getAsString();     // Catch: Exception -> L7
        String r9 = r3.get("shop_id").getAsString();     // Catch: Exception -> L7
        d r12 = e(r11, r1);     // Catch: Exception -> L7
        d14.a r5 = b14.a.a;     // Catch: Exception -> L7
        b14.a.a(t24.a.class).o0(r4, r12.b, r12.c, r12.d, r12.e, r9);     // Catch: Exception -> L7
        return;
    }

    public static d e(m r10, ProfilePageConfig r11) {
        HostEventParameters r0 = r11.getHostEventParameters();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getEnterFrom();
    L6:
        boolean r3 = Intrinsics.areEqual(r2, "live_detail");
        if (r3 == false) goto L12;
        HostEventParameters r4 = r11.getHostEventParameters();
        if (r4 == null) goto L11;
        String r5 = r4.getEnterFromMerge();
    L19:
        if (r3 == false) goto L22;
        String r6 = "live";
    L21:
        String r7 = r6;
        if (r3 == false) goto L43;
        HostEventParameters r8 = r11.getHostEventParameters();
        if (r8 == null) goto L44;
        r1 = r8.getEnterMethod();
    L44:
        if (r3 == false) goto L46;
        String r12 = r11.getOpenId();
    L48:
        if (r5 != null) goto L50;
        String r9 = "";
    L51:
        if (r1 != null) goto L53;
        String r13 = "";
    L54:
        if (r12 != null) goto L56;
        String r14 = "";
    L58:
        return new d(r9, r7, r13, r14, r11.getHostCommonParams().optString("host_enter_from"));
    L56:
        r14 = r12;
        goto L58
    L53:
        r13 = r1;
        goto L54
    L50:
        r9 = r5;
        goto L51
    L46:
        r12 = r10.b.getProfileIds().b;
        goto L48
    L43:
        r1 = r10.b.getEnterMethod();
        goto L44
    L22:
        String r15 = r10.b.getPageConfig().getAid();
        if (r15 != null) goto L25;
    L28:
        boolean r16 = true;
    L29:
        if (r16 == false) goto L38;
        d14.a r17 = b14.a.a;
        x24.a r18 = b14.a.a(x24.a.class);
        jz3.a r19 = r10.b.getCachedFeedItemEntity();
        if (r19 == null) goto L33;
        r14.c r20 = r19.a;
    L35:
        if (r18.W(r20) == true) goto L38;
        r6 = "others";
        goto L21
    L33:
        r20 = null;
    L38:
        r6 = "video";
        goto L21
    L25:
        if (r15.length() == 0) goto L28;
        r16 = false;
        goto L29
    L11:
        r5 = null;
        goto L19
    L12:
        Fragment r21 = r10.e.getParentFragment();
        if ((r21 instanceof AosFeedsHomeFragment) == false) goto L15;
        AosFeedsHomeFragment r22 = (AosFeedsHomeFragment) r21;
    L16:
        if (r22 == null) goto L18;
        r5 = "homepage_hot";
        goto L19
    L18:
        r5 = "others_homepage";
        goto L19
    L15:
        r22 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }
}
