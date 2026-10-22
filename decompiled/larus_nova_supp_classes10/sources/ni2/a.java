package ni2;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements QModel {
    public boolean a;
    public boolean b;
    public int c;
    public ExplainPlaybackVideoInfo d;
    public ECReplayVideo e;
    public String f;
    public Integer g;
    public boolean h;
    public List<ExplainReplaySubTitle> i;
    public final ECUIPromotion j;
    public final long k;
    public final long l;
    public final boolean m;

    public a() {
        this(false, 15);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L14;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L8;
        return false;
    L8:
        if (this.k == r7.k) goto L10;
        return false;
    L10:
        if (this.l == r7.l) goto L12;
        return false;
    L12:
        if (this.m == r7.m) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        ECUIPromotion r0 = this.j;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.k;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.l;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        boolean r6 = this.m;
        ?? r7 = r6;
        if (r6 == false) goto L10;
        r7 = 1;
    L10:
        return r5 + r7;
    L5:
        r1 = 0;
        goto L6
    }

    public final int modelType() {
        return 0;
    }

    public final String toString() {
        return "ECProductCardModel(promotion=" + this.j + ", explainStartTime=" + this.k + ", explainEndTime=" + this.l + ", isGenera=" + this.m + ")";
    }

    public /* synthetic */ a(boolean r8, int r9) {
        if ((r9 & 8) == 0) goto L5;
        boolean r6 = false;
    L6:
        this(null, 0, 0, r6);
        return;
    L5:
        r6 = r8;
        goto L6
    }

    public a(ECUIPromotion r1, long r2, long r4, boolean r6) {
        this.j = r1;
        this.k = r2;
        this.l = r4;
        this.m = r6;
        this.h = true;
    }
}
