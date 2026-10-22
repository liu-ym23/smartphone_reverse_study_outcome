package com.obric.assistant.card.layout.viewholder.style;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleSubtitleBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleSubtitleBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleSubTitleStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleSubtitleBinding> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lca.a f386475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f386477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f386478d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f386479e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f386480f;

        public a() {
            this(null, null, false, null, null, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386475a, r101.f386475a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386476b, r101.f386476b) == true) goto L15;
            return false;
        L15:
            if (this.f386477c == r101.f386477c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386478d, r101.f386478d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386479e, r101.f386479e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f386480f, r101.f386480f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f386475a.hashCode() * 31) + this.f386476b.hashCode()) * 31;
            if (this.f386477c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f386478d.hashCode()) * 31;
            Integer r103 = this.f386479e;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return ((r102 + r104) * 31) + this.f386480f.hashCode();
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.f386475a + ", title=" + this.f386476b + ", isTitleColorRed=" + this.f386477c + ", subTitle=" + this.f386478d + ", subTitleRightIconResId=" + this.f386479e + ", time=" + this.f386480f + ')';
        }

        public a(lca.a r100, String r101, boolean r102, String r103, String r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = new lca.a(null, null, 7);
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = "";
        L15:
            if ((r105 & 32) == 0) goto L17;
            r104 = "";
        L17:
            Intrinsics.checkNotNullParameter(r100, "avatarRes");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r103, "subTitle");
            Intrinsics.checkNotNullParameter(r104, "time");
            this.f386475a = r100;
            this.f386476b = r101;
            this.f386477c = r102;
            this.f386478d = r103;
            this.f386479e = null;
            this.f386480f = r104;
        }
    }

    public abstract a a4(Object r100);

    public AbsCardItemTitleSubTitleStyle(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.obric_card_item_style_title_subtitle, r110, false);
        int r100 = R.id.icon;
        SimpleDraweeView r101 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.icon);
        if (r101 == null) goto L15;
        ConstraintLayout r102 = (ConstraintLayout) r111;
        r100 = R.id.second_title;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r111, R.id.second_title);
        if (r103 == null) goto L15;
        r100 = R.id.second_title_right_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r111, R.id.second_title_right_icon);
        if (r104 == null) goto L15;
        r100 = R.id.time;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r111, R.id.time);
        if (r105 == null) goto L15;
        r100 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r111, R.id.title);
        if (r106 == null) goto L15;
        super(new ObricCardItemStyleTitleSubtitleBinding(r102, r101, r103, r104, r105, r106));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, T r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        a r105 = a4(r101);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386168b, r105.f386475a);
        ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386172f.setText(r105.f386476b);
        TextView r106 = ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386172f;
        Context r107 = getContext();
        if (r105.f386477c == false) goto L5;
        int r108 = R.color.obric_card_conditional_danger_50;
    L6:
        r106.setTextColor(ContextCompat.getColor(r107, r108));
        ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386169c.setText(r105.f386478d);
        ImageView r109 = ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386170d;
        Integer r110 = r105.f386479e;
        int r111 = 0;
        if (r110 == null) goto L9;
        int r112 = r110.intValue();
    L10:
        r109.setImageResource(r112);
        ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386171e.setText(r105.f386480f);
        ImageView r113 = ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386170d;
        Integer r114 = r105.f386479e;
        if (r114 == null) goto L13;
        int r115 = r114.intValue();
    L15:
        if (r115 != 0) goto L17;
        int r116 = 8;
    L18:
        r113.setVisibility(r116);
        TextView r117 = ((ObricCardItemStyleTitleSubtitleBinding) this.f386391a).f386171e;
        if (r105.f386480f.length() != 0) goto L21;
        boolean r118 = true;
    L22:
        if (r118 == false) goto L24;
        r111 = 8;
    L24:
        r117.setVisibility(r111);
        return;
    L21:
        r118 = false;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r115 = 0;
        goto L15
    L9:
        r112 = 0;
        goto L10
    L5:
        r108 = R.color.neutral_100;
        goto L6
    }
}
