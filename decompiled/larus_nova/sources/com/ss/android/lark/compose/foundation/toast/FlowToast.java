package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowToast {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f417626a = 0;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/compose/foundation/toast/FlowToast$Duration;", "", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Duration {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f417627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f417628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f417629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f417630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f417631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f417632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f417633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f417634h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f417635i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f417636j;

        public final g a() {
            int r100 = b.f417637a;
            Intrinsics.checkNotNullParameter(this, "builder");
            int r101 = 1;
            int r102 = 48;
            if (this.f417631e == null) goto L5;
        L8:
            int r103 = com.ss.android.lark.compose.foundation.toast.a.f417638a;
            Context r104 = this.f417627a;
            Intrinsics.checkNotNullParameter(r104, "<this>");
            if (com.ss.android.lark.compose.foundation.toast.a.a(r104) == null) goto L11;
            boolean r105 = true;
        L12:
            if (r105 == false) goto L46;
            com.ss.android.lark.compose.foundation.toast.b r106 = new com.ss.android.lark.compose.foundation.toast.b(this.f417627a);
            CharSequence r107 = this.f417628b;
            if (r107 == null) goto L16;
            Intrinsics.checkNotNullParameter(r107, "s");
            i r110 = r106.f417642d;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r107, "s");
            r110.f417659b.f424297e.setText(r107);
        L16:
            Drawable r108 = this.f417629c;
            if (r108 == null) goto L19;
            r106.setIcon(r108);
        L19:
            c r109 = this.f417632f;
            if (r109 == null) goto L24;
            CharSequence r111 = this.f417631e;
            if (r111 == null) goto L24;
            Intrinsics.checkNotNullParameter(r111, "s");
            Intrinsics.checkNotNullParameter(r109, "action");
            i r112 = r106.f417642d;
            com.ss.android.lark.compose.foundation.toast.c r113 = new com.ss.android.lark.compose.foundation.toast.c(r109, r106);
            r112.getClass();
            Intrinsics.checkNotNullParameter(r111, "s");
            Intrinsics.checkNotNullParameter(r113, "action");
            TextView r114 = r112.f417659b.f424294b;
            r114.setText(r111);
            r114.setOnClickListener(r113);
            r114.setVisibility(0);
            r112.f417659b.f424295c.setVisibility(0);
        L24:
            int r115 = (int) h18.d.b(this.f417627a, 128);
            if (this.f417632f != null) goto L27;
            r115 = (int) h18.d.b(this.f417627a, 100);
        L28:
            int r116 = this.f417634h;
            if (r116 == 0) goto L32;
            r102 = r116;
        L32:
            int r117 = this.f417635i;
            int r118 = this.f417636j;
            if (r118 == 0) goto L36;
            r115 = r118;
        L36:
            r106.f417644f = r102;
            r106.f417645g = r117;
            r106.f417646h = r115;
            long r119 = this.f417630d;
            if (r119 != (-1)) goto L40;
        L44:
            r119 = 4000;
        L45:
            r106.f417647i = r119;
            r106.f417648j = this.f417633g;
            g r120 = r106;
        L65:
            return r120;
        L40:
            if (r119 != (-2)) goto L43;
            r119 = 7000;
            goto L45
        L43:
            if (r119 >= 0) goto L45;
        L27:
            r102 = 80;
        L46:
            f r121 = new f(this.f417627a);
            CharSequence r122 = this.f417628b;
            if (r122 == null) goto L49;
            r121.setText(r122);
        L49:
            Drawable r123 = this.f417629c;
            if (r123 == null) goto L52;
            r121.setIcon(r123);
        L52:
            int r124 = (int) h18.d.b(this.f417627a, 100);
            int r125 = this.f417634h;
            if (r125 == 0) goto L56;
            r102 = r125;
        L56:
            int r126 = this.f417635i;
            int r127 = this.f417636j;
            if (r127 == 0) goto L60;
            r124 = r127;
        L60:
            r121.setGravity(r102, r126, r124);
            if (this.f417630d == (-2)) goto L64;
            r101 = 0;
        L64:
            r121.setDuration(r101);
            r120 = r121;
            goto L65
        L11:
            r105 = false;
            goto L12
        L5:
            if (this.f417630d > 0) goto L8;
            if (this.f417633g == null) goto L46;
            goto L8
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f417627a = r100;
            this.f417630d = -1;
        }

        public final void d(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f417629c = r100;
        }

        public final void e(int r100) {
            this.f417628b = this.f417627a.getString(r100);
        }

        public final void b(int r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f417631e = this.f417627a.getString(r100);
            this.f417632f = r101;
        }

        public final void c(int r100, int r101, int r102) {
            this.f417634h = r100;
            this.f417635i = r101;
            this.f417636j = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f417637a = 0;

        static {
        }
    }

    public interface c extends UDToast.b {
    }

    public interface d extends UDToast.c {
    }

    static {
    }

    @JvmStatic
    public static final a a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }

    @JvmStatic
    public static final f b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        f r102 = new f(r100);
        r102.setText(r101);
        return r102;
    }

    @JvmStatic
    public static final void c(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f r102 = new f(r100);
        r102.setText(r101);
        r102.show();
    }

    @JvmStatic
    public static final void d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        b(r100, r101).show();
    }

    @JvmStatic
    public static final void e(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        f r103 = new f(r100);
        r103.setText(r101);
        r103.setIcon(r102);
        r103.show();
    }
}
