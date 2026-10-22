package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusLayoutChatReplyHeaderBinding;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J5\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/view/ChatReplyHeaderView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutChatReplyHeaderBinding;", "setImmerseMode", "show", "", "text", "", "isImmerse", "", "isSelf", "hintResId", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/Integer;)V", "hide", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatReplyHeaderView extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f315489b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutChatReplyHeaderBinding f315490a;

    public ChatReplyHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatReplyHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public ChatReplyHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_chat_reply_header, this);
        int r103 = R.id.reply_hint;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.reply_hint);
        if (r104 == null) goto L9;
        r103 = R.id.reply_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.reply_text);
        if (r105 == null) goto L9;
        this.f315490a = new LarusLayoutChatReplyHeaderBinding(this, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ ChatReplyHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(String r100, Boolean r101, boolean r102, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusLayoutChatReplyHeaderBinding r103 = this.f315490a;
        if (r103 == null) goto L41;
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r104) == false) goto L13;
        LarusLayoutChatReplyHeaderBinding r105 = this.f315490a;
        if (r105 == null) goto L13;
        r105.f323990c.setTextColor(ve8.d.a(R.color.static_white_transparent_4, AppHost.f326268a.getApplication()));
        ImageView r106 = r105.f323989b;
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L11;
        int r107 = R.drawable.larus_ic_reply_rect_immerse_enterprise;
    L12:
        r106.setImageResource(r107);
        goto L13
    L11:
        r107 = R.drawable.larus_ic_reply_rect_immerse_new;
    L13:
        r103.f323990c.setText(r100);
        if (r102 == true) goto L17;
        r103.f323990c.setTextColor(ve8.d.a(R.color.neutral_70, AppHost.f326268a.getApplication()));
        r103.f323989b.setImageResource(R.drawable.larus_ic_reply_rect_new_in);
    L21:
        if (r110 != null) goto L23;
    L25:
        if (r102 == false) goto L41;
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L29;
        r103.f323990c.setAlpha(1.0f);
    L29:
        IFlowThemeConfigProvider r108 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r108 == null) goto L32;
        r108.d(r103.f323990c, ThemeColorKey.MESSAGE_REPLY_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_TEXT_COLOR);
    L32:
        IFlowThemeConfigProvider r109 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r109 == null) goto L35;
        r109.c(r103.f323989b, ThemeColorKey.MESSAGE_REPLY_LINE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_LINE_COLOR);
    L35:
        if (r110 == null) goto L41;
        if (r110.intValue() == 0) goto L41;
        IFlowThemeConfigProvider r111 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r111 == null) goto L41;
        r111.c(r103.f323989b, ThemeColorKey.MESSAGE_REPLY_ICON_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_ICON_COLOR);
        goto L41
    L23:
        if (r110.intValue() == 0) goto L25;
        r103.f323989b.setImageResource(r110.intValue());
        goto L25
    L17:
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L21;
        if (Intrinsics.areEqual(r101, r104) == true) goto L21;
        r103.f323989b.setImageResource(R.drawable.larus_ic_reply_rect_enterprise);
    L41:
        setVisibility(0);
    }
}
