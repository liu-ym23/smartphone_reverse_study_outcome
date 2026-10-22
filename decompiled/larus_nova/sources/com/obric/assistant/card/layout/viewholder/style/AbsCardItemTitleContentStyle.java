package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleContentBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.NoteEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleContentBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleContentStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleContentBinding> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lca.a f386455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f386456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f386457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f386458d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f386459e;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r100 = 0 == true ? 1 : 0;
            Object[] r101 = 0 == true ? 1 : 0;
            this(null, r100, r101, 31);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386455a, r101.f386455a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386456b, r101.f386456b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386457c, r101.f386457c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386458d, r101.f386458d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f386459e, r101.f386459e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f386455a.hashCode() * 31;
            Integer r101 = this.f386456b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((r100 + r102) * 31) + this.f386457c.hashCode()) * 31) + this.f386458d.hashCode()) * 31) + this.f386459e.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.f386455a + ", avatarCoverResId=" + this.f386456b + ", title=" + this.f386457c + ", content=" + this.f386458d + ", time=" + this.f386459e + ')';
        }

        public /* synthetic */ a(lca.a r100, String r110, String r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r100 = new lca.a(null, null, 7);
        L5:
            lca.a r101 = r100;
            if ((r112 & 4) == 0) goto L8;
            String r102 = "";
        L10:
            if ((r112 & 8) == 0) goto L12;
            String r103 = "";
        L14:
            if ((r112 & 16) == 0) goto L16;
            String r104 = "";
        L17:
            this(r101, null, r102, r103, r104);
            return;
        L16:
            r104 = null;
            goto L17
        L12:
            r103 = r111;
            goto L14
        L8:
            r102 = r110;
            goto L10
        }

        public a(lca.a r100, Integer r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "avatarRes");
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r103, "content");
            Intrinsics.checkNotNullParameter(r104, "time");
            this.f386455a = r100;
            this.f386456b = r101;
            this.f386457c = r102;
            this.f386458d = r103;
            this.f386459e = r104;
        }
    }

    public abstract a a4(Object r100);

    public AbsCardItemTitleContentStyle(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r111 = LayoutInflater.from(r110.getContext()).inflate(R.layout.obric_card_item_style_title_content, r110, false);
        int r100 = R.id.content_group;
        RelativeLayout r101 = (RelativeLayout) ViewBindings.findChildViewById(r111, R.id.content_group);
        if (r101 == null) goto L17;
        r100 = R.id.icon;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.icon);
        if (r102 == null) goto L17;
        r100 = R.id.icon_cover;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r111, R.id.icon_cover);
        if (r103 == null) goto L17;
        ConstraintLayout r104 = (ConstraintLayout) r111;
        r100 = R.id.second_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r111, R.id.second_title);
        if (r105 == null) goto L17;
        r100 = R.id.time;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r111, R.id.time);
        if (r106 == null) goto L17;
        r100 = R.id.title;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r111, R.id.title);
        if (r112 == null) goto L17;
        super(new ObricCardItemStyleTitleContentBinding(r104, r101, r102, r103, r104, r105, r106, r112));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, T r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        a r105 = a4(r101);
        boolean r106 = r101 instanceof NoteEntity;
        int r107 = 0;
        if (r106 == false) goto L5;
        int r108 = 0;
    L6:
        RelativeLayout r109 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386155b;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L52;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        r111.setMarginStart(r108);
        r109.setLayoutParams(r111);
        SimpleDraweeView r112 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386156c;
        if (r106 == false) goto L11;
        int r113 = 8;
    L12:
        r112.setVisibility(r113);
        SimpleDraweeView r114 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386156c;
        if (r106 == false) goto L15;
        lca.a r115 = null;
    L16:
        AbsCardItemBaseStyle.Z3(r114, r115);
        ImageView r116 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386157d;
        Integer r117 = r105.f386456b;
        if (r117 == null) goto L19;
        int r118 = r117.intValue();
    L20:
        r116.setImageResource(r118);
        ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386161h.setText(r105.f386457c);
        boolean r119 = true;
        ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386159f.setText(StringsKt.trim(r105.f386458d, new char[]{'\n'}));
        ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386160g.setText(r105.f386459e);
        ImageView r120 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386157d;
        if (r105.f386456b == null) goto L25;
        if (r106 == true) goto L25;
        int r121 = 0;
    L26:
        r120.setVisibility(r121);
        TextView r122 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386160g;
        if (r105.f386459e.length() != 0) goto L29;
        boolean r123 = true;
    L30:
        if (r123 == false) goto L32;
        int r124 = 8;
    L33:
        r122.setVisibility(r124);
        String r125 = r105.f386458d;
        if (r125 != null) goto L36;
    L39:
        if (r119 == false) goto L41;
        int r126 = 8;
    L42:
        ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386159f.setVisibility(r126);
        TextView r127 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386161h;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 == null) goto L50;
        RelativeLayout.LayoutParams r129 = (RelativeLayout.LayoutParams) r128;
        if (r126 != 8) goto L47;
        r107 = -1;
    L47:
        r129.addRule(15, r107);
        r127.setLayoutParams(r129);
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L41:
        r126 = 0;
        goto L42
    L36:
        if (r125.length() == 0) goto L39;
        r119 = false;
        goto L39
    L32:
        r124 = 0;
        goto L33
    L29:
        r123 = false;
    L25:
        r121 = 8;
        goto L26
    L19:
        r118 = 0;
        goto L20
    L15:
        r115 = r105.f386455a;
        goto L16
    L11:
        r113 = 0;
        goto L12
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r108 = ((ObricCardItemStyleTitleContentBinding) this.f386391a).f386158e.getResources().getDimensionPixelSize(R.dimen.dp_12);
        goto L6
    }
}
