package com.larus.bot.impl.feature.edit.feature.firstmet.tts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusWidgetBotCreateTtsPlayerBinding;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/firstmet/tts/BotCreateTtsPlayerView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/tts/IBotCreateTtsPlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusWidgetBotCreateTtsPlayerBinding;", "disable", "", "playing", "loading", "static", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateTtsPlayerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetBotCreateTtsPlayerBinding f319216a;

    public static final class a {
    }

    static {
    }

    public BotCreateTtsPlayerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BotCreateTtsPlayerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public BotCreateTtsPlayerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_bot_create_tts_player, this);
        int r103 = R.id.tts_icon;
        LottieAdapterView r104 = (LottieAdapterView) ViewBindings.findChildViewById(this, R.id.tts_icon);
        if (r104 == null) goto L12;
        r103 = R.id.tts_tv;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tts_tv);
        if (r105 == null) goto L12;
        this.f319216a = new LarusWidgetBotCreateTtsPlayerBinding(this, r104, r105);
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.text}, r102, r102);
        String r107 = r106.getString(0);
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r105.setText(r107);
        r106.recycle();
        return;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ BotCreateTtsPlayerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
