package com.bytedance.awemeopen.apps.photo.presenter;

import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
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
public final class CameraStrongPresenter extends f04.a<Unit> {
    public final a14.a d;
    public final Lazy e;
    public final ViewGroup f;
    public final AoImageView g;
    public final DmtTextView h;
    public final DmtTextView i;
    public final DmtTextView j;

    @Override // f04.a
    public final void k() {
    }

    public CameraStrongPresenter(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = LazyKt.lazy(CameraStrongPresenter$bdpCameraService$2.INSTANCE);
        this.f = (ViewGroup) i(2131365092);
        this.g = i(2131376064);
        this.h = (DmtTextView) i(2131390269);
        this.i = (DmtTextView) i(2131390268);
        this.j = (DmtTextView) i(2131390267);
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
    public final void j(Unit r24) {
        Intrinsics.checkNotNullParameter(r24, "unit");
        Map r1 = this.d.a.w();
        String r2 = null;
        if (r1 == null) goto L5;
        List r3 = (List) r1.get(4);
    L6:
        AoCameraService r4 = (AoCameraService) this.e.getValue();
        if (r4 == null) goto L9;
        boolean r5 = r4.C();
    L10:
        if (r3 == null) goto L12;
        int r6 = r3.size();
    L14:
        if (r6 < 2) goto L60;
        if (r5 == false) goto L60;
        if (r3 == null) goto L18;
        r14.w r7 = (r14.w) ListProtector.get(r3, 1);
    L19:
        if (r7 == null) goto L62;
        AosEventReporter r8 = AosEventReporter.a;
        String r9 = this.d.c.sceneId();
        AosPictureDetailConfig r10 = this.d.c.getPageConfig();
        if (r10 == null) goto L23;
        r2 = r10.getPreviousPage();
    L23:
        r14.c r11 = this.d.a;
        String r12 = String.valueOf(r7.getType());
        String r15 = String.valueOf(r7.b());
        int r19 = r7.g();
        JSONObject r22 = new JSONObject().put("host_expand_raw_data", r7.f());
        r8.getClass();
        Intrinsics.checkNotNullParameter("", "from_group_id");
        Intrinsics.checkNotNullParameter(r12, "component_type");
        Intrinsics.checkNotNullParameter(r15, "content_id");
        if (r11 != null) goto L26;
    L51:
        x54.b.d(this.f);
        this.g.j(new com.bytedance.awemeopen.infra.base.image.b(r7.c()));
        AppCompatTextView r13 = this.h;
        CharSequence r14 = r7.i();
        if (r14 != null) goto L55;
        r14 = "机位";
    L55:
        r13.setText(r14);
        this.i.setText(r7.a());
        if (TextUtils.isEmpty(r7.h()) == true) goto L58;
        x54.b.d(this.j);
        this.j.setText(r7.h());
        Paint r16 = new Paint();
        Resources r17 = Resources.getSystem();
        r16.setTextSize(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics())));
        r16.setTypeface(this.j.getTypeface());
        float r18 = r16.measureText(r7.h());
        Resources r20 = Resources.getSystem();
        float r21 = r18 + MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics())));
        int r23 = com.bytedance.awemeopen.apps.framework.utils.d0.d(this.d.getActivity());
        Resources r25 = Resources.getSystem();
        this.i.setMaxWidth((int) ((r23 - MathKt.roundToInt(TypedValue.applyDimension(1, 183, WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics())))) - r21));
    L59:
        ViewGroup r26 = this.f;
        r26.setOnClickListener(new g(r26, this, r7));
        return;
    L58:
        x54.b.a(this.j);
        goto L59
    L26:
        if (r11.W() == false) goto L28;
        String r27 = "origin";
    L29:
        String r110 = r27;
        d14.a r28 = b14.a.a;
        t24.a r29 = b14.a.a(t24.a.class);
        if (r9 != null) goto L32;
        String r30 = "";
    L33:
        User r31 = r11.f();
        if (r31 == null) goto L39;
        String r32 = r31.u();
        if (r32 == null) goto L39;
        String r111 = r32;
    L40:
        String r112 = r11.c();
        r14.a0 r33 = r11.d;
        if (r33 == null) goto L46;
        String r34 = r33.a();
        if (r34 == null) goto L46;
        String r113 = r34;
    L47:
        String r114 = AosEventReporter.c(r11);
        if (r2 != null) goto L50;
        r2 = "";
    L50:
        r29.r(r30, r111, r112, r113, r114, r110, r2, "", r12, r15, r19, -1, r11.u(), r22);
    L46:
        r113 = "";
    L39:
        r111 = "";
        goto L40
    L32:
        r30 = r9;
        goto L33
    L28:
        r27 = "sdk";
        goto L29
    L62:
        return;
    L18:
        r7 = null;
    L60:
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
