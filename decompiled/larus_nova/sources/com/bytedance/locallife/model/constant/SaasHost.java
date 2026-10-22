package com.bytedance.locallife.model.constant;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/model/constant/SaasHost;", "", "", "hostName", "Ljava/lang/String;", "getHostName", "()Ljava/lang/String;", "AWEME", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum SaasHost extends Enum<SaasHost> {
    public static final SaasHost AWEME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SaasHost[] f260850a = null;
    private final String hostName;

    public static SaasHost valueOf(String r100) {
        return (SaasHost) a.a(SaasHost.class, r100);
    }

    public static SaasHost[] values() {
        return (SaasHost[]) f260850a.clone();
    }

    static {
        SaasHost r100 = new SaasHost();
        AWEME = r100;
        f260850a = new SaasHost[]{r100};
    }

    public SaasHost() {
        super("AWEME", 0);
        this.hostName = ShareChannel.DOUYIN;
    }

    public final String getHostName() {
        return this.hostName;
    }
}
