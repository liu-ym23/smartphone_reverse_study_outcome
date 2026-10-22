package com.larus.bmhome.taskskill.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u001cH\u0002J\u0014\u0010!\u001a\u00020\u0010*\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0002R7\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/taskskill/view/PcConnectionStatusView;", "Lcom/larus/bmhome/taskskill/view/ShimmerTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onActionClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/view/PcConnectionStatusAction;", "Lkotlin/ParameterName;", "name", "action", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "setOnActionClick", "(Lkotlin/jvm/functions/Function1;)V", "iconSpan", "Lcom/larus/bmhome/taskskill/view/InlineIconSpan;", "currentAction", ChameleonOpenTracker.Stage.RENDER, "uiModel", "Lcom/larus/bmhome/taskskill/view/PcConnectionStatusUiModel;", "buildContent", "", "createIconSpan", "createActionSpan", "Landroid/text/style/ClickableSpan;", "capDeviceName", "appendSpacer", "Landroid/text/SpannableStringBuilder;", "widthPx", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcConnectionStatusView extends ShimmerTextView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super PcConnectionStatusAction, Unit> f314607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.taskskill.view.a f314608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PcConnectionStatusAction f314609q;

    public static final class a {
    }

    static {
    }

    public PcConnectionStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PcConnectionStatusView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function1<PcConnectionStatusAction, Unit> getOnActionClick() {
        return this.f314607o;
    }

    public final void D(p r110) {
        Intrinsics.checkNotNullParameter(r110, "uiModel");
        boolean r100 = false;
        if (r110.f314646f == false) goto L5;
        int r101 = 0;
    L6:
        setVisibility(r101);
        this.f314609q = r110.f314644d;
        CharSequence r102 = null;
        if (r110.f314646f == true) goto L11;
        setText(null);
        this.f314608p = null;
        B();
        return;
    L11:
        if (r110.f314647g == false) goto L13;
        CharSequence r103 = r110.f314642b;
    L58:
        setText(r103);
        if (r110.f314645e == false) goto L61;
        A();
        return;
    L61:
        B();
        return;
    L13:
        CharSequence r104 = r110.f314641a;
        if (r104.length() != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L20;
    L23:
        SpannableStringBuilder r106 = new SpannableStringBuilder();
        Drawable r107 = AppCompatResources.getDrawable(getContext(), R.drawable.larus_ic_localpc_dark);
        if (r107 == null) goto L28;
        Drawable r108 = r107.mutate();
        if (r108 == null) goto L28;
        com.larus.bmhome.taskskill.view.a r109 = new com.larus.bmhome.taskskill.view.a(r108, i5.m());
    L30:
        if (r109 == null) goto L32;
        this.f314608p = r109;
        int r111 = r106.length();
        r106.append("\u200b");
        r106.setSpan(r109, r111, r106.length(), 17);
        boolean r112 = true;
    L34:
        if (r104.length() <= 0) goto L36;
        boolean r113 = true;
    L37:
        if (r113 == false) goto L41;
        if (r112 == false) goto L40;
        C(r106, i5.Y());
    L40:
        r106.append(r104);
        r112 = true;
    L41:
        if (r112 == false) goto L43;
        C(r106, i5.Y());
    L43:
        r106.append(r110.f314642b);
        CharSequence r114 = r110.f314643c;
        if (r114 != null) goto L46;
    L57:
        r103 = new SpannedString(r106);
        goto L58
    L46:
        if (r114.length() <= 0) goto L48;
        boolean r115 = true;
    L49:
        if (r115 == true) goto L51;
    L53:
        if (r100 == false) goto L55;
        r102 = r114;
    L55:
        if (r102 == null) goto L57;
        C(r106, i5.Y());
        r r116 = new r(this);
        int r117 = r106.length();
        r106.append(r102);
        r106.setSpan(r116, r117, r106.length(), 17);
        goto L57
    L51:
        if (r110.f314644d == null) goto L53;
        r100 = true;
        goto L53
    L48:
        r115 = false;
        goto L49
    L36:
        r113 = false;
        goto L37
    L32:
        this.f314608p = null;
        r112 = false;
    L28:
        r109 = null;
        goto L30
    L20:
        if (Character.codePointCount(r104, 0, r104.length()) <= 12) goto L23;
        int r118 = Character.offsetByCodePoints(r104, 0, 12);
        SpannableStringBuilder r119 = new SpannableStringBuilder();
        r119.append(r104.subSequence(0, r118));
        r119.append("…");
        r104 = new SpannedString(r119);
        goto L23
    L16:
        r105 = false;
        goto L17
    L5:
        r101 = 8;
        goto L6
    }

    public final void setOnActionClick(Function1<? super PcConnectionStatusAction, Unit> r100) {
        this.f314607o = r100;
    }

    public static void C(SpannableStringBuilder r100, int r101) {
        x r102 = new x(r101);
        int r103 = r100.length();
        r100.append("\u200b");
        r100.setSpan(r102, r103, r100.length(), 17);
    }

    public PcConnectionStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setMovementMethod(LinkMovementMethod.getInstance());
        setIconShimmerProgressListener(new q(this));
    }

    public /* synthetic */ PcConnectionStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
