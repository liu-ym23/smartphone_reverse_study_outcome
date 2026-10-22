package com.bytedance.android.livesdk.livecommerce.userinfo.rank;

import androidx.lifecycle.Observer;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.live.api.commerce.userinfo.d;
import com.bytedance.android.livesdk.livecommerce.userinfo.rank.repository.ECRankRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/rank/ECRankViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lkl2/a;", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "userInfo", "", "onUserInfoChanged", "onDestroy", "Lbk2/b;", "disposableContext", "Lbk2/b;", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/rank/repository/ECRankRepository;", "repository", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/rank/repository/ECRankRepository;", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "roomUniqueKey", "getRoomUniqueKey", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/d;", "ability", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/d;", "getAbility", "()Lcom/bytedance/android/ec/live/api/commerce/userinfo/d;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/live/api/commerce/userinfo/d;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRankViewModel extends QStateViewModel<kl2.a> {
    public static final a Companion = null;
    private static final String TAG = "ECRankViewModel";
    private final d ability;
    private final bk2.b disposableContext;
    private final ECRankRepository repository;
    private final String roomId;
    private final String roomUniqueKey;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.rank.ECRankViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "p1", "", "invoke", "(Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.ec.live.api.commerce.userinfo.b, Unit> {
        public AnonymousClass2(ECRankViewModel r8) {
            super(1, r8, ECRankViewModel.class, "onUserInfoChanged", "onUserInfoChanged(Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECUserInfo;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.ec.live.api.commerce.userinfo.b) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(com.bytedance.android.ec.live.api.commerce.userinfo.b r2) {
            ECRankViewModel.access$onUserInfoChanged((ECRankViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements Observer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.rank.ECRankViewModel$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "p1", "", "invoke", "(Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C03361 extends FunctionReferenceImpl implements Function1<com.bytedance.android.ec.live.api.commerce.userinfo.b, Unit> {
        public C03361(ECRankViewModel r8) {
            super(1, r8, ECRankViewModel.class, "onUserInfoChanged", "onUserInfoChanged(Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECUserInfo;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.ec.live.api.commerce.userinfo.b) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(com.bytedance.android.ec.live.api.commerce.userinfo.b r2) {
            ECRankViewModel.access$onUserInfoChanged((ECRankViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    static {
        Companion = new a();
    }

    public final d getAbility() {
        return null;
    }

    public final void onDestroy() {
        onCleared();
        this.repository.b.removeObserver(new b(new C03361(this)));
        this.disposableContext.clearDisposable();
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRoomUniqueKey() {
        return this.roomUniqueKey;
    }

    public static final /* synthetic */ ECRankRepository access$getRepository$p(ECRankViewModel r0) {
        return r0.repository;
    }

    private final void onUserInfoChanged(com.bytedance.android.ec.live.api.commerce.userinfo.b r5) {
        if (r5 != null) goto L12;
        final Map r1 = MapsKt.emptyMap();
        if (r1.isEmpty() == false) goto L10;
        dm.a.b r2 = dm.a.a(TAG);
        if (r5 != null) goto L9;
        r2.w("onUserInfoChanged extendArea is Empty null", null);
        goto L10
    L9:
        throw null;
    L10:
        setState(new C03371(this, r1));
        return;
    L12:
        throw null;
    }

    public static final /* synthetic */ void access$onUserInfoChanged(ECRankViewModel r0, com.bytedance.android.ec.live.api.commerce.userinfo.b r1) {
        r0.onUserInfoChanged(r1);
    }

    public ECRankViewModel(String r8, String r9, d r10) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r10, "ability");
        super(new kl2.a(0));
        this.roomId = r8;
        this.roomUniqueKey = r9;
        bk2.b r6 = new bk2.b();
        this.disposableContext = r6;
        ECRankRepository r11 = new ECRankRepository(r8, r9, new ECRankViewModel$repository$1(this), mg.b.a(this), r6);
        this.repository = r11;
        setState(new AnonymousClass1(this));
        r11.b.observeForever(new b(new AnonymousClass2(this)));
    }
}
