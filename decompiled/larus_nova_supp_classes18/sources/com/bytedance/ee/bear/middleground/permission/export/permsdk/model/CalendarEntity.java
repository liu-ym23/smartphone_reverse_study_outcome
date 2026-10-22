package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/CalendarEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "scopedFileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "scopedEntityOperate", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;)V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarEntity extends BaseEntity {
    public CalendarEntity(String r1, e r2, BizDomain r3, String r4, FileBizDomain r5, String r6) {
        super(r1, r2, r3, r4);
    }

    public /* synthetic */ CalendarEntity(String r10, e r11, BizDomain r12, String r13, FileBizDomain r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 16) == 0) goto L5;
        FileBizDomain r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        String r8 = null;
    L10:
        this(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }
}
