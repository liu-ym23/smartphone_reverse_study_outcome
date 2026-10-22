package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/ScaleType;", "", "ALWAYS_FIT_WIDTH", "AUTO_MODE", "CENTER_CROP", "FIT_CENTER", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType ALWAYS_FIT_WIDTH = null;
    public static final ScaleType AUTO_MODE = null;
    public static final ScaleType CENTER_CROP = null;
    public static final ScaleType FIT_CENTER = null;
    public static final /* synthetic */ ScaleType[] a = null;

    public static ScaleType valueOf(String r1) {
        return (ScaleType) a.a(ScaleType.class, r1);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) a.clone();
    }

    static {
        ScaleType r0 = new ScaleType("ALWAYS_FIT_WIDTH", 0);
        ALWAYS_FIT_WIDTH = r0;
        ScaleType r1 = new ScaleType("AUTO_MODE", 1);
        AUTO_MODE = r1;
        ScaleType r3 = new ScaleType("CENTER_CROP", 2);
        CENTER_CROP = r3;
        ScaleType r5 = new ScaleType("FIT_CENTER", 3);
        FIT_CENTER = r5;
        a = new ScaleType[]{r0, r1, r3, r5};
    }

    public ScaleType(String r1, int r2) {
        super(r1, r2);
    }
}
