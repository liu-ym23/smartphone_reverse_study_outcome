package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiTreePlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0<T> implements Observer {
    public final /* synthetic */ WikiTreeCtrlView.d a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WikiAction.values().length];
            r0[WikiAction.INIT_LOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[WikiAction.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[WikiAction.DEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[WikiAction.MOV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[WikiAction.MAKE_COPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[WikiAction.FAVORITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[WikiAction.UNFAVORITE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[WikiAction.SHORTCUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[WikiAction.PUSH_DEL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[WikiAction.PUSH_MOV.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[WikiAction.PUSH_BATCH_MOV.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[WikiAction.PUSH_DES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public u0(WikiTreePlugin.d r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r6 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h) r5;
        if ((r6 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == false) goto L20;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r0 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r6;
        WikiAction r1 = r0.a;
        switch(a.a[r1.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L20;
        };
    L7:
        this.a.p();
        goto L20
    L8:
        this.a.i(r0.n, r0.l, r0.p);
        goto L20
    L9:
        this.a.k(r0.n, r0.k, r0.p);
        goto L20
    L10:
        this.a.j(r0.i);
        goto L20
    L11:
        this.a.o(r0.n, r0.m, r0.o);
        goto L20
    L12:
        this.a.q(r0.r);
        goto L20
    L13:
        this.a.b(r0.q);
        goto L20
    L14:
        this.a.g(r0.n, r0.g, r0.o);
        goto L20
    L15:
        this.a.h(r0.n, r0.k, r0.p);
        goto L20
    L16:
        this.a.n(r0.i);
        goto L20
    L17:
        this.a.e(r0.g, r0.b);
        goto L20
    L18:
        this.a.l();
    L20:
        if ((r6 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) == false) goto L25;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r7 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) r6;
        if (r7.a != WikiAction.INIT_LOAD) goto L26;
        this.a.a(r7.d);
        return;
    L26:
        return;
    }
}
