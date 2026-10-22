package com.larus.voice_setting.voice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceListCreateBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "voiceList", "", "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "<init>", "(Ljava/util/List;Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "getVoiceList", "()Ljava/util/List;", "setVoiceList", "(Ljava/util/List;)V", "getConfig", "()Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "setConfig", "(Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "itemInteractionListener", "Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;", "getItemInteractionListener", "()Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;", "setItemInteractionListener", "(Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onViewDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<o2> f376310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2 f376311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u2 f376312c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f376310a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((o2) ListProtector.get(this.f376310a, r100)).f376970f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).detach();
        return;
    }

    public VoiceItemAdapter(List<o2> r100, t2 r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceList");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f376310a = r100;
        this.f376311b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.voice_setting.voice.r2] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.voice_setting.voice.q2] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final RecyclerView.ViewHolder r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        final o2 r102 = (o2) CollectionsKt.getOrNull(this.f376310a, r101);
        boolean r103 = true;
        if ((r100 instanceof a) == false) goto L26;
        ((a) r100).d2(r102, this.f376311b);
        com.larus.utils.e1.d(r100.itemView, new p2(this, r102));
        a r104 = (a) r100;
        r104.x1(new q2(this, r102, r101));
        t2 r105 = this.f376311b;
        if (r105.f377006a == true) goto L7;
        r104.l3(false);
        return;
    L7:
        if (r105.b() == true) goto L21;
        o2 r106 = (o2) CollectionsKt.getOrNull(this.f376310a, r101);
        Boolean r107 = null;
        if (r106 == null) goto L14;
        SpeakerVoice r108 = r106.f376965a;
        if (r108 == null) goto L14;
        Boolean r109 = Boolean.valueOf(r108.isUgcVoice());
    L15:
        o2 r110 = (o2) CollectionsKt.getOrNull(this.f376310a, r101 + 1);
        if (r110 == null) goto L20;
        SpeakerVoice r111 = r110.f376965a;
        if (r111 == null) goto L20;
        r107 = Boolean.valueOf(r111.isUgcVoice());
    L20:
        r103 = Intrinsics.areEqual(r109, r107);
    L14:
        r109 = null;
    L21:
        r104.l3(r103);
        if (this.f376311b.a() == false) goto L29;
        r104.W1(new r2(r102, this, r100, r101));
        return;
    L29:
        return;
    L26:
        if ((r100 instanceof VoiceCreateAdapter.VoiceCreateViewHolder) == false) goto L32;
        TextView r112 = (TextView) r100.itemView.findViewById(R.id.create_voice_text);
        r112.setText(r100.itemView.getContext().getString(R.string.larus_modify_bot_voice_bot_record_my_voice_btn));
        r112.setTextSize(1, 16.0f);
        r112.getPaint().setFakeBoldText(true);
        com.larus.utils.e1.d(r100.itemView, new s2(this, r102));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        LayoutInflater r100 = LayoutInflater.from(r110.getContext());
        t2 r101 = this.f376311b;
        if (r101.f377007b == false) goto L8;
        if (r111 != 2) goto L8;
        return new VoiceCreateAdapter.VoiceCreateViewHolder(LarusItemVoiceListCreateBinding.a(r100, r110).f376110a);
    L8:
        if (r101.b() == true) goto L10;
        View r102 = r100.inflate(R.layout.larus_layout_voice_item, r110, false);
        if (ViewBindings.findChildViewById(r102, R.id.divider) != null) goto L82;
        int r103 = R.id.divider;
    L113:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    L82:
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.voice_creator_avatar)) == null) goto L110;
        r103 = R.id.voice_selector_creator;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.voice_selector_creator)) == null) goto L113;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.voice_selector_error_icon)) != null) goto L88;
        r103 = R.id.voice_selector_error_icon;
        goto L113
    L88:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.voice_selector_more)) != null) goto L90;
        r103 = R.id.voice_selector_more;
        goto L113
    L90:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.voice_selector_selected_icon)) != null) goto L92;
        r103 = R.id.voice_selector_selected_icon;
        goto L113
    L92:
        if (((ProgressBar) ViewBindings.findChildViewById(r102, R.id.voice_selector_selecting_icon)) != null) goto L94;
        r103 = R.id.voice_selector_selecting_icon;
        goto L113
    L94:
        if (((LinearLayoutCompat) ViewBindings.findChildViewById(r102, R.id.voice_selector_state)) != null) goto L96;
        r103 = R.id.voice_selector_state;
        goto L113
    L96:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.voice_selector_state_text)) != null) goto L98;
        r103 = R.id.voice_selector_state_text;
        goto L113
    L98:
        if (((ProgressBar) ViewBindings.findChildViewById(r102, R.id.voice_selector_uploading_icon)) == null) goto L103;
        r103 = R.id.voice_selector_voice_name;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.voice_selector_voice_name)) == null) goto L113;
        return new VoiceItemViewHolder((ConstraintLayout) r102);
    L103:
        r103 = R.id.voice_selector_uploading_icon;
        goto L113
    L110:
        r103 = R.id.voice_creator_avatar;
        goto L113
    L10:
        if (r111 != 1) goto L22;
        View r104 = r100.inflate(R.layout.larus_layout_empty_voice_item, r110, false);
        int r105 = R.id.avatar_view;
        if (ViewBindings.findChildViewById(r104, R.id.avatar_view) == null) goto L21;
        r105 = R.id.empty_des;
        if (ViewBindings.findChildViewById(r104, R.id.empty_des) == null) goto L21;
        r105 = R.id.empty_label;
        if (ViewBindings.findChildViewById(r104, R.id.empty_label) == null) goto L21;
        r105 = R.id.empty_title;
        if (ViewBindings.findChildViewById(r104, R.id.empty_title) == null) goto L21;
        return new EmptyVoiceItemViewHolder((LinearLayout) r104);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(r105)));
    L22:
        View r106 = r100.inflate(R.layout.larus_layout_voice_item_public, r110, false);
        int r107 = R.id.best_match_label;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r106, R.id.best_match_label)) == null) goto L78;
        r107 = R.id.create_area;
        if (((LinearLayoutCompat) ViewBindings.findChildViewById(r106, R.id.create_area)) == null) goto L78;
        r107 = R.id.create_date;
        if (((TextView) ViewBindings.findChildViewById(r106, R.id.create_date)) == null) goto L78;
        if (ViewBindings.findChildViewById(r106, R.id.divider) == null) goto L76;
        r107 = R.id.divider_dot;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.divider_dot)) == null) goto L78;
        r107 = R.id.label_container;
        if (((LinearLayoutCompat) ViewBindings.findChildViewById(r106, R.id.label_container)) == null) goto L78;
        r107 = R.id.label_text;
        if (((TextView) ViewBindings.findChildViewById(r106, R.id.label_text)) == null) goto L78;
        r107 = R.id.new_play_lottie;
        if (((LottieAdapterView) ViewBindings.findChildViewById(r106, R.id.new_play_lottie)) == null) goto L78;
        r107 = R.id.permission_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.permission_icon)) == null) goto L78;
        r107 = R.id.permission_text;
        if (((TextView) ViewBindings.findChildViewById(r106, R.id.permission_text)) == null) goto L78;
        r107 = R.id.play_lottie;
        if (((LottieAdapterView) ViewBindings.findChildViewById(r106, R.id.play_lottie)) == null) goto L78;
        r107 = R.id.reviewing_area;
        if (((LinearLayoutCompat) ViewBindings.findChildViewById(r106, R.id.reviewing_area)) == null) goto L78;
        r107 = R.id.voice_add_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.voice_add_icon)) == null) goto L78;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r106, R.id.voice_creator_avatar)) != null) goto L51;
        r107 = R.id.voice_creator_avatar;
        goto L78
    L51:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.voice_selector_error_icon)) != null) goto L53;
        r107 = R.id.voice_selector_error_icon;
        goto L78
    L53:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.voice_selector_more)) != null) goto L55;
        r107 = R.id.voice_selector_more;
        goto L78
    L55:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r106, R.id.voice_selector_selected_icon)) != null) goto L57;
        r107 = R.id.voice_selector_selected_icon;
        goto L78
    L57:
        if (((ProgressBar) ViewBindings.findChildViewById(r106, R.id.voice_selector_selecting_icon)) != null) goto L59;
        r107 = R.id.voice_selector_selecting_icon;
        goto L78
    L59:
        if (((LinearLayoutCompat) ViewBindings.findChildViewById(r106, R.id.voice_selector_state)) != null) goto L61;
        r107 = R.id.voice_selector_state;
        goto L78
    L61:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r106, R.id.voice_selector_state_text)) != null) goto L63;
        r107 = R.id.voice_selector_state_text;
        goto L78
    L63:
        if (((ProgressBar) ViewBindings.findChildViewById(r106, R.id.voice_selector_uploading_icon)) != null) goto L65;
        r107 = R.id.voice_selector_uploading_icon;
        goto L78
    L65:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r106, R.id.voice_selector_voice_name)) != null) goto L116;
        r107 = R.id.voice_selector_voice_name;
        goto L78
    L116:
        return new VoiceItemPublicViewHolder((ConstraintLayout) r106);
    L76:
        r107 = R.id.divider;
    L78:
        throw new NullPointerException("Missing required view with ID: ".concat(r106.getResources().getResourceName(r107)));
    }
}
