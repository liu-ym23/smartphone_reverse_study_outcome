package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosDefaultNetErrorView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosDefaultNetErrorView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public DmtTextView a;
    public DmtTextView b;
    public DmtTextView c;

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
    public final void b() {
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setTextColor(getResources().getColor(2131100272));
    L5:
        AppCompatTextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setTextColor(getResources().getColor(2131100319));
    L8:
        DmtTextView r2 = this.c;
        if (r2 == null) goto L11;
        r2.setBackgroundResource(2131231426);
    L11:
        AppCompatTextView r3 = this.c;
        if (r3 == null) goto L15;
        r3.setTextColor(getResources().getColor(2131100272));
        return;
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
    public final void c() {
        AppCompatTextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setTextColor(getResources().getColor(2131100340));
    L5:
        AppCompatTextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setTextColor(getResources().getColor(2131100342));
    L8:
        DmtTextView r2 = this.c;
        if (r2 == null) goto L11;
        r2.setBackgroundResource(2131231543);
    L11:
        AppCompatTextView r3 = this.c;
        if (r3 == null) goto L15;
        r3.setTextColor(getResources().getColor(2131100340));
        return;
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131558702, this, true);
        ImageView r0 = (ImageView) findViewById(2131375008);
        this.a = (DmtTextView) findViewById(2131388877);
        this.b = (DmtTextView) findViewById(2131367826);
        this.c = (DmtTextView) findViewById(2131384465);
    }

    public AosDefaultNetErrorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        a();
    }

    public AosDefaultNetErrorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (Intrinsics.areEqual(r2, this) == false) goto L9;
        if (r3 != 0) goto L10;
        AppCompatTextView r4 = this.c;
        if (r4 == null) goto L11;
        r4.post(new a(this));
        return;
    L11:
        return;
    L10:
        return;
    }

    public AosDefaultNetErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        a();
    }
}
