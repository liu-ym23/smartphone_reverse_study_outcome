package com.larksuite.component.card.component.personlist;

import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements com.larksuite.component.card.component.personlist.avatar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonListLynxUI f283508a;

    public static final class a implements com.larksuite.component.card.component.personlist.avatar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonListLynxUI f283509a;

        @Override // com.larksuite.component.card.component.personlist.avatar.b
        public final void a() {
            PersonListTextView r100 = (PersonListTextView) PersonListLynxUI.M(this.f283509a);
            if (r100 == null) goto L6;
            r100.postInvalidate();
            return;
        }

        public a(PersonListLynxUI r100) {
            this.f283509a = r100;
        }
    }

    public f(PersonListLynxUI r100) {
        this.f283508a = r100;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, wy7.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "userMap");
        Iterator<Map.Entry<String, wy7.c>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        wy7.c r102 = r101.next().getValue();
        if (r102 == null) goto L8;
        String r103 = r102.f561885a;
    L9:
        if (r103 == null) goto L4;
        Lazy<SimpleUserLoader> r104 = SimpleUserLoader.f283460d;
        SimpleUserLoader.a.a().c(r102.f561885a, new a(this.f283508a));
        goto L4
    L8:
        r103 = null;
        goto L9
    }
}
