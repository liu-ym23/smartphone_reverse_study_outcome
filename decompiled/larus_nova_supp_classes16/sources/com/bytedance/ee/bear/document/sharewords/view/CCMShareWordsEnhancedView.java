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
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.o0;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 k2\u00020\u0001:\u0002klB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0016J\"\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\"\u00105\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016JJ\u00106\u001a\u00020\f2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010&2\b\u0010:\u001a\u0004\u0018\u00010&2\b\u0010;\u001a\u0004\u0018\u00010&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010<\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u0010=\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010?\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J@\u0010@\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00103\u001a\u0004\u0018\u0001042\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u001e2\b\u0010E\u001a\u0004\u0018\u00010 2\b\u0010F\u001a\u0004\u0018\u00010/H\u0016J>\u0010G\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010H\u001a\u00020I2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010F\u001a\u0004\u0018\u00010/2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016JJ\u0010M\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\"\u0010R\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J6\u0010S\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010T\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010U\u001a\u00020\f2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020\fH\u0016J \u0010Y\u001a\u00020\f2\u0006\u00101\u001a\u0002022\u0006\u0010>\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010Z\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010[\u001a\u00020\\2\u0006\u00101\u001a\u000202H\u0002J \u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020\fH\u0002J\b\u0010e\u001a\u00020\fH\u0002J\b\u0010f\u001a\u00020gH\u0002J\u0018\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0i2\u0006\u0010b\u001a\u00020cH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView;", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView;", "thumbnailRequest", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;", "<init>", "(Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "previewContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "previewLoadingContainer", "previewDeleteContainer", "previewImgContent", "previewFailContent", "previewImage", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "retryBtn", "Landroidx/appcompat/widget/AppCompatButton;", "tag", "", "skeletonAnimator", "Lcom/bytedance/ee/bear/document/sharewords/view/SkeletonAnimator;", "mDialogController", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$DialogController;", "mDataDependency", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ForwardCustomDataDependency;", "glideUrl", "Lcom/bytedance/ee/bear/thumbnail/ThumbGlideUrl;", "commentCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "commentTip", "Landroid/widget/TextView;", "shareWordsAnalytic", "Lcom/bytedance/ee/bear/document/sharewords/analytic/ShareWordsAnalytic;", "onInterceptForwardDialog", "", "targetList", "", "Lcom/ss/android/lark/forwardv2/dto/ForwardTarget;", "extra", "Landroid/os/Bundle;", "showForwardDialog", "activity", "Landroid/app/Activity;", "handler", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardEnhancedView$ExecuteHandler;", "onInterceptBasicDialogDataRender", "interceptBasicDialogDataRender", "thumbnailIV", "Lpl/droidsonroids/gif/GifImageView;", "titleTV", "contentTV", "descTV", "onInterceptBasicDialogView", "interceptBasicDialogView", "contentParent", "onInterceptForward", "interceptForward", "forwardTemplate", "Lcom/ss/android/lark/forwardv2/dto/ForwardTemplate;", "init", "controller", "dataDependency", "extraParam", "onViewClicked", "sourceFragment", "Landroidx/fragment/app/Fragment;", "uncertainTargetList", "view", "Landroid/view/View;", "interceptBasicDialogViewWithContent", "viewContent", "Lcom/ss/android/lark/forwardv2/dto/template/BasicDialogContent;", "imageLoader", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardClickableEnhancedView$ImageLoader;", "onInterceptBottomCustomView", "interceptBottomCustomView", "onAdditionNoteChanged", "afterAdditionNoteChange", "note", "Landroid/text/Editable;", "onDestroy", "bindPreview", "handleThumbnailResponse", "getResponseListener", "Lcom/bytedance/ee/bear/document/sharewords/ShareWordsProcessor$ResponseListener;", "loadThumbnail", "context", "Landroid/content/Context;", "response", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailResponse;", "startTimeStamp", "", "loading", "loadFailed", "isRealLoadReady", "Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView$LoadStatus;", "getTargetView", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "CREATOR", "LoadStatus", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMShareWordsEnhancedView implements ForwardClickableEnhancedView {
    public static final a CREATOR = null;
    public final ShareWordsThumbnailRequest a;
    public ConstraintLayout b;
    public ConstraintLayout c;
    public ConstraintLayout d;
    public ConstraintLayout e;
    public ConstraintLayout f;
    public LKUIRoundedImageView2 g;
    public AppCompatButton h;
    public final String i;
    public n j;
    public ForwardClickableEnhancedView.a k;
    public ForwardClickableEnhancedView.b l;
    public ThumbGlideUrl m;
    public UDCheckBox n;
    public TextView o;
    public final t35.a p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/view/CCMShareWordsEnhancedView$LoadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED_CODE", "FAILED_NEW_DEFAULT", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadStatus extends Enum<LoadStatus> {
        public static final LoadStatus FAILED_CODE = null;
        public static final LoadStatus FAILED_NEW_DEFAULT = null;
        public static final LoadStatus SUCCESS = null;
        public static final /* synthetic */ LoadStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadStatus> getEntries() {
            return b;
        }

        static {
            LoadStatus r0 = new LoadStatus("SUCCESS", 0);
            SUCCESS = r0;
            LoadStatus r1 = new LoadStatus("FAILED_CODE", 1);
            FAILED_CODE = r1;
            LoadStatus r3 = new LoadStatus("FAILED_NEW_DEFAULT", 2);
            FAILED_NEW_DEFAULT = r3;
            LoadStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) a.clone();
        }

        public static LoadStatus valueOf(String r1) {
            return (LoadStatus) r27.a.a(LoadStatus.class, r1);
        }

        public LoadStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Parcelable.Creator<CCMShareWordsEnhancedView> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CCMShareWordsEnhancedView createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new CCMShareWordsEnhancedView((ShareWordsThumbnailRequest) r3.readParcelable(CCMShareWordsEnhancedView.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CCMShareWordsEnhancedView[] newArray(int r1) {
            return new CCMShareWordsEnhancedView[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public final boolean A() {
        return true;
    }

    public final boolean D1(List r1) {
        return false;
    }

    public final void V(GifImageView r1, TextView r2, TextView r3, Bundle r4) {
    }

    public final void d0(com.ss.android.lark.forwardv2.impl.view.e r1) {
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean n0() {
        return true;
    }

    public final void q0() {
    }

    public final void s0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceFragment");
    }

    public final boolean y() {
        return false;
    }

    public final void y1() {
    }

    public final void b() {
        ForwardClickableEnhancedView.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        ConstraintLayout r1 = this.e;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ConstraintLayout r2 = this.f;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        ConstraintLayout r3 = this.c;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        ConstraintLayout r4 = this.d;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        n r5 = this.j;
        if (r5 == null) goto L27;
        tt5.a.d("SkeletonAnimator", "onLoadFailed(): ");
        Object r6 = r5.b.getParent();
        if ((r6 instanceof View) == false) goto L22;
        View r7 = (View) r6;
    L23:
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        r5.c();
        r5.a.setScaleType(ImageView.ScaleType.CENTER);
        r5.a.setImageDrawable(null);
        return;
    L22:
        r7 = null;
        goto L23
    }

    public final void d() {
        ForwardClickableEnhancedView.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        ConstraintLayout r1 = this.e;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ConstraintLayout r2 = this.f;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        ConstraintLayout r3 = this.c;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        ConstraintLayout r4 = this.d;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
    L17:
        n r5 = this.j;
        if (r5 == null) goto L21;
        int r6 = r5.c;
        lt7.d.a r7 = u.a(r5.b);
        r7.b = r6;
        r7.a(2131100785);
        r5.d = r7.b();
        return;
    }

    public final boolean e0() {
        ShareWordsThumbnailRequest r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e != true) goto L7;
        return true;
    }

    public final void onDestroy() {
        n r0 = this.j;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        com.bytedance.ee.bear.document.sharewords.d r1 = com.bytedance.ee.bear.document.sharewords.g.a;
        com.bytedance.ee.bear.document.sharewords.g.d = null;
        com.bytedance.ee.bear.document.sharewords.g.a.a.clear();
    }

    public CCMShareWordsEnhancedView(ShareWordsThumbnailRequest r4) {
        this.a = r4;
        this.i = "CCMShareWordsEnhancedView" + hashCode();
        this.p = new t35.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
    }

    public static final LoadStatus a(CCMShareWordsEnhancedView r5) {
        ThumbGlideUrl r6 = r5.m;
        if (r6 == null) goto L26;
        Map r7 = r6.getResponseHeaders();
        if (r7 == null) goto L26;
        List r1 = (List) r7.get("fail-code");
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L14;
    L16:
        List r8 = (List) r7.get("access-new-default-thumbnail");
        if (r8 != null) goto L19;
    L21:
        r2 = false;
    L22:
        if (r2 == false) goto L26;
        if (TextUtils.equals((CharSequence) ListProtector.get(r8, 0), "true") == false) goto L26;
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady anchorNewDefault false");
        return LoadStatus.FAILED_NEW_DEFAULT;
    L19:
        if ((!r8.isEmpty()) != true) goto L21;
    L14:
        if (TextUtils.equals((CharSequence) ListProtector.get(r1, 0), "21016") == false) goto L16;
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady anchorFailCode false");
        return LoadStatus.FAILED_CODE;
    L9:
        if ((!r1.isEmpty()) != true) goto L11;
        r4 = true;
    L26:
        Log.i("CCMShareWordsEnhancedView", "isRealLoadReady true");
        return LoadStatus.SUCCESS;
    }

    public final void k1(Editable r4) {
        ShareWordsThumbnailRequest r0 = this.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L14;
        if (r4 == null) goto L11;
        int r5 = r4.length();
    L12:
        if (r5 <= 0) goto L14;
    L15:
        UDCheckBox r6 = this.n;
        if (r6 == null) goto L18;
        r6.setClickable(r1);
    L18:
        UDCheckBox r7 = this.n;
        if (r7 == null) goto L21;
        r7.setEnabled(r1);
    L21:
        TextView r8 = this.o;
        if (r8 == null) goto L29;
        Context r3 = r8.getContext();
        if (r1 == false) goto L26;
        int r9 = 2131106622;
    L27:
        r8.setTextColor(UIUtils.getColor(r3, r9));
        return;
    L26:
        r9 = 2131106610;
        goto L27
    L29:
        return;
    L11:
        r5 = 0;
    L14:
        r1 = false;
        goto L15
    L5:
        if (r0.d != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void l(ForwardClickableEnhancedView.a r1, ForwardClickableEnhancedView.b r2) {
        this.k = r1;
        this.l = r2;
    }

    public final void t1(Activity r4, ConstraintLayout r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5.getChildCount() > 0) goto L16;
        ShareWordsThumbnailRequest r6 = this.a;
        if (r6 != null) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L17;
        View r8 = o0.a(r5).inflate(2131560043, r5, true);
        UDCheckBox r1 = r8.findViewById(2131367281);
        r1.setClickable(false);
        r1.setEnabled(false);
        r1.setOnCheckedChangeListener(new e(this));
        this.n = r1;
        this.o = (TextView) r8.findViewById(2131367299);
        r5.setOnClickListener(new f(this));
        return;
    L17:
        return;
    L8:
        if (r6.e != true) goto L10;
        r7 = true;
        goto L11
    }

    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeParcelable(this.a, r3);
    }

    public final void c(Context r19, ShareWordsThumbnailResponse r20, long r21) {
        Log.i(this.i, "loadThumbnail url=" + du5.b.k(r20.getUrl()));     // Catch: Exception -> L18
        LKUIRoundedImageView2 r0 = this.g;     // Catch: Exception -> L18
        if (r0 == null) goto L23;
        MultiTransformation r2 = new MultiTransformation(new Transformation[]{new CenterCrop()});     // Catch: Exception -> L18
        ShareWordsThumbnailRequest r1 = this.a;     // Catch: Exception -> L18
        if (r1 == null) goto L8;
        int r11 = r1.b;     // Catch: Exception -> L18
    L9:
        ThumbGlideUrl r3 = this.m;     // Catch: Exception -> L18
        if (r3 == null) goto L12;
        Map r4 = r3.getResponseHeaders();     // Catch: Exception -> L18
    L13:
        this.m = new ThumbGlideUrl("", r20.getUrl(), r11, r20.getDecryptType(), r20.getDecryptKey(), "", "share_words", true, r0);     // Catch: Exception -> L18
        Log.i(this.i, "loadThumbnail load start");     // Catch: Exception -> L18
        ThumbGlideUrl r5 = this.m;     // Catch: Exception -> L18
        if (r5 == null) goto L16;
        r5.setResponseHeaders(r4);     // Catch: Exception -> L18
    L16:
        CustomTarget r6 = Glide.with(r19).asBitmap().transform(r2).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(false).load(this.m).into(new d(this, r21, System.currentTimeMillis()));     // Catch: Exception -> L18
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r11 = -1;
        goto L9
    L23:
        return;
    L18:
        e = move-exception;
        Log.e("CCMShareWordsEnhancedView", "glideLoadThumbnail err : " + e.getMessage());
    }

    public final void f(Activity r6, ConstraintLayout r7, BasicDialogContent r8) {
        if (r6 == null) goto L45;
        if (r7 == null) goto L45;
        if (r8 == null) goto L45;
        r6.getLayoutInflater().inflate(2131560133, r7);
        this.b = r7.findViewById(2131377576);
        this.c = r7.findViewById(2131379058);
        this.d = r7.findViewById(2131377578);
        this.e = r7.findViewById(2131377520);
        this.f = r7.findViewById(2131377577);
        this.g = r7.findViewById(2131376602);
        Drawable r9 = com.bytedance.ee.util.ui.n.m(r6, 2131233909);
        LKUIRoundedImageView2 r0 = this.g;
        if (r0 == null) goto L11;
        ViewOverlay r1 = r0.getOverlay();
        if (r1 == null) goto L11;
        r1.add(r9);
    L11:
        LKUIRoundedImageView2 r2 = this.g;
        if (r2 == null) goto L14;
        r2.addOnLayoutChangeListener(new com.bytedance.ee.bear.document.sharewords.view.a(r9));
    L14:
        this.h = r7.findViewById(2131364795);
        View r10 = r7.findViewById(2131379057);
        LKUIRoundedImageView2 r11 = this.g;
        if (r11 == null) goto L17;
        Intrinsics.checkNotNull(r10);
        this.j = new n(r11, r10);
    L17:
        ConstraintLayout r12 = this.b;
        if (r12 == null) goto L20;
        Object r13 = r12.getParent();
    L21:
        View r14 = (View) r13;
        boolean r3 = false;
        if (r14 == null) goto L24;
        r14.setPadding(0, r14.getPaddingTop(), 0, r14.getPaddingBottom());
    L24:
        com.bytedance.ee.bear.document.sharewords.d r16 = com.bytedance.ee.bear.document.sharewords.g.a;
        StringBuilder r17 = new StringBuilder("getShareWordsThumbnailResponse : ");
        if (com.bytedance.ee.bear.document.sharewords.g.c != null) goto L27;
        boolean r4 = true;
    L28:
        r17.append(r4);
        Log.i("ShareWordsInstance", r17.toString());
        ShareWordsThumbnailResponse r18 = com.bytedance.ee.bear.document.sharewords.g.c;
        boolean r5 = com.bytedance.ee.bear.document.sharewords.g.e;
        d();
        c r19 = new c(this, r6);
        Intrinsics.checkNotNullParameter(r19, "responseListener");
        com.bytedance.ee.bear.document.sharewords.g.d = r19;
        if (r18 != null) goto L32;
        if (r5 == true) goto L33;
        b();
    L33:
        AppCompatButton r20 = this.h;
        if (r20 == null) goto L36;
        r20.setOnClickListener(new b(this, r10));
    L36:
        t35.a r21 = this.p;
        if (r21 == null) goto L47;
        ShareWordsThumbnailRequest r22 = this.a;
        if (r22 != null) goto L41;
    L43:
        HashMap r23 = new HashMap();
        r23.put("is_include_support_msg_comment_option", Boolean.valueOf(r3));
        r21.a("ccm_doc_block_share_to_chat_select_view", r23);
        tt5.a.h("ShareWordsAnalytic", "reportForwardView " + r3);
        return;
    L41:
        if (r22.e != true) goto L43;
        r3 = true;
        goto L43
    L47:
        return;
    L32:
        c(r6, r18, com.bytedance.ee.bear.document.sharewords.g.f);
        goto L33
    L27:
        r4 = false;
        goto L28
    L20:
        r13 = null;
    L45:
        Log.e("CCMShareWordsEnhancedView", "activity is null or contentParent is null or viewContent is null");
    }
}
