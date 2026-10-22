package com.obric.assistant.login;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import com.obric.assistant.onelogin.impl.databinding.ObricEnterpriseAccountTipListItemBinding;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f390267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<com.obric.oui.dialog.v2.alert.c> f390268b;

    static {
        f390267a = new s();
    }

    public s() {
    }

    public static /* synthetic */ void b(ObricEnterpriseAccountTipListItemBinding r100, int r101, int r102, int r110, int r111, int r112) {
        a(r100, r101, r102, r110, true, r111, r112);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(ObricEnterpriseAccountTipListItemBinding r100, int r101, int r102, int r103, boolean r104, int r105, int r106) {
        ODialogListItemView r107 = r100.f390938b;
        r107.setTitle(r107.getContext().getText(r102));
        ODialogListItemView r108 = r100.f390938b;
        r108.setSubtitle(r108.getContext().getText(r103));
        r100.f390938b.setChangeAlphaWhenPress(false);
        r100.f390938b.setClickable(false);
        r100.f390938b.setFocusable(false);
        r100.f390938b.getSubtitleView().setMaxLines(Integer.MAX_VALUE);
        r100.f390938b.getSubtitleView().setEllipsize(null);
        ODialogListItemView r109 = r100.f390938b;
        ImageView r110 = new ImageView(r100.f390938b.getContext());
        r110.setImageResource(r101);
        r110.setImportantForAccessibility(2);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(r105, r105);
        r111.gravity = 17;
        Unit r112 = Unit.INSTANCE;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "layoutParams");
        r109.d(r109.getLeadingContainer(), r110, r111);
        r109.getListItemRoot().setPadding(pla.d.n(r109, 0), r109.getPaddingTop(), r109.getPaddingRight(), r109.getPaddingBottom());
        r109.getLeadingContainer().measure(0, 0);
        r109.e(r109.f400779m);
        FrameLayout r113 = r100.f390938b.getLeadingContainer();
        ViewGroup.LayoutParams r114 = r100.f390938b.getLeadingContainer().getLayoutParams();
        r114.width = r106;
        r114.height = -1;
        r113.setLayoutParams(r114);
        ODialogListItemView r115 = r100.f390938b;
        r115.f400779m = r104;
        r115.getLeadingContainer().measure(0, 0);
        OneShotPreDrawListener.add(r115, new com.obric.oui.dialog.v2.common.a(r115, r115, r104));
    }
}
