package com.bytedance.ies.ugc.aweme.network;

import com.bytedance.bdinstall.Level;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JX\u0010\r\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J<\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¨\u0006\u000f"}, d2 = {"com/bytedance/ies/ugc/aweme/network/NetworkCommonParams$INetworkCommonParams", "", "", "", SocialConstants.PARAM_RECEIVER, "path", "domain", "", "isApi", "Lcom/bytedance/bdinstall/Level;", "level", "extraInfo", "", "loadTo", "url", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public interface NetworkCommonParams$INetworkCommonParams {
    String loadTo(String r100, boolean r101, Level r102, Map<String, String> r103);

    void loadTo(Map<String, String> r100, String r101, String r102, boolean r103, Level r104, Map<String, String> r105);
}
