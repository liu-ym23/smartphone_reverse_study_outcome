package qpc;

import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public interface e {
    void addPushPushResourceListener(c r100);

    void addPushResourceDownloadProgressListener(b r100);

    void addPushResourceUploadProgressListener(d r100);

    byte[] decryptResource(String r100);

    void downloadResource(String r100, String r101, String r102);

    a getImageService();

    String getResUrlByResKey(String r100, String r101, int r102, int r103);

    Map<String, Resource> getResources(List<ResourceRequestBaseSet> r100);

    void getResources(List<ResourceRequestBaseSet> r100, int r101, IGetDataCallback<Map<String, Resource>> r102);

    void removePushResourceDownloadProgressListener(b r100);

    void removePushResourceUploadProgressListener(d r100);

    Map<String, Resource> synGetResources(List<ResourceRequestBaseSet> r100);

    void triggerDataClean(Integer r100, Integer r101, TriggerDataCleanRequest.CleanType r102, IGetDataCallback<TriggerDataCleanResponse> r103);
}
