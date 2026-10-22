package com.bytedance.ies.bullet.secure;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig;", "", "", "enableScc", "Ljava/lang/Boolean;", "getEnableScc$anniex_release", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "debug", "getDebug$anniex_release", "setDebug$anniex_release", "", "", "allowList", "Ljava/util/List;", "getAllowList$anniex_release", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "Lcom/bytedance/ies/bullet/secure/SccConfig$a;", "denyList", "getDenyList$anniex_release", "setDenyList$anniex_release", "", "maxReloadCount", "Ljava/lang/Integer;", "getMaxReloadCount$anniex_release", "()Ljava/lang/Integer;", "setMaxReloadCount$anniex_release", "(Ljava/lang/Integer;)V", "maxWaitTime", "getMaxWaitTime$anniex_release", "setMaxWaitTime$anniex_release", "enablePrefetch", "getEnablePrefetch$anniex_release", "setEnablePrefetch$anniex_release", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SccLevel", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SccConfig {

    @SerializedName("scc_cs_allow_list")
    private List<String> allowList;

    @SerializedName("scc_cs_debug")
    private Boolean debug;

    @SerializedName("scc_cs_deny_list")
    private List<a> denyList;

    @SerializedName("scc_cs_enable_prefetch")
    private Boolean enablePrefetch;

    @SerializedName("scc_cs_enable")
    private Boolean enableScc;

    @SerializedName("scc_cs_max_reload_count")
    private Integer maxReloadCount;

    @SerializedName("scc_cs_max_wait_time")
    private Integer maxWaitTime;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "", "SAFE", "NOTICE", "DENY", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SccLevel extends Enum<SccLevel> {
        public static final SccLevel DENY = null;
        public static final SccLevel NOTICE = null;
        public static final SccLevel SAFE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SccLevel[] f247746a = null;

        public static SccLevel valueOf(String r100) {
            return (SccLevel) r27.a.a(SccLevel.class, r100);
        }

        public static SccLevel[] values() {
            return (SccLevel[]) f247746a.clone();
        }

        static {
            SccLevel r100 = new SccLevel("SAFE", 0);
            SAFE = r100;
            SccLevel r101 = new SccLevel("NOTICE", 1);
            NOTICE = r101;
            SccLevel r102 = new SccLevel("DENY", 2);
            DENY = r102;
            f247746a = new SccLevel[]{r100, r101, r102};
        }

        public SccLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SccConfig$a;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "", "urlSet", "Ljava/util/List;", "getUrlSet", "()Ljava/util/List;", "setUrlSet", "(Ljava/util/List;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("reason")
        private String reason;

        @SerializedName("urlSet")
        private List<String> urlSet;

        public a() {
        }
    }

    public final JsonObject e() {
        JsonElement r100 = new Gson().toJsonTree(this);     // Catch: Throwable -> L7
        if ((r100 instanceof JsonObject) == false) goto L12;
        return (JsonObject) r100;
    L12:
        return null;
    L7:
        th = move-exception;
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.i("Bullet_secure", "parse scc config error, e=" + th.getMessage(), null, 12);
        return null;
    }

    public final SccConfig a() {
        SccConfig r100 = new SccConfig();
        r100.enableScc = this.enableScc;
        r100.debug = this.debug;
        ArrayList r101 = new ArrayList();
        List<String> r102 = this.allowList;
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r101.add((String) r103.next());
    L8:
        r100.allowList = r101;
        ArrayList r104 = new ArrayList();
        List<a> r105 = this.denyList;
        if (r105 == null) goto L14;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r104.add((a) r106.next());
    L14:
        r100.denyList = r104;
        r100.maxReloadCount = this.maxReloadCount;
        r100.maxWaitTime = this.maxWaitTime;
        r100.enablePrefetch = this.enablePrefetch;
        return r100;
    }

    public SccConfig() {
        Boolean r100 = Boolean.FALSE;
        this.enableScc = r100;
        this.debug = r100;
        this.maxReloadCount = 5;
        this.maxWaitTime = 1000;
        this.enablePrefetch = r100;
    }

    public final void b(SccConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Boolean r101 = r100.enableScc;
        if (r101 == null) goto L5;
        this.enableScc = Boolean.valueOf(r101.booleanValue());
    L5:
        Boolean r102 = r100.debug;
        if (r102 == null) goto L8;
        this.debug = Boolean.valueOf(r102.booleanValue());
    L8:
        Integer r103 = r100.maxReloadCount;
        if (r103 == null) goto L11;
        this.maxReloadCount = Integer.valueOf(r103.intValue());
    L11:
        Integer r104 = r100.maxWaitTime;
        if (r104 == null) goto L14;
        this.maxWaitTime = Integer.valueOf(r104.intValue());
    L14:
        Boolean r105 = r100.enablePrefetch;
        if (r105 == null) goto L18;
        this.enablePrefetch = Boolean.valueOf(r105.booleanValue());
        return;
    }

    public final void c(List<String> r100) {
        this.allowList = r100;
    }

    public final void d(Boolean r100) {
        this.enableScc = r100;
    }
}
