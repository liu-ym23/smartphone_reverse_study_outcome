package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStatisStruct;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class y {
    public static final CharSequence a(r14.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        MixStruct r101 = r100.y();
        if (r101 == null) goto L7;
        MixStatisStruct r102 = r101.getStatis();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getCurrentEpisode());
    L8:
        if (r103 == null) goto L23;
        String r104 = r100.p();
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        String r106 = y54.a.a().getResources().getString(R.string.aos_mix_current_episode_index, new Object[]{r103});
        SpannableStringBuilder r107 = new SpannableStringBuilder(r106);
        r107.append(" | ");
        r107.setSpan(new ForegroundColorSpan(y54.a.a().getResources().getColor(R.color.aos_const_text_inverse4)), r106.length() + 1, r106.length() + 2, 33);
        r107.append(r100.p());
        return r107;
    L19:
        return y54.a.a().getResources().getString(R.string.aos_mix_current_episode_index, new Object[]{r103});
    L12:
        if (r104.length() == 0) goto L15;
        r105 = false;
        goto L17
    L23:
        return r100.p();
    L7:
        r103 = null;
        goto L8
    }
}
