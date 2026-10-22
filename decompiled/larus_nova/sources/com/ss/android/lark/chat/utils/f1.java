package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static pl.droidsonroids.gif.d f416668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pl.droidsonroids.gif.m f416669b = null;

    public interface a {
        void a(String r100);

        void o1();
    }

    public static class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f416670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f416671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SystemMessageType f416672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f416673d;

        public interface a {
            void a(SystemMessageType r100);
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            long r101 = SystemClock.uptimeMillis();
            long r102 = r101 - this.f416670a;
            this.f416670a = r101;
            if (r102 >= 500) goto L5;
            return;
        L5:
            a r103 = this.f416671b;
            if (r103 == null) goto L9;
            r103.a(this.f416672c);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            r100.setColor(UIUtils.getColor(this.f416673d, R.color.function_danger_fill_default));
            r100.setUnderlineText(false);
        }

        public b(FragmentActivity r100, SystemMessageType r101, a r102) {
            this.f416673d = r100;
            this.f416671b = r102;
            this.f416672c = r101;
        }
    }

    static {
        f416669b = new pl.droidsonroids.gif.m(true);
        new CopyOnWriteArrayList();
    }

    public static ncc.f b(Context r100, boolean r101, boolean r102) {
        if (r102 == false) goto L4;
        int r103 = -9395969;
    L5:
        if (r101 == false) goto L7;
        int r104 = R.color.urgent_message_read_state_tip_is_read;
    L8:
        int r105 = UIUtils.getColor(r100, r104);
        if (r101 == false) goto L11;
        Paint.Style r106 = Paint.Style.FILL;
    L13:
        return new ncc.f(r105, r103, r106);
    L11:
        r106 = Paint.Style.STROKE;
        goto L13
    L7:
        int r107 = p3b.a.W;
        r104 = v4b.a.f553177o;
        goto L8
    L4:
        int r108 = p3b.a.W;
        r103 = UIUtils.getColor(r100, v4b.a.f553182t);
        goto L5
    }

    public static void a(Context r100, SpannableStringBuilder r101, int r102, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r103) {
        int r104 = r101.length();
        r101.append("…" + UIHelper.mustacheFormat(R.string.Lark_Chat_BuzzHasMorePerson, "number", Integer.toString(r102)));
        int r105 = r101.length();
        r101.setSpan(new e1(r100, r103), r104, r105, 33);
        r101.setSpan(new ForegroundColorSpan(UIUtils.getColor(r100, R.color.text_placeholder)), r104, r105, 33);
    }

    public static SpannableStringBuilder c(FragmentActivity r100, SystemMessageType r101, String r102, String r103, b.a r104) {
        String r105 = "[pic]" + r102;
        int r106 = r105.lastIndexOf(r103);
        if (r106 != (-1)) goto L6;
        return null;
    L6:
        int r107 = r103.length() + r106;
        SpannableStringBuilder r108 = new SpannableStringBuilder(r105);
        if (r100 != null) goto L9;
        return r108;
    L9:
        Drawable r109 = UIUtils.getDrawable(r100, R.drawable.ud_icon_luckmoney_colorful);
        r109.setBounds(0, 0, UIUtils.dp2px(r100, 16.0f), UIUtils.dp2px(r100, 16.0f));
        r108.setSpan(new ImageSpan(r109), 0, 5, 17);
        r108.setSpan(new b(r100, r101, r104), r106, r107, 17);
        return r108;
    }
}
