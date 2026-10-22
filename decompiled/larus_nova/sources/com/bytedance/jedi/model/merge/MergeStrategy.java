package com.bytedance.jedi.model.merge;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/jedi/model/merge/MergeStrategy;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "", "<init>", "()V", "BatchMerge", "Companion", "KeyMerge", "PredicatedMerge", "Lcom/bytedance/jedi/model/merge/MergeStrategy$BatchMerge;", "Lcom/bytedance/jedi/model/merge/MergeStrategy$KeyMerge;", "Lcom/bytedance/jedi/model/merge/MergeStrategy$PredicatedMerge;", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class MergeStrategy<K, V, K1, V1> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u0003*\u0004\b\u0007\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/merge/MergeStrategy$BatchMerge;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy;", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class BatchMerge<K, V, K1, V1> extends MergeStrategy<K, V, K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super V, ? extends List<? extends Pair<? extends K1, ? extends V1>>> f251182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<? super V1, ? super V1, ? extends V1> f251183b;

        public BatchMerge() {
            AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
            AnonymousClass2 r101 = AnonymousClass2.INSTANCE;
            Intrinsics.checkNotNullParameter(r100, OPTrace.BATCH_DATA_KEY);
            Intrinsics.checkNotNullParameter(r101, "merge");
            super(0);
            this.f251182a = r100;
            this.f251183b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/merge/MergeStrategy$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u0003*\u0004\b\u0007\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/merge/MergeStrategy$KeyMerge;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy;", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class KeyMerge<K, V, K1, V1> extends MergeStrategy<K, V, K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super K, ? super V, ? extends K1> f251184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function3<? super K, ? super V, ? super V1, ? extends V1> f251185b;

        public KeyMerge() {
            AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
            AnonymousClass2 r101 = AnonymousClass2.INSTANCE;
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "merge");
            super(0);
            this.f251184a = r100;
            this.f251185b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u0003*\u0004\b\u0007\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/merge/MergeStrategy$PredicatedMerge;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/merge/MergeStrategy;", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class PredicatedMerge<K, V, K1, V1> extends MergeStrategy<K, V, K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super V, ? super V1, Boolean> f251186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function2<? super V, ? super V1, ? extends V1> f251187b;

        public PredicatedMerge() {
            AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
            AnonymousClass2 r101 = AnonymousClass2.INSTANCE;
            Intrinsics.checkNotNullParameter(r100, "predicate");
            Intrinsics.checkNotNullParameter(r101, "merge");
            super(0);
            this.f251186a = r100;
            this.f251187b = r101;
        }
    }

    static {
        new Companion(0);
    }

    private MergeStrategy() {
    }

    public /* synthetic */ MergeStrategy(int r100) {
        this();
    }
}
