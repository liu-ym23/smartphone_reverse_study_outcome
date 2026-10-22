package com.bytedance.geckox.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/geckox/model/UpdatePackage;", "", "", "isPatchUpdate", "Lcom/bytedance/geckox/model/UpdatePackage$a;", "fullPackage", "Lcom/bytedance/geckox/model/UpdatePackage$a;", "getFullPackage", "()Lcom/bytedance/geckox/model/UpdatePackage$a;", "Lbz5/a;", "statisticModel", "Lbz5/a;", "getStatisticModel", "()Lbz5/a;", "setStatisticModel", "(Lbz5/a;)V", "", "accessKey", "Ljava/lang/String;", "getAccessKey", "()Ljava/lang/String;", "channel", "getChannel", "", "version", "J", "getVersion", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class UpdatePackage {
    private final String accessKey;
    private final String channel;
    private final a fullPackage;
    private bz5.a statisticModel;
    private final long version;

    public static final class a {
    }

    public final a getFullPackage() {
        return null;
    }

    public final bz5.a getStatisticModel() {
        return null;
    }

    public final boolean isPatchUpdate() {
        return false;
    }

    public final void setStatisticModel(bz5.a r100) {
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final long getVersion() {
        return this.version;
    }

    public UpdatePackage(String r100, String r101, long r102) {
        this.accessKey = r100;
        this.channel = r101;
        this.version = r102;
    }

    public /* synthetic */ UpdatePackage(String r100, String r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
