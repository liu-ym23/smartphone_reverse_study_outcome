package m6b;

import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadResponse;
import com.bytedance.lark.pb.im.v1.EditMessageRequest;
import com.bytedance.lark.pb.im.v1.EditMessageResponse;
import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes35.dex */
public interface h {
    @SdkCall(4158)
    RucketJob<CancelAsyncUploadResponse> cancelAsyncUpload(CancelAsyncUploadRequest r100);

    @SdkCall(4520)
    RucketJob<EditMessageResponse> editMessage(EditMessageRequest r100);

    @SdkPush(4157)
    RucketJob<PushUploadResourceStatus> pushUploadResourceStatus();

    @SdkCall(4159)
    RucketJob<UploadResourceResponse> uploadResource(UploadResourceRequest r100);
}
