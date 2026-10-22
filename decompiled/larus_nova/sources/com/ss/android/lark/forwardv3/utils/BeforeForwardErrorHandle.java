package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
public final class BeforeForwardErrorHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f425526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f425527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f425528c;

    public static final class a {
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f425529a;

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r100) {
            if (r100 != 260008) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 260009) goto L8;
            return false;
        }

        public final Context getContext() {
            return this.f425529a;
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f425529a = r100;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r100) {
            Log.i("BeforeForwardHandle", "forward before forward failed: external permission invalid");
            if (r100 != null) goto L5;
            r100 = UIUtils.getString(this.f425529a, R.string.Lark_Contacts_CantCompleteOperationNoExternalCommunicationPermission);
        L5:
            Context r101 = this.f425529a;
            Intrinsics.checkNotNull(r100);
            UDToast.show(r101, r100);
        }
    }

    public static final class c implements d {
        public c() {
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r100) {
            if (r100 != 4052) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r100) {
            Log.e("BeforeForwardHandle", "forward before forward failed: no im permission");
            ForwardModuleV3.a().showNoIMPermissionDialog(r100);
        }
    }

    public interface d {
        boolean a(int r100);

        void b(String r100);
    }

    public static final class e implements d {
        public e() {
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r100) {
            if (260000 <= r100) goto L5;
        L7:
            return false;
        L5:
            if (r100 > 260007) goto L7;
            return true;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r100) {
            Log.i("BeforeForwardHandle", "forward before forward failed: contact invalid");
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f425526a;
    }

    public BeforeForwardErrorHandle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f425526a = r100;
        this.f425527b = LazyKt.lazy(new BeforeForwardErrorHandle$scope$2(this));
        CopyOnWriteArrayList<d> r101 = new CopyOnWriteArrayList();
        r101.add(new c());
        r101.add(new e());
        r101.add(new b(r100));
        this.f425528c = r101;
    }

    public final void a(int r100, String r110, Function0 r111) {
        if (((CoroutineScope) this.f425527b.getValue()) != null) goto L6;
        Log.e("BeforeForwardHandle", "life scope is null");
        return;
    L6:
        Iterator<d> r101 = this.f425528c.iterator();
    L8:
        if (r101.hasNext() == false) goto L15;
        d r102 = r101.next();
        if (r102.a(r100) == false) goto L8;
        CoroutineScope r103 = (CoroutineScope) this.f425527b.getValue();
        if (r103 == null) goto L20;
        BuildersKt.launch$default(r103, null, null, new BeforeForwardErrorHandle$handle$2$1(r102, r110, null), 3, null);
        return;
    L20:
        return;
    L15:
        ((Boolean) r111.invoke()).booleanValue();
    }
}
