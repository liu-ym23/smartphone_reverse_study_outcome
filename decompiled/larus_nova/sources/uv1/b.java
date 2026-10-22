package uv1;

import com.bytedance.android.livesdk.feed.g;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f551791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f551792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f551793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f551794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f551795e;

    @Override // com.bytedance.android.livesdk.feed.g
    public final String sR() {
        String r100 = this.f551792b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final String url() {
        String r100 = this.f551791a;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final Map SR() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int I9() {
        return this.f551795e;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final int f8() {
        return this.f551794d;
    }

    @Override // com.bytedance.android.livesdk.feed.g
    public final long hC() {
        return this.f551793c;
    }

    public b(String r100, String r101, long r102, int r103) {
        this.f551791a = r100;
        this.f551792b = r101;
        this.f551793c = r102;
        this.f551794d = 10;
        this.f551795e = r103;
    }
}
