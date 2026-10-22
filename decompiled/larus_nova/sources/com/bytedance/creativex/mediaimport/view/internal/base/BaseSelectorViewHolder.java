package com.bytedance.creativex.mediaimport.view.internal.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ%\u0010 \u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u001eH$¢\u0006\u0002\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseSelectorViewHolder;", "DATA", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "cancelView", "clickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "", "position", "Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "state", "", "cancelClickListener", "<init>", "(Landroid/view/View;Landroid/view/View;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getState", "()Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "setState", "(Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;)V", "bind", "mediaData", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseSelectorViewHolder$State;", "(Ljava/lang/Object;ILcom/bytedance/creativex/mediaimport/view/internal/base/BaseSelectorViewHolder$State;)V", "bindDataAndState", "State", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSelectorViewHolder<DATA> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DATA f203809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MaterialSelectedState f203810b;

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder$a$a, reason: collision with other inner class name */
        public static final class C2958a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MaterialSelectedState f203811a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final MaterialSelectedState f203812b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f203813c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C2958a) == true) goto L8;
                return false;
            L8:
                C2958a r101 = (C2958a) r100;
                if (this.f203811a == r101.f203811a) goto L12;
                return false;
            L12:
                if (this.f203812b == r101.f203812b) goto L15;
                return false;
            L15:
                if (this.f203813c == r101.f203813c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f203811a.hashCode() * 31) + this.f203812b.hashCode()) * 31;
                if (this.f203813c == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "Default(selectionViewState=" + this.f203811a + ", dataSelectedState=" + this.f203812b + ", isPartLoad=" + this.f203813c + ')';
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder.a
            public final boolean a() {
                return this.f203813c;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder.a
            public final MaterialSelectedState b() {
                return this.f203811a;
            }

            public C2958a(MaterialSelectedState r100, MaterialSelectedState r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "selectionViewState");
                Intrinsics.checkNotNullParameter(r101, "dataSelectedState");
                this.f203811a = r100;
                this.f203812b = r101;
                this.f203813c = r102;
            }
        }

        boolean a();

        MaterialSelectedState b();
    }

    public BaseSelectorViewHolder(View r100, View r101, k r102, l r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "cancelView");
        Intrinsics.checkNotNullParameter(r102, "clickListener");
        Intrinsics.checkNotNullParameter(r103, "cancelClickListener");
        super(r100);
        this.f203810b = MaterialSelectedState.NON_SELECTED;
        r100.setOnClickListener(new c1(this, this, r102));
        r101.setOnClickListener(new d1(this, this, r103));
    }
}
