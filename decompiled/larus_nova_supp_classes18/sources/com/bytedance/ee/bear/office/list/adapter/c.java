package com.bytedance.ee.bear.office.list.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements nc5.a<DocumentListInfo> {
    public final /* synthetic */ OfficeSpaceTab a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ boolean[] e;
    public final /* synthetic */ Function0<Unit> f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ boolean i;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ Throwable c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public a(boolean[] r1, Fragment r2, Throwable r3, String r4, String r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            if (this.a[0] == true) goto L12;
            e r0 = e.a;
            Fragment r2 = this.b;
            Throwable r3 = this.c;
            String r4 = this.d;
            String r5 = this.e;
            boolean r6 = this.f;
            r0.getClass();
            FragmentActivity r1 = r2.getActivity();
            if (r1 != null) goto L8;
            return;
        L8:
            if (StringsKt.isBlank(r4) == false) goto L10;
            r4 = "office_my_root_folder";
        L10:
            q0.d(new com.bytedance.ee.bear.list.create.b(r1, new com.bytedance.ee.bear.list.create.m(r4, r5, "", r6), sbb.e.f.getType()), r3, r1.getString(2131889419));
            tt5.a.e("OfficeCreateFolderAction", "create folder failed", r3, false);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // nc5.a
    public final void onFailure(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        tt5.a.e("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_request_failed tab=" + this.a + " isFolderPage=" + this.b + " elapsed=" + (System.currentTimeMillis() - this.c), r10, false);
        FragmentActivity r0 = this.d.getActivity();
        if (r0 == null) goto L6;
        r0.runOnUiThread(new a(this.e, this.d, r10, this.g, this.h, this.i));
        return;
    }

    @Override // nc5.a
    public final void onSuccess(DocumentListInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        tt5.a.h("OfficeCreateFolderAction", "[OfficeCreatePerf] stage=create_folder_request_success tab=" + this.a + " isFolderPage=" + this.b + " elapsed=" + (System.currentTimeMillis() - this.c));
        FragmentActivity r9 = this.d.getActivity();
        if (r9 == null) goto L6;
        r9.runOnUiThread(new d(this.e, this.d, this.a, this.b, this.f));
        return;
    }

    public c(OfficeSpaceTab r1, boolean r2, long r3, Fragment r5, boolean[] r6, Function0<Unit> r7, String r8, String r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
