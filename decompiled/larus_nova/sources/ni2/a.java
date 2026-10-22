package ni2;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f519228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f519229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f519230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExplainPlaybackVideoInfo f519231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECReplayVideo f519232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f519233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f519234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f519235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<ExplainReplaySubTitle> f519236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECUIPromotion f519237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f519238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f519239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f519240m;

    public a() {
        this(false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f519237j, r101.f519237j) == true) goto L8;
        return false;
    L8:
        if (this.f519238k == r101.f519238k) goto L10;
        return false;
    L10:
        if (this.f519239l == r101.f519239l) goto L12;
        return false;
    L12:
        if (this.f519240m == r101.f519240m) goto L22;
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
        ECUIPromotion r100 = this.f519237j;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f519238k;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f519239l;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        boolean r106 = this.f519240m;
        ?? r107 = r106;
        if (r106 == false) goto L10;
        r107 = 1;
    L10:
        return r105 + r107;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    public final String toString() {
        return "ECProductCardModel(promotion=" + this.f519237j + ", explainStartTime=" + this.f519238k + ", explainEndTime=" + this.f519239l + ", isGenera=" + this.f519240m + ")";
    }

    public /* synthetic */ a(boolean r100, int r101) {
        if ((r101 & 8) == 0) goto L5;
        boolean r102 = false;
    L6:
        this(null, 0, 0, r102);
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public a(ECUIPromotion r100, long r101, long r102, boolean r103) {
        this.f519237j = r100;
        this.f519238k = r101;
        this.f519239l = r102;
        this.f519240m = r103;
        this.f519235h = true;
    }
}
