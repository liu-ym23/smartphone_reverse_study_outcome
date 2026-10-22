package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.pb.recognition.SpeechLang;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioChooseLanguageDialogAdapter f430825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f430826b;

    public a(AudioChooseLanguageDialogAdapter r100, int r101) {
        this.f430825a = r100;
        this.f430826b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        List<SpeechLang> r101 = this.f430825a.f430812a;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L16;
        int r104 = this.f430826b;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L16;
        b.c("en_us");
        goto L16
    L15:
        b.c("zh_ch");
    L16:
        int r105 = this.f430826b;
        List<SpeechLang> r106 = this.f430825a.f430812a;
        if (r106 == null) goto L19;
        r102 = r106.size();
    L19:
        AudioChooseLanguageDialogAdapter.a r107 = null;
        if (r105 >= r102) goto L24;
        List<SpeechLang> r108 = this.f430825a.f430812a;
        if (r108 == null) goto L24;
        SpeechLang r109 = (SpeechLang) ListProtector.get(r108, this.f430826b);
    L25:
        AudioChooseLanguageDialogAdapter r110 = this.f430825a;
        String r111 = r110.f430815d;
        String r112 = "";
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        if (r109 == null) goto L31;
        String r113 = r109.mlangCode;
        if (r113 == null) goto L31;
    L32:
        r110.f430815d = r113;
        if (r109 == null) goto L36;
        String r114 = r109.mlangName;
        if (r114 == null) goto L36;
    L40:
        AudioChooseLanguageDialogAdapter.a r115 = this.f430825a.f430816e;
        if (r115 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mItemClickListener");
    L44:
        String r116 = this.f430825a.f430815d;
        if (r116 == null) goto L48;
        r112 = r116;
    L48:
        r107.j4(r111, r112, r114);
        return;
    L43:
        r107 = r115;
    L36:
        List<String> r117 = r110.f430814c;
        if (r117 == null) goto L39;
        r114 = (String) ListProtector.get(r117, this.f430826b);
        goto L40
    L39:
        r114 = "";
    L31:
        r113 = "";
    L24:
        r109 = null;
        goto L25
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
