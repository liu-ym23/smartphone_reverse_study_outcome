package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import z5c.k;
import z5c.w3;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatPanelHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f460654a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatPanelHitPoint$ButtonPositionValue;", "", "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonPositionValue {
        public static final int BACK_KEY = 2;
        public static final int BOTTOM = 1;
        public static final a Companion = null;
        public static final int TOP = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f460655a = null;

            static {
                f460655a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f460655a;
        }
    }

    static {
    }

    public static void a(int r100, int r101) {
        Statistics.sendEvent("im_floating_panel_collapse_list_click", s5c.d.b.b(w3.f570397c.a(String.valueOf(r100)), k.f570230c.a(String.valueOf(r101))).toJson());
    }

    public static void b(int r100, int r101) {
        if (r100 != 0) goto L4;
        return;
    L4:
        Statistics.sendEvent("core_float_dialog_show_card", s5c.d.b.b(z5c.c.f570162c.a(String.valueOf(r100)), w3.f570397c.a(String.valueOf(r101))).toJson());
    }
}
