package j20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f496905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f496906b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<String> r100 = this.f496905a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public a(InteractGameFeedbackDialog.b r100) {
        this.f496906b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<String> r103 = this.f496905a;
        if (r103 == null) goto L6;
        String r104 = (String) ListProtector.get(r103, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "tag");
        r102.f496907a.setText(r104);
        r102.itemView.setTag(r104);
        r102.itemView.setSelected(false);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_interact_game_feedback_tag, r100, false);
        r102.setOnClickListener(this.f496906b);
        return new b(r102);
    }
}
