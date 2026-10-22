package com.bytedance.jedi.model.sync;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import io.reactivex.ObservableTransformer;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005:\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/jedi/model/sync/SynckerImpl;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "", "BatchSyncTransformer", "Companion", "SyncTransformer", "model_release"}, k = 1, mv = {1, 7, 1})
public final class SynckerImpl<K, V, K1, V1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251190a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u00032\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00060\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/sync/SynckerImpl$BatchSyncTransformer;", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lio/reactivex/ObservableTransformer;", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class BatchSyncTransformer<V, K1, V1> implements ObservableTransformer<V, Pair<? extends K1, ? extends V1>> {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/sync/SynckerImpl$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u0003*\u0004\b\u0007\u0010\u00042*\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00050\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00070\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/model/sync/SynckerImpl$SyncTransformer;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lio/reactivex/ObservableTransformer;", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class SyncTransformer<K, V, K1, V1> implements ObservableTransformer<Pair<? extends K, ? extends V>, Pair<? extends K1, ? extends V1>> {
    }

    static {
        new Companion(0);
    }
}
