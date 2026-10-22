package com.bytedance.locallife.groupon.struct;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GuideTypeUnknown", "GuideTypeSnackBar", "GuideTypeBottomPanel", "GuideTypeFeedCard", "GuideTypeDialog", "GuideTypeEnhanceSnackBar", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum TopGuideType extends Enum<TopGuideType> {
    public static final a Companion = null;
    public static final TopGuideType GuideTypeBottomPanel = null;
    public static final TopGuideType GuideTypeDialog = null;
    public static final TopGuideType GuideTypeEnhanceSnackBar = null;
    public static final TopGuideType GuideTypeFeedCard = null;
    public static final TopGuideType GuideTypeSnackBar = null;
    public static final TopGuideType GuideTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TopGuideType[] f258841a = null;
    private final int value;

    public static TopGuideType valueOf(String r100) {
        return (TopGuideType) r27.a.a(TopGuideType.class, r100);
    }

    public static TopGuideType[] values() {
        return (TopGuideType[]) f258841a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.groupon.struct.TopGuideType$a] */
    static {
        TopGuideType r100 = new TopGuideType("GuideTypeUnknown", 0, 0);
        GuideTypeUnknown = r100;
        TopGuideType r101 = new TopGuideType("GuideTypeSnackBar", 1, 1);
        GuideTypeSnackBar = r101;
        TopGuideType r102 = new TopGuideType("GuideTypeBottomPanel", 2, 2);
        GuideTypeBottomPanel = r102;
        TopGuideType r103 = new TopGuideType("GuideTypeFeedCard", 3, 3);
        GuideTypeFeedCard = r103;
        TopGuideType r104 = new TopGuideType("GuideTypeDialog", 4, 4);
        GuideTypeDialog = r104;
        TopGuideType r105 = new TopGuideType("GuideTypeEnhanceSnackBar", 5, 5);
        GuideTypeEnhanceSnackBar = r105;
        f258841a = new TopGuideType[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public TopGuideType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
