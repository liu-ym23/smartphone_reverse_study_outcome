package com.ss.android.lark.chat.chatwindow.biz.plugin.tools;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatMemoryLeakDetectPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f412330h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f412331g;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/ChatMemoryLeakDetectPlugin$DetectViewModel;", "Landroidx/lifecycle/ViewModel;", "input", "Landroidx/lifecycle/LiveData;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "<init>", "(Landroidx/lifecycle/LiveData;)V", "liveData", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/DetectMemoryLiveData;", "getLiveData", "()Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/DetectMemoryLiveData;", "observerCountFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getObserverCountFlow", "()Lkotlinx/coroutines/flow/Flow;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DetectViewModel extends ViewModel {
        private final LiveData<i7b.a> input;
        private final DetectMemoryLiveData<i7b.a> liveData;
        private final Flow<Integer> observerCountFlow;

        public static final class a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetectMemoryLiveData<i7b.a> f412332a;

            public a(DetectMemoryLiveData<i7b.a> r100) {
                this.f412332a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                DetectMemoryLiveData<i7b.a> r101 = this.f412332a;
                r101.setValue((i7b.a) r100);
            }
        }

        public final DetectMemoryLiveData<i7b.a> getLiveData() {
            return this.liveData;
        }

        public final Flow<Integer> getObserverCountFlow() {
            return this.observerCountFlow;
        }

        public DetectViewModel(LiveData<i7b.a> r100) {
            this.input = r100;
            DetectMemoryLiveData<i7b.a> r101 = new DetectMemoryLiveData();
            if (r100 == null) goto L5;
            r101.addSource(r100, new a(r101));
        L5:
            this.liveData = r101;
            this.observerCountFlow = e.b(r101.f412337a);
        }
    }

    public static final class a {
    }

    public static final class b implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveData<i7b.a> f412333a;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        public b(MutableLiveData r100) {
            this.f412333a = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return new DetectViewModel(this.f412333a);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f412334a = null;

        static {
            f412334a = new c();
        }

        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((i7b.a) r100, "it");
            Log.d("ChatMemoryLeakDetect", "add init data observer");
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        throw null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r110) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r110, "initData");
        super.C(r100, r110);
        this.f412331g = r100;
        Observer<? super i7b.a> r111 = c.f412334a;
        DetectViewModel r101 = (DetectViewModel) new ViewModelProvider(r100.getFragment(), new b(r100.c().getInitData())).get(DetectViewModel.class);
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r100.getFragment());
        Fragment r103 = null;
        BuildersKt.launch$default(r102, null, null, new ChatMemoryLeakDetectPlugin$onCreate$1(r101, this, null), 3, null);
        Object r104 = r100.getHost();
        if ((r104 instanceof Fragment) == false) goto L5;
        r103 = (Fragment) r104;
    L5:
        if (r103 == null) goto L9;
        Lifecycle r105 = r103.getLifecycle();
        if (r105 == null) goto L9;
        r105.addObserver(new ChatMemoryLeakDetectPlugin$onCreate$2(this));
    L9:
        r101.getLiveData().observe(r100.getFragment(), r111);
    }
}
