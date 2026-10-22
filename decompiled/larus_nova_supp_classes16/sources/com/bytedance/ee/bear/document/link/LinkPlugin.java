package com.bytedance.ee.bear.document.link;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.pageedit.PageEditPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.q0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/link/LinkPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "urlRegex", "Lkotlin/text/Regex;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "showLinkDialog", "data", "Lcom/bytedance/ee/bear/document/link/LinkData;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "trackContextMenuEvent", "id", "", "isLink", "", "input", "isCanCopy", "linkData", "ShowDialogHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String EventDocsBubbleToolBarClick = "ccm_doc_mobile_bubble_toolbar_click";
    private static final String EventDocsLinkEditDialog = "ccm_doc_mobile_link_edit_page_view";
    private static final String EventDocsLinkEditDialogClick = "ccm_doc_mobile_link_edit_page_click";
    private static final String TAG = "LinkPlugin";
    private final Regex urlRegex;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<LinkData> {
        public final /* synthetic */ LinkPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(LinkPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            LinkPlugin r0 = this.a;
            LinkPlugin.access$showLinkDialog(r0, (LinkData) r2, r3);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LinkDataType.values().length];
            r0[LinkDataType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LinkDataType.EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements LinkEditText.a {
        public final /* synthetic */ LinkPlugin a;
        public final /* synthetic */ LinkData b;

        @Override // com.bytedance.ee.bear.document.link.LinkEditText.a
        public final boolean a(int r3) {
            LinkPlugin.access$trackContextMenuEvent(this.a, r3);
            switch(r3) {
                case 16908320: goto L6;
                case 16908321: goto L6;
                default: goto L4;
            };
        L4:
            return false;
        L6:
            if (LinkPlugin.access$isCanCopy(this.a, this.b) == false) goto L8;
            return false;
        L8:
            Toast.showFailureText(LinkPlugin.access$getContext(this.a), LinkPlugin.access$getContext(this.a).getString(2131887613));
            return true;
        }

        public d(LinkPlugin r1, LinkData r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements LinkEditText.a {
        public final /* synthetic */ LinkPlugin a;

        public e(LinkPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.link.LinkEditText.a
        public final boolean a(int r2) {
            LinkPlugin.access$trackContextMenuEvent(this.a, r2);
            return false;
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkDataType a;
        public final /* synthetic */ LinkEditText b;
        public final /* synthetic */ LinkEditText c;
        public final /* synthetic */ m d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LinkDataType.values().length];
                r0[LinkDataType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[LinkDataType.EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public f(LinkDataType r1, LinkEditText r2, LinkEditText r3, m r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            Pair[] r0 = new Pair[2];
            r0[0] = TuplesKt.to("click", TipCallBackData.CONFIRM);
            LinkDataType r1 = this.a;
            if (r1 != null) goto L5;
            int r2 = -1;
        L7:
            if (r2 == 1) goto L12;
            if (r2 != 2) goto L11;
            String r7 = "edit_link";
        L13:
            r0[1] = TuplesKt.to("view_type", r7);
            r6.n(LinkPlugin.EventDocsLinkEditDialogClick, MapsKt.mapOf(r0));
            JSONObject r8 = new JSONObject();
            r8.put("success", Boolean.TRUE);
            Editable r9 = this.b.getText();
            String r3 = "";
            if (r9 == null) goto L17;
            String r10 = r9.toString();
            if (r10 == null) goto L17;
        L18:
            r8.put("text", r10);
            Editable r11 = this.c.getText();
            if (r11 == null) goto L24;
            String r12 = r11.toString();
            if (r12 == null) goto L24;
            r3 = r12;
        L24:
            r8.put("url", r3);
            this.d.b(r8);
            return;
        L17:
            r10 = "";
            goto L18
        L11:
            throw new NoWhenBranchMatchedException();
        L12:
            r7 = "add_link";
            goto L13
        L5:
            r2 = a.a[r1.ordinal()];
            goto L7
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkDataType a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LinkDataType.values().length];
                r0[LinkDataType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[LinkDataType.EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public g(LinkDataType r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            Pair[] r0 = new Pair[2];
            r0[0] = TuplesKt.to("click", "cancel");
            LinkDataType r1 = this.a;
            if (r1 != null) goto L5;
            int r2 = -1;
        L7:
            if (r2 == 1) goto L12;
            if (r2 != 2) goto L11;
            String r7 = "edit_link";
        L13:
            r0[1] = TuplesKt.to("view_type", r7);
            r6.n(LinkPlugin.EventDocsLinkEditDialogClick, MapsKt.mapOf(r0));
            return;
        L11:
            throw new NoWhenBranchMatchedException();
        L12:
            r7 = "add_link";
            goto L13
        L5:
            r2 = a.a[r1.ordinal()];
            goto L7
        }
    }

    public static final class h implements UDBaseDialogBuilder.c {
        public final /* synthetic */ Ref.ObjectRef<LinkEditText> a;
        public final /* synthetic */ LinkDataType b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LinkDataType.values().length];
                r0[LinkDataType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[LinkDataType.EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final void beforeCreate(UDDialog r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
        }

        public final void a(UDDialog r3) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            SpaceEditText r4 = (LinkEditText) this.a.element;
            if (r4 == null) goto L5;
            r4.requestFocus();
        L5:
            com.bytedance.ee.bear.contract.d r5 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            LinkDataType r0 = this.b;
            if (r0 != null) goto L8;
            int r1 = -1;
        L10:
            if (r1 != 1) goto L12;
            String r2 = "add_link";
        L17:
            r5.n(LinkPlugin.EventDocsLinkEditDialog, MapsKt.mapOf(TuplesKt.to("view_type", r2)));
            return;
        L12:
            if (r1 != 2) goto L15;
            r2 = "edit_link";
            goto L17
        L15:
            throw new NoWhenBranchMatchedException();
        L8:
            r1 = a.a[r0.ordinal()];
            goto L10
        }

        public h(Ref.ObjectRef<LinkEditText> r1, LinkDataType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i extends q0 {
        public final /* synthetic */ Button a;
        public final /* synthetic */ LinkPlugin b;

        public final void afterTextChanged(Editable r3) {
            Button r0 = this.a;
            if (r0 == null) goto L11;
            LinkPlugin r1 = this.b;
            if (r3 == null) goto L8;
            String r4 = r3.toString();
            if (r4 == null) goto L8;
        L9:
            r0.setEnabled(LinkPlugin.access$isLink(r1, r4));
            return;
        L8:
            r4 = "";
            goto L9
        }

        public i(Button r1, LinkPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public LinkPlugin() {
        tt5.a.h(TAG, "LinkPlugin init");
        String r1 = av5.a.a;
        this.urlRegex = new Regex(av5.a.a, RegexOption.IGNORE_CASE);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_link_LinkPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ Context access$getContext(LinkPlugin r0) {
        return r0.getContext();
    }

    private final boolean isCanCopy(LinkData r3) {
        StringBuilder r0 = new StringBuilder("isCanCopy use srcObjToken?=");
        if (r3 == null) goto L5;
        String r1 = r3.getSrcObjToken();
    L6:
        r0.append(du5.b.i(r1));
        tt5.a.h(TAG, r0.toString());
        DocumentInfo r2 = (DocumentInfo) ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().getValue();
        if (r2 == null) goto L18;
        if (r3 == null) goto L11;
        String r4 = r3.getSrcObjToken();
        if (r4 == null) goto L11;
    L12:
        IDocUserPermission r5 = r2.getDocPermissionByToken(r4);
        if (r5 != null) goto L15;
        return false;
    L15:
        if (r5.canCopy() != true) goto L20;
        return true;
    L20:
        return false;
    L11:
        r4 = "";
        goto L12
    L18:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    private final boolean isLink(String r2) {
        return this.urlRegex.matches(r2);
    }

    private final void trackContextMenuEvent(int r7) {
        switch(r7) {
            case 16908319: goto L8;
            case 16908320: goto L7;
            case 16908321: goto L6;
            case 16908322: goto L5;
            default: goto L4;
        };
    L4:
        String r8 = null;
    L9:
        if (r8 == null) goto L12;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n(EventDocsBubbleToolBarClick, MapsKt.mapOf(new Pair[]{TuplesKt.to("click", "block_action"), TuplesKt.to("target", "none"), TuplesKt.to("action_type", r8), TuplesKt.to("action_value", null), TuplesKt.to("object_block_data", null), TuplesKt.to("trigger_type", null), TuplesKt.to("object_block_extra_value", null)}));
        return;
    L12:
        return;
    L5:
        r8 = "paste";
        goto L9
    L6:
        r8 = "copy";
        goto L9
    L7:
        r8 = "cut";
        goto L9
    L8:
        r8 = "selectAll";
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        tt5.a.h(TAG, "LinkPlugin getBridgeHandlers");
        r3.put("biz.util.addOrEditHyperLink", new b(this));
    }

    public static final /* synthetic */ boolean access$isCanCopy(LinkPlugin r0, LinkData r1) {
        return r0.isCanCopy(r1);
    }

    public static final /* synthetic */ boolean access$isLink(LinkPlugin r0, String r1) {
        return r0.isLink(r1);
    }

    public static final /* synthetic */ void access$trackContextMenuEvent(LinkPlugin r0, int r1) {
        r0.trackContextMenuEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.widget.EditText, com.bytedance.ee.bear.document.link.LinkEditText] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, android.widget.EditText, com.bytedance.ee.bear.document.link.LinkEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v19 */
    private final void showLinkDialog(LinkData r12, m r13) {
        if (r12 == null) goto L5;
        String r1 = r12.getType();
    L7:
        if (r1 != null) goto L11;
        tt5.a.d(TAG, "LinkData type is null. " + r12);
        return;
    L11:
        if (Intrinsics.areEqual(r1, PageEditPlugin.ADD) == false) goto L14;
        LinkDataType r2 = LinkDataType.ADD;
    L17:
        if (r2 != null) goto L20;
        tt5.a.d(TAG, "LinkData type error. " + r12);
        return;
    L20:
        View r0 = LayoutInflater.from(getContext()).inflate(2131560128, null);
        ?? r3 = (LinkEditText) r0.findViewById(2131371816);
        ?? r4 = (LinkEditText) r0.findViewById(2131371817);
        r3.setDisableUrlStyle(true);
        r3.setText(r12.getText());
        r4.setText(r12.getUrl());
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        int[] r6 = c.a;
        int r7 = r6[r2.ordinal()];
        if (r7 == 1) goto L40;
        if (r7 != 2) goto L39;
        r3.setEnabled(true);
        String r8 = r12.getText();
        if (r8 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == false) goto L33;
    L35:
        ?? r10 = r3;
    L37:
        r5.element = r10;
    L50:
        int r11 = r6[r2.ordinal()];
        if (r11 == 1) goto L56;
        if (r11 != 2) goto L55;
        int r14 = 2131889350;
    L57:
        Context r16 = getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        UDDialogBuilder r17 = new UDDialogBuilder(r16);
        r17.autoDismiss(true);
        r17.title(r14);
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "value");
        r17.contentLayout(r0);
        r17.autoDismiss(true);
        r17.cancelOnTouchOutside(false);
        r17.cancelable(true);
        r17.addActionButton(2131391777, 2131889348, new f(r2, r3, r4, r13));
        r17.addActionButton(2131391778, 2131889347, new g(r2));
        h r18 = new h(r5, r2);
        Intrinsics.checkNotNullParameter(r18, "callback");
        r17.lifecycleCallback(r18);
        UDDialog r19 = r17.build();
        Window r20 = r19.getWindow();
        if (r20 == null) goto L60;
        r20.setSoftInputMode(4);
    L60:
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_link_LinkPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r19);
        KeyboardUtils.showKeyboard(r4);
        Button r110 = (Button) r19.findViewById(2131391777);
        if (r110 == null) goto L66;
        String r21 = r12.getUrl();
        if (r21 != null) goto L65;
        r21 = "";
    L65:
        r110.setEnabled(isLink(r21));
    L66:
        r4.addTextChangedListener(new i(r110, this));
        r3.setCallback(new d(this, r12));
        r4.setCopySecurityEnable(false);
        r4.setCallback(new e(this));
        r3.setSingleLine(true);
        r4.setSingleLine(true);
        return;
    L55:
        throw new NoWhenBranchMatchedException();
    L56:
        r14 = 2131889346;
        goto L57
    L33:
        if (Intrinsics.areEqual(r12.getText(), r12.getUrl()) == false) goto L36;
        r3.selectAll();
        goto L35
    L36:
        r10 = r4;
        goto L37
    L26:
        if (r8.length() == 0) goto L29;
        r9 = false;
        goto L30
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        String r22 = r12.getText();
        if (r22 != null) goto L43;
    L46:
        boolean r23 = true;
    L47:
        if (r23 == false) goto L49;
        r3.setEnabled(true);
        r5.element = r4;
        goto L50
    L49:
        r3.setEnabled(false);
        r3.setTextColor(ContextCompat.getColor(getContext(), 2131106620));
        r5.element = r4;
        goto L50
    L43:
        if (r22.length() == 0) goto L46;
        r23 = false;
        goto L47
    L14:
        if (Intrinsics.areEqual(r1, JSEventListener.ACTION_EDIT) == false) goto L16;
        r2 = LinkDataType.EDIT;
        goto L17
    L16:
        r2 = null;
        goto L17
    L5:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ void access$showLinkDialog(LinkPlugin r0, LinkData r1, m r2) {
        r0.showLinkDialog(r1, r2);
    }
}
