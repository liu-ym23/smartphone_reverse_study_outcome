package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.f;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/WeakNetLimitView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "view", "Landroid/view/View;", "setUIType", "", "uiType", "", "setTopMargin", "topMargin", "Companion", "UIType", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeakNetLimitView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f440341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f440342b;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/WeakNetLimitView$UIType;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface UIType {
        public static final int AllSidesCorner = 1;
        public static final a Companion = null;
        public static final int Normal = 2;
        public static final int TopCorner = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440343a = null;

            static {
                f440343a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440343a;
        }
    }

    public static final class a {
    }

    static {
    }

    public WeakNetLimitView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setTopMargin(int r100) {
        View r101 = this.f440342b;
        if (r101 == null) goto L8;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = r100;
        r101.setLayoutParams(r102);
        return;
    L9:
        return;
    }

    public final void setUIType(int r100) {
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L6;
        removeAllViews();
        View r101 = LayoutInflater.from(this.f440341a).inflate(R.layout.notice_internet_error_limited, this, true);
    L8:
        this.f440342b = r101;
        if (f.a(getContext()) == false) goto L11;
        Drawable r102 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_cloud_failed_outlined, UIUtils.getColor(getContext(), R.color.icon_n1));
    L12:
        View r103 = this.f440342b;
        if (r103 == null) goto L18;
        ImageView r104 = (ImageView) r103.findViewById(R.id.iv_icon_failed);
        if (r104 == null) goto L19;
        r104.setImageDrawable(r102);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r102 = UIUtils.getDrawable(getContext(), R.drawable.ud_icon_cloud_failed_outlined);
        goto L12
    L6:
        removeAllViews();
        r101 = LayoutInflater.from(this.f440341a).inflate(R.layout.notice_internet_error_limited_all_sides_circle, this, true);
        goto L8
    L7:
        removeAllViews();
        r101 = LayoutInflater.from(this.f440341a).inflate(R.layout.notice_internet_error_limited_circle, this, true);
        goto L8
    }

    public WeakNetLimitView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Context r102 = getContext();
        this.f440341a = r102;
        this.f440342b = LayoutInflater.from(r102).inflate(R.layout.notice_internet_error_limited_circle, this, true);
    }
}
