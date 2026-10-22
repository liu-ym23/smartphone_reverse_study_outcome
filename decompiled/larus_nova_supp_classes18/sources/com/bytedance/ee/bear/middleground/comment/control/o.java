package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T, R> implements Function {
    public final /* synthetic */ ReactionPanelFacade.a a;
    public final /* synthetic */ CommentFunction b;
    public final /* synthetic */ ICardAdapter c;
    public final /* synthetic */ CommentBean.CommentDetail d;
    public final /* synthetic */ View e;

    public o(ReactionPanelFacade.a r1, CommentFunction r2, ICardAdapter r3, CommentBean.CommentDetail r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object apply(Object r6) {
        Triple r7 = (Triple) r6;
        Intrinsics.checkNotNullParameter(r7, "hostService");
        ReactionPanelFacade.a r0 = this.a;
        List r1 = (List) r7.getFirst();
        r0.getClass();
        List r2 = (List) r7.getSecond();
        DefaultEmojiPanelData r8 = (DefaultEmojiPanelData) r7.getThird();
        r0.e = new n(this.b, this.c, this.d, this.e);
        return this.a;
    }
}
