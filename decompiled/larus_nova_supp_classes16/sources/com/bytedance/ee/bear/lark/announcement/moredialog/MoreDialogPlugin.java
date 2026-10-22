package com.bytedance.ee.bear.lark.announcement.moredialog;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.dialog.bean.MoreDialogModel;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.l;
import com.larksuite.framework.ui.BaseDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/lark/announcement/moredialog/MoreDialogPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "showMoreDialogHandler", "Lcom/bytedance/ee/bear/lark/announcement/moredialog/MoreDialogPlugin$ShowMoreDialogHandler;", "creator", "Lcom/bytedance/ee/bear/document/dialog/RightTopMoreDialogCreator;", "mOnDeleteListener", "Lcom/bytedance/ee/bear/document/event/IEventPlugin$OnDeleteListener;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "Companion", "ShowMoreDialogHandler", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreDialogPlugin extends DocumentPlugin {
    public static final String BIZ_NAVIGATION_SHOW_MORE_DIALOG = "biz.navigation.showMoreDialog";
    public static final a Companion = null;
    public static final String TAG = "MoreDialogPlugin";
    private final r05.b creator;
    private final IEventPlugin.a mOnDeleteListener;
    private b showMoreDialogHandler;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<MoreDialogModel> {
        public m a;
        public final /* synthetic */ MoreDialogPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(MoreDialogPlugin r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r14, m r16) {
            MoreDialogModel r17 = (MoreDialogModel) r14;
            tt5.a.h(MoreDialogPlugin.TAG, "Show more dialog.");
            if (r17 == null) goto L31;
            this.a = r16;
            if (MoreDialogPlugin.access$isUIContainerAttached(this.b) == false) goto L30;
            r05.b r18 = MoreDialogPlugin.access$getCreator$p(this.b);
            Context r0 = MoreDialogPlugin.access$getContext(this.b);
            com.bytedance.ee.bear.lark.announcement.moredialog.a r1 = new com.bytedance.ee.bear.lark.announcement.moredialog.a(this);
            r18.getClass();
            Intrinsics.checkNotNullParameter(r0, "context");
            Intrinsics.checkNotNullParameter(r17, "data");
            Intrinsics.checkNotNullParameter(r1, "clickListener");
            r18.a();
            View r2 = LayoutInflater.from(r0).inflate(2131563676, null);
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout r3 = (LinearLayout) r2;
            int r4 = r17.getItems().size() - 1;
            Iterator<T> r19 = r17.getItems().iterator();
            int r7 = 0;
        L9:
            if (r19.hasNext() == false) goto L20;
            Object r8 = r19.next();
            int r9 = r7 + 1;
            if (r7 >= 0) goto L13;
            CollectionsKt.throwIndexOverflow();
        L13:
            MoreDialogModel.MoreDialogItem r10 = (MoreDialogModel.MoreDialogItem) r8;
            Integer r11 = r05.b.c.get(r10.getId());
            if (r11 == null) goto L19;
            int r12 = r11.intValue();
            Intrinsics.checkNotNull(r10);
            View r13 = LayoutInflater.from(r0).inflate(2131563677, null);
            r13.setTag(r10.getId());
            ImageView r110 = (ImageView) r13.findViewById(2131376416);
            r110.setImageResource(r12);
            l.c(r110, 2131102418);
            ((TextView) r13.findViewById(2131390964)).setText(r10.getText());
            r13.setEnabled(r10.isEnable());
            r13.setOnClickListener(new r05.c(r1, r10, r18));
            Intrinsics.checkNotNull(r13);
            View r20 = r13.findViewById(2131380301);
            if (r7 != r4) goto L18;
            r20.setVisibility(8);
        L18:
            List<View> r21 = r18.b;
            Intrinsics.checkNotNull(r20);
            ((ArrayList) r21).add(r20);
            r3.addView(r13);
        L19:
            r7 = r9;
            goto L9
        L20:
            r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int r111 = r3.getMeasuredWidth();
            Iterator r5 = ((ArrayList) r18.b).iterator();
        L22:
            if (r5.hasNext() == false) goto L24;
            View r6 = (View) r5.next();
            ViewGroup.LayoutParams r22 = r6.getLayoutParams();
            r22.width = r111;
            r6.setLayoutParams(r22);
            goto L22
        L24:
            BaseDialog r112 = new BaseDialog(r0, 2131954194);
            r112.setContentView(r3);
            r112.setCanceledOnTouchOutside(true);
            r18.a = r112;
            float[] r113 = {12.0f, 49.0f};
            Window r23 = r112.getWindow();
            WindowManager.LayoutParams r24 = r23.getAttributes();
            Resources r26 = r0.getResources();
            DisplayMetrics r27 = WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics());
            r24.gravity = 53;
            float r28 = r113[0];
            float r114 = r113[1];
            r24.horizontalMargin = UIUtils.dp2px(r0, r28) / r27.widthPixels;
            r24.verticalMargin = UIUtils.dp2px(r0, r114) / r27.heightPixels;
            r23.setAttributes(r24);
            r23.setWindowAnimations(2131953928);
            r23.setDimAmount(fac.a.b(r0));
            fac.a.a(r112);
            return;
        L30:
            return;
        }
    }

    public static final class c implements IEventPlugin.a {
        public final /* synthetic */ MoreDialogPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ MoreDialogPlugin a;

            public a(MoreDialogPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MoreDialogPlugin.access$getCreator$p(this.a).a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(MoreDialogPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            j.c(new a(this.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MoreDialogPlugin() {
        this.creator = new r05.b();
        this.mOnDeleteListener = new c(this);
    }

    public static final /* synthetic */ Context access$getContext(MoreDialogPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ r05.b access$getCreator$p(MoreDialogPlugin r0) {
        return r0.creator;
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(MoreDialogPlugin r0) {
        return r0.isUIContainerAttached();
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        b r3 = new b(this);
        this.showMoreDialogHandler = r3;
        bindBridgeHandler(BIZ_NAVIGATION_SHOW_MORE_DIALOG, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L6;
        r3.addDeleteListener(this.mOnDeleteListener);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.creator.a();
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L6;
        r3.removeDeleteListener(this.mOnDeleteListener);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
