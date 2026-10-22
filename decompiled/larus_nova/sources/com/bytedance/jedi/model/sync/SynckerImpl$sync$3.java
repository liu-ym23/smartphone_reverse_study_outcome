package com.bytedance.jedi.model.sync;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.jedi.model.traceable.Traceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001az\u00126\b\u0001\u00122\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0003 \u0006*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0003\u0018\u00010\u00020\u0002 \u0006*<\u00126\b\u0001\u00122\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0003 \u0006*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u00030\u0002H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lio/reactivex/ObservableSource;", "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Lkotlin/Pair;", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "kotlin.jvm.PlatformType", "K", "V", "traceable", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SynckerImpl$sync$3 extends Lambda implements Function1<ITraceable<Pair<Object, Object>>, ObservableSource<? extends ITraceable<Pair<Object, Object>>>> {
    final /* synthetic */ SynckerImpl<Object, Object, Object, Object> this$0;

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$sync$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "it", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<Pair<Object, Object>, Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
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

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$sync$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "V", "K", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "it", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<Pair<Object, Object>, Object> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Object, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return r100.getSecond();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Pair<Object, Object> r100) {
            return invoke2(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$sync$3$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001a2\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002 \u0005*\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0002H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Lkotlin/Pair;", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "kotlin.jvm.PlatformType", "K", "V", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass3 extends Lambda implements Function1<Pair<Object, Object>, ITraceable<Pair<Object, Object>>> {
        final /* synthetic */ ITraceable<Pair<Object, Object>> $traceable;

        public AnonymousClass3(ITraceable<Pair<Object, Object>> r100) {
            this.$traceable = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ITraceable<Pair<Object, Object>> invoke2(Pair<Object, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Traceable.Companion r101 = Traceable.f251191c;
            ITraceable<Pair<Object, Object>> r102 = this.$traceable;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "parent");
            return r102.c(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ITraceable<Pair<Object, Object>> invoke(Pair<Object, Object> r100) {
            return invoke2(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.jedi.model.sync.SynckerImpl$sync$3$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "t", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass4 extends Lambda implements Function1<Throwable, Unit> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r100) {
            if (r100 == null) goto L5;
            r100.printStackTrace();
            return;
        }
    }

    public SynckerImpl$sync$3(SynckerImpl<Object, Object, Object, Object> r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ObservableSource<? extends ITraceable<Pair<Object, Object>>> invoke2(ITraceable<Pair<Object, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        int r101 = SynckerImpl.f251190a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ObservableSource<? extends ITraceable<Pair<Object, Object>>> invoke(ITraceable<Pair<Object, Object>> r100) {
        return invoke2(r100);
    }
}
