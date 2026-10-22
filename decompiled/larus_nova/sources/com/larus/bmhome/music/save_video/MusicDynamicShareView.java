package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusLayoutMusicShareDynamicBinding;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.j5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/music/save_video/MusicDynamicShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusLayoutMusicShareDynamicBinding;", "updateLyrics", "", "lyricsContent", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMusicData", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitThumb", "", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicDynamicShareView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutMusicShareDynamicBinding f313067a;

    public MusicDynamicShareView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MusicDynamicShareView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Object R5(MusicCreationContent r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MusicDynamicShareView$setMusicData$1) == false) goto L7;
        MusicDynamicShareView$setMusicData$1 r100 = (MusicDynamicShareView$setMusicData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        LarusLayoutMusicShareDynamicBinding r113 = (LarusLayoutMusicShareDynamicBinding) r100.L$1;
        MusicCreationContent r105 = (MusicCreationContent) r100.L$0;
        ResultKt.throwOnFailure(r112);
        LarusLayoutMusicShareDynamicBinding r114 = r113;
        r110 = r105;
    L56:
        if (o0.d(r110.getCoverMainColor()) == true) goto L65;
    L60:
        r104 = true;
    L61:
        if (r104 == false) goto L64;
        View r115 = r114.f312749a;
        int r116 = j0.f375426a;
        r115.setBackground(j0.c(R.drawable.larus_bg_ugc_create_failure_placeholder));
    L64:
        return Unit.INSTANCE;
    L65:
        r114.f312749a.setBackgroundColor(Color.parseColor(r110.getCoverMainColor()));     // Catch: Exception -> L59
    L59:
        FLogger.f375446a.e("save_music_video", "Wrong color string format");
        goto L60
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = this.f313067a;
        TextView r106 = r114.f312753e;
        String r107 = r110.getTitle();
        String r108 = "";
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        if (r107.length() != 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
        r107 = getContext().getResources().getString(R.string.larus_music_title_safety_reject);
    L23:
        r106.setText(r107);
        String r117 = null;
        if ((r110 instanceof bq8.a) == false) goto L27;
        r114.f312752d.setText(r110.getCreator());
    L42:
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        kotlinx.coroutines.j r118 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r118.C();
        Image r119 = r110.getCover();
        if (r119 == null) goto L47;
        ImageObj r120 = r119.imageThumb;
        if (r120 == null) goto L47;
        r117 = r120.url;
    L47:
        if (r117 == null) goto L50;
        r108 = r117;
    L50:
        ImageLoaderKt.x(this.f313067a.f312750b, UriProtector.parse(r108), "music_share_thumb", null, new e(this, r118), 4);
        Object r121 = r118.B();
        if (r121 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L53;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L53:
        if (r121 != r102) goto L56;
        return r102;
    L27:
        if (AppHost.f326268a.isOversea() == false) goto L32;
        Context r122 = getContext();
        if (r122 == null) goto L31;
        String r123 = j5.b(r122, AccountService.f365697a.getNickname());
    L37:
        TextView r124 = r114.f312752d;
        if (r123 != null) goto L41;
        r123 = "";
    L41:
        r124.setText(r123);
        goto L42
    L31:
        r123 = null;
        goto L37
    L32:
        StringBuilder r125 = new StringBuilder();
        r125.append(AccountService.f365697a.getNickname());
        r125.append(" / ");
        Context r126 = getContext();
        if (r126 == null) goto L35;
        String r127 = r126.getString(R.string.larus_musiccreation_authorname_doubao_cn);
    L36:
        r125.append(r127);
        r123 = r125.toString();
        goto L37
    L35:
        r127 = null;
        goto L36
    L20:
        r109 = false;
    L7:
        r100 = new MusicDynamicShareView$setMusicData$1(this, r111);
        goto L8
    }

    public MusicDynamicShareView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_music_share_dynamic, this);
        int r103 = R.id.cover;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.cover);
        if (r104 == null) goto L15;
        r103 = R.id.detail_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.detail_container)) == null) goto L15;
        r103 = R.id.lyrics;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.lyrics);
        if (r105 == null) goto L15;
        r103 = R.id.subtitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.subtitle);
        if (r106 == null) goto L15;
        r103 = R.id.title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.title);
        if (r107 == null) goto L15;
        this.f313067a = new LarusLayoutMusicShareDynamicBinding(this, r104, r105, r106, r107);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ MusicDynamicShareView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
