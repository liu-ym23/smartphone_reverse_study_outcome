package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/CalendarEntity;", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", "token", "", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "domain", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "creatorTenantId", "scopedFileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "scopedEntityOperate", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;Ljava/lang/String;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;Ljava/lang/String;)V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarEntity extends BaseEntity {
    public CalendarEntity(String r100, e r101, BizDomain r102, String r103, FileBizDomain r104, String r105) {
        super(r100, r101, r102, r103);
    }

    public /* synthetic */ CalendarEntity(String r110, e r111, BizDomain r112, String r113, FileBizDomain r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 16) == 0) goto L5;
        FileBizDomain r100 = null;
    L7:
        if ((r116 & 32) == 0) goto L9;
        String r101 = null;
    L10:
        this(r110, r111, r112, r113, r100, r101);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
