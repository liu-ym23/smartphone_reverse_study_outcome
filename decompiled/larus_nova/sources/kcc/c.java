package kcc;

import android.text.SpannableStringBuilder;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static final void a(SpannableStringBuilder r100, a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r102, "label");
        b r103 = new b(r101);
        SpannableStringBuilder r104 = new SpannableStringBuilder(r102);
        r104.setSpan(r103, 0, r104.length(), 33);
        r100.append(r104);
    }
}
