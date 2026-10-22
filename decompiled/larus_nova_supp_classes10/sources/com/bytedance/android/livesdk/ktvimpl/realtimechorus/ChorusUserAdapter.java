package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/ChorusUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/SingerInfoViewHolder;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusUserAdapter extends RecyclerView.Adapter<SingerInfoViewHolder> {
    public List<b> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public ChorusUserAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        SingerInfoViewHolder r6 = (SingerInfoViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        b r7 = (b) ListProtector.get(this.a, r5);
        if (r7 == null) goto L26;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        HSImageView r0 = r6.a;
        IBaseUser r1 = r7.b;
        if (r1 == null) goto L7;
        py.k r2 = r1.getAvatarThumbKt();
    L8:
        boolean r3 = false;
        ImageUtil.loadImage(r0, r2, 0);
        TextView r8 = r6.b;
        if (r8 == null) goto L17;
        IBaseUser r9 = r7.b;
        if (r9 == null) goto L15;
        String r10 = r9.getNickName();
        if (r10 == null) goto L15;
    L16:
        r8.setText(r10);
    L15:
        r10 = "";
    L17:
        CheckBox r11 = r6.c;
        if (r11 == null) goto L27;
        UserChorusInfo r12 = r7.a;
        if (r12 == null) goto L24;
        Boolean r13 = r12.isNeedPushRtc();
        if (r13 == null) goto L24;
        r3 = r13.booleanValue();
    L24:
        r11.setChecked(r3);
        return;
    L27:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new SingerInfoViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565115, r3, false));
    }
}
