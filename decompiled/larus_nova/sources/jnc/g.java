package jnc;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f499815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f499816b = null;

    static {
        f499815a = new Gson();
        f499816b = Keva.getRepo("comments_keva_repo", 0);
    }
}
