package com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorViewModel;
import com.bytedance.awemeopen.apps.framework.comment.util.d;
import com.bytedance.awemeopen.apps.framework.utils.t;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ry3.b;
import x54.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010$R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/DiggNewView2;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BaseDiggBuryFrameLayout;", "", "d", "Z", "isAnimating", "()Z", "setAnimating", "(Z)V", "Landroid/widget/TextView;", "<set-?>", "e", "Landroid/widget/TextView;", "getMCountView", "()Landroid/widget/TextView;", "mCountView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "getMDiggView", "()Landroid/widget/ImageView;", "setMDiggView", "(Landroid/widget/ImageView;)V", "mDiggView", "", "getRootViewId", "()I", "rootViewId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiggNewView2 extends BaseDiggBuryFrameLayout {
    public static final /* synthetic */ int g = 0;
    public boolean d;
    public TextView e;
    public ImageView f;

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public int getRootViewId() {
        return 2131558761;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public final void a() {
        super.a();
        this.f = (ImageView) findViewById(2131369096);
        this.e = (TextView) findViewById(2131369093);
        LinearLayout r0 = (LinearLayout) findViewById(2131369092);
        int r1 = a.a(18);
        ImageView r2 = this.f;
        ViewGroup.LayoutParams r3 = null;
        if (r2 == null) goto L5;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
    L6:
        if (r4 == null) goto L9;
        r4.width = r1;
    L9:
        ImageView r5 = this.f;
        if (r5 == null) goto L12;
        r3 = r5.getLayoutParams();
    L12:
        if (r3 == null) goto L15;
        r3.height = r1;
    L15:
        ImageView r6 = this.f;
        if (r6 == null) goto L18;
        r6.setImageDrawable(com.bytedance.awemeopen.apps.framework.comment.view.a.b(false, getColorMode(), getContext()));
    L18:
        TextView r7 = this.e;
        if (r7 == null) goto L29;
        Context r8 = getContext();
        CommentColorViewModel.a r9 = CommentColorViewModel.Companion;
        CommentColorMode r10 = getColorMode();
        r9.getClass();
        if (CommentColorViewModel.a.b(r10) == false) goto L24;
        int r11 = 2131100053;
    L27:
        r7.setTextColor(ContextCompat.getColor(r8, r11));
        return;
    L24:
        if (CommentColorViewModel.a.a(getColorMode()) == false) goto L26;
        r11 = 2131099799;
        goto L27
    L26:
        r11 = 2131100048;
        goto L27
    L29:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final TextView getMCountView() {
        return this.e;
    }

    public final ImageView getMDiggView() {
        return this.f;
    }

    public DiggNewView2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setAnimating(boolean r1) {
        this.d = r1;
    }

    public final void setMDiggView(ImageView r1) {
        this.f = r1;
    }

    public DiggNewView2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public DiggNewView2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
    }

    public final void b(boolean r10, boolean r11, long r12) {
        if (this.f == null) goto L58;
        TextView r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.d == true) goto L25;
        int r1 = d.a;
        Long r2 = Long.valueOf(r12);
        int r3 = com.bytedance.awemeopen.apps.framework.comment.util.a.a;
        if (r2 == null) goto L13;
        r2.longValue();
        String r4 = t.a(r2.longValue());
        if (r4 == null) goto L13;
    L14:
        String r5 = r4;
        if (StringsKt.contains$default(r5, "w", false, 2, null) == false) goto L17;
        r5 = StringsKt.replace$default(r5, "w", "万", false, 4, null);
    L17:
        r0.setText(r5);
        TextView r6 = this.e;
        if (r6 == null) goto L25;
        if (r12 > 0) goto L23;
        int r13 = 8;
    L24:
        r6.setVisibility(r13);
        goto L25
    L23:
        r13 = 0;
    L13:
        r4 = "0";
    L25:
        Context r14 = getContext();
        ImageView r15 = this.f;
        if (r15 == null) goto L30;
        r15.setSelected(r10);
    L30:
        if (this.c == r10) goto L48;
        ImageView r16 = this.f;
        if (r16 == null) goto L34;
        r16.setImageDrawable(com.bytedance.awemeopen.apps.framework.comment.view.a.b(r10, getColorMode(), r14));
    L34:
        if (r10 == false) goto L38;
        TextView r17 = this.e;
        if (r17 == null) goto L48;
        r17.setTextColor(ContextCompat.getColor(r14, 2131099677));
        goto L48
    L38:
        TextView r18 = this.e;
        if (r18 == null) goto L48;
        CommentColorViewModel.a r7 = CommentColorViewModel.Companion;
        CommentColorMode r8 = getColorMode();
        r7.getClass();
        if (CommentColorViewModel.a.b(r8) == false) goto L44;
        int r9 = 2131100053;
    L47:
        r18.setTextColor(ContextCompat.getColor(r14, r9));
        goto L48
    L44:
        if (CommentColorViewModel.a.a(getColorMode()) == false) goto L46;
        r9 = 2131099799;
        goto L47
    L46:
        r9 = 2131100048;
    L48:
        ImageView r19 = this.f;
        if (r19 == null) goto L52;
        r19.setVisibility(0);
    L52:
        if (r11 == false) goto L56;
        final ImageView r110 = this.f;
        if (r110 == null) goto L56;
        r110.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new b(r110)).start();
    L56:
        setActive(r10);
        return;
    }
}
