package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/NoNetView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "setBgColor", "", "bgColor", "", "setErrorType", "errorType", "(Ljava/lang/Integer;)V", "Companion", "BgColor", "ErrorType", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoNetView extends FrameLayout {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/NoNetView$BgColor;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BgColor {
        public static final a Companion = null;
        public static final int Gray = 0;
        public static final int White = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440339a = null;

            static {
                f440339a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440339a;
        }
    }

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/NoNetView$ErrorType;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ErrorType {
        public static final a Companion = null;
        public static final int NetError = 0;
        public static final int ServerError = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440340a = null;

            static {
                f440340a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440340a;
        }
    }

    public static final class a {
    }

    static {
    }

    public NoNetView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBgColor(int r100) {
        if (r100 != 0) goto L4;
        setBackgroundColor(d.c(getContext(), R.color.ud_N100));
        return;
    L4:
        setBackgroundColor(d.c(getContext(), R.color.ud_N00));
    }

    public final void setErrorType(Integer r100) {
        if (r100 != null) goto L6;
    L8:
        ((TextView) findViewById(R.id.tv_no_result)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_ServerError_Text));
        ((TextView) findViewById(R.id.tv_check_error)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_ServerError_Desc));
        ((TextView) findViewById(R.id.tv_retry_click)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_ServerError_Retry));
        return;
    L6:
        if (r100.intValue() != 0) goto L8;
        ((TextView) findViewById(R.id.tv_no_result)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_InternetErrorNoResults_TitlePC));
        ((TextView) findViewById(R.id.tv_check_error)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_NoInternetCheckSettings_NoticeMobile));
        ((TextView) findViewById(R.id.tv_retry_click)).setText(UIHelper.getString(R.string.Lark_ASLSearch_WeakNetworkNotice_NoInternetCheckSettings_RetryMobile));
    }

    public NoNetView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.notice_no_internet_error, this, true);
    }
}
