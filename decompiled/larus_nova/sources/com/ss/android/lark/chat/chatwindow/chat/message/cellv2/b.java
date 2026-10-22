package com.ss.android.lark.chat.chatwindow.chat.message.cellv2;

import android.content.Context;
import android.view.View;
import b3b.f;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import kotlin.jvm.internal.Intrinsics;
import v4b.c;
import v4b.d;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b<Data, PatchData> implements i<Data, PatchData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f412671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f412672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m2b.a f412673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f412674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f412675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f412676f;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<Data> f412677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b<Data, PatchData> f412678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Data f412679c;

        public a(m<Data> r100, b<Data, PatchData> r101, Data r102) {
            this.f412677a = r100;
            this.f412678b = r101;
            this.f412679c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            m<Data> r101 = this.f412677a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 != null) goto L10;
            return false;
        L10:
            return r102.e(this.f412678b, this.f412679c);
        L5:
            r102 = null;
            goto L6
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final Class<PatchData> b() {
        return null;
    }

    @Override // com.ss.android.lark.blueprint.i
    public abstract /* synthetic */ void update(m<Data> r100, q<Data> r101, Data r102);

    public final Context getContext() {
        return this.f412672b;
    }

    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f412671a = r100;
        this.f412672b = r100.getContext();
        i3b.d r101 = (i3b.d) r100.f410652c.a(i3b.d.class);
        c r102 = null;
        if (r101 == null) goto L5;
        m2b.a r103 = r101.a();
    L6:
        if (r103 == null) goto L21;
        this.f412673c = r103;
        i3b.d r104 = (i3b.d) r100.f410652c.a(i3b.d.class);
        if (r104 == null) goto L10;
        f r105 = r104.g();
    L11:
        this.f412674d = r105;
        i3b.d r106 = (i3b.d) r100.f410652c.a(i3b.d.class);
        if (r106 == null) goto L14;
        d r107 = r106.j();
    L15:
        this.f412675e = r107;
        i3b.d r108 = (i3b.d) r100.f410652c.a(i3b.d.class);
        if (r108 == null) goto L18;
        r102 = r108.b();
    L18:
        this.f412676f = r102;
        return;
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L21:
        throw new IllegalStateException("chatContext is null".toString());
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.blueprint.i
    public void a(m<Data> r100, q<Data> r101) {
        i.a.a(r100, r101);
    }

    public final void f(View r100, m<Data> r101, Data r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r102, "data");
        r100.setOnLongClickListener(new a(r101, this, r102));
    }

    public final void g(q r100, j r101, IMMessageKeys$Slots r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "slotId");
        k<?> r103 = r100.o(r101, r102);
        if (r103 == null) goto L6;
        this.f412671a.f410653d.b(r101, k.class, r103);
        return;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, q r101, Object r102, Object r103) {
        i.a.b(this, r100, r101, r102, r103);
    }
}
