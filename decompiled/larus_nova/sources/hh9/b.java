package hh9;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.bridge.v;
import com.larus.kmp.voice_setting.voice.model.Page;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f485242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Page f485243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f485244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f485246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<SpeakerVoice, Boolean> f485247f;

    public b(Page r100, String r101, boolean r102, int r103, Function1 r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r100 = Page.NON;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r101 = "my_tab";
    L8:
        boolean r106 = false;
        if ((r105 & 16) == 0) goto L12;
        r102 = false;
    L12:
        if ((r105 & 32) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r105 & 64) == 0) goto L18;
        r106 = v.c(null).f351907a;
    L18:
        if ((r105 & 128) == 0) goto L20;
        r104 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        this.f485242a = true;
        this.f485243b = r100;
        this.f485244c = r102;
        this.f485245d = r103;
        this.f485246e = r106;
        this.f485247f = r104;
    }
}
