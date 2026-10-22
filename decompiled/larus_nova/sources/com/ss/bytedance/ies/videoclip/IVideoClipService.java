package com.ss.bytedance.ies.videoclip;

import com.ss.android.ugc.aweme.framework.services.dyext.annotation.DouyinImpl;
import com.ss.bytedance.ies.videoclip.api.timeline.ITimeLine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/bytedance/ies/videoclip/IVideoClipService;", "", "newTimeLine", "Lcom/ss/bytedance/ies/videoclip/api/timeline/ITimeLine;", "videoclip-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
@DouyinImpl(plugin = "com.ss.android.ugc.aweme.iesvideoclip")
public interface IVideoClipService {
    ITimeLine newTimeLine();
}
