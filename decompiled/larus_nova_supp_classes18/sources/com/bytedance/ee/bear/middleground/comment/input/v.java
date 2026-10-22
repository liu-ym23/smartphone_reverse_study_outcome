package com.bytedance.ee.bear.middleground.comment.input;

import android.text.Editable;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.widget.AtEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements AtEditText.b {
    public final /* synthetic */ BaseInputComment a;

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
        BaseInputComment r0 = this.a;
        SharePermissionViewModel r1 = r0.h;
        UDEditText r2 = r0.e();
        final BaseInputComment r3 = this.a;
        r1.i(r2, true, new BaseInputComment$initDefaultData$3$notifyHtmlPaste$1(r3));
        Editable r4 = this.a.e().getText();
        if (r4 == null) goto L18;
        BaseInputComment r5 = this.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_link_optimize") == false) goto L18;
        ArrayList r6 = new ArrayList();
        if (com.bytedance.ee.bear.middleground.comment.input.utils.f.a(r4, r6) == false) goto L18;
        if (r6.size() <= 1) goto L13;
        CollectionsKt.sortWith(r6, new u());
    L13:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        r7.add(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r8.next()).a);
        goto L15
    L17:
        r5.getClass();
        com.bytedance.ee.util.ui.j.c(new BaseInputComment$dealWithUrls$1(r5, r7));
    L18:
        BaseInputComment r9 = this.a;
        List<ve5.m> r10 = r9.B(r9.A());
        ve5.e r11 = r9.H();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "mentions");
        r11.l(r10);
        return;
    }

    public v(BaseInputComment r1) {
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
        BaseInputComment r6 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        r2.add(((com.bytedance.ee.bear.middleground.comment.input.utils.e) r1.next()).a);
        goto L12
    L14:
        r6.getClass();
        com.bytedance.ee.util.ui.j.c(new BaseInputComment$dealWithUrls$1(r6, r2));
    L16:
        return false;
    L15:
        final BaseInputComment r3 = this.a;
        r3.getClass();
        com.bytedance.ee.util.ui.j.c(new BaseInputComment$dealWithUrl$1(r3, r5));
        goto L16
    }
}
