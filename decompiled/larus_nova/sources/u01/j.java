package u01;

import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements IPkExposeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pc0.d f548135a;

    @Override // com.bytedance.android.livesdkapi.feed.data.IPkExposeData
    public final int getIconId() {
        return this.f548135a.f528469d;
    }

    @Override // com.bytedance.android.livesdkapi.feed.data.IPkExposeData
    public final int getLeftTime() {
        return this.f548135a.f528466a;
    }

    @Override // com.bytedance.android.livesdkapi.feed.data.IPkExposeData
    public final int getLoadStatus() {
        return this.f548135a.f528470e;
    }

    @Override // com.bytedance.android.livesdkapi.feed.data.IPkExposeData
    public final int getPkState() {
        Integer r100 = this.f548135a.f528467b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.android.livesdkapi.feed.data.IPkExposeData
    public final int getPlayMode() {
        Integer r100 = this.f548135a.f528468c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public j(pc0.d r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f548135a = r100;
    }
}
