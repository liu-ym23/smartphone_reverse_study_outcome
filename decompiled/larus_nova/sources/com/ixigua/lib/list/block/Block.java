package com.ixigua.lib.list.block;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.ixigua.lib.list.ListAgency;
import com.ixigua.lib.list.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0004¨\u0006\u000b"}, d2 = {"Lcom/ixigua/lib/list/block/Block;", "P", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "", "Landroid/content/Context;", "getContext", "Landroid/content/res/Resources;", "getResources", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liblist_release"}, k = 1, mv = {1, 4, 0})
public abstract class Block<P> implements AsyncLayoutInflater.OnInflateFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f278504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public P f278505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<BlockViewHolder<?>> f278506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f278507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f278508e;

    public static final class a {
    }

    static {
    }

    public abstract void b();

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    public final Context getContext() {
        WeakReference<BlockViewHolder<?>> r100 = this.f278506c;
        Context r101 = null;
        if (r100 == null) goto L5;
        BlockViewHolder<?> r102 = r100.get();
    L6:
        if (r102 == null) goto L8;
        d r103 = r102.f278526d;
    L9:
        if (r103 == null) goto L13;
        Context r104 = r103.a();
        if (r104 == null) goto L13;
        r101 = r104;
    L16:
        if (r101 != null) goto L21;
        ListAgency.f278497d.getClass();
        r101 = ListAgency.f278496c;
        if (r101 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
    L21:
        return r101;
    L13:
        View r105 = this.f278508e;
        if (r105 == null) goto L16;
        r101 = r105.getContext();
        goto L16
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final String toString() {
        ListAgency.f278497d.getClass();
        return super.toString();
    }

    public Block() {
        this.f278504a = new Bundle();
    }

    public final Resources getResources() {
        Context r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getResources();
    }

    public static void a(View r100) {
        ViewParent r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L10;
        r101 = r102;
    L10:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L18;
        r103.removeView(r100);     // Catch: Exception -> L14
        return;
    L14:
        ListAgency.f278497d.getClass();
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        ListAgency r103 = ListAgency.f278497d;
        r103.getClass();
        this.f278507d = false;
        this.f278508e = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        WeakReference<BlockViewHolder<?>> r104 = this.f278506c;
        if (r104 == null) goto L8;
        BlockViewHolder<?> r105 = r104.get();
    L9:
        if (r105 == null) goto L21;
        a(this.f278508e);
        View r106 = this.f278508e;
        if (r106 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r105.f278515f.put(this, r106);
        r103.getClass();
        r105.Z3();
        if (this.f278505b == null) goto L22;
        b();     // Catch: Throwable -> L17
        return;
    L17:
        ListAgency.f278497d.getClass();
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r105 = null;
        goto L9
    }
}
