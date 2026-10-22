package com.larksuite.component.decoration.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ \u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u001a\u0010 \u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\"\u001a\u00020\u0016J,\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$*\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H$0'H\u0082\b¢\u0006\u0002\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decorationView", "Landroid/widget/ImageView;", "getDecorationView", "()Landroid/widget/ImageView;", "setDecorationView", "(Landroid/widget/ImageView;)V", "avatarView", "getAvatarView", "setAvatarView", "decorationElevation", "", "initDecorationView", "", "addAvatarView", "initAvatarView", "initAIAvatarView", "bgView", "loadSdkDecoration", "imageKey", "", "widthPx", "heightPx", "loadPassThroughDecoration", "fsUnit", "clearDecoration", NameKeys.LoadStrategy_Use, "R", "Landroid/content/res/TypedArray;", "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "avatar-decoration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DecoratedAvatar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f283986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f283987b;

    public static final class a {
    }

    static {
    }

    public DecoratedAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DecoratedAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ImageView getAvatarView() {
        return this.f283987b;
    }

    public final ImageView getDecorationView() {
        return this.f283986a;
    }

    public final void a(ImageView r100) {
        if (r100 == null) goto L9;
        ImageView r101 = this.f283987b;
        if (r101 == null) goto L7;
        removeView(r101);
    L7:
        r100.getParent();
        this.f283987b = r100;
        addView(r100, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public final void b(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        String r102 = r100;
    L10:
        if (r102 == null) goto L14;
        ImageLoader.with(getContext()).load(new EncryptImage(r100)).override(getMeasuredWidth(), getMeasuredHeight()).into(this.f283986a);
        return;
    L14:
        return;
    L9:
        r102 = null;
        goto L10
    L6:
        r101 = false;
        goto L7
    }

    public final void setAvatarView(ImageView r100) {
        this.f283987b = r100;
    }

    public final void setDecorationView(ImageView r100) {
        this.f283986a = r100;
    }

    public DecoratedAvatar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.decoratedAvatar_avatarLayout}, r102, 0);
        int r104 = r103.getResourceId(0, -1);
        if ((-1) == r104) goto L5;
        View r105 = LayoutInflater.from(r100).inflate(r104, this, false);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.ImageView");
        a((ImageView) r105);
    L5:
        Unit r106 = Unit.INSTANCE;
        r103.recycle();
        ImageView r107 = new ImageView(getContext());
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r107.setElevation(1.0f);
        this.f283986a = r107;
        addView(r107);
    }

    public /* synthetic */ DecoratedAvatar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
