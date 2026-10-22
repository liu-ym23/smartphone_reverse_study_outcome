package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextToggle;", "Lcom/larus/bmhome/view/item/ItemTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRestoring", "", "()Z", "setRestoring", "(Z)V", "setEnabled", "", "enabled", "subTextView", "Landroid/widget/TextView;", "getSubTextView", "()Landroid/widget/TextView;", "toggleView", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getToggleView", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "init", "setImageSrc", "resId", "setSubText", "text", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextToggle extends ItemTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f316977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f316978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CustomSwitchCompat f316979e;

    private final void T5() {
        View r100 = this.f316979e;
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-2, i5.C());
        r101.topToTop = 0;
        r101.bottomToBottom = 0;
        r101.endToEnd = 0;
        Unit r102 = Unit.INSTANCE;
        addView(r100, r101);
        View r103 = this.f316978d;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(0, -2);
        r104.topToBottom = getTextView().getId();
        r104.bottomToBottom = 0;
        r104.startToEnd = getImageView().getId();
        r104.verticalBias = 0.0f;
        boolean r105 = true;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        r104.setMarginStart(i5.q());
        r104.setMarginEnd(0);
    L10:
        if (this.f316979e.getVisibility() != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        r104.endToStart = this.f316979e.getId();
    L16:
        this.f316978d.setVisibility(8);
        addView(r103, r104);
        TextView r108 = getTextView();
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(0, -2);
        r109.topToTop = 0;
        r109.bottomToTop = this.f316978d.getId();
        r109.startToEnd = getImageView().getId();
        if (getImageView().getVisibility() != 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L22;
        r109.setMarginStart(i5.q());
        r109.setMarginEnd(0);
    L24:
        if (this.f316979e.getVisibility() != 0) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        r109.endToStart = this.f316979e.getId();
    L30:
        r108.setLayoutParams(r109);
        ViewGroup.LayoutParams r112 = getTextView().getLayoutParams();
        if ((r112 instanceof ConstraintLayout.LayoutParams) == false) goto L33;
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
    L34:
        if (r113 == null) goto L44;
        ((ViewGroup.MarginLayoutParams) r113).width = 0;
        r113.topToTop = 0;
        r113.bottomToBottom = 0;
        r113.startToEnd = getImageView().getId();
        r113.endToStart = this.f316979e.getId();
        if (getImageView().getVisibility() == 0) goto L39;
        r105 = false;
    L39:
        if (r105 == false) goto L41;
        r113.setMarginStart(i5.q());
        r113.setMarginEnd(i5.q());
        r113.setMarginEnd(0);
    L42:
        getTextView().setGravity(GravityCompat.START);
        return;
    L41:
        r113.setMarginStart(0);
        r113.setMarginEnd(0);
        goto L42
    L44:
        return;
    L33:
        r113 = null;
        goto L34
    L29:
        r109.endToEnd = 0;
        goto L30
    L26:
        r111 = false;
        goto L27
    L22:
        r109.setMarginStart(0);
        r109.setMarginEnd(0);
        goto L24
    L19:
        r110 = false;
        goto L20
    L15:
        r104.endToEnd = 0;
        goto L16
    L12:
        r107 = false;
        goto L13
    L8:
        r104.setMarginStart(0);
        r104.setMarginEnd(0);
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    public final TextView getSubTextView() {
        return this.f316978d;
    }

    public final CustomSwitchCompat getToggleView() {
        return this.f316979e;
    }

    public ItemTextToggle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        TextView r101 = new TextView(getContext());
        r101.setId(R.id.view_id_sub_text);
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), c.b(R.attr.larus_neutral_50, r101.getContext(), R.color.larus_neutral_50)));
        r101.setTextSize(0, i5.k());
        r101.setGravity(16);
        this.f316978d = r101;
        CustomSwitchCompat r102 = new CustomSwitchCompat(getContext(), null);
        r102.setId(ViewGroup.generateViewId());
        r102.setChecked(true);
        r102.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r102.setTrackResource(c.b(R.attr.larus_bg_switch_track, r102.getContext(), R.drawable.larus_bg_switch_track));
        this.f316979e = r102;
        T5();
    }

    @Override // com.larus.bmhome.view.item.ItemTextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f316979e.setEnabled(r100);
    }

    @Override // com.larus.bmhome.view.item.ItemTextView
    public void setImageSrc(int r100) {
        super.setImageSrc(r100);
        ViewGroup.LayoutParams r101 = this.f316978d.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102.setMarginStart(i5.q());
        r102.setMarginEnd(0);
    L9:
        this.f316978d.setLayoutParams(r102);
        return;
    L8:
        r102.setMarginStart(0);
        r102.setMarginEnd(0);
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    public final void setRestoring(boolean r100) {
        this.f316977c = r100;
    }

    public final void setSubText(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        this.f316978d.setText(r100);
        this.f316978d.setVisibility(0);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public ItemTextToggle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_sub_text);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50)));
        r102.setTextSize(0, i5.k());
        r102.setGravity(16);
        this.f316978d = r102;
        CustomSwitchCompat r103 = new CustomSwitchCompat(getContext(), null);
        r103.setId(ViewGroup.generateViewId());
        r103.setChecked(true);
        r103.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r103.setTrackResource(c.b(R.attr.larus_bg_switch_track, r103.getContext(), R.drawable.larus_bg_switch_track));
        this.f316979e = r103;
        T5();
    }

    public ItemTextToggle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_sub_text);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_50, r103.getContext(), R.color.larus_neutral_50)));
        r103.setTextSize(0, i5.k());
        r103.setGravity(16);
        this.f316978d = r103;
        CustomSwitchCompat r104 = new CustomSwitchCompat(getContext(), null);
        r104.setId(ViewGroup.generateViewId());
        r104.setChecked(true);
        r104.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r104.setTrackResource(c.b(R.attr.larus_bg_switch_track, r104.getContext(), R.drawable.larus_bg_switch_track));
        this.f316979e = r104;
        T5();
    }
}
