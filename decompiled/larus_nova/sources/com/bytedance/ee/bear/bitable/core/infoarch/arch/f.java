package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.bitable.core.infoarch.BitableInfoArchManagerNew;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableInfoArchManagerNew f210255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f210256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f210257c;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f210258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f210259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f210260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f210261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f210262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SceneModel f210263f;

        public b() {
        }
    }

    static {
    }

    public f(BitableInfoArchManagerNew r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f210255a = r100;
        this.f210256b = new b();
        this.f210257c = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.dashboard.enable.swipe_pop_fullscreen");
        r100.f210181g.f210221h.setBackground(AppCompatResources.getDrawable(r100.getContext(), R.drawable.bitable_pin_bg_with_radius));
    }

    public final void a(boolean r100) {
        Boolean r101 = this.f210256b.f210259b;
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L6;
        return;
    L6:
        if (this.f210257c == true) goto L8;
    L10:
        ViewHolder r103 = this.f210255a.f210181g;
        Intrinsics.checkNotNullParameter(r103, "viewHolder");
        ViewGroup r104 = r103.f210216c;
        if (r100 == false) goto L13;
        int r105 = 0;
    L14:
        r104.setVisibility(r105);
        return;
    L13:
        r105 = 8;
        goto L14
    L8:
        if (Intrinsics.areEqual(this.f210256b.f210260c, r102) == false) goto L10;
    }
}
