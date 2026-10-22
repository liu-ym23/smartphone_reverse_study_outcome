package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import w08.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010$\u001a\u00020%2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0015\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200H\u0014J\u0012\u00101\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0003J\b\u00102\u001a\u00020\u0018H\u0002J\u0010\u00103\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000104H\u0003J\b\u00105\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDTextAvatar;", "Lcom/larksuite/component/universe_design/image/UDAvatar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "avatarTextColor", "textPaint", "Landroid/text/TextPaint;", "avatarText", "", "getAvatarText", "()Ljava/lang/String;", "setAvatarText", "(Ljava/lang/String;)V", "hasCustomTextSize", "", "value", "avatarTextSize", "getAvatarTextSize", "()I", "setAvatarTextSize", "(I)V", "avatarBgColor", "getAvatarBgColor", "setAvatarBgColor", "bgPaint", "Landroid/graphics/Paint;", "init", "", "ta", "Landroid/content/res/TypedArray;", "onAvatarSizeChanged", "setText", "text", "setTextColor", "color", "(Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawText", "shouldDrawText", "breakAvatarText", "", "countAvatarText", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDTextAvatar extends UDAvatar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f285053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextPaint f285054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f285055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f285056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f285057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f285058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f285059g;

    @Override // com.larksuite.component.universe_design.image.UDAvatar
    public final void onAvatarSizeChanged() {
        super.onAvatarSizeChanged();
        if (this.f285056d == true) goto L22;
        int r100 = getAvatarSize();
        if (r100 != (-5)) goto L7;
        int r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_extra_small);
    L20:
        setAvatarTextSize(r101);
        return;
    L7:
        if (r100 != (-4)) goto L9;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_mini);
        goto L20
    L9:
        if (r100 != (-3)) goto L11;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_small);
        goto L20
    L11:
        if (r100 != (-2)) goto L13;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_middle);
        goto L20
    L13:
        if (r100 == (-1)) goto L15;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_large);
        goto L20
    L15:
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_large);
        goto L20
    }

    public final int getAvatarBgColor() {
        return this.f285058f;
    }

    public final String getAvatarText() {
        return this.f285055c;
    }

    public final int getAvatarTextSize() {
        return this.f285057e;
    }

    public UDTextAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void init(TypedArray r100) {
        CharSequence r101 = r100.getText(6);
        if (r101 == null) goto L6;
        String r102 = r101.toString();
        if (r102 == null) goto L6;
    L7:
        this.f285055c = r102;
        this.f285053a = r100.getColor(7, 0);
        this.f285058f = r100.getColor(0, 0);
        int r103 = r100.getDimensionPixelSize(8, -1);
        if (r103 <= 0) goto L11;
        setAvatarTextSize(r103);
        return;
    L11:
        return;
    L6:
        r102 = r100.getString(6);
        goto L7
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatar, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        String r100 = this.f285055c;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if ((!r101) == true) goto L13;
        return;
    L13:
        if (getBackground() != null) goto L23;
        int r102 = this.f285058f;
        if (r102 == 0) goto L23;
        Paint r103 = this.f285059g;
        if (r103 == null) goto L19;
        r103.setColor(r102);
    L19:
        Paint r104 = this.f285059g;
        if (r104 == null) goto L23;
        if (r110 == null) goto L23;
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), r104);
    L23:
        String r105 = this.f285055c;
        if (r105 != null) goto L26;
    L29:
        boolean r106 = true;
    L31:
        if (r106 == false) goto L33;
        ArrayList r107 = null;
    L102:
        if (r107 == null) goto L127;
        TextPaint r108 = this.f285054b;
        if (r108 == null) goto L106;
        r108.setColor(this.f285053a);
    L106:
        Iterator r109 = r107.iterator();
        int r111 = 0;
    L108:
        if (r109.hasNext() == false) goto L138;
        int r112 = r111 + 1;
        String r113 = (String) r109.next();
        Rect r114 = new Rect();
        TextPaint r115 = this.f285054b;
        if (r115 == null) goto L112;
        r115.getTextBounds(r113, 0, r113.length(), r114);
    L112:
        int r116 = getHeight() / r107.size();
        float r117 = getWidth();
        TextPaint r118 = this.f285054b;
        if (r118 == null) goto L115;
        float r119 = r118.measureText(r113);
    L116:
        float r120 = ((r117 - r119) - r114.left) / 2;
        float r121 = (r111 * r116) + (r116 / 2.0f);
        TextPaint r122 = this.f285054b;
        if (r122 == null) goto L126;
        float r123 = (r121 + ((r122.getFontMetricsInt().descent - r122.getFontMetricsInt().ascent) / 2.0f)) - r122.getFontMetricsInt().descent;
        if (r107.size() <= 1) goto L124;
        if (r111 != 0) goto L122;
        int r124 = r122.getFontMetricsInt().descent;
    L123:
        r123 = r123 + r124;
        goto L124
    L122:
        r124 = -r122.getFontMetricsInt().descent;
    L124:
        if (r110 == null) goto L126;
        r110.drawText(r113, r120, r123, r122);
    L126:
        r111 = r112;
        goto L108
    L115:
        r119 = 0.0f;
        goto L116
    L138:
        return;
    L127:
        return;
    L33:
        r107 = new ArrayList();
        int r125 = this.f285057e;
        if (r125 <= 0) goto L41;
        TextPaint r126 = this.f285054b;
        if (r126 == null) goto L38;
        r126.setTextSize(r125);
    L38:
        String r127 = this.f285055c;
        if (r127 == null) goto L102;
        r107.add(r127);
        goto L102
    L41:
        String r128 = this.f285055c;
        if (r128 != null) goto L44;
    L55:
        int r129 = 0;
    L56:
        TextPaint r130 = this.f285054b;
        if (r130 == null) goto L69;
        if (r129 == 0) goto L67;
        if (r129 == 1) goto L67;
        if (r129 != 2) goto L62;
        float r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_middle);
    L68:
        r130.setTextSize(r131);
        goto L69
    L62:
        if (r129 == 3) goto L65;
        if (r129 == 4) goto L65;
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_mini);
    L65:
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_small);
    L67:
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_large);
    L69:
        String r132 = this.f285055c;
        if (r132 == null) goto L102;
        if (r132.length() <= 0) goto L74;
        boolean r133 = true;
    L75:
        if (r133 == false) goto L102;
        int r134 = r132.length();
        int r135 = 0;
        int r136 = 0;
        int r137 = 0;
    L77:
        if (r135 >= r134) goto L100;
        int r138 = r135 + 1;
        if (r132.substring(r135, r138).getBytes(Charsets.UTF_8).length != 1) goto L81;
        int r139 = 1;
    L82:
        r136 = r136 + r139;
        if (r136 != 4) goto L85;
        r107.add(r132.substring(r137, r138));
        r137 = r138;
        r136 = 0;
    L96:
        if (r107.size() >= 2) goto L100;
        r135 = r138;
        goto L77
    L85:
        if (r136 <= 4) goto L93;
        r107.add(r132.substring(r137, r135));
        if (r107.size() < 2) goto L89;
    L91:
        r137 = r135;
        r136 = 2;
        goto L96
    L89:
        if (r135 < (r132.length() - 1)) goto L91;
        r107.add(r132.substring(r135, r132.length()));
        goto L91
    L93:
        if (r135 < (r132.length() - 1)) goto L96;
        r107.add(r132.substring(r137, r132.length()));
        goto L96
    L81:
        r139 = 2;
    L100:
        if (r107.size() != 0) goto L102;
        r107.add(r132);
        goto L102
    L74:
        r133 = false;
        goto L75
    L44:
        if (r128.length() <= 0) goto L46;
        boolean r140 = true;
    L47:
        if (r140 == false) goto L55;
        int r141 = r128.length();
        int r142 = 0;
        r129 = 0;
    L49:
        if (r142 >= r141) goto L56;
        int r143 = r142 + 1;
        if (r128.substring(r142, r143).getBytes(Charsets.UTF_8).length != 1) goto L53;
        r129 = r129 + 1;
    L54:
        r142 = r143;
        goto L49
    L53:
        r129 = r129 + 2;
        goto L54
    L46:
        r140 = false;
        goto L47
    L26:
        if (r105.length() == 0) goto L29;
        r106 = false;
        goto L31
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final void setAvatarBgColor(int r100) {
        this.f285058f = r100;
    }

    public final void setAvatarText(String r100) {
        this.f285055c = r100;
    }

    public final void setAvatarTextSize(int r100) {
        if (this.f285057e == r100) goto L5;
        this.f285057e = r100;
        invalidate();
    L5:
        this.f285056d = true;
    }

    public final void setText(String r100) {
        if (r100 == null) goto L5;
        this.f285055c = r100;
        invalidate();
        return;
    }

    public final void setTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        this.f285053a = r100.intValue();
        invalidate();
        return;
    }

    public UDTextAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public UDTextAvatar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatar
    public final void init(AttributeSet r100, int r101, int r102) {
        super.init(r100, r101, r102);
        Paint r103 = new Paint();
        this.f285059g = r103;
        r103.setStyle(Paint.Style.FILL);
        TextPaint r104 = new TextPaint(1);
        this.f285054b = r104;
        r104.setFakeBoldText(true);
        r104.setTextSize(d.d(getContext(), R.dimen.ud_avatar_more_text_size_large));
        a.a(r104, getContext(), 0);
        TypedArray r105 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_avatar_background, R.attr.ud_avatar_borderColor, R.attr.ud_avatar_borderStyle, R.attr.ud_avatar_borderWidth, R.attr.ud_avatar_cornerRadius, R.attr.ud_avatar_size, R.attr.ud_avatar_text, R.attr.ud_avatar_textColor, R.attr.ud_avatar_textSize}, r101, r102);
        init(r105);
        r105.recycle();
    }

    public UDTextAvatar(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        init(r101, r102, 0);
    }
}
