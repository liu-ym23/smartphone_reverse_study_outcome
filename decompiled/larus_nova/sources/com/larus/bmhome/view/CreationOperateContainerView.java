package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusCreationOperateContainerLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/CreationOperateContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/ICreationStatusChange;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isByPublisher", "", "setByPublisher", "", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusCreationOperateContainerLayoutBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusCreationOperateContainerLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "enableCreationOperator", "enable", "refreshCreationButtonStatus", "status", "ButtonStatus", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationOperateContainerView extends ConstraintLayout implements e2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f315537c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f315538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f315539b;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/view/CreationOperateContainerView$ButtonStatus;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStatus {
        public static final int AddedPrivate = 2;
        public static final int AddedPublic = 3;
        public static final a Companion = null;
        public static final int Disable = 0;
        public static final int UnAdd = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f315540a = null;

            static {
                f315540a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f315540a;
        }
    }

    public CreationOperateContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationOperateContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LarusCreationOperateContainerLayoutBinding getBinding() {
        return (LarusCreationOperateContainerLayoutBinding) this.f315539b.getValue();
    }

    @Override // com.larus.bmhome.view.e2
    public final void r1(int r100) {
        if (AppHost.f326268a.isOversea() == false) goto L7;
        setVisibility(8);
        return;
    L7:
        if (r100 != 1) goto L9;
    L39:
        ConstraintLayout r101 = getBinding().f326649c;
        if (r101 == null) goto L42;
        r101.setVisibility(4);
    L42:
        Button r102 = getBinding().f326648b;
        if (r102 == null) goto L45;
        r102.setVisibility(4);
    L45:
        ConstraintLayout r103 = getBinding().f326651e;
        if (r103 == null) goto L49;
        com.larus.utils.e1.x(r103);
    L49:
        if (this.f315538a == false) goto L51;
        getBinding().f326653g.setText(getContext().getText(R.string.larus_imageDetail_btn_post));
        com.larus.utils.e1.o(getBinding().f326652f);
        return;
    L51:
        getBinding().f326653g.setText(R.string.larus_creationPreview_btn_publish);
        com.larus.utils.e1.x(getBinding().f326652f);
        return;
    L9:
        if (r100 == 2) goto L39;
        if (r100 == 3) goto L21;
        ConstraintLayout r104 = getBinding().f326649c;
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        Button r105 = getBinding().f326648b;
        if (r105 == null) goto L18;
        r105.setVisibility(8);
    L18:
        ConstraintLayout r106 = getBinding().f326651e;
        if (r106 == null) goto L53;
        r106.setVisibility(8);
        return;
    L53:
        return;
    L21:
        ConstraintLayout r107 = getBinding().f326649c;
        if (r107 == null) goto L24;
        com.larus.utils.e1.x(r107);
    L24:
        AppCompatTextView r108 = getBinding().f326650d;
        if (r108 == null) goto L33;
        Context r109 = getContext();
        if (r109 == null) goto L31;
        String r110 = r109.getString(R.string.larus_ccMob_PreviewPage_dropdown_public);
        if (r110 == null) goto L31;
    L32:
        r108.setText(r110);
    L31:
        r110 = "";
    L33:
        Button r111 = getBinding().f326648b;
        if (r111 == null) goto L36;
        r111.setVisibility(4);
    L36:
        ConstraintLayout r112 = getBinding().f326651e;
        if (r112 == null) goto L55;
        r112.setVisibility(4);
        return;
    }

    @Override // com.larus.bmhome.view.e2
    public void setByPublisher(boolean r100) {
        this.f315538a = r100;
        FLogger.f375446a.d("CreationOperateContainerView", "isByPublisher: " + r100);
    }

    public CreationOperateContainerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315539b = LazyKt.lazy(new y1(r100, this));
        com.larus.utils.w0.e(getBinding().f326648b, j19.c.c(12));
        com.larus.utils.w0.e(getBinding().f326651e, j19.c.c(12));
        getBinding().f326648b.setBackground(com.larus.utils.w0.b(Integer.valueOf(r100.getResources().getColor(R.color.larus_static_white)), null, 0.2f, null, 8));
        getBinding().f326651e.setBackground(com.larus.utils.w0.b(Integer.valueOf(r100.getResources().getColor(R.color.larus_static_white)), null, 0.2f, null, 8));
    }

    public /* synthetic */ CreationOperateContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
