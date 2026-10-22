package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 [2\u00020\u0001:\u0005[\\]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020;H\u0016J\u0014\u0010A\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J\u0014\u0010D\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J\u0014\u0010F\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J&\u0010G\u001a\u0004\u0018\u0001022\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u0002022\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010P\u001a\u00020;H\u0002J\b\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020;H\u0002J\u0012\u0010T\u001a\u00020;2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020;H\u0002J\b\u0010X\u001a\u00020;H\u0016J\b\u0010Y\u001a\u00020RH\u0002J\b\u0010Z\u001a\u00020;H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u00101\u001a\u0004\u0018\u0001028FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "quitQRCodeFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getQuitQRCodeFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setQuitQRCodeFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "formsCoverFromXml", "getFormsCoverFromXml", "setFormsCoverFromXml", "baseIconFromXml", "getBaseIconFromXml", "setBaseIconFromXml", "qrContentContainerFromXml", "Landroid/widget/FrameLayout;", "getQrContentContainerFromXml", "()Landroid/widget/FrameLayout;", "setQrContentContainerFromXml", "(Landroid/widget/FrameLayout;)V", "formsTitleFromXml", "Landroid/widget/TextView;", "getFormsTitleFromXml", "()Landroid/widget/TextView;", "setFormsTitleFromXml", "(Landroid/widget/TextView;)V", "formsShareLinkQRCodeFromXml", "getFormsShareLinkQRCodeFromXml", "setFormsShareLinkQRCodeFromXml", "qrcodeHintTvFromXml", "getQrcodeHintTvFromXml", "setQrcodeHintTvFromXml", "brandHintFromXml", "getBrandHintFromXml", "setBrandHintFromXml", "saveQRCodeFromXml", "Landroid/widget/LinearLayout;", "getSaveQRCodeFromXml", "()Landroid/widget/LinearLayout;", "setSaveQRCodeFromXml", "(Landroid/widget/LinearLayout;)V", "mainContentFromXml", "getMainContentFromXml", "setMainContentFromXml", "qrInnerContentFromXml", "getQrInnerContentFromXml", "setQrInnerContentFromXml", "containerWhiteBgFromXml", "Landroid/view/View;", "getContainerWhiteBgFromXml", "()Landroid/view/View;", "setContainerWhiteBgFromXml", "(Landroid/view/View;)V", "maskViewFromXml", "getMaskViewFromXml", "setMaskViewFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mOnSaveClickListener", "Lkotlin/Function0;", "mQRCodeBmpDisposable", "Lio/reactivex/disposables/Disposable;", "setOnSaveClickListener", "listener", "mOnBackClickListener", "setOnBackClickListener", "mOnViewShowListener", "setOnViewShowListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "hasCover", "", "updateQRContentBgDrawable", "loadBannerAndMask", "source", "Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2$BannerSource;", "addBlueMask", WidgetCostModule.TYPE_ON_START, "isFragmentStateValid", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "BannerSource", "BannerSourceType", "BannerSourceBuilder", "FormsBannerModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormsQRCodePanelFragmentV2 extends DialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f215387u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f215388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatImageView f215389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f215390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f215391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f215392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f215393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f215394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f215395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f215396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f215397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f215398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f215399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AppCompatImageView f215400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Unit> f215401q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f215402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<Unit> f215403s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<Unit> f215404t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2$BannerSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "NET", "RES", "LOCAL_PATH", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BannerSourceType extends Enum<BannerSourceType> {
        public static final BannerSourceType LOCAL_PATH = null;
        public static final BannerSourceType NET = null;
        public static final BannerSourceType RES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BannerSourceType[] f215405a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f215406b = null;

        public static EnumEntries<BannerSourceType> getEntries() {
            return f215406b;
        }

        static {
            BannerSourceType r100 = new BannerSourceType("NET", 0);
            NET = r100;
            BannerSourceType r101 = new BannerSourceType("RES", 1);
            RES = r101;
            BannerSourceType r102 = new BannerSourceType("LOCAL_PATH", 2);
            LOCAL_PATH = r102;
            BannerSourceType[] r103 = {r100, r101, r102};
            f215405a = r103;
            f215406b = EnumEntriesKt.enumEntries(r103);
        }

        public static BannerSourceType[] values() {
            return (BannerSourceType[]) f215405a.clone();
        }

        public static BannerSourceType valueOf(String r100) {
            return (BannerSourceType) r27.a.a(BannerSourceType.class, r100);
        }

        public BannerSourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2$FormsBannerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "viewId", "fileToken", "shareToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTableId", "()Ljava/lang/String;", "getViewId", "getFileToken", "getShareToken", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FormsBannerModel implements NonProguard {
        private final String fileToken;
        private final String shareToken;
        private final String tableId;
        private final String viewId;

        public final String getFileToken() {
            return this.fileToken;
        }

        public final String getShareToken() {
            return this.shareToken;
        }

        public final String getTableId() {
            return this.tableId;
        }

        public final String getViewId() {
            return this.viewId;
        }

        public FormsBannerModel(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "tableId");
            Intrinsics.checkNotNullParameter(r101, "viewId");
            Intrinsics.checkNotNullParameter(r102, "fileToken");
            Intrinsics.checkNotNullParameter(r103, "shareToken");
            this.tableId = r100;
            this.viewId = r101;
            this.fileToken = r102;
            this.shareToken = r103;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f215407e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BannerSourceType f215408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f215409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f215410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f215411d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.sharepanel.FormsQRCodePanelFragmentV2$a$a, reason: collision with other inner class name */
        public static final class C3073a {
            public static a a(BannerSourceType r100, Integer r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "sourceType");
                return new a(r100, r101, r102, r103);
            }
        }

        static {
        }

        public a(BannerSourceType r100, Integer r101, String r102, String r103) {
            this.f215408a = r100;
            this.f215409b = r101;
            this.f215410c = r102;
            this.f215411d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f215412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f215413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f215414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BannerSourceType f215415d;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f215416a = null;

            static {
                int[] r100 = new int[BannerSourceType.values().length];
                r100[BannerSourceType.RES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[BannerSourceType.NET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[BannerSourceType.LOCAL_PATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f215416a = r100;
            }
        }

        public final a a() {
            BannerSourceType r100 = this.f215415d;
            if (r100 != null) goto L7;
            tt5.a.d("BannerSourceBuilder", "can not build BannerSource with empty sourceType");
            return null;
        L7:
            if (r100 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r100 = null;
        L10:
            int r101 = a.f215416a[r100.ordinal()];
            boolean r102 = true;
            if (r101 != 1) goto L13;
            Integer r103 = this.f215412a;
            if (r103 != null) goto L37;
        L44:
            StringBuilder r104 = new StringBuilder("can not build res cover with empty resId - ");
            if (this.f215412a != null) goto L47;
            boolean r105 = true;
        L48:
            r104.append(r105);
            r104.append(" - ");
            Integer r106 = this.f215412a;
            if (r106 != null) goto L52;
        L54:
            r102 = false;
        L55:
            r104.append(r102);
            tt5.a.d("BannerSourceBuilder", r104.toString());
            return null;
        L52:
            if (r106.intValue() != (-1)) goto L54;
        L47:
            r105 = false;
            goto L48
        L37:
            if (r103.intValue() == (-1)) goto L44;
            int r107 = a.f215407e;
            BannerSourceType r108 = this.f215415d;
            if (r108 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r108 = null;
        L61:
            return a.C3073a.a(r108, this.f215412a, null, null);
        L13:
            if (r101 == 2) goto L27;
            if (r101 != 3) goto L25;
            if (TextUtils.isEmpty(this.f215414c) == false) goto L19;
            tt5.a.d("BannerSourceBuilder", "can not build res cover with empty localPath");
            return null;
        L19:
            int r109 = a.f215407e;
            BannerSourceType r110 = this.f215415d;
            if (r110 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r110 = null;
        L58:
            return a.C3073a.a(r110, null, null, this.f215414c);
        L25:
            throw new NoWhenBranchMatchedException();
        L27:
            if (TextUtils.isEmpty(this.f215413b) == false) goto L29;
            tt5.a.d("BannerSourceBuilder", "can not build res cover with empty url");
            return null;
        L29:
            int r111 = a.f215407e;
            BannerSourceType r112 = this.f215415d;
            if (r112 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r112 = null;
        L60:
            return a.C3073a.a(r112, null, this.f215413b, null);
        }

        public b() {
        }
    }

    public static final class c {
        public c() {
        }

        public static FormsQRCodePanelFragmentV2 a(String r100, String r101, Integer r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "formsName");
            Intrinsics.checkNotNullParameter(r103, "formsShareUrl");
            Intrinsics.checkNotNullParameter(r104, "baseToken");
            Bundle r106 = new Bundle();
            r106.putString(BitableResourceData.KEY_BASE_TOKEN, r104);
            r106.putString("forms_name", r100);
            if (r101 == null) goto L5;
            r106.putString("forms_cover_img", r101);
        L5:
            if (r102 == null) goto L7;
            r106.putInt("forms_cover_resid", r102.intValue());
        L7:
            r106.putString("forms_share_url", r103);
            if (r105 == null) goto L10;
            r106.putString("qrcode_hint", r105);
        L10:
            FormsQRCodePanelFragmentV2 r107 = new FormsQRCodePanelFragmentV2();
            r107.setArguments(r106);
            return r107;
        }
    }

    public static final class d extends DrawableImageViewTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormsQRCodePanelFragmentV2 f215417a;

        public d(FormsQRCodePanelFragmentV2 r100, AppCompatImageView r101) {
            this.f215417a = r100;
            super(r101);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Drawable r102 = (Drawable) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            super.onResourceReady(r102, r101);
            if (FormsQRCodePanelFragmentV2.S90(this.f215417a) == false) goto L5;
            FormsQRCodePanelFragmentV2 r103 = this.f215417a;
            int r104 = UIUtils.dp2px(r103.requireContext(), 90.0f);
            int r105 = UIUtils.dp2px(r103.requireContext(), 200.0f);
            Bitmap r106 = com.ss.android.lark.utils.p.f(r103.T90());
            Bitmap r107 = Bitmap.createBitmap(r106, 0, r105 - r104, r106.getWidth(), r104);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r103.getViewLifecycleOwner()), null, null, new FormsQRCodePanelFragmentV2$addBlueMask$1(r103, r107, null), 3, null);
            return;
        L5:
            tt5.a.h("FormsQRCodePanelFragment", "fragment state is not valid when addBlueMask");
        }
    }

    static {
        new c();
    }

    public final AppCompatImageView T90() {
        View r100 = this.f215389e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.formsCover);
    L8:
        this.f215389e = (AppCompatImageView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (AppCompatImageView) r100;
    }

    public final LinearLayout U90() {
        View r100 = this.f215397m;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.mainContent);
    L8:
        this.f215397m = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final FrameLayout V90() {
        View r100 = this.f215391g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.qrContentContainer);
    L8:
        this.f215391g = (FrameLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (FrameLayout) r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f215401q = null;
        Disposable r100 = this.f215402r;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f215388d = null;
        this.f215389e = null;
        this.f215390f = null;
        this.f215391g = null;
        this.f215392h = null;
        this.f215393i = null;
        this.f215394j = null;
        this.f215395k = null;
        this.f215396l = null;
        this.f215397m = null;
        this.f215398n = null;
        this.f215399o = null;
        this.f215400p = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.gravity = 80;
        r102.y = com.bytedance.ee.util.ui.k.e(r101.getContext());
        r102.windowAnimations = R.style.ActionSheetDialogAnimation;
        r101.setAttributes(r102);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public FormsQRCodePanelFragmentV2() {
    }

    public static final boolean S90(FormsQRCodePanelFragmentV2 r100) {
        if (r100.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isDetached() == true) goto L9;
        if (r100.getContext() == null) goto L9;
        return true;
    }

    public final void W90(a r100) {
        if (r100 != null) goto L5;
        tt5.a.d("FormsQRCodePanelFragment", "can not load banner with empty source!!");
        return;
    L5:
        float r101 = UIUtils.dp2px(requireContext(), 16.0f);
        BannerSourceType r102 = r100.f215408a;
        if (r102 != BannerSourceType.NET) goto L9;
        Object r103 = r100.f215410c;
    L15:
        Glide.with(this).load(r103).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new Transformation[]{new CenterCrop(), new FourRoundedCorners(r101, r101, 0.0f, 0.0f)}).placeholder(kac.a.b(R.drawable.ud_icon_file_image_colorful)).into(new d(this, T90()));
        return;
    L9:
        if (r102 != BannerSourceType.RES) goto L12;
        r103 = r100.f215409b;
        goto L15
    L12:
        if (r102 != BannerSourceType.LOCAL_PATH) goto L14;
        r103 = r100.f215411d;
        goto L15
    L14:
        r103 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40, types: [android.widget.RelativeLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v44, types: [android.widget.RelativeLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Integer] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("forms_name");
    L6:
        Bundle r102 = getArguments();
        if (r102 == null) goto L9;
        String r103 = r102.getString("forms_cover_img");
    L10:
        Bundle r104 = getArguments();
        if (r104 == null) goto L13;
        Integer r105 = Integer.valueOf(r104.getInt("forms_cover_resid", -1));
    L14:
        Bundle r112 = getArguments();
        if (r112 == null) goto L17;
        String r113 = r112.getString("forms_share_url");
    L18:
        Bundle r114 = getArguments();
        if (r114 == null) goto L21;
        r114.getString(BitableResourceData.KEY_BASE_TOKEN);
    L21:
        Bundle r115 = getArguments();
        if (r115 == null) goto L24;
        String r116 = r115.getString("qrcode_hint");
    L25:
        View r117 = this.f215390f;
        if (r117 != null) goto L32;
        View r118 = getView();
        if (r118 == null) goto L30;
        r117 = r118.findViewById(R.id.baseIcon);
    L31:
        this.f215390f = (AppCompatImageView) r117;
        goto L32
    L30:
        r117 = null;
    L32:
        AppCompatImageView r119 = (AppCompatImageView) r117;
        View r120 = this.f215395k;
        if (r120 != null) goto L39;
        View r121 = getView();
        if (r121 == null) goto L37;
        r120 = r121.findViewById(R.id.brandHint);
    L38:
        this.f215395k = (TextView) r120;
        goto L39
    L37:
        r120 = null;
    L39:
        s.a(r119, (TextView) r120);
        View r122 = this.f215388d;
        if (r122 != null) goto L46;
        View r123 = getView();
        if (r123 == null) goto L44;
        r122 = r123.findViewById(R.id.quitQRCode);
    L45:
        this.f215388d = (AppCompatImageView) r122;
        goto L46
    L44:
        r122 = null;
    L46:
        ((AppCompatImageView) r122).setOnClickListener(new l(this));
        boolean r124 = true;
        if (r105 != null) goto L50;
    L51:
        boolean r125 = true;
    L54:
        if (r103 != null) goto L56;
    L74:
        String r126 = null;
    L75:
        if (r125 == false) goto L77;
        b r106 = new b();
        BannerSourceType r107 = BannerSourceType.RES;
        Intrinsics.checkNotNullParameter(r107, "sourceType");
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f215415d = r107;
        r106.f215412a = r105;
        W90(r106.a());
    L77:
        Bundle r108 = getArguments();
        if (r108 == null) goto L80;
        String r109 = r108.getString("forms_cover_img");
    L81:
        Bundle r127 = getArguments();
        if (r127 == null) goto L84;
        ?? r128 = Integer.valueOf(r127.getInt("forms_cover_resid", -1));
    L86:
        if (TextUtils.isEmpty(r109) == false) goto L93;
        if (r128 == 0) goto L93;
        if (r128.intValue() != (-1)) goto L93;
        r124 = false;
    L93:
        if (r124 == true) goto L107;
        T90().setVisibility(8);
        ViewGroup.LayoutParams r129 = V90().getLayoutParams();
        if ((r129 instanceof RelativeLayout.LayoutParams) == false) goto L97;
        ?? r130 = (RelativeLayout.LayoutParams) r129;
    L98:
        if (r130 != 0) goto L100;
        r130 = new RelativeLayout.LayoutParams(-1, -2);
    L100:
        ((RelativeLayout.LayoutParams) r130).topMargin = 0;
        Context r131 = getContext();
        if (r131 == null) goto L107;
        Resources r132 = r131.getResources();
        if (r132 == null) goto L107;
        Drawable r133 = r132.getDrawable(R.drawable.forms_qrcode_content_container_bg);
        if (r133 == null) goto L107;
        V90().setBackground(r133);
        goto L107
    L97:
        r130 = r126;
    L107:
        if (r101 == null) goto L116;
        Object r134 = this.f215392h;
        if (r134 != null) goto L115;
        View r135 = getView();
        if (r135 == null) goto L113;
        r134 = r135.findViewById(R.id.formsTitle);
    L114:
        this.f215392h = (TextView) r134;
        goto L115
    L113:
        r134 = r126;
    L115:
        ((TextView) r134).setText(r101);
    L116:
        if (r113 == null) goto L118;
        int r136 = UIUtils.dp2px(getContext(), 245.0f);
        int r137 = UIUtils.dp2px(getContext(), 245.0f);
        Flowable.just("").map(new n(r113, r136, r137)).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new o(this), p.f215464a);
    L118:
        if (r116 == null) goto L127;
        Object r138 = this.f215394j;
        if (r138 != null) goto L126;
        View r139 = getView();
        if (r139 == null) goto L124;
        r138 = r139.findViewById(R.id.qrcodeHintTv);
    L125:
        this.f215394j = (TextView) r138;
        goto L126
    L124:
        r138 = r126;
    L126:
        ((TextView) r138).setText(r116);
    L127:
        Object r140 = this.f215396l;
        if (r140 != null) goto L134;
        View r141 = getView();
        if (r141 == null) goto L132;
        Object r142 = r141.findViewById(R.id.saveQRCode);
    L133:
        this.f215396l = (LinearLayout) r142;
        r140 = r142;
        goto L134
    L132:
        r142 = r126;
    L134:
        ((LinearLayout) r140).setOnClickListener(new q(this));
        V90().getViewTreeObserver().addOnGlobalLayoutListener(new r(this));
        Function0<Unit> r143 = this.f215404t;
        if (r143 == null) goto L141;
        r143.invoke();
        return;
    L141:
        return;
    L84:
        r128 = r126;
        goto L86
    L80:
        r109 = r126;
        goto L81
    L56:
        if (TextUtils.isEmpty(r103) == true) goto L74;
        String r144 = UriProtector.getQueryParameter(UriProtector.parse(r103), "extra");     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r144) == false) goto L61;
        tt5.a.h("FormsQRCodePanelFragment", "cdnUrl=".concat(r103));     // Catch: Throwable -> L70
        b r145 = new b();     // Catch: Throwable -> L70
        BannerSourceType r146 = BannerSourceType.NET;     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r146, "sourceType");     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r146, "<set-?>");     // Catch: Throwable -> L70
        r145.f215415d = r146;     // Catch: Throwable -> L70
        r145.f215413b = r103;     // Catch: Throwable -> L70
        W90(r145.a());     // Catch: Throwable -> L70
        Unit r147 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L69:
        r126 = null;
    L73:
        r125 = false;
        goto L75
    L61:
        String r148 = JSON.parseObject(r144).getString("sharePerm");     // Catch: Throwable -> L70
        if (r148 == null) goto L69;
        FormsBannerModel r149 = (FormsBannerModel) JSON.parseObject(r148, FormsBannerModel.class);     // Catch: Throwable -> L70
        m r150 = new m(this);     // Catch: Throwable -> L70
        w85.a.C8081a r151 = new w85.a.C8081a();     // Catch: Throwable -> L70
        r151.f558639a = true;     // Catch: Throwable -> L70
        r151.f558642d = r103;     // Catch: Throwable -> L70
        r151.f558643e = r149.getFileToken();     // Catch: Throwable -> L70
        r151.f558651m = r144;     // Catch: Throwable -> L70
        r151.f558640b = DownloadRequestInfo.DownloadType.COVER;     // Catch: Throwable -> L70
        r151.f558648j = r150;     // Catch: Throwable -> L70
        r151.f558645g = "bitable_image";     // Catch: Throwable -> L70
        w85.a r152 = new w85.a(r151);     // Catch: Throwable -> L70
        r126 = null;
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(r152);     // Catch: Throwable -> L67
    L67:
        th = th;
    L72:
        tt5.a.e("FormsQRCodePanelFragment", "load formsBanner failed", th, false);
        Unit r153 = Unit.INSTANCE;
    L70:
        th = th;
        r126 = null;
        goto L72
    L50:
        if (r105.intValue() != (-1)) goto L51;
        r125 = false;
        goto L54
    L24:
        r116 = null;
        goto L25
    L17:
        r113 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.forms_qrcode_panel_fragmentv2, r101, false);
    }
}
