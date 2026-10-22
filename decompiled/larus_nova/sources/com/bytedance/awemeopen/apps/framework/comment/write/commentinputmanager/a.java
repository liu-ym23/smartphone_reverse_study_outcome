package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import jy3.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<E extends jy3.a> extends az3.a<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f194420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ManagerContext f194421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public E f194422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2797a f194423f;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a$a, reason: collision with other inner class name */
    public static final class C2797a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<E> f194424a;

        public C2797a(a<E> r100) {
            this.f194424a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c
        public final View a(String r100) {
            hy3.b r101 = this.f194424a.f194421d.f194409g;
            if (r101 == null) goto L7;
            Map<String, View> r102 = r101.f487633d;
            if (r102 == null) goto L7;
            return (View) ((LinkedHashMap) r102).get(r100);
        L7:
            return null;
        }
    }

    public void E() {
    }

    public void G() {
    }

    @Override // az3.a
    public /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r100) {
        F((c) r100);
    }

    public void F(c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        super.A(r100);
    }

    public a(ManagerContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f194420c = r101;
        this.f194421d = r100;
        this.f194423f = new C2797a(this);
    }

    public final void H(Class r100, xy3.c r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        LifecycleOwner r102 = this.f194421d.f561864b.f195172d;
        if (r102 == null) goto L6;
        xy3.a.c(r100, r101, r102);
        return;
    }
}
