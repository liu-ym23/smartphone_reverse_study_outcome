package com.bytedance.ee.bear.bitable.infoarch.header;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.Style;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import ct4.f;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 e2\u00020\u0001:\u0002efB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\u0018\u0010@\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u00020>2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010DH\u0002J\u000e\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020>2\u0006\u0010J\u001a\u00020KJ\b\u0010M\u001a\u00020>H\u0002J\u0012\u0010N\u001a\u00020>2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0006\u0010Q\u001a\u00020>J\u0012\u0010R\u001a\u00020>2\b\u0010S\u001a\u0004\u0018\u00010PH\u0002J\u0012\u0010T\u001a\u00020>2\b\u0010U\u001a\u0004\u0018\u00010PH\u0002J\b\u0010V\u001a\u00020\u0007H\u0002J&\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u00072\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0002J\u0018\u0010]\u001a\u00020^2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u0007H\u0003J\u0018\u0010`\u001a\u00020^2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u0007H\u0002J\b\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020KH\u0016J\b\u0010d\u001a\u00020>H\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001e\u0010+\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010.\u001a\u0004\u0018\u00010/8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00104\u001a\f\u0012\b\u0012\u000606R\u00020\u000005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006g"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/header/BitableHeaderContainer;", "Lcom/bytedance/ee/bear/bitable/infoarch/BaseLoadingContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tableIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getTableIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setTableIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "leftIconFromXml", "getLeftIconFromXml", "setLeftIconFromXml", "tipsIconTagFromXml", "Landroid/widget/LinearLayout;", "getTipsIconTagFromXml", "()Landroid/widget/LinearLayout;", "setTipsIconTagFromXml", "(Landroid/widget/LinearLayout;)V", "tipsIconFromXml", "getTipsIconFromXml", "setTipsIconFromXml", "tipsTextFromXml", "Landroid/widget/TextView;", "getTipsTextFromXml", "()Landroid/widget/TextView;", "setTipsTextFromXml", "(Landroid/widget/TextView;)V", "mainTitleWrapperFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/header/TextViewTagLayout;", "getMainTitleWrapperFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/header/TextViewTagLayout;", "setMainTitleWrapperFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/header/TextViewTagLayout;)V", "mainTitleFromXml", "getMainTitleFromXml", "setMainTitleFromXml", "subTitleFromXml", "getSubTitleFromXml", "setSubTitleFromXml", "titleContainerCLFromXml", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getTitleContainerCLFromXml", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setTitleContainerCLFromXml", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "tagList", "", "Lcom/bytedance/ee/bear/bitable/infoarch/header/BitableHeaderContainer$HeaderTagModel;", "bizCacheController", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NativeBizCacheController;", "getBizCacheController", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NativeBizCacheController;", "setBizCacheController", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/NativeBizCacheController;)V", "addMockFgTips", "", "getBitableGradationLogoResId", "setData", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/header/HeaderContainerModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setTableStatusTag", "tag", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "actionHandler", "setTitleExternalTagEnabled", "show", "", "setTitleTemplateTagEnabled", "setMainTitleTag", "setIcon", "iconMeta", "", "resizeTitleFont", "setMainTitle", "title", "setSubTitle", "subTitle", "getTitleAvaliableWidth", "fitTitleTextSize", "text", "index", "sizeArray", "", "", "getStaticLayoutM", "Landroid/text/StaticLayout;", "avaliableWidth", "getStaticLayout", "getLoadingType", "Lcom/bytedance/ee/bear/bitable/loading/ELoadingType;", "interruptLoading", "createTags", "Companion", "HeaderTagModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHeaderContainer extends BaseLoadingContainer {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List<Float> f213203o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<Float> f213204p = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f213205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatImageView f213206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f213207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatImageView f213208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f213209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextViewTagLayout f213210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f213211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f213212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f213213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<b> f213214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f213215n;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f213216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UDTagsDrawable.d f213217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f213218c;

        public b() {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableHeaderContainer f213219a;

        public c(BitableHeaderContainer r100) {
            this.f213219a = r100;
        }

        public final void a() {
            BitableHeaderContainer r100 = this.f213219a;
            int r101 = 0;
            int r102 = r100.b(r100.getMainTitleFromXml(), 0, BitableHeaderContainer.f213203o);
            TextView r103 = this.f213219a.getMainTitleFromXml();
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L8;
            LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
            if (r102 <= 1) goto L7;
            r101 = 4;
        L7:
            r105.bottomMargin = cu5.c.b(r101);
            r103.setLayoutParams(r104);
        L8:
            this.f213219a.getMainTitleWrapperFromXml().requestLayout();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableHeaderContainer f213220a;

        public d(BitableHeaderContainer r100) {
            this.f213220a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableHeaderContainer r100 = this.f213220a;     // Catch: Throwable -> L4
            r100.b(r100.getSubTitleFromXml(), 0, BitableHeaderContainer.f213204p);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BitableHeaderContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableHeaderContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        Float r100 = Float.valueOf(14.0f);
        f213203o = CollectionsKt.listOf(new Float[]{Float.valueOf(17.0f), Float.valueOf(16.0f), Float.valueOf(15.0f), r100});
        f213204p = CollectionsKt.listOf(new Float[]{r100, Float.valueOf(13.0f), Float.valueOf(12.0f)});
    }

    private final int getBitableGradationLogoResId() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r101 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.use_new_gradation_logo_enable") == false) goto L5;
        return R.drawable.ud_icon_logo_gradient_base_colorful;
    L5:
        return R.drawable.purple_base;
    }

    public final void e() {
        UDTagsDrawable.a r100 = new UDTagsDrawable.a(getContext());
        Iterator r101 = ((ArrayList) this.f213214m).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        b r102 = (b) r101.next();
        if (r102.f213218c == false) goto L4;
        UDTagsDrawable.d r103 = r102.f213217b;
        if (r103 == null) goto L4;
        r100.a(r103);
        goto L4
    L10:
        getMainTitleWrapperFromXml().setTagDrawable(r100.b());
        getMainTitleWrapperFromXml().setTagPaddingLeft(com.bytedance.ee.util.ui.n.c(6.0f));
    }

    public final AppCompatImageView getLeftIconFromXml() {
        KeyEvent.Callback r100 = this.f213206e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.left_icon);
        this.f213206e = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getMainTitleFromXml() {
        KeyEvent.Callback r100 = this.f213211j;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.main_title);
        this.f213211j = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextViewTagLayout getMainTitleWrapperFromXml() {
        KeyEvent.Callback r100 = this.f213210i;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.main_title_wrapper);
        this.f213210i = (TextViewTagLayout) r100;
    L6:
        return (TextViewTagLayout) r100;
    }

    public final TextView getSubTitleFromXml() {
        KeyEvent.Callback r100 = this.f213212k;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.sub_title);
        this.f213212k = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final AppCompatImageView getTableIconFromXml() {
        KeyEvent.Callback r100 = this.f213205d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.table_icon);
        this.f213205d = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final AppCompatImageView getTipsIconFromXml() {
        KeyEvent.Callback r100 = this.f213208g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tips_icon);
        this.f213208g = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final LinearLayout getTipsIconTagFromXml() {
        KeyEvent.Callback r100 = this.f213207f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tips_icon_tag);
        this.f213207f = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final TextView getTipsTextFromXml() {
        KeyEvent.Callback r100 = this.f213209h;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tips_text);
        this.f213209h = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final ConstraintLayout getTitleContainerCLFromXml() {
        KeyEvent.Callback r100 = this.f213213l;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.titleContainerCL);
        this.f213213l = (ConstraintLayout) r100;
    L6:
        return (ConstraintLayout) r100;
    }

    private final int getTitleAvaliableWidth() {
        return getTitleContainerCLFromXml().getMeasuredWidth();
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        super.A30();
        return true;
    }

    public final void c() {
        CharSequence r100 = getMainTitleFromXml().getText();
        if (r100 == null) goto L7;
        String r101 = r100.toString();
        if (r101 == null) goto L7;
        setMainTitle(r101);
    L7:
        CharSequence r102 = getSubTitleFromXml().getText();
        if (r102 == null) goto L13;
        String r103 = r102.toString();
        if (r103 == null) goto L14;
        setSubTitle(r103);
        return;
    L14:
        return;
    }

    public final f getBizCacheController() {
        return this.f213215n;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public ELoadingType getLoadingType() {
        return ELoadingType.HEADER;
    }

    private final void setIcon(String r100) {
        mbb.c.d(getLeftIconFromXml(), "base", e.f541298i.f541317b, r100, IconShape.SQUARE, new obb.a(IconScene.BITABLE));
    }

    private final void setMainTitle(String r100) {
        TextView r101 = getMainTitleFromXml();
        if (r101 == null) goto L5;
        CharSequence r102 = r101.getText();
    L7:
        if (TextUtils.equals(r102, r100) == false) goto L9;
        return;
    L9:
        getMainTitleFromXml().setText(r100);
        getMainTitleFromXml().setTextSize(((Number) ListProtector.get(f213203o, 0)).floatValue());
        post(new c(this));
        return;
    L5:
        r102 = null;
        goto L7
    }

    private final void setSubTitle(String r100) {
        TextView r101 = getSubTitleFromXml();
        if (r101 == null) goto L5;
        CharSequence r102 = r101.getText();
    L7:
        if (TextUtils.equals(r102, r100) == false) goto L9;
        return;
    L9:
        getSubTitleFromXml().setText(r100);
        getSubTitleFromXml().setTextSize(((Number) ListProtector.get(f213204p, 0)).floatValue());
        post(new d(this));
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setBizCacheController(f r100) {
        this.f213215n = r100;
    }

    public final void setLeftIconFromXml(AppCompatImageView r100) {
        this.f213206e = r100;
    }

    public final void setMainTitleFromXml(TextView r100) {
        this.f213211j = r100;
    }

    public final void setMainTitleWrapperFromXml(TextViewTagLayout r100) {
        this.f213210i = r100;
    }

    public final void setSubTitleFromXml(TextView r100) {
        this.f213212k = r100;
    }

    public final void setTableIconFromXml(AppCompatImageView r100) {
        this.f213205d = r100;
    }

    public final void setTipsIconFromXml(AppCompatImageView r100) {
        this.f213208g = r100;
    }

    public final void setTipsIconTagFromXml(LinearLayout r100) {
        this.f213207f = r100;
    }

    public final void setTipsTextFromXml(TextView r100) {
        this.f213209h = r100;
    }

    public final void setTitleContainerCLFromXml(ConstraintLayout r100) {
        this.f213213l = r100;
    }

    public final void setTitleExternalTagEnabled(boolean r100) {
        tt5.a.h("BitableHeaderContainer", "setTitleExternalTagEnabled:" + r100);
        Iterator<T> r101 = this.f213214m.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        b r105 = (b) r103;
        if (TextUtils.equals(r105.f213216a, "external") == false) goto L11;
        r105.f213218c = r100;
    L11:
        r102 = r104;
        goto L4
    L12:
        e();
    }

    public final void setTitleTemplateTagEnabled(boolean r100) {
        tt5.a.h("BitableHeaderContainer", "setTitleTemplateTagEnabled:" + r100);
        Iterator<T> r101 = this.f213214m.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        b r105 = (b) r103;
        if (TextUtils.equals(r105.f213216a, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L11;
        r105.f213218c = r100;
    L11:
        r102 = r104;
        goto L4
    L12:
        e();
    }

    public final void d(HeaderContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "handler");
        ys4.c r102 = null;
        if (r100 == null) goto L7;
        Icon r103 = r100.getIcon();
        if (r103 == null) goto L7;
        String r104 = r103.getUrl();
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L22;
        if (r100 == null) goto L21;
        Icon r105 = r100.getIcon();
        if (r105 == null) goto L21;
        f r106 = this.f213215n;
        if (r106 == null) goto L20;
        Icon r107 = r100.getIcon();
        if (r107 == null) goto L18;
        String r108 = r107.getUrl();
    L19:
        r106.f465351a.f465346b = r108;
        goto L20
    L18:
        r108 = null;
    L20:
        r105.setErrorRes(Integer.valueOf(getBitableGradationLogoResId()));
    L34:
        com.bytedance.ee.bear.bitable.panel.e.n(getLeftIconFromXml(), r105);
        AppCompatImageView r109 = getTableIconFromXml();
        if (r100 == null) goto L37;
        Icon r110 = r100.getTableIcon();
    L38:
        com.bytedance.ee.bear.bitable.panel.e.n(r109, r110);
        if (r100 == null) goto L41;
        String r111 = r100.getMainTitle();
    L42:
        setMainTitle(r111);
        if (r100 == null) goto L45;
        String r112 = r100.getSubTitle();
    L46:
        setSubTitle(r112);
        if (r100 == null) goto L49;
        SimpleItemModel r113 = r100.getTableStatusTag();
    L50:
        if (r113 == null) goto L52;
        Icon r114 = r113.getIcon();
    L53:
        if (r113 == null) goto L55;
        String r115 = r113.getText();
    L56:
        if (r114 == null) goto L86;
        if (r115 == null) goto L86;
        int r116 = r113.getTextStyle();
        Style r117 = Style.Disable;
        if (r116 != r117.getValue()) goto L62;
        int r118 = R.color.function_danger_400;
    L64:
        if (r113.getTextStyle() != r117.getValue()) goto L66;
        int r119 = R.color.udtoken_tag_bg_red;
    L67:
        AppCompatImageView r120 = getTipsIconFromXml();
        Integer r121 = r114.getImgRes(getContext());
        if (r121 == null) goto L70;
        int r122 = r121.intValue();
    L71:
        r120.setImageResource(r122);
        TextView r123 = getTipsTextFromXml();
        String r124 = r113.getText();
        if (r124 != null) goto L75;
        r124 = "";
    L75:
        r123.setText(r124);
        getTipsTextFromXml().setTextColor(UIHelper.getColor(r118));
        m.w(getTipsIconTagFromXml(), 9.0f, r119);
        ys4.c r125 = new ys4.c(r101, r113);
        LinearLayout r126 = getTipsIconTagFromXml();
        String r127 = r113.getClickAction();
        if (r127 != null) goto L78;
    L81:
        boolean r128 = true;
    L82:
        if (r128 == true) goto L85;
        r102 = r125;
    L85:
        r126.setOnClickListener(r102);
        getTipsIconTagFromXml().setVisibility(0);
    L87:
        a();
        return;
    L78:
        if (r127.length() == 0) goto L81;
        r128 = false;
        goto L82
    L70:
        r122 = 0;
        goto L71
    L66:
        r119 = R.color.udtoken_tag_bg_orange;
        goto L67
    L62:
        r118 = R.color.ud_O400;
    L86:
        getTipsIconTagFromXml().setVisibility(8);
        goto L87
    L55:
        r115 = null;
        goto L56
    L52:
        r114 = null;
        goto L53
    L49:
        r113 = null;
        goto L50
    L45:
        r112 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = null;
    L21:
        r105 = null;
        goto L34
    L22:
        f r129 = this.f213215n;
        if (r129 == null) goto L25;
        String r130 = r129.f465351a.f465346b;
    L27:
        if (TextUtils.isEmpty(r130) == true) goto L33;
        r105 = new Icon();
        f r131 = this.f213215n;
        if (r131 == null) goto L31;
        String r132 = r131.f465351a.f465346b;
    L32:
        r105.setUrl(r132);
        r105.setErrorRes(Integer.valueOf(getBitableGradationLogoResId()));
        goto L34
    L31:
        r132 = null;
        goto L32
    L33:
        r105 = new Icon();
        r105.setImgRes(Integer.valueOf(getBitableGradationLogoResId()));
        goto L34
    L25:
        r130 = null;
    L7:
        r104 = null;
        goto L9
    }

    public BitableHeaderContainer(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        ArrayList r112 = new ArrayList();
        this.f213214m = r112;
        LayoutInflater.from(r100).inflate(R.layout.bitable_header_container_layout, this, true);
        if (eu5.c.c() == false) goto L12;
        int r101 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r102 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("bitable.mobile.mockfg.tips") == false) goto L12;
        if (((Boolean) new ml5.b("debug_config").a("bitable_show_mock_fg_tips_enable", Boolean.TRUE)).booleanValue() == false) goto L12;
        if (((jdb.f) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.f.class)).a().isEmpty() == true) goto L12;
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setOrientation(0);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 8388629;
        r103.setLayoutParams(r104);
        r103.setBackgroundColor(r103.getContext().getResources().getColor(R.color.function_danger_500));
        AppCompatImageView r105 = new AppCompatImageView(getContext());
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(com.bytedance.ee.util.ui.n.c(20.0f), com.bytedance.ee.util.ui.n.c(20.0f));
        r106.gravity = 16;
        r105.setLayoutParams(r106);
        r105.setImageDrawable(UDIconUtils.getIconDrawable(r105.getContext(), R.drawable.ud_icon_close_small_outlined, r105.getContext().getResources().getColor(R.color.static_white)));
        r105.setPadding(com.bytedance.ee.util.ui.n.c(2.0f), 0, com.bytedance.ee.util.ui.n.c(2.0f), 0);
        r105.setOnClickListener(new ys4.a(r103));
        r103.addView(r105);
        TextView r107 = new TextView(getContext());
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.gravity = 8388629;
        r107.setLayoutParams(r108);
        r107.setText("MockFG Detected>");
        r107.setTextColor(r107.getContext().getResources().getColor(R.color.static_white));
        r107.setPadding(com.bytedance.ee.util.ui.n.c(2.0f), 0, com.bytedance.ee.util.ui.n.c(8.0f), com.bytedance.ee.util.ui.n.c(2.0f));
        r107.setOnClickListener(ys4.b.f568989a);
        r103.addView(r107);
        addView(r103);
    L12:
        nu5.a.a(getTableIconFromXml(), 16, 16);
        com.bytedance.ee.bear.bitable.common.e.b(this, 0.97f, 4);
        UDTagsDrawable.d.a r109 = new UDTagsDrawable.d.a(getContext());
        r109.f285353c = getContext().getString(R.string.Doc_Widget_External);
        r109.c(UDTagsDrawable.TagColorSet.BLUE);
        UDTagsDrawable.d r113 = r109.b();
        b r114 = new b();
        r114.f213216a = "external";
        r114.f213217b = r113;
        UDTagsDrawable.d.a r115 = new UDTagsDrawable.d.a(getContext());
        r115.f285353c = getContext().getString(R.string.Doc_Create_File_ByTemplate);
        r115.c(UDTagsDrawable.TagColorSet.INDIGO);
        UDTagsDrawable.d r116 = r115.b();
        b r117 = new b();
        r117.f213216a = ThumbGlideUrl.SOURCE_TEMPLATE;
        r117.f213217b = r116;
        r112.add(r117);
        r112.add(r114);
    }

    public final int b(TextView r110, int r111, List<Float> r112) {
        int r113 = getTitleAvaliableWidth();
        if (r113 != 0) goto L5;
        return 0;
    L5:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L20;
        CharSequence r101 = r110.getText();
        CharSequence r102 = r110.getText();
        if (r102 == null) goto L10;
        int r103 = r102.length();
    L11:
        StaticLayout.Builder r104 = StaticLayout.Builder.obtain(r101, 0, r103, r110.getPaint(), r113);
        r104.setAlignment(Layout.Alignment.ALIGN_NORMAL);
        r104.setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR);
        r104.setLineSpacing(r110.getLineSpacingExtra(), r110.getLineSpacingMultiplier());
        r104.setIncludePad(r110.getIncludeFontPadding());
        r104.setBreakStrategy(r110.getBreakStrategy());
        r104.setHyphenationFrequency(r110.getHyphenationFrequency());
        r104.setMaxLines(2);
        if (r100 < 26) goto L15;
        r104.setJustificationMode(r110.getJustificationMode());
    L15:
        if (r110.getEllipsize() != null) goto L17;
    L19:
        StaticLayout r105 = r104.build();
    L26:
        if (r111 < (r112.size() - 1)) goto L30;
        return r105.getLineCount();
    L30:
        if (r105.getLineCount() <= 1) goto L34;
        int r106 = r111 + 1;
        r110.setTextSize(((Number) ListProtector.get(r112, r106)).floatValue());
        return b(r110, r106, r112);
    L34:
        return r105.getLineCount();
    L17:
        if (r110.getKeyListener() == null) goto L19;
        r104.setEllipsize(r110.getEllipsize());
        r104.setEllipsizedWidth(r113);
        goto L19
    L10:
        r103 = 0;
        goto L11
    L20:
        CharSequence r107 = r110.getText();
        CharSequence r108 = r110.getText();
        if (r108 == null) goto L23;
        int r109 = r108.length();
    L24:
        r105 = new StaticLayout(r107, 0, r109, r110.getPaint(), r113, Layout.Alignment.ALIGN_NORMAL, r110.getLineSpacingMultiplier(), r110.getLineSpacingExtra(), r110.getIncludeFontPadding(), r110.getEllipsize(), r113);
        goto L26
    L23:
        r109 = 0;
        goto L24
    }

    public /* synthetic */ BitableHeaderContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
