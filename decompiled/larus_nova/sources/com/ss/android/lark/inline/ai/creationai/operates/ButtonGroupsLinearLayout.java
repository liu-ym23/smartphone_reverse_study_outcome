package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.n0;
import com.ss.android.lark.language.service.impl.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bJ\f\u0010\u001d\u001a\u00020\u0007*\u00020\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsLinearLayout$OnOperateClickListener;", "menuItems", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "isFirstSetData", "", "setData", "", "data", "updateButtons", "createButton", "Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "menuItem", "index", "buildReactionText", "", "setOnOperateClickListener", "listener", "dp", "Companion", "OnOperateClickListener", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonGroupsLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f427185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<MenuItem> f427186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f427187c;

    public static final class a {
    }

    public interface b {
        void a(MenuItem r100);
    }

    static {
    }

    public ButtonGroupsLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ButtonGroupsLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.widget.LinearLayout, com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsLinearLayout] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.widget.Button, com.ss.android.lark.inline.ai.creationai.operates.MenuButton] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    public final void setData(List<MenuItem> r110) {
        if (r110 != null) goto L5;
        r110 = CollectionsKt.emptyList();
    L5:
        if (this.f427187c == false) goto L7;
    L9:
        this.f427186b = CollectionsKt.toList(r110);
        removeAllViews();
        int r100 = 0;
        if (this.f427186b.isEmpty() == true) goto L45;
        Iterator r111 = this.f427186b.iterator();
        int r101 = 0;
    L14:
        if (r111.hasNext() == false) goto L45;
        Object r102 = r111.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        MenuItem r104 = (MenuItem) r102;
        Drawable r105 = null;
        ?? r106 = new MenuButton(getContext(), 0 == true ? 1 : 0, 6, r100);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(0, -2, 1.0f / this.f427186b.size());
        if (r101 >= (this.f427186b.size() - 1)) goto L21;
        r107.setMarginEnd(a(8));
    L21:
        r107.gravity = 17;
        r106.setLayoutParams(r107);
        r106.setPadding(a(16), a(7), a(16), a(7));
        r106.setTextSize(16.0f);
        r106.setType(r104.getType());
        if (Intrinsics.areEqual(r104.getType(), INotificationHitPoint.NoticeType.REACTION) == false) goto L43;
        Context r108 = getContext();
        if (r108 == null) goto L36;
        e.a().getClass();
        Locale r109 = c.a.f431101a.a();
        String r112 = r104.getIcon();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        Intrinsics.checkNotNullParameter(r109, "locale");
        Intrinsics.checkNotNullParameter(r112, "reactionKey");
        if (Intrinsics.areEqual(r109.getLanguage(), "zh") == false) goto L28;
        Drawable r113 = UIUtils.getDrawable(r108, R.drawable.emoji_ai_answer_apply_cn);
    L30:
        if (Intrinsics.areEqual(r109.getLanguage(), "zh") == false) goto L33;
        if (r113 == null) goto L35;
        r113.setBounds(new Rect(0, 0, n0.a(86), n0.a(25)));
    L35:
        r105 = r113;
        goto L36
    L33:
        if (r113 == null) goto L35;
        r113.setBounds(new Rect(0, 0, n0.a(113), n0.a(25)));
        goto L35
    L28:
        r113 = UIUtils.getDrawable(r108, R.drawable.emoji_ai_answer_apply_en);
    L36:
        if (r105 != null) goto L39;
        Log.e("ButtonGroupsLinearLayout", "set ai apply drawable failed");
        ?? r114 = r104.getIcon();
    L44:
        r106.setText(r114);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        r106.setEnabled(!r104.getDisabled());
        r106.setTag(r104);
        r106.setOnClickListener(new com.ss.android.lark.inline.ai.creationai.operates.a(this, r104));
        addView(r106);
        r101 = r103;
        goto L14
    L39:
        if (r104.getDisabled() == false) goto L41;
        r105.setAlpha(127);
    L42:
        r114 = new SpannableStringBuilder();
        r114.append(" ");
        r114.setSpan(new xlb.a(r105), 0, 1, 33);
        goto L44
    L41:
        r105.setAlpha(255);
        goto L42
    L43:
        r114 = r104.getText();
    L45:
        this.f427187c = false;
        return;
    L7:
        if (Intrinsics.areEqual(r110, this.f427186b) == false) goto L9;
    }

    public final void setOnOperateClickListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f427185a = r100;
    }

    public ButtonGroupsLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f427186b = CollectionsKt.emptyList();
        this.f427187c = true;
        setOrientation(0);
    }

    public /* synthetic */ ButtonGroupsLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
