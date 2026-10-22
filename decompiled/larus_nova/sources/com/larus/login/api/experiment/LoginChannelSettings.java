package com.larus.login.api.experiment;

import androidx.constraintlayout.motion.utils.HyperSpline;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.LocalClientResultGetter;
import com.bytedance.news.common.settings.api.annotation.LocalClientVidSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Settings(storageKey = "login_channel")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'¨\u0006\u0006"}, d2 = {"Lcom/larus/login/api/experiment/LoginChannelSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ILocalSettings;", "contrastGroup", "", "isVid", "getResult", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LoginChannelSettings extends ILocalSettings {
    @LocalClientVidSettings(percent = HyperSpline.Cubic.HALF, resultBoolean = false, vid = "71843653")
    boolean contrastGroup();

    @LocalClientResultGetter
    boolean getResult();

    @LocalClientVidSettings(percent = HyperSpline.Cubic.HALF, resultBoolean = true, vid = "71843654")
    boolean isVid();
}
