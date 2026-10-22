package com.larksuite.component.blockit.hashtag.list;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.larksuite.component.blockit.hashtag.widget.RecyclerSwipeAdapter;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00152\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter;", "Lcom/larksuite/component/blockit/hashtag/widget/RecyclerSwipeAdapter;", "Lcom/larksuite/component/blockit/hashtag/list/HashTagViewHolder;", "mContext", "Landroid/content/Context;", "itemClickListener", "Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter$ItemClickListener;", "isSwipeEnable", "", "isDistinguishAuthorized", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/blockit/hashtag/list/HashTagSwipeAdapter$ItemClickListener;ZZ)V", "items", "Ljava/util/ArrayList;", "Lcom/larksuite/component/blockit/hashtag/HashTagViewData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItem", "getItemCount", "getSwipeLayoutResourceId", "resetAll", "collection", "", "ItemClickListener", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HashTagSwipeAdapter extends RecyclerSwipeAdapter<HashTagViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f283027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f283028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f283029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f283030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<oy7.e> f283031f;

    public interface a {
        void a(oy7.e r100);

        void b(oy7.e r100);
    }

    @Override // py7.a
    public final int B0() {
        return R.id.swipeLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f283031f.size();
    }

    public final void A2(List<oy7.e> r100) {
        this.f283031f.clear();
        if (r100 == null) goto L5;
        this.f283031f.addAll(r100);
    L5:
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        HashTagViewHolder r112 = (HashTagViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        oy7.e r100 = (oy7.e) ListProtector.get(this.f283031f, r111);
        r112.f283034c.setSwipeEnabled(this.f283029d);
        r112.f283034c.setShowMode(SwipeLayout.ShowMode.LayDown);
        r112.f283035d.setOnClickListener(new h(this, r111, r100));
        if (r100.f527156g == false) goto L5;
        r112.f283035d.setBackgroundColor(this.f283027b.getResources().getColor(R.color.lkui_R500));
    L6:
        this.f283058a.a(r112.itemView, r111);
        int r101 = LarkNameTag.f284333d;
        Context r102 = this.f283027b;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarkNameTag.c r103 = new LarkNameTag.c(r102);
        if (r100.f527161l == false) goto L9;
        String r104 = y9c.d.i(this.f283027b, R.string.Lark_Pano_CreatTopic);
        SpannableStringBuilder r105 = new SpannableStringBuilder(r104 + " #" + r100.f527152c);
        r105.setSpan(new ForegroundColorSpan(this.f283027b.getResources().getColor(R.color.lkui_N500)), 0, r104.length(), 33);
        r112.f283032a.setText(r105);
        r112.f283032a.setTextColor(UIUtils.getColor(this.f283027b, R.color.lkui_N900));
        r112.f283036e.setVisibility(8);
    L31:
        r103.f().c(r112.f283032a);
        r112.f283033b.setOnClickListener(new i(this, r111, r100));
        return;
    L9:
        r112.f283032a.setText("#" + r100.f527152c);
        if (r100.f527159j != TagPermissionType.Public.value()) goto L13;
        int r106 = com.larksuite.component.ui.tag.f.f284457g;
        com.larksuite.component.ui.tag.f.a r107 = new com.larksuite.component.ui.tag.f.a();
        r107.f284465b = 0;
        r107.f284466c = R.string.Lark_Pano_Tag_Public;
        r107.f284468e = R.color.lkui_B600;
        r107.f284470g = R.color.lkui_B100;
        r103.d(new com.larksuite.component.ui.tag.f(r107), true);
    L13:
        if (r100.f527160k.length() <= 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L19;
        r112.f283036e.setVisibility(0);
        r112.f283036e.setText(r100.f527160k);
    L19:
        if (this.f283030e == true) goto L21;
        r112.f283032a.setTextColor(UIUtils.getColor(this.f283027b, R.color.lkui_N900));
    L29:
        if (r100.f527153d == false) goto L31;
        int r109 = com.larksuite.component.ui.tag.b.f284444e;
        com.larksuite.component.ui.tag.b.a r113 = new com.larksuite.component.ui.tag.b.a();
        r113.f284450b = 100;
        r113.f284451c = R.drawable.ic_svg_collect_hash_tag;
        r103.b(new com.larksuite.component.ui.tag.b(r113), true);
        goto L31
    L21:
        if (r100.f527154e == false) goto L24;
        r112.f283032a.setTextColor(UIUtils.getColor(this.f283027b, R.color.lkui_N500));
        int r114 = com.larksuite.component.ui.tag.f.f284457g;
        com.larksuite.component.ui.tag.f.a r115 = new com.larksuite.component.ui.tag.f.a();
        r115.f284465b = 50;
        r115.f284466c = R.string.Lark_Pano_HaveAdded;
        r115.f284468e = R.color.lkui_N600;
        r115.f284470g = R.color.lkui_N200;
        r103.d(new com.larksuite.component.ui.tag.f(r115), true);
        goto L29
    L24:
        if (r100.f527155f == false) goto L26;
        r112.f283032a.setTextColor(UIUtils.getColor(this.f283027b, R.color.lkui_N900));
        goto L29
    L26:
        r112.f283032a.setTextColor(UIUtils.getColor(this.f283027b, R.color.lkui_N500));
        int r116 = com.larksuite.component.ui.tag.f.f284457g;
        com.larksuite.component.ui.tag.f.a r117 = new com.larksuite.component.ui.tag.f.a();
        r117.f284465b = 50;
        r117.f284466c = R.string.Lark_Pano_NoAccess;
        r117.f284468e = R.color.lkui_N600;
        r117.f284470g = R.color.lkui_N200;
        r103.d(new com.larksuite.component.ui.tag.f(r117), true);
        goto L29
    L15:
        r108 = false;
        goto L16
    L5:
        r112.f283035d.setBackgroundColor(this.f283027b.getResources().getColor(R.color.lkui_N400));
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new HashTagViewHolder(LayoutInflater.from(this.f283027b).inflate(R.layout.item_hash_tag_layout, r100, false));
    }

    public HashTagSwipeAdapter(Context r100, a r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "itemClickListener");
        this.f283027b = r100;
        this.f283028c = r101;
        this.f283029d = r102;
        this.f283030e = r103;
        this.f283031f = new ArrayList();
    }
}
