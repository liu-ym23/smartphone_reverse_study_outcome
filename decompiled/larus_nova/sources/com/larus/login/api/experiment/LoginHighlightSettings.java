package com.larus.login.api.experiment;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.LocalClientResultGetter;
import com.bytedance.news.common.settings.api.annotation.LocalClientVidSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Settings(storageKey = "login_local_settings")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'¨\u0006\b"}, d2 = {"Lcom/larus/login/api/experiment/LoginHighlightSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ILocalSettings;", "isVid1", "", "isVid2", "isVid3", "isVid4", "getResult", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LoginHighlightSettings extends ILocalSettings {
    @LocalClientResultGetter
    int getResult();

    @LocalClientVidSettings(percent = 0.03d, resultInt = 0, vid = "13971250")
    int isVid1();

    @LocalClientVidSettings(percent = 0.03d, resultInt = 1, vid = "13971251")
    int isVid2();

    @LocalClientVidSettings(percent = 0.03d, resultInt = 2, vid = "13971252")
    int isVid3();

    @LocalClientVidSettings(percent = 0.91d, resultInt = 3, vid = "13971253")
    int isVid4();
}
