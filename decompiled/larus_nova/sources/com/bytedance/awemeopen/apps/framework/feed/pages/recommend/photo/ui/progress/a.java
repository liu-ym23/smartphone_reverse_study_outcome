package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f195343a;

    public a(StoryProgressBar r100) {
        Intrinsics.checkNotNullParameter(r100, "progressBar");
        this.f195343a = new ArrayList();
        new RectF();
        new Paint().setColor(ContextCompat.getColor(r100.getContext(), R.color.aos_const_text_inverse));
        r100.setMChapterStoryProgressBarDrawer(this);
    }
}
