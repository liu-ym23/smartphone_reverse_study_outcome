package j6b;

import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewAction;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f497542a = null;

        static {
            int[] r100 = new int[UrlPreviewAction.Method.values().length];
            r100[UrlPreviewAction.Method.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[UrlPreviewAction.Method.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[UrlPreviewAction.Method.OPEN_URL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[UrlPreviewAction.Method.LARK_COMMAND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[UrlPreviewAction.Method.SWITCH_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[UrlPreviewAction.Method.SHOW_TOAST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[UrlPreviewAction.Method.SHOW_DIALOG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f497542a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final Parameters a(UrlPreviewAction.Parameters r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Parameters(r100.parameters, r100.user_id, r100.source_id, r100.preview_id);
    }

    @JvmStatic
    public static final ShowDialogAction b(UrlPreviewAction.ShowDialogAction r100) {
        ShowDialogAction.DialogItem r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.buttons.iterator();
    L7:
        if (r103.hasNext() == false) goto L24;
        UrlPreviewAction.ShowDialogAction.DialogButton r104 = (UrlPreviewAction.ShowDialogAction.DialogButton) r103.next();
        if (r104 != null) goto L11;
        ShowDialogAction.a r105 = null;
    L22:
        if (r105 == null) goto L7;
        r102.add(r105);
        goto L7
    L11:
        String r106 = r104.text;
        ShowDialogAction.DialogButtonType.a r107 = ShowDialogAction.DialogButtonType.Companion;
        int r108 = r104.type.getValue();
        r107.getClass();
        if (r108 != 0) goto L14;
        ShowDialogAction.DialogButtonType r109 = ShowDialogAction.DialogButtonType.DEFAULT;
    L21:
        r105 = new ShowDialogAction.a(r106, r109, r104.action_id);
        goto L22
    L14:
        if (r108 != 1) goto L16;
        r109 = ShowDialogAction.DialogButtonType.PRIMARY;
        goto L21
    L16:
        if (r108 == 2) goto L18;
        r109 = ShowDialogAction.DialogButtonType.DEFAULT;
        goto L21
    L18:
        r109 = ShowDialogAction.DialogButtonType.DANGER;
        goto L21
    L24:
        UrlPreviewAction.ShowDialogAction.DialogItem r110 = r100.title;
        if (r110 != null) goto L27;
        ShowDialogAction.DialogItem r111 = null;
    L28:
        UrlPreviewAction.ShowDialogAction.DialogItem r112 = r100.content;
        if (r112 == null) goto L33;
        r101 = new ShowDialogAction.DialogItem(r112.text, r112.number_of_lines);
    L33:
        return new ShowDialogAction(r111, r101, r102);
    L27:
        r111 = new ShowDialogAction.DialogItem(r110.text, r110.number_of_lines);
        goto L28
    }

    @JvmStatic
    public static final Url c(URL r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Url(r100.url, r100.ios, r100.f253581android, r100.f253582pc, r100.f253583web);
    }

    @JvmStatic
    public static final com.ss.android.lark.export.entity.preview.UrlPreviewAction d(UrlPreviewAction r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "pbAction");
        int r100 = -1;
        BaseAction r101 = null;
        if (r111 == false) goto L48;
        UrlPreviewAction.Method r112 = r110.method;
        if (r112 == null) goto L8;
        r100 = a.f497542a[r112.ordinal()];
    L8:
        switch(r100) {
            case 1: goto L42;
            case 2: goto L38;
            case 3: goto L34;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L11;
        };
    L10:
        r101 = b(r110.show_dialog);
        goto L11
    L12:
        UrlPreviewAction.ShowToastAction r113 = r110.show_toast;
        if (r113 == null) goto L11;
        ShowToastAction.ToastType.a r102 = ShowToastAction.ToastType.Companion;
        int r103 = r113.type.getValue();
        r102.getClass();
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L22;
        if (r103 == 4) goto L21;
        ShowToastAction.ToastType r104 = ShowToastAction.ToastType.SUCCESS;
    L25:
        r101 = new ShowToastAction(r104, r113.content, r113.duration.intValue());
        goto L11
    L21:
        r104 = ShowToastAction.ToastType.WARNING;
        goto L25
    L22:
        r104 = ShowToastAction.ToastType.INFO;
        goto L25
    L23:
        r104 = ShowToastAction.ToastType.ERROR;
        goto L25
    L24:
        r104 = ShowToastAction.ToastType.SUCCESS;
        goto L25
    L26:
        UrlPreviewAction.SwitchStateAction r114 = r110.switch_state;
        if (r114 == null) goto L11;
        r101 = new SwitchStateAction(r114.next_state_id);
        goto L11
    L30:
        UrlPreviewAction.LarkCommandAction r115 = r110.command;
        if (r115 == null) goto L11;
        r101 = new LarkCommandAction(r115.cmd.intValue(), a(r115.parameters));
        goto L11
    L34:
        UrlPreviewAction.OpenURLAction r116 = r110.open_url_v2;
        if (r116 == null) goto L11;
        r101 = new OpenUrlAction(c(r116.open_url));
        goto L11
    L38:
        UrlPreviewAction.PostAction r117 = r110.post;
        if (r117 == null) goto L11;
        r101 = new PostAction(a(r117.parameters));
        goto L11
    L42:
        UrlPreviewAction.GetAction r118 = r110.get;
        if (r118 == null) goto L11;
        r101 = new GetAction(a(r118.parameters));
    L11:
        BaseAction r119 = r101;
        String r105 = r110.url;
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a r106 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.Companion;
        int r107 = r110.method.getValue();
        r106.getClass();
        return new com.ss.android.lark.export.entity.preview.UrlPreviewAction(r105, com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a.a(r107), a(r110.parameters), r110.cmd.intValue(), c(r110.open_url), r110.fallback_action_id, r119);
    L48:
        UrlPreviewAction.Method r120 = r110.method;
        if (r120 == null) goto L52;
        r100 = a.f497542a[r120.ordinal()];
    L52:
        if (r100 == 1) goto L63;
        if (r100 == 2) goto L62;
        if (r100 == 3) goto L61;
        if (r100 != 4) goto L57;
        r101 = new LarkCommandAction(r110.cmd.intValue(), a(r110.parameters));
    L64:
        String r108 = r110.url;
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a r109 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.Companion;
        int r121 = r110.method.getValue();
        r109.getClass();
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method r122 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a.a(r121);
        Parameters r123 = a(r110.parameters);
        int r124 = r110.cmd.intValue();
        Url r125 = c(r110.open_url);
        String r126 = r110.fallback_action_id;
        return new com.ss.android.lark.export.entity.preview.UrlPreviewAction(r108, r122, r123, r124, r125, r126, r101);
    L57:
        if (r100 != 7) goto L64;
        r101 = b(r110.show_dialog);
        goto L64
    L61:
        r101 = new OpenUrlAction(c(r110.open_url));
        goto L64
    L62:
        r101 = new PostAction(a(r110.parameters));
        goto L64
    L63:
        r101 = new GetAction(a(r110.parameters));
        goto L64
    }

    @JvmStatic
    public static final LinkedHashMap<String, com.ss.android.lark.export.entity.preview.UrlPreviewAction> e(Map<String, UrlPreviewAction> r100, boolean r101) {
        LinkedHashMap<String, com.ss.android.lark.export.entity.preview.UrlPreviewAction> r102 = new LinkedHashMap();
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, UrlPreviewAction>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, UrlPreviewAction> r104 = r103.next();
        r102.put(r104.getKey(), d(r104.getValue(), r101));
    L8:
        return r102;
    }
}
