package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import slb.j;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIButtonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIButtonViewHolder;", "controller", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "<init>", "(Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;)V", "prompts", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "getPrompts", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "showAIBtn", "btn", "Landroidx/appcompat/widget/AppCompatTextView;", EventConstant.Key.RETAIN_PROMPT, "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioAIButtonAdapter extends RecyclerView.Adapter<AudioAIButtonViewHolder> {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai.AudioAIButtonAdapter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<List<? extends j>, Unit> {
        final /* synthetic */ AudioAIButtonAdapter this$0;

        public AnonymousClass1(AudioAIButtonAdapter r100) {
            this.this$0 = r100;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<j> r100) {
            StringBuilder r101 = new StringBuilder("AI prompts changed: ");
            if (r100 == null) goto L8;
            List<j> r102 = r100;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L6:
            if (r104.hasNext() == false) goto L9;
            r103.add(((j) r104.next()).f542537d);
        L9:
            r101.append(r103);
            Log.i("AudioAIButtonAdapter", r101.toString());
            this.this$0.notifyDataSetChanged();
            return;
        L8:
            r103 = null;
            goto L9
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends j> r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<j> r100 = y2();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final List<j> y2() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AudioAIButtonViewHolder r102 = (AudioAIButtonViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        AudioAIGradientButton r103 = (AudioAIGradientButton) r102.f429925a.getValue();
        List<j> r104 = y2();
        if (r104 == null) goto L5;
        j r105 = (j) ListProtector.get(r104, r101);
    L6:
        if (r105 == null) goto L10;
        Drawable r106 = UIHelper.getDrawable(r105.f542536c);
        r106.setBounds(0, 0, UIHelper.dp2px(18.0f), UIHelper.dp2px(18.0f));
        r103.setCompoundDrawables(r106, null, null, null);
        r103.setText(r105.f542537d);
        r103.setVisibility(0);
        r103.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai.a(this, r105));
        return;
    L10:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new AudioAIButtonViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_audio_ai_button, r100, false));
    }
}
