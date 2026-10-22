package m6b;

import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    @SdkPush(4157)
    RucketJob<PushUploadResourceStatus> pushUploadResourceStatus();
}
