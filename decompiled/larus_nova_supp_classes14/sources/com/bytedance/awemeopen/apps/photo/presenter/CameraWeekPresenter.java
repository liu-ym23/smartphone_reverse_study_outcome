package com.bytedance.awemeopen.apps.photo.presenter;

import android.content.res.Resources;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.collect.serviceapi.AoCameraService;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CameraWeekPresenter extends f04.a<Unit> {
    public final a14.a d;
    public final Lazy e;
    public final ViewGroup f;
    public final AoImageView g;
    public final DmtTextView h;
    public final DmtTextView i;

    @Override // f04.a
    public final void k() {
    }

    public CameraWeekPresenter(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = LazyKt.lazy(CameraWeekPresenter$bdpCameraService$2.INSTANCE);
        this.f = (ViewGroup) i(2131365093);
        this.g = i(2131376065);
        this.h = (DmtTextView) i(2131390272);
        this.i = (DmtTextView) i(2131390271);
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
    @Override // f04.a
    public final void j(Unit r23) {
        Intrinsics.checkNotNullParameter(r23, "unit");
        Map r1 = this.d.a.w();
        String r2 = null;
        if (r1 == null) goto L5;
        List r3 = (List) r1.get(5);
    L6:
        AoCameraService r4 = (AoCameraService) this.e.getValue();
        if (r4 == null) goto L9;
        boolean r5 = r4.C();
    L10:
        if (r3 == null) goto L12;
        int r6 = r3.size();
    L14:
        if (r6 < 2) goto L63;
        if (r5 == false) goto L63;
        if (r3 == null) goto L18;
        r14.w r7 = (r14.w) ListProtector.get(r3, 1);
    L19:
        if (r7 == null) goto L65;
        AosEventReporter r8 = AosEventReporter.a;
        String r9 = this.d.c.sceneId();
        AosPictureDetailConfig r10 = this.d.c.getPageConfig();
        if (r10 == null) goto L23;
        r2 = r10.getPreviousPage();
    L23:
        r14.c r11 = this.d.a;
        String r12 = r7.i();
        if (r12 != null) goto L26;
        r12 = "";
    L26:
        String r15 = String.valueOf(r7.b());
        String r13 = r7.a();
        if (r13 != null) goto L29;
        String r14 = "";
    L30:
        JSONObject r21 = new JSONObject().put("host_expand_raw_data", r7.f());
        r8.getClass();
        Intrinsics.checkNotNullParameter(r12, "bar_name");
        Intrinsics.checkNotNullParameter("topic", "bar_type");
        Intrinsics.checkNotNullParameter(r15, "topic_id");
        Intrinsics.checkNotNullParameter(r14, "topic_name");
        if (r11 != null) goto L33;
    L59:
        x54.b.d(this.f);
        this.g.j(new com.bytedance.awemeopen.infra.base.image.b(r7.c()));
        String r16 = r7.i();
        if (r16 != null) goto L62;
        r16 = "相关机位";
    L62:
        this.h.setText(r16);
        this.i.setText(r7.a());
        Paint r17 = new Paint();
        Resources r18 = Resources.getSystem();
        r17.setTextSize(TypedValue.applyDimension(1, 14, WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics())));
        r17.setTypeface(this.h.getTypeface());
        float r19 = r17.measureText(r16);
        int r20 = com.bytedance.awemeopen.apps.framework.utils.d0.d(this.d.getActivity());
        Resources r22 = Resources.getSystem();
        this.i.setMaxWidth((int) ((r20 - MathKt.roundToInt(TypedValue.applyDimension(1, 105, WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics())))) - r19));
        ViewGroup r24 = this.f;
        r24.setOnClickListener(new h(r24, this, r7));
        return;
    L33:
        if (r11.W() == false) goto L35;
        String r25 = "origin";
    L36:
        d14.a r26 = b14.a.a;
        t24.a r27 = b14.a.a(t24.a.class);
        if (r9 != null) goto L39;
        String r110 = "";
    L40:
        User r28 = r11.f();
        if (r28 == null) goto L46;
        String r29 = r28.u();
        if (r29 == null) goto L46;
        String r111 = r29;
    L47:
        String r112 = r11.c();
        r14.a0 r30 = r11.d;
        if (r30 == null) goto L53;
        String r31 = r30.a();
        if (r31 == null) goto L53;
        String r113 = r31;
    L54:
        String r32 = AosEventReporter.c(r11);
        if (r2 != null) goto L57;
        String r114 = "";
    L58:
        String r115 = r25;
        String r116 = r12;
        r27.R(r110, r111, r112, r113, r32, r115, r114, r116, r15, r14, r11.u(), r21);
        goto L59
    L57:
        r114 = r2;
    L53:
        r113 = "";
    L46:
        r111 = "";
        goto L47
    L39:
        r110 = r9;
        goto L40
    L35:
        r25 = "sdk";
        goto L36
    L29:
        r14 = r13;
        goto L30
    L65:
        return;
    L18:
        r7 = null;
    L63:
        x54.b.a(this.f);
        return;
    L12:
        r6 = 0;
        goto L14
    L9:
        r5 = true;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
