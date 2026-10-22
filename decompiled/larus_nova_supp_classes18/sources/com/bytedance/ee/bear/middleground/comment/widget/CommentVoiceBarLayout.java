package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J0\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "voiceRecordTouchBounds", "Landroid/graphics/Rect;", "voiceRecordView", "Landroid/view/View;", "getVoiceRecordView", "()Landroid/view/View;", "voiceRecordView$delegate", "Lkotlin/Lazy;", "setUiMode", "", "mode", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout$UiMode;", "toggleIconConfig", "Lcom/bytedance/ee/bear/config/CommentVoiceToggleIconConfig;", "setToggleIconConfig", "onLayout", "changed", "", "left", "top", "right", "bottom", "updateVoiceRecordTouchBounds", "applyAsideMode", "UiMode", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentVoiceBarLayout extends LinearLayoutCompat {
    public final Rect a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentVoiceBarLayout$UiMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ASIDE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UiMode extends Enum<UiMode> {
        public static final UiMode ASIDE = null;
        public static final UiMode NORMAL = null;
        public static final /* synthetic */ UiMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UiMode> getEntries() {
            return b;
        }

        static {
            UiMode r0 = new UiMode("NORMAL", 0);
            NORMAL = r0;
            UiMode r1 = new UiMode("ASIDE", 1);
            ASIDE = r1;
            UiMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static UiMode[] values() {
            return (UiMode[]) a.clone();
        }

        public static UiMode valueOf(String r1) {
            return (UiMode) r27.a.a(UiMode.class, r1);
        }

        public UiMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public CommentVoiceBarLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentVoiceBarLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final View getVoiceRecordView() {
        return (View) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setToggleIconConfig(ew4.g r2) {
        if (r2 == null) goto L6;
        Integer r3 = r2.a;
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
    L7:
        AppCompatImageView r0 = findViewById(2131387913);
        if (r0 == null) goto L11;
        r0.setImageResource(r4);
        return;
    L11:
        return;
    L6:
        r4 = 2131255102;
        goto L7
    }

    public CommentVoiceBarLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Rect();
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CommentVoiceBarLayout$voiceRecordView$2(this));
    }

    public /* synthetic */ CommentVoiceBarLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        View r6 = getVoiceRecordView();
        if (r6 != null) goto L5;
    L8:
        setTouchDelegate(null);
        return;
    L5:
        if (r6.getVisibility() != 0) goto L8;
        r6.getHitRect(this.a);
        Rect r7 = this.a;
        r7.top = 0;
        r7.bottom = getHeight();
        setTouchDelegate(new TouchDelegate(this.a, r6));
    }
}
