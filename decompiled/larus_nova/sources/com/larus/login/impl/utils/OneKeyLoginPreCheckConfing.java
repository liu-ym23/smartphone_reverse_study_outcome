package com.larus.login.impl.utils;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.LocalClientResultGetter;
import com.bytedance.news.common.settings.api.annotation.LocalClientVidSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Settings(storageKey = "one_key_login_pre_check_config")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'J\b\u0010\b\u001a\u00020\u0003H'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'J\b\u0010\u000b\u001a\u00020\u0003H'¨\u0006\f"}, d2 = {"Lcom/larus/login/impl/utils/OneKeyLoginPreCheckConfing;", "Lcom/bytedance/news/common/settings/api/annotation/ILocalSettings;", "isVid0", "", "isVid1", "isVid2", "isNewVid0", "isNewVid1", "isNewVid2", "isNewVid3", "isUnused", "getResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OneKeyLoginPreCheckConfing extends ILocalSettings {
    @LocalClientResultGetter
    int getResult();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 0, vid = "16701858")
    int isNewVid0();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 1, vid = "16701859")
    int isNewVid1();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 2, vid = "16701861")
    int isNewVid2();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 4, vid = "16701860")
    int isNewVid3();

    @LocalClientVidSettings(percent = 0.45d, resultInt = 3, vid = "16367512")
    int isUnused();

    @LocalClientVidSettings(percent = 0.05d, resultInt = 0, vid = "16367509")
    int isVid0();

    @LocalClientVidSettings(percent = 0.05d, resultInt = 1, vid = "16367510")
    int isVid1();

    @LocalClientVidSettings(percent = 0.05d, resultInt = 2, vid = "16367511")
    int isVid2();
}
