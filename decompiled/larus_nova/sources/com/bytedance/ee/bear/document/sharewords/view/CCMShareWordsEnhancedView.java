package com.bytedance.ee.bear.document.sharewords.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.CustomTarget;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.o0;
import com.larus.nova.R;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 k2\u00020\u0001:\u0002klB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0016J\"\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\"\u00105\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016JJ\u00106\u001a\u00020\f2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u00010&2\b\u0010;\u001a\u0004\u0018\u00010&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010<\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u0010=\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010?\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J@\u0010@\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00103\u001a\u0004\u0018\u0001042\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u001e2\b\u0010E\u001a\u0004\u0018\u00010 2\b\u0010F\u001a\u0004\u0018\u00010/H\u0016J>\u0010G\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010H\u001a\u00020I2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010F\u001a\u0004\u0018\u00010/2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016JJ\u0010M\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\"\u0010R\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u0010S\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010T\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010U\u001a\u00020\f2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020\fH\u0016J \u0010Y\u001a\u00020\f2\u0006\u00101\u001a\u0002022\u0006\u0010>\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010Z\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010[\u001a\u00020\\2\u0006\u00101\u001a\u000202H\u0002J \u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020\fH\u0002J\b\u0010e\u001a\u00020\fH\u0002J\b\u0010f\u001a\u00020gH\u0002J\u0018\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0i2\u0006\u0010b\u001a\u00020cH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView;", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView;", "thumbnailRequest", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;", "<init>", "(Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "previewContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "previewLoadingContainer", "previewDeleteContainer", "previewImgContent", "previewFailContent", "previewImage", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "retryBtn", "Landroidx/appcompat/widget/AppCompatButton;", "tag", "", "skeletonAnimator", "Lcom/bytedance/ee/bear/document/sharewords/view/SkeletonAnimator;", "mDialogController", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$DialogController;", "mDataDependency", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ForwardCustomDataDependency;", "glideUrl", "Lcom/bytedance/ee/bear/thumbnail/ThumbGlideUrl;", "commentCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "commentTip", "Landroid/widget/TextView;", "shareWordsAnalytic", "Lcom/bytedance/ee/bear/document/sharewords/analytic/ShareWordsAnalytic;", "onInterceptForwardDialog", "", "targetList", "", "Lcom/ss/android/lark/forwardv2/dto/ForwardTarget;", "extra", "Landroid/os/Bundle;", "showForwardDialog", "activity", "Landroid/app/Activity;", "handler", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardEnhancedView$ExecuteHandler;", "onInterceptBasicDialogDataRender", "interceptBasicDialogDataRender", "thumbnailIV", "Lpl/droidsonroids/gif/GifImageView;", "titleTV", "contentTV", "descTV", "onInterceptBasicDialogView", "interceptBasicDialogView", "contentParent", "onInterceptForward", "interceptForward", "forwardTemplate", "Lcom/ss/android/lark/forwardv2/dto/ForwardTemplate;", "init", "controller", "dataDependency", "extraParam", "onViewClicked", "sourceFragment", "Landroidx/fragment/app/Fragment;", "uncertainTargetList", "view", "Landroid/view/View;", "interceptBasicDialogViewWithContent", "viewContent", "Lcom/ss/android/lark/forwardv2/dto/template/BasicDialogContent;", "imageLoader", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ImageLoader;", "onInterceptBottomCustomView", "interceptBottomCustomView", "onAdditionNoteChanged", "afterAdditionNoteChange", "note", "Landroid/text/Editable;", LiveCommonConstants.REASON_ON_DEDTROY, "bindPreview", "handleThumbnailResponse", "getResponseListener", "Lcom/bytedance/ee/bear/document/sharewords/ShareWordsProcessor$ResponseListener;", "loadThumbnail", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "response", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailResponse;", "startTimeStamp", "", "loading", "loadFailed", "isRealLoadReady", "Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView$LoadStatus;", "getTargetView", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "CREATOR", "LoadStatus", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMShareWordsEnhancedView implements ForwardClickableEnhancedView {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareWordsThumbnailRequest f221804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f221805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f221806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f221807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout f221808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout f221809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LKUIRoundedImageView2 f221810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatButton f221811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f221812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f221813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ForwardClickableEnhancedView.a f221814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ForwardClickableEnhancedView.b f221815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ThumbGlideUrl f221816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UDCheckBox f221817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f221818o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t35.a f221819p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView$LoadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED_CODE", "FAILED_NEW_DEFAULT", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadStatus extends Enum<LoadStatus> {
        public static final LoadStatus FAILED_CODE = null;
        public static final LoadStatus FAILED_NEW_DEFAULT = null;
        public static final LoadStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadStatus[] f221820a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f221821b = null;

        public static EnumEntries<LoadStatus> getEntries() {
            return f221821b;
        }

        static {
            LoadStatus r100 = new LoadStatus("SUCCESS", 0);
            SUCCESS = r100;
            LoadStatus r101 = new LoadStatus("FAILED_CODE", 1);
            FAILED_CODE = r101;
            LoadStatus r102 = new LoadStatus("FAILED_NEW_DEFAULT", 2);
            FAILED_NEW_DEFAULT = r102;
            LoadStatus[] r103 = {r100, r101, r102};
            f221820a = r103;
            f221821b = EnumEntriesKt.enumEntries(r103);
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) f221820a.clone();
        }

        public static LoadStatus valueOf(String r100) {
            return (LoadStatus) r27.a.a(LoadStatus.class, r100);
        }

        public LoadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements Parcelable.Creator<CCMShareWordsEnhancedView> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CCMShareWordsEnhancedView createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CCMShareWordsEnhancedView((ShareWordsThumbnailRequest) r100.readParcelable(CCMShareWordsEnhancedView.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CCMShareWordsEnhancedView[] newArray(int r100) {
            return new CCMShareWordsEnhancedView[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean A() {
        return true;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean D1(List r100) {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void V(GifImageView r100, TextView r101, TextView r102, Bundle r103) {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void d0(com.ss.android.lark.forwardv2.impl.view.e r100) {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final boolean n0() {
        return true;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void q0() {
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void s0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceFragment");
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final boolean y() {
        return false;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView
    public final void y1() {
    }

    public final void b() {
        ForwardClickableEnhancedView.a r100 = this.f221814k;
        if (r100 == null) goto L5;
        r100.a(false);
    L5:
        ConstraintLayout r101 = this.f221808e;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        ConstraintLayout r102 = this.f221809f;
        if (r102 == null) goto L11;
        r102.setVisibility(0);
    L11:
        ConstraintLayout r103 = this.f221806c;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        ConstraintLayout r104 = this.f221807d;
        if (r104 == null) goto L17;
        r104.setVisibility(8);
    L17:
        n r105 = this.f221813j;
        if (r105 == null) goto L27;
        tt5.a.d("SkeletonAnimator", "onLoadFailed(): ");
        Object r106 = r105.f221855b.getParent();
        if ((r106 instanceof View) == false) goto L22;
        View r107 = (View) r106;
    L23:
        if (r107 == null) goto L25;
        r107.setVisibility(8);
    L25:
        r105.c();
        r105.f221854a.setScaleType(ImageView.ScaleType.CENTER);
        r105.f221854a.setImageDrawable(null);
        return;
    L22:
        r107 = null;
        goto L23
    }

    public final void d() {
        ForwardClickableEnhancedView.a r100 = this.f221814k;
        if (r100 == null) goto L5;
        r100.a(false);
    L5:
        ConstraintLayout r101 = this.f221808e;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        ConstraintLayout r102 = this.f221809f;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        ConstraintLayout r103 = this.f221806c;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
    L14:
        ConstraintLayout r104 = this.f221807d;
        if (r104 == null) goto L17;
        r104.setVisibility(8);
    L17:
        n r105 = this.f221813j;
        if (r105 == null) goto L21;
        int r106 = r105.f221856c;
        lt7.d.a r107 = u.a(r105.f221855b);
        r107.f510707b = r106;
        r107.a(R.color.ccmtoken_message_card_paragraph_loading_bg);
        r105.f221857d = r107.b();
        return;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final boolean e0() {
        ShareWordsThumbnailRequest r100 = this.f221804a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f221791e != true) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void onDestroy() {
        n r100 = this.f221813j;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        com.bytedance.ee.bear.document.sharewords.d r101 = com.bytedance.ee.bear.document.sharewords.g.f221797a;
        com.bytedance.ee.bear.document.sharewords.g.f221800d = null;
        com.bytedance.ee.bear.document.sharewords.g.f221797a.f221794a.clear();
    }

    public CCMShareWordsEnhancedView(ShareWordsThumbnailRequest r100) {
        this.f221804a = r100;
        this.f221812i = "CCMShareWordsEnhancedView" + hashCode();
        this.f221819p = new t35.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
    }

    public static final LoadStatus a(CCMShareWordsEnhancedView r100) {
        ThumbGlideUrl r101 = r100.f221816m;
        if (r101 == null) goto L26;
        Map<String, List<String>> r102 = r101.getResponseHeaders();
        if (r102 == null) goto L26;
        List<String> r103 = r102.get("fail-code");
        boolean r104 = true;
        if (r103 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
    L16:
        List<String> r106 = r102.get("access-new-default-thumbnail");
        if (r106 != null) goto L19;
    L21:
        r104 = false;
    L22:
        if (r104 == false) goto L26;
        if (TextUtils.equals((CharSequence) ListProtector.get(r106, 0), "true") == false) goto L26;
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady anchorNewDefault false");
        return LoadStatus.FAILED_NEW_DEFAULT;
    L19:
        if ((!r106.isEmpty()) != true) goto L21;
    L14:
        if (TextUtils.equals((CharSequence) ListProtector.get(r103, 0), "21016") == false) goto L16;
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady anchorFailCode false");
        return LoadStatus.FAILED_CODE;
    L9:
        if ((!r103.isEmpty()) != true) goto L11;
        r105 = true;
    L26:
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady true");
        return LoadStatus.SUCCESS;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void k1(Editable r100) {
        ShareWordsThumbnailRequest r101 = this.f221804a;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L14;
        if (r100 == null) goto L11;
        int r104 = r100.length();
    L12:
        if (r104 <= 0) goto L14;
    L15:
        UDCheckBox r105 = this.f221817n;
        if (r105 == null) goto L18;
        r105.setClickable(r102);
    L18:
        UDCheckBox r106 = this.f221817n;
        if (r106 == null) goto L21;
        r106.setEnabled(r102);
    L21:
        TextView r107 = this.f221818o;
        if (r107 == null) goto L29;
        Context r108 = r107.getContext();
        if (r102 == false) goto L26;
        int r109 = R.color.text_title;
    L27:
        r107.setTextColor(UIUtils.getColor(r108, r109));
        return;
    L26:
        r109 = R.color.text_disable;
        goto L27
    L29:
        return;
    L11:
        r104 = 0;
    L14:
        r102 = false;
        goto L15
    L5:
        if (r101.f221790d != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void l(ForwardClickableEnhancedView.a r100, ForwardClickableEnhancedView.b r101) {
        this.f221814k = r100;
        this.f221815l = r101;
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void t1(Activity r100, ConstraintLayout r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.getChildCount() > 0) goto L16;
        ShareWordsThumbnailRequest r102 = this.f221804a;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L17;
        View r104 = o0.a(r101).inflate(R.layout.dialog_share_work_external, r101, true);
        UDCheckBox r105 = (UDCheckBox) r104.findViewById(R.id.commentCheckBox);
        r105.setClickable(false);
        r105.setEnabled(false);
        r105.setOnCheckedChangeListener(new e(this));
        this.f221817n = r105;
        this.f221818o = (TextView) r104.findViewById(R.id.commentTip);
        r101.setOnClickListener(new f(this));
        return;
    L17:
        return;
    L8:
        if (r102.f221791e != true) goto L10;
        r103 = true;
        goto L11
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f221804a, r101);
    }

    public final void c(Context r110, ShareWordsThumbnailResponse r210, long r211) {
        Log.i(this.f221812i, "loadThumbnail url=" + du5.b.k(r210.getUrl()));     // Catch: Exception -> L18
        LKUIRoundedImageView2 r100 = this.f221810g;     // Catch: Exception -> L18
        if (r100 == null) goto L23;
        MultiTransformation r101 = new MultiTransformation(new Transformation[]{new CenterCrop()});     // Catch: Exception -> L18
        ShareWordsThumbnailRequest r102 = this.f221804a;     // Catch: Exception -> L18
        if (r102 == null) goto L8;
        int r111 = r102.f221788b;     // Catch: Exception -> L18
    L9:
        ThumbGlideUrl r103 = this.f221816m;     // Catch: Exception -> L18
        if (r103 == null) goto L12;
        Map<String, List<String>> r104 = r103.getResponseHeaders();     // Catch: Exception -> L18
    L13:
        this.f221816m = new ThumbGlideUrl("", r210.getUrl(), r111, r210.getDecryptType(), r210.getDecryptKey(), "", ThumbGlideUrl.SOURCE_SHARE_WORDS, true, r100);     // Catch: Exception -> L18
        Log.i(this.f221812i, "loadThumbnail load start");     // Catch: Exception -> L18
        ThumbGlideUrl r105 = this.f221816m;     // Catch: Exception -> L18
        if (r105 == null) goto L16;
        r105.setResponseHeaders(r104);     // Catch: Exception -> L18
    L16:
        CustomTarget r106 = (CustomTarget) Glide.with(r110).asBitmap().transform(r101).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(false).load(this.f221816m).into(new d(this, r211, System.currentTimeMillis()));     // Catch: Exception -> L18
        return;
    L12:
        r104 = null;
        goto L13
    L8:
        r111 = -1;
        goto L9
    L23:
        return;
    L18:
        e = move-exception;
        Log.e("CCMShareWordsEnhancedView", "glideLoadThumbnail err : " + e.getMessage());
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView
    public final void f(Activity r100, ConstraintLayout r101, BasicDialogContent r102) {
        if (r100 == null) goto L45;
        if (r101 == null) goto L45;
        if (r102 == null) goto L45;
        r100.getLayoutInflater().inflate(R.layout.docx_share_words_preview_content, r101);
        this.f221805b = (ConstraintLayout) r101.findViewById(R.id.layout_preview_content);
        this.f221806c = (ConstraintLayout) r101.findViewById(R.id.loading_replace_container);
        this.f221807d = (ConstraintLayout) r101.findViewById(R.id.layout_preview_fail_reveal);
        this.f221808e = (ConstraintLayout) r101.findViewById(R.id.layout_img_content);
        this.f221809f = (ConstraintLayout) r101.findViewById(R.id.layout_preview_fail_content);
        this.f221810g = (LKUIRoundedImageView2) r101.findViewById(R.id.iv_share_words_preview);
        Drawable r103 = com.bytedance.ee.util.ui.n.m(r100, R.drawable.docs_share_words_image_mask);
        LKUIRoundedImageView2 r104 = this.f221810g;
        if (r104 == null) goto L11;
        ViewOverlay r105 = r104.getOverlay();
        if (r105 == null) goto L11;
        r105.add(r103);
    L11:
        LKUIRoundedImageView2 r106 = this.f221810g;
        if (r106 == null) goto L14;
        r106.addOnLayoutChangeListener(new com.bytedance.ee.bear.document.sharewords.view.a(r103));
    L14:
        this.f221811h = (AppCompatButton) r101.findViewById(R.id.btn_preview_load_retry);
        View r107 = r101.findViewById(R.id.loading_replace);
        LKUIRoundedImageView2 r108 = this.f221810g;
        if (r108 == null) goto L17;
        Intrinsics.checkNotNull(r107);
        this.f221813j = new n(r108, r107);
    L17:
        ConstraintLayout r109 = this.f221805b;
        if (r109 == null) goto L20;
        Object r110 = r109.getParent();
    L21:
        View r111 = (View) r110;
        boolean r112 = false;
        if (r111 == null) goto L24;
        r111.setPadding(0, r111.getPaddingTop(), 0, r111.getPaddingBottom());
    L24:
        com.bytedance.ee.bear.document.sharewords.d r113 = com.bytedance.ee.bear.document.sharewords.g.f221797a;
        StringBuilder r114 = new StringBuilder("getShareWordsThumbnailResponse : ");
        if (com.bytedance.ee.bear.document.sharewords.g.f221799c != null) goto L27;
        boolean r115 = true;
    L28:
        r114.append(r115);
        Log.i("ShareWordsInstance", r114.toString());
        ShareWordsThumbnailResponse r116 = com.bytedance.ee.bear.document.sharewords.g.f221799c;
        boolean r117 = com.bytedance.ee.bear.document.sharewords.g.f221801e;
        d();
        c r118 = new c(this, r100);
        Intrinsics.checkNotNullParameter(r118, "responseListener");
        com.bytedance.ee.bear.document.sharewords.g.f221800d = r118;
        if (r116 != null) goto L32;
        if (r117 == true) goto L33;
        b();
    L33:
        AppCompatButton r119 = this.f221811h;
        if (r119 == null) goto L36;
        r119.setOnClickListener(new b(this, r107));
    L36:
        t35.a r120 = this.f221819p;
        if (r120 == null) goto L47;
        ShareWordsThumbnailRequest r121 = this.f221804a;
        if (r121 != null) goto L41;
    L43:
        HashMap r122 = new HashMap();
        r122.put("is_include_support_msg_comment_option", Boolean.valueOf(r112));
        r120.a("ccm_doc_block_share_to_chat_select_view", r122);
        tt5.a.h("ShareWordsAnalytic", "reportForwardView " + r112);
        return;
    L41:
        if (r121.f221791e != true) goto L43;
        r112 = true;
        goto L43
    L47:
        return;
    L32:
        c(r100, r116, com.bytedance.ee.bear.document.sharewords.g.f221802f);
        goto L33
    L27:
        r115 = false;
        goto L28
    L20:
        r110 = null;
    L45:
        Log.e("CCMShareWordsEnhancedView", "activity is null or contentParent is null or viewContent is null");
    }
}
