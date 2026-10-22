package com.bytedance.locallife.ability.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/ability/model/AbilityEnum;", "", "", "values", "Ljava/lang/String;", "getValues", "()Ljava/lang/String;", "COLLECT_SERVICE", "SHARE_SERVICE", "SEARCH_SERVICE", "TEMPO_SERVICE", "UPLOAD_SERVICE", "MAP_SERVICE", "NEARBY_SERVICE", "COMMENT_SERVICE", "PREVIEW_FEED_SERVICE", "ALBUM_SERVICE", "VIDEO_PLAY_SERVICE", "OCR_SERVICE", "POI_CHECK_IN_VIDEO_FEED_PAGE_SERVICE", "locallife-ability-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AbilityEnum extends Enum<AbilityEnum> {
    public static final AbilityEnum ALBUM_SERVICE = null;
    public static final AbilityEnum COLLECT_SERVICE = null;
    public static final AbilityEnum COMMENT_SERVICE = null;
    public static final AbilityEnum MAP_SERVICE = null;
    public static final AbilityEnum NEARBY_SERVICE = null;
    public static final AbilityEnum OCR_SERVICE = null;
    public static final AbilityEnum POI_CHECK_IN_VIDEO_FEED_PAGE_SERVICE = null;
    public static final AbilityEnum PREVIEW_FEED_SERVICE = null;
    public static final AbilityEnum SEARCH_SERVICE = null;
    public static final AbilityEnum SHARE_SERVICE = null;
    public static final AbilityEnum TEMPO_SERVICE = null;
    public static final AbilityEnum UPLOAD_SERVICE = null;
    public static final AbilityEnum VIDEO_PLAY_SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AbilityEnum[] f256451a = null;
    private final String values;

    public static AbilityEnum valueOf(String r100) {
        return (AbilityEnum) a.a(AbilityEnum.class, r100);
    }

    public static AbilityEnum[] values() {
        return (AbilityEnum[]) f256451a.clone();
    }

    static {
        AbilityEnum r100 = new AbilityEnum("COLLECT_SERVICE", 0, "life_collect");
        COLLECT_SERVICE = r100;
        AbilityEnum r101 = new AbilityEnum("SHARE_SERVICE", 1, "life_share");
        SHARE_SERVICE = r101;
        AbilityEnum r102 = new AbilityEnum("SEARCH_SERVICE", 2, "life_search");
        SEARCH_SERVICE = r102;
        AbilityEnum r103 = new AbilityEnum("TEMPO_SERVICE", 3, "life_tempo");
        TEMPO_SERVICE = r103;
        AbilityEnum r104 = new AbilityEnum("UPLOAD_SERVICE", 4, "life_upload");
        UPLOAD_SERVICE = r104;
        AbilityEnum r105 = new AbilityEnum("MAP_SERVICE", 5, "life_map");
        MAP_SERVICE = r105;
        AbilityEnum r110 = new AbilityEnum("NEARBY_SERVICE", 6, "life_nearby");
        NEARBY_SERVICE = r110;
        AbilityEnum r111 = new AbilityEnum("COMMENT_SERVICE", 7, "life_comment");
        COMMENT_SERVICE = r111;
        AbilityEnum r112 = new AbilityEnum("PREVIEW_FEED_SERVICE", 8, "life_preview_feed");
        PREVIEW_FEED_SERVICE = r112;
        AbilityEnum r113 = new AbilityEnum("ALBUM_SERVICE", 9, "life_album");
        ALBUM_SERVICE = r113;
        AbilityEnum r114 = new AbilityEnum("VIDEO_PLAY_SERVICE", 10, "life_video_play");
        VIDEO_PLAY_SERVICE = r114;
        AbilityEnum r106 = new AbilityEnum("OCR_SERVICE", 11, "life_ocr");
        OCR_SERVICE = r106;
        AbilityEnum r107 = new AbilityEnum("POI_CHECK_IN_VIDEO_FEED_PAGE_SERVICE", 12, "life_poi_check_in_video_feed_page");
        POI_CHECK_IN_VIDEO_FEED_PAGE_SERVICE = r107;
        f256451a = new AbilityEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final String getValues() {
        return this.values;
    }

    public AbilityEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.values = r102;
    }
}
