package com.larus.bmhome.chat.auth;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f297367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f297368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f297369c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f297367a + "\n\n");
        String r102 = this.f297368b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        String r103 = r101.toString();
        Function1<String, Unit> r104 = this.f297369c;
        if (r104 == null) goto L9;
        r104.invoke(r103);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        AppHost.Companion r101 = AppHost.f326268a;
        r100.setColor(ContextCompat.getColor(r101.getApplication(), v19.c.b(R.attr.larus_neutral_50, r101.getApplication(), R.color.larus_neutral_50)));
        r100.setUnderlineText(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(String r100, String r101, Function1<? super String, Unit> r102) {
        this.f297367a = r100;
        this.f297368b = r101;
        this.f297369c = r102;
    }
}
