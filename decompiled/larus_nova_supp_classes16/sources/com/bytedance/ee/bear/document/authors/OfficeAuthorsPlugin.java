package com.bytedance.ee.bear.document.authors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/authors/OfficeAuthorsPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "authorsLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/ee/bear/document/authors/Author;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getAuthorsLiveData", "Landroidx/lifecycle/LiveData;", "Companion", "SetAuthorsHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeAuthorsPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final String TAG = "OfficeAuthorsPlugin";
    private final MutableLiveData<List<Author>> authorsLiveData;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<AuthorsBean> {
        public final /* synthetic */ OfficeAuthorsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeAuthorsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r12, m r13) {
            AuthorsBean r14 = (AuthorsBean) r12;
            if (r14 != null) goto L5;
            OfficeAuthorsPlugin.access$getAuthorsLiveData$p(this.a).postValue(CollectionsKt.emptyList());
            tt5.a.d(OfficeAuthorsPlugin.TAG, "set authors, data is null!");
            return;
        L5:
            tt5.a.h(OfficeAuthorsPlugin.TAG, "set authors, ids = " + CollectionsKt.joinToString$default(r14.getAuthors(), null, null, null, 0, null, OfficeAuthorsPlugin$SetAuthorsHandler$handle$1.INSTANCE, 31, null));
            OfficeAuthorsPlugin.access$getAuthorsLiveData$p(this.a).postValue(r14.getAuthors());
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeAuthorsPlugin() {
        this.authorsLiveData = new MutableLiveData(CollectionsKt.emptyList());
    }

    public final LiveData<List<Author>> getAuthorsLiveData() {
        return this.authorsLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getAuthorsLiveData$p(OfficeAuthorsPlugin r0) {
        return r0.authorsLiveData;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.common.setAuthors", new b(this));
    }
}
