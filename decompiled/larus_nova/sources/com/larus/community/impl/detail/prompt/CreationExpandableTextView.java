package com.larus.community.impl.detail.prompt;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0013J\u0014\u0010%\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$J\u0006\u0010\u000e\u001a\u00020\u000fJ\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fullText", "", "expandText", "maxLines", "isExpanded", "", "expandTextColor", "isCalculated", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onSizeChanged", "w", "h", "oldw", "oldh", "updateText", "setMaxCollapsedLines", "setExpandText", "setExpandTextColor", "color", BitableAnalytic.LinkSceneClickType.EXPAND, "expandAction", "Lkotlin/Function0;", "setExpandListener", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "SavedState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationExpandableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f329404h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f329405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f329406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f329407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f329408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f329409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f329410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f329411g;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationExpandableTextView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isExpanded", "", "()Z", "setExpanded", "(Z)V", "fullText", "", "getFullText", "()Ljava/lang/String;", "setFullText", "(Ljava/lang/String;)V", "writeToParcel", "", Argument.OUT, "flags", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f329412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f329413b;

        public static final class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "source");
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            String r101 = "";
            this.f329413b = "";
            boolean r102 = true;
            if (r100.readInt() == 1) goto L6;
            r102 = false;
        L6:
            this.f329412a = r102;
            String r103 = r100.readString();
            if (r103 == null) goto L10;
            r101 = r103;
        L10:
            this.f329413b = r101;
        }

        public SavedState(Parcelable r100) {
            super(r100);
            this.f329413b = "";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f329412a ? 1 : 0);
            r100.writeString(this.f329413b);
        }
    }

    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationExpandableTextView f329414a;

        /* JADX INFO: renamed from: com.larus.community.impl.detail.prompt.CreationExpandableTextView$a$a, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnGlobalLayoutListenerC4194a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CreationExpandableTextView f329415a;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f329415a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Function0<Unit> r100 = this.f329415a.f329411g;
                if (r100 == null) goto L6;
                r100.invoke();
                return;
            }

            public ViewTreeObserverOnGlobalLayoutListenerC4194a(CreationExpandableTextView r100) {
                this.f329415a = r100;
            }
        }

        public a(CreationExpandableTextView r100) {
            this.f329414a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f329414a.setMaxLines(Integer.MAX_VALUE);
            CreationExpandableTextView r101 = this.f329414a;
            CreationExpandableTextView.y(r101, r101.f329405a, TextView.BufferType.NORMAL);
            CreationExpandableTextView r102 = this.f329414a;
            r102.f329408d = true;
            r102.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4194a(this.f329414a));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            super.updateDrawState(r100);
            r100.setColor(this.f329414a.f329409e);
            r100.setUnderlineText(false);
        }
    }

    public CreationExpandableTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationExpandableTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void x(CreationExpandableTextView r100) {
        setText$lambda$2(r100);
    }

    public final void z() {
        if (this.f329408d == false) goto L26;
        super.setText(this.f329405a, TextView.BufferType.NORMAL);
        this.f329410f = true;
        return;
    L26:
        super.setText(this.f329405a, TextView.BufferType.NORMAL);     // Catch: Exception -> L23
        setMaxLines(this.f329407c);     // Catch: Exception -> L23
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Exception -> L23
        Layout r100 = getLayout();     // Catch: Exception -> L23
        if (r100 == null) goto L29;
        int r101 = getLineCount();     // Catch: Exception -> L23
        int r102 = this.f329407c;     // Catch: Exception -> L23
        if (r101 > r102) goto L12;
        super.setText(this.f329405a, TextView.BufferType.NORMAL);     // Catch: Exception -> L23
        this.f329410f = true;     // Catch: Exception -> L23
        return;
    L12:
        int r103 = r102 - 1;     // Catch: Exception -> L23
        int r104 = r100.getLineEnd(r103);     // Catch: Exception -> L23
        r100.getLineVisibleEnd(r103);     // Catch: Exception -> L23
        int r105 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();     // Catch: Exception -> L23
        float r106 = getPaint().measureText(this.f329406b);     // Catch: Exception -> L23
        float r107 = getPaint().measureText("...");     // Catch: Exception -> L23
        float r108 = r100.getLineWidth(r103);     // Catch: Exception -> L23
        String r109 = this.f329405a.substring(r100.getLineStart(r103), r104);     // Catch: Exception -> L23
        int r110 = 0;
    L14:
        if (((r108 + r106) + r107) <= r105) goto L18;
        if (r110 >= r109.length()) goto L18;
        r110 = r110 + 1;     // Catch: Exception -> L23
        r108 = getPaint().measureText(r109.substring(0, r109.length() - r110));     // Catch: Exception -> L23
    L18:
        int r111 = (r104 - r110) - 3;     // Catch: Exception -> L23
        if (r111 > 0) goto L21;
        return;
    L21:
        String r112 = this.f329405a.substring(0, r111) + "...";     // Catch: Exception -> L23
        SpannableString r113 = new SpannableString(r112 + this.f329406b);     // Catch: Exception -> L23
        r113.setSpan(new a(this), r112.length(), r112.length() + this.f329406b.length(), 33);     // Catch: Exception -> L23
        super.setText(r113, TextView.BufferType.SPANNABLE);     // Catch: Exception -> L23
        setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Exception -> L23
        this.f329410f = true;     // Catch: Exception -> L23
        return;
    L29:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        super.setText(this.f329405a, TextView.BufferType.NORMAL);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f329412a = this.f329408d;
        String r101 = this.f329405a;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f329413b = r101;
        return r100;
    }

    private static final void setText$lambda$2(CreationExpandableTextView r100) {
        if (r100.getLineCount() <= r100.f329407c) goto L5;
        r100.z();
        return;
    L5:
        r100.f329410f = true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        boolean r102 = r101.f329412a;
        this.f329408d = r102;
        this.f329405a = r101.f329413b;
        if (r102 == false) goto L9;
        setMaxLines(Integer.MAX_VALUE);
        setText(this.f329405a, TextView.BufferType.NORMAL);
        return;
    L9:
        setMaxLines(this.f329407c);
        post(new r(this));
    }

    public final void setExpandListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "expandAction");
        this.f329411g = r100;
    }

    public final void setExpandText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "expandText");
        this.f329406b = r100;
        if (this.f329408d == true) goto L6;
        z();
        return;
    }

    public final void setExpandTextColor(int r100) {
        this.f329409e = r100;
        if (this.f329408d == true) goto L6;
        z();
        return;
    }

    public final void setMaxCollapsedLines(int r100) {
        this.f329407c = r100;
        if (this.f329408d == true) goto L6;
        setMaxLines(r100);
        z();
        return;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        String r102 = r100.toString();
        this.f329405a = r102;
        this.f329410f = false;
        if (this.f329408d == false) goto L6;
        super.setText(r102, r101);
        return;
    L6:
        super.setText(r100, r101);
        post(new t(this));
    }

    public CreationExpandableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f329405a = "";
        this.f329406b = r100.getString(R.string.larus_load_more);
        this.f329407c = 3;
        this.f329409e = r100.getResources().getColor(R.color.larus_neutral_50);
        if (r101 == null) goto L8;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_community_expand_text, R.attr.larus_community_expand_text_color, R.attr.larus_community_max_collapsed_lines}, 0, 0);
        this.f329407c = r103.getInt(2, 3);
        String r104 = r103.getString(0);
        if (r104 != null) goto L7;
        r104 = " " + r100.getString(R.string.larus_load_more);
    L7:
        this.f329406b = r104;
        this.f329409e = r103.getColor(1, r100.getResources().getColor(R.color.larus_neutral_50));
        r103.recycle();
    L8:
        setMaxLines(this.f329407c);
    }

    public static final /* synthetic */ void y(CreationExpandableTextView r100, CharSequence r101, TextView.BufferType r102) {
        super.setText(r101, r102);
    }

    public /* synthetic */ CreationExpandableTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        return;
    L5:
        if (this.f329410f == false) goto L7;
        return;
    L7:
        if (this.f329408d == false) goto L9;
        return;
    L9:
        if (this.f329405a.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L18;
        post(new s(this));
        return;
    L18:
        return;
    L11:
        r104 = false;
        goto L12
    }
}
