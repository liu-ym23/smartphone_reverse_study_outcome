package com.bytedance.creativex.mediaimport.view.internal.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001(B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J%\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020%H$¢\u0006\u0002\u0010&RS\u0010\u0006\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0010\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaViewHolder;", "DATA", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "selectorView", "clickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "", "position", "Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "state", "", "selectorClickListener", "<init>", "(Landroid/view/View;Landroid/view/View;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "selectState", "getSelectState", "()Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "setSelectState", "(Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;)V", "supportMultiSelect", "", "getSupportMultiSelect", "()Z", "setSupportMultiSelect", "(Z)V", "bind", "mediaData", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaViewHolder$State;", "(Ljava/lang/Object;ILcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaViewHolder$State;)V", "bindDataAndState", "State", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMediaViewHolder<DATA> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<DATA, Integer, MaterialSelectedState, Unit> f203796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<DATA, Integer, MaterialSelectedState, Unit> f203797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DATA f203798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MaterialSelectedState f203799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f203800e;

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder$a$a, reason: collision with other inner class name */
        public static final class C2957a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MaterialSelectedState f203801a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f203802b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f203803c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f203804d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final boolean f203805e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final boolean f203806f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final boolean f203807g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final boolean f203808h;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C2957a) == true) goto L8;
                return false;
            L8:
                C2957a r101 = (C2957a) r100;
                if (this.f203801a == r101.f203801a) goto L12;
                return false;
            L12:
                if (this.f203802b == r101.f203802b) goto L15;
                return false;
            L15:
                if (this.f203803c == r101.f203803c) goto L18;
                return false;
            L18:
                if (this.f203804d == r101.f203804d) goto L21;
                return false;
            L21:
                if (this.f203805e == r101.f203805e) goto L24;
                return false;
            L24:
                if (this.f203806f == r101.f203806f) goto L27;
                return false;
            L27:
                if (this.f203807g == r101.f203807g) goto L30;
                return false;
            L30:
                if (this.f203808h == r101.f203808h) goto L32;
                return false;
            L32:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f203801a.hashCode() * 31) + this.f203802b) * 31;
                int r101 = 1231;
                if (this.f203803c == false) goto L5;
                int r102 = 1231;
            L6:
                int r103 = (r100 + r102) * 31;
                if (this.f203804d == false) goto L9;
                int r104 = 1231;
            L10:
                int r105 = (r103 + r104) * 31;
                if (this.f203805e == false) goto L13;
                int r106 = 1231;
            L14:
                int r107 = (r105 + r106) * 31;
                if (this.f203806f == false) goto L17;
                int r108 = 1231;
            L18:
                int r109 = (r107 + r108) * 31;
                if (this.f203807g == false) goto L21;
                int r110 = 1231;
            L22:
                int r111 = (r109 + r110) * 31;
                if (this.f203808h == true) goto L27;
                r101 = 1237;
            L27:
                return r111 + r101;
            L21:
                r110 = 1237;
                goto L22
            L17:
                r108 = 1237;
                goto L18
            L13:
                r106 = 1237;
                goto L14
            L9:
                r104 = 1237;
                goto L10
            L5:
                r102 = 1237;
                goto L6
            }

            public final String toString() {
                return "Default(selectedState=" + this.f203801a + ", selectionIndex=" + this.f203802b + ", isPartLoad=" + this.f203803c + ", selectable=" + this.f203804d + ", preselected=" + this.f203805e + ", supportMultiSelect=" + this.f203806f + ", collapsedMultiSelectConfirmed=" + this.f203807g + ", itemHolderUseCorner=" + this.f203808h + ')';
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final boolean a() {
                return this.f203803c;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final int b() {
                return this.f203802b;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final boolean c() {
                return this.f203805e;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final boolean d() {
                return this.f203804d;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final MaterialSelectedState e() {
                return this.f203801a;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final boolean f() {
                return this.f203807g;
            }

            @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder.a
            public final boolean g() {
                return this.f203806f;
            }

            public C2957a(MaterialSelectedState r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
                Intrinsics.checkNotNullParameter(r100, "selectedState");
                this.f203801a = r100;
                this.f203802b = r101;
                this.f203803c = r102;
                this.f203804d = r103;
                this.f203805e = r104;
                this.f203806f = r105;
                this.f203807g = r106;
                this.f203808h = r107;
            }
        }

        boolean a();

        int b();

        boolean c();

        boolean d();

        MaterialSelectedState e();

        boolean f();

        boolean g();
    }

    public abstract void T3(Object r100, int r101, a.C2957a r102);

    public BaseMediaViewHolder(View r100, View r101, Function3 r102, s0 r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "selectorView");
        Intrinsics.checkNotNullParameter(r102, "clickListener");
        Intrinsics.checkNotNullParameter(r103, "selectorClickListener");
        super(r100);
        this.f203796a = r102;
        this.f203797b = r103;
        this.f203799d = MaterialSelectedState.NON_SELECTED;
        this.f203800e = true;
        r100.setOnClickListener(new a1(this, this));
        r101.setOnClickListener(new b1(this, this));
    }
}
