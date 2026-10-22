package com.larus.bmhome.chat.standarduikit.interaction.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.mainbot.impl.databinding.LarusInteractionQuickReplyViewBinding;
import com.larus.nova.R;
import com.larus.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0002'(B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J-\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001fJ8\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput;", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusInteractionQuickReplyViewBinding;", "exposeFired", "", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "bindContent", "bindEnvironmentIcon", "bindButtons", "buttons", "", "Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput$Button;", "loadingIndex", "(Ljava/util/List;Ljava/lang/Integer;Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewOutput;)V", "createButton", "Landroid/view/View;", "button", "isLoading", "otherLoading", "horizontal", "index", "Companion", "ButtonViews", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionQuickReplyView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309300c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusInteractionQuickReplyViewBinding f309301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f309302b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FrameLayout f309303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f309304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FrameLayout f309305c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f309303a, r101.f309303a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309304b, r101.f309304b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f309305c, r101.f309305c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f309303a.hashCode() * 31) + this.f309304b.hashCode()) * 31) + this.f309305c.hashCode();
        }

        public final String toString() {
            return "ButtonViews(root=" + this.f309303a + ", label=" + this.f309304b + ", loadingContainer=" + this.f309305c + ')';
        }

        public a(FrameLayout r100, TextView r101, FrameLayout r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "label");
            Intrinsics.checkNotNullParameter(r102, "loadingContainer");
            this.f309303a = r100;
            this.f309304b = r101;
            this.f309305c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f309302b = false;
    }

    public InteractionQuickReplyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public InteractionQuickReplyView(Context r210, AttributeSet r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211);
        View r100 = LayoutInflater.from(r210).inflate(R.layout.larus_interaction_quick_reply_view, this, false);
        addView(r100);
        int r101 = R.id.button_divider;
        View r102 = ViewBindings.findChildViewById(r100, R.id.button_divider);
        if (r102 == null) goto L39;
        r101 = R.id.button_group;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.button_group);
        if (r103 == null) goto L39;
        r101 = R.id.card;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.card)) == null) goto L39;
        r101 = R.id.content_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.content_container);
        if (r104 == null) goto L39;
        r101 = R.id.content_scroll;
        ScrollView r105 = (ScrollView) ViewBindings.findChildViewById(r100, R.id.content_scroll);
        if (r105 == null) goto L39;
        r101 = R.id.description_view;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.description_view);
        if (r106 == null) goto L39;
        r101 = R.id.environment_icon;
        SimpleDraweeView r110 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.environment_icon);
        if (r110 == null) goto L39;
        r101 = R.id.environment_icon_container;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.environment_icon_container);
        if (r111 == null) goto L39;
        r101 = R.id.environment_label;
        AppCompatTextView r112 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.environment_label);
        if (r112 == null) goto L39;
        r101 = R.id.environment_row;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.environment_row);
        if (r113 == null) goto L39;
        r101 = R.id.environment_text_gap;
        Space r114 = (Space) ViewBindings.findChildViewById(r100, R.id.environment_text_gap);
        if (r114 == null) goto L39;
        r101 = R.id.folder_gap;
        Space r115 = (Space) ViewBindings.findChildViewById(r100, R.id.folder_gap);
        if (r115 == null) goto L39;
        r101 = R.id.folder_name;
        AppCompatTextView r116 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.folder_name);
        if (r116 == null) goto L39;
        r101 = R.id.folder_row;
        LinearLayout r117 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.folder_row);
        if (r117 == null) goto L39;
        r101 = R.id.scroll_content_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.scroll_content_container)) == null) goto L39;
        ShadowLayout r107 = (ShadowLayout) r100;
        r101 = R.id.title_description_gap;
        Space r118 = (Space) ViewBindings.findChildViewById(r100, R.id.title_description_gap);
        if (r118 == null) goto L39;
        r101 = R.id.title_view;
        AppCompatTextView r119 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.title_view);
        if (r119 == null) goto L39;
        this.f309301a = new LarusInteractionQuickReplyViewBinding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = MathKt.roundToInt(i.c(getContext()) * 0.6f);
        if (r102 == 0) goto L6;
        r104 = Math.min(r104, r103);
    L6:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r104, Integer.MIN_VALUE));
    }
}
