package zh3;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import bi3.c;
import bi3.e;
import bi3.g;
import cl.d;
import com.bytedance.android.ec.core.widget.DoubleColorBallAnimationView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.abscontainer.arch.platform.slice.PlatformSliceSDK;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.ContainerName;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformErrorView;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformFooterSkeletonView;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformLoadingView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p33.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b {
    public final Window a;

    /* JADX INFO: renamed from: zh3.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0246a implements View.OnClickListener {
        public static final ViewOnClickListenerC0246a a = null;

        static {
            a = new ViewOnClickListenerC0246a();
        }

        public ViewOnClickListenerC0246a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            d r2 = k.a();
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public final p33.a a(ConstraintLayout r31) {
        Intrinsics.checkNotNullParameter(r31, "rootView");
        th.a.c(r31.getContext(), 2131564879, r31, true);
        RecyclerView r5 = r31.findViewById(2131364334);
        k43.a r1 = new k43.a(r5);
        View r2 = r31.findViewById(2131381805);
        View r4 = r31.findViewById(2131381866);
        View r6 = r31.findViewById(2131372607);
        LinearLayout r7 = (LinearLayout) r31.findViewById(2131374285);
        LinearLayout r8 = (LinearLayout) r31.findViewById(2131373142);
        LinearLayout r9 = (LinearLayout) r31.findViewById(2131365368);
        LinearLayout r10 = (LinearLayout) r31.findViewById(2131371514);
        LinearLayout r11 = (LinearLayout) r31.findViewById(2131368977);
        LinearLayout r12 = (LinearLayout) r31.findViewById(2131389228);
        LinearLayout r13 = (LinearLayout) r31.findViewById(2131374283);
        LinearLayout r14 = (LinearLayout) r31.findViewById(2131379666);
        View r15 = r31.findViewById(2131379429);
        FrameLayout r3 = (FrameLayout) r31.findViewById(2131382786);
        int r16 = PlatformSliceSDK.a;
        com.bytedance.android.ecom.arch.slice.render.context.b r17 = PlatformSliceSDK.a(com.bytedance.android.shopping.skubuy.platform.helper.b.b(false));
        PlatformLoadingView r18 = (PlatformLoadingView) r31.findViewById(2131379091);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "displayMetrics");
        DoubleColorBallAnimationView r19 = r18.a;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if (r110 == null) goto L5;
        r110.width = SlcDimensExtensionsKt.a(24, r17);
        r110.height = SlcDimensExtensionsKt.a(28, r17);
        Unit r20 = Unit.INSTANCE;
    L6:
        r19.setLayoutParams(r110);
        PlatformFooterSkeletonView r21 = r18.c;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L9;
        r22.height = SlcDimensExtensionsKt.a(64, r17);
        Unit r111 = Unit.INSTANCE;
    L10:
        r21.setLayoutParams(r22);
        e r23 = new e(r18);
        PlatformErrorView r24 = (PlatformErrorView) r31.findViewById(2131371766);
        r24.R5(r17);
        c r112 = new c(r24);
        View r0 = r31.findViewById(2131388304);
        r0.setOnClickListener(ViewOnClickListenerC0246a.a);
        if (ECAppInfoService.e.i() == false) goto L13;
        char r25 = 0;
        r0.setVisibility(0);
    L14:
        Pair[] r26 = new Pair[8];
        r26[r25] = TuplesKt.to(ContainerName.HEADER.getValue(), r7);
        r26[1] = TuplesKt.to(ContainerName.FOOTER.getValue(), r8);
        r26[2] = TuplesKt.to(ContainerName.CEILING.getValue(), r9);
        r26[3] = TuplesKt.to(ContainerName.GUIDE.getValue(), r10);
        r26[4] = TuplesKt.to(ContainerName.DIALOG.getValue(), r11);
        r26[5] = TuplesKt.to(ContainerName.TOP_STRAND.getValue(), r12);
        r26[6] = TuplesKt.to(ContainerName.HEADER_CEILING.getValue(), r13);
        r26[7] = TuplesKt.to(ContainerName.MASK.getValue(), r14);
        return new p33.a(r5, MapsKt.mapOf(r26), r3, r23, r112, MapsKt.mapOf(new Pair[]{TuplesKt.to(WidgetName.MASK_BACKGROUND.getValue(), new g(this.a, r2)), TuplesKt.to(WidgetName.BODY.getValue(), r1), TuplesKt.to(WidgetName.MASK_LAYER.getValue(), new k43.c(r14)), TuplesKt.to(WidgetName.DIALOG.getValue(), new k43.c(r11)), TuplesKt.to(WidgetName.TOP.getValue(), new k43.c(r12)), TuplesKt.to(WidgetName.HEADER_CEILING.getValue(), new k43.c(r13)), TuplesKt.to(WidgetName.HEADER.getValue(), new k43.c(r7)), TuplesKt.to(WidgetName.FOOTER.getValue(), new bi3.d(r8)), TuplesKt.to(WidgetName.POPUP.getValue(), new k43.c(r3)), TuplesKt.to(WidgetName.CONTENT.getValue(), new bi3.b(r15)), TuplesKt.to(WidgetName.GUIDE.getValue(), new k43.d(r10)), TuplesKt.to(WidgetName.DEBUG.getValue(), new w43.a(r0)), TuplesKt.to(WidgetName.GLOBAL_LOADING.getValue(), new k43.c(r6)), TuplesKt.to(WidgetName.PANEL_CONTAINER.getValue(), new bi3.a(r4))}));
    L13:
        r25 = 0;
        r0.setVisibility(8);
        goto L14
    L9:
        r22 = null;
        goto L10
    L5:
        r110 = null;
        goto L6
    }

    public a(Window r1, boolean r2) {
        this.a = r1;
    }
}
