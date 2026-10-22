package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ChatCheckBox;", "Landroidx/appcompat/widget/AppCompatCheckBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interceptTouchEvent", "", "getInterceptTouchEvent", "()Z", "setInterceptTouchEvent", "(Z)V", "isImmerseMode", "srcDrawable", "Landroid/graphics/drawable/Drawable;", "init", "", "setChecked", "checked", "show", "immerseMode", "hide", "applyTintForState", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatCheckBox extends AppCompatCheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f304774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f304775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f304776c;

    public final void a() {
        setVisibility(8);
    }

    public final boolean getInterceptTouchEvent() {
        return this.f304774a;
    }

    public ChatCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        setBackground(ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_ic_msg_checkbox, getContext(), R.drawable.larus_ic_msg_checkbox)));
        setButtonDrawable(null);
    }

    public final void c(boolean r100) {
        if (this.f304775b == r100) goto L9;
        this.f304775b = r100;
        if (r100 == false) goto L7;
        Drawable r101 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_ic_msg_checkbox_immerse, getContext(), R.drawable.larus_ic_msg_checkbox_immerse));
    L8:
        setBackground(r101);
        goto L9
    L7:
        r101 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_ic_msg_checkbox, getContext(), R.drawable.larus_ic_msg_checkbox));
    L9:
        setVisibility(0);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        Drawable r101 = getBackground();
        if (r101 == null) goto L25;
        Drawable r102 = r101.mutate();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f304775b == false) goto L10;
    L19:
        IFlowThemeConfigProvider r103 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r103 == null) goto L29;
        Drawable r104 = this.f304776c;
        ThemeConfigScene r105 = ThemeConfigScene.CHAT;
        Drawable r106 = r103.b(r104, ThemeColorKey.MESSAGE_CHECKBOX_COLOR, r105, AdaptThemeFeatureKey.MESSAGE_CHECKBOX);
        if (r106 == null) goto L30;
        setBackground(r106);
        return;
    L30:
        return;
    L29:
        return;
    L10:
        if (isChecked() == false) goto L19;
        if (this.f304776c != null) goto L14;
        this.f304776c = r102;
    L14:
        int r107 = v19.c.b(R.attr.larus_ic_msg_checkbox2, getContext(), R.drawable.larus_ic_msg_checkbox2);
        Drawable r108 = ContextCompat.getDrawable(getContext(), r107);
        IFlowThemeConfigProvider r109 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r109 == null) goto L26;
        Drawable r110 = this.f304776c;
        ThemeConfigScene r111 = ThemeConfigScene.CHAT;
        Drawable r112 = r109.e(r110, r108, ThemeColorKey.MESSAGE_CHECKBOX_COLOR, r111, AdaptThemeFeatureKey.MESSAGE_CHECKBOX);
        if (r112 == null) goto L27;
        setBackground(r112);
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void setInterceptTouchEvent(boolean r100) {
        this.f304774a = r100;
    }

    public ChatCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        b(r100);
    }

    public ChatCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        b(r100);
    }
}
