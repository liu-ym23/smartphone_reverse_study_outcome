package com.larus.bmhome.chat.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.list.cell.text.components.bottom.riskwarning.TipsBlockType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TipsBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusRiskTipsTextViewBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import po8.r;
import po8.s;
import po8.t;
import po8.w;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ2\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J,\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/view/RiskTipsTextView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bottomPadding", "binding", "Lcom/larus/mainbot/impl/databinding/LarusRiskTipsTextViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusRiskTipsTextViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "message", "Lcom/larus/im/bean/message/Message;", "block", "Lcom/larus/im/bean/message/block/Block;", "isLastBlockModel", "", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "setupRiskView", "data", "Lcom/larus/im/bean/message/block/TipsBlock;", "setWarningUrl", "view", "Landroid/widget/TextView;", "textOfUrl", "url", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RiskTipsTextView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f310378c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f310379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f310380b;

    public RiskTipsTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RiskTipsTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusRiskTipsTextViewBinding getBinding() {
        return (LarusRiskTipsTextViewBinding) this.f310380b.getValue();
    }

    public RiskTipsTextView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f310379a = getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        this.f310380b = LazyKt.lazy(new r(r100, this));
    }

    public /* synthetic */ RiskTipsTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(final Message r100, Block r101, boolean r102, final z r110) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        BlockContent r103 = r101.getContent();
        if (r103 == null) goto L60;
        TipsBlock r104 = r103.getTipsBlock();
        if (r104 == null) goto L63;
        LarusRiskTipsTextViewBinding r105 = getBinding();
        e1.o(r105.f358822a);
        e1.o(r105.f358823b);
        r105.f358822a.setOnLongClickListener(new s(r110));
        boolean r106 = true;
        if (d.Q0(r100) == true) goto L14;
        if (d.I0(r100) == true) goto L14;
        if (r100.getMessageStatusLocal() == 20) goto L14;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L58;
        String r108 = r100.getMessageId();
        if (r108 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == true) goto L58;
        String r111 = r104.text;
        if (r111 == null) goto L33;
        String r112 = StringsKt.trimStart(r111, new char[]{'\n'});
    L34:
        e1.x(r105.f358822a);
        TextView r113 = r105.f358823b;
        int r114 = r104.type;
        if (r114 != TipsBlockType.TIPS_BLOCK_TYPE_TEXT.getValue()) goto L38;
        r113.setText(r112);
        r113.setTextSize(0, r113.getResources().getDimensionPixelSize(c.b(R.attr.larus_sp_15, null, R.dimen.larus_sp_15)));
        r113.setTextColor(ContextCompat.getColor(r113.getContext(), c.b(R.attr.larus_neutral_50, r113.getContext(), R.color.larus_neutral_50)));
        Intrinsics.checkNotNull(r113);
        e1.x(r113);
    L56:
        if (r102 == false) goto L61;
        r113.setPaddingRelative(r113.getPaddingStart(), r113.getPaddingTop(), r113.getPaddingEnd(), this.f310379a);
        return;
    L61:
        return;
    L38:
        if (r114 != TipsBlockType.TIPS_BLOCK_TYPE_URL.getValue()) goto L56;
        Intrinsics.checkNotNull(r113);
        final String r115 = r104.url;
        if (r112 != null) goto L42;
    L45:
        boolean r116 = true;
    L46:
        if (r116 == true) goto L55;
        if (r115 != null) goto L49;
    L52:
        if (r106 == true) goto L55;
        SpannableString r117 = new SpannableString(r112);
        r117.setSpan(new w(r115, this), 0, r112.length(), 33);
        r113.setText(r117);
        r113.setTextSize(0, r113.getResources().getDimensionPixelSize(c.b(R.attr.larus_sp_17, null, R.dimen.larus_sp_17)));
        r113.setMovementMethod(LinkMovementMethod.getInstance());
        ExposeXTrackerExtKt.b(r113, new t(r100, r115));
        goto L55
    L49:
        if (r115.length() == 0) goto L52;
        r106 = false;
    L55:
        e1.x(r113);
        goto L56
    L42:
        if (r112.length() == 0) goto L45;
        r116 = false;
        goto L46
    L33:
        r112 = null;
        goto L34
    L24:
        if (r108.length() == 0) goto L27;
        r109 = false;
    L58:
        e1.o(r105.f358822a);
        return;
    L14:
        if (r100.getMessageStatusLocal() == 23) goto L19;
        if (r101.isFinish() == true) goto L19;
        r107 = false;
        goto L20
    L63:
        return;
    }
}
