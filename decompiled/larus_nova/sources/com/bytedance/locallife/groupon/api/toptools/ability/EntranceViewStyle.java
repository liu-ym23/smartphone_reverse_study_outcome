package com.bytedance.locallife.groupon.api.toptools.ability;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/ability/EntranceViewStyle;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STYLE_NORMAL", "STYLE_TOP", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum EntranceViewStyle extends Enum<EntranceViewStyle> {
    public static final a Companion = null;
    public static final EntranceViewStyle STYLE_NORMAL = null;
    public static final EntranceViewStyle STYLE_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceViewStyle[] f258787a = null;

    public static EntranceViewStyle valueOf(String r100) {
        return (EntranceViewStyle) r27.a.a(EntranceViewStyle.class, r100);
    }

    public static EntranceViewStyle[] values() {
        return (EntranceViewStyle[]) f258787a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.groupon.api.toptools.ability.EntranceViewStyle$a] */
    static {
        EntranceViewStyle r100 = new EntranceViewStyle("STYLE_NORMAL", 0);
        STYLE_NORMAL = r100;
        EntranceViewStyle r101 = new EntranceViewStyle("STYLE_TOP", 1);
        STYLE_TOP = r101;
        f258787a = new EntranceViewStyle[]{r100, r101};
        Companion = new a();
    }

    public EntranceViewStyle(String r100, int r101) {
        super(r100, r101);
    }
}
