package com.ss.android.ugc.aweme.search.hostapi;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAddressService;", "", "getAddress", "", "btmNode", "btm", "bizCode", "isLocationEnable", "", "setAddress", "", "address", "Lorg/json/JSONObject;", "sourceType", "", "isSession", "isSyncWrite", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITradeSearchAddressService {
    String getAddress(Object r100, String r101, String r102);

    boolean isLocationEnable();

    void setAddress(JSONObject r100, int r101, boolean r102, boolean r103);
}
