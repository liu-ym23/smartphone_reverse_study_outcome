package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricCardItemStyleScheduleBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleScheduleBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemScheduleStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleScheduleBinding> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lca.a f386450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f386451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f386452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CharSequence f386453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CharSequence f386454e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386450a, r101.f386450a) == true) goto L12;
            return false;
        L12:
            if (this.f386451b == r101.f386451b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386452c, r101.f386452c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386453d, r101.f386453d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386454e, r101.f386454e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f386450a.hashCode() * 31) + this.f386451b) * 31) + this.f386452c.hashCode()) * 31) + this.f386453d.hashCode()) * 31) + this.f386454e.hashCode();
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.f386450a + ", avatarCoverResId=" + this.f386451b + ", name=" + this.f386452c + ", subLine1=" + this.f386453d + ", subLine2=" + this.f386454e + ')';
        }

        public a(lca.a r100, int r101, String r102, CharSequence r103, CharSequence r104) {
            Intrinsics.checkNotNullParameter(r100, "iconRes");
            Intrinsics.checkNotNullParameter(r102, "name");
            Intrinsics.checkNotNullParameter(r103, "subLine1");
            Intrinsics.checkNotNullParameter(r104, "subLine2");
            this.f386450a = r100;
            this.f386451b = r101;
            this.f386452c = r102;
            this.f386453d = r103;
            this.f386454e = r104;
        }

        public /* synthetic */ a(lca.a r100, String r101, CharSequence r102, CharSequence r110, int r111) {
            if ((r111 & 4) == 0) goto L5;
            String r103 = "";
        L7:
            if ((r111 & 8) == 0) goto L9;
            CharSequence r104 = "";
        L11:
            if ((r111 & 16) == 0) goto L13;
            CharSequence r105 = "";
        L14:
            this(r100, 0, r103, r104, r105);
            return;
        L13:
            r105 = r110;
            goto L14
        L9:
            r104 = r102;
            goto L11
        L5:
            r103 = r101;
            goto L7
        }
    }

    public abstract a a4(Object r100);

    public AbsCardItemScheduleStyle(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.obric_card_item_style_schedule, r100, false);
        int r102 = R.id.icon;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.icon);
        if (r103 == null) goto L13;
        r102 = R.id.name;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.name);
        if (r104 == null) goto L13;
        ConstraintLayout r105 = (ConstraintLayout) r101;
        r102 = R.id.subLine1;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.subLine1);
        if (r106 == null) goto L13;
        r102 = R.id.subLine2;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.subLine2);
        if (r107 == null) goto L13;
        super(new ObricCardItemStyleScheduleBinding(r105, r103, r104, r106, r107));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, T r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        a r105 = a4(r101);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleScheduleBinding) this.f386391a).f386150b, r105.f386450a);
        TextView r106 = ((ObricCardItemStyleScheduleBinding) this.f386391a).f386151c;
        String r107 = r105.f386452c;
        boolean r108 = true;
        int r109 = 0;
        if (r107.length() != 0) goto L5;
        boolean r110 = true;
    L6:
        if (r110 == false) goto L8;
        r107 = "无主题";
    L8:
        r106.setText(r107);
        ((ObricCardItemStyleScheduleBinding) this.f386391a).f386152d.setText(r105.f386453d);
        ((ObricCardItemStyleScheduleBinding) this.f386391a).f386153e.setText(r105.f386454e);
        TextView r111 = ((ObricCardItemStyleScheduleBinding) this.f386391a).f386152d;
        CharSequence r112 = r105.f386453d;
        if (r112 != null) goto L11;
    L14:
        boolean r113 = true;
    L16:
        if (r113 == false) goto L18;
        int r114 = 8;
    L19:
        r111.setVisibility(r114);
        TextView r115 = ((ObricCardItemStyleScheduleBinding) this.f386391a).f386153e;
        CharSequence r116 = r105.f386454e;
        if (r116 != null) goto L22;
    L25:
        if (r108 == false) goto L27;
        r109 = 8;
    L27:
        r115.setVisibility(r109);
        return;
    L22:
        if (r116.length() == 0) goto L25;
        r108 = false;
        goto L25
    L18:
        r114 = 0;
        goto L19
    L11:
        if (r112.length() == 0) goto L14;
        r113 = false;
        goto L16
    L5:
        r110 = false;
        goto L6
    }
}
