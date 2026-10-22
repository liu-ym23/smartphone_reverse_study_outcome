package com.bytedance.locallife.dito.core.manager;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.core.adapter.DitoAdapter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.log.error.BODY_UPDATE_ERROR;
import com.bytedance.locallife.dito.utils.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoUpdateData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f257945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f257946d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f257947a;

        public b(Function0<Unit> r100) {
            this.f257947a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f257947a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoUpdateData) == true) goto L8;
        return false;
    L8:
        DitoUpdateData r101 = (DitoUpdateData) r100;
        if (Intrinsics.areEqual(this.f257943a, r101.f257943a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257944b, r101.f257944b) == true) goto L15;
        return false;
    L15:
        if (this.f257945c == r101.f257945c) goto L18;
        return false;
    L18:
        if (this.f257946d == r101.f257946d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f257943a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.f257944b.hashCode()) * 31) + this.f257945c) * 31) + this.f257946d;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DitoUpdateData(containerType=" + this.f257943a + ", updateType=" + this.f257944b + ", startIndex=" + this.f257945c + ", length=" + this.f257946d + ')';
    }

    public final void update(final DitoAdapter r110, final DitoViewModel r111) {
        Intrinsics.checkNotNullParameter(r110, "adapter");
        Intrinsics.checkNotNullParameter(r111, "viewModel");
        rq6.a r100 = rq6.a.f538927a;
        r100.a("dito_log", "update adapter的数据大小 : " + ((ArrayList) r110.f257893c).size());
        r100.a("dito_log", "update: " + this);
        if (this.f257945c != (-1)) goto L6;
        r100.b("dito_log", "DitoUpdateData Index: error");
        j.k(r111, BODY_UPDATE_ERROR.f258452a, Log.getStackTraceString(new Exception("DitoUpdateData Index: error,adapter size:" + ((ArrayList) r110.f257893c).size() + ",startIndex==-1")), null, null, null, 28);
        return;
    L6:
        com.bytedance.locallife.dito.core.e r101 = r111.n().f258175q;
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        final boolean r103 = false;
    L12:
        Function0<Unit> r104 = new DitoUpdateData$update$doUpdate$1(this, r110, r103, r111);
        if (r103 == false) goto L23;
        RecyclerView r112 = r111.f258035a.f257790l;
        if (r112 != null) goto L17;
    L19:
        if (r102 == false) goto L23;
        RecyclerView r113 = r111.f258035a.f257790l;
        if (r113 == null) goto L25;
        r113.post(new b(r104));
        return;
    L25:
        return;
    L17:
        if (r112.isComputingLayout() != true) goto L19;
        r102 = true;
    L23:
        r104.invoke();
        return;
    L9:
        if (r101.f257907c != true) goto L11;
        r103 = true;
        goto L12
    }

    public DitoUpdateData(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "updateType");
        this.f257943a = r100;
        this.f257944b = r101;
        this.f257945c = r102;
        this.f257946d = r103;
    }
}
