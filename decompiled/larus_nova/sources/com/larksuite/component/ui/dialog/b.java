package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.b;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b<T extends b> extends d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DialogInterface.OnClickListener f284126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UDActionPanelBuilder f284127g;

    public class a extends g {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ b f284128h;

        public a(b r100, Context r101) {
            this.f284128h = r100;
            super(r101);
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
        public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, final UDDialog r101) {
            super.apply(r100, r101);
            if (this.f284128h.f284126f == null) goto L6;
            this.f284862a = new com.larksuite.component.ui.dialog.a(this, r101);
            return;
        }
    }

    public b(Context r100) {
        super(r100);
        UDActionPanelBuilder r101 = new UDActionPanelBuilder(r100);
        this.f284127g = r101;
        this.f284132c = r101;
        this.f284133d = new a(this, r100);
    }

    public final void l(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        h r103 = (h) r102.next();
        r101.add(new UDBaseListDialogBuilder.ListItemBuilder(r103.f284136a).textColorRes(r103.f284137b).build());
        goto L4
    L6:
        this.f284127g.itemList(r101);
    }

    public final void m(int r100) {
        this.f284127g.itemLayout(r100);
        if (r100 == (-1)) goto L6;
        this.f284127g.adapter(new UDBaseListDialogAdapterWrapper(this.f284130a, r100));
        return;
    }

    public final void n(CharSequence... r100) {
        if (r100 != null) goto L4;
        ArrayList r101 = null;
    L8:
        l(r101);
        return;
    L4:
        ArrayList r102 = new ArrayList(r100.length);
        int r103 = r100.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        CharSequence r105 = r100[r104];
        h r106 = new h();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r106.f284136a = r105;
        r102.add(r106);
        r104 = r104 + 1;
        goto L5
    L7:
        r101 = r102;
        goto L8
    }
}
