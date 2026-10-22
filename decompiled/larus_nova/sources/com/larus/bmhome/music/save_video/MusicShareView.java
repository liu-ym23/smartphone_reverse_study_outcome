package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusLayoutMusicShareBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.j5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/music/save_video/MusicShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusLayoutMusicShareBinding;", "setMusicData", "", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitThumb", "", "awaitBg", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicShareView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutMusicShareBinding f313068a;

    public MusicShareView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MusicShareView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Object R5(MusicCreationContent r310, Continuation<? super Unit> r311) {
        MusicCreationContent r100 = r310;
        if ((r311 instanceof MusicShareView$setMusicData$1) == false) goto L7;
        MusicShareView$setMusicData$1 r101 = (MusicShareView$setMusicData$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        int r106 = r101.I$0;
        LarusLayoutMusicShareBinding r107 = (LarusLayoutMusicShareBinding) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L108:
        int r108 = r107.f312746f.getLineCount() * r107.f312746f.getLineHeight();
        FLogger.f375446a.d("save_music_video", "Lyrics actualHeightAfter = " + r108 + ", lyrics textView height = " + r106);
        float r109 = (float) r108;
        int r110 = CircleProgressBarView.f328410k;
        if (r109 <= CircleProgressBarView.a.a(getContext(), 380.0f)) goto L112;
        int r111 = getContext().getResources().getColor(R.color.larus_static_white);
        r107.f312746f.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r107.f312746f.getMeasuredHeight(), new int[]{r111, ColorUtils.setAlphaComponent(r111, 15)}, new float[]{0.9f, 1.0f}, Shader.TileMode.CLAMP));
    L112:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r106 = r101.I$0;
        LarusLayoutMusicShareBinding r112 = (LarusLayoutMusicShareBinding) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L101:
        int r113 = r112.f312746f.getLineCount() * r112.f312746f.getLineHeight();
        FLogger.f375446a.d("save_music_video", "Lyrics actualHeight = " + r113 + ", lyrics textView height = " + r106);
        float r114 = (float) r113;
        int r115 = CircleProgressBarView.f328410k;
        if (r114 < CircleProgressBarView.a.a(getContext(), 380.0f)) goto L104;
        r112.f312746f.setTextSize(15.0f);
    L104:
        r112.f312746f.setLineSpacing(0.0f, 1.4f);
        TextView r116 = r112.f312746f;
        r101.L$0 = r112;
        r101.I$0 = r106;
        r101.label = 4;
        if (ViewExtKt.b(r116, r101) != r104) goto L107;
        return r104;
    L107:
        r107 = r112;
        goto L108
    L18:
        LarusLayoutMusicShareBinding r117 = (LarusLayoutMusicShareBinding) r101.L$1;
        MusicCreationContent r118 = (MusicCreationContent) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L76:
        if (o0.d(r118.getCoverMainColor()) == true) goto L113;
    L84:
        boolean r119 = true;
    L85:
        if (r119 == false) goto L87;
        r117.f312744d.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#AAB8C6"), ColorProtector.parseColor("#B6BACD")}));
    L87:
        TextView r120 = r117.f312746f;
        String r121 = r118.getLyrics();
        if (r121 != null) goto L90;
        String r122 = "";
    L91:
        List r123 = StringsKt.split$default(r122, new String[]{"\n"}, false, 0, 6, null);
        ArrayList r124 = new ArrayList();
        Iterator r125 = r123.iterator();
    L93:
        if (r125.hasNext() == false) goto L97;
        Object r126 = r125.next();
        if ((!StringsKt.contains$default((String) r126, "[", false, 2, null)) == false) goto L93;
        r124.add(r126);
        goto L93
    L97:
        r120.setText(CollectionsKt.joinToString$default(r124, "\n", null, null, 0, null, null, 62, null));
        int r127 = r117.f312746f.getMeasuredHeight();
        TextView r128 = r117.f312746f;
        r101.L$0 = r117;
        r101.L$1 = null;
        r101.I$0 = r127;
        r101.label = 3;
        if (ViewExtKt.b(r128, r101) != r104) goto L100;
        return r104;
    L100:
        r112 = r117;
        r106 = r127;
        goto L101
    L90:
        r122 = r121;
        goto L91
    L113:
        int r129 = Color.parseColor(r118.getCoverMainColor());     // Catch: Exception -> L83
        int[] r130 = {ColorUtils.setAlphaComponent(r129, 127), ColorUtils.setAlphaComponent(r129, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X), r129};     // Catch: Exception -> L83
        float[] r131 = {0.0f, 0.7f, 1.0f};     // Catch: Exception -> L83
        if (Build.VERSION.SDK_INT < 29) goto L80;
        GradientDrawable r132 = new GradientDrawable();     // Catch: Exception -> L83
        r132.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);     // Catch: Exception -> L83
        r132.setColors(r130, r131);     // Catch: Exception -> L83
        Drawable r133 = r132;
    L81:
        r117.f312743c.setBackground(r133);     // Catch: Exception -> L83
        r117.f312741a.setBackgroundColor(r129);     // Catch: Exception -> L83
        r119 = false;
        goto L85
    L80:
        ShapeDrawable r134 = new ShapeDrawable(new RectShape());     // Catch: Exception -> L83
        r134.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r117.f312743c.getHeight(), r130, r131, Shader.TileMode.CLAMP));     // Catch: Exception -> L83
        r133 = r134;
    L83:
        FLogger.f375446a.e("save_music_video", "Wrong color string format");
        goto L84
    L19:
        LarusLayoutMusicShareBinding r135 = (LarusLayoutMusicShareBinding) r101.L$1;
        MusicCreationContent r136 = (MusicCreationContent) r101.L$0;
        ResultKt.throwOnFailure(r103);
        LarusLayoutMusicShareBinding r137 = r135;
        r100 = r136;
    L61:
        r101.L$0 = r100;
        r101.L$1 = r137;
        r101.label = 2;
        kotlinx.coroutines.j r138 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r138.C();
        Image r139 = r100.getCover();
        if (r139 == null) goto L66;
        ImageObj r140 = r139.imageOri;
        if (r140 == null) goto L66;
        String r141 = r140.url;
    L67:
        if (r141 != null) goto L69;
        r141 = "";
    L69:
        ImageLoaderKt.x(this.f313068a.f312742b, UriProtector.parse(r141), "music_share_bg", null, new g(this, r138), 4);
        Object r142 = r138.B();
        if (r142 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L72;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L72:
        if (r142 != r104) goto L74;
        return r104;
    L74:
        r118 = r100;
        r117 = r137;
    L66:
        r141 = null;
        goto L67
    L20:
        ResultKt.throwOnFailure(r103);
        r137 = this.f313068a;
        TextView r143 = r137.f312748h;
        String r144 = r310.getTitle();
        if (r144 != null) goto L24;
        r144 = "";
    L24:
        if (r144.length() != 0) goto L26;
        boolean r145 = true;
    L27:
        if (r145 == false) goto L29;
        r144 = getContext().getResources().getString(R.string.larus_music_title_safety_reject);
    L29:
        r143.setText(r144);
        if ((r100 instanceof bq8.a) == false) goto L33;
        r137.f312747g.setText(r310.getCreator());
    L48:
        r101.L$0 = r100;
        r101.L$1 = r137;
        r101.label = 1;
        kotlinx.coroutines.j r146 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r146.C();
        Image r147 = r310.getCover();
        if (r147 == null) goto L53;
        ImageObj r148 = r147.imageThumb;
        if (r148 == null) goto L53;
        String r149 = r148.url;
    L54:
        if (r149 != null) goto L56;
        r149 = "";
    L56:
        ImageLoaderKt.x(this.f313068a.f312745e, UriProtector.parse(r149), "music_share_thumb", null, new i(this, r146), 4);
        Object r150 = r146.B();
        if (r150 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L59:
        if (r150 != r104) goto L61;
        return r104;
    L53:
        r149 = null;
        goto L54
    L33:
        if (AppHost.f326268a.isOversea() == false) goto L38;
        Context r151 = getContext();
        if (r151 == null) goto L37;
        String r152 = j5.b(r151, AccountService.f365697a.getNickname());
    L43:
        TextView r153 = r137.f312747g;
        if (r152 != null) goto L47;
        r152 = "";
    L47:
        r153.setText(r152);
        goto L48
    L37:
        r152 = null;
        goto L43
    L38:
        StringBuilder r154 = new StringBuilder();
        r154.append(AccountService.f365697a.getNickname());
        r154.append(" / ");
        Context r155 = getContext();
        if (r155 == null) goto L41;
        String r156 = r155.getString(R.string.larus_musiccreation_authorname_doubao_cn);
    L42:
        r154.append(r156);
        r152 = r154.toString();
        goto L43
    L41:
        r156 = null;
        goto L42
    L26:
        r145 = false;
    L7:
        r101 = new MusicShareView$setMusicData$1(this, r311);
        goto L8
    }

    public MusicShareView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_music_share, this);
        int r113 = R.id.bg_cover;
        SimpleDraweeView r100 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.bg_cover);
        if (r100 == null) goto L23;
        r113 = R.id.bg_cover_mask;
        View r101 = ViewBindings.findChildViewById(this, R.id.bg_cover_mask);
        if (r101 == null) goto L23;
        r113 = R.id.bg_default;
        View r102 = ViewBindings.findChildViewById(this, R.id.bg_default);
        if (r102 == null) goto L23;
        r113 = R.id.cover;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.cover);
        if (r103 == null) goto L23;
        r113 = R.id.detail_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.detail_container)) == null) goto L23;
        r113 = R.id.icon_music;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.icon_music)) == null) goto L23;
        r113 = R.id.lyrics;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.lyrics);
        if (r104 == null) goto L23;
        r113 = R.id.subtitle;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.subtitle);
        if (r105 == null) goto L23;
        r113 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.title);
        if (r106 == null) goto L23;
        this.f313068a = new LarusLayoutMusicShareBinding(this, r100, r101, r102, r103, r104, r105, r106);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ MusicShareView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
