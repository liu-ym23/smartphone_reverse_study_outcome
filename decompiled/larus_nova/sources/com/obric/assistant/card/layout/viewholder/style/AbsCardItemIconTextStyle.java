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
import com.obric.assistant.card.databinding.ObricCardItemStyleIconTextBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleIconTextBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "", "isDeleted", "", "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle$StyleData;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemIconTextStyle<T extends AppEntity> extends AbsCardItemBaseStyle<T, ObricCardItemStyleIconTextBinding> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lca.a f386448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386449b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386448a, r101.f386448a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386449b, r101.f386449b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f386448a.hashCode() * 31) + this.f386449b.hashCode();
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.f386448a + ", text=" + this.f386449b + ')';
        }

        public a(lca.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "iconRes");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f386448a = r100;
            this.f386449b = r101;
        }
    }

    public abstract a a4(AppEntity r100);

    public AbsCardItemIconTextStyle(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.obric_card_item_style_icon_text, r100, false);
        int r102 = R.id.icon;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.icon);
        if (r103 == null) goto L10;
        ConstraintLayout r104 = (ConstraintLayout) r101;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.text);
        if (r105 == null) goto L8;
        super(new ObricCardItemStyleIconTextBinding(r104, r103, r105));
        return;
    L8:
        r102 = R.id.text;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, Object r101, int r102, boolean r103, boolean r104) {
        AppEntity r105 = (AppEntity) r101;
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        Intrinsics.checkNotNullParameter(r105, "entity");
        a r106 = a4(r105);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleIconTextBinding) this.f386391a).f386147b, r106.f386448a);
        ((ObricCardItemStyleIconTextBinding) this.f386391a).f386148c.setText(StringsKt.trim(r106.f386449b, new char[]{'\n'}));
    }
}
