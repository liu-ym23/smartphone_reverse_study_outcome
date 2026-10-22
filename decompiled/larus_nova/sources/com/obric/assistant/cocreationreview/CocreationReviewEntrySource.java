package com.obric.assistant.cocreationreview;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewEntrySource;", "", "trackValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackValue", "()Ljava/lang/String;", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, EffectConstants.NORMAL, "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CocreationReviewEntrySource extends Enum<CocreationReviewEntrySource> {
    public static final a Companion = null;
    public static final CocreationReviewEntrySource NORMAL = null;
    public static final CocreationReviewEntrySource PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CocreationReviewEntrySource[] f387102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387103b = null;
    private final String trackValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CocreationReviewEntrySource> getEntries() {
        return f387103b;
    }

    static {
        CocreationReviewEntrySource r100 = new CocreationReviewEntrySource(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0, "outer_push");
        PUSH = r100;
        CocreationReviewEntrySource r101 = new CocreationReviewEntrySource(EffectConstants.NORMAL, 1, "normal");
        NORMAL = r101;
        CocreationReviewEntrySource[] r102 = {r100, r101};
        f387102a = r102;
        f387103b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static CocreationReviewEntrySource[] values() {
        return (CocreationReviewEntrySource[]) f387102a.clone();
    }

    public final String getTrackValue() {
        return this.trackValue;
    }

    public static CocreationReviewEntrySource valueOf(String r100) {
        return (CocreationReviewEntrySource) r27.a.a(CocreationReviewEntrySource.class, r100);
    }

    public CocreationReviewEntrySource(String r100, int r101, String r102) {
        super(r100, r101);
        this.trackValue = r102;
    }
}
