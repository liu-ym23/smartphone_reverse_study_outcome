package fy3;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.AutoRTLImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.collect.dialog.AosCollectTipDialog;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends f04.a<Unit> {
    public static final /* synthetic */ int q = 0;
    public final com.bytedance.awemeopen.apps.framework.collect.i d;
    public final View e;
    public final View f;
    public final View g;
    public final AutoRTLImageView h;
    public final DmtTextView i;
    public final AoImageView j;
    public final DampScrollableLayout k;
    public AosCollectTipDialog l;
    public final int m;
    public final a n;
    public int o;
    public final j p;

    public static final class a implements DampScrollableLayout.d {
        public final /* synthetic */ m a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(m r1) {
            this.a = r1;
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
        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r9) {
            m r0 = this.a;
            boolean r2 = false;
            if (r9 < r0.o) goto L14;
            if (r0.f.getAlpha() != 0.0f) goto L7;
            r2 = true;
        L7:
            if (r2 == true) goto L9;
        L12:
            r0.f.setAlpha(1.0f);
            x54.b.d(r0.i);
            return;
        L9:
            if (n0.c(r0.d.e.getContext()) == false) goto L11;
            r0.h.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231633));
            r0.i.setTextColor(ContextCompat.getColor(r0.getContext(), 2131100356));
            r0.j.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231635));
            goto L12
        L11:
            r0.h.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231632));
            r0.i.setTextColor(ContextCompat.getColor(r0.getContext(), 2131100340));
            r0.j.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231634));
            goto L12
        L14:
            if (r0.f.getAlpha() != 1.0f) goto L16;
            r2 = true;
        L16:
            if (r2 == false) goto L18;
            r0.h.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231633));
            r0.j.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231635));
        L18:
            r0.f.setAlpha(0.0f);
            x54.b.b(r0.i);
        }
    }

    @Override // f04.a
    public final void k() {
        this.k.e(this.n);
        this.d.b.getUserName().removeObserver(this.p);
        this.l = null;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [fy3.j] */
    public m(com.bytedance.awemeopen.apps.framework.collect.i r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        View r3 = i(2131367157);
        this.e = r3;
        this.f = i(2131388841);
        this.g = i(2131388813);
        this.h = (AutoRTLImageView) i(2131363770);
        this.i = (DmtTextView) i(2131388772);
        this.j = i(2131388830);
        this.k = (DampScrollableLayout) i(2131385230);
        this.m = z04.c.a(getContext());
        this.n = new a(this);
        r3.post(new i(this));
        this.p = new j();
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.h.setOnClickListener(new k(this));
        this.j.setOnClickListener(new l(this));
        this.l = new AosCollectTipDialog(getContext());
        this.k.d(this.n);
        this.d.b.getUserName().observe(this.d.c, this.p);
    }
}
