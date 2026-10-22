package com.larus.login.impl.agegate;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;
import com.larus.login.impl.databinding.LarusAgeGatePageBinding;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes30.dex */
public final class m implements DatePicker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgeGateFragment f357344a;

    @Override // com.larus.common_ui.widget.datepicker.DatePicker.b
    public final void a() {
        Context r100 = this.f357344a.getContext();
        if (r100 == null) goto L17;
        AgeGateFragment r101 = this.f357344a;
        LarusAgeGatePageBinding r102 = r101.f357287h;
        if (r102 == null) goto L9;
        TextView r103 = r102.f357485e;
        if (r103 == null) goto L9;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r103.setText(String.format(r100.getString(R.string.larus_age_gate_age), Arrays.copyOf(new Object[]{Integer.valueOf(r101.Y90())}, 1)));
    L9:
        LarusAgeGatePageBinding r105 = r101.f357287h;
        if (r105 == null) goto L15;
        TextView r106 = r105.f357485e;
        if (r106 == null) goto L15;
        r106.setTextColor(ContextCompat.getColor(r100, R.color.larus_neutral_100));
    L15:
        if (r101.f357289j == false) goto L17;
        r101.Z90();
    L17:
        LarusAgeGatePageBinding r107 = this.f357344a.f357287h;
        if (r107 == null) goto L23;
        RectangleButton r108 = r107.f357484d;
        if (r108 == null) goto L24;
        r108.a(true);
        return;
    L24:
        return;
    }

    public m(AgeGateFragment r100) {
        this.f357344a = r100;
    }
}
