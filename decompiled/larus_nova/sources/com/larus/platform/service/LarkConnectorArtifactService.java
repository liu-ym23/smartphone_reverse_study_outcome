package com.larus.platform.service;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.platform.api.ILarkConnectorArtifactService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/service/LarkConnectorArtifactService;", "Lcom/larus/platform/api/ILarkConnectorArtifactService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/api/ILarkConnectorArtifactService;", "service$delegate", "Lkotlin/Lazy;", "isLarkConnectorArtifact", "", "message", "Lcom/larus/im/bean/message/Message;", "tryOpenUrl", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "tryOpen", "artifactBlock", "Lcom/larus/im/bean/message/block/ArtifactBlock;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkConnectorArtifactService implements ILarkConnectorArtifactService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkConnectorArtifactService f365709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365710b = null;

    private LarkConnectorArtifactService() {
    }

    static {
        f365709a = new LarkConnectorArtifactService();
        f365710b = LazyKt.lazy(new f1());
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean c(Message r100) {
        ILarkConnectorArtifactService r101 = (ILarkConnectorArtifactService) f365710b.getValue();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.c(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean a(Context r100, Message r101, ArtifactBlock r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILarkConnectorArtifactService r103 = (ILarkConnectorArtifactService) f365710b.getValue();
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.a(r100, r101, r102) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean b(Context r100, Message r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "url");
        ILarkConnectorArtifactService r103 = (ILarkConnectorArtifactService) f365710b.getValue();
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.b(r100, r101, r102) != true) goto L7;
        return true;
    }
}
