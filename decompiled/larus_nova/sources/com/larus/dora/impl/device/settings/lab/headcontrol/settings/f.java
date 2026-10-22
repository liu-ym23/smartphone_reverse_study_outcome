package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.widget.TextView;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlSettingsBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class f<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadControlSettingsFragment f334754a;

    public f(HeadControlSettingsFragment r100) {
        this.f334754a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        w49.c r102 = (w49.c) r100;
        LarusDoraPageHeadControlSettingsBinding r103 = this.f334754a.f334745f;
        if (r103 == null) goto L9;
        ItemTextArrow r104 = r103.f332983f;
        if (r104 == null) goto L9;
        TextView r105 = r104.getSubTextView();
        if (r105 == null) goto L9;
        r105.setText(r102.f558269a.getTitle());
    L9:
        LarusDoraPageHeadControlSettingsBinding r106 = this.f334754a.f334745f;
        if (r106 == null) goto L17;
        ItemTextArrow r107 = r106.f332985h;
        if (r107 == null) goto L17;
        TextView r108 = r107.getSubTextView();
        if (r108 == null) goto L17;
        r108.setText(r102.f558270b.getTitle());
    L17:
        return Unit.INSTANCE;
    }
}
