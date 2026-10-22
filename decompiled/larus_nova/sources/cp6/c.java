package cp6;

import com.bytedance.locallife.cube.api.config.LoadType;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f464704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadType f464705d;

    public final String toString() {
        return "UrlConfig(url=" + this.f464702a + ", ditoTag=" + this.f464703b + ", loadType=" + this.f464705d + ')';
    }

    public c(String r100, int r101, String r102, boolean r103) {
        this.f464702a = r100;
        this.f464703b = r102;
        this.f464704c = r103;
        LoadType r104 = LoadType.OLD_PRELOAD;
        this.f464705d = r104;
        LoadType[] r105 = LoadType.values();
        if (r101 >= 0) goto L5;
    L7:
        this.f464705d = r104;
        return;
    L5:
        if (r101 > ArraysKt.getLastIndex(r105)) goto L7;
        r104 = r105[r101];
        goto L7
    }
}
