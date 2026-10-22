package com.bytedance.locallife.bridge.common.method;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public final class v extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f257082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f257083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<ko6.o.c> f257084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f257085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f257086e;

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onLocalNewestVersion(LocalPackageModel r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getChannel();
    L7:
        if (TextUtils.equals(r101, this.f257082a) == false) goto L10;
        w.i(this.f257083b, this.f257084c, this.f257085d, true, null);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        if (w.h(this.f257083b, r100, this.f257086e, this.f257082a) == false) goto L10;
        w r102 = this.f257083b;
        CompletionBlock<ko6.o.c> r103 = this.f257084c;
        AtomicBoolean r104 = this.f257085d;
        StringBuilder r105 = new StringBuilder("checkServerVersionFail,");
        if (r101 == null) goto L7;
        String r106 = r101.getMessage();
    L8:
        r105.append(r106);
        w.i(r102, r103, r104, false, r105.toString());
        return;
    L7:
        r106 = null;
        goto L8
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        boolean r102 = w.h(this.f257083b, r100, this.f257086e, this.f257082a);
        if (r101 == null) goto L19;
        List<UpdatePackage> r103 = r101.get(this.f257086e);
        if (r103 == null) goto L19;
        List<UpdatePackage> r104 = r103;
        String r105 = this.f257082a;
        boolean r106 = true;
        if ((r104 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L10;
        if (TextUtils.equals(((UpdatePackage) r107.next()).getChannel(), r105) == false) goto L13;
        boolean r108 = true;
    L17:
        if (r108 != true) goto L19;
    L20:
        if (r102 == true) goto L27;
        if (r106 == true) goto L28;
        w.i(this.f257083b, this.f257084c, this.f257085d, false, "checkServerVersionSuccess, but not found channel");
        return;
    L28:
        return;
    L27:
        return;
    L10:
        r108 = false;
        goto L17
    L9:
        if (r104.isEmpty() == false) goto L11;
    L19:
        r106 = false;
        goto L20
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getChannel();
    L7:
        if (TextUtils.equals(r103, this.f257082a) == false) goto L13;
        w r104 = this.f257083b;
        CompletionBlock<ko6.o.c> r105 = this.f257084c;
        AtomicBoolean r106 = this.f257085d;
        StringBuilder r107 = new StringBuilder("updateFailed,");
        if (r101 == null) goto L11;
        r102 = r101.getMessage();
    L11:
        r107.append(r102);
        w.i(r104, r105, r106, false, r107.toString());
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getChannel();
    L7:
        if (TextUtils.equals(r102, this.f257082a) == false) goto L10;
        w.i(this.f257083b, this.f257084c, this.f257085d, true, null);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckRequestIntercept(int r100, Map<String, List<Pair<String, Long>>> r101, Throwable r102) {
        if (w.h(this.f257083b, r101, this.f257086e, this.f257082a) == false) goto L10;
        w r103 = this.f257083b;
        CompletionBlock<ko6.o.c> r104 = this.f257084c;
        AtomicBoolean r105 = this.f257085d;
        StringBuilder r106 = new StringBuilder("checkRequestIntercept,");
        if (r102 == null) goto L7;
        String r107 = r102.getMessage();
    L8:
        r106.append(r107);
        w.i(r103, r104, r105, false, r106.toString());
        return;
    L7:
        r107 = null;
        goto L8
    }

    public v(String r100, w r101, v56.a r102, AtomicBoolean r103, String r104) {
        this.f257082a = r100;
        this.f257083b = r101;
        this.f257084c = r102;
        this.f257085d = r103;
        this.f257086e = r104;
    }
}
