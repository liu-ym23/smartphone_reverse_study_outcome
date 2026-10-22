package com.larksuite.component.ui.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b08.a;
import b08.b;
import b08.c;

/* JADX INFO: loaded from: classes24.dex */
public abstract class LarkListItemView extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284238a;

    public abstract View a(ViewGroup r100);

    public abstract void b();

    public LarkListItemView(Context r100) {
        super(r100);
        this.f284238a = new a();
        addView(a(this));
        b();
    }

    public LarkListItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f284238a = new a();
        addView(a(this));
        b();
    }

    public LarkListItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f284238a = new a();
        addView(a(this));
        b();
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b<? super V, ? super M> r102) {
        this.f284238a.registerModelBinder(r100, r101, r102);
    }
}
