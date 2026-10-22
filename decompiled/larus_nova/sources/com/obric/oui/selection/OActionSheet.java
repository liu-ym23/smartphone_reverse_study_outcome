package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mma.a;

/* JADX INFO: loaded from: classes34.dex */
public final class OActionSheet extends OInsetSheet {

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "", "LIST_BUTTON", "LIST_TEXT_ONLY", "LIST_ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
        public static final enum ItemStyle extends Enum<ItemStyle> {
            public static final ItemStyle LIST_BUTTON = null;
            public static final ItemStyle LIST_ICON_AND_TEXT = null;
            public static final ItemStyle LIST_TEXT_ONLY = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ItemStyle[] f402762a = null;

            public static ItemStyle valueOf(String r100) {
                return (ItemStyle) r27.a.a(ItemStyle.class, r100);
            }

            public static ItemStyle[] values() {
                return (ItemStyle[]) f402762a.clone();
            }

            static {
                ItemStyle r100 = new ItemStyle("LIST_BUTTON", 0);
                LIST_BUTTON = r100;
                ItemStyle r101 = new ItemStyle("LIST_TEXT_ONLY", 1);
                LIST_TEXT_ONLY = r101;
                ItemStyle r102 = new ItemStyle("LIST_ICON_AND_TEXT", 2);
                LIST_ICON_AND_TEXT = r102;
                f402762a = new ItemStyle[]{r100, r101, r102};
            }

            public ItemStyle(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final OInsetSheet.PanelWidth f402763a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f402764b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f402765c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Function0<Unit> f402766d;

            public a(OInsetSheet.PanelWidth r100, String r101, Function0 r102) {
                Intrinsics.checkNotNullParameter(r100, "width");
                Intrinsics.checkNotNullParameter(r101, "title");
                this.f402763a = r100;
                this.f402764b = r101;
                this.f402765c = null;
                this.f402766d = r102;
            }
        }
    }

    static {
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L10
    L11:
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L10
        super.show();     // Catch: Exception -> L10
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L10
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        f(this);     // Catch: Exception -> L4
        return;
    }

    public static void f(OInsetSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OActionSheet(Context r110, Companion.a r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "modifier");
        super(r110);
        e(r111.f402763a);
        String r100 = r111.f402764b;
        String r101 = r111.f402765c;
        final Function0<Unit> r112 = r111.f402766d;
        LinearLayout r102 = new LinearLayout(r110);
        r102.setOrientation(1);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        FrameLayout r103 = null;
        OInsetSheetTitleBar r104 = new OInsetSheetTitleBar(r110, 0 == true ? 1 : 0, 6, 0);
        r104.setTitleText(r100);
        r104.setShowLeftBack(false);
        ViewGroup r105 = r104.getMRightContainer();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
        int r106 = OButton.f399053p;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, RootDescription.ROOT_ELEMENT);
        if (((OButton) r105.findViewById(R.id.btn_titlebar)) != null) goto L5;
        View r107 = Button.inflate(r110, R.layout.o_widget_titlebar_understated_button, r105).findViewById(R.id.btn_titlebar);
        Intrinsics.checkNotNull(r107);
        OButton r108 = (OButton) r107;
    L8:
        int r109 = r110.getColor(R.color.oui_basic_text_4);
        Drawable r113 = ContextCompat.getDrawable(r108.getContext(), R.drawable.o_ic_xmark_fill);
        if (r113 != null) goto L11;
        Drawable r114 = null;
    L12:
        r108.setMIcon(r114);
        Drawable r115 = r108.f399059f;
        if (r115 == null) goto L16;
        r115.setTint(r109);
    L16:
        Drawable r116 = r108.f399059f;
        if (r116 != null) goto L19;
        int r117 = 0;
    L20:
        r108.f399064k = r117;
        r108.invalidate();
        r108.setOnClickListener(new a(r112));
        r102.addView(r104);
        r104.setDesText(r101);
        FrameLayout r118 = this.f402833a;
        if (r118 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        r118 = null;
    L24:
        OInsetSheet.d(r118, r102);
        this.f402837e = false;
        b().setPadding(pla.d.c(r110, 16), pla.d.c(r110, 4), pla.d.c(r110, 16), pla.d.c(r110, 16));
        FrameLayout r119 = this.f402834b;
        if (r119 == null) goto L27;
        r103 = r119;
    L28:
        r103.setVisibility(8);
        return;
    L27:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        goto L28
    L19:
        r117 = r116.getAlpha();
        goto L20
    L11:
        r114 = r113.mutate();
        goto L12
    L5:
        View r120 = LayoutInflater.from(r110).inflate(R.layout.o_widget_titlebar_understated_button, r105, false);
        if (r120 == null) goto L31;
        r108 = (OButton) r120;
        r108.setId(-1);
        r105.addView(r108);
        goto L8
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }
}
