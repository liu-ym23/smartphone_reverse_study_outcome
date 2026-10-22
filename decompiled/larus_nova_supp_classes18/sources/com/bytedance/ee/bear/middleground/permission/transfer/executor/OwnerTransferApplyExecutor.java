package com.bytedance.ee.bear.middleground.permission.transfer.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OwnerTransferApplyExecutor {
    public final NetService a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor$PresenterFolderResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isPresenter", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor;Z)V", "()Z", "setPresenter", "(Z)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PresenterFolderResult extends Result<Serializable> {
        private boolean isPresenter;
        final /* synthetic */ OwnerTransferApplyExecutor this$0;

        public final boolean isPresenter() {
            return this.isPresenter;
        }

        public final void setPresenter(boolean r1) {
            this.isPresenter = r1;
        }

        public PresenterFolderResult(OwnerTransferApplyExecutor r1, boolean r2) {
            this.this$0 = r1;
            this.isPresenter = r2;
        }

        public /* synthetic */ PresenterFolderResult(OwnerTransferApplyExecutor r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }
    }

    public static final class a {
    }

    public final class b implements NetService.c<PresenterFolderResult> {
        public final String a;
        public final /* synthetic */ OwnerTransferApplyExecutor b;

        public final Result parse(String r6) {
            boolean r2 = false;
            Boolean r4 = null;
            PresenterFolderResult r0 = new PresenterFolderResult(this.b, r2, 1, r4);
            if (r6 != null) goto L23;
        L22:
            return r0;
        L23:
            JSONObject r7 = new JSONObject(r6).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L20
            if (r7 == null) goto L7;
            JSONObject r8 = r7.optJSONObject("entities");     // Catch: Exception -> L20
        L8:
            if (r8 == null) goto L10;
            JSONObject r9 = r8.optJSONObject("nodes");     // Catch: Exception -> L20
        L11:
            if (r9 == null) goto L13;
            JSONObject r10 = r9.optJSONObject(this.a);     // Catch: Exception -> L20
        L14:
            if (r10 == null) goto L16;
            r4 = Boolean.valueOf(r10.optBoolean("transfer_auto_move"));     // Catch: Exception -> L20
        L16:
            if (r4 == null) goto L18;
            r2 = r4.booleanValue();     // Catch: Exception -> L20
        L18:
            r0.setPresenter(r2);     // Catch: Exception -> L20
            goto L22
        L13:
            r10 = null;
            goto L14
        L10:
            r9 = null;
            goto L11
        L7:
            r8 = null;
        L20:
            e = move-exception;
            tt5.a.d("OwnerTransferApplyExecutor", "parse error " + e);
            goto L22
        }

        public b(OwnerTransferApplyExecutor r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
            this.b = r2;
            this.a = r3;
        }
    }

    static {
    }

    public OwnerTransferApplyExecutor(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
    }
}
