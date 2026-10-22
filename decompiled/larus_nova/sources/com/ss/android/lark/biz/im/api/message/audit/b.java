package com.ss.android.lark.biz.im.api.message.audit;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<e>> f410327a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final List<IMFileEntity> I8() {
        int r100 = AuthorityParam.f409659j;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("admin.policycenter.imfilecontrol") == false) goto L5;
        ArrayList r101 = new ArrayList();
        Iterator<WeakReference<e>> r102 = this.f410327a.iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        e r103 = r102.next().get();
        if (r103 == null) goto L8;
        List<AuthorityParam> r104 = r103.getAuthFileEntities();
        Log.d("AuthResourceManager", "getAuthRequiredFileEntities from ".concat(r103.getClass().getSimpleName()));
        Iterator<AuthorityParam> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L8;
        AuthorityParam r106 = r105.next();
        if ((!r106.f409667h.isEmpty()) == true) goto L17;
        int r107 = AuthorityParam.f409659j;
        r101.add(AuthorityParam.Companion.c(r106, null));
        goto L14
    L17:
        Iterator<T> r108 = r106.f409667h.iterator();
    L19:
        if (r108.hasNext() == false) goto L14;
        String r109 = (String) r108.next();
        int r110 = AuthorityParam.f409659j;
        r101.add(AuthorityParam.Companion.c(r106, r109));
        goto L19
    L22:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    @Inject
    public b() {
        this.f410327a = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final void Cb(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Iterator<WeakReference<e>> r101 = this.f410327a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r100, r101.next().get()) == false) goto L4;
        return;
    L8:
        Log.d("AuthResourceManager", "registerProvider : ".concat(r100.getClass().getSimpleName()));
        this.f410327a.add(new WeakReference(r100));
    }

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final void Z9(final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Log.d("AuthResourceManager", "unregisterProvider : ".concat(r100.getClass().getSimpleName()));
        CollectionsKt.removeAll(this.f410327a, new AuthResourceUserScopeManager$unregisterProvider$1(r100));
    }
}
