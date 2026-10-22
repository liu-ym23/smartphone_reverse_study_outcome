package jnc;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.platform.model.comment.UserInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<View, UserInfo, Unit> f499808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f499809b;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f499808a.invoke(r100, this.f499809b);
    }

    public c(com.story.ai.biz.comment.adapter.g r100, UserInfo r101) {
        this.f499808a = r100;
        this.f499809b = r101;
    }
}
