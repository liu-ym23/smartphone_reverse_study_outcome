package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.chat.common.databinding.LarusLayoutTextMessageMultiActionButtonBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/view/TextAnswerMultiActionButton;", "Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageMultiActionButtonBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageMultiActionButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "config", "", "action", "Lcom/larus/bmhome/view/actionbar/IAction;", "useSubscribedColor", "", "compact", "getRoot", "Landroid/view/ViewGroup;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextAnswerMultiActionButton extends BaseTextAnswerActionButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f315601d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f315602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f315603c;

    public TextAnswerMultiActionButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TextAnswerMultiActionButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public ViewGroup getRoot() {
        return this;
    }

    private final LarusLayoutTextMessageMultiActionButtonBinding getBinding() {
        return (LarusLayoutTextMessageMultiActionButtonBinding) this.f315602b.getValue();
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) this.f315603c.getValue();
    }

    public TextAnswerMultiActionButton(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315602b = LazyKt.lazy(new i4(r100, this));
        this.f315603c = LazyKt.lazy(new j4());
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public final void a(final rs8.g r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super.a(r100, r101, r102);
        if ((r100 instanceof rs8.o) == true) goto L5;
        return;
    L5:
        final LarusLayoutTextMessageMultiActionButtonBinding r103 = getBinding();
        if (r102 == false) goto L8;
        int r104 = i5.T();
    L9:
        if (r102 == false) goto L11;
        int r105 = i5.j0();
    L12:
        AppCompatImageView r106 = r103.f324051d;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.width = r104;
        r107.height = r104;
        r106.setLayoutParams(r107);
        r103.f324051d.setPadding(r105, r105, r105, r105);
        com.larus.utils.e1.x(r103.f324049b);
        rs8.o r108 = (rs8.o) r100;
        com.larus.utils.e1.x(r103.f324054g);
        com.larus.utils.e1.o(r103.f324053f);
        r103.f324054g.setText(null);
        Integer r109 = c(r101);
        if (r109 == null) goto L15;
        int r110 = r109.intValue();
        r103.f324054g.setTextColor(r110);
    L15:
        if (r101 == false) goto L17;
        r103.f324050c.setBackgroundColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.additional_purple_premium_1_transparent2, null, R.color.additional_purple_premium_1_transparent2)));
    L17:
        ColorFilter r111 = b(r101);
        if (r111 == null) goto L20;
        r103.f324051d.setColorFilter(r111);
    L20:
        com.larus.utils.e1.d(r103.f324054g, new k4(r100));
        com.larus.utils.e1.d(r103.f324052e, new l4(r100, r103, this));
        return;
    L11:
        r105 = i5.n0();
        goto L12
    L8:
        r104 = i5.W();
        goto L9
    }

    public /* synthetic */ TextAnswerMultiActionButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
