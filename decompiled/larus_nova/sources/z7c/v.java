package z7c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u.a f570842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f570843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f570844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f570845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f570846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f570847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f570848g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f570850b;

        public b(v r100) {
            this.f570850b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570849a;
            long r102 = System.currentTimeMillis();
            this.f570849a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570850b.getMDialog();
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

    static {
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return R.layout.detail_task_list_dialog_root;
    }

    public final void initView() {
        RecyclerView r100 = this.f570844c;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f570848g = "";
        Drawable r101 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_search_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n2), new UDDimension.Dp(16));
        TextView r102 = this.f570843b;
        if (r102 == null) goto L8;
        r102.setCompoundDrawables(r101, null, null, null);
    L8:
        b(true);
        TextView r103 = this.f570843b;
        if (r103 == null) goto L11;
        r103.addTextChangedListener(new x(this));
    L11:
        LinearLayoutManager r104 = new LinearLayoutManager(getContext());
        r104.setOrientation(1);
        RecyclerView r105 = this.f570844c;
        if (r105 == null) goto L14;
        r105.setLayoutManager(r104);
    L14:
        RecyclerView r106 = this.f570844c;
        if (r106 == null) goto L17;
        DetailTaskListSelectAdapter r107 = new DetailTaskListSelectAdapter();
        r107.f443478c = new w(this);
        r106.setAdapter(r107);
    L17:
        KeyboardUtils.showKeyboard(this.f570843b);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = (TextView) r100.findViewById(R.id.search_text);
    L6:
        this.f570843b = r102;
        if (r100 == null) goto L9;
        RecyclerView r103 = (RecyclerView) r100.findViewById(R.id.task_list_recycler);
    L10:
        this.f570844c = r103;
        if (r100 == null) goto L13;
        ImageView r104 = (ImageView) r100.findViewById(R.id.loading_image);
    L14:
        this.f570845d = r104;
        if (r100 == null) goto L17;
        ImageView r105 = (ImageView) r100.findViewById(R.id.close_icon);
    L18:
        this.f570846e = r105;
        if (r100 == null) goto L21;
        r101 = (ViewGroup) r100.findViewById(R.id.empty_container);
    L21:
        this.f570847f = r101;
        ImageView r106 = this.f570846e;
        if (r106 == null) goto L24;
        r106.setOnClickListener(new b(this));
    L24:
        initView();
        return r100;
    L17:
        r105 = null;
        goto L18
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

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController, com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public final void onDismiss() {
        super.onDismiss();
        TextView r100 = this.f570843b;
        IBinder r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.getContext();
        if (r102 == null) goto L7;
        Object r103 = r102.getSystemService("input_method");
    L9:
        if ((r103 instanceof InputMethodManager) == false) goto L11;
        InputMethodManager r104 = (InputMethodManager) r103;
    L12:
        if (r104 == null) goto L18;
        TextView r105 = this.f570843b;
        if (r105 == null) goto L16;
        r101 = r105.getWindowToken();
    L16:
        r104.hideSoftInputFromWindow(r101, 0);
        return;
    L18:
        return;
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    public v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570848g = "";
    }

    public final void b(boolean r100) {
        ImageView r101 = this.f570845d;
        if (r101 == null) goto L5;
        com.larksuite.framework.section.utils.a.d(r101, r100);
    L5:
        if (r100 == false) goto L9;
        ImageView r102 = this.f570845d;
        if (r102 == null) goto L13;
        RotateAnimation r103 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r103.setDuration(400);
        r103.setInterpolator(new LinearInterpolator());
        r103.setRepeatCount(-1);
        r103.setRepeatMode(1);
        r102.startAnimation(r103);
        return;
    L13:
        return;
    L9:
        ImageView r104 = this.f570845d;
        if (r104 == null) goto L15;
        r104.clearAnimation();
        return;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof u) == false) goto L7;
        super.apply(r100, r101);
        this.f570842a = ((u) r100).f570841a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be TaskListSelectDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
