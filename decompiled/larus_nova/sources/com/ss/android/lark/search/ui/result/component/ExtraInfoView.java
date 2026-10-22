package com.ss.android.lark.search.ui.result.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u0003123B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\nJ0\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020!2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\b\b\u0002\u0010,\u001a\u00020!H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/search/ui/result/component/ExtraInfoView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "priority", "leftExtraTv", "Landroid/widget/TextView;", "midSeparatorTv", "rightExtraTv", "hasMeasure", "", "fgUtils", "Lcom/ss/android/lark/search/ui/result/fg/FgUtils;", "troubleReporter", "Lcom/ss/android/lark/search/ui/result/monitor/SearchTroubleReporter;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "getExpectMeasuredWidth", "view", "Landroid/view/View;", "parseLong", "", "text", "", "setExtraInfoSummary", "extraInfoSummary", "Lcom/ss/android/lark/search/dto/info/ExtraInfoSummary;", "type", "setTextExtraInfo", "textView", "contentWithoutTag", "tagContentList", "", "Lcom/ss/android/lark/search/dto/info/TagContent;", "iconKey", "getUdIconDrawable", "Landroid/graphics/drawable/Drawable;", "parsePriority", "resetView", "Priority", "Companion", "ExtraInfo", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraInfoView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f440297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EllipsizedEmojiconTextView f440298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EllipsizedEmojiconTextView f440299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EllipsizedEmojiconTextView f440300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f440301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g4c.a f440302f;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/search/ui/result/component/ExtraInfoView$ExtraInfo;", "Ljava/io/Serializable;", "contentWithoutTag", "", "tagContentList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/TagContent;", "Lkotlin/collections/ArrayList;", "iconKey", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getContentWithoutTag", "()Ljava/lang/String;", "getTagContentList", "()Ljava/util/ArrayList;", "getIconKey", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExtraInfo implements Serializable {
        private final String contentWithoutTag;
        private final String iconKey;
        private final ArrayList<TagContent> tagContentList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExtraInfo copy$default(ExtraInfo r100, String r101, ArrayList r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.contentWithoutTag;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.tagContentList;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.iconKey;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.contentWithoutTag;
        }

        public final ArrayList<TagContent> component2() {
            return this.tagContentList;
        }

        public final String component3() {
            return this.iconKey;
        }

        public final ExtraInfo copy(String r100, ArrayList<TagContent> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "contentWithoutTag");
            Intrinsics.checkNotNullParameter(r101, "tagContentList");
            Intrinsics.checkNotNullParameter(r102, "iconKey");
            return new ExtraInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExtraInfo) == true) goto L8;
            return false;
        L8:
            ExtraInfo r101 = (ExtraInfo) r100;
            if (Intrinsics.areEqual(this.contentWithoutTag, r101.contentWithoutTag) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tagContentList, r101.tagContentList) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconKey, r101.iconKey) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.contentWithoutTag.hashCode() * 31) + this.tagContentList.hashCode()) * 31) + this.iconKey.hashCode();
        }

        public String toString() {
            return "ExtraInfo(contentWithoutTag=" + this.contentWithoutTag + ", tagContentList=" + this.tagContentList + ", iconKey=" + this.iconKey + ')';
        }

        public final String getContentWithoutTag() {
            return this.contentWithoutTag;
        }

        public final String getIconKey() {
            return this.iconKey;
        }

        public final ArrayList<TagContent> getTagContentList() {
            return this.tagContentList;
        }

        public ExtraInfo(String r100, ArrayList<TagContent> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "contentWithoutTag");
            Intrinsics.checkNotNullParameter(r101, "tagContentList");
            Intrinsics.checkNotNullParameter(r102, "iconKey");
            this.contentWithoutTag = r100;
            this.tagContentList = r101;
            this.iconKey = r102;
        }

        public /* synthetic */ ExtraInfo(String r100, ArrayList r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = "";
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/component/ExtraInfoView$Priority;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Priority {
        public static final a Companion = null;
        public static final int LEFT_PRIORITY = 1;
        public static final int RIGHT_PRIORITY = 2;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440303a = null;

            static {
                f440303a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440303a;
        }
    }

    public static final class a {
    }

    static {
    }

    public ExtraInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static int a(EllipsizedEmojiconTextView r100) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredWidth();
    }

    public ExtraInfoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        if (this.f440301e == true) goto L17;
        this.f440301e = true;
        int r101 = View.MeasureSpec.getSize(r100);
        int r102 = a(this.f440298b);
        int r103 = a(this.f440299c);
        int r104 = a(this.f440300d);
        int r105 = r101 - r103;
        float r106 = r105;
        float r107 = 0.4f * r106;
        if (((r103 + r102) + r104) <= r101) goto L17;
        int r108 = this.f440297a;
        if (r108 != 2) goto L12;
        int r109 = r105 - r104;
        if (r109 < r107) goto L11;
        this.f440298b.setMaxWidth(r109);
        this.f440300d.setMaxWidth(r104);
        goto L17
    L11:
        this.f440298b.setMaxWidth((int) r107);
        this.f440300d.setMaxWidth((int) (r106 - r107));
        goto L17
    L12:
        if (r108 != 1) goto L17;
        int r111 = r105 - r102;
        if (r111 < r107) goto L16;
        this.f440298b.setMaxWidth(r102);
        this.f440300d.setMaxWidth(r111);
        goto L17
    L16:
        this.f440298b.setMaxWidth((int) (r106 - r107));
        this.f440300d.setMaxWidth((int) r107);
    L17:
        super.onMeasure(r100, r110);
    }

    public ExtraInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f440297a = 1;
        this.f440302f = new g4c.a();
        new h4c.a();
        setOrientation(0);
        EllipsizedEmojiconTextView r103 = new EllipsizedEmojiconTextView(getContext());
        r103.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r103.setIncludeFontPadding(false);
        r103.setGravity(16);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setMaxLines(1);
        r103.setSingleLine(true);
        r103.setTextSize(2, 14.0f);
        r103.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        addView(r103);
        this.f440298b = r103;
        EllipsizedEmojiconTextView r104 = new EllipsizedEmojiconTextView(getContext());
        r104.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r104.setIncludeFontPadding(false);
        r104.setGravity(16);
        r104.setMaxLines(1);
        r104.setSingleLine(true);
        r104.setTextSize(2, 12.0f);
        r104.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        addView(r104);
        this.f440299c = r104;
        EllipsizedEmojiconTextView r105 = new EllipsizedEmojiconTextView(getContext());
        r105.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r105.setIncludeFontPadding(false);
        r105.setGravity(16);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r105.setMaxLines(1);
        r105.setSingleLine(true);
        r105.setTextSize(2, 14.0f);
        r105.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
        addView(r105);
        this.f440300d = r105;
    }

    public final void b(EllipsizedEmojiconTextView r100, String r101, List r102, String r103) {
        String r104 = r103.toLowerCase();
        switch(r104.hashCode()) {
            case -267437798: goto L18;
            case 3108362: goto L14;
            case 3649456: goto L10;
            case 466743410: goto L6;
            default: goto L21;
        };
    L21:
        int r105 = -1;
    L23:
        if (r105 <= 0) goto L25;
        Drawable r106 = UDIconUtils.getIconDrawable(getContext(), r105, getResources().getColor(R.color.text_placeholder), new UDDimension.Dp(14.0f));
    L26:
        SpannableStringBuilder r107 = new SpannableStringBuilder(r101);
        if (CollectionUtils.isEmpty(r102) == false) goto L29;
        r100.setText(r107);
        r100.setCompoundDrawablePadding(UIHelper.dp2px(4.0f));
        r100.setCompoundDrawables(r106, null, null, null);
        return;
    L29:
        j4c.a.a(r107, r100, r102, getContext().getResources().getColor(R.color.lkui_B500));
        r100.setText(r107);
        r100.setCompoundDrawablePadding(UIHelper.dp2px(4.0f));
        r100.setCompoundDrawables(r106, null, null, null);
        return;
    L25:
        r106 = null;
        goto L26
    L6:
        if (r104.equals("visible") == false) goto L21;
        r105 = R.drawable.ud_icon_visible_outlined;
        goto L23
    L10:
        if (r104.equals("wiki") == false) goto L21;
        r105 = R.drawable.ud_icon_wiki_outlined;
        goto L23
    L14:
        if (r104.equals("edit") == false) goto L21;
        r105 = R.drawable.ud_icon_edit_outlined;
        goto L23
    L18:
        if (r104.equals("myfolder") == false) goto L21;
        r105 = R.drawable.ud_icon_myfolder_outlined;
        goto L23
    }
}
