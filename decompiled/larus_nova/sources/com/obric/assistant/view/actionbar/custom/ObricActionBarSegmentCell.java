package com.obric.assistant.view.actionbar.custom;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import aq8.e;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qha.a;
import qha.b;
import qha.c;
import v19.h;
import wa8.u1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0004J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/view/actionbar/custom/ObricActionBarSegmentCell;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "binding", "Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "defaultClickCallback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerse", "", ControlRule.KEY_EXTRA_DATA, "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "Lcom/larus/bmhome/instruction/InstructionExtraData;", "<init>", "(Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZLcom/larus/bmhome/instruction/core/model/InstructionExtraData;)V", "getBinding", "()Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "updateExtraData", "", "bind", "name", "", "url", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "", "onViewRecycle", "clearTransientPressState", "renderRedDotInfo", "applyRedDotTextStyle", "redDotTextInfo", "Lcom/larus/bmhome/actionbar/model/RedDotTextStyleInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricActionBarSegmentCell extends BaseActionBarHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f394029e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricItemCustomActionbarNormalHolderBinding f394030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f394031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f394032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f394033d;

    public final void V3() {
        RoundConstraintLayout r100 = W3().f389593a;
        r100.setPressed(false);
        r100.setHovered(false);
        r100.refreshDrawableState();
        r100.jumpDrawablesToCurrentState();
    }

    @Override // com.larus.bmhome.view.actionbar.BaseActionBarHolder
    public final void T3() {
        V3();
    }

    public ObricItemCustomActionbarNormalHolderBinding W3() {
        return this.f394030a;
    }

    public ObricActionBarSegmentCell(ObricItemCustomActionbarNormalHolderBinding r100, t1 r101, boolean r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        super(r100.f389593a);
        this.f394030a = r100;
        this.f394031b = r101;
        this.f394032c = r102;
        this.f394033d = r103;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [qha.b] */
    public void U3(String r100, String r101, final z0 r102, final int r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        V3();
        GradientDrawable r104 = null;
        ImageLoaderKt.u(W3().f389595c, r101, null);
        W3().f389596d.setText(r100);
        e1.d(W3().f389593a, new a(this, r102, r103));
        if (this.f394032c == false) goto L13;
        View r105 = this.itemView;
        if ((r105 instanceof RoundConstraintLayout) == false) goto L7;
        RoundConstraintLayout r106 = (RoundConstraintLayout) r105;
    L8:
        if (r106 == null) goto L12;
        c29.a r107 = r106.getDelegate();
        if (r107 == null) goto L12;
        int r108 = ContextCompat.getColor(this.itemView.getContext(), R.color.static_white_transparent_0);
        r107.a(r108);
        r107.b(r108);
        r107.g(ContextCompat.getColor(this.itemView.getContext(), R.color.static_white_transparent_1));
    L12:
        W3().f389596d.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.static_white));
    L33:
        final ?? r109 = new b(this);
        if (W3().f389596d.getWidth() != 0) goto L36;
    L39:
        W3().f389596d.post(new c(r109));
    L40:
        W3().f389595c.setColorFilter(ColorProtector.parseColor("#FF000000"));
        this.f394031b.d(this.itemView, W3().f389595c, W3().f389596d, r102);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        W3().f389594b.setVisibility(8);
        if (r102.f295629y == true) goto L43;
        W3().f389597e.setVisibility(8);
        return;
    L43:
        u1 r110 = r102.f295630z;
        if (r110 == null) goto L46;
        String r111 = r110.f558894a;
    L48:
        if (r111 != null) goto L50;
    L53:
        boolean r112 = true;
    L54:
        if (r112 == false) goto L56;
        W3().f389597e.setVisibility(8);
        W3().f389594b.setVisibility(0);
        return;
    L56:
        W3().f389597e.setVisibility(0);
        TextView r113 = W3().f389597e;
        if (r110 == null) goto L59;
        String r114 = r110.f558894a;
    L60:
        if (r114 != null) goto L62;
        r114 = "";
    L62:
        r113.setText(r114);
        TextView r115 = W3().f389597e;
        if (r110 == null) goto L65;
        int r116 = r110.f558895b;
    L66:
        r115.setTextColor(r116);
        Drawable r117 = W3().f389597e.getBackground();
        if (r117 == null) goto L69;
        Drawable r118 = r117.mutate();
    L71:
        if ((r118 instanceof GradientDrawable) == false) goto L73;
        r104 = (GradientDrawable) r118;
    L73:
        if (r104 == null) goto L81;
        if (r110 == null) goto L76;
        int r119 = r110.f558896c;
    L77:
        r104.setColor(r119);
        return;
    L76:
        r119 = ContextCompat.getColor(this.itemView.getContext(), v19.c.b(R.attr.primary_transparent_2, this.itemView.getContext(), R.color.primary_transparent_2));
        goto L77
    L81:
        return;
    L69:
        r118 = null;
        goto L71
    L65:
        r116 = ContextCompat.getColor(this.itemView.getContext(), v19.c.b(R.attr.larus_primary_50, this.itemView.getContext(), R.color.larus_primary_50));
        goto L66
    L59:
        r114 = null;
        goto L60
    L50:
        if (r111.length() == 0) goto L53;
        r112 = false;
        goto L54
    L46:
        r111 = null;
        goto L48
    L36:
        if (W3().f389596d.getHeight() == 0) goto L39;
        r109.invoke();
        goto L40
    L7:
        r106 = null;
        goto L8
    L13:
        boolean r120 = h.f552477a;
        if (h.b(this.itemView.getContext()) == false) goto L16;
        int r121 = R.color.larus_bg_action_bar_item_night_color;
    L17:
        View r122 = this.itemView;
        if ((r122 instanceof RoundConstraintLayout) == false) goto L20;
        RoundConstraintLayout r123 = (RoundConstraintLayout) r122;
    L21:
        if (r123 == null) goto L25;
        c29.a r124 = r123.getDelegate();
        if (r124 == null) goto L25;
        r124.a(ContextCompat.getColor(this.itemView.getContext(), r121));
    L25:
        View r125 = this.itemView;
        if ((r125 instanceof RoundFrameLayout) == false) goto L28;
        RoundFrameLayout r126 = (RoundFrameLayout) r125;
    L29:
        if (r126 == null) goto L33;
        c29.a r127 = r126.getDelegate();
        if (r127 == null) goto L33;
        r127.a(ContextCompat.getColor(this.itemView.getContext(), r121));
        goto L33
    L28:
        r126 = null;
        goto L29
    L20:
        r123 = null;
        goto L21
    L16:
        r121 = R.color.larus_bg_action_bar_item_light_color;
        goto L17
    }
}
