package com.larus.share.host;

import com.obric.assistant.spi.share.IShareChannelExtraConfigurator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J/\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/share/host/MainlandShareChannelExtraConfigurator;", "Lcom/obric/assistant/spi/share/IShareChannelExtraConfigurator;", "<init>", "()V", "isAvailable", "", "configureDouyinExtra", "", "shareExtra", "", "hashTags", "", "", "configureWechatMiniAppExtra", "miniAppId", "miniAppPath", "miniProgramType", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "share-host_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainlandShareChannelExtraConfigurator implements IShareChannelExtraConfigurator {
    public MainlandShareChannelExtraConfigurator() {
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void b(kn7.a r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "shareExtra");
        Intrinsics.checkNotNullParameter(r101, "hashTags");
        on7.a r102 = new on7.a();
        r102.f524372a = new ArrayList(r101);
        r100.f504247a = r102;
    }

    @Override // com.obric.assistant.spi.share.IShareChannelExtraConfigurator
    public final void a(kn7.a r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "shareExtra");
        Intrinsics.checkNotNullParameter("gh_b8a66f6c82a7", "miniAppId");
        Intrinsics.checkNotNullParameter(r101, "miniAppPath");
        vn7.a r103 = new vn7.a();
        r103.f556458a = "gh_b8a66f6c82a7";
        r103.f556459b = r101;
        if (r102 == null) goto L5;
        r103.f556460c = r102.intValue();
    L5:
        r100.f504249c = r103;
    }
}
