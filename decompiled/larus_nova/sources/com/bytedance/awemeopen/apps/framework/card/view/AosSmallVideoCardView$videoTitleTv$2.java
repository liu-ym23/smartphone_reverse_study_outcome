package com.bytedance.awemeopen.apps.framework.card.view;

import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosSmallVideoCardView$videoTitleTv$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ f this$0;

    public AosSmallVideoCardView$videoTitleTv$2(f r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.aos_card_small_video_title);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ TextView invoke() {
        return invoke();
    }
}
