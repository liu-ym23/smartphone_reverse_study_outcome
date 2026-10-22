package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewHeaderView extends RelativeLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f416132g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f416133h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f416134i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f416135j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f416136k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TailDrawableTextView f416137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f416138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f416139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f416140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f416141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f416142f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/PreviewHeaderView$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ONELINE", "NEXLINE", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type NEXLINE = null;
        public static final Type ONELINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f416143a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416144b = null;

        public static EnumEntries<Type> getEntries() {
            return f416144b;
        }

        static {
            Type r100 = new Type("ONELINE", 0);
            ONELINE = r100;
            Type r101 = new Type("NEXLINE", 1);
            NEXLINE = r101;
            Type[] r102 = {r100, r101};
            f416143a = r102;
            f416144b = EnumEntriesKt.enumEntries(r102);
        }

        public static Type[] values() {
            return (Type[]) f416143a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
        UIHelper.dp2px(12.0f);
        f416132g = UIHelper.dp2px(12.0f);
        UIHelper.dp2px(12.0f);
        f416133h = UIHelper.dp2px(78.0f);
        UIHelper.dp2px(12.0f);
        UIHelper.dp2px(12.0f);
        UIHelper.dp2px(150.0f);
        f416134i = UIHelper.dp2px(8.0f);
        f416135j = UIHelper.dp2px(8.0f);
        f416136k = 3;
    }

    public final void a() {
        ImageView r100 = this.f416140d;
        TailDrawableTextView r101 = null;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r100 = null;
    L6:
        r100.setTranslationY(0.0f);
    L7:
        TailDrawableTextView r102 = this.f416137a;
        if (r102 == null) goto L14;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
    L12:
        r101.setTranslationY(0.0f);
        return;
    L11:
        r101 = r102;
        goto L12
    }

    public final ImageView getCopyBtn() {
        Intrinsics.throwUninitializedPropertyAccessException("mCopyBtn");
        return null;
    }

    public final FrameLayout getCustomContainer() {
        FrameLayout r100 = this.f416138b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomContainer");
        return null;
    L6:
        return r100;
    }

    public final ImageView getMoreBtn() {
        ImageView r100 = this.f416139c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
        return null;
    L6:
        return r100;
    }

    public final ImageView getTitleIconView() {
        ImageView r100 = this.f416140d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        return null;
    L6:
        return r100;
    }

    public final TailDrawableTextView getTitleView() {
        TailDrawableTextView r100 = this.f416137a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        return null;
    L6:
        return r100;
    }

    public final Type getType() {
        return this.f416141e;
    }

    public PreviewHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(r100, R.layout.component_headerview_oneline, this);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        super.onLayout(r100, r101, r110, r111, r112);
        TailDrawableTextView r102 = this.f416137a;
        if (r102 != null) goto L5;
    L56:
        a();
        return;
    L5:
        if (this.f416140d == null) goto L56;
        if (this.f416142f == false) goto L56;
        Layout r103 = r102.getLayout();
        if (r103 == null) goto L55;
        TailDrawableTextView r104 = this.f416137a;
        TailDrawableTextView r113 = null;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r104 = null;
    L15:
        if (r104.getLineCount() == 0) goto L55;
        ImageView r105 = this.f416140d;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r105 = null;
    L20:
        if (r105.getHeight() == 0) goto L55;
        int r106 = r103.getLineBottom(0) - r103.getLineTop(0);
        int r107 = c.f416185a;
        TailDrawableTextView r108 = this.f416137a;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r108 = null;
    L25:
        int r109 = r108.getLineCount();
        TailDrawableTextView r114 = this.f416137a;
        if (r114 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r114 = null;
    L28:
        int r115 = r114.getTop();
        TailDrawableTextView r116 = this.f416137a;
        if (r116 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r116 = null;
    L31:
        int r117 = r116.getHeight();
        ImageView r118 = this.f416140d;
        if (r118 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r118 = null;
    L34:
        int r119 = r118.getTop();
        ImageView r120 = this.f416140d;
        if (r120 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r120 = null;
    L37:
        int r121 = r120.getHeight();
        if (r109 <= 1) goto L42;
        if (r121 <= r106) goto L41;
        c.a r122 = new c.a(r115 - r119, 0.0f);
    L47:
        ImageView r123 = this.f416140d;
        if (r123 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleIconIV");
        r123 = null;
    L50:
        r123.setTranslationY(r122.f416186a);
        TailDrawableTextView r124 = this.f416137a;
        if (r124 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
    L54:
        r113.setTranslationY(r122.f416187b);
        return;
    L53:
        r113 = r124;
        goto L54
    L41:
        c.a r125 = new c.a((r115 + (r106 / 2.0f)) - (r119 + (r121 / 2.0f)), 0.0f);
    L46:
        r122 = r125;
        goto L47
    L42:
        float r126 = r115 + (r117 / 2.0f);
        float r127 = r119 + (r121 / 2.0f);
        if (r121 < r117) goto L45;
        r125 = new c.a(0.0f, r127 - r126);
        goto L46
    L45:
        r125 = new c.a(r126 - r127, 0.0f);
    L55:
        a();
    }
}
