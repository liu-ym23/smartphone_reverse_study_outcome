package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStatisStruct;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y {
    public static final CharSequence a(r14.c r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        MixStruct r0 = r6.y();
        if (r0 == null) goto L7;
        MixStatisStruct r1 = r0.getStatis();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.getCurrentEpisode());
    L8:
        if (r2 == null) goto L23;
        String r3 = r6.p();
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        String r5 = y54.a.a().getResources().getString(2131894233, new Object[]{r2});
        SpannableStringBuilder r7 = new SpannableStringBuilder(r5);
        r7.append(" | ");
        r7.setSpan(new ForegroundColorSpan(y54.a.a().getResources().getColor(2131100273)), r5.length() + 1, r5.length() + 2, 33);
        r7.append(r6.p());
        return r7;
    L19:
        return y54.a.a().getResources().getString(2131894233, new Object[]{r2});
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L17
    L23:
        return r6.p();
    L7:
        r2 = null;
        goto L8
    }
}
