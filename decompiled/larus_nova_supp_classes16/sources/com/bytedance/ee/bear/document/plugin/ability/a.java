package com.bytedance.ee.bear.document.plugin.ability;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bx4.b;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements r4 {
    public final DocumentPluginV3 a;
    public final MutableLiveData<r4.a> b;
    public final Lazy c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.ability.a$a, reason: collision with other inner class name */
    public static final class C0091a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final BearUrl getBearUrl() {
        return ((y3) this.c.getValue()).getBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final String getContainerUrl() {
        String r1 = ((y3) this.c.getValue()).getOriginBearUrl().b;
        String r0 = ((y3) this.c.getValue()).getOriginUrl();
        if (b.b(r1) == true) goto L5;
        return r0;
    L5:
        if (TextUtils.isEmpty("") == true) goto L9;
        Intrinsics.checkNotNull(r1);
        return StringsKt.replace$default(r0, r1, "", false, 4, null);
    L9:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final Fragment getFragment() {
        return this.a.getHost().getFragment();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final BearUrl getOriginBearUrl() {
        return ((y3) this.c.getValue()).getOriginBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final String getOriginUrl() {
        return ((y3) this.c.getValue()).getOriginUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final HashMap<String, Object> getReportCommonParams() {
        return ((d) org.koin.java.a.c(d.class, null, null, 6)).m("docCommonParams");
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final void startBrowserView() {
        ChameleonPluginHost r0 = this.a.getHost();
        if (r0 != null) goto L5;
    L16:
        tt5.a.k("DocumentFileCommonAbility", "startShare when not active !");
        return;
    L5:
        if (r0.getUIContainer() == null) goto L16;
        String r2 = getContainerUrl();
        if (TextUtils.isEmpty(r2) == false) goto L18;
        tt5.a.k("DocumentFileCommonAbility", "origin url is empty !");
        return;
    L18:
        r0.getActivity().startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r2)));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        tt5.a.d("DocumentFileCommonAbility", "start intent activity fail: " + e);
    }

    @Override // com.bytedance.ee.bear.document.r4
    public final LiveData<r4.a> getLoadState() {
        return this.b;
    }

    public a(OfficeDocumentHostAbilityPlugin r2, MutableLiveData r3) {
        Intrinsics.checkNotNullParameter(r2, "documentPluginV3");
        Intrinsics.checkNotNullParameter(r3, "loadState");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new OfficeDocumentFileCommonAbility$documentMetadata$2(this));
    }
}
