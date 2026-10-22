package g9b;

import com.bytedance.lark.pb.basic.v1.ChatApplication;
import com.bytedance.lark.pb.basic.v1.ContactSummary;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements y.a<ChatApplication, com.ss.android.lark.contact.base.dto.ChatApplication> {
    public a() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final com.ss.android.lark.contact.base.dto.ChatApplication get(ChatApplication r100) {
        ChatApplication r101 = r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.contact.base.dto.ChatApplication r102 = new com.ss.android.lark.contact.base.dto.ChatApplication();
        r102.setId(r101.f253447id);
        r102.setApplyTime(r101.apply_time.longValue());
        r102.setChatId(r101.chat_id);
        ContactSummary r103 = r101.contact_summary;
        if (r103 == null) goto L8;
        ExternalContactSummary r104 = new ExternalContactSummary();
        r104.setAvatarKey(r103.avatar_key);
        r104.setDepartmentName(r103.department_name);
        r104.setTenantName(r103.tenant_name);
        r104.setUseId(r103.user_id);
        r104.setTenantNameStatus(r103.tenant_name_status);
        r104.setUserEnName(r103.user_en_name);
        r104.setUserName(r103.user_name);
        r104.setI18nName(r103.user_name_i18n);
        r102.setExternalContactSummary(r104);
        r102.setCertificationInfo(r101.contact_summary.certification_info);
    L8:
        r102.setExtraMessage(r101.extra_message);
        r102.setProcessedTime(r101.processed_time.longValue());
        r102.setRead(r101.is_read.booleanValue());
        r102.setStatus(com.ss.android.lark.contact.base.dto.ChatApplication.Status.forNumber(r101.status.getValue()));
        r102.setType(com.ss.android.lark.contact.base.dto.ChatApplication.Type.forNumber(r101.type.getValue()));
        return r102;
    }
}
