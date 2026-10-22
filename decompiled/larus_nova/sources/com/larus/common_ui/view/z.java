package com.larus.common_ui.view;

import android.view.View;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes27.dex */
public final class z implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuggestedActionBar f328376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f328377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f328378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Set f328379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f328380e;

    public z(SuggestedActionBar r100, int r101, List r102, Set r103, Integer r104) {
        this.f328376a = r100;
        this.f328377b = r101;
        this.f328378c = r102;
        this.f328379d = r103;
        this.f328380e = r104;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        SuggestedActionBar r109 = this.f328376a;
        if (r109.f328278r != this.f328377b) goto L6;
        r109.h(this.f328378c, this.f328379d, this.f328380e);
        return;
    }
}
