package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.applog.util.EventsSenderUtils;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes34.dex */
public final class k implements nx3.e {
    public k() {
    }

    @Override // nx3.e
    public final boolean isEnable() {
        return EventsSenderUtils.isEnable(String.valueOf(jta.g.c()));
    }

    @Override // nx3.e
    public final void setEventVerifyInterval(long r100) {
        EventsSenderUtils.setEventVerifyInterval(String.valueOf(jta.g.c()), r100);
    }

    @Override // nx3.e
    public final void setEventVerifyUrl(String r100) {
        EventsSenderUtils.setEventVerifyHost(String.valueOf(jta.g.c()), r100);
    }

    @Override // nx3.e
    public final void setSpecialKeys(List<String> r100) {
        EventsSenderUtils.setSpecialKeys(String.valueOf(jta.g.c()), r100);
    }

    @Override // nx3.e
    public final void loginEtWithScheme(String r100, Context r101) {
        EventsSenderUtils.loginEtWithScheme(String.valueOf(jta.g.c()), r100, r101);
    }

    @Override // nx3.e
    public final void putEvent(String r100, JSONArray r101) {
        EventsSenderUtils.putEvent(String.valueOf(jta.g.c()), r100, r101);
    }

    @Override // nx3.e
    public final void setEnable(boolean r100, Context r101) {
        EventsSenderUtils.setEventsSenderEnable(String.valueOf(jta.g.c()), r100, r101);
    }
}
