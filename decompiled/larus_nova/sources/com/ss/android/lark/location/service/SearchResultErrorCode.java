package com.ss.android.lark.location.service;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/location/service/SearchResultErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "NETWORK_FAILURE", "UNSUPPORTED", "ILLEGAL_PARAMS", FlowDoraWifiScene.OTHER, "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SearchResultErrorCode extends Enum<SearchResultErrorCode> {
    public static final SearchResultErrorCode ILLEGAL_PARAMS = null;
    public static final SearchResultErrorCode NETWORK_FAILURE = null;
    public static final SearchResultErrorCode OK = null;
    public static final SearchResultErrorCode OTHER = null;
    public static final SearchResultErrorCode UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchResultErrorCode[] f431200a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431201b = null;

    public static EnumEntries<SearchResultErrorCode> getEntries() {
        return f431201b;
    }

    static {
        SearchResultErrorCode r100 = new SearchResultErrorCode("OK", 0);
        OK = r100;
        SearchResultErrorCode r101 = new SearchResultErrorCode("NETWORK_FAILURE", 1);
        NETWORK_FAILURE = r101;
        SearchResultErrorCode r102 = new SearchResultErrorCode("UNSUPPORTED", 2);
        UNSUPPORTED = r102;
        SearchResultErrorCode r103 = new SearchResultErrorCode("ILLEGAL_PARAMS", 3);
        ILLEGAL_PARAMS = r103;
        SearchResultErrorCode r104 = new SearchResultErrorCode(FlowDoraWifiScene.OTHER, 4);
        OTHER = r104;
        SearchResultErrorCode[] r105 = {r100, r101, r102, r103, r104};
        f431200a = r105;
        f431201b = EnumEntriesKt.enumEntries(r105);
    }

    public static SearchResultErrorCode[] values() {
        return (SearchResultErrorCode[]) f431200a.clone();
    }

    public static SearchResultErrorCode valueOf(String r100) {
        return (SearchResultErrorCode) r27.a.a(SearchResultErrorCode.class, r100);
    }

    public SearchResultErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
