package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001d\u000fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0017J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bR\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "index", "", "setTextSpec", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView$TextSpec;", "spec", "", "size", "setTextSize", "alpha", "setAlpha", "alphaMax", "setAlphaMax", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TextSpec", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class DuxTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer[] f194770b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<TextSpec[]> f194771c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f194772a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxTextView$TextSpec;", "", "", "getTextStyle", "H0", "H1", "H2", "H3", "H4", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "T1", "T2", "H0S", "H1S", "H2S", "H3S", "H4S", "P1S", "P2S", "P3S", "T1S", "T2S", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextSpec[] f194773a = null;

        public static TextSpec valueOf(String r100) {
            return (TextSpec) r27.a.a(TextSpec.class, r100);
        }

        public static TextSpec[] values() {
            return (TextSpec[]) f194773a.clone();
        }

        static {
            TextSpec r100 = new TextSpec("H0", 0);
            H0 = r100;
            TextSpec r101 = new TextSpec("H1", 1);
            H1 = r101;
            TextSpec r102 = new TextSpec("H2", 2);
            H2 = r102;
            TextSpec r103 = new TextSpec("H3", 3);
            H3 = r103;
            TextSpec r104 = new TextSpec("H4", 4);
            H4 = r104;
            TextSpec r105 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P1, 5);
            P1 = r105;
            TextSpec r110 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P2, 6);
            P2 = r110;
            TextSpec r111 = new TextSpec("P3", 7);
            P3 = r111;
            TextSpec r112 = new TextSpec("T1", 8);
            T1 = r112;
            TextSpec r113 = new TextSpec("T2", 9);
            T2 = r113;
            TextSpec r114 = new TextSpec("H0S", 10);
            H0S = r114;
            TextSpec r115 = new TextSpec("H1S", 11);
            H1S = r115;
            TextSpec r106 = new TextSpec("H2S", 12);
            H2S = r106;
            TextSpec r107 = new TextSpec("H3S", 13);
            H3S = r107;
            TextSpec r108 = new TextSpec("H4S", 14);
            H4S = r108;
            TextSpec r109 = new TextSpec("P1S", 15);
            P1S = r109;
            TextSpec r116 = new TextSpec("P2S", 16);
            P2S = r116;
            TextSpec r117 = new TextSpec("P3S", 17);
            P3S = r117;
            TextSpec r118 = new TextSpec("T1S", 18);
            T1S = r118;
            TextSpec r119 = new TextSpec("T2S", 19);
            T2S = r119;
            f194773a = new TextSpec[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        }

        public final int getTextStyle() {
            Integer[] r100 = DuxTextView.f194770b;
            int r101 = ordinal();
            if (r101 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L10;
            return 0;
        L10:
            return DuxTextView.f194770b[r101].intValue();
        L5:
            if (r101 >= 20) goto L7;
            r102 = true;
            goto L8
        }

        public TextSpec(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public DuxTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        new a();
        f194770b = new Integer[]{Integer.valueOf(R.style.DuxTextView_Spec_H0), Integer.valueOf(R.style.DuxTextView_Spec_H1), Integer.valueOf(R.style.DuxTextView_Spec_H2), Integer.valueOf(R.style.DuxTextView_Spec_H3), Integer.valueOf(R.style.DuxTextView_Spec_H4), Integer.valueOf(R.style.DuxTextView_Spec_P1), Integer.valueOf(R.style.DuxTextView_Spec_P2), Integer.valueOf(R.style.DuxTextView_Spec_P3), Integer.valueOf(R.style.DuxTextView_Spec_T1), Integer.valueOf(R.style.DuxTextView_Spec_T2), Integer.valueOf(R.style.DuxTextView_Spec_H0S), Integer.valueOf(R.style.DuxTextView_Spec_H1S), Integer.valueOf(R.style.DuxTextView_Spec_H2S), Integer.valueOf(R.style.DuxTextView_Spec_H3S), Integer.valueOf(R.style.DuxTextView_Spec_H4S), Integer.valueOf(R.style.DuxTextView_Spec_P1S), Integer.valueOf(R.style.DuxTextView_Spec_P2S), Integer.valueOf(R.style.DuxTextView_Spec_P3S), Integer.valueOf(R.style.DuxTextView_Spec_T1S), Integer.valueOf(R.style.DuxTextView_Spec_T2S)};
        f194771c = LazyKt.lazy(DuxTextView$TextSpecManifest$textSpecEnums$2.INSTANCE);
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        AoLogger.c("DuxTextView", new Object[]{"createAccessibilityNodeInfo Exception.", e});
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        return super.performLongClick();
    L4:
        getText();
        return false;
    }

    public final float getMaxAlpha() {
        return this.f194772a;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = this.f194772a;
        if (r101 > 0.0f) goto L5;
    L8:
        super.setAlpha(r100);
        return;
    L5:
        if (r100 <= r101) goto L8;
        super.setAlpha(r101);
    }

    public final void setAlphaMax(float r100) {
        this.f194772a = r100;
        float r101 = getAlpha();
        float r102 = this.f194772a;
        if (r101 <= r102) goto L5;
        setAlpha(r102);
    L5:
        Objects.toString(getText());
    }

    public final void setMaxAlpha(float r100) {
        this.f194772a = r100;
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Text size is not recommended", replaceWith = @ReplaceWith(expression = "setTextSpec()", imports = {}))
    public void setTextSize(float r100) {
        super.setTextSize(r100);
    }

    public final void setTextSpec(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L9;
        TextSpec r102 = f194771c.getValue()[r100];
    L10:
        if (r102 == null) goto L13;
        setTextSpec(r102);
        return;
    L13:
        return;
    L9:
        r102 = null;
        goto L10
    L4:
        if (r100 >= f194771c.getValue().length) goto L6;
        r101 = true;
        goto L7
    }

    public final void setTextSpec(TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        int r101 = r100.ordinal();
        int r102 = 0;
        if (r101 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        r102 = f194770b[r101].intValue();
    L10:
        TextViewCompat.setTextAppearance(this, r102);
        return;
    L5:
        if (r101 >= 20) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        AoLogger.c("DuxTextView", new Object[]{"onVisibilityChanged", e});
    }

    public DuxTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f194772a = 1.0f;
    }

    public /* synthetic */ DuxTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView
    public final void setShadowLayer(float r100, float r101, float r102, int r103) {
        super.setShadowLayer(r100, r101, r102, r103);
    }
}
