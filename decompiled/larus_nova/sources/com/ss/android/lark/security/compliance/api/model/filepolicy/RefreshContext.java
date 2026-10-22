package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.LarkContext;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext;", "", "refreshableScene", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshableScene;", "refreshListener", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext$RefreshListener;", "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshableScene;Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext$RefreshListener;)V", "getRefreshableScene", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshableScene;", "getRefreshListener", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext$RefreshListener;", "setRefreshListener", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext$RefreshListener;)V", LocationMonitorConst.IDENTIFIER, "", "getIdentifier", "registerObserver", "", "unregisterObserver", "RefreshListener", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefreshContext {
    private final String identifier;
    private a refreshListener;
    private final i refreshableScene;

    public interface a {
        void a(String r100, @PointKey Set<String> r101);
    }

    public final void registerObserver() {
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).g(new j(this));
    }

    public final void unregisterObserver() {
        ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).g(new n(this));
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final a getRefreshListener() {
        return this.refreshListener;
    }

    public final i getRefreshableScene() {
        return this.refreshableScene;
    }

    public final void setRefreshListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.refreshListener = r100;
    }

    public RefreshContext(i r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshableScene");
        Intrinsics.checkNotNullParameter(r101, "refreshListener");
        this.refreshableScene = r100;
        this.refreshListener = r101;
        this.identifier = String.valueOf(hashCode());
    }
}
