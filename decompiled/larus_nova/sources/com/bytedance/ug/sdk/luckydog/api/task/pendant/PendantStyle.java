package com.bytedance.ug.sdk.luckydog.api.task.pendant;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/pendant/PendantStyle;", "", EffectConstants.NORMAL, "ALL_RADIUS", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum PendantStyle extends Enum<PendantStyle> {
    public static final PendantStyle ALL_RADIUS = null;
    public static final PendantStyle NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PendantStyle[] f271669a = null;

    static {
        PendantStyle r100 = new PendantStyle(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        PendantStyle r101 = new PendantStyle("ALL_RADIUS", 1);
        ALL_RADIUS = r101;
        f271669a = new PendantStyle[]{r100, r101};
    }

    public static PendantStyle valueOf(String r100) {
        return (PendantStyle) a.a(PendantStyle.class, r100);
    }

    public static PendantStyle[] values() {
        return (PendantStyle[]) f271669a.clone();
    }

    public PendantStyle(String r100, int r101) {
        super(r100, r101);
    }
}
