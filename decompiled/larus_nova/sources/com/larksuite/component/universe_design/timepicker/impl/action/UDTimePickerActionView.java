package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.datepicker.databinding.UdTimepickerActionviewBinding;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010&\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020#J\u000e\u0010-\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/action/UDTimePickerActionView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdTimepickerActionviewBinding;", "setPickerMode", "", "pickerModel", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "setLeftActionViewText", "text", "", "setInterval", VideoThumbInfo.KEY_INTERVAL, "setSelectedTime", "calendarDate", "Ljava/util/Calendar;", "setLeftActionViewTextSize", "size", "", "setLeftTextColor", "color", "setLeftActionViewClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setLeftActionViewVisibility", RemoteMessageConst.Notification.VISIBILITY, "getLeftActionView", "Landroid/widget/TextView;", "setRightActionViewText", "setRightActionViewTextSize", "setRightActionViewTextColor", "setRightActionViewClickListener", "setRightActionViewVisibility", "getRightActionView", "getUDTimePicker", "Lcom/larksuite/component/universe_design/timepicker/UDTimePicker;", "getTitleTextView", "setTitleText", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDTimePickerActionView extends LinearLayout {
    private final UdTimepickerActionviewBinding viewBinding;

    public UDTimePickerActionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public UDTimePickerActionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final TextView getLeftActionView() {
        return this.viewBinding.f284786b;
    }

    public final TextView getRightActionView() {
        return this.viewBinding.f284787c;
    }

    public final TextView getTitleTextView() {
        return this.viewBinding.f284789e;
    }

    public final UDTimePicker getUDTimePicker() {
        return this.viewBinding.f284788d;
    }

    public final void setInterval(int r100) {
        this.viewBinding.f284788d.setMinuteInterval(r100);
    }

    public final void setLeftActionViewClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.viewBinding.f284786b.setOnClickListener(r100);
    }

    public final void setLeftActionViewText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.viewBinding.f284786b.setText(r100);
    }

    public final void setLeftActionViewTextSize(float r100) {
        this.viewBinding.f284786b.setTextSize(0, r100);
    }

    public final void setLeftActionViewVisibility(int r100) {
        this.viewBinding.f284786b.setVisibility(r100);
    }

    public final void setLeftTextColor(int r100) {
        this.viewBinding.f284786b.setTextColor(r100);
    }

    public final void setPickerMode(PickerModel r100) {
        Intrinsics.checkNotNullParameter(r100, "pickerModel");
        this.viewBinding.f284788d.setPickerMode(r100);
    }

    public final void setRightActionViewClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.viewBinding.f284787c.setOnClickListener(r100);
    }

    public final void setRightActionViewText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.viewBinding.f284787c.setText(r100);
    }

    public final void setRightActionViewTextColor(int r100) {
        this.viewBinding.f284787c.setTextColor(r100);
    }

    public final void setRightActionViewTextSize(float r100) {
        this.viewBinding.f284787c.setTextSize(r100);
    }

    public final void setRightActionViewVisibility(int r100) {
        this.viewBinding.f284787c.setVisibility(r100);
    }

    public final void setSelectedTime(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "calendarDate");
        this.viewBinding.f284788d.setSelectedCalendar(r100);
    }

    public final void setTitleText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.viewBinding.f284789e.setText(r100);
    }

    public UDTimePickerActionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ud_timepicker_actionview, this, false);
        addView(r103);
        int r104 = R.id.leftActionView;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.leftActionView);
        if (r105 == null) goto L13;
        r104 = R.id.rightActionView;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.rightActionView);
        if (r106 == null) goto L13;
        r104 = R.id.timePicker;
        UDTimePicker r107 = (UDTimePicker) ViewBindings.findChildViewById(r103, R.id.timePicker);
        if (r107 == null) goto L13;
        r104 = R.id.titleTextView;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r103, R.id.titleTextView);
        if (r108 == null) goto L13;
        this.viewBinding = new UdTimepickerActionviewBinding((LinearLayout) r103, r105, r106, r107, r108);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ UDTimePickerActionView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
