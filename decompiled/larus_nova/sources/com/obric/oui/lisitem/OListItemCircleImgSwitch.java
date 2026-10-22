package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImgSwitch;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "", "setOnCheckedChangeListener", "", "checked", "setChecked", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemCircleImgSwitch extends OListItemCircleImg {
    public static final /* synthetic */ int D = 0;
    public final OSwitch B;
    public CompoundButton.OnCheckedChangeListener C;

    public final void setChecked(boolean r100) {
        this.B.setChecked(r100);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        this.C = r100;
    }

    public OListItemCircleImgSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        OSwitch r102 = new OSwitch(r100, null, 6, 0);
        r102.setClickable(true);
        r102.setOnCheckedChangeListener(new e(this));
        this.B = r102;
        setTrailingView(r102);
    }
}
