package com.ss.android.ugc.tools.view.widget.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.tools.view.widget.state.CommonUiState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/LoadMoreRecyclerViewAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/FooterRecyclerViewAdapter;", "Lcom/ss/android/ugc/tools/view/widget/state/a;", "Lcom/ss/android/ugc/tools/view/widget/state/CommonUiState;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class LoadMoreRecyclerViewAdapter extends FooterRecyclerViewAdapter implements com.ss.android.ugc.tools.view.widget.state.a<CommonUiState> {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f455131a;

        public a(LoadMoreRecyclerViewAdapter r100) {
            this.f455131a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f455131a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract RecyclerView.ViewHolder A2();

    public abstract void z2();

    @Override // com.ss.android.ugc.tools.view.widget.adapter.FooterRecyclerViewAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        z2();
        r100.itemView.post(new a(this));
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.FooterRecyclerViewAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return A2();
    }

    @Override // com.ss.android.ugc.tools.view.widget.state.a
    public final void setState(Enum r100) {
        Intrinsics.checkNotNullParameter((CommonUiState) r100, "state");
        notifyItemChanged(getItemCount() - 1);
    }
}
