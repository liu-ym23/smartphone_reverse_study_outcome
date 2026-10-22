package com.bytedance.ee.bear.middleground.permission.transfer.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class OwnerTransferApplyExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f234295a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor$PresenterFolderResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isPresenter", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor;Z)V", "()Z", "setPresenter", "(Z)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PresenterFolderResult extends Result<Serializable> {
        private boolean isPresenter;
        final /* synthetic */ OwnerTransferApplyExecutor this$0;

        public final boolean isPresenter() {
            return this.isPresenter;
        }

        public final void setPresenter(boolean r100) {
            this.isPresenter = r100;
        }

        public PresenterFolderResult(OwnerTransferApplyExecutor r100, boolean r101) {
            this.this$0 = r100;
            this.isPresenter = r101;
        }

        public /* synthetic */ PresenterFolderResult(OwnerTransferApplyExecutor r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L5;
            r101 = false;
        L5:
            this(r100, r101);
        }
    }

    public static final class a {
    }

    public final class b implements NetService.c<PresenterFolderResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OwnerTransferApplyExecutor f234297b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            boolean r101 = false;
            Boolean r102 = null;
            PresenterFolderResult r103 = new PresenterFolderResult(this.f234297b, r101, 1, 0 == true ? 1 : 0);
            if (r100 != null) goto L23;
        L22:
            return r103;
        L23:
            JSONObject r104 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L20
            if (r104 == null) goto L7;
            JSONObject r105 = r104.optJSONObject("entities");     // Catch: Exception -> L20
        L8:
            if (r105 == null) goto L10;
            JSONObject r106 = r105.optJSONObject("nodes");     // Catch: Exception -> L20
        L11:
            if (r106 == null) goto L13;
            JSONObject r107 = r106.optJSONObject(this.f234296a);     // Catch: Exception -> L20
        L14:
            if (r107 == null) goto L16;
            r102 = Boolean.valueOf(r107.optBoolean("transfer_auto_move"));     // Catch: Exception -> L20
        L16:
            if (r102 == null) goto L18;
            r101 = r102.booleanValue();     // Catch: Exception -> L20
        L18:
            r103.setPresenter(r101);     // Catch: Exception -> L20
            goto L22
        L13:
            r107 = null;
            goto L14
        L10:
            r106 = null;
            goto L11
        L7:
            r105 = null;
        L20:
            e = move-exception;
            tt5.a.d("OwnerTransferApplyExecutor", "parse error " + e);
            goto L22
        }

        public b(OwnerTransferApplyExecutor r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "token");
            this.f234297b = r100;
            this.f234296a = r101;
        }
    }

    static {
    }

    public OwnerTransferApplyExecutor(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f234295a = r100;
    }
}
