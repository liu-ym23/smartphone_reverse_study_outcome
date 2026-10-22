package e4b;

import android.content.Context;
import android.content.Intent;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.message.j;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s2b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements e4b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b f471028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListMode f471029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 f471030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<j> f471031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f471032e;

    public static final class a {
    }

    /* JADX INFO: renamed from: e4b.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C5740b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f471033a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Message.Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Message.Type.STICKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f471033a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public b() {
        this.f471029b = ListMode.NORMAL;
        this.f471031d = new CopyOnWriteArrayList();
    }

    @Override // e4b.a
    public final ListMode o() {
        return this.f471029b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        Intrinsics.checkNotNullParameter(r100, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r101 = this.f471028a;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r101 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r103 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r101.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r103 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.a r104 = r103.getAdapter();
    L9:
        if (r104 == null) goto L20;
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r105 = new MessageListMultiSelectFeature$initMultiSelector$multiSelector$1(r104, this);
        this.f471030c = r105;
        r105.f448176e = new c(this, r105);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r106 = this.f471028a;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L15:
        d r107 = r102.a();
        if (r107 == null) goto L19;
        r107.u8(r105);
        return;
    L19:
        return;
    L14:
        r102 = r106;
        goto L15
    L20:
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f471028a = r100;
    }

    @Override // e4b.a
    public final boolean E(y6b.c<?> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "message");
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r100 = this.f471030c;
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f448175d == true) goto L8;
        return false;
    L8:
        List<j> r102 = this.f471031d;
        if ((r102 instanceof Collection) == true) goto L11;
    L13:
        Iterator r103 = ((CopyOnWriteArrayList) r102).iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        if (((j) r103.next()).a() == false) goto L15;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L23;
    L117:
        return true;
    L23:
        if (lpc.a.d(r110) == false) goto L101;
        Message.Type r105 = r110.getType();
        int r106 = C5740b.f471033a[r105.ordinal()];
        if (r106 == 1) goto L34;
        if (r106 == 2) goto L33;
        if (r106 == 3) goto L32;
        if (r106 == 4) goto L31;
        ResourceType r107 = ResourceType.FILE;
    L35:
        ResourceCleanScene r112 = lpc.a.b(r110);
        y6b.b r113 = r110.f566508t;
        if (r113 == null) goto L38;
        String r114 = r113.f566474w;
    L39:
        acc.d r115 = new acc.d(r107, r112, acc.a.d(r114));
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r108 = this.f471028a;
        if (r108 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r108 = null;
    L42:
        Context r109 = r108.getContext();
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "params");
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "params");
        ResourceCleanScene r116 = r115.f2928b;
        ResourceType r117 = r115.getType();
        if (r116 != null) goto L59;
        if (r115.f2929c == false) goto L47;
        String r118 = UIUtils.getString(r109, R.string.Lark_IM_ContentCleanedCantSelect_Toast);
    L57:
        Intrinsics.checkNotNull(r118);
    L100:
        UICallbackExecutor.execute(new acc.c(r109, r118));
        r101 = true;
        goto L101
    L47:
        int r119 = acc.a.C0053a.f2916a[r117.ordinal()];
        if (r119 == 1) goto L56;
        if (r119 == 2) goto L56;
        if (r119 == 3) goto L55;
        if (r119 != 4) goto L54;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_FileCleanedByOtherAdminCantSelect_Toast);
        goto L57
    L54:
        throw new NoWhenBranchMatchedException();
    L55:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_VideoCleanedByOtherAdminCantSelect_Toast);
    L56:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_ImageCleanedByOtherAdminCantSelect_Toast);
        goto L57
    L59:
        if (r116.isUnifiedRegularDelete() == false) goto L87;
        if (r116.isPersonalDelete() == false) goto L73;
        int r120 = acc.a.C0053a.f2916a[r117.ordinal()];
        if (r120 == 1) goto L71;
        if (r120 == 2) goto L71;
        if (r120 == 3) goto L70;
        if (r120 != 4) goto L69;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_FileCleanedCantSelect_Toast);
    L85:
        Intrinsics.checkNotNull(r118);
        goto L100
    L69:
        throw new NoWhenBranchMatchedException();
    L70:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_VideoCleanedCantSelect_Toast);
    L71:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_ImageCleanedCantSelect_Toast);
        goto L85
    L73:
        if (r115.f2929c == false) goto L75;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_ContentCleanedCantSelect_Toast);
        goto L85
    L75:
        int r121 = acc.a.C0053a.f2916a[r117.ordinal()];
        if (r121 == 1) goto L84;
        if (r121 == 2) goto L84;
        if (r121 == 3) goto L83;
        if (r121 != 4) goto L82;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_FileCleanedByOtherAdminCantSelect_Toast);
        goto L85
    L82:
        throw new NoWhenBranchMatchedException();
    L83:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_VideoCleanedByOtherAdminCantSelect_Toast);
    L84:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_ImageCleanedByOtherAdminCantSelect_Toast);
        goto L85
    L87:
        if (r116.isCSAMDelete() == false) goto L89;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_FileRemovedByPolicy_Toast);
        goto L100
    L89:
        int r122 = acc.a.C0053a.f2916a[r117.ordinal()];
        if (r122 == 1) goto L98;
        if (r122 == 2) goto L98;
        if (r122 == 3) goto L97;
        if (r122 != 4) goto L96;
        r118 = UIUtils.getString(r109, R.string.Lark_IM_FileCleanedCantSelect_Toast);
    L99:
        Intrinsics.checkNotNull(r118);
        goto L100
    L96:
        throw new NoWhenBranchMatchedException();
    L97:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_VideoCleanedCantSelect_Toast);
    L98:
        r118 = UIUtils.getString(r109, R.string.Lark_IM_ImageCleanedCantSelect_Toast);
        goto L99
    L38:
        r114 = null;
        goto L39
    L31:
        r107 = ResourceType.FILE;
        goto L35
    L32:
        r107 = ResourceType.STICKER;
        goto L35
    L33:
        r107 = ResourceType.IMAGE;
        goto L35
    L34:
        r107 = ResourceType.VIDEO;
    L101:
        if (r101 == true) goto L117;
        if (r100.b(r110) == false) goto L117;
        String r123 = r110.f566482c;
        List<String> r124 = this.f471032e;
        if (r124 == null) goto L109;
        TypeIntrinsics.asMutableCollection(r124).remove(r123);
    L109:
        if (r100.f448173b.containsKey(Integer.valueOf(r110.hashCode())) == false) goto L111;
    L116:
        r100.d(r111);
        goto L117
    L111:
        if (r100.f448173b.size() < 100) goto L116;
        String r125 = UIHelper.getString(R.string.Lark_Legacy_MultiSelectTooManyMessagesTips);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r126 = this.f471028a;
        if (r126 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r126 = null;
    L115:
        com.larksuite.component.ui.dialog.d r127 = new com.larksuite.component.ui.dialog.d(r126.getContext());
        r127.k(r125);
        r127.f284132c.titleBold(true);
        r127.f284132c.titleLineCount(2);
        r127.b(R.id.lkui_dialog_btn_right, UIHelper.getString(R.string.Lark_Legacy_ShareAlertOK), null);
        l7b.a.a(r127.i());
    L19:
        r104 = false;
        goto L20
    L11:
        if (((CopyOnWriteArrayList) r102).isEmpty() == false) goto L13;
        goto L13
    }
}
