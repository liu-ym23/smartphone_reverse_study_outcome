package com.ss.android.lark.chameleon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonContainerConst;", "", "<init>", "()V", "LOG_TAG_PRE", "", "SESSION_KEY", "URL_CONFIG_KEY", "CHAMELEON_EXTRA_URL", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonContainerConst {
    public static final String CHAMELEON_EXTRA_URL = "chameleon_url";
    public static final ChameleonContainerConst INSTANCE = null;
    public static final String LOG_TAG_PRE = "CML_TAG_";
    public static final String SESSION_KEY = "session_id";
    public static final String URL_CONFIG_KEY = "__cml_interceptor_config__";

    static {
        INSTANCE = new ChameleonContainerConst();
    }

    private ChameleonContainerConst() {
    }
}
