package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.ExtendParam;
import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatRequest;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f419102a = 0;

    static {
    }

    public static void a(String r100, int r101, DepartmentStructureViewModel$fetchCurrent$resp$1$1$1 r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        ExtendParam.Builder r103 = new ExtendParam.Builder().in_chat_id(null);
        Intrinsics.checkNotNull(r103);
        Boolean r104 = Boolean.TRUE;
        r103.has_lead_perm(r104);
        r103.select_enterprise_email(Boolean.FALSE);
        r103.need_user_profile_fields(r104);
        GetDepartmentCombineChatRequest.Builder r105 = new GetDepartmentCombineChatRequest.Builder().department_id(r100).count(100).offset(Integer.valueOf(r101)).need_path(r104).sub_department_paging(r104).use_display_order(r104).extend_param(r103.build());
        SdkSender.asynSendRequestNonWrap(Command.GET_DEPARTMENT_COMBINE_CHAT, r105, r102, c.f419101a);
    }
}
