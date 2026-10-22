package erb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements drb.a<AllAtBean, AtSelectableViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f473651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f473652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IItemContainer f473653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IItemContainer.a f473654e;

    public b(IItemContainer r100) {
        this.f473653d = r100;
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(AllAtBean r100) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r100) {
        Context r101 = r100.getContext();
        this.f473651b = r101;
        return new AtSelectableViewHolder(LayoutInflater.from(r101).inflate(R.layout.item_chat_at_select, r100, false));
    }

    @Override // drb.a
    public final void c(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102) {
        AtSelectableViewHolder r103 = (AtSelectableViewHolder) r100;
        AllAtBean r104 = (AllAtBean) r101;
        if (this.f473651b != null) goto L5;
        this.f473651b = r103.itemView.getContext();
    L5:
        this.f473652c = this.f473653d.y0();
        this.f473654e = this.f473653d.a0();
        r103.mTagWrapper.setVisibility(8);
        r103.mUserStatus.setVisibility(8);
        r103.mWorkStatus.setVisibility(8);
        if (this.f473652c != 0) goto L9;
        r103.mNameTV.setText(r104.getDisplayName());
        r103.mDividerView.setVisibility(8);
        r103.mOwnerTV.setVisibility(0);
        r103.mOwnerTV.setText(R.string.Lark_Legacy_NotifyAllMembersInChat);
        r103.mOwnerTV.setTextColor(y9c.d.c(this.f473651b, R.color.text_caption));
        r103.mAtSelectCheckBox.setVisibility(8);
        int r105 = drb.a.f469801a;
        r104.showAvatar(this.f473651b, r103.mSingleAvatarIV, r105, r105);
        a r106 = new a(this, r104);
        r103.itemView.setOnClickListener(r106);
        return;
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102, List r103) {
        AtSelectableViewHolder r104 = (AtSelectableViewHolder) r100;
        AllAtBean r105 = (AllAtBean) r101;
    }
}
