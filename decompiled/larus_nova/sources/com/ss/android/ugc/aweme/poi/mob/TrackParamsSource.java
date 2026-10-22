package com.ss.android.ugc.aweme.poi.mob;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/TrackParamsSource;", "", "schema", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "schemaH5Common", "trackParams", "code", "unknown", "refreshPage", "schemaCommonExtra", "liveRoomInfo", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum TrackParamsSource extends Enum<TrackParamsSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrackParamsSource[] f451354a = null;
    public static final TrackParamsSource code = null;
    public static final TrackParamsSource liveRoomInfo = null;
    public static final TrackParamsSource refreshPage = null;
    public static final TrackParamsSource schema = null;
    public static final TrackParamsSource schemaCommonExtra = null;
    public static final TrackParamsSource schemaH5Common = null;
    public static final TrackParamsSource session = null;
    public static final TrackParamsSource trackParams = null;
    public static final TrackParamsSource unknown = null;

    public static TrackParamsSource valueOf(String r100) {
        return (TrackParamsSource) a.a(TrackParamsSource.class, r100);
    }

    public static TrackParamsSource[] values() {
        return (TrackParamsSource[]) f451354a.clone();
    }

    static {
        TrackParamsSource r100 = new TrackParamsSource("schema", 0);
        schema = r100;
        TrackParamsSource r101 = new TrackParamsSource(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, 1);
        session = r101;
        TrackParamsSource r102 = new TrackParamsSource("schemaH5Common", 2);
        schemaH5Common = r102;
        TrackParamsSource r103 = new TrackParamsSource("trackParams", 3);
        trackParams = r103;
        TrackParamsSource r104 = new TrackParamsSource("code", 4);
        code = r104;
        TrackParamsSource r105 = new TrackParamsSource("unknown", 5);
        unknown = r105;
        TrackParamsSource r110 = new TrackParamsSource("refreshPage", 6);
        refreshPage = r110;
        TrackParamsSource r111 = new TrackParamsSource("schemaCommonExtra", 7);
        schemaCommonExtra = r111;
        TrackParamsSource r112 = new TrackParamsSource("liveRoomInfo", 8);
        liveRoomInfo = r112;
        f451354a = new TrackParamsSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public TrackParamsSource(String r100, int r101) {
        super(r100, r101);
    }
}
