package com.ss.android.lark.vote.publish;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u000fJ\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,J\u0006\u0010-\u001a\u00020\u0011J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u00064"}, d2 = {"Lcom/ss/android/lark/vote/publish/VoteRecycleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/ss/android/lark/vote/publish/VoteItemData;", "dependency", "Lcom/ss/android/lark/vote/publish/VoteRecycleAdapter$VoteAdapterDependency;", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/vote/publish/VoteRecycleAdapter$VoteAdapterDependency;)V", "getItems", "()Ljava/util/List;", "addViewHolder", "Lcom/ss/android/lark/vote/publish/AddViewHolder;", "isAddOption", "", "sameOptionPosition1", "", "getSameOptionPosition1", "()I", "setSameOptionPosition1", "(I)V", "sameOptionPosition2", "getSameOptionPosition2", "setSameOptionPosition2", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "bindTopicViewHolder", "Lcom/ss/android/lark/vote/publish/TopicViewHolder;", "bindOptionViewHolder", "Lcom/ss/android/lark/vote/publish/OptionViewHolder;", "bindAddViewHolder", "updateAddState", "isTopicValid", "getTopic", "", "isOptionsValid", "getOptions", "", "getMaxSameOptionCount", "getItemViewType", "getItemCount", "addData", "removeData", "Companion", "VoteAdapterDependency", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f445284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f445285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AddViewHolder f445286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f445287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f445288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f445289f;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void showToast(String r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f445284a.size();
    }

    public final boolean z2() {
        int r100 = this.f445284a.size() - 1;
        int r101 = 1;
    L3:
        if (r101 >= r100) goto L14;
        if (StringsKt.trim(((g) ListProtector.get(this.f445284a, r101)).f445297b).toString().length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L9;
        r101 = r101 + 1;
        goto L3
    L9:
        return false;
    L7:
        r102 = false;
        goto L8
    L14:
        return true;
    }

    public static final void y2(VoteRecycleAdapter r100) {
        AddViewHolder r101 = r100.f445286c;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.z2() == false) goto L8;
        AppCompatImageView r102 = r101.f445258b;
        r102.setImageTintList(AppCompatResources.getColorStateList(r102.getContext(), R.color.colorful_blue));
        TextView r103 = r101.f445257a;
        r103.setTextColor(AppCompatResources.getColorStateList(r103.getContext(), R.color.text_title));
        r101.itemView.setEnabled(true);
        return;
    L8:
        AppCompatImageView r104 = r101.f445258b;
        r104.setImageTintList(AppCompatResources.getColorStateList(r104.getContext(), R.color.icon_disable));
        TextView r105 = r101.f445257a;
        r105.setTextColor(AppCompatResources.getColorStateList(r105.getContext(), R.color.text_disable));
        r101.itemView.setEnabled(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((g) ListProtector.get(this.f445284a, r100)).f445296a;
    }

    public VoteRecycleAdapter(List r100, VoteFragment.b r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f445284a = r100;
        this.f445285b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof TopicViewHolder) == false) goto L9;
        TopicViewHolder r102 = (TopicViewHolder) r100;
        m r103 = new m(r102, this);
        Object r104 = r102.f445261a.getTag(R.id.vote_tag_text_watcher);
        if ((r104 instanceof TextWatcher) == false) goto L7;
        r102.f445261a.removeTextChangedListener((TextWatcher) r104);
    L7:
        r102.f445261a.addTextChangedListener(r103);
        r102.f445261a.setTag(R.id.vote_tag_text_watcher, r103);
        return;
    L9:
        if ((r100 instanceof OptionViewHolder) == false) goto L35;
        OptionViewHolder r105 = (OptionViewHolder) r100;
        r105.setIsRecyclable(false);
        ((g) ListProtector.get(this.f445284a, r101)).f445298c = new WeakReference(r105.f445260b);
        if (r101 == (this.f445284a.size() - 2)) goto L13;
    L15:
        l r106 = new l(r105, this, r101);
        Object r107 = r105.f445259a.getTag(R.id.vote_tag_text_watcher);
        if ((r107 instanceof TextWatcher) == false) goto L18;
        r105.f445259a.removeTextChangedListener((TextWatcher) r107);
    L18:
        r105.f445259a.setText(((g) ListProtector.get(this.f445284a, r101)).f445297b);
        if (this.f445284a.size() <= 4) goto L32;
        AppCompatImageView r108 = r105.f445260b;
        r108.setImageTintList(AppCompatResources.getColorStateList(r108.getContext(), R.color.colorful_red));
        r105.f445260b.setEnabled(true);
        int r109 = 1;
    L22:
        if (r109 >= 3) goto L33;
        WeakReference<AppCompatImageView> r110 = ((g) ListProtector.get(this.f445284a, r109)).f445298c;
        if (r110 == null) goto L26;
        AppCompatImageView r111 = r110.get();
    L27:
        if (r111 == null) goto L29;
        r111.setImageTintList(AppCompatResources.getColorStateList(r105.f445260b.getContext(), R.color.colorful_red));
    L29:
        if (r111 == null) goto L31;
        r111.setEnabled(true);
    L31:
        r109 = r109 + 1;
        goto L22
    L26:
        r111 = null;
    L33:
        r105.f445259a.addTextChangedListener(r106);
        r105.f445259a.setTag(R.id.vote_tag_text_watcher, r106);
        r105.f445260b.setOnClickListener(new k(this, r101));
        return;
    L32:
        AppCompatImageView r112 = r105.f445260b;
        r112.setImageTintList(AppCompatResources.getColorStateList(r112.getContext(), R.color.icon_disable));
        r105.f445260b.setEnabled(false);
        goto L33
    L13:
        if (this.f445287d == false) goto L15;
        this.f445287d = false;
        r105.f445259a.requestFocus();
        goto L15
    L35:
        if ((r100 instanceof AddViewHolder) == false) goto L47;
        AddViewHolder r113 = (AddViewHolder) r100;
        this.f445286c = r113;
        if (z2() == false) goto L39;
        AppCompatImageView r114 = r113.f445258b;
        r114.setImageTintList(AppCompatResources.getColorStateList(r114.getContext(), R.color.colorful_blue));
        TextView r115 = r113.f445257a;
        r115.setTextColor(AppCompatResources.getColorStateList(r115.getContext(), R.color.text_title));
        r113.itemView.setEnabled(true);
    L40:
        r113.itemView.setOnClickListener(new j(this, r113));
        return;
    L39:
        AppCompatImageView r116 = r113.f445258b;
        r116.setImageTintList(AppCompatResources.getColorStateList(r116.getContext(), R.color.icon_disable));
        TextView r117 = r113.f445257a;
        r117.setTextColor(AppCompatResources.getColorStateList(r117.getContext(), R.color.text_disable));
        r113.itemView.setEnabled(false);
        goto L40
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != VoteItemType.TOPIC.ordinal()) goto L7;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.lark_vote_item_topic, r100, false);
        Intrinsics.checkNotNull(r102);
        return new TopicViewHolder(r102);
    L7:
        if (r101 != VoteItemType.ADD.ordinal()) goto L10;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.lark_vote_item_add, r100, false);
        Intrinsics.checkNotNull(r103);
        return new AddViewHolder(r103);
    L10:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.lark_vote_item_option, r100, false);
        Intrinsics.checkNotNull(r104);
        return new OptionViewHolder(r104);
    }
}
