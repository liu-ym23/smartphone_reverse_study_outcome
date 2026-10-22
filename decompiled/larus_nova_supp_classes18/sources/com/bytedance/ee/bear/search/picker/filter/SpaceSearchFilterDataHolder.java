package com.bytedance.ee.bear.search.picker.filter;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.search.d;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import em5.e;
import em5.f;
import em5.g;
import em5.h;
import em5.i;
import em5.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceSearchFilterDataHolder extends em5.b {
    public final Context c;
    public final String d;
    public final j e;
    public final i f;
    public final g g;
    public final h h;
    public final f i;

    @Override // em5.b
    public final e a() {
        return new SpaceSearchReloader(this);
    }

    @Override // em5.b
    public Context getContext() {
        return this.c;
    }

    public SpaceSearchFilterDataHolder(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        this.c = r8;
        String r9 = "";
        this.d = "";
        j r0 = new j();
        Context r1 = getContext();
        if (r1 == null) goto L6;
        String r2 = r1.getString(2131888181);
        if (r2 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ((cpc.a) r0).b = r2;
        ((cpc.a) r0).d = false;
        this.e = r0;
        Context r3 = getContext();
        if (r3 == null) goto L11;
        String r4 = r3.getString(2131888196);
        if (r4 == null) goto L11;
    L12:
        i r5 = new i(r4);
        this.f = r5;
        g r6 = new g(getContext().getString(2131888809));
        this.g = r6;
        Context r7 = getContext();
        if (r7 == null) goto L16;
        String r10 = r7.getString(2131888022);
        if (r10 == null) goto L16;
    L17:
        h r11 = new h(r10);
        this.h = r11;
        Context r12 = getContext();
        if (r12 == null) goto L23;
        String r13 = r12.getString(2131888195);
        if (r13 == null) goto L23;
        r9 = r13;
    L23:
        f r14 = new f(r9);
        this.i = r14;
        ArrayList r15 = (ArrayList) this.b;
        r15.add(r0);
        r15.add(r6);
        r15.add(r5);
        r15.add(r11);
        r15.add(r14);
        this.d = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().uid;
        return;
    L16:
        r10 = "";
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    @Override // em5.b
    public final void c(String r5, Object r6, final Function1<? super cpc.a, Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r7, "loadCallback");
        ArrayList r1 = null;
        boolean r2 = false;
        switch(r5.hashCode()) {
            case -1058114788: goto L77;
            case -862523263: goto L45;
            case -287027157: goto L32;
            case 797302193: goto L10;
            case 1502331690: goto L6;
            default: goto L98;
        };
    L98:
        return;
    L6:
        if (r5.equals("doc/my_own") == false) goto L99;
        j r8 = this.e;
        r8.e = !r8.e;
        r7.invoke(r8);
        return;
    L99:
        return;
    L10:
        if (r5.equals("doc/type") == true) goto L13;
        return;
    L13:
        if ((r6 instanceof ArrayList) == false) goto L15;
        r1 = (ArrayList) r6;
    L15:
        if (r1 != null) goto L17;
    L18:
        r2 = true;
    L19:
        if (r2 == true) goto L29;
        i r9 = this.f;
        if (r1.size() <= 0) goto L23;
        String r10 = r9.e + '(' + r1.size() + ')';
    L24:
        r9.d(r10);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r0 = r1.iterator();
    L26:
        if (r0.hasNext() == false) goto L28;
        r11.add(Integer.valueOf(((com.bytedance.ee.bear.search.picker.filter.type.e) r0.next()).b));
        goto L26
    L28:
        r9.e(r11);
    L30:
        r7.invoke(this.f);
        return;
    L23:
        r10 = r9.e;
        goto L24
    L29:
        this.f.c();
        goto L30
    L17:
        if (r1.isEmpty() == false) goto L19;
    L32:
        if (r5.equals("doc/in/chat") == true) goto L35;
        return;
    L35:
        if ((r6 instanceof ArrayList) == false) goto L37;
        r1 = (ArrayList) r6;
    L37:
        if (r1 != null) goto L39;
    L40:
        r2 = true;
    L41:
        if (r2 == true) goto L43;
        final f r12 = this.i;
        r12.d(r12.e);
        r12.e((ArrayList) r6);
        SearchBaseInfo r13 = (SearchBaseInfo) CollectionsKt.first(r1);
        em5.b.b(getContext(), r13.getAvatarKey(), r13.getId(), new SpaceSearchFilterDataHolder$updateSearchFilterData$3$1$1(r12, r7, this));
        return;
    L43:
        this.i.c();
        r7.invoke(this.i);
        return;
    L39:
        if (r1.isEmpty() == false) goto L41;
    L45:
        if (r5.equals("doc/in/folder") == true) goto L48;
        return;
    L48:
        if ((r6 instanceof ArrayList) == false) goto L50;
        r1 = (ArrayList) r6;
    L50:
        if (r1 != null) goto L52;
    L55:
        boolean r14 = true;
    L56:
        if (r14 == true) goto L75;
        g r15 = this.g;
        if ((!r1.isEmpty()) == false) goto L64;
        SearchSpaceInfo r3 = (SearchSpaceInfo) CollectionsKt.first(r1);
        if (r3 == null) goto L63;
        String r4 = r3.getTitle();
        if (r4 == null) goto L63;
    L65:
        r15.d(r4);
        r15.e((ArrayList) r6);
        SearchSpaceInfo r16 = (SearchSpaceInfo) CollectionsKt.first(r1);
        Context r17 = getContext();
        Boolean r18 = r16.getIsShareFolder();
        if (r18 == null) goto L68;
        r2 = r18.booleanValue();
    L68:
        if (r2 == false) goto L70;
        int r19 = 2131254672;
    L71:
        Bitmap r20 = d.a(r17, kac.a.b(r19));
        ((ArrayList) ((cpc.a) r15).c).clear();
        if (r20 == null) goto L74;
        ((ArrayList) ((cpc.a) r15).c).add(r20);
    L74:
        r7.invoke(this.g);
        return;
    L70:
        r19 = 2131254639;
    L63:
        r4 = r15.e;
        goto L65
    L64:
        r4 = r15.e;
        goto L65
    L75:
        this.g.c();
        r7.invoke(this.g);
        return;
    L52:
        if (r1.isEmpty() == true) goto L55;
        r14 = false;
        goto L56
    L77:
        if (r5.equals("doc/owner") == true) goto L80;
        return;
    L80:
        if ((r6 instanceof ArrayList) == false) goto L82;
        r1 = (ArrayList) r6;
    L82:
        if (r1 != null) goto L84;
    L85:
        r2 = true;
    L86:
        if (r2 == true) goto L88;
        final h r21 = this.h;
        r21.d(r21.e);
        r21.e((ArrayList) r6);
        SearchChatterInfo r22 = (SearchChatterInfo) CollectionsKt.first(r1);
        em5.b.b(getContext(), r22.getAvatarKey(), r22.getId(), new SpaceSearchFilterDataHolder$updateSearchFilterData$2$1$1(r21, r7, this));
        return;
    L88:
        this.h.c();
        r7.invoke(this.h);
        return;
    L84:
        if (r1.isEmpty() == false) goto L86;
        goto L85
    }
}
