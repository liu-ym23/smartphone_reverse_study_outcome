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
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.UIUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 [2\u00020\u0001:\u0005[\\]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020;H\u0016J\u0014\u0010A\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J\u0014\u0010D\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J\u0014\u0010F\u001a\u00020;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020;0>J&\u0010G\u001a\u0004\u0018\u0001022\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u0002022\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010P\u001a\u00020;H\u0002J\b\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020;H\u0002J\u0012\u0010T\u001a\u00020;2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020;H\u0002J\b\u0010X\u001a\u00020;H\u0016J\b\u0010Y\u001a\u00020RH\u0002J\b\u0010Z\u001a\u00020;H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u00101\u001a\u0004\u0018\u0001028FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "quitQRCodeFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getQuitQRCodeFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setQuitQRCodeFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "formsCoverFromXml", "getFormsCoverFromXml", "setFormsCoverFromXml", "baseIconFromXml", "getBaseIconFromXml", "setBaseIconFromXml", "qrContentContainerFromXml", "Landroid/widget/FrameLayout;", "getQrContentContainerFromXml", "()Landroid/widget/FrameLayout;", "setQrContentContainerFromXml", "(Landroid/widget/FrameLayout;)V", "formsTitleFromXml", "Landroid/widget/TextView;", "getFormsTitleFromXml", "()Landroid/widget/TextView;", "setFormsTitleFromXml", "(Landroid/widget/TextView;)V", "formsShareLinkQRCodeFromXml", "getFormsShareLinkQRCodeFromXml", "setFormsShareLinkQRCodeFromXml", "qrcodeHintTvFromXml", "getQrcodeHintTvFromXml", "setQrcodeHintTvFromXml", "brandHintFromXml", "getBrandHintFromXml", "setBrandHintFromXml", "saveQRCodeFromXml", "Landroid/widget/LinearLayout;", "getSaveQRCodeFromXml", "()Landroid/widget/LinearLayout;", "setSaveQRCodeFromXml", "(Landroid/widget/LinearLayout;)V", "mainContentFromXml", "getMainContentFromXml", "setMainContentFromXml", "qrInnerContentFromXml", "getQrInnerContentFromXml", "setQrInnerContentFromXml", "containerWhiteBgFromXml", "Landroid/view/View;", "getContainerWhiteBgFromXml", "()Landroid/view/View;", "setContainerWhiteBgFromXml", "(Landroid/view/View;)V", "maskViewFromXml", "getMaskViewFromXml", "setMaskViewFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mOnSaveClickListener", "Lkotlin/Function0;", "mQRCodeBmpDisposable", "Lio/reactivex/disposables/Disposable;", "setOnSaveClickListener", "listener", "mOnBackClickListener", "setOnBackClickListener", "mOnViewShowListener", "setOnViewShowListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "hasCover", "", "updateQRContentBgDrawable", "loadBannerAndMask", "source", "Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2$BannerSource;", "addBlueMask", "onStart", "isFragmentStateValid", "onDestroy", "Companion", "BannerSource", "BannerSourceType", "BannerSourceBuilder", "FormsBannerModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormsQRCodePanelFragmentV2 extends DialogFragment {
    public static final /* synthetic */ int u = 0;
    public AppCompatImageView d;
    public AppCompatImageView e;
    public AppCompatImageView f;
    public FrameLayout g;
    public TextView h;
    public AppCompatImageView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public LinearLayout n;
    public View o;
    public AppCompatImageView p;
    public Function0<Unit> q;
    public Disposable r;
    public Function0<Unit> s;
    public Function0<Unit> t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragmentV2$BannerSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "NET", "RES", "LOCAL_PATH", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BannerSourceType extends Enum<BannerSourceType> {
        public static final BannerSourceType LOCAL_PATH = null;
        public static final BannerSourceType NET = null;
        public static final BannerSourceType RES = null;
        public static final /* synthetic */ BannerSourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BannerSourceType> getEntries() {
            return b;
        }

        static {
            BannerSourceType r0 = new BannerSourceType("NET", 0);
            NET = r0;
            BannerSourceType r1 = new BannerSourceType("RES", 1);
            RES = r1;
            BannerSourceType r3 = new BannerSourceType("LOCAL_PATH", 2);
            LOCAL_PATH = r3;
            BannerSourceType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static BannerSourceType[] values() {
            return (BannerSourceType[]) a.clone();
        }

        public static BannerSourceType valueOf(String r1) {
            return (BannerSourceType) r27.a.a(BannerSourceType.class, r1);
        }

        public BannerSourceType(String r1, int r2) {
            super(r1, r2);
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

        public FormsBannerModel(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "tableId");
            Intrinsics.checkNotNullParameter(r3, "viewId");
            Intrinsics.checkNotNullParameter(r4, "fileToken");
            Intrinsics.checkNotNullParameter(r5, "shareToken");
            this.tableId = r2;
            this.viewId = r3;
            this.fileToken = r4;
            this.shareToken = r5;
        }
    }

    public static final class a {
        public static final /* synthetic */ int e = 0;
        public final BannerSourceType a;
        public final Integer b;
        public final String c;
        public final String d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.sharepanel.FormsQRCodePanelFragmentV2$a$a, reason: collision with other inner class name */
        public static final class C0017a {
            public static a a(BannerSourceType r1, Integer r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r1, "sourceType");
                return new a(r1, r2, r3, r4);
            }
        }

        static {
        }

        public a(BannerSourceType r1, Integer r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b {
        public Integer a;
        public String b;
        public String c;
        public BannerSourceType d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BannerSourceType.values().length];
                r0[BannerSourceType.RES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[BannerSourceType.NET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[BannerSourceType.LOCAL_PATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final a a() {
            BannerSourceType r0 = this.d;
            if (r0 != null) goto L7;
            tt5.a.d("BannerSourceBuilder", "can not build BannerSource with empty sourceType");
            return null;
        L7:
            if (r0 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r0 = null;
        L10:
            int r1 = a.a[r0.ordinal()];
            boolean r4 = true;
            if (r1 != 1) goto L13;
            Integer r2 = this.a;
            if (r2 != null) goto L37;
        L44:
            StringBuilder r3 = new StringBuilder("can not build res cover with empty resId - ");
            if (this.a != null) goto L47;
            boolean r5 = true;
        L48:
            r3.append(r5);
            r3.append(" - ");
            Integer r6 = this.a;
            if (r6 != null) goto L52;
        L54:
            r4 = false;
        L55:
            r3.append(r4);
            tt5.a.d("BannerSourceBuilder", r3.toString());
            return null;
        L52:
            if (r6.intValue() != (-1)) goto L54;
        L47:
            r5 = false;
            goto L48
        L37:
            if (r2.intValue() == (-1)) goto L44;
            int r7 = a.e;
            BannerSourceType r8 = this.d;
            if (r8 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r8 = null;
        L61:
            return a.C0017a.a(r8, this.a, null, null);
        L13:
            if (r1 == 2) goto L27;
            if (r1 != 3) goto L25;
            if (TextUtils.isEmpty(this.c) == false) goto L19;
            tt5.a.d("BannerSourceBuilder", "can not build res cover with empty localPath");
            return null;
        L19:
            int r9 = a.e;
            BannerSourceType r10 = this.d;
            if (r10 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r10 = null;
        L58:
            return a.C0017a.a(r10, null, null, this.c);
        L25:
            throw new NoWhenBranchMatchedException();
        L27:
            if (TextUtils.isEmpty(this.b) == false) goto L29;
            tt5.a.d("BannerSourceBuilder", "can not build res cover with empty url");
            return null;
        L29:
            int r11 = a.e;
            BannerSourceType r12 = this.d;
            if (r12 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("sourceType");
            r12 = null;
        L60:
            return a.C0017a.a(r12, null, this.b, null);
        }

        public b() {
        }
    }

    public static final class c {
        public c() {
        }

        public static FormsQRCodePanelFragmentV2 a(String r2, String r3, Integer r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "formsName");
            Intrinsics.checkNotNullParameter(r5, "formsShareUrl");
            Intrinsics.checkNotNullParameter(r6, "baseToken");
            Bundle r0 = new Bundle();
            r0.putString("base_token", r6);
            r0.putString("forms_name", r2);
            if (r3 == null) goto L5;
            r0.putString("forms_cover_img", r3);
        L5:
            if (r4 == null) goto L7;
            r0.putInt("forms_cover_resid", r4.intValue());
        L7:
            r0.putString("forms_share_url", r5);
            if (r7 == null) goto L10;
            r0.putString("qrcode_hint", r7);
        L10:
            FormsQRCodePanelFragmentV2 r8 = new FormsQRCodePanelFragmentV2();
            r8.setArguments(r0);
            return r8;
        }
    }

    public static final class d extends DrawableImageViewTarget {
        public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

        public d(FormsQRCodePanelFragmentV2 r1, AppCompatImageView r2) {
            this.a = r1;
            super(r2);
        }

        public final void onResourceReady(Object r8, Transition r9) {
            Drawable r10 = (Drawable) r8;
            Intrinsics.checkNotNullParameter(r10, "resource");
            super/*com.bumptech.glide.request.target.ImageViewTarget*/.onResourceReady(r10, r9);
            if (FormsQRCodePanelFragmentV2.S90(this.a) == false) goto L5;
            FormsQRCodePanelFragmentV2 r11 = this.a;
            int r12 = UIUtils.dp2px(r11.requireContext(), 90.0f);
            int r0 = UIUtils.dp2px(r11.requireContext(), 200.0f);
            Bitmap r1 = com.ss.android.lark.utils.p.f(r11.T90());
            Bitmap r13 = Bitmap.createBitmap(r1, 0, r0 - r12, r1.getWidth(), r12);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11.getViewLifecycleOwner()), null, null, new FormsQRCodePanelFragmentV2$addBlueMask$1(r11, r13, null), 3, null);
            return;
        L5:
            tt5.a.h("FormsQRCodePanelFragment", "fragment state is not valid when addBlueMask");
        }
    }

    static {
        new c();
    }

    public final AppCompatImageView T90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131373210);
    L8:
        this.e = (AppCompatImageView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (AppCompatImageView) r0;
    }

    public final LinearLayout U90() {
        View r0 = this.m;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131379421);
    L8:
        this.m = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    public final FrameLayout V90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131383503);
    L8:
        this.g = (FrameLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (FrameLayout) r0;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.q = null;
        Disposable r0 = this.r;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.y = com.bytedance.ee.util.ui.k.e(r1.getContext());
        r2.windowAnimations = 2131951621;
        r1.setAttributes(r2);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public FormsQRCodePanelFragmentV2() {
    }

    public static final boolean S90(FormsQRCodePanelFragmentV2 r1) {
        if (r1.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.isDetached() == true) goto L9;
        if (r1.getContext() == null) goto L9;
        return true;
    }

    public final void W90(a r5) {
        if (r5 != null) goto L5;
        tt5.a.d("FormsQRCodePanelFragment", "can not load banner with empty source!!");
        return;
    L5:
        float r0 = UIUtils.dp2px(requireContext(), 16.0f);
        BannerSourceType r1 = r5.a;
        if (r1 != BannerSourceType.NET) goto L9;
        Object r6 = r5.c;
    L15:
        Glide.with(this).load(r6).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new Transformation[]{new CenterCrop(), new FourRoundedCorners(r0, r0, 0.0f, 0.0f)}).placeholder(kac.a.b(2131254464)).into(new d(this, T90()));
        return;
    L9:
        if (r1 != BannerSourceType.RES) goto L12;
        r6 = r5.b;
        goto L15
    L12:
        if (r1 != BannerSourceType.LOCAL_PATH) goto L14;
        r6 = r5.d;
        goto L15
    L14:
        r6 = null;
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
    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r19);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("forms_name");
    L6:
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        String r6 = r5.getString("forms_cover_img");
    L10:
        Bundle r7 = getArguments();
        if (r7 == null) goto L13;
        Integer r8 = Integer.valueOf(r7.getInt("forms_cover_resid", -1));
    L14:
        Bundle r10 = getArguments();
        if (r10 == null) goto L17;
        String r11 = r10.getString("forms_share_url");
    L18:
        Bundle r12 = getArguments();
        if (r12 == null) goto L21;
        r12.getString("base_token");
    L21:
        Bundle r13 = getArguments();
        if (r13 == null) goto L24;
        String r14 = r13.getString("qrcode_hint");
    L25:
        View r16 = this.f;
        if (r16 != null) goto L32;
        View r17 = getView();
        if (r17 == null) goto L30;
        r16 = r17.findViewById(2131363977);
    L31:
        this.f = (AppCompatImageView) r16;
        goto L32
    L30:
        r16 = null;
    L32:
        AppCompatImageView r110 = (AppCompatImageView) r16;
        View r111 = this.k;
        if (r111 != null) goto L39;
        View r112 = getView();
        if (r112 == null) goto L37;
        r111 = r112.findViewById(2131364562);
    L38:
        this.k = (TextView) r111;
        goto L39
    L37:
        r111 = null;
    L39:
        s.a(r110, (TextView) r111);
        View r113 = this.d;
        if (r113 != null) goto L46;
        View r114 = getView();
        if (r114 == null) goto L44;
        r113 = r114.findViewById(2131383572);
    L45:
        this.d = (AppCompatImageView) r113;
        goto L46
    L44:
        r113 = null;
    L46:
        ((AppCompatImageView) r113).setOnClickListener(new l(this));
        boolean r115 = true;
        if (r8 != null) goto L50;
    L51:
        boolean r116 = true;
    L54:
        if (r6 != null) goto L56;
    L74:
        String r117 = null;
    L75:
        if (r116 == false) goto L77;
        b r0 = new b();
        BannerSourceType r2 = BannerSourceType.RES;
        Intrinsics.checkNotNullParameter(r2, "sourceType");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.d = r2;
        r0.a = r8;
        W90(r0.a());
    L77:
        Bundle r1 = getArguments();
        if (r1 == null) goto L80;
        String r9 = r1.getString("forms_cover_img");
    L81:
        Bundle r20 = getArguments();
        if (r20 == null) goto L84;
        ?? r21 = Integer.valueOf(r20.getInt("forms_cover_resid", -1));
    L86:
        if (TextUtils.isEmpty(r9) == false) goto L93;
        if (r21 == 0) goto L93;
        if (r21.intValue() != (-1)) goto L93;
        r115 = false;
    L93:
        if (r115 == true) goto L107;
        T90().setVisibility(8);
        ViewGroup.LayoutParams r22 = V90().getLayoutParams();
        if ((r22 instanceof RelativeLayout.LayoutParams) == false) goto L97;
        ?? r23 = (RelativeLayout.LayoutParams) r22;
    L98:
        if (r23 != 0) goto L100;
        r23 = new RelativeLayout.LayoutParams(-1, -2);
    L100:
        ((RelativeLayout.LayoutParams) r23).topMargin = 0;
        Context r24 = getContext();
        if (r24 == null) goto L107;
        Resources r26 = r24.getResources();
        if (r26 == null) goto L107;
        Drawable r27 = r26.getDrawable(2131235487);
        if (r27 == null) goto L107;
        V90().setBackground(r27);
        goto L107
    L97:
        r23 = r117;
    L107:
        if (r4 == null) goto L116;
        Object r28 = this.h;
        if (r28 != null) goto L115;
        View r29 = getView();
        if (r29 == null) goto L113;
        r28 = r29.findViewById(2131373212);
    L114:
        this.h = (TextView) r28;
        goto L115
    L113:
        r28 = r117;
    L115:
        ((TextView) r28).setText(r4);
    L116:
        if (r11 == null) goto L118;
        int r30 = UIUtils.dp2px(getContext(), 245.0f);
        int r31 = UIUtils.dp2px(getContext(), 245.0f);
        Flowable.just("").map(new n(r11, r30, r31)).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new o(this), p.a);
    L118:
        if (r14 == null) goto L127;
        Object r32 = this.j;
        if (r32 != null) goto L126;
        View r33 = getView();
        if (r33 == null) goto L124;
        r32 = r33.findViewById(2131383508);
    L125:
        this.j = (TextView) r32;
        goto L126
    L124:
        r32 = r117;
    L126:
        ((TextView) r32).setText(r14);
    L127:
        Object r34 = this.l;
        if (r34 != null) goto L134;
        View r36 = getView();
        if (r36 == null) goto L132;
        Object r37 = r36.findViewById(2131385086);
    L133:
        this.l = (LinearLayout) r37;
        r34 = r37;
        goto L134
    L132:
        r37 = r117;
    L134:
        ((LinearLayout) r34).setOnClickListener(new q(this));
        V90().getViewTreeObserver().addOnGlobalLayoutListener(new r(this));
        Function0<Unit> r38 = this.t;
        if (r38 == null) goto L141;
        r38.invoke();
        return;
    L141:
        return;
    L84:
        r21 = r117;
        goto L86
    L80:
        r9 = r117;
        goto L81
    L56:
        if (TextUtils.isEmpty(r6) == true) goto L74;
        String r118 = UriProtector.getQueryParameter(UriProtector.parse(r6), "extra");     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r118) == false) goto L61;
        tt5.a.h("FormsQRCodePanelFragment", "cdnUrl=".concat(r6));     // Catch: Throwable -> L70
        b r39 = new b();     // Catch: Throwable -> L70
        BannerSourceType r119 = BannerSourceType.NET;     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r119, "sourceType");     // Catch: Throwable -> L70
        Intrinsics.checkNotNullParameter(r119, "<set-?>");     // Catch: Throwable -> L70
        r39.d = r119;     // Catch: Throwable -> L70
        r39.b = r6;     // Catch: Throwable -> L70
        W90(r39.a());     // Catch: Throwable -> L70
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L69:
        r117 = null;
    L73:
        r116 = false;
        goto L75
    L61:
        String r41 = JSON.parseObject(r118).getString("sharePerm");     // Catch: Throwable -> L70
        if (r41 == null) goto L69;
        FormsBannerModel r42 = (FormsBannerModel) JSON.parseObject(r41, FormsBannerModel.class);     // Catch: Throwable -> L70
        m r120 = new m(this);     // Catch: Throwable -> L70
        w85.a.C0319a r43 = new w85.a.C0319a();     // Catch: Throwable -> L70
        r43.a = true;     // Catch: Throwable -> L70
        r43.d = r6;     // Catch: Throwable -> L70
        r43.e = r42.getFileToken();     // Catch: Throwable -> L70
        r43.m = r118;     // Catch: Throwable -> L70
        r43.b = DownloadRequestInfo.DownloadType.COVER;     // Catch: Throwable -> L70
        r43.j = r120;     // Catch: Throwable -> L70
        r43.g = "bitable_image";     // Catch: Throwable -> L70
        w85.a r44 = new w85.a(r43);     // Catch: Throwable -> L70
        r117 = null;
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(r44);     // Catch: Throwable -> L67
    L67:
        th = th;
    L72:
        tt5.a.e("FormsQRCodePanelFragment", "load formsBanner failed", th, false);
        Unit r46 = Unit.INSTANCE;
    L70:
        th = th;
        r117 = null;
        goto L72
    L50:
        if (r8.intValue() != (-1)) goto L51;
        r116 = false;
        goto L54
    L24:
        r14 = null;
        goto L25
    L17:
        r11 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561153, r3, false);
    }
}
