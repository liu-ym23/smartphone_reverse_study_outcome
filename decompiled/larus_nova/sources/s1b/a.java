package s1b;

import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.LruCache;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.LarkUriUtil;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FileInfo;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FilePickerCloseResult;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAction;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAlignActions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ToastShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ToastShowResult;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$XToastType;
import com.ss.android.lark.chameleonv2.lkapi.widget.panel.h;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a implements sa5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, WeakReference<UDDialog>> f540188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.a> f540189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.b> f540190c;

    /* JADX INFO: renamed from: s1b.a$a, reason: collision with other inner class name */
    public final class C7555a extends AbsChameleonHandler<IWidget$Internal$ConfirmDialogCloseOptions> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f540191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f540192b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f540191a;
        }

        public C7555a(a r100) {
            this.f540192b = r100;
            this.f540191a = LKAPIModules.Internal.Widget.CloseConfirmDialog.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ConfirmDialogCloseOptions r100, Callback r101) {
            IWidget$Internal$ConfirmDialogCloseOptions r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            Map<String, WeakReference<UDDialog>> r103 = this.f540192b.f540188a;
            LinkedHashMap r104 = (LinkedHashMap) r103;
            WeakReference r105 = (WeakReference) r104.get(r102.getId());
            if (r105 == null) goto L7;
            UDDialog r106 = (UDDialog) r105.get();
            if (r106 == null) goto L7;
            r106.cancel();
        L7:
            r101.success(null);
        }
    }

    public static final class b {
    }

    public final class c extends AbsChameleonHandler<IWidget$Internal$ConfirmDialogShowOptions> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f540193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f540194b;

        /* JADX INFO: renamed from: s1b.a$c$a, reason: collision with other inner class name */
        public /* synthetic */ class C7556a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f540195a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f540196b = null;

            static {
                int[] r100 = new int[IWidget$Internal$ConfirmDialogAlignActions.values().length];
                r100[IWidget$Internal$ConfirmDialogAlignActions.Vertical.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[IWidget$Internal$ConfirmDialogAlignActions.Horizontal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L6:
                f540195a = r100;
                int[] r101 = new int[UDBaseDialogBuilder.ActionBottomOrientation.values().length];
                r101[UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L25:
                r101[UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L21:
                r101[UDBaseDialogBuilder.ActionBottomOrientation.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L10:
                f540196b = r101;
            }
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f540193a;
        }

        public c(a r100) {
            this.f540194b = r100;
            this.f540193a = LKAPIModules.Internal.Widget.ShowConfirmDialog.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ConfirmDialogShowOptions r110, Callback r111) {
            IWidget$Internal$ConfirmDialogShowOptions r112 = r110;
            Intrinsics.checkNotNullParameter(r112, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r111, "callback");
            IChameleonHandlerContext r100 = getContext();
            if (r100 != null) goto L5;
            r111.error(new LKAPIError(-1, "Chameleon Context is null"));
            return;
        L5:
            Context r101 = r100.getCmlContext();
            if (r101 != null) goto L8;
            r111.error(new LKAPIError(-1, "App Context is null"));
            return;
        L8:
            UDDialogBuilder r102 = new UDDialogBuilder(r101);
            r102.title(r112.getTitle()).message(r112.getContent());
            r102.cancelOnTouchOutside(r112.getMaskClosable());
            int r103 = r112.getActions().size();
            if (r103 == 1) goto L19;
            if (r103 == 2) goto L12;
            UDBaseDialogBuilder.ActionBottomOrientation r104 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        L20:
            r102.actionButtonOrientation(r104);
            if (r103 == 1) goto L33;
            if (r103 == 2) goto L24;
            int[] r105 = {R.id.ud_dialog_btn_primary, R.id.ud_dialog_btn_secondary, R.id.ud_dialog_btn_secondary2};
        L34:
            List r106 = CollectionsKt.take(r112.getActions(), 3);
            a r107 = this.f540194b;
            Iterator r108 = r106.iterator();
            int r109 = 0;
        L36:
            if (r108.hasNext() == false) goto L50;
            Object r113 = r108.next();
            int r114 = r109 + 1;
            if (r109 >= 0) goto L40;
            CollectionsKt.throwIndexOverflow();
        L40:
            IWidget$Internal$ConfirmDialogAction r115 = (IWidget$Internal$ConfirmDialogAction) r113;
            if (r109 >= 0) goto L43;
        L45:
            boolean r116 = false;
        L46:
            if (r116 == false) goto L48;
            int r117 = r105[r109];
        L49:
            r102.addActionButton(r117, r115.getText(), new s1b.b(r107, r112, r100, r115));
            r109 = r114;
            goto L36
        L48:
            r117 = Integer.valueOf(R.id.ud_dialog_btn_secondary).intValue();
            goto L49
        L43:
            if (r109 >= r105.length) goto L45;
            r116 = true;
            goto L46
        L50:
            r102.onCancelListener(new s1b.c(this.f540194b, r112, r100));
            this.f540194b.f540188a.put(r112.getId(), new WeakReference(r102.show()));
            r111.success(null);
            return;
        L24:
            int r118 = C7556a.f540196b[r104.ordinal()];
            if (r118 == 1) goto L32;
            if (r118 == 2) goto L31;
            if (r118 != 3) goto L30;
            r105 = new int[]{R.id.ud_dialog_btn_secondary, R.id.ud_dialog_btn_primary};
            goto L34
        L30:
            throw new NoWhenBranchMatchedException();
        L31:
            r105 = new int[]{R.id.ud_dialog_btn_primary, R.id.ud_dialog_btn_secondary};
            goto L34
        L32:
            r105 = new int[]{R.id.ud_dialog_btn_secondary, R.id.ud_dialog_btn_primary};
            goto L34
        L33:
            r105 = new int[]{R.id.ud_dialog_btn_primary};
            goto L34
        L12:
            int r119 = C7556a.f540195a[r112.getAlignActions().ordinal()];
            if (r119 == 1) goto L18;
            if (r119 != 2) goto L17;
            r104 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
            goto L20
        L17:
            throw new NoWhenBranchMatchedException();
        L18:
            r104 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            goto L20
        L19:
            r104 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
            goto L20
        }
    }

    public final class d extends AbsChameleonHandler<IWidget$Internal$ToastShowOptions> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f540197a;

        /* JADX INFO: renamed from: s1b.a$d$a, reason: collision with other inner class name */
        public /* synthetic */ class C7557a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f540198a = null;

            static {
                int[] r100 = new int[IWidget$Internal$XToastType.values().length];
                r100[IWidget$Internal$XToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[IWidget$Internal$XToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[IWidget$Internal$XToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[IWidget$Internal$XToastType.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[IWidget$Internal$XToastType.LOADING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f540198a = r100;
            }
        }

        public d() {
            this.f540197a = LKAPIModules.Internal.Widget.ShowToast.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f540197a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ToastShowOptions r100, Callback r101) {
            IWidget$Internal$ToastShowOptions r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            IChameleonHandlerContext r103 = getContext();
            if (r103 != null) goto L5;
            r101.error(new LKAPIError(-1, "Chameleon Context is null"));
            return;
        L5:
            Context r104 = r103.getCmlContext();
            if (r104 != null) goto L8;
            r101.error(new LKAPIError(-1, "App Context is null"));
            return;
        L8:
            IWidget$Internal$XToastType r105 = r102.getType();
            if (r105 != null) goto L11;
            int r106 = -1;
        L12:
            if (r106 != (-1)) goto L14;
        L29:
            int r107 = R.drawable.ud_icon_info_outlined;
        L30:
            String r108 = r102.getContent();
            if (r108 != null) goto L33;
            r108 = "";
        L33:
            Long r109 = r102.getDuration();
            if (r109 == null) goto L36;
            long r110 = r109.longValue();
        L37:
            UDToast.a r111 = UDToast.build(r104);
            r111.g(r108);
            r111.d(r107);
            r111.f285429b.f417630d = r110;
            r111.h();
            r101.success(new IWidget$Internal$ToastShowResult(0));
            return;
        L36:
            r110 = 3000;
            goto L37
        L14:
            if (r106 != 1) goto L16;
            r107 = R.drawable.ud_icon_yes_outlined;
            goto L30
        L16:
            if (r106 != 2) goto L18;
            r107 = R.drawable.ud_icon_more_close_outlined;
            goto L30
        L18:
            if (r106 != 3) goto L20;
            r107 = R.drawable.ud_icon_warning_outlined;
            goto L30
        L20:
            if (r106 == 4) goto L29;
            if (r106 != 5) goto L25;
            r107 = R.drawable.ud_icon_loading_outlined;
            goto L30
        L25:
            throw new NoWhenBranchMatchedException();
        L11:
            r106 = C7557a.f540198a[r105.ordinal()];
            goto L12
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> b() {
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.a r100 = new com.ss.android.lark.chameleonv2.lkapi.widget.picker.a();
        this.f540189b = new WeakReference(r100);
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.b r101 = new com.ss.android.lark.chameleonv2.lkapi.widget.picker.b();
        this.f540190c = new WeakReference(r101);
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new c(this), new C7555a(this), r100, r101, new h(), new d()});
    }

    public a() {
        this.f540188a = new LinkedHashMap();
    }

    @Override // sa5.a
    public final void onActivityResult(int r110, int r111, Intent r210) {
        WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.a> r100 = this.f540189b;
        if (r100 == null) goto L35;
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.a r101 = r100.get();
        if (r101 == null) goto L35;
        if (r110 != 96) goto L35;
        if (r111 == (-1)) goto L13;
        Callback r102 = r101.f411517a;
        if (r102 == null) goto L35;
        r102.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        goto L35
    L13:
        if (r210 == null) goto L15;
        ArrayList<String> r103 = r210.getStringArrayListExtra("extra.file.path.list");
    L16:
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L22;
        Iterator<String> r105 = r103.iterator();
    L20:
        if (r105.hasNext() == false) goto L32;
        String r112 = r105.next();
        Intrinsics.checkNotNull(r112);
        String r113 = FileUtils.l(r112);
        String r114 = String.valueOf(VFSFiles.f444819b.i(r112).length());
        LruCache<String, String> r115 = l0b.a.f506906a;
        Intrinsics.checkNotNullParameter(r112, "value");
        String r116 = UUID.randomUUID().toString();
        l0b.a.f506906a.put(r116, r112);
        r104.add(new IWidget$FileInfo(r116, r113, r114));
    L32:
        Callback r106 = r101.f411517a;
        if (r106 == null) goto L35;
        r106.success(new IWidget$FilePickerCloseResult(r104));
        goto L35
    L22:
        if (r210 == null) goto L32;
        ClipData r107 = r210.getClipData();
        if (r107 == null) goto L32;
        int r117 = r107.getItemCount();
        int r118 = 0;
    L26:
        if (r118 >= r117) goto L32;
        Uri r119 = r107.getItemAt(r118).getUri();
        Application r120 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r119);
        Pair<String, Long> r121 = LarkUriUtil.g(r120, r119);
        if (r121 == null) goto L30;
        String r122 = r121.component1();
        String r123 = String.valueOf(r121.component2().longValue());
    L31:
        String r124 = r119.toString();
        LruCache<String, String> r125 = l0b.a.f506906a;
        Intrinsics.checkNotNullParameter(r124, "value");
        String r108 = UUID.randomUUID().toString();
        l0b.a.f506906a.put(r108, r124);
        r104.add(new IWidget$FileInfo(r108, r122, r123));
        r118 = r118 + 1;
        goto L26
    L30:
        r122 = "";
        r123 = "";
        goto L31
    L15:
        r103 = null;
    L35:
        WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.b> r109 = this.f540190c;
        if (r109 == null) goto L65;
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.b r126 = r109.get();
        if (r126 != null) goto L40;
        return;
    L40:
        if (r110 == 97) goto L43;
        return;
    L43:
        if (r111 == (-1)) goto L47;
        Callback r127 = r126.f411519a;
        if (r127 == null) goto L67;
        r127.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        return;
    L67:
        return;
    L47:
        if (r210 == null) goto L49;
        ArrayList<String> r128 = r210.getStringArrayListExtra("SELECTED_PHOTOS");
    L50:
        ArrayList r129 = new ArrayList();
        if (r128 == null) goto L56;
        Iterator<String> r130 = r128.iterator();
    L54:
        if (r130.hasNext() == false) goto L56;
        String r131 = r130.next();
        VFSFiles r132 = VFSFiles.f444819b;
        Intrinsics.checkNotNull(r131);
        VFSFile r133 = r132.i(r131);
        String[] r134 = FileUtils.f285888a;
        long r135 = r133.length();
        String r136 = FileUtils.l(r131);
        String r137 = r133.toUri().toString();
        Intrinsics.checkNotNull(r136);
        String r138 = String.valueOf(r135);
        LruCache<String, String> r139 = l0b.a.f506906a;
        Intrinsics.checkNotNullParameter(r137, "value");
        String r140 = UUID.randomUUID().toString();
        l0b.a.f506906a.put(r140, r137);
        r129.add(new IWidget$FileInfo(r140, r136, r138));
    L56:
        Callback r141 = r126.f411519a;
        if (r141 == null) goto L69;
        r141.success(new IWidget$FilePickerCloseResult(r129));
        return;
    L69:
        return;
    L49:
        r128 = null;
        goto L50
    }
}
