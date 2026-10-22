package com.larus.flowsdk.common.experiment.generated.flowsdk.business.office.api;

import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.larus.office.experiment.b;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import ga9.e;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/office/api/FlowSDKBusinessOfficeApiFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "registerProperty1", "registerProperty2", "registerProperty3", "registerConfig0", "registerConfig1", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessOfficeApiFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessOfficeApiFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        a.i("url_preivew_layout_optimization", "zhuxiaolong", true);
        a.i("office_ai_float_chat_enable", "zhuxiaolong", false);
        a.h("office_conversation_task_mode_list", "yangyurun.000", new JSONArray("[\"docx\",\"sheet\",\"slides\",\"bitable\",\"wiki\",\"file\"]"));
        a.i("office_doc_conversation_task_mode_enable", "yangyurun.000", false);
        e r100 = e.f480599a;
        com.larus.office.experiment.a r101 = new com.larus.office.experiment.a(0);
        r100.getClass();
        a.j("html_cloud_card_preview", "zhuxiaolong", e.c(r101), true);
        a.j("md_cloud_card_preview", "zhuxiaolong", e.c(new b(0)), true);
    }
}
