package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006$"}, d2 = {"Lcom/ss/android/lark/picker/base/view/ShrinkDutyView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sectionTV", "Landroid/widget/TextView;", "dutyTV", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/widget/ImageView;", "value", "", "section", "getSection", "()Ljava/lang/String;", "setSection", "(Ljava/lang/String;)V", "duty", "getDuty", "setDuty", "setTextSize", "", "size", "setTextColor", "color", "clearSection", "clearDuty", "setDividerVisibility", RemoteMessageConst.Notification.VISIBILITY, "setSectionVisibility", "setDutyVisibility", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShrinkDutyView extends FrameLayout {
    private ImageView divider;
    private TextView dutyTV;
    private TextView sectionTV;

    public ShrinkDutyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public ShrinkDutyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void clearDuty() {
        this.dutyTV.setText("");
    }

    public final void clearSection() {
        this.sectionTV.setText("");
    }

    public final String getDuty() {
        CharSequence r100 = this.dutyTV.getText();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getSection() {
        CharSequence r100 = this.sectionTV.getText();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final void setDividerVisibility(int r100) {
        this.divider.setVisibility(r100);
    }

    public final void setDuty(String r100) {
        this.dutyTV.setText(r100);
    }

    public final void setDutyVisibility(int r100) {
        this.dutyTV.setVisibility(r100);
    }

    public final void setSection(String r100) {
        this.sectionTV.setText(r100);
    }

    public final void setSectionVisibility(int r100) {
        this.sectionTV.setVisibility(r100);
    }

    public final void setTextColor(int r100) {
        this.sectionTV.setTextColor(r100);
        this.dutyTV.setTextColor(r100);
    }

    public final void setTextSize(int r100) {
        float r101 = r100;
        this.sectionTV.setTextSize(r101);
        this.dutyTV.setTextSize(r101);
    }

    public ShrinkDutyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.view_shrink_user_duty, this);
        this.sectionTV = (TextView) findViewById(R.id.tv_section);
        this.dutyTV = (TextView) findViewById(R.id.tv_duty);
        this.divider = (ImageView) findViewById(R.id.iv_divider);
    }

    public /* synthetic */ ShrinkDutyView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
