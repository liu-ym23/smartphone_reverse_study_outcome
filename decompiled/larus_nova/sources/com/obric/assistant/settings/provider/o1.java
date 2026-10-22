package com.obric.assistant.settings.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.home.api.main.HomeService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o1 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f392327a;

    public o1(Context r100) {
        this.f392327a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        FLogger.f375446a.i("AsrSettingProvider", "showPcInAsrPrivacyDialog, clickableSpan, onClick https://os.obriccloud.com/agreement/enhance_asr");
        Context r101 = this.f392327a;
        Intent r102 = new Intent();
        r102.setComponent(new ComponentName(r101, HomeService.f344094a.F()));
        r102.putExtra("open_link", "https://os.obriccloud.com/agreement/enhance_asr");
        r101.startActivity(r102);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(ContextCompat.getColor(this.f392327a, R.color.oui_fill_highlighted));
        r100.setUnderlineText(false);
    }
}
