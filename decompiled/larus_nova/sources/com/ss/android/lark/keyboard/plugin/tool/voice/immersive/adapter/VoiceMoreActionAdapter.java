package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.d;
import rob.g;
import rob.l;
import rob.m;
import rob.n;
import rob.o;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/VoiceMoreActionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "<init>", "()V", "dataList", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "moreActionItemClickListener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/IOnMoreActionItemClickListener;", "setItemClickListener", "", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "getItemCount", "onBindViewHolder", "holder", "addItem", MapController.ITEM_LAYER_TAG, "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMoreActionAdapter extends RecyclerView.Adapter<BaseActionItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f430182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f430183b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f430182a).size();
    }

    public VoiceMoreActionAdapter() {
        this.f430182a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((g) ListProtector.get(this.f430182a, r100)).getType().value();
    }

    public final void y2(g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        ((ArrayList) this.f430182a).add(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseActionItemViewHolder r102 = (BaseActionItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        g r103 = (g) ListProtector.get(this.f430182a, r101);
        r102.T3(r102.itemView, r103);
        if (r103.getType() != ItemType.SendTypeAction) goto L6;
        r102.itemView.setOnClickListener(new l(this, r103));
    L6:
        if (r103.getType() != ItemType.AsrLanguage) goto L9;
        r102.itemView.setOnClickListener(new m(this, r103));
    L9:
        if (r103.getType() != ItemType.IconWithTitle) goto L12;
        r102.itemView.setOnClickListener(new n(this, r103));
    L12:
        if (r103.getType() != ItemType.SwitchAction) goto L15;
        r102.itemView.setOnClickListener(new o(this, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_language_option, r100, false);
        if (r101 != ItemType.Header.value()) goto L6;
        Intrinsics.checkNotNull(r102);
        return new HeaderActionItemViewHolder(r102);
    L6:
        if (r101 != ItemType.SendTypeAction.value()) goto L9;
        Intrinsics.checkNotNull(r102);
        return new SendResultActionItemViewHolder(r102);
    L9:
        if (r101 != ItemType.AsrLanguage.value()) goto L12;
        Intrinsics.checkNotNull(r102);
        return new AsrLanguageActionItemViewHolder(r102);
    L12:
        if (r101 != ItemType.IconWithTitle.value()) goto L15;
        Intrinsics.checkNotNull(r102);
        return new IconWithTitleViewHolder(r102);
    L15:
        if (r101 != ItemType.Divider.value()) goto L18;
        Intrinsics.checkNotNull(r102);
        return new ItemDivider(r102);
    L18:
        if (r101 != ItemType.SwitchAction.value()) goto L20;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_voice_more_action_switch, r100, false);
        Intrinsics.checkNotNull(r103);
        return new SwitchActionItemViewHolder(r103);
    L20:
        Intrinsics.checkNotNull(r102);
        return new BaseActionItemViewHolder(r102);
    }
}
