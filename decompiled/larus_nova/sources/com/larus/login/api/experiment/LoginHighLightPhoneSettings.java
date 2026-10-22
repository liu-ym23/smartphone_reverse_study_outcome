package com.larus.login.api.experiment;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.LocalClientResultGetter;
import com.bytedance.news.common.settings.api.annotation.LocalClientVidSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Settings(storageKey = "login_highlight_phone_settings")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'J\b\u0010\b\u001a\u00020\u0003H'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/larus/login/api/experiment/LoginHighLightPhoneSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ILocalSettings;", "isVid1", "", "isPhoneFirst", "isPhoneFirstMinifyDouyin", "isPhoneFirstWithoutDouyin", "isNewVid1", "isNewPhoneFirstWithoutDouyin", "isUnused", "getResult", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LoginHighLightPhoneSettings extends ILocalSettings {
    @LocalClientResultGetter
    int getResult();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 3, vid = "16525211")
    int isNewPhoneFirstWithoutDouyin();

    @LocalClientVidSettings(percent = 0.1d, resultInt = 0, vid = "16525210")
    int isNewVid1();

    @LocalClientVidSettings(percent = 0.02d, resultInt = 1, vid = "16285928")
    int isPhoneFirst();

    @LocalClientVidSettings(percent = 0.02d, resultInt = 3, vid = "16285929")
    int isPhoneFirstMinifyDouyin();

    @LocalClientVidSettings(percent = 0.02d, resultInt = 3, vid = "16285930")
    int isPhoneFirstWithoutDouyin();

    @LocalClientVidSettings(percent = 0.72d, resultInt = 4, vid = "16285931")
    int isUnused();

    @LocalClientVidSettings(percent = 0.02d, resultInt = 0, vid = "16285927")
    int isVid1();
}
