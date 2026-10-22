package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuButton extends UDButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f427189a;

    public static final class a {
    }

    static {
    }

    public MenuButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MenuButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Log.i("OperateButton", "setType, type = " + r100);
        this.f427189a = r100;
        int r101 = r100.hashCode();
        if (r101 == (-867509719)) goto L17;
        if (r101 == (-314765822)) goto L14;
        if (r101 == 3181155) goto L10;
    L18:
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.creation_ai_button_secondary_text));
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.creation_ai_button_secondary_bg));
        setHeight(f0.a(48));
        return;
    L10:
        if (r100.equals("gray") == false) goto L18;
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.creation_ai_button_gray_text));
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.creation_ai_button_gray_bg));
        setHeight(f0.a(48));
        setTextSize(17.0f);
        return;
    L14:
        if (r100.equals("primary") == false) goto L18;
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.creation_ai_button_primary_bg));
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.creation_ai_button_primary_text));
        setHeight(f0.a(48));
        return;
    L17:
        if (r100.equals(INotificationHitPoint.NoticeType.REACTION) == false) goto L18;
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.creation_ai_button_gray_text));
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.creation_ai_button_gray_bg));
        setHeight(f0.a(48));
        setTextSize(17.0f);
    }

    public MenuButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f427189a = "normal";
        setGravity(17);
        setTextAlignment(4);
        setType(this.f427189a);
    }

    public /* synthetic */ MenuButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
