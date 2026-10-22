package r80;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Configuration f536498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f536499b;

    public i(Configuration r100, float r101) {
        this.f536498a = r100;
        this.f536499b = r101;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "Samsung height " + this.f536498a.screenHeightDp + " width: " + this.f536498a.screenWidthDp + " ratio = " + this.f536499b;
    }
}
