package erb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.AtSelectableViewHolder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.mention.base.impl.atselector.bean.a f473670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtSelectableViewHolder f473671b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = MentionUtils.f431660a;
        com.ss.android.lark.mention.base.impl.atselector.bean.a r102 = this.f473670a;
        if (r102.f431701g != Chatter.ChatterType.BOT) goto L5;
        boolean r103 = true;
    L6:
        String r104 = r102.f431695a;
        Context r105 = this.f473671b.profileInfoCard.getContext();
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 == false) goto L9;
        arb.a.f16068b.Y(r105, r104);
        return;
    L9:
        com.ss.android.lark.profile.utils.a.a(r105, r104, 2);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public g(com.ss.android.lark.mention.base.impl.atselector.bean.a r100, AtSelectableViewHolder r101) {
        this.f473670a = r100;
        this.f473671b = r101;
    }
}
