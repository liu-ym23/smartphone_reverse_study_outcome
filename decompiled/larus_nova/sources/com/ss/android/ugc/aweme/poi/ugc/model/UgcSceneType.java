package com.ss.android.ugc.aweme.poi.ugc.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ugc/model/UgcSceneType;", "", "", "value", "I", "getValue", "()I", "Companion", "POI", "POI_UGC_LIST", "SPU_UGC_LIST", "STAFF", "LIFE_VIDEO", "FEED_POI_UGC_LIST", "FEED_SPU_UGC_LIST", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum UgcSceneType extends Enum<UgcSceneType> {
    public static final Companion Companion = null;
    public static final UgcSceneType FEED_POI_UGC_LIST = null;
    public static final UgcSceneType FEED_SPU_UGC_LIST = null;
    public static final UgcSceneType LIFE_VIDEO = null;
    public static final UgcSceneType POI = null;
    public static final UgcSceneType POI_UGC_LIST = null;
    public static final UgcSceneType SPU_UGC_LIST = null;
    public static final UgcSceneType STAFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UgcSceneType[] f451361a = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/ugc/model/UgcSceneType$Companion;", "", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    public static UgcSceneType valueOf(String r100) {
        return (UgcSceneType) a.a(UgcSceneType.class, r100);
    }

    public static UgcSceneType[] values() {
        return (UgcSceneType[]) f451361a.clone();
    }

    static {
        UgcSceneType r100 = new UgcSceneType("POI", 0, 0);
        POI = r100;
        UgcSceneType r101 = new UgcSceneType("POI_UGC_LIST", 1, 1);
        POI_UGC_LIST = r101;
        UgcSceneType r102 = new UgcSceneType("SPU_UGC_LIST", 2, 2);
        SPU_UGC_LIST = r102;
        UgcSceneType r103 = new UgcSceneType("STAFF", 3, 4);
        STAFF = r103;
        UgcSceneType r104 = new UgcSceneType("LIFE_VIDEO", 4, 3);
        LIFE_VIDEO = r104;
        UgcSceneType r110 = new UgcSceneType("FEED_POI_UGC_LIST", 5, 7);
        FEED_POI_UGC_LIST = r110;
        UgcSceneType r111 = new UgcSceneType("FEED_SPU_UGC_LIST", 6, 8);
        FEED_SPU_UGC_LIST = r111;
        f451361a = new UgcSceneType[]{r100, r101, r102, r103, r104, r110, r111};
        Companion = new Companion(0);
    }

    public final int getValue() {
        return this.value;
    }

    public UgcSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
