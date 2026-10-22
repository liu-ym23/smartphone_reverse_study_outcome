package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusChatInputReplyBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ7\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u001d\u001a\u00020\u0018J\r\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u001fJ\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0018H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/ChatInputReply;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/databinding/LarusChatInputReplyBinding;", "onClose", "Lkotlin/Function0;", "", "onItemClick", "Lkotlin/Function1;", "", "setImmerseMode", "setReplyData", "reply", "suggestList", "", "showPanel", "", "hintResId", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/Integer;)V", "setOnReplyCloseListener", "setOnItemClickListener", "hasReplySuggestData", "showReplySuggest", "()Lkotlin/Unit;", "hideReplySuggest", "updateReplyCloseVerticalMargin", "showSuggest", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputReply extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f315409d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusChatInputReplyBinding f315410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f315411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f315412c;

    public ChatInputReply(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatInputReply(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void S5(boolean r100) {
        Resources r101 = getResources();
        ViewGroup.MarginLayoutParams r102 = null;
        if (r100 == false) goto L5;
        int r103 = R.attr.larus_dp_12;
        int r104 = R.dimen.larus_dp_12;
    L6:
        int r105 = r101.getDimensionPixelSize(v19.c.b(r103, null, r104));
        LarusChatInputReplyBinding r106 = this.f315410a;
        if (r106 == null) goto L21;
        AppCompatImageView r107 = r106.f310790c;
        if (r107 == null) goto L22;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r102 = (ViewGroup.MarginLayoutParams) r108;
    L14:
        if (r102 != null) goto L17;
        return;
    L17:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        ((ConstraintLayout.LayoutParams) r102).goneTopMargin = r105;
    L19:
        r102.topMargin = r105;
        r102.bottomMargin = r105;
        r107.setLayoutParams(r102);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r103 = R.attr.larus_dp_6;
        r104 = R.dimen.larus_dp_6;
        goto L6
    }

    public final void setOnItemClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        this.f315412c = r100;
    }

    public final void setOnReplyCloseListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onClose");
        this.f315411b = r100;
    }

    public ChatInputReply(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f315411b = new v();
        this.f315412c = new w();
        LayoutInflater.from(r100).inflate(R.layout.larus_chat_input_reply, this);
        int r102 = R.id.divider;
        View r103 = ViewBindings.findChildViewById(this, R.id.divider);
        if (r103 == null) goto L15;
        r102 = R.id.reply_close;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.reply_close);
        if (r104 == null) goto L15;
        r102 = R.id.reply_hint;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.reply_hint);
        if (r105 == null) goto L15;
        r102 = R.id.reply_list;
        ReplySuggestList r106 = (ReplySuggestList) ViewBindings.findChildViewById(this, R.id.reply_list);
        if (r106 == null) goto L15;
        r102 = R.id.reply_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.reply_text);
        if (r107 == null) goto L15;
        this.f315410a = new LarusChatInputReplyBinding(this, r103, r104, r105, r106, r107);
        setOnClickListener(new x());
        S5(false);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ ChatInputReply(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void R5(String r100, List<String> r101, boolean r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "reply");
        Intrinsics.checkNotNullParameter(r101, "suggestList");
        LarusChatInputReplyBinding r104 = this.f315410a;
        if (r104 == null) goto L22;
        FLogger.f375446a.i("ChatInputReply", "[setReplyData] reply:" + r100);
        r104.f310793f.setText(r100);
        if (r103 != null) goto L7;
    L10:
        r104.f310791d.setImageResource(R.drawable.larus_ic_reply_rect);
    L11:
        boolean r105 = true;
        int r106 = 0;
        if ((!r101.isEmpty()) == false) goto L15;
        if (r102 == false) goto L15;
    L16:
        ReplySuggestList r107 = r104.f310792e;
        if (r105 == true) goto L20;
        r106 = 8;
    L20:
        r107.setVisibility(r106);
        S5(r105);
        r104.f310790c.setOnClickListener(new y(this));
        r104.f310792e.setSuggestList(r101);
        r104.f310792e.setItemClickListener(new z(this));
        return;
    L15:
        r105 = false;
        goto L16
    L7:
        if (r103.intValue() == 0) goto L10;
        r104.f310791d.setImageResource(r103.intValue());
        goto L11
    }
}
