package com.obric.assistant.window.materials.services.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import bia.g;
import com.larus.nova.R;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0016J\u0014\u0010\u0019\u001a\u00020\u000e*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0010*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u0012\u0010\u001c\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/window/materials/services/impl/OWindowMaterialServiceImpl;", "Lcom/obric/assistant/window/materials/services/IWindowMaterialService;", "<init>", "()V", "materialsMap", "", "Lcom/obric/assistant/window/materials/MaterialSceneType;", "", "isMaterialEnabled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isBlurEnabled", "setupMaterials", "", "view", "Landroid/view/View;", "materialSceneType", "processWindowBottomMenu", "bgViews", "", "iconViews", "Landroid/widget/ImageView;", "textViews", "Landroid/widget/TextView;", "internalSetupMaterials", "getTargetView", "processBottomMenuBg", "processBottomMenuIcon", "processBottomMenuText", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OWindowMaterialServiceImpl implements IWindowMaterialService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<MaterialSceneType, Integer> f394945a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394946a = null;

        static {
            int[] r100 = new int[MaterialSceneType.values().length];
            r100[MaterialSceneType.INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MaterialSceneType.FLOATING_BG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MaterialSceneType.WINDOW_BG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f394946a = r100;
        }
    }

    static {
    }

    public OWindowMaterialServiceImpl() {
        if (OMaterialHelper.f() >= 4) goto L5;
        Map<MaterialSceneType, Integer> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to(MaterialSceneType.INPUT, Integer.valueOf(R.drawable.bg_window_input)), TuplesKt.to(MaterialSceneType.ACTION_BAR, Integer.valueOf(R.drawable.bg_window_action_bar_chip)), TuplesKt.to(MaterialSceneType.ACTION_BAR_SELECTED, Integer.valueOf(R.drawable.bg_window_action_bar_selected_chip)), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL, Integer.valueOf(R.drawable.bg_window_action_bar_task_skill_chip)), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED, Integer.valueOf(R.drawable.bg_window_action_bar_task_skill_selected_chip)), TuplesKt.to(MaterialSceneType.BOTTOM_MENU, Integer.valueOf(R.drawable.bg_window_bottom_menu_chip)), TuplesKt.to(MaterialSceneType.WINDOW_BG, Integer.valueOf(R.drawable.bg_window)), TuplesKt.to(MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS, Integer.valueOf(R.drawable.bg_window)), TuplesKt.to(MaterialSceneType.FLOATING_BG, Integer.valueOf(R.drawable.bg_window_float_button))});
    L6:
        this.f394945a = r100;
        return;
    L5:
        r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to(MaterialSceneType.INPUT, Integer.valueOf(R.drawable.bg_window_input_v2)), TuplesKt.to(MaterialSceneType.ACTION_BAR, Integer.valueOf(R.drawable.bg_window_action_bar_chip_v2)), TuplesKt.to(MaterialSceneType.ACTION_BAR_SELECTED, Integer.valueOf(R.drawable.bg_window_action_bar_selected_chip_v2)), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL, Integer.valueOf(R.drawable.bg_window_action_bar_task_skill_chip_v2)), TuplesKt.to(MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED, Integer.valueOf(R.drawable.bg_window_action_bar_task_skill_selected_chip_v2)), TuplesKt.to(MaterialSceneType.BOTTOM_MENU, Integer.valueOf(R.drawable.bg_window_bottom_menu_chip_v2)), TuplesKt.to(MaterialSceneType.WINDOW_BG, Integer.valueOf(R.drawable.bg_window_v2)), TuplesKt.to(MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS, Integer.valueOf(R.drawable.bg_window_with_bottom_radius_v2)), TuplesKt.to(MaterialSceneType.FLOATING_BG, Integer.valueOf(R.drawable.bg_window_float_button_v2))});
        goto L6
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OMaterialHelper.j(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (OMaterialHelper.f() < 3) goto L7;
        return true;
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final void a(View r100, MaterialSceneType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "materialSceneType");
        if (b.f394946a[r101.ordinal()] == 1) goto L5;
        d(r100, r101);
        return;
    L5:
        if (r100.getId() == R.id.input_area_container_bg) goto L7;
        r100.setBackground(new ColorDrawable(0));
        return;
    L7:
        d(r100, r101);
    }

    public final void d(View r100, MaterialSceneType r101) {
        Integer r102 = this.f394945a.get(r101);
        if (r102 == null) goto L35;
        int r103 = r102.intValue();
        Object r104 = r100.getTag(R.id.obric_material_target_view);
        View r105 = null;
        if ((r104 instanceof View) == false) goto L7;
        View r106 = (View) r104;
    L8:
        if (r106 != null) goto L25;
        int r107 = b.f394946a[r101.ordinal()];
        if (r107 != 2) goto L12;
    L23:
        r105 = r100;
    L24:
        r106 = r105;
        goto L25
    L12:
        if (r107 == 3) goto L23;
        if (r107 == 4) goto L23;
        Context r108 = r100.getContext();
        if ((r108 instanceof Activity) == false) goto L18;
        Activity r109 = (Activity) r108;
    L19:
        if (r109 == null) goto L24;
        Window r110 = r109.getWindow();
        if (r110 == null) goto L24;
        r105 = r110.findViewById(R.id.input);
        goto L24
    L18:
        r109 = null;
    L25:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OMaterialHelper.t(r100, r106);
        r100.setBackground(AppCompatResources.getDrawable(r100.getContext(), r103));
        int[] r111 = r100.getDrawableState();
        Intrinsics.checkNotNull(r111);
        if (r111.length != 0) goto L28;
        boolean r112 = true;
    L30:
        if ((!r112) == false) goto L32;
        int[] r113 = new int[0];
    L33:
        r100.getBackground().setState(r113);
        r100.getBackground().setState(r111);
        r100.getBackground().invalidateSelf();
        return;
    L32:
        r113 = new int[]{android.R.attr.state_enabled};
        goto L33
    L28:
        r112 = false;
        goto L30
    L7:
        r106 = null;
        goto L8
    }

    @Override // com.obric.assistant.window.materials.services.IWindowMaterialService
    public final void c(List<? extends View> r100, List<? extends ImageView> r101, List<? extends TextView> r102) {
        Intrinsics.checkNotNullParameter(r100, "bgViews");
        Intrinsics.checkNotNullParameter(r101, "iconViews");
        Intrinsics.checkNotNullParameter(r102, "textViews");
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        View r104 = (View) r103.next();
        r104.setAlpha(1.0f);
        Lazy r105 = g.f19194a;
        g.a(r104, true, MaterialSceneType.BOTTOM_MENU);
        goto L4
    L6:
        Iterator<T> r106 = r101.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        ((ImageView) r106.next()).setBackground(new ColorDrawable(0));
        goto L8
    L10:
        Iterator<T> r107 = r102.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        ((TextView) r107.next()).setAlpha(1.0f);
        goto L12
    }
}
