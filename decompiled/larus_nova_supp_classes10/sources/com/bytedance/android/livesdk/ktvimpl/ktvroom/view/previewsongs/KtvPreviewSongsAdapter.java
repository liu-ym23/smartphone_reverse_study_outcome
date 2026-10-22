package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/previewsongs/KtvPreviewSongsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/previewsongs/KtvPreviewSongsViewHolder;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPreviewSongsAdapter extends RecyclerView.Adapter<KtvPreviewSongsViewHolder> {
    public static final TranslateAnimation e = null;
    public static final AlphaAnimation f = null;
    public final List<MusicPanel> a;
    public final AnimationSet b;
    public final boolean c;
    public final boolean d;

    public static final class a {
    }

    static {
        TranslateAnimation r1 = new TranslateAnimation(0.0f, 0.0f, s1.f(20.0f), 0.0f);
        long r3 = (long) 437.5d;
        r1.setDuration(r3);
        long r5 = (long) 271.25d;
        r1.setStartOffset(r5);
        e = r1;
        AlphaAnimation r0 = new AlphaAnimation(0.0f, 1.0f);
        r0.setDuration(r3);
        r0.setStartOffset(r5);
        f = r0;
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final void y2(List<MusicPanel> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        String r0 = "KtvPreviewSongsAdapter setContent:" + r4.size();
        ALogger.i(bb0.b.b(), r0 + ", invoke class :KtvPreviewSongsAdapter");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r4);
        notifyDataSetChanged();
    }

    public KtvPreviewSongsAdapter(boolean r1, boolean r2) {
        this.c = r1;
        this.d = r2;
        this.a = new ArrayList();
        AnimationSet r3 = new AnimationSet(false);
        r3.addAnimation(e);
        r3.addAnimation(f);
        Unit r4 = Unit.INSTANCE;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        final KtvPreviewSongsViewHolder r9 = (KtvPreviewSongsViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "p0");
        final MusicPanel r10 = (MusicPanel) ListProtector.get(this.a, r8);
        int r0 = KtvPreviewSongsViewHolder.e;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "panel");
        r9.U3(false);
        r9.d = r10.a.getMId();
        String r1 = r10.a.getMTitle();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        SpannableString r3 = new SpannableString(s1.C(2131918194, new Object[]{r1, r10.a.getMAuthor()}));
        int r2 = r1.length();
        ForegroundColorSpan r4 = new ForegroundColorSpan(-1);
        r9.d = r10.a.getMId();
        r3.setSpan(r4, 0, r2, 34);
        r9.b.setMaxWidth(s1.f(158.0f));
        r9.b.setText(r3);
        if (r10.b != 4) goto L8;
        r9.c.setText(s1.B(2131918626));
        r9.c.setClickable(false);
    L9:
        r9.c.setOnClickListener(x0.a(new KtvPreviewSongsViewHolder$bindMusicPanel$1(r9, r10)));
        return;
    L8:
        r9.T3();
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566151, r3, false);
        if (this.c == false) goto L6;
        r5.setPadding(0, 0, 0, 0);
    L8:
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L19;
        if (this.c == false) goto L14;
        int r0 = UtilityKotlinExtentionsKt.i(48);
    L17:
        r6.height = r0;
        r5.setLayoutParams(r6);
        goto L19
    L14:
        if (this.d == false) goto L16;
        r0 = UtilityKotlinExtentionsKt.i(44);
        goto L17
    L16:
        r0 = UtilityKotlinExtentionsKt.i(52);
    L19:
        return new KtvPreviewSongsViewHolder(r5);
    L6:
        if (this.d == false) goto L8;
        r5.setPadding(0, s1.f(10.0f), 0, s1.f(10.0f));
        goto L8
    }
}
