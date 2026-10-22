package com.larus.bmhome.view.textview.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tt8.c;
import ut8.g;

/* JADX INFO: loaded from: classes26.dex */
public final class SelectorRestore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f317437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, c> f317438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f317439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larus.bmhome.chat.component.bottom.reference.a f317440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f317441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectorRestore$outClearStoreListener$1 f317442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SelectorRestore$touchHideSelectorListener$1 f317443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public tt8.a f317444h;

    public static final class a implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectorRestore f317445a;

        @Override // ut8.g.a
        public final void b() {
        }

        @Override // ut8.g.a
        public final void onStart() {
            SelectorRestore r100 = this.f317445a;
            Map<String, c> r101 = r100.f317438b;
            LinkedHashMap r102 = (LinkedHashMap) r101;
            c r103 = (c) r102.get(r100.f317437a);
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.f547562c != true) goto L7;
        L8:
            if (r104 == false) goto L18;
            SelectorRestore r105 = this.f317445a;
            if (r105.f317439c == false) goto L19;
            com.larus.bmhome.chat.component.bottom.reference.a r106 = r105.f317440d;
            if (r106 != null) goto L14;
        L16:
            ((LinkedHashMap) this.f317445a.f317438b).clear();
            this.f317445a.f317439c = false;
            return;
        L14:
            if (r106.i9() == false) goto L16;
            r106.sZ();
            goto L16
        L19:
            return;
        L18:
            return;
        L7:
            r104 = false;
            goto L8
        }

        @Override // ut8.g.a
        public final void onStop() {
            SelectorRestore r100 = this.f317445a;
            Map<String, c> r101 = r100.f317438b;
            LinkedHashMap r102 = (LinkedHashMap) r101;
            c r103 = (c) r102.get(r100.f317437a);
            boolean r104 = false;
            if (r103 != null) goto L5;
        L7:
            if (r104 == false) goto L12;
            SelectorRestore r105 = this.f317445a;
            if (r105.f317439c == true) goto L13;
            r105.f317439c = true;
            return;
        L13:
            return;
        L12:
            return;
        L5:
            if (r103.f547562c != true) goto L7;
            r104 = true;
            goto L7
        }

        public a(SelectorRestore r100) {
            this.f317445a = r100;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.textview.impl.SelectorRestore$outClearStoreListener$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.view.textview.impl.SelectorRestore$touchHideSelectorListener$1] */
    public SelectorRestore() {
        this.f317438b = new LinkedHashMap();
        this.f317442f = new SelectorRestore$outClearStoreListener$1(this);
        this.f317443g = new SelectorRestore$touchHideSelectorListener$1(this);
        g r100 = new g();
        this.f317441e = r100;
        a r101 = new a(this);
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.f551689b = r101;
    }
}
