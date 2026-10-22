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
import androidx.appcompat.widget.AppCompatTextView;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0002XYB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\u0006\u00109\u001a\u000205J\u000e\u0010:\u001a\u0002072\u0006\u0010 \u001a\u00020\tJ\u001f\u0010;\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u000105¢\u0006\u0002\u0010?J\u0006\u0010@\u001a\u000207J\u0010\u0010A\u001a\u0002072\b\u0010B\u001a\u0004\u0018\u00010=J\u0012\u0010C\u001a\u00020\"2\b\u0010D\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010E\u001a\u0002072\b\u0010F\u001a\u0004\u0018\u00010)J\u000e\u0010G\u001a\u0002072\u0006\u0010H\u001a\u000205J\u000e\u0010I\u001a\u0002072\u0006\u0010J\u001a\u000205J(\u0010K\u001a\u0002072\u0006\u0010L\u001a\u0002052\u0006\u0010M\u001a\u0002052\u0006\u0010N\u001a\u0002052\b\u0010O\u001a\u0004\u0018\u00010PJ\u0010\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010Q\u001a\u0002072\u0006\u0010D\u001a\u00020=H\u0002J\u0010\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020SH\u0002J\u0018\u0010V\u001a\u00020S2\u0006\u0010>\u001a\u0002052\u0006\u0010W\u001a\u00020=H\u0002R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "wikiFixedTitleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getWikiFixedTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setWikiFixedTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "tvWikiTitleFromXml", "Landroid/widget/TextView;", "getTvWikiTitleFromXml", "()Landroid/widget/TextView;", "setTvWikiTitleFromXml", "(Landroid/widget/TextView;)V", "ivWikiCoverFromXml", "Landroid/widget/ImageView;", "getIvWikiCoverFromXml", "()Landroid/widget/ImageView;", "setIvWikiCoverFromXml", "(Landroid/widget/ImageView;)V", "tvLabelFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;", "getTvLabelFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;", "setTvLabelFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceTagTextView;)V", "floatingTitleBar", "floatSearchView", "Landroid/view/View;", "floatFavoriteView", "floatDetailView", "searchView", "favoriteView", "detailView", "cover", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/SpaceInfo$SpaceCover;", "wikiAiManager", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiSpaceAiManager;", "chatInitParam", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/ai/WikiChatInitParam;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/main/SpaceCoverView$ViewDelegate;)V", "isFavorite", "", "initView", "", "initListener", "isDarkCover", "setFloatingTitleBar", "updateWikiAiEnable", "spaceId", "", "isGraphDark", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "onRelease", "setTitle", "title", "getCustomTitleView", "text", "setCover", "spaceCover", "setFavorite", "favorite", "setMoreVisible", "visible", "setLabelVisible", "sameAccount", "openSharing", "publicScope", "tagInfo", "Lcom/bytedance/ee/bear/wikiv2/home/api/DisplayTag;", "setLabel", "textRes", "", "setTextIconColor", "colorRes", "getBackgroundColor", "colorValue", "Companion", "ViewDelegate", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceCoverView extends RelativeLayout {
    public BaseTitleBar a;
    public TextView b;
    public ImageView c;
    public SpaceTagTextView d;
    public BaseTitleBar e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public SpaceInfo.SpaceCover l;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c m;
    public b n;
    public boolean o;

    public static final class a {
    }

    public interface b {
        void a();

        void b(boolean r1);

        void p();
    }

    public static final class c implements RequestListener<Drawable> {
        public c() {
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "target");
            tt5.a.e("Wiki_WikiCoverView", "bindImage glide onException", r1, false);
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Drawable r6 = (Drawable) r1;
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            return false;
        }
    }

    public static final class d extends CustomTarget<Drawable> {
        public final /* synthetic */ SpaceCoverView a;

        public d(SpaceCoverView r1) {
            this.a = r1;
        }

        public final void onLoadCleared(Drawable r2) {
            if (r2 == null) goto L5;
            this.a.getIvWikiCoverFromXml().setImageDrawable(r2);
            return;
        }

        public final void onLoadFailed(Drawable r2) {
            if (r2 == null) goto L5;
            this.a.getIvWikiCoverFromXml().setImageDrawable(r2);
            return;
        }

        public final void onLoadStarted(Drawable r2) {
            if (r2 == null) goto L5;
            this.a.getIvWikiCoverFromXml().setImageDrawable(r2);
            return;
        }

        public final void onResourceReady(Object r1, Transition r2) {
            Drawable r3 = (Drawable) r1;
            Intrinsics.checkNotNullParameter(r3, "resource");
            this.a.getIvWikiCoverFromXml().setImageDrawable(r3);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ SpaceCoverView a;

        public e(SpaceCoverView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            b r2 = this.a.getViewDelegate();
            if (r2 == null) goto L6;
            r2.p();
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ SpaceCoverView a;

        public f(SpaceCoverView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.getViewDelegate();
            if (r3 == null) goto L6;
            r3.b(!this.a.o);
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ SpaceCoverView a;

        public g(SpaceCoverView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            b r2 = this.a.getViewDelegate();
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    static {
    }

    public final ImageView getIvWikiCoverFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131376731);
        this.c = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    public final SpaceTagTextView getTvLabelFromXml() {
        AppCompatTextView r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131390840);
        this.d = (SpaceTagTextView) r0;
    L6:
        return (SpaceTagTextView) r0;
    }

    public final TextView getTvWikiTitleFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131391725);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final BaseTitleBar getWikiFixedTitleBarFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131393228);
        this.a = (BaseTitleBar) r0;
    L6:
        return (BaseTitleBar) r0;
    }

    public final b getViewDelegate() {
        return this.n;
    }

    private final void setLabel(int r4) {
        SpaceTagTextView r0 = getTvLabelFromXml();
        UDTagsDrawable.d.a r1 = new UDTagsDrawable.d.a(getContext());
        r1.c = getResources().getString(r4);
        r1.d = getResources().getColor(2131109113);
        r1.a(getResources().getColor(2131102126));
        r1.f = Integer.valueOf(getResources().getColor(2131106521));
        r0.y(r1.b());
    }

    private final void setTextIconColor(int r5) {
        int r6 = getResources().getColor(r5);
        getTvWikiTitleFromXml().setTextColor(r6);
        getWikiFixedTitleBarFromXml().getLeftImage().getDrawable().setTint(r6);
        View r0 = this.i;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchView");
        r0 = null;
    L5:
        View r2 = r0.findViewById(2131393182);
        if ((r2 instanceof ImageView) == false) goto L8;
        ((ImageView) r2).getDrawable().setTint(r6);
    L8:
        View r3 = this.j;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r3 = null;
    L11:
        View r4 = r3.findViewById(2131393182);
        if ((r4 instanceof ImageView) == false) goto L14;
        ((ImageView) r4).getDrawable().setTint(r6);
    L14:
        View r7 = this.k;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L18:
        View r8 = r1.findViewById(2131393182);
        if ((r8 instanceof ImageView) == false) goto L22;
        ((ImageView) r8).getDrawable().setTint(r6);
        return;
    L22:
        return;
    L17:
        r1 = r7;
        goto L18
    }

    public final void setCover(SpaceInfo.SpaceCover r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.l != null) goto L37;
        this.l = r8;
        if (r8.is_graph_dark == false) goto L9;
        setTextIconColor(2131106521);
    L10:
        boolean r0 = r8.is_graph_dark;
        String r2 = r8.color_value;
        if (r0 == false) goto L13;
        int r1 = getResources().getColor(2131103467);
    L15:
        if (TextUtils.isEmpty(r2) == false) goto L33;
    L28:
        GradientDrawable r3 = new GradientDrawable();
        r3.setColor(r1);
        if (TextUtils.isEmpty(r8.origin) == false) goto L31;
        tt5.a.h("Wiki_WikiCoverView", "bindImage spaceCover.thumbnail is empty");
        getIvWikiCoverFromXml().setImageDrawable(r3);
        return;
    L31:
        Intrinsics.checkNotNull(Glide.with(this).load(new BearGlideUrl(r8.origin)).placeholder(r3).error(r3).listener(new c()).into(new d(this)));
        return;
    L33:
    L25:
        e = move-exception;
        tt5.a.d("Wiki_WikiCoverView", e.toString());
    L27:
        tt5.a.h("Wiki_WikiCoverView", "colorValue:  " + r2 + "   color:  " + r1);
        goto L28
    L18:
        if (TextUtils.isEmpty(r2) == false) goto L20;
    L22:
        String r4 = r2;
    L23:
        r1 = Color.parseColor(r4);     // Catch: Exception -> L25
        goto L27
    L20:
        if (StringsKt.startsWith$default(r2, "#", false, 2, null) == true) goto L22;
        r4 = "#" + r2;     // Catch: Exception -> L25
        goto L23
    L13:
        r1 = getResources().getColor(2131106521);
        goto L15
    L9:
        setTextIconColor(2131106500);
        goto L10
    }

    public final void setFavorite(boolean r7) {
        this.o = r7;
        if (r7 == false) goto L5;
        int r8 = 2131254138;
    L6:
        SpaceInfo.SpaceCover r0 = this.l;
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        if (r1 == false) goto L13;
        int r2 = 2131106521;
    L14:
        View r3 = this.j;
        View r4 = null;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r3 = null;
    L17:
        View r5 = r3.findViewById(2131393182);
        if ((r5 instanceof ImageView) == false) goto L23;
        ImageView r6 = (ImageView) r5;
        r6.setImageResource(r8);
        if (this.o == false) goto L22;
        r6.getDrawable().setTint(getResources().getColor(2131103533));
        goto L23
    L22:
        r6.getDrawable().setTint(getResources().getColor(r2));
    L23:
        View r9 = this.g;
        if (r9 == null) goto L27;
        r4 = r9.findViewById(2131393182);
    L27:
        if ((r4 instanceof ImageView) == false) goto L33;
        ImageView r10 = (ImageView) r4;
        r10.setImageResource(r8);
        if (this.o == false) goto L31;
        r10.getDrawable().setTint(getResources().getColor(2131103533));
        return;
    L31:
        r10.getDrawable().setTint(getResources().getColor(2131102418));
        return;
    L33:
        return;
    L13:
        r2 = 2131106500;
        goto L14
    L9:
        if (r0.is_graph_dark != true) goto L11;
        r1 = true;
        goto L11
    L5:
        r8 = 2131254139;
        goto L6
    }

    public final void setFloatingTitleBar(BaseTitleBar r4) {
        Intrinsics.checkNotNullParameter(r4, "floatingTitleBar");
        this.e = r4;
        this.f = r4.a(new BaseTitleBar.c(2131255617), true);
        this.g = r4.a(new BaseTitleBar.c(2131254139), true);
        this.h = r4.a(new BaseTitleBar.c(2131254921), true);
        View r5 = this.f;
        if (r5 == null) goto L5;
        r5.setOnClickListener(new e(this));
    L5:
        View r6 = this.g;
        if (r6 == null) goto L8;
        r6.setOnClickListener(new f(this));
    L8:
        View r7 = this.h;
        if (r7 == null) goto L12;
        r7.setOnClickListener(new g(this));
        return;
    }

    public final void setIvWikiCoverFromXml(ImageView r1) {
        this.c = r1;
    }

    public final void setMoreVisible(boolean r5) {
        View r0 = this.j;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r0 = null;
    L5:
        int r2 = 8;
        r0.setVisibility(8);
        View r3 = this.k;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L10:
        if (r5 == false) goto L12;
        int r4 = 0;
    L13:
        r1.setVisibility(r4);
        View r6 = this.g;
        if (r6 == null) goto L16;
        r6.setVisibility(8);
    L16:
        View r7 = this.h;
        if (r7 == null) goto L22;
        if (r5 == false) goto L20;
        r2 = 0;
    L20:
        r7.setVisibility(r2);
        return;
    L22:
        return;
    L12:
        r4 = 8;
        goto L13
    L8:
        r1 = r3;
        goto L10
    }

    public final void setTitle(String r7) {
        TextView r0 = getTvWikiTitleFromXml();
        if (r7 == null) goto L5;
        String r2 = r7;
    L6:
        r0.setText(r2);
        BaseTitleBar r1 = this.e;
        if (r1 == null) goto L13;
        View r3 = RelativeLayout.inflate(getContext(), 2131568247, null);
        TextView r4 = (TextView) r3.findViewById(2131388772);
        r4.getPaint().setFakeBoldText(true);
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r4.setText(r7);
        Intrinsics.checkNotNull(r3);
        r1.setCustomTitleView(r3);
    L13:
        BaseTitleBar r8 = this.e;
        if (r8 == null) goto L17;
        r8.setIsCenterAlways(false);
        return;
    L17:
        return;
    L5:
        r2 = "";
        goto L6
    }

    public final void setTvLabelFromXml(SpaceTagTextView r1) {
        this.d = r1;
    }

    public final void setTvWikiTitleFromXml(TextView r1) {
        this.b = r1;
    }

    public final void setViewDelegate(b r1) {
        this.n = r1;
    }

    public final void setWikiFixedTitleBarFromXml(BaseTitleBar r1) {
        this.a = r1;
    }

    private final void setLabel(String r4) {
        SpaceTagTextView r0 = getTvLabelFromXml();
        UDTagsDrawable.d.a r1 = new UDTagsDrawable.d.a(getContext());
        r1.c = r4;
        r1.d = getResources().getColor(2131109113);
        r1.a(getResources().getColor(2131102126));
        r1.f = Integer.valueOf(getResources().getColor(2131106521));
        r0.y(r1.b());
    }

    public SpaceCoverView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.m = new com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c();
        LayoutInflater.from(r3).inflate(2131568266, this);
        getWikiFixedTitleBarFromXml().setBackgroundColor(0);
        this.i = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(2131255617), true);
        this.j = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(2131254139), true);
        this.k = getWikiFixedTitleBarFromXml().a(new BaseTitleBar.c(2131254921), true);
        View r5 = this.i;
        View r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchView");
        r5 = null;
    L5:
        r5.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.e(this));
        View r7 = this.j;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("favoriteView");
        r7 = null;
    L8:
        r7.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.f(this));
        View r8 = this.k;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("detailView");
    L12:
        r6.setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.g(this));
        return;
    L11:
        r6 = r8;
        goto L12
    }

    public final void a(boolean r4, boolean r5, boolean r6, DisplayTag r7) {
        boolean r0 = true;
        int r1 = 0;
        if (r7 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        r4 = true;
    L11:
        if (r4 == false) goto L18;
        if (r7 == null) goto L14;
        String r8 = r7.getTag_value();
    L16:
        if (TextUtils.isEmpty(r8) == true) goto L18;
    L19:
        AppCompatTextView r9 = getTvLabelFromXml();
        if (r0 == true) goto L23;
        r1 = 8;
    L23:
        r9.setVisibility(r1);
        if (r0 == false) goto L35;
        if (r7 == null) goto L30;
        String r10 = r7.getTag_value();
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        setLabel(r10);
        return;
    L30:
        if (r5 == false) goto L32;
        setLabel(2131889830);
        return;
    L32:
        if (r6 == false) goto L38;
        setLabel(2131889822);
        return;
    L38:
        return;
    L35:
        return;
    L14:
        r8 = null;
    L18:
        r0 = false;
        goto L19
    L5:
        if (r7.isValidInSameTenant() != true) goto L7;
        r2 = true;
        goto L8
    }
}
