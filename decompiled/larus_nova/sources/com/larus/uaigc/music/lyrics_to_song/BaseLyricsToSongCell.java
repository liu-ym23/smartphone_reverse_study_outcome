package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larus/uaigc/music/lyrics_to_song/BaseLyricsToSongCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/uaigc/music/lyrics_to_song/LyricsToSongCellState;", "<init>", "()V", "songBox", "Lcom/larus/uaigc/music/lyrics_to_song/BaseLyricsToSongBox;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "generateSongBox", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateBoxView", "Landroid/view/View;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseLyricsToSongCell extends BaseMessageListCell<g> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f373669i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.uaigc.music.lyrics_to_song.a f373670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f373671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f373672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f373673h;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
    }

    static {
    }

    public BaseLyricsToSongCell() {
        this.f373671f = LazyKt.lazy(new b(this));
        this.f373672g = LazyKt.lazy(new c(this));
        this.f373673h = LazyKt.lazy(new d(this));
    }

    public com.larus.uaigc.music.lyrics_to_song.a o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new f(r100);
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.uaigc.music.lyrics_to_song.a r103 = o(r100);
        r103.setBoxType(r102);
        de8.c r104 = (de8.c) this.f373671f.getValue();
        if (r104 == null) goto L5;
        Integer r105 = r104.m();
    L6:
        r103.setImmerseBgColor(r105);
        this.f373670e = r103;
        return r103;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r110, ei9.f r210, int r211) {
        g r100 = (g) r210;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r100, "state");
        q0 r101 = lf8.a.b(this);
        if (r101 == null) goto L27;
        com.larus.uaigc.music.lyrics_to_song.a r102 = this.f373670e;
        q0.a r111 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("songBox");
        com.larus.uaigc.music.lyrics_to_song.a r103 = null;
    L8:
        Message r104 = r100.f563233a;
        y r105 = (y) this.f373672g.getValue();
        if (r105 == null) goto L11;
        wc9.e r106 = r105.h();
    L12:
        IChatMessageShareAbility r107 = (IChatMessageShareAbility) this.f373673h.getValue();
        if (r107 == null) goto L17;
        boolean r108 = true;
        if (r107.H1() != true) goto L17;
    L18:
        int r109 = com.larus.uaigc.music.lyrics_to_song.a.f373686p;
        r103.n(r104, r101, r106, r108, null, null);
        IAIChatUgcAIGCService.Companion r112 = IAIChatUgcAIGCService.f365905a;
        com.larus.uaigc.music.lyrics_to_song.a r113 = this.f373670e;
        if (r113 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("songBox");
        com.larus.uaigc.music.lyrics_to_song.a r114 = null;
    L22:
        Message r115 = r100.f563233a;
        q0 r116 = lf8.a.b(this);
        q0 r117 = lf8.a.b(this);
        if (r117 == null) goto L25;
        r111 = r117.getProvider();
    L25:
        r112.Q(r114, r115, r116, r111, false);
        return;
    L21:
        r114 = r113;
    L17:
        r108 = false;
        goto L18
    L11:
        r106 = null;
        goto L12
    L7:
        r103 = r102;
        goto L8
    }
}
