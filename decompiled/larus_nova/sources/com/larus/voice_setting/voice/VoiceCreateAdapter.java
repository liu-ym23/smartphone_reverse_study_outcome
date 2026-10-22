package com.larus.voice_setting.voice;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceListCreateBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceCreateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/voice_setting/voice/VoiceCreateAdapter$VoiceCreateViewHolder;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "<init>", "(Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "voiceCreateClick", "Lkotlin/Function0;", "", "getVoiceCreateClick", "()Lkotlin/jvm/functions/Function0;", "setVoiceCreateClick", "(Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "VoiceCreateViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCreateAdapter extends RecyclerView.Adapter<VoiceCreateViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2 f376308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f376309b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceCreateAdapter$VoiceCreateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VoiceCreateViewHolder extends RecyclerView.ViewHolder {
        public VoiceCreateViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    public VoiceCreateAdapter(t2 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f376308a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VoiceCreateViewHolder r102 = (VoiceCreateViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = (TextView) r102.itemView.findViewById(R.id.create_voice_text);
        if (this.f376308a.f377007b == false) goto L5;
        r103.setText(r102.itemView.getContext().getString(R.string.larus_modify_bot_voice_bot_record_my_voice_btn));
        r103.setTextSize(1, 16.0f);
        r103.getPaint().setFakeBoldText(true);
    L7:
        if (this.f376308a.b() == false) goto L9;
        r103.setTypeface(Typeface.DEFAULT_BOLD);
    L9:
        com.larus.utils.e1.d(r102.itemView, new m2(this));
        return;
    L5:
        Resources r104 = r102.itemView.getResources();
        com.larus.voice_setting.voice.utils.f r105 = com.larus.voice_setting.voice.utils.f.f377023a;
        r103.setText(r104.getString(R.string.larus_modify_bot_voice_bot_clone_voice_btn2));
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new VoiceCreateViewHolder(LarusItemVoiceListCreateBinding.a(LayoutInflater.from(r100.getContext()), r100).f376110a);
    }
}
