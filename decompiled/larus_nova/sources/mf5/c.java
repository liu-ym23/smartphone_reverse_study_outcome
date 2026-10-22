package mf5;

import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f513628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f513629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> f513630c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, SharePermissionViewModel r101, Function2<? super Boolean, ? super Boolean, Unit> r102) {
        this.f513628a = r100;
        this.f513629b = r101;
        this.f513630c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HashMap r101 = (HashMap) r100;
        IDocUserPermission r102 = (IDocUserPermission) r101.get(this.f513628a);
        Map<String, IDocUserPermission> r103 = this.f513629b.f232156f;
        Intrinsics.checkNotNull(r101);
        r103.putAll(r101);
        Function2<Boolean, Boolean, Unit> r104 = this.f513630c;
        boolean r105 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L19;
        if (r102 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == true) goto L16;
    L18:
        boolean r108 = false;
    L20:
        Boolean r109 = Boolean.valueOf(r108);
        IDocUserPermission r110 = this.f513629b.f232155e;
        if (r110 != null) goto L23;
    L25:
        r104.invoke(r109, Boolean.valueOf(r105));
        return;
    L23:
        if (r110.canManageCollaborator() != true) goto L25;
        r105 = true;
        goto L25
    L16:
        if (r102.canPerceive() == false) goto L18;
    L11:
        if (r102.canRead() == true) goto L13;
        r107 = true;
    L19:
        r108 = true;
        goto L20
    L5:
        if (r102.canRead() != true) goto L7;
        r106 = true;
        goto L8
    }
}
