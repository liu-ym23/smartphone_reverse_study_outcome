package com.obric.assistant;

import ada.d;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.EventsUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.home.api.main.HomeService;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricUIService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.xmlpull.v1.XmlPullParser;
import t1a.b;
import xha.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0014H\u0016J\u001c\u0010+\u001a\u00020\b2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-H\u0016J\u0018\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020#H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u00069"}, d2 = {"Lcom/obric/assistant/ObricUIServiceImpl;", "Lcom/obric/assistant/common/spi/IObricUIService;", "<init>", "()V", "lastNavigationBarHeight", XmlPullParser.NO_NAMESPACE, "Ljava/lang/Integer;", "changeFontSizeToSP", XmlPullParser.NO_NAMESPACE, "textViews", XmlPullParser.NO_NAMESPACE, "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "toSPBasedPixelSize", "context", "Landroid/content/Context;", "dpBasedPixelSize", XmlPullParser.NO_NAMESPACE, "setChatRootBottomPadding", "chatRoot", "Landroid/view/View;", "navigationBarHeight", "getNavigationBarHeightFallback", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Integer;", "onSideBarContentViewCreated", "contentView", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getMentionPanelMaxHeight", "panelView", "currentMaxHeight", "(Landroid/view/View;I)Ljava/lang/Integer;", "isWindowLandscape", XmlPullParser.NO_NAMESPACE, "actionMenuEntrance", "enableActionBarMenuFocusable", "enableInterceptSwitchMenuView", "enableInterceptSwitchMenuOutsideTouch", "applyResourceBarStyle", "viewType", "itemView", "setTagForBottomMenuIcon", "iconMap", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "Landroid/widget/ImageView;", "applySuggestedActionBarStyle", "textView", "iconView", "disableSwDpOffline", "onEnterSelectMode", "isWindowHost", "isMultiTaskNewChatNavEntryEnabledWhenEnterprise", "setupInputPanelHeader", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricUIServiceImpl implements IObricUIService {
    public static final /* synthetic */ int b = 0;
    public volatile Integer a;

    public static final class a {
    }

    static {
    }

    public ObricUIServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean la() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void na(TextView... r2) {
        Intrinsics.checkNotNullParameter(r2, "textViews");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void pa() {
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ra() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean sa() {
        return false;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final int ua(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r3;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final float va(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r3;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ma() {
        return HomeService.a.o();
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void ia(Map<String, ? extends ImageView> r3) {
        Intrinsics.checkNotNullParameter(r3, "iconMap");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        b r2 = r1.provideWindowVContext();     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        e r4 = r2.o(Reflection.getOrCreateKotlinClass(e.class));     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        r4.ia(r3);     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Result.m49constructorimpl(r5);     // Catch: Throwable -> L13
        return;
    L10:
        r5 = null;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m49constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ja(View r4) {
        Intrinsics.checkNotNullParameter(r4, "actionMenuEntrance");
        Context r5 = r4.getContext();
        if (r5 == null) goto L9;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L9;
        Configuration r7 = r6.getConfiguration();
        if (r7 == null) goto L9;
        Integer r8 = Integer.valueOf(r7.orientation);
    L10:
        FLogger.a.i("ObricUIServiceImpl", "view orientation: " + r8);
        if (r8 != null) goto L14;
    L16:
        return false;
    L14:
        if (r8.intValue() != 2) goto L16;
        return true;
    L9:
        r8 = null;
        goto L10
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final Integer ka(FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        View r6 = r5.getWindow().getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        WindowInsetsCompat r7 = ViewCompat.getRootWindowInsets(r6);
        if (r7 == null) goto L12;
        Insets r8 = r7.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r8 == null) goto L12;
        Integer r9 = Integer.valueOf(r8.bottom);
    L13:
        Integer r1 = this.a;
        if (Intrinsics.areEqual(r9, r1) == true) goto L16;
        FLogger.a.i("ObricUIServiceImpl", "navigationBarHeight changed: " + r1 + " -> " + r9);
        this.a = r9;
    L16:
        return r9;
    L12:
        r9 = null;
        goto L13
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void wa(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        if (IWindowContextKt.isWindowContext(r3.getContext()) == false) goto L6;
        r3.setBackground(new ColorDrawable(0));
        return;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void xa(boolean r4) {
        if (r4 == true) goto L4;
        return;
    L4:
        IAssistantChatWindow r5 = IAssistantChatWindowKt.getAssistantChatWindow();
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r0 = null;
        if (r5 == null) goto L9;
        b r6 = r5.provideWindowVContext();
        if (r6 == null) goto L9;
        ICoreInputAbility r7 = (ICoreInputAbility) r6.o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
    L10:
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 == null) goto L16;
        b r2 = r1.provideWindowVContext();
        if (r2 == null) goto L16;
        r0 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) r2.o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class));
    L16:
        if (r0 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == false) goto L25;
        if (r7 == null) goto L26;
        r7.C1(false, true, XmlPullParser.NO_NAMESPACE);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        if (r0.sL() != true) goto L20;
        r3 = true;
    L9:
        r7 = null;
        goto L10
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final int b(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "chatRoot");
        return ObricChatUIDelegate.b.b(r2, r3);
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void oa(TextView r2, AppCompatImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "iconView");
        if (IWindowContextKt.isWindowContext(r2.getContext()) == false) goto L6;
        com.obric.assistant.util.q2.a(r2);
        return;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void qa(ConstraintLayout r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "contentView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        ViewCompat.setOnApplyWindowInsetsListener(r2, new h4());
        if (r2.isAttachedToWindow() == false) goto L5;
        ViewCompat.requestApplyInsets(r2);
    L6:
        r3.getLifecycle().addObserver(new onSideBarContentViewCreated.3(r2));
        return;
    L5:
        r2.addOnAttachStateChangeListener(new i4(r2));
        goto L6
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void ta(int r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L10;
        b r1 = r0.provideWindowVContext();
        if (r1 == null) goto L11;
        d r2 = r1.o(Reflection.getOrCreateKotlinClass(d.class));
        if (r2 == null) goto L12;
        r2.gi(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
