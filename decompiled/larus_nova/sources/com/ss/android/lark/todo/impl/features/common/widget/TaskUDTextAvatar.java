package com.ss.android.lark.todo.impl.features.common.widget;

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

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010!\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\"H\u0014J\u0010\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\u0012J\u0015\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0014J\u0012\u0010.\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010-H\u0003J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000102H\u0003J\b\u00103\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDTextAvatar;", "Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "avatarTextColor", "textPaint", "Landroid/text/TextPaint;", "avatarText", "", "getAvatarText", "()Ljava/lang/String;", "setAvatarText", "(Ljava/lang/String;)V", "avatarTextSize", "getAvatarTextSize", "()I", "setAvatarTextSize", "(I)V", "avatarBgColor", "getAvatarBgColor", "setAvatarBgColor", "bgPaint", "Landroid/graphics/Paint;", "init", "", "ta", "Landroid/content/res/TypedArray;", "onAvatarSizeChanged", "setText", "text", "setTextColor", "color", "(Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawText", "shouldDrawText", "", "breakAvatarText", "", "countAvatarText", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskUDTextAvatar extends TaskUDAvatar {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f442509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextPaint f442510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f442511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f442512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f442513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Paint f442514n;

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatar
    public final void onAvatarSizeChanged() {
        super.onAvatarSizeChanged();
        int r100 = getAvatarSize();
        if (r100 != (-5)) goto L5;
        int r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_extra_small);
    L18:
        this.f442512l = r101;
        return;
    L5:
        if (r100 != (-4)) goto L7;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_mini);
        goto L18
    L7:
        if (r100 != (-3)) goto L9;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_small);
        goto L18
    L9:
        if (r100 != (-2)) goto L11;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_middle);
        goto L18
    L11:
        if (r100 == (-1)) goto L13;
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_large);
        goto L18
    L13:
        r101 = d.d(getContext(), R.dimen.ud_avatar_more_text_size_large);
        goto L18
    }

    public final int getAvatarBgColor() {
        return this.f442513m;
    }

    public final String getAvatarText() {
        return this.f442511k;
    }

    public final int getAvatarTextSize() {
        return this.f442512l;
    }

    public TaskUDTextAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatar, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        String r100 = this.f442511k;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if ((!r101) == true) goto L13;
        return;
    L13:
        if (getBackground() != null) goto L22;
        int r102 = this.f442513m;
        if (r102 == 0) goto L22;
        Paint r103 = this.f442514n;
        if (r103 == null) goto L19;
        r103.setColor(r102);
    L19:
        Paint r104 = this.f442514n;
        if (r104 == null) goto L22;
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), r104);
    L22:
        String r105 = this.f442511k;
        if (r105 != null) goto L25;
    L28:
        boolean r106 = true;
    L30:
        if (r106 == false) goto L32;
        ArrayList r107 = null;
    L101:
        if (r107 == null) goto L125;
        TextPaint r108 = this.f442510j;
        if (r108 == null) goto L105;
        r108.setColor(this.f442509i);
    L105:
        Iterator r109 = r107.iterator();
        int r111 = 0;
    L107:
        if (r109.hasNext() == false) goto L135;
        int r112 = r111 + 1;
        String r113 = (String) r109.next();
        Rect r114 = new Rect();
        TextPaint r115 = this.f442510j;
        if (r115 == null) goto L111;
        r115.getTextBounds(r113, 0, r113.length(), r114);
    L111:
        int r116 = getHeight() / r107.size();
        float r117 = getWidth();
        TextPaint r118 = this.f442510j;
        if (r118 == null) goto L114;
        float r119 = r118.measureText(r113);
    L115:
        float r120 = ((r117 - r119) - r114.left) / 2;
        float r121 = (r111 * r116) + (r116 / 2.0f);
        TextPaint r122 = this.f442510j;
        if (r122 == null) goto L124;
        float r123 = (r121 + ((r122.getFontMetricsInt().descent - r122.getFontMetricsInt().ascent) / 2.0f)) - r122.getFontMetricsInt().descent;
        if (r107.size() <= 1) goto L123;
        if (r111 != 0) goto L121;
        int r124 = r122.getFontMetricsInt().descent;
    L122:
        r123 = r123 + r124;
        goto L123
    L121:
        r124 = -r122.getFontMetricsInt().descent;
    L123:
        r110.drawText(r113, r120, r123, r122);
    L124:
        r111 = r112;
        goto L107
    L114:
        r119 = 0.0f;
        goto L115
    L135:
        return;
    L125:
        return;
    L32:
        r107 = new ArrayList();
        int r125 = this.f442512l;
        if (r125 <= 0) goto L40;
        TextPaint r126 = this.f442510j;
        if (r126 == null) goto L37;
        r126.setTextSize(r125);
    L37:
        String r127 = this.f442511k;
        if (r127 == null) goto L101;
        r107.add(r127);
        goto L101
    L40:
        String r128 = this.f442511k;
        if (r128 != null) goto L43;
    L54:
        int r129 = 0;
    L55:
        TextPaint r130 = this.f442510j;
        if (r130 == null) goto L68;
        if (r129 == 0) goto L66;
        if (r129 == 1) goto L66;
        if (r129 != 2) goto L61;
        float r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_middle);
    L67:
        r130.setTextSize(r131);
        goto L68
    L61:
        if (r129 == 3) goto L64;
        if (r129 == 4) goto L64;
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_mini);
    L64:
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_small);
    L66:
        r131 = d.c(getContext(), R.dimen.ud_avatar_text_size_large);
    L68:
        String r132 = this.f442511k;
        if (r132 == null) goto L101;
        if (r132.length() <= 0) goto L73;
        boolean r133 = true;
    L74:
        if (r133 == false) goto L101;
        int r134 = r132.length();
        int r135 = 0;
        int r136 = 0;
        int r137 = 0;
    L76:
        if (r135 >= r134) goto L99;
        int r138 = r135 + 1;
        if (r132.substring(r135, r138).getBytes(Charsets.UTF_8).length != 1) goto L80;
        int r139 = 1;
    L81:
        r136 = r136 + r139;
        if (r136 != 4) goto L84;
        r107.add(r132.substring(r137, r138));
        r137 = r138;
        r136 = 0;
    L95:
        if (r107.size() >= 2) goto L99;
        r135 = r138;
        goto L76
    L84:
        if (r136 <= 4) goto L92;
        r107.add(r132.substring(r137, r135));
        if (r107.size() < 2) goto L88;
    L90:
        r137 = r135;
        r136 = 2;
        goto L95
    L88:
        if (r135 < (r132.length() - 1)) goto L90;
        r107.add(r132.substring(r135, r132.length()));
        goto L90
    L92:
        if (r135 < (r132.length() - 1)) goto L95;
        r107.add(r132.substring(r137, r132.length()));
        goto L95
    L80:
        r139 = 2;
    L99:
        if (r107.size() != 0) goto L101;
        r107.add(r132);
        goto L101
    L73:
        r133 = false;
        goto L74
    L43:
        if (r128.length() <= 0) goto L45;
        boolean r140 = true;
    L46:
        if (r140 == false) goto L54;
        int r141 = r128.length();
        int r142 = 0;
        r129 = 0;
    L48:
        if (r142 >= r141) goto L55;
        int r143 = r142 + 1;
        if (r128.substring(r142, r143).getBytes(Charsets.UTF_8).length != 1) goto L52;
        r129 = r129 + 1;
    L53:
        r142 = r143;
        goto L48
    L52:
        r129 = r129 + 2;
        goto L53
    L45:
        r140 = false;
        goto L46
    L25:
        if (r105.length() == 0) goto L28;
        r106 = false;
        goto L30
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final void setAvatarBgColor(int r100) {
        this.f442513m = r100;
    }

    public final void setAvatarText(String r100) {
        this.f442511k = r100;
    }

    public final void setAvatarTextSize(int r100) {
        this.f442512l = r100;
    }

    public final void setText(String r100) {
        if (r100 == null) goto L5;
        this.f442511k = r100;
        invalidate();
        return;
    }

    public final void setTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        this.f442509i = r100.intValue();
        invalidate();
        return;
    }

    public TaskUDTextAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public TaskUDTextAvatar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        init(r101, r102, 0);
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatar
    public final void init(AttributeSet r100, int r101, int r102) {
        super.init(r100, r101, 0);
        Paint r103 = new Paint();
        this.f442514n = r103;
        r103.setStyle(Paint.Style.FILL);
        TextPaint r104 = new TextPaint(1);
        this.f442510j = r104;
        r104.setTextSize(d.d(getContext(), R.dimen.ud_avatar_more_text_size_large));
        TypedArray r105 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_avatar_background, R.attr.ud_avatar_borderColor, R.attr.ud_avatar_borderStyle, R.attr.ud_avatar_borderWidth, R.attr.ud_avatar_cornerRadius, R.attr.ud_avatar_size, R.attr.ud_avatar_text, R.attr.ud_avatar_textColor, R.attr.ud_avatar_textSize}, r101, 0);
        CharSequence r106 = r105.getText(6);
        if (r106 == null) goto L6;
        String r107 = r106.toString();
        if (r107 == null) goto L6;
    L7:
        this.f442511k = r107;
        this.f442509i = r105.getColor(7, 0);
        this.f442513m = r105.getColor(0, 0);
        r105.recycle();
        return;
    L6:
        r107 = r105.getString(6);
        goto L7
    }
}
