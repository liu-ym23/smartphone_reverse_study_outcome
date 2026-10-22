package ov3;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.aibridge.locallife.api.AbsOpenLocalLifeMethodIDL;
import com.bytedance.applet.aibridge.locallife.impl.OpenLocalLifeMethod;
import com.larus.platform.api.f2;
import com.larus.platform.api.g5;
import com.larus.platform.api.h5;
import com.larus.utils.o0;
import f3.h;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements h5 {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ OpenLocalLifeMethod b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ AbsOpenLocalLifeMethodIDL.a d;
    public final /* synthetic */ h<AbsOpenLocalLifeMethodIDL.b> e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    public final void a(g5 r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        this.a.invoke();
    }

    public final void onFailure(int r5) {
        if (Intrinsics.areEqual(f2.a.l(), Boolean.TRUE) == false) goto L7;
        OpenLocalLifeMethod r6 = this.b;
        FragmentActivity r0 = this.c;
        AbsOpenLocalLifeMethodIDL.a r1 = this.d;
        h<AbsOpenLocalLifeMethodIDL.b> r2 = this.e;
        Set<String> r3 = OpenLocalLifeMethod.b;
        r6.getClass();
        OpenLocalLifeMethod.b(r0, r1, r2);
        return;
    L7:
        if (this.f == true) goto L9;
    L13:
        this.a.invoke();
        return;
    L9:
        if (o0.d(this.g) == false) goto L13;
        if (CollectionsKt.contains(OpenLocalLifeMethod.b, this.g) == false) goto L13;
        OpenLocalLifeMethod r7 = this.b;
        FragmentActivity r4 = this.c;
        AbsOpenLocalLifeMethodIDL.a r8 = this.d;
        h<AbsOpenLocalLifeMethodIDL.b> r9 = this.e;
        r7.getClass();
        OpenLocalLifeMethod.b(r4, r8, r9);
    }

    public c(a r1, OpenLocalLifeMethod r2, FragmentActivity r3, AbsOpenLocalLifeMethodIDL.a r4, h r5, boolean r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
