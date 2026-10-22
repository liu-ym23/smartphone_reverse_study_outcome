package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/model/ScaleType;", "", "ALWAYS_FIT_WIDTH", "AUTO_MODE", "CENTER_CROP", "FIT_CENTER", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType ALWAYS_FIT_WIDTH = null;
    public static final ScaleType AUTO_MODE = null;
    public static final ScaleType CENTER_CROP = null;
    public static final ScaleType FIT_CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScaleType[] f195183a = null;

    public static ScaleType valueOf(String r100) {
        return (ScaleType) a.a(ScaleType.class, r100);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) f195183a.clone();
    }

    static {
        ScaleType r100 = new ScaleType("ALWAYS_FIT_WIDTH", 0);
        ALWAYS_FIT_WIDTH = r100;
        ScaleType r101 = new ScaleType("AUTO_MODE", 1);
        AUTO_MODE = r101;
        ScaleType r102 = new ScaleType("CENTER_CROP", 2);
        CENTER_CROP = r102;
        ScaleType r103 = new ScaleType("FIT_CENTER", 3);
        FIT_CENTER = r103;
        f195183a = new ScaleType[]{r100, r101, r102, r103};
    }

    public ScaleType(String r100, int r101) {
        super(r100, r101);
    }
}
