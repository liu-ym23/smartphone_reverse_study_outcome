package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import jy3.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<E extends jy3.a> extends az3.a<c> {
    public final String c;
    public final ManagerContext d;
    public E e;
    public final C0070a f;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a$a, reason: collision with other inner class name */
    public static final class C0070a implements c {
        public final /* synthetic */ a<E> a;

        public C0070a(a<E> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c
        public final View a(String r2) {
            hy3.b r0 = this.a.d.g;
            if (r0 == null) goto L7;
            Map<String, View> r1 = r0.d;
            if (r1 == null) goto L7;
            return (View) ((LinkedHashMap) r1).get(r2);
        L7:
            return null;
        }
    }

    public void E() {
    }

    public void G() {
    }

    @Override // az3.a
    public /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r1) {
        F((c) r1);
    }

    public void F(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewProvider");
        super.A(r2);
    }

    public a(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r3;
        this.d = r2;
        this.f = new C0070a(this);
    }

    public final void H(Class r2, xy3.c r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "ability");
        LifecycleOwner r0 = this.d.b.d;
        if (r0 == null) goto L6;
        xy3.a.c(r2, r3, r0);
        return;
    }
}
