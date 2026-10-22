package com.ss.android.lark.feed.cardcomponent.title;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larksuite.framework.ui.SpareLayout;
import com.ss.android.lark.feed.cardcomponent.title.specialfocus.SpecialFocusComponent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002JB\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!J\f\u0010'\u001a\u00020%*\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/title/FeedCardTitleView;", "Lcom/larksuite/framework/ui/SpareLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/titleview/TitleViewComponent;", "specialFocusComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/specialfocus/SpecialFocusComponent;", "customStatusComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/customstatus/CustomStatusComponent;", "feedTagComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/feedtag/FeedTagComponent;", "init", "", "addTitleView", "addSpecialFocusView", "bindSpecialFocus", "isSpecialFocus", "", "addCustomStatusView", "bindCustomStatus", "customStatusDrawable", "Landroid/graphics/drawable/Drawable;", "addFeedTagView", "bindFeedTag", "drawable", "bindTitleView", "titleText", "", "feedTagDrawable", "isBoldDisplay", "titleTextSize", "", "bindTitleViewText", "dp2px", "", "generateLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardTitleView extends SpareLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wdb.a f420984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpecialFocusComponent f420985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public udb.a f420986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vdb.a f420987e;

    public static final class a {
    }

    static {
    }

    public FeedCardTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public FeedCardTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        setFirstViewMinWidth(b.g(getContext(), 36));
        this.f420984b = new wdb.a(getContext());
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 16;
        wdb.a r103 = this.f420984b;
        vdb.a r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r103 = null;
    L5:
        addView(r103.c(), 0, r102);
        this.f420985c = new SpecialFocusComponent(getContext());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(b.g(getContext(), 18), b.g(getContext(), 18));
        r105.leftMargin = UIHelper.dp2px(4.0f);
        r105.gravity = 16;
        SpecialFocusComponent r106 = this.f420985c;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specialFocusComponent");
        r106 = null;
    L8:
        addView(r106.c(), r105);
        this.f420986d = new udb.a(getContext());
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.leftMargin = UIHelper.dp2px(8.0f);
        r107.gravity = 16;
        udb.a r108 = this.f420986d;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("customStatusComponent");
        r108 = null;
    L11:
        addView(r108.c(), r107);
        this.f420987e = new vdb.a(getContext());
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.leftMargin = UIHelper.dp2px(4.0f);
        r109.gravity = 16;
        vdb.a r110 = this.f420987e;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("feedTagComponent");
    L15:
        addView(r104.c(), r109);
        return;
    L14:
        r104 = r110;
        goto L15
    }
}
