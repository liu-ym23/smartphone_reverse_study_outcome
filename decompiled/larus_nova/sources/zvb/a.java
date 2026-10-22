package zvb;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f573774b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f573775a;

    /* JADX INFO: renamed from: zvb.a$a, reason: collision with other inner class name */
    public static final class C8496a {
        public C8496a() {
        }

        public static GradientDrawable a(Context r100, Integer r101, Float r102, Integer r103, int r104) {
            int r105 = a.f573774b;
            if ((r104 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            a r106 = new a();
            r106.f573775a.setShape(1);
            if (r101 == null) goto L14;
            r101.intValue();
            r106.c(r100, r101.intValue(), r102);
        L14:
            if (r103 == null) goto L17;
            float r107 = r103.intValue();
            r106.b(Integer.valueOf(UIUtils.dp2px(r100, r107)), Integer.valueOf(UIUtils.dp2px(r100, r107)));
        L17:
            return r106.f573775a;
        }

        public static GradientDrawable b(Context r100, Integer r101, Float r102, Integer r103, Integer r104, Integer r105) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            a r106 = new a();
            if (r101 == null) goto L5;
            r101.intValue();
            r106.c(r100, r101.intValue(), r102);
        L5:
            if (r103 == null) goto L7;
            int r107 = UIUtils.dp2px(r100, r103.intValue());
            r106.a(r107, r107, r107, r107);
        L7:
            if (r104 == null) goto L11;
            if (r105 == null) goto L11;
            a.d(r106, r100, UIUtils.dp2px(r100, r105.intValue()), r104.intValue());
        L11:
            return r106.f573775a;
        }

        public static /* synthetic */ GradientDrawable c(Context r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 8) == 0) goto L8;
            Integer r106 = null;
        L10:
            if ((r105 & 16) == 0) goto L12;
            Integer r107 = null;
        L14:
            if ((r105 & 32) == 0) goto L16;
            Integer r108 = null;
        L18:
            return b(r100, r101, null, r106, r107, r108);
        L16:
            r108 = r104;
            goto L18
        L12:
            r107 = r103;
            goto L14
        L8:
            r106 = r102;
            goto L10
        }

        public static GradientDrawable d(Context r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, int r106) {
            int r107 = a.f573774b;
            if ((r106 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r106 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r106 & 8) == 0) goto L12;
            r103 = null;
        L12:
            if ((r106 & 16) == 0) goto L15;
            r104 = null;
        L15:
            if ((r106 & 32) == 0) goto L17;
            r105 = null;
        L17:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            a r108 = new a();
            if (r101 == null) goto L20;
            r101.intValue();
            r108.c(r100, r101.intValue(), null);
        L20:
            if (r102 != null) goto L24;
            if (r103 != null) goto L24;
            if (r104 != null) goto L24;
            if (r105 != null) goto L24;
        L41:
            return r108.f573775a;
        L24:
            int r109 = 0;
            if (r102 == null) goto L27;
            int r110 = r102.intValue();
        L28:
            int r111 = UIUtils.dp2px(r100, r110);
            if (r103 == null) goto L31;
            int r112 = r103.intValue();
        L32:
            int r113 = UIUtils.dp2px(r100, r112);
            if (r104 == null) goto L35;
            int r114 = r104.intValue();
        L36:
            int r115 = UIUtils.dp2px(r100, r114);
            if (r105 == null) goto L39;
            r109 = r105.intValue();
        L39:
            r108.a(r111, r113, r115, UIUtils.dp2px(r100, r109));
            goto L41
        L35:
            r114 = 0;
            goto L36
        L31:
            r112 = 0;
            goto L32
        L27:
            r110 = 0;
            goto L28
        }
    }

    static {
        new C8496a();
    }

    public a() {
        this.f573775a = new GradientDrawable();
    }

    public final void b(Integer r100, Integer r101) {
        if (r100 != null) goto L5;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L11;
        GradientDrawable r102 = this.f573775a;
        if (r101 == null) goto L10;
        r102.setSize(-1, r101.intValue());
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        if (r101 != null) goto L13;
        this.f573775a.setSize(r100.intValue(), -1);
        return;
    L13:
        this.f573775a.setSize(r100.intValue(), r101.intValue());
    }

    public final void c(Context r100, int r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 == null) goto L5;
        int r103 = UDColorUtils.getAlphaColor(r100, r101, r102.floatValue());
    L6:
        this.f573775a.setColor(r103);
        return;
    L5:
        r103 = UDColorUtils.getColor(r100, r101);
        goto L6
    }

    public static void d(a r100, Context r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = UDColorUtils.getColor(r101, r103);
        r100.f573775a.setStroke(r102, r104, 0.0f, 0.0f);
    }

    public final void a(int r100, int r101, int r102, int r103) {
        float r104 = r100;
        float r105 = r101;
        float r106 = r102;
        float r107 = r103;
        this.f573775a.setCornerRadii(new float[]{r104, r104, r105, r105, r106, r106, r107, r107});
    }
}
