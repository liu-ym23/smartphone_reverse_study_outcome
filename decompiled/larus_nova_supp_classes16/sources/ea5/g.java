package ea5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends UDBaseListDialogAdapter {
    public final /* synthetic */ List i;
    public final /* synthetic */ TTVideoView j;

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r1, r2);
    }

    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r3, int r4) {
        super.y2(r3, r4);
        ((RecyclerView.ViewHolder) r3).itemView.setBackgroundResource(2131234042);
        ImageView r5 = (ImageView) ((RecyclerView.ViewHolder) r3).itemView.findViewById(2131370348);
        if (TextUtils.equals(this.j.t, (CharSequence) ListProtector.get(this.i, r4)) == false) goto L5;
        int r6 = 0;
    L6:
        r5.setVisibility(r6);
        return;
    L5:
        r6 = 8;
        goto L6
    }

    public g(TTVideoView r1, Context r2, List r3) {
        this.j = r1;
        this.i = r3;
        super(r2);
    }
}
