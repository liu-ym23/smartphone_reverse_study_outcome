package lm1;

import com.larus.nova.R;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f509833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<String> f509834b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f509833a == r101.f509833a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509834b, r101.f509834b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f509833a * 31;
        BehaviorSubject<String> r101 = this.f509834b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ReplayEmojiSelectPanelParam(smallEmojiPanelBtn=" + this.f509833a + ", switchPanelSubject=" + this.f509834b + ")";
    }

    public e(BehaviorSubject r100) {
        this.f509833a = R.drawable.ttlive_vs_ic_small_emoji_section;
        this.f509834b = r100;
    }
}
