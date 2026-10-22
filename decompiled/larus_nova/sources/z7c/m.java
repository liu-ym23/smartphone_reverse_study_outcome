package z7c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskSectionSelectAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class m extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<TaskSection> f570786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f570787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l.a f570788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f570789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f570790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f570791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f570792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f570793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f570794i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f570795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f570796b;

        public a(m r100) {
            this.f570796b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f570795a;
            long r102 = System.currentTimeMillis();
            this.f570795a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            UDDialog r103 = this.f570796b.getMDialog();
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
        return R.layout.detail_task_list_section_dialog_root;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        if (r100 == null) goto L5;
        ImageView r101 = (ImageView) r100.findViewById(R.id.close_icon);
    L6:
        this.f570791f = r101;
        if (r100 == null) goto L9;
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.section_recycler);
    L10:
        this.f570792g = r102;
        if (r100 == null) goto L13;
        TextView r103 = (TextView) r100.findViewById(R.id.search_text);
    L14:
        this.f570793h = r103;
        if (r100 == null) goto L17;
        TextView r104 = (TextView) r100.findViewById(R.id.owned_section_title);
    L18:
        if (r104 == null) goto L20;
        com.larksuite.framework.section.utils.a.d(r104, this.f570790e);
    L20:
        TextView r105 = this.f570793h;
        if (r105 == null) goto L23;
        r105.setText("");
    L23:
        this.f570794i = "";
        LinearLayoutManager r106 = new LinearLayoutManager(getContext());
        r106.setOrientation(1);
        RecyclerView r107 = this.f570792g;
        if (r107 == null) goto L26;
        r107.setLayoutManager(r106);
    L26:
        RecyclerView r108 = this.f570792g;
        if (r108 == null) goto L33;
        String r109 = this.f570787b;
        List<TaskSection> r110 = this.f570786a;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        r111.add(new l8c.a((TaskSection) r112.next(), false));
        goto L30
    L32:
        r108.setAdapter(new DetailTaskSectionSelectAdapter(r109, r111, new n(this)));
    L33:
        Drawable r113 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_search_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n2), new UDDimension.b(16));
        TextView r114 = this.f570793h;
        if (r114 == null) goto L36;
        r114.setCompoundDrawables(r113, null, null, null);
    L36:
        TextView r115 = this.f570793h;
        if (r115 == null) goto L39;
        r115.addTextChangedListener(new o(this));
    L39:
        ImageView r116 = this.f570791f;
        if (r116 == null) goto L42;
        r116.setOnClickListener(new a(this));
    L42:
        return r100;
    L17:
        r104 = null;
        goto L18
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570786a = CollectionsKt.emptyList();
        this.f570787b = "";
        this.f570789d = "";
        this.f570794i = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof l) == false) goto L7;
        super.apply(r100, r101);
        l r102 = (l) r100;
        this.f570786a = r102.f570781a;
        this.f570787b = r102.f570782b;
        this.f570788c = r102.f570783c;
        this.f570789d = r102.f570784d;
        this.f570790e = r102.f570785e;
        return;
    L7:
        throw new IllegalArgumentException("builder should be SectionListSelectDialogController, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }

    public final void b(List<TaskSection> r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "sections");
        Intrinsics.checkNotNullParameter(r111, "selectSectionId");
        this.f570787b = r111;
        this.f570786a = r110;
        ArrayList r112 = new ArrayList();
        String r100 = this.f570794i;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        List<TaskSection> r101 = this.f570786a;
    L15:
        Iterator<T> r102 = r101.iterator();
    L17:
        if (r102.hasNext() == false) goto L20;
        r112.add(new l8c.a((TaskSection) r102.next(), false));
        goto L17
    L20:
        if (TextUtils.isEmpty(this.f570794i) == true) goto L22;
        r112.add(new l8c.a(new TaskSection.Builder().name(this.f570794i).build(), true));
    L22:
        RecyclerView r103 = this.f570792g;
        DetailTaskSectionSelectAdapter r104 = null;
        if (r103 == null) goto L25;
        RecyclerView.Adapter r105 = r103.getAdapter();
    L27:
        if ((r105 instanceof DetailTaskSectionSelectAdapter) == false) goto L29;
        r104 = (DetailTaskSectionSelectAdapter) r105;
    L29:
        if (r104 == null) goto L38;
        String r106 = this.f570794i;
        Intrinsics.checkNotNullParameter(r112, "data");
        Intrinsics.checkNotNullParameter(r111, "selectSectionId");
        Intrinsics.checkNotNullParameter(r106, "queryKey");
        r104.f443481b = r112;
        r104.f443480a = r111;
        r104.f443483d = r106;
        r104.notifyDataSetChanged();
        return;
    L38:
        return;
    L25:
        r105 = null;
        goto L27
    L5:
        List<TaskSection> r107 = this.f570786a;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r107.iterator();
    L7:
        if (r114.hasNext() == false) goto L14;
        Object r115 = r114.next();
        if (StringsKt.indexOf$default(((TaskSection) r115).name, r100, 0, false, 6, null) == (-1)) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L7;
        r113.add(r115);
        goto L7
    L11:
        r108 = false;
        goto L12
    L14:
        r101 = r113;
        goto L15
    }
}
