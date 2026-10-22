package jnc;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.platform.model.comment.UserInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<View, UserInfo, Unit> f499810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f499811b;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f499810a.invoke(r100, this.f499811b);
    }

    public d(com.story.ai.biz.comment.adapter.g r100, UserInfo r101) {
        this.f499810a = r100;
        this.f499811b = r101;
    }
}
