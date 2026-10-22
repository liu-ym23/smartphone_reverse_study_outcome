package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutMenuBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J \u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J \u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/ConversationListMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/larus/bmhome/view/screenmenu/IConversationListMenu;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "menuBinding", "Lcom/larus/bmhome/databinding/LarusLayoutMenuBinding;", "init", "", "setOnPinListener", "listener", "Lkotlin/Function0;", "setOnUnpinListener", "setOnEditNameListener", "menuExtra", "Lcom/larus/bmhome/view/screenmenu/MenuExtra;", "setOnDeleteListener", "setOnShareMessageListener", "setOnRefreshListener", "setOnHideListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationListMenu extends LinearLayoutCompat implements e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f317232b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusLayoutMenuBinding f317233a;

    public ConversationListMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        d(r100, null);
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnCopyWorkingDirectoryPathListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnHideListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutMenuBinding r101 = this.f317233a;
        LarusLayoutMenuBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        r101.f311057c.setVisibility(0);
        LarusLayoutMenuBinding r103 = this.f317233a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r103 = null;
    L8:
        r103.f311064j.setText(getContext().getString(R.string.larus_chatlist_hideChat));
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L12:
        com.larus.utils.e1.d(r102.f311057c, new i(r100));
        return;
    L11:
        r102 = r104;
        goto L12
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnPinListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutMenuBinding r101 = this.f317233a;
        LarusLayoutMenuBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        r101.f311058d.setVisibility(0);
        LarusLayoutMenuBinding r103 = this.f317233a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r103 = null;
    L8:
        r103.f311065k.setText(getContext().getString(R.string.larus_pin_chat));
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r104 = null;
    L11:
        r104.f311062h.setImageResource(v19.c.b(R.attr.larus_ic_conversation_pin, null, R.drawable.larus_ic_conversation_pin));
        LarusLayoutMenuBinding r105 = this.f317233a;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r102.f311058d, new k(r100));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRefreshListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutMenuBinding r101 = this.f317233a;
        LarusLayoutMenuBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        r101.f311059e.setVisibility(0);
        LarusLayoutMenuBinding r103 = this.f317233a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r103 = null;
    L8:
        r103.f311066l.setText(getContext().getString(R.string.larus_chat_list_rec_change));
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r104 = null;
    L11:
        r104.f311063i.setImageResource(R.drawable.larus_ic_cvs_regegerate);
        LarusLayoutMenuBinding r105 = this.f317233a;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r102.f311059e, new h(r100));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnRemoveFromProjectListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnShareMessageListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutMenuBinding r101 = this.f317233a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        FrameLayout r102 = r101.f311061g;
        r102.setVisibility(0);
        com.larus.utils.e1.d(r102, new j(r100));
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public void setOnUnpinListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LarusLayoutMenuBinding r101 = this.f317233a;
        LarusLayoutMenuBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r101 = null;
    L5:
        r101.f311058d.setVisibility(0);
        LarusLayoutMenuBinding r103 = this.f317233a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r103 = null;
    L8:
        r103.f311065k.setText(getContext().getString(R.string.larus_unpin_chat));
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r104 = null;
    L11:
        r104.f311062h.setImageResource(v19.c.b(R.attr.larus_ic_conversation_unpin, null, R.drawable.larus_ic_conversation_unpin));
        LarusLayoutMenuBinding r105 = this.f317233a;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r102.f311058d, new l(r100));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    public ConversationListMenu(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        d(r100, r101);
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void a(k0 r100, com.larus.bmhome.chat.manager.k r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void b(k0 r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        LarusLayoutMenuBinding r102 = this.f317233a;
        LarusLayoutMenuBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r102 = null;
    L5:
        r102.f311056b.setVisibility(0);
        if (r100 == null) goto L14;
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r104 = null;
    L10:
        r104.f311056b.setAlpha(r100.f317314b);
        LarusLayoutMenuBinding r105 = this.f317233a;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r105 = null;
    L13:
        r105.f311056b.setEnabled(r100.f317313a);
    L21:
        LarusLayoutMenuBinding r106 = this.f317233a;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L25:
        com.larus.utils.e1.d(r103.f311056b, new m(r101));
        return;
    L24:
        r103 = r106;
        goto L25
    L14:
        LarusLayoutMenuBinding r107 = this.f317233a;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r107 = null;
    L17:
        r107.f311056b.setAlpha(1.0f);
        LarusLayoutMenuBinding r108 = this.f317233a;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r108 = null;
    L20:
        r108.f311056b.setEnabled(true);
        goto L21
    }

    @Override // com.larus.bmhome.view.screenmenu.e0
    public final void c(k0 r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        LarusLayoutMenuBinding r102 = this.f317233a;
        LarusLayoutMenuBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r102 = null;
    L5:
        r102.f311060f.setVisibility(0);
        LarusLayoutMenuBinding r104 = this.f317233a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r104 = null;
    L8:
        r104.f311060f.setAlpha(r100.f317314b);
        LarusLayoutMenuBinding r105 = this.f317233a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
        r105 = null;
    L11:
        r105.f311060f.setEnabled(r100.f317313a);
        LarusLayoutMenuBinding r106 = this.f317233a;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("menuBinding");
    L15:
        com.larus.utils.e1.d(r103.f311060f, new n(r101));
        return;
    L14:
        r103 = r106;
        goto L15
    }

    public final void d(Context r110, AttributeSet r111) {
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_menu, this);
        int r100 = R.id.fl_menu_edit_name;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_edit_name);
        if (r101 == null) goto L29;
        r100 = R.id.fl_menu_hide;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_hide);
        if (r102 == null) goto L29;
        r100 = R.id.fl_menu_pinned;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_pinned);
        if (r103 == null) goto L29;
        r100 = R.id.fl_menu_refresh;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_refresh);
        if (r104 == null) goto L29;
        r100 = R.id.fl_menu_remove;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_remove);
        if (r105 == null) goto L29;
        r100 = R.id.fl_menu_share_message;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_menu_share_message);
        if (r106 == null) goto L29;
        r100 = R.id.iv_menu_hide;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_menu_hide)) == null) goto L29;
        r100 = R.id.iv_menu_pinned;
        AppCompatImageView r107 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_menu_pinned);
        if (r107 == null) goto L29;
        r100 = R.id.iv_menu_refresh;
        AppCompatImageView r108 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_menu_refresh);
        if (r108 == null) goto L29;
        r100 = R.id.tv_menu_hide;
        AppCompatTextView r112 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_menu_hide);
        if (r112 == null) goto L29;
        r100 = R.id.tv_menu_pinned;
        AppCompatTextView r113 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_menu_pinned);
        if (r113 == null) goto L29;
        r100 = R.id.tv_menu_refresh;
        AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_menu_refresh);
        if (r114 == null) goto L29;
        this.f317233a = new LarusLayoutMenuBinding(this, r101, r102, r103, r104, r105, r106, r107, r108, r112, r113, r114);
        setOrientation(1);
        setDividerDrawable(AppCompatResources.getDrawable(r110, v19.c.b(R.attr.larus_common_menu_divider, r110, R.drawable.larus_common_menu_divider)));
        setShowDividers(2);
        setBackgroundResource(v19.c.b(R.attr.larus_bg_conversation_menu, null, R.drawable.larus_bg_conversation_menu));
        return;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r100)));
    }

    public ConversationListMenu(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        d(r100, r101);
    }
}
