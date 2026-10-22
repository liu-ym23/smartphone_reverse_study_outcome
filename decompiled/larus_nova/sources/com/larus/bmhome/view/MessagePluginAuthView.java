package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusViewMessagePluginAuthBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ3\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u001eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/MessagePluginAuthView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/auth/IAuthorizationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusViewMessagePluginAuthBinding;", "showAuthButton", "", "vertical", "", "immersiveColor", "clickListener", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/auth/model/PluginAuthType;", "(ZLjava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "hideAuthButton", "updateButtonGroup", "setSelectedListener", "getAuthAlwaysButton", "Landroid/widget/TextView;", "getAuthOnceButton", "getAuthDenyButton", "setButtonStyle", "(ZLjava/lang/Integer;)V", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessagePluginAuthView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f315578b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusViewMessagePluginAuthBinding f315579a;

    public MessagePluginAuthView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessagePluginAuthView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public MessagePluginAuthView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_view_message_plugin_auth, this);
        int r113 = R.id.auth_always_h;
        RoundTextView r100 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_always_h);
        if (r100 == null) goto L23;
        r113 = R.id.auth_always_v;
        RoundTextView r101 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_always_v);
        if (r101 == null) goto L23;
        r113 = R.id.auth_button_group_h;
        ConstraintLayout r102 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.auth_button_group_h);
        if (r102 == null) goto L23;
        r113 = R.id.auth_button_group_v;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.auth_button_group_v);
        if (r103 == null) goto L23;
        r113 = R.id.auth_deny_h;
        RoundTextView r104 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_deny_h);
        if (r104 == null) goto L23;
        r113 = R.id.auth_deny_v;
        RoundTextView r105 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_deny_v);
        if (r105 == null) goto L23;
        r113 = R.id.auth_once_h;
        RoundTextView r106 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_once_h);
        if (r106 == null) goto L23;
        r113 = R.id.auth_once_v;
        RoundTextView r107 = (RoundTextView) ViewBindings.findChildViewById(this, R.id.auth_once_v);
        if (r107 == null) goto L23;
        r113 = R.id.divider;
        View r114 = ViewBindings.findChildViewById(this, R.id.divider);
        if (r114 == null) goto L23;
        this.f315579a = new LarusViewMessagePluginAuthBinding(this, r100, r101, r102, r103, r104, r105, r106, r107, r114);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ MessagePluginAuthView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
