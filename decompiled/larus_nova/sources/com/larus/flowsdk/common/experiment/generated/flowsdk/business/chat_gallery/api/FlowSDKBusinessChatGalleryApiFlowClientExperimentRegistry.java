package com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat_gallery.api;

import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/chat_gallery/api/FlowSDKBusinessChatGalleryApiFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "registerProperty1", "registerProperty2", "registerProperty3", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessChatGalleryApiFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessChatGalleryApiFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        AtomicReference<a.C5998a> r100 = a.f480591a;
        a.h("enabled_quick_input_entries", "yanshutong", new JSONArray("[]"));
        a.h("enabled_preview_scenes", "yanshutong", new JSONArray("[]"));
        a.i("quick_input_attachment_add_enable", "yanshutong", false);
        a.i("quick_input_data_protocol_enable", "yanshutong", false);
    }
}
