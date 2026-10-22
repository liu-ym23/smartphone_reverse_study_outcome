package com.bytedance.ee.bear.wikiv2.selector;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements iq5.p {
    public static final /* synthetic */ int b = 0;
    public final SelectorScope a;

    public static final class a {
        @JvmStatic
        public static boolean a() {
            if (qc5.a.c() == false) goto L5;
        L8:
            boolean r0 = true;
        L9:
            tt5.a.h("IRootSelectData-MyLibrary", "isFGEnabled: " + r0);
            return r0;
        L5:
            if (qc5.a.h() == true) goto L8;
            r0 = false;
            goto L9
        }

        @JvmStatic
        public static boolean b(SelectorScope r2) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            if (r2 != SelectorScope.ALL) goto L5;
        L8:
            boolean r3 = true;
        L9:
            tt5.a.h("IRootSelectData-MyLibrary", "isScopeSupported: " + r3);
            return r3;
        L5:
            if (r2 == SelectorScope.WIKI_ONLY) goto L8;
            r3 = false;
            goto L9
        }
    }

    static {
    }

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final int c() {
        return 2131255197;
    }

    @Override // iq5.p
    public final /* synthetic */ int d() {
        return 0;
    }

    @Override // iq5.p
    public final int height() {
        return com.bytedance.ee.util.ui.n.d(48);
    }

    @Override // iq5.p
    public final String title() {
        Application r0 = eu5.b.a;
        int r1 = jq5.a.a;
        return r0.getString(2131888790);
    }

    public o(SelectorScope r2) {
        Intrinsics.checkNotNullParameter(r2, "selectorScope");
        this.a = r2;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r6) {
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        if (r6.g.n1().hasBenefit("common_wiki_node_management") == true) goto L5;
        return false;
    L5:
        boolean r0 = a.b(this.a);
        boolean r2 = a.a();
        String r7 = dq5.j.a(r6);
        tt5.a.h("IRootSelectData-MyLibrary", "isVisible, scopeEnable: " + r0 + ", fgEnable: " + r2 + ", cachedMyLibraryId: " + r7);
        if (r0 == false) goto L18;
        if (r2 == true) goto L9;
        return false;
    L9:
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (r7.length() == 0) goto L14;
        r8 = false;
        goto L15
    L18:
        return false;
    }
}
