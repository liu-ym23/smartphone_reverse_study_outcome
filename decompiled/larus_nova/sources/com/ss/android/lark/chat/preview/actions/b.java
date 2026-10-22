package com.ss.android.lark.chat.preview.actions;

import android.content.Context;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.preview.GetAction;
import com.ss.android.lark.chat.entity.preview.LarkCommandAction;
import com.ss.android.lark.chat.entity.preview.OpenUrlAction;
import com.ss.android.lark.chat.entity.preview.PostAction;
import com.ss.android.lark.chat.entity.preview.ShowDialogAction;
import com.ss.android.lark.chat.entity.preview.ShowToastAction;
import com.ss.android.lark.chat.entity.preview.SwitchStateAction;
import com.ss.android.lark.export.entity.preview.BaseAction;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: classes35.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f415975h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlPreviewAction f415976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f415977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UrlPreviewBody f415978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f415979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, UrlPreviewAction> f415980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final URLPreviewParams f415981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f415982g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.actions.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C4868b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415983a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f415984b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f415985c = null;

        static {
            int[] r100 = new int[ShowToastAction.ToastType.values().length];
            r100[ShowToastAction.ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L46:
            r100[ShowToastAction.ToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L60:
            r100[ShowToastAction.ToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L48:
            r100[ShowToastAction.ToastType.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L10:
            f415983a = r100;
            int[] r101 = new int[ShowDialogAction.DialogButtonType.values().length];
            r101[ShowDialogAction.DialogButtonType.DANGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L50:
            r101[ShowDialogAction.DialogButtonType.PRIMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L13:
            f415984b = r101;
            int[] r102 = new int[UrlPreviewAction.Method.values().length];
            r102[UrlPreviewAction.Method.OPEN_URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L40:
            r102[UrlPreviewAction.Method.LARK_COMMAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L52:
            r102[UrlPreviewAction.Method.GET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L38:
            r102[UrlPreviewAction.Method.POST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L56:
            r102[UrlPreviewAction.Method.SWITCH_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L42:
            r102[UrlPreviewAction.Method.SHOW_TOAST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L44:
            r102[UrlPreviewAction.Method.SHOW_DIALOG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L21:
            f415985c = r102;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.chat.preview.actions.ActionImpl$onActionTriggered$1] */
    public void a(final int r110) {
        UrlPreviewAction r100 = this.f415976a;
        if (r100 == null) goto L128;
        String r101 = this.f415977b;
        if (r110 > 10) goto L146;
        boolean r102 = true;
        Parameters r103 = null;
        switch(C4868b.f415985c[r100.getMethod().ordinal()]) {
            case 1: goto L93;
            case 2: goto L79;
            case 3: goto L79;
            case 4: goto L79;
            case 5: goto L74;
            case 6: goto L58;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        Log.i("ActionImpl", "action method:" + r100.getMethod());
        return;
    L10:
        BaseAction r104 = r100.getAction();
        if ((r104 instanceof ShowDialogAction) == false) goto L130;
        ShowDialogAction r105 = (ShowDialogAction) r104;
        ShowDialogAction.DialogItem r106 = r105.getTitle();
        if (r106 == null) goto L17;
        Integer r107 = r106.getNumberOfLines();
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        if (r108 <= 0) goto L24;
        if (r106 == null) goto L23;
        Integer r109 = r106.getNumberOfLines();
        if (r109 == null) goto L23;
        int r111 = r109.intValue();
    L25:
        ShowDialogAction.DialogItem r112 = r105.getContent();
        ArrayList<ShowDialogAction.a> r113 = r105.getButtons();
        UDDialogBuilder r114 = new UDDialogBuilder(this.f415979d.getContext()).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
        String r115 = "";
        if (r106 == null) goto L29;
        String r116 = r106.getText();
        if (r116 == null) goto L29;
    L30:
        UDDialogBuilder r117 = r114.title(r116).titleBold(true).titleLineCount(r111);
        if (r112 == null) goto L36;
        String r118 = r112.getText();
        if (r118 == null) goto L36;
        r115 = r118;
    L36:
        UDDialogBuilder r119 = r117.message(r115);
        if (r113 == null) goto L51;
        Iterator<T> r120 = r113.iterator();
    L40:
        if (r120.hasNext() == false) goto L51;
        ShowDialogAction.a r121 = (ShowDialogAction.a) r120.next();
        ShowDialogAction.DialogButtonType r122 = r121.getType();
        if (r122 != null) goto L44;
        int r123 = -1;
    L45:
        if (r123 == 1) goto L49;
        if (r123 == 2) goto L48;
        UDBaseDialogBuilder.ActionBuilder r124 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.f415979d.getContext(), R.color.text_title)).actionResId(R.id.ud_dialog_btn_primary);
    L50:
        r124.text(r121.f415351a).onClickListener(new c(r121, this, r110));
        r119.addActionButton(r124);
        goto L40
    L48:
        r124 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.f415979d.getContext(), R.color.primary_fill_default)).actionResId(R.id.ud_dialog_btn_secondary);
        goto L50
    L49:
        r124 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.f415979d.getContext(), R.color.function_danger_fill_default)).actionResId(R.id.ud_dialog_btn_secondary2);
        goto L50
    L44:
        r123 = C4868b.f415984b[r122.ordinal()];
    L51:
        if (r113 == null) goto L53;
        int r125 = r113.size();
    L54:
        if (r125 <= 2) goto L56;
        UDDialogBuilder r126 = r119.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
    L57:
        r119.cancelOnTouchOutside(false).show();
        return;
    L56:
        UDDialogBuilder r127 = r119.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL);
        goto L57
    L53:
        r125 = 0;
    L29:
        r116 = "";
    L23:
        r111 = 0;
        goto L25
    L24:
        r111 = Integer.MAX_VALUE;
    L17:
        r108 = 0;
        goto L18
    L130:
        return;
    L58:
        BaseAction r128 = r100.getAction();
        if ((r128 instanceof ShowToastAction) == false) goto L132;
        ShowToastAction r129 = (ShowToastAction) r128;
        int r130 = C4868b.f415983a[r129.getType().ordinal()];
        if (r130 == 1) goto L72;
        if (r130 != 2) goto L64;
        int r131 = R.drawable.ud_icon_more_close_outlined;
    L73:
        UDToast.a r132 = UDToast.build(this.f415979d.getContext());
        r132.g(r129.getContent());
        r132.d(r131);
        r132.f285429b.f417630d = r129.getDuration();
        r132.h();
        return;
    L64:
        if (r130 != 3) goto L66;
        r131 = R.drawable.ud_icon_warning_outlined;
        goto L73
    L66:
        if (r130 != 4) goto L69;
        r131 = R.drawable.ud_icon_info_outlined;
        goto L73
    L69:
        throw new NoWhenBranchMatchedException();
    L72:
        r131 = R.drawable.ud_icon_yes_outlined;
        goto L73
    L132:
        return;
    L74:
        BaseAction r133 = r100.getAction();
        if ((r133 instanceof SwitchStateAction) == false) goto L134;
        vcb.a r134 = (vcb.a) new WeakReference(this.f415979d.f554143c).get();
        if (r134 == null) goto L135;
        r134.a(this.f415981f.f420685a, ((SwitchStateAction) r133).getNextStateId());
        return;
    L135:
        return;
    L134:
        return;
    L79:
        BaseAction r135 = r100.getAction();
        if ((r135 instanceof LarkCommandAction) == false) goto L83;
        r103 = ((LarkCommandAction) r135).getParameters();
    L88:
        g6b.a.InterfaceC5990a r136 = (g6b.a.InterfaceC5990a) this.f415982g.getValue();
        if (r136 == null) goto L137;
        com.ss.android.lark.officesdk.integrator.im.a r137 = r136.a();
        if (r137 == 0) goto L138;
        r137.b(r103, r101, new ActionImpl$onActionTriggered$1(this, r110));
        return;
    L138:
        return;
    L137:
        return;
    L83:
        if ((r135 instanceof GetAction) == false) goto L86;
        r103 = ((GetAction) r135).getParameters();
        goto L88
    L86:
        if ((r135 instanceof PostAction) == false) goto L88;
        r103 = ((PostAction) r135).getParameters();
        goto L88
    L93:
        BaseAction r138 = r100.getAction();
        if ((r138 instanceof OpenUrlAction) == false) goto L140;
        OpenUrlAction r139 = (OpenUrlAction) r138;
        Url r140 = r139.getOpenUrl();
        if (r140 == null) goto L98;
        String r141 = r140.getAndroidUrl();
    L99:
        if (r141 != null) goto L101;
    L104:
        if (r102 == false) goto L114;
        g6b.a.InterfaceC5990a r142 = (g6b.a.InterfaceC5990a) this.f415982g.getValue();
        if (r142 == null) goto L141;
        com.ss.android.lark.officesdk.integrator.im.a r143 = r142.a();
        if (r143 == null) goto L142;
        Context r144 = this.f415979d.getContext();
        Url r145 = r139.getOpenUrl();
        if (r145 == null) goto L112;
        String r146 = r145.getUrl();
    L113:
        r143.a(r144, r146, null);
        return;
    L112:
        r146 = null;
        goto L113
    L142:
        return;
    L141:
        return;
    L114:
        g6b.a.InterfaceC5990a r147 = (g6b.a.InterfaceC5990a) this.f415982g.getValue();
        if (r147 == null) goto L144;
        com.ss.android.lark.officesdk.integrator.im.a r148 = r147.a();
        if (r148 == null) goto L145;
        Context r149 = this.f415979d.getContext();
        Url r150 = r139.getOpenUrl();
        if (r150 == null) goto L121;
        String r151 = r150.getAndroidUrl();
    L122:
        r148.a(r149, r151, null);
        return;
    L121:
        r151 = null;
        goto L122
    L145:
        return;
    L144:
        return;
    L101:
        if (r141.length() == 0) goto L104;
        r102 = false;
        goto L104
    L98:
        r141 = null;
        goto L99
    L140:
        return;
    L146:
        return;
    }

    public b(UrlPreviewAction r100, String r101, UrlPreviewBody r102, d r103, Map r104) {
        Intrinsics.checkNotNullParameter(r103, "dependency");
        this.f415976a = r100;
        this.f415977b = r101;
        this.f415978c = r102;
        this.f415979d = r103;
        this.f415980e = r104;
        this.f415981f = r103.f554144d;
        this.f415982g = LazyKt.lazy(ActionImpl$sChatPreviewDependency$2.INSTANCE);
    }
}
