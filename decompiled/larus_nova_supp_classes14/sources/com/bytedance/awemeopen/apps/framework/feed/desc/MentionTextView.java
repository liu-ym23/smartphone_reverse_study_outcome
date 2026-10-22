package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.view.widget.ClickSpanWorkaroundTextView;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MentionTextView extends ClickSpanWorkaroundTextView {
    public static final /* synthetic */ int l = 0;
    public boolean b;
    public e c;
    public int d;
    public float e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;

    public class a extends c {
        public final e c;
        public final TextExtraStruct d;
        public final int e;
        public final d f;
        public final /* synthetic */ MentionTextView g;

        @Override // com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView.c
        public final void a(boolean r3) {
            if (r3 == false) goto L4;
            this.g.i = false;
        L4:
            d r0 = this.f;
            if (r0 == null) goto L7;
            r0.a();
        L7:
            MentionTextView r1 = this.g;
            int r2 = MentionTextView.l;
            r1.getClass();
            super.a(r3);
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            if (y.a(r2) == false) goto L6;
            return;
        L6:
            if (this.g.i == false) goto L8;
            return;
        L8:
            e r3 = this.c;
            if (r3 == null) goto L12;
            sy3.a r4 = (sy3.a) r3;
            r4.a(this.d);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            int r0 = this.g.h;
            if (r0 != 0) goto L5;
            r0 = this.e;
        L5:
            if (r0 != 0) goto L7;
            r0 = r2.linkColor;
        L7:
            r2.setColor(r0);
            r2.setUnderlineText(this.g.b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(MentionTextView r1, e r2, TextExtraStruct r3, int r4, d r5) {
            this.g = r1;
            super(r1);
            this.c = r2;
            int r6 = MentionTextView.l;
            r1.getClass();
            this.d = r3;
            this.e = r4;
            if (r1.h == 0) goto L5;
            r1.getPaint().setColor(r1.h);
        L9:
            this.f = r5;
            return;
        L5:
            TextPaint r7 = r1.getPaint();
            if (r4 != 0) goto L8;
            r4 = r1.getPaint().linkColor;
        L8:
            r7.setColor(r4);
            goto L9
        }
    }

    public class b extends c {
        public final e c;
        public final TextExtraStruct d;
        public final int e;
        public final boolean f;
        public final /* synthetic */ MentionTextView g;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            if (y.a(r2) == false) goto L5;
            return;
        L5:
            e r3 = this.c;
            if (r3 == null) goto L9;
            sy3.a r4 = (sy3.a) r3;
            r4.a(this.d);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r5) {
            int r0 = this.e;
            if (r0 != 0) goto L6;
            r0 = r5.linkColor;
        L6:
            if (this.a == false) goto L8;
            this.g.getClass();
            r0 = Color.argb(Math.round(Color.alpha(r0) * 0.75f), Color.red(r0), Color.green(r0), Color.blue(r0));
        L8:
            r5.setColor(r0);
            r5.setUnderlineText(this.g.b);
            r5.setFakeBoldText(this.f);
        }

        public b(MentionTextView r1, e r2, TextExtraStruct r3, int r4) {
            this.g = r1;
            super(r1);
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r3.isBoldText();
        }
    }

    public abstract class c extends ClickableSpan {
        public boolean a;
        public final /* synthetic */ MentionTextView b;

        public c(MentionTextView r1) {
            this.b = r1;
            this.a = false;
        }

        public void a(boolean r1) {
            this.a = r1;
            this.b.invalidate();
        }
    }

    public interface d {
        void a();
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public int getPreMeasuredHeight() {
        return 0;
    }

    public int getPreMeasuredWidth() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        this.b = false;
        this.d = 0;
        this.e = getTextSize();
        this.f = getCurrentTextColor();
        setHighlightColor(0);
    }

    public void setOnSpanLongClickListener(f r1) {
    }

    public void setOnSpanShowListener(g r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public CharSequence getText() {
        return super.getText();
    L5:
        return super.getText();
    }

    public int getSpanColor() {
        return this.f;
    }

    public float getSpanSize() {
        return this.e;
    }

    public int getSpanStyle() {
        return this.d;
    }

    public MentionTextView(Context r2) {
        super(r2);
        this.g = true;
        this.h = 0;
        this.j = true;
        this.k = true;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollHorizontally(int r2) {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.widget.TextView*/.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r2) {
        if (this.g == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.widget.TextView*/.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    public void setCanScroll(boolean r1) {
        this.g = r1;
    }

    public void setIsHashTagClickable(boolean r1) {
        this.k = r1;
    }

    public void setIsHashTagEnhance(boolean r1) {
        this.j = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxSize(int r3) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(r3)});
    }

    public void setOnSpanClickListener(e r1) {
        this.c = r1;
    }

    public void setShowUnderline(boolean r1) {
        this.b = r1;
    }

    public void setSpanColor(int r1) {
        this.h = r1;
    }

    public void setSpanSize(float r1) {
        this.e = r1;
    }

    public void setSpanStyle(int r1) {
        this.d = r1;
    }

    public MentionTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.g = true;
        this.h = 0;
        this.j = true;
        this.k = true;
        init();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L8;
        super.onMeasure(r3, r4);
        return;
    L8:
        AoLogger.c("MentionTextView", new Object[]{e});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(List r18, go2.g r19) {
        CharSequence r0 = getText();
        if (r0 == null) goto L101;
        if (r18 == null) goto L101;
        if (r18.isEmpty() == true) goto L101;
        SpannableString r7 = new SpannableString(r0);
        if (TextUtils.isEmpty(r7.toString()) == true) goto L99;
        int r8 = r7.length();
        Iterator r9 = r18.iterator();
    L13:
        if (r9.hasNext() == false) goto L99;
        TextExtraStruct r10 = (TextExtraStruct) r9.next();
        if (r19 != null) goto L16;
        if (r10.getStart() > r10.getEnd()) goto L13;
        if (r10.getStart() > r8) goto L13;
        if (r10.getEnd() < 0) goto L13;
        if (r10.getStart() >= 0) goto L27;
        int r11 = 0;
    L29:
        if (r10.getEnd() <= r8) goto L31;
        int r12 = r8;
    L32:
        if (r12 <= r11) goto L13;
        if (r10.getType() == 7) goto L13;
        if (r10.getType() == 8) goto L13;
        if (r10.getType() == 65281) goto L41;
        if (r10.getType() == 4) goto L13;
        if (r10.getType() == 65282) goto L47;
        if (r10.getType() == 65286) goto L50;
        if (r10.getType() == 65285) goto L53;
        if (r10.getType() == 5) goto L62;
        if (r10.getType() != 2) goto L77;
        getResources().getColor(2131100332);
    L86:
        if (r10.getType() == 1) goto L88;
    L89:
        r7.setSpan(new a(this, this.c, r10, this.f, null), r11, r12, 33);
    L91:
        if (r10.getType() != 3) goto L94;
        r7.setSpan(new StyleSpan(1), r11, r12, 33);
    L98:
        r7.setSpan(new AbsoluteSizeSpan((int) this.e), r11, r12, 33);
        goto L13
    L94:
        if (r10.getType() == 1) goto L96;
    L97:
        r7.setSpan(new StyleSpan(this.d), r11, r12, 33);
        goto L98
    L96:
        if (this.j == false) goto L98;
    L88:
        if (this.k == false) goto L91;
    L77:
        if (r10.getType() != 0) goto L79;
    L84:
        getResources().getColor(2131100289);
        goto L86
    L79:
        if (r10.getType() == 1) goto L84;
        if (r10.getType() != 3) goto L86;
        getResources().getColor(2131100332);
        goto L86
    L62:
        if (r10.isHideSearchWords() == true) goto L13;
        Object r1 = r10.getCustomSpan();
        if (r1 == null) goto L68;
        r7.setSpan(r1, r11, r12, 33);
    L68:
        if (r10.isClickable() == false) goto L13;
        r7.setSpan(new StyleSpan(this.d), r11, r12, 33);
        if ((r1 instanceof d) == true) goto L71;
        r7.setSpan(new a(this, this.c, r10, this.f, null), r11, r12, 33);
        goto L13
    L71:
        e r2 = this.c;
        int r4 = this.f;
        r7.setSpan(new a(this, r2, r10, r4, (d) r1), r11, r12, 33);
        goto L13
    L53:
        Object r3 = r10.getCustomSpan();
        int r5 = r11 + 1;
        if (r5 <= r12) goto L56;
        r5 = r12;
    L56:
        r7.setSpan(r3, r11, r5, 33);
        r7.setSpan(new StyleSpan(this.d), r11, r12, 33);
        if ((r3 instanceof d) == false) goto L13;
        e r6 = this.c;
        int r13 = this.f;
        r7.setSpan(new a(this, r6, r10, r13, (d) r3), r11, r12, 33);
        goto L13
    L50:
        int r14 = r10.getColor();
        r7.setSpan(new b(this, this.c, r10, r14), r11, r12, 33);
        goto L13
    L47:
        int r15 = r10.getColor();
        r7.setSpan(new b(this, this.c, r10, r15), r11, r12, 33);
        goto L13
    L41:
        r7.setSpan(r10.getCustomSpan(), r11, r12, 33);
        goto L13
    L31:
        r12 = r10.getEnd();
        goto L32
    L27:
        r11 = r10.getStart();
        goto L29
    L16:
        int r16 = com.bytedance.awemeopen.apps.framework.feed.desc.d.a;
    L99:
        r0 = r7;
    L101:
        if ((r0 instanceof SpannableString) == false) goto L148;
        setText((SpannableString) r0);
        return;
    }

    public MentionTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = true;
        this.h = 0;
        this.j = true;
        this.k = true;
        init();
    }
}
