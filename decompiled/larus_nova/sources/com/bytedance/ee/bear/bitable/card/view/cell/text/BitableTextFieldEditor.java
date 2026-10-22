package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 V2\u00020\u0001:\u0006QRSTUVB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ7\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u001a\u0010(\u001a\u00020 2\b\b\u0001\u0010)\u001a\u00020\n2\b\b\u0001\u0010*\u001a\u00020\nJ\u001a\u0010+\u001a\u00020 2\b\b\u0001\u0010)\u001a\u00020\n2\b\b\u0001\u0010*\u001a\u00020\nJ\u0006\u0010,\u001a\u00020 J\u001a\u0010-\u001a\u00020 2\b\b\u0001\u0010)\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\u000eJ\u000e\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020\u0010J\u000e\u00102\u001a\u00020 2\u0006\u00100\u001a\u00020\u0012J\u0010\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020 H\u0016J\u0018\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J*\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u00107\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0014J(\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0014J\u0006\u0010C\u001a\u00020\nJ\u0006\u0010D\u001a\u00020 J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0014J\u0010\u0010H\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010I\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010J\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020MH\u0017J\u0010\u0010N\u001a\u00020\u00162\u0006\u0010L\u001a\u00020MH\u0002J\u0017\u0010O\u001a\u0004\u0018\u00010\n2\u0006\u0010L\u001a\u00020MH\u0002¢\u0006\u0002\u0010PR\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mEditorUIType", "mEditorActionListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor$EditorActionListener;", "mOnSelectionChangedListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor$OnSelectionChangedListener;", "mOnSecondaryRightIconClickListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor$OnSecondaryRightIconClickListener;", "mRightIconDrawable", "Landroid/graphics/drawable/Drawable;", "mIsRightIconClicking", "", "mSecondaryRightIconDrawable", "mPressedRightIconIndex", "Ljava/lang/Integer;", "mPressedSelectionStart", "mPlaceholderIconDrawable", "mPlaceholderHintText", "", "mIsMultiLine", "setUIType", "", "uiType", "rightIconResId", "placeholderIconResId", "placeholderHintText", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "adjustPadding", "adjustPaddingForSecond", "setRightIcon", "iconResId", "iconColorId", "setSecondaryRightIcon", "clearRightIcon", "setPlaceholder", "hintText", "setEditorActionListener", "listener", "setOnSelectionChangedListener", "setSecondaryRightIconClickListener", "setFocusableAndClickable", "enable", "clearSelection", "onSelectionChanged", "start", "end", "onTextChanged", "text", "", "lengthBefore", "lengthAfter", "onSizeChanged", "w", "h", "oldw", "oldh", "getPressedSelectionStart", "updateMultiLineState", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawRightIcon", "drawRightIconSecond", "drawPlaceholder", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchAreaInsideRightIcon", "hitTestRightIconSecond", "(Landroid/view/MotionEvent;)Ljava/lang/Integer;", "EditorUIType", "EditorActionListener", "SimpleEditorActionListener", "OnSecondaryRightIconClickListener", "OnSelectionChangedListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableTextFieldEditor extends BitableAtEditText {
    public boolean E2;
    public Drawable F2;
    public Integer G2;
    public Integer H2;
    public Drawable I2;
    public String J2;
    public boolean K2;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f208212h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public b f208213p2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public d f208214v2;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public c f208215x2;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public Drawable f208216y2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor$EditorUIType;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface EditorUIType {
        public static final int ASSIST_PLACEHOLDER = 2;
        public static final int ASSIST_RIGHT_ICON = 1;
        public static final int ASSIST_RIGHT_ICON_BACKGROUND = 3;
        public static final int ASSIST_RIGHT_ICON_SECOND = 5;
        public static final a Companion = null;
        public static final int FULL_INPUT = 0;
        public static final int FULL_INPUT_NO_PADDING = 4;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f208217a = null;

            static {
                f208217a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f208217a;
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void onRightIconClick();
    }

    public interface c {
        void a();
    }

    public interface d {
        void C(int r100, int r101);
    }

    public static class e implements b {
        public e() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.b
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.b
        public final void b() {
        }
    }

    static {
    }

    public final void O() {
        int r100 = this.f208212h2;
        if (r100 != 1) goto L5;
        int r101 = (int) h18.d.a(getContext(), 18.0f);
        int r102 = (int) h18.d.a(getContext(), 10.0f);
        int r103 = (((int) h18.d.a(getContext(), 12.0f)) * 2) + r101;
        int r104 = (int) h18.d.a(getContext(), 12.0f);
        setPadding(r102, r104, r103, r104);
        return;
    L5:
        if (r100 != 3) goto L7;
        int r105 = (int) h18.d.a(getContext(), 24.0f);
        int r106 = ((int) h18.d.a(getContext(), 12.0f)) + r105;
        int r107 = (((int) h18.d.a(getContext(), 24.0f)) - getLineHeight()) / 2;
        setPadding(0, r107, r106, r107);
        return;
    L7:
        if (r100 != 4) goto L9;
        setPadding(0, 0, 0, 0);
        return;
    L9:
        if (r100 == 5) goto L11;
        int r108 = (int) h18.d.a(getContext(), 10.0f);
        int r109 = (int) h18.d.a(getContext(), 12.0f);
        setPadding(r108, r109, r108, r109);
        return;
    L11:
        int r110 = (int) h18.d.a(getContext(), 18.0f);
        int r111 = (int) h18.d.a(getContext(), 12.0f);
        int r112 = (int) h18.d.a(getContext(), 10.0f);
        int r113 = (int) h18.d.a(getContext(), 12.0f);
        if (this.f208216y2 != null) goto L17;
        if (this.F2 != null) goto L17;
        setPadding(r112, r113, r112, r113);
        return;
    L17:
        if (this.K2 == false) goto L20;
        setPadding(r112, r113, r112, (r111 + r113) + r110);
        return;
    L20:
        if (this.F2 == null) goto L22;
        int r114 = (((r111 * 2) + r110) + r111) + r110;
    L23:
        setPadding(r112, r113, r114, r113);
        return;
    L22:
        r114 = (r111 * 2) + r110;
        goto L23
    }

    public final void R() {
        if (this.f208212h2 == 5) goto L6;
        return;
    L6:
        if (this.f208216y2 == null) goto L8;
    L10:
        int r100 = getWidth();
        if (r100 > 0) goto L13;
        return;
    L13:
        Layout r101 = getLayout();
        if (r101 != null) goto L16;
        return;
    L16:
        boolean r102 = true;
        if (r101.getLineCount() > 1) goto L28;
        int r103 = (int) h18.d.a(getContext(), 18.0f);
        int r104 = (int) h18.d.a(getContext(), 12.0f);
        int r105 = (int) h18.d.a(getContext(), 10.0f);
        if (this.F2 == null) goto L22;
        int r106 = (((r104 * 2) + r103) + r104) + r103;
    L24:
        if (r101.getLineWidth(0) > ((r100 - r105) - r106)) goto L28;
        r102 = false;
        goto L28
    L22:
        r106 = (r104 * 2) + r103;
    L28:
        if (r102 == this.K2) goto L31;
        this.K2 = r102;
        O();
        invalidate();
        return;
    L31:
        return;
    L8:
        if (this.F2 != null) goto L10;
    }

    public final int getPressedSelectionStart() {
        Integer r100 = this.H2;
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return getSelectionStart();
    }

    public BitableTextFieldEditor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, android.text.TextPaint] */
    @Override // com.larksuite.component.universe_design.edittext.UDEditText, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = this.f208212h2;
        if (r100 == 1) goto L63;
        if (r100 == 2) goto L31;
        if (r100 == 5) goto L9;
    L74:
        super.onDraw(r110);
        return;
    L9:
        if (this.f208216y2 == null) goto L11;
    L13:
        int r101 = (int) h18.d.a(getContext(), 18.0f);
        int r102 = (int) h18.d.a(getContext(), 12.0f);
        if (this.K2 == false) goto L16;
        int r103 = ((getScrollY() + getHeight()) - r102) - r101;
    L17:
        int r104 = ((getScrollX() + getWidth()) - r102) - r101;
        int r105 = (r104 - r102) - r101;
        Drawable r106 = this.F2;
        if (r106 == null) goto L20;
        r106.setBounds(r105, r103, r105 + r101, r103 + r101);
        r106.draw(r110);
    L20:
        Drawable r107 = this.f208216y2;
        if (r107 == null) goto L23;
        r107.setBounds(r104, r103, r104 + r101, r103 + r101);
        r107.draw(r110);
    L23:
        Integer r108 = this.G2;
        if (r108 == null) goto L74;
        if (r108.intValue() == 0) goto L29;
        r104 = r105;
    L29:
        int r109 = (int) h18.d.a(getContext(), 26.0f);
        int r111 = (r109 - r101) / 2;
        int r112 = r104 - r111;
        int r113 = r103 - r111;
        int r114 = (int) h18.d.a(getContext(), 4.0f);
        TextPaint r115 = new TextPaint(1);
        r115.setColor(UDColorUtils.getColor(getContext(), R.color.fill_hover));
        float r116 = r114;
        r110.drawRoundRect(r112, r113, r112 + r109, r113 + r109, r116, r116, r115);
        goto L74
    L16:
        r103 = ((h18.d.d(getContext(), R.dimen.bitable_cell_min_height) - r101) / 2) + getScrollY();
        goto L17
    L11:
        if (this.F2 != null) goto L13;
    L31:
        if (this.I2 == null) goto L33;
    L35:
        int r117 = getScrollX() + getWidth();
        int r118 = getScrollY();
        float r119 = h18.d.a(getContext(), 4.0f);
        Ref.ObjectRef r120 = new Ref.ObjectRef();
        float r121 = 0.0f;
        if (this.I2 == null) goto L38;
        float r122 = h18.d.a(getContext(), 16.0f);
    L39:
        String r123 = this.J2;
        if (r123 == null) goto L50;
        ?? r124 = new TextPaint();
        r124.setAntiAlias(true);
        r124.setTextSize(h18.d.f(getContext(), 14.0f));
        r124.setColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        r120.element = r124;
        float r125 = r124.measureText(r123, 0, r123.length());
        if (((r122 + r119) + r125) <= getWidth()) goto L49;
        String r126 = TextUtils.ellipsize(r123, (TextPaint) r120.element, (getWidth() - r122) - r119, TextUtils.TruncateAt.END).toString();
        this.J2 = r126;
        TextPaint r127 = (TextPaint) r120.element;
        if (r127 == null) goto L50;
        if (r126 == null) goto L47;
        int r128 = r126.length();
    L48:
        r121 = r127.measureText(r126, 0, r128);
        goto L50
    L47:
        r128 = 0;
        goto L48
    L49:
        r121 = r125;
    L50:
        int r129 = (r117 - ((int) ((r122 + r119) + r121))) / 2;
        float r130 = 2;
        int r131 = (int) (r118 + ((getHeight() - r122) / r130));
        Drawable r132 = this.I2;
        if (r132 == null) goto L53;
        int r133 = (int) r122;
        r132.setBounds(r129, r131, r129 + r133, r133 + r131);
    L53:
        Drawable r134 = this.I2;
        if (r134 == null) goto L56;
        r134.draw(r110);
    L56:
        TextPaint r135 = (TextPaint) r120.element;
        if (r135 == null) goto L74;
        float r136 = (r135.getFontMetrics().ascent + r135.getFontMetrics().descent) / r130;
        String r137 = this.J2;
        if (r137 != null) goto L61;
        r137 = "";
    L61:
        r110.drawText(r137, (r129 + r122) + r119, (getHeight() / 2) - r136, r135);
        goto L74
    L38:
        r122 = 0.0f;
        goto L39
    L33:
        if (TextUtils.isEmpty(this.J2) == false) goto L35;
    L63:
        if (this.f208216y2 == null) goto L74;
        int r138 = (int) h18.d.a(getContext(), 18.0f);
        int r139 = ((getScrollX() + getWidth()) - ((int) h18.d.a(getContext(), 12.0f))) - r138;
        int r140 = getScrollY() + ((h18.d.d(getContext(), R.dimen.bitable_cell_min_height) - r138) / 2);
        Drawable r141 = this.f208216y2;
        if (r141 == null) goto L68;
        r141.setBounds(r139, r140, r139 + r138, r140 + r138);
    L68:
        Drawable r142 = this.f208216y2;
        if (r142 == null) goto L72;
        r142.draw(r110);
    L72:
        if (this.E2 == false) goto L74;
        int r143 = (int) h18.d.a(getContext(), 26.0f);
        int r144 = r139 - ((r143 - r138) / 2);
        int r145 = getScrollY() + ((h18.d.d(getContext(), R.dimen.bitable_cell_min_height) - r143) / 2);
        int r146 = (int) h18.d.a(getContext(), 4.0f);
        TextPaint r147 = new TextPaint(1);
        r147.setColor(UDColorUtils.getColor(getContext(), R.color.fill_hover));
        float r148 = r146;
        r110.drawRoundRect(r144, r145, r144 + r143, r145 + r143, r148, r148, r147);
        goto L74
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText, com.larksuite.component.universe_design.edittext.UDEditText, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.getAction() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r110.getAction() != 1) goto L9;
    L12:
        boolean r101 = true;
    L13:
        int r102 = this.f208212h2;
        if (r102 != 0) goto L16;
    L110:
        if (r101 == false) goto L115;
        b r103 = this.f208213p2;
        if (r103 == null) goto L115;
        r103.a();
    L115:
        return super.onTouchEvent(r110);
    L16:
        if (r102 != 1) goto L18;
        if (r100 == false) goto L99;
        if (r102 == 1) goto L85;
    L95:
        boolean r104 = false;
    L96:
        if (r104 == false) goto L99;
        this.E2 = true;
        invalidate();
        return true;
    L85:
        if (this.f208216y2 == null) goto L95;
        float r105 = r110.getX();
        float r106 = r110.getY();
        int r107 = (int) h18.d.a(getContext(), 42.0f);
        int r108 = h18.d.d(getContext(), R.dimen.bitable_cell_min_height);
        int r109 = (getScrollX() + getWidth()) - r107;
        int r111 = getScrollX() + getWidth();
        int r112 = getScrollY();
        int r113 = getScrollY() + r108;
        if (r105 < r109) goto L95;
        if (r105 >= r111) goto L95;
        if (r106 < r112) goto L95;
        if (r106 >= r113) goto L95;
        r104 = true;
    L99:
        if (r101 == false) goto L115;
        if (this.E2 == false) goto L107;
        b r114 = this.f208213p2;
        if (r114 == null) goto L105;
        r114.onRightIconClick();
    L105:
        this.E2 = false;
        invalidate();
        return true;
    L107:
        b r115 = this.f208213p2;
        if (r115 == null) goto L115;
        r115.a();
        goto L115
    L18:
        if (r102 != 2) goto L20;
        if (r101 == false) goto L81;
        b r116 = this.f208213p2;
        if (r116 == null) goto L81;
        r116.b();
    L81:
        return true;
    L20:
        if (r102 == 4) goto L110;
        if (r102 != 5) goto L115;
        if (r100 == false) goto L59;
        if (r102 == 5) goto L29;
    L27:
        Integer r117 = null;
    L56:
        if (r117 == null) goto L59;
        this.G2 = r117;
        this.H2 = Integer.valueOf(getSelectionStart());
        invalidate();
        return true;
    L29:
        if (this.f208216y2 == null) goto L31;
    L33:
        float r118 = r110.getX();
        float r119 = r110.getY();
        int r120 = (int) h18.d.a(getContext(), 42.0f);
        int r121 = h18.d.d(getContext(), R.dimen.bitable_cell_min_height);
        if (this.K2 == false) goto L36;
        int r122 = getScrollY() + getHeight();
        int r123 = r122 - r121;
    L38:
        if (r119 < r123) goto L27;
        if (r119 >= r122) goto L27;
        int r124 = getScrollX() + getWidth();
        int r125 = r124 - r120;
        if (this.f208216y2 == null) goto L50;
        if (r118 < r125) goto L50;
        if (r118 >= r124) goto L50;
        r117 = 0;
    L50:
        if (this.F2 == null) goto L27;
        if (r118 < (r125 - r120)) goto L27;
        if (r118 >= r125) goto L27;
        r117 = 1;
        goto L56
    L36:
        int r126 = getScrollY();
        r122 = r121 + getScrollY();
        r123 = r126;
        goto L38
    L31:
        if (this.F2 != null) goto L33;
    L59:
        if (r101 == false) goto L115;
        Integer r127 = this.G2;
        if (r127 == null) goto L74;
        if (r127 != null) goto L65;
    L69:
        c r128 = this.f208215x2;
        if (r128 == null) goto L72;
        r128.a();
    L72:
        this.G2 = null;
        this.H2 = null;
        invalidate();
        return true;
    L65:
        if (r127.intValue() != 0) goto L69;
        b r129 = this.f208213p2;
        if (r129 == null) goto L72;
        r129.onRightIconClick();
        goto L72
    L74:
        b r130 = this.f208213p2;
        if (r130 == null) goto L115;
        r130.a();
        goto L115
    L9:
        if (r110.getAction() == 3) goto L12;
        r101 = false;
        goto L13
    L5:
        r100 = false;
        goto L7
    }

    public final void setEditorActionListener(b r100) {
        this.f208213p2 = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText
    public void setFocusableAndClickable(boolean r100) {
        setFocusable(r100);
        setFocusableInTouchMode(r100);
        setClickable(r100);
        setLongClickable(r100);
    }

    public final void setOnSelectionChangedListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f208214v2 = r100;
    }

    public final void setSecondaryRightIconClickListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f208215x2 = r100;
    }

    public BitableTextFieldEditor(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static void Q(BitableTextFieldEditor r100, int r101) {
        r100.f208212h2 = r101;
        r100.O();
        r100.invalidate();
    }

    public final void P(int r100, int r101) {
        int r102 = UDColorUtils.getColor(getContext(), r101);
        this.f208216y2 = UDIconUtils.getIconDrawable(getContext(), r100, r102);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        d r102 = this.f208214v2;
        if (r102 == null) goto L6;
        r102.C(r100, r101);
        return;
    }

    public BitableTextFieldEditor(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (getBackground() != null) goto L6;
        setBackground(AppCompatResources.getDrawable(r100, R.drawable.bitable_card_field_item_bg_selector));
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        R();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        R();
    }
}
