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
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class MentionTextView extends ClickSpanWorkaroundTextView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f194625l = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f194626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f194627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f194628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f194629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f194630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f194631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f194632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f194633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f194634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f194635k;

    public class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f194636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextExtraStruct f194637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f194638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f194639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MentionTextView f194640g;

        @Override // com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView.c
        public final void a(boolean r100) {
            if (r100 == false) goto L4;
            this.f194640g.f194633i = false;
        L4:
            d r101 = this.f194639f;
            if (r101 == null) goto L7;
            r101.a();
        L7:
            MentionTextView r102 = this.f194640g;
            int r103 = MentionTextView.f194625l;
            r102.getClass();
            super.a(r100);
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (y.a(r100) == false) goto L6;
            return;
        L6:
            if (this.f194640g.f194633i == false) goto L8;
            return;
        L8:
            e r101 = this.f194636c;
            if (r101 == null) goto L12;
            sy3.a r102 = (sy3.a) r101;
            r102.a(this.f194637d);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            int r101 = this.f194640g.f194632h;
            if (r101 != 0) goto L5;
            r101 = this.f194638e;
        L5:
            if (r101 != 0) goto L7;
            r101 = r100.linkColor;
        L7:
            r100.setColor(r101);
            r100.setUnderlineText(this.f194640g.f194626b);
        }

        public a(MentionTextView r100, e r101, TextExtraStruct r102, int r103, d r104) {
            this.f194640g = r100;
            super(r100);
            this.f194636c = r101;
            int r105 = MentionTextView.f194625l;
            r100.getClass();
            this.f194637d = r102;
            this.f194638e = r103;
            if (r100.f194632h == 0) goto L5;
            r100.getPaint().setColor(r100.f194632h);
        L9:
            this.f194639f = r104;
            return;
        L5:
            TextPaint r106 = r100.getPaint();
            if (r103 != 0) goto L8;
            r103 = r100.getPaint().linkColor;
        L8:
            r106.setColor(r103);
            goto L9
        }
    }

    public class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f194641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextExtraStruct f194642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f194643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f194644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MentionTextView f194645g;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (y.a(r100) == false) goto L5;
            return;
        L5:
            e r101 = this.f194641c;
            if (r101 == null) goto L9;
            sy3.a r102 = (sy3.a) r101;
            r102.a(this.f194642d);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            int r101 = this.f194643e;
            if (r101 != 0) goto L6;
            r101 = r100.linkColor;
        L6:
            if (this.f194646a == false) goto L8;
            this.f194645g.getClass();
            r101 = Color.argb(Math.round(Color.alpha(r101) * 0.75f), Color.red(r101), Color.green(r101), Color.blue(r101));
        L8:
            r100.setColor(r101);
            r100.setUnderlineText(this.f194645g.f194626b);
            r100.setFakeBoldText(this.f194644f);
        }

        public b(MentionTextView r100, e r101, TextExtraStruct r102, int r103) {
            this.f194645g = r100;
            super(r100);
            this.f194641c = r101;
            this.f194642d = r102;
            this.f194643e = r103;
            this.f194644f = r102.isBoldText();
        }
    }

    public abstract class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f194646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MentionTextView f194647b;

        public c(MentionTextView r100) {
            this.f194647b = r100;
            this.f194646a = false;
        }

        public void a(boolean r100) {
            this.f194646a = r100;
            this.f194647b.invalidate();
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

    public final void init() {
        this.f194626b = false;
        this.f194628d = 0;
        this.f194629e = getTextSize();
        this.f194630f = getCurrentTextColor();
        setHighlightColor(0);
    }

    public void setOnSpanLongClickListener(f r100) {
    }

    public void setOnSpanShowListener(g r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return super.getText();
    L5:
        return super.getText();
    }

    public int getSpanColor() {
        return this.f194630f;
    }

    public float getSpanSize() {
        return this.f194629e;
    }

    public int getSpanStyle() {
        return this.f194628d;
    }

    public MentionTextView(Context r100) {
        super(r100);
        this.f194631g = true;
        this.f194632h = 0;
        this.f194634j = true;
        this.f194635k = true;
        init();
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f194631g == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f194631g == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r100) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public void setCanScroll(boolean r100) {
        this.f194631g = r100;
    }

    public void setIsHashTagClickable(boolean r100) {
        this.f194635k = r100;
    }

    public void setIsHashTagEnhance(boolean r100) {
        this.f194634j = r100;
    }

    public void setMaxSize(int r100) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(r100)});
    }

    public void setOnSpanClickListener(e r100) {
        this.f194627c = r100;
    }

    public void setShowUnderline(boolean r100) {
        this.f194626b = r100;
    }

    public void setSpanColor(int r100) {
        this.f194632h = r100;
    }

    public void setSpanSize(float r100) {
        this.f194629e = r100;
    }

    public void setSpanStyle(int r100) {
        this.f194628d = r100;
    }

    public MentionTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f194631g = true;
        this.f194632h = 0;
        this.f194634j = true;
        this.f194635k = true;
        init();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L8;
        super.onMeasure(r100, r101);
        return;
    L8:
        AoLogger.c("MentionTextView", new Object[]{e});
    }

    public final void y(List r110, go2.g r111) {
        CharSequence r100 = getText();
        if (r100 == null) goto L101;
        if (r110 == null) goto L101;
        if (r110.isEmpty() == true) goto L101;
        SpannableString r101 = new SpannableString(r100);
        if (TextUtils.isEmpty(r101.toString()) == true) goto L99;
        int r102 = r101.length();
        Iterator r103 = r110.iterator();
    L13:
        if (r103.hasNext() == false) goto L99;
        TextExtraStruct r112 = (TextExtraStruct) r103.next();
        if (r111 != null) goto L16;
        if (r112.getStart() > r112.getEnd()) goto L13;
        if (r112.getStart() > r102) goto L13;
        if (r112.getEnd() < 0) goto L13;
        if (r112.getStart() >= 0) goto L27;
        int r113 = 0;
    L29:
        if (r112.getEnd() <= r102) goto L31;
        int r114 = r102;
    L32:
        if (r114 <= r113) goto L13;
        if (r112.getType() == 7) goto L13;
        if (r112.getType() == 8) goto L13;
        if (r112.getType() == 65281) goto L41;
        if (r112.getType() == 4) goto L13;
        if (r112.getType() == 65282) goto L47;
        if (r112.getType() == 65286) goto L50;
        if (r112.getType() == 65285) goto L53;
        if (r112.getType() == 5) goto L62;
        if (r112.getType() != 2) goto L77;
        getResources().getColor(R.color.aos_text_primary);
    L86:
        if (r112.getType() == 1) goto L88;
    L89:
        r101.setSpan(new a(this, this.f194627c, r112, this.f194630f, null), r113, r114, 33);
    L91:
        if (r112.getType() != 3) goto L94;
        r101.setSpan(new StyleSpan(1), r113, r114, 33);
    L98:
        r101.setSpan(new AbsoluteSizeSpan((int) this.f194629e), r113, r114, 33);
        goto L13
    L94:
        if (r112.getType() == 1) goto L96;
    L97:
        r101.setSpan(new StyleSpan(this.f194628d), r113, r114, 33);
        goto L98
    L96:
        if (this.f194634j == false) goto L98;
    L88:
        if (this.f194635k == false) goto L91;
    L77:
        if (r112.getType() != 0) goto L79;
    L84:
        getResources().getColor(R.color.aos_link3);
        goto L86
    L79:
        if (r112.getType() == 1) goto L84;
        if (r112.getType() != 3) goto L86;
        getResources().getColor(R.color.aos_text_primary);
        goto L86
    L62:
        if (r112.isHideSearchWords() == true) goto L13;
        Object r104 = r112.getCustomSpan();
        if (r104 == null) goto L68;
        r101.setSpan(r104, r113, r114, 33);
    L68:
        if (r112.isClickable() == false) goto L13;
        r101.setSpan(new StyleSpan(this.f194628d), r113, r114, 33);
        if ((r104 instanceof d) == true) goto L71;
        r101.setSpan(new a(this, this.f194627c, r112, this.f194630f, null), r113, r114, 33);
        goto L13
    L71:
        e r105 = this.f194627c;
        int r106 = this.f194630f;
        r101.setSpan(new a(this, r105, r112, r106, (d) r104), r113, r114, 33);
        goto L13
    L53:
        Object r107 = r112.getCustomSpan();
        int r108 = r113 + 1;
        if (r108 <= r114) goto L56;
        r108 = r114;
    L56:
        r101.setSpan(r107, r113, r108, 33);
        r101.setSpan(new StyleSpan(this.f194628d), r113, r114, 33);
        if ((r107 instanceof d) == false) goto L13;
        e r109 = this.f194627c;
        int r115 = this.f194630f;
        r101.setSpan(new a(this, r109, r112, r115, (d) r107), r113, r114, 33);
        goto L13
    L50:
        int r116 = r112.getColor();
        r101.setSpan(new b(this, this.f194627c, r112, r116), r113, r114, 33);
        goto L13
    L47:
        int r117 = r112.getColor();
        r101.setSpan(new b(this, this.f194627c, r112, r117), r113, r114, 33);
        goto L13
    L41:
        r101.setSpan(r112.getCustomSpan(), r113, r114, 33);
        goto L13
    L31:
        r114 = r112.getEnd();
        goto L32
    L27:
        r113 = r112.getStart();
        goto L29
    L16:
        int r118 = com.bytedance.awemeopen.apps.framework.feed.desc.d.f194657a;
    L99:
        r100 = r101;
    L101:
        if ((r100 instanceof SpannableString) == false) goto L148;
        setText((SpannableString) r100);
        return;
    }

    public MentionTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f194631g = true;
        this.f194632h = 0;
        this.f194634j = true;
        this.f194635k = true;
        init();
    }
}
