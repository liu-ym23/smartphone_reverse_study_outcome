package cq4;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.view.cell.title.record.span.DescriptionIconSpan;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.panel.BitablePanelFragment;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import fp4.g;
import gp4.h;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements aq4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f464770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f464771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f464772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitablePanelFragment f464773d;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f464774a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        public a(b r100) {
            this.f464774a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            BitablePanelFragment r101 = this.f464774a.f464773d;
            if (r101 == null) goto L13;
            r101.dismiss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L14;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }
    }

    /* JADX INFO: renamed from: cq4.b$b, reason: collision with other inner class name */
    public class C5571b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f464775a;

        public C5571b(g r100) {
            this.f464775a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            UDToast.show(r100.getContext(), this.f464775a.f478262i, R.drawable.ud_icon_warning_outlined);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f464776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC5572b f464777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DescriptionIconSpan f464778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DescriptionIconSpan.DescriptionIconState f464779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f464780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f464781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SyncIconImageView f464782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public dq4.a f464783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ClickableSpan f464784i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f464785j;

        public class a extends dq4.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f464786a;

            @Override // dq4.b
            public final void a(View r100) {
            }

            @Override // dq4.b
            public final void b(View r100) {
            }

            public a(c r100) {
                this.f464786a = r100;
            }

            @Override // android.text.style.ClickableSpan
            public final void onClick(View r100) {
                this.f464786a.f464784i.onClick(r100);
            }
        }

        /* JADX INFO: renamed from: cq4.b$c$b, reason: collision with other inner class name */
        public interface InterfaceC5572b {
        }

        public Context getContext() {
            return this.f464776a;
        }

        public c(View r100) {
            this.f464779d = DescriptionIconSpan.DescriptionIconState.STATE_NORMAL;
            this.f464783h = null;
            this.f464784i = null;
            this.f464785j = R.dimen.bitable_descrpition_icon_size;
            this.f464780e = r100;
            this.f464776a = r100.getContext();
            this.f464782g = (SyncIconImageView) r100.findViewById(R.id.cell_title_icon);
            this.f464781f = (TextView) r100.findViewById(R.id.cell_title_name);
        }

        public final void a(SpannableStringBuilder r100) {
            if (this.f464783h != null) goto L5;
            return;
        L5:
            int r101 = r100.length();
            r100.append("<doc.at.~#_%=`>");
            r100.setSpan(this.f464783h, r101, r100.length(), 33);
            if (this.f464784i == null) goto L9;
            r100.setSpan(new a(this), r101, r100.length(), 33);
            return;
        }

        public final void b(C5571b r100) {
            this.f464784i = r100;
            if (r100 == null) goto L5;
            this.f464783h = new dq4.a(this.f464776a, this.f464785j);
            this.f464781f.setMovementMethod(new dq4.c());
            return;
        L5:
            this.f464783h = null;
            this.f464781f.setMovementMethod(null);
        }
    }

    @Override // aq4.a
    public final View getView() {
        return this.f464772c.f464780e;
    }

    @Override // aq4.a
    public final void u() {
        BitablePanelFragment r100 = this.f464773d;
        if (r100 == null) goto L13;
        r100.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // aq4.a
    public final void v(g r100) {
        this.f464770a = r100;
        c r101 = this.f464772c;
        int r102 = r100.f478257d.getIcon();
        boolean r103 = r100.f478265l;
        r101.f464782g.setImageResource(r102);
        r101.f464782g.setSyncIconVisible(r103);
        ep4.a r104 = r100.f478259f;
        if (TextUtils.isEmpty(r100.f478262i) == true) goto L5;
        this.f464772c.b(new C5571b(r100));
    L7:
        if (r100.f478261h == false) goto L13;
        cp4.b r105 = r100.f478254a;
        if (r105 == null) goto L13;
        if (r105.f464675s != ETableType.STAGE) goto L13;
        boolean r106 = true;
    L15:
        if (r104.a() == false) goto L23;
        c r107 = this.f464772c;
        String r108 = r100.f478256c;
        r107.f464781f.setMovementMethod(new dq4.c());
        SpannableStringBuilder r109 = new SpannableStringBuilder(r108);
        r109.append("<doc.at.~#_%=`>");
        DescriptionIconSpan r110 = new DescriptionIconSpan(r107.f464776a, r107.f464785j);
        r107.f464778c = r110;
        DescriptionIconSpan.DescriptionIconState r111 = r107.f464779d;
        if (r111 != null) goto L19;
        r111 = DescriptionIconSpan.DescriptionIconState.STATE_NORMAL;
    L19:
        r110.f208281b = r111;
        r109.setSpan(r110, r108.length(), r109.length(), 33);
        r109.setSpan(new d(r107), r108.length(), r109.length(), 33);
        if (r106 == false) goto L22;
        r109.append("*");
        r109.setSpan(new bq4.d(r107.f464776a), r109.length() - 1, r109.length(), 33);
    L22:
        r107.a(r109);
        r107.f464781f.setText(r109);
        return;
    L23:
        c r112 = this.f464772c;
        String r113 = r100.f478256c;
        r112.getClass();
        SpannableStringBuilder r114 = new SpannableStringBuilder(r113);
        if (r106 == false) goto L26;
        r114.append("*");
        r114.setSpan(new bq4.d(r112.f464776a), r114.length() - 1, r114.length(), 33);
    L26:
        r112.a(r114);
        r112.f464781f.setText(r114);
        return;
    L13:
        r106 = false;
        goto L15
    L5:
        this.f464772c.b(null);
        goto L7
    }

    public b(View r100, h r101) {
        this.f464771b = r101;
        c r102 = new c(r100);
        this.f464772c = r102;
        r102.f464777b = new cq4.a(this);
        r100.addOnAttachStateChangeListener(new a(this));
    }
}
