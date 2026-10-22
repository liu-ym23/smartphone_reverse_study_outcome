package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.util.UDDividerItemDecoration;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class UDListDialogController extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnItemClickListener f284862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<UDBaseListDialogBuilder.ListItem> f284863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDBaseListDialogAdapter f284868g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "", "onItemClick", "", "index", "", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(int r100);
    }

    public static final class a implements OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDListDialogController f284869a;

        public a(UDListDialogController r100) {
            this.f284869a = r100;
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            if (this.f284869a.getMAutoDismiss() == false) goto L23;
            UDDialog r101 = this.f284869a.getMDialog();
            if (r101 == null) goto L23;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r101);
            goto L23
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r103 == null) goto L20;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L9:
            if (Looper.myLooper() == r102.getLooper()) goto L11;
            r102.post(DialogLancet.createDismissRunnable(r101));
        L23:
            OnItemClickListener r104 = this.f284869a.f284862a;
            if (r104 == null) goto L30;
            r104.onItemClick(r100);
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.ud_action_panel_default_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultFooterRes() {
        return R.layout.ud_action_panel_default_footer;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultHeaderRes() {
        setHeaderLayoutDefault$universe_ui_dialog_release(true);
        return R.layout.ud_action_panel_default_header;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public int getDefaultRootRes() {
        return R.layout.ud_action_panel_default_root;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View createView() {
        View r100 = super.createView();
        if (isHeaderVisible$universe_ui_dialog_release() == true) goto L8;
        if (r100 == null) goto L8;
        View r101 = r100.findViewById(R.id.ud_action_panel_header_divider);
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        return r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View onCreateContent() {
        View r100 = getFinalView(getMContentLayout(), getMContentLayoutRes(), R.layout.ud_action_panel_default_content);
        UDBaseListDialogAdapter r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.ud_action_panel_list_rv);
        if (r102 == null) goto L15;
        UDBaseListDialogAdapter r103 = this.f284868g;
        if (r103 == null) goto L14;
        int r104 = this.f284867f;
        if (r104 != (-1)) goto L13;
        r104 = R.layout.ud_action_panel_default_item;
    L13:
        r103.f284845d = r104;
        r103.A2(this.f284863b);
        r103.f284844c = new a(this);
        r103.f284848g = this.f284866e;
        r103.f284847f = this.f284865d;
        r103.f284846e = this.f284864c;
        r103.f284849h = !TextUtils.isEmpty(getMTitle());
        r101 = r103;
    L14:
        r102.setAdapter(r101);
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
        UDDividerItemDecoration r105 = new UDDividerItemDecoration();
        Drawable r106 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_divider_action_panel_item);
        Intrinsics.checkNotNullParameter(r106, "drawable");
        r105.f285482a = r106;
        r105.f285485d = false;
        r102.addItemDecoration(r105);
    L15:
        return r100;
    }

    public UDListDialogController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284863b = new ArrayList();
        this.f284864c = -1;
        this.f284865d = -1;
        this.f284866e = -1;
        this.f284867f = -1;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof UDBaseListDialogBuilder) == false) goto L10;
        super.apply(r100, r101);
        UDBaseListDialogBuilder r102 = (UDBaseListDialogBuilder) r100;
        this.f284862a = r102.getMItemClickListener$universe_ui_dialog_release();
        this.f284863b = r102.getMItems$universe_ui_dialog_release();
        this.f284864c = r102.getMItemTextSize$universe_ui_dialog_release();
        this.f284865d = r102.getMItemTextColorRes$universe_ui_dialog_release();
        this.f284866e = r102.getMItemHeight$universe_ui_dialog_release();
        this.f284867f = r102.getMItemLayoutRes$universe_ui_dialog_release();
        UDBaseListDialogAdapter r103 = r102.getMAdapter$universe_ui_dialog_release();
        if (r103 != null) goto L7;
        r103 = new UDBaseListDialogAdapter(getContext());
    L7:
        this.f284868g = r103;
        return;
    L10:
        throw new IllegalArgumentException("builder should be UDBaseListDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
