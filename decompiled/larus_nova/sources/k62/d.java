package k62;

import ak6.g;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelGiftViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wb2.h;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelGiftViewHolder f501952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f501953b;

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f501953b;
        SpannableString r102 = r100.f4074a;
        int r103 = 0;
        Object[] r104 = r102.getSpans(0, r102.length(), h.class);
        int r105 = r104.length;
    L3:
        if (r103 >= r105) goto L5;
        h r106 = (h) r104[r103];
        r106.f558922a = this.f501952a.f134336d;
        r103 = r103 + 1;
        goto L3
    L5:
        Unit r107 = Unit.INSTANCE;
        r101.setText(r102);
    }

    public d(ChatChannelGiftViewHolder r100, TextView r101) {
        this.f501952a = r100;
        this.f501953b = r101;
    }
}
