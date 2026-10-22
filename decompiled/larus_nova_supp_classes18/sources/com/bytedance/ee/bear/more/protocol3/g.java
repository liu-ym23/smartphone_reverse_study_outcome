package com.bytedance.ee.bear.more.protocol3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class g implements b {
    public h a;
    public String b;

    public abstract k a();

    public c b() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public void create() {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public void release() {
    }

    public final oj5.c c() {
        h r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r0 = null;
    L6:
        return r0.d;
    }

    public final void f() {
        h r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r0 = null;
    L5:
        r0.g();
    }

    public final sj5.b getHost() {
        h r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r0 = null;
    L6:
        return r0.f();
    }

    public final void j() {
        if (this.b.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        h r1 = this.a;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r1 = null;
    L10:
        r1.h(this.b);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public g() {
        this.b = "";
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public final k buildUI() {
        k r0 = a();
        if (r0 != null) goto L5;
    L10:
        return r0;
    L5:
        if (this.b.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        this.b = r0.a;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public final <T extends oj5.c> T d(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clz");
        h r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "clz");
        T r0 = (T) r1.d;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r4.isAssignableFrom(r0.getClass()) == true) goto L10;
        return null;
    L10:
        return r0;
    }

    public final String e(int r3) {
        if (r3 > 0) goto L5;
        return "";
    L5:
        Context r1 = getHost().getHostFragment().getContext();
        if (r1 == null) goto L12;
        String r4 = r1.getString(r3);
        if (r4 != null) goto L11;
        return "";
    L11:
        return r4;
    L12:
        return "";
    }

    public final boolean g(String r5) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_ID);
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return false;
    L5:
        String[] r1 = r0.u();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.length != 0) goto L10;
        boolean r2 = true;
    L12:
        if ((!r2) == true) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r5) == true) goto L27;
        Iterator r3 = ArrayIteratorKt.iterator(r1);
    L17:
        if (r3.hasNext() == false) goto L28;
        if (TextUtils.equals(r5, (String) r3.next()) == false) goto L17;
        return true;
    L28:
        return false;
    L27:
        return false;
    L10:
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.protocol3.b
    public void init(h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostProvider");
        this.a = r2;
    }

    public final k h(f r8, e r9, List<? extends m> r10, List<? extends a> r11, View.OnClickListener r12) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r9, "style");
        ArrayList r4 = new ArrayList();
        if (r10 != null) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        r4.addAll(r10);
        r4.add(new com.bytedance.ee.bear.more.protocol3.checker.c(r8.a));
        ArrayList r5 = new ArrayList();
        if (r11 != null) goto L8;
        r11 = CollectionsKt.emptyList();
    L8:
        r5.addAll(r11);
        r5.add(new com.bytedance.ee.bear.more.protocol3.checker.c(r8.a));
        Iterator r13 = r4.iterator();
    L9:
        j r0 = null;
        if (r13.hasNext() == false) goto L16;
        m r14 = (m) r13.next();
        if ((r14 instanceof j) == false) goto L14;
        r0 = (j) r14;
    L14:
        if (r0 == null) goto L9;
        r0.a = this;
        goto L9
    L16:
        Iterator r15 = r5.iterator();
    L18:
        if (r15.hasNext() == false) goto L25;
        a r16 = (a) r15.next();
        if ((r16 instanceof j) == false) goto L22;
        j r17 = (j) r16;
    L23:
        if (r17 == null) goto L18;
        r17.a = this;
        goto L18
    L22:
        r17 = null;
        goto L23
    L25:
        h r18 = this.a;
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
        r18 = null;
    L28:
        l r19 = r18.b;
        if (r19 == null) goto L31;
        l r1 = r19;
    L33:
        return r1.b(r8, r9, r4, r5, r12);
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("uiItemFactory");
        r1 = null;
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k i(g r7, f r8, e r9, List r10, List r11, View.OnClickListener r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r9 = new e.f(false, false, false);
    L5:
        e r3 = r9;
        if ((r13 & 4) == 0) goto L8;
        List r4 = null;
    L10:
        if ((r13 & 8) == 0) goto L12;
        List r5 = null;
    L14:
        if ((r13 & 16) == 0) goto L16;
        View.OnClickListener r6 = null;
    L18:
        return r7.h(r8, r3, r4, r5, r6);
    L16:
        r6 = r12;
        goto L18
    L12:
        r5 = r11;
        goto L14
    L8:
        r4 = r10;
        goto L10
    }
}
