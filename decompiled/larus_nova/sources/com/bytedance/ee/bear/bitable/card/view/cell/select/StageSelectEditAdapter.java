package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0014\u0010\u0006\u001a\u00060\u0007R\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/StageSelectEditAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectEditAdapter;", "<init>", "()V", "getLayoutRes", "", "createOptionHolder", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectEditAdapter$OptionHolder;", "view", "Landroid/view/View;", "StageOptionHolder", "Companion", "StageColorOverride", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageSelectEditAdapter extends SelectEditAdapter {

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f208112d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f208113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f208114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f208115c;

        public static final class a {

            /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.select.StageSelectEditAdapter$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C3004a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f208116a = null;

                static {
                    int[] r100 = new int[StageType.values().length];
                    r100[StageType.EndDone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[StageType.EndCancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[StageType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f208116a = r100;
                }
            }

            public static b a(int r100, int r101, View r102) {
                return new b(ContextCompat.getColor(r102.getContext(), r100), ContextCompat.getColor(r102.getContext(), r101), ContextCompat.getColor(r102.getContext(), R.color.static_white));
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f208113a == r101.f208113a) goto L12;
            return false;
        L12:
            if (this.f208114b == r101.f208114b) goto L15;
            return false;
        L15:
            if (this.f208115c == r101.f208115c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f208113a * 31) + this.f208114b) * 31) + this.f208115c;
        }

        public final String toString() {
            return "StageColorOverride(backgroundColor=" + this.f208113a + ", borderColor=" + this.f208114b + ", textColor=" + this.f208115c + ')';
        }

        public b(int r100, int r101, int r102) {
            this.f208113a = r100;
            this.f208114b = r101;
            this.f208115c = r102;
        }
    }

    public final class c extends SelectEditAdapter.OptionHolder {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f208117a = null;

            static {
                int[] r100 = new int[StageType.values().length];
                r100[StageType.EndDone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[StageType.EndCancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[StageType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f208117a = r100;
            }
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.OptionHolder
        public final void U3() {
        }

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            super(r100);
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter.OptionHolder
        public final void T3(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r110) {
            Intrinsics.checkNotNullParameter(r110, "optionEntity");
            BaseTagSize r100 = BaseTagSize.LARGE;
            View r101 = this.itemView.findViewById(R.id.cell_item);
            if (r101 != null) goto L5;
            return;
        L5:
            StageType.a r102 = StageType.Companion;
            String r103 = r110.f207148h;
            r102.getClass();
            StageType r104 = StageType.a.a(r103);
            int r105 = b.f208112d;
            View r106 = this.itemView;
            Intrinsics.checkNotNullParameter(r104, "stageType");
            Intrinsics.checkNotNullParameter(r106, "view");
            int r107 = b.a.C3004a.f208116a[r104.ordinal()];
            if (r107 == 1) goto L13;
            if (r107 == 2) goto L12;
            if (r107 != 3) goto L11;
            b r108 = null;
        L14:
            com.bytedance.ee.bear.bitable.card.view.cell.stage.a.d(r101, r100);
            if (r108 == null) goto L17;
            com.bytedance.ee.bear.bitable.card.view.cell.stage.a.a(r101, r100, r108.f208113a, r108.f208114b);
        L18:
            TextView r109 = (TextView) r101.findViewById(R.id.tv_name);
            if (r109 == null) goto L27;
            r109.setText(r110.f207142b);
            if (r108 == null) goto L53;
            r109.setTextColor(r108.f208115c);
            goto L27
        L53:
            r109.setTextColor(ColorUtils.h(r110.f207145e));     // Catch: Exception -> L25
        L25:
            e = move-exception;
            tt5.a.e("StageSelectEditAdapter", "parse color failed!", e, false);
        L27:
            ImageView r111 = (ImageView) r101.findViewById(R.id.icon_done);
            RingView r112 = (RingView) r101.findViewById(R.id.icon_ring);
            if (r112 == null) goto L30;
            com.bytedance.ee.bear.bitable.card.view.cell.stage.a.c(r112, r100);
        L30:
            Context r113 = this.itemView.getContext();
            int r114 = a.f208117a[r104.ordinal()];
            if (r114 == 1) goto L48;
            if (r114 == 2) goto L42;
            if (r114 != 3) goto L41;
            if (r111 == null) goto L36;
            r111.setVisibility(8);
        L36:
            if (r112 == null) goto L38;
            r112.setVisibility(0);
        L38:
            if (r112 == null) goto L55;
            r112.a(ContextCompat.getColor(r113, R.color.ud_O350), ContextCompat.getColor(r113, R.color.ud_O200));
            return;
        L55:
            return;
        L41:
            throw new NoWhenBranchMatchedException();
        L42:
            if (r111 == null) goto L44;
            r111.setVisibility(8);
        L44:
            if (r112 == null) goto L46;
            r112.setVisibility(0);
        L46:
            if (r112 == null) goto L57;
            r112.a(ContextCompat.getColor(r113, R.color.ud_R500), ContextCompat.getColor(r113, R.color.ud_R300));
            return;
        L57:
            return;
        L48:
            if (r111 == null) goto L50;
            r111.setVisibility(0);
        L50:
            if (r112 == null) goto L59;
            r112.setVisibility(8);
            return;
        L59:
            return;
        L17:
            com.bytedance.ee.bear.bitable.card.view.cell.stage.a.b(r101, r100, r110.f207144d, r110.f207146f);
            goto L18
        L11:
            throw new NoWhenBranchMatchedException();
        L12:
            r108 = b.a.a(R.color.ud_R400, R.color.ud_R500, r106);
            goto L14
        L13:
            r108 = b.a.a(R.color.ud_G350, R.color.ud_G400, r106);
            goto L14
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter
    public final int z2() {
        return R.layout.bitable_card_select_edit_stage_option_item;
    }

    public StageSelectEditAdapter() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter
    public final SelectEditAdapter.OptionHolder y2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return new c(r100);
    }
}
