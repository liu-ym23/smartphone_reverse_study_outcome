package com.bytedance.ee.bear.wikiv2.selector;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements iq5.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f241190b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectorScope f241191a;

    public static final class a {
        @JvmStatic
        public static boolean a() {
            if (qc5.a.c() == false) goto L5;
        L8:
            boolean r100 = true;
        L9:
            tt5.a.h("IRootSelectData-MyLibrary", "isFGEnabled: " + r100);
            return r100;
        L5:
            if (qc5.a.h() == true) goto L8;
            r100 = false;
            goto L9
        }

        @JvmStatic
        public static boolean b(SelectorScope r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            if (r100 != SelectorScope.ALL) goto L5;
        L8:
            boolean r101 = true;
        L9:
            tt5.a.h("IRootSelectData-MyLibrary", "isScopeSupported: " + r101);
            return r101;
        L5:
            if (r100 == SelectorScope.WIKI_ONLY) goto L8;
            r101 = false;
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
        return R.drawable.ud_icon_mywiki_colorful;
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
        Application r100 = eu5.b.f474075a;
        int r101 = jq5.a.f500067a;
        return r100.getString(R.string.LarkCCM_CM_MyLib_Menu);
    }

    public o(SelectorScope r100) {
        Intrinsics.checkNotNullParameter(r100, "selectorScope");
        this.f241191a = r100;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        if (r100.f23452g.n1().hasBenefit("common_wiki_node_management") == true) goto L5;
        return false;
    L5:
        boolean r101 = a.b(this.f241191a);
        boolean r102 = a.a();
        String r103 = dq5.j.a(r100);
        tt5.a.h("IRootSelectData-MyLibrary", "isVisible, scopeEnable: " + r101 + ", fgEnable: " + r102 + ", cachedMyLibraryId: " + r103);
        if (r101 == false) goto L18;
        if (r102 == true) goto L9;
        return false;
    L9:
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
        goto L15
    L18:
        return false;
    }
}
