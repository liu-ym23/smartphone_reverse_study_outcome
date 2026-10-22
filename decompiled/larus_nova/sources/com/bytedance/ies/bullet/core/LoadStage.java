package com.bytedance.ies.bullet.core;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/core/LoadStage;", "", "", "stage", "Ljava/lang/String;", "getStage", "()Ljava/lang/String;", "BEGIN", "START_LOAD", "DOWNLOAD_TEMPLATE", GXAnimation.STATE_END, "UPDATE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadStage extends Enum<LoadStage> {
    public static final LoadStage BEGIN = null;
    public static final LoadStage DOWNLOAD_TEMPLATE = null;
    public static final LoadStage END = null;
    public static final LoadStage START_LOAD = null;
    public static final LoadStage UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStage[] f246461a = null;
    private final String stage;

    public static LoadStage valueOf(String r100) {
        return (LoadStage) r27.a.a(LoadStage.class, r100);
    }

    public static LoadStage[] values() {
        return (LoadStage[]) f246461a.clone();
    }

    static {
        LoadStage r100 = new LoadStage("BEGIN", 0, GearStrategyConsts.EV_SELECT_BEGIN);
        BEGIN = r100;
        LoadStage r101 = new LoadStage("START_LOAD", 1, "start_load");
        START_LOAD = r101;
        LoadStage r102 = new LoadStage("DOWNLOAD_TEMPLATE", 2, "download_template");
        DOWNLOAD_TEMPLATE = r102;
        LoadStage r103 = new LoadStage(GXAnimation.STATE_END, 3, "end");
        END = r103;
        LoadStage r104 = new LoadStage("UPDATE", 4, "update");
        UPDATE = r104;
        f246461a = new LoadStage[]{r100, r101, r102, r103, r104};
    }

    public final String getStage() {
        return this.stage;
    }

    public LoadStage(String r100, int r101, String r102) {
        super(r100, r101);
        this.stage = r102;
    }
}
