package com.bytedance.locallife.cube.api;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/cube/api/CubeTimingVersion;", "", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V2", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CubeTimingVersion extends Enum<CubeTimingVersion> {
    public static final CubeTimingVersion V1 = null;
    public static final CubeTimingVersion V2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CubeTimingVersion[] f257159a = null;

    public static CubeTimingVersion valueOf(String r100) {
        return (CubeTimingVersion) a.a(CubeTimingVersion.class, r100);
    }

    public static CubeTimingVersion[] values() {
        return (CubeTimingVersion[]) f257159a.clone();
    }

    static {
        CubeTimingVersion r100 = new CubeTimingVersion(OuterPayLoginWrapper.LOGIN_STYLE_V1, 0);
        V1 = r100;
        CubeTimingVersion r101 = new CubeTimingVersion("V2", 1);
        V2 = r101;
        f257159a = new CubeTimingVersion[]{r100, r101};
    }

    public CubeTimingVersion(String r100, int r101) {
        super(r100, r101);
    }
}
