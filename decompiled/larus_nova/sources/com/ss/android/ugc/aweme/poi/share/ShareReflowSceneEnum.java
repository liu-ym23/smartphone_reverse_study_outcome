package com.ss.android.ugc.aweme.poi.share;

import com.bytedance.ai.api.navi.AppletNaviType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/share/ShareReflowSceneEnum;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "VIDEO", "POI", "GOODS_DETAIL", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ShareReflowSceneEnum extends Enum<ShareReflowSceneEnum> {
    public static final ShareReflowSceneEnum GOODS_DETAIL = null;
    public static final ShareReflowSceneEnum POI = null;
    public static final ShareReflowSceneEnum VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareReflowSceneEnum[] f451360a = null;
    private final String value;

    public static ShareReflowSceneEnum valueOf(String r100) {
        return (ShareReflowSceneEnum) a.a(ShareReflowSceneEnum.class, r100);
    }

    public static ShareReflowSceneEnum[] values() {
        return (ShareReflowSceneEnum[]) f451360a.clone();
    }

    static {
        ShareReflowSceneEnum r100 = new ShareReflowSceneEnum("VIDEO", 0, "video");
        VIDEO = r100;
        ShareReflowSceneEnum r101 = new ShareReflowSceneEnum("POI", 1, AppletNaviType.POI);
        POI = r101;
        ShareReflowSceneEnum r102 = new ShareReflowSceneEnum("GOODS_DETAIL", 2, "goodsdetail");
        GOODS_DETAIL = r102;
        f451360a = new ShareReflowSceneEnum[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public ShareReflowSceneEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
