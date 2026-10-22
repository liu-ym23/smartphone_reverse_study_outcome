package com.obric.assistant.card.layout.viewholder.style;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricCardItemStyleClockBinding;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rca.b;
import rca.c;
import rca.d;
import rca.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001.B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001aH\u0014J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001aH\u0002J \u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001aH\u0003J%\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\nH&¢\u0006\u0002\u0010-R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleClockBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "defaultMinimumHeight", "", "defaultPaddingStart", "defaultPaddingTop", "defaultPaddingEnd", "defaultPaddingBottom", "defaultTitleTextColor", "defaultTitleBottomToTop", "defaultTitleVerticalChainStyle", "defaultSecondTitleBottomToBottom", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;IZZ)V", "onEnabledStateChanged", "isEnabled", "bindAlarmSwitch", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "isChecked", "applyClockLayout", "useShowAllAlarmStyle", "applyShowAllAlarmTextConstraints", "bindSecondTitle", "title", "", "prioritizedExtra", "alignExtraToTitle", "updateInteractiveState", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemClockStyle<T extends AppEntity> extends AbsCardItemBaseStyle<T, ObricCardItemStyleClockBinding> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f386424u = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f386425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f386426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f386427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f386428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f386429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f386430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f386431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f386432s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f386433t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lca.a f386434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f386436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CharSequence f386437d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f386438e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386434a, r101.f386434a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386435b, r101.f386435b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386436c, r101.f386436c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386437d, r101.f386437d) == true) goto L21;
            return false;
        L21:
            if (this.f386438e == r101.f386438e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f386434a.hashCode() * 31) + this.f386435b.hashCode()) * 31) + this.f386436c.hashCode()) * 31) + this.f386437d.hashCode()) * 31;
            if (this.f386438e == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.f386434a + ", title=" + this.f386435b + ", secondTitle=" + this.f386436c + ", secondTitleExtra=" + this.f386437d + ", isEnabled=" + this.f386438e + ')';
        }

        public a(lca.a r100, String r101, CharSequence r102, CharSequence r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "iconRes");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "secondTitle");
            Intrinsics.checkNotNullParameter(r103, "secondTitleExtra");
            this.f386434a = r100;
            this.f386435b = r101;
            this.f386436c = r102;
            this.f386437d = r103;
            this.f386438e = r104;
        }
    }

    public abstract a a4(MessageExtraForViewHolder r100, AppEntity r101);

    public AbsCardItemClockStyle(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.obric_card_item_style_clock, r110, false);
        int r100 = R.id.action_start_barrier;
        Barrier r101 = (Barrier) ViewBindings.findChildViewById(r111, R.id.action_start_barrier);
        if (r101 == null) goto L21;
        r100 = R.id.end_switch;
        OSwitch r102 = (OSwitch) ViewBindings.findChildViewById(r111, R.id.end_switch);
        if (r102 == null) goto L21;
        ConstraintLayout r103 = (ConstraintLayout) r111;
        r100 = R.id.second_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r111, R.id.second_title);
        if (r104 == null) goto L21;
        r100 = R.id.second_title_container;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.second_title_container);
        if (r105 == null) goto L21;
        r100 = R.id.second_title_extra;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r111, R.id.second_title_extra);
        if (r106 == null) goto L21;
        r100 = R.id.second_title_separator;
        View r112 = ViewBindings.findChildViewById(r111, R.id.second_title_separator);
        if (r112 == null) goto L21;
        r100 = R.id.text_hint;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r111, R.id.text_hint);
        if (r113 == null) goto L21;
        r100 = R.id.title;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r111, R.id.title);
        if (r114 == null) goto L21;
        super(new ObricCardItemStyleClockBinding(r103, r101, r102, r103, r104, r105, r106, r112, r113, r114));
        this.f386425l = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.getMinimumHeight();
        this.f386426m = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.getPaddingStart();
        this.f386427n = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.getPaddingTop();
        this.f386428o = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.getPaddingEnd();
        this.f386429p = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.getPaddingBottom();
        this.f386430q = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.getCurrentTextColor();
        ViewGroup.LayoutParams r115 = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.f386431r = ((ConstraintLayout.LayoutParams) r115).bottomToTop;
        ViewGroup.LayoutParams r116 = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.getLayoutParams();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.f386432s = ((ConstraintLayout.LayoutParams) r116).verticalChainStyle;
        ViewGroup.LayoutParams r117 = ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.getLayoutParams();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.f386433t = ((ConstraintLayout.LayoutParams) r117).bottomToBottom;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386132b.setReferencedIds(new int[]{R.id.end_switch, R.id.text_hint});
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemBaseStyle
    public final void X3(boolean r100) {
        b4(r100);
    }

    public final void b4(boolean r100) {
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setEnabled(true);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setClickable(r100);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setFocusable(r100);
        OSwitch r101 = ((ObricCardItemStyleClockBinding) this.f386391a).f386133c;
        if (r100 == false) goto L5;
        View.OnTouchListener r102 = null;
    L6:
        r101.setOnTouchListener(r102);
        return;
    L5:
        r102 = new b();
        goto L6
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, Object r110, int r111, final boolean r112, final boolean r113) {
        final AppEntity r114 = (AppEntity) r110;
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        Intrinsics.checkNotNullParameter(r114, "entity");
        a r101 = a4(r100, r114);
        AppEntityListAdapter.PageType r115 = this.f386396f;
        if (r115 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r115 = null;
    L6:
        int r102 = 0;
        if (r115 == AppEntityListAdapter.PageType.ShowAllPage) goto L9;
    L11:
        boolean r116 = false;
    L12:
        ConstraintLayout r103 = ((ObricCardItemStyleClockBinding) this.f386391a).f386134d;
        if (r116 == false) goto L15;
        int r104 = getContext().getResources().getDimensionPixelSize(R.dimen.dp_74);
    L16:
        r103.setMinimumHeight(r104);
        if (r116 == false) goto L19;
        Integer r105 = Integer.valueOf(getContext().getResources().getDimensionPixelSize(R.dimen.dp_12));
    L20:
        if (r116 == false) goto L22;
        Integer r106 = Integer.valueOf(getContext().getResources().getDimensionPixelSize(R.dimen.dp_12));
    L23:
        if (r105 == null) goto L25;
        int r107 = r105.intValue();
    L26:
        if (r106 == null) goto L28;
        int r108 = r106.intValue();
    L29:
        if (r105 == null) goto L31;
        int r109 = r105.intValue();
    L32:
        if (r106 == null) goto L34;
        int r117 = r106.intValue();
    L35:
        r103.setPaddingRelative(r107, r108, r109, r117);
        TextView r118 = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j;
        Resources r119 = getContext().getResources();
        if (r116 == false) goto L38;
        int r120 = R.dimen.dp_24;
    L39:
        r118.setTextSize(0, r119.getDimension(r120));
        TextView r121 = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j;
        if (r116 == false) goto L42;
        int r122 = getContext().getResources().getColor(R.color.oui_basic_text_1);
    L43:
        r121.setTextColor(r122);
        Resources r123 = getContext().getResources();
        if (r116 == false) goto L46;
        int r124 = R.color.oui_basic_text_3;
    L47:
        int r125 = r123.getColor(r124);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setTextColor(r125);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setTextColor(r125);
        ViewGroup.LayoutParams r126 = ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.getLayoutParams();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r127 = (ConstraintLayout.LayoutParams) r126;
        if (r116 == false) goto L50;
        int r128 = R.id.second_title_container;
    L51:
        r127.bottomToTop = r128;
        if (r116 == false) goto L54;
        int r129 = 2;
    L55:
        r127.verticalChainStyle = r129;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.setLayoutParams(r127);
        ViewGroup.LayoutParams r130 = ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.getLayoutParams();
        Intrinsics.checkNotNull(r130, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r131 = (ConstraintLayout.LayoutParams) r130;
        if (r116 == false) goto L58;
        int r132 = 0;
    L59:
        r131.bottomToBottom = r132;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.setLayoutParams(r131);
        ViewGroup.LayoutParams r133 = ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.getLayoutParams();
        Intrinsics.checkNotNull(r133, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r134 = (LinearLayout.LayoutParams) r133;
        if (r116 == false) goto L62;
        int r135 = -2;
    L63:
        r134.width = r135;
        if (r116 == false) goto L66;
        float r136 = 0.0f;
    L67:
        r134.weight = r136;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setLayoutParams(r134);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386140j.setText(r101.f386435b);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386134d.setOnClickListener(new c(r112, this, r113, r114));
        if ((r114 instanceof AlarmEntity) == false) goto L70;
        final AlarmEntity r137 = (AlarmEntity) r114;
        boolean r138 = r101.f386438e;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setOnCheckedChangeListener(null);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setChecked(r138);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setOnCheckedChangeListener(new d(r137));
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setVisibility(8);
    L71:
        if (r112 == false) goto L73;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setText(getContext().getResources().getString(R.string.obric_already_deleted));
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setVisibility(8);
    L75:
        CharSequence r139 = StringsKt.trim(r101.f386436c, new char[]{'\n'});
        CharSequence r140 = StringsKt.trim(r101.f386437d, new char[]{'\n'});
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setText(r139);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setText(r140);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setMaxWidth(Integer.MAX_VALUE);
        if (r140.length() != 0) goto L78;
        boolean r141 = true;
    L79:
        if (r141 == false) goto L94;
        LinearLayout r142 = ((ObricCardItemStyleClockBinding) this.f386391a).f386136f;
        if (r139.length() != 0) goto L83;
        boolean r143 = true;
    L84:
        if (r143 == false) goto L86;
        int r144 = 8;
    L87:
        r142.setVisibility(r144);
        TextView r145 = ((ObricCardItemStyleClockBinding) this.f386391a).f386135e;
        if (r139.length() != 0) goto L90;
        boolean r146 = true;
    L91:
        if (r146 == false) goto L93;
        r102 = 8;
    L93:
        r145.setVisibility(r102);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setVisibility(8);
    L124:
        b4(true);
        return;
    L90:
        r146 = false;
        goto L91
    L86:
        r144 = 0;
        goto L87
    L83:
        r143 = false;
        goto L84
    L94:
        ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.setVisibility(4);
        TextView r147 = ((ObricCardItemStyleClockBinding) this.f386391a).f386135e;
        if (r139.length() != 0) goto L97;
        boolean r148 = true;
    L98:
        if (r148 == false) goto L100;
        int r149 = 8;
    L101:
        r147.setVisibility(r149);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.setVisibility(4);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setVisibility(4);
        LinearLayout r150 = ((ObricCardItemStyleClockBinding) this.f386391a).f386136f;
        if (r150.isLaidOut() == true) goto L104;
    L123:
        r150.addOnLayoutChangeListener(new e(this, r140, r139, r116));
        goto L124
    L104:
        if (r150.isLayoutRequested() == true) goto L123;
        int r151 = ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.getWidth();
        float r152 = ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.getPaint().measureText(r140.toString());
        ViewGroup.LayoutParams r153 = ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.getLayoutParams();
        Intrinsics.checkNotNull(r153, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r154 = (ViewGroup.MarginLayoutParams) r153;
        int r155 = (((ObricCardItemStyleClockBinding) this.f386391a).f386138h.getMeasuredWidth() + r154.getMarginStart()) + r154.getMarginEnd();
        int r156 = getContext().getResources().getDimensionPixelSize(R.dimen.dp_24);
        if (r151 <= 0) goto L122;
        float r157 = r151;
        if (r152 > r157) goto L122;
        if (r139.length() != 0) goto L113;
        boolean r158 = true;
    L114:
        if (r158 == true) goto L121;
        float r159 = r155;
        if (((r152 + r159) + r156) > r157) goto L121;
        if (r116 == false) goto L120;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setMaxWidth((int) ((r157 - r152) - r159));
    L120:
        ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setVisibility(0);
    L121:
        ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setVisibility(0);
        goto L124
    L113:
        r158 = false;
    L122:
        ((ObricCardItemStyleClockBinding) this.f386391a).f386136f.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386135e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386138h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386137g.setVisibility(8);
        goto L124
    L100:
        r149 = 4;
        goto L101
    L97:
        r148 = false;
        goto L98
    L78:
        r141 = false;
        goto L79
    L73:
        if (r113 == false) goto L75;
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setText(getContext().getResources().getString(R.string.obric_already_invalid));
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setVisibility(8);
        goto L75
    L70:
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setOnCheckedChangeListener(null);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386133c.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.f386391a).f386139i.setVisibility(8);
        goto L71
    L66:
        r136 = 1.0f;
        goto L67
    L62:
        r135 = 0;
        goto L63
    L58:
        r132 = this.f386433t;
        goto L59
    L54:
        r129 = this.f386432s;
        goto L55
    L50:
        r128 = this.f386431r;
        goto L51
    L46:
        r124 = R.color.neutral_70;
        goto L47
    L42:
        r122 = this.f386430q;
        goto L43
    L38:
        r120 = R.dimen.dp_28;
        goto L39
    L34:
        r117 = this.f386429p;
        goto L35
    L31:
        r109 = this.f386428o;
        goto L32
    L28:
        r108 = this.f386427n;
        goto L29
    L25:
        r107 = this.f386426m;
        goto L26
    L22:
        r106 = null;
        goto L23
    L19:
        r105 = null;
        goto L20
    L15:
        r104 = this.f386425l;
        goto L16
    L9:
        if ((r114 instanceof AlarmEntity) == false) goto L11;
        r116 = true;
        goto L12
    }
}
