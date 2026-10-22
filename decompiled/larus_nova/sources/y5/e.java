package y5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements x5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f566189d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f566191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer[] f566192c;

    public static final class a {
        public static void b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            ViewGroup.LayoutParams r102 = null;
            if ((r100 instanceof ViewGroup) == false) goto L5;
            ViewGroup r103 = (ViewGroup) r100;
        L6:
            if (r103 == null) goto L9;
            r102 = r103.getLayoutParams();
        L9:
            if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L12;
            ((FrameLayout.LayoutParams) r102).gravity = r101;
        L17:
            r100.requestLayout();
            return;
        L12:
            if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
            ((CoordinatorLayout.LayoutParams) r102).gravity = r101;
            goto L17
        L15:
            if ((r102 instanceof LinearLayout.LayoutParams) == false) goto L17;
            ((LinearLayout.LayoutParams) r102).gravity = r101;
            goto L17
        L5:
            r103 = null;
            goto L6
        }

        public static int a(AppletPopupSchemaParam r110, View r111, Integer[] r112) {
            Intrinsics.checkNotNullParameter(r110, "params");
            Intrinsics.checkNotNullParameter(r111, "view");
            Intrinsics.checkNotNullParameter(r112, GXTemplateKey.FLEXBOX_MARGIN);
            String r113 = r110.getRealGravity(r111.getContext());
            switch(r113.hashCode()) {
                case -1383228885: goto L25;
                case -1364013995: goto L22;
                case 100571: goto L18;
                case 3317767: goto L14;
                case 108511772: goto L10;
                case 109757538: goto L6;
                default: goto L96;
            };
        L6:
            if (r113.equals("start") == false) goto L96;
            return GravityCompat.START;
        L10:
            if (r113.equals("right") == false) goto L96;
            return 5;
        L14:
            if (r113.equals("left") == false) goto L96;
            return 3;
        L18:
            if (r113.equals("end") == false) goto L96;
            return GravityCompat.END;
        L22:
            if (r113.equals("center") == false) goto L96;
            return 17;
        L25:
            if (r113.equals("bottom") == false) goto L96;
            return 81;
        L96:
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L31
            Object r101 = Result.m9449constructorimpl(Integer.valueOf(r112[0].intValue()));     // Catch: Throwable -> L31
        L34:
            if (Result.m9455isFailureimpl(r101) == false) goto L36;
            r101 = 0;
        L36:
            int r102 = ((Number) r101).intValue();
            Object r103 = Result.m9449constructorimpl(Integer.valueOf(r112[1].intValue()));     // Catch: Throwable -> L39
        L42:
            if (Result.m9455isFailureimpl(r103) == false) goto L44;
            r103 = 0;
        L44:
            int r104 = ((Number) r103).intValue();
            Object r105 = Result.m9449constructorimpl(Integer.valueOf(r112[2].intValue()));     // Catch: Throwable -> L47
        L50:
            if (Result.m9455isFailureimpl(r105) == false) goto L52;
            r105 = 0;
        L52:
            int r106 = ((Number) r105).intValue();
            Object r107 = Result.m9449constructorimpl(Integer.valueOf(r112[3].intValue()));     // Catch: Throwable -> L55
        L58:
            if (Result.m9455isFailureimpl(r107) == false) goto L60;
            r107 = 0;
        L60:
            ((Number) r107).intValue();
            Object r108 = Result.m9449constructorimpl(Integer.valueOf(r112[4].intValue()));     // Catch: Throwable -> L63
        L66:
            if (Result.m9455isFailureimpl(r108) == false) goto L68;
            r108 = 0;
        L68:
            int r109 = ((Number) r108).intValue();
            Object r114 = Result.m9449constructorimpl(Integer.valueOf(r112[5].intValue()));     // Catch: Throwable -> L71
        L74:
            if (Result.m9455isFailureimpl(r114) == false) goto L76;
            r114 = 0;
        L76:
            int r115 = ((Number) r114).intValue();
            if (r104 <= 0) goto L79;
            int r116 = 48;
        L80:
            int r117 = z5.a.f570044a;
            z5.a.a(r111.getContext());
            if (r109 <= 0) goto L84;
            int r118 = r116 | GravityCompat.START;
        L109:
            return r118;
        L84:
            if (r115 <= 0) goto L86;
            r118 = r116 | GravityCompat.END;
            goto L109
        L86:
            if (r102 <= 0) goto L88;
            r118 = r116 | 3;
            goto L109
        L88:
            if (r106 <= 0) goto L90;
            r118 = r116 | 5;
            goto L109
        L90:
            r118 = r116 | 17;
            goto L109
        L79:
            r116 = 80;
        L71:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L63:
            th = move-exception;
            Result.Companion r120 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L55:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L47:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L39:
            th = move-exception;
            Result.Companion r123 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L31:
            th = move-exception;
            Result.Companion r124 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L34
        }
    }

    static {
    }

    @Override // x5.a
    public final void invoke() {
        int r100 = a.a(this.f566190a, this.f566191b, this.f566192c);
        a.b(this.f566191b, r100);
    }

    public e(AppletPopupSchemaParam r100, View r101, Integer[] r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.FLEXBOX_MARGIN);
        this.f566190a = r100;
        this.f566191b = r101;
        this.f566192c = r102;
    }
}
