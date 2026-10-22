package com.bytedance.bdp.appbase.network.dns;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class BdpDnsManager$preResolve$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ List $domains;

    public BdpDnsManager$preResolve$1(List r100, String r101) {
        this.$domains = r100;
        this.$appId = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        g94.b.d("BdpHttpDns", new Object[]{"preResolve", this.$domains});
        List r100 = this.$domains;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (a.f200880a.get((String) r103) == null) goto L8;
        boolean r104 = false;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = true;
        goto L9
    L11:
        int r105 = c.f200882a;
        String r106 = this.$appId;
        if (r101.isEmpty() == false) goto L14;
        List r107 = CollectionsKt.emptyList();
    L17:
        Iterator r108 = r107.iterator();
        if (r108.hasNext() == true) goto L20;
        return;
    L20:
        b r109 = (b) r108.next();
        g94.b.d("BdpHttpDns", new Object[]{"preResolve result", r109});
        r109.getClass();
        Collection r110 = (Collection) null;
        throw null;
    L14:
        ArrayList r111 = new ArrayList();
        Iterator r112 = CollectionsKt.chunked(r101, 6).iterator();
        if (r112.hasNext() == true) goto L22;
        r107 = r111;
        goto L17
    L22:
        c.a(r106, "https://dig.bdurl.net/q?host=" + CollectionsKt.joinToString$default((List) r112.next(), ",", null, null, 0, null, null, 62, null) + "&source=micro_app");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
