package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ SharePermissionViewModel b;
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r1, SharePermissionViewModel r2, Function2<? super Boolean, ? super Boolean, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        HashMap r6 = (HashMap) r5;
        IDocUserPermission r0 = (IDocUserPermission) r6.get(this.a);
        Map<String, IDocUserPermission> r1 = this.b.f;
        Intrinsics.checkNotNull(r6);
        r1.putAll(r6);
        Function2<Boolean, Boolean, Unit> r7 = this.c;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L19;
        if (r0 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L16;
    L18:
        boolean r8 = false;
    L20:
        Boolean r9 = Boolean.valueOf(r8);
        IDocUserPermission r10 = this.b.e;
        if (r10 != null) goto L23;
    L25:
        r7.invoke(r9, Boolean.valueOf(r2));
        return;
    L23:
        if (r10.canManageCollaborator() != true) goto L25;
        r2 = true;
        goto L25
    L16:
        if (r0.canPerceive() == false) goto L18;
    L11:
        if (r0.canRead() == true) goto L13;
        r4 = true;
    L19:
        r8 = true;
        goto L20
    L5:
        if (r0.canRead() != true) goto L7;
        r3 = true;
        goto L8
    }
}
