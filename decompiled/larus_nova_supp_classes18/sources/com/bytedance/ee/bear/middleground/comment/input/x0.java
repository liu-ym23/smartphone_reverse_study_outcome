package com.bytedance.ee.bear.middleground.comment.input;

import android.text.Editable;
import com.bytedance.ee.bear.widget.AtEditText;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x0 implements AtEditText.b {
    public final /* synthetic */ InputComment a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r2).a.length()), Integer.valueOf(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r1).a.length()));
        }
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
    @Override // com.bytedance.ee.bear.widget.AtEditText.b
    public final void a() {
        if (this.a.isShowing() == false) goto L21;
        final InputComment r0 = this.a;
        r0.j.i(r0.p, true, new InputComment$initDefaultData$5$notifyHtmlPaste$1(r0));
        Editable r1 = this.a.p.getText();
        if (r1 == null) goto L18;
        InputComment r2 = this.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_link_optimize") == false) goto L18;
        ArrayList r3 = new ArrayList();
        if (com.bytedance.ee.bear.middleground.comment.input.utils.f.a(r1, r3) == false) goto L18;
        if (r3.size() <= 1) goto L13;
        CollectionsKt.sortWith(r3, new w0());
    L13:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r4.add(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r5.next()).a);
        goto L15
    L17:
        r2.getClass();
        com.bytedance.ee.util.ui.j.c(new InputComment$dealWithUrls$1(r2, r4));
    L18:
        InputComment r6 = this.a;
        List<ve5.m> r7 = r6.E(r6.D());
        ve5.e r8 = r6.H();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "mentions");
        r8.l(r7);
        return;
    }

    public x0(InputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.b
    public final boolean onPaste(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_link_optimize") == false) goto L15;
        ArrayList r0 = new ArrayList();
        if (com.bytedance.ee.bear.middleground.comment.input.utils.f.a(r5, r0) == true) goto L8;
        return false;
    L8:
        if (r0.size() <= 1) goto L10;
        CollectionsKt.sortWith(r0, new a());
    L10:
        InputComment r6 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        r2.add(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r1.next()).a);
        goto L12
    L14:
        r6.getClass();
        com.bytedance.ee.util.ui.j.c(new InputComment$dealWithUrls$1(r6, r2));
    L16:
        return false;
    L15:
        final InputComment r3 = this.a;
        r3.getClass();
        com.bytedance.ee.util.ui.j.c(new InputComment$dealWithUrl$1(r3, r5));
        goto L16
    }
}
