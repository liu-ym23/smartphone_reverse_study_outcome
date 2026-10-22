package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/q;", "", "", "enableWebForcePrivate", "Z", "c", "()Z", "setEnableWebForcePrivate", "(Z)V", "", "", "webPublicMethods", "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", "setWebPublicMethods", "([Ljava/lang/String;)V", "enableLynxForcePrivate", "b", "setEnableLynxForcePrivate", "lynxPublicMethods", "d", "setLynxPublicMethods", "", "", "commonSecureMethods", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setCommonSecureMethods", "(Ljava/util/Map;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("common_secure_method")
    private Map<String, Integer> commonSecureMethods;

    @SerializedName("enable_lynx_force_private")
    private boolean enableLynxForcePrivate;

    @SerializedName("enable_web_force_private")
    private boolean enableWebForcePrivate;

    @SerializedName("lynx_public_method")
    private String[] lynxPublicMethods;

    @SerializedName("web_public_method")
    private String[] webPublicMethods;

    public q() {
        this.webPublicMethods = new String[0];
        this.enableLynxForcePrivate = true;
        this.lynxPublicMethods = new String[0];
        this.commonSecureMethods = MapsKt.emptyMap();
    }

    public final Map<String, Integer> a() {
        return this.commonSecureMethods;
    }

    public final boolean b() {
        return this.enableLynxForcePrivate;
    }

    public final boolean c() {
        return this.enableWebForcePrivate;
    }

    public final String[] d() {
        return this.lynxPublicMethods;
    }

    public final String[] e() {
        return this.webPublicMethods;
    }
}
