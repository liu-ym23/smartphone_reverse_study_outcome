package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
public final class f extends com.larus.uaigc.music.lyrics_to_song.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LyricsToSongCardView f373691q;

    public static final class a {
    }

    static {
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        LyricsToSongCardView r101 = new LyricsToSongCardView(r100);
        this.f373691q = r101;
        addView(r101);
        if (e2.f365734a.isPad() == false) goto L6;
        setMaxWidth(Math.min(getMaxWidth(), i5.y0(v19.c.b(R.attr.larus_dp_420, null, R.dimen.larus_dp_420))));
        return;
    }

    @Override // com.larus.uaigc.music.lyrics_to_song.a
    public final void n(Message r110, q0 r111, wc9.e r112, boolean r113, MusicCreationContentList r114, Fragment r115) {
        MusicCreationContent r116 = null;
        if (r110 == null) goto L10;
        IAIChatUgcAIGCService.Companion r100 = IAIChatUgcAIGCService.f365905a;
        if (r111 == null) goto L7;
        q0.a r101 = r111.getProvider();
    L8:
        r100.Q(this, r110, r111, r101, true);
        goto L10
    L7:
        r101 = null;
    L10:
        if (r110 == null) goto L14;
        boolean r102 = true;
        if (com.larus.im.bean.message.a.k0(r110) != true) goto L14;
    L15:
        if (r102 == true) goto L17;
        int r103 = CircleProgressBarView.f328410k;
        setPadding((int) CircleProgressBarView.a.a(this.f373691q.getViewContext(), 10.0f), 0, 0, 0);
    L17:
        LyricsToSongCardView r104 = this.f373691q;
        if (r111 == null) goto L20;
        q0.a r105 = r111.getProvider();
    L21:
        if (r114 == null) goto L25;
        Map<String, MusicCreationContent> r117 = r114.getContentMap();
        if (r117 == null) goto L25;
        r116 = r117.get("0");
    L25:
        MusicCreationContent r106 = r116;
        if (r111 == null) goto L33;
        Function0<Fragment> r118 = r111.getHostFragment();
        if (r118 == null) goto L33;
        Fragment r119 = r118.invoke();
        if (r119 == null) goto L33;
        Fragment r107 = r119;
    L34:
        r104.i(r110, r105, r106, 0, "0", r107, new e(this));
        return;
    L33:
        r107 = r115;
        goto L34
    L20:
        r105 = null;
    L14:
        r102 = false;
        goto L15
    }
}
