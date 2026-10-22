package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends ClickableSpan {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.h b;
    public final /* synthetic */ Function1<b, Unit> c;
    public final /* synthetic */ d d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        tt5.a.h("BotAtHintView", "[BOT_GUIDE_APP_ID_TRACE] report click, appId=" + this.a.a() + ", clickType=" + this.a.b() + ", botIds=" + this.a.c + ", botNames=" + this.a.b + ", actionType=" + this.a.a.c);
        com.bytedance.ee.bear.middleground.comment.uitls.h r7 = this.b;
        if (r7 == null) goto L5;
        String r0 = this.a.b();
        String r1 = this.a.a();
        Map<String, Object> r2 = r7.b();
        HashMap r3 = (HashMap) r2;
        r3.put("click", r0);
        r3.put("app_id", r1);
        tt5.a.h("Comment#CommentAnalytic", "[BOT_GUIDE_APP_ID_TRACE] track click, click = " + r0 + ", appId = " + r1);
        StringBuilder r4 = new StringBuilder("reportBotGuideClick params = ");
        r4.append(r2);
        tt5.a.b("Comment#CommentAnalytic", r4.toString());
        r7.g.a("ccm_comment_click", r2);
    L5:
        Function1<b, Unit> r8 = this.c;
        if (r8 == null) goto L9;
        r8.invoke(this.a.a);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        r3.setColor(ContextCompat.getColor(((RecyclerView.ViewHolder) this.d).itemView.getContext(), 2131106616));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(j0 r1, com.bytedance.ee.bear.middleground.comment.uitls.h r2, Function1<? super b, Unit> r3, d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
