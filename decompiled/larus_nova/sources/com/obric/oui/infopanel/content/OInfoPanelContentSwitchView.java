package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.oswitch.OSwitch;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/obric/oui/oswitch/OSwitch;", "b", "Lcom/obric/oui/oswitch/OSwitch;", "getOSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "oSwitch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OInfoPanelContentSwitchView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f401287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSwitch f401288b;

    public final OSwitch getOSwitch() {
        return this.f401288b;
    }

    public final TextView getTvTitle() {
        return this.f401287a;
    }

    public OInfoPanelContentSwitchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OInfoPanelContentSwitchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_info_panel_content_switch_view, this);
        ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-1, -2);
        r102.setMargins(0, d.n(this, 16), 0, d.n(this, 12));
        setLayoutParams(r102);
        setBackgroundResource(R.drawable.o_info_panel_content_switch_view_bg);
        int r103 = d.n(this, 16);
        setPadding(r103, r103, r103, r103);
        this.f401287a = (TextView) findViewById(R.id.tv_title);
        OSwitch r104 = (OSwitch) findViewById(R.id.o_switch);
        this.f401288b = r104;
        j.a(r104, d.n(this, 44));
    }
}
