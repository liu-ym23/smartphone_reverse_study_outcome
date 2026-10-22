package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.d1;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.ding.entity.DingStatus;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageDingDescBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412817g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageDingDescBlock f412818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.k<AppCompatTextView> f412819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DingStatus f412821d;

        public a(MessageDingDescBlock r100, com.ss.android.lark.blueprint.k<AppCompatTextView> r101, y6b.a<?> r102, DingStatus r103) {
            this.f412818a = r100;
            this.f412819b = r101;
            this.f412820c = r102;
            this.f412821d = r103;
        }

        public final void a() {
            MessageDingDescBlock r100 = this.f412818a;
            com.ss.android.lark.blueprint.k<AppCompatTextView> r101 = this.f412819b;
            y6b.a<?> r102 = this.f412820c;
            DingStatus r103 = this.f412821d;
            r100.getClass();
            String r104 = UIHelper.getString(R.string.Lark_Chat_BuzzMessageTip) + ' ';
            SpannableStringBuilder r105 = new SpannableStringBuilder(r104);
            int r106 = r104.length();
            Drawable r107 = UIUtils.getDrawable(r100.getContext(), R.drawable.ic_svg_message_tag_urgent);
            int r108 = zz7.b.g(r100.getContext(), 12);
            r107.setBounds(0, 0, r108, r108);
            com.ss.android.lark.chat.drawable.b r110 = new com.ss.android.lark.chat.drawable.b(r107);
            SpannableString r109 = new SpannableString(" ");
            r109.setSpan(r110, 0, 1, 33);
            r105.insert(0, r109);
            TextPaint r111 = ((AppCompatTextView) r101.getView()).getPaint();
            ChatThemeInfo r112 = r100.f412673c.r8();
            ChatThemeInfo.Scene r113 = null;
            if (r112 == null) goto L5;
            ChatThemeInfo.Scene r114 = r112.getComponentScene();
        L6:
            boolean r115 = com.ss.android.lark.chat.utils.p.g(r114);
            if (r115 == false) goto L14;
            ChatThemeInfo r116 = r100.f412673c.r8();
            if (r116 == null) goto L12;
            r113 = r116.getComponentScene();
        L12:
            if (com.ss.android.lark.chat.utils.p.f(r113) == false) goto L14;
            boolean r117 = true;
        L15:
            Context r118 = r100.getContext();
            float r119 = (((AppCompatTextView) r101.getView()).getMeasuredWidth() - r108) - r111.measureText(r104);
            Map<String, String> r120 = r103.getChatterNameMap();
            List<String> r121 = r103.getConfirmedChatterIds();
            y r122 = new y(r100, r102);
            pl.droidsonroids.gif.d r123 = f1.f416668a;
            String r124 = UIUtils.getString(ChatCoreModule.a().getContext(), R.string.Lark_Legacy_SystemMessageSeparatorComma);
            float r125 = r111.measureText(r124);
            float r126 = r111.measureText("…");
            int r127 = ncc.f.f518738d;
            int r128 = ((UIHelper.dp2px(2.0f) * 2) + UIHelper.dp2px(3.0f)) + UIHelper.dp2px(2.0f);
            int r129 = r120.size();
            float r130 = r119 - r111.measureText("…" + UIHelper.mustacheFormat(R.string.Lark_Chat_BuzzHasMorePerson, "number", Integer.toString(r129)));
            if (r121 != null) goto L18;
            Set r131 = Collections.emptySet();
        L19:
            SpannableStringBuilder r132 = new SpannableStringBuilder();
            Iterator<Map.Entry<String, String>> r133 = r120.entrySet().iterator();
            float r134 = 0.0f;
            int r135 = 0;
        L21:
            if (r133.hasNext() == false) goto L47;
            Map.Entry<String, String> r210 = r133.next();
            Iterator<Map.Entry<String, String>> r211 = r133;
            if (r135 != (r129 - 1)) goto L25;
            boolean r136 = true;
        L26:
            float r212 = r125;
            String r213 = r124;
            float r137 = r111.measureText(r210.getValue()) + r128;
            boolean r138 = r131.contains(r210.getKey());
            r134 = r134 + r137;
            if (r134 > r130) goto L29;
        L43:
            String r139 = r210.getKey();
            int r214 = r128;
            String r140 = r210.getValue();
            ncc.f r141 = f1.b(r118, r138, r117);
            float r215 = r130;
            int r142 = r132.length();
            r132.append(r140);
            int r143 = r132.length();
            int r216 = r129;
            r132.setSpan(new d1(r122, r139), r142, r143, 33);
            r132.setSpan(r141, r142, r143, 33);
            if (r136 == true) goto L46;
            r132.append(r213);
            r134 = r134 + r212;
        L46:
            r135 = r135 + 1;
            r124 = r213;
            r130 = r215;
            r133 = r211;
            r125 = r212;
            r128 = r214;
            r129 = r216;
            goto L21
        L29:
            if (r134 > r119) goto L32;
            if (r136 == true) goto L43;
        L32:
            if (r135 != 0) goto L42;
            if (r136 == false) goto L35;
            r130 = r119 - r126;
        L35:
            String r144 = r210.getKey();
            String r145 = r210.getValue();
            ncc.f r146 = f1.b(r118, r138, r117);
            String r147 = TextUtils.ellipsize(r145, r111, r130, TextUtils.TruncateAt.END).toString();
            if (r147.length() <= 0) goto L38;
            r147 = r147.substring(0, r147.length() - 1);
        L38:
            int r148 = r132.length();
            r132.append(r147);
            int r149 = r132.length();
            r132.setSpan(new d1(r122, r144), r148, r149, 33);
            r132.setSpan(r146, r148, r149, 33);
            if (r136 == false) goto L41;
            r132.append("…");
            goto L47
        L41:
            f1.a(r118, r132, r129, r122);
            goto L47
        L42:
            r132.delete(r132.length() - r213.length(), r132.length());
            f1.a(r118, r132, r129, r122);
            goto L47
        L25:
            r136 = false;
        L47:
            r105.append(r132);
            if (r115 == true) goto L50;
        L53:
            int r150 = com.ss.android.lark.chat.utils.p.e(r100.getContext());
            int r151 = com.ss.android.lark.chat.utils.p.d(r100.getContext());
        L54:
            int r152 = r106 + 1;
            r105.setSpan(new ForegroundColorSpan(r150), 0, r152, 33);
            r105.setSpan(new ForegroundColorSpan(r151), r152, r105.length(), 33);
            ((AppCompatTextView) r101.getView()).setText(r105, TextView.BufferType.SPANNABLE);
            ((AppCompatTextView) r101.getView()).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        L50:
            if (h18.f.a(r100.getContext()) == true) goto L52;
            if (r117 == false) goto L53;
        L52:
            r150 = com.ss.android.lark.chat.utils.p.b(r100.getContext());
            Context r153 = r100.getContext();
            Intrinsics.checkNotNullParameter(r153, PerfLog.PARAM_KEY_CONTEXT_ID);
            r151 = UIUtils.getColor(r153, R.color.text_link_normal_color_in_dark_mode);
            goto L54
        L18:
            r131 = new HashSet(r121);
        L14:
            r117 = false;
            goto L15
        L5:
            r114 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412817g;
    }

    public MessageDingDescBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412817g = IMMessageKeys$Blocks.DING_DESC;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412817g, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        y6b.c r103 = (y6b.c) r102;
        DingStatus r104 = r103.V;
        if (r103.f566517y == false) goto L5;
    L20:
        g(r101, this.f412817g, IMMessageKeys$Slots.BOTTOM);
        return;
    L5:
        if (r103.T == false) goto L20;
        if (r104 == null) goto L20;
        if (r103.f566520z == true) goto L20;
        if ((r104.getConfirmedChatterIds().size() + r104.getUnconfirmedChatterIds().size()) > 0) goto L14;
        g(r101, this.f412817g, IMMessageKeys$Slots.BOTTOM);
        return;
    L14:
        com.ss.android.lark.blueprint.k r105 = r101.c(this.f412817g, IMMessageKeys$Slots.BOTTOM, new MessageDingDescBlock$update$blockView$1(this));
        if (r103.f566496k1 == false) goto L17;
        ((AppCompatTextView) r105.getView()).setGravity(8388629);
    L18:
        ((AppCompatTextView) r105.getView()).post(new a(this, r105, r102, r104));
        return;
    L17:
        ((AppCompatTextView) r105.getView()).setGravity(8388627);
        goto L18
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
