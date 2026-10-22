package com.ss.android.lark.emoji_office;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010#J\u0010\u0010*\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010%J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIcon", "Landroid/widget/ImageView;", "avatarContainer", "Landroid/widget/FrameLayout;", "remainingCountText", "Landroid/widget/TextView;", "avatarViewPool", "", "getAvatarViewPool", "()Ljava/util/List;", "avatarViewPool$delegate", "Lkotlin/Lazy;", "requestBitmapListeners", "", "", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "getRequestBitmapListeners", "()Ljava/util/Map;", "requestBitmapListeners$delegate", "avatarSize", "getAvatarSize", "()I", "avatarSize$delegate", "onReactionClickListener", "Lcom/ss/android/lark/emoji_office/OnReactionClickListener;", "onImageLoadedListener", "Lcom/ss/android/lark/emoji_office/OfficeReactionItemView$OnImageLoadedListener;", "currentReactionKey", "setOnReactionClickListener", "", "listener", "setOnImageLoadedListener", "initView", "setData", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "updateEmojiIconSize", "reactionKey", "ensureAvatarViews", "requiredCount", "Companion", "OnImageLoadedListener", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionItemView extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f420621h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f420622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f420623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f420624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f420625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f420626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f420627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f420628g;

    public static final class a {
    }

    public interface b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeReactionItemView f420629a;

        public c(OfficeReactionItemView r100, String r101) {
            this.f420629a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OfficeReactionItemView r101 = this.f420629a;
            int r102 = OfficeReactionItemView.f420621h;
            r101.getClass();
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeReactionItemView f420630a;

        public d(OfficeReactionItemView r100, int r101, String r102, String r103) {
            this.f420630a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OfficeReactionItemView r101 = this.f420630a;
            int r102 = OfficeReactionItemView.f420621h;
            r101.getClass();
        }
    }

    static {
    }

    public OfficeReactionItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OfficeReactionItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnImageLoadedListener(b r100) {
    }

    public final void setOnReactionClickListener(com.ss.android.lark.emoji_office.b r100) {
    }

    private final int getAvatarSize() {
        return ((Number) this.f420627f.getValue()).intValue();
    }

    private final List<ImageView> getAvatarViewPool() {
        return (List) this.f420625d.getValue();
    }

    private final Map<String, IGetDataCallback<Boolean>> getRequestBitmapListeners() {
        return (Map) this.f420626e.getValue();
    }

    public static final /* synthetic */ Map a(OfficeReactionItemView r100) {
        return r100.getRequestBitmapListeners();
    }

    public final void b(String r100) {
        int r101 = UIHelper.dp2px(20.0f);
        qsb.a r102 = qsb.b.a().Yd(r100);
        if (r102 != null) goto L5;
    L7:
        int r103 = r101;
    L8:
        ImageView r104 = this.f420622a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r104 = null;
    L11:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L16;
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.width = r103;
        r106.height = r101;
        r104.setLayoutParams(r106);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L5:
        if (r102.a() <= 0) goto L7;
        r103 = (int) ((r101 * r102.c()) / r102.a());
        goto L8
    }

    public final void setData(q2c.c r110) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        getRequestBitmapListeners().clear();
        final String r100 = r110.f531474a;
        this.f420628g = r100;
        ImageView r101 = this.f420622a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r101 = null;
    L5:
        r101.setOnClickListener(new c(this, r100));
        Intrinsics.checkNotNull(r100);
        b(r100);
        Bitmap r102 = qsb.b.a().v1(r100);
        if (r102 == null) goto L14;
        ImageView r103 = this.f420622a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r103 = null;
    L10:
        r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView r104 = this.f420622a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r104 = null;
    L13:
        r104.setImageBitmap(r102);
    L21:
        List<q2c.d> r105 = r110.f531476c;
        List<q2c.d> r106 = r105;
        if (r106 != null) goto L24;
    L27:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L42;
        Iterator<T> r108 = getAvatarViewPool().iterator();
    L32:
        if (r108.hasNext() == false) goto L34;
        ImageView r109 = (ImageView) r108.next();
        r109.setVisibility(8);
        r109.setImageDrawable(null);
        goto L32
    L34:
        TextView r111 = this.f420624c;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r111 = null;
    L37:
        r111.setVisibility(8);
        FrameLayout r112 = this.f420623b;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r112 = null;
    L40:
        r112.setOnClickListener(null);
        return;
    L42:
        int r113 = r105.size();
        int r114 = Math.min(r113, 5);
        if (r113 != 1) goto L45;
        String r115 = ((q2c.d) ListProtector.get(r105, 0)).f531477a;
    L46:
        FrameLayout r116 = this.f420623b;
        if (r116 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r116 = null;
    L49:
        r116.setOnClickListener(new d(this, r113, r115, r100));
        int r117 = Math.min(r114, 5);
    L51:
        if (getAvatarViewPool().size() >= r117) goto L69;
        int r118 = getAvatarViewPool().size();
        Log.i("OfficeReactionItemView", "host[" + hashCode() + "] create avatarView index=" + r118);
        ImageView r119 = new ImageView(getContext());
        r119.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r119.setPadding(UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f));
        GradientDrawable r120 = new GradientDrawable();
        r120.setShape(1);
        r120.setColor(ContextCompat.getColor(r119.getContext(), R.color.flow_ud_bg_base_2_overlay));
        r119.setBackground(r120);
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(UIHelper.dp2px(24.0f), UIHelper.dp2px(24.0f));
        r121.leftMargin = UIHelper.dp2px(r118 * 12.0f);
        r121.gravity = 16;
        r119.setLayoutParams(r121);
        r119.setClickable(false);
        r119.setVisibility(8);
        getAvatarViewPool().add(r119);
        FrameLayout r122 = this.f420623b;
        if (r122 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r122 = null;
    L55:
        TextView r123 = this.f420624c;
        if (r123 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r123 = null;
    L58:
        int r124 = r122.indexOfChild(r123);
        if (r124 >= 0) goto L65;
        FrameLayout r125 = this.f420623b;
        if (r125 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r125 = null;
    L64:
        r124 = r125.getChildCount();
    L65:
        FrameLayout r126 = this.f420623b;
        if (r126 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r126 = null;
    L68:
        r126.addView(r119, r124);
        goto L51
    L69:
        Iterator<T> r127 = getAvatarViewPool().iterator();
        int r128 = 0;
    L71:
        if (r127.hasNext() == false) goto L85;
        Object r129 = r127.next();
        int r130 = r128 + 1;
        if (r128 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();
    L75:
        ImageView r131 = (ImageView) r129;
        r131.setImageDrawable(null);
        r131.setClickable(false);
        if (r128 < r114) goto L78;
        r131.setVisibility(8);
    L81:
        r128 = r130;
        goto L71
    L78:
        q2c.d r132 = (q2c.d) ListProtector.get(r105, r128);
        r131.setVisibility(0);
        ViewGroup.LayoutParams r133 = r131.getLayoutParams();
        if (r133 == null) goto L83;
        FrameLayout.LayoutParams r134 = (FrameLayout.LayoutParams) r133;
        r134.leftMargin = UIHelper.dp2px(r128 * 12.0f);
        r131.setLayoutParams(r134);
        ImageLoader.with(getContext()).load(AvatarImage.Builder.obtain(r132.f531479c, r132.f531477a, getAvatarSize(), getAvatarSize()).build()).override(getAvatarSize(), getAvatarSize()).transform(new CropCircleTransformation()).into(r131);
        goto L81
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L85:
        if (r113 <= 5) goto L98;
        int r135 = r110.f531475b - 4;
        if (r135 > 99) goto L89;
        String r136 = Marker.ANY_NON_NULL_MARKER + r135;
    L90:
        TextView r137 = this.f420624c;
        if (r137 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r137 = null;
    L93:
        r137.setVisibility(0);
        TextView r138 = this.f420624c;
        if (r138 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        TextView r139 = null;
    L97:
        r139.setText(r136);
    L103:
        measure(0, 0);
        return;
    L96:
        r139 = r138;
        goto L97
    L89:
        r136 = "99+";
        goto L90
    L98:
        TextView r140 = this.f420624c;
        if (r140 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        TextView r141 = null;
    L102:
        r141.setVisibility(8);
        goto L103
    L101:
        r141 = r140;
        goto L102
    L45:
        r115 = null;
        goto L46
    L24:
        if (r106.isEmpty() == true) goto L27;
        r107 = false;
        goto L29
    L14:
        int r142 = UIHelper.dp2px(20.0f);
        GradientDrawable r143 = new GradientDrawable();
        r143.setShape(0);
        r143.setCornerRadius(r142 / 2.0f);
        r143.setColor(ContextCompat.getColor(getContext(), R.color.ud_N900_05));
        ImageView r144 = this.f420622a;
        if (r144 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r144 = null;
    L17:
        r144.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView r145 = this.f420622a;
        if (r145 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r145 = null;
    L20:
        r145.setImageDrawable(r143);
        Log.i("OfficeReactionItemView", "requestBitmap start for reactionKey: " + r100);
        IGetDataCallback<Boolean> r146 = new OfficeReactionItemView$setData$callback$1(r100, this);
        getRequestBitmapListeners().put(r100, r146);
        qsb.b.a().ge(r100, false, null, r146);
        goto L21
    }

    public OfficeReactionItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f420625d = LazyKt.lazy(OfficeReactionItemView$avatarViewPool$2.INSTANCE);
        this.f420626e = LazyKt.lazy(OfficeReactionItemView$requestBitmapListeners$2.INSTANCE);
        this.f420627f = LazyKt.lazy(OfficeReactionItemView$avatarSize$2.INSTANCE);
        setOrientation(0);
        setGravity(16);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setCornerRadius(UIHelper.dp2px(100.0f));
        r103.setColor(ContextCompat.getColor(getContext(), R.color.flow_ud_bg_base_2_overlay));
        setBackground(r103);
        setPadding(UIHelper.dp2px(8.0f), 0, UIHelper.dp2px(6.0f), 0);
        ImageView r104 = new ImageView(getContext());
        this.f420622a = r104;
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, UIHelper.dp2px(20.0f)));
        View r105 = this.f420622a;
        TextView r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r105 = null;
    L5:
        addView(r105);
        FrameLayout r107 = new FrameLayout(getContext());
        this.f420623b = r107;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, UIHelper.dp2px(24.0f));
        r108.leftMargin = UIHelper.dp2px(6.0f);
        r107.setLayoutParams(r108);
        View r109 = this.f420623b;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r109 = null;
    L8:
        addView(r109);
        TextView r110 = new TextView(getContext());
        r110.setTextColor(ContextCompat.getColor(r110.getContext(), R.color.static_white));
        r110.setTextSize(7.0f);
        r110.setGravity(17);
        r110.setVisibility(8);
        r110.setTypeface(r110.getTypeface(), 1);
        GradientDrawable r111 = new GradientDrawable();
        r111.setShape(1);
        r111.setColor(ColorProtector.parseColor("#4D000000"));
        r110.setBackground(r111);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(UIHelper.dp2px(20.0f), UIHelper.dp2px(20.0f));
        r112.gravity = 8388629;
        r112.rightMargin = UIHelper.dp2px(2.0f);
        r110.setLayoutParams(r112);
        this.f420624c = r110;
        FrameLayout r113 = this.f420623b;
        if (r113 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r113 = null;
    L11:
        TextView r114 = this.f420624c;
        if (r114 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
    L15:
        r113.addView(r106);
        return;
    L14:
        r106 = r114;
        goto L15
    }

    public /* synthetic */ OfficeReactionItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
