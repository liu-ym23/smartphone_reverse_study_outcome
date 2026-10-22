package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.oui.oswitch.OSwitch;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSwitch;", "Lcom/obric/oui/lisitem/OListItemSettings;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "", "setOnCheckedChangeListener", "", "checked", "setChecked", "enabled", "setEnabled", "Lcom/obric/oui/oswitch/OSwitch;", "getSwitch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemSwitch extends OListItemSettings {
    public static final /* synthetic */ int E = 0;
    public final OSwitch C;
    public CompoundButton.OnCheckedChangeListener D;

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_switch, this);
    }

    public final OSwitch getSwitch() {
        return this.C;
    }

    public final void setChecked(boolean r100) {
        this.C.setChecked(r100);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.C.setAlpha(1.0f);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        this.D = r100;
    }

    public OListItemSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setClickable(false);
        AttributeSet r102 = null;
        int r103 = 6;
        OSwitch r104 = new OSwitch(r100, r102, r103, 0);
        r104.setClickable(true);
        r104.setOnCheckedChangeListener(new f(this));
        this.C = r104;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        r105.leftMargin = pla.d.n(this, 4);
        r105.rightMargin = pla.d.n(this, 4);
        e(getMTrailingElement(), r104, r105);
    }
}
