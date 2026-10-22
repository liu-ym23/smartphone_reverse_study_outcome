package com.ss.android.lark.biz.im.api.chat.setting;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u001fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u001fJ\b\u0010/\u001a\u00020\u001fH\u0014J\b\u00100\u001a\u00020\u001fH\u0014J\b\u00101\u001a\u00020\u001fH\u0014J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u00102\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0014J6\u00103\u001a\u0002042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010 \u001a\u00020\u001fH\u0005J\u000e\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u001fJ\u0010\u00107\u001a\u0002042\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/SettingNavigationPiece;", "Lcom/ss/android/lark/biz/im/api/chat/setting/SettingBasePiece;", "<init>", "()V", "titleView", "Landroid/widget/TextView;", "subtitleView", "statusView", "Landroid/view/View;", "rightArrow", "Landroid/widget/ImageView;", "redDotView", "startExtraView", "getStartExtraView", "()Landroid/view/View;", "setStartExtraView", "(Landroid/view/View;)V", "titleStr", "", "subtitleStr", "getSubtitleStr", "()Ljava/lang/String;", "setSubtitleStr", "(Ljava/lang/String;)V", "statusStr", "", "getStatusStr", "()Ljava/lang/CharSequence;", "setStatusStr", "(Ljava/lang/CharSequence;)V", "arrowVisibility", "", "redDotVisibility", "pieceStyle", "redDotSize", "arrowSize", "getView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "layoutConfig", "Landroid/view/ViewGroup$MarginLayoutParams;", "title", "subtitle", "status", "arrowVisible", RemoteMessageConst.Notification.VISIBILITY, "redDotVisible", "titleRes", "subtitleRes", "statusRes", "getStatusView", "updateViewProperty", "", "updateViewStyle", "style", "updateViewLayout", "PieceStyle", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SettingNavigationPiece extends SettingBasePiece<SettingNavigationPiece> {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/SettingNavigationPiece$PieceStyle;", "", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PieceStyle {
        public static final a Companion = null;
        public static final int DISABLE = 2;
        public static final int ENABLE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f410075a = null;

            static {
                f410075a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f410075a;
        }
    }

    public SettingNavigationPiece() {
    }
}
