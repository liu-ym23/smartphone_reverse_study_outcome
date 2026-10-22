package com.ss.android.lark.security.compliance.api.subapimock;

import com.bytedance.i18n.claymore.ClaymoreNoop;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.a;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p4c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/subapimock/SecurityComplianceInternalApiMock;", "Lcom/ss/android/lark/security/compliance/api/subapi/ISecurityComplianceInternalApi;", "<init>", "()V", "monitorEventV2", "", "serviceName", "", "category", "", "", "metric", "logExtra", "status", "", "monitorEvent", "Lorg/json/JSONObject;", "extraLog", "getScsGlobalKVRepo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "repoName", "needMigration", "", "getScsUserKVRepo", "getLscSettingAuditValue", "", "getFileWatermarkSceneType", "getFileWatermarkPointKey", "fragmentBinderOpt", "enableDoubaoWatermark", "enableDoubaoDialogWatermarkGlobalOnly", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ClaymoreNoop(d.class)
public final class SecurityComplianceInternalApiMock implements d {
    public SecurityComplianceInternalApiMock() {
    }

    @Override // p4c.d
    public boolean enableDoubaoDialogWatermarkGlobalOnly() {
        return true;
    }

    @Override // p4c.d
    public boolean enableDoubaoWatermark() {
        return true;
    }

    @Override // p4c.d
    public boolean fragmentBinderOpt() {
        return true;
    }

    @Override // p4c.d
    public String getFileWatermarkPointKey() {
        return "";
    }

    @Override // p4c.d
    public String getFileWatermarkSceneType() {
        return "";
    }

    @Override // p4c.d
    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
    }

    @Override // p4c.d
    public void monitorEventV2(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
    }

    public KVRepo getScsGlobalKVRepo() {
        return LarkKVStorage.g(new a("security_compliance"), "common", false);
    }

    @Override // p4c.d
    public List<Integer> getLscSettingAuditValue() {
        return CollectionsKt.emptyList();
    }

    @Override // p4c.d
    public KVRepo getScsUserKVRepo(boolean r100) {
        return LarkKVStorage.p(new a("security_compliance"), "common", r100);
    }

    public KVRepo getScsGlobalKVRepo(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        return LarkKVStorage.g(new a("security_compliance"), r100, r101);
    }
}
