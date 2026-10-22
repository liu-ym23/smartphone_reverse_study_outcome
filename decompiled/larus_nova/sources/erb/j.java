package erb;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtLabelViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements drb.a<LabelAtBean, AtLabelViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f473674b;

    public j() {
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(LabelAtBean r100) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r100) {
        Context r101 = r100.getContext();
        this.f473674b = r101;
        return new AtLabelViewHolder(LayoutInflater.from(r101).inflate(R.layout.item_chat_at_label, r100, false));
    }

    @Override // drb.a
    public final void c(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102) {
        AtLabelViewHolder r103 = (AtLabelViewHolder) r100;
        LabelAtBean r104 = (LabelAtBean) r101;
        if (this.f473674b != null) goto L5;
        this.f473674b = r103.itemView.getContext();
    L5:
        r103.mLabelTV.setBackgroundColor(y9c.d.c(this.f473674b, r104.getBgColorResId()));
        r103.mLabelTV.setTextSize(r104.getTextSize());
        TextView r105 = r103.mLabelTV;
        r105.setPadding(r105.getPaddingLeft(), r104.getVerticalPadding(), r103.mLabelTV.getPaddingRight(), r104.getVerticalPadding());
        if (TextUtils.isEmpty(r104.getSubLabel()) == false) goto L8;
        r103.mLabelTV.setText(r104.getDisplayName());
        return;
    L8:
        String r106 = r104.getDisplayName();
        String r107 = r104.getSubLabel();
        SpannableStringBuilder r108 = new SpannableStringBuilder();
        r108.append(r106).append(tb2.c.DEFAULT_TEXT).append(r107);
        int r109 = r106.length() + 2;
        r108.setSpan(new ForegroundColorSpan(y9c.d.c(this.f473674b, R.color.text_caption)), r109, r107.length() + r109, 33);
        r103.mLabelTV.setText(r108);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102, List r103) {
        AtLabelViewHolder r104 = (AtLabelViewHolder) r100;
        LabelAtBean r105 = (LabelAtBean) r101;
    }
}
