package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.toolbox.rxanimation.RxViewAnimationExtensionKt;
import com.bytedance.android.ec.core.utils.a1;
import com.bytedance.android.ec.core.utils.i1;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4RulePresenter extends QPresenter implements c53.d {
    public static final /* synthetic */ int j = 0;
    public final com.bytedance.android.ec.core.arch.viewmodel.c e;
    public Disposable f;
    public GroupInfo g;
    public final FragmentActivity h;
    public final /* synthetic */ c53.b i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorV4RulePresenter a;

        public b(AnchorV4RulePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AnchorV4ActivityGroupViewModel r0 = (AnchorV4ActivityGroupViewModel) this.a.e.getValue();
            r0.updateGroupInfo((GroupInfo) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ AnchorV4RulePresenter a;

        public d(AnchorV4RulePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r17) {
            GroupInfo r1 = (GroupInfo) r17;
            if (r1 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(r1, this.a.g)) == false) goto L7;
            GroupInfo r2 = r1;
        L8:
            if (r2 == null) goto L23;
            AnchorV4RulePresenter r5 = this.a;
            if (r1.getAvatars().isEmpty() == false) goto L17;
            GroupInfo r6 = this.a.g;
            if (r6 == null) goto L15;
            List r7 = r6.getAvatars();
            if (r7 == null) goto L15;
        L16:
            r1.setAvatars(r7);
        L15:
            r7 = CollectionsKt.emptyList();
        L17:
            Unit r8 = Unit.INSTANCE;
            r5.g = r1;
            AnchorV4RulePresenter r3 = this.a;
            r3.w().b(2131373922).g(0);
            Disposable r9 = r3.f;
            if (r9 == null) goto L20;
            Intrinsics.checkNotNullParameter(r9, "$this$disposeFrom");
            Intrinsics.checkNotNullParameter(r3, "disposableContext");
            r3.remove(r9);
        L20:
            ViewGroup r10 = (ViewGroup) r3.w().b(2131363754).f();
            Intrinsics.checkNotNullParameter(r10, "avatarContainer");
            Intrinsics.checkNotNullParameter(r2, "groupInfo");
            int r11 = com.bytedance.android.ec.core.toolbox.rxanimation.a.a;
            Completable r12 = com.bytedance.android.ec.core.toolbox.rxanimation.a.a(new Completable[]{Completable.create(new i(r10, r2))});
            ViewGroup r13 = (ViewGroup) r3.w().b(2131373922).f();
            ViewGroup r14 = (ViewGroup) r3.w().b(2131363754).f();
            TextView r15 = (TextView) r3.w().b(2131391594).f();
            Intrinsics.checkNotNullParameter(r13, "groupContainer");
            Intrinsics.checkNotNullParameter(r14, "avatarContainer");
            Intrinsics.checkNotNullParameter(r15, "tvTip");
            Intrinsics.checkNotNullParameter(r2, "groupInfo");
            r3.f = c53.c.a(com.bytedance.android.ec.core.toolbox.rxanimation.a.a(new Completable[]{r12, com.bytedance.android.ec.core.toolbox.rxanimation.a.a(new Completable[]{RxViewAnimationExtensionKt.d(r15, 0.0f, 500L, null, 28).doOnComplete(new j(r15)), RxViewAnimationExtensionKt.d(r15, 1.0f, 500L, null, 28).doOnSubscribe(new k(r13, r14, r15, r2))})}).subscribe(e.a, f.a), r3);
            return;
        L23:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    static {
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.i.add(r2);
        return r2;
    }

    public final void doClear() {
        this.i.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.i.remove(r2);
    }

    public final void C() {
        doClear();
    }

    public final FragmentActivity getContext() {
        return this.h;
    }

    public AnchorV4RulePresenter(final FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.i = new c53.b();
        this.h = r5;
        AnchorV4RulePresenter$viewModel$2 r0 = AnchorV4RulePresenter$viewModel$2.INSTANCE;
        final Function0<FragmentActivity> r1 = new AnchorV4RulePresenter$$special$$inlined$viewModels$1(r5);
        this.e = com.bytedance.android.ec.core.arch.viewmodel.a.a(r5, Reflection.getOrCreateKotlinClass(AnchorV4ActivityGroupViewModel.class), new AnchorV4RulePresenter$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void A(QModel r7) {
        int r8 = a1.a;
        c53.c.a(bg4.b.b(i1.a(a1.a(0, 25, TimeUnit.SECONDS, Schedulers.computation()), new AnchorV4RulePresenter$onBind$1(this))).subscribe(new b(this), c.a), this);
        ((AnchorV4ActivityGroupViewModel) this.e.getValue()).getGroupInfo().b(this.h, new d(this));
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.i.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }
}
