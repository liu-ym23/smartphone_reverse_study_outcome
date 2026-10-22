package com.obric.assistant.block.common.reference_msg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricLayoutChatReplyHeaderBinding;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve8.d;
import yba.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J3\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0002\u0010\u001dR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/block/common/reference_msg/view/ObricChatReplyHeaderView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricLayoutChatReplyHeaderBinding;", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "arrowDrawable$delegate", "Lkotlin/Lazy;", "setImmerseMode", "getClickView", "Landroid/view/View;", "show", "", "text", "", "isImmerse", "", "isSelf", "showArrow", "(Ljava/lang/String;Ljava/lang/Boolean;ZZ)V", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatReplyHeaderView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f385930c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricLayoutChatReplyHeaderBinding f385931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f385932b;

    public ObricChatReplyHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ObricChatReplyHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getArrowDrawable() {
        return (Drawable) this.f385932b.getValue();
    }

    public final View getClickView() {
        ObricLayoutChatReplyHeaderBinding r100 = this.f385931a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f386254c;
    }

    public ObricChatReplyHeaderView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        LayoutInflater.from(r100).inflate(R.layout.obric_layout_chat_reply_header, this);
        int r103 = R.id.reply_hint;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.reply_hint);
        if (r104 == null) goto L9;
        r103 = R.id.reply_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.reply_text);
        if (r105 == null) goto L9;
        this.f385931a = new ObricLayoutChatReplyHeaderBinding(this, r104, r105);
        this.f385932b = LazyKt.lazy(new a(r100));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ ObricChatReplyHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(String r100, Boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.areEqual(r101, Boolean.TRUE);
        ObricLayoutChatReplyHeaderBinding r104 = this.f385931a;
        if (r104 == null) goto L24;
        r104.f386254c.setText(r100);
        if (r102 == true) goto L8;
        r104.f386254c.setTextColor(d.a(R.color.neutral_70, AppHost.f326268a.getApplication()));
        r104.f386253b.setImageResource(R.drawable.obric_ic_reply_rect);
    L8:
        if (IWindowContextKt.isWindowContext(getContext()) == true) goto L10;
    L12:
        TextView r105 = r104.f386254c;
        if (r103 == false) goto L15;
        Drawable r106 = getArrowDrawable();
    L16:
        r105.setCompoundDrawables(null, null, r106, null);
        TextView r107 = r104.f386254c;
        if (r100.length() != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        int r109 = 4;
    L23:
        r107.setVisibility(r109);
        goto L24
    L22:
        r109 = 0;
        goto L23
    L19:
        r108 = false;
        goto L20
    L15:
        r106 = null;
        goto L16
    L10:
        if (OMaterialHelper.f() < 3) goto L12;
        r104.f386254c.setTextColor(d.a(R.color.neutral_70, getContext()));
    L24:
        setVisibility(0);
    }
}
