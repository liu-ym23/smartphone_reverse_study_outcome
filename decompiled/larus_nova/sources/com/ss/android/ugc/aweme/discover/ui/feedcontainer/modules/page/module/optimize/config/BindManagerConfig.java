package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.IAsyncLoad;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.IAsyncPrefetchStrategy;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.IPreloadResultListener;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/BindManagerConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BindManagerConfig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CachalotAsyncConfig<T> f450658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f450659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f450660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function4<RecyclerView.ViewHolder, Integer, T, Boolean, Unit> f450661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IAsyncLoad<T> f450662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<String, Integer, T, CardPreloadConfig> f450663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Boolean, Boolean> f450664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IAsyncPrefetchStrategy f450665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IPreloadResultListener f450666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f450667j;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerConfig$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/Void;"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function3 {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(3);
        }

        public final Void invoke(String r100, int r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
            return null;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102) {
            return invoke((String) r100, ((Number) r101).intValue(), r102);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerConfig$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "<anonymous parameter 0>", "", "futureCount", "<anonymous parameter 2>", "failed", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function4<Integer, Integer, Integer, Boolean, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(4);
        }

        public final boolean invoke(int r100, int r101, int r102, boolean r103) {
            if (r103 == true) goto L8;
            if (r101 > 1) goto L9;
            return false;
        L9:
            return true;
        L8:
            return true;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(Integer r100, Integer r101, Integer r102, Boolean r103) {
            return Boolean.valueOf(invoke(r100.intValue(), r101.intValue(), r102.intValue(), r103.booleanValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BindManagerConfig(CachalotAsyncConfig<T> r100, RecyclerView r101, ExecutorService r102, Function4<? super RecyclerView.ViewHolder, ? super Integer, ? super T, ? super Boolean, Unit> r103, IAsyncLoad<T> r104, Function3<? super String, ? super Integer, ? super T, CardPreloadConfig> r105, Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Boolean> r106, IAsyncPrefetchStrategy r107, IPreloadResultListener r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "asyncConfig");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "executor");
        Intrinsics.checkNotNullParameter(r103, "bindViewHolder");
        Intrinsics.checkNotNullParameter(r104, "dataProvider");
        Intrinsics.checkNotNullParameter(r105, "cardPreloadConfigs");
        Intrinsics.checkNotNullParameter(r106, "skipAsyncBind");
        Intrinsics.checkNotNullParameter(r107, "preloadStrategy");
        this.f450658a = r100;
        this.f450659b = r101;
        this.f450660c = r102;
        this.f450661d = r103;
        this.f450662e = r104;
        this.f450663f = r105;
        this.f450664g = r106;
        this.f450665h = r107;
        this.f450666i = r110;
        this.f450667j = r111;
    }
}
