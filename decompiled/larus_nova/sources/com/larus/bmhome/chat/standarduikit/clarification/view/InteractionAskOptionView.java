package com.larus.bmhome.chat.standarduikit.clarification.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.mainbot.impl.databinding.LarusInteractionAskOptionViewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import ij8.j;
import ij8.k;
import ij8.l;
import ij8.m;
import ij8.n;
import ij8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010&\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eJ\b\u0010-\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010.\u001a\u00020'2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020'00J\b\u00101\u001a\u00020'H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u0019R\u001b\u0010#\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0019¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/clarification/view/InteractionAskOptionView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "optionCache", "Lcom/larus/im/bean/message/block/InteractionAskOption;", "markIndex", "selectedState", "", "showSelectedMarkState", "binding", "Lcom/larus/mainbot/impl/databinding/LarusInteractionAskOptionViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusInteractionAskOptionViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "markIndexView", "Landroid/widget/TextView;", "getMarkIndexView", "()Landroid/widget/TextView;", "markIndexView$delegate", "markCheckedView", "Landroidx/appcompat/widget/AppCompatImageView;", "getMarkCheckedView", "()Landroidx/appcompat/widget/AppCompatImageView;", "markCheckedView$delegate", "titleView", "getTitleView", "titleView$delegate", "descriptionView", "getDescriptionView", "descriptionView$delegate", "bind", "", "option", "index", "setSelectedState", "selected", "showSelectedMark", "boundOption", "setOnOptionClickListener", "listener", "Lkotlin/Function1;", "renderMark", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionAskOptionView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f308961j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InteractionAskOption f308962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f308963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f308964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f308965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f308966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f308967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f308968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f308969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f308970i;

    public InteractionAskOptionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InteractionAskOptionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusInteractionAskOptionViewBinding getBinding() {
        return (LarusInteractionAskOptionViewBinding) this.f308966e.getValue();
    }

    private final TextView getDescriptionView() {
        return (TextView) this.f308970i.getValue();
    }

    private final AppCompatImageView getMarkCheckedView() {
        return (AppCompatImageView) this.f308968g.getValue();
    }

    private final TextView getMarkIndexView() {
        return (TextView) this.f308967f.getValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.f308969h.getValue();
    }

    public final void f() {
        if (this.f308964c == true) goto L5;
    L7:
        getMarkCheckedView().setVisibility(8);
        getMarkIndexView().setVisibility(0);
        getMarkIndexView().setText(String.valueOf(this.f308963b + 1));
        return;
    L5:
        if (this.f308965d == false) goto L7;
        getMarkCheckedView().setVisibility(0);
        getMarkIndexView().setVisibility(8);
    }

    public static TextView a(InteractionAskOptionView r100) {
        return r100.getBinding().f358666d;
    }

    public static AppCompatImageView b(InteractionAskOptionView r100) {
        return r100.getBinding().f358665c;
    }

    public static TextView c(InteractionAskOptionView r100) {
        return r100.getBinding().f358667e;
    }

    public static TextView d(InteractionAskOptionView r100) {
        return r100.getBinding().f358664b;
    }

    public final void setOnOptionClickListener(final Function1<? super InteractionAskOption, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        setOnClickListener(new j(this, r100));
    }

    public final void e(int r100, InteractionAskOption r101) {
        Intrinsics.checkNotNullParameter(r101, "option");
        this.f308963b = r100;
        this.f308962a = r101;
        TextView r102 = getTitleView();
        String r103 = r101.getLabel();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.setText(r103);
        String r105 = r101.getDescription();
        if (r105 == null) goto L10;
        r104 = r105;
    L10:
        if (StringsKt.isBlank(r104) == false) goto L12;
        getDescriptionView().setVisibility(8);
    L13:
        f();
        return;
    L12:
        getDescriptionView().setVisibility(0);
        getDescriptionView().setText(r104);
        goto L13
    }

    public InteractionAskOptionView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f308966e = LazyKt.lazy(new k(r100, this));
        this.f308967f = LazyKt.lazy(new l(this));
        this.f308968g = LazyKt.lazy(new m(this));
        this.f308969h = LazyKt.lazy(new n(this));
        this.f308970i = LazyKt.lazy(new o(this));
    }

    public /* synthetic */ InteractionAskOptionView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
