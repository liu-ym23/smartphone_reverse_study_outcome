package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import em5.h;
import em5.i;
import em5.k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiSearchFilterDataHolder extends em5.b {
    public final Context c;
    public final k d;
    public final i e;
    public final h f;
    public final em5.f g;

    @Override // em5.b
    public final em5.e a() {
        return new WikiSearchReloader(this);
    }

    @Override // em5.b
    public Context getContext() {
        return this.c;
    }

    public WikiSearchFilterDataHolder(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.c = r7;
        Context r0 = getContext();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getString(2131888810);
        if (r2 == null) goto L6;
    L7:
        k r8 = new k(r2);
        this.d = r8;
        Context r3 = getContext();
        if (r3 == null) goto L11;
        String r4 = r3.getString(2131888196);
        if (r4 == null) goto L11;
    L12:
        i r5 = new i(r4);
        this.e = r5;
        Context r6 = getContext();
        if (r6 == null) goto L16;
        String r9 = r6.getString(2131888022);
        if (r9 == null) goto L16;
    L17:
        h r10 = new h(r9);
        this.f = r10;
        Context r11 = getContext();
        if (r11 == null) goto L23;
        String r12 = r11.getString(2131888195);
        if (r12 == null) goto L23;
        r1 = r12;
    L23:
        em5.f r13 = new em5.f(r1);
        this.g = r13;
        ((ArrayList) this.b).add(r8);
        ((ArrayList) this.b).add(r5);
        ((ArrayList) this.b).add(r10);
        ((ArrayList) this.b).add(r13);
        return;
    L16:
        r9 = "";
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
        boolean r1 = true;
        ArrayList r3 = null;
        switch(r5.hashCode()) {
            case -1058114788: goto L60;
            case -287027157: goto L46;
            case -286430077: goto L29;
            case 797302193: goto L6;
            default: goto L81;
        };
    L81:
        return;
    L6:
        if (r5.equals("doc/type") == true) goto L9;
        return;
    L9:
        if ((r6 instanceof ArrayList) == false) goto L11;
        r3 = (ArrayList) r6;
    L11:
        if (r3 != null) goto L13;
    L16:
        if (r1 == true) goto L26;
        i r8 = this.e;
        if (r3.size() <= 0) goto L20;
        String r9 = r8.e + '(' + r3.size() + ')';
    L21:
        r8.d(r9);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r0 = r3.iterator();
    L23:
        if (r0.hasNext() == false) goto L25;
        r10.add(Integer.valueOf(((com.bytedance.ee.bear.search.picker.filter.type.e) r0.next()).b));
        goto L23
    L25:
        r8.e(r10);
    L27:
        r7.invoke(this.e);
        return;
    L20:
        r9 = r8.e;
        goto L21
    L26:
        this.e.c();
        goto L27
    L13:
        if (r3.isEmpty() == true) goto L16;
        r1 = false;
        goto L16
    L29:
        if (r5.equals("doc/in/wiki") == true) goto L32;
        return;
    L32:
        if ((r6 instanceof ArrayList) == false) goto L34;
        r3 = (ArrayList) r6;
    L34:
        if (r3 != null) goto L36;
    L39:
        if (r1 == true) goto L44;
        k r11 = this.d;
        r11.d(r11.e);
        r11.e(r3);
        SearchWikiSpaceInfo r12 = (SearchWikiSpaceInfo) CollectionsKt.first(r3);
        Bitmap r2 = com.bytedance.ee.bear.search.d.a(getContext(), 2131256279);
        ((ArrayList) ((cpc.a) r11).c).clear();
        if (r2 == null) goto L43;
        ((ArrayList) ((cpc.a) r11).c).add(r2);
    L43:
        r7.invoke(this.d);
        r11.d(r12.getTitle());
        return;
    L44:
        this.d.c();
        r7.invoke(this.d);
        return;
    L36:
        if (r3.isEmpty() == true) goto L39;
        r1 = false;
        goto L39
    L46:
        if (r5.equals("doc/in/chat") == true) goto L49;
        return;
    L49:
        if ((r6 instanceof ArrayList) == false) goto L51;
        r3 = (ArrayList) r6;
    L51:
        if (r3 != null) goto L53;
    L56:
        if (r1 == true) goto L58;
        final em5.f r13 = this.g;
        r13.d(r13.e);
        r13.e((ArrayList) r6);
        SearchBaseInfo r14 = (SearchBaseInfo) CollectionsKt.first(r3);
        em5.b.b(getContext(), r14.getAvatarKey(), r14.getId(), new WikiSearchFilterDataHolder$updateSearchFilterData$4$1$1(r13, r7, this));
        return;
    L58:
        this.g.c();
        r7.invoke(this.g);
        return;
    L53:
        if (r3.isEmpty() == true) goto L56;
        r1 = false;
        goto L56
    L60:
        if (r5.equals("doc/owner") == true) goto L63;
        return;
    L63:
        if ((r6 instanceof ArrayList) == false) goto L65;
        r3 = (ArrayList) r6;
    L65:
        if (r3 != null) goto L67;
    L70:
        if (r1 == true) goto L72;
        final h r15 = this.f;
        r15.d(r15.e);
        r15.e((ArrayList) r6);
        SearchChatterInfo r16 = (SearchChatterInfo) CollectionsKt.first(r3);
        em5.b.b(getContext(), r16.getAvatarKey(), r16.getId(), new WikiSearchFilterDataHolder$updateSearchFilterData$3$1$1(r15, r7, this));
        return;
    L72:
        this.f.c();
        r7.invoke(this.f);
        return;
    L67:
        if (r3.isEmpty() == true) goto L70;
        r1 = false;
        goto L70
    }
}
