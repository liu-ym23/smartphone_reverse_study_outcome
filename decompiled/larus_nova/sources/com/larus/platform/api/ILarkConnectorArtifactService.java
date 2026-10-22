package com.larus.platform.api;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/api/ILarkConnectorArtifactService;", "", "isLarkConnectorArtifact", "", "message", "Lcom/larus/im/bean/message/Message;", "tryOpenUrl", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "tryOpen", "artifactBlock", "Lcom/larus/im/bean/message/block/ArtifactBlock;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkConnectorArtifactService {
    boolean a(Context r100, Message r101, ArtifactBlock r102);

    boolean b(Context r100, Message r101, String r102);

    boolean c(Message r100);
}
