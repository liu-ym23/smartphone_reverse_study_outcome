package com.ss.android.ugc.aweme.search.hostapi;

import android.app.Activity;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J@\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostUserService;", "", "", Keys.API_RETURN_KEY_IS_LOGIN, "", "getCurrentUserId", "Landroid/app/Activity;", "activity", "enterFrom", "enterMethod", "Lkotlin/Function0;", "", "onResultOK", "onResultError", "showLogin", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public interface ITradeSearchHostUserService {
    String getCurrentUserId();

    boolean isLogin();

    void showLogin(Activity r100, String r101, String r102, Function0<Unit> r103, Function0<Unit> r104);
}
