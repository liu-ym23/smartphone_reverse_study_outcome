package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001d\u000fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0017J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bR\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "index", "", "setTextSpec", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView$TextSpec;", "spec", "", "size", "setTextSize", "alpha", "setAlpha", "alphaMax", "setAlphaMax", "a", "F", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TextSpec", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class DuxTextView extends AppCompatTextView {
    public static final Integer[] b = null;
    public static final Lazy<TextSpec[]> c = null;
    public float a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView$TextSpec;", "", "", "getTextStyle", "H0", "H1", "H2", "H3", "H4", "P1", "P2", "P3", "T1", "T2", "H0S", "H1S", "H2S", "H3S", "H4S", "P1S", "P2S", "P3S", "T1S", "T2S", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum TextSpec extends Enum<TextSpec> {
        public static final TextSpec H0 = null;
        public static final TextSpec H0S = null;
        public static final TextSpec H1 = null;
        public static final TextSpec H1S = null;
        public static final TextSpec H2 = null;
        public static final TextSpec H2S = null;
        public static final TextSpec H3 = null;
        public static final TextSpec H3S = null;
        public static final TextSpec H4 = null;
        public static final TextSpec H4S = null;
        public static final TextSpec P1 = null;
        public static final TextSpec P1S = null;
        public static final TextSpec P2 = null;
        public static final TextSpec P2S = null;
        public static final TextSpec P3 = null;
        public static final TextSpec P3S = null;
        public static final TextSpec T1 = null;
        public static final TextSpec T1S = null;
        public static final TextSpec T2 = null;
        public static final TextSpec T2S = null;
        public static final /* synthetic */ TextSpec[] a = null;

        public static TextSpec valueOf(String r1) {
            return (TextSpec) r27.a.a(TextSpec.class, r1);
        }

        public static TextSpec[] values() {
            return (TextSpec[]) a.clone();
        }

        static {
            TextSpec r0 = new TextSpec("H0", 0);
            H0 = r0;
            TextSpec r1 = new TextSpec("H1", 1);
            H1 = r1;
            TextSpec r3 = new TextSpec("H2", 2);
            H2 = r3;
            TextSpec r5 = new TextSpec("H3", 3);
            H3 = r5;
            TextSpec r7 = new TextSpec("H4", 4);
            H4 = r7;
            TextSpec r9 = new TextSpec("P1", 5);
            P1 = r9;
            TextSpec r11 = new TextSpec("P2", 6);
            P2 = r11;
            TextSpec r13 = new TextSpec("P3", 7);
            P3 = r13;
            TextSpec r15 = new TextSpec("T1", 8);
            T1 = r15;
            TextSpec r14 = new TextSpec("T2", 9);
            T2 = r14;
            TextSpec r12 = new TextSpec("H0S", 10);
            H0S = r12;
            TextSpec r10 = new TextSpec("H1S", 11);
            H1S = r10;
            TextSpec r8 = new TextSpec("H2S", 12);
            H2S = r8;
            TextSpec r6 = new TextSpec("H3S", 13);
            H3S = r6;
            TextSpec r4 = new TextSpec("H4S", 14);
            H4S = r4;
            TextSpec r2 = new TextSpec("P1S", 15);
            P1S = r2;
            TextSpec r16 = new TextSpec("P2S", 16);
            P2S = r16;
            TextSpec r17 = new TextSpec("P3S", 17);
            P3S = r17;
            TextSpec r18 = new TextSpec("T1S", 18);
            T1S = r18;
            TextSpec r19 = new TextSpec("T2S", 19);
            T2S = r19;
            a = new TextSpec[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        }

        public final int getTextStyle() {
            Integer[] r0 = DuxTextView.b;
            int r1 = ordinal();
            if (r1 >= 0) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L10;
            return 0;
        L10:
            return DuxTextView.b[r1].intValue();
        L5:
            if (r1 >= 20) goto L7;
            r2 = true;
            goto L8
        }

        public TextSpec(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public DuxTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DuxTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        new a();
        b = new Integer[]{2131952296, 2131952298, 2131952300, 2131952302, 2131952304, 2131952306, 2131952308, 2131952310, 2131952313, 2131952315, 2131952297, 2131952299, 2131952301, 2131952303, 2131952305, 2131952307, 2131952309, 2131952311, 2131952314, 2131952316};
        c = LazyKt.lazy(DuxTextView$TextSpecManifest$textSpecEnums$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super/*android.widget.TextView*/.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        AoLogger.c("DuxTextView", new Object[]{"createAccessibilityNodeInfo Exception.", e});
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performLongClick() {
        return super/*android.widget.TextView*/.performLongClick();
    L4:
        getText();
        return false;
    }

    public final float getMaxAlpha() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAlpha(float r3) {
        float r0 = this.a;
        if (r0 > 0.0f) goto L5;
    L8:
        super/*android.widget.TextView*/.setAlpha(r3);
        return;
    L5:
        if (r3 <= r0) goto L8;
        super/*android.widget.TextView*/.setAlpha(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAlphaMax(float r2) {
        this.a = r2;
        float r3 = getAlpha();
        float r0 = this.a;
        if (r3 <= r0) goto L5;
        setAlpha(r0);
    L5:
        Objects.toString(getText());
    }

    public final void setMaxAlpha(float r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Text size is not recommended", replaceWith = @ReplaceWith(expression = "setTextSpec()", imports = {}))
    public void setTextSize(float r1) {
        super/*android.widget.TextView*/.setTextSize(r1);
    }

    public final void setTextSpec(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L9;
        TextSpec r3 = ((TextSpec[]) c.getValue())[r2];
    L10:
        if (r3 == null) goto L13;
        setTextSpec(r3);
        return;
    L13:
        return;
    L9:
        r3 = null;
        goto L10
    L4:
        if (r2 >= ((TextSpec[]) c.getValue()).length) goto L6;
        r0 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSpec(TextSpec r3) {
        Intrinsics.checkNotNullParameter(r3, "spec");
        int r4 = r3.ordinal();
        int r0 = 0;
        if (r4 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        r0 = b[r4].intValue();
    L10:
        TextViewCompat.setTextAppearance(this, r0);
        return;
    L5:
        if (r4 >= 20) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "changedView");
        super/*android.widget.TextView*/.onVisibilityChanged(r3, r4);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        AoLogger.c("DuxTextView", new Object[]{"onVisibilityChanged", e});
    }

    public DuxTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = 1.0f;
    }

    public /* synthetic */ DuxTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setShadowLayer(float r1, float r2, float r3, int r4) {
        super/*android.widget.TextView*/.setShadowLayer(r1, r2, r3, r4);
    }
}
