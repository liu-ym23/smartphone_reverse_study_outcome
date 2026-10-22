package com.larus.bmhome.double_post.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.videogroup.VideoGroupV2Widget;
import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.InteractInfo;
import com.larus.bmhome.video.InteractionStatistic;
import com.larus.bmhome.video.InteractionStatus;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.chat.common.databinding.LarusCardAwemeAuthorInfoBinding;
import com.larus.chat.common.databinding.LarusCardAwemeRecommendContentBinding;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import ip8.e;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kp8.b;
import kp8.c;
import kp8.f;
import rh8.j;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\"\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0003R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/double_post/view/AwemeRecommendContentView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larus/chat/common/databinding/LarusCardAwemeRecommendContentBinding;", "data", "Lcom/larus/bmhome/video/Content;", "clickX", "", "clickY", "screenPos", "", "init", "", "bindData", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "setupMainView", "setupCover", "coverWidth", "isMixedWithText", "", "setupPlayerIcon", "setupDescription", "setupAuthorInfo", "setupInteraction", "setupLikedStatus", "isLiked", "likedCount", "", "formattedLikedCount", "", "setupListeners", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendContentView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f311632f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusCardAwemeRecommendContentBinding f311633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Content f311634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f311635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f311636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f311637e;

    public static final class a {
        public static String a(Content r100) {
            if (r100 == null) goto L4;
            Integer r101 = r100.getItemType();
        L5:
            int r102 = ItemType.VIDEO.getValue();
            if (r101 != null) goto L9;
        L11:
            int r103 = ItemType.ARTICLE.getValue();
            if (r101 != null) goto L15;
        L17:
            return "";
        L15:
            if (r101.intValue() != r103) goto L17;
            return "aweme_recommend_card_cover_post";
        L9:
            if (r101.intValue() != r102) goto L11;
            return "aweme_recommend_card_cover_video";
        L4:
            r101 = null;
            goto L5
        }

        public static ImageObj b(ContentCover r100) {
            if (r100 == null) goto L8;
            IconImage r101 = r100.getSelectedCover();
            if (r101 == null) goto L8;
            ImageObj r102 = r101.imageOri;
            if (r102 == null) goto L8;
            return r102;
        L8:
            if (r100 == null) goto L12;
            IconImage r103 = r100.getOriginCover();
            if (r103 == null) goto L12;
            ImageObj r104 = r103.imageOri;
        L13:
            if (r104 != null) goto L19;
            if (r100 == null) goto L21;
            IconImage r105 = r100.getDynamicCover();
            if (r105 != null) goto L23;
            return null;
        L23:
            return r105.imageOri;
        L21:
            return null;
        L19:
            return r104;
        L12:
            r104 = null;
            goto L13
        }
    }

    static {
    }

    public AwemeRecommendContentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f311637e = new int[2];
        b(r100);
    }

    private final void setupDescription(boolean r100) {
        Content r101 = this.f311634b;
        if (r101 == null) goto L60;
        ContentDescription r102 = r101.getContentDescription();
        if (r102 != null) goto L7;
        return;
    L7:
        if (o0.d(r102.getTitle()) == false) goto L10;
        String r103 = r102.getTitle();
    L13:
        LarusCardAwemeRecommendContentBinding r104 = this.f311633a;
        if (r104 == null) goto L62;
        AppCompatTextView r105 = r104.f323915g;
        if (r105 == null) goto L63;
        Content r106 = this.f311634b;
        Integer r107 = null;
        if (r106 == null) goto L22;
        CardRatioStrategy r108 = r106.getRatioStrategy();
        if (r108 == null) goto L22;
        Integer r109 = Integer.valueOf(r108.getValue());
    L23:
        CardRatioStrategy r110 = CardRatioStrategy.FixRatio;
        int r111 = r110.getValue();
        int r112 = -2;
        if (r109 == null) goto L40;
        if (r109.intValue() != r111) goto L40;
        e1.x(r105);
        ViewGroup.LayoutParams r113 = r105.getLayoutParams();
        if (r113 == null) goto L38;
        Lazy r114 = f.f505528a;
        Integer r115 = Integer.valueOf(r110.getValue());
        int r116 = r110.getValue();
        if (r115 != null) goto L34;
    L36:
        r113.height = r112;
        r105.setLayoutParams(r113);
        r105.setText(r103);
        return;
    L34:
        if (r115.intValue() != r116) goto L36;
        r112 = i5.Z();
        goto L36
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L40:
        if (o0.d(r103) == true) goto L44;
        if (r100 == true) goto L44;
        e1.o(r105);
        return;
    L44:
        e1.x(r105);
        ViewGroup.LayoutParams r117 = r105.getLayoutParams();
        if (r117 == null) goto L59;
        Lazy r118 = f.f505528a;
        Content r119 = this.f311634b;
        if (r119 == null) goto L51;
        CardRatioStrategy r120 = r119.getRatioStrategy();
        if (r120 == null) goto L51;
        r107 = Integer.valueOf(r120.getValue());
    L51:
        int r121 = r110.getValue();
        if (r107 != null) goto L55;
    L57:
        r117.height = r112;
        r105.setLayoutParams(r117);
        r105.setText(r103);
        return;
    L55:
        if (r107.intValue() != r121) goto L57;
        r112 = i5.Z();
        goto L57
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        r109 = null;
        goto L23
    L63:
        return;
    L62:
        return;
    L10:
        if (o0.d(r102.getDescription()) == false) goto L12;
        r103 = r102.getDescription();
        goto L13
    L12:
        r103 = "";
        goto L13
    }

    private final void setupListeners(ip8.f r100) {
        final LarusCardAwemeRecommendContentBinding r101 = this.f311633a;
        if (r101 == null) goto L10;
        if (r100 == null) goto L8;
        final e r102 = r100.e();
        if (r102 == null) goto L8;
        e1.d(r101.f323909a, new kp8.a(this, r102));
        r101.f323909a.setOnLongClickListener(new b(this, r102));
    L8:
        r101.f323909a.setOnTouchListener(new c(r101, this));
        return;
    }

    private final void setupMainView(ip8.f r100) {
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.b() != true) goto L7;
    L8:
        if (r101 == false) goto L17;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r100.d(), -1);
        if (r100.a() == false) goto L12;
        r102.leftMargin = i5.j0();
        r102.rightMargin = i5.j0();
        r102.topMargin = i5.j0();
        r102.bottomMargin = i5.j0();
    L12:
        setLayoutParams(r102);
        LarusCardAwemeRecommendContentBinding r103 = this.f311633a;
        if (r103 == null) goto L36;
        ShapeConstraintLayout r104 = r103.f323914f;
        if (r104 == null) goto L37;
        ShapeConstraintLayout.U5(r104, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_3, getContext(), R.color.larus_base_3)), 0, 0, 510);
        return;
    L37:
        return;
    L36:
        return;
    L17:
        if (r100 == null) goto L19;
        r100.c();
    L19:
        Lazy r105 = com.larus.bmhome.video.b.f315193a;
        int r106 = com.larus.bmhome.video.b.b(false);
        LarusCardAwemeRecommendContentBinding r107 = this.f311633a;
        ViewGroup.MarginLayoutParams r108 = null;
        if (r107 == null) goto L24;
        ShapeConstraintLayout r109 = r107.f323914f;
        if (r109 == null) goto L24;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
    L26:
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        r108 = (ViewGroup.MarginLayoutParams) r110;
    L28:
        if (r108 == null) goto L30;
        r108.leftMargin = r106;
        r108.topMargin = r106;
        r108.rightMargin = r106;
        r108.bottomMargin = r106;
    L30:
        LarusCardAwemeRecommendContentBinding r111 = this.f311633a;
        if (r111 == null) goto L39;
        ShapeConstraintLayout r112 = r111.f323913e;
        if (r112 == null) goto L40;
        ShapeConstraintLayout.U5(r112, 0, 0, com.larus.bmhome.video.b.c(false), 255);
        return;
    L40:
        return;
    L39:
        return;
    L24:
        r110 = null;
    L7:
        r101 = false;
        goto L8
    }

    public final void b(Context r110) {
        LayoutInflater.from(r110).inflate(R.layout.larus_card_aweme_recommend_content, this);
        int r111 = R.id.author_info_container;
        View r100 = ViewBindings.findChildViewById(this, R.id.author_info_container);
        if (r100 == null) goto L17;
        LarusCardAwemeAuthorInfoBinding r101 = LarusCardAwemeAuthorInfoBinding.a(r100);
        r111 = R.id.cover;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.cover);
        if (r102 == null) goto L17;
        r111 = R.id.player_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(this, R.id.player_icon);
        if (r103 == null) goto L17;
        r111 = R.id.shadow;
        ShapeConstraintLayout r104 = (ShapeConstraintLayout) ViewBindings.findChildViewById(this, R.id.shadow);
        if (r104 == null) goto L17;
        r111 = R.id.shape_layout;
        ShapeConstraintLayout r105 = (ShapeConstraintLayout) ViewBindings.findChildViewById(this, R.id.shape_layout);
        if (r105 == null) goto L17;
        r111 = R.id.title;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.title);
        if (r106 == null) goto L17;
        this.f311633a = new LarusCardAwemeRecommendContentBinding(this, r101, r102, r103, r104, r105, r106);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r111)));
    }

    public AwemeRecommendContentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f311637e = new int[2];
        b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final void a(Content r110, j r111) {
        this.f311634b = r110;
        setupMainView(r111);
        int r112 = VideoGroupV2Widget.f307291i;
        Content r100 = this.f311634b;
        boolean r101 = false;
        String r102 = null;
        if (r100 == null) goto L43;
        ContentCover r103 = r100.getCover();
        if (r103 == null) goto L43;
        LarusCardAwemeRecommendContentBinding r104 = this.f311633a;
        if (r104 == null) goto L43;
        SimpleDraweeView r105 = r104.f323911c;
        if (r105 == null) goto L43;
        r105.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(i5.Y(), i5.Y(), 0.0f, 0.0f));
        ImageObj r106 = a.b(r103);
        e1.x(r105);
        Lazy r107 = f.f505528a;
        if (r106 == null) goto L13;
        int r108 = r106.width;
    L14:
        if (r106 == null) goto L16;
        int r109 = r106.height;
    L17:
        Content r113 = this.f311634b;
        if (r113 == null) goto L22;
        CardRatioStrategy r114 = r113.getRatioStrategy();
        if (r114 == null) goto L22;
        Integer r115 = Integer.valueOf(r114.getValue());
    L24:
        if (r112 > 0) goto L26;
        Pair r116 = new Pair(0, 0);
    L38:
        int r117 = ((Number) r116.component1()).intValue();
        int r118 = ((Number) r116.component2()).intValue();
        ViewGroup.LayoutParams r119 = r105.getLayoutParams();
        r119.height = r118;
        r119.width = r117;
        r105.setLayoutParams(r119);
        if (r106 == null) goto L41;
        String r120 = r106.url;
    L42:
        ImageLoaderKt.u(r105, r120, a.a(this.f311634b));
        goto L43
    L41:
        r120 = null;
        goto L42
    L26:
        if (r115 == null) goto L28;
        ?? r121 = r115.intValue();
    L29:
        if (r108 <= 0) goto L31;
        if (r109 <= 0) goto L31;
    L33:
        if (r121 == 0) goto L37;
        if (r121 == 1) goto L36;
        r116 = f.a(r112, r108, r109);
        goto L38
    L36:
        r116 = new Pair(Integer.valueOf(r112), Integer.valueOf((int) (r112 * ((Number) f.f505529b.getValue()).floatValue())));
        goto L38
    L37:
        r116 = f.a(r112, r108, r109);
    L31:
        if (r121 != 0) goto L33;
        r116 = new Pair(0, 0);
        goto L38
    L28:
        r121 = ((Boolean) f.f505528a.getValue()).booleanValue();
    L22:
        r115 = null;
        goto L24
    L16:
        r109 = 0;
        goto L17
    L13:
        r108 = 0;
    L43:
        LarusCardAwemeRecommendContentBinding r122 = this.f311633a;
        if (r122 == null) goto L59;
        ImageView r123 = r122.f323912d;
        if (r123 == null) goto L59;
        Content r124 = this.f311634b;
        if (r124 == null) goto L55;
        Integer r125 = r124.getItemType();
        int r126 = ItemType.VIDEO.getValue();
        if (r125 == null) goto L55;
        if (r125.intValue() != r126) goto L55;
        boolean r127 = true;
    L56:
        if (r127 == false) goto L58;
        e1.x(r123);
        goto L59
    L58:
        e1.o(r123);
    L55:
        r127 = false;
    L59:
        setupDescription(true);
        Content r128 = this.f311634b;
        if (r128 == null) goto L74;
        AuthorInfo r129 = r128.getAuthorInfo();
        if (r129 == null) goto L74;
        LarusCardAwemeRecommendContentBinding r130 = this.f311633a;
        if (r130 == null) goto L74;
        LarusCardAwemeAuthorInfoBinding r131 = r130.f323910b;
        if (r131 == null) goto L74;
        RoundAvatarImageView r132 = r131.f323905b;
        IconImage r133 = r129.getAvatar();
        if (r133 == null) goto L72;
        ImageObj r134 = r133.imageThumb;
        if (r134 == null) goto L72;
        String r135 = r134.url;
    L73:
        ImageLoaderKt.u(r132, r135, "aweme_recommend_card_avatar");
        r131.f323908e.setText(r129.getNickName());
    L72:
        r135 = null;
    L74:
        Content r136 = this.f311634b;
        if (r136 == null) goto L92;
        InteractInfo r137 = r136.getInteractInfo();
        if (r137 == null) goto L92;
        InteractionStatus r138 = r137.getStatus();
        if (r138 == null) goto L81;
        r101 = r138.isLiked();
    L81:
        InteractionStatistic r139 = r137.getStatistic();
        if (r139 == null) goto L84;
        r139.getLikedCount();
    L84:
        InteractionStatistic r140 = r137.getStatistic();
        if (r140 == null) goto L87;
        r102 = r140.getFormattedLikedCount();
    L87:
        LarusCardAwemeRecommendContentBinding r141 = this.f311633a;
        if (r141 == null) goto L92;
        LarusCardAwemeAuthorInfoBinding r142 = r141.f323910b;
        if (r142 == null) goto L92;
        r142.f323907d.setSelected(r101);
        r142.f323906c.setText(r102);
    L92:
        setupListeners(r111);
    }

    public AwemeRecommendContentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f311637e = new int[2];
        b(r100);
    }
}
