package z7c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.customfields.CustomFieldOptionSelectAdapter;
import com.ss.android.lark.todo.impl.features.detail.widget.MaxHeightRecyclerView;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SelectFieldOption> f570760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<SelectFieldOption> f570761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f570762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f570763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.a f570764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f570765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f570766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MaxHeightRecyclerView f570767h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f570769b;

        public a(f r100) {
            this.f570769b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570768a;
            long r102 = System.currentTimeMillis();
            this.f570768a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570769b.getMDialog();
            if (r103 == null) goto L24;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r105 == null) goto L21;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L10:
            if (Looper.myLooper() == r104.getLooper()) goto L12;
            r104.post(DialogLancet.createDismissRunnable(r103));
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return R.layout.detail_custom_field_option_dialog_root;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        TextView r101 = null;
        if (r100 == null) goto L5;
        ImageView r102 = (ImageView) r100.findViewById(R.id.close_icon);
    L6:
        this.f570765f = r102;
        if (r100 == null) goto L9;
        View r103 = r100.findViewById(R.id.empty_view_option);
    L10:
        this.f570766g = r103;
        if (r100 == null) goto L13;
        MaxHeightRecyclerView r104 = (MaxHeightRecyclerView) r100.findViewById(R.id.rv_option);
    L14:
        this.f570767h = r104;
        if (r104 == null) goto L17;
        r104.setMaxHeight((UIHelper.getDimens(R.dimen.dp_48) * 6) + UIHelper.getDimens(R.dimen.dp_24));
    L17:
        if (r100 == null) goto L19;
        r101 = (TextView) r100.findViewById(R.id.option_dialog_title);
    L19:
        if (r101 == null) goto L21;
        r101.setText(getMTitle());
    L21:
        ImageView r105 = this.f570765f;
        if (r105 == null) goto L24;
        r105.setOnClickListener(new a(this));
    L24:
        List<SelectFieldOption> r106 = this.f570760a;
        if (r106 != null) goto L27;
    L30:
        boolean r107 = true;
    L31:
        if (r107 == false) goto L38;
        View r108 = this.f570766g;
        if (r108 == null) goto L35;
        com.larksuite.framework.section.utils.a.d(r108, true);
    L35:
        MaxHeightRecyclerView r109 = this.f570767h;
        if (r109 == null) goto L50;
        com.larksuite.framework.section.utils.a.d(r109, false);
    L50:
        return r100;
    L38:
        View r110 = this.f570766g;
        if (r110 == null) goto L41;
        com.larksuite.framework.section.utils.a.d(r110, false);
    L41:
        MaxHeightRecyclerView r111 = this.f570767h;
        if (r111 == null) goto L44;
        com.larksuite.framework.section.utils.a.d(r111, true);
    L44:
        LinearLayoutManager r112 = new LinearLayoutManager(getContext());
        r112.setOrientation(1);
        MaxHeightRecyclerView r113 = this.f570767h;
        if (r113 == null) goto L47;
        r113.setLayoutManager(r112);
    L47:
        MaxHeightRecyclerView r114 = this.f570767h;
        if (r114 == null) goto L50;
        r114.setAdapter(new CustomFieldOptionSelectAdapter(this.f570763d, this.f570761b, this.f570760a, this.f570762c, new g(this)));
        goto L50
    L27:
        if (r106.isEmpty() == true) goto L30;
        r107 = false;
        goto L31
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570760a = CollectionsKt.emptyList();
        this.f570761b = new ArrayList();
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof e) == false) goto L7;
        super.apply(r100, r101);
        e r102 = (e) r100;
        this.f570760a = r102.f570755a;
        this.f570761b = new ArrayList(r102.f570756b);
        this.f570762c = r102.f570757c;
        this.f570763d = r102.f570758d;
        this.f570764e = r102.f570759e;
        return;
    L7:
        throw new IllegalArgumentException("builder should be CustomFieldOptionDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
