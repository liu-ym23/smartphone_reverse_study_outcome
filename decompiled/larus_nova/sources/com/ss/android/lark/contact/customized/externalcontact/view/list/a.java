package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> f419221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> f419222b;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.view.list.a$a, reason: collision with other inner class name */
    public interface InterfaceC4935a {
        void a(String r100);

        void b(View r100, long r101);
    }

    public a() {
    }

    public abstract void a(IndexRecyclerViewAdapter r100, OfficeExternalContactFragment$initExternalContactView$actionHandler$1 r101);

    public abstract boolean b(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.Adapter<? extends RecyclerView.ViewHolder> c(l9b.a r100);

    public abstract IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> d();

    public abstract int f(CommonRecyclerView r100);

    public abstract void g(List<? extends T> r100);

    public final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> e() {
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> r100 = this.f419222b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        return null;
    L6:
        return r100;
    }
}
