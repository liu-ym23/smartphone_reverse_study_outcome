package com.obric.assistant.settings.experience;

import android.view.View;
import com.obric.assistant.impl.databinding.ObricFragmentUserExperiencePlanBinding;
import com.obric.assistant.settings.p0;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricUserExperiencePlanFragment f392055a;

    public f(ObricUserExperiencePlanFragment r100) {
        this.f392055a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        ObricUserExperiencePlanFragment r109 = this.f392055a;
        ObricFragmentUserExperiencePlanBinding r110 = r109.f392027e;
        if (r110 == null) goto L9;
        OCardListItem r111 = r110.f389538f;
        if (r111 == null) goto L10;
        r109.f392030h = null;
        p0.d(r111);
        return;
    L10:
        return;
    }
}
