package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final List<Float> a;

    public a(StoryProgressBar r4) {
        Intrinsics.checkNotNullParameter(r4, "progressBar");
        this.a = new ArrayList();
        new RectF();
        new Paint().setColor(ContextCompat.getColor(r4.getContext(), 2131100271));
        r4.setMChapterStoryProgressBarDrawer(this);
    }
}
