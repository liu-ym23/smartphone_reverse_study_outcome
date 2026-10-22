package com.larksuite.component.universe_design.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.f;
import com.ss.android.lark.compose.foundation.toast.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/universe_design/toast/UDToast;", "", "<init>", "()V", "LENGTH_LONG", "", "LENGTH_SHORT", "show", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "text", "", "stringId", "", "drawableId", "makeToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "build", "Lcom/larksuite/component/universe_design/toast/UDToast$Builder;", "createTintedIcon", "Landroid/graphics/drawable/Drawable;", "tintDrawable", "drawable", "Builder", "Duration", "OnActionClickListener", "OnToastDismissListener", "flow-ud-toast-compat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDToast {
    public static final UDToast INSTANCE = null;
    public static final long LENGTH_LONG = -2;
    public static final long LENGTH_SHORT = -1;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larksuite/component/universe_design/toast/UDToast$Duration;", "", "flow-ud-toast-compat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Duration {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f285428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowToast.a f285429b;

        public final g a() {
            return this.f285429b.a();
        }

        public final void h() {
            a().show();
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f285428a = r100;
            this.f285429b = FlowToast.a(r100);
        }

        public final void d(int r100) {
            this.f285429b.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, this.f285428a, r100));
        }

        public final void e(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f285429b.d(UDToast.access$tintDrawable(UDToast.INSTANCE, this.f285428a, r100));
        }

        public final void f(c r100) {
            Intrinsics.checkNotNullParameter(r100, "dismiss");
            FlowToast.a r101 = this.f285429b;
            com.larksuite.component.universe_design.toast.b r102 = new com.larksuite.component.universe_design.toast.b(r100);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "dismiss");
            r101.f417633g = r102;
        }

        public final void g(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            FlowToast.a r101 = this.f285429b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "value");
            r101.f417628b = r100;
        }

        public final void b(int r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f285429b.b(r100, new com.larksuite.component.universe_design.toast.a(r101));
        }

        public final void c(String r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "action");
            FlowToast.a r102 = this.f285429b;
            com.larksuite.component.universe_design.toast.a r103 = new com.larksuite.component.universe_design.toast.a(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r103, "action");
            r102.f417631e = r100;
            r102.f417632f = r103;
        }
    }

    public interface b {
        void a(com.ss.android.lark.compose.foundation.toast.b r100);
    }

    public interface c {
        void a();
    }

    static {
        INSTANCE = new UDToast();
    }

    private UDToast() {
    }

    @JvmStatic
    public static final a build(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }

    private final Drawable createTintedIcon(Context r100, int r101) {
        return UDIconUtils.getIconDrawable(r100, r101, r100.getResources().getColor(R.color.icon_n1));
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = FlowToast.f417626a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f r103 = new f(r100);
        r103.setText(r101);
        return r103;
    }

    @JvmStatic
    public static final void show(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        FlowToast.d(r100, r101);
    }

    private final Drawable tintDrawable(Context r100, Drawable r101) {
        r101.mutate().setTint(r100.getResources().getColor(R.color.icon_n1));
        return r101;
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        return FlowToast.b(r100, r101);
    }

    @JvmStatic
    public static final void show(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.c(r100, r101);
    }

    public static final /* synthetic */ Drawable access$createTintedIcon(UDToast r100, Context r101, int r102) {
        return r100.createTintedIcon(r101, r102);
    }

    public static final /* synthetic */ Drawable access$tintDrawable(UDToast r100, Context r101, Drawable r102) {
        return r100.tintDrawable(r101, r102);
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = FlowToast.f417626a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f r104 = new f(r100);
        r104.setText(r101);
        r104.setIcon(INSTANCE.createTintedIcon(r100, r102));
        return r104;
    }

    @JvmStatic
    public static final void show(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        makeToast(r100, r101, r102).show();
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        f r103 = FlowToast.b(r100, r101);
        r103.setIcon(INSTANCE.createTintedIcon(r100, r102));
        return r103;
    }

    @JvmStatic
    public static final void show(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        makeToast(r100, r101, r102).show();
    }
}
