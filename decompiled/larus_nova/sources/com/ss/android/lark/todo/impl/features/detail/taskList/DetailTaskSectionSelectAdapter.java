package com.ss.android.lark.todo.impl.features.detail.taskList;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l8c.d;
import l8c.e;
import l8c.f;
import z7c.n;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J$\u0010\u0018\u001a\u00020\u00132\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter$ViewHolder;", "selectSectionId", "", "data", "", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailSectionSelectItem;", "listener", "Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter$ISectionSelectListener;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter$ISectionSelectListener;)V", "queryKey", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "updateData", "ISectionSelectListener", "ViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetailTaskSectionSelectAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f443480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<l8c.a> f443481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f443482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f443483d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/taskList/DetailTaskSectionSelectAdapter;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443484a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443484a = r100;
        }
    }

    public interface a {
        void a(String r100);

        void b(String r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443481b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        l8c.a r101 = (l8c.a) CollectionsKt.getOrNull(this.f443481b, r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (r101.f508077b != true) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        l8c.a r113 = (l8c.a) ListProtector.get(this.f443481b, r111);
        if (r113.f508077b == false) goto L5;
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        i r101 = i.f444291a;
        r100.append(r101.g(R.string.Todo_CreateSectionName_Button));
        int r102 = r100.length();
        r100.append(" " + r113.f508076a.name);
        final int r103 = r101.a(R.color.text_title);
        r100.setSpan(new AnonymousClass3(r103), r102, r100.length(), 33);
        ((TextView) r112.f443484a.findViewById(R.id.create_text)).setText(r100);
        r112.f443484a.findViewById(R.id.create_container).setOnClickListener(new f(this, r113));
        r112.f443484a.findViewById(R.id.divide_line).setVisibility(8);
        return;
    L5:
        if (TextUtils.isEmpty(StringsKt.trim(r113.f508076a.name).toString()) == true) goto L8;
        String r104 = StringsKt.trim(r113.f508076a.name).toString();
    L11:
        TextView r105 = (TextView) r112.f443484a.findViewById(R.id.section_name);
        if (Intrinsics.areEqual(this.f443480a, r113.f508076a.guid) == false) goto L14;
        int r106 = i.f444291a.a(R.color.primary_fill_default);
    L15:
        r105.setTextColor(r106);
        SpannableString r107 = new SpannableString(r104);
        if (Intrinsics.areEqual(this.f443480a, r113.f508076a.guid) == false) goto L18;
    L23:
        ((TextView) r112.f443484a.findViewById(R.id.section_name)).setText(r107);
        com.larksuite.framework.section.utils.a.d(r112.f443484a.findViewById(R.id.section_select_check), Intrinsics.areEqual(this.f443480a, r113.f508076a.guid));
        r112.f443484a.findViewById(R.id.section_name).setOnClickListener(new d(this, r113));
        r112.f443484a.findViewById(R.id.section_select_check).setOnClickListener(new e(this, r113));
        return;
    L18:
        if (TextUtils.isEmpty(this.f443483d) == true) goto L23;
        int r108 = StringsKt.indexOf$default(r107, this.f443483d, 0, false, 4, null);
    L21:
        if (r108 == (-1)) goto L23;
        r107.setSpan(new ForegroundColorSpan(i.f444291a.a(R.color.primary_fill_default)), r108, this.f443483d.length() + r108, 33);
        String r109 = this.f443483d;
        r108 = StringsKt.indexOf$default(r107, r109, r108 + r109.length(), false, 4, null);
        goto L21
    L14:
        r106 = i.f444291a.a(R.color.text_title);
        goto L15
    L8:
        if (r113.f508076a.is_default.booleanValue() == false) goto L10;
        r104 = i.f444291a.g(R.string.Todo_New_Section_NoSection_Title);
        goto L11
    L10:
        r104 = i.f444291a.g(R.string.Todo_New_UntitledSection_Title);
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L6;
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.detail_task_list_dialog_create_item, r100, false));
    L6:
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.detail_task_list_section_select_item, r100, false));
    }

    public DetailTaskSectionSelectAdapter(String r100, List r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "selectSectionId");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f443480a = r100;
        this.f443481b = r101;
        this.f443482c = r102;
        this.f443483d = "";
    }
}
