package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceTagTextView;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0002XYB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\u0006\u00109\u001a\u000205J\u000e\u0010:\u001a\u0002072\u0006\u0010 \u001a\u00020\tJ\u001f\u0010;\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u000105¢\u0006\u0002\u0010?J\u0006\u0010@\u001a\u000207J\u0010\u0010A\u001a\u0002072\b\u0010B\u001a\u0004\u0018\u00010=J\u0012\u0010C\u001a\u00020\"2\b\u0010D\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010E\u001a\u0002072\b\u0010F\u001a\u0004\u0018\u00010)J\u000e\u0010G\u001a\u0002072\u0006\u0010H\u001a\u000205J\u000e\u0010I\u001a\u0002072\u0006\u0010J\u001a\u000205J(\u0010K\u001a\u0002072\u0006\u0010L\u001a\u0002052\u0006\u0010M\u001a\u0002052\u0006\u0010N\u001a\u0002052\b\u0010O\u001a\u0004\u0018\u00010PJ\u0010\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010Q\u001a\u0002072\u0006\u0010D\u001a\u00020=H\u0002J\u0010\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020SH\u0002J\u0018\u0010V\u001a\u00020S2\u0006\u0010>\u001a\u0002052\u0006\u0010W\u001a\u00020=H\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wikiFixedTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getWikiFixedTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setWikiFixedTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "tvWikiTitleFromXml", "Landroid/widget/TextView;", "getTvWikiTitleFromXml", "()Landroid/widget/TextView;", "setTvWikiTitleFromXml", "(Landroid/widget/TextView;)V", "ivWikiCoverFromXml", "Landroid/widget/ImageView;", "getIvWikiCoverFromXml", "()Landroid/widget/ImageView;", "setIvWikiCoverFromXml", "(Landroid/widget/ImageView;)V", "tvLabelFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;", "getTvLabelFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;", "setTvLabelFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;)V", "floatingTitleBar", "floatSearchView", "Landroid/view/View;", "floatFavoriteView", "floatDetailView", "searchView", "favoriteView", "detailView", "cover", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo$SpaceCover;", "wikiAiManager", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiSpaceAiManager;", "chatInitParam", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiChatInitParam;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;)V", Keys.API_EVENT_KEY_IS_FAVORITE, "", "initView", "", "initListener", "isDarkCover", "setFloatingTitleBar", "updateWikiAiEnable", "spaceId", "", "isGraphDark", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "onRelease", com.alipay.sdk.m.x.d.f25925o, "title", "getCustomTitleView", "text", "setCover", "spaceCover", "setFavorite", "favorite", "setMoreVisible", "visible", "setLabelVisible", "sameAccount", "openSharing", "publicScope", "tagInfo", "Lcom/bytedance/ee/bear/wikiv2/home/api/DisplayTag;", "setLabel", "textRes", "", "setTextIconColor", "colorRes", "getBackgroundColor", "colorValue", "Companion", "ViewDelegate", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceCoverView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseTitleBar f241454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f241455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f241456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpaceTagTextView f241457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f241458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f241459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f241460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f241461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f241462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f241463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f241464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SpaceInfo.SpaceCover f241465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c f241466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f241467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f241468o;

    public static final class a {
    }

    public interface b {
        void a();

        void b(boolean r100);

        void p();
    }

    public static final class c implements RequestListener<Drawable> {
        public c() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            tt5.a.e("Wiki_WikiCoverView", "bindImage glide onException", r100, false);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "dataSource");
            return false;
        }
    }

    public static final class d extends CustomTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceCoverView f241469a;

        public d(SpaceCoverView r100) {
            this.f241469a = r100;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadCleared(Drawable r100) {
            if (r100 == null) goto L5;
            this.f241469a.getIvWikiCoverFromXml().setImageDrawable(r100);
            return;
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable r100) {
            if (r100 == null) goto L5;
            this.f241469a.getIvWikiCoverFromXml().setImageDrawable(r100);
            return;
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public final void onLoadStarted(Drawable r100) {
            if (r100 == null) goto L5;
            this.f241469a.getIvWikiCoverFromXml().setImageDrawable(r100);
            return;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Drawable r102 = (Drawable) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            this.f241469a.getIvWikiCoverFromXml().setImageDrawable(r102);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceCoverView f241470a;

        public e(SpaceCoverView r100) {
            this.f241470a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f241470a.getViewDelegate();
            if (r101 == null) goto L6;
            r101.p();
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceCoverView f241471a;

        public f(SpaceCoverView r100) {
            this.f241471a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f241471a.getViewDelegate();
            if (r101 == null) goto L6;
            r101.b(!this.f241471a.f241468o);
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceCoverView f241472a;

        public g(SpaceCoverView r100) {
            this.f241472a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f241472a.getViewDelegate();
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    static {
    }

    public final ImageView getIvWikiCoverFromXml() {
        KeyEvent.Callback r100 = this.f241456c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.iv_wiki_cover);
        this.f241456c = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final SpaceTagTextView getTvLabelFromXml() {
        KeyEvent.Callback r100 = this.f241457d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tv_label);
        this.f241457d = (SpaceTagTextView) r100;
    L6:
        return (SpaceTagTextView) r100;
    }

    public final TextView getTvWikiTitleFromXml() {
        KeyEvent.Callback r100 = this.f241455b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tv_wiki_title);
        this.f241455b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final BaseTitleBar getWikiFixedTitleBarFromXml() {
        KeyEvent.Callback r100 = this.f241454a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.wiki_fixed_title_bar);
        this.f241454a = (BaseTitleBar) r100;
    L6:
        return (BaseTitleBar) r100;
    }

    public final b getViewDelegate() {
        return this.f241467n;
    }

    private final void setLabel(int r100) {
        SpaceTagTextView r101 = getTvLabelFromXml();
        UDTagsDrawable.d.a r102 = new UDTagsDrawable.d.a(getContext());
        r102.f285353c = getResources().getString(r100);
        r102.f285354d = getResources().getColor(R.color.udtoken_tag_neutral_text_inverse);
        r102.a(getResources().getColor(R.color.function_info_fill_hover));
        r102.f285356f = Integer.valueOf(getResources().getColor(R.color.static_white));
        r101.y(r102.b());
    }

    private final void setTextIconColor(int r100) {
        int r101 = getResources().getColor(r100);
        getTvWikiTitleFromXml().setTextColor(r101);
        getWikiFixedTitleBarFromXml().getLeftImage().getDrawable().setTint(r101);
        View r102 = this.f241462i;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchView");
        r102 = null;
    L5:
        View r104 = r102.findViewById(R.id.widgetTitleMenuImg);
        if ((r104 instanceof ImageView) == false) goto L8;
        ((ImageView) r104).getDrawable().setTint(r101);
    L8:
        View r105 = this.f241463j;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r105 = null;
    L11:
        View r106 = r105.findViewById(R.id.widgetTitleMenuImg);
        if ((r106 instanceof ImageView) == false) goto L14;
        ((ImageView) r106).getDrawable().setTint(r101);
    L14:
        View r107 = this.f241464k;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L18:
        View r108 = r103.findViewById(R.id.widgetTitleMenuImg);
        if ((r108 instanceof ImageView) == false) goto L22;
        ((ImageView) r108).getDrawable().setTint(r101);
        return;
    L22:
        return;
    L17:
        r103 = r107;
        goto L18
    }

    public final void setCover(SpaceInfo.SpaceCover r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f241465l != null) goto L37;
        this.f241465l = r100;
        if (r100.is_graph_dark == false) goto L9;
        setTextIconColor(R.color.static_white);
    L10:
        boolean r101 = r100.is_graph_dark;
        String r102 = r100.color_value;
        if (r101 == false) goto L13;
        int r103 = getResources().getColor(R.color.lkui_N950);
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L33;
    L28:
        GradientDrawable r104 = new GradientDrawable();
        r104.setColor(r103);
        if (TextUtils.isEmpty(r100.origin) == false) goto L31;
        tt5.a.h("Wiki_WikiCoverView", "bindImage spaceCover.thumbnail is empty");
        getIvWikiCoverFromXml().setImageDrawable(r104);
        return;
    L31:
        Intrinsics.checkNotNull(Glide.with(this).load(new BearGlideUrl(r100.origin)).placeholder(r104).error(r104).listener(new c()).into(new d(this)));
        return;
    L33:
    L25:
        e = move-exception;
        tt5.a.d("Wiki_WikiCoverView", e.toString());
    L27:
        tt5.a.h("Wiki_WikiCoverView", "colorValue:  " + r102 + "   color:  " + r103);
        goto L28
    L18:
        if (TextUtils.isEmpty(r102) == false) goto L20;
    L22:
        String r105 = r102;
    L23:
        r103 = Color.parseColor(r105);     // Catch: Exception -> L25
        goto L27
    L20:
        if (StringsKt.startsWith$default(r102, "#", false, 2, null) == true) goto L22;
        r105 = "#" + r102;     // Catch: Exception -> L25
        goto L23
    L13:
        r103 = getResources().getColor(R.color.static_white);
        goto L15
    L9:
        setTextIconColor(R.color.static_black);
        goto L10
    }

    public final void setFavorite(boolean r100) {
        this.f241468o = r100;
        if (r100 == false) goto L5;
        int r101 = R.drawable.ud_icon_collect_filled;
    L6:
        SpaceInfo.SpaceCover r102 = this.f241465l;
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L13;
        int r104 = R.color.static_white;
    L14:
        View r105 = this.f241463j;
        View r106 = null;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r105 = null;
    L17:
        View r107 = r105.findViewById(R.id.widgetTitleMenuImg);
        if ((r107 instanceof ImageView) == false) goto L23;
        ImageView r108 = (ImageView) r107;
        r108.setImageResource(r101);
        if (this.f241468o == false) goto L22;
        r108.getDrawable().setTint(getResources().getColor(R.color.lkui_Y500));
        goto L23
    L22:
        r108.getDrawable().setTint(getResources().getColor(r104));
    L23:
        View r109 = this.f241460g;
        if (r109 == null) goto L27;
        r106 = r109.findViewById(R.id.widgetTitleMenuImg);
    L27:
        if ((r106 instanceof ImageView) == false) goto L33;
        ImageView r110 = (ImageView) r106;
        r110.setImageResource(r101);
        if (this.f241468o == false) goto L31;
        r110.getDrawable().setTint(getResources().getColor(R.color.lkui_Y500));
        return;
    L31:
        r110.getDrawable().setTint(getResources().getColor(R.color.icon_n1));
        return;
    L33:
        return;
    L13:
        r104 = R.color.static_black;
        goto L14
    L9:
        if (r102.is_graph_dark != true) goto L11;
        r103 = true;
        goto L11
    L5:
        r101 = R.drawable.ud_icon_collection_outlined;
        goto L6
    }

    public final void setFloatingTitleBar(BaseTitleBar r100) {
        Intrinsics.checkNotNullParameter(r100, "floatingTitleBar");
        this.f241458e = r100;
        this.f241459f = r100.a(new BaseTitleBar.c(R.drawable.ud_icon_search_outlined), true);
        this.f241460g = r100.a(new BaseTitleBar.c(R.drawable.ud_icon_collection_outlined), true);
        this.f241461h = r100.a(new BaseTitleBar.c(R.drawable.ud_icon_info_outlined), true);
        View r101 = this.f241459f;
        if (r101 == null) goto L5;
        r101.setOnClickListener(new e(this));
    L5:
        View r102 = this.f241460g;
        if (r102 == null) goto L8;
        r102.setOnClickListener(new f(this));
    L8:
        View r103 = this.f241461h;
        if (r103 == null) goto L12;
        r103.setOnClickListener(new g(this));
        return;
    }

    public final void setIvWikiCoverFromXml(ImageView r100) {
        this.f241456c = r100;
    }

    public final void setMoreVisible(boolean r100) {
        View r101 = this.f241463j;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r101 = null;
    L5:
        int r103 = 8;
        r101.setVisibility(8);
        View r104 = this.f241464k;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L10:
        if (r100 == false) goto L12;
        int r105 = 0;
    L13:
        r102.setVisibility(r105);
        View r106 = this.f241460g;
        if (r106 == null) goto L16;
        r106.setVisibility(8);
    L16:
        View r107 = this.f241461h;
        if (r107 == null) goto L22;
        if (r100 == false) goto L20;
        r103 = 0;
    L20:
        r107.setVisibility(r103);
        return;
    L22:
        return;
    L12:
        r105 = 8;
        goto L13
    L8:
        r102 = r104;
        goto L10
    }

    public final void setTitle(String r100) {
        TextView r101 = getTvWikiTitleFromXml();
        if (r100 == null) goto L5;
        String r102 = r100;
    L6:
        r101.setText(r102);
        BaseTitleBar r103 = this.f241458e;
        if (r103 == null) goto L13;
        View r104 = RelativeLayout.inflate(getContext(), R.layout.wiki_main_title_bar, null);
        TextView r105 = (TextView) r104.findViewById(R.id.title);
        r105.getPaint().setFakeBoldText(true);
        if (r100 != null) goto L12;
        r100 = "";
    L12:
        r105.setText(r100);
        Intrinsics.checkNotNull(r104);
        r103.setCustomTitleView(r104);
    L13:
        BaseTitleBar r106 = this.f241458e;
        if (r106 == null) goto L17;
        r106.setIsCenterAlways(false);
        return;
    L17:
        return;
    L5:
        r102 = "";
        goto L6
    }

    public final void setTvLabelFromXml(SpaceTagTextView r100) {
        this.f241457d = r100;
    }

    public final void setTvWikiTitleFromXml(TextView r100) {
        this.f241455b = r100;
    }

    public final void setViewDelegate(b r100) {
        this.f241467n = r100;
    }

    public final void setWikiFixedTitleBarFromXml(BaseTitleBar r100) {
        this.f241454a = r100;
    }

    private final void setLabel(String r100) {
        SpaceTagTextView r101 = getTvLabelFromXml();
        UDTagsDrawable.d.a r102 = new UDTagsDrawable.d.a(getContext());
        r102.f285353c = r100;
        r102.f285354d = getResources().getColor(R.color.udtoken_tag_neutral_text_inverse);
        r102.a(getResources().getColor(R.color.function_info_fill_hover));
        r102.f285356f = Integer.valueOf(getResources().getColor(R.color.static_white));
        r101.y(r102.b());
    }

    public SpaceCoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f241466m = new com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c();
        LayoutInflater.from(r100).inflate(R.layout.wiki_tree_cover_view, this);
        getWikiFixedTitleBarFromXml().setBackgroundColor(0);
        this.f241462i = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(R.drawable.ud_icon_search_outlined), true);
        this.f241463j = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(R.drawable.ud_icon_collection_outlined), true);
        this.f241464k = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(R.drawable.ud_icon_info_outlined), true);
        View r102 = this.f241462i;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchView");
        r102 = null;
    L5:
        r102.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.e(this));
        View r104 = this.f241463j;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r104 = null;
    L8:
        r104.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.f(this));
        View r105 = this.f241464k;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L12:
        r103.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.g(this));
        return;
    L11:
        r103 = r105;
        goto L12
    }

    public final void a(boolean r100, boolean r101, boolean r102, DisplayTag r103) {
        boolean r104 = true;
        int r105 = 0;
        if (r103 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L11;
        r100 = true;
    L11:
        if (r100 == false) goto L18;
        if (r103 == null) goto L14;
        String r107 = r103.getTag_value();
    L16:
        if (TextUtils.isEmpty(r107) == true) goto L18;
    L19:
        SpaceTagTextView r108 = getTvLabelFromXml();
        if (r104 == true) goto L23;
        r105 = 8;
    L23:
        r108.setVisibility(r105);
        if (r104 == false) goto L35;
        if (r103 == null) goto L30;
        String r109 = r103.getTag_value();
        if (r109 != null) goto L29;
        r109 = "";
    L29:
        setLabel(r109);
        return;
    L30:
        if (r101 == false) goto L32;
        setLabel(R.string.LarkCCM_Wiki_WebAccess_Tag);
        return;
    L32:
        if (r102 == false) goto L38;
        setLabel(R.string.LarkCCM_Wiki_OrgAccess_Tag);
        return;
    L38:
        return;
    L35:
        return;
    L14:
        r107 = null;
    L18:
        r104 = false;
        goto L19
    L5:
        if (r103.isValidInSameTenant() != true) goto L7;
        r106 = true;
        goto L8
    }
}
