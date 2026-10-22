package com.ss.android.ugc.aweme.live;

import com.bytedance.android.live.base.IService;
import com.ss.android.ugc.aweme.debug.tag.base.LocalTestTag;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/live/ILiveUtils4Plugin;", "Lcom/bytedance/android/live/base/IService;", "getLiveTag", "Ljava/lang/Class;", "Lcom/ss/android/ugc/aweme/debug/tag/base/LocalTestTag;", "isSaas", "", "live-spi-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveUtils4Plugin extends IService {
    Class<? extends LocalTestTag> getLiveTag();

    boolean isSaas();
}
