package com.larus.bmhome.chat.deepresearch.component;

import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchBinding;
import com.larus.utils.e1;
import java.util.Map;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepReSearchContentComponent f302209a;

    public /* synthetic */ p(DeepReSearchContentComponent r100) {
        this.f302209a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepReSearchContentComponent r100 = this.f302209a;
        Map<String, Long> r101 = DeepReSearchContentComponent.M;
        LarusPageDeepResearchBinding r102 = r100.p3();
        if (r102 == null) goto L7;
        AppCompatImageView r103 = r102.f358808i;
        if (r103 == null) goto L7;
        e1.x(r103);
    L7:
        LarusPageDeepResearchBinding r104 = r100.p3();
        if (r104 == null) goto L13;
        ProgressBar r105 = r104.f358809j;
        if (r105 == null) goto L14;
        e1.o(r105);
        return;
    L14:
        return;
    }
}
