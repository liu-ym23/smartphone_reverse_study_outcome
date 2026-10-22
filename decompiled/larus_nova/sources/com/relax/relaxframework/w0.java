package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f405337c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f405338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f405339b;

    public static final class a {
        public static void a(c1 r110, v0 r111) {
            Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r111, "event");
            w0 r100 = new w0(r110, r111);
            Intrinsics.checkNotNullParameter(r100, "dispatcher");
            v0 r112 = r100.f405339b;
            v0 r101 = null;
            if (r112 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r112 = null;
        L5:
            c1 r102 = r100.f405338a;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("___target");
            r102 = null;
        L8:
            r112.getClass();
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            r112.f405314e = r102;
            v0 r113 = r100.f405339b;
            if (r113 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r113 = null;
        L12:
            if (r113.f405312c == true) goto L30;
            v0 r114 = r100.f405339b;
            if (r114 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r114 = null;
        L16:
            PhaseType r103 = PhaseType.AtTarget;
            r114.getClass();
            Intrinsics.checkNotNullParameter(r103, "phaseType");
            r114.f405313d = r103;
            v0 r115 = r100.f405339b;
            if (r115 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r115 = null;
        L19:
            c1 r104 = r100.f405338a;
            if (r104 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("___target");
            r104 = null;
        L22:
            r115.getClass();
            Intrinsics.checkNotNullParameter(r104, PickerReporterConstants.KEY.TARGET);
            c1 r116 = r100.f405338a;
            if (r116 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("___target");
            r116 = null;
        L25:
            v0 r105 = r100.f405339b;
            if (r105 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
        L29:
            q0 r117 = r116.q(r101);
            EventCancelType r118 = EventCancelType.CanceledByDefaultEventHandler;
            boolean r119 = r117.f405225b;
            Intrinsics.checkNotNullParameter(r118, "cancelType");
            EventCancelType r120 = EventCancelType.NotCanceled;
            return;
        L28:
            r101 = r105;
            goto L29
        L30:
            v0 r121 = r100.f405339b;
            if (r121 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r121 = null;
        L33:
            ArrayList<c1> r122 = r121.f405315f;
            IntCompanionObject r106 = IntCompanionObject.INSTANCE;
            int r107 = com.bytedance.rts.foundation.j.d(r122);
            com.bytedance.rts.foundation.k.c(r106, r107);
            int r108 = r107 - 1;
            boolean r109 = false;
        L34:
            if (r108 < 0) goto L65;
            int r123 = com.bytedance.rts.foundation.d.f267577a;
            c1 r124 = (c1) ListProtector.get(r122, r108);
            v0 r125 = r100.f405339b;
            if (r125 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r125 = null;
        L38:
            v0 r126 = r100.f405339b;
            if (r126 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r126 = null;
        L41:
            c1 r127 = r126.f405314e;
            Intrinsics.checkNotNull(r127);
            if (r127 != r124) goto L44;
            PhaseType r128 = PhaseType.AtTarget;
        L45:
            r125.getClass();
            Intrinsics.checkNotNullParameter(r128, "phaseType");
            r125.f405313d = r128;
            v0 r129 = r100.f405339b;
            if (r129 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r129 = null;
        L48:
            r129.getClass();
            Intrinsics.checkNotNullParameter(r124, PickerReporterConstants.KEY.TARGET);
            v0 r130 = r100.f405339b;
            if (r130 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r130 = null;
        L51:
            q0 r131 = r124.q(r130);
            if (r109 == false) goto L54;
        L57:
            r109 = true;
        L59:
            if (r131.f405224a == EventCancelType.NotCanceled) goto L61;
            boolean r132 = true;
        L62:
            if (r132 == true) goto L106;
            r108 = r108 - 1;
            goto L34
        L106:
            return;
        L61:
            r132 = false;
            goto L62
        L54:
            if (r131.f405225b == true) goto L57;
            r109 = false;
            goto L59
        L44:
            r128 = PhaseType.CapturingPhase;
            goto L45
        L65:
            int r133 = 0;
        L66:
            IntCompanionObject r134 = IntCompanionObject.INSTANCE;
            int r135 = com.bytedance.rts.foundation.j.d(r122);
            com.bytedance.rts.foundation.k.c(r134, r135);
            if (r133 >= r135) goto L97;
            int r136 = com.bytedance.rts.foundation.d.f267577a;
            c1 r137 = (c1) ListProtector.get(r122, r133);
            v0 r138 = r100.f405339b;
            if (r138 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r138 = null;
        L72:
            if (r138.f405314e == r137) goto L96;
            v0 r139 = r100.f405339b;
            if (r139 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r139 = null;
        L77:
            PhaseType r140 = PhaseType.BubblingPhase;
            r139.getClass();
            Intrinsics.checkNotNullParameter(r140, "phaseType");
            r139.f405313d = r140;
            v0 r141 = r100.f405339b;
            if (r141 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r141 = null;
        L80:
            r141.getClass();
            Intrinsics.checkNotNullParameter(r137, PickerReporterConstants.KEY.TARGET);
            v0 r142 = r100.f405339b;
            if (r142 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("___event");
            r142 = null;
        L83:
            q0 r143 = r137.q(r142);
            if (r109 == false) goto L86;
        L89:
            r109 = true;
        L91:
            if (r143.f405224a == EventCancelType.NotCanceled) goto L93;
            boolean r144 = true;
        L94:
            if (r144 == false) goto L96;
            return;
        L93:
            r144 = false;
            goto L94
        L86:
            if (r143.f405225b == true) goto L89;
            r109 = false;
        L96:
            r133 = r133 + 1;
            goto L66
        L97:
            Intrinsics.checkNotNullParameter(EventCancelType.NotCanceled, "cancelType");
            EventCancelType r145 = EventCancelType.NotCanceled;
        }
    }

    static {
    }

    public w0(c1 r100, v0 r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "event");
        this.f405338a = r100;
        this.f405339b = r101;
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    L3:
        if (r100 == null) goto L5;
        com.bytedance.rts.foundation.j.j(r101.f405315f, r100);
        r100 = r100.r();
        goto L3
    }
}
