package com.larus.common.account.platform.larklogin;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f326229a = null;

    static {
        f326229a = SetsKt.setOf(new String[]{"client_id", "response_type", "scope", "state", EventConstant.Key.RETAIN_PROMPT, "code_challenge", "code_challenge_method", "redirect_uri"});
    }
}
