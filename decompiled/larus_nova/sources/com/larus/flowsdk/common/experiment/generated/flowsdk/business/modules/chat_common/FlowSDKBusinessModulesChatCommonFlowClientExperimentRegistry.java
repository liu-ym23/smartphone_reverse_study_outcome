package com.larus.flowsdk.common.experiment.generated.flowsdk.business.modules.chat_common;

import ac8.h;
import ac8.i;
import com.larus.bmhome.chat.stop.c;
import com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry;
import com.xiaomi.mipush.sdk.MiPushClient;
import ga9.a;
import ga9.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u000e"}, d2 = {"Lcom/larus/flowsdk/common/experiment/generated/flowsdk/business/modules/chat_common/FlowSDKBusinessModulesChatCommonFlowClientExperimentRegistry;", "Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "registerAll", "registerProperty0", "registerProperty1", "registerProperty2", "registerProperty3", "registerConfig0", "registerConfig1", "registerConfig2", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSDKBusinessModulesChatCommonFlowClientExperimentRegistry implements IFlowClientExperimentRegistry {
    public FlowSDKBusinessModulesChatCommonFlowClientExperimentRegistry() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void priority() {
    }

    @Override // com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry
    public final void register() {
        a.l("delete_msg_tip_display", "zhangtienan", "0", true);
        a.i("message_reply_long_message_collapse_enabled", "mengwenlong", false);
        a.i("message_send_long_message_collapse_enabled", "mengwenlong", false);
        a.k("insert_visible_message_timestamp_interval", "zhangtienan", 900, false);
        e r100 = e.f480599a;
        h r101 = new h(0);
        r100.getClass();
        a.j("mobile_action_bar_keyboard_visibility_by_mode", "hekai", e.c(r101), true);
        a.j("mobile_action_bar_plus_panel_visibility_by_mode", "hekai", e.c(new i(0)), true);
        a.j("mobile_input_stop_scene_config_v2", "hekai.echo", e.c(new c(null)), true);
    }
}
