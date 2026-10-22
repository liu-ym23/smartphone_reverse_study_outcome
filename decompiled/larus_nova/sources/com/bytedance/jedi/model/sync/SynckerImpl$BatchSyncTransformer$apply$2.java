package com.bytedance.jedi.model.sync;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.datasource.Optional;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004 \u0005*\u0012\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0018\u00010\u00020\u0002 \u0005*0\u0012*\b\u0001\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004 \u0005*\u0012\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0007\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0003\"\u0004\b\u0006\u0010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/ObservableSource;", "Lkotlin/Pair;", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "kotlin.jvm.PlatformType", "V", "K", "<name for destructuring parameter 0>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SynckerImpl$BatchSyncTransformer$apply$2 extends Lambda implements Function1<Pair<Object, Object>, ObservableSource<? extends Pair<Object, Object>>> {
    final /* synthetic */ SynckerImpl.BatchSyncTransformer<Object, Object, Object> this$0;

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$BatchSyncTransformer$apply$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003 \u0004*\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u0002\"\u0004\b\u0006\u0010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "kotlin.jvm.PlatformType", "V", "K", "cur", "Lcom/bytedance/jedi/model/datasource/Optional;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<Optional<Object>, Pair<Object, Object>> {
        final /* synthetic */ Object $newK;
        final /* synthetic */ Object $newV;
        final /* synthetic */ SynckerImpl.BatchSyncTransformer<Object, Object, Object> this$0;

        public AnonymousClass1(SynckerImpl.BatchSyncTransformer<Object, Object, Object> r100, Object r101, Object r102) {
            this.this$0 = r100;
            this.$newV = r101;
            this.$newK = r102;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Pair<Object, Object> invoke2(Optional<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "cur");
            r100.a();
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Pair<Object, Object> invoke(Optional<Object> r100) {
            return invoke2(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$BatchSyncTransformer$apply$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0002\"\u0004\b\u0005\u0010\u0003\"\u0004\b\u0006\u0010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "K", "it", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<Pair<Object, Object>, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(Pair<Object, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (r100.getSecond() == null) goto L5;
            boolean r101 = true;
        L7:
            return Boolean.valueOf(r101);
        L5:
            r101 = false;
            goto L7
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Pair<Object, Object> r100) {
            return invoke2(r100);
        }
    }

    public SynckerImpl$BatchSyncTransformer$apply$2(SynckerImpl.BatchSyncTransformer<Object, Object, Object> r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ObservableSource<? extends Pair<Object, Object>> invoke2(Pair<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        r100.component1();
        r100.component2();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ObservableSource<? extends Pair<Object, Object>> invoke(Pair<Object, Object> r100) {
        return invoke2(r100);
    }
}
