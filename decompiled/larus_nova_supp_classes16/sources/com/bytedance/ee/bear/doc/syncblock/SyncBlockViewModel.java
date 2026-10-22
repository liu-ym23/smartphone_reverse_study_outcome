package com.bytedance.ee.bear.doc.syncblock;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockViewModel;", "Landroidx/lifecycle/ViewModel;", "syncBlockResolver", "Lcom/bytedance/ee/bear/document/syncblock/SyncBlockResolver;", "<init>", "(Lcom/bytedance/ee/bear/document/syncblock/SyncBlockResolver;)V", "fetch", "Lio/reactivex/Flowable;", "", "localAccountService", "Lcom/bytedance/ee/bear/contract/LocalAccountService;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncBlockViewModel extends ViewModel {
    public static final String API = "/space/api/suite/permission/synced_block/check_apply_permission/";
    public static final a Companion = null;
    public static final String TAG = "SyncBlockViewModel";
    private final y35.a syncBlockResolver;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SyncBlockViewModel() {
        y35.a r0 = null;
        this(r0, 1, r0);
    }

    public SyncBlockViewModel(y35.a r2) {
        Intrinsics.checkNotNullParameter(r2, "syncBlockResolver");
        this.syncBlockResolver = r2;
    }

    public /* synthetic */ SyncBlockViewModel(y35.a r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new y35.a();
    L5:
        this(r1);
    }

    public final Flowable<String> fetch(h0 r2, NetService r3, BearUrl r4) {
        Intrinsics.checkNotNullParameter(r2, "localAccountService");
        Intrinsics.checkNotNullParameter(r3, "netService");
        Intrinsics.checkNotNullParameter(r4, "bearUrl");
        return this.syncBlockResolver.a(r2, r3, r4);
    }
}
