package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListToast;", "Landroid/widget/FrameLayout;", "", "", "c", "Lkotlin/Lazy;", "getToastList", "()Ljava/util/List;", "toastList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronPromotionListToast extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public AnimatorSet a;
    public String b;
    public final Lazy c;

    public IronPromotionListToast(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronPromotionListToast(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final List<String> getToastList() {
        return (List) this.c.getValue();
    }

    public final void a() {
        setVisibility(8);
        getToastList().clear();
        AnimatorSet r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
    }

    public final boolean c() {
        List<String> r0 = getToastList();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        int r2 = CollectionsKt.getLastIndex(getToastList());
    L12:
        if (r2 < 0) goto L20;
        String r3 = this.b;
        if (r3 == null) goto L19;
        if ((!Intrinsics.areEqual(r3, (String) ListProtector.get(getToastList(), r2))) == true) goto L19;
        r2 = r2 - 1;
    L19:
        String r4 = (String) ListProtector.get(getToastList(), r2);
    L21:
        getToastList().clear();
        if (r4 == null) goto L30;
        this.b = r4;
        ((TextView) findViewById(2131391632)).setText(r4);
        if (this.a != null) goto L26;
        AnimatorSet r5 = new AnimatorSet();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f}).setDuration(200);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 1.0f}).setDuration(KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}).setDuration(200);
        r5.addListener(new e(this));
        r5.playSequentially(new Animator[]{r6, r8, r7});
        Unit r9 = Unit.INSTANCE;
        this.a = r5;
    L26:
        AnimatorSet r10 = this.a;
        if (r10 == null) goto L29;
        r10.start();
    L29:
        return true;
    L30:
        return false;
    L20:
        r4 = null;
        goto L21
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void b(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        getToastList().add(r3);
        AnimatorSet r4 = this.a;
        if (r4 != null) goto L14;
    L15:
        c();
        return;
    L14:
        if (r4.isRunning() != true) goto L15;
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public IronPromotionListToast(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, IronPromotionListToast$toastList$2.INSTANCE);
        th.a.c(r2, 2131564726, this, true);
    }

    public /* synthetic */ IronPromotionListToast(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
